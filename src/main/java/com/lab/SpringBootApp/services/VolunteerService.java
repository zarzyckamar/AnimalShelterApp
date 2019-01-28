package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Volunteer;

import java.util.Optional;


public interface VolunteerService {

    Iterable<Volunteer> listAllVolunteers();

    Optional<Volunteer> getById(Integer id);

    Volunteer saveVolunteer(Volunteer product);

    void deleteVolunteer(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Volunteer> listAllVolunteersPaging(Integer pageNr, Integer howManyOnPage);


}
