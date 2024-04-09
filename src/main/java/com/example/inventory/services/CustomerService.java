package com.example.inventory.services;

import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.Mapper.CustomerMapper;
import com.example.inventory.Mapper.OrderMapper;
import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Order;
import com.example.inventory.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public ResponseEntity<?> saveNewCustomer(Customer customerRequest) {
        Customer customerToSave = Customer.builder().name(customerRequest.getName())
                .email(customerRequest.getEmail()).phone_number(customerRequest.getPhone_number()).build();
        customerRepository.save(customerToSave);
        return ResponseEntity.ok(customerToSave);
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
    public ResponseEntity<?> updateCustomerById(long id,Customer requestedCustomer) {
        Customer customerById = customerRepository.findAllById(id);
        if(customerById!=null){
            customerById.setName(requestedCustomer.getName());
            customerById.setEmail(requestedCustomer.getEmail());
            customerById.setPhone_number(requestedCustomer.getPhone_number());
            customerRepository.save(customerById);
        }else{
            return ResponseEntity.ok("Customer Not Found");
        }
        return ResponseEntity.ok(customerById);
    }

    public ResponseEntity<?> addOrderForSpecificCustomer(Long id,OrderDto orderRequest) {
        Customer customerById = customerRepository.findAllById(id);
        if(customerById!=null){
            Order orderToAdd= OrderMapper.toEntity(orderRequest,customerById);
            customerById.getOrderlist().add(orderToAdd);
            customerById= customerRepository.save(customerById);
            System.out.print("Eliana"+customerById.getOrderlist());
            System.out.print("ElianaEEEEE"+orderToAdd.getStatus());
        }
        else{
            return ResponseEntity.ok("Customer Not Found");
        }
        return ResponseEntity.ok(customerById);
    }
    public List<OrderDto> retrieveOrderForSpecificCustomer(Long id) {
        Customer customerById = customerRepository.findAllById(id);
        List<Order>orders=customerById.getOrderlist();
        return orders.stream().map(order -> OrderMapper.mapToDTO(order)).collect(Collectors.toList());

    }

}
