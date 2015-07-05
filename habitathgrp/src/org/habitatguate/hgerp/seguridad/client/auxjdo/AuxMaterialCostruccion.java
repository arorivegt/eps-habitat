package org.habitatguate.hgerp.seguridad.client.auxjdo;



import java.util.Date;




import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxMaterialCostruccion implements Comparable<AuxMaterialCostruccion>,IsSerializable {

	/**

     * El KEY_PROVIDER es el que provee el ID de un contacto.
     */
    public static final ProvidesKey<AuxMaterialCostruccion> KEY_PROVIDER = new ProvidesKey<AuxMaterialCostruccion>() {
      @Override
      public Object getKey(AuxMaterialCostruccion item) {
        return item == null ? null : item.getIdMaterialConstruccion();
      }
    };
    
    @Override
    public int compareTo(AuxMaterialCostruccion o) {
      return (o == null || o.idMaterialConstruccion == null) ? -1 : -o.idMaterialConstruccion.compareTo(idMaterialConstruccion);
    }
    
    public AuxMaterialCostruccion(String nomMaterialConstruccion, Double Precio){
    	this.nomMaterialCostruccion = nomMaterialConstruccion;
    	this.precioUnit = Precio;
    }
    
    public AuxMaterialCostruccion(){
    	proveedor = new AuxProveedor();
    }
	
	private Long idMaterialConstruccion;

	private String nomMaterialCostruccion;

	private Double precioUnit;

	private String unidadMetrica;

	private Date fechaIngreso;
	
	private AuxProveedor proveedor;
	
	private String idProducto;
	
	
	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdMaterialConstruccion() {
		return idMaterialConstruccion;
	}

	public void setIdMaterialConstruccion(Long idMaterialConstruccion) {
		this.idMaterialConstruccion = idMaterialConstruccion;
	}

	public String getNomMaterialCostruccion() {
		return nomMaterialCostruccion;
	}

	public void setNomMaterialCostruccion(String nomMaterialCostruccion) {
		this.nomMaterialCostruccion = nomMaterialCostruccion;
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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public AuxProveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(AuxProveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
}
