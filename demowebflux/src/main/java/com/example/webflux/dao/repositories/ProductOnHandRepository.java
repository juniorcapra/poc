package com.example.webflux.dao.repositories;

import com.example.webflux.dao.models.ProductOnHand;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductOnHandRepository extends ReactiveCrudRepository<ProductOnHand, Integer> {

    @Query("select * from inventory.products_on_hand")
    Flux<ProductOnHand> findProductsOnHand();
}
