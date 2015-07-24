package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegPersonalAfiliado implements Serializable{
	@PrimaryKey
	@Persistent
	private Long idPersonalAfiliado;
	@Persistent
	private String nombreAdministrador;
	@Persistent
	private String nombreAsistenteAdmin;
	@Persistent
	private String nombreContadorRegion;
	@Persistent
	private String nombreEncargadoCheques;
	public Long getIdPersonalAfiliado() {
		return idPersonalAfiliado;
	}
	public void setIdPersonalAfiliado(Long idPersonalAfiliado) {
		this.idPersonalAfiliado = idPersonalAfiliado;
	}
	public String getNombreAdministrador() {
		return nombreAdministrador;
	}
	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}
	public String getNombreAsistenteAdmin() {
		return nombreAsistenteAdmin;
	}
	public void setNombreAsistenteAdmin(String nombreAsistenteAdmin) {
		this.nombreAsistenteAdmin = nombreAsistenteAdmin;
	}
	public String getNombreContadorRegion() {
		return nombreContadorRegion;
	}
	public void setNombreContadorRegion(String nombreContadorRegion) {
		this.nombreContadorRegion = nombreContadorRegion;
	}
	public String getNombreEncargadoCheques() {
		return nombreEncargadoCheques;
	}
	public void setNombreEncargadoCheques(String nombreEncargadoCheques) {
		this.nombreEncargadoCheques = nombreEncargadoCheques;
	}
	
	
	

}
