package com.example.inventory.services;

import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.Mapper.CustomerMapper;
import com.example.inventory.Mapper.OrderMapper;
import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Order;
import com.example.inventory.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository =orderRepository ;
    }



    public List<OrderDto> retrieveOrders() {
       List<Order> orders=orderRepository.findAll();
        return orders.stream().map(order -> OrderMapper.mapToDTO(order)).collect(Collectors.toList());

    }
    public OrderDto retrieveOrderById(long id) {
        Order OrderById = orderRepository.findAllById(id);
        return OrderMapper.mapToDTO(OrderById);
    }
    public ResponseEntity<?> deleteOrderBy(long id) {
        orderRepository.deleteById(id);
        return ResponseEntity.ok("Successfully deleted");
    }


}
