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
	
	 	public String Bancos(char tipo,String  primer_nombre,String DPI,
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
	 			result				 	= recusosHumanosService.Buscar_Empleado(tipo, primer_nombre, "", 
	 																			"", "",DPI, 
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
	 		float enero = 0, eneroBono = 0;
	 		float febrero= 0 , febreroBono = 0;
	 		float marzo= 0, marzoBono = 0;
	 		float abril= 0, abrilBono = 0;
	 		float mayo= 0, mayoBono = 0;
	 		float junio= 0, junioBono = 0;
	 		float julio= 0, julioBono = 0;
	 		float agosto= 0, agostoBono = 0;
	 		float septiembre= 0, septiembreBono = 0;
	 		float octubre= 0, octubreBono = 0;
	 		float noviembre= 0, noviembreBono = 0;
	 		float diciembre= 0, diciembreBono = 0;
	 		
	 		boolean bEnero = true;
	 		boolean bFebrero = true;
	 		boolean bMarzo	= true;
	 		boolean bAbril = true;
	 		boolean bMayo = true;
	 		boolean bJunio = true;
	 		boolean bJulio = true;
	 		boolean bAgosto = true;
	 		boolean bSeptiembre = true;
	 		boolean bOctubre = true;
	 		boolean bNoviembre = true;
	 		boolean bDiciembre = true;
	 		
	 		float eneroUltimoSalario = 0;
	 		float febreroUltimoSalario = 0;
	 		float marzoUltimoSalario = 0;
	 		float abrilUltimoSalario = 0;
	 		float mayoUltimoSalario = 0;
	 		float junioUltimoSalario = 0;
	 		float julioUltimoSalario = 0;
	 		float agostoUltimoSalario = 0;
	 		float septiembreUltimoSalario = 0;
	 		float octubreUltimoSalario = 0;
	 		float noviembreUltimoSalario = 0;
	 		float diciembreUltimoSalario = 0;
	 		
	 		int eneroAnioUltimo = 0;
	 		int febreroAnioUltimo = 0;
	 		int marzoAnioUltimo = 0;
	 		int abrilAnioUltimo = 0;
	 		int mayoAnioUltimo = 0;
	 		int junioAnioUltimo = 0;
	 		int julioAnioUltimo = 0;
	 		int agostoAnioUltimo = 0;
	 		int septiembreAnioUltimo = 0;
	 		int octubreAnioUltimo = 0;
	 		int noviembreAnioUltimo = 0;
	 		int diciembreAnioUltimo = 0;
	 		
	 		int eneroMesUltimo = 0;
	 		int febreroMesUltimo = 0;
	 		int marzoMesUltimo = 0;
	 		int abrilMesUltimo = 0;
	 		int mayoMesUltimo = 0;
	 		int junioMesUltimo = 0;
	 		int julioMesUltimo = 0;
	 		int agostoMesUltimo = 0;
	 		int septiembreMesUltimo = 0;
	 		int octubreMesUltimo = 0;
	 		int noviembreMesUltimo = 0;
	 		int diciembreMesUltimo = 0;
	 		
	 		SimpleDateFormat anio 	= new SimpleDateFormat("yyyy");
	 		SimpleDateFormat mes 	= new SimpleDateFormat("MM");

	 		String AuxAnio 	= "";
	 		String AuxMes 	= "";
	 		

	 		for(AuxEmpleado e:result)
	 		{
	 			nombre = e.getPrimer_nombre() +" "+ e.getSegundo_nombre() +" "+e.getPrimer_apellido() +" "+e.getSegundo_apellido(); 
		 			for(AuxSalario s:e.getSalario())
		 			{
		 				AuxAnio = anio.format(new Date(s.getFecha()));
		 				AuxMes  = mes.format(new Date(s.getFecha()));
		 				
		 				//verifico el ultimo salario que tiene el empleado, si en caso:
		 				//esto primero verificando que el año del ultimo salario, este no sea de una fecha despues de la que se quiere calcular
		 				//fecha del salario menor o igual que el año a calcular
		 				if(Integer.parseInt(AuxAnio) <= Integer.parseInt(listAnio) &&  s.getTipoSalario().equals("0"))
		 				{
		 					//luego de lo anterior verifico que el año del salario y el mes del salario a tomar en cuenta
		 					//es mayor o igual a la fecha del ultimo salario, si es asi, entonces ese salario sera el ultimo
		 					//y asi hasta encontrar el ultimo entre la fecha a calcular hasta antes de esa fecha
		 					System.out.println(AuxMes);
		 					if(Integer.parseInt(AuxAnio) >= eneroAnioUltimo && Integer.parseInt(AuxMes) >= eneroMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 01)
		 					{
		 						eneroAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						eneroMesUltimo 		= Integer.parseInt(AuxMes);
		 						eneroUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= febreroAnioUltimo && Integer.parseInt(AuxMes) >= febreroMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 02)
		 					{
		 						febreroAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						febreroMesUltimo 		= Integer.parseInt(AuxMes);
		 						febreroUltimoSalario 	=  s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= marzoAnioUltimo && Integer.parseInt(AuxMes) >= marzoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 03)
		 					{
		 						marzoAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						marzoMesUltimo 		= Integer.parseInt(AuxMes);
		 						marzoUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= abrilAnioUltimo && Integer.parseInt(AuxMes) >= abrilMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 04)
		 					{
		 						abrilAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						abrilMesUltimo 		= Integer.parseInt(AuxMes);
		 						abrilUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= mayoAnioUltimo && Integer.parseInt(AuxMes) >= mayoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 05)
		 					{
		 						mayoAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						mayoMesUltimo 		= Integer.parseInt(AuxMes);
		 						mayoUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= junioAnioUltimo && Integer.parseInt(AuxMes) >= junioMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 06)
		 					{
		 						junioAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						junioMesUltimo 		= Integer.parseInt(AuxMes);
		 						junioUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= julioAnioUltimo && Integer.parseInt(AuxMes) >= julioMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 07)
		 					{
		 						julioAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						julioMesUltimo 		= Integer.parseInt(AuxMes);
		 						julioUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= agostoAnioUltimo && Integer.parseInt(AuxMes) >= agostoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 8)
		 					{
		 						agostoAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						agostoMesUltimo 		= Integer.parseInt(AuxMes);
		 						agostoUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= septiembreAnioUltimo && Integer.parseInt(AuxMes) >= septiembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 9)
		 					{
		 						septiembreAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						septiembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						septiembreUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= octubreAnioUltimo && Integer.parseInt(AuxMes) >= octubreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 10)
		 					{
		 						octubreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						octubreMesUltimo 		= Integer.parseInt(AuxMes);
		 						octubreUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= noviembreAnioUltimo && Integer.parseInt(AuxMes) >= noviembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 11)
		 					{
		 						noviembreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						noviembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						noviembreUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= diciembreAnioUltimo && Integer.parseInt(AuxMes) >= diciembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 12)
		 					{
		 						diciembreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						diciembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						diciembreUltimoSalario 	= s.getSalario();
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
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("01") && s.getTipoSalario().equals("0"))
		 				{
		 					enero = s.getSalario();
		 					bEnero = false;
		 				}else if(bEnero)
		 				{
		 					enero = eneroUltimoSalario;
		 				}
		 				
		 				//salario de febrero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("02")&& s.getTipoSalario().equals("0"))
		 				{
		 					febrero = s.getSalario();
		 					bFebrero  = false;
		 				}else if(bFebrero)
		 				{
		 					febrero = febreroUltimoSalario;
		 				}
		 				
		 				//salario de marzo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("03") && s.getTipoSalario().equals("0"))
		 				{
		 					marzo = s.getSalario();
		 					bMarzo  = false;
		 				}else if(bMarzo)
		 				{
		 					marzo = marzoUltimoSalario;
		 				}
		 				
		 				//salario de abril
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("04") && s.getTipoSalario().equals("0"))
		 				{
		 					abril = s.getSalario();
		 					bAbril  = false;
		 				}else if(bAbril)
		 				{
		 					abril = abrilUltimoSalario;
		 				}
		 				
		 				//salario de mayo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("05") && s.getTipoSalario().equals("0"))
		 				{
		 					mayo = s.getSalario();
		 					bMayo  = false;
		 				}else if(bMayo)
		 				{
		 					mayo = mayoUltimoSalario;
		 				}
		 				
		 				//salario de junio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("06") && s.getTipoSalario().equals("0"))
		 				{
		 					junio = s.getSalario();
		 					bJunio  = false;
		 				}else if(bJunio)
		 				{
		 					junio = junioUltimoSalario;
		 				}
		 				
	
		 				//salario de julio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("07") && s.getTipoSalario().equals("0"))
		 				{
		 					julio = s.getSalario();
		 					bJulio  = false;
		 				}else if(bJulio)
		 				{
		 					julio = julioUltimoSalario;
		 				}
		 				
	
		 				//salario de agosto
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("08") && s.getTipoSalario().equals("0"))
		 				{
		 					agosto = s.getSalario();
		 					bAgosto  = false;
		 				}else if(bAgosto)
		 				{
		 					agosto = agostoUltimoSalario;
		 				}
		 				
	
		 				//salario de septiembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("09")  && s.getTipoSalario().equals("0"))
		 				{
		 					septiembre = s.getSalario();
		 					bSeptiembre  = false;
		 				}else if(bSeptiembre)
		 				{
		 					septiembre = septiembreUltimoSalario;
		 				}
		 				
	
		 				//salario de Octubre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("10") && s.getTipoSalario().equals("0"))
		 				{
		 					octubre = s.getSalario();
		 					bOctubre  = false;
		 				}else if(bOctubre)
		 				{
		 					octubre = octubreUltimoSalario;
		 				}
		 				
	
		 				//salario de Noviembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("11") && s.getTipoSalario().equals("0"))
		 				{
		 					noviembre = s.getSalario();
		 					bNoviembre  = false;
		 				}else if(bNoviembre)
		 				{
		 					noviembre = noviembreUltimoSalario;
		 				}
		 				
	
		 				//salario de Diciembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("12")  && s.getTipoSalario().equals("0"))
		 				{
		 					diciembre = s.getSalario();
		 					bDiciembre  = false;
		 				}else if(bDiciembre)
		 				{
		 					diciembre = diciembreUltimoSalario;
		 				}
		 				
		 				
	
		 				//*********************************************************************************
		 				
		 				//*********************************************************************************
		 				//bonos de enero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("01")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					eneroBono += s.getSalario();
		 				}
		 				//bonos de febrero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("02")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					febreroBono += s.getSalario();
		 				}
		 				//bonos de marzo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("03")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					marzoBono += s.getSalario();
		 				}
		 				//bonos de abril
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("04")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					abrilBono += s.getSalario();
		 				}
		 				//bonos de mayo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("05")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					mayoBono += s.getSalario();
		 				}
		 				//bonos de junio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("06")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					junioBono += s.getSalario();
		 				}
		 				//bonos de julio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("07")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					julioBono += s.getSalario();
		 				}
		 				//bonos de agosto
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("08")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					agostoBono += s.getSalario();
		 				}
		 				//bonos de septiembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("09")
		 	 				   && s.getTipoSalario().equals("3") )
		 				{
		 					septiembreBono += s.getSalario();
		 				}
		 				//bonos de octubre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("10")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					octubreBono += s.getSalario();
		 				}
		 				//bonos de noviembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("11")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					noviembreBono += s.getSalario();
		 				}
		 				//bonos de diciembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("12")
		 	 				   && s.getTipoSalario().equals("3"))
		 				{
		 					diciembreBono += s.getSalario();
		 				}
		 				//*********************************************************************************
		 				
		 				
		 			}//fin for salario
		 		
	 			

 				//****************************************calculo de planilla del mes a calcular*****************************************
	 			
	 			if(Integer.parseInt(listMes) == 01){
	 				mesPlanilla = "Enero";
	 				salarioCalculo = (float) (enero - (enero*4.83/100)+ eneroBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 02){
	 				mesPlanilla = "Febrero";
	 				salarioCalculo = (float) (febrero- (febrero*4.83/100)+ febreroBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 03){
	 				mesPlanilla = "Marzo";
	 				salarioCalculo = (float) (marzo - (marzo*4.83/100)+ marzoBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 04){
	 				mesPlanilla = "Abril";
	 				salarioCalculo = (float) (abril - (abril*4.83/100)+ abrilBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 05){
	 				mesPlanilla = "Mayo";
	 				salarioCalculo = (float) (mayo - (mayo*4.83/100)+ mayoBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 06){
	 				mesPlanilla = "Junio";
	 				salarioCalculo = (float) (junio - (junio*4.83/100) + junioBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 07){
	 				mesPlanilla = "Julio";
	 				salarioCalculo = (float) (julio - (julio*4.83/100)+ julioBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 8){
	 				mesPlanilla = "Agosto";
	 				salarioCalculo = (float) (agosto - (agosto*4.83/100)+ agostoBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 9){
	 				mesPlanilla = "Septiembre";
	 				salarioCalculo = (float) (septiembre - (septiembre*4.83/100)+ septiembreBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 10){
	 				mesPlanilla = "Octubre";
	 				salarioCalculo = (float) (octubre - (octubre*4.83/100)+ octubreBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 11){
	 				mesPlanilla = "Noviembre";
	 				salarioCalculo = (float) (noviembre - (noviembre*4.83/100)+ noviembreBono);
	 				
	 			}else if(Integer.parseInt(listMes) == 12){
	 				mesPlanilla = "Diciembre";
	 				salarioCalculo = (float) (diciembre - (diciembre*4.83/100)+ diciembreBono);
	 				
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
	 			 bEnero = true;
		 		 bFebrero = true;
		 		 bMarzo	= true;
		 		 bAbril = true;
		 		 bMayo = true;
		 		 bJunio = true;
		 		 

		 		 eneroUltimoSalario = 0;
		 		 febreroUltimoSalario = 0;
		 		 marzoUltimoSalario = 0;
		 		 abrilUltimoSalario = 0;
		 		 mayoUltimoSalario = 0;
		 		 junioUltimoSalario = 0;
		 		 julioUltimoSalario = 0;
		 		 agostoUltimoSalario = 0;
		 		 septiembreUltimoSalario = 0;
		 		 octubreUltimoSalario = 0;
		 		 noviembreUltimoSalario = 0;
		 		 diciembreUltimoSalario = 0;
		 		
		 		 eneroAnioUltimo = 0;
		 		 febreroAnioUltimo = 0;
		 		 marzoAnioUltimo = 0;
		 		 abrilAnioUltimo = 0;
		 		 mayoAnioUltimo = 0;
		 		 junioAnioUltimo = 0;
		 		 julioAnioUltimo = 0;
		 		 agostoAnioUltimo = 0;
		 		 septiembreAnioUltimo = 0;
		 		 octubreAnioUltimo = 0;
		 		 noviembreAnioUltimo = 0;
		 		 diciembreAnioUltimo = 0;
		 		
		 		 eneroMesUltimo = 0;
		 		 febreroMesUltimo = 0;
		 		 marzoMesUltimo = 0;
		 		 abrilMesUltimo = 0;
		 		 mayoMesUltimo = 0;
		 		 junioMesUltimo = 0;
		 		 julioMesUltimo = 0;
		 		 agostoMesUltimo = 0;
		 		 septiembreMesUltimo = 0;
		 		 octubreMesUltimo = 0;
		 		 noviembreMesUltimo = 0;
		 		 diciembreMesUltimo = 0;

		 		 AuxAnio 	= "";
		 		 AuxMes 	= "";
	 			i++;
	 		}//fin for empleado
	 		
	 		xmlInicio 		= xmlInicio + xmlFinal;
	 		
	 		return xmlInicio;
	 	}

}
