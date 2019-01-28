
package com.lab.SpringBootApp.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lab.SpringBootApp.model.Adoption;
import com.lab.SpringBootApp.model.Animal;
import com.lab.SpringBootApp.model.Client;
import com.lab.SpringBootApp.repository.AdoptionRepository;
import com.lab.SpringBootApp.services.AdoptionService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;



@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @Autowired
    private AdoptionRepository adoptionRepository;


    @GetMapping(path = "/addadoption")
    public @ResponseBody
    String addNewAdoption(@RequestParam String date, @RequestParam Animal animal, @RequestParam Client client)
    {
        Adoption adoption1 = new Adoption();
        adoption1.setAnimal(animal);
        adoption1.setDataOfAdoption(date);
        adoption1.setClient(client);

        adoptionRepository.save(adoption1);
        return  "Saved";


    }



    @RequestMapping(path="/alladoptions")
    public @ResponseBody Iterable<Adoption> getAllAdoptions() {
        return adoptionRepository.findAll();
    }


    @RequestMapping(value = "/adoptions1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Adoption> list(Model model) {
        return adoptionService.listAllAdoptions();
    }

    @ApiIgnore
    @RequestMapping(value = "/adoptions", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Adoption> redirect(Model model) {
        return adoptionService.listAllAdoptions();
    }

    @RequestMapping(value = "/adoption/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Adoption> getByPublicId(@PathVariable("id") Integer publicId) {
        return adoptionService.getById(publicId);
    }




}
