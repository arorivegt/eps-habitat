package org.habitatguate.hgerp.seguridad.client.api;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.finanzas.AuxParametro;
import org.habitatguate.hgerp.seguridad.service.jdo.SegParametro;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;



@RemoteServiceRelativePath("Insertar")
public interface SqlService extends RemoteService{
	String[] Insertar(String nomParam,int codContable,int codUno, int codDos) throws IllegalArgumentException;
	List<AuxParametro> ConsultaTodosParam() throws IllegalArgumentException;
	Long Eliminar_Parametro(Long id);
	
}
