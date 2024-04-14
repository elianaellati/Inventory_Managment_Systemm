package com.example.inventory.Controller;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {
 ItemService itemservice;
    @Autowired
   public ItemController( ItemService itemservice){
     this.itemservice=itemservice;
 }
    @GetMapping("")
    public List<ItemDto>retrieveItems(){
     return itemservice.retrieveItems();
 }
    @GetMapping("/{id}")
    public ItemDto retrieveItemById(@PathVariable Long id){
        return itemservice.retrieveItemById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnItem(@PathVariable Long id){
        return itemservice.deleteAnItem(id);
    }
    @PutMapping("/{id}")
    public ItemDto updateItem(@PathVariable Long id,@RequestBody ItemDto request){
        return itemservice.updateItem(id,request);
    }
    @GetMapping("/{id}/orders")
    public List<OrderDto>retrieveOrdersForItem(@PathVariable Long id ){
        return itemservice.retrieveOrdersForItem(id);
    }

}
