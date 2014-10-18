package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.sql.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegProveedor implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idProveedor;
	@Persistent
	private String nomProveedor;
	@Persistent
	private String dirProveedor;
	@Persistent
	private String telProveedor;
	@Persistent
	private Boolean servicioEntrega;	
	@Persistent
	private Date fechaIngreso;
	@Persistent
	private Boolean aprobadoComision;
	@Persistent
	private String paginaWeb;
	@Persistent
	private String numeroNit;
	@Persistent
	private String personaJuridica;
	@Persistent
	private String observaciones;
	
	private SegAfiliado afiliado;
	
	public Key getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Key idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNomProveedor() {
		return nomProveedor;
	}
	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}
	public String getDirProveedor() {
		return dirProveedor;
	}
	public void setDirProveedor(String dirProveedor) {
		this.dirProveedor = dirProveedor;
	}
	public String getTelProveedor() {
		return telProveedor;
	}
	public void setTelProveedor(String telProveedor) {
		this.telProveedor = telProveedor;
	}
	public Boolean getServicioEntrega() {
		return servicioEntrega;
	}
	public void setServicioEntrega(Boolean servicioEntrega) {
		this.servicioEntrega = servicioEntrega;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Boolean getAprobadoComision() {
		return aprobadoComision;
	}
	public void setAprobadoComision(Boolean aprobadoComision) {
		this.aprobadoComision = aprobadoComision;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getNumeroNit() {
		return numeroNit;
	}
	public void setNumeroNit(String numeroNit) {
		this.numeroNit = numeroNit;
	}
	public String getPersonaJuridica() {
		return personaJuridica;
	}
	public void setPersonaJuridica(String personaJuridica) {
		this.personaJuridica = personaJuridica;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public SegAfiliado getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(SegAfiliado afiliado) {
		this.afiliado = afiliado;
	}
	
	
}
