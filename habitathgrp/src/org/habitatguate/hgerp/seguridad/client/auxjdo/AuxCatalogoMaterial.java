package org.habitatguate.hgerp.seguridad.client.auxjdo;



import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxCatalogoMaterial implements Comparable<AuxCatalogoMaterial>,IsSerializable {
	/**

     * El KEY_PROVIDER es el que provee el ID de un contacto.
     */
    public static final ProvidesKey<AuxCatalogoMaterial> KEY_PROVIDER = new ProvidesKey<AuxCatalogoMaterial>() {
      @Override
      public Object getKey(AuxCatalogoMaterial item) {
        return item == null ? null : item.getIdCatalogoMaterial();
      }
    };
    @Override
    public int compareTo(AuxCatalogoMaterial o) {
      return (o == null || o.idCatalogoMaterial == null) ? -1 : -o.idCatalogoMaterial.compareTo(idCatalogoMaterial);
    }
	
	
	
    private String idCatalogoMaterial;
	
	private String nombreMaterial;
	
	private String tipoMaterial;
	
	private String idProducto;
	
	private String unidadMedida;
	
	private int status;
	
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIdCatalogoMaterial() {
		return idCatalogoMaterial;
	}

	public void setIdCatalogoMaterial(String idCatalogoMaterial) {
		this.idCatalogoMaterial = idCatalogoMaterial;
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	
	
}
