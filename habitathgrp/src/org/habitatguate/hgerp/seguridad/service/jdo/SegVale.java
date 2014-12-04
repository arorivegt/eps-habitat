package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegVale implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idVale;
	@Persistent
	private Double totalVale;
	@Persistent
	private Date fechaVale;
	@Persistent
	private boolean estado;
	
	public Long getIdVale() {
		return idVale;
	}
	public void setIdVale(Long idVale) {
		this.idVale = idVale;
	}
	public Double getTotalVale() {
		return totalVale;
	}
	public void setTotalVale(Double totalVale) {
		this.totalVale = totalVale;
	}
	public Date getFechaVale() {
		return fechaVale;
	}
	public void setFechaVale(Date fechaVale) {
		this.fechaVale = fechaVale;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}
