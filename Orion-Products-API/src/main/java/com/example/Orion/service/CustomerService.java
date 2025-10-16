package com.example.Orion.service;

import com.example.Orion.dto.CustomerDto;
import com.example.Orion.dto.mapper.CustomerMapper;
import com.example.Orion.model.Customer;
import com.example.Orion.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository ,CustomerMapper customerMapper) {
        this.customerRepository=customerRepository;
        this.customerMapper=customerMapper;
    }

    public List<CustomerDto> getall() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    public CustomerDto getcustomerByid(Long id) {
        Customer customer=customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toDto(customer);
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer=customerMapper.toEntity(customerDto);
        Customer savedCustomer=customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    public CustomerDto updateCustomer(Long id, CustomerDto customerDto){
        Customer existingCustomer=customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer Not Found"));

        existingCustomer.setNome(customerDto.getName());
        existingCustomer.setEmail(customerDto.getEmail());

        Customer updateCustomer= customerRepository.save(existingCustomer);
        return customerMapper.toDto(updateCustomer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer Not found");
        }
        customerRepository.deleteById(id);
    }



}


