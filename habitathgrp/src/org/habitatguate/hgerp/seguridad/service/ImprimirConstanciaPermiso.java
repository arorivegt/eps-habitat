package org.habitatguate.hgerp.seguridad.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPermiso;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;

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

@WebServlet("/ImprimirConstanciaPermiso")
public class ImprimirConstanciaPermiso extends HttpServlet {

	private static final long serialVersionUID 	= 1L;
    private AuxPermiso auxPermiso 				= new AuxPermiso();
    private AuxEmpleado auxEmpleado 			= new AuxEmpleado();
    private AuxEmpleado auxJefe 				= new AuxEmpleado();
    private AuxPuesto auxPuesto 				= new AuxPuesto();
    private Font redFont 						= new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD, BaseColor.BLACK);
    private static float totalDias				= 0.0f;
    private static float dias					= 0.0f;

    
    private RecursosHumanosServiceImpl recursosHumanosService = new  RecursosHumanosServiceImpl();
    
	/**
	 * Metodo para crear el pdf del perfil de la persona en cuestion
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
    @SuppressWarnings("deprecation")
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
        	auxPuesto					= recursosHumanosService.getPuestoActivo(abracadabra);
	        OutputStream out 			= response.getOutputStream();
	        
	        Date ff1 = new Date(auxPermiso.getFecha1());
	        Date ff2 = new Date(auxPermiso.getFecha2());
	        Long fechh1 = auxPermiso.getFecha1();

			while(ff1.before(ff2) || ff1.getTime() == ff2.getTime()){
				dias = dias + 1f;
				fechh1 = fechh1 + 1*24*60*60*1000;
				ff1 = new Date(fechh1);
			}
			
	        Long fech1 = auxPermiso.getFecha1();
	        Long fech2 = auxPermiso.getFecha2();
	        
	        Date f1 = new Date(fech1);
			Date f2 = new Date(fech2);
			
			while(f1.before(f2) || f1.getTime() == f2.getTime()){
				int diaNumero = f1.getDay();
				System.out.println(auxPuesto.getSabado());
				System.out.println(diaNumero);
				
				if(auxPuesto.getDomingo().equals("0") && diaNumero == 0){
					totalDias =totalDias+1;
				}else if(auxPuesto.getDomingo().equals("1") && diaNumero == 0){
					totalDias =(float) +0.50;
				}else if(auxPuesto.getLunes().equals("0") && diaNumero == 1){
					totalDias =totalDias+1;
				}else if(auxPuesto.getLunes().equals("1") && diaNumero == 1){
					totalDias =totalDias+0.50f;
				}else if(auxPuesto.getMartes().equals("0") && diaNumero == 2){
					totalDias =totalDias+1;
				}else if(auxPuesto.getMartes().equals("1") && diaNumero == 2){
					totalDias =totalDias+0.50f;
				}else if(auxPuesto.getMiercoles().equals("0") && diaNumero == 3){
					totalDias =totalDias+1;
				}else if(auxPuesto.getMiercoles().equals("1") && diaNumero == 3){
					totalDias =totalDias+0.50f;
				}else if(auxPuesto.getJueves().equals("0") && diaNumero == 4){
					totalDias =totalDias+1;
				}else if(auxPuesto.getJueves().equals("1") && diaNumero == 4){
					totalDias =totalDias+0.50f;
				}else if(auxPuesto.getViernes().equals("0") && diaNumero == 5){
					totalDias =totalDias+1;
				}else if(auxPuesto.getViernes().equals("1") && diaNumero == 5){
					totalDias =totalDias+0.50f;
				}else if(auxPuesto.getSabado().equals("0") && diaNumero == 6){
					totalDias =totalDias+1;
				}else if(auxPuesto.getSabado().equals("1") && diaNumero == 6){
					totalDias =totalDias+0.50f;
				}
				System.out.println("totalDias: "+totalDias);
				
				fech1 = fech1 + 1*24*60*60*1000;
				f1 = new Date(fech1);						
			}
			System.out.println("dias: "+dias);
			System.out.println("totalDias: "+totalDias);
			dias = dias - totalDias;
	       
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
	            String tipoPermiso 		= "";
	            PdfPTable table 	= new PdfPTable(1);
	            image1.setAlignment(Element.ALIGN_CENTER);
	            image1.scaleAbsolute(10.0f, 10.0f);

	            if(auxPermiso.getTipoPermisos().equals("0")){
	                tipoPermiso = "Vacaciones con goce salaria";
	            }else if(auxPermiso.getTipoPermisos().equals("1")){
	                tipoPermiso = "Vacaciones sin goce salaria";
	            }else if(auxPermiso.getTipoPermisos().equals("2")){
	                tipoPermiso = "Permiso con goce salaria";
	            }else if(auxPermiso.getTipoPermisos().equals("3")){
	                tipoPermiso = "Permiso sin goce salaria";
	            }else if(auxPermiso.getTipoPermisos().equals("4")){
	                tipoPermiso = "Suspension con goce salaria";
	            }else if(auxPermiso.getTipoPermisos().equals("5")){
	                tipoPermiso = "Suspension sin goce salaria";
	            }else if(auxPermiso.getTipoPermisos().equals("6")){
	                tipoPermiso = "Ausencia con goce salaria";
	            }else if(auxPermiso.getTipoPermisos().equals("7")){
	                tipoPermiso = "Ausencia sin goce salaria";
	            	
	            }
	            table.addCell(image1);
	            table.addCell(new Paragraph("Por este medio hace constar que: "+nombre+" quien se identifica con DPI"
	            		+ " "+auxEmpleado.getCui()+" ha solicitado "+tipoPermiso+" de "+dias
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
	        totalDias = 0.0f;
	        dias = 0.0f;
		
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
