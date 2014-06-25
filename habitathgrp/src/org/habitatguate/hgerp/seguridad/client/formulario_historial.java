package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;

public class formulario_historial extends Composite {

	public formulario_historial() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("534px", "140px");
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 380, 71);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 380, 107);
		btnEliminar.setSize("157px", "20px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnGuardar, 380, 29);
		btnGuardar.setSize("157px", "20px");
		
		TextBox txtNombre = new TextBox();
		txtNombre.setMaxLength(500);
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombre, 10, 29);
		txtNombre.setSize("137px", "11px");
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 56);
		lblMotivo.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Tipo ");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 173, 10);
		lblLoRecomienda.setSize("103px", "13px");
		
		ListBox listBox = new ListBox();
		listBox.addItem("permisos");
		listBox.addItem("ausencias");
		listBox.addItem("aciertos ");
		listBox.addItem("llamadas de atención");
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 173, 29);
		listBox.setSize("157px", "19px");
		
		TextArea txtMotivo_Retiro = new TextArea();
		txtMotivo_Retiro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtMotivo_Retiro, 10, 71);
		txtMotivo_Retiro.setSize("317px", "61px");
	}
}
