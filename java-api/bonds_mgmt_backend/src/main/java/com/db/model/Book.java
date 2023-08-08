package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")	
public class Book {
	
	private @Id @GeneratedValue Long id;

	
	@Column(name="book_Name")
	private String book_Name;

}
