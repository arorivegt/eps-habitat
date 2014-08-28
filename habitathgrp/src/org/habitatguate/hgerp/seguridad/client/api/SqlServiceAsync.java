package org.habitatguate.hgerp.seguridad.client.api;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.finanzas.AuxParametro;
import org.habitatguate.hgerp.seguridad.service.jdo.SegParametro;

import com.google.gwt.user.client.rpc.AsyncCallback;
public interface SqlServiceAsync {
	void Insertar(String nomParam,int codContable,int codUno,int codDos, AsyncCallback<String[]> callback)
			throws IllegalArgumentException;
	
	
	void Eliminar_Parametro(Long id, AsyncCallback<Long> callback)
			throws IllegalArgumentException;
	
	
	void ConsultaTodosParam( AsyncCallback<List<AuxParametro>> callback)
			throws IllegalArgumentException;

	//void ConsultaTodosParam(AsyncCallback<List<segParametro>> callback);
}
