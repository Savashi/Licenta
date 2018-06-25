package ro.cristin.service;

import ro.cristin.model.UserDO;

import java.util.List;

public interface UserDOService {

    List<UserDO> getAllUsers();
    UserDO addUser(UserDO user);
    void deleteUser(UserDO user);
    UserDO findById(int id);
    void deleteFromFriends(int userId);
    void deleteFromUser(int userId);
    void deleteFromUserFriends(int userId);
}
