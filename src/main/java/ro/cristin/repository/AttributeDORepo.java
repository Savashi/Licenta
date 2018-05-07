package ro.cristin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cristin.model.AttributeDO;

public interface AttributeDORepo extends JpaRepository<AttributeDO, Integer> {

}