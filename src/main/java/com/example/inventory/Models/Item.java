package com.example.inventory.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="id")
    private Long id;

    @Column(name="item_name")
    private String item_name;

    @Column(name="quantity")
    private double quantity;

    @Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    @JsonBackReference
    private Supplier supplier_id;

    @OneToMany(mappedBy = "item_id", cascade = {CascadeType.ALL})
    private List<Order_item> order_items;

}
