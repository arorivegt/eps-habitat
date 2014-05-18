package org.habitatguate.hgerp.seguridad.client.api;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LoginServiceAsync {
	void login(String user,String i2, AsyncCallback<String[]> callback)
			throws IllegalArgumentException;
}
