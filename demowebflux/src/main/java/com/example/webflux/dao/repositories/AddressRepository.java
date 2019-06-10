package com.example.webflux.dao.repositories;

import com.example.webflux.dao.models.Address;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AddressRepository extends ReactiveCrudRepository<Address,Integer> {
    
    @Query("select * from addresses")
    Flux<Address> findAddresses();
}
