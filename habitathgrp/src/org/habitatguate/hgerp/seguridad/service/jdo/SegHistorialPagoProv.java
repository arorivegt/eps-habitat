package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.Date;
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
public class SegHistorialPagoProv implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idHistorialPagoProv;
	@Persistent
	private Double valorPago;
	@Persistent
	private Date fechaVale;
	@Persistent
	private String TipoDocumento;
	@Persistent
	private String serieDocumento;
	@Persistent
	private Double valorCancelado;
	@Persistent
	private Double retenidoDonacion;
	@Persistent
	private Double retenidoIva;
	@Persistent
	private Long idProveedor;
	@Persistent
	@Unowned
	private List<SegVale> vale;
	
	
	
	
	public Double getValorCancelado() {
		return valorCancelado;
	}
	public void setValorCancelado(Double valorCancelado) {
		this.valorCancelado = valorCancelado;
	}
	public Double getRetenidoDonacion() {
		return retenidoDonacion;
	}
	public void setRetenidoDonacion(Double retenidoDonacion) {
		this.retenidoDonacion = retenidoDonacion;
	}
	public Double getRetenidoIva() {
		return retenidoIva;
	}
	public void setRetenidoIva(Double retenidoIva) {
		this.retenidoIva = retenidoIva;
	}
	public Long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public Long getIdHistorialPagoProv() {
		return idHistorialPagoProv;
	}
	public void setIdHistorialPagoProv(Long idHistorialPagoProv) {
		this.idHistorialPagoProv = idHistorialPagoProv;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Date getFechaVale() {
		return fechaVale;
	}
	public void setFechaVale(Date fechaVale) {
		this.fechaVale = fechaVale;
	}
	public String getTipoDocumento() {
		return TipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}
	public String getSerieDocumento() {
		return serieDocumento;
	}
	public void setSerieDocumento(String serieDocumento) {
		this.serieDocumento = serieDocumento;
	}
	public List<SegVale> getVale() {
		return vale;
	}
	public void setVale(List<SegVale> vale) {
		this.vale = vale;
	}
	

	
	
}
