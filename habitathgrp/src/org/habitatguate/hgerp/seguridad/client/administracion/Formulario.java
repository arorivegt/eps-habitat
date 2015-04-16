package org.habitatguate.hgerp.seguridad.client.administracion;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Formulario extends Composite  {
    private Loading load ;
	private FlexTable flextable;
    public List<FormularioRol> formularioROL = new ArrayList<FormularioRol>();
	
    public Formulario() {
    	
    	VerticalPanel verticalPanel = new VerticalPanel();
    	verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
    	verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    	initWidget(verticalPanel);
    	verticalPanel.setSize("761px", "381px");
    	
    	flextable = new FlexTable();
    	verticalPanel.add(flextable);

    	load = new Loading();
        load.Mostrar();
        load.invisible();
	}
    
    
    public void agregarFormulario_lleno(List<AuxUsuarioPermiso> results){
        load.visible();
        formularioROL.clear();
        
    	if (!results.isEmpty()) {
		    for ( AuxUsuarioPermiso n2 : results) {
		    		FormularioRol fa = new  FormularioRol();
		    		fa.LlenarDatos(n2.getId_permiso(), n2.getRol(),n2.getNombreFormulario(),
		    					   n2.getFormularioPadre(),n2.getPermiso());
			    	formularioROL.add(fa);
			    	flextable.setWidget(flextable.getRowCount(), 0,fa);
		    }
		    	
    	}
        load.invisible();
    		
    }
    
    
}
