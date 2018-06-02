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

    public EntityDO getMaxEntity(){
        int max = 0;
        EntityDO maxEntity = new EntityDO();
        for (EntityEdge entityEdge:entityEdgeList) {
            if (entityEdge.getRating() > max) {
                max = entityEdge.getRating();
                maxEntity = entityEdge.getTo().getVertex();
            }
        }
        return maxEntity;
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
}
