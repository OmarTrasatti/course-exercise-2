package it.cineca.springbootsecondproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cineca.springbootsecondproject.dtos.BoxPostDTO;
import it.cineca.springbootsecondproject.models.Box;
import it.cineca.springbootsecondproject.repositories.BoxRepository;

@Service
public class BoxService {
	@Autowired
	private BoxRepository boxRepository;

	public BoxService() {
	}

	public BoxService(BoxRepository boxRepository) {
		this.boxRepository = boxRepository;
	}

	public Optional<Box> getSingleBox(Long id) {
		return this.boxRepository.findById(id);
	}

	public Box insertBox(BoxPostDTO bodyDto) {
		Box box = new Box();

		box.setName(bodyDto.getName());
		box.setAuthor(bodyDto.getAuthor());

		return this.boxRepository.save(box);

	}

	public void ModifyBox(Long id, BoxPostDTO bodyDto) {
		Optional<Box> box = this.boxRepository.findById(id);

		if (box.isPresent()) {
			Box myBox = box.get();
			myBox.setName(bodyDto.getName());
			myBox.setAuthor(bodyDto.getAuthor());
			this.boxRepository.save(myBox);
		}
	}

	public void DeleteBox(Long id) {
		this.boxRepository.deleteById(id);
	}

}
