package org.habitatguate.hgerp.seguridad.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;


public class InformeConsultaSolucionesXml {
    
    private SolucionesConstruidasServiceImpl solucionesService = new SolucionesConstruidasServiceImpl();
    
	    private String xmlInicio 							 	= "<table><tbody>"
																+"<tr>"
																+"<td>No.</td>"	
//																+"<td>Codigo Referencia</td>"
																+"<td>Nombre Solicitante</td>"	
																+"<td>Estado Civil</td>"	
																+"<td>Edad</td>"	
																+"<td>Solucion a Construir</td>"	
																+"<td>Telefono Casa</td>"
																+"<td>Telefono Trabajo</td>"
																+"<td>Inmueble accesible en camion</td>"
																+"<td>Inmueble accesible en carro</td>"
																+"<td>Inmueble accesible para peatones</td>"
																+"<td>Contiene Garantia</td>"
																+"<td>Contiene Primera Supervision</td>"
																+"<td>Contiene Segunda Supervision</td>"
																+"<td>Contiene Tercera Supervision</td>"
																+"<td>Contiene Cuarta Supervision</td>"
																+"</tr>";

		String  xmlFinal 										= "</tbody></table>";
	
	public String busqueda(char tipo, long idEmpleado, long idAfiliado, String solucion){
		
		DecimalFormat df 			= new DecimalFormat();
		df.setMaximumFractionDigits(2);

	    List<AuxSolicitudGeneral> result 	= new ArrayList<AuxSolicitudGeneral>();
	    
		result = solucionesService.buscarFormulario(tipo, idEmpleado, idAfiliado, "", solucion);

	    
				int i = 1;
				
				for (AuxSolicitudGeneral p : result) {
					
					// 1. Numero Correlativo.
					xmlInicio += "<td>"+i+"</td>";
					
//					// 1. Codigo Referencia
//					xmlInicio += "<td>"+p.getIdFormulario()+"</td>";
					
//					// 2. Nombre Solicitante
					xmlInicio += "<td>"+p.getNombreSolicitante()+"</td>";
					
					// 3. Estado Civil
					String valEstadoCivil = "";
					valEstadoCivil = p.getEstadoCivil();
					String estadoCivil = "";
					if(valEstadoCivil.equals("1")){
						estadoCivil = "Soltero (a)";
					}else if(valEstadoCivil.equals("2")){
						estadoCivil = "Casado (a)";
					}else if(valEstadoCivil.equals("3")){
						estadoCivil = "Unido (a)";
					}else if(valEstadoCivil.equals("4")){
						estadoCivil = "Separado (a)";
					}else if(valEstadoCivil.equals("5")){
						estadoCivil = "Divorciado (a)";
					}else if(valEstadoCivil.equals("6")){
						estadoCivil = "Viudo (a)";
					}
					xmlInicio += "<td>"+estadoCivil+"</td>";
					
					// 4. Edad
					xmlInicio += "<td>"+p.getEdad()+"</td>";
					
					// 5. Solucion a construir
					String valSolucion = "";
					valSolucion = p.getSolucionConstruir();
					String solucionConstruir = "";
					if(valSolucion.equals("1")){
						solucionConstruir = "NUEVA";
					}else if(valSolucion.equals("2")){
						solucionConstruir = "MEJORAMIENTO";
					}else if(valSolucion.equals("3")){
						solucionConstruir = "ADICIONES MENORES";
					}
					xmlInicio += "<td>"+solucionConstruir+"</td>";

					// 6. Usuario Responsable
					xmlInicio += "<td>"+p.getUsrName()+"</td>";
					
					// 7. Telefono Casa
					xmlInicio += "<td>"+p.getTelefonoCasaSolicitante()+"</td>";
					
					// 8. Telefono Trabajo
					xmlInicio += "<td>"+p.getTelefonoTrabajoSolicitante()+"</td>";
					
					// 9. Inmueble accesible en camion
					String valCamion = "";
					Boolean camion = false;
					camion = p.getCheckCamion();
					if(camion){
						valCamion = "SI";
					}else{
						valCamion = "NO";
					}
					xmlInicio += "<td>"+valCamion+"</td>";
					
					// 10. Inmueble accesible en carro
					String valCarro = "";
					Boolean carro = false;
					carro = p.getCheckCarro();
					if(carro){
						valCarro = "SI";
					}else{
						valCarro = "NO";
					}
					xmlInicio += "<td>"+valCarro+"</td>";
					
					// 11. Inmueble accesible para peatones
					String valPeatonal = "";
					Boolean peatonal = false;
					peatonal = p.getCheckPeatonal();
					if(peatonal){
						valPeatonal = "SI";
					}else{
						valPeatonal = "NO";
					}
					xmlInicio += "<td>"+valPeatonal+"</td>";
					
					// 12. Contiene Garantia
					String valGarantia = "";
					Boolean garantia = false;
					garantia = p.getGarantia();
					if(garantia){
						valGarantia = "SI";
					}else{
						valGarantia = "NO";
					}
					xmlInicio += "<td>"+valGarantia+"</td>";
					
					// 13. Primera Supervision
					String valSupervision1 = "";
					Boolean supervision1 = false;
					supervision1 = p.getPrimeraSupervision();
					if(supervision1){
						valSupervision1 = "SI";
					}else{
						valSupervision1 = "NO";
					}
					xmlInicio += "<td>"+valSupervision1+"</td>";
					
					// 14. Segunda Supervision
					String valSupervision2 = "";
					Boolean supervision2 = false;
					supervision2 = p.getSegundaSupervision();
					if(supervision2){
						valSupervision2 = "SI";
					}else{
						valSupervision2 = "NO";
					}
					xmlInicio += "<td>"+valSupervision2+"</td>";
					
					// 15. Tercera Supervision
					String valSupervision3 = "";
					Boolean supervision3 = false;
					supervision3 = p.getTerceraSupervision();
					if(supervision3){
						valSupervision3 = "SI";
					}else{
						valSupervision3 = "NO";
					}
					xmlInicio += "<td>"+valSupervision3+"</td>";
					
					// 16. Cuarta Supervision
					String valSupervision4 = "";
					Boolean supervision4 = false;
					supervision4 = p.getCuartaSupervision();
					if(supervision4){
						valSupervision4 = "SI";
					}else{
						valSupervision4 = "NO";
					}
					xmlInicio += "<td>"+valSupervision4+"</td>";					
				
					xmlInicio += "</tr>";
					
					i++;
				}

		 		xmlInicio = xmlInicio + xmlFinal;
		 		System.out.println(xmlInicio);
		
		

		return xmlInicio;
	}

}
