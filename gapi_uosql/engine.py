"""
AST Transformer and Execution Engine for UOSQL.
Parses and executes UOSQL statements against the GAPIGraphStore.
"""
from pathlib import Path
from typing import Any, Dict, List, Optional
from lark import Lark, Transformer, v_args
from .store import GAPIGraphStore
from .models import EntityNode

GRAMMAR_PATH = Path(__file__).parent / "grammar.lark"

class UOSQLASTBuilder(Transformer):
    def str_val(self, items):
        # strip quotes
        val = str(items[0])
        return val[1:-1]

    def num_val(self, items):
        val = str(items[0])
        return float(val) if "." in val else int(val)

    def bool_val(self, items):
        return str(items[0]).lower() == "true"

    def attr_pair(self, items):
        key = str(items[0])
        val = items[1]
        return (key, val)

    def edge_attrs(self, items):
        return dict(items)

    def entity_attrs(self, items):
        return dict(items)

    def entity_ref(self, items):
        raw_id = str(items[1])
        entity_id = raw_id.strip('"').strip("'")
        return {"kind": str(items[0]), "id": entity_id}

    def entity_decl(self, items):
        kind = str(items[0])
        raw_id = str(items[1])
        entity_id = raw_id.strip('"').strip("'")
        attrs = items[2] if len(items) > 2 else {}
        return {"type": "entity_decl", "kind": kind, "id": entity_id, "attrs": attrs}

    def entity_stmt(self, items):
        return items[0]

    def entity_selector(self, items):
        kind = str(items[0])
        entity_id = items[1] if len(items) > 1 else "*"
        return {"kind": kind, "id": entity_id}

    def dir_forward(self, _):
        return "->"

    def dir_backward(self, _):
        return "<-"

    def dir_bi(self, _):
        return "<->"

    def dir_undirected(self, _):
        return "--"

    def chain_link(self, items):
        # items can contain None for omitted optional rules
        op = items[0]
        edge_attrs = {}
        ref = None
        for it in items[1:]:
            if it is None:
                continue
            if isinstance(it, dict) and "kind" in it:
                ref = it
            elif isinstance(it, dict):
                edge_attrs.update(it)
        return {"op": op, "target": ref, "attrs": edge_attrs}

    def connect_stmt(self, items):
        start_entity = items[0]
        start_attrs = {}
        links = []
        for it in items[1:]:
            if it is None:
                continue
            if isinstance(it, dict) and "target" in it:
                links.append(it)
            elif isinstance(it, dict) and "kind" not in it:
                start_attrs.update(it)
        return {"type": "connect", "start": start_entity, "start_attrs": start_attrs, "chain": links}

    def traverse_link(self, items):
        op = items[0]
        selector = items[1]
        attrs = items[2] if len(items) > 2 and items[2] is not None else {}
        return {"op": op, "selector": selector, "attrs": attrs}

    def condition_factor(self, items):
        if len(items) == 1:
            return items[0]
        key = str(items[0])
        op = str(items[1])
        return ("cond", key, op, items[2])

    def condition_term(self, items):
        if len(items) == 1:
            return items[0]
        return ("AND", items)

    def condition_expr(self, items):
        if len(items) == 1:
            return items[0]
        return ("OR", items)

    def return_list(self, items):
        return [str(x) for x in items]

    def traverse_stmt(self, items):
        start = items[0]
        links = []
        where_cond = None
        returns = None

        idx = 1
        while idx < len(items) and isinstance(items[idx], dict) and "selector" in items[idx]:
            links.append(items[idx])
            idx += 1

        while idx < len(items):
            item = items[idx]
            if isinstance(item, tuple) and item and item[0] in ("cond", "AND", "OR"):
                where_cond = item
            elif isinstance(item, list):
                returns = item
            idx += 1

        return {
            "type": "traverse",
            "start": start,
            "steps": links,
            "where": where_cond,
            "returns": returns
        }

    def find_stmt(self, items):
        kind = str(items[0])
        where_cond = items[1] if len(items) > 1 else None
        return {"type": "find", "kind": kind, "where": where_cond}

    def statement(self, items):
        return items[0]

    def start(self, items):
        return items


