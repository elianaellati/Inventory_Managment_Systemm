package com.example.inventory.DTO;

import com.example.inventory.Models.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ItemDto {
    private Long id;

    @NotNull
    private String item_name;
    @NotNull
    private double quantity;

    @NotNull
    private double price;

}
