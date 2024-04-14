package com.example.inventory.services.Impl;



import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.Exceptions.ResourceNotFound;
import com.example.inventory.Mapper.ItemMapper;
import com.example.inventory.Mapper.Order_itemMapper;
import com.example.inventory.Mapper.SupplierMapper;
import com.example.inventory.Models.Item;
import com.example.inventory.Models.Order;
import com.example.inventory.Models.Order_item;
import com.example.inventory.Models.Supplier;
import com.example.inventory.Repository.ItemRepository;
import com.example.inventory.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;
    @Autowired
    public ItemServiceImpl (ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    public List<ItemDto> retrieveItems() {
        List<Item> items=itemRepository.findAll();
        return items.stream().map(item -> ItemMapper.mapToDTO(item)).collect(Collectors.toList());
    }
    public ItemDto retrieveItemById(long id) {
        Item itemByid  = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        return ItemMapper.mapToDTO(itemByid);
    }
    public ResponseEntity<?> deleteAnItem(long id) {
        Item itemByid  = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        itemRepository.delete(itemByid);
        return ResponseEntity.ok("Successfully deleted");
    }
    public List<OrderDto>  retrieveOrdersForItem(Long id){
        Item itemByid  = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        List<Order_item> orderForAnItem=itemByid.getOrder_items();
        return orderForAnItem.stream().map(order -> Order_itemMapper.mapToDTOOrder(order)).collect(Collectors.toList());
    }
    public ItemDto updateItem(Long id,ItemDto request){
        Item itemByid  = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        ItemMapper.update(itemByid,request);
        itemRepository.save(itemByid);
        return ItemMapper.mapToDTO(itemByid );
    }

}
