
package com.lab.SpringBootApp.controller;


import com.lab.SpringBootApp.model.Animal;
import com.lab.SpringBootApp.repository.AnimalRepository;
import com.lab.SpringBootApp.repository.ClientRepository;
import com.lab.SpringBootApp.services.AnimalService;
import com.lab.SpringBootApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;



@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping(path = "/addanimal")
    public @ResponseBody
    String addNewAnimal(@RequestParam String name, @RequestParam String type, @RequestParam Integer age, @RequestParam Boolean is_adopted) {
        Animal a1 = new Animal();
        a1.setNameAnimals(name);
        a1.setType(type);
        a1.setAge(age);
        a1.setIs_adopted(is_adopted);
        return  "Saved";


    }



    @RequestMapping(path="/allanimals")
    public @ResponseBody Iterable<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }


    @RequestMapping(value = "/animals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Animal> list(Model model) {
        return animalService.listAllAnimals();
    }

    @ApiIgnore
    @RequestMapping(value = "/animals", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Animal> redirect(Model model) {
        return animalService.listAllAnimals();
    }

    @RequestMapping(value = "/animal/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Animal> getByPublicId(@PathVariable("id") Integer publicId) {
        return animalService.getById(publicId);
    }

    @RequestMapping(value = "/animal/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        animalService.deleteAnimal(id);
        return new RedirectView("/api/animal", true);
    }



}
