package com.example.demo.controller.hello;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.login.LoginResponse;
import com.example.demo.dto.login.LoginUserDto;
import com.example.demo.dto.user.CreateUserRequest;
import com.example.demo.entity.security.UserPrincipal;
import com.example.demo.entity.user.Users;
import com.example.demo.service.async.AsyncService;
import com.example.demo.service.login.AuthenticationService;
import com.example.demo.service.login.JwtService;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class HelloController {

    private final UserService userService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AsyncService asyncService;

    HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String Helloworld() throws InterruptedException {

        System.err.println("hello with thread: "+ Thread.currentThread().getId());
        for (int i = 0; i<5; i++) {
            System.out.println(Thread.currentThread().getId() + ": " + i);
            Thread.sleep(5000);
        }
        System.err.println("Finished thread: "+ Thread.currentThread().getId());
        return "hello world";
    }

    @GetMapping("/student")
    public  String student(){
        return "This is Student";
    }

    @GetMapping("/admin")
    public  String admin(){
        return "This is Admin";
    }

    @GetMapping("/auth/login")
    public LoginResponse authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserPrincipal authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return loginResponse;
    }

    @PostMapping("/createuser")
    public String createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.create(createUserRequest);
    }

    @GetMapping("/async")
    public void AsyncMethod() throws InterruptedException {
        asyncService.processTask();
    }
    
       

}