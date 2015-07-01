package org.habitatguate.hgerp.seguridad.client.finanzas;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class CatalogoMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxCatalogoMaterial afiliado = null;

	
	
	public CatalogoMultiWordSuggestion(AuxCatalogoMaterial afiliado){
		super(afiliado.getNombreMaterial(),
				afiliado.getNombreMaterial());
		this.afiliado = afiliado;
	}
	



	public AuxCatalogoMaterial getAfiliado() {
		return this.afiliado;
	}
	



	
}
