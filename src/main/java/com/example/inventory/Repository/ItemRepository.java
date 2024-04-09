package com.example.inventory.Repository;

import com.example.inventory.Models.Item;
import com.example.inventory.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findAllById(Long id);
}
