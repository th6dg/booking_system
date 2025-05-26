package com.example.demo.Iservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import com.example.demo.dto.user.CreateUserRequest;
import com.example.demo.entity.user.Users;
import com.example.demo.repository.user.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    
    //@Autowired
    //private JWTService jwtService;

   // @Autowired
    //private AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String create(CreateUserRequest createUserRequest) {
        // Encodes the password and creates a new User object
        Users user = Users.builder()
                .username(createUserRequest.getUsername())
                .password(encoder.encode(createUserRequest.getPassword())) // Encrypts the password
                .role(createUserRequest.getRole()) // Assigns default authority
                .build();
        
        // Saves the new user to the database
        userRepo.save(user);
        
        return "Create Successfully !"; // Returns a success message
    }
    // public String verify (CreateUserRequest request) {
    //     Authentication authentication = 
    //         authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    //     if (authentication.isAuthenticated()) {
    //         return jwtService.generateToken(request.getUsername());
    //     }
    //     return "false";
    // }

}
