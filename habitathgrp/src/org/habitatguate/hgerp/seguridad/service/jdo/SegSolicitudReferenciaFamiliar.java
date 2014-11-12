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
public class SegSolicitudReferenciaFamiliar implements Serializable {

	public SegSolicitudReferenciaFamiliar() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idReferenciaFamiliar;
	
	public Long getIdReferenciaFamiliar() {
		return idReferenciaFamiliar.getId();
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
    private int telefonoFamiliar;

	public int getTelefonoFamiliar() {
		return telefonoFamiliar;
	}

	public void setTelefonoFamiliar(int telefonoFamiliar) {
		this.telefonoFamiliar = telefonoFamiliar;
	}

	@Persistent
    private String parentescoFamiliar;

	public String getParentescoFamiliar() {
		return parentescoFamiliar;
	}

	public void setParentescoFamiliar(String parentescoFamiliar) {
		this.parentescoFamiliar = parentescoFamiliar;
	}

	@Persistent
    private String direccionFamiliar;

	public String getDireccionFamiliar() {
		return direccionFamiliar;
	}

	public void setDireccionFamiliar(String direccionFamiliar) {
		this.direccionFamiliar = direccionFamiliar;
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
