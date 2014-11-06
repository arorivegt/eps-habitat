package org.habitatguate.hgerp.seguridad.client.auxjdo;



import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxDetallePlantillaSolucion implements Comparable<AuxDetallePlantillaSolucion>,IsSerializable{
	
    public static final ProvidesKey<AuxDetallePlantillaSolucion> KEY_PROVIDER = new ProvidesKey<AuxDetallePlantillaSolucion>() {
        @Override
        public Object getKey(AuxDetallePlantillaSolucion item) {
          return item == null ? null : item.getIdDetallePlantillaSolucion();
        }
      };
      
      public int compareTo(AuxDetallePlantillaSolucion o) {
        return (o == null || o.idDetallePlantillaSolucion == null) ? -1 : -o.idDetallePlantillaSolucion.compareTo(idDetallePlantillaSolucion);
      }  

	
	
	private Long idDetallePlantillaSolucion;
	
	private String nomMaterialCostruccion;
	
	private Double cantidad;

	private Double precioUnit;

	private String unidadMetrica;

	private Double subTotal;
	
	private Double costoAcumulado;
	
	private AuxMaterialCostruccion materialCostruccion;

	public AuxDetallePlantillaSolucion(){
		materialCostruccion = new AuxMaterialCostruccion();
	}
	
	public Long getIdDetallePlantillaSolucion() {
		return idDetallePlantillaSolucion;
	}

	public void setIdDetallePlantillaSolucion(Long idDetallePlantillaSolucion) {
		this.idDetallePlantillaSolucion = idDetallePlantillaSolucion;
	}

	public String getNomMaterialCostruccion() {
		return nomMaterialCostruccion;
	}

	public void setNomMaterialCostruccion(String nomMaterialCostruccion) {
		this.nomMaterialCostruccion = nomMaterialCostruccion;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnit() {
		return precioUnit;
	}

	public void setPrecioUnit(Double precioUnit) {
		this.precioUnit = precioUnit;
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
	
	
	
	

}
