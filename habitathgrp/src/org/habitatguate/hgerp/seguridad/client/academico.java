package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class academico extends Composite  {

	 private FlexTable flextable;
		private VerticalPanel panel = new VerticalPanel();
		
	    public academico() {

	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        Button Agregar_pariente = new Button("Agregar");
	        panel.add(Agregar_pariente);
	        
	        Agregar_pariente.setStyleName("gwt-PasswordTextBox");
	        Agregar_pariente.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario();
	        	}
	        });
	        
	        Agregar_pariente.setWidth("246px");
		}
	    
	    private void agregarFormulario(){
	        flextable.setWidget(flextable.getRowCount(), 0, new formulario_academico());
	    }
}
