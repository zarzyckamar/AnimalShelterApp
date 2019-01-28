package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Volunteer;
import com.lab.SpringBootApp.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;



    @Override
    public Iterable<Volunteer> listAllVolunteersPaging(Integer pageNr, Integer howManyOnPage) {

        return volunteerRepository.findAll(new PageRequest(pageNr,howManyOnPage ));
    }


    public Iterable<Volunteer> listAllVolunteers() {
        return volunteerRepository.findAll();
    }


    @Override
    public Optional<Volunteer> getById(Integer id) {
        return volunteerRepository.findById(id);
    }

    @Override
    public Volunteer saveVolunteer(Volunteer product) {
        return volunteerRepository.save(product);
    }

    @Override
    public void deleteVolunteer(Integer id) {
        volunteerRepository.deleteById(id);}


    @Override
    public Boolean checkIfExist(Integer id) {
        if (volunteerRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }




}

