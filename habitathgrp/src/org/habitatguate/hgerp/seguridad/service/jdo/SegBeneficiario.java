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

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegBeneficiario implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idBeneficiario;
	@Persistent
	private String nomBeneficiario;
	@Persistent
	private String dirBeneficiario;
	@Persistent
	private String DPI;
	@Persistent
	private int telBeneficiario;
	@Persistent
	private SegAfiliado afiliado;
	@Persistent(mappedBy = "beneficiario")
	@Element(dependent = "true")
	@Unowned
	private SegSolucion solucion;
	@Persistent
	@Unowned
	private SegSolicitudGeneral solicitud;
	
	public SegBeneficiario(){
		super();
	}

	
	//aqui vienen todas los objetos con los que se relaciona





	public Key getIdBeneficiario() {
		return idBeneficiario;
	}



	public SegSolicitudGeneral getSolicitud() {
		return solicitud;
	}


	public void setSolicitud(SegSolicitudGeneral solicitud) {
		this.solicitud = solicitud;
	}


	public void setIdBeneficiario(Key idBeneficiario) {
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







	public SegSolucion getSolucion() {
		return solucion;
	}



	public void setSolucion(SegSolucion solucion) {
		this.solucion = solucion;
	}


	public SegAfiliado getAfiliado() {
		return afiliado;
	}


	public void setAfiliado(SegAfiliado afiliado) {
		this.afiliado = afiliado;
	}


	public String getDPI() {
		return DPI;
	}


	public void setDPI(String dPI) {
		DPI = dPI;
	}
	

	
	
	
}
