package org.habitatguate.hgerp.seguridad.client.finanzas;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class BeneficiarioMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxSolicitudGeneral afiliado = null;

	
	
	public BeneficiarioMultiWordSuggestion(AuxSolicitudGeneral afiliado){
		super(afiliado.getNombreSolicitante() ,
				afiliado.getNombreSolicitante());
		this.afiliado = afiliado;
	}
	



	public AuxSolicitudGeneral getAfiliado() {
		return this.afiliado;
	}
	



	
}
