package com.lab.SpringBootApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "VACCINATION")
public class Vaccination {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idvaccination;

    @Column(name = "vaccination_name")
    private String namevaccinaiton;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="animal")
    private Animal animal;

    @Column(name = "data")
    private String data;

    public String getData() {
        return data;
    }


    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    public Vaccination(String namevaccinaiton, Animal animal, String data) {
        this.namevaccinaiton = namevaccinaiton;
        this.animal = animal;
        this.data = data;
    }

    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    public Vaccination() {}

    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    public Vaccination(String namevaccinaiton,Animal animal, String data, int idvaccination)
    {
        this.namevaccinaiton = namevaccinaiton;
        this.animal = animal;
        this.data = data;
        this.idvaccination = idvaccination;
    }

   /* public String getAllInformation()
    {
        return namevaccinaiton + " " + animal + " " + data + " " + idvaccination;}*/

    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNamevaccinaiton() {
        return namevaccinaiton;
    }

    public void setNamevaccinaiton(String namevaccinaiton) {
        this.namevaccinaiton = namevaccinaiton;
    }

    public int getIdvaccination() {
        return idvaccination;
    }

    public void setIdvaccination(int idvaccination) {
        this.idvaccination = idvaccination;
    }
}
