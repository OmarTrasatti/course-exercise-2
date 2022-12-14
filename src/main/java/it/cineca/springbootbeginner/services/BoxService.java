package it.cineca.springbootbeginner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.cineca.springbootbeginner.dtos.BoxPostDto;
import it.cineca.springbootbeginner.models.Box;
import it.cineca.springbootbeginner.repositories.BoxRepository;

@Service
public class BoxService {
	private BoxRepository boxRepository;
	
	@Autowired
	public BoxService(BoxRepository boxRepository) {
		this.boxRepository = boxRepository;
	}
	
	public List<Box> getBoxs(String name, PageRequest pageReq) {
		if(name != null) {
			Page<Box> result = this.boxRepository.findAllByName(name, pageReq);
			return result.getContent();
		} else {
			Page<Box> result = this.boxRepository.findAll(pageReq);
			return result.getContent();
		}
	}
	
	public Optional<Box> getBox(Long id) {
		return this.boxRepository.findById(id);
	}
	
	public Box createBox (BoxPostDto body) {
		Box newBox = new Box();
		
		newBox.setName(body.getName());
		newBox.setAuthor(body.getAuthor());
		
		return this.boxRepository.save(newBox);
	}
	
	public Optional<Box> updateBox(Long id, BoxPostDto body) {
		Optional<Box> box = this.boxRepository.findById(id);
		
		if(box.isPresent()) {
			Box boxToUpdate = box.get();
			if (body.getName() != null)
				boxToUpdate.setName(body.getName());
			if (body.getAuthor() != null)
				boxToUpdate.setAuthor(body.getAuthor());
			
			return Optional.ofNullable(this.boxRepository.save(boxToUpdate));
			
		} else {
			return box;
		}	
	}
	
	public void deleteBox(Long id) {
		this.boxRepository.deleteById(id);
	}

}
