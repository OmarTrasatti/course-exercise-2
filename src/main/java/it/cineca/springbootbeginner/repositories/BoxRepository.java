package it.cineca.springbootbeginner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.cineca.springbootbeginner.models.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
	
    @Query(value="select b from BOX b where b.name = %searchtext%")    
    Page<Box> findAllByName (@Param("searchtext") String searchtext, PageRequest pageReq);
}
