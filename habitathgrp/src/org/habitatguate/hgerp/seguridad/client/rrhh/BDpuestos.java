package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BDpuestos extends Composite  {
	     private ScrollPanel scrollPanel;
	     private VerticalPanel verticalPanel;
	     private FlexTable flextable;
	     private Button button;
	     private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	     private BDpuestos a;
	    public BDpuestos() {
			a = this;
			scrollPanel = new ScrollPanel();
			initWidget(scrollPanel);
			scrollPanel.setSize("900px", "489px");
			
			verticalPanel = new VerticalPanel();
			scrollPanel.setWidget(verticalPanel);
			verticalPanel.setSize("877px", "93px");
			
			flextable = new FlexTable();
			verticalPanel.add(flextable);
			flextable.setSize("869px", "80px");
			
			button = new Button("Agregar");
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					agregarFormulario();
				}
			});
			verticalPanel.add(button);
			button.setStyleName("gwt-PasswordTextBox");
			button.setWidth("246px");
			agregarFormulario_lleno();
		}
	    
	    public void agregarFormulario_lleno(){
	    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
	    		public void onFailure(Throwable caught) 
	    		{
	    			Window.alert("Error en BD puestos"+caught);
	    		}

				@Override
				public void onSuccess(List<AuxBDPuesto> results)
				{
					if (!results.isEmpty()) {
			    		
					    for ( AuxBDPuesto n2 : results) {
					    	formularioBDPuestos fa = new  formularioBDPuestos(a);
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
