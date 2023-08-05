package com.db.controller;

import com.db.model.UserDetails;
import com.db.service.AuthenticationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthenticationController {
    public AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }
    @GetMapping("/auth/{username}/{password}")
    public ResponseEntity<UserDetails> login(@PathVariable(value = "username") String username,
                        @PathVariable(value = "password") String password) {

        UserDetails userDetails=new UserDetails("invalid", "invalid");
        try {
            userDetails = authenticationService.authenticate(username, password);
            System.out.println("Authorized");
            return ResponseEntity.ok(userDetails);
        } catch (Exception e) {
            System.out.println("Unauthorized");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userDetails);
        }
    }
}
