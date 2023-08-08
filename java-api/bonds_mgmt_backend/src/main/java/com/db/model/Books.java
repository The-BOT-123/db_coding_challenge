package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedNativeQueries({

    @NamedNativeQuery(
        name = "Book.findAllBooks",
        query =
            "SELECT * " +
            "FROM books ", resultClass = Books.class
    )
    })
public class Books {
	
	private @Id @GeneratedValue Long id;

	private String book_name;
	
	public String getBookName() {
		return book_name;
	}

}