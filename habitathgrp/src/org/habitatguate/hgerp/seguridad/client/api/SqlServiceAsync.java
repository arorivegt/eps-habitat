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
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPersonalAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReporteCuentasPorPagar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTipoSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegPlantillaSolucion;

import com.google.gwt.user.client.rpc.AsyncCallback;
public interface SqlServiceAsync {
	void Insertar(String nomParam,int codContable,int codUno,int codDos, AsyncCallback<String[]> callback)
			throws IllegalArgumentException;
	
	void Insertar_Afiliado(String nomAfiliado, String dirAfiliado,
			String municipio, String departamento, AsyncCallback<Long> callback);
	
	void Eliminar_Parametro(Long id, AsyncCallback<Long> callback)
			throws IllegalArgumentException;
	
	
	void ConsultaTodosParam( AsyncCallback<List<AuxParametro>> callback)
			throws IllegalArgumentException;

	void ConsultaTodosAfiliados(AsyncCallback<List<AuxAfiliado>> callback)
			throws IllegalArgumentException;

	void Actualizar_Parametro(Long id, String nomParam, int codContable,
			int codUno, int codDos, AsyncCallback<Long> callback);

	void Insertar_Beneficiario(String nomBeneficiario, String dirBeneficiario,
			int telBeneficiario,Long idAfiliado, AsyncCallback<Long> callback);

	void Eliminar_Afiliado(Long id, AsyncCallback<Long> callback);

	void Actualizar_Afiliado(Long id, String nomAfiliado, String dirAfiliado,
			String depAfiliado, String munAfiliado, AsyncCallback<Long> callback);

	void ConsultaTodosBene(AsyncCallback<List<AuxBeneficiario>> callback);

	void Eliminar_Beneficiario(Long id, AsyncCallback<Long> callback);

	void Actualizar_Beneficiario(Long id, String nomBeneficiario,
			String dirBeneficiario, int telBeneficiario,
			AsyncCallback<Long> callback);

	void Insertar_MaterialCostruccion(String nomMaterialCostruccion,
			String unidadMetrica, Double precioUnitario,
			AsyncCallback<Long> callback);

	void ConsultaTodosMaterialCostruccion(
			AsyncCallback<List<AuxMaterialCostruccion>> callback);

	void Actualizar_MaterialCostruccion(Long id, String nomMaterialCostruccion,
			Double precioUnitario, String unidadMetrica,
			AsyncCallback<Long> callback);

	void Eliminar_MaterialCostruccion(Long id, AsyncCallback<Long> callback);

	void Insertar_PlantillaSolucion(String nomPlantilla, String tipo,
			Double costoFinal, AsyncCallback<Long> callback);

	void Insertar_DetallePlantillaSolucion(Long idPlantillaSolucion,
			List<AuxDetallePlantillaSolucion> listaDetallePlantilla,
			AsyncCallback<Long> callback);

	void Insertar_UnicoDetallePlantillaSolucion(Long idPlantillaSolucion,
			AuxDetallePlantillaSolucion auxDetalle, AsyncCallback<Long> callback);

	void ConsultaTodasPlantillas(
			AsyncCallback<List<AuxPlantillaSolucion>> callback);

	void Insertar_Bene(String nomBeneficiario, String dirBeneficiario,
			int telBeneficiario, Long idAfiliado, AsyncCallback<Long> callback);

	void Insertar_Proveedor(Boolean aprobadoComision, String dirProveedor,
			Date fechaIngreso, String nomProveedor, String numeroNit,
			String paginaWeb, String personaJuridica, Boolean servicioEntrega,
			String telProveedor,String observaciones, AsyncCallback<Long> callback);

	void ConsultaTodosProveedor_PorAfiliado(Long Afiliado,
			AsyncCallback<List<AuxProveedor>> callback);

	void Actualizar_Proveedor(Long id, Boolean aprobadoComision,
			String dirProveedor, Long fechaIngreso,
			String nomProveedor, String numeroNit, String observaciones,
			String paginaWeb, String personaJuridica, Boolean servicioEntrega,
			String telProveedor, AsyncCallback<Long> callback);

	void Insertar_MaterialCostruccionAfiliadoProveedor(Long idProveedor,
			String nomMaterialCostruccion, String unidadMetrica,
			Double precioUnitario, String idProducto,Long idAfiliado, AsyncCallback<Long> callback);

	void Eliminar_Proveedor(Long id, AsyncCallback<Long> callback);

	void ConsultaTodosProveedor_SinAprobar(Long Afiliado,
			AsyncCallback<List<AuxProveedor>> callback);

	void Actualizar_ProveedorAprobado(Long id,Long idAfiliado, AsyncCallback<Long> callback);

	void ConsultaTodosProveedor_PorAfiliadoAprobados(Long Afiliado,
			AsyncCallback<List<AuxProveedor>> callback);

	void Insertar_Solucion(AuxSolucion auxS, Double costoFinal,
			AsyncCallback<Long> callback);

	void Insertar_UnicoDetalleSolucion(Long idSolucion,
			AuxDetallePlantillaSolucion auxDetalle, AsyncCallback<Long> callback);

	void Actualizar_AfiliadoEmpleado(Long idAfiliado, Long idEmpleado,
			AsyncCallback<Long> callback);

	void ConsultaTodosBene_PorAfiliado(Long idAfiliado,
			AsyncCallback<List<AuxBeneficiario>> callback);

	void GenerarIdVale(AsyncCallback<Long> callback);

	void Actualizar_DetalleSolucion(Long idDetalleSolucion, Long idVale,
			Long idSolucion, AsyncCallback<Long> callback);

