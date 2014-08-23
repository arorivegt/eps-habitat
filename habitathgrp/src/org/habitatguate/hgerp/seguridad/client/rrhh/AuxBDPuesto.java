package org.habitatguate.hgerp.seguridad.client.rrhh;


import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxBDPuesto implements IsSerializable{
	
    private Long id_puesto;
	
	
    private Long fecha_puesto;
	
	
    private String nombre_puesto;
	
	
    private String funciones;
	
	

	public AuxBDPuesto() {
		super();
	}

	public Long getId_puesto() {
		return id_puesto;
	}

	public void setId_puesto(Long id_puesto) {
		this.id_puesto = id_puesto;
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

}
