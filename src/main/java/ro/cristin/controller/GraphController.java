package ro.cristin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.cristin.dto.GraphDTO;
import ro.cristin.dto.ResultDTO;
import ro.cristin.graph.Graph;
import ro.cristin.graph.GraphBrowser;
import ro.cristin.model.UserDO;
import ro.cristin.service.GraphService;
import ro.cristin.service.UserDOService;

import java.util.List;

@Controller
public class GraphController {

    @Autowired
    private GraphService graphService;

    @Autowired
    private UserDOService userDOService;

    @Value("${ro.cristin.threshold}")
    private int threshold;

    @RequestMapping(value = "/getGraph", method = RequestMethod.GET)
    @ResponseBody
    public GraphDTO generateGraph() {
        return graphService.getGraph();
    }

    @RequestMapping(value = "/graph", method = RequestMethod.GET)
    public String showGraph(Model model) {
        return "graph";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value = "/getresultlist", method = RequestMethod.POST)
    @ResponseBody
    public List<ResultDTO> generateResults(@RequestParam("id") int id) {
        UserDO userDO = userDOService.findById(id);
        return graphService.getResults(userDO, threshold);
    }


}
