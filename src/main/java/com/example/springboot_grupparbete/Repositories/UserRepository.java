package com.example.springboot_grupparbete.Repositories;

import com.example.springboot_grupparbete.Models.Användare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Användare, Long> {
    Användare findByUsername(String username);
}
