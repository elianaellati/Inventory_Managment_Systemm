package com.example.inventory.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name="suppliers")
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phone_number;

    @OneToMany(mappedBy = "supplier_id",cascade ={CascadeType.ALL})
    private List<Item> itemlist;

}
