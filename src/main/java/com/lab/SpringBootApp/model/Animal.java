package com.lab.SpringBootApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ANIMAL")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true)
    private int id;

    @Column(name = "name")
    private String nameAnimals;

    @Column(name = "type")
    private String type;

    @Column(name="age")
    private int age;

    @Column(name="is_adopted")
    private boolean is_adopted;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="volunteer")
    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    private Volunteer volunteer;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy="animal")
    private List<Vaccination> vaccinations;



    public Animal(String nameAnimals, String type, boolean is_adopted, int age) {
        this.nameAnimals = nameAnimals;
        this.type = type;
        this.is_adopted = is_adopted;
        this.age = age;
    }


    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    public Animal (String nameAnimals, String type, boolean is_adopted, int age,int id) {
        this.id=id;
        this.nameAnimals = nameAnimals;
        this.type = type;
        this.is_adopted = is_adopted;
        this.age = age;
    }
public Animal() { }

    @JsonIgnore
    public String getAllInf()
    {
        return id + " " + nameAnimals + " " + type + " " + is_adopted + " " + volunteer.getAllInf();
    }
    @JsonIgnore
    public String getAllInf2()
    {
        return id + " " + nameAnimals + " " + type + " " + is_adopted;
    }
    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public boolean is_adopted() {
        return is_adopted;
    }

    public void setIs_adopted(boolean is_adopted) {
        this.is_adopted = is_adopted;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String race) {
        this.type = race;
    }

    public String getNameAnimals() {
        return nameAnimals;
    }

    public void setNameAnimals(String nameAnimals) {
        this.nameAnimals = nameAnimals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

