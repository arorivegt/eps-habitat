package org.habitatguate.hgerp.seguridad.service;


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
public class SegHistorial implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_historial;
	
	@Persistent
    private Date fecha;

	@Persistent
    private String Descripcion;

	@Persistent
    private String tipo_historial;

    private SegEmpleado empleado;

	public SegHistorial() {
		super();
	}

	public Long getId_historial() {
		return id_historial.getId();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getTipo_historial() {
		return tipo_historial;
	}

	public void setTipo_historial(String tipo_historial) {
		this.tipo_historial = tipo_historial;
	}

	public SegEmpleado getEmpleados() {
		return empleado;
	}

	public void setEmpleados(SegEmpleado empleados) {
		this.empleado = empleados;
	}
	
}
