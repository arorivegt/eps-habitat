package org.habitatguate.hgerp.seguridad.client.finanzas;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class BeneMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxBeneficiario afiliado = null;

	
	
	public BeneMultiWordSuggestion(AuxBeneficiario afiliado){
		super(afiliado.getNomBeneficiario() ,
				afiliado.getNomBeneficiario());
		this.afiliado = afiliado;
	}
	



	public AuxBeneficiario getAfiliado() {
		return this.afiliado;
	}
	



	
}
