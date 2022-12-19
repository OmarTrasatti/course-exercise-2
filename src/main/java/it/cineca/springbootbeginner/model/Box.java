package it.cineca.springbootbeginner.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Box {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotEmpty
	String name;
	
	@Size(max = 150)
	String author;
	
	@Version
	Date lastUpdate;

	public Box(Long id, @NotEmpty String name, @Size(max = 150) String author, Date lastUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.lastUpdate = lastUpdate;
	}
	
	public Box() {
		
	}
	
}
