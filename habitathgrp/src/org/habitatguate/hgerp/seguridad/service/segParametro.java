package org.habitatguate.hgerp.seguridad.service;

import java.io.Serializable;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class segParametro implements Serializable{

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idParametro;
	@Persistent
	private String nomParametro;
	@Persistent
	private int codContable;
	@Persistent
	private int codUno;
	@Persistent
	private int codDos;
	
	
	public segParametro(String nomParametro, int codContable, int codUno, int codDos){
		super();
		this.nomParametro = nomParametro;
		this.codContable = codContable;
		this.codUno = codUno;
		this.codDos = codDos;
		
		
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
