package ro.cristin.model;

import javax.persistence.*;

@Entity
@Table(name = "attribute")
public class AttributeDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAttribute")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Value")
    private String value;


    public AttributeDO(){

    }



    public AttributeDO(String name, String value) {
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return "AttributeDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
