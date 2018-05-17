package ro.cristin.graphv2;

import ro.cristin.graph.generic.Node;
import ro.cristin.model.UserDO;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<UserDO, UserNode> userMap;
    private Map<UserDO, EntityNode> entityMap;

    public Graph() {
        userMap = new HashMap<>();
        entityMap = new HashMap<>();
    }

    public Map<UserDO, UserNode> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<UserDO, UserNode> userMap) {
        this.userMap = userMap;
    }

    public Map<UserDO, EntityNode> getEntityMap() {
        return entityMap;
    }

    public void setEntityMap(Map<UserDO, EntityNode> entityMap) {
        this.entityMap = entityMap;
    }
}
