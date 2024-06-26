package com.example.inventory.services;

import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.Models.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    CustomerDto saveNewCustomer(CustomerDto customerRequest);
    List<CustomerDto> retrieveCustomers();
    CustomerDto findCustomerById(long id);
    CustomerDto updateCustomerById(long id,CustomerDto requestedCustomer);
    ResponseEntity<?> deleteCustomerById(long id);
     ResponseEntity<?> addOrderForSpecificCustomer(Long id, OrderDto orderRequest);
    List<OrderDto> retrieveOrderForSpecificCustomer(Long id);

}
