package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSalario implements IsSerializable{

	private Long id_Salario;
	
	private String anio;
	
	private float salario;

	private String tipoSalario;
	
	private String Descripcion;

	public AuxSalario() {
		super();
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

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	
}
