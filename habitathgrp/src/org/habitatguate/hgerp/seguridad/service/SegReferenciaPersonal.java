package org.habitatguate.hgerp.seguridad.service;


import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class seg_referencia_personal implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id_referencia_laboral;
	
	@Persistent
    private String nombre_referencia;
	
	@Persistent
    private int telefono;
	
	@Persistent
    private String puesto_candidato;
	
	@Persistent
    private String relacion;

	@Persistent
    private String actitudes_cualidades;
	
	@Persistent
    private seg_empleado empleado;
	
	public seg_referencia_personal() {
		super();
	}

	public Long getId_referencia_laboral() {
		return id_referencia_laboral;
	}

	public void setId_referencia_laboral(Long id_referencia_laboral) {
		this.id_referencia_laboral = id_referencia_laboral;
	}

	public String getNombre_referencia() {
		return nombre_referencia;
	}

	public void setNombre_referencia(String nombre_referencia) {
		this.nombre_referencia = nombre_referencia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPuesto_candidato() {
		return puesto_candidato;
	}

	public void setPuesto_candidato(String puesto_candidato) {
		this.puesto_candidato = puesto_candidato;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getActitudes_cualidades() {
		return actitudes_cualidades;
	}

	public void setActitudes_cualidades(String actitudes_cualidades) {
		this.actitudes_cualidades = actitudes_cualidades;
	}

	public seg_empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleados(seg_empleado empleado) {
		this.empleado = empleado;
	}

    
}
