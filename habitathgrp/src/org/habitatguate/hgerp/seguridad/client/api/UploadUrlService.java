package org.habitatguate.hgerp.seguridad.client.api;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("uploadUrl")
public interface UploadUrlService extends RemoteService {
	String getUploadUrl() throws IllegalArgumentException;
}
