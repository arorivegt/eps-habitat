package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formulario_referencia_laboral extends Composite {

	private referencia_laboral a;
	private int id_referencia_laboral =0;
	public formulario_referencia_laboral(referencia_laboral a) {
		this.a = a;
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
		
		Label lblParentesco = new Label("Puesto Candidato");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 166, 210);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormulario();
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 350, 210);
		btnEliminar.setSize("157px", "20px");
		
		Label lblAos = new Label("Periodo Labores");
		lblAos.setStyleName("label");
		absolutePanel.add(lblAos, 584, 10);
		lblAos.setSize("103px", "13px");
		
		TextBox txtNombre = new TextBox();
		txtNombre.setMaxLength(200);
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombre, 10, 29);
		txtNombre.setSize("137px", "11px");
		
		TextBox txtPuesto_Candidato = new TextBox();
		txtPuesto_Candidato.setMaxLength(200);
		txtPuesto_Candidato.setStylePrimaryName("gwt-TextBox2");
		txtPuesto_Candidato.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPuesto_Candidato, 374, 29);
		txtPuesto_Candidato.setSize("137px", "11px");
		
		Label lblEmpresa = new Label("Empresa");
		lblEmpresa.setStyleName("label");
		absolutePanel.add(lblEmpresa, 10, 54);
		lblEmpresa.setSize("192px", "13px");
		
		TextBox txtEmpresa = new TextBox();
		txtEmpresa.setMaxLength(100);
		txtEmpresa.setStylePrimaryName("gwt-TextBox2");
		txtEmpresa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEmpresa, 10, 73);
		txtEmpresa.setSize("137px", "11px");
		
		Label lblMotivo = new Label("Motivo Retiro");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 107);
		lblMotivo.setSize("196px", "82px");
		
		Label lblSalarioFinal = new Label("Salario  Final");
		lblSalarioFinal.setStyleName("label");
		absolutePanel.add(lblSalarioFinal, 190, 54);
		lblSalarioFinal.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Lo recomienda");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 374, 54);
		lblLoRecomienda.setSize("103px", "13px");
		
		ListBox listRecomienda = new ListBox();
		listRecomienda.addItem("Si");
		listRecomienda.addItem("No");
		listRecomienda.setStyleName("gwt-TextBox2");
		absolutePanel.add(listRecomienda, 374, 73);
		listRecomienda.setSize("157px", "19px");
		
		TextArea txtMotivo_Retiro = new TextArea();
		txtMotivo_Retiro.getElement().setAttribute("maxlength", "500");
		txtMotivo_Retiro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtMotivo_Retiro, 10, 122);
		txtMotivo_Retiro.setSize("317px", "61px");
		
		TextArea txtActitudes = new TextArea();
		txtActitudes.getElement().setAttribute("maxlength", "500");
		txtActitudes.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtActitudes, 374, 126);
		txtActitudes.setSize("318px", "61px");
		
		Label lblActitudescualidadesaptitudesObserv = new Label("Actitudes/cualidades/aptitudes observadas");
		lblActitudescualidadesaptitudesObserv.setStyleName("label");
		absolutePanel.add(lblActitudescualidadesaptitudesObserv, 374, 107);
		lblActitudescualidadesaptitudesObserv.setSize("338px", "13px");
		
		IntegerBox integerBox = new IntegerBox();
		integerBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox, 190, 29);
		integerBox.setSize("137px", "11px");
		
		DateBox dateFecha1 = new DateBox();
		dateFecha1.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha1.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha1, 548, 29);
		dateFecha1.setSize("50px", "11px");
		
		DateBox dateFecha2 = new DateBox();
		dateFecha2.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha2.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha2, 643, 29);
		dateFecha2.setSize("50px", "11px");
		
		Label label = new Label("al");
		label.setStyleName("label");
		absolutePanel.add(label, 624, 35);
		label.setSize("38px", "13px");
		
		DoubleBox txtSalarioFinal = new DoubleBox();
		txtSalarioFinal.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSalarioFinal, 189, 73);
		txtSalarioFinal.setSize("138px", "11px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this);
    }
}
