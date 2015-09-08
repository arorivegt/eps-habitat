package org.habitatguate.hgerp.seguridad.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxContactoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCuentaBancariaProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialPagoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;


public class InfoComparativoPreciosXml {

		private SqlServiceImpl finanzasService = new  SqlServiceImpl();
	    private String xmlInicio 								 = "";
		private String  xmlFinal 								 = "";
		private String  xmlFinEncabezado 								 = "";
		private String  CuerpoEncabezado 								 = "";
		private String  CuerpoTabla 								 = "";
	
	 	public String Bancos(String idItemCostruccion, String afiliado, String filter, String anio, String trimestre, String fechaInicio, String fechaFIn, String checkRange )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		List<AuxMaterialCostruccion>result =  finanzasService.Consulta_ComparativoPrecios_Generica2(afiliado, filter, idItemCostruccion,anio, trimestre, fechaInicio, fechaFIn, Boolean.valueOf(checkRange));

 			
	 			CuerpoEncabezado+= "<td>"+"Codigo Material"+"</td>"
			 					+ "<td>"+"Nombre Material"+"</td>"
			 					+ "<td>"+"Proveedor"+"</td>"
			 					+ "<td>"+"Afiliado"+"</td>"
			 					+ "<td>"+"Precio Unitario"+"</td>"
			 					+ "<td>"+"Unidad de medida"+"</td>";

	 		
	 		//Tabla
	 		System.out.println("Afiliados"+ result.size());
	 		for(AuxMaterialCostruccion e:result)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+e.getIdMaterialConstruccion()+"</td>"
			 					+ "<td>"+e.getNomMaterialCostruccion()+"</td>"
			 					+ "<td>"+e.getProveedor().getNomProveedor()+"</td>"
			 					+ "<td>"+e.getProveedor().getAuxAfiliado().getNomAfiliado()+"</td>"
			 					+ "<td>"+e.getPrecioUnit()/e.getCantidadMaterial()+"</td>"
			 					+ "<td>"+e.getUnidadMetrica()+"</td>"
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
	 			String nombreDep = getDepto(String.valueOf(e.getDepartamentoSolucion()));
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>'"+e.getIdSolucion()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getDisenio()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getDirBeneficiario()+"</td>"
	 							+ "<td>"+nombreDep+"</td>"
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
	 			String nombreDep = getDepto(String.valueOf(e.getDepartamentoSolucion()));
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>'"+e.getIdSolucion()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getDisenio()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getDirBeneficiario()+"</td>"
	 							+ "<td>"+nombreDep+"</td>"
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
	 	
	 	
	 	public String ReporteComprasProv(String idAfiliado, String filter, String idProveedor, String anioFin, String trimestre, String fechaInicio, String fechaFIn, String estado, boolean checkRange )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxValeBeneficiario> result2 = finanzasService.Consulta_ComprasProvGenerica2(idAfiliado, filter, idProveedor, anioFin, trimestre, fechaInicio, fechaFIn, estado, checkRange);
 			
	 		System.out.println("Datos"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Id Vale"+"</td>"
			 					+ "<td>"+"Estado Vale"+"</td>"
			 					+ "<td>"+"Afiliado"+"</td>"
			 					+ "<td>"+"Beneficiario"+"</td>"
			 					+ "<td>"+"Fecha Vale"+"</td>"
			 					+ "<td>"+"Total Vale"+"</td>"		
			 					+ "<td>"+"Proveedor"+"</td>";

	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxValeBeneficiario e:result2)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>"+e.getVale().getIdVale()+"</td>"
	 							+ "<td>"+e.getVale().getAprobado()+"</td>"
	 							+ "<td>"+e.getSolucion().getBeneficiario().getAfiliado().getNomAfiliado()+"</td>"
	 							+ "<td>"+e.getSolucion().getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getVale().getFechaVale()+"</td>"
	 							+ "<td>"+e.getVale().getTotalVale()+"</td>"
	 							+ "<td>"+e.getProveedor().getNomProveedor()+"</td>"
			 					+ "</tr>";
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	public String ReportePagosProv(String idAfiliado, String filter, String idProveedor, String anioFin, String trimestre, String fechaInicio, String fechaFIn, String estado, boolean checkRange )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxHistorialPagoProv> result2 = finanzasService.Consulta_PagosProvGenerica(idAfiliado, filter, idProveedor, anioFin, trimestre, fechaInicio, fechaFIn, estado, checkRange);
 			
