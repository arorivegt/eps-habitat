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
	private double municipio;
	@Persistent
	private double departamento;
	
	@Persistent(mappedBy = "afiliado")
    @Element(dependent = "true")
	private List <SegAfiliado> solucion;

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

	public String getDirAfiliadol() {
		return dirAfiliado;
	}

	public void setDirAfiliadol(String dirAfiliadol) {
		this.dirAfiliado = dirAfiliadol;
	}

	public double getMunicipio() {
		return municipio;
	}

	public void setMunicipio(double municipio) {
		this.municipio = municipio;
	}

	public double getDepartamento() {
		return departamento;
	}

	public void setDepartamento(double departamento) {
		this.departamento = departamento;
	}

	public List<SegAfiliado> getSolucion() {
		return solucion;
	}

	public void setSolucion(List<SegAfiliado> solucion) {
		this.solucion = solucion;
	}
	
	
}
