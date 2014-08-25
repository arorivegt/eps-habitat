package org.habitatguate.hgerp.seguridad.client.rrhh;

import com.google.gwt.user.client.rpc.IsSerializable;

public class valores_sesion implements IsSerializable{

	private boolean correcto;
	
	private Long id_empleado;
	
	public valores_sesion() {
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

}
