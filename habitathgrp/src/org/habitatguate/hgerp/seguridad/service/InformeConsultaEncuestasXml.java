package org.habitatguate.hgerp.seguridad.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_ReporteDatosSolucionesConstruidas;


public class InformeConsultaEncuestasXml {
    
    private SolucionesConstruidasServiceImpl solucionesService = new SolucionesConstruidasServiceImpl();
    
	    private String xmlInicio 							 	= "<table><tbody>"
																+"<tr>"
																+"<td>No.</td>"					// 1
																+"<td>Nombre Solicitante</td>"	// 2
																+"<td>Departamento</td>"		// 3
																+"<td>Pregunta 1</td>"			// 4
																+"<td>Pregunta 2</td>"			// 5
																+"<td>Pregunta 3</td>"			// 6
																+"<td>Pregunta 4</td>"			// 7
																+"<td>Pregunta 5</td>"			// 8
																+"<td>Pregunta 6</td>"			// 9
																+"<td>Pregunta 7</td>"			// 10
																+"<td>Pregunta 8</td>"			// 11
																+"<td>Pregunta 9</td>"			// 12
																+"<td>Pregunta 10</td>"			// 13
																+"<td>Pregunta 11</td>"			// 14
																+"<td>Pregunta 12</td>"			// 15
																+"<td>Pregunta 13</td>"			// 16
																+"<td>Pregunta 14</td>"			// 17
																+"<td>Pregunta 15</td>"			// 18
																+"<td>Pregunta 16</td>"			// 19
																+"</tr>";

		String  xmlFinal 										= "</tbody></table>";
		
	    private int i = 1;
	
