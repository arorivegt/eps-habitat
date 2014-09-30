package org.habitatguate.hgerp.seguridad.service.jdo;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegMaterialCostruccion {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idMaterialConstruccion;
	@Persistent
	private String nomMaterialCostruccion;
	@Persistent
	private Double precioUnit;
	@Persistent
	private String unidadMetrica;
	@Persistent
	private Date fechaIngreso;
	public Long getIdMaterialConstruccion() {
		return idMaterialConstruccion;
	}
	public void setIdMaterialConstruccion(Long idMaterialConstruccion) {
		this.idMaterialConstruccion = idMaterialConstruccion;
	}
	public String getNomMaterialCostruccion() {
		return nomMaterialCostruccion;
	}
	public void setNomMaterialCostruccion(String nomMaterialCostruccion) {
		this.nomMaterialCostruccion = nomMaterialCostruccion;
	}
	public Double getPrecioUnit() {
		return precioUnit;
	}
	public void setPrecioUnit(Double precioUnit) {
		this.precioUnit = precioUnit;
	}
	public String getUnidadMetrica() {
		return unidadMetrica;
	}
	public void setUnidadMetrica(String unidadMetrica) {
		this.unidadMetrica = unidadMetrica;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
}
