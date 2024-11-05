package com.arjay.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.arjay.demo.entity.PizzaType;

@RepositoryRestResource(collectionResourceRel = "pizzaType", path = "pizzaType")
public interface PizzaTypeRepository extends PagingAndSortingRepository<PizzaType, String>, CrudRepository<PizzaType, String> {
    
  List<PizzaType> findByName(@Param("name") String name);
}
