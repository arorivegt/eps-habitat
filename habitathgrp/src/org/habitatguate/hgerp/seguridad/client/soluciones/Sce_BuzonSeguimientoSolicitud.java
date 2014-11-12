package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Grid;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleados; // Por cambiar

public class Sce_BuzonSeguimientoSolicitud extends Composite  {

	private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_BuzonSeguimientoSolicitud buzon;
	private Mensaje mensaje; 
	private Grid grid;
	private ListBox listBox;
	private Label lbDato1;
	private Image Busqueda;
	private SuggestBox txtDato1;
	private ListBox listEstado ;
	private AbsolutePanel absolutePanel;
	private Loading load ;
    
	public Sce_BuzonSeguimientoSolicitud() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		this.buzon = this;
		grid = new Grid(2, 1);
		grid.setSize("876px", "100%");
		
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		grid.clearCell(0, 0);
		Sce_BuzonSeguimientoSolicitudLista  nuevo = new Sce_BuzonSeguimientoSolicitudLista();
		nuevo.agregarFormulario('2', buzon, "", "", "", "", "", "", "");
		grid.setWidget(1, 0,nuevo);
	    	
		initWidget(grid);
	
	}
	
	// CARGA DATA A FORMULARIO

	public void cargarFormulario(final Long idFormulario){
        
		load.visible();        
		grid.clearCell(1, 0);
		
		final Sce_DataEntrySeguimientoFormularioSolicitud seguimientoSolicitud = new Sce_DataEntrySeguimientoFormularioSolicitud();
		
		seguimientoSolicitud.NuevasPestanas();	// Muestra de nuevo las pestanas
		grid.setWidget(1, 0, seguimientoSolicitud);
		seguimientoSolicitud.setSize("100%", "648px");
        
        solucionesService.obtenerDataFormularioRegistrado(idFormulario, new AsyncCallback<AuxSolicitudGeneral>(){
        	public void onFailure(Throwable caught) 
        	{
                load.invisible();
            	mensaje.setMensaje("alert alert-information alert-block", 
            			"\nNo hay resultados");
        	}

        	@Override
        	public void onSuccess(AuxSolicitudGeneral result)
        	{	
        		
                load.invisible();            	
                seguimientoSolicitud.idFormulario = result.getIdFormulario();
            	System.out.println("SEGUIMIENTO DE FORMULARIO: " + seguimientoSolicitud.idFormulario + ", Del Solicitante: " + result.getNombreSolicitante());
        		        		
        		try{
        		
        			seguimientoSolicitud.setDataDocumentoPropiedad(result.getDocumentoPropiedad());

        		}catch(Exception e){
        			
        		}        		
            
        		
        	}

        });
	}
	
}
