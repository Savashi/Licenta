package ro.cristin.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "user")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Passw")
    private String password;

    @JoinTable(name="user_entity",
            joinColumns = { @JoinColumn(name = "idUser") },
            inverseJoinColumns = { @JoinColumn(name = "idEntity") })
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<EntityDO> entityList;

    @JoinTable(name="user_user",
            joinColumns = { @JoinColumn(name = "idUser") },
            inverseJoinColumns = { @JoinColumn(name = "idFriend") })
    @ManyToMany(cascade = {
        CascadeType.PERSIST,
                CascadeType.MERGE
    })

    private List<UserDO> userList;


    public UserDO(){

    }


    public UserDO(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void addUser(UserDO user){
        if(userList == null){
            userList = new ArrayList<>();
        }
        userList.add(user);
    }

    public void addEntity(EntityDO entity){
        if(entityList == null){
            entityList = new ArrayList<>();
        }
        entityList.add(entity);
    }


}
