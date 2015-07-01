package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.Date;
import java.util.List;

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

	private Date fechaVale;

	private String TipoDocumento;

	private String serieDocumento;

	private List<AuxVale> vale;

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

	public List<AuxVale> getVale() {
		return vale;
	}

	public void setVale(List<AuxVale> vale) {
		this.vale = vale;
	}

	
	
	
}
