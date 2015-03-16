package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegUsuarioPermiso implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_permiso;
	
	@Persistent
    private Long rol;
	
	@Persistent
    private String nombreFormulario;
	
	@Persistent
    private Long formularioPadre;
	
	@Persistent
    private String permiso;

	public SegUsuarioPermiso() {
		super();
	}

	public Key getId_permiso() {
		return id_permiso;
	}

	public void setId_permiso(Key id_permiso) {
		this.id_permiso = id_permiso;
	}

	public Long getRol() {
		return rol;
	}

	public void setRol(Long rol) {
		this.rol = rol;
	}

	public String getNombreFormulario() {
		return nombreFormulario;
	}

	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}

	public Long getFormularioPadre() {
		return formularioPadre;
	}

	public void setFormularioPadre(Long formularioPadre) {
		this.formularioPadre = formularioPadre;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	

}
