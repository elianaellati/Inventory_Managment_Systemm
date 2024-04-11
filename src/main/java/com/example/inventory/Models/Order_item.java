package com.example.inventory.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name="order_item")
@NoArgsConstructor
@AllArgsConstructor
public class Order_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order_id;


    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item_id;


    @Column(name="quantity")
    private double quantity;


}
