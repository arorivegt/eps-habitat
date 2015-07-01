package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegContactoProv implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idContactoProv;
	@Persistent
	private String nomContacto;
	@Persistent
	private String dirContacto;
	@Persistent
	private String correoContacto;
	@Persistent
	private String telContacto;
	@Persistent
	private String cellphoneContacto;
	
	
	

	public Long getIdContactoProv() {
		return idContactoProv;
	}
	public void setIdContactoProv(Long idContactoProv) {
		this.idContactoProv = idContactoProv;
	}
	public String getNomContacto() {
		return nomContacto;
	}
	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}
	public String getDirContacto() {
		return dirContacto;
	}
	public void setDirContacto(String dirContacto) {
		this.dirContacto = dirContacto;
	}
	public String getCorreoContacto() {
		return correoContacto;
	}
	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}
	public String getTelContacto() {
		return telContacto;
	}
	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}
	public String getCellphoneContacto() {
		return cellphoneContacto;
	}
	public void setCellphoneContacto(String cellphoneContacto) {
		this.cellphoneContacto = cellphoneContacto;
	}
	
	
	

}
