package com.db.model;


import jakarta.persistence.*;

@Entity
@Table(name="usertable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public String getUsername() {
        return username;
    }

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }
    // Other user fields, getters, setters, and constructors
}

