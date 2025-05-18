package com.example.demo.service.login;

import com.example.demo.entity.security.UserPrincipal;
import com.example.demo.entity.user.Users;
import com.example.demo.repository.user.UserRepo;
import com.example.demo.dto.login.LoginUserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AuthenticationService {
    
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepo userRepo;

    // public User signup(RegisterUserDto input) {
    //     User user = new User()
    //             .setFullName(input.getFullName())
    //             .setEmail(input.getEmail())
    //             .setPassword(passwordEncoder.encode(input.getPassword()));

    //     return userRepository.save(user);
    // }

    public UserPrincipal authenticate(LoginUserDto input) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(input.getUsername(),
                                                    input.getPassword()));
        
        Users user = (userRepo.findByUsername(input.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("User not found")));
        
        return new UserPrincipal(user);
    }
}