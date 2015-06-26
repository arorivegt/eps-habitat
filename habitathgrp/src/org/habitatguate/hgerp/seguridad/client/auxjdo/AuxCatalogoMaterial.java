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
	
	
	
	private Long idCatalogoMaterial;

	private String idMaterial;

	private String nombreMaterial;
	
	private String categoriaMaterial;
	
	private int status;
	
	
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCategoriaMaterial() {
		return categoriaMaterial;
	}

	public void setCategoriaMaterial(String categoriaMaterial) {
		this.categoriaMaterial = categoriaMaterial;
	}

	public Long getIdCatalogoMaterial() {
		return idCatalogoMaterial;
	}

	public void setIdCatalogoMaterial(Long idCatalogoMaterial) {
		this.idCatalogoMaterial = idCatalogoMaterial;
	}

	public String getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(String idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}
	
	
	
	
}
