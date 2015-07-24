package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegTipoSolucion implements Serializable{
	@PrimaryKey
	@Persistent
	private String idTipoSolucion;
	@Persistent
	private String descripcionTipoSolucion;
	@Persistent
	private int statusProducto;
	public String getIdTipoSolucion() {
		return idTipoSolucion;
	}
	public void setIdTipoSolucion(String idTipoSolucion) {
		this.idTipoSolucion = idTipoSolucion;
	}
	public String getDescripcionTipoSolucion() {
		return descripcionTipoSolucion;
	}
	public void setDescripcionTipoSolucion(String descripcionTipoSolucion) {
		this.descripcionTipoSolucion = descripcionTipoSolucion;
	}
	public int getStatusProducto() {
		return statusProducto;
	}
	public void setStatusProducto(int statusProducto) {
		this.statusProducto = statusProducto;
	}
	
	
}
