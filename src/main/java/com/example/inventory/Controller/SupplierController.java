package com.example.inventory.Controller;

import com.example.inventory.DTO.ItemDto;
import com.example.inventory.DTO.SupplierDto;
import com.example.inventory.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    SupplierService supplierService;
    @Autowired
    public SupplierController( SupplierService supplierService){
        this.supplierService=supplierService;
    }

    @GetMapping("")
    public List<SupplierDto> retrieveAllSuppliers(){
       return supplierService.retrieveSuppliers();
    }
    @PostMapping("")
    public ResponseEntity<?> addNewSupplier(@RequestBody SupplierDto supplierRequest){
        return supplierService.addNewSuppliers(supplierRequest);
    }
    @GetMapping("/{id}")
    public SupplierDto retrieveSupplierById(@PathVariable Long id){
        return supplierService.retrieveSupplierById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteAnSupplier(@PathVariable Long id){
        return supplierService.deleteAnSupplier(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>updateSupplier(@RequestBody SupplierDto supplier, @PathVariable Long id){
        return supplierService.updateSupplier(supplier,id);
    }
    @GetMapping("/{id}/items")
    public List<ItemDto>retrieveItemsForSupplier(@PathVariable Long id){
        return supplierService.retriveItemsForSupplier(id);
    }
    @PostMapping("/{id}/items")
    public ResponseEntity<?>saveItemForSupplier(@RequestBody ItemDto item, @PathVariable Long id){
        return supplierService.saveItemsForSupplier(item,id);
    }




}
