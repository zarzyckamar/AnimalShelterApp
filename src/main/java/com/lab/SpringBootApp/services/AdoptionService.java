package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Adoption;

import java.util.Optional;


public interface AdoptionService {

    Iterable<Adoption> listAllAdoptions();

    Optional<Adoption> getById(Integer id);

    Adoption saveAdoption(Adoption adoption);

    void deleteAdoption(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Adoption> listAllAdoptionsPaging(Integer pageNr, Integer howManyOnPage);


}
