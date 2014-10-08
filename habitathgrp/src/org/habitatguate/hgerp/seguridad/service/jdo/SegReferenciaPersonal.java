package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegReferenciaPersonal implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_referencia_personal;

	@Persistent
    private String nombre_referencia;
	
	@Persistent
    private String telefono;
	
	@Persistent
    private String puesto_candidato;
	
	@Persistent
    private String relacion;

	@Persistent
    private String actitudes_cualidades;

	@Persistent
    private SegEmpleado empleado;

	public SegReferenciaPersonal() {
		super();
	}

	public Long getId_referencia_personal() {
		return id_referencia_personal.getId();
	}

	public String getNombre_referencia() {
		return nombre_referencia;
	}

	public void setNombre_referencia(String nombre_referencia) {
		this.nombre_referencia = nombre_referencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
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

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleados(SegEmpleado empleado) {
		this.empleado = empleado;
	}

    
}
