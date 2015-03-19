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
public class SegSolicitudGarantiaFiduciaria implements Serializable {

	public SegSolicitudGarantiaFiduciaria() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idGarantiaFiduciaria;
	
	public Long getIdGarantiaFiduciaria() {
		return idGarantiaFiduciaria.getId();
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
    private String estadoCivil;
	
	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
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
    private String nacionalidad;
	
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	@Persistent
    private String actividadEconomica;

	public String getActividadEconomica() {
		return actividadEconomica;
	}

	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}

	@Persistent
    private Boolean checkLeer;
	
	public Boolean getCheckLeer() {
		return checkLeer;
	}

	public void setCheckLeer(Boolean checkLeer) {
		this.checkLeer = checkLeer;
	}

	@Persistent
    private Boolean checkEscribir;

	public Boolean getCheckEscribir() {
		return checkEscribir;
	}

	public void setCheckEscribir(Boolean checkEscribir) {
		this.checkEscribir = checkEscribir;
	}

	@Persistent
    private Boolean checkFirmar;
	
	public Boolean getCheckFirmar() {
		return checkFirmar;
	}

	public void setCheckFirmar(Boolean checkFirmar) {
		this.checkFirmar = checkFirmar;
	}
	
	@Persistent
    private String direccionActual;
	
	public String getDireccionActual() {
		return direccionActual;
	}

	public void setDireccionActual(String direccionActual) {
		this.direccionActual = direccionActual;
	}

	@Persistent
    private String lugarTrabajo;
	
	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	@Persistent
    private int telefonoCasa;

	public int getTelefonoCasa() {
		return telefonoCasa;
	}

	public void setTelefonoCasa(int telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	@Persistent
    private int telefonoTrabajo;

	public int getTelefonoTrabajo() {
		return telefonoTrabajo;
	}

	public void setTelefonoTrabajo(int telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
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
