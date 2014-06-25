package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;

public class formulario_puestos extends Composite {

	public formulario_puestos() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "50px");
		
		Label lblNivelAcademico = new Label("Puesto");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Fecha");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 190, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Salario");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 190, 64);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 374, 64);
		btnEliminar.setSize("157px", "20px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnGuardar, 10, 64);
		btnGuardar.setSize("157px", "20px");
		
		TextBox txtFecha = new TextBox();
		txtFecha.setStylePrimaryName("gwt-TextBox2");
		txtFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtFecha, 190, 29);
		txtFecha.setSize("137px", "11px");
		
		TextBox txtSalario = new TextBox();
		txtSalario.setStylePrimaryName("gwt-TextBox2");
		txtSalario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSalario, 374, 29);
		txtSalario.setSize("137px", "11px");
		
		ListBox listPuesto = new ListBox();
		listPuesto.addItem("Coordinador Finanzas");
		listPuesto.addItem("RRHH");
		listPuesto.addItem("otro");
		listPuesto.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPuesto, 10, 29);
		listPuesto.setSize("157px", "19px");
		
		ListBox listActivo = new ListBox();
		listActivo.addItem("Si");
		listActivo.addItem("No");
		listActivo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listActivo, 551, 29);
		listActivo.setSize("157px", "19px");
		
		Label lblActivo = new Label("Activo");
		lblActivo.setStyleName("label");
		absolutePanel.add(lblActivo, 550, 10);
		lblActivo.setSize("192px", "13px");
	}
}
