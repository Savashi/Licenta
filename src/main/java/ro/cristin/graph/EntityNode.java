package ro.cristin.graph;

import ro.cristin.model.EntityDO;

public class EntityNode {
    private EntityDO vertex;

    private boolean isVisited;

    public EntityDO getVertex() {
        return vertex;
    }

    public void setVertex(EntityDO vertex) {
        this.vertex = vertex;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
