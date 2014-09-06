package org.habitatguate.hgerp.seguridad.client.api;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.finanzas.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.finanzas.AuxParametro;
import org.habitatguate.hgerp.seguridad.service.jdo.SegParametro;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;



@RemoteServiceRelativePath("Insertar")
public interface SqlService extends RemoteService{
	String[] Insertar(String nomParam,int codContable,int codUno, int codDos) throws IllegalArgumentException;
	Long Insertar_Afiliado(String nomAfiliado,String dirAfiliado,String municipio,String departamento);
	Long Insertar_Beneficiario(String nomBeneficiario,String dirBeneficiario,int telBeneficiario);
	List<AuxParametro> ConsultaTodosParam();
	List<AuxAfiliado> ConsultaTodosAfiliados();
	Long Eliminar_Parametro(Long id);
	Long Actualizar_Parametro(Long id,String nomParam,int codContable,int codUno, int codDos);

	
}
