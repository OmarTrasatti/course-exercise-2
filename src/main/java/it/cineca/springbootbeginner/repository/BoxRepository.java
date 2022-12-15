package it.cineca.springbootbeginner.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.cineca.springbootbeginner.model.Box;


public interface BoxRepository extends CrudRepository<Box, Long> {

	public List<Box> findByName(String name, Pageable pageable);
	public List<Box> findAll(Pageable pageable);
	public Optional<Box> findById(Long id);
}
