package ro.cristin.model;

import javax.persistence.Entity;
import java.util.List;


public class Result {

    private EntityDO entityDO;
    private UserDO userDO;
    private EntityDO entityCovered;
    private int rating;

    public Result(EntityDO entityDO, UserDO userDO, EntityDO entityCovered, int rating) {
        this.entityDO = entityDO;
        this.userDO = userDO;
        this.entityCovered = entityCovered;
        this.rating = rating;
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

    public EntityDO getEntityCovered() {
        return entityCovered;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setEntityCovered(EntityDO entityCovered) {
        this.entityCovered = entityCovered;
    }

    @Override
    public String toString() {
        return "Result{" +
                "entityDO=" + entityDO +
                ", userDO=" + userDO +
                '}';
    }
}
