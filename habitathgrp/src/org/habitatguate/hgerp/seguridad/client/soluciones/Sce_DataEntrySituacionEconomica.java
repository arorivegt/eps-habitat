package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSituacionEconomica;
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


public class Sce_DataEntrySituacionEconomica extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryFormularioSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
	 private Mensaje mensaje; 
	 private FlexTable flextable;
    
	 private Sce_DataSituacionEconomica data;
	 
	public Sce_DataEntrySituacionEconomica(Sce_DataEntryFormularioSolicitud formulario) {
				
		mensaje = new Mensaje();
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
	
		data = new Sce_DataSituacionEconomica(this, this.formularioSolicitud);
        flextable.setWidget(flextable.getRowCount(), 0, data);

	}
	
    
    public void setDataSituacionEconomica(List<AuxSolicitudSituacionEconomica> results){

    	if (!results.isEmpty()) {

    		for ( AuxSolicitudSituacionEconomica n2 : results) {

    			System.out.println("ID Situacion Economica a Cargar: " + n2.getIdSituacionEconomica() + ", ID Formulario: " + n2.getIdFormulario());
    			
    			data.LlenarDatos(n2.getIdSituacionEconomica(), 
    					n2.getIngresosSolicitante(), n2.getIngresosConyuge(), n2.getOtrosIngresos(), n2.getIngresosTotales(),
    					n2.getTotalIngresos(), n2.getTotalEgresos(), n2.getDiferencia(), n2.getPagosBuro(), n2.getCuota(), n2.getExcedente(),
    					n2.getAlquilerVivienda(), n2.getAlimentacion(), n2.getRopa(), n2.getGastosMedicos(), n2.getTransporte(), n2.getEducacion(),
    					n2.getPagoLuzAgua(), n2.getPagoPrestamos(), n2.getOtrosGastos1(), n2.getOtrosGastos2(), n2.getEgresosTotales());  
    			
    		}
    	
    	}
    
    }
    
    
}
