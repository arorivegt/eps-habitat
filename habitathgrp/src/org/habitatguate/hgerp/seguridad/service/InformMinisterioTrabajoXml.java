package org.habitatguate.hgerp.seguridad.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialAcademico;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxIdioma;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;


public class InformMinisterioTrabajoXml {

    private RecursosHumanosServiceImpl recursosHumanosService 	= new  RecursosHumanosServiceImpl();
	    private String xmlInicio 							 	= "<table><tbody>"
																+"<tr>"
																+"<td>Numero de Empleado</td>"	
																+"<td>Primer Nombre</td>"	
																+"<td>Segundo Nombre</td>"
																+"<td>Primer Apellido</td>"	
																+"<td>Segundo Apellido</td>"	
																+"<td>Nacionalidad</td>"	
																+"<td>Estado Civil</td>"	
																+"<td>Documento Identificación</td>"
																+"<td>Número de Documento</td>"	
																+"<td>Pais Origen</td>"	
																+"<td>Lugar Nacimiento</td>"	
																+"<td>NIT</td>"	
																+"<td>Número de Afiliación IGSS</td>"
																+"<td>Sexo (M) O (F)</td>"	
																+"<td>Fecha Nacimiento</td>"	
																+"<td>Cantidad de Hijos</td>"	
																+"<td>A trabajado en el extranjero</td>"
																+"<td>En que forma</td>"
																+"<td>Pais</td>"
																+"<td>Motivo de finalización de la relación laboral en el extranjero</td>"
																+"<td>Nivel Academico</td>"	
																+"<td>Profesión</td>"
																+"<td>Etnia</td>"	 
																+"<td>Idiomas</td>"	
																+"<td>Tipo Contrato</td>"	
																+"<td>Fecha Inicio Labores</td>"
																+"<td>Fecha Reinicio-labores</td>"
																+"<td>Fecha Retiro Labores</td>"
																+"<td>Puesto</td>"	
																+"<td>Jornada de Trabajo</td>"	
																+"<td>Dias Laborados en el Año</td>"	
																+"<td>Permiso Trabajo</td>"	
																+"<td>Salario Anual Nominal</td>"	
																+"<td>Bonificación Decreto 78-89 (Q.250.00)</td>"	
																+"<td>Total Horas Extras Anuales</td>"	
																+"<td>Valor de Hora Extra</td>"
																+"<td>Monto Aguinaldo Decreto 76-78</td>"
																+"<td>Monto Bono 14  Decreto 42-92</td>"
																+"<td>Retribución por Comisiones</td>"	
																+"<td>Viaticos</td>"	
																+"<td>Bonificaciones Adicionales</td>"
																+"<td>Retribución por vacaciones</td>"
																+"<td>Retribución por Indemnización (Articulo 82)</td></tr>";

		String  xmlFinal 										= "</tbody></table>";
	
