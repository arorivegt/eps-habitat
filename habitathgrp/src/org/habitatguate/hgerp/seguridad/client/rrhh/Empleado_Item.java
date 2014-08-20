package org.habitatguate.hgerp.seguridad.client.rrhh;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Empleado_Item extends Composite {

	private Empleado_Lista a;
	private Long id_empleado = 0L;
	private Buscador_Empleados BE;
	public Empleado_Item(Buscador_Empleados b, Empleado_Lista a,Long id_emplead, String primer_nombre, String segundo_nombre, 
			String primer_apellido, String segundo_apellido) {
		this.id_empleado = id_emplead;
		this.BE = b;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("889px", "10px");
		
		Label lblPrimerNombre = new Label("Primer Nombre");
		lblPrimerNombre.setStyleName("label");
		absolutePanel.add(lblPrimerNombre, 22, 0);
		lblPrimerNombre.setSize("192px", "13px");
		
		Label lblSegundoNombre = new Label("Segundo Nombre");
		lblSegundoNombre.setStyleName("label");
		absolutePanel.add(lblSegundoNombre, 190, 0);
		lblSegundoNombre.setSize("192px", "13px");
		
		TextBox txtSegundoNombre = new TextBox();
		txtSegundoNombre.setEnabled(false);
		txtSegundoNombre.setStyleName("gwt-TextBox2");
		txtSegundoNombre.setMaxLength(100);
		absolutePanel.add(txtSegundoNombre, 183, 20);
		txtSegundoNombre.setSize("137px", "11px");
		txtSegundoNombre.setText(segundo_nombre);
		
		TextBox txtPrimerApellido = new TextBox();
		txtPrimerApellido.setEnabled(false);
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		txtPrimerApellido.setMaxLength(100);
		absolutePanel.add(txtPrimerApellido, 346, 20);
		txtPrimerApellido.setSize("137px", "11px");
		txtPrimerApellido.setText(primer_apellido);
		
		TextBox txtPrimerNombre = new TextBox();
		txtPrimerNombre.setEnabled(false);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		txtPrimerNombre.setMaxLength(100);
		absolutePanel.add(txtPrimerNombre, 20, 20);
		txtPrimerNombre.setSize("137px", "11px");
		txtPrimerNombre.setText(primer_nombre);

		TextBox txtSegundoApellido = new TextBox();
		txtSegundoApellido.setEnabled(false);
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		txtSegundoApellido.setMaxLength(100);
		absolutePanel.add(txtSegundoApellido, 510, 20);
		txtSegundoApellido.setSize("137px", "11px");
		txtSegundoApellido.setText(segundo_apellido);
	
		Label lblPrimerApellido = new Label("Primer Apellido");
		lblPrimerApellido.setStyleName("label");
		absolutePanel.add(lblPrimerApellido, 349, 0);
		lblPrimerApellido.setSize("192px", "13px");
		
		Label lblSegundoApellido = new Label("Segundo Apellido");
		lblSegundoApellido.setStyleName("label");
		absolutePanel.add(lblSegundoApellido, 517, 0);
		lblSegundoApellido.setSize("192px", "13px");
		
		Button button_2 = new Button("Send");
		button_2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				BE.Empleado_registrado(id_empleado);
			}
		});
		button_2.setText("Editar");
		button_2.setStylePrimaryName("gwt-TextBox2");
		button_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(button_2, 675, 19);
		button_2.setSize("84px", "20px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormulario();
			}
		});
		button.setText("Eliminar");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("gwt-TextBox2");
		absolutePanel.add(button, 764, 19);
		button.setSize("84px", "20px");
		
	}
	
	private void EliminarFormulario(){
        a.EliminarFormulario(this);
	}

}
