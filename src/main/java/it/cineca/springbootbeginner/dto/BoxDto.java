package it.cineca.springbootbeginner.dto;

import java.util.Date;

public class BoxDto {
	
	private String name;
	private String author;
	private Date lastUpdate;
	
	public String getName() {
		return name;
	}
	public BoxDto setName(String name) {
		this.name = name;
		return this;
	}
	public String getAuthor() {
		return author;
	}
	public BoxDto setAuthor(String author) {
		this.author = author;
		return this;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public BoxDto setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}
	
	
}
