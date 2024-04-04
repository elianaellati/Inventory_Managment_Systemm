package com.example.inventory.Controller;

import com.example.inventory.Models.Customer;
import com.example.inventory.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> findAllCustomer(){
        return customerService.findAllCustomer();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }
    @PostMapping("")
    public ResponseEntity<?> saveNewCustomer(@RequestBody Customer customer){
        return customerService.saveNewCustomer(customer);
    }

}
