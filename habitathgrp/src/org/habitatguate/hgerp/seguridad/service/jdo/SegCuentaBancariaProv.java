package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegCuentaBancariaProv implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idCuentaBancariaProv;
	@Persistent
	private String tipoPago;
	@Persistent
	private String tipoCuentaBancaria;
	@Persistent
	private String numeroCuentaBancaria;
	@Persistent
	private String bancoCuentaBancaria;
	@Persistent
	private String nombrePropietario;

	
	
	public Long getIdCuentaBancariaProv() {
		return idCuentaBancariaProv;
	}
	public void setIdCuentaBancariaProv(Long idCuentaBancariaProv) {
		this.idCuentaBancariaProv = idCuentaBancariaProv;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public String getTipoCuentaBancaria() {
		return tipoCuentaBancaria;
	}
	public void setTipoCuentaBancaria(String tipoCuentaBancaria) {
		this.tipoCuentaBancaria = tipoCuentaBancaria;
	}
	public String getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}
	public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}
	public String getBancoCuentaBancaria() {
		return bancoCuentaBancaria;
	}
	public void setBancoCuentaBancaria(String bancoCuentaBancaria) {
		this.bancoCuentaBancaria = bancoCuentaBancaria;
	}
	public String getNombrePropietario() {
		return nombrePropietario;
	}
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}
	
	

}
