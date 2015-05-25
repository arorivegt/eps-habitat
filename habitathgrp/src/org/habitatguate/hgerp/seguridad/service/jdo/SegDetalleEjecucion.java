package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegDetalleEjecucion implements Serializable{
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
	private Double precioEjecucion;
	@Persistent
	@Unowned
    private SegMaterialCostruccion materialCostruccion;
	@Persistent
	@Unowned
	private SegVale vale;
	@Persistent
	@Unowned
	private SegSolucion solucion2;

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

	public Double getPrecioEjecucion() {
		return precioEjecucion;
	}

	public void setPrecioEjecucion(Double costoAcumulado) {
		this.precioEjecucion = costoAcumulado;
	}

	public SegMaterialCostruccion getMaterialCostruccion() {
		return materialCostruccion;
	}

	public void setMaterialCostruccion(SegMaterialCostruccion materialCostruccion) {
		this.materialCostruccion = materialCostruccion;
	}

	public SegSolucion getSolucion() {
		return solucion2;
	}

	public void setSolucion(SegSolucion solucion) {
		this.solucion2 = solucion;
	}

	public SegVale getVale() {
		return vale;
	}

	public void setVale(SegVale vale) {
		this.vale = vale;
	}
}
