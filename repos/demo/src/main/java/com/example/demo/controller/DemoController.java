package com.example.demo.controller;

import java.io.IOException;
import java.util.Map;

import com.example.demo.Entities.Invoice;
import com.example.demo.services.DemoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/demo")
@Validated
public class DemoController {

//    private final DemoServices demoService = new DemoService();
//
//    public PdfGenerationController(DemoServices pdfGenerationService) {
//        this.demoService.pdfGenerationService = pdfGenerationService;
//    }

    @Autowired
    private DemoServices demoServices;

    @PostMapping(value = "/generate-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody Invoice invoice) {
        try {
            byte[] pdfBytes = demoServices.generateInvoicePdf(invoice);
            return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=invoice.pdf").body(pdfBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public Object getData(
            @RequestBody Object object
    ){
        Map<String, String> data = (Map<String,String>) object;
        data.put("Success", "false");
        return data;
    }
}
