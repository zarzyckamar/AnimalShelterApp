package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Animal;
import com.lab.SpringBootApp.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;



    @Override
    public Iterable<Animal> listAllAnimalsPaging(Integer pageNr, Integer howManyOnPage) {

        return animalRepository.findAll(new PageRequest(pageNr,howManyOnPage ));
    }


    public Iterable<Animal> listAllAnimals() {
        return animalRepository.findAll();
    }


    @Override
    public Optional<Animal> getById(Integer id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Integer id) {
        animalRepository.deleteById(id);}


    @Override
    public Boolean checkIfExist(Integer id) {
        if (animalRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }




}

