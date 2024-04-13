package com.example.inventory.services;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.SupplierDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {
    List<SupplierDto> retrieveSuppliers();
    SupplierDto addNewSuppliers(SupplierDto supplierRequest);
    SupplierDto retrieveSupplierById(long id);
    ResponseEntity<?> deleteAnSupplier(long id);
    SupplierDto updateSupplier(SupplierDto supplier,long id);
    ResponseEntity<?> saveItemsForSupplier(ItemDto item, Long id);
    List<ItemDto> retriveItemsForSupplier(Long id);


}
