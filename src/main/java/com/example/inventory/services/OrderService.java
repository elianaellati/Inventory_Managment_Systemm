package com.example.inventory.services;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.Order_itemDto;
import com.example.inventory.Models.OrderStatus;
import com.example.inventory.services.Impl.OrderServiceImpl;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService  {
    List<OrderDto> retrieveOrders();
    OrderDto retrieveOrderById(long id);
    ResponseEntity<?> deleteOrderBy(long id);
    ResponseEntity<?> addItemsForOrder(Order_itemDto itemRequest);
    List<ItemDto> retrieveItemsBySpecificOrder(Long id);
    OrderDto updateAnOrder(Long id,OrderDto orderDto);
    List<OrderDto>retrieveOrdersBySpecificStatus(OrderStatus status);


}
