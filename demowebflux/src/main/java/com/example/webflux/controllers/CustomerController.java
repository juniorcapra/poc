package com.example.webflux.controllers;

import com.example.webflux.dao.models.Customer;
import com.example.webflux.dao.repositories.CustomerRepository;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/inventory.customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Customer> findaAll() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/count")
    public Mono<Long> count() { return customerRepository.count(); }

    @GetMapping(path = "/j")
    public Flux<Customer> findCustomersStartWithJ() { return customerRepository.findCustomersStartWithJ(); }

    @PostMapping(path = "/new")
    public Mono<Customer> save(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

}