package com.example.inventory.Models;

import jakarta.persistence.*;

@Entity
@Table(name="orders") // Change the table name to "orders" (or any other valid name)
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id") // Change the column name to "customer_id" (or any other valid name)
    private Customer customer;

    // Other attributes and methods
}

