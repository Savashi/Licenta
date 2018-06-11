package ro.cristin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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



    @JoinTable(name="user_user",
            joinColumns = { @JoinColumn(name = "idUser") },
            inverseJoinColumns = { @JoinColumn(name = "idFriend") })
    @ManyToMany(fetch = FetchType.EAGER,cascade = {
        CascadeType.PERSIST
    })
    @JsonIgnore
    private Set<UserDO> userList;


    public UserDO(){

    }


    public UserDO(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
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





    public Set<UserDO> getUserList() {
        return userList;
    }

    public void setUserList(Set<UserDO> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDO userDO = (UserDO) o;
        return id == userDO.id &&
                Objects.equals(email, userDO.email) &&
                Objects.equals(name, userDO.name) &&
                Objects.equals(surname, userDO.surname) &&
                Objects.equals(userList, userDO.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, surname);
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void addUser(UserDO user){
        if(userList == null){
            userList = new HashSet<>();
        }
        userList.add(user);
    }


}
