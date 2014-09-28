package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxVacaciones implements IsSerializable{
	
    private Long id_vacaciones;
	
	
    private Long fecha1;	
	
	
    private Long fecha2;

	
    private String Descripcion;
	
	public AuxVacaciones() {
		super();
	}
    
	public Long getId_vacaciones() {
		return id_vacaciones;
	}
	

	public void setId_vacaciones(Long id_vacaciones) {
		this.id_vacaciones = id_vacaciones;
	}

	public Long getFecha1() {
		return fecha1;
	}


	public void setFecha1(Long fecha1) {
		this.fecha1 = fecha1;
	}


	public Long getFecha2() {
		return fecha2;
	}


	public void setFecha2(Long fecha2) {
		this.fecha2 = fecha2;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	
}
