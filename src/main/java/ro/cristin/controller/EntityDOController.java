package ro.cristin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserEntityDO;
import ro.cristin.service.EntityDOService;
import ro.cristin.service.UserDOService;
import ro.cristin.service.UserEntityDOService;

import java.util.List;

@Controller
public class EntityDOController {

    @Autowired
    EntityDOService entityDOService;

    @Autowired
    UserEntityDOService userEntityDOService;

    @RequestMapping(value = "/createentity", method = RequestMethod.GET)
    public String createEntity(Model model) {
        return "createentity";
    }

    @RequestMapping(value = "/createnewentity", method = RequestMethod.POST)
    public String addEntity(Model model, @RequestParam("class") String domain,
                          @RequestParam("name") String name,
                          @RequestParam("type") String type) {
        EntityDO entityDO = new EntityDO(domain, name, type);
        entityDOService.addEntityDO(entityDO);
        List<EntityDO> entityDOS = entityDOService.getAllEntities();
        model.addAttribute("entityDOS",entityDOS);
        return "showentities";
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
        return "updatentity";
    }

    @RequestMapping(value = "/modifyentity", method = RequestMethod.POST)
    public String updateUser(Model model, @RequestParam("id") int id,
                                          @RequestParam("class") String domain,
                                          @RequestParam("name") String name,
                                          @RequestParam("type") String type) {
        EntityDO entityDO = new EntityDO(domain, name, type);
        entityDO.setId(id);
        entityDOService.addEntityDO(entityDO);
        List<EntityDO> entityDOS = entityDOService.getAllEntities();
        model.addAttribute("entityDOS",entityDOS);
        return "showentities";
    }

    @ResponseBody
    @RequestMapping(value = "/removentity", method = RequestMethod.POST)
    public String removeEntity(Model model, @RequestParam("id") int id) {
        EntityDO entityDO = entityDOService.findById(id);
        userEntityDOService.deleteAllByEntityDO(entityDO);
        entityDOService.deleteEntityDO(entityDO);
        return "success";
    }
}
