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
public class SegVacaciones implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_vacaciones;
	
	@Persistent
    private Date fecha1;	
	
	@Persistent
    private Date fecha2;

	@Persistent
    private String Descripcion;

    private SegEmpleado empleado;
	
	public SegVacaciones() {
		super();
	}
    
	public Long getId_vacaciones() {
		return id_vacaciones.getId();
	}

	public Date getFecha1() {
		return fecha1;
	}


	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}


	public Date getFecha2() {
		return fecha2;
	}


	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public SegEmpleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}

	
}
