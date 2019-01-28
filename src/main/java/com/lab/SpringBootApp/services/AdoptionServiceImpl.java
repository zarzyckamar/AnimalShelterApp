package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Adoption;
import com.lab.SpringBootApp.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;



    @Override
    public Iterable<Adoption> listAllAdoptionsPaging(Integer pageNr, Integer howManyOnPage) {

        return adoptionRepository.findAll(new PageRequest(pageNr,howManyOnPage ));
    }


    public Iterable<Adoption> listAllAdoptions() {
        return adoptionRepository.findAll();
    }


    @Override
    public Optional<Adoption> getById(Integer id) {
        return adoptionRepository.findById(id);
    }

    @Override
    public Adoption saveAdoption(Adoption adoption) {
        return adoptionRepository.save(adoption);
    }

    @Override
    public void deleteAdoption(Integer id) {
        adoptionRepository.deleteById(id);}


    @Override
    public Boolean checkIfExist(Integer id) {
        if (adoptionRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }




}

