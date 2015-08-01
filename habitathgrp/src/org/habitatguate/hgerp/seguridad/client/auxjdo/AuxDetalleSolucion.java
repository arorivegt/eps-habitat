package org.habitatguate.hgerp.seguridad.client.auxjdo;







import java.util.ArrayList;

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
	
	private Double precioUnitario;
	
	private Double cantidadEjecutada;
	
    private AuxMaterialCostruccion materialCostruccion;
	
	private AuxSolucion solucion;
	
	private ArrayList<AuxVale> vale = new ArrayList<AuxVale>();;

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

	public ArrayList<AuxVale> getVale() {
		return vale;
	}

	public void setVale(ArrayList<AuxVale> vale) {
		this.vale = vale;
	}

	public Double getCantidadEjecutada() {
		return cantidadEjecutada;
	}

	public void setCantidadEjecutada(Double cantidadEjecutada) {
		this.cantidadEjecutada = cantidadEjecutada;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	
}
