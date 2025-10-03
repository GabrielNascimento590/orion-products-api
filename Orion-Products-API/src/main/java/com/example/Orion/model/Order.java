package com.example.Orion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Order")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private String Status;
    private BigDecimal total;

    @OneToMany(mappedBy = "Order" , cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();
}
