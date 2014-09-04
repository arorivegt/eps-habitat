package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegBeneficiario implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idBeneficiario;
	@Persistent
	private String nomBeneficiario;
	@Persistent
	private String dirBeneficiario;
	@Persistent
	private int telBeneficiario;
	@Persistent
	private int codDos;
		
	
	public SegBeneficiario(){
		super();
	}

	
	//aqui vienen todas los objetos con los que se relaciona

	@Persistent(mappedBy = "beneficiario")
    @Element(dependent = "true")
	private List <SegSolucion> solucion;



	public Long getIdBeneficiario() {
		return idBeneficiario;
	}



	public void setIdBeneficiario(Long idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}



	public String getNomBeneficiario() {
		return nomBeneficiario;
	}



	public void setNomBeneficiario(String nomBeneficiario) {
		this.nomBeneficiario = nomBeneficiario;
	}



	public String getDirBeneficiario() {
		return dirBeneficiario;
	}



	public void setDirBeneficiario(String dirBeneficiario) {
		this.dirBeneficiario = dirBeneficiario;
	}



	public int getTelBeneficiario() {
		return telBeneficiario;
	}



	public void setTelBeneficiario(int telBeneficiario) {
		this.telBeneficiario = telBeneficiario;
	}



	public int getCodDos() {
		return codDos;
	}



	public void setCodDos(int codDos) {
		this.codDos = codDos;
	}



	public List<SegSolucion> getSolucion() {
		return solucion;
	}



	public void setSolucion(List<SegSolucion> solucion) {
		this.solucion = solucion;
	}
	
	
	
	
}
