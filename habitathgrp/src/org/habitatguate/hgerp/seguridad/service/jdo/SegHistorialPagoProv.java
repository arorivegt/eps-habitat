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
	private Date FechadeTransaccion;
	@Persistent
	private Date FechaSolicitud;
	@Persistent
	private String chequeNombre;
	@Persistent
	private String numeroCuenta;
	@Persistent
	private String Banco;
	@Persistent
	private Long idAfiliado;
	@Persistent
	private int statusPago;
	@Persistent
	private String tipoOperacion;
	@Persistent
	private String seriesDocumento;
	@Persistent
	private Double valorCancelado;
	@Persistent
	private Double retenidoDonacion;
	@Persistent
	private Double retenidoIva;
	@Persistent
	private String docLegalPago;
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
	public Date getFechadeTransaccion() {
		return FechadeTransaccion;
	}
	public void setFechadeTransaccion(Date fechadeTransaccion) {
		FechadeTransaccion = fechadeTransaccion;
	}
	public Date getFechaSolicitud() {
		return FechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		FechaSolicitud = fechaSolicitud;
	}
	public String getChequeNombre() {
		return chequeNombre;
	}
	public void setChequeNombre(String chequeNombre) {
		this.chequeNombre = chequeNombre;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getBanco() {
		return Banco;
	}
	public void setBanco(String banco) {
		Banco = banco;
	}
	public Long getIdAfiliado() {
		return idAfiliado;
	}
	public void setIdAfiliado(Long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	public int getStatusPago() {
		return statusPago;
	}
	public void setStatusPago(int statusPago) {
		this.statusPago = statusPago;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getSeriesDocumento() {
		return seriesDocumento;
	}
	public void setSeriesDocumento(String seriesDocumento) {
		this.seriesDocumento = seriesDocumento;
	}
	public List<SegVale> getVale() {
		return vale;
	}
	public void setVale(List<SegVale> vale) {
		this.vale = vale;
	}
	public String getDocLegalPago() {
		return docLegalPago;
	}
	public void setDocLegalPago(String docLegalPago) {
		this.docLegalPago = docLegalPago;
	}
	
	
	
	
}
