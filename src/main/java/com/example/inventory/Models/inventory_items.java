package com.example.inventory.Models;

import jakarta.persistence.*;

@Entity
@Table(name="inventory_items")
public class inventory_items {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="item_name")
    private String item_name;

    public inventory_items(int id, String item_name, double quantity, double price) {
        this.id = id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.price = price;
    }

    @Column(name="quantity")
    private double quantity;
    @Column(name="price")
    private double price;

    public inventory_items() {

    }
}
