package org.habitatguate.hgerp.seguridad.client.rrhh;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ValoresSesion implements IsSerializable{

	private boolean correcto;
	
	private Long id_empleado;
	
	private Long id_rol;
	
	public ValoresSesion() {
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

	/**
	 * @return the id_rol
	 */
	public Long getId_rol() {
		return id_rol;
	}

	/**
	 * @param id_rol the id_rol to set
	 */
	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

}
