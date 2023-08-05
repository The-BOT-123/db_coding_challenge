package com.example.demo.service;

//import com.example.demo.model.User;
import com.example.demo.model.User;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    @Autowired
    public AuthenticationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserDetails authenticate(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(password)){
            String role = "user";
            return new UserDetails(username, role);
        }
        return new UserDetails("inv", "inv");
    }
}
