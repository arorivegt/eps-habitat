package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudGarantiaSolidario implements IsSerializable {

	public AuxSolicitudGarantiaSolidario() {
		super();
	}

	// Llave Primaria

	private Long idGarantiaSolidario;

	public Long getIdGarantiaSolidario() {
		return idGarantiaSolidario;
	}

	public void setIdGarantiaSolidario(Long idGarantiaSolidario) {
		this.idGarantiaSolidario = idGarantiaSolidario;
	}

	// Atributos

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String numDpi;  

	public String getNumDpi() {
		return numDpi;
	}

	public void setNumDpi(String numDpi) {
		this.numDpi = numDpi;
	}

	private String estadoCivil;

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	private int edad;   

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	private String nacionalidad;

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	private String actividadEconomica;

	public String getActividadEconomica() {
		return actividadEconomica;
	}

	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}

	private Boolean checkLeer;

	public Boolean getCheckLeer() {
		return checkLeer;
	}

	public void setCheckLeer(Boolean checkLeer) {
		this.checkLeer = checkLeer;
	}

	private Boolean checkEscribir;

	public Boolean getCheckEscribir() {
		return checkEscribir;
	}

	public void setCheckEscribir(Boolean checkEscribir) {
		this.checkEscribir = checkEscribir;
	}

	private Boolean checkFirmar;

	public Boolean getCheckFirmar() {
		return checkFirmar;
	}

	public void setCheckFirmar(Boolean checkFirmar) {
		this.checkFirmar = checkFirmar;
	}

	private String direccionActual;

	public String getDireccionActual() {
		return direccionActual;
	}

	public void setDireccionActual(String direccionActual) {
		this.direccionActual = direccionActual;
	}

	private String lugarTrabajo;

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	private int telefonoCasa;

	public int getTelefonoCasa() {
		return telefonoCasa;
	}

	public void setTelefonoCasa(int telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	private int telefonoTrabajo;

	public int getTelefonoTrabajo() {
		return telefonoTrabajo;
	}

	public void setTelefonoTrabajo(int telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	private String profesionOficio;

	public String getProfesionOficio() {
		return profesionOficio;
	}

	public void setProfesionOficio(String profesionOficio) {
		this.profesionOficio = profesionOficio;
	}

	private String direccionLugarTrabajo;

	public String getDireccionLugarTrabajo() {
		return direccionLugarTrabajo;
	}

	public void setDireccionLugarTrabajo(String direccionLugarTrabajo) {
		this.direccionLugarTrabajo = direccionLugarTrabajo;
	}

	private String correoElectronico;

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private int numeroCelular;

	public int getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	private int telefonoInternacional;


	public int getTelefonoInternacional() {
		return telefonoInternacional;
	}

	public void setTelefonoInternacional(int telefonoInternacional) {
		this.telefonoInternacional = telefonoInternacional;
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
