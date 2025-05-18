package com.example.demo.service.login;

import com.example.demo.entity.security.UserPrincipal;
import com.example.demo.entity.user.Users;
import com.example.demo.repository.user.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*    ---------------------
 *    | DaoAuthentication |  <---->  UserDetailService <------------ UserDetails
 *    | Provider          |                 |                             ^
 *    ---------------------                 v                             |
 *                                    UserRepository  -----------------> Users
 * 
 * 
 * UnAuthenticated Object  ---> Provider  ---> Authenticated Object
 *                                                 ( Or Not )
 * 
 * If UserDetails not null ---> authenticated project ----> return resource
*/

/*
 * Step 4: Define the class implement UserDetailsService
 * 
 * Create a service to handle user details and authentication. 
 * This service implements the UserDetailsService interface, 
 * essential for fetching user information during authentication.
 * 
 * Loading User Details:
 * Method: loadUserByUsername(String username)
 * Purpose: This method fetches user information from the database using their username. 
 * Spring Security calls this method to retrieve the user's details when they attempt to log in.
 * 
 */

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return new UserPrincipal(user);
    }
    @Override
    public String toString() {
        return "hello, this is class implement UserDetailsService";
    }
}