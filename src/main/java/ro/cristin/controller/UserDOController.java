package ro.cristin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;
import ro.cristin.repository.UserEntityDORepo;
import ro.cristin.service.EntityDOService;
import ro.cristin.service.UserDOService;
import ro.cristin.service.UserEntityDOService;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserDOController {

    @Autowired
    UserDOService userDOService;

    @Autowired
    EntityDOService entityDOService;

    @Autowired
    UserEntityDOService userEntityDOService;


    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public String createUser(Model model) {
        List<UserDO> userDOS = userDOService.getAllUsers();
        model.addAttribute("userDOS",userDOS);
        List<EntityDO> entityDOS = entityDOService.getAllEntities();
        model.addAttribute("entityDOS",entityDOS);
        return "createuser";
    }


    @RequestMapping(value = "/updateuser", method = RequestMethod.GET)
    public String updateUser(Model model, @RequestParam("id") int id) {
        UserDO userDO = userDOService.findById(id);
        model.addAttribute("userDO",userDO);
        List<UserDO> userDOS = userDOService.getAllUsers();
        model.addAttribute("userDOS",userDOS);
        List<EntityDO> entityDOS = entityDOService.getAllEntities();
        model.addAttribute("entityDOS",entityDOS);
        List<UserEntityDO> userEntityDOS = userEntityDOService.findAllByUserDO(userDO);
        model.addAttribute("userEntityDOS",userEntityDOS);
        return "updateuser";
    }

    @RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
    public String addUSer(Model model, @RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("email") String email,
                             @RequestParam("friends") List<String> friends,
                             @RequestParam("entityratings") List<String> entityratings) {
        UserDO userDO = new UserDO(email, name, surname);//plus id cu setter
        userDO = userDOService.addUser(userDO);//sterge linia asta
        Set<UserDO> friendList = extractUsers(friends);
        userDO.setUserList(friendList);
        //pe linia asta golesc lista de prieteni din baza de date 109,110
        userDO = userDOService.addUser(userDO);
        //pe linia asta sterg user entities pt userul curent 108
        List<UserEntityDO> userEntityDOS = extractRatings(entityratings,userDO);
        userEntityDOService.addUserEntities(userEntityDOS);
        List<UserDO> userDOS = userDOService.getAllUsers();
        model.addAttribute("userDOS",userDOS);
        return "showusers";
    }

    @RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
    public String modifyUser(Model model, @RequestParam("name") String name,
                          @RequestParam("id") int id,
                          @RequestParam("surname") String surname,
                          @RequestParam("email") String email,
                          @RequestParam("friends") List<String> friends,
                          @RequestParam("entityratings") List<String> entityratings) {
        UserDO userDO = new UserDO(email, name, surname);//plus id cu setter
        userDO.setId(id);
        Set<UserDO> friendList = extractUsers(friends);
        userDO.setUserList(friendList);
        //pe linia asta golesc lista de prieteni din baza de date 109,110
        userDOService.deleteFromFriends(id);
        userDOService.deleteFromUserFriends(id);
        userDO = userDOService.addUser(userDO);
        //pe linia asta sterg user entities pt userul curent 108
        userEntityDOService.deleteAllByUserDO(userDO);
        List<UserEntityDO> userEntityDOS = extractRatings(entityratings,userDO);
        userEntityDOService.addUserEntities(userEntityDOS);
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
                                           @RequestParam("email") String email) {
        UserDO usertata = new UserDO(email, name, surname);
        UserDO usercopil = new UserDO(email, name, surname);
        userDOService.addUser(usercopil);   //adauga participant nou
        usertata.addUser(usercopil);
        usertata.addUser(usertata);  //aici face save, ca sa observe hibernate ca am adaugat
        List<UserDO> userDOList = userDOService.getAllUsers();
        model.addAttribute("userDOList",userDOList);
        return "showusers";
    }

    @ResponseBody
    @RequestMapping(value = "/removeuser", method = RequestMethod.POST)
    public String removeEntity(Model model, @RequestParam("id") int id) {
        UserDO userDO = userDOService.findById(id);
        userEntityDOService.deleteAllByUserDO(userDO);
        userDOService.deleteFromFriends(id);
        userDOService.deleteFromUserFriends(id);
        userDOService.deleteFromUser(id);
        return "success";
    }

    private Set<UserDO> extractUsers(List<String> friends){
        Set<UserDO> userDOList = new HashSet<>();
        for (String friend:friends) {
            String[] data = friend.split("--");
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            String surname = data[2];
            String email = data[3];
            UserDO userDO = new UserDO(email,name,surname);
            userDO.setId(id);
            userDOList.add(userDO);
        }
        return userDOList;
    }

    private List<UserEntityDO> extractRatings(List<String> ratings, UserDO user){
        List<UserEntityDO> userEntityDOList = new ArrayList<>();
        for(String rating:ratings){
            String[] data = rating.split("--");
            int id = Integer.parseInt(data[0]);
            String classname = data[1];
            String title = data[2];
            String type = data[3];
            int ratingul = Integer.parseInt(data[4]);
            EntityDO entityDO = new EntityDO(classname,title,type);
            entityDO.setId(id);
            UserEntityDO userEntityDO = new UserEntityDO(user,entityDO,ratingul);
            userEntityDOList.add(userEntityDO);
        }
        return  userEntityDOList;
    }
}
