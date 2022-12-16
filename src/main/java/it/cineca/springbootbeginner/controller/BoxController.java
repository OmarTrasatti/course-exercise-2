package it.cineca.springbootbeginner.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import it.cineca.springbootbeginner.component.BoxWrapper;
import it.cineca.springbootbeginner.dto.BoxDto;
import it.cineca.springbootbeginner.model.Box;
import it.cineca.springbootbeginner.service.BoxService;

@RestController
public class BoxController {
	
	private static final String OBJ_MAPPING = "/box";
	@Autowired
	private BoxService boxService;
	
    @RequestMapping(value = OBJ_MAPPING+ "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Box> getBox(@PathVariable Long id) {
    	Optional<Box> box = boxService.getBoxById(id);
    	if(!box.isPresent()) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Box>(box.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value = {OBJ_MAPPING + "/boxName/{name}", OBJ_MAPPING + "/boxName"}, method = RequestMethod.GET)
    public ResponseEntity<List<Box>>  getBoxByName( @PathVariable(required = false) String name,
    										@RequestParam(defaultValue = "0") Integer pageNo,
    										@RequestParam(defaultValue = "10") Integer pageSize) {
    	return new ResponseEntity<List<Box>>(boxService.getBoxByName(name, pageNo, pageSize), HttpStatus.OK);
    }
    
    @RequestMapping(value = {OBJ_MAPPING + "/newBox"}, method = RequestMethod.POST)
    public ResponseEntity<BoxDto>  createNewBox(@RequestBody @Valid BoxDto boxDto) {
    	return new ResponseEntity<BoxDto>(boxService.createNewBox(boxDto), HttpStatus.OK);
    }
    
    @RequestMapping(value = {OBJ_MAPPING + "/submit"}, method = RequestMethod.POST)
    public ResponseEntity<?>  submitBoxes() {
    	try {
    		boxService.saveAllBoxes();
    	} catch (HttpClientErrorException e) {
    		return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = {OBJ_MAPPING + "/updateBox/{id}"}, method = RequestMethod.PATCH)
    public ResponseEntity<Box>  updateBox(@PathVariable Long id, @RequestBody BoxDto patch) {
    	Optional<Box> oldBox = boxService.getBoxById(id);
    	if(!oldBox.isPresent()) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Box>(boxService.updateBox(id, oldBox.get(), patch), HttpStatus.OK);
    }
    
    @RequestMapping(value = {OBJ_MAPPING + "/deleteBox/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<?>  deleteBox(@PathVariable Long id) {
    	Optional<Box> boxToDelete = boxService.getBoxById(id);
    	if(!boxToDelete.isPresent()) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	boxService.deleteBox(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
