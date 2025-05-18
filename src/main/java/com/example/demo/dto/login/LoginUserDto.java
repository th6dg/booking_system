package com.example.demo.dto.login;

import lombok.Data;

@Data       // Auto getter, setter
public class LoginUserDto {
    private String Username;

    private String password;
}
