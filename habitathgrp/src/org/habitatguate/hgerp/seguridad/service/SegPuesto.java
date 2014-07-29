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
public class SegPuesto implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id_puesto;
	
	@Persistent
    private Date fecha_puesto;
	
	@Persistent
    private String nombre_puesto;
	
	@Persistent
    private String funciones;
	
	@Persistent
    private float salario;
	
	@Persistent
    private boolean activo;
	
	@Persistent
    private SegEmpleado empleado;

	public SegPuesto() {
		super();
	}

	public Long getId_puesto() {
		return id_puesto;
	}

	public void setId_puesto(Long id_puesto) {
		this.id_puesto = id_puesto;
	}

	public Date getFecha_puesto() {
		return fecha_puesto;
	}

	public void setFecha_puesto(Date fecha_puesto) {
		this.fecha_puesto = fecha_puesto;
	}

	public String getNombre_puesto() {
		return nombre_puesto;
	}

	public void setNombre_puesto(String nombre_puesto) {
		this.nombre_puesto = nombre_puesto;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}
	
}
