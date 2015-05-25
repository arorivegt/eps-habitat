package org.habitatguate.hgerp.seguridad.client.api;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
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
			Double precioUnitario, AsyncCallback<Long> callback);

	void Eliminar_Proveedor(Long id, AsyncCallback<Long> callback);

	void ConsultaTodosProveedor_SinAprobar(Long Afiliado,
			AsyncCallback<List<AuxProveedor>> callback);

	void Actualizar_ProveedorAprobado(Long id, AsyncCallback<Long> callback);

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











	//void ConsultaTodosParam(AsyncCallback<List<segParametro>> callback);
}
