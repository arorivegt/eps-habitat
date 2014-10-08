package org.habitatguate.hgerp.seguridad.client.finanzas;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class MaterialMultiWordSuggestion extends MultiWordSuggestion{

	
	private AuxMaterialCostruccion MatConstruccion = null;
	private AuxPlantillaSolucion PlatillaSolucion = null;
	
	
	public MaterialMultiWordSuggestion(AuxMaterialCostruccion matConstruccion){
		super(matConstruccion.getNomMaterialCostruccion()+ " " + matConstruccion.getPrecioUnit(),
				matConstruccion.getNomMaterialCostruccion()+ " " + matConstruccion.getPrecioUnit());
		this.MatConstruccion = matConstruccion;
	}
	
	public MaterialMultiWordSuggestion(AuxPlantillaSolucion matPlantilla){
		super(matPlantilla.getNomPlantillaSolucion()+ " " + matPlantilla.getCostoFinal(),
				matPlantilla.getNomPlantillaSolucion()+ " " + matPlantilla.getCostoFinal());
		this.PlatillaSolucion = matPlantilla;
	}


	public AuxMaterialCostruccion getMatConstruccion() {
		return MatConstruccion;
	}
	
	public AuxPlantillaSolucion getPlantillaSolucion(){
		return PlatillaSolucion;
	}


	
}
