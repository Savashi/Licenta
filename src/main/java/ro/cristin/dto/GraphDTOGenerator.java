package ro.cristin.dto;

import ro.cristin.graph.*;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphDTOGenerator {
    private Graph graph;

    public GraphDTOGenerator(Graph graph){
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public GraphDTO generateGraphDTO(){
        Map<UserDO, UserNode> userMap = graph.getUserMap();
        List<NodeDTO> nodeDTOList = new ArrayList<>();
        List<EdgeDTO> edgeDTOList = new ArrayList<>();
        for(UserDO userDO: userMap.keySet()){
            UserNode userNode = userMap.get(userDO);
            nodeDTOList.add(new UserNodeDTO(userNode.getVertex()));
            for(EntityEdge entityEdge : userNode.getEntityEdgeList()){
                EntityNode entityNode = entityEdge.getTo();
                if(!entityNode.isVisited()){
                    nodeDTOList.add(new EntityNodeDTO(entityNode.getVertex()));
                    entityNode.setVisited(true);
                }
                edgeDTOList.add(new EntityEdgeDTO(userDO,entityNode.getVertex(),entityEdge.getRating()));
            }
            for(UserEdge userEdge: userNode.getUserEdgeList()){
                UserDO to = userEdge.getTo().getVertex();
                edgeDTOList.add(new UserEdgeDTO(userDO,to));
            }
        }
         GraphDTO graphDTO = new GraphDTO(nodeDTOList,edgeDTOList);
        return graphDTO;
    }
}
