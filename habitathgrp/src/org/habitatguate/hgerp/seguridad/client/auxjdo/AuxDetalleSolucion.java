package org.habitatguate.hgerp.seguridad.client.auxjdo;




import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxDetalleSolucion implements Comparable<AuxDetalleSolucion>,IsSerializable {
	
	  public static final ProvidesKey<AuxDetalleSolucion> KEY_PROVIDER = new ProvidesKey<AuxDetalleSolucion>() {
	        @Override
	        public Object getKey(AuxDetalleSolucion item) {
	          return item == null ? null : item.getIdDetalleSolucion();
	        }
	      };
	      @Override
	      public int compareTo(AuxDetalleSolucion o) {
	        return (o == null || o.getIdDetalleSolucion() == null) ? -1 : -o.getIdDetalleSolucion().compareTo(getIdDetalleSolucion());
	      }

	private Long idDetalleSolucion;
	
	private Double cantidad;
	
	private String unidadMetrica;
	
	private Double subTotal;
	
	private Double costoAcumulado;
	
    private AuxMaterialCostruccion materialCostruccion;
	
	private AuxSolucion solucion;
	
	private AuxVale vale;

	public Long getIdDetalleSolucion() {
		return idDetalleSolucion;
	}

	public void setIdDetalleSolucion(Long idDetalleSolucion) {
		this.idDetalleSolucion = idDetalleSolucion;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidadMetrica() {
		return unidadMetrica;
	}

	public void setUnidadMetrica(String unidadMetrica) {
		this.unidadMetrica = unidadMetrica;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getCostoAcumulado() {
		return costoAcumulado;
	}

	public void setCostoAcumulado(Double costoAcumulado) {
		this.costoAcumulado = costoAcumulado;
	}

	public AuxMaterialCostruccion getMaterialCostruccion() {
		return materialCostruccion;
	}

	public void setMaterialCostruccion(AuxMaterialCostruccion materialCostruccion) {
		this.materialCostruccion = materialCostruccion;
	}

	public AuxSolucion getSolucion() {
		return solucion;
	}

	public void setSolucion(AuxSolucion solucion) {
		this.solucion = solucion;
	}

	public AuxVale getVale() {
		return vale;
	}

	public void setVale(AuxVale vale) {
		this.vale = vale;
	}
	
	
	
}
