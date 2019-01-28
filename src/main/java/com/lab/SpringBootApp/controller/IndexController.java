package com.lab.SpringBootApp.controller;

import com.lab.SpringBootApp.model.*;
import com.lab.SpringBootApp.repository.ClientRepository;
import com.lab.SpringBootApp.services.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class IndexController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private VaccinationService vaccinationService;
    @Autowired
    private AdoptionService adoptionService;


    @RequestMapping(value = "/generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {


        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime dateAndTime  = ZonedDateTime.of(localtDateAndTime, zoneId);


        Client c1 = new Client("Malwina", "Grzyb", "Poznan"," Os.Przyjazni");
        Client c2 = new Client("Kamil", "Pyrka", "Czestochowa", "Os.Przyjazni");
        Client c3 = new Client("Ola", "Ladurska", "Szczecin", "Wiejska");

        clientService.saveClient(c1);
        clientService.saveClient(c2);
        clientService.saveClient(c3);

        Animal animal1 = new Animal("Falafel", "dog", false, 5);
        Animal animal2 = new Animal("PrincessCarolyn", "cat", false, 2);
        Animal animal3 = new Animal("Tyran", "dog", true, 7);
        Animal animal4 = new Animal("Mruczek", "cat", false, 3);
        Animal animal5 = new Animal("Abat", "dog", false, 1);

        animalService.saveAnimal(animal1);
        animalService.saveAnimal(animal2);
        animalService.saveAnimal(animal3);
        animalService.saveAnimal(animal4);
        animalService.saveAnimal(animal5);

        Volunteer vol1 = new Volunteer("Marlena", "Zarzycka", 18);
        Volunteer vol2 = new Volunteer("Marian", "Nowak", 21);

        volunteerService.saveVolunteer(vol1);
        volunteerService.saveVolunteer(vol2);

/*
        Vaccination vac1 = new Vaccination("parainflueza", animal1, "2018-07-21");
        Vaccination vac2 = new Vaccination("bordetella", animal3, "2018-07-21");

        vaccinationService.saveVaccination(vac1);
        vaccinationService.saveVaccination(vac2);
*/

      //  Adoption adoption1 =new Adoption("2017-02-11", animal3, c2);
      Adoption adoption1=new Adoption();
      adoption1.setDataOfAdoption("21-08-2017");
      adoption1.setClient(c1);
      adoption1.setAnimal(animal1);
        adoptionService.saveAdoption(adoption1);

        return "Model Generated";
    }


}
