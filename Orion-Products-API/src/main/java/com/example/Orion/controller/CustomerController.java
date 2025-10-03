package com.example.Orion.controller;

import com.example.Orion.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    private final Customer customer;

    public CustomerController(Customer customer) {
        this.customer=customer;
    }
}
