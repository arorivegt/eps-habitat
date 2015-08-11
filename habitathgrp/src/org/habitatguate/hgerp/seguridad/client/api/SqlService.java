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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;



@RemoteServiceRelativePath("Insertar")
public interface SqlService extends RemoteService{
	String[] Insertar(String nomParam,int codContable,int codUno, int codDos) throws IllegalArgumentException;
	Long Insertar_Afiliado(String nomAfiliado,String dirAfiliado,String municipio,String departamento,String numeroTelefono,String codigoAfiliado);
	Long Insertar_Beneficiario(String nomBeneficiario,String dirBeneficiario,int telBeneficiario,Long idAfiliado);
	Long Insertar_MaterialCostruccion(String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario);
	Long Insertar_PlantillaSolucion(String nomPlantilla,String tipo,Double costoFinal);
	Long Insertar_DetallePlantillaSolucion(Long idPlantillaSolucion,List<AuxDetallePlantillaSolucion> listaDetallePlantilla);
	Long Insertar_UnicoDetallePlantillaSolucion(Long idPlantillaSolucion,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_Bene(String nomBeneficiario,String dirBeneficiario,int telBeneficiario,Long idAfiliado);
	Long Insertar_Proveedor(Boolean aprobadoComision,String dirProveedor,Date fechaIngreso,String nomProveedor,String numeroNit,String paginaWeb,String personaJuridica,Boolean servicioEntrega,String telProveedor,String observaciones);
	Long Insertar_ProveedorCompleto(Boolean aprobadoComision,
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
			 Date fechaIngreso,
			 Long idAfiliado
			); 
	Long Insertar_MaterialCostruccionAfiliadoProveedor(Long idProveedor,String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario, String idProducto,Long idAfiliado);
	Long Insertar_Solucion(AuxSolucion auxS,Double costoFinal);
	Long Insertar_UnicoDetalleSolucion(Long idSolucion,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_UnicoHistorialSolucion(Long idSolucion,Long idVale,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_PagoVale(Date fechaSolicitud,String banco, String chequeNombre, Date fechadeTransaccion, 
			Long idAfiliado,Long idProveedor, String numeroCuenta, Double retenidoDonacion, Double retenidoIva, 
			String seriesDocumento, String tipoOperacion, Double valorCancelado, Double valorPago);
	String Insertar_Catalogo(String idMaterial,String nombreMaterial,String tipoMaterial,String idProducto,String unidadMedida);
	Long Insertar_ValePagado(Long idHistorialPagoProv, Long idVale,Double totalPago);
	Long Insertar_ContactoProveedor(Long idProveedor,String nomContacto,String dirContacto, String telContacto, String correoContacto, String cellphoneContacto, Long idAfiliado);
	Long Insertar_FormaPagoProv(Long idProveedor,String tipoPago,String tipoCuentaBancaria, String bancoCuentaBancaria, String numeroCuentaBancaria, String nombrePropietario, Long idAfiliado);
	String Insertar_CatalogoProducto(String idProducto, String descripcionProducto);
	String Insertar_TipoSolucion(String nomTipoSolucion,String descripcion);
	Long Insertar_PersonalAfiliado(Long idAfiliado,String nomAdmin,String nomAsistente,String nomContador,String nomEncargadoCheques);
	Long Agregar_DetalleEjecucionVale(Long idVale, Long idDetalleEjecucion);
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
	List<AuxSolucion> Consultar_SolucionesEnCostruccion_PorAfiliado(Long idAfiliado);
	List<AuxSolucion> Consultar_SolucionesFinalizadas_PorAfiliado(Long idAfiliado, String trimestre,String anio);
	AuxBeneficiario ConsultaRecord_Beneficiario(Long idAfiliado, Long idBeneficiario);
	AuxBeneficiario ConsultaBene_PorAfiliado(Long idAfiliado, Long idBeneficiario);
	AuxHistorialPagoProv Consultar_SolicitudPagoVales(Long idHistorialPagoProv);
	AuxProveedor Consultar_infoProveedor(Long idProveedor,Long idAfiliado);
	List<AuxCatalogoMaterial> ConsultaTodosProductosCatalogo();
	List<AuxValeBeneficiario> ConsultarValesPendientes_Aprobar(Long idAfiliado);
	List<AuxSolucion> Consulta_ComparativoPlaniEjecucionSolucion();
	List<AuxSolucion> Consulta_PagosRealizados(Long idBeneficiario);
	List<AuxReporteCuentasPorPagar> ConsultarCuentasXPagar_PorProveedores();
	List<AuxTipoSolucion> Consultar_TipoSolucion();
	List<AuxPersonalAfiliado> Consultar_PersonalAfiliado();
	List<AuxAfiliado> Consulta_ComparativoPrecios(String idItemCostruccion);
	List<AuxSolucion> Consulta_SolucionesGeneralesOpcion1(String anio, String trimestre);
	List<AuxSolucion> Consulta_SolucionesGeneralesAfiliado(Long idAfiliado);
	List<AuxSolucion> Consulta_SolucionesGeneralesRango(double minimo, double maximos);
	List<AuxSolucion> Consulta_SolucionesGeneralesTipoSolucion(String tipoSolucion);
	List<AuxSolucion> Consulta_ComparativoPlaniEjecucionSolucion_TipoSolucion(String tipoSolucion);
	List<AuxSolucion> Consulta_ComparativoPlaniEjecucionSolucion_RangoMontos(double minimo, double maximos);
	List<AuxSolucion> Consulta_ComparativoPlaniEjecucionSolucion_Afiliado(Long idAfiliado);
	List<AuxSolucion> Consulta_ComparativoPlaniEjecucionSolucion_Opcion1(String anio, String trimestre);
	List<AuxValeBeneficiario> ConsultarValesAprobados(Long idAfiliado, Long idBeneficiario);
	List<AuxValeBeneficiario> ConsultarValesAprobados_PorTrimestreAnio(Long idAfiliado, String trimestre, int anio);
	Long Eliminar_Parametro(Long id);
	Long Eliminar_Afiliado(Long id);
	Long Eliminar_Beneficiario(Long id);
	Long Eliminar_MaterialCostruccion(Long id);
	Long Eliminar_Proveedor(Long id);
	Long Eliminar_ProductoCatalogo(String id);
	Long Actualizar_Parametro(Long id,String nomParam,int codContable,int codUno, int codDos);
	Long Actualizar_Afiliado(Long id,String nomAfiliado,String dirAfiliado,String depAfiliado, String munAfiliado);
	Long Actualizar_Beneficiario(Long id,String nomBeneficiario,String dirBeneficiario,int telBeneficiario);
	Long Actualizar_MaterialCostruccion(Long id,String nomMaterialCostruccion,Double precioUnitario,String unidadMetrica);
	Long Actualizar_Proveedor(Long id,Boolean aprobadoComision, String dirProveedor,Long fechaIngreso, String nomProveedor,String numeroNit, String observaciones, String paginaWeb, String personaJuridica, Boolean servicioEntrega, String telProveedor);
	Long Actualizar_ProveedorAprobado(Long id,Long idAfiliado);
	Long Actualizar_AfiliadoEmpleado(Long idAfiliado, Long idEmpleado);
	Long Actualizar_DetalleSolucion(Long idDetalleSolucion, Long idVale, Long idSolucion);
	Long Actualizar_EstadoVale(Long idVale, java.util.Date fechaVale, Double costoTotal);
	Long Actualizar_StatusValeAprobado(Long idVale,int status);
	Long Actualizar_EstadoFinalizadoSolucion(Long idSolucion,int numeroSolucion);
	Long Actualizar_TrimestreSolucion(Long idSolucion,int trimestre,int anio);
	
}
