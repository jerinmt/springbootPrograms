package com.example.pdfProject.controllers;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PdfController {
	
	@GetMapping("/lotr")
	public String showPage() {
		return "lotr";
	}

    // Generate PDF for a specific product
    @GetMapping("/generate-book-pdf")
    public void generateProductPdf(HttpServletResponse response) throws Exception {
    	response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=product.pdf");

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 750);
                contentStream.showText("Book Details");
                contentStream.endText();

                contentStream.setFont(PDType1Font.HELVETICA, 12);
                int yPosition = 720;
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("Title: Lord of the Rings");
                contentStream.endText();

                yPosition -= 20;
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("Author: JRR Tolkien");
                contentStream.endText();
                
                yPosition -= 20;
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("Description: An unexpected group of heroes take on a dangerous journey.");
                contentStream.endText();

                yPosition -= 20;
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("Price: Rs. 700");
                contentStream.endText();

                yPosition -= 20;
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("Published Date: 21 June 1990");
                contentStream.endText();
            }

            document.save(response.getOutputStream());
        }
    }
}