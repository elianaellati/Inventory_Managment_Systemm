package com.example.inventory.services;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.Mapper.ItemMapper;
import com.example.inventory.Mapper.SupplierMapper;
import com.example.inventory.Models.Item;
import com.example.inventory.Models.Supplier;
import com.example.inventory.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ItemService {
    ItemRepository itemRepository;
    @Autowired
    public ItemService (ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    public List<ItemDto> retrieveItems() {
        List<Item> items=itemRepository.findAll();
        return items.stream().map(item -> ItemMapper.mapToDTO(item)).collect(Collectors.toList());
    }
    public ItemDto retrieveItemById(long id) {
        Item itemByid  = itemRepository.findAllById(id);
        return ItemMapper.mapToDTO(itemByid);
    }
    public ResponseEntity<?> deleteAnItem(long id) {
       itemRepository.deleteById(id);
        return ResponseEntity.ok("Successfully deleted");
    }


}
