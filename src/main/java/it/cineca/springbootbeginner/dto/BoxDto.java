package it.cineca.springbootbeginner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoxDto {

	private String name;
	private String author;
	
	public BoxDto(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}
	
	
	
}
