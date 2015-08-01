package org.habitatguate.hgerp.seguridad.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;


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

}
