package com.example.webflux.controllers;

import com.example.webflux.dao.models.Customer;
import com.example.webflux.dao.services.CustomerServiceImpl;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private CustomerServiceImpl customerService;


    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/all")
    public Flux<Customer> findaAll() {
        log.info("=> Listing all Customers ...");
        return customerService.buscarTodos();
    }


    @PostMapping(path = "/new")
    public Mono<Customer> save(@RequestBody Customer customer) {
        log.info("=> Saving Customer: " + customer.toString());
        return customerService.salvar(customer);
    }

}