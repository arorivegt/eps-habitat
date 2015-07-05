package org.habitatguate.hgerp.seguridad.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialAcademico;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxIdioma;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaLaboral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaPersonal;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPermiso;

import com.itextpdf.text.BaseColor;
// Document Object
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
//For adding content into PDF document
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



@WebServlet("/CrearReporteSolucionesHabitat")
public class CrearReporteSolucionesHabitat extends HttpServlet {

	private static final long serialVersionUID 	= 1L;
    private List<AuxEmpleado> auxEmpleado 		= new ArrayList<AuxEmpleado>();
    
    private Font redFont 						= new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD, BaseColor.BLACK);
    private Font catFont 						= new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.NORMAL,BaseColor.BLACK);

	private RecursosHumanosServiceImpl recusosHumanosService 	= new  RecursosHumanosServiceImpl();
    private SimpleDateFormat fecha 								= new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df 									= new DecimalFormat();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        
    	response.setContentType("application/pdf");

        char tipo 				= request.getParameter("tipo").charAt(0);
		String estado 			= request.getParameter("estado");
		String primer_nombre 	= request.getParameter("primer_nombre");
		String DPI 				= request.getParameter("DPI");
		String Pasaporte 		= request.getParameter("Pasaporte");
		String familia 			= request.getParameter("familia");
		String academico 		= request.getParameter("academico");
		String reflab 			= request.getParameter("reflab");
		String refper 			= request.getParameter("refper");
		String idiomas 			= request.getParameter("idiomas");
		String puesto 			= request.getParameter("puesto");
		String test 			= request.getParameter("test");
		String testf1 			= request.getParameter("testf1");
		String testf2 			= request.getParameter("testf2");
		String testT 			= request.getParameter("testT");
		String hist 			= request.getParameter("hist");
		String histf1 			= request.getParameter("histf1");
		String histf2 			= request.getParameter("histf2");
		String histT 			= request.getParameter("histT");
		String perm 			= request.getParameter("perm");
		String permf1 			= request.getParameter("permf1");
		String permf2 			= request.getParameter("permf2");
		String permT 			= request.getParameter("permT");
		String sal 				= request.getParameter("sal");
		String salf1 			= request.getParameter("salf1");
		String salf2 			= request.getParameter("salf2");
		String salT 			= request.getParameter("salT");

       
        if(tipo =='1'){

			String nombreArray[]	= primer_nombre.split(":");
			String primerNombre 	= "";
			String segundoNombre 	= "";
			String segundoApellido 	= "";
			String primerApellido 	= "";

			try{

				if(nombreArray.length == 2){
					primerNombre 	= nombreArray[0].trim();
					segundoNombre 	= "".trim();
					primerApellido 	= nombreArray[1].trim();
					segundoApellido = "".trim();
					
					auxEmpleado 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																   			primerApellido,  segundoApellido,DPI, 
																   			Pasaporte,estado);
				}else if(nombreArray.length == 3){
					
					primerNombre 	= nombreArray[0].trim();
					segundoNombre 	= nombreArray[1].trim();
					primerApellido 	= nombreArray[2].trim();
					segundoApellido = "".trim();
					
					auxEmpleado 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																			primerApellido,  segundoApellido,DPI, 
																			Pasaporte,estado);
					if(auxEmpleado.isEmpty())
					{
						primerNombre 	= nombreArray[0].trim();
						segundoNombre 	= nombreArray[1].trim();
						primerApellido 	= "".trim();
						segundoApellido = nombreArray[2].trim();
						
						auxEmpleado 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																			primerApellido,  segundoApellido,DPI, 
																			Pasaporte,estado);
					}
					
					
				}else if(nombreArray.length == 4)
				{
					primerNombre 	= nombreArray[0].trim();
					segundoNombre 	= nombreArray[1].trim();
					primerApellido 	= nombreArray[2].trim();
					segundoApellido = nombreArray[3].trim();
					
					
					auxEmpleado 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																			primerApellido,  segundoApellido,DPI, 
																			Pasaporte,estado);
				}
				
			}catch(Exception e)
			{
				 primerNombre 		= "";
				 primerApellido 	= "";
				 segundoApellido 	= "";
				 primerApellido 	= "";
			}
 		}
 		else{
 			auxEmpleado				 	= recusosHumanosService.Buscar_Empleado(tipo, primer_nombre, "", 
 																			"", "",DPI, 
 																			Pasaporte,estado);
 		}
        OutputStream out 	= response.getOutputStream();
       
	        try {
	        	
	            Document document = new Document();
	            PdfWriter.getInstance(document, out);
	            document.open();
	            
	            for(AuxEmpleado p : auxEmpleado) {
	            	//titulo es el Nombre del Empleado + algunos datos
		            document.add(new Paragraph("........................................................"
		            						 + "......................................................"
		            						 + "........................................................",catFont));
		            document.add(new Paragraph("Nombre:"+" "+p.getPrimer_nombre()+" "+p.getSegundo_nombre()+","+p.getPrimer_apellido()+" "+p.getSegundo_apellido(), redFont));

		            if(p.getSexo().equals("0")){ 
		            	document.add(new Paragraph("Sexo:"+" "+"femenino", redFont));
		            }else if(p.getSexo().equals("1")){
		            	document.add(new Paragraph("Sexo:"+" "+"masculino", redFont));
		            }
		            document.add(new Paragraph("Email:"+" "+p.getEmail(), redFont));
		            document.add(new Paragraph("Pais:"+" "+getPais(p.getPais()), redFont));
		            document.add(new Paragraph(" "));
	            
		           if(familia.equals("true") ){
		        	   boolean valor = true;
		            	for(AuxFamilia f : p.getFamilia()) {
		            		if(valor){
		    		            document.add(new Paragraph("Historial Familiar",catFont));
		    		            document.add(new Paragraph(" "));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		    		            valor = false;
		            		}
			            	document.add(CrearFamilia(f));
	    		            document.add(new Paragraph(" "));
		            	}
		            }
		           if(academico.equals("true")){
		        	   boolean valor = true;
		            	for(AuxHistorialAcademico f : p.getHistorial_academico()) {
		            		if(valor){
		    		            document.add(new Paragraph("Historial Academico",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
			            	document.add(CrearAcademico(f));
	    		            document.add(new Paragraph(" "));
		            	}
		            }
		           if(reflab.equals("true")){
		        	   boolean valor = true;
		            	for(AuxReferenciaLaboral f : p.getReferencia_laboral()) {
		            		if(valor){
		    		            document.add(new Paragraph("Referencia Laboral",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
			            	document.add(CrearRefLaboral(f));
	    		            document.add(new Paragraph(" "));
		            	}
		           }
		           if(refper.equals("true")){
		        	   boolean valor = true;
		            	for(AuxReferenciaPersonal f : p.getReferencia_personal()) {
		            		if(valor){
		    		            document.add(new Paragraph("Referencia Personal",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
			            	document.add(CrearRefPersonal(f));
	    		            document.add(new Paragraph(" "));
		            	}
		            }
		            if(idiomas.equals("true")){
			        	   boolean valor = true;
		            	for(AuxIdioma f : p.getIdiomas()) {
		            		if(valor){
		    		            document.add(new Paragraph("Historial de Idiomas",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
			            	document.add(CrearIdioma(f));
	    		            document.add(new Paragraph(" "));
		            	}
		            }

		            if(puesto.equals("true")){
			        	   boolean valor = true;
		            	for(AuxPuesto f : p.getPuestos()) {
		            		if(valor){
		    		            document.add(new Paragraph("Historial de Puestos",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
			            	document.add(CrearPuesto(f));
	    		            document.add(new Paragraph(" "));
		            	}
		            }
		            if(test.equals("true")){
			        	   boolean valor = true;
			        	   Date fecha1 = new Date(Long.parseLong(testf1));
			        	   Date fecha2 = new Date(Long.parseLong(testf2));
		            	for(AuxTest f : p.getTest()) {

		        			Date aux = new Date(f.getFecha_test());
		        			if(valor){
		    		            document.add(new Paragraph("Test",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		        			}
		        			
		            		if((f.getTipo_test().equals(testT) && aux.after(fecha1) && aux.before(fecha2))			        				
			        		   ||
			        		 (f.getTipo_test().equals(testT) && aux.equals(fecha1) && aux.equals(fecha2)))
		            		{
			            			document.add(CrearTest(f));
			    		            document.add(new Paragraph(" "));
		            		}
		            		
		            	}
		            }
		            if(hist.equals("true")){
			        	   boolean valor = true;
			        	   Date fecha1 = new Date(Long.parseLong(histf1));
			        	   Date fecha2 = new Date(Long.parseLong(histf2));
		            	for(AuxHistorial f : p.getHistorial()) {
		        			Date aux = new Date(f.getFecha());
		        			
		        			if(valor){
		    		            document.add(new Paragraph("Historial Aciertos y llamadas de atencion",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		        			}
		            		if((f.getTipo_historial().equals(histT) && aux.after(fecha1) && aux.before(fecha2))			        				
		        				||
			        			(f.getTipo_historial().equals(histT) && aux.equals(fecha1) && aux.equals(fecha2)))
			        		{
		            			document.add(CrearHistorial(f));
		    		            document.add(new Paragraph(" "));
		            		}
		            		
		            	}
		            }
		            if(perm.equals("true")){
			        	   boolean valor = true;
			        	   Date fecha1 = new Date(Long.parseLong(permf1));
			        	   Date fecha2 = new Date(Long.parseLong(permf2));
		            	for(AuxPermiso f : p.getVacaciones()) {
		        			Date aux = new Date(f.getFecha1());
		        			Date aux2 = new Date(f.getFecha2());
		        			
		        			if(valor){
		    		            document.add(new Paragraph("Historial de Permisos",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		        			}
		            		if((f.getTipoPermisos().equals(permT) && aux.after(fecha1) && aux.before(fecha2))			        				
			        			||
				        	  (f.getTipoPermisos().equals(permT) && aux.equals(fecha1) && aux.equals(fecha2)))
		            		{
			            		document.add(CrearPermiso(f));
		    		            document.add(new Paragraph(" "));
		            		}else if((f.getTipoPermisos().equals(perm) && aux2.after(fecha1) && aux2.before(fecha2))			        				
		            				||
		            				(f.getTipoPermisos().equals(perm) && aux2.equals(fecha1) && aux2.equals(fecha2)))
		            		{
		            			document.add(CrearPermiso(f));
		            			document.add(new Paragraph(" "));
		            		}
		            	}
		            }
		            if(sal.equals("true")){
			        	   boolean valor = true;
			        	   Date fecha1 = new Date(Long.parseLong(salf1));
			        	   Date fecha2 = new Date(Long.parseLong(salf2));
		            	for(AuxSalario f : p.getSalario()) {
		            		if(valor){
		    		            document.add(new Paragraph("Historial Salario",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}

		        			Date aux = new Date(f.getFecha());
		            		if((f.getTipoSalario().equals(salT) && aux.after(fecha1) && aux.before(fecha2))			        				
		        				||
			        			(f.getTipoSalario().equals(salT) && aux.equals(fecha1) && aux.equals(fecha2)))
			        		{
		    		            document.add(new Paragraph(" "));
			            		document.add(CrearSalario(f));
		            		}
		            	}
		            }
		           }
	            document.close();
	        }
	        catch (DocumentException exc){
	        	throw new IOException(exc.getMessage());
	        }
	        finally {            
	            out.close();
	        }
		
        
    }
    public PdfPTable CrearFamilia(AuxFamilia f) {
    	PdfPTable table = new PdfPTable(3);
    	
        table.addCell(new Paragraph("Primer Nombre",redFont));
        table.addCell(new Paragraph("Primer Apellido",redFont));
        table.addCell(new Paragraph("Ocupacion",redFont));
        table.addCell(new Paragraph(f.getPrimer_nombre(),catFont));
        table.addCell(new Paragraph(f.getPrimer_apellido(),catFont));
        table.addCell(new Paragraph(f.getOcupacion(),catFont));
        

        table.addCell(new Paragraph("Segundo Nombre",redFont));
        table.addCell(new Paragraph("Segundo Apellido",redFont));
        table.addCell(new Paragraph("Edad",redFont));
        table.addCell(new Paragraph(f.getSegundo_nombre(),catFont));
        table.addCell(new Paragraph(f.getSegundo_apellido(),catFont));
        table.addCell(new Paragraph(""+f.getEdad(),catFont));
        

        table.addCell(new Paragraph("Parentesco",redFont));
        table.addCell(new Paragraph(f.getParentesco(),catFont));
        
        table.setHeaderRows(1);

        return table;
    }
    public PdfPTable CrearAcademico(AuxHistorialAcademico f) {
    	PdfPTable table = new PdfPTable(3);

        table.addCell(new Paragraph("Titulo",redFont));
        table.addCell(new Paragraph("Establecimiento",redFont));
        table.addCell(new Paragraph("Nivel Academico",redFont));
        table.addCell(new Paragraph(f.getTitulo(),catFont));
        table.addCell(new Paragraph(f.getEstablecimiento(),catFont));
        if(f.getNivel_academico().equals("0"))
            table.addCell(new Paragraph("No sabe leer y/o Escribir",catFont));
        else if(f.getNivel_academico().equals("1"))
             table.addCell(new Paragraph("sabe leer y/o Escribir",catFont));
        else if(f.getNivel_academico().equals("2"))
            table.addCell(new Paragraph("Primaria Incompleta",catFont));
        else if(f.getNivel_academico().equals("3"))
            table.addCell(new Paragraph("Primaria Completa",catFont));
        else if(f.getNivel_academico().equals("4"))
            table.addCell(new Paragraph("Secundaria Incompleta",catFont));
        else if(f.getNivel_academico().equals("5"))
            table.addCell(new Paragraph("Secundaria Completa",catFont));
        else if(f.getNivel_academico().equals("6"))
            table.addCell(new Paragraph("Diversificado Incompleta",catFont));
        else if(f.getNivel_academico().equals("7"))
            table.addCell(new Paragraph("Diversificado Completa",catFont));
        else if(f.getNivel_academico().equals("8"))
            table.addCell(new Paragraph("Universidad Incompleta",catFont));
        else if(f.getNivel_academico().equals("9"))
            table.addCell(new Paragraph("Universidad Completa",catFont));
        else if(f.getNivel_academico().equals("10"))
            table.addCell(new Paragraph("Postgrados",catFont));
        else if(f.getNivel_academico().equals("11"))
            table.addCell(new Paragraph("Diplomado",catFont));
        
        table.setHeaderRows(1);

        return table;
    } 
    public PdfPTable CrearRefLaboral(AuxReferenciaLaboral f) {

    	df.setMaximumFractionDigits(2);
    	PdfPTable table = new PdfPTable(4);

        table.addCell(new Paragraph("Nombre Referencia",redFont));
        table.addCell(new Paragraph("Puesto Candidato",redFont));
        table.addCell(new Paragraph("Empresa Referencia",redFont));
        table.addCell(new Paragraph("Fecha de labores",redFont));
        table.addCell(new Paragraph(f.getNombre_referencia(),catFont));
        table.addCell(new Paragraph(f.getPuesto_candidato(),catFont));
        table.addCell(new Paragraph(f.getEmpresa_referencia(),catFont));
        table.addCell(new Paragraph(fecha.format(new Date(f.getFecha1()))+" al "+fecha.format(new Date(f.getFecha2())),catFont));

        table.addCell(new Paragraph("Telefono Referencia",redFont));
        table.addCell(new Paragraph("Motivo Retiro",redFont));
        table.addCell(new Paragraph("Salario Final",redFont));
        table.addCell(new Paragraph("Recomienda (Si/No)",redFont));
        table.addCell(new Paragraph(f.getTelefono(),catFont));
        table.addCell(new Paragraph(f.getMotivo_retiro(),catFont));
        table.addCell(new Paragraph(""+df.format(f.getSalario_final()),catFont));
        table.addCell(new Paragraph(f.getRecomiendo(),catFont));       
        
        table.setHeaderRows(1);
        
        return table;
    }
    
    public PdfPTable CrearRefPersonal(AuxReferenciaPersonal f) {
    	PdfPTable table = new PdfPTable(4);

        table.addCell(new Paragraph("Nombre Referencia",redFont));
        table.addCell(new Paragraph("Puesto Candidato",redFont));
        table.addCell(new Paragraph("Relacion Referencia",redFont));
        table.addCell(new Paragraph("Telefono",redFont));
        table.addCell(new Paragraph(f.getNombre_referencia(),catFont));
        table.addCell(new Paragraph(f.getPuesto_candidato(),catFont));
        table.addCell(new Paragraph(f.getPuesto_candidato(),catFont));
        table.addCell(new Paragraph(f.getTelefono(),catFont));               
        table.setHeaderRows(1);
        
        return table;
    }
    public PdfPTable CrearIdioma(AuxIdioma f) {
    	
    	PdfPTable table = new PdfPTable(2);
        table.addCell(new Paragraph("Idioma",redFont));
        table.addCell(new Paragraph("Nivel",redFont));
        if(f.getIdioma().equals("1"))
        	table.addCell(new Paragraph("Achi"));
		else if(f.getIdioma().equals("2"))
        	table.addCell(new Paragraph("Akateko"));
		else if(f.getIdioma().equals("3"))
        	table.addCell(new Paragraph("Awakateko"));
		else if(f.getIdioma().equals("4"))
        	table.addCell(new Paragraph("Ch'orti"));
		else if(f.getIdioma().equals("5"))
        	table.addCell(new Paragraph("Chuj"));
		else if(f.getIdioma().equals("6"))
        	table.addCell(new Paragraph("Itza"));
		else if(f.getIdioma().equals("7"))
        	table.addCell(new Paragraph("Ixil"));
		else if(f.getIdioma().equals("8"))
        	table.addCell(new Paragraph("Jakalteko"));
		else if(f.getIdioma().equals("9"))
        	table.addCell(new Paragraph("Kaqchiquel"));
		else if(f.getIdioma().equals("10"))
        	table.addCell(new Paragraph("Kiche"));
		else if(f.getIdioma().equals("11"))
        	table.addCell(new Paragraph("Mam"));
		else if(f.getIdioma().equals("12"))
        	table.addCell(new Paragraph("Mopan"));
		else if(f.getIdioma().equals("13"))
        	table.addCell(new Paragraph("Poqoman"));
		else if(f.getIdioma().equals("14"))
        	table.addCell(new Paragraph("Poqomchi"));
		else if(f.getIdioma().equals("15"))
        	table.addCell(new Paragraph("Q'anjob'al"));
		else if(f.getIdioma().equals("16"))
        	table.addCell(new Paragraph("Q'eqchi"));
		else if(f.getIdioma().equals("17"))
        	table.addCell(new Paragraph("Sakapulteko"));
		else if(f.getIdioma().equals("18"))
        	table.addCell(new Paragraph("Sipakapense"));
		else if(f.getIdioma().equals("19"))
        	table.addCell(new Paragraph("Tektiteko"));
		else if(f.getIdioma().equals("20"))
        	table.addCell(new Paragraph("tz'utujil"));
		else if(f.getIdioma().equals("21"))
        	table.addCell(new Paragraph("Uspanteko"));
		else if(f.getIdioma().equals("22"))
        	table.addCell(new Paragraph("Garelse ifuna"));
		else if(f.getIdioma().equals("23"))
        	table.addCell(new Paragraph("Español"));
		else if(f.getIdioma().equals("24"))
        	table.addCell(new Paragraph("Ingles"));
		else if(f.getIdioma().equals("25"))
        	table.addCell(new Paragraph("Frances"));
		else if(f.getIdioma().equals("26"))
        	table.addCell(new Paragraph("Aleman"));
		else if(f.getIdioma().equals("27"))
        	table.addCell(new Paragraph("Italiano"));
		else if(f.getIdioma().equals("28"))
        	table.addCell(new Paragraph("Coreano"));
		else if(f.getIdioma().equals("29"))
        	table.addCell(new Paragraph("Japones"));
		else if(f.getIdioma().equals("30"))
        	table.addCell(new Paragraph("Mandarin"));
		else if(f.getIdioma().equals("31"))
        	table.addCell(new Paragraph("Cantones"));
		else if(f.getIdioma().equals("32"))
        	table.addCell(new Paragraph("Tailandes"));
		else if(f.getIdioma().equals("33"))
        	table.addCell(new Paragraph("Portugues"));
		else if(f.getIdioma().equals("34"))
        	table.addCell(new Paragraph("Arabe"));
		else if(f.getIdioma().equals("35"))
        	table.addCell(new Paragraph("Hebreo"));
		else if(f.getIdioma().equals("36"))
        	table.addCell(new Paragraph("Griego"));
		else if(f.getIdioma().equals("37"))
        	table.addCell(new Paragraph("Neerlandes"));
		else if(f.getIdioma().equals("38"))
        	table.addCell(new Paragraph("Otros"));

        if(f.getNivel().equals("0"))
        	table.addCell(new Paragraph("Avanzado"));
        else if(f.getNivel().equals("1"))
        	table.addCell(new Paragraph("Intermedio"));
        else if(f.getNivel().equals("2"))
        	table.addCell(new Paragraph("Principiante"));
        table.setHeaderRows(1);
        return table;
    }
    
    public PdfPTable CrearTest(AuxTest f) {
		String AnnioTest 	=  ""+fecha.format(fecha.format(new Date(f.getFecha_test())));
		int valor 			= f.getPregunta1() + f.getPregunt2() + f.getPregunta3()
							+f.getPregunta4()+f.getPregunta5() +f.getPregunta6()
							+f.getPregunta7()+f.getPregunta8()+f.getPregunta9()
							+f.getPregunta10();
		
    	PdfPTable table = new PdfPTable(3);
        table.addCell(new Paragraph("Evaluador",redFont));
        table.addCell(new Paragraph("Fecha",redFont));
        table.addCell(new Paragraph("Punteo",redFont));
        table.addCell(new Paragraph("Tipo Test",redFont));
        table.addCell(new Paragraph(f.getEvaluador(),catFont));
        table.addCell(new Paragraph(AnnioTest,catFont));
        table.addCell(new Paragraph(""+valor,catFont));
        if(f.getTipo_test().equals("1")){
            table.addCell(new Paragraph("Desempeño"));
        }else{
            table.addCell(new Paragraph("Evaluacion"));
        }
        table.setHeaderRows(1);
        return table;
    }
    
    public PdfPTable CrearPuesto(AuxPuesto f) {
		String AnnioPuesto 	= ""+fecha.format(new Date(f.getFecha_puesto()));
    	PdfPTable table 	= new PdfPTable(3);
    	String jornada = "";
    	
        table.addCell(new Paragraph("Puesto",redFont));
        table.addCell(new Paragraph("Fecha del Puesto",redFont));
        table.addCell(new Paragraph("Horas por trabajo",redFont));
        table.addCell(new Paragraph(recusosHumanosService.NombrePuesto(Long.parseLong(f.getNombre_puesto())),catFont));
        table.addCell(new Paragraph(AnnioPuesto,catFont));
        table.addCell(new Paragraph(f.getHorasTrabajo(),catFont));

        table.addCell(new Paragraph("Funciones",redFont));
        table.addCell(new Paragraph("Jornada",redFont));
        table.addCell(new Paragraph("Puesto Activo",redFont));
        table.addCell(new Paragraph(f.getFunciones(),catFont));

        if(f.getJornada().equals("0"))
        	jornada = "Diurna";
        else if(f.getJornada().equals("1"))
            	jornada = "Nocturna";
        else if(f.getJornada().equals("2"))
        	jornada = "Mixta";
        
        table.addCell(new Paragraph(jornada,catFont));
        if(f.isActivo())
        	table.addCell(new Paragraph("Si",catFont));
        else
        	table.addCell(new Paragraph("No",catFont));
    	
        table.setHeaderRows(1);

        return table;
    }
    public PdfPTable CrearHistorial(AuxHistorial f) {
    	
 		String Annio = ""+fecha.format(new Date(f.getFecha()));
     	PdfPTable table = new PdfPTable(2);
     	
        table.addCell(new Paragraph("Descripcion",redFont));
        table.addCell(new Paragraph("Tipo Historial",redFont));
        table.addCell(new Paragraph(f.getDescripcion(),catFont));
        if(f.getTipo_historial().equals("0"))
        	table.addCell(new Paragraph("aciertos",catFont));
        else if(f.getTipo_historial().equals("1"))
        	table.addCell(new Paragraph("llamadas de atención",catFont));
        
        table.addCell(new Paragraph("Fecha Creacion",redFont));
        table.addCell(new Paragraph(Annio,catFont));
        return table;
    }
    
    public PdfPTable CrearPermiso(AuxPermiso f) {
 		String Annio1 = ""+fecha.format(new Date(f.getFecha1()));
 		String Annio2 = ""+fecha.format(new Date(f.getFecha2()));
     	PdfPTable table = new PdfPTable(2);

        table.addCell(new Paragraph("Descripcion",redFont));
        table.addCell(new Paragraph("Tipo Permiso",redFont));
		
        table.addCell(new Paragraph(f.getDescripcion(),catFont));
        if(f.getTipoPermisos().equals("0")){
            table.addCell(new Paragraph("Vacaciones con goce salaria",catFont));
        }else if(f.getTipoPermisos().equals("1")){
            table.addCell(new Paragraph("Vacaciones sin goce salaria",catFont));
        }else if(f.getTipoPermisos().equals("2")){
            table.addCell(new Paragraph("Permiso con goce salaria",catFont));
        }else if(f.getTipoPermisos().equals("3")){
            table.addCell(new Paragraph("Permiso sin goce salaria",catFont));
        }else if(f.getTipoPermisos().equals("4")){
            table.addCell(new Paragraph("Suspension con goce salaria",catFont));
        }else if(f.getTipoPermisos().equals("5")){
            table.addCell(new Paragraph("Suspension sin goce salaria",catFont));
        }else if(f.getTipoPermisos().equals("6")){
            table.addCell(new Paragraph("Ausencia con goce salaria",catFont));
        }else if(f.getTipoPermisos().equals("7")){
            table.addCell(new Paragraph("Ausencia sin goce salaria",catFont));
        	
        }
        
        table.addCell(new Paragraph("Fecha de Permiso",redFont));
        table.addCell(new Paragraph(Annio1+" al "+Annio2,catFont));
       
         return table;
     }
    
    public PdfPTable CrearSalario(AuxSalario f) {
 		String Annio = ""+fecha.format(new Date(f.getFecha()));
     	PdfPTable table = new PdfPTable(2);

        table.addCell(new Paragraph("Descripcion",redFont));
        table.addCell(new Paragraph("Tipo Salario",redFont));
        table.addCell(new Paragraph(f.getDescripcion(),catFont));
        if(f.getTipoSalario().equals("0"))
        	table.addCell(new Paragraph("Salario Base"));
		else if(f.getTipoSalario().equals("1"))
        	table.addCell(new Paragraph("Decreto(78-89)"));
		else if(f.getTipoSalario().equals("2"))
        	table.addCell(new Paragraph("Comisiones"));
		else if(f.getTipoSalario().equals("3"))
        	table.addCell(new Paragraph("Bonificacion"));
		else if(f.getTipoSalario().equals("4"))
        	table.addCell(new Paragraph("Bono 14"));
		else if(f.getTipoSalario().equals("5"))
        	table.addCell(new Paragraph("Aguinaldo"));
		else if(f.getTipoSalario().equals("6"))
        	table.addCell(new Paragraph("Vacaciones"));
		else if(f.getTipoSalario().equals("7"))
        	table.addCell(new Paragraph("Indemnizacion"));
		else if(f.getTipoSalario().equals("8"))
        	table.addCell(new Paragraph("Otros pagos"));
        
        table.addCell(new Paragraph("Fecha",redFont));
        table.addCell(new Paragraph("Monto",redFont));
        table.addCell(new Paragraph(Annio,catFont));
        table.addCell(new Paragraph(""+f.getSalario(),catFont));
       
         return table;
     }
    private String getPais(String codigoPais){
    	String pais = "GUATEMALA";
    	if(codigoPais.equals("1")){pais =  "ABUDABI"; }
    	else if(codigoPais.equals("2")){pais = "AFGANISTÁN"; }
    	else if(codigoPais.equals("143")){pais = "ALASKA"; }
    	else if(codigoPais.equals("3")){pais = "ALBANIA"; }
    	else if(codigoPais.equals("4")){pais = "ALEMANIA"; }
    	else if(codigoPais.equals("5")){pais = "ALGERIA"; }
    	else if(codigoPais.equals("198")){pais = "ALMIRANTES"; }
    	else if(codigoPais.equals("199")){pais = "ALTO VOLTA"; }
    	else if(codigoPais.equals("6")){pais = "ANDORRA"; }
    	else if(codigoPais.equals("196")){pais = "ANGLONORMANDAS"; }
    	else if(codigoPais.equals("7")){pais = "ANGOLA"; }
    	else if(codigoPais.equals("8")){pais = "ANGUILLA"; }
    	else if(codigoPais.equals("9")){pais = "ANTARCTICA"; }
    	else if(codigoPais.equals("10")){pais = "ANTIGUA Y BARBUDA"; }
    	else if(codigoPais.equals("195")){pais = "ANTILLAS HOLANDESAS"; }
    	else if(codigoPais.equals("11")){pais = "ARABIA SAUDITA"; }
    	else if(codigoPais.equals("200")){pais = "ARGELIA"; }
    	else if(codigoPais.equals("12")){pais = "ARGENTINA"; }
    	else if(codigoPais.equals("13")){pais = "ARMENIA"; }
    	else if(codigoPais.equals("14")){pais = "ARUBA"; }
    	else if(codigoPais.equals("15")){pais = "AUSTRALIA"; }
    	else if(codigoPais.equals("16")){pais = "AUSTRIA"; }
    	else if(codigoPais.equals("17")){pais = "AZERBAIJAN"; }
    	else if(codigoPais.equals("197")){pais = "AZORES"; }
    	else if(codigoPais.equals("18")){pais = "BAHAMAS"; }
    	else if(codigoPais.equals("19")){pais = "BAHREIN"; }
    	else if(codigoPais.equals("20")){pais = "BANGLADESH"; }
    	else if(codigoPais.equals("21")){pais = "BARBADOS"; }
    	else if(codigoPais.equals("204")){pais = "BARBUDA"; }
    	else if(codigoPais.equals("22")){pais = "BELARUS"; }
    	else if(codigoPais.equals("203")){pais = "BELAU"; }
    	else if(codigoPais.equals("23")){pais = "BÉLGICA"; }
    	else if(codigoPais.equals("24")){pais = "BELIZE"; }
    	else if(codigoPais.equals("25")){pais = "BENIN"; }
    	else if(codigoPais.equals("26")){pais = "BERMUDA"; }
    	else if(codigoPais.equals("27")){pais = "BHUTÁN"; }
    	else if(codigoPais.equals("202")){pais = "BIRMANIA"; }
    	else if(codigoPais.equals("28")){pais = "BOLIVIA"; }
    	else if(codigoPais.equals("201")){pais = "BORNEO"; }
    	else if(codigoPais.equals("29")){pais = "BOSNIA Y HERZEGOVINA"; }
    	else if(codigoPais.equals("30")){pais = "BOTSWANA"; }
    	else if(codigoPais.equals("31")){pais = "BRASIL"; }
    	else if(codigoPais.equals("32")){pais = "BRUNEI"; }
    	else if(codigoPais.equals("33")){pais = "BULGARIA"; }
    	else if(codigoPais.equals("34")){pais = "BURKINA FASO"; }
    	else if(codigoPais.equals("35")){pais = "BURUNDI"; }
    	else if(codigoPais.equals("206")){pais = "CAIMAN"; }
    	else if(codigoPais.equals("207")){pais = "CALPE"; }
    	else if(codigoPais.equals("36")){pais = "CAMBOYA"; }
    	else if(codigoPais.equals("37")){pais = "CAMERÚN"; }
    	else if(codigoPais.equals("38")){pais = "CANADÁ"; }
    	else if(codigoPais.equals("213")){pais = "CANARIAS"; }
    	else if(codigoPais.equals("39")){pais = "CAPO VERDE"; }
    	else if(codigoPais.equals("215")){pais = "CEBELES"; }
    	else if(codigoPais.equals("209")){pais = "CEILAN"; }
    	else if(codigoPais.equals("214")){pais = "CEUTA"; }
    	else if(codigoPais.equals("41")){pais = "CHAD"; }
    	else if(codigoPais.equals("208")){pais = "CHECOSLOVAQUIA"; }
    	else if(codigoPais.equals("42")){pais = "CHILE"; }
    	else if(codigoPais.equals("43")){pais = "CHINA"; }
    	else if(codigoPais.equals("52")){pais = "CHIPRE"; }
    	else if(codigoPais.equals("211")){pais = "CLIPPERTON"; }
    	else if(codigoPais.equals("210")){pais = "COCOS"; }
    	else if(codigoPais.equals("44")){pais = "COLOMBIA"; }
    	else if(codigoPais.equals("45")){pais = "COMORO"; }
    	else if(codigoPais.equals("46")){pais = "CONGO"; }
    	else if(codigoPais.equals("212")){pais = "COOK"; }
    	else if(codigoPais.equals("48")){pais = "COREA"; }
    	else if(codigoPais.equals("47")){pais = "COREA DEL SUR"; }
    	else if(codigoPais.equals("50")){pais = "COSTA DE MARFIL"; }
    	else if(codigoPais.equals("49")){pais = "COSTA RICA"; }
    	else if(codigoPais.equals("53")){pais = "CROATIA"; }
    	else if(codigoPais.equals("54")){pais = "DINAMARCA"; }
    	else if(codigoPais.equals("55")){pais = "DJIBOUTI"; }
    	else if(codigoPais.equals("56")){pais = "DOMINICA"; }
    	else if(codigoPais.equals("58")){pais = "DUBAI"; }
    	else if(codigoPais.equals("59")){pais = "ECUADOR"; }
    	else if(codigoPais.equals("60")){pais = "EGIPTO"; }
    	else if(codigoPais.equals("61")){pais = "EL SALVADOR"; }
    	else if(codigoPais.equals("62")){pais = "EMIRATOS ÁRABES UNIDOS"; }
    	else if(codigoPais.equals("63")){pais = "ERITREA"; }
    	else if(codigoPais.equals("216")){pais = "ESCOCIA"; }
    	else if(codigoPais.equals("64")){pais = "ESLOVAQUIA"; }
    	else if(codigoPais.equals("65")){pais = "ESLOVENIA"; }
    	else if(codigoPais.equals("109")){pais = "ESOTHO"; }
    	else if(codigoPais.equals("66")){pais = "ESPAÑA"; }
    	else if(codigoPais.equals("67")){pais = "ESTADOS UNIDOS DE AMERICA"; }
    	else if(codigoPais.equals("68")){pais = "ESTONIA"; }
    	else if(codigoPais.equals("69")){pais = "ETIOPÍA"; }
    	else if(codigoPais.equals("217")){pais = "FEDERACION DE MALAYSIA"; }
    	else if(codigoPais.equals("219")){pais = "FEROE"; }
    	else if(codigoPais.equals("70")){pais = "FIJI"; }
    	else if(codigoPais.equals("71")){pais = "FILIPINAS"; }
    	else if(codigoPais.equals("72")){pais = "FINLANDIA"; }
    	else if(codigoPais.equals("218")){pais = "FORMOSA"; }
    	else if(codigoPais.equals("73")){pais = "FRANCIA"; }
    	else if(codigoPais.equals("74")){pais = "GABÓN"; }
    	else if(codigoPais.equals("75")){pais = "GAMBIA"; }
    	else if(codigoPais.equals("76")){pais = "GEORGIA"; }
    	else if(codigoPais.equals("77")){pais = "GHANA"; }
    	else if(codigoPais.equals("78")){pais = "GIBRALTAR"; }
    	else if(codigoPais.equals("223")){pais = "GILBERT"; }
    	else if(codigoPais.equals("220")){pais = "GRAN BRETAÑA"; }
    	else if(codigoPais.equals("79")){pais = "GRECIA"; }
    	else if(codigoPais.equals("81")){pais = "GRENADA"; }
    	else if(codigoPais.equals("80")){pais = "GROENLANDIA"; }
    	else if(codigoPais.equals("82")){pais = "GUADELUPE"; }
    	else if(codigoPais.equals("222")){pais = "GUAM"; }
    	else if(codigoPais.equals("83")){pais = "GUATEMALA"; }
    	else if(codigoPais.equals("221")){pais = "GUAYANA INGLESA"; }
    	else if(codigoPais.equals("84")){pais = "GUINEA"; }
    	else if(codigoPais.equals("85")){pais = "GUINEA ECUATORIAL"; }
    	else if(codigoPais.equals("224")){pais = "GUINEA PORTUGUESA"; }
    	else if(codigoPais.equals("86")){pais = "GUYANA"; }
    	else if(codigoPais.equals("87")){pais = "HAITI"; }
    	else if(codigoPais.equals("225")){pais = "HAWAI"; }
    	else if(codigoPais.equals("88")){pais = "HOLANDA"; }
    	else if(codigoPais.equals("89")){pais = "HONDURAS"; }
    	else if(codigoPais.equals("90")){pais = "HONG KONG"; }
    	else if(codigoPais.equals("91")){pais = "HUNGRÍA"; }
    	else if(codigoPais.equals("93")){pais = "INDIA"; }
    	else if(codigoPais.equals("94")){pais = "INDONESIA"; }
    	else if(codigoPais.equals("226")){pais = "INGLATERRA"; }
    	else if(codigoPais.equals("95")){pais = "IRAN"; }
    	else if(codigoPais.equals("96")){pais = "IRAQ"; }
    	else if(codigoPais.equals("227")){pais = "IRIAN JAYA"; }
    	else if(codigoPais.equals("97")){pais = "IRLANDA"; }
    	else if(codigoPais.equals("228")){pais = "ISLA HONG KONG"; }
    	else if(codigoPais.equals("92")){pais = "ISLANDIA"; }
    	else if(codigoPais.equals("98")){pais = "ISRAEL"; }
    	else if(codigoPais.equals("99")){pais = "ITALIA"; }
    	else if(codigoPais.equals("100")){pais = "JAMAICA"; }
    	else if(codigoPais.equals("101")){pais = "JAPÓN"; }
    	else if(codigoPais.equals("102")){pais = "JORDANIA"; }
    	else if(codigoPais.equals("230")){pais = "KATAR"; }
    	else if(codigoPais.equals("103")){pais = "KAZAKHSTAN"; }
    	else if(codigoPais.equals("104")){pais = "KENIA"; }
    	else if(codigoPais.equals("229")){pais = "KOWEIT"; }
    	else if(codigoPais.equals("105")){pais = "KUWAIT"; }
    	else if(codigoPais.equals("106")){pais = "KYRGYZSTAN"; }
    	else if(codigoPais.equals("107")){pais = "LATVIA"; }
    	else if(codigoPais.equals("231")){pais = "LESHOTO"; }
    	else if(codigoPais.equals("110")){pais = "LETONIA"; }
    	else if(codigoPais.equals("108")){pais = "LÍBANO"; }
    	else if(codigoPais.equals("111")){pais = "LIBERIA"; }
    	else if(codigoPais.equals("112")){pais = "LIBIA"; }
    	else if(codigoPais.equals("113")){pais = "LIECHTENSTEIN"; }
    	else if(codigoPais.equals("114")){pais = "LITUANIA"; }
    	else if(codigoPais.equals("115")){pais = "LUXEMBURGO"; }
    	else if(codigoPais.equals("116")){pais = "MACEDONIA"; }
    	else if(codigoPais.equals("235")){pais = "MACQUARIE"; }
    	else if(codigoPais.equals("117")){pais = "MADAGASCAR"; }
    	else if(codigoPais.equals("236")){pais = "MADEITA"; }
    	else if(codigoPais.equals("119")){pais = "MALASIA"; }
    	else if(codigoPais.equals("118")){pais = "MALAWI"; }
    	else if(codigoPais.equals("232")){pais = "MALAYSIA"; }
    	else if(codigoPais.equals("120")){pais = "MALDIVES"; }
    	else if(codigoPais.equals("121")){pais = "MALI"; }
    	else if(codigoPais.equals("122")){pais = "MALTA"; }
    	else if(codigoPais.equals("238")){pais = "MAN"; }
    	else if(codigoPais.equals("133")){pais = "MARRUECOS"; }
    	else if(codigoPais.equals("123")){pais = "MARTINICA"; }
    	else if(codigoPais.equals("124")){pais = "MAURITANIA"; }
    	else if(codigoPais.equals("125")){pais = "MAURITIUS"; }
    	else if(codigoPais.equals("126")){pais = "MAYOTTE"; }
    	else if(codigoPais.equals("233")){pais = "MELILLA"; }
    	else if(codigoPais.equals("127")){pais = "MÉXICO"; }
    	else if(codigoPais.equals("128")){pais = "MICRONESIA"; }
    	else if(codigoPais.equals("237")){pais = "MIDWAY"; }
    	else if(codigoPais.equals("129")){pais = "MOLDOVA"; }
    	else if(codigoPais.equals("234")){pais = "MOLUCA"; }
    	else if(codigoPais.equals("130")){pais = "MÓNACO"; }
    	else if(codigoPais.equals("131")){pais = "MONGOLIA"; }
    	else if(codigoPais.equals("132")){pais = "MONTSERRAT"; }
    	else if(codigoPais.equals("134")){pais = "MOZAMBIQUE"; }
    	else if(codigoPais.equals("135")){pais = "NAMIBIA"; }
    	else if(codigoPais.equals("136")){pais = "NEPAL"; }
    	else if(codigoPais.equals("138")){pais = "NICARAGUA"; }
    	else if(codigoPais.equals("139")){pais = "NIGER"; }
    	else if(codigoPais.equals("140")){pais = "NIGERIA"; }
    	else if(codigoPais.equals("239")){pais = "NORFOLK"; }
    	else if(codigoPais.equals("141")){pais = "NORUEGA"; }
    	else if(codigoPais.equals("240")){pais = "NUEVA CALEDONIA"; }
    	else if(codigoPais.equals("137")){pais = "NUEVA ZELANDIA"; }
    	else if(codigoPais.equals("142")){pais = "OMÁN"; }
    	else if(codigoPais.equals("243")){pais = "PALAU"; }
    	else if(codigoPais.equals("145")){pais = "PALESTINA"; }
    	else if(codigoPais.equals("146")){pais = "PANAMÁ"; }
    	else if(codigoPais.equals("147")){pais = "PAPUA NUEVA GUINEA"; }
    	else if(codigoPais.equals("144")){pais = "PAQUISTÁN"; }
    	else if(codigoPais.equals("148")){pais = "PARAGUAY"; }
    	else if(codigoPais.equals("244")){pais = "PASCUA"; }
    	else if(codigoPais.equals("149")){pais = "PERÚ"; }
    	else if(codigoPais.equals("245")){pais = "PITCAIRN"; }
    	else if(codigoPais.equals("246")){pais = "POLONESIA FRANCESA"; }
    	else if(codigoPais.equals("150")){pais = "POLONIA"; }
    	else if(codigoPais.equals("241")){pais = "POPULAR DE CHINA"; }
    	else if(codigoPais.equals("242")){pais = "POPULAR DE COREA"; }
    	else if(codigoPais.equals("151")){pais = "PORTUGAL"; }
    	else if(codigoPais.equals("152")){pais = "PUERTO RICO"; }
    	else if(codigoPais.equals("153")){pais = "QATAR"; }
    	else if(codigoPais.equals("154")){pais = "REINO UNIDO"; }
    	else if(codigoPais.equals("247")){pais = "REPUBLICA ARABE DE EJIPTO"; }
    	else if(codigoPais.equals("40")){pais = "REPÚBLICA CENTROAFRICANA"; }
    	else if(codigoPais.equals("51")){pais = "REPÚBLICA CHECA"; }
    	else if(codigoPais.equals("248")){pais = "REPUBLICA DE AFRICA ECUATORIAL"; }
    	else if(codigoPais.equals("57")){pais = "REPÚBLICA DOMINICANA"; }
    	else if(codigoPais.equals("155")){pais = "REUNION"; }
    	else if(codigoPais.equals("156")){pais = "ROMANIA"; }
    	else if(codigoPais.equals("157")){pais = "RUSSIA"; }
    	else if(codigoPais.equals("158")){pais = "RWANDA"; }
    	else if(codigoPais.equals("250")){pais = "SALOMON DEL SUR"; }
    	else if(codigoPais.equals("159")){pais = "SAMOA"; }
    	else if(codigoPais.equals("160")){pais = "SAN MARINO"; }
    	else if(codigoPais.equals("251")){pais = "SANTA LUCIA"; }
    	else if(codigoPais.equals("161")){pais = "SAO TOME Y PRÍNCIPE"; }
    	else if(codigoPais.equals("162")){pais = "SENEGAL"; }
    	else if(codigoPais.equals("163")){pais = "SEYCHELLES"; }
    	else if(codigoPais.equals("164")){pais = "SIERRA LEONA"; }
    	else if(codigoPais.equals("165")){pais = "SINGAPUR"; }
    	else if(codigoPais.equals("166")){pais = "SIRIA"; }
    	else if(codigoPais.equals("249")){pais = "SOCOTORRA"; }
    	else if(codigoPais.equals("167")){pais = "SOMALIA"; }
    	else if(codigoPais.equals("169")){pais = "SRI LANKA"; }
    	else if(codigoPais.equals("170")){pais = "SUDÁN"; }
    	else if(codigoPais.equals("173")){pais = "SUECIA"; }
    	else if(codigoPais.equals("174")){pais = "SUIZA"; }
    	else if(codigoPais.equals("168")){pais = "SURÁFRICA"; }
    	else if(codigoPais.equals("171")){pais = "SURINAME"; }
    	else if(codigoPais.equals("172")){pais = "SWAZILANDIA"; }
    	else if(codigoPais.equals("178")){pais = "TAILANDIA"; }
    	else if(codigoPais.equals("175")){pais = "TAIWÁN"; }
    	else if(codigoPais.equals("176")){pais = "TAJIKISTAN"; }
    	else if(codigoPais.equals("177")){pais = "TANZANIA"; }
    	else if(codigoPais.equals("252")){pais = "TIMOR"; }
    	else if(codigoPais.equals("179")){pais = "TOGO"; }
    	else if(codigoPais.equals("253")){pais = "TOKELAU"; }
    	else if(codigoPais.equals("181")){pais = "TONGA"; }
    	else if(codigoPais.equals("181")){pais = "TRINIDAD Y TOBAGO"; }
    	else if(codigoPais.equals("182")){pais = "TÚNEZ"; }
    	else if(codigoPais.equals("184")){pais = "3TURKMENISTAN"; }
    	else if(codigoPais.equals("183")){pais = "TURQUÍA"; }
    	else if(codigoPais.equals("254")){pais = "TUVALU"; }
    	else if(codigoPais.equals("185")){pais = "UCRANIA"; }
    	else if(codigoPais.equals("186")){pais = "UGANDA"; }
    	else if(codigoPais.equals("187")){pais = "URUGUAY"; }
    	else if(codigoPais.equals("188")){pais = "UZBEKISTAN"; }
    	else if(codigoPais.equals("257")){pais = "VATICANO"; }
    	else if(codigoPais.equals("189")){pais = "VENEZUELA"; }
    	else if(codigoPais.equals("190")){pais = "VIETNAM"; }
    	else if(codigoPais.equals("256")){pais = "VIRGENES AMERICAS"; }
    	else if(codigoPais.equals("255")){pais = "VIRGENES BRITANICAS"; }
    	else if(codigoPais.equals("258")){pais = "WAKE"; }
    	else if(codigoPais.equals("259")){pais = "WALLIS"; }
    	else if(codigoPais.equals("191")){pais = "YEMEN"; }
    	else if(codigoPais.equals("192")){pais = "YUGOSLAVIA"; }
    	else if(codigoPais.equals("183")){pais = "ZAMBIA"; }
    	else if(codigoPais.equals("194")){pais = "ZIMBABWE"; }
    	
		return pais;

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
