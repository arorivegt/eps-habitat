package org.habitatguate.hgerp.seguridad.client;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class familiares extends Composite  {

	private Grid grid;
	private Empleados empleado;
    private FlexTable flextable;
	private Button btnAgregarHermanoa;
	private VerticalPanel panel = new VerticalPanel();
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	
    public familiares(Empleados e) {

		this.empleado = e;
        initWidget(panel);
        panel.setSize("761px", "381px");
        flextable = new FlexTable();
        panel.add(flextable);
        //se agrega padre, madre, conyugue
		agregarFormulario("padre");
		agregarFormulario("madre");
		agregarFormulario("conyugue");
        
        grid = new Grid(1, 3);
        panel.add(grid);
        Button btnAgregar_pariente = new Button("Agregar hijo(a)");
        grid.setWidget(0, 0, btnAgregar_pariente);
        
        btnAgregar_pariente.setStyleName("gwt-PasswordTextBox");
        btnAgregar_pariente.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario("hijo(a)");
        	}
        });
        
        btnAgregar_pariente.setWidth("246px");
        
        btnAgregarHermanoa = new Button("Agregar hermano(a)");
        grid.setWidget(0, 2, btnAgregarHermanoa);
        btnAgregarHermanoa.setStyleName("gwt-PasswordTextBox");
        btnAgregarHermanoa.setWidth("246px");
        btnAgregarHermanoa.setStyleName("gwt-PasswordTextBox");
        btnAgregarHermanoa.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario("hermano(a)");
        	}
        });
	}
    
    private void agregarFormulario(String pariente){
        flextable.setWidget(flextable.getRowCount(), 0, new formulario_familia(pariente,this,empleado));  	
    }
    
    public void agregarFormulario_lleno(List<AuxFamilia> results){
    	if (!results.isEmpty()) {
    		
		    for ( AuxFamilia n2 : results) {
		    	 formulario_familia fa = new  formulario_familia(n2.getParentesco(),this,empleado);
		    	  fa.LlenarDatos(n2.getId_familia(),n2.getPrimer_apellido(),n2.getSegundo_apellido(),n2.getPrimer_nombre(),
		    					 n2.getSegundo_nombre(),n2.getOcupacion(),n2.getParentesco(),""+n2.getEdad());
		        flextable.setWidget(flextable.getRowCount(), 0,fa );
		    }
    	}	    
    }
    
    public void EliminarFormulario(final formulario_familia fa, final Long id_empledo, final Long id){

		loginService.Eliminar_Familiar(id_empledo, id, new AsyncCallback<Long>(){
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
