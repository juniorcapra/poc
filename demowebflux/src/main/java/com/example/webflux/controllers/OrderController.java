package com.example.webflux.controllers;

import com.example.webflux.dao.models.Order;
import com.example.webflux.dao.repositories.OrderRepository;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    public OrderController() {
    }

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Order> findaAll() {
        log.info("=> Listing all Orders ...");
        return orderRepository.findAll();
    }

    @GetMapping(path = "/firstOrder")
    public Mono<Order> findFirstOrder() {
        log.info("=> Listing Order where ID equal 1 ...");
        return orderRepository.findFirstOrder();
    }

    @PostMapping(path = "/new")
    public Mono<Order> save(@RequestBody Order order) {
        log.info("=> Saving Order: " + order.toString());
        return orderRepository.save(order);
    }

}