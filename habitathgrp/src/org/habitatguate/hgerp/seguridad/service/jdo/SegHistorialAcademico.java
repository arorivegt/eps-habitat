package org.habitatguate.hgerp.seguridad.service.jdo;


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
public class SegHistorialAcademico implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_historial_academico;
	
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
    private String URLFile;

	@Persistent    
    private String KeyFile;

	@Persistent
    private SegEmpleado empleado;

	public SegHistorialAcademico() {
		super();
	}

	public Long getId_historial_academico() {
		return id_historial_academico.getId();
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

	public String getURLFile() {
		return URLFile;
	}

	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}

	public String getKeyFile() {
		return KeyFile;
	}

	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
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

	public SegEmpleado getEmpleados() {
		return empleado;
	}

	public void setEmpleados(SegEmpleado empleado) {
		this.empleado = empleado;
	}

	

}
