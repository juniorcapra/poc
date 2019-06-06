package com.example.webflux.controllers;

import com.example.webflux.dao.models.Order;
import com.example.webflux.dao.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/inventory.order")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(path = "/all")
    public Flux<Order> findaAll() { return orderRepository.findAll(); }

    @PostMapping(path = "/new")
    public Mono<Order> save(@RequestBody Order order) {
        return orderRepository.save(order);
    }

}