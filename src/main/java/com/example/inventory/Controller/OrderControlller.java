package com.example.inventory.Controller;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.Order_itemDto;
import com.example.inventory.Models.OrderStatus;
import com.example.inventory.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderControlller {
    OrderService orderService;
    @Autowired
    public OrderControlller( OrderService orderService) {

        this.orderService = orderService;
    }
    @GetMapping("")
    public List<OrderDto> retrieveOrders(){

        return orderService.retrieveOrders();
    }
    @GetMapping("/{id}")
    public OrderDto retrieveOrderById(@PathVariable Long id){
        return orderService.retrieveOrderById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        return orderService.deleteOrderBy(id);
    }

    @PostMapping("/items")
    public ResponseEntity<?> addItemsForOrder(@RequestBody Order_itemDto requestedBody){
        return orderService.addItemsForOrder(requestedBody);
    }
    @PutMapping("/{id}")
    public OrderDto updateAnOrder(@PathVariable Long id,@RequestBody OrderDto request){
        return orderService.updateAnOrder(id,request);
    }
    @GetMapping("/{id}/items")
    public List<ItemDto>retrieveItemsBySpecificOrder(@PathVariable Long id){
        return orderService.retrieveItemsBySpecificOrder(id);
    }
    @GetMapping("/status/{status}")
    public List<OrderDto>retrieveOrdersBySpecificStatus(@PathVariable OrderStatus status){
   return orderService.retrieveOrdersBySpecificStatus(status);
    }


}
