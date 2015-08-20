package org.habitatguate.hgerp.seguridad.service.jdo;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegMaterialCostruccion {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idMaterialConstruccion;
	@Persistent
	private String nomMaterialCostruccion;
	@Persistent
	private Double precioUnit;
	@Persistent
	private String unidadMetrica;
	@Persistent
	private Date fechaIngreso;
	@Persistent
	private String idProducto;
	@Persistent
	private String idCatalogoMaterial;
	
	private SegProveedor proveedor;
	
	public Key getIdMaterialConstruccion() {
		return idMaterialConstruccion;
	}
	public void setIdMaterialConstruccion(Key idMaterialConstruccion) {
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
	public SegProveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(SegProveedor proveedor) {
		this.proveedor = proveedor;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getIdCatalogoMaterial() {
		return idCatalogoMaterial;
	}
	public void setIdCatalogoMaterial(String idCatalogoMaterial) {
		this.idCatalogoMaterial = idCatalogoMaterial;
	}
	
	
	
}
