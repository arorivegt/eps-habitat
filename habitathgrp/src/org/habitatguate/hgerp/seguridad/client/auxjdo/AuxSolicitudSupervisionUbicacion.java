package org.habitatguate.hgerp.seguridad.client.auxjdo;


import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudSupervisionUbicacion implements IsSerializable {

	public AuxSolicitudSupervisionUbicacion() {
		super();
	}
	
	// Llave Primaria
	
    private Long idSupervisionUbicacion;
	
    public Long getIdSupervisionUbicacion() {
		return idSupervisionUbicacion;
	}

	public void setIdSupervisionUbicacion(Long idSupervisionUbicacion) {
		this.idSupervisionUbicacion = idSupervisionUbicacion;
	}
	
	// Atributos

	private String latitud;

    public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	private String longitud;
	
	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	// Llave Foranea
	
	private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
    
}
