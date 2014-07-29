package org.habitatguate.hgerp.seguridad.service;


import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegIdioma implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id_idioma;
	
	@Persistent
    private String nivel;
	
	@Persistent
    private String idioma;   
	
	@Persistent
    private SegEmpleado empleado;

	public SegIdioma() {
		super();
	}

	public Long getId_idioma() {
		return id_idioma;
	}

	public void setId_idioma(Long id_idioma) {
		this.id_idioma = id_idioma;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public SegEmpleado getEmpleados() {
		return empleado;
	}

	public void setEmpleados(SegEmpleado empleado) {
		this.empleado = empleado;
	}
	
}
