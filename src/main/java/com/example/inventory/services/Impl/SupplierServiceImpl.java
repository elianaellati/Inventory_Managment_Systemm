package com.example.inventory.services.Impl;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.Exceptions.ResourceNotFound;
import com.example.inventory.Mapper.ItemMapper;
import com.example.inventory.Mapper.SupplierMapper;
import com.example.inventory.Models.Item;
import com.example.inventory.Models.Supplier;
import com.example.inventory.Repository.SupplierRepository;
import com.example.inventory.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {

        this.supplierRepository=supplierRepository;
    }


    public List<SupplierDto> retrieveSuppliers() {
        List<Supplier> suppliers=supplierRepository.findAll();
        return suppliers.stream().map(supplier -> SupplierMapper.mapToDTO(supplier)).collect(Collectors.toList());

    }
    public SupplierDto addNewSuppliers(SupplierDto supplierRequest) {
        Supplier saveSupplier=  SupplierMapper.toEntity(supplierRequest);
        supplierRepository.save(saveSupplier);
        return SupplierMapper.mapToDTO(saveSupplier);

    }
    public SupplierDto retrieveSupplierById(long id) {
        Supplier supplierByid  = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        return SupplierMapper.mapToDTO(supplierByid);
    }
    public ResponseEntity<?> deleteAnSupplier(long id) {
        Supplier supplierByid  = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        supplierRepository.delete(supplierByid);
        return ResponseEntity.ok("Successfully deleted");
    }
    public SupplierDto updateSupplier(SupplierDto supplier,long id) {
        Supplier supplierToUpdate=supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));

            SupplierMapper.update(supplierToUpdate,supplier);


        supplierRepository.save(supplierToUpdate);
        return SupplierMapper.mapToDTO(supplierToUpdate);
    }
    public ResponseEntity<?> saveItemsForSupplier(ItemDto item,Long id){
        Supplier supplierById=supplierRepository.findAllById(id);
        Item itemToAdd=ItemMapper.toEntity(item,supplierById);
        supplierById.getItemlist().add(itemToAdd);
        supplierRepository.save(supplierById);
        return ResponseEntity.ok("Saved Successfully");
    }
    public List<ItemDto> retriveItemsForSupplier(Long id){
        Supplier supplierById=supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
        List<Item>itemList=supplierById.getItemlist();
        return itemList.stream().map(item -> ItemMapper.mapToDTO(item)).collect(Collectors.toList());
    }

}

