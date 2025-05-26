package com.example.demo.controller.hello;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Iservice.async.AsyncService;
import com.example.demo.Iservice.async.AsyncServiceV2;
import com.example.demo.Iservice.async.AsyncServiceV3Test;
import com.example.demo.Iservice.login.AuthenticationService;
import com.example.demo.Iservice.login.JwtService;
import com.example.demo.Iservice.user.UserService;
import com.example.demo.dto.login.LoginResponse;
import com.example.demo.dto.login.LoginUserDto;
import com.example.demo.dto.user.CreateUserRequest;
import com.example.demo.entity.security.UserPrincipal;
import com.example.demo.entity.user.Users;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class HelloController {
    @Autowired
    private AsyncServiceV2 asyncServiceV2;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private AsyncServiceV3Test asyncServiceV3Test;
    


    @GetMapping("/hello")
    public String Helloworld(@RequestParam(name = "index") int index) throws InterruptedException {

        //System.err.println("hello with thread: "+ Thread.currentThread().getId());
        
        System.err.println("thread: "+ Thread.currentThread().getId()+" and number: "+ index);
        asyncServiceV3Test.AddRequest(index);;
        //System.err.println("Finished thread: "+ Thread.currentThread().getId() + " number "+ index);
        return "hello world";
    }

    @GetMapping("/hello/process")
    public void ProcessQueue() throws InterruptedException {
        System.out.println("Starting process loop.....");
        asyncServiceV3Test.PopRequest();
        
        
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