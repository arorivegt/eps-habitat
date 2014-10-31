package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaLaboral;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class referenciaLaboral extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleados empleado;
     private VerticalPanel panel = new VerticalPanel();
     private Loading load ;
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
		
	    public referenciaLaboral(Empleados e) {

			mensaje = new Mensaje();
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			this.empleado = e;
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
	        load.visible();
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioReferenciaLaboral(this,empleado));
	        load.invisible();
	    }
	    
	    public void agregarFormulario_lleno(List<AuxReferenciaLaboral> results){
	        load.visible();
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxReferenciaLaboral n2 : results) {
			    	formularioReferenciaLaboral fa = new  formularioReferenciaLaboral(this,empleado);
			    	fa.LlenarDatos(n2.getId_referencia_laboral(),n2.getNombre_referencia(), n2.getEmpresa_referencia(), n2.getRecomiendo(),
			    				   n2.getMotivo_retiro(),n2.getActitudes_cualidades(), ""+n2.getTelefono(),
			    				   n2.getFecha1(), n2.getFecha2(), ""+n2.getSalario_final(), n2.getPuesto_candidato());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	 
	        load.invisible();   
	    }
	    
	    public void EliminarFormulario(final formularioReferenciaLaboral fa, final Long id_empledo, final Long id){

	        load.visible();
			loginService.Eliminar_Referencia_Laboral(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
    		        load.invisible();
                	mensaje.setMensaje("alert alert-error", 
                			"Error !! \nal Eliminar");
                }

				@Override
                public void onSuccess(Long result)
                {
			        load.invisible();
					mensaje.setMensaje("alert alert-success", 
                			"Eliminado\n exitosamente!!!");
        	        flextable.remove(fa);
                }

         });
	        load.invisible();
	    }
	    public void EliminarFormulario(formularioReferenciaLaboral fa){
	        load.visible();
	        flextable.remove(fa);
	        load.invisible();
	    }
}
