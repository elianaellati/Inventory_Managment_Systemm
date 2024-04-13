package com.example.inventory.services.Impl;


import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.OrderDto;
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
        Customer customerById = customerRepository.findAllById(id);
        return CustomerMapper.mapToDTO(customerById);
    }
    public ResponseEntity<?> deleteCustomerById(long id) {
        customerRepository.deleteById(id);
        return ResponseEntity.ok("Successfully deleted");
    }
    public CustomerDto updateCustomerById(long id,Customer requestedCustomer) {
        Customer customerById = customerRepository.findAllById(id);
        if(customerById!=null){
            customerById.setName(requestedCustomer.getName());
            customerById.setEmail(requestedCustomer.getEmail());
            customerById.setPhone_number(requestedCustomer.getPhone_number());
            customerRepository.save(customerById);
        }
        return CustomerMapper.mapToDTO(customerById);
    }

    public OrderDto addOrderForSpecificCustomer(Long id,OrderDto orderRequest) {
        Customer customerById = customerRepository.findAllById(id);

            Order orderToAdd= OrderMapper.toEntity(orderRequest,customerById);
            customerById.getOrderlist().add(orderToAdd);
            customerRepository.save(customerById);
        return OrderMapper.mapToDTO(orderToAdd);
    }
    public List<OrderDto> retrieveOrderForSpecificCustomer(Long id) {
        Customer customerById = customerRepository.findAllById(id);
        List<Order>orders=customerById.getOrderlist();
        return orders.stream().map(order -> OrderMapper.mapToDTO(order)).collect(Collectors.toList());

    }


}
