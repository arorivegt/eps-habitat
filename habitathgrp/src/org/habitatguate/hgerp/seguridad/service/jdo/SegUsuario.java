package org.habitatguate.hgerp.seguridad.service.jdo;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegUsuario{
	
	@PrimaryKey
	private String user;
	
	@Persistent
	private String password;
	
	@Persistent
	private Long id_empleado;
	
	public SegUsuario(String user2, String password2) {
		super();
		this.user=user2;
		this.password=password2;
	}

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
