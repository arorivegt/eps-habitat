package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.rrhh.formularioFamilia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;


public class Sce_DataEntryDatosVivienda extends Composite {

	private Sce_DataEntryFormularioSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
	 private FlexTable flextable;
    
	 private Sce_DataDatosVivienda data;
	 
	public Sce_DataEntryDatosVivienda(Sce_DataEntryFormularioSolicitud formulario) {
				
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
	
		data = new Sce_DataDatosVivienda(this, this.formularioSolicitud);
        flextable.setWidget(flextable.getRowCount(), 0, data);

	}
	
    
    public void setDataDatosVivienda(List<AuxSolicitudDatosVivienda> results){

    	if (!results.isEmpty()) {

    		for ( AuxSolicitudDatosVivienda n2 : results) {

    			System.out.println("ID Datos Vivienda a Cargar: " + n2.getIdDatosVivienda() + ", ID Formulario: " + n2.getIdFormulario());
    			
    			data.LlenarDatos(n2.getIdDatosVivienda(), 
    					n2.getDatoVivienda(), n2.getOtroDatoVivienda(),
    					n2.getTecho(), n2.getPared(), n2.getCocina(),
    					n2.getCheckAgua(), n2.getCheckDrenaje(), n2.getCheckElectricidad(), n2.getCheckSanitario(),
    					n2.getBienesInmuebles(), n2.getValorInmueble());    		
    		}
    	}
    
    }
    
    
}
