package org.habitatguate.hgerp.seguridad.client.finanzas;


import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class PlantillaMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxPlantillaSolucion PlatillaSolucion = null;
	
	
	
	public PlantillaMultiWordSuggestion(AuxPlantillaSolucion matPlantilla){
		super(matPlantilla.getNomPlantillaSolucion()+"		"+ matPlantilla.getTipo()+ "		" + matPlantilla.getCostoFinal() ,
				matPlantilla.getNomPlantillaSolucion()+"		"+ matPlantilla.getTipo()+ "		" + matPlantilla.getCostoFinal());
		this.PlatillaSolucion = matPlantilla;
	}


	
	public AuxPlantillaSolucion getPlantillaSolucion(){
		return PlatillaSolucion;
	}


	
}
