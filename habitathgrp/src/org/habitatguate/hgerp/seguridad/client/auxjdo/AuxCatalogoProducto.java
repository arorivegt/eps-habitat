package org.habitatguate.hgerp.seguridad.client.auxjdo;



import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxCatalogoProducto implements Comparable<AuxCatalogoProducto>,IsSerializable{
	
    public static final ProvidesKey<AuxCatalogoProducto> KEY_PROVIDER = new ProvidesKey<AuxCatalogoProducto>() {
        @Override
        public Object getKey(AuxCatalogoProducto item) {
          return item == null ? null : item.getIdProducto();
        }
      };
      @Override
      public int compareTo(AuxCatalogoProducto o) {
        return (o == null || o.idProducto == null) ? -1 : -o.idProducto.compareTo(idProducto);
      }
	
	private String idProducto;
	
	private String descripcionProducto;
	
	private int statusProducto;

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getStatusProducto() {
		return statusProducto;
	}

	public void setStatusProducto(int statusProducto) {
		this.statusProducto = statusProducto;
	}

	
	
}
