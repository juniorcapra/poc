package com.example.webflux.controllers;

import com.example.webflux.dao.models.Customer;
import com.example.webflux.dao.repositories.CustomerRepository;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Customer> findaAll() {
        log.info("=> Listing all Customers ...");
        return customerRepository.findAll();
    }

    @GetMapping(path = "/count")
    public Mono<Long> count() {
        log.info("=> Couting Customers ...");
        return customerRepository.count();
    }

    @GetMapping(path = "/firstCustomer")
    public Mono<Customer> findFirstCustomer() {
        log.info("=> Listing Customer where ID equal 1 ...");
        return customerRepository.findFirstCustomer();
    }

    @GetMapping(path = "/j")
    public Flux<Customer> findCustomersStartWithJ() {
        log.info("=> Listing all Customers starts with J ...");
        return customerRepository.findCustomersStartWithJ();
    }

    @PostMapping(path = "/new")
    public Mono<Customer> save(@RequestBody Customer customer) {
        log.info("=> Saving Customer: " + customer.toString());
        return customerRepository.save(customer);
    }

}