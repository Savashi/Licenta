package ro.cristin.graph;

import ro.cristin.model.UserDO;

import java.util.Map;

public class Graph {
    private Map<UserDO, UserNode> userMap;
    //private Map<UserDO, EntityNode> entityMap;

    public Graph(Map<UserDO, UserNode> userMap) {
        this.userMap = userMap;
    }

    public Map<UserDO, UserNode> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<UserDO, UserNode> userMap) {
        this.userMap = userMap;
    }

    /*public Map<UserDO, EntityNode> getEntityMap() {
        return entityMap;
    }

    public void setEntityMap(Map<UserDO, EntityNode> entityMap) {
        this.entityMap = entityMap;
    }*/
}
