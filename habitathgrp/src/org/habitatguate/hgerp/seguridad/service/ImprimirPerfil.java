package org.habitatguate.hgerp.seguridad.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
// Document Object
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
//For adding content into PDF document
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable; 



public class ImprimirPerfil extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private AuxEmpleado p = new AuxEmpleado();
   private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.NORMAL,BaseColor.BLACK);
   private Font catFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD,BaseColor.BLACK);
    private RecursosHumanosServiceImpl loginService = new  RecursosHumanosServiceImpl();
    
	//invoked from doGet method to create PDF through servlet 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Set content type to application / pdf
        //browser will open the document only if this is set
        response.setContentType("application/pdf");

        long abracadabra = Long.parseLong(request.getParameter("abracadabra"));
        
        p = loginService.Empleado_Registrado(abracadabra);
        
        OutputStream out = response.getOutputStream();
       
			//Get the output stream for writing PDF object  zzz
	        try {
	            Document document = new Document();
	            PdfWriter.getInstance(document, out);
	            Image image1 = null ;
	            
	            try{
	            	image1 = Image.getInstance(new URL(p.getURLFile()));
	            }catch(Exception e){
	            	image1 = Image.getInstance("images/imagenempresa.png");
	            }
	            
	            document.open();
	            image1.setAlignment(Element.ALIGN_CENTER);
	            document.add(image1);
	            document.add(new Paragraph("",catFont));
	            document.add(new Paragraph("",catFont));
	            document.add(new Paragraph("",catFont));
	            PdfPTable table = new PdfPTable(2);
	        	PdfPCell c1 = new PdfPCell(new Phrase("Primer Nombre",catFont2));
	            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	            table.addCell(c1);
	            c1 = new PdfPCell(new Phrase("Segundo Nombre",catFont2));
	            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	            table.addCell(c1);
	            table.setHeaderRows(1);

	            table.addCell(new Paragraph(p.getPrimer_nombre(),catFont));
	            table.addCell(new Paragraph(p.getSegundo_nombre(),catFont));
	            table.addCell(new Paragraph("Primer Apellido",catFont2));
	            table.addCell(new Paragraph("Segundo Apellido",catFont2));
	            table.addCell(new Paragraph(p.getPrimer_apellido(),catFont));
	            table.addCell(new Paragraph(p.getSegundo_apellido(),catFont));
	            table.addCell(new Paragraph("Sexo",catFont2));
	            table.addCell(new Paragraph("Estado Civil",catFont2));
	            table.addCell(new Paragraph(p.getSexo(),catFont));
	            table.addCell(new Paragraph(p.getEstado_civil(),catFont));
	            table.addCell(new Paragraph("No Afiliado IGSS",catFont2));
	            table.addCell(new Paragraph("NIT",catFont2));
	            table.addCell(new Paragraph(p.getAfiliacion_igss(),catFont));
	            table.addCell(new Paragraph(p.getNit(),catFont));
	            table.addCell(new Paragraph("Pais",catFont2));
	            table.addCell(new Paragraph("Direccion Actual",catFont2));
	            table.addCell(new Paragraph(p.getPais(),catFont));
	            table.addCell(new Paragraph(p.getDireccion_actual(),catFont));
	            table.addCell(new Paragraph("Celular",catFont2));
	            table.addCell(new Paragraph("Telefono",catFont2));
	            table.addCell(new Paragraph(p.getCelular(),catFont));
	            table.addCell(new Paragraph(p.getTelefono(),catFont));
	            table.addCell(new Paragraph("DPI",catFont2));
	            table.addCell(new Paragraph("Cedula",catFont2));
	            table.addCell(new Paragraph(p.getCui(),catFont));
	            table.addCell(new Paragraph(p.getNo_registro()+"-"+p.getNo_orden(),catFont));
	            table.addCell(new Paragraph("Correo",catFont2));
	            table.addCell(new Paragraph("Año de Nacimiento",catFont2));
	            table.addCell(new Paragraph(p.getEmail(),catFont));
	            table.addCell(new Paragraph(""+new Date(p.getFecha_nacimiento()),catFont));
	            document.add(table);
	            /* Basic PDF Creation inside servlet */
	          
	            document.close();
	        }catch (DocumentException exc){
	        	throw new IOException(exc.getMessage());
	        }
	        finally {            
	            out.close();
	        }
		
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This Servlet Generates PDF Using iText Library";
    }
}
