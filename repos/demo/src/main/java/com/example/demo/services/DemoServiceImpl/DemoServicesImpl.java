package com.example.demo.services.DemoServiceImpl;

import com.example.demo.Entities.Invoice;
import com.example.demo.Entities.InvoiceItem;
import com.example.demo.services.DemoServices;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class DemoServicesImpl implements DemoServices {
    public byte[] generateInvoicePdf(Invoice invoice) throws IOException {
        try (PDDocument document = new PDDocument(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 750);
            contentStream.showText("Invoice");
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 730);
            contentStream.showText("Invoice Number: " + invoice.getInvoiceNumber());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Date: " + invoice.getDate());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Customer Name: " + invoice.getCustomerName());
            contentStream.endText();

            // Draw the table header
            drawTableHeader(contentStream, 50, 670);

            // Draw the table rows
            drawTableRows(contentStream, 50, 650, invoice);

            // Draw the table footer
            drawTableFooter(contentStream, 50, 50, invoice.getTotalAmount());

            contentStream.close();

            document.save(outputStream);
            document.close();

            return outputStream.toByteArray();
        }
    }

    private void drawTableHeader(PDPageContentStream contentStream, float x, float y) throws IOException {
        float tableWidth = 500;
        float tableTopY = y;
        float tableBottomY = y - 20;
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.setLineWidth(0.5f);
        contentStream.drawLine(x, tableTopY, x + tableWidth, tableTopY);
        contentStream.drawLine(x, tableBottomY, x + tableWidth, tableBottomY);
        contentStream.drawLine(x, tableTopY, x, tableBottomY);
        contentStream.drawLine(x + tableWidth, tableTopY, x + tableWidth, tableBottomY);

        float textX = x + 5;
        float textY = tableTopY - 15;
        contentStream.beginText();
        contentStream.newLineAtOffset(textX, textY);
        contentStream.showText("Item");
        contentStream.newLineAtOffset(150, 0);
        contentStream.showText("Quantity");
        contentStream.newLineAtOffset(100, 0);
        contentStream.showText("Unit Price");
        contentStream.newLineAtOffset(100, 0);
        contentStream.showText("Total");
        contentStream.endText();
    }

    private void drawTableRows(PDPageContentStream contentStream, float x, float y, Invoice invoice) throws IOException {
        float tableBottomY = y - 20;
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.setLineWidth(0.5f);
        float rowHeight = 20;
        for (InvoiceItem item : invoice.getItems()) {
            contentStream.drawLine(x, y, x + 500, y);
            contentStream.drawLine(x, y - rowHeight, x + 500, y - rowHeight);
            contentStream.drawLine(x + 150, y, x + 150, y - rowHeight);
            contentStream.drawLine(x + 250, y, x + 250, y - rowHeight);
            contentStream.drawLine(x + 350, y, x + 350, y - rowHeight);

            float textX = x + 5;
            float textY = y - 15;
            contentStream.beginText();
            contentStream.newLineAtOffset(textX, textY);
            contentStream.showText(item.getDescription());
            contentStream.newLineAtOffset(150, 0);
            contentStream.showText(String.valueOf(item.getQuantity()));
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(String.valueOf(item.getUnitPrice()));
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(String.valueOf(item.getTotal()));
            contentStream.endText();

            y -= rowHeight;
        }
        contentStream.drawLine(x, tableBottomY, x + 500, tableBottomY);
    }

    private void drawTableFooter(PDPageContentStream contentStream, float x, float y, double totalAmount) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.setLineWidth(0.5f);
        contentStream.drawLine(x, y, x + 500, y);

        float textX = x + 250;
        float textY = y - 15;
        contentStream.beginText();
        contentStream.newLineAtOffset(textX, textY);
        contentStream.showText("Total Amount:");
        contentStream.endText();

        textX = x + 350;
        contentStream.beginText();
        contentStream.newLineAtOffset(textX, textY);
        contentStream.showText("$" + totalAmount);
        contentStream.endText();
    }
}


