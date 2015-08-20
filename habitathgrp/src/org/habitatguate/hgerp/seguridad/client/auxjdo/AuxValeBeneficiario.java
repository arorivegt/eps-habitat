package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxValeBeneficiario implements IsSerializable{

	
	AuxBeneficiario beneficiario;
	
	AuxVale vale;
	
	AuxProveedor proveedor;
	
	AuxMaterialCostruccion materialCostruccion;
	
	AuxSolucion solucion;
	
	Double totalPagar;
	
	Double cantidadMat;

	
	
	public AuxProveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(AuxProveedor proveedor) {
		this.proveedor = proveedor;
	}

	public AuxBeneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(AuxBeneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public AuxVale getVale() {
		return vale;
	}

	public void setVale(AuxVale vale) {
		this.vale = vale;
	}

	public AuxMaterialCostruccion getMaterialCostruccion() {
		return materialCostruccion;
	}

	public void setMaterialCostruccion(AuxMaterialCostruccion materialCostruccion) {
		this.materialCostruccion = materialCostruccion;
	}

	public AuxSolucion getSolucion() {
		return solucion;
	}

	public void setSolucion(AuxSolucion solucion) {
		this.solucion = solucion;
	}

	public Double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public Double getCantidadMat() {
		return cantidadMat;
	}

	public void setCantidadMat(Double cantidadMat) {
		this.cantidadMat = cantidadMat;
	}
	
	
	
	
	
}
