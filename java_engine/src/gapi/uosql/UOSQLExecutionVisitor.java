package gapi.uosql;

import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;

public class UOSQLExecutionVisitor extends UOSQLBaseVisitor<Object> {
    private final GAPIGraphStore store;

    public UOSQLExecutionVisitor(GAPIGraphStore store) {
        this.store = store;
    }

    private String cleanString(String raw) {
        if (raw == null) return "";
        if ((raw.startsWith("\"") && raw.endsWith("\"")) || (raw.startsWith("'") && raw.endsWith("'"))) {
            return raw.substring(1, raw.length() - 1);
        }
        return raw;
    }

    private Object parseValue(UOSQLParser.ValueContext ctx) {
        if (ctx.STRING() != null) {
            return cleanString(ctx.STRING().getText());
        } else if (ctx.NUMBER() != null) {
            String num = ctx.NUMBER().getText();
            return num.contains(".") ? Double.parseDouble(num) : Long.parseLong(num);
        } else if (ctx.BOOLEAN() != null) {
            return Boolean.parseBoolean(ctx.BOOLEAN().getText().toLowerCase());
        }
        return ctx.getText();
    }

    private Map<String, Object> parseAttrs(UOSQLParser.EdgeAttrsContext ctx) {
        Map<String, Object> attrs = new HashMap<>();
        if (ctx == null) return attrs;
        for (UOSQLParser.AttrPairContext p : ctx.attrPair()) {
            String k = p.IDENT().getText();
            Object v = parseValue(p.value());
            attrs.put(k, v);
        }
        return attrs;
    }

    private Map<String, Object> parseEntityAttrs(UOSQLParser.EntityAttrsContext ctx) {
        Map<String, Object> attrs = new HashMap<>();
        if (ctx == null) return attrs;
        for (UOSQLParser.AttrPairContext p : ctx.attrPair()) {
            String k = p.IDENT().getText();
            Object v = parseValue(p.value());
            attrs.put(k, v);
        }
        return attrs;
    }

    @Override
    public Object visitEntityStmt(UOSQLParser.EntityStmtContext ctx) {
        UOSQLParser.EntityDeclContext decl = ctx.entityDecl();
        String kind = decl.KIND().getText();
        String id = cleanString(decl.STRING().getText());
        Map<String, Object> props = decl.entityAttrs() != null ? parseEntityAttrs(decl.entityAttrs()) : new HashMap<>();
        EntityNode node = store.addOrUpdateEntity(kind, id, props);
        System.out.println("Declared Entity: " + node);
        return node;
    }

    @Override
    public Object visitConnectStmt(UOSQLParser.ConnectStmtContext ctx) {
        String startKind = ctx.entityRef().KIND().getText();
        String startId = cleanString(ctx.entityRef().STRING().getText());
        Map<String, Object> startProps = ctx.edgeAttrs() != null ? parseAttrs(ctx.edgeAttrs()) : new HashMap<>();

        EntityNode curr = store.addOrUpdateEntity(startKind, startId, startProps);
        int connectedEdges = 0;

        for (UOSQLParser.ChainLinkContext link : ctx.chainLink()) {
            String op = link.edgeOp().getText();
            String targetKind = link.entityRef().KIND().getText();
            String targetId = cleanString(link.entityRef().STRING().getText());

            Map<String, Object> linkProps = new HashMap<>();
            for (UOSQLParser.EdgeAttrsContext eac : link.edgeAttrs()) {
                linkProps.putAll(parseAttrs(eac));
            }

            EntityNode target = store.addOrUpdateEntity(targetKind, targetId, linkProps);
            store.addEdge(curr.getKey(), target.getKey(), op, linkProps);
            connectedEdges++;
            curr = target;
        }

        System.out.println("Executed CONNECT: Wired " + connectedEdges + " graph edges starting from " + startKind + "(\"" + startId + "\").");
        return connectedEdges;
    }

    @Override
    public Object visitTraverseStmt(UOSQLParser.TraverseStmtContext ctx) {
        String startKind = ctx.entityRef().KIND().getText();
        String startId = cleanString(ctx.entityRef().STRING().getText());
        String startKey = startKind + ":" + startId;

        List<String> targetKinds = new ArrayList<>();
        for (UOSQLParser.TraverseLinkContext link : ctx.traverseLink()) {
            targetKinds.add(link.entitySelector().KIND().getText());
        }

        List<List<EntityNode>> paths = store.traverse(startKey, targetKinds);
        System.out.println("Executed TRAVERSE from " + startKey + " -> Found " + paths.size() + " path(s):");
        for (List<EntityNode> path : paths) {
            StringBuilder sb = new StringBuilder("  ");
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i).toString());
                if (i < path.size() - 1) sb.append(" -> ");
            }
            System.out.println(sb.toString());
        }
        return paths;
    }

    @Override
    public Object visitFindStmt(UOSQLParser.FindStmtContext ctx) {
        String kind = ctx.KIND() != null ? ctx.KIND().getText() : "*";
        List<EntityNode> results = store.findEntities(kind);
        System.out.println("Executed FIND " + kind + " -> " + results.size() + " entities found:");
        for (EntityNode n : results) {
            System.out.println("  " + n);
        }
        return results;
    }
}

