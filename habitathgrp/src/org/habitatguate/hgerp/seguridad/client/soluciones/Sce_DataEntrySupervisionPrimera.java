package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionPrimera;
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


public class Sce_DataEntrySupervisionPrimera extends Composite {

	private Sce_DataEntryBitacoraSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
	 private FlexTable flextable;
    
	 private Sce_DataSupervisionPrimera data;
	 
	public Sce_DataEntrySupervisionPrimera(Sce_DataEntryBitacoraSolicitud formulario) {
				
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
	
		data = new Sce_DataSupervisionPrimera(this, this.formularioSolicitud);
        flextable.setWidget(flextable.getRowCount(), 0, data);

	}
	
    
    public void setDataSupervisionPrimera(List<AuxSolicitudSupervisionPrimera> results){

    	if (!results.isEmpty()) {

    		for ( AuxSolicitudSupervisionPrimera n2 : results) {

    			System.out.println("ID Primera Supervison a Cargar: " + n2.getIdSupervisionPrimera() + ", ID Formulario: " + n2.getIdFormulario());
    			
    			data.LlenarDatos(n2.getIdSupervisionPrimera(), 
    					n2.getFechaVisita(), n2.getCheckSi(), n2.getCheckNo(),
    					n2.getObservaciones(), n2.getAcciones(),
    					n2.getCheckSatisfactoria(), n2.getCheckNoSatisfactoria());    		
    		
    		}
    	}
    
    }
    
    
}
