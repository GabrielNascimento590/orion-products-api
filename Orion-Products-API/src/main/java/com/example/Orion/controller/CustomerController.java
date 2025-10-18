package com.example.Orion.controller;

import com.example.Orion.dto.CustomerDto;
import com.example.Orion.dto.ProductDto;
import com.example.Orion.model.Customer;
import com.example.Orion.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers=customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getByid(@PathVariable Long id) {
        CustomerDto customers =customerService.getcustomerByid(id);
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomers(@RequestBody CustomerDto customerDto) {
        CustomerDto createdcustomers=customerService.createCustomer(customerDto);
        return ResponseEntity.ok(createdcustomers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomers(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto updateCustomers=customerService.updateCustomer(id,customerDto);
        return ResponseEntity.ok(updateCustomers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }



}
