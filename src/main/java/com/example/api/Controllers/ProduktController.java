package com.example.api.Controllers;


import com.example.api.Models.Beställning;
import com.example.api.Models.Produkt;
import com.example.api.Repositories.BeställningRepository;
import com.example.api.Repositories.ProduktRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="/produkt")
public class ProduktController {

    private final ProduktRepository produktRepository;
    private final BeställningRepository beställningRepository;


    public ProduktController(ProduktRepository produktRepository, BeställningRepository beställningRepository) {

        this.produktRepository = produktRepository;
        this.beställningRepository = beställningRepository;
    }

    //Använd koden nedan efter att vi har fått till frontend separat
    @GetMapping("")
    public Iterable<Produkt> getAllProdukter() {
        return produktRepository.findAll();
    }

    /*
    @GetMapping("")
    public String getAll(Model model){
        Iterable<Produkt> p=produktRepository.findAll();
        model.addAttribute("rubrik", "Alla Våra Produkter");
        model.addAttribute("allProducts", p);
        model.addAttribute("brandTitle", "Märke");
        model.addAttribute("colorTitle", "Färg");
        model.addAttribute("sizeTitle", "Storlek");
        model.addAttribute("priceTitle", "Pris");
        model.addAttribute("stock", "Lager");

        return "products";
    }*/

    @GetMapping("{id}")
    public Optional<Produkt> getProduktById(@PathVariable Long id) {
        return produktRepository.findById(id);
    }

    @RequestMapping("/get")
    public Produkt getById(@RequestParam Long id){
        return produktRepository.findById(id).get();
    }

    @PostMapping("/post")
    public Beställning postBeställning(@RequestBody Beställning b) {
        beställningRepository.save(b);
        return b;
    }
}
