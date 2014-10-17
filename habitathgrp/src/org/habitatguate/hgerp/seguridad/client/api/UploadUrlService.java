/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.api;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * 
 * @author arodriguez
 *
 */
@RemoteServiceRelativePath("uploadUrl")
public interface UploadUrlService extends RemoteService {
	/**
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 */
	String getUploadUrl() throws IllegalArgumentException;
}
