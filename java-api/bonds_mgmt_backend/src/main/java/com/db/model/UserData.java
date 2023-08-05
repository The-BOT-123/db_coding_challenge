package com.db.model;

import javax.persistence.Column;

public class UserData {
	private Integer id;
	private String username;
	private String email;
	private String role;

	public UserData(Integer id, String username, String email, String role) {
		this.username = username;
		this.email = email;
		this.id = id;
		this.role = role;
	}
	

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

}
