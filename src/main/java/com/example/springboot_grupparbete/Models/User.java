//package com.example.springboot_grupparbete.Models;
//import javax.persistence.*;
//
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private String password;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn
//    private Kund kund;
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Kund getKund() {
//        return kund;
//    }
//
//    public void setKund(Kund kund) {
//        this.kund = kund;
//    }
//}
//
//    /*
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(nullable = false)
//    private Kund kund;
//
//    @Column(nullable = false, length = 20)
//    private String username;
//
//    @Column(nullable = false, length = 64)
//    private String password;
//
//
//
//    public Användare() {
//    }
//
//    public Användare(Kund kund, String username, String password) {
//        this.kund = kund;
//        this.username = username;
//        this.password = password;
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Kund getKund() {
//        return kund;
//    }
//
//    public void setKund(Kund kund) {
//        this.kund = kund;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}*/
