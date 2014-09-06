package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;


@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegSolucion implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idSolucion;
	@Persistent
	private String nomSolucion;
	@Persistent
	private String disenio;
	@Persistent
	private double costoMaterial;
	@Persistent
	private double costoDirecto;
	@Persistent
	private double costoAdministrativo;
	@Persistent
	private double costoTotal;
	@Persistent
	private double valorContrato;
	@Persistent
	private int notaDebito;
	@Persistent
	private Date fechaInicio;

	@ManyToOne(fetch = FetchType.EAGER)
	private SegAfiliado afiliado;
	@ManyToOne
	private SegBeneficiario beneficiario;
	
	public Key getIdSolucion() {
		return idSolucion;
	}




	public void setIdSolucion(Key idSolucion) {
		this.idSolucion = idSolucion;
	}




	public SegSolucion(){
		super();
	}

	


	public String getNomSolucion() {
		return nomSolucion;
	}

	public void setNomSolucion(String nomSolucion) {
		this.nomSolucion = nomSolucion;
	}

	public String getDisenio() {
		return disenio;
	}

	public void setDisenio(String disenio) {
		this.disenio = disenio;
	}

	public double getCostoMaterial() {
		return costoMaterial;
	}

	public void setCostoMaterial(double costoMaterial) {
		this.costoMaterial = costoMaterial;
	}

	public double getCostoDirecto() {
		return costoDirecto;
	}

	public void setCostoDirecto(double costoDirecto) {
		this.costoDirecto = costoDirecto;
	}

	public double getCostoAdministrativo() {
		return costoAdministrativo;
	}

	public void setCostoAdministrativo(double costoAdministrativo) {
		this.costoAdministrativo = costoAdministrativo;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public int getNotaDebito() {
		return notaDebito;
	}

	public void setNotaDebito(int notaDebito) {
		this.notaDebito = notaDebito;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public SegBeneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(SegBeneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public SegAfiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(SegAfiliado afiliado) {
		this.afiliado = afiliado;
	}
	
	
	
	
}
