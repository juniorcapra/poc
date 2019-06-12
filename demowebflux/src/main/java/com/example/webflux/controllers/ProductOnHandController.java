package com.example.webflux.controllers;

import com.example.webflux.dao.models.ProductOnHand;
import com.example.webflux.dao.repositories.ProductOnHandRepository;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@RestController
@RequestMapping(path = "/productOnHand")
public class ProductOnHandController {

    private ProductOnHandRepository productOnHandRepository;

    public ProductOnHandController(ProductOnHandRepository productOnHandRepository) {
        this.productOnHandRepository = productOnHandRepository;
    }

    @GetMapping(path = "/all")
    public Flux<ProductOnHand> findaAll() {
        log.info("=> Listing all ProductsOnHand ...");
        return productOnHandRepository.findAll();
    }

    @GetMapping(path = "/firstProductOnHand")
    public Mono<ProductOnHand> findFirstProductOnHand() {
        log.info("=> Listing ProductOnHand where ID equal 1 ...");
        return productOnHandRepository.findFirstProductsOnHand();
    }

    @PostMapping(path = "/new")
    public Mono<ProductOnHand> save(@RequestBody ProductOnHand productOnHand) {
        log.info("=> Saving ProductOnHand: " + productOnHand.toString());
        return productOnHandRepository.save(productOnHand);
    }

}