/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.api;

import com.google.gwt.user.client.rpc.AsyncCallback;
/**
 * 
 * @author arodriguez
 *
 */
public interface UploadUrlServiceAsync {
	/**
	 * 
	 * @param callback
	 */
	void getUploadUrl(AsyncCallback<String> callback);
}
