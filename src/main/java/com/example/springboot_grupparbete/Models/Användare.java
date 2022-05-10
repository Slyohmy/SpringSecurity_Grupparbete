/*package com.example.springboot_grupparbete.Models;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.*;

@Entity
public class Användare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Kund kund;
    private User user;

    public Användare(){}

    public Användare(User user, Kund kund){
        this.user = user;
        this.kund = kund;
    }
}*/
