package com.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.Security;

public interface SecurityRepository extends JpaRepository<Security, Long> {

}
