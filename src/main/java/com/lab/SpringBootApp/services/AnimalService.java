package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Animal;

import java.util.Optional;


public interface AnimalService {

    Iterable<Animal> listAllAnimals();

    Optional<Animal> getById(Integer id);

    Animal saveAnimal(Animal product);

    void deleteAnimal(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Animal> listAllAnimalsPaging(Integer pageNr, Integer howManyOnPage);


}