	 		System.out.println("Datos"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Codigo Pago"+"</td>"
			 					+ "<td>"+"Afiliado"+"</td>"
			 					+ "<td>"+"Proveedor"+"</td>"
			 					+ "<td>"+"Tipo de Operación"+"</td>"
			 					+ "<td>"+"Fecha Pago"+"</td>"
			 					+ "<td>"+"Total Cancelado"+"</td>"		
			 					+ "<td>"+"Retenido por donación"+"</td>";

	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxHistorialPagoProv e:result2)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>'"+e.getIdHistorialPagoProv()+"</td>"
	 							+ "<td>"+e.getNombreAfiliado()+"</td>"
	 							+ "<td>"+e.getNombreProveedor()+"</td>"
	 							+ "<td>"+e.getTipoOperacion()+"</td>"
	 							+ "<td>"+e.getFechaSolicitud()+"</td>"
	 							+ "<td>"+e.getValorCancelado()+"</td>"
	 							+ "<td>"+e.getRetenidoDonacion()+"</td>"
			 					+ "</tr>";
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	public String SolucionesHab(String idAfiliado,String anio, String anioFin, String minimo, String maximos, String filter )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxSolucion> result2 = finanzasService.Consulta_SolucionesHabitacionalesGenerica(idAfiliado, anio, anioFin, Double.valueOf(minimo), Double.valueOf(maximos), filter);
 			
