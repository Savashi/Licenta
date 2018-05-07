package ro.cristin.service;

import ro.cristin.model.EntityDO;

import java.util.List;

public interface EntityDOService {

    List<EntityDO> getAllEntities();
    void addEntityDO(EntityDO entityDO);
    void deleteEntityDO(EntityDO entityDO);
}
