package ro.cristin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cristin.model.EntityDO;

public interface EntityDORepo extends JpaRepository<EntityDO, Integer> {

}