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
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idCatalogoMaterial;
	@Persistent
	private String idMaterial;
	@Persistent
	private String nombreMaterial;
	@Persistent
	private String categoriaMaterial;
	@Persistent
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

	public SegCatalogoMaterial(){
		super();
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
