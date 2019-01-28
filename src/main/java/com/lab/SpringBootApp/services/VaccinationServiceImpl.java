package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Vaccination;
import com.lab.SpringBootApp.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VaccinationServiceImpl implements VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;



    @Override
    public Iterable<Vaccination> listAllVaccinationsPaging(Integer pageNr, Integer howManyOnPage) {

        return vaccinationRepository.findAll(new PageRequest(pageNr,howManyOnPage ));
    }


    public List<Vaccination> listAllVaccinations() {
        return (List<Vaccination>) vaccinationRepository.findAll();

    }


    @Override
    public Optional<Vaccination> getById(Integer id) {
        return vaccinationRepository.findById(id);
    }

    @Override
    public Vaccination saveVaccination(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }

    @Override
    public void deleteVaccination(Integer id) {
        vaccinationRepository.deleteById(id);}


    @Override
    public Boolean checkIfExist(Integer id) {
        if (vaccinationRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }




}

