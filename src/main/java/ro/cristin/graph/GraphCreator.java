package ro.cristin.graph;

import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;

import java.util.*;

public class GraphCreator {
    private List<UserEntityDO> userEntities;

    private Map<Integer, UserNode> userMap = new LinkedHashMap<>();
    private Map<Integer, EntityNode> entityMap = new HashMap<>();

    public GraphCreator(List<UserEntityDO> userEntities) {
        this.userEntities = userEntities;
    }

    public Graph createGraph(UserDO currentUser) {
        createUserEntityNodes(currentUser);
        for (int id : userMap.keySet()) {
            UserNode userNode = userMap.get(id);
            createEdges(userNode);
        }
        return extractGraph();
    }

    private Graph extractGraph() {
        Map<UserDO, UserNode> userMapGraph = new HashMap<>();
        for (int id: userMap.keySet()){
            UserNode userNode = userMap.get(id);
            UserDO userDO = userNode.getVertex();
            userMapGraph.put(userDO,userNode);
        }
        return new Graph(userMapGraph);
    }

    private void createUserEntityNodes(UserDO currentUser) {
        Map<Integer, UserNode> temp = new LinkedHashMap<>();
        for (UserEntityDO userEntity : userEntities) {
            UserDO user = userEntity.getUserDO();
            UserNode u = new UserNode();
            u.setVertex(user);
            if (currentUser !=null && user.getId() == currentUser.getId()) {
                temp.put(user.getId(), u);
            }
            userMap.put(user.getId(), u);
            EntityDO entityDO = userEntity.getEntityDO();
            EntityNode e = new EntityNode();
            e.setVertex(entityDO);
            entityMap.put(entityDO.getId(), e);
        }
        if (currentUser != null) {
            for (int id: userMap.keySet()) {
                if (id != currentUser.getId()) {
                    temp.put(id, userMap.get(id));
                }
            }
            userMap = temp;
        }
    }

    private void createEdges(UserNode userNode) {
        UserDO vertex = userNode.getVertex();
        if (!userNode.isVisited()) {
            userNode.setVisited(true);
            List<UserEntityDO> userEntityDOS = getFilteredList(vertex.getId());
            for (UserEntityDO userEntityDO : userEntityDOS){
                EntityDO entityDO = userEntityDO.getEntityDO();
                EntityEdge entityEdge = new EntityEdge();
                entityEdge.setFrom(userNode);
                entityEdge.setTo(entityMap.get(entityDO.getId()));
                entityEdge.setRating(userEntityDO.getRating());
                userNode.addEntityEdge(entityEdge);
            }
        }
        for (UserDO userDO : vertex.getUserList()) {
            final UserNode userNode1 = userMap.get(userDO.getId());
            if (!userNode1.isVisited()) {
                UserEdge userEdge = new UserEdge();
                userEdge.setFrom(userNode);
                userEdge.setTo(userNode1);
                userNode.addUserEdge(userEdge);
                createEdges(userNode1);
            }
        }
    }

    private List<UserEntityDO> getFilteredList(int iduser){
        List<UserEntityDO> userEntityDOList = new ArrayList<>();
        for (UserEntityDO userEntityDO : userEntities){
            UserDO userDO = userEntityDO.getUserDO();
            if (userDO.getId() == iduser)
                userEntityDOList.add(userEntityDO);
        }
        return userEntityDOList;
    }

}
