package com.example.Orion.service;

import com.example.Orion.model.Order;
import com.example.Orion.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getAllByid(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Long id, Order orderdetails) {
        Order order = getAllByid(id);
        order.setDate(orderdetails.getDate());
        order.setTotal(orderdetails.getTotal());
        order.setStatus(orderdetails.getStatus());
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        Order order=getAllByid(id);
        orderRepository.delete(order);
}

}


