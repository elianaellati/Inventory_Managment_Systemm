package com.example.inventory.Models;

public enum  OrderStatus {

    Pending("pending"),
    approved("approved"),
    delivered("delivered"),
    COMPLETED("Completed");

    private final String value;
    OrderStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}