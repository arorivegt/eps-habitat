package org.habitatguate.hgerp.seguridad.client;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxParametro implements IsSerializable {


	private Long idParametro;

	private String nomParametro;

	private int codContable;

	private int codUno;

	private int codDos;
	
	
	public AuxParametro(){
		super();
	
	}


	public Long getIdParametro() {
		return idParametro;
	}


	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}


	public String getNomParametro() {
		return nomParametro;
	}


	public void setNomParametro(String nomParametro) {
		this.nomParametro = nomParametro;
	}


	public int getCodContable() {
		return codContable;
	}


	public void setCodContable(int codContable) {
		this.codContable = codContable;
	}


	public int getCodUno() {
		return codUno;
	}


	public void setCodUno(int codUno) {
		this.codUno = codUno;
	}


	public int getCodDos() {
		return codDos;
	}


	public void setCodDos(int codDos) {
		this.codDos = codDos;
	}
	
}
