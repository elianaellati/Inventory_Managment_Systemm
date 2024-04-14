package com.example.inventory.Mapper;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.Order_itemDto;
import com.example.inventory.Models.Item;
import com.example.inventory.Models.Order;
import com.example.inventory.Models.Order_item;
import com.example.inventory.Models.Supplier;

public class Order_itemMapper {
    public static Order_item toEntity(Item item, Order order, Order_itemDto request) {

        return Order_item.builder()
                .item_id(item)
                .order_id(order)
                .quantity(request.getQuantity())
                .build();
    }

    public static ItemDto mapToDTO(Order_item request){
        ItemDto item=new ItemDto();
        item.setId(request.getItem_id().getId());
        item.setItem_name(request.getItem_id().getItem_name());
        item.setPrice(request.getItem_id().getPrice());
        item.setQuantity(request.getQuantity());
        return item;
    }
    public static OrderDto mapToDTOOrder(Order_item request){
        OrderDto order=new OrderDto();
        order.setId(request.getOrder_id().getId());
        order.setOrder_date(request.getOrder_id().getOrder_date());
        order.setStatus(request.getOrder_id().getStatus());
        order.setTotal_price(request.getOrder_id().getTotal_price());
        return order;
    }
}
