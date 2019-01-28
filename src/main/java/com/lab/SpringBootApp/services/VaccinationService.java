package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Vaccination;

import java.util.List;
import java.util.Optional;


public interface VaccinationService {

    List<Vaccination> listAllVaccinations();

    Optional<Vaccination> getById(Integer id);

    Vaccination saveVaccination(Vaccination product);

    void deleteVaccination(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Vaccination> listAllVaccinationsPaging(Integer pageNr, Integer howManyOnPage);


}
