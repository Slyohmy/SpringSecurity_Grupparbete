package com.example.springboot_grupparbete.Models;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.*;

@Entity
public class Användare {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Kund kund;

    public Användare(){}

    public Användare(String username, String password, Kund kund) {
        this.username = username;
        this.password = password;
        this.kund = kund;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Kund getKund() {
        return kund;
    }

    public void setKund(Kund kund) {
        this.kund = kund;
    }
}
