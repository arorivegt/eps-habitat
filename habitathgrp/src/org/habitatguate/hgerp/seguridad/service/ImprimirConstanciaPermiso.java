package org.habitatguate.hgerp.seguridad.service;

import java.io.IOException;
import java.io.OutputStream;
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
    private AuxEmpleado auxEmpleado 			= new AuxEmpleado();
    private AuxEmpleado auxJefe 				= new AuxEmpleado();
    private Font redFont 						= new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD, BaseColor.BLACK);

    
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
	        auxEmpleado 				= recursosHumanosService.Empleado_Registrado(abracadabra);
	        auxJefe						= recursosHumanosService.Empleado_Registrado(auxEmpleado.getJefe_Inmediato());

	        int dias					= (int) ((auxPermiso.getFecha2()-auxPermiso.getFecha1())/(1000*60*60*24)); 
	        OutputStream out 			= response.getOutputStream();
	       
	        try {
	            Document document 	= new Document();
	            PdfWriter.getInstance(document, out);
	            document.open();
	            
	            Image image1 			= null ;
		 		SimpleDateFormat fecha 	= new SimpleDateFormat("dd/MM/yyyy");
	            String nombre 			= auxEmpleado.getPrimer_nombre() +" "+ auxEmpleado.getSegundo_nombre() 
	            					+ " " +auxEmpleado.getPrimer_apellido() +" "+ auxEmpleado.getSegundo_apellido();
	            
	            String nombre2 			= auxJefe.getPrimer_nombre() +" "+ auxJefe.getSegundo_nombre() 
	            					+ " " +auxJefe.getPrimer_apellido() +" "+ auxJefe.getSegundo_apellido();
	            	image1 				= Image.getInstance("images/imagenempresa.png");
	            PdfPTable table 	= new PdfPTable(1);
	            image1.setAlignment(Element.ALIGN_CENTER);
	            image1.scaleAbsolute(10.0f, 10.0f);
	            
	            table.addCell(image1);
	            table.addCell(new Paragraph("Por este medio hace constar que: "+nombre+" quien se identifica con DPI"
	            		+ " "+auxEmpleado.getCui()+" ha solicitado un Permiso/Vacaciones/Ausencia que son un total de "+dias
	            		+ " dias la cual se restara a los dias totales que posee, y en caso contrario debera reponerlo"
	            		+ " los cuales corresponde a la fecha del "+fecha.format(new Date(auxPermiso.getFecha1()))+""
	            		+ " al "+fecha.format(new Date(auxPermiso.getFecha2())),redFont));
	            table.addCell(nombre2 + "(Jefe)");
	            table.addCell("Recursos Humanos:");
	            table.addCell("Guatemala "+fecha.format(new Date()));
	        
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
