package com.example.inventory.services.Impl;


import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.Exceptions.ResourceNotFound;
import com.example.inventory.Mapper.CustomerMapper;
import com.example.inventory.Mapper.OrderMapper;
import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Order;
import com.example.inventory.Repository.CustomerRepository;
import com.example.inventory.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public CustomerDto saveNewCustomer(CustomerDto customerRequest) {
        Customer customerToSave = CustomerMapper.ToEntity(customerRequest);
        customerRepository.save(customerToSave);
        return  CustomerMapper.mapToDTO( customerToSave);
    }

    public List<CustomerDto> retrieveCustomers() {
        List<Customer> allCustomer = customerRepository.findAll();
        return allCustomer.stream().map(customer -> CustomerMapper.mapToDTO(customer)).collect(Collectors.toList());

    }

    public CustomerDto findCustomerById(long id) {
        Customer customerById = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        return CustomerMapper.mapToDTO(customerById);
    }
    public ResponseEntity<?> deleteCustomerById(long id) {
        Customer customerById = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        customerRepository.delete(customerById);
        return ResponseEntity.ok("Successfully deleted");
    }
    public CustomerDto updateCustomerById(long id,CustomerDto requestedCustomer) {
        Customer customerById = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        CustomerMapper.update(customerById,requestedCustomer);
        customerRepository.save(customerById);
        return CustomerMapper.mapToDTO(customerById);
    }

    public OrderDto addOrderForSpecificCustomer(Long id,OrderDto orderRequest) {
        Customer customerById = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
            Order orderToAdd= OrderMapper.toEntity(orderRequest,customerById);
            customerById.getOrderlist().add(orderToAdd);
            customerRepository.save(customerById);
        return OrderMapper.mapToDTO(orderToAdd);
    }
    public List<OrderDto> retrieveOrderForSpecificCustomer(Long id) {
        Customer customerById = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        List<Order>orders=customerById.getOrderlist();
        return orders.stream().map(order -> OrderMapper.mapToDTO(order)).collect(Collectors.toList());

    }


}
