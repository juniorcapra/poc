package com.example.webflux.controllers;

import com.example.webflux.dao.models.Address;
import com.example.webflux.dao.repositories.AddressCustomerRepositoryImpl;
import com.example.webflux.dao.services.AddressServiceImpl;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Log
@RestController
@RequestMapping(path = "/address")
public class AddressControler {

    private AddressServiceImpl addressService;


    private AddressCustomerRepositoryImpl addressCustomerRepository;

    public AddressControler(AddressServiceImpl addressService, AddressCustomerRepositoryImpl addressCustomerRepository) {
        this.addressService = addressService;
        this.addressCustomerRepository = addressCustomerRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Address> findaAll() {
        log.info("=> Listing all Addresses ...");
        return addressService.buscarTodos();
    }

    @GetMapping(path = "/findWithJoin")
    public Flux<Map<String, Object>> findWithJoin() {
        log.info("=> Listing Address using Join ...");
        return addressCustomerRepository.findWithJoin();
    }


    @PostMapping(path = "/new")
    public Mono<Address> save(@RequestBody Address address) {
        log.info("=> Saving Address: " + address.toString());
        return addressService.salvar(address);
    }

}