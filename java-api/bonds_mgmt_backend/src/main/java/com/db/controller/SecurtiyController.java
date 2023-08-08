/**
 * 
 */
package com.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Security;
import com.db.repository.SecurityRepository;

@RestController
@RequestMapping("/api")
public class SecurtiyController {

	 @Autowired
     private SecurityRepository securityRepository;

    @GetMapping("/security/{id}")
    public Security getSecurityById(@PathVariable Long id) {
        return securityRepository.findById(id).orElse(null);
    }
}
