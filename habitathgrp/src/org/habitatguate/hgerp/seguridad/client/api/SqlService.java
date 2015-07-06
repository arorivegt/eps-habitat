package org.habitatguate.hgerp.seguridad.client.api;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoProducto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxContactoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCuentaBancariaProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialPagoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegPlantillaSolucion;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;



@RemoteServiceRelativePath("Insertar")
public interface SqlService extends RemoteService{
	String[] Insertar(String nomParam,int codContable,int codUno, int codDos) throws IllegalArgumentException;
	Long Insertar_Afiliado(String nomAfiliado,String dirAfiliado,String municipio,String departamento);
	Long Insertar_Beneficiario(String nomBeneficiario,String dirBeneficiario,int telBeneficiario,Long idAfiliado);
	Long Insertar_MaterialCostruccion(String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario);
	Long Insertar_PlantillaSolucion(String nomPlantilla,String tipo,Double costoFinal);
	Long Insertar_DetallePlantillaSolucion(Long idPlantillaSolucion,List<AuxDetallePlantillaSolucion> listaDetallePlantilla);
	Long Insertar_UnicoDetallePlantillaSolucion(Long idPlantillaSolucion,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_Bene(String nomBeneficiario,String dirBeneficiario,int telBeneficiario,Long idAfiliado);
	Long Insertar_Proveedor(Boolean aprobadoComision,String dirProveedor,Date fechaIngreso,String nomProveedor,String numeroNit,String paginaWeb,String personaJuridica,Boolean servicioEntrega,String telProveedor,String observaciones);
	Long Insertar_ProveedorCompleto(Boolean aprobadoComision,
			String dirProveedor,Date fechaIngreso,String nomProveedor,String numeroNit,String paginaWeb,String personaJuridica,Boolean servicioEntrega,
			String telProveedor,String observaciones,			
			String razonSocial,	String actividadEcono,String aceptaExencion,String relacionConProv,	String tipoProveedor,
			String productosfrece,String disponibilidadProd,String tiempoEntrega,String regimenTributario,String aceptaDonacion,double porcentDonacion); 
	Long Insertar_MaterialCostruccionAfiliadoProveedor(Long idProveedor,String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario, String idProducto);
	Long Insertar_Solucion(AuxSolucion auxS,Double costoFinal);
	Long Insertar_UnicoDetalleSolucion(Long idSolucion,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_UnicoHistorialSolucion(Long idSolucion,Long idVale,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_PagoVale(Long idVale, Date fechaVale, String serieDocumento, String tipoDocumento, Double valorPago);
	Long Insertar_Catalogo(String idMaterial,String nombreMaterial,String categoriaMaterial);
	Long Insertar_ValePagado(Long idHistorialPagoProv, Long idVale,Double totalPago);
	Long Insertar_ContactoProveedor(Long idProveedor,String nomContacto,String dirContacto, String telContacto, String correoContacto, String cellphoneContacto);
	Long Insertar_FormaPagoProv(Long idProveedor,String tipoPago,String tipoCuentaBancaria, String bancoCuentaBancaria, String numeroCuentaBancaria, String nombrePropietario);
	String Insertar_CatalogoProducto(String idProducto, String descripcionProducto);
	Long GenerarIdVale();
	List<AuxParametro> ConsultaTodosParam();
	List<AuxAfiliado> ConsultaTodosAfiliados();
	List<AuxBeneficiario> ConsultaTodosBene();
	List<AuxPlantillaSolucion> ConsultaTodasPlantillas();
	List<AuxMaterialCostruccion> ConsultaTodosMaterialCostruccion();
	List<AuxProveedor> ConsultaTodosProveedor_PorAfiliado(Long Afiliado);
	List<AuxProveedor> ConsultaTodosProveedor_SinAprobar(Long Afiliado);
	List<AuxProveedor> ConsultaTodosProveedor_PorAfiliadoAprobados(Long Afiliado);
	List<AuxProveedor> ConsultaTodosProveedor_Aprobados();
	List<AuxBeneficiario> ConsultaTodosBene_PorAfiliado(Long idAfiliado);
	List<AuxBeneficiario> ConsultaTodosBene_PorAfiliadoDos(Long idAfiliado);
	List<AuxVale> ConsultarValesPendientes_unProveedor(Long idProveedor);
	List<AuxSolucion> Consulta_SolucionesGenerales();
	List<AuxCuentaBancariaProv> Consultar_FormasPago(Long idProveedor);
	List<AuxContactoProv> Consultar_ContactosProv(Long idProveedor);
	List<AuxCatalogoProducto> Consultar_CatalogoProductos();
	AuxBeneficiario ConsultaRecord_Beneficiario(Long idAfiliado, Long idBeneficiario);
	AuxBeneficiario ConsultaBene_PorAfiliado(Long idAfiliado, Long idBeneficiario);
	AuxHistorialPagoProv Consultar_SolicitudPagoVales(Long idHistorialPagoProv);
	AuxProveedor Consultar_infoProveedor(Long idProveedor);
	List<AuxCatalogoMaterial> ConsultaTodosProductosCatalogo();
	List<AuxValeBeneficiario> ConsultarValesPendientes_Aprobar(Long idAfiliado);
	List<AuxSolucion> Consulta_ComparativoPlaniEjecucionSolucion();
	List<AuxSolucion> Consulta_PagosRealizados(Long idBeneficiario);
	Long Eliminar_Parametro(Long id);
	Long Eliminar_Afiliado(Long id);
	Long Eliminar_Beneficiario(Long id);
	Long Eliminar_MaterialCostruccion(Long id);
	Long Eliminar_Proveedor(Long id);
	Long Eliminar_ProductoCatalogo(Long id);
	Long Actualizar_Parametro(Long id,String nomParam,int codContable,int codUno, int codDos);
	Long Actualizar_Afiliado(Long id,String nomAfiliado,String dirAfiliado,String depAfiliado, String munAfiliado);
	Long Actualizar_Beneficiario(Long id,String nomBeneficiario,String dirBeneficiario,int telBeneficiario);
	Long Actualizar_MaterialCostruccion(Long id,String nomMaterialCostruccion,Double precioUnitario,String unidadMetrica);
	Long Actualizar_Proveedor(Long id,Boolean aprobadoComision, String dirProveedor,Long fechaIngreso, String nomProveedor,String numeroNit, String observaciones, String paginaWeb, String personaJuridica, Boolean servicioEntrega, String telProveedor);
	Long Actualizar_ProveedorAprobado(Long id);
	Long Actualizar_AfiliadoEmpleado(Long idAfiliado, Long idEmpleado);
	Long Actualizar_DetalleSolucion(Long idDetalleSolucion, Long idVale, Long idSolucion);
	Long Actualizar_EstadoVale(Long idVale, java.util.Date fechaVale, Double costoTotal);
	Long Actualizar_StatusValeAprobado(Long idVale,int status);
	
}
