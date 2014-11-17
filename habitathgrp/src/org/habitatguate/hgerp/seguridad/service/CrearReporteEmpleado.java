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
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
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
	            			document.add(CrearTest(f));
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
	            			document.add(CrearTest(f));
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
		else if(f.getIdioma().equals("19"))
        	table.addCell(new Paragraph("Sipakapense"));
		else if(f.getIdioma().equals("20"))
        	table.addCell(new Paragraph("Tektiteko"));
		else if(f.getIdioma().equals("21"))
        	table.addCell(new Paragraph("tz'utujil"));
		else if(f.getIdioma().equals("22"))
        	table.addCell(new Paragraph("Uspanteko"));
		else if(f.getIdioma().equals("23"))
        	table.addCell(new Paragraph("Garelse ifuna"));
		else if(f.getIdioma().equals("24"))
        	table.addCell(new Paragraph("Español"));
		else if(f.getIdioma().equals("25"))
        	table.addCell(new Paragraph("Ingles"));
		else if(f.getIdioma().equals("26"))
        	table.addCell(new Paragraph("Frances"));
		else if(f.getIdioma().equals("27"))
        	table.addCell(new Paragraph("Aleman"));
		else if(f.getIdioma().equals("28"))
        	table.addCell(new Paragraph("Italiano"));
		else if(f.getIdioma().equals("29"))
        	table.addCell(new Paragraph("Coreano"));
		else if(f.getIdioma().equals("30"))
        	table.addCell(new Paragraph("Japones"));
		else if(f.getIdioma().equals("31"))
        	table.addCell(new Paragraph("Mandarin"));
		else if(f.getIdioma().equals("32"))
        	table.addCell(new Paragraph("Cantones"));
		else if(f.getIdioma().equals("33"))
        	table.addCell(new Paragraph("Tailandes"));
		else if(f.getIdioma().equals("34"))
        	table.addCell(new Paragraph("Portugues"));
		else if(f.getIdioma().equals("1"))
        	table.addCell(new Paragraph("Arabe"));
		else if(f.getIdioma().equals("1"))
        	table.addCell(new Paragraph("Hebreo"));
		else if(f.getIdioma().equals("1"))
        	table.addCell(new Paragraph("Griego"));
		else if(f.getIdioma().equals("1"))
        	table.addCell(new Paragraph("Neerlandes"));
		else if(f.getIdioma().equals("1"))
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
		String AnnioTest =  ""+fecha.format(fecha.format(new Date(f.getFecha_test())));
		int valor = f.getPregunta1() + f.getPregunt2() + f.getPregunta3()
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
		String AnnioPuesto = ""+fecha.format(new Date(f.getFecha_puesto()));
    	PdfPTable table = new PdfPTable(3);

        table.addCell(new Paragraph("Puesto",redFont));
        table.addCell(new Paragraph("Fecha del Puesto",redFont));
        table.addCell(new Paragraph("Horas por trabajo",redFont));
        table.addCell(new Paragraph(f.getNombre_puesto(),catFont));
        table.addCell(new Paragraph(AnnioPuesto,catFont));
        table.addCell(new Paragraph(f.getHorasTrabajo(),catFont));

        table.addCell(new Paragraph("Funciones",redFont));
        table.addCell(new Paragraph("Jornada",redFont));
        table.addCell(new Paragraph("Puesto Activo",redFont));
        table.addCell(new Paragraph(f.getFunciones(),catFont));
        table.addCell(new Paragraph(f.getJornada(),catFont));
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
        table.addCell(new Paragraph(f.getTipo_historial(),catFont));
        
        table.addCell(new Paragraph("Fecha Creacion",redFont));
        table.addCell(new Paragraph(Annio,catFont));
        return table;
    }
    
    public PdfPTable CrearVacaciones(AuxVacaciones f) {
 		String Annio1 = ""+fecha.format(new Date(f.getFecha1()));
 		String Annio2 = ""+fecha.format(new Date(f.getFecha2()));
     	PdfPTable table = new PdfPTable(2);

        table.addCell(new Paragraph("Descripcion",redFont));
        table.addCell(new Paragraph("Tipo Permiso",redFont));
        table.addCell(new Paragraph(f.getDescripcion(),catFont));
        table.addCell(new Paragraph(f.getTipoPermisos(),catFont));
        
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
        table.addCell(new Paragraph(f.getTipoSalario(),catFont));
        
        table.addCell(new Paragraph("Fecha",redFont));
        table.addCell(new Paragraph("Monto",redFont));
        table.addCell(new Paragraph(Annio,catFont));
        table.addCell(new Paragraph(""+f.getSalario(),catFont));
       
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
