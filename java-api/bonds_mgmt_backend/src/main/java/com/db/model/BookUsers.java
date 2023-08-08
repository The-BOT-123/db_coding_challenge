/**
 * 
 */
package com.db.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "bookusers")	
public class BookUsers {
	
	private @Id  @GeneratedValue Long id;

	@JoinColumn(name="book_id")
	@OneToOne(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Book book;
	
	@JoinColumn(name="user_id")
	@ManyToOne
    private User user;
}
