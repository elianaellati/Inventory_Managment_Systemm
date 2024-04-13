package com.example.inventory.services;

import com.example.inventory.DTO.ItemDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    List<ItemDto> retrieveItems();
    ItemDto retrieveItemById(long id);
    ResponseEntity<?> deleteAnItem(long id);

}
