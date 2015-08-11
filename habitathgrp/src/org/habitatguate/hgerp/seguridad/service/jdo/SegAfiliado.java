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
	@Persistent
	private String telefono;
	@Persistent
	private String codigoAfiliado;
	@Persistent
	private int correlativoVale;
	@Persistent(mappedBy = "afiliado")
    @Element(dependent = "true")
	private List <SegBeneficiario> beneficiario;
	@Persistent(mappedBy = "afiliado")
    @Element(dependent = "true")
	private List <SegProveedor> proveedor;
	@Persistent
	@OneToMany(mappedBy = "afiliado")
	private List<Long> empleados;
	

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

	public List<SegBeneficiario> getSolucion() {
		return beneficiario;
	}

	public void setSolucion(List<SegBeneficiario> solucion) {
		this.beneficiario = solucion;
	}

	public List<Long> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Long> empleados) {
		this.empleados = empleados;
	}

	public List<SegBeneficiario> getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(List<SegBeneficiario> beneficiario) {
		this.beneficiario = beneficiario;
	}

	public List<SegProveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(List<SegProveedor> proveedor) {
		this.proveedor = proveedor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigoAfiliado() {
		return codigoAfiliado;
	}

	public void setCodigoAfiliado(String codigoAfiliado) {
		this.codigoAfiliado = codigoAfiliado;
	}

	public int getCorrelativoVale() {
		return correlativoVale;
	}

	public void setCorrelativoVale(int correlativoVale) {
		this.correlativoVale = correlativoVale;
	}

	
	

	
	
}
