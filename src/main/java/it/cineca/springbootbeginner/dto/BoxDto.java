package it.cineca.springbootbeginner.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BoxDto {
	
	@NotEmpty
	private String name;
	private String author;
	private Date lastUpdate;
	
	public BoxDto(String name, String author, Date lastUpdate) {
		super();
		this.name = name;
		this.author = author;
		this.lastUpdate = lastUpdate;
	}
}
