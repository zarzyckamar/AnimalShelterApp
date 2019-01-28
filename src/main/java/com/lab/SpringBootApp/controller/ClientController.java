
package com.lab.SpringBootApp.controller;


import com.lab.SpringBootApp.model.Client;
import com.lab.SpringBootApp.repository.ClientRepository;
import com.lab.SpringBootApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;



@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientService clientService;

   @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/addclient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String addNewClient(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String city, @RequestParam String street) {
        Client c1 = new Client();
        c1.setFirstName(firstName);
        c1.setLastName(lastName);
        c1.setCity(city);
        c1.setStreet(street);
        clientRepository.save(c1);
        return  "Saved";

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Client> create(@RequestBody @Valid @NotNull Client client) {
        client.setId((int)(Math.random() * 50 + 1));
        clientService.saveClient(client);
        return ResponseEntity.ok().body(client);
    }

    @RequestMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }


    @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> list(Model model) {
        return clientService.listAllClients();
    }

    @ApiIgnore
    @RequestMapping(value = "/clients", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> redirect(Model model) {
        return clientService.listAllClients();
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Client> getByPublicId(@PathVariable("id") Integer publicId) {
        return clientService.getById(publicId);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        clientService.deleteClient(id);
        return new RedirectView("/api/clients", true);
    }



}
