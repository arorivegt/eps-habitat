package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class SegCatalogoMaterial implements Serializable {
	@PrimaryKey
	@Persistent
	private String idCatalogoMaterial;
	@Persistent
	private String nombreMaterial;
	@Persistent
	private String tipoMaterial;
	@Persistent
	private String idProducto;
	@Persistent
	private String unidadMedida;
	@Persistent
	private int status;
	
	
	
	
	
	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

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

	
	
	
}
