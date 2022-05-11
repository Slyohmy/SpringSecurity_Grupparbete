package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Användare;
import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private KundRepository kundRepository;
    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/sign_up")
    public String newUser(@RequestParam String username, @RequestParam String password, @RequestParam long kund) {

        Användare user = new Användare();
        Kund k = kundRepository.findById(kund).get();
        user.setUsername(username);
        user.setPassword(password);
        user.setKund(k);

        if (k == null) {
            user.setKund(k);
        }

        userRepository.save(user);
        log.info("User " + user + " was added to the database");
        return "User " + user + " is saved";
    }

    @RequestMapping("")
    public Iterable<Användare> getAllUsers() {
        return userRepository.findAll();
    }
}
