package org.habitatguate.hgerp.seguridad.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;


public class InformBancosXml {

    	private RecursosHumanosServiceImpl recusosHumanosService = new  RecursosHumanosServiceImpl();
	    private String xmlInicio 								 = "";
		private String  xmlFinal 								 = "";
	
	 	public String Bancos(char tipo,String  primer_nombre, String segundo_nombre, 
				 			String primer_apellido, String segundo_apellido,String DPI,
				 			String  pasaporte,String estado, 
				 			String listMes,String listAnio)
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
			
	 		List<AuxEmpleado> result 	= new ArrayList<AuxEmpleado>();
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
						
						result 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																	   			primerApellido,  segundoApellido,DPI, 
																	   			pasaporte,estado);
					}else if(nombreArray.length == 3){
						
						primerNombre 	= nombreArray[0].trim();
						segundoNombre 	= nombreArray[1].trim();
						primerApellido 	= nombreArray[2].trim();
						segundoApellido = "".trim();
						
						result 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																				primerApellido,  segundoApellido,DPI, 
																				pasaporte,estado);
						if(result.isEmpty())
						{
							primerNombre 	= nombreArray[0].trim();
							segundoNombre 	= nombreArray[1].trim();
							primerApellido 	= "".trim();
							segundoApellido = nombreArray[2].trim();
							
							result 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																				primerApellido,  segundoApellido,DPI, 
																				pasaporte,estado);
						}
						
						
					}else if(nombreArray.length == 4)
					{
						primerNombre 	= nombreArray[0].trim();
						segundoNombre 	= nombreArray[1].trim();
						primerApellido 	= nombreArray[2].trim();
						segundoApellido = nombreArray[3].trim();
						
						
						result 			= recusosHumanosService.Buscar_Empleado(tipo, primerNombre, segundoNombre, 
																				primerApellido,  segundoApellido,DPI, 
																				pasaporte,estado);
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
	 			result				 	= recusosHumanosService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, 
	 																			primer_apellido, segundo_apellido,DPI, 
	 																			pasaporte,estado);
	 		}
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>"
						 					+ "<td>"+"Correlativo"+"</td>"
						 					+ "<td>"+"Tipo de Cuenta"+"</td>"
						 					+ "<td>"+"No Cuenta"+"</td>"
						 		 			+ "<td>"+"Nombre"+"</td>"
						 					+ "<td>"+"Monto"+"</td>"
						 					+ "<td>"+"Descripcion"+"</td>"
					 					+ "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";
	 		int i 					= 0;
	 		float salarioCalculo 	= 0;
	 		float enero 	= 0, Bono  		= 0;
	 		float febrero	= 0, marzo 		= 0;
	 		float abril		= 0, mayo 		= 0;
	 		float junio		= 0, julio 		= 0;
	 		float agosto	= 0, septiembre = 0;
	 		float octubre	= 0, noviembre 	= 0;
	 		float diciembre	= 0;
	 		
	 		boolean bEnero 		= true;
	 		boolean bFebrero 	= true;
	 		boolean bMarzo		= true;
	 		boolean bAbril 		= true;
	 		boolean bMayo 		= true;
	 		boolean bJunio 		= true;
	 		boolean bJulio 		= true;
	 		boolean bAgosto 	= true;
	 		boolean bSeptiembre = true;
	 		boolean bOctubre 	= true;
	 		boolean bNoviembre 	= true;
	 		boolean bDiciembre 	= true;
	 		
	 		SimpleDateFormat anio 	= new SimpleDateFormat("yyyy");
	 		SimpleDateFormat mes 	= new SimpleDateFormat("MM");
	 		int ultimoAnnio 		= 0;
	 		int ultimoMes 			= 0;
	 		float ultimoSalario 	= 0;
	 		String formatAnio 		= "";
	 		String formatMes 		= "";
	 		
	 		for(AuxEmpleado e:result)
	 		{
	 			nombre = e.getPrimer_nombre() +" "+ e.getSegundo_nombre() +" "+e.getPrimer_apellido() +" "+e.getSegundo_apellido(); 
	 			for(AuxSalario s:e.getSalario())
	 			{
	 				formatAnio = anio.format(new Date(s.getFecha()));
	 				formatMes  = mes.format(new Date(s.getFecha()));
	 				
	 				//verifico el ultimo salario que tiene el empleado, si en caso:
	 				//esto primero verificando que el año del ultimo salario, este no sea de una fecha despues de la que se quiere calcular
	 				//fecha del salario menor o igual que el año a calcular
	 				if(Integer.parseInt(formatAnio) <= Integer.parseInt(listAnio))
	 				{
	 					//luego de lo anterior verifico que el año del salario y el mes del salario a tomar en cuenta
	 					//es mayor o igual a la fecha del ultimo salario, si es asi, entonces ese salario sera el ultimo
	 					//y asi hasta encontrar el ultimo entre la fecha a calcular hasta antes de esa fecha
	 					if(Integer.parseInt(formatAnio) >= ultimoAnnio && Integer.parseInt(formatMes) >= ultimoMes)
	 					{
	 						ultimoAnnio 	= Integer.parseInt(formatAnio);
	 				 		ultimoMes 		= Integer.parseInt(formatMes);
	 				 		ultimoSalario 	=  s.getSalario();
	 					}
	 				}
	 				//*********************************************************************************
	 				/**
	 				 * por si cada mes no tuviera un salario en especifico, entonces se le asigna el ultimo salario calculado
	 				 * este salario para asignarle, el año debera ser menor o igual al año a calcular, y ademas el mes en 
	 				 * cuestion a asignarle el ultimo salario, el mes del ultimo salario debera ser menor o igual al mes al
	 				 * que se le va asignar el ultimo salario, en caso contrario ese mes, tendra salario = 0;
	 				 */
	 				//salario de enero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("01")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					enero = s.getSalario();
	 					bEnero = false;
	 				}else if(bEnero && s.getTipoSalario().equals("0") &&
	 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 01 && ultimoAnnio == Integer.parseInt(listAnio)) )
	 						)
	 				{
	 					enero = ultimoSalario;
	 				}
	 				
	 				//salario de febrero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("02")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					febrero = s.getSalario();
	 					bFebrero  = false;
	 				}else if(bFebrero && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 02 && ultimoAnnio == Integer.parseInt(listAnio))) 
 							)
	 				{
	 					febrero = ultimoSalario;
	 				}
	 				
	 				//salario de marzo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("03")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					marzo = s.getSalario();
	 					bMarzo  = false;
	 				}else if(bMarzo && s.getTipoSalario().equals("0")&&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 03 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					marzo = ultimoSalario;
	 				}
	 				
	 				//salario de abril
	 				if(formatAnio.equals(listAnio) && formatMes.equals("04")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					abril = s.getSalario();
	 					bAbril  = false;
	 				}else if(bAbril && s.getTipoSalario().equals("0")&&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 04 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					abril = ultimoSalario;
	 				}
	 				
	 				//salario de mayo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("05")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					mayo = s.getSalario();
	 					bMayo  = false;
	 				}else if(bMayo && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 05 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					mayo = ultimoSalario;
	 				}
	 				
	 				//salario de junio
	 				if(formatAnio.equals(listAnio) && formatMes.equals("06")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
	 					bJunio  = false;
	 				}else if(bJunio && s.getTipoSalario().equals("0")&&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 06 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					junio = ultimoSalario;
	 				}
	 				

	 				//salario de julio
	 				if(formatAnio.equals(listAnio) && formatMes.equals("07")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					julio = s.getSalario();
	 					bJulio  = false;
	 				}else if(bJulio && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 07 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					julio = ultimoSalario;
	 				}
	 				
	 				//salario de agosto
	 				if(formatAnio.equals(listAnio) && formatMes.equals("08")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					agosto = s.getSalario();
	 					bAgosto  = false;
	 				}else if(bAgosto && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 8 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					agosto = ultimoSalario;
	 				}
	 				

	 				//salario de septiembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("09")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					septiembre = s.getSalario();
	 					bSeptiembre  = false;
	 				}else if(bSeptiembre && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 9 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					septiembre = ultimoSalario;
	 				}
	 				

	 				//salario de octubre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("10")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					octubre = s.getSalario();
	 					bOctubre  = false;
	 				}else if(bOctubre && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 10 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					octubre = ultimoSalario;
	 				}
	 				

	 				//salario de noviembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("11")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					noviembre = s.getSalario();
	 					bNoviembre  = false;
	 				}else if(bNoviembre && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 11 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					noviembre = ultimoSalario;
	 				}
	 				

	 				//salario de diciembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("12")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					diciembre = s.getSalario();
	 					bDiciembre  = false;
	 				}else if(bDiciembre && s.getTipoSalario().equals("0") &&
 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 12 && ultimoAnnio == Integer.parseInt(listAnio)))
 							)
	 				{
	 					diciembre = ultimoSalario;
	 				}
	 				
	 				//*********************************************************************************
	 				
	 				//*********************************************************************************
	 				//bonos
	 				if(formatAnio.equals(listAnio) && formatMes.equals(listMes)
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					Bono += s.getSalario();
	 				}
	 				//*********************************************************************************
	 				
	 				
	 			}//fin for salario
	 			

 				//****************************************calculo de planilla del mes a calcular*****************************************
	 			
	 			if(Integer.parseInt(listMes) == 01){
	 				mesPlanilla = "Enero";
	 				salarioCalculo = (float) (enero - (enero*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 02){
	 				mesPlanilla = "Febrero";
	 				salarioCalculo = (float) (febrero- (febrero*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 03){
	 				mesPlanilla = "Marzo";
	 				salarioCalculo = (float) (marzo - (marzo*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 04){
	 				mesPlanilla = "Abril";
	 				salarioCalculo = (float) (abril - (abril*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 05){
	 				mesPlanilla = "Mayo";
	 				salarioCalculo = (float) (mayo - (mayo*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 06){
	 				mesPlanilla = "Junio";
	 				salarioCalculo = (float) (junio - (junio*4.83/100) + Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 07){
	 				mesPlanilla = "Julio";
	 				salarioCalculo = (float) (julio - (julio*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 8){
	 				mesPlanilla = "Agosto";
	 				salarioCalculo = (float) (agosto - (agosto*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 9){
	 				mesPlanilla = "Septiembre";
	 				salarioCalculo = (float) (septiembre - (septiembre*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 10){
	 				mesPlanilla = "Octubre";
	 				salarioCalculo = octubre + Bono;
	 				
	 			}else if(Integer.parseInt(listMes) == 11){
	 				mesPlanilla = "Noviembre";
	 				salarioCalculo = (float) (noviembre - (noviembre*4.83/100)+ Bono);
	 				
	 			}else if(Integer.parseInt(listMes) == 12){
	 				mesPlanilla = "Diciembre";
	 				salarioCalculo = (float) (diciembre - (diciembre*4.83/100)+ Bono);
	 				
	 			}
	 			String tipoCuenta = "";
	 			if(e.getTipoCuenta().equals("0")){
	 				tipoCuenta = "Ahorro";
	 			}else{
	 				tipoCuenta = "Monetaria";
	 			}
	 			xmlInicio+= "<tr>"
			 					+ "<td>"+i+"</td>"
			 					+ "<td>"+tipoCuenta.toUpperCase()+"</td>"
			 					+ "<td>"+e.getNoCuenta()+"</td>"
			 		 			+ "<td>"+nombre+"</td>"
			 					+ "<td>"+df.format(salarioCalculo)+"</td>"
			 					+ "<td> PLANILLA "+mesPlanilla.toUpperCase()+" "+listAnio+"</td>"
		 					+ "</tr>";
	 			//aqui se crea cada fila con sus respectivas columnas para el excel
	 			enero 		= 0;
	 			febrero 	= 0;
	 			marzo 		= 0;
	 			abril 		= 0;
	 			mayo 		= 0;
	 			junio 		= 0;
	 			julio 		= 0;
	 			agosto 		= 0;
	 			septiembre 	= 0;
	 			octubre 	= 0;
	 			noviembre 	= 0;
	 			diciembre 	= 0;
	 			Bono 		= 0;
	 			i++;
	 		}//fin for empleado
	 		
	 		xmlInicio 		= xmlInicio + xmlFinal;
	 		
	 		return xmlInicio;
	 	}

}
