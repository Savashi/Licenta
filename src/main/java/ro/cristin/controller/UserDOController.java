package ro.cristin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.cristin.model.UserDO;
import ro.cristin.service.UserDOService;

import java.util.List;

@Controller
public class UserDOController {

    @Autowired
    UserDOService userDOService;

    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public String createUser(Model model) {
        return "createuser";
    }

    @RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
    @ResponseBody
    public String addUSer(Model model, @RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password) {
        UserDO userDO = new UserDO(email, name, surname);
        userDOService.addUser(userDO);
        List<UserDO> userDOS = userDOService.getAllUsers();
        model.addAttribute("userDOS",userDOS);
        return "showusers";
    }

    @RequestMapping(value = "/showusers", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        List<UserDO> userDOS = userDOService.getAllUsers();
        model.addAttribute("userDOS",userDOS);
        return "showusers";
    }


    @RequestMapping(value = "/adduser", method=RequestMethod.POST)
    public String addNewParticipantToCursa(Model model, @RequestParam("name") String name,
                                           @RequestParam("surname") String surname,
                                           @RequestParam("email") String email,
                                           @RequestParam("password") String password) {
        UserDO usertata = new UserDO(email, name, surname);
        UserDO usercopil = new UserDO(email, name, surname);
        userDOService.addUser(usercopil);   //adauga participant nou
        usertata.addUser(usercopil);
        usertata.addUser(usertata);  //aici face save, ca sa observe hibernate ca am adaugat
        List<UserDO> userDOList = userDOService.getAllUsers();
        model.addAttribute("userDOList",userDOList);
        return "showusers";
    }
}
