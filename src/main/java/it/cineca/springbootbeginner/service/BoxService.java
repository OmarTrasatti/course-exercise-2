package it.cineca.springbootbeginner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.cineca.springbootbeginner.dto.BoxDto;
import it.cineca.springbootbeginner.models.Box;
import io.micrometer.common.util.StringUtils;
import it.cineca.springbootbeginner.repository.BoxRepository;

@Service
public class BoxService {
	
	@Autowired
	private BoxRepository boxRepo;
	
	public List<Box> getByNamePaged(String name, PageRequest page){
		return StringUtils.isBlank(name)?
				boxRepo.findAll(page).toList():
					boxRepo.findByName(name, page);
	}
	
	public Optional<Box> getOne(Long id) {
		return boxRepo.findById(id);
	}
	
	public Box createBox(BoxDto dto) {
		Box daCreare=new Box(null, dto.getName(), dto.getAuthor(), null);
		return boxRepo.save(daCreare);
	}
	
	public Optional<Box> updateBox(Long id, BoxDto dto){
		Box daCreare=null;
		if (boxRepo.findById(id).isPresent())
			daCreare=new Box(null, dto.getName(), dto.getAuthor(), null);	
		return Optional.ofNullable(daCreare);
	}
	
	public void deleteBox(Long id) {
		boxRepo.deleteById(id);
	}

}
