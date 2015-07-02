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
    private String numDpi;  
	
	public String getNumDpi() {
		return numDpi;
	}

	public void setNumDpi(String numDpi) {
		this.numDpi = numDpi;
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
	
	@Persistent
    private String profesionOficio;

	public String getProfesionOficio() {
		return profesionOficio;
	}

	public void setProfesionOficio(String profesionOficio) {
		this.profesionOficio = profesionOficio;
	}

	@Persistent
    private String direccionLugarTrabajo;
	
	public String getDireccionLugarTrabajo() {
		return direccionLugarTrabajo;
	}

	public void setDireccionLugarTrabajo(String direccionLugarTrabajo) {
		this.direccionLugarTrabajo = direccionLugarTrabajo;
	}

	@Persistent
    private String correoElectronico;
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Persistent
    private int numeroCelular;
	
	public int getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	@Persistent
    private int telefonoInternacional;

	
	public int getTelefonoInternacional() {
		return telefonoInternacional;
	}

	public void setTelefonoInternacional(int telefonoInternacional) {
		this.telefonoInternacional = telefonoInternacional;
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
