package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegSolicitudCargaFamiliar implements Serializable {

	public SegSolicitudCargaFamiliar() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idCargaFamiliar;
	
	public Long getIdCargaFamiliar() {
		return idCargaFamiliar.getId();
	}
	
	// Atributos
	
	@Persistent    
    private Date fecrec;
	
	public Date getFecrec() {
		return fecrec;
	}

	public void setFecrec(Date fecrec) {
		this.fecrec = fecrec;
	}
	
	@Persistent
    private String nombreFamiliar;
	
	public String getNombreFamiliar() {
		return nombreFamiliar;
	}

	public void setNombreFamiliar(String nombreFamiliar) {
		this.nombreFamiliar = nombreFamiliar;
	}

	@Persistent
    private int edadFamiliar;
	
	public int getEdadFamiliar() {
		return edadFamiliar;
	}

	public void setEdadFamiliar(int edadFamiliar) {
		this.edadFamiliar = edadFamiliar;
	}

	@Persistent
    private String escolaridadFamiliar;
	
	public String getEscolaridadFamiliar() {
		return escolaridadFamiliar;
	}

	public void setEscolaridadFamiliar(String escolaridadFamiliar) {
		this.escolaridadFamiliar = escolaridadFamiliar;
	}

	@Persistent
    private String ocupacionFamiliar;

	public String getOcupacionFamiliar() {
		return ocupacionFamiliar;
	}

	public void setOcupacionFamiliar(String ocupacionFamiliar) {
		this.ocupacionFamiliar = ocupacionFamiliar;
	}

	// Llave Foranea

	@Persistent
    private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
	
	// Relacion

	@Persistent
    private SegSolicitudGeneral solicitud;

	public SegSolicitudGeneral getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SegSolicitudGeneral solicitud) {
		this.solicitud = solicitud;
	}
    
}
