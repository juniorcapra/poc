package com.example.webflux.controllers;

import com.example.webflux.dao.models.Addresses;
import com.example.webflux.dao.repositories.AddressesRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/inventory.addresses")
public class AddressesControler {

    private AddressesRepository addressesRepository;


    public AddressesControler(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }


    @GetMapping(path = "/all")
    public Flux<Addresses> findaAll() {
        return addressesRepository.findAll();
    }

    @PostMapping(path = "/new")
    public Mono<Addresses> save(@RequestBody Addresses addresses) {
        return addressesRepository.save(addresses);
    }

}
