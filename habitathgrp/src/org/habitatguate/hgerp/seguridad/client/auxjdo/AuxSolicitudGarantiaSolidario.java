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

	private int edad;

    public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	private String escolaridad;
	
    public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	private String ocupacion;
	
    public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
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
