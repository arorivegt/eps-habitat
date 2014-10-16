package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSalario implements IsSerializable{

	private Long id_Salario;
	
	private Long Fecha;
	
	private float salario;

	private String tipoSalario;

	public AuxSalario() {
		super();
	}


	public Long getFecha() {
		return Fecha;
	}


	public void setFecha(Long fecha) {
		Fecha = fecha;
	}


	public Long getId_Salario() {
		return id_Salario;
	}


	public void setId_Salario(Long id_Salario) {
		this.id_Salario = id_Salario;
	}


	public float getSalario() {
		return salario;
	}


	public void setSalario(float salario) {
		this.salario = salario;
	}


	public String getTipoSalario() {
		return tipoSalario;
	}


	public void setTipoSalario(String tipoSalario) {
		this.tipoSalario = tipoSalario;
	}

	
	
}
