package org.habitatguate.hgerp.seguridad.client;


import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class Buscador_Empleados extends Composite  {
	
	private DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);

    
	public Buscador_Empleados() {

		initWidget(dockLayoutPanel);
		dockLayoutPanel.setSize("1500px", "800px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		dockLayoutPanel.addNorth(absolutePanel, 6.2);
		absolutePanel.setSize("1000px", "20px");
		
		Label label = new Label("Primer Apellido");
		label.setStyleName("label");
		absolutePanel.add(label, 10, 10);
		label.setSize("157px", "13px");
		
		Label label_1 = new Label("Segundo Apellido");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 173, 10);
		label_1.setSize("192px", "13px");
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(100);
		absolutePanel.add(textBox, 10, 29);
		textBox.setSize("137px", "11px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(100);
		absolutePanel.add(textBox_1, 173, 29);
		textBox_1.setSize("137px", "11px");
		
		Label label_2 = new Label("Primer Nombre");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 337, 15);
		label_2.setSize("157px", "19px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setStylePrimaryName("gwt-TextBox2");
		textBox_2.setStyleName("gwt-TextBox2");
		textBox_2.setMaxLength(100);
		absolutePanel.add(textBox_2, 337, 29);
		textBox_2.setSize("137px", "11px");
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setStylePrimaryName("gwt-TextBox2");
		textBox_3.setStyleName("gwt-TextBox2");
		textBox_3.setMaxLength(100);
		absolutePanel.add(textBox_3, 500, 29);
		textBox_3.setSize("137px", "11px");
		
		Label label_3 = new Label("2do y Demás Nombres");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 500, 15);
		label_3.setSize("157px", "13px");

        
		Image image = new Image("images/ico-lupa.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				Window.alert("buscador");
			}
		});
		absolutePanel.add(image, 639, 10);
		image.setSize("103px", "55px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        Empleados e = new Empleados();
				dockLayoutPanel.add(e);
		        e.setSize("1187px", "648px");
			}
		});
		button.setText("Nuevo Empleado");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("gwt-TextBox2");
		absolutePanel.add(button, 730, 29);
		button.setSize("157px", "20px");
		
		// TODO Auto-generated constructor stub
	}
	
}
