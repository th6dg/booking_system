package com.example.demo.dto.user;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;

    private String password;

    private String role;
}
