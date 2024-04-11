package com.example.inventory.services.Impl;

import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.Order_itemDto;
import com.example.inventory.Mapper.CustomerMapper;
import com.example.inventory.Mapper.ItemMapper;
import com.example.inventory.Mapper.OrderMapper;
import com.example.inventory.Mapper.Order_itemMapper;
import com.example.inventory.Models.*;
import com.example.inventory.Repository.ItemRepository;
import com.example.inventory.Repository.OrderRepository;
import com.example.inventory.Repository.Order_itemRepository;
import com.example.inventory.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ItemRepository itemRepository;
    Order_itemRepository   order_itemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,ItemRepository itemRepository, Order_itemRepository order_itemRepository) {
        this.orderRepository =orderRepository ;
        this.itemRepository=itemRepository;
        this.order_itemRepository=order_itemRepository;
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

    public ResponseEntity<?> addItemsForOrder(Order_itemDto itemRequest){
        Order orderbyid=orderRepository.findAllById(itemRequest.getOrder_id());
        Item itembyid=itemRepository.findAllById(itemRequest.getItem_id());
        Order_item itemstoadd=Order_itemMapper.toEntity(itembyid,orderbyid,itemRequest);
        order_itemRepository.save(itemstoadd);
        orderbyid.getOrder_items().add(itemstoadd);
        itembyid.getOrder_items().add(itemstoadd);
        orderbyid=calculeTotalPrice(orderbyid);
        orderRepository.save(orderbyid);
        itemRepository.save(itembyid);
        return ResponseEntity.ok("Successful");
    }
    public static Order calculeTotalPrice(Order orderRequest){
        List<Order_item> allItems=orderRequest.getOrder_items();
        double totalprice=0;
        for(int i=0;i<allItems.size();++i){
            totalprice=totalprice+allItems.get(i).getItem_id().getPrice()*allItems.get(i).getQuantity();
        }
        orderRequest.setTotal_price(totalprice);
        return orderRequest;
    }
    public List<ItemDto> retrieveItemsBySpecificOrder(Long id){
        Order orderbyid=orderRepository.findAllById(id);
        List<Order_item> itemsForAnOrder=orderbyid.getOrder_items();
        return itemsForAnOrder.stream().map(item -> Order_itemMapper.mapToDTO(item)).collect(Collectors.toList());
    }

}
