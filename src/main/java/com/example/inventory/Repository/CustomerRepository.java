package com.example.inventory.Repository;

import com.example.inventory.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   Customer findAllById(long id);
}
