package com.example.api.Repositories;

import com.example.api.Models.Produkt;
import org.springframework.data.repository.CrudRepository;

public interface ProduktRepository extends CrudRepository <Produkt, Long> {
}
