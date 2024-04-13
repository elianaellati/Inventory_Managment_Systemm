package com.example.inventory.Mapper;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.Models.Item;
import com.example.inventory.Models.Supplier;

public class ItemMapper {
    public static ItemDto mapToDTO(Item itemRequest){
        ItemDto item=new ItemDto();
        item.setId(itemRequest.getId());
        item.setItem_name(itemRequest.getItem_name());
        item.setPrice(itemRequest.getPrice());
        item.setQuantity(itemRequest.getQuantity());
        return item;
    }
    public static Item toEntity(ItemDto item,Supplier supplier) {
        return Item.builder()
                .item_name(item.getItem_name())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .supplier_id(supplier)
                .build();
    }
    public static void update (Item oldItem ,ItemDto item) {
        oldItem.setItem_name(item.getItem_name());
        oldItem.setQuantity(item.getQuantity());
        oldItem.setPrice(item.getPrice());
    }
}
