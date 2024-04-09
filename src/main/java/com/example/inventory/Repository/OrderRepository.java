package com.example.inventory.Repository;

import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
   Order findAllById(long id);
}
