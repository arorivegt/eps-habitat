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
public class SegSolicitudGarantiaSolidario implements Serializable {

	public SegSolicitudGarantiaSolidario() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idGarantiaSolidario;
	
	public Long getIdGarantiaSolidario() {
		return idGarantiaSolidario.getId();
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
    private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Persistent
    private int edad;

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Persistent
    private String escolaridad;
	
	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	@Persistent
    private String ocupacion;

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
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
