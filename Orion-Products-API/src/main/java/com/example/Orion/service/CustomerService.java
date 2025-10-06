package com.example.Orion.service;

import com.example.Orion.model.Customer;
import com.example.Orion.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getAllByid(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer update(Long id ,Customer customerdetails) {
        Customer customer=getAllByid(id);
        customer.setNome(customerdetails.getNome());
        customer.setEmail(customerdetails.getEmail());
        customer.setPhone(customerdetails.getPhone());
        return customerRepository.save(customer);
    }
    public void delete (Long id) {
        Customer customer=getAllByid(id);
        customerRepository.delete(customer);
    }
}
