package com.lab.SpringBootApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lab.SpringBootApp.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ClientRepository extends CrudRepository<Client, Integer>,PagingAndSortingRepository<Client, Integer>  {

    Client findById(int id);
  //  Client findOne(Integer id);
    //void delete(Integer id);



    @Query("select count(*) from Client p where p.id = ?1")
    Integer checkIfExist(Integer id);

}