	 		System.out.println("Datos"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Numero Solución"+"</td>"
			 					+ "<td>"+"Beneficiario"+"</td>"
			 					+ "<td>"+"Diseño"+"</td>"
			 					+ "<td>"+"Dirección"+"</td>"
			 					+ "<td>"+"Departamento"+"</td>"
			 					+ "<td>"+"Teléfono"+"</td>";
			 						 		
	 			CuerpoEncabezado += "<td>"+"Costo Total Sumatoria"+"</td>"
	 					+ "<td>"+"Costo Total Promedio"+"</td>";


	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxSolucion e:result2)
	 		{
	 			String nombreDep = getDepto(String.valueOf(e.getDepartamentoSolucion()));
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>'"+e.getIdSolucion()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getDisenio()+"</td>"
	 							+ "<td>"+e.getBeneficiario().getDirBeneficiario()+"</td>"
	 							+ "<td>"+nombreDep+"</td>"
	 							+ "<td>"+e.getBeneficiario().getTelBeneficiario()+"</td>";
	 			
	 			
	 			CuerpoTabla +=  "<td>"+e.getCostoTotal()+"</td>"
	 					      +"<td>"+e.getCostoTotal()+"</td>";
	 							
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	public String ReporteCuentasAPagar(String idAfiliado, String filter, String idProveedor, String anioFin, String trimestre, String fechaInicio, String fechaFIn, String estado, boolean checkRange )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxValeBeneficiario> result2 = finanzasService.Consulta_CuentaAPagarProvGenerica2(idAfiliado, filter, idProveedor, anioFin, trimestre, fechaInicio, fechaFIn, estado, checkRange);
 			
	 		System.out.println("Datos"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Proveedor"+"</td>"
			 					+ "<td>"+"Afiliado"+"</td>"
			 					+ "<td>"+"Beneficiario"+"</td>"
			 					+ "<td>"+"Total a Pagar"+"</td>";


	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxValeBeneficiario e:result2)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>"+e.getProveedor().getNomProveedor()+"</td>"
	 							+ "<td>"+e.getSolucion().getBeneficiario().getAfiliado().getNomAfiliado()+"</td>"
	 							+ "<td>"+e.getSolucion().getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getVale().getTotalVale()+"</td>"
			 					+ "</tr>";
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	public String ReporteDeMateriales(String idAfiliado, String filter, String idProveedor, String anioFin, String trimestre, String fechaInicio, String fechaFIn, String idCatalogoMaterial,String idCatalogoMaterial2, boolean checkRange )
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxValeBeneficiario> result2 = finanzasService.Consulta_MaterialCostruccionGenerica(idAfiliado, filter, idProveedor, anioFin, trimestre, fechaInicio, fechaFIn, idCatalogoMaterial,idCatalogoMaterial2, checkRange);
 			
	 		System.out.println("Datos"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Proveedor"+"</td>"
			 					+ "<td>"+"Afiliado"+"</td>"
			 					+ "<td>"+"Codigo Catálogo Material"+"</td>"
			 					+ "<td>"+"Codigo Vale"+"</td>"
			 					+ "<td>"+"Beneficiario"+"</td>"
			 					+ "<td>"+"Fecha Vale"+"</td>"		
			 					+ "<td>"+"Precio Unitario"+"</td>"
			 					+ "<td>"+"Cantidad"+"</td>"
			 					+ "<td>"+"Total Compra"+"</td>";

	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxValeBeneficiario e:result2)
	 		{
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>"+e.getProveedor().getNomProveedor()+"</td>"
	 							+ "<td>"+e.getSolucion().getBeneficiario().getAfiliado().getNomAfiliado()+"</td>"
	 							+ "<td>"+e.getMaterialCostruccion().getIdCatalogoMaterial()+"</td>"
	 							+ "<td>"+e.getVale().getIdVale()+"</td>"
	 							+ "<td>"+e.getSolucion().getBeneficiario().getNomBeneficiario()+"</td>"
	 							+ "<td>"+e.getVale().getFechaVale()+"</td>"
	 							+ "<td>"+e.getMaterialCostruccion().getPrecioUnit()+"</td>"
	 							+ "<td>"+e.getCantidadMat()+"</td>"
	 							+ "<td>"+e.getTotalPagar()+"</td>"
			 					+ "</tr>";
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	public String ReporteDatosProv(String afiliado, String estado, String tipo)
	 	{
	 		String mesPlanilla 			=	"";
			DecimalFormat df 			= new DecimalFormat();
			df.setMaximumFractionDigits(2);
        
	 		String nombre 				= "";
	 		xmlInicio 					+= "<table><tbody><tr>";
			xmlFinEncabezado		 					+= "</tr>";

	 		xmlFinal = "</tbody></table></body></html>";	
	 		
	 		
	 		List<AuxProveedor> result2 = finanzasService.ConsultaDatosProveedor_Generico(afiliado, estado, tipo);
 			
	 		System.out.println("Datos Provvedores"+ result2.size());
	 		
	 			CuerpoEncabezado+= "<td>"+"Correlativo"+"</td>"
			 					+ "<td>"+"Codigo Proveedor"+"</td>"
			 					+ "<td>"+"Nombre Proveedor"+"</td>"
			 					+ "<td>"+"Numero de Nit"+"</td>"
			 					+ "<td>"+"Direccion Proveedor"+"</td>"
			 					+ "<td>"+"Teléfono Proveedor"+"</td>"
			 					+ "<td>"+"Pagina Web"+"</td>"
			 					+ "<td>"+"Persona Jurídica"+"</td>"
			 					+ "<td>"+"Razón Social"+"</td>"
			 					+ "<td>"+"Actividad Económica"+"</td>"
			 					+ "<td>"+"Acepta Exencion"+"</td>"
			 					+ "<td>"+"Relación con Proveedor"+"</td>"
			 					+ "<td>"+"Tipo de Proveedor"+"</td>"
			 					+ "<td>"+"Tiempo de trabajar con HG"+"</td>"
			 					+ "<td>"+"Afiliado"+"</td>"
			 					+ "<td>"+"Departamentos donde labora"+"</td>"
			 					+ "<td>"+"Municipios donde labora"+"</td>"
			 					+ "<td>"+"Ubicación Sucursales"+"</td>"
			 					+ "<td>"+"Productos que ofrece"+"</td>"
			 					+ "<td>"+"Disponibilidad de productos"+"</td>"
			 					+ "<td>"+"Servicio de entrega"+"</td>"
			 					+ "<td>"+"Tiempo máximo de entrega"+"</td>"
			 					+ "<td>"+"Regimen Tributario"+"</td>"
			 					+ "<td>"+"Observaciones Generales"+"</td>"
			 					+ "<td>"+"Acepta Donación"+"</td>"
			 					+ "<td>"+"Forma de Donación"+"</td>"
			 					+ "<td>"+"Porcentaje de Donación"+"</td>"
			 					+ "<td>"+"Frecuencia de Donación"+"</td>"
			 					+ "<td>"+"Contribuye Eventos"+"</td>"
			 					+ "<td>"+"Cuales y de que forma"+"</td>"
			 					+ "<td>"+"Acepta Crédito"+"</td>"
			 					+ "<td>"+"Monto Máximo Crédito"+"</td>"
			 					+ "<td>"+"Tiempo Maximo Credito"+"</td>"
			 					+ "<td>"+"fecha de Ingreso"+"</td>"
			 					+ "<td>"+"Estado del Proveedor"+"</td>"
			 					+ "<td>"+"Motivo de Inactivo"+"</td>"
			 					+ "<td>"+"URL RTU"+"</td>"
			 					+ "<td>"+"URL Convenio Aprobado"+"</td>"
			 					+ "<td>"+"Obsevaciones de Distribución"+"</td>"
			 					+ "<td>"+"Tipo General de Proveedor"+"</td>";

	 		
	 		//Tabla
	 		
	 		int correlativo = 1;
	 		for(AuxProveedor e:result2){
	 			
	 			CuerpoTabla += "<tr>"
	 							+ "<td>"+correlativo+"</td>"
	 							+ "<td>'"+e.getIdProveedor()+"</td>"
	 							+ "<td>"+e.getNomProveedor()+"</td>"
	 							+ "<td>"+e.getNumeroNit()+"</td>"
	 							+ "<td>"+e.getDirProveedor()+"</td>"
	 							+ "<td>"+e.getTelProveedor()+"</td>"
	 							+ "<td>"+e.getPaginaWeb()+"</td>"
	 							+ "<td>"+e.getPersonaJuridica()+"</td>"
	 							+ "<td>"+e.getRazonSocial()+"</td>"
	 							+ "<td>"+e.getActividadEcono()+"</td>"
	 							+ "<td>"+e.getAceptaExencion()+"</td>"
	 							+ "<td>"+e.getRelacionConProv()+"</td>"
	 							+ "<td>"+e.getTipoProveedor()+"</td>"
	 							+ "<td>"+"No hay dato"+"</td>"
	 							+ "<td>'"+e.getAuxAfiliado().getIdAfiliado()+"</td>"
	 							+ "<td>"+e.getDepartamentos()+"</td>"
	 							+ "<td>"+e.getMunicipios()+"</td>"
	 							+ "<td>"+e.getUbicacionSucursales()+"</td>"
	 							+ "<td>"+e.getProductosfrece()+"</td>"
	 							+ "<td>"+e.getDisponibilidadProd()+"</td>"
	 							+ "<td>"+e.getServicioEntrega()+"</td>"
	 							+ "<td>"+e.getTiempoEntrega()+"</td>"
	 							+ "<td>"+e.getRegimenTributario()+"</td>"
	 							+ "<td>"+e.getObservaciones()+"</td>"
	 							+ "<td>"+e.getAceptaDonacion()+"</td>"
	 							+ "<td>"+e.getFormaDonacion()+"</td>"
	 							+ "<td>"+e.getPorcentDonacion()+"</td>"
	 							+ "<td>"+e.getFrecuenciaDonacion()+"</td>"
	 							+ "<td>"+e.getContribuyeEventos()+"</td>"
	 							+ "<td>"+e.getCualesyComoEventos()+"</td>"
	 							+ "<td>"+e.getAceptaCredito()+"</td>"
	 							+ "<td>"+e.getMontoMaximo()+"</td>"
	 							+ "<td>"+"tiempo maximo"+"</td>"
	 							+ "<td>"+e.getFechaIngreso()+"</td>"
	 							+ "<td>"+e.getAprobadoComision()+"</td>"
	 							+ "<td>"+e.getMotivoInactivo()+"</td>"
	 							+ "<td>"+e.getURLFileRTU()+"</td>"
	 							+ "<td>"+e.getURLFileConvenio()+"</td>"
	 							+ "<td>"+e.getObservacionDistribucion()+"</td>"
	 							+ "<td>"+e.getTipoProveedorGeneral()+"</td>";
	 			
	 			
	 			for (AuxContactoProv auxContact : e.getListaContacto()){
	 				CuerpoTabla += "<td>"+"Nombre Contacto"+"</td>"
	 						+ "<td>"+auxContact.getNomContacto() +"</td>"
	 						+ "<td>"+"Puesto"+"</td>"
	 						+ "<td>"+auxContact.getPuestoContacto()+"</td>"
	 						+ "<td>"+"Telefono y Ext."+"</td>"
	 						+ "<td>"+auxContact.getTelContacto()+"</td>"
	 						+ "<td>"+"Celular"+"</td>"
	 						+ "<td>"+auxContact.getCellphoneContacto()+"</td>"
	 						+ "<td>"+"Corre Electronico"+"</td>"
	 						+ "<td>"+auxContact.getCorreoContacto()+"</td>";
	 			}
	 			for (AuxCuentaBancariaProv auxCuenta : e.getLista()){
	 				CuerpoTabla += "<td>"+"Tipo de Transaccion"+"</td>"
	 						+ "<td>"+ auxCuenta.getTipoPago()+"</td>"
	 						+ "<td>"+"Banco Emisor"+"</td>"
	 						+ "<td>"+ auxCuenta.getBancoCuentaBancaria() + "</td>"
	 						+ "<td>"+"Nombre del Propietario"+"</td>"
	 						+ "<td>"+ auxCuenta.getNombrePropietario() + "</td>"
	 						+ "<td>"+"Número de Cuenta"+"</td>"
	 						+ "<td>"+ auxCuenta.getNumeroCuentaBancaria() + "</td>"
	 						+ "<td>"+"Tipo de Cuenta"+"</td>"
	 						+ "<td>"+ auxCuenta.getTipoCuentaBancaria() + "</td>";
	 			}
			 	CuerpoTabla			+= "</tr>";
	 			correlativo++;
	 		}
	 		
	 		
	 		xmlInicio 		= xmlInicio+CuerpoEncabezado+xmlFinEncabezado + CuerpoTabla+xmlFinal;
	 		
	 		return xmlInicio;
	 	}
	 	
	 	private String Depto_Municipio(String Departamento){
			
			String valor = "";
			if(Departamento.equals("01")){	
				
				valor = valor + "," + "Guatemala";
				valor = valor + "," + "Santa Catarina Pinula";
				valor = valor + "," + "San Jose Pinula";
				valor = valor + "," + "San Jose del Golfo";
				valor = valor + "," + "Palencia";
				valor = valor + "," + "Chinautla";
				valor = valor + "," + "San Pedro Ayampuc";
				valor = valor + "," + "Mixco";
				valor = valor + "," + "San Pedro Sacatepequez";
				valor = valor + "," + "San Juan Sacatepequez";
				valor = valor + "," + "San Raymundo";
				valor = valor + "," + "Chuarrancho";
				valor = valor + "," + "Fraijanes";
				valor = valor + "," + "Amatitlan";
				valor = valor + "," + "Villa Nueva";
				valor = valor + "," + "Villa Canales";
				valor = valor + "," + "Petapa";
				
			}else if(Departamento.equals("15")){
				valor = valor + "," + "Salama";
				valor = valor + "," + "San Miguel Chicaj";
				valor = valor + "," + "Rabinal";
				valor = valor + "," + "Cubulco";
				valor = valor + "," + "Granados";
				valor = valor + "," + "Santa Cruz el Chol";
				valor = valor + "," + "San Jeronimo";
				valor = valor + "," + "Purulha";
				
			}else if(Departamento.equals("16")){
				valor = valor + "," + "Coban";
				valor = valor + "," + "Santa Cruz Verapaz";
				valor = valor + "," + "San Cristobal Verapaz";
				valor = valor + "," + "Tactic";
				valor = valor + "," + "Tamahu";
				valor = valor + "," + "Tucuru";
				valor = valor + "," + "Panzos";
				valor = valor + "," + "Senahu";
				valor = valor + "," + "San Pedro Carcha";
				valor = valor + "," + "San Juan Chamelco";
				valor = valor + "," + "Lanquin";
				valor = valor + "," + "Santa Maria Cahabon";
				valor = valor + "," + "Chisec";
				valor = valor + "," + "Chahal";
				valor = valor + "," + "Fray Bartolome de las Casas";
				valor = valor + "," + "La Tinta";
				valor = valor + "," + "Raxruha";
				
			}else if(Departamento.equals("02")){
				valor = valor + "," + "Guastatoya";
				valor = valor + "," + "Morazan";
				valor = valor + "," + "San Agustin Acasaguastlan";
				valor = valor + "," + "San Cristobal Acasaguastlan";
				valor = valor + "," + "El Jicaro";
				valor = valor + "," + "Sansare";
				valor = valor + "," + "Sanarate";
				valor = valor + "," + "San Antonio La Paz";
				
			}else if(Departamento.equals("18")){
				valor = valor + "," + "Puerto Barrios";
				valor = valor + "," + "Livingston";
				valor = valor + "," + "El Estor";
				valor = valor + "," + "Morales";
				valor = valor + "," + "Los Amates";
				
			}else if(Departamento.equals("19")){
				valor = valor + "," + "Zacapa";
				valor = valor + "," + "Estanzuela";
				valor = valor + "," + "Rio Hondo";
				valor = valor + "," + "Gualan";
				valor = valor + "," + "Teculutan";
				valor = valor + "," + "Usumatlan";
				valor = valor + "," + "Cabañas";
				valor = valor + "," + "Huite";
				valor = valor + "," + "San Diego";
				valor = valor + "," + "La Union";
				valor = valor + "," + "Huite";
				
			}else if(Departamento.equals("20")){

				valor = valor + "," + "Chiquimula";
				valor = valor + "," + "San Jose la Arada";
				valor = valor + "," + "San Juan Ermita";
				valor = valor + "," + "Jocotan";
				valor = valor + "," + "Camotan";
				valor = valor + "," + "Olopa";
				valor = valor + "," + "Esquipulas";
				valor = valor + "," + "Concepcion Las Minas";
				valor = valor + "," + "Quezaltepeque";
				valor = valor + "," + "San Jacinto";
				valor = valor + "," + "Ipala";
				
			}else if(Departamento.equals("06")){
				valor = valor + "," + "Cuilapa";
				valor = valor + "," + "Barberena";
				valor = valor + "," + "Santa Rosa de Lima";
				valor = valor + "," + "Casillas";
				valor = valor + "," + "San Rafael las Flores";
				valor = valor + "," + "Oratorio";
				valor = valor + "," + "San Juan Tecuaco";
				valor = valor + "," + "Chiquimulilla";
				valor = valor + "," + "Taxisco";
				valor = valor + "," + "Santa Maria Ixhuatan";
				valor = valor + "," + "Guazacapan";
				valor = valor + "," + "Santa Cruz Naranjo";
				valor = valor + "," + "Pueblo Nuevo Viñas";
				valor = valor + "," + "Nueva Santa Rosa";
				
			}else if(Departamento.equals("21")){
				valor = valor + "," + "Jalapa";
				valor = valor + "," + "San Pedro Pinula";
				valor = valor + "," + "San Luis Jilotepeque";
				valor = valor + "," + "San Manuel Chaparron";
				valor = valor + "," + "San Carlos Alzatate";
				valor = valor + "," + "Monjas";
				valor = valor + "," + "Mataquescuintla";
				
			}else if(Departamento.equals("22")){
				valor = valor + "," + "Jutiapa";
				valor = valor + "," + "El Progreso";
				valor = valor + "," + "Santa Catarina Mita";
				valor = valor + "," + "Agua Blanca";
				valor = valor + "," + "Asuncion Mita";
				valor = valor + "," + "Yupiltepeque";
				valor = valor + "," + "Atescatempa";
				valor = valor + "," + "Jerez";
				valor = valor + "," + "El Adelanto";
				valor = valor + "," + "Zapotitlan";
				valor = valor + "," + "Comapa";
				valor = valor + "," + "Jalpatagua";
				valor = valor + "," + "Conguaco";
				valor = valor + "," + "Moyuta";
				valor = valor + "," + "Pasaco";
				valor = valor + "," + "San Jose Acatempa";
				valor = valor + "," + "Quesada";
				
			}else if(Departamento.equals("03")){
				valor = valor + "," + "La Antigua Guatemala";
				valor = valor + "," + "Jocotenango";
				valor = valor + "," + "Pastores";
				valor = valor + "," + "Sumpango";
				valor = valor + "," + "Santo Domingo Xenacoj";
				valor = valor + "," + "Santiago Sacatepequez";
				valor = valor + "," + "San Bartolome Milpas Altas";
				valor = valor + "," + "San Lucas Sacatepequez";
				valor = valor + "," + "Santa Lucia Milpas Altas";
				valor = valor + "," + "Magdalena Milpas Altas";
				valor = valor + "," + "Santa Maria de Jesus";
				valor = valor + "," + "Ciudad Vieja";
				valor = valor + "," + "San Miguel Dueñas";
				valor = valor + "," + "Alotenango";
				valor = valor + "," + "San Antonio Aguas Calientes";
				valor = valor + "," + "Santa Catarina Barahona";
				
			}else if(Departamento.equals("04")){
				valor = valor + "," + "Chimaltenango";
				valor = valor + "," + "San Jose Poaquil";
				valor = valor + "," + "San Martin Jilotepeque";
				valor = valor + "," + "San Juan Comalapa";
				valor = valor + "," + "Santa Apolonia";
				valor = valor + "," + "Tecpan";
				valor = valor + "," + "Patzun";
				valor = valor + "," + "Pochuta";
				valor = valor + "," + "Patzicia";
				valor = valor + "," + "Santa Cruz Balanya";
				valor = valor + "," + "Acatenango";
				valor = valor + "," + "Yepocapa";
				valor = valor + "," + "San Andres Itzapa";
				valor = valor + "," + "Parramos";
				valor = valor + "," + "Zaragoza";
				valor = valor + "," + "El Tejar";
				
			}else if(Departamento.equals("05")){			
				valor = valor + "," + "Escuintla";
				valor = valor + "," + "Santa Lucia Cotzumalguapa";
				valor = valor + "," + "La Democracia";
				valor = valor + "," + "Siquinala";
				valor = valor + "," + "Masagua";
				valor = valor + "," + "Tiquisate";
				valor = valor + "," + "La Gomera";
				valor = valor + "," + "Guanagazapa";
				valor = valor + "," + "San Jose";
				valor = valor + "," + "Iztapa";
				valor = valor + "," + "Palin";
				valor = valor + "," + "San Vicente Pacaya";
				valor = valor + "," + "Nueva Concepcion";
				
			}else if(Departamento.equals("07")){
				valor = valor + "," + "Solola";
				valor = valor + "," + "San Jose Chacaya";
				valor = valor + "," + "Santa Maria Visitacion";
				valor = valor + "," + "Santa Lucia Utatlan";
				valor = valor + "," + "Nahuala";
				valor = valor + "," + "Santa Catarina Ixtahuacan";
				valor = valor + "," + "Santa Clara La Laguna";
				valor = valor + "," + "Concepcion";
				valor = valor + "," + "San Andres Semetabaj";
				valor = valor + "," + "Panajachel";
				valor = valor + "," + "Santa Catarina Palopo";
				valor = valor + "," + "San Antonio Palopo";
				valor = valor + "," + "San Lucas Toliman";
				valor = valor + "," + "Santa Cruz La Laguna";
				valor = valor + "," + "San Pablo La Laguna";
				valor = valor + "," + "San Juan La Laguna";
				valor = valor + "," + "San Marcos La Laguna";
				valor = valor + "," + "San Pedro La Laguna";
				valor = valor + "," + "Santiago Atitlan";
				
			}else if(Departamento.equals("08")){
				valor = valor + "," + "Totonicapan";
				valor = valor + "," + "San Cristobal Totonicapan";
				valor = valor + "," + "San Francisco El Alto";
				valor = valor + "," + "San Andres Xecul";
				valor = valor + "," + "Momostenango";
				valor = valor + "," + "Santa Maria Chiquimula";
				valor = valor + "," + "Santa Lucia La Reforma";
				valor = valor + "," + "San Bartolo";
				
			}else if(Departamento.equals("09")){
				valor = valor + "," + "Quetzaltenango";
				valor = valor + "," + "Salcaja";
				valor = valor + "," + "Olintepeque";
				valor = valor + "," + "San Carlos Sija";
				valor = valor + "," + "Sibilia";
				valor = valor + "," + "Cabrican";
				valor = valor + "," + "Cajola";
				valor = valor + "," + "San Miguel Sigüila";
				valor = valor + "," + "San Juan Ostuncalco";
				valor = valor + "," + "San Mateo";
				valor = valor + "," + "Concepcion Chiquirichapa";
				valor = valor + "," + "San Martin Sacatepequez";
				valor = valor + "," + "Almolonga";
				valor = valor + "," + "Cantel";
				valor = valor + "," + "Huitan";
				valor = valor + "," + "Zunil";
				valor = valor + "," + "Colomba Costa Cuca";
				valor = valor + "," + "San Francisco La Union";
				valor = valor + "," + "El Palmar";
				valor = valor + "," + "Coatepeque";
				valor = valor + "," + "Genova";
				valor = valor + "," + "Flores Costa Cuca";
				valor = valor + "," + "La Esperanza";
				valor = valor + "," + "Palestina de Los Altos";
				
			}else if(Departamento.equals("10")){
				valor = valor + "," + "Mazatenango";
				valor = valor + "," + "Cuyotenango";
				valor = valor + "," + "San Francisco Zapotitlan";
				valor = valor + "," + "San Bernardino";
				valor = valor + "," + "San Jose El Idolo";
				valor = valor + "," + "Santo Domingo Suchitepequez";
				valor = valor + "," + "San Lorenzo";
				valor = valor + "," + "Samayac";
				valor = valor + "," + "San Pablo Jocopilas";
				valor = valor + "," + "San Antonio Suchitepequez";
				valor = valor + "," + "San Miguel Panan";
				valor = valor + "," + "San Gabriel";
				valor = valor + "," + "Chicacao";
				valor = valor + "," + "Patulul";
				valor = valor + "," + "Santa Barbara";
				valor = valor + "," + "San Juan Bautista";
				valor = valor + "," + "Santo Tomas La Union";
				valor = valor + "," + "Zunilito";
				valor = valor + "," + "Pueblo Nuevo";
				valor = valor + "," + "Rio Bravo";
				
			}else if(Departamento.equals("11")){
				valor = valor + "," + "Retalhuleu";
				valor = valor + "," + "San Sebastian";
				valor = valor + "," + "Santa Cruz Mulua";
				valor = valor + "," + "San Martin Zapotitlan";
				valor = valor + "," + "San Felipe";
				valor = valor + "," + "San Andres Villa Seca";
				valor = valor + "," + "Champerico";
				valor = valor + "," + "Nuevo San Carlos";
				valor = valor + "," + "El Asintal";
				
			}else if(Departamento.equals("12")){
				valor = valor + "," + "San Marcos";
				valor = valor + "," + "San Pedro Sacatepequez";
				valor = valor + "," + "San Antonio Sacatepequez";
				valor = valor + "," + "Comitancillo";
				valor = valor + "," + "San Miguel Ixtahuacan";
				valor = valor + "," + "Concepcion Tutuapa";
				valor = valor + "," + "Tacana";
				valor = valor + "," + "Sibinal";
				valor = valor + "," + "Tajumulco";
				valor = valor + "," + "Tejutla";
				valor = valor + "," + "San Rafael Pie de la Cuesta";
				valor = valor + "," + "Nuevo Progreso";
				valor = valor + "," + "El Tumbador";
				valor = valor + "," + "San Jose El Rodeo";
				valor = valor + "," + "Malacatan";
				valor = valor + "," + "Catarina";
				valor = valor + "," + "Ayutla";
				valor = valor + "," + "Ocos";
				valor = valor + "," + "San Pablo";
				valor = valor + "," + "El Quetzal";
				valor = valor + "," + "La Reforma";
				valor = valor + "," + "Pajapita";
				valor = valor + "," + "Ixchiguan";
				valor = valor + "," + "San Jose Ojetenam";
				valor = valor + "," + "San Cristobal Cucho";
				valor = valor + "," + "Sipacapa";
				valor = valor + "," + "Esquipulas Palo Gordo";
				valor = valor + "," + "Rio Blanco";
				valor = valor + "," + "San Lorenzo";
				
			}else if(Departamento.equals("13")){
				valor = valor + "," + "Huehuetenango";
				valor = valor + "," + "Chiantla";
				valor = valor + "," + "Malacatancito";
				valor = valor + "," + "Cuilco";
				valor = valor + "," + "Nenton";
				valor = valor + "," + "San Pedro Necta";
				valor = valor + "," + "Jacaltenango";
				valor = valor + "," + "San Pedro Soloma";
				valor = valor + "," + "San Ildefonso Ixtahuacan";
				valor = valor + "," + "Santa Barbara";
				valor = valor + "," + "La Libertad";
				valor = valor + "," + "La Democracia";
				valor = valor + "," + "San Miguel Acatan";
				valor = valor + "," + "San Rafael La Independencia";
				valor = valor + "," + "Santos Cuchumatan";
				valor = valor + "," + "San Juan Atitan";
				valor = valor + "," + "Santa Eulalia";
				valor = valor + "," + "San Mateo Ixtatan";
				valor = valor + "," + "Colotenango";
				valor = valor + "," + "San Sebastian Huehuetenango";
				valor = valor + "," + "Tectitan";
				valor = valor + "," + "Concepcion Huista";
				valor = valor + "," + "San Juan Ixcoy";
				valor = valor + "," + "San Antonio Huista";
				valor = valor + "," + "San Sebastian Coatan";
				valor = valor + "," + "Santa Cruz Barillas";
				valor = valor + "," + "Aguacatan";
				valor = valor + "," + "San Rafael Petzal";
				valor = valor + "," + "San Gaspar Ixchil";
				valor = valor + "," + "Santiago Chimaltenango";
				valor = valor + "," + "Santa Ana Huista";
				valor = valor + "," + "Union Cantinil";
				
			}else if(Departamento.equals("14")){
				valor = valor + "," + "Santa Cruz del Quiche";
				valor = valor + "," + "Chiche";
				valor = valor + "," + "Chinique";
				valor = valor + "," + "Zacualpa";
				valor = valor + "," + "Chajul";
				valor = valor + "," + "Chichicastenango";
				valor = valor + "," + "Patzite";
				valor = valor + "," + "San Antonio Ilotenango";
				valor = valor + "," + "San Pedro Jocopilas";
				valor = valor + "," + "Cunen";
				valor = valor + "," + "San Juan Cotzal";
				valor = valor + "," + "Joyabaj";
				valor = valor + "," + "Nebaj";
				valor = valor + "," + "San Andres Sajcabaja";
				valor = valor + "," + "Uspantan";
				valor = valor + "," + "Sacapulas";
				valor = valor + "," + "San Bartolome Jocotenango";
				valor = valor + "," + "Canilla";
				valor = valor + "," + "Chicaman";
				valor = valor + "," + "Ixcan";
				valor = valor + "," + "Pachalum";
				
			}else if(Departamento.equals("17")){
				valor = valor + "," + "Flores";
				valor = valor + "," + "San Jose";
				valor = valor + "," + "San Benito";
				valor = valor + "," + "San Andres";
				valor = valor + "," + "La Libertad";
				valor = valor + "," + "San Francisco";
				valor = valor + "," + "Santa Ana";
				valor = valor + "," + "Dolores";
				valor = valor + "," + "San Luis";
				valor = valor + "," + "Sayaxche";
				valor = valor + "," + "Melchor de Mencos";
				valor = valor + "," + "Poptun";
				
			}else if(Departamento.equals("-")){
				valor = valor + "," + "-";
			}
		
			return valor;
		}


	    
	private String getDepto(String codigo){
		switch (codigo) {
		  case "01": return "Guatemala";  
		  case "15": return "Baja Verapaz";  
		 case "16": return "Alta Verapaz" ;  
		  case "02": return "El Progreso";  
		  case "18": return "Izabal";  
		 case "19": return  "Zacapa";  
		  case "20": return "Chiquimula";  
		  case "06": return "Santa Rosa";  
		  case "21": return "Jalapa";  
		  case "22": return "Jutiapa";  
		  case "03": return "Sacatepequez";  
		  case "04": return "Chimaltenango";  
		  case "05": return "Escuintla";  
		  case "07": return "Solola";  
		  case "08": return "Totonicapan";  
		  case "09": return "Quezaltenango"; 
		  case "10": return "Suchitepequez";  
		  case "11": return "Retalhuleu";  
		  case "12": return "San Marcos";  
		  case "13": return "Huehuetenango";  
		  case "14": return "Quiche";  
		  case "17": return "Peten";  

		default: return "Sin Dep";
		}
	}
	 	

}
