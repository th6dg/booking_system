package com.example.demo.entity.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.user.Users;

import java.util.Collection;
import java.util.Collections;


// Step 3: Create the UserPricipal Model, class that implement user detail

/*
 * Some resource: User = combine (User, UserPrincipal)
 */
 
/*
 * In this step, we will define the User model 
 * that (include) represents the user entity in your database 
 * and implements the UserDetails interface from Spring Security
 */


/*
 * The UserPrincipal class represents a user entity in a Spring Security context, 
 * implementing the UserDetails interface. 
 * It provides user information such as username, password, and authorities. 
 */


/* 
 * The UserDetails interface is a core part of Spring Security. 
 * It provides a way to retrieve user information necessary for authentication and authorization. 
 * When you implement this interface, you tell Spring Security how to get details about a user from your data source (e.g., a database).
*/


public class UserPrincipal implements UserDetails {

    private Users user;

    public UserPrincipal(Users user) {
        this.user = user;
    }

    /*
     * The method “getAuthorities()” returns the user’s roles; 
     * it is helpful to manage permissions. 
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

