package com.example.webflux.dao.services;

import com.example.webflux.dao.models.Address;
import com.example.webflux.dao.models.Customer;
import com.example.webflux.dao.repositories.AddressRepository;
import com.example.webflux.dao.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class CustomerServiceImpl {

    public CustomerServiceImpl() {
    }



    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private AddressRepository addressRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }


    /**
     * Salva customer e o address que estiver relacionado
     *
     * @param customer
     * @return
     */
    public Mono<Customer> salvar(Customer customer) {

        Mono<Customer> save = customerRepository.save(customer);

        return save.flatMap((customerSaved -> {
            Address address = customerSaved.getAddress();
            if (address != null) {
                address.setCustomerId(customerSaved.getId());
            }
            return addressRepository.save(address).flatMap(addressSaved -> Mono.just(customerSaved));
        }));
    }


    /**
     * Buscar todos os customers
     *
     * @return
     */
     public Flux<Customer> buscarTodos() {
        return customerRepository.findAll();
    }


    /**
     * @return
     */
    public Mono<Long> contarCustomers() {
        return customerRepository.count();
    }


}
