package ro.cristin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.cristin.dto.GraphDTO;
import ro.cristin.service.GraphService;

@Controller
public class GraphController {

    @Autowired
    private GraphService graphService;

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
    public String fff(Model model) {
        return "home";
    }

}
