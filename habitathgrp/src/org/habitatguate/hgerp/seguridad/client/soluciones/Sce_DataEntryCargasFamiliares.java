package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudCargaFamiliar;
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


public class Sce_DataEntryCargasFamiliares extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryFormularioSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
	 private Mensaje mensaje; 
	 private FlexTable flextable;
    
	public Sce_DataEntryCargasFamiliares(Sce_DataEntryFormularioSolicitud formulario) {
		
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
        flextable.setWidget(flextable.getRowCount(), 0, new Sce_DataCargasFamiliares(this, formularioSolicitud));
    }
    
    public void EliminarFormulario(final Sce_DataCargasFamiliares fa, final Long idFormulario, final Long id){

    	solucionesService.eliminarCargaFamiliar(idFormulario, id, new AsyncCallback<Long>(){
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
    
    public void EliminarFormulario(Sce_DataCargasFamiliares fa){
    	        flextable.remove(fa);
    }
    
    
    public void setDataCargasFamiliares(List<AuxSolicitudCargaFamiliar> results){

    	//load.visible();
    	if (!results.isEmpty()) {

    		for ( AuxSolicitudCargaFamiliar n2 : results) {

    			System.out.println("ID Carga Familiar a Cargar: " + n2.getIdCargaFamiliar() + ", ID Formulario: " + n2.getIdFormulario());
    			
    			Sce_DataCargasFamiliares fa = new  Sce_DataCargasFamiliares(this, formularioSolicitud);
    			
    			fa.LlenarDatos(n2.getIdCargaFamiliar(), 
    					n2.getNombreFamiliar(), n2.getEdadFamiliar(), n2.getEscolaridadFamiliar(), n2.getOcupacionFamiliar());
    			
    			flextable.setWidget(flextable.getRowCount(), 0, fa );
    		
    		}


    		//load.invisible();

    	}
    }
    
    
}
