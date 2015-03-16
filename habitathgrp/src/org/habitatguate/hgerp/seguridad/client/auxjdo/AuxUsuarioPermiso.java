package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxUsuarioPermiso implements IsSerializable{
	
    private Long id_permiso;
	
    private Long rol;
	
    private String nombreFormulario;
	
    private Long formularioPadre;
	
    private String permiso;

	public AuxUsuarioPermiso() {
		super();
	}

	public Long getId_permiso() {
		return id_permiso;
	}

	public void setId_permiso(Long id_permiso) {
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
