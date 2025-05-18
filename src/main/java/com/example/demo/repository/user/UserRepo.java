package com.example.demo.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.user.Users;

// Step 5: Define the User Repository

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);

    
}