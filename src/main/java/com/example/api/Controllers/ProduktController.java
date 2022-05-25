package com.example.api.Controllers;


import com.example.api.Models.Beställning;
import com.example.api.Models.Produkt;
import com.example.api.RabbitMQ.CustomMessage_V2;
import com.example.api.RabbitMQ.MQConfig_V2;
import com.example.api.Repositories.BeställningRepository;
import com.example.api.Repositories.ProduktRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path ="/produkt")
public class ProduktController {

    private final ProduktRepository produktRepository;
    private final BeställningRepository beställningRepository;

    @Autowired
    private RabbitTemplate template;

    public ProduktController(ProduktRepository produktRepository, BeställningRepository beställningRepository) {

        this.produktRepository = produktRepository;
        this.beställningRepository = beställningRepository;
    }

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
        publishMessage(b);
        return b;
    }

    public void publishMessage(Beställning beställning) {
        CustomMessage_V2 message = new CustomMessage_V2();
        message.setMessage(" Pris: " + beställning.getTotalPris() + " Datum: " + beställning.getDatum());
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig_V2.EXCHANGE, MQConfig_V2.ROUTING_KEY, message);
    }
}
