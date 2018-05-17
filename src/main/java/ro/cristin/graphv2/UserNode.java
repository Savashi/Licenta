package ro.cristin.graphv2;

import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

import java.util.List;

public class UserNode {

    private UserDO vertex;

    private List<UserEdge> userEdgeList;
    private List<EntityEdge> entityEdgeList;

    public UserDO getVertex() {
        return vertex;
    }

    public void setVertex(UserDO vertex) {
        this.vertex = vertex;
    }

    public List<UserEdge> getUserEdgeList() {
        return userEdgeList;
    }

    public void setUserEdgeList(List<UserEdge> userEdgeList) {
        this.userEdgeList = userEdgeList;
    }

    public List<EntityEdge> getEntityEdgeList() {
        return entityEdgeList;
    }

    public void setEntityEdgeList(List<EntityEdge> entityEdgeList) {
        this.entityEdgeList = entityEdgeList;
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
            if (entityEdge.getTo().getVertex().getRating() > max) {
                max = entityEdge.getTo().getVertex().getRating();
                maxEntity = entityEdge.getTo().getVertex();
            }
        }
        return maxEntity;

    }
}
