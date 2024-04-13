package com.example.inventory.services;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    List<ItemDto> retrieveItems();
    ItemDto retrieveItemById(long id);
    ResponseEntity<?> deleteAnItem(long id);
    List<OrderDto>  retrieveOrdersForItem(Long id);

    ItemDto updateItem(Long id,ItemDto request);
}
