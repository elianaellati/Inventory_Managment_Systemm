package com.example.inventory.Repository;

import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Order;
import com.example.inventory.Models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
   Order findAllById(long id);
   List<Order> findOrderByStatus(OrderStatus status);
}
