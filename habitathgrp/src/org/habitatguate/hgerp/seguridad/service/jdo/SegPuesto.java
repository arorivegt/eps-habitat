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
public class SegPuesto implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_puesto;
	
	@Persistent
    private Date fecha_puesto;
	
	@Persistent
    private String nombre_puesto;
	
	@Persistent
    private String funciones;
	
	@Persistent
    private boolean activo;

	@Persistent
    private String motivoPuesto;
	
	@Persistent
    private String jornada;
	
	@Persistent
    private String horasTrabajo;
	
	@Persistent
    private String Lunes;
	
	@Persistent
    private String Martes;
	
	@Persistent
    private String Miercoles;
	
	@Persistent
    private String Jueves;
	
	@Persistent
    private String Viernes;
	
	@Persistent
    private String Sabado;
	
	@Persistent
    private String Domingo;
	
	@Persistent
    private SegEmpleado empleado;

	public SegPuesto() {
		super();
	}

	public Long getId_puesto() {
		return id_puesto.getId();
	}

	public Date getFecha_puesto() {
		return fecha_puesto;
	}

	public String getLunes() {
		return Lunes;
	}

	public void setLunes(String lunes) {
		Lunes = lunes;
	}

	public String getMartes() {
		return Martes;
	}

	public void setMartes(String martes) {
		Martes = martes;
	}

	public String getMiercoles() {
		return Miercoles;
	}

	public void setMiercoles(String miercoles) {
		Miercoles = miercoles;
	}

	public String getJueves() {
		return Jueves;
	}

	public void setJueves(String jueves) {
		Jueves = jueves;
	}

	public String getViernes() {
		return Viernes;
	}

	public void setViernes(String viernes) {
		Viernes = viernes;
	}

	public String getSabado() {
		return Sabado;
	}

	public void setSabado(String sabado) {
		Sabado = sabado;
	}

	public String getDomingo() {
		return Domingo;
	}

	public void setDomingo(String domingo) {
		Domingo = domingo;
	}

	public String getMotivoPuesto() {
		return motivoPuesto;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getHorasTrabajo() {
		return horasTrabajo;
	}

	public void setHorasTrabajo(String horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public void setMotivoPuesto(String motivoPuesto) {
		this.motivoPuesto = motivoPuesto;
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

	public boolean getActivo() {
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
