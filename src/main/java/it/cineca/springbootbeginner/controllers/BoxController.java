package it.cineca.springbootbeginner.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.cineca.springbootbeginner.dtos.BoxPostDto;
import it.cineca.springbootbeginner.models.Box;
import it.cineca.springbootbeginner.services.BoxService;

@RestController
public class BoxController {
	
	private BoxService boxService;
	
	public BoxController() {}

	@Autowired
	public BoxController(BoxService boxService) {
		this.boxService = boxService;
	}
	
	@GetMapping("/boxs")
	public ResponseEntity<List<Box>> getBoxes(
			@RequestParam(name = "page", required = true) int page, 
			@RequestParam(name = "pagesize", required = false, defaultValue = "3") int pagesize,
			@RequestParam(name = "name", required = false) String name
			) {
		
		PageRequest pageReq = PageRequest.of(page, pagesize);
		List<Box> boxs = this.boxService.getBoxs(name, pageReq);
		
		return ResponseEntity.ok(boxs);
	}
	
	@GetMapping("/box/{id}")
	public ResponseEntity<Box> getBox(@PathVariable("id") Long id) {
		Optional<Box> box = this.boxService.getBox(id);
		
		return ResponseEntity.of(box);
	}
		  
	@PostMapping("/box")
	public ResponseEntity<Box> createBox(@RequestBody @Valid BoxPostDto body) {
		Box newBox = this.boxService.createBox(body);
		return ResponseEntity.ok(newBox);
	}
	
	@PatchMapping("/box/{id}")
	public ResponseEntity<Box> updateBox(@PathVariable("id") Long id, @RequestBody @Valid BoxPostDto body) {
		Optional<Box> updatedBox = this.boxService.updateBox(id, body);
		return ResponseEntity.of(updatedBox);
	}
	
	@DeleteMapping("/box/{id}")
	public ResponseEntity<Boolean> deleteBox(@PathVariable("id") Long id) {
		this.boxService.deleteBox(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
