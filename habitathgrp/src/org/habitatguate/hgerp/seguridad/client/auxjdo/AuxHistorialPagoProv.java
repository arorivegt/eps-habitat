package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Persistent;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;



public class AuxHistorialPagoProv implements Comparable<AuxHistorialPagoProv>,IsSerializable {
	
	public static final ProvidesKey<AuxHistorialPagoProv> KEY_PROVIDER = new ProvidesKey<AuxHistorialPagoProv>() {
        @Override
        public Object getKey(AuxHistorialPagoProv item) {
          return item == null ? null : item.getIdHistorialPagoProv();
        }
      };
	
      @Override
      public int compareTo(AuxHistorialPagoProv o) {
        return (o == null || o.idHistorialPagoProv == null) ? -1 : -o.idHistorialPagoProv.compareTo(idHistorialPagoProv);
      }
	
	private Long idHistorialPagoProv;

	private Double valorPago;
	private Date FechadeTransaccion;
	private Date FechaSolicitud;
	private String chequeNombre;
	private String numeroCuenta;
	private String Banco;
	private Long idAfiliado;
	private int statusPago;
	private String tipoOperacion;
	private String seriesDocumento;
	private Double valorCancelado;
	private Double retenidoDonacion;
	private Double retenidoIva;
	private String docLegalPago;
	private Long idProveedor;

	//extras---------------
	
	private String nombreAfiliado;
	
	private String nombreProveedor;
	
	
	//-----------------
	
	
	private List<AuxVale> vale;

	

	
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


	public List<AuxVale> getVale() {
		return vale;
	}

	public void setVale(List<AuxVale> vale) {
		this.vale = vale;
	}

	public String getDocLegalPago() {
		return docLegalPago;
	}

	public void setDocLegalPago(String docLegalPago) {
		this.docLegalPago = docLegalPago;
	}

	public String getNombreAfiliado() {
		return nombreAfiliado;
	}

	public void setNombreAfiliado(String nombreAfiliado) {
		this.nombreAfiliado = nombreAfiliado;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	
	
	
}
