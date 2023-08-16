package com.example.demo.services;

import com.example.demo.Entities.Invoice;

import java.io.IOException;

public interface DemoServices {
    byte[] generateInvoicePdf(Invoice invoice) throws IOException;

}
