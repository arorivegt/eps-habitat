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
public class SegAfiliado implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idAfiliado;
	@Persistent
	private String nomAfiliado;
	@Persistent
	private String dirAfiliado;
	@Persistent
	private String municipio;
	@Persistent
	private String departamento;
	
	@Persistent(mappedBy = "afiliado")
    @Element(dependent = "true")
	private List <SegSolucion> solucion;
	

	public SegAfiliado(){
		super();
	}

	public Long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(Long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public String getNomAfiliado() {
		return nomAfiliado;
	}

	public void setNomAfiliado(String nomAfiliado) {
		this.nomAfiliado = nomAfiliado;
	}

	public String getDirAfiliado() {
		return dirAfiliado;
	}

	public void setDirAfiliado(String dirAfiliado) {
		this.dirAfiliado = dirAfiliado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<SegSolucion> getSolucion() {
		return solucion;
	}

	public void setSolucion(List<SegSolucion> solucion) {
		this.solucion = solucion;
	}


	
	
}
