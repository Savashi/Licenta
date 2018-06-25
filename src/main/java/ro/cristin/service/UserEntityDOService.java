package ro.cristin.service;

import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;

import java.util.List;

public interface UserEntityDOService {
    List<UserEntityDO> findAllByUserDO(UserDO userDO);
    void addUserEntity(UserEntityDO userEntityDO);
    void deleteUserEntity(UserEntityDO userEntityDO);
    void deleteAllByEntityDO(EntityDO entityDO);
    void deleteAllByUserDO(UserDO userDO);
    void addUserEntities(List<UserEntityDO> userEntityDOS);

}
