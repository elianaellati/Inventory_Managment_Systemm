package com.example.inventory.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    /*public customer( String FirstName,String LastName, String customer_email) {
        this.first_name=FirstName;
        this.last_name=LastName;
        this.email = customer_email;
    }*/
    @Column(name="first_name")
    private String first_name;

    @OneToMany(mappedBy = "customer")
    private List <order> orderlist;







    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;


}
