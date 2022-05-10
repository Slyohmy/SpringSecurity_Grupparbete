package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.AuthenticationRequest;
import com.example.springboot_grupparbete.Models.AuthenticationResponse;
import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import com.example.springboot_grupparbete.Services.MyUserDetailsService;
import com.example.springboot_grupparbete.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/kund")
public class KundController {

    private final KundRepository kundRepository;

    public KundController(KundRepository kundRepository) {
        this.kundRepository = kundRepository;
    }


    @PostMapping("")
    public String createKund(@RequestBody Kund nyKund) {
        kundRepository.save(nyKund);
        return "Saved: " + nyKund;
    }

    @GetMapping("")
    public Iterable<Kund> getAllKunder() {
        return kundRepository.findAll();
    }

    @GetMapping("/get")
    public Kund getKund(@RequestParam Long kundId) {
        return kundRepository.findById(kundId).get();
    }

    @GetMapping("{id}")
    public Optional<Kund> getKundById(@PathVariable Long id) {
        return kundRepository.findById(id);
    }

}