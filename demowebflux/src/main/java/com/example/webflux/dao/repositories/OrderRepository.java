package com.example.webflux.dao.repositories;

import com.example.webflux.dao.models.Order;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, Integer> {

    @Query("select * from inventory.orders")
    Flux<Order> findOrders();
}
