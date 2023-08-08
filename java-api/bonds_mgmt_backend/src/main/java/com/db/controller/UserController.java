package com.db.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.response.MessageResponse;
import com.db.model.UserData;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/test")
public class UserController {

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

}
