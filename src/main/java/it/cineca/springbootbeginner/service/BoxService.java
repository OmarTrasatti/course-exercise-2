package it.cineca.springbootbeginner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.cineca.springbootbeginner.model.Box;
import it.cineca.springbootbeginner.repository.BoxRepository;

@Service
public class BoxService {
	
	@Autowired
	private BoxRepository boxRepository;
	
	public List<Box> getBoxByName(String name, Integer pageNo, Integer pageSize){
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		if(name != null) {
			return boxRepository.findByName(name, paging);
		} else {
			return boxRepository.findAll(paging);
		}
	}
	
	public Optional<Box> getBoxById(Long id) {
		return boxRepository.findById(id);
	}
	
	public Box saveBox(Box box) {
		return boxRepository.save(box);
	}
	
	public void deleteBox(Long id) {
		boxRepository.deleteById(id);
	}
	
}
