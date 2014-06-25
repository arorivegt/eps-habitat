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
		
		TextBox txtfecha_inicia = new TextBox();
		txtfecha_inicia.setStylePrimaryName("gwt-TextBox2");
		txtfecha_inicia.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtfecha_inicia, 555, 29);
		txtfecha_inicia.setSize("45px", "11px");
		
		TextBox txtfecha_final = new TextBox();
		txtfecha_final.setStylePrimaryName("gwt-TextBox2");
		txtfecha_final.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtfecha_final, 647, 29);
		txtfecha_final.setSize("45px", "11px");
		
		Label lblParentesco = new Label("Establecimiento");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 190, 63);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 374, 63);
		btnEliminar.setSize("157px", "20px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnGuardar, 10, 63);
		btnGuardar.setSize("157px", "20px");
		
		ListBox listNIvel_Academico = new ListBox();
		listNIvel_Academico.addItem("primaria");
		listNIvel_Academico.addItem("basicos");
		listNIvel_Academico.addItem("diversificado");
		listNIvel_Academico.addItem("universidad");
		listNIvel_Academico.addItem("maestria");
		listNIvel_Academico.addItem("Diploma");
		listNIvel_Academico.addItem("otro");
		listNIvel_Academico.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNIvel_Academico, 10, 29);
		listNIvel_Academico.setSize("157px", "19px");
		
		ListBox listTitulo_Diploma = new ListBox();
		listTitulo_Diploma.addItem("6to. primaria");
		listTitulo_Diploma.addItem("3ro. basico");
		listTitulo_Diploma.addItem("Ingeniero civil");
		listTitulo_Diploma.addItem("Ingeniero ciencias y sistemas");
		listTitulo_Diploma.addItem("Arquitecto");
		listTitulo_Diploma.addItem("otro");
		listTitulo_Diploma.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTitulo_Diploma, 190, 29);
		listTitulo_Diploma.setSize("157px", "19px");
		
		ListBox listEstablecimiento = new ListBox();
		listEstablecimiento.addItem("Universidad de San Carlos");
		listEstablecimiento.addItem("Universidad Marroquin");
		listEstablecimiento.addItem("Universidad del valle");
		listEstablecimiento.addItem("otro");
		listEstablecimiento.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstablecimiento, 374, 29);
		listEstablecimiento.setSize("157px", "19px");
		
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
