package gapi.uosql;

import java.util.*;

public class GAPIGraphStore {
    private final Map<String, EntityNode> nodes = new LinkedHashMap<>();
    private final Map<String, List<Edge>> adjacency = new LinkedHashMap<>();

    public static class Edge {
        private final String targetKey;
        private final String direction;
        private final Map<String, Object> properties;

        public Edge(String targetKey, String direction, Map<String, Object> properties) {
            this.targetKey = targetKey;
            this.direction = direction;
            this.properties = properties != null ? properties : new HashMap<>();
        }

        public String getTargetKey() {
            return targetKey;
        }

        public String getDirection() {
            return direction;
        }

        public Map<String, Object> getProperties() {
            return properties;
        }
    }

    public synchronized EntityNode addOrUpdateEntity(String kind, String id, Map<String, Object> properties) {
        String key = kind + ":" + id;
        EntityNode node = nodes.get(key);
        if (node == null) {
            node = new EntityNode(kind, id, properties);
            nodes.put(key, node);
            adjacency.putIfAbsent(key, new ArrayList<>());
        } else if (properties != null && !properties.isEmpty()) {
            node.getProperties().putAll(properties);
        }
        return node;
    }

    public EntityNode getEntity(String kind, String id) {
        return nodes.get(kind + ":" + id);
    }

    public synchronized void addEdge(String srcKey, String tgtKey, String direction, Map<String, Object> properties) {
        adjacency.putIfAbsent(srcKey, new ArrayList<>());
        adjacency.putIfAbsent(tgtKey, new ArrayList<>());

        if (direction.equals("->") || direction.equals("--") || direction.equals("<->")) {
            adjacency.get(srcKey).add(new Edge(tgtKey, direction, properties));
        }
        if (direction.equals("<-") || direction.equals("<->")) {
            adjacency.get(tgtKey).add(new Edge(srcKey, direction, properties));
        }
    }

    public List<EntityNode> findEntities(String kind) {
        List<EntityNode> list = new ArrayList<>();
        for (EntityNode n : nodes.values()) {
            if (kind == null || kind.equals("*") || n.getKind().equalsIgnoreCase(kind)) {
                list.add(n);
            }
        }
        return list;
    }

    public List<List<EntityNode>> traverse(String startKey, List<String> targetKinds) {
        List<List<EntityNode>> activePaths = new ArrayList<>();
        EntityNode start = nodes.get(startKey);
        if (start == null) return activePaths;

        List<EntityNode> initial = new ArrayList<>();
        initial.add(start);
        activePaths.add(initial);

        for (String expectedKind : targetKinds) {
            List<List<EntityNode>> nextPaths = new ArrayList<>();
            for (List<EntityNode> path : activePaths) {
                EntityNode current = path.get(path.size() - 1);
                List<Edge> edges = adjacency.getOrDefault(current.getKey(), Collections.emptyList());
                for (Edge edge : edges) {
                    EntityNode target = nodes.get(edge.getTargetKey());
                    if (target != null && (expectedKind.equals("*") || target.getKind().equalsIgnoreCase(expectedKind))) {
                        List<EntityNode> newPath = new ArrayList<>(path);
                        newPath.add(target);
                        nextPaths.add(newPath);
                    }
                }
            }
            activePaths = nextPaths;
            if (activePaths.isEmpty()) break;
        }

        return activePaths;
    }

    public Map<String, EntityNode> getNodes() {
        return Collections.unmodifiableMap(nodes);
    }
}

