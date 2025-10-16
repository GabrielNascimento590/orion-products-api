package com.example.Orion.dto.mapper;

import com.example.Orion.dto.OrderDto;
import com.example.Orion.model.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order toEntity(OrderDto dto) {
        Order order= new Order();
        BeanUtils.copyProperties(this , order);
        return order;
    }

    public OrderDto toDto(Order order) {
        OrderDto orderDto= new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }
}
