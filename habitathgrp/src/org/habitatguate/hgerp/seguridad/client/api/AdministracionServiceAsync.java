/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Administracion
 */
package org.habitatguate.hgerp.seguridad.client.api;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 * @author arodriguez
 *
 */
public interface AdministracionServiceAsync {
	
	/**
	 * 
	 * @param rol
	 * @param nombreFormulario
	 * @param formularioPadre
	 * @param permiso
	 */

	void InsertarUsuarioPermiso(Long rol,String nombreFormulario, Long formularioPadre, String permiso,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param idPermiso
	 * @param rol
	 * @param nombreFormulario
	 * @param formularioPadre
	 * @param permiso
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void ActualizarUsuarioPermiso(Long idPermiso, Long rol,String nombreFormulario, Long formularioPadre, String permiso,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	/**
	 * 
	 * @param Rol
	 * @param callback
	 */
	void ObtenerUsuarioPermiso(Long Rol,
			AsyncCallback<List<AuxUsuarioPermiso>> callback);

	/**
	 * 
	 * @param Rol
	 * @param formularioPadre
	 * @param callback
	 */
	void ObtenerUsuarioPermisoFormularios(Long Rol, Long formularioPadre,
			AsyncCallback<List<AuxUsuarioPermiso>> callback);
	

	/**
	 * 
	 * @param Rol
	 * @param callback
	 */
	void EliminarUsuarioPermiso(Long Rol,
			AsyncCallback<Long> callback);

	/**
	 * 
	 * @param Rol
	 * @param formularioPadre
	 * @param callback
	 */
	void EliminarUsuarioPermisoFormularios(Long Rol, Long formularioPadre,
			AsyncCallback<Long> callback);
	
}
