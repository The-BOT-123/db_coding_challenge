/**
 * 
 */
package com.db.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@OneToMany
    private List<Book> book;
	
	@JoinColumn(name="user_id")
	@OneToMany
    private List<User> user;
	
	public List<Book> getBooks(){
		return book;
	}
}
