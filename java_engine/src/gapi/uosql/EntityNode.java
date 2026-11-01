package gapi.uosql;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EntityNode {
    private final String kind;
    private final String id;
    private final Map<String, Object> properties;

    public EntityNode(String kind, String id) {
        this(kind, id, new HashMap<>());
    }

    public EntityNode(String kind, String id, Map<String, Object> properties) {
        this.kind = kind;
        this.id = id;
        this.properties = properties != null ? new HashMap<>(properties) : new HashMap<>();
    }

    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public String getKey() {
        return kind + ":" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityNode that = (EntityNode) o;
        return Objects.equals(getKey(), that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }

    @Override
    public String toString() {
        return "[" + kind + "] " + id + (properties.isEmpty() ? "" : " " + properties);
    }
}

