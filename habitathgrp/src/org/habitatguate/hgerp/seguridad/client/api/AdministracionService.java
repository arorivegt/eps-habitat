/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Administracion
 */
package org.habitatguate.hgerp.seguridad.client.api;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 * 
 * @author arodriguez
 *
 */
@RemoteServiceRelativePath("Admnistracion")
public interface AdministracionService extends RemoteService {
	
	/**
	 * 
	 * @param rol
	 * @param nombreFormulario
	 * @param formularioPadre
	 * @param permiso
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long InsertarUsuarioPermiso(Long rol,String nombreFormulario, Long formularioPadre, String permiso) throws IllegalArgumentException;

	/**
	 * 
	 * @param idPermiso
	 * @param rol
	 * @param nombreFormulario
	 * @param formularioPadre
	 * @param permiso
	 * @return
	 * @throws IllegalArgumentException
	 */
	Long ActualizarUsuarioPermiso(Long idPermiso, Long rol,String nombreFormulario, Long formularioPadre, String permiso) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param Rol
	 * @return
	 * @throws IllegalArgumentException
	 */
	List<AuxUsuarioPermiso> ObtenerUsuarioPermiso(Long Rol) throws IllegalArgumentException;
	
	
	/**
	 * 
	 * @param Rol
	 * @param formularioPadre
	 * @return
	 * @throws IllegalArgumentException
	 */
	List<AuxUsuarioPermiso> ObtenerUsuarioPermisoFormularios(Long Rol,Long formularioPadre) throws IllegalArgumentException;

	/**
	 * 
	 * @param Rol
	 * @return
	 */
	Long EliminarUsuarioPermiso(Long Rol) throws IllegalArgumentException;
;

	/**
	 * 
	 * @param Rol
	 * @param formularioPadre
	 * @return
	 */
    Long EliminarUsuarioPermisoFormularios(Long Rol,Long formularioPadre) throws IllegalArgumentException;

    /**
     * 
     * @param nombreFormulario
     * @return
     */
	List<AuxUsuarioPermiso> ObtenerUsuarioPermisoNombre(String nombreFormulario,Long Rol) throws IllegalArgumentException;
	
	

    /**
     * 
     * @return
     */
	Long ObtenerUltimoROl();
	
    
}

