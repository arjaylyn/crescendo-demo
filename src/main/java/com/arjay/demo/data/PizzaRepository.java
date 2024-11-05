package com.arjay.demo.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.arjay.demo.model.Pizza;
import com.arjay.demo.model.Size;

@RepositoryRestResource(collectionResourceRel = "pizza", path = "pizza")
public interface PizzaRepository extends PagingAndSortingRepository<Pizza, String>, CrudRepository<Pizza, String> {
    
  List<Pizza> findBySize(@Param("size") Size size);
}
