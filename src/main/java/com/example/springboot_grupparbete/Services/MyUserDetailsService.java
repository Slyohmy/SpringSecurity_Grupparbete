package com.example.springboot_grupparbete.Services;

import com.example.springboot_grupparbete.Controllers.AuthenticationController;
import com.example.springboot_grupparbete.Controllers.UserController;
import com.example.springboot_grupparbete.Models.Användare;
import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("simon", "password", new ArrayList<>());
    }

    /*@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Användare user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserRepository(user);
    }*/
}