	public String busqueda( char tipo,  String Estado,  String listAnnio){
		
		DecimalFormat df 			= new DecimalFormat();
		df.setMaximumFractionDigits(2);

	    List<AuxEmpleado> result 	= new ArrayList<AuxEmpleado>();
	    result 						= recursosHumanosService.Buscar_Empleado(tipo,"", "", "", "","","",Estado);
				int i = 0;
				
				for (AuxEmpleado p : result) {
					
					xmlInicio += "<tr><td>"+i+"</td>";
					
					xmlInicio += "<td>"+p.getPrimer_nombre()+"</td>";
					
					xmlInicio += "<td>"+p.getSegundo_nombre()+"</td>";
					
					xmlInicio += "<td>"+p.getPrimer_apellido()+"</td>";
					
					xmlInicio += "<td>"+p.getSegundo_apellido()+"</td>";
					
					xmlInicio += "<td>"+p.getPais()+"</td>";
					
					xmlInicio += "<td>"+p.getEstado_civil()+"</td>";
					
					try{
						if(p.getPais().equals("83")){
							xmlInicio += "<td>2</td>";
							xmlInicio += "<td>"+p.getCui()+"</td>";
						}
						else{
							xmlInicio += "<td>4</td>";
							xmlInicio += "<td>"+p.getCui()+"</td>";
						}
					}catch(Exception e){
						xmlInicio += "<td>2</td>";
						xmlInicio += "<td>"+p.getCui()+"</td>";
					}
					
					xmlInicio += "<td>"+p.getPais()+"</td>";
		
					 String[] numerosComoArray2 = p.getDepto_municipio_nacimiento().split(",");
					 String deptodir 			= "";
					 String munidir 			= "";
					 for (int i1 = 0; i1 < numerosComoArray2.length; i1++) {
						 if(i1 == 0)
							 deptodir = numerosComoArray2[i1];
						 if(i1 == 1)
							 munidir = numerosComoArray2[i1];
				     }	
					 if(deptodir.equals("01")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"I"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"I"+munidir+"</td>";
						 }
					 }
					 else if(deptodir.equals("15")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"II"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"II"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("16")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"II"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"II"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("02")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("18")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("19")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("20")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("06")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"IV"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"IV"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("21")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"IV"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"IV"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("22")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"IV"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"IV"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("03")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"V"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"V"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("04")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"V"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"V"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("05")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"V"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"V"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("07")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("08")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("09")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("10")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("11")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("12")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("13")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VIII"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VII"+"0"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("14")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VIII"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VIII"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("17")){
						 if(munidir.length()<4){
								xmlInicio += "<td>"+"VIII"+"0"+munidir+"</td>";
						 }else{
								xmlInicio += "<td>"+"VIII"+munidir+"</td>";
						 }}
		
					xmlInicio += "<td>"+p.getNit()+"</td>";
					
					xmlInicio += "<td>"+p.getAfiliacion_igss()+"</td>";

					if(p.getSexo().equals("0")){
						xmlInicio += "<td>"+"F"+"</td>";
					}else{
						xmlInicio += "<td>"+"M"+"</td>";
					}
					//SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
					//fecha de naicmiento con formato dia/mes/año
					SimpleDateFormat dtDia = new SimpleDateFormat("dd");
					String dia = dtDia.format(new Date(p.getFecha_nacimiento()));
					SimpleDateFormat dtMes = new SimpleDateFormat("MM");
					String Mes = dtMes.format(new Date(p.getFecha_nacimiento()));
					SimpleDateFormat dtAnio = new SimpleDateFormat("yyyy");
					String Anio = dtAnio.format(new Date(p.getFecha_nacimiento()));
					
					xmlInicio += "<td>"+dia+"/"+Mes+"/"+Anio+"</td>";
					
					int NoHijos = 0;
					for (AuxFamilia f : p.getFamilia()) {
						if(f.getParentesco().equals("hijo(a)"))
							NoHijos++;
					}
					xmlInicio += "<td>"+NoHijos+"</td>";
					
					//trabajado en el extranjero
					xmlInicio += "<td></td>";
					//en que forma
					xmlInicio += "<td></td>";
					//Pais
					xmlInicio += "<td></td>";
					
					//Motivo de finalización de la relación laboral en el extranjero
					xmlInicio += "<td></td>";

					int nivelAcademico = 0;
					String profesion = "";
					for (AuxHistorialAcademico academico : p.getHistorial_academico()) {
						if(Integer.parseInt(academico.getNivel_academico()) > nivelAcademico){
							nivelAcademico = Integer.parseInt(academico.getNivel_academico());
							profesion = academico.getTitulo();
						}
					}
					xmlInicio += "<td>"+nivelAcademico+"</td>";
					
					xmlInicio += "<td>"+profesion+"</td>";

					xmlInicio += "<td>"+p.getEtnia()+"</td>";

					String idioma ="";
					for (AuxIdioma id : p.getIdiomas()) {
						if(idioma.equals(""))
							idioma = id.getIdioma();
						else
							idioma += ","+id.getIdioma();
					}
					xmlInicio += "<td>"+idioma+"</td>";
					//tipo de contrato
					xmlInicio += "<td>Indefinido</td>";

					dia = dtDia.format(new Date(p.getFecha_ingreso()));
					Mes = dtMes.format(new Date(p.getFecha_ingreso()));
					Anio = dtAnio.format(new Date(p.getFecha_ingreso()));
					xmlInicio += "<td>"+dia+"/"+Mes+"/"+Anio+"</td>";

					xmlInicio += "<td>"+dia+"/"+Mes+"/"+Anio+"</td>";
					//fecha de retiro de labores
					xmlInicio += "<td>"+dia+"/"+Mes+"/"+Anio+"</td>";
					
					String DescansoSemanal = "";
					String jornada = "";
					String nombre_puesto = "";
					String horas_trabajadas = "";
					for (AuxPuesto f : p.getPuestos()) {
						if(f.isActivo()){
							nombre_puesto = f.getNombre_puesto();
							horas_trabajadas = f.getHorasTrabajo();
							if(f.getJornada().equals("0")){
								jornada = "Diurna";
							}else if(f.getJornada().equals("1")){
								jornada = "Nocturna";
							}else if(f.getJornada().equals("2")){
								jornada = "Mixta";
							}

							if(f.getLunes().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Lunes medio dia";
								else
									DescansoSemanal +=","+ "Lunes medio dia";
							}else if(f.getLunes().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Lunes";
								else
									DescansoSemanal +=","+ "Lunes";
							}
							
							
							if(f.getMartes().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Martes medio dia";
								else
									DescansoSemanal +=","+  "Martes medio dia";
							}else if(f.getMartes().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Martes";
								else
									DescansoSemanal +=","+ "Martes";
							}
							

							if(f.getMiercoles().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Miercoles medio dia";
								else
									DescansoSemanal +=","+  "Miercoles medio dia";
							}else if(f.getMiercoles().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Miercoles";
								else
									DescansoSemanal +=","+ "Miercoles";
							}
							

							if(f.getJueves().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Jueves medio dia";
								else
									DescansoSemanal +=","+  "Jueves medio dia";
							}else if(f.getJueves().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Jueves";
								else
									DescansoSemanal +=","+ "Jueves";
							}
							

							if(f.getViernes().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Viernes medio dia";
								else
									DescansoSemanal +=","+  "Viernes medio dia";
							}else if(f.getViernes().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Viernes";
								else
									DescansoSemanal +=","+ "Viernes";
							}
							

							if(f.getSabado().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Sabado medio dia";
								else
									DescansoSemanal +=","+  "Sabado medio dia";
							}else if(f.getSabado().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Sabado";
								else
									DescansoSemanal +=","+ "Sabado";
							}
							

							if(f.getDomingo().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Domingo medio dia";
								else
									DescansoSemanal +=","+  "Domingo medio dia";
							}else if(f.getDomingo().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Domingo";
								else
									DescansoSemanal +=","+ "Domingo";
							}
							
							break;
						}
					}
					

					xmlInicio += "<td>"+nombre_puesto+"</td>";
					
					xmlInicio += "<td>"+jornada+"</td>";

					 Anio = dtAnio.format(new Date(p.getFecha_ingreso()));
					 String Anio2 = dtAnio.format(new Date());
					long diaslaborados = new Date().getTime()-p.getFecha_ingreso();
					if(Integer.parseInt(Anio)< Integer.parseInt(Anio2)){
						xmlInicio += "<td>"+"365"+"</td>";
					}else{
						int dialaboradoss = (int) (diaslaborados /(1000 * 60 * 60 * 24));
						xmlInicio += "<td>"+dialaboradoss+"</td>";
					}
					
					//permiso
					xmlInicio += "<td></td>";

//					
//					//calculo de edad del empleado
//					//resta del año de actual - año nacimiento, para calcular edad aproximada
//					SimpleDateFormat dtf = new SimpleDateFormat("yyyy");
//					String AnnioNacimiento = dtf.format(new Date(p.getFecha_nacimiento()));
//					String AnnioActual = dtf.format(new Date());
//					int edadtotal = Integer.parseInt(AnnioActual)- Integer.parseInt(AnnioNacimiento);
//					
//					xmlInicio += "<td>"+edadtotal+"</td>";
		
			 		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			 		//SimpleDateFormat mes 	= new SimpleDateFormat("MM");
			 		//SimpleDateFormat diaa 	= new SimpleDateFormat("dd");
			 		String formatAnio 	= "";
			 		//String formatMes 	= "";
			 		// formatDia 	= "";
			 		
			 		float bono14 = 0;
			 		float aguinaldo = 0;
			 		float comisiones = 0;
			 		float indemnizacion = 0;
			 		float otrosPagos = 0;
			 		float viaticos = 0;
			 		float bonificaciones = 0;
			 		float vacaciones = 0;
			 		float salarioMensualNominal = 0;
			 		float decreto7889 = 0;
			 		
					for (AuxSalario s : p.getSalario()) {
		 				formatAnio = anio.format(new Date(s.getFecha()));
		 				
		 				if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("0"))
		 				{
		 					salarioMensualNominal += s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("1"))
		 				{
		 					decreto7889 += s.getSalario();
		 				}else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("2"))
		 				{
		 					comisiones += s.getSalario();
		 				}else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("2"))
		 				{
		 					bonificaciones += s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("4"))
		 				{
		 					bono14 = s.getSalario();
		 				}else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("5"))
		 				{
		 					aguinaldo = s.getSalario();
		 				}else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("6"))
		 				{
		 					vacaciones = s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("7")) 
		 				{
		 					indemnizacion = s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("8")) 
		 				{
		 					otrosPagos += s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("9")) 
		 				{
		 					viaticos += s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("10")) 
		 				{
		 					bonificaciones += s.getSalario();
		 				}
		 				
		 				
					}
					xmlInicio += "<td>"+df.format(salarioMensualNominal)+"</td>";
					
					xmlInicio += "<td>"+decreto7889+"</td>";
					
					xmlInicio += "<td>"+"0"+"</td>";
					
					xmlInicio += "<td>"+"0"+"</td>";
					
					xmlInicio += "<td>"+df.format(aguinaldo)+"</td>";
					
					xmlInicio += "<td>"+df.format(bono14)+"</td>";
					
					xmlInicio += "<td>"+df.format(comisiones)+"</td>";	
					
					xmlInicio += "<td>"+df.format(viaticos)+"</td>";	
					
					xmlInicio += "<td>"+df.format(bonificaciones)+"</td>";	
					
					xmlInicio += "<td>"+df.format(vacaciones)+"</td>";		
					
					xmlInicio += "<td>"+df.format(indemnizacion)+"</td></tr>";
					
					
				
					i++;
				}

		 		xmlInicio = xmlInicio + xmlFinal;
		 		System.out.println(xmlInicio);
		
		

		return xmlInicio;
	}

}
