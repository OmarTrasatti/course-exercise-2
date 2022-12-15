package it.cineca.springbootbeginner.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.cineca.springbootbeginner.dto.BoxDto;
import it.cineca.springbootbeginner.model.Box;
import it.cineca.springbootbeginner.service.BoxService;

@RestController
public class BoxController {

	//private static final String OBJ_MAPPING = "/box";
	
	@Autowired
	private BoxService boxService;
	
	@GetMapping("/box/{id}")
	public ResponseEntity<Box> getSingleBox(@PathVariable("id") Long id) {
		Optional<Box> boxOptional = this.boxService.getSingleBox(id);
		return ResponseEntity.of(boxOptional);
	}
	
	@DeleteMapping("/box/{id}")
	public void deleteSingleBox(@PathVariable("id") Long id) {
		this.boxService.deleteSingleBox(id);
	}
	
	@PostMapping("/box")
	public ResponseEntity<Box> postSingleBox(@RequestBody BoxDto boxDto) {
		Box box = this.boxService.insertSingleBox(boxDto);
		return ResponseEntity.ok(box);
	}
	
	//@RequestMapping(value = {OBJ_MAPPING + "/updateBox/{id}"}, method = RequestMethod.PATCH)
	@PatchMapping("/box/{id}")
	public void patchSingleBox(@PathVariable("id") Long id, @RequestBody BoxDto boxDto) {
		this.boxService.updateSingleBox(id, boxDto);
	}
	
}
