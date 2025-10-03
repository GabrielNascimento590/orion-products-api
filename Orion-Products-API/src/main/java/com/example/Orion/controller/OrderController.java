package com.example.Orion.controller;

import com.example.Orion.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {
    private final Order order;

    public OrderController(Order order){
        this.order=order;
    }
}
