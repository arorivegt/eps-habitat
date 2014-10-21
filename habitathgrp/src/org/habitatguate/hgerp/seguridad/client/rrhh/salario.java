/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class salario extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleados empleado;
	 private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     private Button btnAgregar;
		
	    public salario(Empleados e) {

			mensaje = new Mensaje();
			this.empleado = e;
	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        
	        btnAgregar = new Button("Agregar");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario("Comision");
	        	}
	        });
	        btnAgregar.setText("Agregar");
	        btnAgregar.setStyleName("sendButton");
	        panel.add(btnAgregar);
	        btnAgregar.setSize("227px", "34px");
		}
	    
	    private void agregarFormulario(String tipo){
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioSalario(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxSalario> results){
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxSalario n2 : results) 
			    {
			    	formularioSalario fa = new  formularioSalario(this,empleado);
			    	fa.LlenarDatos(n2.getId_Salario(), ""+n2.getSalario(),n2.getFecha(), n2.getTipoSalario(),n2.getDescripcion());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	
	    	
	    }
	    
	    public void EliminarFormulario(final formularioSalario fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Salario(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                	mensaje.setMensaje("alert alert-error", "Error !! \nal Eliminar");
                }

				@Override
                public void onSuccess(Long result)
                {
					mensaje.setMensaje("alert alert-success", "Eliminado\n exitosamente!!!");
        	        flextable.remove(fa);
                }

         });
	    }
	    
	    public void EliminarFormulario(formularioSalario fa){
        	flextable.remove(fa);
	    }
}
