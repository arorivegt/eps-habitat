package org.habitatguate.hgerp.seguridad.client.api;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
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
	Long Insertar_MaterialCostruccionAfiliadoProveedor(Long idProveedor,String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario);
	Long Insertar_Solucion(AuxSolucion auxS,Double costoFinal);
	Long Insertar_UnicoDetalleSolucion(Long idSolucion,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_UnicoHistorialSolucion(Long idSolucion,Long idVale,AuxDetallePlantillaSolucion auxDetalle);
	Long Insertar_PagoVale(Long idVale, Date fechaVale, String serieDocumento, String tipoDocumento, Double valorPago);
	Long Insertar_Catalogo(String idMaterial,String nombreMaterial,String categoriaMaterial);
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
	AuxBeneficiario ConsultaBene_PorAfiliado(Long idAfiliado, Long idBeneficiario);
	List<AuxCatalogoMaterial> ConsultaTodosProductosCatalogo();
	Long Eliminar_Parametro(Long id);
	Long Eliminar_Afiliado(Long id);
	Long Eliminar_Beneficiario(Long id);
	Long Eliminar_MaterialCostruccion(Long id);
	Long Eliminar_Proveedor(Long id);
	Long Actualizar_Parametro(Long id,String nomParam,int codContable,int codUno, int codDos);
	Long Actualizar_Afiliado(Long id,String nomAfiliado,String dirAfiliado,String depAfiliado, String munAfiliado);
	Long Actualizar_Beneficiario(Long id,String nomBeneficiario,String dirBeneficiario,int telBeneficiario);
	Long Actualizar_MaterialCostruccion(Long id,String nomMaterialCostruccion,Double precioUnitario,String unidadMetrica);
	Long Actualizar_Proveedor(Long id,Boolean aprobadoComision, String dirProveedor,Long fechaIngreso, String nomProveedor,String numeroNit, String observaciones, String paginaWeb, String personaJuridica, Boolean servicioEntrega, String telProveedor);
	Long Actualizar_ProveedorAprobado(Long id);
	Long Actualizar_AfiliadoEmpleado(Long idAfiliado, Long idEmpleado);
	Long Actualizar_DetalleSolucion(Long idDetalleSolucion, Long idVale, Long idSolucion);
	Long Actualizar_EstadoVale(Long idVale, java.util.Date fechaVale, Double costoTotal);
	
}
