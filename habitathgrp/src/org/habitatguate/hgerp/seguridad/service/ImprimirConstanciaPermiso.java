package org.habitatguate.hgerp.seguridad.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPermiso;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable; 


/**
 * contancia de de permiso
 * , de un Empleado en especifico
 * utilizando la libreria itextpdf url-->http://itextpdf.com/
 * Ejemplos en url---> http://itextpdf.com/examples/iia.php?id=12
 * @author arodriguez
 *
 */
public class ImprimirConstanciaPermiso extends HttpServlet {

	private static final long serialVersionUID 	= 1L;
    private AuxPermiso auxPermiso 				= new AuxPermiso();
    private Font catFont 						= new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.NORMAL,BaseColor.BLACK);
    private Font catFont2 						= new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD,BaseColor.BLACK);
    
    private RecursosHumanosServiceImpl recursosHumanosService = new  RecursosHumanosServiceImpl();
    
	/**
	 * Metodo para crear el pdf del perfil de la persona en cuestion
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        response.setContentType("application/pdf");

		HttpSession session = request.getSession(false);
		
        if(session.getAttribute("usserHabitat") != null)
        {  
        	long abracadabra 			= Long.parseLong(request.getParameter("abracadabra"));
        	long abracadabra2			= Long.parseLong(request.getParameter("abracadabra2"));
	        auxPermiso 					= recursosHumanosService.getPermiso(abracadabra, abracadabra2);
	        
	        OutputStream out 			= response.getOutputStream();
	       
	        try {
	            Document document 	= new Document();
	            PdfWriter.getInstance(document, out);
	            document.open();
	            
	            document.add(new Paragraph("",catFont));
	            document.add(new Paragraph("",catFont));
	            document.add(new Paragraph("",catFont));
	            
	            PdfPTable table 	= new PdfPTable(2);
	        	PdfPCell c1 		= new PdfPCell(new Phrase("Primer Nombre",catFont2));
	            document.add(table);
	          
	            document.close();
	        }catch (DocumentException exc){
	        	throw new IOException(exc.getMessage());
	        }
	        finally {            
	            out.close();
	        }
		
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This Servlet Generates PDF Using iText Library";
    }
    
    
}
