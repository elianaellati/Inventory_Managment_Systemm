package com.example.inventory.Mapper;

import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.Models.Customer;
import com.example.inventory.Models.Order;
import com.example.inventory.Models.Supplier;

public class SupplierMapper {
    public static SupplierDto mapToDTO(Supplier supplierRequest){
       SupplierDto supplier =new SupplierDto();
        supplier.setId(supplierRequest.getId());
        supplier.setAddress(supplierRequest.getAddress());
        supplier.setName((supplierRequest.getName()));
        supplier.setPhone_number(supplierRequest.getPhone_number());
        return supplier;
    }
    public static Supplier toEntity(SupplierDto supplier) {
        return Supplier.builder()
                .name(supplier.getName())
                .address(supplier.getAddress())
                .phone_number(supplier.getPhone_number())
                .build();
    }
    public static void update (Supplier oldSupplier,SupplierDto supplier) {
        oldSupplier.setName(supplier.getName());
        oldSupplier.setAddress(supplier.getAddress());
        oldSupplier.setPhone_number(supplier.getPhone_number());
    }
}
