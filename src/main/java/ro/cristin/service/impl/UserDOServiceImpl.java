package ro.cristin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public void addUser(UserDO user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(UserDO user) {
        userRepo.delete(user);

    }
}
