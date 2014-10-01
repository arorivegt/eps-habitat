package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.Date;

public class AuxDetallePlantillaSolucion {
	
	private Long idDetallePlantillaSolucion;
	
	private String nomMaterialCostruccion;
	
	private int cantidad;

	private Double precioUnit;

	private String unidadMetrica;

	private Double subTotal;
	
	private Double costoAcumulado;

	public Long getIdDetallePlantillaSolucion() {
		return idDetallePlantillaSolucion;
	}

	public void setIdDetallePlantillaSolucion(Long idDetallePlantillaSolucion) {
		this.idDetallePlantillaSolucion = idDetallePlantillaSolucion;
	}

	public String getNomMaterialCostruccion() {
		return nomMaterialCostruccion;
	}

	public void setNomMaterialCostruccion(String nomMaterialCostruccion) {
		this.nomMaterialCostruccion = nomMaterialCostruccion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
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
	
	
	
	

}
