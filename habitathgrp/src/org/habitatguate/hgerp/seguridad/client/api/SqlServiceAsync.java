package org.habitatguate.hgerp.seguridad.client.api;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;

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
			int telBeneficiario, AsyncCallback<Long> callback);

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




	//void ConsultaTodosParam(AsyncCallback<List<segParametro>> callback);
}
