package com.lab.SpringBootApp.services;

import com.lab.SpringBootApp.model.Client;
import com.lab.SpringBootApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
    public class ClientServiceImpl implements ClientService {

        @Autowired
        private ClientRepository clientRepository;



        @Override
        public Iterable<Client> listAllClientsPaging(Integer pageNr, Integer howManyOnPage) {

            return clientRepository.findAll(new PageRequest(pageNr,howManyOnPage ));
        }


        public Iterable<Client> listAllClients() {
            return clientRepository.findAll();
        }


        @Override
        public Optional<Client> getById(Integer id) {
            return clientRepository.findById(id);
        }

        @Override
        public Client saveClient(Client product) {
            return clientRepository.save(product);
        }

        @Override
        public void deleteClient(Integer id) {
            clientRepository.deleteById(id);}


        @Override
        public Boolean checkIfExist(Integer id) {
            if (clientRepository.checkIfExist(id) > 0)
                return true;
            else
                return false;
        }




}

