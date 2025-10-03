package com.example.Orion.controller;

import com.example.Orion.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Product")
public class ProductController {
    private final Product product;

    public ProductController(Product product) {
        this.product=product;
    }
}
