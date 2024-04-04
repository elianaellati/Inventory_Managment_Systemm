package com.example.inventory.services;

import com.example.inventory.Models.Customer;
import com.example.inventory.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<?> saveNewCustomer(Customer customerRequest) {
        Customer customerToSave = Customer.builder().first_name(customerRequest.getFirst_name()).last_name(customerRequest
                .getLast_name()).email(customerRequest.getEmail()).build();
        // )
        // customer customerToSave= new customer(customerRequest.getFirst_name(),customerRequest.getLast_name(),customerRequest.getEmail());
        customerRepository.save(customerToSave);
        return ResponseEntity.ok(customerToSave);
    }

    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> allCustomer = customerRepository.findAll();
        return ResponseEntity.ok(allCustomer);
    }

    public ResponseEntity<Customer> findCustomerById(long id) {
        Customer customerById = customerRepository.findAllById(id);
        return ResponseEntity.ok(customerById);
    }

}
