package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.datanucleus.annotations.Unowned;



@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegVale implements Serializable{
	@PrimaryKey
	@Persistent
	private String idVale;
	@Persistent
	private Double totalVale;
	@Persistent
	private Date fechaVale;
	@Persistent
	private boolean estado;
	@Persistent
	private Double totalPagado;
	@Persistent
	private int aprobado;
	
	//relacion
	@Persistent(mappedBy = "vale")
    @Element(dependent = "true")
	@Unowned
	private List<SegHistorialPagoProv> listaPagoProv;
	
	@Persistent
	@Unowned
	private List<SegDetalleEjecucion> listadetalle;
	
	
	public SegVale(String idVale){
		this.idVale = idVale;
	}
	
	
	public String getIdVale() {
		return idVale;
	}
	public void setIdVale(String idVale) {
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
	public Double getTotalPagado() {
		return totalPagado;
	}
	public void setTotalPagado(Double totalPagado) {
		this.totalPagado = totalPagado;
	}
	public List<SegHistorialPagoProv> getListaPagoProv() {
		return listaPagoProv;
	}
	public void setListaPagoProv(List<SegHistorialPagoProv> listaPagoProv) {
		this.listaPagoProv = listaPagoProv;
	}
	public int getAprobado() {
		return aprobado;
	}
	public void setAprobado(int aprobado) {
		this.aprobado = aprobado;
	}
	public List<SegDetalleEjecucion> getListadetalle() {
		return listadetalle;
	}
	public void setListadetalle(List<SegDetalleEjecucion> listadetalle) {
		this.listadetalle = listadetalle;
	}
	
	
	
		
}