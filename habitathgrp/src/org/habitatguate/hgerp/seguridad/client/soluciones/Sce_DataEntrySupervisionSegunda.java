package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionSegunda;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.rrhh.FormularioFamilia;

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


public class Sce_DataEntrySupervisionSegunda extends Composite {

	private Sce_DataEntryBitacoraSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
	 private FlexTable flextable;
    
	 private Sce_DataSupervisionSegunda data;
	 
	public Sce_DataEntrySupervisionSegunda(Sce_DataEntryBitacoraSolicitud formulario) {
				
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
	
		data = new Sce_DataSupervisionSegunda(this, this.formularioSolicitud);
        flextable.setWidget(flextable.getRowCount(), 0, data);

	}
	
    
    public void setDataSupervisionSegunda(List<AuxSolicitudSupervisionSegunda> results){

    	if (!results.isEmpty()) {

    		for ( AuxSolicitudSupervisionSegunda n2 : results) {

    			System.out.println("ID Segunda Supervison a Cargar: " + n2.getIdSupervisionSegunda() + ", ID Formulario: " + n2.getIdFormulario());
    			
//    			final Sce_DataEntryBitacoraSolicitud bitacoraSolicitud = new Sce_DataEntryBitacoraSolicitud();
//    			bitacoraSolicitud.habilitarTerceraSupervision();
    			
    			System.out.println("Existe Data en Segunda Supervision - Se habilita 3era Supervision");
    			
    			data.LlenarDatos(n2.getIdSupervisionSegunda(), 
    					n2.getFechaVisita(),
    					n2.getObservaciones(), n2.getAcciones(),
    					n2.getCheckSatisfactoria(), n2.getCheckNoSatisfactoria(),
    					n2.getPromotor(), n2.getAlbanil(), n2.getRepresentante(),
    					n2.getURLFile(), n2.getKeyFile());		
    		
    		}
    	}
    
    }
    
    
}
