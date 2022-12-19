package it.cineca.springbootbeginner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.cineca.springbootbeginner.model.Box;

public interface BoxRepository extends CrudRepository<Box, Long> {
	
//	List<Box> findByName(String name);
}
