package ro.cristin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade=ALL)
    @JoinColumn(name="idEntity", nullable = false)
    private List<AttributeDO> listAttribute;


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

    public void addAttribute(AttributeDO attribute){
        if(listAttribute == null){
            listAttribute = new ArrayList<>();
        }
        listAttribute.add(attribute);
    }



    @Override
    public String toString() {
        return "EntityDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", clasa='" + entityclass + '\'' +
                '}';
    }
}
