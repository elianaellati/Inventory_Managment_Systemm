package com.example.inventory.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order_itemDto {

    @NotNull
    private Long order_id;

    @NotNull
    private Long item_id;

    @NotNull
    private double quantity;


}
