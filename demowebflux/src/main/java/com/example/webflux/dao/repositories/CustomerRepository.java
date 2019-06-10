package com.example.webflux.dao.repositories;

import com.example.webflux.dao.models.Customer;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {

    @Query("select * from customers")
    Flux<Customer> findCustomers();

    @Query("select * from customers where first_name like 'J%'")
    Flux<Customer> findCustomersStartWithJ();
}