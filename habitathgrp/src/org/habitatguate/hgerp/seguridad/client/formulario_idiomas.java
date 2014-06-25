package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;

public class formulario_idiomas extends Composite {

	public formulario_idiomas() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "20px");
		
		Label lblNivelAcademico = new Label("Idioma");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Nivel");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 160, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 416, 29);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 585, 29);
		btnEliminar.setSize("157px", "20px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnGuardar, 253, 29);
		btnGuardar.setSize("157px", "20px");
		
		ListBox listIdioma = new ListBox();
		listIdioma.addItem("Ingles");
		listIdioma.addItem("Aleman");
		listIdioma.addItem("Frances");
		listIdioma.addItem("otro");
		listIdioma.setStyleName("gwt-TextBox2");
		absolutePanel.add(listIdioma, 10, 29);
		listIdioma.setSize("137px", "19px");
		
		ListBox listNIvel = new ListBox();
		listNIvel.addItem("Avanzado");
		listNIvel.addItem("Intermedio");
		listNIvel.addItem("Principiante");
		listNIvel.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNIvel, 160, 29);
		listNIvel.setSize("87px", "19px");
	}

}
