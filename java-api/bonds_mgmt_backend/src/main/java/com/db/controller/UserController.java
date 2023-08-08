package com.db.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.response.MessageResponse;
import com.db.model.Books;
import com.db.model.Trade;
import com.db.model.BookUsers;
import com.db.model.UserData;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/test")
public class UserController {
	@PersistenceContext
	EntityManager em;

	@GetMapping("/all")
	public MessageResponse allAccess() {
		return new MessageResponse("Server is up.....");
	}

	// For Authenticated Routes please use the `@PreAuthorize("isAuthenticated()")` code, this will run a filter before this code, and will validate and extract data from JWT token.
	// For accessing the data retrieved from JWT token add `@RequestAttribute UserData user_data code`, you can access the entire user information using the user_data object.
	@GetMapping("/greeting")
	@PreAuthorize("isAuthenticated()")
	public MessageResponse userAccess(@RequestAttribute UserData user_data) {	
		
		return new MessageResponse("Congratulations! You are an authenticated user." + " " + user_data.getEmail() + " " + user_data.getUsername());
	}
	
	@GetMapping("/books")
	public MessageResponse getBooks(@RequestAttribute UserData user_data) {
		Query q = em.createNamedQuery("Book.findAllBooks");      
		List<Books> books = q.getResultList();
        for (Books i : books) {
 
            // Print all elements of ArrayList
            System.out.println(i.getBookName());
        }		
        return new MessageResponse("Congratulations! These are books");
	}
	
	@GetMapping("/booksAndUsers")
	public MessageResponse getBooksAndUsers(@RequestAttribute UserData user_data) {
		Query q = em.createNamedQuery("BookUsers.findAllBooksWithUsers");      
		List<BookUsers> bookUsers = q.getResultList();
        for (BookUsers i : bookUsers) {
 
            // Print all elements of ArrayList
            System.out.println(i.getBookDetails().getBookName() + " " + i.getUserDetails().getUsername() + " " + i.getUserDetails().getEmail());
        }		
        return new MessageResponse("Congratulations! These are books");
	}
	
	@GetMapping("/getAllTradeInformation")
	public MessageResponse getTradeInformation(@RequestAttribute UserData user_data) {
		Query q = em.createNamedQuery("Trade.innerJoinEverything"); 
		List<Trade> bookUsers = q.getResultList();
        for (Trade i : bookUsers) {
 
            // Print all elements of ArrayList
            System.out.println(i.toString() + " "  + " " + i.getBook().getBookName() + " " + 
            		i.getSecurity().getIssuer());
        }
        return new MessageResponse("Congratulations! These are books");
	}
	
	@GetMapping("/getBookInfo/{id}")
	public MessageResponse getBookInformation(@PathVariable Long id,@RequestAttribute UserData user_data) {
		Query q = em.createNamedQuery("BookUsers.findAllBooksWithSpecificUsers"); 
		q.setParameter(1, id); 
		List<BookUsers> bookUsers = q.getResultList();
        for (BookUsers i : bookUsers) {
 
            // Print all elements of ArrayList
            System.out.println(i.getBookDetails().getBookName() + " " + i.getUserDetails().getUsername() + " " + i.getUserDetails().getEmail());
        }		
        return new MessageResponse("Congratulations! These are books");
	}
}
