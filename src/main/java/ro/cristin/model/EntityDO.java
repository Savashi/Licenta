package ro.cristin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name = "entity")
public class EntityDO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntity")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String type;

    @Column(name = "Class")
    private String entityclass;



    public EntityDO(){

    }

    public EntityDO(String name, String type, String clasa) {
        this.name = name;
        this.type = type;
        this.entityclass = clasa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEntityclass() {
        return entityclass;
    }

    public void setEntityclass(String entityclass) {
        this.entityclass = entityclass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityDO entityDO = (EntityDO) o;
        return id == entityDO.id &&
                Objects.equals(name, entityDO.name) &&
                Objects.equals(type, entityDO.type) &&
                Objects.equals(entityclass, entityDO.entityclass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, type, entityclass);
    }

    @Override
    public String toString() {
        return "EntityDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", entityclass='" + entityclass + '\'' +
                '}';
    }
}
