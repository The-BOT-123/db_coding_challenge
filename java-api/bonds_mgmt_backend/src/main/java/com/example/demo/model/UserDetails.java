package com.example.demo.model;

import jakarta.persistence.Entity;

//@Entity
public class UserDetails {
    public String name;
    public String role;

    public UserDetails() {
    }

    public UserDetails(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
