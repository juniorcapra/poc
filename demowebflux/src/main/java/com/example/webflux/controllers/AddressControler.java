package com.example.webflux.controllers;

import com.example.webflux.dao.models.Address;
import com.example.webflux.dao.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/address")
public class AddressControler {

    private AddressRepository addressRepository;

    public AddressControler(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Address> findaAll() {
        return addressRepository.findAll();
    }

    @PostMapping(path = "/new")
    public Mono<Address> save(@RequestBody Address address) {
        return addressRepository.save(address);
    }

}
