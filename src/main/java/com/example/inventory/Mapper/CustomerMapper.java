package com.example.inventory.Mapper;

import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.ItemDto;
import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Item;

import java.util.List;

public class CustomerMapper{

    public static CustomerDto mapToDTO(Customer customerRequest){
        CustomerDto customer=new CustomerDto();
        customer.setId(customerRequest.getId());
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhone_number(customerRequest.getPhone_number());
        return customer;
    }
    public static Customer ToEntity(CustomerDto customerRequest){
      return Customer.builder().name(customerRequest.getName())
                .email(customerRequest.getEmail()).
              phone_number(customerRequest.getPhone_number())
              .build();

    }
    public static void update (Customer customerById , CustomerDto requestedCustomer) {
        customerById.setName(requestedCustomer.getName());
        customerById.setEmail(requestedCustomer.getEmail());
        customerById.setPhone_number(requestedCustomer.getPhone_number());

    }

}