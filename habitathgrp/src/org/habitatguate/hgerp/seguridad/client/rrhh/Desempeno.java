package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
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
import com.google.gwt.user.client.ui.Grid;

public class Desempeno extends Composite  {

	 private FlexTable flextable;
	 private Empleados empleado;
     private VerticalPanel panel = new VerticalPanel();
     private final LoginServiceAsync loginService = GWT.create(LoginService.class);
     private List<AuxTest> valor = new ArrayList<AuxTest>();
     private final Button btnTest = new Button("Agregar");
     private final Grid grid = new Grid(1, 3);
	    public Desempeno(Empleados e) {

			this.empleado = e;
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        
	        panel.add(grid);
	        grid.setWidget(0, 0, btnTest);
	        btnTest.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregar_formularios(valor);
	        	}
	        });
	        btnTest.setText("Ver Test");
	        btnTest.setStyleName("gwt-PasswordTextBox");
	        btnTest.setWidth("246px");
	        Button btnAgregar = new Button("Agregar");
	        grid.setWidget(0, 2, btnAgregar);
	        
	        btnAgregar.setStyleName("gwt-PasswordTextBox");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario();
	        	}
	        });
	        
	        btnAgregar.setWidth("246px");
		}
	    
	    private void agregarFormulario(){
	    	flextable.clear();
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioPruebaPeriodo(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(AuxTest n){
	    	flextable.clear();
	    	if (!n.equals(null)) {
			    	formularioPruebaPeriodo  fa = new formularioPruebaPeriodo(this,empleado);
					fa.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
							""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
							""+n.getPregunta10(), n.getEvaluador(), n.getFecha_test());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    	}	    
	    }
	    
	    public void agregar_formularios(List<AuxTest> results){
	    	flextable.clear();
	    	if (!(results.size() == 0)) {
	    		valor = results;
			    for (AuxTest n : results) {
			    	formularioDesempeno de = new formularioDesempeno(this, n);
			    	flextable.setWidget(flextable.getRowCount(), 0,de);
			    }
			}			    
	    }
	    
	    public void EliminarFormulario(final formularioPruebaPeriodo fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Test(id_empledo, id, new AsyncCallback<Long>(){
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
	    public void EliminarFormulario(formularioPruebaPeriodo fa){
	    	flextable.remove(fa);
	    }
	    
}
