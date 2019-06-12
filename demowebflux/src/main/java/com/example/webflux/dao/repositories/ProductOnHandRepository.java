package com.example.webflux.dao.repositories;

import com.example.webflux.dao.models.ProductOnHand;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductOnHandRepository extends ReactiveCrudRepository<ProductOnHand, Integer> {

    @Query("select * from products_on_hand where id = 1")
    Mono<ProductOnHand> findFirstProductsOnHand();

}