package com.example.webflux.controllers;

import com.example.webflux.dao.models.ProductOnHand;
import com.example.webflux.dao.repositories.ProductOnHandRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/productOnHand")
public class ProductOnHandController {

    private ProductOnHandRepository productOnHandRepository;

    public ProductOnHandController(ProductOnHandRepository productOnHandRepository) {
        this.productOnHandRepository = productOnHandRepository;
    }

    @GetMapping(path = "/all")
    public Flux<ProductOnHand> findaAll() {
        return productOnHandRepository.findAll();
    }

    @PostMapping(path = "/new")
    public Mono<ProductOnHand> save(@RequestBody ProductOnHand productOnHand) {
        return productOnHandRepository.save(productOnHand);
    }

}