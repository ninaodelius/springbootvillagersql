package se.nina.cruddemo.entity;

import javax.persistence.*;

@Entity
@Table(name="villager")
public class Villager {

    //define fields
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="personality")
    private String personality;

    @Column(name="species")
    private String species;

    //define constructors

    public Villager() {

    }

    public Villager(String name, String personality, String species) {
        this.name = name;
        this.personality = personality;
        this.species = species;
    }


    //define getter setter

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

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    //define tostring

    @Override
    public String toString() {
        return "Villager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personality='" + personality + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
