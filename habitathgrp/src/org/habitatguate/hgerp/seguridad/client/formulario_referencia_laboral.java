package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;

public class formulario_referencia_laboral extends Composite {

	public formulario_referencia_laboral() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "200px");
		
		Label lblNivelAcademico = new Label("Nombre");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Telefono");
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
		
		Label lblParentesco = new Label("Puesto Candidato");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 279, 210);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 463, 210);
		btnEliminar.setSize("157px", "20px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnGuardar, 99, 210);
		btnGuardar.setSize("157px", "20px");
		
		Label lblAos = new Label("Periodo Labores");
		lblAos.setStyleName("label");
		absolutePanel.add(lblAos, 584, 10);
		lblAos.setSize("103px", "13px");
		
		Label lblAl = new Label("al");
		lblAl.setStyleName("label");
		absolutePanel.add(lblAl, 626, 35);
		lblAl.setSize("38px", "13px");
		
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
		
		Label lblEmpresa = new Label("Empresa");
		lblEmpresa.setStyleName("label");
		absolutePanel.add(lblEmpresa, 10, 54);
		lblEmpresa.setSize("192px", "13px");
		
		TextBox txtEmpresa = new TextBox();
		txtEmpresa.setStylePrimaryName("gwt-TextBox2");
		txtEmpresa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEmpresa, 10, 73);
		txtEmpresa.setSize("137px", "11px");
		
		Label lblMotivo = new Label("Motivo Retiro");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 107);
		lblMotivo.setSize("196px", "82px");
		
		TextBox txtSalario_Final = new TextBox();
		txtSalario_Final.setStylePrimaryName("gwt-TextBox2");
		txtSalario_Final.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSalario_Final, 190, 73);
		txtSalario_Final.setSize("137px", "11px");
		
		Label lblSalarioFinal = new Label("Salario  Final");
		lblSalarioFinal.setStyleName("label");
		absolutePanel.add(lblSalarioFinal, 190, 54);
		lblSalarioFinal.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Lo recomienda");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 374, 54);
		lblLoRecomienda.setSize("103px", "13px");
		
		ListBox listBox = new ListBox();
		listBox.addItem("Si");
		listBox.addItem("No");
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 374, 73);
		listBox.setSize("157px", "19px");
		
		TextArea txtMotivo_Retiro = new TextArea();
		txtMotivo_Retiro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtMotivo_Retiro, 10, 122);
		txtMotivo_Retiro.setSize("317px", "61px");
		
		TextArea txtActitudes = new TextArea();
		txtActitudes.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtActitudes, 374, 126);
		txtActitudes.setSize("318px", "61px");
		
		Label lblActitudescualidadesaptitudesObserv = new Label("Actitudes/cualidades/aptitudes observadas");
		lblActitudescualidadesaptitudesObserv.setStyleName("label");
		absolutePanel.add(lblActitudescualidadesaptitudesObserv, 374, 107);
		lblActitudescualidadesaptitudesObserv.setSize("338px", "13px");
	}
}
