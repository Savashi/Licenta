package ro.cristin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;
import ro.cristin.repository.UserEntityDORepo;
import ro.cristin.service.UserEntityDOService;

import java.util.List;


@Service
public class UserEntityDOServiceImpl implements UserEntityDOService{
    @Autowired
    UserEntityDORepo userEntityDORepo;

    @Override
    public List<UserEntityDO> findAllByUserDO(UserDO userDO) {
        return userEntityDORepo.findAllByUserDO(userDO);
    }

    @Override
    public void addUserEntity(UserEntityDO userEntityDO) {
        userEntityDORepo.save(userEntityDO);
    }

    @Override
    public void deleteUserEntity(UserEntityDO userEntityDO) {
        userEntityDORepo.delete(userEntityDO);
    }
}
