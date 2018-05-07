package ro.cristin.service;

import ro.cristin.model.UserDO;

import java.util.List;

public interface UserDOService {

    List<UserDO> getAllUsers();
    void addUser(UserDO user);
    void deleteUser(UserDO user);
}
