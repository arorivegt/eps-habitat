package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;

public class BDpuestos extends Composite  {

     private BDpuestos a;
	 private FlexTable flextable;
     private VerticalPanel panel = new VerticalPanel();
     private final LoginServiceAsync loginService = GWT.create(LoginService.class);
     private final Button btnTest = new Button("Agregar");
     private final Grid grid = new Grid(1, 3);
     
	    public BDpuestos() {

	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        
	        panel.add(grid);
	        grid.setWidget(0, 0, btnTest);
	        btnTest.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario_lleno();
	        	}
	        });
	        btnTest.setText("Ver Puestos");
	        btnTest.setStyleName("sendButton");
	        btnTest.setSize("227px", "34px");
	        Button btnAgregar = new Button("Agregar");
	        grid.setWidget(0, 2, btnAgregar);
	        
	        btnAgregar.setStyleName("sendButton");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario();
	        	}
	        });
	        
	        btnAgregar.setSize("227px", "34px");
		}
	    
	    public void agregarFormulario_lleno(){
	    	flextable.clear();
	    	final formularioBDPuestos fa = new  formularioBDPuestos(a);
	    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
	    		public void onFailure(Throwable caught) 
	    		{
                	fa.setMensaje("alert alert-error", 
                			"Error !! \nen la base de datos\nde puestos");
	    			//Window.alert("Error en BD puestos"+caught);
	    		}

				@Override
				public void onSuccess(List<AuxBDPuesto> results)
				{
					if (results.size()!=0) {
			    		
					    for ( AuxBDPuesto n2 : results) {
					    	fa.LlenarDatos(n2.getId_puesto(),n2.getFecha_puesto(), n2.getNombre_puesto(),n2.getFunciones());
					    	flextable.setWidget(flextable.getRowCount(), 0,fa );
					    }
			    	}	
				}
			});
	    	
	    	    
	    }
	    
	    private void agregarFormulario(){
	    	flextable.setWidget(flextable.getRowCount(), 0, new formularioBDPuestos(this));
	    }
	    
	    public void EliminarFormulario(formularioBDPuestos fa){
	    	flextable.remove(fa);
		}
}
