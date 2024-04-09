package com.example.inventory.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="order_date")
    private Date order_date;

    @Column(name="total_price")
    private double total_price;

    @Enumerated()
    @Column(name = "status", nullable = false)
    private com.example.inventory.Models.OrderStatus status = com.example.inventory.Models.OrderStatus.Pending;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="customer_id")
    private Customer customer_id;

}