	public String busqueda(char tipo, long idEmpleado, long idAfiliado, String solucion){
		
		DecimalFormat df 			= new DecimalFormat();
		df.setMaximumFractionDigits(2);

	    List<AuxSolicitudGeneral> result 	= new ArrayList<AuxSolicitudGeneral>();
	    
		result = solucionesService.buscarFormulario(tipo, idEmpleado, idAfiliado, "", solucion);

	    
				i = 1;
				
				for (AuxSolicitudGeneral p : result) {
					try{
						
						setDataEncuestaSatisfaccion(p.getEncuestaSatisfaccion(), p.getNombreSolicitante());
						
					}catch(Exception e){
					}
				}

		 		xmlInicio = xmlInicio + xmlFinal;
		 		System.out.println(xmlInicio);

		return xmlInicio;
	}
	
	
	public void setDataEncuestaSatisfaccion(List<AuxSolicitudEncuestaSatisfaccion> results, String nombre){
		
		for ( AuxSolicitudEncuestaSatisfaccion n2 : results) {

			
			// 1. Numero Correlativo.
			xmlInicio += "<td>"+i+"</td>";
			
			// 2. Nombre Solicitante
			xmlInicio += "<td>"+nombre+"</td>";
			
			// 3. Departamento
			String valDepto = "";
			valDepto = n2.getDepartamento();
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
			xmlInicio += "<td>"+departamento+"</td>";
			
			// 4. Pregunta 1
			String valP1 = "";
			valP1 = n2.getPreguntaNo1();
			String pregunta1 = "";
			if(valP1.equals("1")){
				pregunta1 = "Muy bueno";
			}else if(valP1.equals("2")){
				pregunta1 = "Bueno";
			}else if(valP1.equals("3")){
				pregunta1 = "Regular";
			}else if(valP1.equals("4")){
				pregunta1 = "Malo";
			}else if(valP1.equals("5")){
				pregunta1 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta1+"</td>";

			// 5. Pregunta 2
			String valP2 = "";
			valP2 = n2.getPreguntaNo2();
			String pregunta2 = "";
			if(valP2.equals("1")){
				pregunta2 = "Muy bueno";
			}else if(valP2.equals("2")){
				pregunta2 = "Bueno";
			}else if(valP2.equals("3")){
				pregunta2 = "Regular";
			}else if(valP2.equals("4")){
				pregunta2 = "Malo";
			}else if(valP2.equals("5")){
				pregunta2 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta2+"</td>";
			
			// 6. Pregunta 3
			String valP3 = "";
			valP3 = n2.getPreguntaNo3();
			String pregunta3 = "";
			if(valP3.equals("1")){
				pregunta3 = "Muy bueno";
			}else if(valP3.equals("2")){
				pregunta3 = "Bueno";
			}else if(valP3.equals("3")){
				pregunta3 = "Regular";
			}else if(valP3.equals("4")){
				pregunta3 = "Malo";
			}else if(valP3.equals("5")){
				pregunta3 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta3+"</td>";
			
			// 7. Pregunta 4
			String valP4 = "";
			valP4 = n2.getPreguntaNo4();
			String pregunta4 = "";
			if(valP4.equals("1")){
				pregunta4 = "Muy bueno";
			}else if(valP4.equals("2")){
				pregunta4 = "Bueno";
			}else if(valP4.equals("3")){
				pregunta4 = "Regular";
			}else if(valP4.equals("4")){
				pregunta4 = "Malo";
			}else if(valP4.equals("5")){
				pregunta4 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta4+"</td>";
			
			// 8. Pregunta 5
			String valP5 = "";
			valP5 = n2.getPreguntaNo5();
			String pregunta5 = "";
			if(valP5.equals("1")){
				pregunta5 = "Muy bueno";
			}else if(valP5.equals("2")){
				pregunta5 = "Bueno";
			}else if(valP5.equals("3")){
				pregunta5 = "Regular";
			}else if(valP5.equals("4")){
				pregunta5 = "Malo";
			}else if(valP5.equals("5")){
				pregunta5 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta5+"</td>";
			
			// 9. Pregunta 6
			String valP6 = "";
			valP6 = n2.getPreguntaNo6();
			String pregunta6 = "";
			if(valP6.equals("1")){
				pregunta6 = "Muy bueno";
			}else if(valP6.equals("2")){
				pregunta6 = "Bueno";
			}else if(valP6.equals("3")){
				pregunta6 = "Regular";
			}else if(valP6.equals("4")){
				pregunta6 = "Malo";
			}else if(valP6.equals("5")){
				pregunta6 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta6+"</td>";
			
			// 10. Pregunta 7
			String valP7 = "";
			valP7 = n2.getPreguntaNo7();
			String pregunta7 = "";
			if(valP7.equals("1")){
				pregunta7 = "Muy bueno";
			}else if(valP7.equals("2")){
				pregunta7 = "Bueno";
			}else if(valP7.equals("3")){
				pregunta7 = "Regular";
			}else if(valP7.equals("4")){
				pregunta7 = "Malo";
			}else if(valP7.equals("5")){
				pregunta7 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta7+"</td>";
			
			// 11. Pregunta 8
			String valP8 = "";
			valP8 = n2.getPreguntaNo8();
			String pregunta8 = "";
			if(valP8.equals("1")){
				pregunta8 = "Muy bueno";
			}else if(valP8.equals("2")){
				pregunta8 = "Bueno";
			}else if(valP8.equals("3")){
				pregunta8 = "Regular";
			}else if(valP8.equals("4")){
				pregunta8 = "Malo";
			}else if(valP8.equals("5")){
				pregunta8 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta8+"</td>";
			
			// 12. Pregunta 9
			String valP9 = "";
			valP9 = n2.getPreguntaNo9();
			String pregunta9 = "";
			if(valP9.equals("1")){
				pregunta9 = "Muy bueno";
			}else if(valP9.equals("2")){
				pregunta9 = "Bueno";
			}else if(valP9.equals("3")){
				pregunta9 = "Regular";
			}else if(valP9.equals("4")){
				pregunta9 = "Malo";
			}else if(valP9.equals("5")){
				pregunta9 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta9+"</td>";
			
			// 13. Pregunta 10
			String valP10 = "";
			valP10 = n2.getPreguntaNo10();
			String pregunta10 = "";
			if(valP10.equals("1")){
				pregunta10 = "Muy bueno";
			}else if(valP10.equals("2")){
				pregunta10 = "Bueno";
			}else if(valP10.equals("3")){
				pregunta10 = "Regular";
			}else if(valP10.equals("4")){
				pregunta10 = "Malo";
			}else if(valP10.equals("5")){
				pregunta10 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta10+"</td>";
			
			// 14. Pregunta 11
			String valP11 = "";
			valP11 = n2.getPreguntaNo11();
			String pregunta11 = "";
			if(valP11.equals("1")){
				pregunta11 = "Muy bueno";
			}else if(valP11.equals("2")){
				pregunta11 = "Bueno";
			}else if(valP11.equals("3")){
				pregunta11 = "Regular";
			}else if(valP11.equals("4")){
				pregunta11 = "Malo";
			}else if(valP11.equals("5")){
				pregunta11 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta11+"</td>";
			
			// 15. Pregunta 12
			String valP12 = "";
			valP12 = n2.getPreguntaNo12();
			String pregunta12 = "";
			if(valP12.equals("1")){
				pregunta12 = "Muy bueno";
			}else if(valP12.equals("2")){
				pregunta12 = "Bueno";
			}else if(valP12.equals("3")){
				pregunta12 = "Regular";
			}else if(valP12.equals("4")){
				pregunta12 = "Malo";
			}else if(valP12.equals("5")){
				pregunta12 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta12+"</td>";
			
			// 16. Pregunta 13
			String valP13 = "";
			valP13 = n2.getPreguntaNo13();
			String pregunta13 = "";
			if(valP13.equals("1")){
				pregunta13 = "Muy bueno";
			}else if(valP13.equals("2")){
				pregunta13 = "Bueno";
			}else if(valP13.equals("3")){
				pregunta13 = "Regular";
			}else if(valP13.equals("4")){
				pregunta13 = "Malo";
			}else if(valP13.equals("5")){
				pregunta13 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta13+"</td>";
			
			// 17. Pregunta 14
			String valP14 = "";
			valP14 = n2.getPreguntaNo14();
			String pregunta14 = "";
			if(valP14.equals("1")){
				pregunta14 = "Muy bueno";
			}else if(valP14.equals("2")){
				pregunta14 = "Bueno";
			}else if(valP14.equals("3")){
				pregunta14 = "Regular";
			}else if(valP14.equals("4")){
				pregunta14 = "Malo";
			}else if(valP14.equals("5")){
				pregunta14 = "Muy Malo";
			}
			xmlInicio += "<td>"+pregunta14+"</td>";
			
			// 18. Pregunta 15
			String valP15 = "";
			valP15 = n2.getPreguntaNo15();
			String pregunta15 = "";
			if(valP15.equals("1")){
				pregunta15 = "Television";
			}else if(valP15.equals("2")){
				pregunta15 = "Radio";
			}else if(valP15.equals("3")){
				pregunta15 = "Prensa/Revista";
			}else if(valP15.equals("4")){
				pregunta15 = "Volantes";
			}else if(valP15.equals("5")){
				pregunta15 = "Perifoneo";
			}else if(valP15.equals("6")){
				pregunta15 = "Ferias";
			}else if(valP15.equals("7")){
				pregunta15 = "Ferreterias";
			}else if(valP15.equals("8")){
				pregunta15 = "Por medio de un familiar";
			}else if(valP15.equals("9")){
				pregunta15 = "Por medio de un conocido";
			}
			xmlInicio += "<td>"+pregunta15+"</td>";
			
			// 19. Pregunta 16
			xmlInicio += "<td>"+n2.getPreguntaNo16()+"</td>";

			xmlInicio += "</tr>";
			
			i++;
		
		}
}
	
	

}
