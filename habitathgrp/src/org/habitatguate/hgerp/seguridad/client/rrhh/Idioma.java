package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Idioma extends Composite  {

	 private FlexTable flextable;
	 private Empleados empleado;
		private VerticalPanel panel = new VerticalPanel();
	     private final LoginServiceAsync loginService = GWT.create(LoginService.class);
		
	    public Idioma(Empleados e) {

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
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioIdiomas(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxIdioma> results){
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxIdioma n2 : results) {
			    	formularioIdiomas fa = new  formularioIdiomas(this,empleado);
			    	fa.LlenarDatos(n2.getId_idioma(),n2.getNivel(),n2.getIdioma(), n2.getURLFile(), n2.getKeyFile());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	    
	    }
	    
	    public void EliminarFormulario(final formularioIdiomas fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Idioma(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Error al ELiminar"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {
                	Window.alert("Eliminado exitosamente!!! ");
        	        flextable.remove(fa);
                }

         });
	    }
	    
	    public void EliminarFormulario(formularioIdiomas fa){
        	        flextable.remove(fa);
	    }
}
