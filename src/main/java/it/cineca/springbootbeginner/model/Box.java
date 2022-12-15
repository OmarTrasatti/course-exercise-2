package it.cineca.springbootbeginner.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
