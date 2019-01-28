
package com.lab.SpringBootApp.controller;


import com.lab.SpringBootApp.model.Volunteer;
import com.lab.SpringBootApp.repository.VolunteerRepository;
import com.lab.SpringBootApp.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;



@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "http://localhost:4200")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @GetMapping(path = "/addvol")
    public @ResponseBody
    String addNewVolunteer(@RequestParam String firstname, @RequestParam String lastname, @RequestParam Integer age)
    {
        Volunteer vol1 = new Volunteer();
        vol1.setFirstName(firstname);
        vol1.setLastName(lastname);
        vol1.setAge(age);

        return  "Saved";


    }



    @RequestMapping(path="/allvolunteers")
    public @ResponseBody Iterable<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }


    @RequestMapping(value = "/volunteers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Volunteer> list(Model model) {
        return volunteerService.listAllVolunteers();
    }

    @ApiIgnore
    @RequestMapping(value = "/volunteers", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Volunteer> redirect(Model model) {
        return volunteerService.listAllVolunteers();
    }

    @RequestMapping(value = "/volunteer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Volunteer> getByPublicId(@PathVariable("id") Integer publicId) {
        return volunteerService.getById(publicId);
    }




}
