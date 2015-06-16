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
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable; 


public class ImprimirEncuestaSatisfaccion extends HttpServlet {

	private static final long serialVersionUID 	= 1L;

	private AuxSolicitudGeneral 				auxSolicitudGeneral 	= new AuxSolicitudGeneral();
	private AuxSolicitudEncuestaSatisfaccion 	auxEncuesta 			= new AuxSolicitudEncuestaSatisfaccion();
    private Font 								catFont 				= new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL,BaseColor.BLACK);
    private Font 								catFont2 				= new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD,BaseColor.BLACK);
    
    private RecursosHumanosServiceImpl 			recursosHumanosService 	= new  RecursosHumanosServiceImpl();
    private SolucionesConstruidasServiceImpl 	solucionesService 		= new SolucionesConstruidasServiceImpl();
    
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
    		long idEmpleado 		= Long.parseLong(request.getParameter("id_Empleado"));
    		String valor 			= request.getParameter("value_send");
    		long idFormulario		= Long.parseLong(request.getParameter("id_formulario"));
    		long idEncuesta			= Long.parseLong(request.getParameter("id_encuesta")); 		
    		
    		System.out.println("VALOR RECIBIDO: " + valor);
    		System.out.println("Formulario recibido: " + idFormulario + ", Id de encuesta: " + idEncuesta);

    		if(valor.equals("1")) {

    			OutputStream out 			= response.getOutputStream();
    			
    			try {

    				Document document 	= new Document();
    				PdfWriter.getInstance(document, out);
    				Image image1 		= null ;
    				image1 			= Image.getInstance("images/imagenempresa.png");

    				document.open();

    				image1.setAlignment(Element.ALIGN_CENTER);
    				image1.scaleAbsolute(50.0f, 50.0f);
    				document.add(image1);

    				document.add(new Paragraph("\t",catFont));
    				document.add(new Paragraph("Nombre de solicitante:" ,catFont));
    				document.add(new Paragraph("                                        _____________________________________________________________________________________",catFont));
    				
    				document.add(new Paragraph("\t",catFont));
    				document.add(new Paragraph("Departamento:" ,catFont));
    				document.add(new Paragraph("                                        _____________________________________________________________________________________",catFont));
    				
    				document.add(new Paragraph("\t",catFont));
    				document.add(new Paragraph("\t",catFont));
    				document.add(new Paragraph("1. ¿Cómo considera la ubicación de nuestra oficina?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("2. ¿Cómo califica el orden y limpieza de nuestras instalaciones?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("3. ¿Cómo considera el ambiente de nuestra oficina?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("4. ¿Cómo fue el trato que recibió por parte del personal?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("5. ¿Recibió información clara de nuestros productos y servicios?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("6. ¿Resolvieron sus dudas correctamente y con rapidez?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("7. ¿Recibió asesoría para completar los requisitos solicitados?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("8. ¿Entregaron su producto en el tiempo ofrecido? " ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("9. ¿Cómo califica la calidad de los materiales de construcción?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("10. ¿Cómo califica la calidad de los acabados de su vivienda?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("11. ¿Considera últil el contenido de las capacitaciones?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("12. ¿Ha puesto en práctica el conocimiento recibido?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("13. ¿Cómo considera la asistencia técnica constructiva que recibió?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("14. En general ¿Cómo considera su experiencia con nosotros?" ,catFont));
    				document.add(new Paragraph("                    Muy Bueno                    Bueno                    Regular                    Malo                    Muy Malo",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("15. ¿Cómo se entero de nuestros productos y servicios?" ,catFont));
    				document.add(new Paragraph("                    Television               Radio               Prensa/Revista               Perifoneo               Ferias               Ferreterías",catFont));

    				document.add(new Paragraph("\t",catFont));		            
    				document.add(new Paragraph("16. ¿Recomendaría nuestros productos y servicios?" ,catFont));
    				document.add(new Paragraph("Observación: Considerando que 1 es la nota más baja y 5 la más alta.",catFont));
    				document.add(new Paragraph("                    1                         2                         3                         4                         5",catFont));

    				document.close();

    			}catch (DocumentException exc){
    				throw new IOException(exc.getMessage());
    			}
    			finally {            
    				out.close();
    			}

    		}else if(valor.equals("2")){

    			if(idEncuesta != 0){

    				auxSolicitudGeneral		= solucionesService.obtenerDataFormularioRegistrado(idFormulario);
    				auxEncuesta				= solucionesService.consultaEncuestaSatisfaccion(idFormulario, idEncuesta);

    				OutputStream out 			= response.getOutputStream();

    				try {

    					Document document 	= new Document();
    					PdfWriter.getInstance(document, out);
    					Image image1 		= null ;
    					image1 			= Image.getInstance("images/imagenempresa.png");

    					document.open();

    					image1.setAlignment(Element.ALIGN_CENTER);
    					image1.scaleAbsolute(50.0f, 50.0f);
    					document.add(image1);

    					document.add(new Paragraph("\t",catFont));
    					document.add(new Paragraph("Nombre de solicitante:" ,catFont));
    					document.add(new Paragraph("                                        " + auxSolicitudGeneral.getNombreSolicitante() ,catFont2));

    					document.add(new Paragraph("\t",catFont));
    					document.add(new Paragraph("Departamento:" ,catFont));
    					document.add(new Paragraph("                                        " + getDepartamento(auxEncuesta.getDepartamento()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));
    					document.add(new Paragraph("\t",catFont));
    					document.add(new Paragraph("1. ¿Cómo considera la ubicación de nuestra oficina?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo1()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("2. ¿Cómo califica el orden y limpieza de nuestras instalaciones?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo2()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("3. ¿Cómo considera el ambiente de nuestra oficina?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo3()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("4. ¿Cómo fue el trato que recibió por parte del personal?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo4()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("5. ¿Recibió información clara de nuestros productos y servicios?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo5()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("6. ¿Resolvieron sus dudas correctamente y con rapidez?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo6()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("7. ¿Recibió asesoría para completar los requisitos solicitados?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo7()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("8. ¿Entregaron su producto en el tiempo ofrecido? ",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo8()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("9. ¿Cómo califica la calidad de los materiales de construcción?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo9()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("10. ¿Cómo califica la calidad de los acabados de su vivienda?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo10()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("11. ¿Considera últil el contenido de las capacitaciones?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo11()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("12. ¿Ha puesto en práctica el conocimiento recibido?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo12()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("13. ¿Cómo considera la asistencia técnica constructiva que recibió?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo13()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("14. En general ¿Cómo considera su experiencia con nosotros?",catFont));
    					document.add(new Paragraph("                                        " + getPregunta(auxEncuesta.getPreguntaNo14()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("15. ¿Cómo se entero de nuestros productos y servicios?",catFont));
    					document.add(new Paragraph("                                        " + getServicio(auxEncuesta.getPreguntaNo15()) ,catFont2));

    					document.add(new Paragraph("\t",catFont));		            
    					document.add(new Paragraph("16. ¿Recomendaría nuestros productos y servicios?",catFont));
    					document.add(new Paragraph("Observación: Considerando que 1 es la nota más baja y 5 la más alta.",catFont));
    					document.add(new Paragraph("                                        " + auxEncuesta.getPreguntaNo16() ,catFont2));

    					document.close();

    				}catch (DocumentException exc){
    					throw new IOException(exc.getMessage());
    				}
    				finally {            
    					out.close();
    				}

    			}else{

    				System.out.println("No existen datos almacenados");

    			}
    		}
    		
    	}
    }

    private String getPregunta(String codigoPregunta){
    	
    	String pregunta = "";
    	
    	if(codigoPregunta.equals("1")){
    		pregunta =  "Muy bueno"; 
    	}
    	else if(codigoPregunta.equals("2")){
    		pregunta = "Bueno"; 
    	}
    	else if(codigoPregunta.equals("3")){
    		pregunta = "Regular"; 
    	}
    	else if(codigoPregunta.equals("4")){
    		pregunta = "Malo"; 
    	}
    	else if(codigoPregunta.equals("5")){
    		pregunta = "Muy Malo"; 
    	}
    	return pregunta;
    	
    }
    
    private String getServicio(String codigoServicio){
    	
    	String servicio = "";
    	
    	if(codigoServicio.equals("1")){
    		servicio =  "Televisión"; 
    	}
    	else if(codigoServicio.equals("2")){
    		servicio = "Radio"; 
    	}
    	else if(codigoServicio.equals("3")){
    		servicio = "Prensa/Revista"; 
    	}
    	else if(codigoServicio.equals("4")){
    		servicio = "Volantes"; 
    	}
    	else if(codigoServicio.equals("5")){
    		servicio = "Perifoneo"; 
    	}
    	else if(codigoServicio.equals("6")){
    		servicio = "Ferias"; 
    	}
    	else if(codigoServicio.equals("7")){
    		servicio = "Ferreterias"; 
    	}
    	return servicio;
    	
    }
    
    private String getDepartamento(String valDepto){
    	
    	String departamento = "";
    	
		if(valDepto.equals("1")){
			departamento = "Petén";
		}else if(valDepto.equals("2")){
			departamento = "Izabal";
		}else if(valDepto.equals("3")){
			departamento = "Alta Verapaz";
		}else if(valDepto.equals("4")){
			departamento = "Quiché";
		}else if(valDepto.equals("5")){
			departamento = "Huehuetenango";
		}else if(valDepto.equals("6")){
			departamento = "Escuintla";
		}else if(valDepto.equals("7")){
			departamento = "San Marcos";
		}else if(valDepto.equals("8")){
			departamento = "Jutiapa";
		}else if(valDepto.equals("9")){
			departamento = "Baja Verapaz";
		}else if(valDepto.equals("10")){
			departamento = "Santa Rosa";
		}else if(valDepto.equals("11")){
			departamento = "Zacapa";
		}else if(valDepto.equals("12")){
			departamento = "Suchitepéquez";
		}else if(valDepto.equals("13")){
			departamento = "Chiquimula";
		}else if(valDepto.equals("14")){
			departamento = "Guatemala";
		}else if(valDepto.equals("15")){
			departamento = "Jalapa";
		}else if(valDepto.equals("16")){
			departamento = "Chimaltenango";
		}else if(valDepto.equals("17")){
			departamento = "Quetzaltenango";
		}else if(valDepto.equals("18")){
			departamento = "El Progreso";
		}else if(valDepto.equals("19")){
			departamento = "Retalhuleu";
		}else if(valDepto.equals("20")){
			departamento = "Sololá";
		}else if(valDepto.equals("21")){
			departamento = "Totonicapán";
		}else if(valDepto.equals("22")){
			departamento = "Sacatepéquez";
		}	
    	return departamento;
    	
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
