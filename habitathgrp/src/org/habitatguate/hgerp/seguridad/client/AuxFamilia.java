package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxFamilia implements IsSerializable{
	
	private Long id_familia;
	
	
	private String primer_nombre;
	
	
	private String segundo_nombre;
	
	
	private String primer_apellido;
	
	
	private String segundo_apellido;
    
	
	private int edad;
	
	
	private String ocupacion;
	
	
	private String parentesco;
	


	public AuxFamilia() {
		super();
	}

	public Long getId_familia() {
		return id_familia;
	}

	public void setId_familia(Long id_familia) {
		this.id_familia = id_familia;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	
}
