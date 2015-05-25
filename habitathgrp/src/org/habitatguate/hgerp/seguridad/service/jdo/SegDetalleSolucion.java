package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;
@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegDetalleSolucion implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idDetalleSolucion;
	@Persistent
	private Double cantidad;
	@Persistent
	private String unidadMetrica;
	@Persistent
	private Double subTotal;
	@Persistent
	private Double costoAcumulado;
	@Persistent
	private Double cantidadEjecutada;
	@Persistent
	@Unowned
    private SegMaterialCostruccion materialCostruccion;
	@Persistent
	@Unowned
	private List<SegVale> vale;
	
	private SegSolucion solucion;

	public Key getIdDetalleSolucion() {
		return idDetalleSolucion;
	}

	public void setIdDetalleSolucion(Key idDetalleSolucion) {
		this.idDetalleSolucion = idDetalleSolucion;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
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

	public SegMaterialCostruccion getMaterialCostruccion() {
		return materialCostruccion;
	}

	public void setMaterialCostruccion(SegMaterialCostruccion materialCostruccion) {
		this.materialCostruccion = materialCostruccion;
	}

	public SegSolucion getSolucion() {
		return solucion;
	}

	public void setSolucion(SegSolucion solucion) {
		this.solucion = solucion;
	}

	public List<SegVale> getVale() {
		return vale;
	}

	public void setVale(List<SegVale> vale) {
		this.vale = vale;
	}

	public Double getCantidadEjecutada() {
		return cantidadEjecutada;
	}

	public void setCantidadEjecutada(Double cantidadEjecutada) {
		this.cantidadEjecutada = cantidadEjecutada;
	}


	
}
