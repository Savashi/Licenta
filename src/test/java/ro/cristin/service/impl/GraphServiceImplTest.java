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
import ro.cristin.model.UserEntityDO;
import ro.cristin.repository.EntityDORepo;
import ro.cristin.repository.UserDORepo;
import ro.cristin.repository.UserEntityDORepo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GraphServiceImplTest {

    @Autowired
    private UserEntityDORepo userEntityDORepo;

    @Test
    public void getGraph() {
        List<UserEntityDO> userEntityDOS = new ArrayList<>();
        GraphCreator graphCreator = new GraphCreator(userEntityDOS);
        Graph graph = graphCreator.createGraph(null);
        GraphDTOGenerator graphDTOGenerator = new GraphDTOGenerator(graph);
        assertNotNull(graphDTOGenerator);
    }
}