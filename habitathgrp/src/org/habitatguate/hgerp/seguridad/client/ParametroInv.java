package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;

public class ParametroInv extends Composite{
	 private FlexTable flextable;
	private VerticalPanel panel = new VerticalPanel();
	
	public ParametroInv(){
		initWidget(panel);
		panel.setSize("761px", "236px");
		flextable = new FlexTable();
        panel.add(flextable);
        Button btnAgregar = new Button("Agregar");
        flextable.setWidget(0, 0, btnAgregar);
        
        btnAgregar.setStyleName("gwt-PasswordTextBox");
        btnAgregar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {

        	}
        });
        btnAgregar.setWidth("246px");
	}

}
