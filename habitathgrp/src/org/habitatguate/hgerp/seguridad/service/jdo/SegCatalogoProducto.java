package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegCatalogoProducto implements Serializable{
	@PrimaryKey
	@Persistent
	private String idProducto;
	@Persistent
	private String descripcionProducto;
	@Persistent
	private int statusProducto;
	
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public int getStatusProducto() {
		return statusProducto;
	}
	public void setStatusProducto(int statusProducto) {
		this.statusProducto = statusProducto;
	}

	
	
	

}
