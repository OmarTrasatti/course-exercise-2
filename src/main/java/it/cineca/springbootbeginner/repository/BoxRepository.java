package it.cineca.springbootbeginner.repository;

import org.springframework.data.repository.CrudRepository;

import it.cineca.springbootbeginner.model.Box;

public interface BoxRepository extends CrudRepository<Box, Long> {
	
//	List<Box> findByName(String name);
}
