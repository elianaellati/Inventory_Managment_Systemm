package com.example.inventory.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound  extends RuntimeException{
    private long fieldValue;

    public ResourceNotFound( long fieldValue) {
        super(String.format("This ID is not found ",fieldValue));

        this.fieldValue = fieldValue;
    }
}
