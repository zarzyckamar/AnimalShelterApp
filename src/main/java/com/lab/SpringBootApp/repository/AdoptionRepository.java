package com.lab.SpringBootApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lab.SpringBootApp.model.Adoption;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface AdoptionRepository extends CrudRepository<Adoption, Integer>,PagingAndSortingRepository<Adoption, Integer>  {

    Adoption findById(int id);



    @Query("select count(*) from Adoption p where p.id = ?1")
    Integer checkIfExist(Integer id);

}
