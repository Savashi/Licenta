package ro.cristin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;

import java.util.List;

public interface UserEntityDORepo extends JpaRepository<UserEntityDO, Integer> {

    List<UserEntityDO> findAllByUserDO(UserDO userDO);
}
