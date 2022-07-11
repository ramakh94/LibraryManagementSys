package com.example.entity;



import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "isbn", length = 50, nullable = false, unique = true)
	private String isbn;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "serialName", length = 50, nullable = false)
	private String serialName;

	@Column(name = "description" , nullable = false)
	private String description;

	@Column(name="empty", columnDefinition="boolean default false",nullable = false)
	private Boolean empty;

	@Column(name = "author" , nullable = false)
	private String author;

	@Column(name = "category" , nullable = false)
	private String category;



	public Book(String isbn, String name, String serialName, String description,Boolean empty,String author,String category) {
		this.isbn = isbn;
		this.name = name;
		this.serialName = serialName;
		this.description = description;
		this.empty=empty;
		this.category=category;
		this.author=author;
	}



}
