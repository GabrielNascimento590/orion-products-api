package com.example.Orion.controller;

import com.example.Orion.dto.OrderDto;
import com.example.Orion.dto.ProductDto;
import com.example.Orion.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService=orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrder() {
        List<OrderDto> orders = orderService.getAllDto();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderByid(@PathVariable Long id) {
        OrderDto orders = orderService.getOrderByid(id);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrders(@RequestBody OrderDto orderDto) {
        OrderDto createorders=orderService.createorder(orderDto);
        return ResponseEntity.ok(createorders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateorders(@PathVariable Long id , @RequestBody OrderDto orderDto) {
        OrderDto updateorders=orderService.updateOrder(id, orderDto);
        return ResponseEntity.ok(updateorders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }





}


