package it.cineca.springbootbeginner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	private ModelMapper modelMapper;
	@Autowired
	private BoxWrapper boxWrapper;

	public Optional<Box> getSingleBox(Long id) {
		return this.boxRepository.findById(id);
	}
	
	public void deleteSingleBox(Long id) {
		boxRepository.deleteById(id);
	}
	
	public Box insertSingleBox(BoxDto boxDto) {
		Box box = modelMapper.map(boxDto, Box.class);
		if(boxWrapper.getListBox() == null) {
			boxWrapper.setListBox(new ArrayList<BoxDto>());
		}
		boxWrapper.getListBox().add(boxDto);
		return box;
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
	
	public void submitBoxes() {
		List<BoxDto> sessionBoxes = boxWrapper.getListBox();
		
		if(sessionBoxes.isEmpty()) {
			throw new HttpClientErrorException(HttpStatus.PRECONDITION_FAILED);
		}
		
		for(BoxDto boxDto : sessionBoxes) {
			Box box = modelMapper.map(boxDto, Box.class);
			boxRepository.save(box);
		}
		
		sessionBoxes.clear();
	}
	
}
