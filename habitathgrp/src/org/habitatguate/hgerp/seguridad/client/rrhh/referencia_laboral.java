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

public class referencia_laboral extends Composite  {

	 private FlexTable flextable;
	 private Empleados empleado;
     private VerticalPanel panel = new VerticalPanel();
     private final LoginServiceAsync loginService = GWT.create(LoginService.class);
		
	    public referencia_laboral(Empleados e) {

			this.empleado = e;
	        initWidget(panel);
	        panel.setSize("761px", "79px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        Button btnAgregar = new Button("Agregar");
	        panel.add(btnAgregar);
	        
	        btnAgregar.setStyleName("gwt-PasswordTextBox");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario();
	        	}
	        });
	        
	        btnAgregar.setWidth("246px");
		}
	    
	    private void agregarFormulario(){
	        flextable.setWidget(flextable.getRowCount(), 0, new formulario_referencia_laboral(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxReferenciaLaboral> results){
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxReferenciaLaboral n2 : results) {
			    	formulario_referencia_laboral fa = new  formulario_referencia_laboral(this,empleado);
			    	fa.LlenarDatos(n2.getId_referencia_laboral(),n2.getNombre_referencia(), n2.getEmpresa_referencia(), n2.getRecomiendo(),
			    				   n2.getMotivo_retiro(),n2.getActitudes_cualidades(), ""+n2.getTelefono(),
			    				   n2.getFecha1(), n2.getFecha2(), ""+n2.getSalario_final(), n2.getPuesto_candidato());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	    
	    }
	    
	    public void EliminarFormulario(final formulario_referencia_laboral fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Referencia_Laboral(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Error al ELiminar"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {
                	Window.alert("Eliminado exitosamente!!! "+id);
        	        flextable.remove(fa);
                }

         });
	    }
}
