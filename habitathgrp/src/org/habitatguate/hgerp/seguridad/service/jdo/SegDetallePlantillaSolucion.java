package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

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
public class SegDetallePlantillaSolucion implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idDetallePlantillaSolucion;
	@Persistent
	private String nomMaterialCostruccion;
	@Persistent
	private Double cantidad;
	@Persistent
	private Double precioUnit;
	@Persistent
	private String unidadMetrica;
	@Persistent
	private Double subTotal;
	@Persistent
	private Double costoAcumulado;
	

	private SegPlantillaSolucion plantillaSolucion;

	public Key getIdDetallePlantillaSolucion() {
		return idDetallePlantillaSolucion;
	}

	public void setIdDetallePlantillaSolucion(Key idDetallePlantillaSolucion) {
		this.idDetallePlantillaSolucion = idDetallePlantillaSolucion;
	}

	public String getNomMaterialCostruccion() {
		return nomMaterialCostruccion;
	}

	public void setNomMaterialCostruccion(String nomMaterialCostruccion) {
		this.nomMaterialCostruccion = nomMaterialCostruccion;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
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

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getCostoAcumulado() {
		return costoAcumulado;
	}

	public void setCostoAcumulado(Double costoAcumulado) {
		this.costoAcumulado = costoAcumulado;
	}

	public SegPlantillaSolucion getPlantillaSolucion() {
		return plantillaSolucion;
	}

	public void setPlantillaSolucion(SegPlantillaSolucion plantillaSolucion) {
		this.plantillaSolucion = plantillaSolucion;
	}
	
	
}
