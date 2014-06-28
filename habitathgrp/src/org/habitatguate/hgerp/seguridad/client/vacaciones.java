package org.habitatguate.hgerp.seguridad.client;

import javax.jdo.PersistenceManager;

import org.habitatguate.hgerp.seguridad.service.seg_usuario;
import org.habitatguate.hgerp.util.PMF;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class vacaciones extends Composite  {

	 private FlexTable flextable;
		private VerticalPanel panel = new VerticalPanel();
		
	    public vacaciones() {

	        initWidget(panel);
	        panel.setSize("761px", "85px");
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
	        flextable.setWidget(flextable.getRowCount(), 0, new formulario_vacaciones(this));
	    }
	    public void EliminarFormulario(formulario_vacaciones fa){
	        flextable.remove(fa);
	    }
	    

}
