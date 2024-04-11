package com.example.inventory.services;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.OrderDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.Mapper.ItemMapper;
import com.example.inventory.Mapper.OrderMapper;
import com.example.inventory.Mapper.SupplierMapper;
import com.example.inventory.Models.Item;
import com.example.inventory.Models.Order;
import com.example.inventory.Models.Supplier;
import com.example.inventory.Repository.OrderRepository;
import com.example.inventory.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {

        this.supplierRepository=supplierRepository;
    }


    public List<SupplierDto> retrieveSuppliers() {
        List<Supplier> suppliers=supplierRepository.findAll();
        return suppliers.stream().map(supplier -> SupplierMapper.mapToDTO(supplier)).collect(Collectors.toList());

    }
    public ResponseEntity<?> addNewSuppliers(SupplierDto supplierRequest) {
       Supplier saveSupplier=  SupplierMapper.toEntity(supplierRequest);
     return ResponseEntity.ok(supplierRepository.save( saveSupplier));

    }
  public SupplierDto retrieveSupplierById(long id) {
        Supplier supplierByid  = supplierRepository.findAllById(id);
        return SupplierMapper.mapToDTO(supplierByid);
    }
    public ResponseEntity<?> deleteAnSupplier(long id) {
        supplierRepository.deleteById(id);
        return ResponseEntity.ok("Successfully deleted");
    }
    public ResponseEntity<?> updateSupplier(SupplierDto supplier,long id) {
        Supplier supplierToUpdate=supplierRepository.findAllById(id);
        if(supplierToUpdate!=null){
        SupplierMapper.update(supplierToUpdate,supplier);
        supplierRepository.save(supplierToUpdate);
            return ResponseEntity.ok("Successfully updated");
        }
        return ResponseEntity.ok("Failed To Update");
    }
   public ResponseEntity<?> saveItemsForSupplier(ItemDto item,Long id){
       Supplier supplierById=supplierRepository.findAllById(id);
       Item itemToAdd=ItemMapper.toEntity(item,supplierById);
       supplierById.getItemlist().add(itemToAdd);
       supplierRepository.save(supplierById);
       return ResponseEntity.ok(itemToAdd);
   }
   public List<ItemDto> retriveItemsForSupplier(Long id){
        Supplier supplierById=supplierRepository.findAllById(id);
        List<Item>itemList=supplierById.getItemlist();
        return itemList.stream().map(item -> ItemMapper.mapToDTO(item)).collect(Collectors.toList());
   }

}
