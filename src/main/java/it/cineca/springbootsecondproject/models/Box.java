package it.cineca.springbootsecondproject.models;


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
	private Long id;
	
	@NotEmpty
	private String name;
	
	@Size(max = 150)
	private String author;
	
	@Version
	private Date lastUpDate;

	public Box() {
	}

	public Box(Long id, String name, String author, Date lastUpDate) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.lastUpDate = lastUpDate;
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

	public Date getLastUpDate() {
		return lastUpDate;
	}

	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}

}
