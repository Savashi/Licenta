package ro.cristin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cristin.model.EntityDO;
import ro.cristin.repository.EntityDORepo;
import ro.cristin.service.EntityDOService;

import java.util.List;

@Service
public class EntityDOServiceImpl implements EntityDOService {

    @Autowired
    EntityDORepo entityDORepo;

    @Override
    public List<EntityDO> getAllEntities() {
        return entityDORepo.findAll();
    }

    @Override
    public void addEntityDO(EntityDO entityDO) {
        entityDORepo.save(entityDO);
    }

    @Override
    public void deleteEntityDO(EntityDO entityDO) {
        entityDORepo.delete(entityDO);
    }

    @Override
    public EntityDO findById(int id) {
        return entityDORepo.findOne(id);
    }
}