	void Actualizar_EstadoVale(Long idVale, Date fechaVale ,Double costoTotal, AsyncCallback<Long> callback);



	void ConsultaTodosBene_PorAfiliadoDos(Long idAfiliado,
			AsyncCallback<List<AuxBeneficiario>> callback);

	void Insertar_UnicoHistorialSolucion(Long idSolucion, Long idVale,
			AuxDetallePlantillaSolucion auxDetalle, AsyncCallback<Long> callback);

	void ConsultaBene_PorAfiliado(Long idAfiliado, Long idBeneficiario,
			AsyncCallback<AuxBeneficiario> callback);

	void ConsultaTodosProveedor_Aprobados(
			AsyncCallback<List<AuxProveedor>> callback);

	void ConsultarValesPendientes_unProveedor(Long idProveedor,
			AsyncCallback<List<AuxVale>> callback);

	void Insertar_PagoVale(Date fechaSolicitud,String banco, String chequeNombre, Date fechadeTransaccion, 
			Long idAfiliado,Long idProveedor, String numeroCuenta, Double retenidoDonacion, Double retenidoIva, 
			String seriesDocumento, String tipoOperacion, Double valorCancelado, Double valorPago, AsyncCallback<Long> callback);

	void Insertar_Catalogo(String idMaterial,String nombreMaterial,String tipoMaterial,String idProducto,AsyncCallback<String> callback);

	void ConsultaTodosProductosCatalogo(
			AsyncCallback<List<AuxCatalogoMaterial>> callback);

	void Eliminar_ProductoCatalogo(String id, AsyncCallback<Long> callback);

	void ConsultaRecord_Beneficiario(Long idAfiliado, Long idBeneficiario,
			AsyncCallback<AuxBeneficiario> callback);

	void Consulta_SolucionesGenerales(AsyncCallback<List<AuxSolucion>> callback);

	void Insertar_ProveedorCompleto(Boolean aprobadoComision,
			String nomProveedor,
			 String numeroNit,
			 String dirProveedor,
			 String telProveedor,
			 String paginaWeb,
			 String personaJuridica,
			 String razonSocial,
			 String actividadEcono,
			 String aceptaExencion,
			 String relacionConProv,
			 String tipoProveedor,
			 String tiempoDeTrabajarConHG,
			 String Departamentos,
			 String Municipios,
			 String ubicacionSucursales,
			 String productosfrece,
			 String disponibilidadProd,
			 Boolean servicioEntrega,
			 String tiempoEntrega,
			 String regimenTributario,
			 String observaciones,
			 String aceptaDonacion,
			 String formaDonacion,
			 double porcentDonacion,
			 String frecuenciaDonacion,
			 Boolean contribuyeEventos,
			 String cualesyComoEventos,
			 Boolean aceptaCredito,
			 double montoMaximo,
			 int tiempoMaximo,
			 Date fechaIngreso
			,Long idAfiliado,
			AsyncCallback<Long> callback);

	void Insertar_ValePagado(Long idHistorialPagoProv, Long idVale,Double totalPago,
			AsyncCallback<Long> callback);

	void Consultar_SolicitudPagoVales(Long idHistorialPagoProv,
			AsyncCallback<AuxHistorialPagoProv> callback);

	void Insertar_ContactoProveedor(Long idProveedor, String nomContacto,
			String dirContacto, String telContacto, String correoContacto,
			String cellphoneContacto, Long idAfiliado, AsyncCallback<Long> callback);

	void Insertar_FormaPagoProv(Long idProveedor, String tipoPago,
			String tipoCuentaBancaria, String bancoCuentaBancaria,
			String numeroCuentaBancaria, String nombrePropietario, Long idAfiliado,
			AsyncCallback<Long> callback);

	void Consultar_FormasPago(Long idProveedor,
			AsyncCallback<List<AuxCuentaBancariaProv>> callback);

	void Consultar_ContactosProv(Long idProveedor,
			AsyncCallback<List<AuxContactoProv>> callback);

	void Insertar_CatalogoProducto(String idProducto,
			String descripcionProducto, AsyncCallback<String> callback);

	void Consultar_CatalogoProductos(
			AsyncCallback<List<AuxCatalogoProducto>> callback);

	void ConsultarValesPendientes_Aprobar(Long idAfiliado,
			AsyncCallback<List<AuxValeBeneficiario>> callback);

	void Actualizar_StatusValeAprobado(Long idVale, int status,
			AsyncCallback<Long> callback);

	void Consulta_ComparativoPlaniEjecucionSolucion(
			AsyncCallback<List<AuxSolucion>> callback);

	void Consulta_PagosRealizados(Long idBeneficiario,AsyncCallback<List<AuxSolucion>> callback);

	void Consultar_infoProveedor(Long idProveedor,Long idAfiliado,
			AsyncCallback<AuxProveedor> callback);

	void Agregar_DetalleEjecucionVale(Long idVale, Long idDetalleEjecucion,
			AsyncCallback<Long> callback);

	void ConsultarCuentasXPagar_PorProveedores(
			AsyncCallback<List<AuxReporteCuentasPorPagar>> callback);

	void Insertar_TipoSolucion(String nomTipoSolucion, String descripcion,
			AsyncCallback<String> callback);

	void Insertar_PersonalAfiliado(Long idAfiliado, String nomAdmin,
			String nomAsistente, String nomContador,
			String nomEncargadoCheques, AsyncCallback<Long> callback);

	void Consultar_TipoSolucion(AsyncCallback<List<AuxTipoSolucion>> callback);

	void Consultar_PersonalAfiliado(
			AsyncCallback<List<AuxPersonalAfiliado>> callback);











	//void ConsultaTodosParam(AsyncCallback<List<segParametro>> callback);
}
