package com.example.demo.Entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InvoiceMaster {
    private String invoiceNumber;

//    private MetaData metaData; //Will contain details regarding user type, invoice type and others
//
//    private InvoiceType invoiceType; //for End user or for seller
//
//    @Transient
//    private TransactionDetails transactionDetails; //will contain details of all the transaction for seller in monthly cycle
    private LocalDateTime invoiceDate;
    private LocalDateTime dueDate;
    private String sellerName;
    private String sellerAddress;
    private String sellerTaxId;
    private String customerName;
    private String customerAddress;
    private String customerTaxId;
    private double subtotal;
    private double tax;
    private double totalAmount;
}
