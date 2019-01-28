package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Client;

import java.util.Optional;


public interface ClientService {

    Iterable<Client> listAllClients();

    Optional<Client> getById(Integer id);

    Client saveClient(Client product);

    void deleteClient(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Client> listAllClientsPaging(Integer pageNr, Integer howManyOnPage);


}
