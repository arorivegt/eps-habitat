package org.habitatguate.hgerp.seguridad.client.api;

import com.google.gwt.user.client.rpc.AsyncCallback;
public interface SqlServiceAsync {
	void Insertar(String user,String i2, AsyncCallback<String[]> callback)
			throws IllegalArgumentException;

}
