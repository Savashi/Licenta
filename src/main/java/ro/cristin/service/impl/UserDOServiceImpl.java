package ro.cristin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.cristin.model.UserDO;
import ro.cristin.repository.UserDORepo;
import ro.cristin.service.UserDOService;

import java.util.List;

@Service
public class UserDOServiceImpl implements UserDOService {
    @Autowired
    UserDORepo userRepo;

    @Override
    public List<UserDO> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDO addUser(UserDO user) {
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(UserDO user) {
        userRepo.delete(user);
    }

    @Override
    public UserDO findById(int id) {
        return userRepo.findOne(id);
    }

    @Override
    @Transactional
    public void deleteFromFriends(int userId) {
        userRepo.deleteFromFriends(userId);

    }

    @Override
    @Transactional
    public void deleteFromUser(int userId) {
        userRepo.deleteFromUser(userId);

    }

    @Override
    @Transactional
    public void deleteFromUserFriends(int userId) {
        userRepo.deleteFromUserFriends(userId);
    }


}
