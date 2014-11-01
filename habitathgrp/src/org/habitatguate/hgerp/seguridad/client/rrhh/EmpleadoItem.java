package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class EmpleadoItem extends Composite {

	private EmpleadoLista a;
	private Long id_empleado = 0L;
	private BuscadorEmpleados BE;
    private Loading load ;
	
	public EmpleadoItem(BuscadorEmpleados b, EmpleadoLista a,Long id_emplead, String primer_nombre, String segundo_nombre, 
			String primer_apellido, String segundo_apellido) {
		this.id_empleado = id_emplead;
		this.BE = b;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.setA(a);
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1097px", "20px");
		
		Label lblPrimerNombre = new Label("Primer Nombre");
		lblPrimerNombre.setStyleName("label");
		absolutePanel.add(lblPrimerNombre, 10, 0);
		lblPrimerNombre.setSize("192px", "13px");
		
		Label lblSegundoNombre = new Label("Segundo Nombre");
		lblSegundoNombre.setStyleName("label");
		absolutePanel.add(lblSegundoNombre, 245, 0);
		lblSegundoNombre.setSize("227px", "34px");
		
		TextBox txtSegundoNombre = new TextBox();
		txtSegundoNombre.setEnabled(false);
		txtSegundoNombre.setStyleName("gwt-TextBox2");
		txtSegundoNombre.setMaxLength(100);
		absolutePanel.add(txtSegundoNombre, 245, 20);
		txtSegundoNombre.setSize("227px", "34px");
		txtSegundoNombre.setText(segundo_nombre);
		
		TextBox txtPrimerApellido = new TextBox();
		txtPrimerApellido.setEnabled(false);
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		txtPrimerApellido.setMaxLength(100);
		absolutePanel.add(txtPrimerApellido, 478, 20);
		txtPrimerApellido.setSize("227px", "34px");
		txtPrimerApellido.setText(primer_apellido);
		
		TextBox txtPrimerNombre = new TextBox();
		txtPrimerNombre.setEnabled(false);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		txtPrimerNombre.setMaxLength(100);
		absolutePanel.add(txtPrimerNombre, 10, 20);
		txtPrimerNombre.setSize("227px", "34px");
		txtPrimerNombre.setText(primer_nombre);

		TextBox txtSegundoApellido = new TextBox();
		txtSegundoApellido.setEnabled(false);
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		txtSegundoApellido.setMaxLength(100);
		absolutePanel.add(txtSegundoApellido, 713, 20);
		txtSegundoApellido.setSize("227px", "34px");
		txtSegundoApellido.setText(segundo_apellido);
	
		Label lblPrimerApellido = new Label("Primer Apellido");
		lblPrimerApellido.setStyleName("label");
		absolutePanel.add(lblPrimerApellido, 478, -1);
		lblPrimerApellido.setSize("192px", "13px");
		
		Label lblSegundoApellido = new Label("Segundo Apellido");
		lblSegundoApellido.setStyleName("label");
		absolutePanel.add(lblSegundoApellido, 713, 0);
		lblSegundoApellido.setSize("192px", "13px");
		
		Button button_2 = new Button("Send");
		button_2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				BE.Empleado_registrado(id_empleado);
			}
		});
		button_2.setText("Editar");
		button_2.setStylePrimaryName("sendButton");
		button_2.setStyleName("sendButton");
		absolutePanel.add(button_2, 948, 22);
		button_2.setSize("205px", "34px");
		
	}
	public EmpleadoLista getA() {
		return a;
	}
	public void setA(EmpleadoLista a) {
		this.a = a;
	}

}
