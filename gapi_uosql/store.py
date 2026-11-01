"""
In-memory and NetworkX-backed Graph Database for GAPI.
"""
from typing import Dict, Any, List, Optional
import networkx as nx
from .models import EntityNode, GraphEdge

class GAPIGraphStore:
    def __init__(self):
        self.graph = nx.MultiDiGraph()

    def add_entity(self, kind: str, entity_id: str, properties: Optional[Dict[str, Any]] = None) -> EntityNode:
        properties = properties or {}
        node = EntityNode(kind=kind, id=entity_id, properties=properties)
        self.graph.add_node(
            node.key,
            kind=kind,
            id=entity_id,
            properties=properties
        )
        return node

    def get_entity(self, kind: str, entity_id: str) -> Optional[EntityNode]:
        key = f"{kind}:{entity_id}"
        if key in self.graph:
            data = self.graph.nodes[key]
            return EntityNode(kind=data["kind"], id=data["id"], properties=data.get("properties", {}))
        return None

    def add_edge(self, source_key: str, target_key: str, direction: str = "->", properties: Optional[Dict[str, Any]] = None):
        properties = properties or {}
        if direction in ("->", "--", "<->"):
            self.graph.add_edge(source_key, target_key, **properties)
        if direction in ("<-", "<->"):
            self.graph.add_edge(target_key, source_key, **properties)

    def find_entities(self, kind: Optional[str] = None, filter_fn=None) -> List[EntityNode]:
        results = []
        for key, data in self.graph.nodes(data=True):
            if kind and kind != "*" and data.get("kind") != kind:
                continue
            entity = EntityNode(kind=data["kind"], id=data["id"], properties=data.get("properties", {}))
            if filter_fn is None or filter_fn(entity):
                results.append(entity)
        return results

    def traverse(self, start_key: str, steps: List[Dict[str, Any]]) -> List[List[EntityNode]]:
        """
        Traverse chain of steps.
        Each step: {'op': '->', 'kind': 'Project', 'filter': dict/fn}
        Returns list of valid paths (as entity lists).
        """
        if start_key not in self.graph:
            return []

        start_data = self.graph.nodes[start_key]
        initial_path = [EntityNode(kind=start_data["kind"], id=start_data["id"], properties=start_data.get("properties", {}))]
        active_paths = [initial_path]

        for step in steps:
            target_kind = step.get("kind")
            step_filter = step.get("filter")
            target_id = step.get("id")
            next_paths = []

            for path in active_paths:
                current_node_key = path[-1].key
                # Follow outgoing neighbors in graph
                for neighbor_key in self.graph.successors(current_node_key):
                    ndata = self.graph.nodes[neighbor_key]
                    if target_kind and target_kind != "*" and ndata.get("kind") != target_kind:
                        continue
                    if target_id and target_id != "*" and ndata.get("id") != target_id:
                        continue
                    candidate = EntityNode(kind=ndata["kind"], id=ndata["id"], properties=ndata.get("properties", {}))
                    if step_filter and not step_filter(candidate):
                        continue
                    next_paths.append(path + [candidate])
            active_paths = next_paths
            if not active_paths:
                break

        return active_paths

    def to_dict(self) -> Dict[str, Any]:
        nodes = []
        for n, data in self.graph.nodes(data=True):
            nodes.append({"key": n, "kind": data["kind"], "id": data["id"], "properties": data.get("properties", {})})
        edges = []
        for u, v, k, data in self.graph.edges(keys=True, data=True):
            edges.append({"from": u, "to": v, "properties": data})
        return {"nodes": nodes, "edges": edges}

