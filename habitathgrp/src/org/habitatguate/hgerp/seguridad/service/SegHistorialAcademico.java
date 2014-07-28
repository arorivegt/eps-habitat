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
public class seg_historial_academico implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id_historial_academico;
	
	@Persistent
    private Date fecha1;
	
	@Persistent
    private Date fecha2;

	@Persistent
    private String nivel_academico;
	
	@Persistent
    private String establecimiento;
	
	@Persistent
    private String titulo;
	
	@Persistent
    private seg_empleado empleado;

	public seg_historial_academico() {
		super();
	}

	public Long getId_historial_academico() {
		return id_historial_academico;
	}

	public void setId_historial_academico(Long id_historial_academico) {
		this.id_historial_academico = id_historial_academico;
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

	public String getNivel_academico() {
		return nivel_academico;
	}

	public void setNivel_academico(String nivel_academico) {
		this.nivel_academico = nivel_academico;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public seg_empleado getEmpleados() {
		return empleado;
	}

	public void setEmpleados(seg_empleado empleado) {
		this.empleado = empleado;
	}

	

}
