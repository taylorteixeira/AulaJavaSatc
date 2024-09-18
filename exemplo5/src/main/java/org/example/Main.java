package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PDDocument documento = new PDDocument(); // instacia um documento PDF
        PDPage pagina = new PDPage(); // Intacia uma pagina em branco
        documento.addPage(pagina); // Adiciona a pagina no documento

        PDPageContentStream escritor = new PDPageContentStream(documento, pagina);
        PDType1CFont fonte = new PDType1CFont(Standard14Fonts.FontName.TIMES_BOLD);
        escritor.setFont(fonte, 18.5f);
        escritor.beginText();
        escritor.showText("Olá mundo!");
        escritor.endText();
        escritor.close();

        documento.save("teste.pdf");
    }
}