package com.example.webflux.controllers;

import com.example.webflux.dao.models.Address;
import com.example.webflux.dao.repositories.AddressCustomerRepositoryImpl;
import com.example.webflux.dao.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

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
    public Flux<Map<String, Object>> findaAll() {
        return addressCustomerRepository.buscarAdd();
    }

    @PostMapping(path = "/new")
    public Mono<Address> save(@RequestBody Address address) {
        return addressRepository.save(address);
    }

}
