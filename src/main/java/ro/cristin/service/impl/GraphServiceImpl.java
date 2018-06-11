package ro.cristin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cristin.dto.GraphDTO;
import ro.cristin.dto.GraphDTOGenerator;
import ro.cristin.dto.ResultDTO;
import ro.cristin.graph.Graph;
import ro.cristin.graph.GraphBrowser;
import ro.cristin.graph.GraphCreator;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;
import ro.cristin.repository.UserEntityDORepo;
import ro.cristin.service.GraphService;

import java.util.List;

@Service
public class GraphServiceImpl implements GraphService{

    @Autowired
    private UserEntityDORepo userEntityDORepo;

    @Override
    public GraphDTO getGraph() {
        List<UserEntityDO> userEntityDOS = userEntityDORepo.findAll();
        GraphCreator graphCreator = new GraphCreator(userEntityDOS);
        Graph graph = graphCreator.createGraph(null);
        GraphDTOGenerator graphDTOGenerator = new GraphDTOGenerator(graph);
        return graphDTOGenerator.generateGraphDTO();
    }

    @Override
    public List<ResultDTO> getResults(UserDO currentUser, int threshold) {
        List<UserEntityDO> userEntityDOS = userEntityDORepo.findAll();
        GraphCreator graphCreator = new GraphCreator(userEntityDOS);
        Graph graph = graphCreator.createGraph(currentUser);
        GraphBrowser graphBrowser = new GraphBrowser(graph,currentUser, threshold);
        return graphBrowser.getResults();
    }


}
