package ro.cristin.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.cristin.Application;
import ro.cristin.dto.GraphDTOGenerator;
import ro.cristin.graph.Graph;
import ro.cristin.graph.GraphCreator;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;
import ro.cristin.repository.EntityDORepo;
import ro.cristin.repository.UserDORepo;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GraphServiceImplTest {
    @Autowired
    private UserDORepo userDORepo;

    @Autowired
    private EntityDORepo entityDORepo;

    @Test
    public void getGraph() {
        List<UserDO> userDOs = userDORepo.findAll();
        List<EntityDO> entityDOs = entityDORepo.findAll();
        GraphCreator graphCreator = new GraphCreator(userDOs,entityDOs);
        Graph graph = graphCreator.createGraph();
        GraphDTOGenerator graphDTOGenerator = new GraphDTOGenerator(graph);
        assertNotNull(graphDTOGenerator);
    }
}