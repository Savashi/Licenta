package ro.cristin.graph;

import ro.cristin.dto.ResultDTO;
import ro.cristin.model.EntityDO;
import ro.cristin.model.Result;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;

import java.util.ArrayList;
import java.util.List;

public class GraphBrowser {

    private int threshold;

    private Graph graph;
    private UserDO currentUser;
    private List<EntityEdge> currentEdges;

    public GraphBrowser(Graph graph, UserDO currentUser) {
        this.graph = graph;
        this.currentUser = currentUser;
        this.threshold = calculateThreshold(currentUser);
    }

    public List<ResultDTO> getResults(){
        List<Result> resultList = browseGraph();
        int average = calculateAverage(resultList);
        List<ResultDTO> resultDTOS = new ArrayList<>();
        for (Result result: resultList) {
            if (result.getRating() >= average) {
                ResultDTO resultDTO = currentResultUser(resultDTOS, result.getUserDO());
                if (!resultDTO.getRecommended().contains(result.getEntityDO())) {
                    resultDTO.getRecommended().add(result.getEntityDO());
                }
                if (!resultDTO.getCovered().contains(result.getEntityCovered())) {
                    resultDTO.getCovered().add(result.getEntityCovered());
                }
                if (!resultDTOS.contains(resultDTO)) {
                    resultDTOS.add(resultDTO);
                }
            }
        }
        return resultDTOS;
    }

    private List<Result> browseGraph() {
        List<Result> results = new ArrayList<>();
        final UserNode userNode = graph.getUserMap().get(currentUser);
        currentEdges = userNode.getEntityEdgeList();
        for (EntityEdge entityEdge: userNode.getEntityEdgeList()) {
            if(entityEdge.getRating() >= threshold) {
                recursiveAddResults(userNode, entityEdge.getTo(), results);
            }
        }
        return results;
    }

    private void recursiveAddResults(UserNode userNode, EntityNode entityNode, List<Result> results) {
            for (UserEdge userEdge: userNode.getUserEdgeList()) {
                UserNode friend = userEdge.getTo();
                if (friend.hasEntity(entityNode)){
                    final List<Object[]> entityDatas = friend.getMaxEntity(threshold, currentEdges);
                    for (Object[] entityData: entityDatas) {
                        final EntityDO maxEntityDO = (EntityDO) entityData[0];
                        final int rating = (Integer) entityData[1];
                        if (rating > 0) {
                            final Result result = new Result(maxEntityDO, friend.getVertex(),
                                                                entityNode.getVertex(), rating);
                            results.add(result);
                        }
                    }
                }
                recursiveAddResults(friend, entityNode, results);
            }

    }


    private ResultDTO currentResultUser(List<ResultDTO> results, UserDO userDO){
        for (ResultDTO result: results) {
            if(userDO.getId() == result.getUserDO().getId()){
                return result;
            }
        }
        return new ResultDTO(currentUser.getSurname() + " " + currentUser.getName(), userDO);
    }

    private int calculateAverage(List<Result> resultList){
        double sum = 0;
        int count = 0;
        for (Result result:resultList) {
            sum += result.getRating();
            count += 1;
        }
        return (int) Math.ceil(sum / count);
    }


    private int calculateThreshold(UserDO currentUser){
        final UserNode userNode = graph.getUserMap().get(currentUser);
        currentEdges = userNode.getEntityEdgeList();
        double sum =0;
        int count = 0;
        for (EntityEdge entityEdge: userNode.getEntityEdgeList()) {
            sum += entityEdge.getRating();
            count += 1;
        }
        return (int) Math.ceil(sum/count);
    }









}
