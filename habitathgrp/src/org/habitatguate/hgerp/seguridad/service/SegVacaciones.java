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
public class seg_vacaciones implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id_vacaciones;
	
	@Persistent
    private Date fecha1;	
	
	@Persistent
    private Date fecha2;

	@Persistent
    private String Descripcion;
	
	@Persistent
    private seg_empleado empleado;

	public seg_vacaciones() {
		super();
	}
    
	public Long getId_vacaciones() {
		return id_vacaciones;
	}


	public void setId_vacaciones(Long id_vacaciones) {
		this.id_vacaciones = id_vacaciones;
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


	public seg_empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(seg_empleado empleado) {
		this.empleado = empleado;
	}

	
}
