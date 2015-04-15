package cs544.exercise09_1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
//@NamedQuery(name="Owner.ALL",query="from Owner o LEFT JOIN FETCH o.pets")
public class Owner {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "clientid")
    @org.hibernate.annotations.Fetch(
            org.hibernate.annotations.FetchMode.JOIN)
    private List<Pet> pets;

    public Owner() {
    }

    public Owner(String name) {
        super();
        this.name = name;
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

}
