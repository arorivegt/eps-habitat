package org.habitatguate.hgerp.seguridad.service;


import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegHistorial implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id_historial;
	
	@Persistent
    private Date fecha;

	@Persistent
    private String Descripcion;

	@Persistent
    private int tipo_historial;
	
	@Persistent
    private SegEmpleado empleados;

	public SegHistorial() {
		super();
	}

	public Long getId_historial() {
		return id_historial;
	}

	public void setId_historial(Long id_historial) {
		this.id_historial = id_historial;
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

	public int getTipo_historial() {
		return tipo_historial;
	}

	public void setTipo_historial(int tipo_historial) {
		this.tipo_historial = tipo_historial;
	}

	public SegEmpleado getEmpleados() {
		return empleados;
	}

	public void setEmpleados(SegEmpleado empleados) {
		this.empleados = empleados;
	}
	
}
