package ro.cristin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cristin.model.UserDO;

public interface UserDORepo extends JpaRepository<UserDO, Integer> {

}