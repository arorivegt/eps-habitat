package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxTipoSolucion implements Comparable<AuxTipoSolucion>,IsSerializable{
	
	/**

     * El KEY_PROVIDER es el que provee el ID de un contacto.
     */
    public static final ProvidesKey<AuxTipoSolucion> KEY_PROVIDER = new ProvidesKey<AuxTipoSolucion>() {
      @Override
      public Object getKey(AuxTipoSolucion item) {
        return item == null ? null : item.getIdTipoSolucion();
      }
    };
    	@Override
	    public int compareTo(AuxTipoSolucion o) {
	      return (o == null || o.idTipoSolucion == null) ? -1 : -o.idTipoSolucion.compareTo(idTipoSolucion);
	    }
	
    
	private String idTipoSolucion;
	
	private String descripcionTipoSolucion;
	
	private int statusProducto;
	public String getIdTipoSolucion() {
		return idTipoSolucion;
	}

	public void setIdTipoSolucion(String idTipoSolucion) {
		this.idTipoSolucion = idTipoSolucion;
	}

	public String getDescripcionTipoSolucion() {
		return descripcionTipoSolucion;
	}

	public void setDescripcionTipoSolucion(String descripcionTipoSolucion) {
		this.descripcionTipoSolucion = descripcionTipoSolucion;
	}

	public int getStatusProducto() {
		return statusProducto;
	}

	public void setStatusProducto(int statusProducto) {
		this.statusProducto = statusProducto;
	}
	
	
	
	
	

}
