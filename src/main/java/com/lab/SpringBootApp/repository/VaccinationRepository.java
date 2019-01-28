package com.lab.SpringBootApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lab.SpringBootApp.model.Vaccination;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface VaccinationRepository extends CrudRepository<Vaccination, Integer>,PagingAndSortingRepository<Vaccination, Integer>  {

    Vaccination findById(int id);



    @Query("select count(*) from Vaccination p where p.id = ?1")
    Integer checkIfExist(Integer id);

}
