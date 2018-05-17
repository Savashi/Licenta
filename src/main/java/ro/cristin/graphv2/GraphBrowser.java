package ro.cristin.graphv2;

import org.hibernate.EntityMode;
import ro.cristin.model.EntityDO;
import ro.cristin.model.Result;
import ro.cristin.model.UserDO;

import java.util.ArrayList;
import java.util.List;

public class GraphBrowser {
    private Graph graph;
    private UserDO userDO;

    public void browseGraph() {
        List<Result> results = new ArrayList<>();
        final UserNode userNode = graph.getUserMap().get(userDO);
        for (EntityEdge entityEdge: userNode.getEntityEdgeList()) {
            recursiveAddResults(userNode, entityEdge.getTo(), results);

        }
    }

    private void recursiveAddResults(UserNode userNode, EntityNode entityNode, List<Result> results) {
            for (UserEdge userEdge: userNode.getUserEdgeList()) {
                UserNode friend = userEdge.getTo();
                if (friend.hasEntity(entityNode)){
                    final EntityDO maxEntityDO = friend.getMaxEntity();
                    final Result result = new Result(maxEntityDO, friend.getVertex());
                    results.add(result);
                }
                recursiveAddResults(friend, entityNode, results);
            }

    }






}
