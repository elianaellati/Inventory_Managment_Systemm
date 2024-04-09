package com.example.inventory.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto{

private long id;

 @NotNull
 @NotBlank
 @Size(min = 5, max = 30)
 private String name;

 @NotNull
 @NotBlank
 @Size(min = 5, max = 30)
 private String phone_number;

 @NotNull
 @NotBlank
 @Size(min = 5, max = 30)
 private String email;

 }