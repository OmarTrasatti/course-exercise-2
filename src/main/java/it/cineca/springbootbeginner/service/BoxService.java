package it.cineca.springbootbeginner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import it.cineca.springbootbeginner.component.BoxWrapper;
import it.cineca.springbootbeginner.dto.BoxDto;
import it.cineca.springbootbeginner.model.Box;
import it.cineca.springbootbeginner.repository.BoxRepository;

@Service
public class BoxService {
	
	@Autowired
	private BoxRepository boxRepository;
	@Autowired
	private BoxWrapper boxWrapper;
	@Autowired
	private ModelMapper modelMapper;
	
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
	
	public BoxDto createNewBox(BoxDto box) {
		if(boxWrapper.getBoxList() == null) {
			List<BoxDto> boxList = new ArrayList<BoxDto>(); 
			boxWrapper.setBoxList(boxList);
		}
		boxWrapper.getBoxList().add(box);
	   	return box;
	}
	
	public void saveAllBoxes() {
    	List<BoxDto> boxesInSession = boxWrapper.getBoxList();
    	
    	if(boxesInSession == null || boxesInSession.size() == 0) {
    		throw new HttpClientErrorException(HttpStatus.PRECONDITION_FAILED);
    	}
    	
    	for (BoxDto boxDto : boxesInSession) {
    		Box boxToSave = modelMapper.map(boxDto, Box.class); 
    		boxRepository.save(boxToSave);
		}
    	
    	boxesInSession.clear();
    }
	
	public void deleteBox(Long id) {
		boxRepository.deleteById(id);
	}

	public Box updateBox(Long id, Box boxToPatch, BoxDto patch) {
    	if(patch.getName() != null && !patch.getName().trim().isEmpty()) {
    		boxToPatch.setName(patch.getName());
    	}
    	if(patch.getAuthor() != null && !patch.getAuthor().trim().isEmpty()) {
    		boxToPatch.setAuthor(patch.getAuthor());
    	}
    	if(patch.getLastUpdate() != null) {
    		boxToPatch.setLastUpdate(patch.getLastUpdate());
    	}
    	return boxRepository.save(boxToPatch);
	}
	
}
