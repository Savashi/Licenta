package ro.cristin.model;

import javax.persistence.Entity;


public class Result {

    private EntityDO entityDO;
    private UserDO userDO;
    private String entitiesWatched;

    public Result(EntityDO entityDO, UserDO userDO) {
        this.entityDO = entityDO;
        this.userDO = userDO;
    }

    public Result(){

    }

    public EntityDO getEntityDO() {
        return entityDO;
    }

    public void setEntityDO(EntityDO entityDO) {
        this.entityDO = entityDO;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public String getEntitiesWatched() {
        return entitiesWatched;
    }

    public void setEntitiesWatched(String entitiesWatched) {
        this.entitiesWatched = entitiesWatched;
    }

    @Override
    public String toString() {
        return "Result{" +
                "entityDO=" + entityDO +
                ", userDO=" + userDO +
                '}';
    }
}
