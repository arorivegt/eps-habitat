package org.habitatguate.hgerp.seguridad.client.finanzas;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class ProveedorMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxProveedor afiliado = null;

	
	
	public ProveedorMultiWordSuggestion(AuxProveedor afiliado){
		super(afiliado.getNomProveedor()+ " " + afiliado.getDirProveedor(),
				afiliado.getNomProveedor()+ " " + afiliado.getDirProveedor());
		this.afiliado = afiliado;
	}
	



	public AuxProveedor getAfiliado() {
		return this.afiliado;
	}
	



	
}
