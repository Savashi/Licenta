package ro.cristin.model;

import javax.persistence.*;

@Entity
@Table(name = "user_entity")
public class UserEntityDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUserEntity")
    private int id;

    @ManyToOne
    @JoinColumn(name="idUser")
    private UserDO userDO;

    @ManyToOne
    @JoinColumn(name="idEntity")
    private EntityDO entityDO;

    @Column(name = "rating")
    private int rating;

    public UserEntityDO() {

    }
    public UserEntityDO(UserDO userDO, EntityDO entityDO, int rating) {
        this.userDO = userDO;
        this.entityDO = entityDO;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public EntityDO getEntityDO() {
        return entityDO;
    }

    public void setEntityDO(EntityDO entityDO) {
        this.entityDO = entityDO;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
