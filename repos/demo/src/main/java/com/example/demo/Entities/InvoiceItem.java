package com.example.demo.Entities;

import lombok.Data;

@Data
public class InvoiceItem {
    private String description;
    private int quantity;
    private double unitPrice;

    // Constructors, getters, and setters for the InvoiceItem class

    public InvoiceItem() {
    }

    public InvoiceItem(String description, int quantity, double unitPrice) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and setters for description, quantity, and unitPrice

    public double getTotal() {
        return quantity * unitPrice;
    }
}
