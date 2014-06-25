package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;

public class formulario_referencia_personal extends Composite {

	public formulario_referencia_personal() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "150px");
		
		Label lblNivelAcademico = new Label("Nombre");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Telefono");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 190, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Puesto Candidato");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 190, 159);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 374, 159);
		btnEliminar.setSize("157px", "20px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnGuardar, 10, 159);
		btnGuardar.setSize("157px", "20px");
		
		TextBox txtNombre = new TextBox();
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombre, 10, 29);
		txtNombre.setSize("137px", "11px");
		
		TextBox textBox = new TextBox();
		textBox.setStylePrimaryName("gwt-TextBox2");
		textBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox, 190, 29);
		textBox.setSize("137px", "11px");
		
		TextBox txtPuesto_Candidato = new TextBox();
		txtPuesto_Candidato.setStylePrimaryName("gwt-TextBox2");
		txtPuesto_Candidato.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPuesto_Candidato, 374, 29);
		txtPuesto_Candidato.setSize("137px", "11px");
		
		Label lblEmpresa = new Label("Relacion");
		lblEmpresa.setStyleName("label");
		absolutePanel.add(lblEmpresa, 10, 54);
		lblEmpresa.setSize("192px", "13px");
		
		TextBox txtRelacion = new TextBox();
		txtRelacion.setStylePrimaryName("gwt-TextBox2");
		txtRelacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtRelacion, 10, 73);
		txtRelacion.setSize("137px", "11px");
		
		TextArea txtActitudes = new TextArea();
		txtActitudes.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtActitudes, 190, 73);
		txtActitudes.setSize("318px", "61px");
		
		Label lblActitudescualidadesaptitudesObserv = new Label("Actitudes/cualidades/aptitudes observadas");
		lblActitudescualidadesaptitudesObserv.setStyleName("label");
		absolutePanel.add(lblActitudescualidadesaptitudesObserv, 190, 54);
		lblActitudescualidadesaptitudesObserv.setSize("338px", "13px");
	}
}
