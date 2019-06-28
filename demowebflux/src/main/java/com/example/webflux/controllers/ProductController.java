package com.example.webflux.controllers;

import com.example.webflux.dao.models.Product;
import com.example.webflux.dao.repositories.ProductRepository;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    public ProductController() {
    }

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Product> findaAll() {
        log.info("=> Listing all Products ...");
        return productRepository.findAll();
    }

    @GetMapping(path = "/firstProduct")
    public Mono<Product> findFirstProduct() {
        log.info("=> Listing Product where ID equal 1 ...");
        return productRepository.findFirstProduct();
    }

    @PostMapping(path = "/new")
    public Mono<Product> save(@RequestBody Product product) {
        log.info("=> Saving Product: " + product.toString());
        return productRepository.save(product);
    }

}