package com.example.inventory.Repository;

import com.example.inventory.Models.Order;
import com.example.inventory.Models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
  Supplier findAllById(long id);

}
