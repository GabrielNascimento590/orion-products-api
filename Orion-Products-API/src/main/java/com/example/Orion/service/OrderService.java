package com.example.Orion.service;

import com.example.Orion.dto.OrderDto;
import com.example.Orion.dto.ProductDto;
import com.example.Orion.dto.mapper.OrderMapper;
import com.example.Orion.model.Order;
import com.example.Orion.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository=orderRepository;
        this.orderMapper=orderMapper;
    }

    public List<OrderDto> getAllDto() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    public OrderDto getOrderByid(Long id){
        Order order= orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDto(order);
    }


    public OrderDto createorder(OrderDto orderDto) {
        Order order=orderMapper.toEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);

    }

    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setStatus(orderDto.getStatus());
        existingOrder.setDate(orderDto.getDate());
        existingOrder.setTotal(orderDto.getTotal());

        Order updateOrder = orderRepository.save(existingOrder);
        return orderMapper.toDto(updateOrder);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }



    }









