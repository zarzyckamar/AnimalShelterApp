package com.lab.SpringBootApp.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Client.class)

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String city;

    @Column
    private String street;


    public int getId() {
        return id;
    }

    public Client(String firstName, String lastName, String city, String street) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   /* public String getAllInformation()
    {
        return id + " " + firstName + " " + lastName + " " + city + " " + street;
    }

    public String getPoznanPeople() { return id + " " + firstName + " " + lastName;}*/

    public Client() {}


}
