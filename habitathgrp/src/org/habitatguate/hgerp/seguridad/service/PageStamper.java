package org.habitatguate.hgerp.seguridad.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

 
import java.io.IOException;

public class PageStamper extends PdfPageEventHelper {
	 String header;
	 String noSolucion;
     /** The template with the total number of pages. */
     PdfTemplate total;
     
     
     public PageStamper(String noSolucion){
    	 this.noSolucion = noSolucion;
     }

     /**
      * Allows us to change the content of the header.
      * @param header The new header String
      */
     public void setHeader(String header) {
         this.header = header;
     }

     /**
      * Creates the PdfTemplate that will hold the total number of pages.
      * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
      *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
      */
     public void onOpenDocument(PdfWriter writer, Document document) {
         total = writer.getDirectContent().createTemplate(30, 16);
     }

     /**
      * Adds a header to every page
      * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
      *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
      */

 

    public void onEndPage(PdfWriter writer, Document document) {
    	 PdfPTable table = new PdfPTable(4);
         try {
             table.setWidths(new int[]{25, 10, 16,24});
             table.setTotalWidth(527);
             table.setLockedWidth(true);
             table.getDefaultCell().setFixedHeight(20);
             table.getDefaultCell().setBorder(Rectangle.BOTTOM);
             table.addCell(header);
             table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
             table.addCell(String.format("Pagina %d de", writer.getPageNumber()));
             PdfPCell cell = new PdfPCell(Image.getInstance(total));
             cell.setBorder(Rectangle.BOTTOM);
             table.addCell(cell);
             table.addCell(noSolucion);
             table.writeSelectedRows(0, -1, 34, 35, writer.getDirectContent());
         }
         catch(DocumentException de) {
             throw new ExceptionConverter(de);
         }
    }
    
    /**
     * Fills out the total number of pages before the document is closed.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                new Phrase(String.valueOf(writer.getPageNumber() - 1)),
                2, 2, 0);
    }
}
