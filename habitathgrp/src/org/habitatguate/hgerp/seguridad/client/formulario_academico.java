package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;

public class formulario_academico extends Composite {

	public formulario_academico() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "50px");
		
		Label lblNivelAcademico = new Label("Nivel Academico");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Titulo/Diploma");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 190, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		TextBox primer_nombre = new TextBox();
		primer_nombre.setStylePrimaryName("gwt-TextBox2");
		primer_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(primer_nombre, 555, 29);
		primer_nombre.setSize("45px", "11px");
		
		TextBox segundo_nombre = new TextBox();
		segundo_nombre.setStylePrimaryName("gwt-TextBox2");
		segundo_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(segundo_nombre, 647, 29);
		segundo_nombre.setSize("45px", "11px");
		
		Label lblParentesco = new Label("Establecimiento");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Button actualizar = new Button("Send");
		actualizar.setText("Actualizar");
		actualizar.setStylePrimaryName("gwt-TextBox2");
		actualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(actualizar, 190, 63);
		actualizar.setSize("157px", "20px");
		
		Button eliminar = new Button("Send");
		eliminar.setText("Eliminar");
		eliminar.setStylePrimaryName("gwt-TextBox2");
		eliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(eliminar, 374, 63);
		eliminar.setSize("157px", "20px");
		
		Button Guardar = new Button("Send");
		Guardar.setText("Guardar");
		Guardar.setStylePrimaryName("gwt-TextBox2");
		Guardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(Guardar, 10, 63);
		Guardar.setSize("157px", "20px");
		
		ListBox listBox = new ListBox();
		listBox.addItem("primaria");
		listBox.addItem("basicos");
		listBox.addItem("diversificado");
		listBox.addItem("universidad");
		listBox.addItem("maestria");
		listBox.addItem("Diploma");
		listBox.addItem("otro");
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 29);
		listBox.setSize("157px", "19px");
		
		ListBox listBox_1 = new ListBox();
		listBox_1.addItem("6to. primaria");
		listBox_1.addItem("3ro. basico");
		listBox_1.addItem("Ingeniero civil");
		listBox_1.addItem("Ingeniero ciencias y sistemas");
		listBox_1.addItem("Arquitecto");
		listBox_1.addItem("otro");
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 190, 29);
		listBox_1.setSize("157px", "19px");
		
		ListBox listBox_2 = new ListBox();
		listBox_2.addItem("Universidad de San Carlos");
		listBox_2.addItem("Universidad Marroquin");
		listBox_2.addItem("Universidad del valle");
		listBox_2.addItem("otro");
		listBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_2, 374, 29);
		listBox_2.setSize("157px", "19px");
		
		Label lblAos = new Label("Fecha inicio y final");
		lblAos.setStyleName("label");
		absolutePanel.add(lblAos, 584, 10);
		lblAos.setSize("103px", "13px");
		
		Label lblAl = new Label("al");
		lblAl.setStyleName("label");
		absolutePanel.add(lblAl, 626, 35);
		lblAl.setSize("38px", "13px");
	}

}
