package it.cineca.springbootbeginner.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cineca.springbootbeginner.dto.BoxDto;
import it.cineca.springbootbeginner.model.Box;
import it.cineca.springbootbeginner.repository.BoxRepository;

@Service
public class BoxService {

	@Autowired
	private BoxRepository boxRepository;

	public Optional<Box> getSingleBox(Long id) {
		return this.boxRepository.findById(id);
	}
	
	public void deleteSingleBox(Long id) {
		boxRepository.deleteById(id);;
	}
	
	public Box insertSingleBox(BoxDto boxDto) {
		Box box = new Box();
		box.setAuthor(boxDto.getAuthor());
		box.setName(boxDto.getName());
		return boxRepository.save(box);
	}
	
	public void updateSingleBox(Long id, BoxDto boxDto) {
		Optional<Box> optionalBox = getSingleBox(id);
		if(optionalBox.isPresent()) {
			Box box = optionalBox.get();
			box.setAuthor(boxDto.getAuthor()); 
			box.setName(boxDto.getName());
			boxRepository.save(box);
		}
	}
	
	
}
