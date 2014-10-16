package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVacaciones;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class vacaciones extends Composite  {

	 private FlexTable flextable;
	 private Empleados empleado;
		private VerticalPanel panel = new VerticalPanel();
	     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
		
	    public vacaciones(Empleados e) {

			this.empleado = e;
	        initWidget(panel);
	        panel.setSize("761px", "85px");
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
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioVacaciones(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxVacaciones> results){
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxVacaciones n2 : results) {
			    	formularioVacaciones fa = new  formularioVacaciones(this,empleado);
			    	fa.LlenarDatos(n2.getId_vacaciones(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	    
	    }
	    
	    public void EliminarFormulario(final formularioVacaciones fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Vacaciones(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                	fa.setMensaje("alert alert-error", 
                			"Error !! \nal Eliminar");
                }

				@Override
                public void onSuccess(Long result)
                {
                	fa.setMensaje("alert alert-success", 
                			"Eliminado\n exitosamente!!!");
        	        flextable.remove(fa);
                }

         });
	    }
	    
	    public void EliminarFormulario(formularioVacaciones fa){
        	        flextable.remove(fa);
	    }
	    

}
