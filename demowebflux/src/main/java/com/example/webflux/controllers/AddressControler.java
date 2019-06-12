package com.example.webflux.controllers;

import com.example.webflux.dao.models.Address;
import com.example.webflux.dao.repositories.AddressCustomerRepositoryImpl;
import com.example.webflux.dao.repositories.AddressRepository;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Log
@RestController
@RequestMapping(path = "/address")
public class AddressControler {

    private AddressRepository addressRepository;
    private AddressCustomerRepositoryImpl addressCustomerRepository;

    public AddressControler(AddressRepository addressRepository, AddressCustomerRepositoryImpl addressCustomerRepository) {
        this.addressRepository = addressRepository;
        this.addressCustomerRepository = addressCustomerRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Address> findaAll() {
        log.info("=> Listing all Addresses ...");
        return addressRepository.findAll();
    }

    @GetMapping(path = "/findWithJoin")
    public Flux<Map<String, Object>> findWithJoin() {
        log.info("=> Listing Address using Join ...");
        return addressCustomerRepository.findWithJoin();
    }

    @GetMapping(path = "/firstAddress")
    public Mono<Address> findFirstAddress() {
        log.info("=> Listing Address where ID equal 1 ...");
        return addressRepository.findFirstAddress();
    }

    @PostMapping(path = "/new")
    public Mono<Address> save(@RequestBody Address address) {
        log.info("=> Saving Address: " + address.toString());
        return addressRepository.save(address);
    }

}