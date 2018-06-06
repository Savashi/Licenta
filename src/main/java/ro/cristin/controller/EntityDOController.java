package ro.cristin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ro.cristin.model.EntityDO;
import ro.cristin.service.EntityDOService;

import java.util.List;

@Controller
public class EntityDOController {

    @Autowired
    EntityDOService entityDOService;

    @RequestMapping(value = "/createentity", method = RequestMethod.GET)
    public String createEntity(Model model) {
        return "createentity";
    }

    @RequestMapping(value = "/showentities", method = RequestMethod.GET)
    public String getAllEntities(Model model) {
        List<EntityDO> entityDOS = entityDOService.getAllEntities();
        model.addAttribute("entityDOS",entityDOS);
        return "showentities";
    }

    @RequestMapping(value = "/updatentity", method = RequestMethod.GET)
    public String updateUser(Model model, @RequestParam("id") int id) {
        EntityDO entityDO = entityDOService.findById(id);
        model.addAttribute("entityDO",entityDO);
        List<EntityDO> entityDOS = entityDOService.getAllEntities();
        model.addAttribute("entityDOS",entityDOS);
        return "updatentity";
    }
}
