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

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaSolidario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;

public class Sce_BuzonGarantiaLista extends Composite {

	private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Mensaje mensaje; 
    private Sce_BuzonGarantiaLista listaFormulario;
    private FlexTable flexTable;
    private Loading load ;
    private VerticalPanel verticalPanel;
    
    private boolean garantiaHipotecariaExistente = false;
    private boolean garantiaFiduciariaExistente = false;
    private boolean garantiaGrupoSolidarioExistente = false;
    
	public Sce_BuzonGarantiaLista() {
		
		this.listaFormulario =this;
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

    public void agregarFormulario(final char tipo, Long idEmpleado, Long idAfiliado, final Sce_BuzonGarantia buscador, String nombreSolicitante, 
    		String solucionConstruir, final boolean valVisibilidad){

        load.visible();
        
        solucionesService.buscarFormulario(tipo, idEmpleado, idAfiliado, nombreSolicitante, solucionConstruir, new AsyncCallback<List<AuxSolicitudGeneral>>(){        	
        	
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
            		
            		if(dataGarantiaHipotecaria(p.getGarantiaHipotecaria())) {
            			garantiaHipotecariaExistente = true;
            			System.out.println("SI existe Data de Garantia Hipotecaria");
            			
            		}else{
            			garantiaHipotecariaExistente = false;
            			System.out.println("NO existe Data de Garantia Hipotecaria");
            		}
            		
            		if(dataGarantiaFiduciaria(p.getGarantiaFiduciaria())) {
            			garantiaFiduciariaExistente = true;
            			System.out.println("SI existe Data de Garantia Fiduciaria");
            		}else{
            			garantiaFiduciariaExistente = false;
            			System.out.println("NO existe Data de Garantia Fiduciaria");
            		}
            		
            		if(dataGarantiaGrupoSolidario(p.getGarantiaSolidario())) {
            			garantiaGrupoSolidarioExistente = true;
            			System.out.println("SI existe Data de Garantia Grupo Solidario");
            		}else{
            			garantiaGrupoSolidarioExistente = false;
            			System.out.println("NO existe Data de Garantia Grupo Solidario");
            		}

            		flexTable.setWidget(flexTable.getRowCount(), 0, 
            				new Sce_BuzonGarantiaItem(buscador, listaFormulario, 
            						p.getIdFormulario(), p.getNombreSolicitante(), 
            						p.getTelefonoCasaSolicitante(), p.getTelefonoTrabajoSolicitante(), 
            						p.getSolucionConstruir(),
            						garantiaHipotecariaExistente, garantiaFiduciariaExistente, garantiaGrupoSolidarioExistente,
            						valVisibilidad)
            				);
            	}
				
				
		        load.invisible();
            }

     });

        load.invisible();
    }
    
    public void EliminarFormulario(final Sce_BuzonSolicitudItem a){
        load.visible();
    	flexTable.remove(a);
        load.invisible();
    }
    
    // VALIDACION EXISTENCIA GARANTIAS
    
    
    public boolean dataGarantiaHipotecaria(List<AuxSolicitudGarantiaHipotecaria> results) {

    	if (!results.isEmpty()) {
    		return true;
    	}

    	return false;
    }
    
    public boolean dataGarantiaFiduciaria(List<AuxSolicitudGarantiaFiduciaria> results) {

    	if (!results.isEmpty()) {
    		return true;
    	}

    	return false;
    }
 
    public boolean dataGarantiaGrupoSolidario(List<AuxSolicitudGarantiaSolidario> results) {

    	if (!results.isEmpty()) {
    		return true;
    	}

    	return false;
    }
    

}
