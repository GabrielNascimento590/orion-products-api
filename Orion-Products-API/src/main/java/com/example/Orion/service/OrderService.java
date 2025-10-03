package com.example.Orion.service;

import com.example.Orion.model.Order;
import com.example.Orion.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }


}