def eval_condition(entity: EntityNode, condition: tuple) -> bool:
    if not condition:
        return True
    tag = condition[0]
    if tag == "cond":
        _, key, op, target_val = condition
        val = entity.properties.get(key)
        if op in ("=", "=="):
            return val == target_val
        elif op == "!=":
            return val != target_val
        elif op == ">":
            return val is not None and val > target_val
        elif op == ">=":
            return val is not None and val >= target_val
        elif op == "<":
            return val is not None and val < target_val
        elif op == "<=":
            return val is not None and val <= target_val
        elif op == "CONTAINS":
            return val is not None and target_val in str(val)
        return False
    elif tag == "AND":
        return all(eval_condition(entity, sub) for sub in condition[1])
    elif tag == "OR":
        return any(eval_condition(entity, sub) for sub in condition[1])
    return True


class UOSQLEngine:
    def __init__(self, store: Optional[GAPIGraphStore] = None):
        self.store = store or GAPIGraphStore()
        with open(GRAMMAR_PATH, "r", encoding="utf-8") as f:
            grammar_str = f.read()
        self.parser = Lark(grammar_str, parser="lalr", transformer=UOSQLASTBuilder())

    def execute(self, query_str: str) -> List[Any]:
        parsed = self.parser.parse(query_str)
        if not isinstance(parsed, list):
            parsed = [parsed]

        results = []
        for stmt in parsed:
            if not stmt:
                continue
            res = self._execute_statement(stmt)
            results.append(res)
        return results

    def _execute_statement(self, stmt: Dict[str, Any]) -> Any:
        stype = stmt.get("type")

        if stype == "entity_decl":
            node = self.store.add_entity(stmt["kind"], stmt["id"], stmt.get("attrs", {}))
            return {"action": "created_entity", "node": node.model_dump()}

        elif stype == "connect":
            start_ref = stmt["start"]
            start_attrs = stmt.get("start_attrs", {})
            curr_node = self.store.get_entity(start_ref["kind"], start_ref["id"])
            if not curr_node:
                curr_node = self.store.add_entity(start_ref["kind"], start_ref["id"], properties=start_attrs)
            elif start_attrs:
                curr_node.properties.update(start_attrs)
                self.store.graph.nodes[curr_node.key]["properties"].update(start_attrs)

            curr_key = curr_node.key
            created_edges = []
            for link in stmt["chain"]:
                target_ref = link["target"]
                edge_attrs = link.get("attrs", {})
                t_node = self.store.get_entity(target_ref["kind"], target_ref["id"])
                if not t_node:
                    t_node = self.store.add_entity(target_ref["kind"], target_ref["id"], properties=edge_attrs)
                elif edge_attrs:
                    t_node.properties.update(edge_attrs)
                    self.store.graph.nodes[t_node.key]["properties"].update(edge_attrs)
                t_key = t_node.key
                self.store.add_edge(curr_key, t_key, direction=link["op"], properties=edge_attrs)
                created_edges.append((curr_key, link["op"], t_key))
                curr_key = t_key

            return {"action": "connected", "edges": created_edges}

        elif stype == "find":
            kind = stmt["kind"]
            cond = stmt.get("where")
            filter_fn = (lambda n: eval_condition(n, cond)) if cond else None
            entities = self.store.find_entities(kind=kind, filter_fn=filter_fn)
            return {"action": "find", "results": [e.model_dump() for e in entities]}

        elif stype == "traverse":
            start_ref = stmt["start"]
            start_key = f"{start_ref['kind']}:{start_ref['id']}"
            step_specs = []
            for s in stmt["steps"]:
                sel = s["selector"]
                attrs = s.get("attrs", {})
                filter_fn = (lambda n, a=attrs: all(n.properties.get(k) == v for k, v in a.items())) if attrs else None
                step_specs.append({
                    "op": s["op"],
                    "kind": sel["kind"],
                    "id": sel.get("id"),
                    "filter": filter_fn
                })
            paths = self.store.traverse(start_key, step_specs)

            where_cond = stmt.get("where")
            if where_cond:
                paths = [p for p in paths if eval_condition(p[-1], where_cond)]

            formatted_paths = []
            for p in paths:
                formatted_paths.append([n.model_dump() for n in p])
            return {"action": "traverse", "paths": formatted_paths}

        return {"status": "unsupported", "stmt": stmt}
