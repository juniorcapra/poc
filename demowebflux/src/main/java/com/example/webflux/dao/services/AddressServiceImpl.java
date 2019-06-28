package com.example.webflux.dao.services;

import com.example.webflux.dao.models.Address;
import com.example.webflux.dao.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AddressServiceImpl {


    @Autowired
    private AddressRepository addressRepository;

    public AddressServiceImpl() {
    }


    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }



    /**
     *
     * @return
     */
    public Flux<Address> buscarTodos() {
       return addressRepository.findAll();
    }


    /**
     *
     * @param address
     * @return
     */
    public Mono<Address> salvar(@RequestBody Address address) {
        return addressRepository.save(address);
    }


}
