package com.example.inventory.Repository;

import com.example.inventory.Models.Order;
import com.example.inventory.Models.Order_item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_itemRepository extends JpaRepository<Order_item, Long> {

}
