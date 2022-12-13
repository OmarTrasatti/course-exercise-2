package it.cineca.springbootsecondproject.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.cineca.springbootsecondproject.dtos.BoxPostDTO;
import it.cineca.springbootsecondproject.models.Box;
import it.cineca.springbootsecondproject.services.BoxService;

@RestController
public class BoxController {
	@Autowired
	private BoxService boxService;
	
	public BoxController() {
		// TODO Auto-generated constructor stub
	}

	public BoxController(BoxService boxService) {
		this.boxService = boxService;
	}

	@GetMapping("/box/{id}")
	public ResponseEntity<Box> getSingleBox(@PathVariable("id") Long id) {

		Optional<Box> boxOptional = this.boxService.getSingleBox(id);

		return ResponseEntity.of(boxOptional);
	}

	@PostMapping("/box")
	public ResponseEntity<Box> insertBox(@RequestBody BoxPostDTO bodyDto) {
		Box box = this.boxService.insertBox(bodyDto);

		return ResponseEntity.ok(box);
	}

	@PatchMapping("/box/{id}")
	public ResponseEntity<?> ModifyBox(@PathVariable("id") Long id, @RequestBody BoxPostDTO bodyDto) {

		this.boxService.ModifyBox(id, bodyDto);

		return ResponseEntity.ok("resource address updated");
	}

	@DeleteMapping("/box/{id}")
	public ResponseEntity<Boolean> DeleteBox(@PathVariable("id") Long id) {

		this.boxService.DeleteBox(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
