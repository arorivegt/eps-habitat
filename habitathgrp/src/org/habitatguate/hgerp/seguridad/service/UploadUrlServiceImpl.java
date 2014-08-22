package org.habitatguate.hgerp.seguridad.service;

import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;

import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UploadUrlServiceImpl extends RemoteServiceServlet implements
		UploadUrlService {

	@Override
	public String getUploadUrl() throws IllegalArgumentException {
		
		return BlobstoreServiceFactory.getBlobstoreService().createUploadUrl("/upload");
	}

}
