package com.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom query methods here if needed
    User findByUsername(String username);
}