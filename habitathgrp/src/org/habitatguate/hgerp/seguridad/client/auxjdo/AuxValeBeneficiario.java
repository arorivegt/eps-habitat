package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxValeBeneficiario implements IsSerializable{

	
	AuxBeneficiario beneficiario;
	
	AuxVale vale;
	
	AuxProveedor proveedor;

	
	
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
	
	
}
