package com.example.Orion.dto.mapper;

import com.example.Orion.dto.CustomerDto;
import com.example.Orion.model.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity (CustomerDto dto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(dto,customer);
        return customer;
    }

    public CustomerDto toDto(Customer customer) {
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customer ,customerDto);
        return customerDto;
    }
}
