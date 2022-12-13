package it.cineca.springbootsecondproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cineca.springbootsecondproject.models.Box;

public interface BoxRepository extends JpaRepository<Box, Long> {

}
