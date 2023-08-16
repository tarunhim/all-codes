package com.example.demo.Entities;

import lombok.Data;

import java.util.List;

@Data
public class Invoice {
    private String invoiceNumber;
    private String date;
    private String customerName;
    private double totalAmount;

    private List<InvoiceItem> items;
    private double calculateTotalAmount() {
        return items.stream().mapToDouble(InvoiceItem::getTotal).sum();
    }

    // Constructors, getters, and setters for the Invoice class
}

