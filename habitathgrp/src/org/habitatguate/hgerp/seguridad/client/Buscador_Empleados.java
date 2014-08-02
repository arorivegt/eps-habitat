package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Grid;

public class Buscador_Empleados extends Composite  {

    
	public Buscador_Empleados() {
		
		final Grid grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "20px");
		absolutePanel.setStyleName("gwt-Label-new");
		
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
		absolutePanel.add(image, 639, 10);
		image.setSize("103px", "55px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				grid.clearCell(1, 0);
				Empleados e = new Empleados();
				grid.setWidget(1, 0,e);
		        e.setSize("1187px", "648px");
			}
		});
		button.setText("Nuevo Empleado");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("gwt-TextBox2");
		absolutePanel.add(button, 730, 29);
		button.setSize("157px", "20px");
		
		SimplePanel simplePanel = new SimplePanel();
		grid.setWidget(1, 0, simplePanel);
		simplePanel.setSize("1184px", "716px");
		
		// TODO Auto-generated constructor stub
	}
	
}
