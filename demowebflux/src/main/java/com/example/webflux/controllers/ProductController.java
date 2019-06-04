package com.example.webflux.controllers;

import com.example.webflux.dao.models.Product;
import com.example.webflux.dao.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/inventory.product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Product> findaAll() {
        return productRepository.findAll();
    }

    @PostMapping(path = "/new")
    public Mono<Product> save(@RequestBody Product product) {
        return productRepository.save(product);
    }

}