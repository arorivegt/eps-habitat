package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxHistorial implements IsSerializable {
	
    private Long id_historial;
	
	
    private Long fecha;

	
    private String Descripcion;

	
    private String tipo_historial;
	
	

	public AuxHistorial() {
		super();
	}

	public void setId_historial(Long id_historial) {
		this.id_historial = id_historial;
	}

	public Long getId_historial() {
		return id_historial;
	}

	public Long getFecha() {
		return fecha;
	}

	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getTipo_historial() {
		return tipo_historial;
	}

	public void setTipo_historial(String tipo_historial) {
		this.tipo_historial = tipo_historial;
	}

	
}
