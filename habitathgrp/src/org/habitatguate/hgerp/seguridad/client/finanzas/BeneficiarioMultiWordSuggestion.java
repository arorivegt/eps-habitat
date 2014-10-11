package org.habitatguate.hgerp.seguridad.client.finanzas;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class BeneficiarioMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxBeneficiario afiliado = null;

	
	
	public BeneficiarioMultiWordSuggestion(AuxBeneficiario afiliado){
		super(afiliado.getNomBeneficiario() + " " + afiliado.getDirBeneficiario(),
				afiliado.getNomBeneficiario() + " " + afiliado.getDirBeneficiario());
		this.afiliado = afiliado;
	}
	



	public AuxBeneficiario getAfiliado() {
		return this.afiliado;
	}
	



	
}
