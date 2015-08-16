package org.habitatguate.hgerp.seguridad.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;


public class InfoComparativoPreciosXml {

		private SqlServiceImpl finanzasService = new  SqlServiceImpl();
	    private String xmlInicio 								 = "";
		private String  xmlFinal 								 = "";
		private String  xmlFinEncabezado 								 = "";
		private String  CuerpoEncabezado 								 = "";
		private String  CuerpoTabla 								 = "";
	
	 	public String Bancos(String idItemMaterial )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		List<AuxAfiliado>result =  finanzasService.Consulta_ComparativoPrecios(idItemMaterial);

 			
	 			CuerpoEncabezado+= "<td>"+"Proveedor-Afiliado"+"</td>"
			 					+ "<td>"+"Precio"+"</td>";

	 		
	 		//Tabla
	 		System.out.println("Afiliados"+ result.size());
	 		for(AuxAfiliado e:result)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+e.getNomAfiliado()+ " - "+e.getListaProveedores().get(0).getNomProveedor()+"</td>"
			 					+ "<td>"+e.getListaProveedores().get(0).getListaMateriales().get(0).getPrecioUnit()+"</td>"
			 					+ "</tr>";
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	public String ResumenCreditos(String idAfiliado,String anio, String anioFin, String minimo, String maximos, String filter )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxSolucion> result2 = finanzasService.Consulta_SolucionesGeneralesGenerica(idAfiliado, anio, anioFin, Double.valueOf(minimo), Double.valueOf(maximos), filter);
 			
	 		System.out.println("Datos"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Numero Solución"+"</td>"
			 					+ "<td>"+"Beneficiario"+"</td>"
			 					+ "<td>"+"Diseño"+"</td>"
			 					+ "<td>"+"Dirección"+"</td>"
			 					+ "<td>"+"Departamento"+"</td>"
			 					+ "<td>"+"Teléfono"+"</td>";
			 					
	 			
	 		for (String x : result2.get(0).getNombreProducto()){
	 			CuerpoEncabezado+= "<td>"+x+"</td>";
	 		}
	 		
	 			CuerpoEncabezado += "<td>"+"Ejecutado Costo Directo"+"</td>"
	 					+ "<td>"+"Costo Administrativo"+"</td>"
	 					+ "<td>"+"Costo Total Ejecutado"+"</td>"
	 					+ "<td>"+"Monto Autorizado"+"</td>"
	 					+ "<td>"+"(+/-)Costo Total y Monto Autorizado"+"</td>"
	 					+ "<td>"+"Cuentas por pagar"+"</td>";

	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxSolucion e:result2)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>'"+e.getIdSolucion()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getDisenio()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getDirBeneficiario()+"</td>"
	 							+ "<td>"+e.getDepartamentoSolucion()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getTelBeneficiario()+"</td>";
	 			
	 			for(Double y : e.getCostoProducto()){
	 				CuerpoTabla += "<td>"+y+"</td>";
	 			}
	 			CuerpoTabla += "<td>"+e.getCostoDirecto()+"</td>"
	 							+ "<td>"+e.getCostoAdministrativo()+"</td>"
	 							+ "<td>"+e.getCostoTotal()+"</td>"
	 							+ "<td>"+e.getValorContrato()+"</td>"
	 							+ "<td>"+String.valueOf(e.getValorContrato() - e.getCostoTotal())+"</td>"
	 							+ "<td>"+e.getCostoMaterial()+"</td>"
			 					+ "</tr>";
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	
	 	public String ResumenComparativoSolucion(String idAfiliado,String anio, String anioFin, String minimo, String maximos, String filter )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxSolucion> result2 = finanzasService.Consulta_ComparativoPlaniEjecucionGenerica(idAfiliado, anio, anioFin, Double.valueOf(minimo), Double.valueOf(maximos), filter);
 			
	 		System.out.println("Datos"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Numero Solución"+"</td>"
			 					+ "<td>"+"Beneficiario"+"</td>"
			 					+ "<td>"+"Diseño"+"</td>"
			 					+ "<td>"+"Dirección"+"</td>"
			 					+ "<td>"+"Departamento"+"</td>"
			 					+ "<td>"+"Teléfono"+"</td>";
			 					
	 			
	 		for (String x : result2.get(0).getNombreProducto()){
	 			CuerpoEncabezado+= "<td>"+"Ejecutado: "+x+"</td>";
	 			CuerpoEncabezado+= "<td>"+"Planificado: "+x+"</td>";
	 		}
	 		
	 			CuerpoEncabezado += "<td>"+"Ejecutado Costo Directo"+"</td>"
	 					+ "<td>"+"Planificado Costo Directo"+"</td>"
	 					+ "<td>"+"Costo Administrativo"+"</td>"
	 					+ "<td>"+"Costo Total Ejecutado"+"</td>"
	 					+ "<td>"+"Costo Total Planificado"+"</td>"
	 					+ "<td>"+"Monto Autorizado"+"</td>"
	 					+ "<td>"+"(+/-)Costo Total y Monto Autorizado"+"</td>"
	 					+ "<td>"+"Cuentas por pagar"+"</td>";

	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxSolucion e:result2)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>'"+e.getIdSolucion()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getDisenio()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getDirBeneficiario()+"</td>"
	 							+ "<td>"+e.getDepartamentoSolucion()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getTelBeneficiario()+"</td>";
	 			int z = 0;
	 			for(Double y : e.getCostoProducto()){
	 				CuerpoTabla += "<td>"+y+"</td>";
	 				CuerpoTabla += "<td>"+e.getCostoProductoPlani().get(z)+"</td>";
	 				z++;
	 			}
	 			CuerpoTabla += "<td>"+e.getCostoDirecto()+"</td>"
	 							+ "<td>"+e.getCostoDirectoPlani()+"</td>"
	 							+ "<td>"+e.getCostoAdministrativo()+"</td>"
	 							+ "<td>"+e.getCostoTotal()+"</td>"
	 							+ "<td>"+e.getCostoTotalPlani()+"</td>"
	 							+ "<td>"+e.getValorContrato()+"</td>"
	 							+ "<td>"+String.valueOf(e.getValorContrato() - e.getCostoTotal())+"</td>"
	 							+ "<td>"+e.getCostoMaterial()+"</td>"
			 					+ "</tr>";
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	

}
