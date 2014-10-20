package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaPersonal;
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

public class referenciaPersonal extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleados empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
		
	    public referenciaPersonal(Empleados e) {

			mensaje = new Mensaje();
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
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioReferenciaPersonal(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxReferenciaPersonal> results){
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxReferenciaPersonal n2 : results) {
			    	formularioReferenciaPersonal fa = new  formularioReferenciaPersonal(this,empleado);
			    	fa.LlenarDatos( n2.getId_referencia_personal(), n2.getNombre_referencia(), n2.getPuesto_candidato(), n2.getRelacion(),
			    					n2.getActitudes_cualidades(), ""+n2.getTelefono());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	    
	    }
	    
	    public void EliminarFormulario(final formularioReferenciaPersonal fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Referencia_Personal(id_empledo, id, new AsyncCallback<Long>(){
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
	    
	    public void EliminarFormulario(formularioReferenciaPersonal fa){
	    		flextable.remove(fa);
	 	}
}
