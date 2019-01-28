
package com.lab.SpringBootApp.controller;


import com.lab.SpringBootApp.model.Animal;
import com.lab.SpringBootApp.model.Vaccination;
import com.lab.SpringBootApp.repository.VaccinationRepository;
import com.lab.SpringBootApp.services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @GetMapping(path = "/addvaccination")
    public @ResponseBody
    String addNewVaccination(@RequestParam String name, @RequestParam Animal animal, @RequestParam String data){
        Vaccination vac1 = new Vaccination();
        vac1.setNamevaccinaiton(name);
        vac1.setAnimal(animal);
        vac1.setData(data);

        vaccinationRepository.save(vac1);

        return  "Saved";


    }



    @RequestMapping(path="/allvaccinations")
    public @ResponseBody Iterable<Vaccination> getAllVaccinations() {
        return vaccinationRepository.findAll();
    }


    @RequestMapping(value = "/vaccinations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vaccination> list(Model model) {
        return vaccinationService.listAllVaccinations();
    }

    @ApiIgnore
    @RequestMapping(value = "/vaccinations", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vaccination> redirect(Model model) {
        return vaccinationService.listAllVaccinations();
    }

    @RequestMapping(value = "/vaccination/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Vaccination> getByPublicId(@PathVariable("id") Integer publicId) {
        return vaccinationService.getById(publicId);
    }




}
