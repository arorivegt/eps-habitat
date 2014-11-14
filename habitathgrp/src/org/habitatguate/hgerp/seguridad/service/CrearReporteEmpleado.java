package org.habitatguate.hgerp.seguridad.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVacaciones;

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
import com.itextpdf.text.pdf.PdfWriter;

import java.util.Date;



public class CrearReporteEmpleado extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private List<AuxEmpleado> empl = new ArrayList<AuxEmpleado>();
    private Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD, BaseColor.BLACK);
    private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.NORMAL,BaseColor.BLACK);
    private RecursosHumanosServiceImpl loginService = new  RecursosHumanosServiceImpl();
    private SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat();
	//invoked from doGet method to create PDF through servlet 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Set content type to application / pdf
        //browser will open the document only if this is set
        response.setContentType("application/pdf");

        char tipo = '1';
        String crear = request.getParameter("crear");
        String estado = request.getParameter("estado");
        String familia = request.getParameter("familia");
        String academico = request.getParameter("academico");
        String reflaboral = request.getParameter("reflaboral");
        String refpersonal = request.getParameter("refpersonal");
        String idioma = request.getParameter("idioma");
        String desempeno = request.getParameter("desempeno");
        String evaluacion = request.getParameter("evaluacion");
        String historial = request.getParameter("historial");
        String vacaciones = request.getParameter("vacaciones");
        // String bono14 = request.getParameter("bono14");
        // String aguinaldo = request.getParameter("aguinaldo");
        //String indemnizacion = request.getParameter("indemnizacion");
        
        if(crear.equals("Todos")){
        	tipo = '2';
		}
		else if(crear.equals("Estado")){
        	tipo = '5';
		}
        empl = loginService.Buscar_Empleado(tipo, "", "", "", "","", "",estado);
        
        OutputStream out = response.getOutputStream();
       
			//Get the output stream for writing PDF object  zzz
	        try {
	            Document document = new Document();
	            /* Basic PDF Creation inside servlet */
	            PdfWriter.getInstance(document, out);
	            document.open();
	            for(AuxEmpleado p : empl) {
	            //titulo es el Nombre del Empleado + algunos datos
		            document.add(new Paragraph("........................................................"
		            		+ "......................................................"
		            		+ "........................................................",catFont));
	            document.add(new Paragraph("Nombre:"+" "+p.getPrimer_nombre()+" "+p.getSegundo_nombre()+","+p.getPrimer_apellido()+" "+p.getSegundo_apellido(), redFont));
	            document.add(new Paragraph("Sexo:"+" "+p.getSexo(), redFont));
	            document.add(new Paragraph("Email:"+" "+p.getEmail(), redFont));
	            document.add(new Paragraph("Pais:"+" "+p.getPais(), redFont));
	            document.add(new Paragraph("Sexo:"+" "+p.getCelular(), redFont));
	            document.add(new Paragraph(" "));
	           if(familia.equals("true") ){
	        	   boolean valor = true;
	            	for(AuxFamilia f : p.getFamilia()) {
	            		if(valor){
	    		            document.add(new Paragraph("Historial Familiar",catFont));
	    		            document.add(new Paragraph(" "));
	    		            valor = false;
	            		}
    		            document.add(new Paragraph(" "));
		            	document.add(CrearFamilia(f));
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
    		            document.add(new Paragraph(" "));
		            	document.add(CrearAcademico(f));
	            	}
	            }
	           if(reflaboral.equals("true")){
	        	   boolean valor = true;
	            	for(AuxReferenciaLaboral f : p.getReferencia_laboral()) {
	            		if(valor){
	    		            document.add(new Paragraph("Referencia Laboral",catFont));
	    		            document.add(new Paragraph(" "));
	    		            valor = false;
	            		}
    		            document.add(new Paragraph(" "));
		            	document.add(CrearRefLaboral(f));
	            	}
	           }
	           if(refpersonal.equals("true")){
	        	   boolean valor = true;
	            	for(AuxReferenciaPersonal f : p.getReferencia_personal()) {
	            		if(valor){
	    		            document.add(new Paragraph("Referencia Personal",catFont));
	    		            document.add(new Paragraph(" "));
	    		            valor = false;
	            		}
    		            document.add(new Paragraph(" "));
		            	document.add(CrearRefPersonal(f));
	            	}
	            }
	            if(idioma.equals("true")){
		        	   boolean valor = true;
	            	for(AuxIdioma f : p.getIdiomas()) {
	            		if(valor){
	    		            document.add(new Paragraph("Historial de Idiomas",catFont));
	    		            document.add(new Paragraph(" "));
	    		            valor = false;
	            		}
    		            document.add(new Paragraph(" "));
		            	document.add(CrearIdioma(f));
	            	}
	            }
	            if(desempeno.equals("true")){
		        	   boolean valor = true;
	            	for(AuxTest f : p.getTest()) {
	            		if(f.getTipo_test().equals("1")){
		            		if(valor){
		    		            document.add(new Paragraph("Desempeños",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
	    		            document.add(new Paragraph(" "));
	            			document.add(CrearDesempeno(f));
	            		}
	            	}
	            }
	            if(evaluacion.equals("true")){
		        	 boolean valor = true;
	            	for(AuxTest f : p.getTest()) {
	            		if(f.getTipo_test().equals("2")){
		            		if(valor){
		    		            document.add(new Paragraph("Evaluacion",catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
	    		            document.add(new Paragraph(" "));
	            			document.add(CrearEvaluacion(f));
	            		}
	            	}
	            }
	            if(historial.equals("true")){
	            	boolean valor = true;
	            	for(AuxHistorial f : p.getHistorial()) {
		            		if(valor){
		    		            document.add(new Paragraph("Historial Ausencias, "
		    		            		+ "Permisos, Aciertor y llamadas de atencion",
		    		            		catFont));
		    		            document.add(new Paragraph(" "));
		    		            valor = false;
		            		}
	    		            document.add(new Paragraph(" "));
	            			document.add(CrearHistorial(f));
	            		
	            	}
	            }
	            if(vacaciones.equals("true")){
		        	   boolean valor = true;
	            	for(AuxVacaciones f : p.getVacaciones()) {
	            		if(valor){
	    		            document.add(new Paragraph("Historial Vacaciones",catFont));
	    		            document.add(new Paragraph(" "));
	    		            valor = false;
	            		}
    		            document.add(new Paragraph(" "));
	            		document.add(CrearVacaciones(f));
	            	}
	            }
	           }/* 
	            if(bono14.equals("true"))
	            	document.add(CrearFamilia());
	            if(bono14.equals("true"))
	            	document.add(CrearFamilia());
	            if(aguinaldo.equals("true"))
	            	document.add(CrearFamilia());
	            if(indemnizacion.equals("true"))
	            	document.add(CrearFamilia());*/
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
        table.addCell(new Paragraph(f.getNivel_academico(),catFont));
        
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
        table.addCell(new Paragraph("Telefono",redFont));
        table.addCell(new Paragraph(f.getIdioma(),catFont));
        table.addCell(new Paragraph(f.getNivel(),catFont));
        table.setHeaderRows(1);
        return table;
    }
    
    public PdfPTable CrearDesempeno(AuxTest f) {
		String AnnioTest =  ""+fecha.format(fecha.format(new Date(f.getFecha_test())));

		int valor = f.getPregunta1() + f.getPregunt2() + f.getPregunta3()
				+f.getPregunta4()+f.getPregunta5() +f.getPregunta6()
				+f.getPregunta7()+f.getPregunta8()+f.getPregunta9()
				+f.getPregunta10();
    	PdfPTable table = new PdfPTable(3);
    	

        table.addCell(new Paragraph("Evaluador",redFont));
        table.addCell(new Paragraph("Fecha",redFont));
        table.addCell(new Paragraph("Punteo",redFont));
        table.addCell(new Paragraph(f.getEvaluador(),catFont));
        table.addCell(new Paragraph(AnnioTest,catFont));
        table.addCell(new Paragraph(""+valor,catFont));
        
        
        table.setHeaderRows(1);
        return table;
    }
    
    public PdfPTable CrearEvaluacion(AuxTest f) {
		String AnnioTest =  ""+fecha.format(new Date(f.getFecha_test()));

		int valor = f.getPregunta1() + f.getPregunt2() + f.getPregunta3()
				+f.getPregunta4()+f.getPregunta5() +f.getPregunta6()
				+f.getPregunta7()+f.getPregunta8()+f.getPregunta9()
				+f.getPregunta10();
    	PdfPTable table = new PdfPTable(3);
    	
    	PdfPCell c1 = new PdfPCell(new Phrase("Evaluador",redFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Fecha",redFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Punteo",redFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);

        table.addCell(f.getEvaluador());
        table.addCell(AnnioTest);
        table.addCell(""+valor);
        return table;
    }
    public PdfPTable CrearPuesto(AuxPuesto f) {
		String AnnioPuesto = ""+fecha.format(new Date(f.getFecha_puesto()));
    	PdfPTable table = new PdfPTable(3);
    	
    	PdfPCell c1 = new PdfPCell(new Phrase("Puesto",redFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Salario",redFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("fecha",redFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);

        table.addCell(f.getNombre_puesto());
        table.addCell(""+0);
        table.addCell(AnnioPuesto);
        return table;
    }
    public PdfPTable CrearHistorial(AuxHistorial f) {
 		String Annio = ""+fecha.format(new Date(f.getFecha()));
     	PdfPTable table = new PdfPTable(2);
     	
     	PdfPCell c1 = new PdfPCell(new Phrase("Tipo Historial",redFont));
         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(c1);
         
         c1 = new PdfPCell(new Phrase("fecha",redFont));
         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(c1);
         
         table.setHeaderRows(1);

         table.addCell(f.getTipo_historial());
         table.addCell(Annio);
         return table;
     }
    public PdfPTable CrearVacaciones(AuxVacaciones f) {
 		String Annio1 = ""+fecha.format(new Date(f.getFecha1()));
 		String Annio2 = ""+fecha.format(new Date(f.getFecha2()));
     	PdfPTable table = new PdfPTable(2);
     	
     	PdfPCell c1 = new PdfPCell(new Phrase("Desde la fecha",redFont));
         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(c1);
         
         c1 = new PdfPCell(new Phrase("Hasta la fecha",redFont));
         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(c1);
         
         table.setHeaderRows(1);

         table.addCell(Annio1);
         table.addCell(Annio2);
         return table;
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
