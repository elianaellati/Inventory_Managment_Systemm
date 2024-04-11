package com.example.inventory.Controller;

import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.Models.Customer;
import com.example.inventory.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("")
    public List<CustomerDto> retrieveCustomers(){
        return customerService.retrieveCustomers();
    }
    @PostMapping("")
    public CustomerDto addCustomer(@RequestBody CustomerDto customer){
        return customerService.saveNewCustomer(customer);
    }
    @GetMapping("/{id}")
    public CustomerDto retrieveCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomerById(id);
    }
    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id,@RequestBody Customer updatedCustomer){
        return customerService.updateCustomerById(id,updatedCustomer);
    }
    @PostMapping("/{id}/orders")
    public OrderDto addOrderForSpecificCustomer(@PathVariable Long id, @RequestBody OrderDto orderRequest){
        return customerService.addOrderForSpecificCustomer(id,orderRequest);
    }
    @GetMapping("/{id}/orders")
    public List<OrderDto> retrieveOrderForSpecificCustomer(@PathVariable Long id){
        return customerService.retrieveOrderForSpecificCustomer(id);
    }



}
