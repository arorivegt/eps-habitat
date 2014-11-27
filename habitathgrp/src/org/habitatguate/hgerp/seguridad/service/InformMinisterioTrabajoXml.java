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
																+"<td>No. de empleado</td>"	
																+"<td>Tipo Documento Identificación</td>"
																+"<td>Documento Identificación</td>"	
																+"<td>Pais Origen</td>"	
																+"<td>Lugar Nacimiento</td>"	
																+"<td>Nit Empleado</td>"	
																+"<td>IGSS Empleado</td>"
																+"<td>Deportado de algún País</td>"	
																+"<td>Nombre1</td>"	
																+"<td>Nombre2</td>"	
																+"<td>Nombre3</td>"	
																+"<td>Apellido1</td>"	
																+"<td>Apellido2</td>"	
																+"<td>Estado Civil</td>"	
																+"<td>Número Hijos</td>"	
																+"<td>Fecha Nacimiento</td>"	
																+"<td>Edad aprox.</td>"	 
																+"<td>Sexo (M) O (F)</td>"	
																+"<td>Tiempo de laborar</td>"	
																+"<td>Puesto</td>"	 
																+"<td>Dias Trabajados Año</td>"	
																+"<td>Descanso Semanal</td>"	
																+"<td>Jornada</td>"	
																+"<td>Horas al Día</td>"	
																+"<td>Salario Mensual Nominal</td>"	
																+"<td>Decreto 78-89  (Q.250.00)</td>"	
																+"<td>Total Horas Extras</td>"	
																+"<td>Valor de Hora Extra </td>"	
																+"<td>Aguinaldo Decreto 76-78</td>"	
																+"<td>Bono 14 decreto 42-92</td>"	
																+"<td>Comisiones</td>"	
																+"<td>Nivel Academico</td>"	
																+"<td>Profesión</td>"
																+"<td>Etnia</td>"	 
																+"<td>Idiomas</td>"	
																+"<td>Permiso Trabajo</td>"	
																+"<td>Tipo Contrato</td>"	
																+"<td>Indemnización (Articulo 82)</td>"
																+"<td>Otros Pagos</td>"
																+"</tr>";

		String  xmlFinal 										= "</tbody></table>";
	
	public String busqueda( char tipo,  String Estado,  String listAnnio){
		
		DecimalFormat df 			= new DecimalFormat();
		df.setMaximumFractionDigits(2);

	    List<AuxEmpleado> result 	= new ArrayList<AuxEmpleado>();
	    result 						= recursosHumanosService.Buscar_Empleado(tipo,"", "", "", "","","",Estado);
				int i = 0;
				
				for (AuxEmpleado p : result) {
					
					xmlInicio += "<td>"+i+"</td>";
					
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
					
					xmlInicio += "<td>"+""+"</td>";
					
					xmlInicio += "<td>"+p.getPrimer_nombre()+"</td>";
					
					xmlInicio += "<td>"+p.getSegundo_nombre()+"</td>";
					
					//empleado.setNombre3(p.getPrimer_nombre());
					xmlInicio += "<td>"+""+"</td>";
					
					xmlInicio += "<td>"+p.getPrimer_apellido()+"</td>";
					
					xmlInicio += "<td>"+p.getSegundo_apellido()+"</td>";
					
					xmlInicio += "<td>"+p.getEstado_civil()+"</td>";
					
					int NoHijos = 0;
					for (AuxFamilia f : p.getFamilia()) {
						if(f.getParentesco().equals("hijo(a)"))
							NoHijos++;
					}
					xmlInicio += "<td>"+NoHijos+"</td>";
					//SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
					//fecha de naicmiento con formato dia/mes/año
					SimpleDateFormat dtDia = new SimpleDateFormat("dd");
					String dia = dtDia.format(new Date(p.getFecha_nacimiento()));
					SimpleDateFormat dtMes = new SimpleDateFormat("MM");
					String Mes = dtMes.format(new Date(p.getFecha_nacimiento()));
					SimpleDateFormat dtAnio = new SimpleDateFormat("yyyy");
					String Anio = dtAnio.format(new Date(p.getFecha_nacimiento()));
					
					xmlInicio += "<td>"+dia+"/"+Mes+"/"+Anio+"</td>";
					
					//calculo de edad del empleado
					//resta del año de actual - año nacimiento, para calcular edad aproximada
					SimpleDateFormat dtf = new SimpleDateFormat("yyyy");
					String AnnioNacimiento = dtf.format(new Date(p.getFecha_nacimiento()));
					String AnnioActual = dtf.format(new Date());
					int edadtotal = Integer.parseInt(AnnioActual)- Integer.parseInt(AnnioNacimiento);
					
					xmlInicio += "<td>"+edadtotal+"</td>";
		
					if(p.getSexo().equals("0")){
						xmlInicio += "<td>"+"F"+"</td>";
					}else{
						xmlInicio += "<td>"+"M"+"</td>";
					}
					 Anio = dtAnio.format(new Date(p.getFecha_ingreso()));
					 String Anio2 = dtAnio.format(new Date());
					 
					
					long diaslaborados = new Date().getTime()-p.getFecha_ingreso();
					if(Integer.parseInt(Anio)< Integer.parseInt(Anio2)){
						xmlInicio += "<td>"+"365"+"</td>";
					}else{
						int dialaboradoss = (int) (diaslaborados /(1000 * 60 * 60 * 24));
						xmlInicio += "<td>"+dialaboradoss+"</td>";
					}
		
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
							
							if(f.getLunes()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Lunes";
								else
									DescansoSemanal +=","+ "Lunes";
							}if(f.getMartes()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Martes";
								else
									DescansoSemanal +=","+ "Martes";
									
							}if(f.getMiercoles()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Miercoles";
								else
									DescansoSemanal +=","+ "Miercoles";
							}if(f.getJueves()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Jueves";
								else
									DescansoSemanal +=","+ "Jueves";
							}if(f.getViernes()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Viernes";
								else
									DescansoSemanal +=","+ "Viernes";
							}if(f.getSabado()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Sabado";
								else
									DescansoSemanal +=","+ "Sabado";
							}if(f.getDomingo()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Domingo";
								else
									DescansoSemanal +=","+ "Domingo";
							}
							break;
						}
					}

					xmlInicio += "<td>"+nombre_puesto+"</td>";
					
					xmlInicio += "<td>"+""+"</td>";

					//+"<td>Dias Trabajados Año</td>"	aqui va despues del nombre del puesto

					xmlInicio += "<td>"+DescansoSemanal+"</td>";
					
					xmlInicio += "<td>"+jornada+"</td>";

					xmlInicio += "<td>"+horas_trabajadas+"</td>";
					
					
					String idioma ="";
					for (AuxIdioma id : p.getIdiomas()) {
						if(idioma.equals(""))
							idioma = id.getIdioma();
						else
							idioma += ","+id.getIdioma();
					}
		
					int nivelAcademico = 0;
					String profesion = "";
					for (AuxHistorialAcademico academico : p.getHistorial_academico()) {
						if(Integer.parseInt(academico.getNivel_academico()) > nivelAcademico){
							nivelAcademico = Integer.parseInt(academico.getNivel_academico());
							profesion = academico.getTitulo();
						}
					}

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
			 		float salarioMensualNominal = 0;
			 		float decreto7889 = 0;
			 		
					for (AuxSalario s : p.getSalario()) {
		 				formatAnio = anio.format(new Date(s.getFecha()));
		 				
		 				if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("4"))
		 				{
		 					bono14 = s.getSalario();
		 				}else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("5"))
		 				{
		 					aguinaldo = s.getSalario();
		 				}else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("2"))
		 				{
		 					comisiones += s.getSalario();
		 				}else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("1"))
		 				{
		 					decreto7889 = s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("7")) //abra que incluir bonos?
		 				{
		 					indemnizacion = s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio) 
		 						&& s.getTipoSalario().equals("8")) //abra que incluir bonos?
		 				{
		 					otrosPagos += s.getSalario();
		 				}
		 				
		 				//falta salario mensual nominal,  y otros pagos que incluye estos dos?
		 				
					}
					xmlInicio += "<td>"+df.format(salarioMensualNominal)+"</td>";
					
					xmlInicio += "<td>"+decreto7889+"</td>";
					
					xmlInicio += "<td>"+"0"+"</td>";
					
					xmlInicio += "<td>"+"0"+"</td>";
					
					xmlInicio += "<td>"+df.format(aguinaldo)+"</td>";
					
					xmlInicio += "<td>"+df.format(bono14)+"</td>";
					
					xmlInicio += "<td>"+df.format(comisiones)+"</td>";
					
					xmlInicio += "<td>"+nivelAcademico+"</td>";
					
					xmlInicio += "<td>"+profesion+"</td>";
					
					xmlInicio += "<td>"+p.getEtnia()+"</td>";

					xmlInicio += "<td>"+idioma+"</td>";

					xmlInicio += "<td>"+""+"</td>";
					//private String PermisoTrabajo;
					
					xmlInicio += "<td>"+"Indefinido"+"</td>";
					
					xmlInicio += "<td>"+df.format(indemnizacion)+"</td>";
					
					xmlInicio += "<td>"+df.format(otrosPagos)+"</td></tr>";
					
				
					i++;
				}

		 		xmlInicio = xmlInicio + xmlFinal;
		 		System.out.println(xmlInicio);
		
		

		return xmlInicio;
	}

}
