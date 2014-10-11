package org.habitatguate.hgerp.seguridad.client.finanzas;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class AfiliadoMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxAfiliado afiliado = null;

	
	
	public AfiliadoMultiWordSuggestion(AuxAfiliado afiliado){
		super(afiliado.getNomAfiliado()+ " " + afiliado.getDirAfiliado(),
				afiliado.getNomAfiliado()+ " " + afiliado.getDirAfiliado());
		this.afiliado = afiliado;
	}
	



	public AuxAfiliado getAfiliado() {
		return this.afiliado;
	}
	



	
}
