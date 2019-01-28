package com.lab.SpringBootApp.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "ADOPTION")
public class Adoption {

    @Id
    @GeneratedValue
    @Column(name = "adoption_number")
    private int numberOfAdoption;

    @JsonIgnore
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "adoption_data")
    private String dataOfAdoption;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idanimal", referencedColumnName = "id")
    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    Animal animal;


    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idclient", referencedColumnName = "id")
    Client client;

/*
    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    public Adoption(String dataOfAdoption, Animal animal, Client client) {
        this.dataOfAdoption = dataOfAdoption;
        this.animal = animal;
        this.client = client;
    }
*/

    /*public Adoption(DateTime dataOfAdoption, Animal animal, Client client, int id) {
        this.dataOfAdoption = dataOfAdoption;
        this.animal = animal;
        this.client = client;
        this.numberOfAdoption=id;
    }
*/
    public Adoption() { }
    public int getNumberOfAdoption() {
        return numberOfAdoption;
    }

    public void setNumberOfAdoption(int numberOfAdoption) {
        this.numberOfAdoption = numberOfAdoption;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    public void setDataOfAdoption(String dataOfAdoption) {
        this.dataOfAdoption = dataOfAdoption;
    }
}
