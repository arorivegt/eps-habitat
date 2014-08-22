package org.habitatguate.hgerp.seguridad.client.api;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UploadUrlServiceAsync {
	void getUploadUrl(AsyncCallback<String> callback);
}
