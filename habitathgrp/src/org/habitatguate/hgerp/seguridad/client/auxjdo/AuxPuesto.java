package org.habitatguate.hgerp.seguridad.client.auxjdo;

import javax.jdo.annotations.Persistent;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxPuesto implements IsSerializable{
	
    private Long id_puesto;
	
	
    private Long fecha_puesto;
	
	
    private String nombre_puesto;
	
	
    private String funciones;
	
    
    private String motivoPuesto;

    
    private String jornada;
	
    
    private String horasTrabajo;
	
    
    private boolean activo;
    
    private boolean Lunes;
	
	
    private boolean Martes;
	
	
    private boolean Miercoles;
	
	
    private boolean Jueves;
	
	
    private boolean Viernes;
	
	
    private boolean Sabado;
	
	
    private boolean Domingo;
	

	public AuxPuesto() {
		super();
	}

	public Long getId_puesto() {
		return id_puesto;
	}

	public void setId_puesto(Long id_puesto) {
		this.id_puesto = id_puesto;
	}

	public boolean getLunes() {
		return Lunes;
	}

	public void setLunes(boolean lunes) {
		Lunes = lunes;
	}

	public boolean getMartes() {
		return Martes;
	}

	public void setMartes(boolean martes) {
		Martes = martes;
	}

	public boolean getMiercoles() {
		return Miercoles;
	}

	public void setMiercoles(boolean miercoles) {
		Miercoles = miercoles;
	}

	public boolean getJueves() {
		return Jueves;
	}

	public void setJueves(boolean jueves) {
		Jueves = jueves;
	}

	public boolean getViernes() {
		return Viernes;
	}

	public void setViernes(boolean viernes) {
		Viernes = viernes;
	}

	public boolean getSabado() {
		return Sabado;
	}

	public void setSabado(boolean sabado) {
		Sabado = sabado;
	}

	public boolean getDomingo() {
		return Domingo;
	}

	public void setDomingo(boolean domingo) {
		Domingo = domingo;
	}

	public Long getFecha_puesto() {
		return fecha_puesto;
	}

	public void setFecha_puesto(Long fecha_puesto) {
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getMotivoPuesto() {
		return motivoPuesto;
	}

	public void setMotivoPuesto(String motivoPuesto) {
		this.motivoPuesto = motivoPuesto;
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

}
