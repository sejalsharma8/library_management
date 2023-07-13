package com.nagarro.library_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="books")

public class Book {
	@Id
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="author")
	private String author;
	@Column(name="date")
	private String date;
	
	public Book() {
		
	}
	public Book(int id, String title, String author, String date) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
