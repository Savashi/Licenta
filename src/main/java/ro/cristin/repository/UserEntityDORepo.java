package ro.cristin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cristin.model.UserEntityDO;

public interface UserEntityDORepo extends JpaRepository<UserEntityDO, Integer> {

}
