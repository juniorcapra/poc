package com.example.webflux.dao.repositories;

import com.example.webflux.dao.models.Product;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

    @Query("select * from products where id = 1")
    Mono<Product> findFirstProduct();

}