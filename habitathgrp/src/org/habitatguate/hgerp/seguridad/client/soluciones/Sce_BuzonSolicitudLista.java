package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;

public class Sce_BuzonSolicitudLista extends Composite {

	private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Mensaje mensaje; 
    private Sce_BuzonSolicitudLista listaFormulario;
    private FlexTable flexTable;
    private Loading load ;
    private VerticalPanel verticalPanel;
    
	public Sce_BuzonSolicitudLista() {
		
		this.listaFormulario = this;
		mensaje = new Mensaje();

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		initWidget(scrollPanel);
		
		scrollPanel.setSize("100%", "100%");
		
		verticalPanel = new VerticalPanel();
		scrollPanel.setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setSize("100%", "100%");
	}

    public void agregarFormulario(final char tipo, Long idEmpleado, Long idAfiliado, final Sce_BuzonSolicitud buscador, final String nombreSolicitante, 
    		final String solucionConstruir, final boolean valVisibilidad){

        load.visible();
        
        solucionesService.buscarFormulario(tipo, idEmpleado, idAfiliado,
        		nombreSolicitante, solucionConstruir,
        		new AsyncCallback<List<AuxSolicitudGeneral>>(){        	
        	
            public void onFailure(Throwable caught) 
            {
		        load.invisible();
            	mensaje.setMensaje("alert alert-information alert-block", 
            			"\nNo hay resultados");
               // Window.alert("No hay resultados "+caught);
            }

			@Override
            public void onSuccess( List<AuxSolicitudGeneral> result)
            {
				for(AuxSolicitudGeneral p : result) {
			        flexTable.setWidget(flexTable.getRowCount(), 0, 
			        					new Sce_BuzonSolicitudItem(buscador, listaFormulario, 
			        					p.getIdFormulario(), p.getNombreSolicitante(), p.getTelefonoCasaSolicitante(), p.getTelefonoTrabajoSolicitante(), 
			        					p.getSolucionConstruir(), valVisibilidad)
			        );
				}
		        load.invisible();
            }

     });

        load.invisible();
    }
    
    // Metodo no utilizado
    
//    public void EliminarFormulario(final Sce_BuzonSolicitudItem a){
//        load.visible();
//    	flexTable.remove(a);
//        load.invisible();
//    }
//    

}
