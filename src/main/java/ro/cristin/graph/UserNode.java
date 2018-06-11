package ro.cristin.graph;

import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

import java.util.ArrayList;
import java.util.List;

public class UserNode {

    private UserDO vertex;

    private List<UserEdge> userEdgeList;
    private List<EntityEdge> entityEdgeList;

    private boolean isVisited;

    public UserDO getVertex() {
        return vertex;
    }

    public void setVertex(UserDO vertex) {
        this.vertex = vertex;
    }

    public List<UserEdge> getUserEdgeList() {
        if(userEdgeList == null){
            userEdgeList = new ArrayList<>();
        }
        return userEdgeList;
    }

    public void setUserEdgeList(List<UserEdge> userEdgeList) {
        this.userEdgeList = userEdgeList;
    }

    public List<EntityEdge> getEntityEdgeList() {
        if(entityEdgeList == null){
            entityEdgeList = new ArrayList<>();
        }
        return entityEdgeList;
    }

    public void setEntityEdgeList(List<EntityEdge> entityEdgeList) {
        this.entityEdgeList = entityEdgeList;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean hasEntity(EntityNode entityNode){
        for (EntityEdge entityEdge:entityEdgeList) {
            if (entityEdge.getTo().equals(entityNode)) {
                return true;
            }
        }
        return false;
    }

    public List<Object[]> getMaxEntity(int threshold, List<EntityEdge> currentEdges){
        int max = 0;
        List<Object[]> results = new ArrayList<>();
        EntityDO maxEntity = new EntityDO();
        for (EntityEdge entityEdge:entityEdgeList) {
            if (entityEdge.getRating() >= threshold && !isContained(currentEdges,entityEdge)) {
                max = entityEdge.getRating();
                maxEntity = entityEdge.getTo().getVertex();
                Object[] result = {maxEntity, max};
                results.add(result);
            }
        }
        return results;
    }

    public void addEntityEdge(EntityEdge entityEdge){
        if(entityEdgeList == null){
            entityEdgeList = new ArrayList<>();
        }
        entityEdgeList.add(entityEdge);
    }

    public void addUserEdge(UserEdge userEdge){
        if(userEdgeList == null){
            userEdgeList = new ArrayList<>();
        }
        userEdgeList.add(userEdge);
    }

    private boolean isContained(List<EntityEdge> entities, EntityEdge entity) {
        for (EntityEdge entityEdge: entities) {
            if (entityEdge.getTo().equals(entity.getTo())) {
                return true;
            }
        }
        return false;
    }
}
