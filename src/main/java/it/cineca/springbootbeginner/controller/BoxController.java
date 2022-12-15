package it.cineca.springbootbeginner.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Box>  createNewBox(@RequestBody Box box) {
    	return new ResponseEntity<Box>(boxService.saveBox(box), HttpStatus.OK);
    }
    
    @RequestMapping(value = {OBJ_MAPPING + "/updateBox/{id}"}, method = RequestMethod.PATCH)
    public ResponseEntity<Box>  updateBox(@PathVariable Long id, @RequestBody BoxDto patch) {
    	Optional<Box> oldBox = boxService.getBoxById(id);
    	if(!oldBox.isPresent()) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
    	Box boxToPatch = oldBox.get();
    	if(patch.getName() != null && !patch.getName().trim().isEmpty()) {
    		boxToPatch.setName(patch.getName());
    	}
    	if(patch.getAuthor() != null && !patch.getAuthor().trim().isEmpty()) {
    		boxToPatch.setAuthor(patch.getAuthor());
    	}
    	if(patch.getLastUpdate() != null) {
    		boxToPatch.setLastUpdate(patch.getLastUpdate());
    	}
    	
    	return new ResponseEntity<Box>(boxService.saveBox(boxToPatch), HttpStatus.OK);
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
