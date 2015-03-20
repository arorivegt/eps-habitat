package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudCargaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaSolidario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
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


public class Sce_DataEntryGarantiaSolidario extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryGarantiaSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
	 private Mensaje mensaje; 
	 private FlexTable flextable;
    
	public Sce_DataEntryGarantiaSolidario(Sce_DataEntryGarantiaSolicitud formulario) {
		
		mensaje = new Mensaje();
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
		
        Button btnAgregar = new Button("Agregar");
        panel.add(btnAgregar);
        
        btnAgregar.setStyleName("sendButton");
        btnAgregar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario();
        	}
        });
        
        btnAgregar.setSize("227px", "34px");

	}

    private void agregarFormulario(){
        flextable.setWidget(flextable.getRowCount(), 0, new Sce_DataGarantiaSolidario(this, formularioSolicitud));
    }
    
    public void EliminarFormulario(final Sce_DataGarantiaSolidario fa, final Long idFormulario, final Long id){

    	solucionesService.eliminarGarantiaSolidario(idFormulario, id, new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) 
            {
            	mensaje.setMensaje("alert alert-error", 
            			"Error !! \nal Eliminar");
            }

			@Override
            public void onSuccess(Long result)
            {
				mensaje.setMensaje("alert alert-success", 
            			"Eliminado\n exitosamente!!!");
    	        flextable.remove(fa);
            }

     });
		
    }
    
    public void EliminarFormulario(Sce_DataGarantiaSolidario fa){
    	        flextable.remove(fa);
    }
    
    
    public void setDataGarantiaSolidario(List<AuxSolicitudGarantiaSolidario> results){

    	//load.visible();
    	if (!results.isEmpty()) {

    		for ( AuxSolicitudGarantiaSolidario n2 : results) {

    			System.out.println("ID Garantia Grupo Solidario a Cargar: " + n2.getIdGarantiaSolidario() + ", ID Formulario: " + n2.getIdFormulario());
    			
    			Sce_DataGarantiaSolidario fa = new  Sce_DataGarantiaSolidario(this, formularioSolicitud);
    			
    			fa.LlenarDatos(n2.getIdGarantiaSolidario(), 
    					n2.getNombre(), n2.getEdad(), n2.getEscolaridad(), n2.getOcupacion());
    			
    			flextable.setWidget(flextable.getRowCount(), 0, fa );
    		
    		}


    		//load.invisible();

    	}
    }
    
    
}
