package com.example.inventory.Mapper;

import com.example.inventory.DTO.CustomerDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Order;
import com.example.inventory.Models.Order_item;
import com.example.inventory.Models.Supplier;

import java.util.List;

public class OrderMapper {
    public static OrderDto mapToDTO(Order orderRequest){
        OrderDto order=new OrderDto();
        order.setId(orderRequest.getId());
        order.setStatus(orderRequest.getStatus());
        order.setTotal_price(orderRequest.getTotal_price());
        order.setOrder_date(orderRequest.getOrder_date());
        return order;
    }

    public static Order toEntity(OrderDto orderRequest , Customer customer) {

        return Order.builder()
                .order_date(orderRequest.getOrder_date())
                .status(orderRequest.getStatus())
                .total_price(orderRequest.getTotal_price())
                .customer_id(customer)
                .build();
    }
    public static void update (Order oldOrder, OrderDto order) {
        oldOrder.setOrder_date(order.getOrder_date());
        oldOrder.setStatus(order.getStatus());
    }
}
