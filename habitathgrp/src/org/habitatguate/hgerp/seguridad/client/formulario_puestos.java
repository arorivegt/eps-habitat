package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formulario_puestos extends Composite {

	private puestos a;
	private int id_puesto_empleado =0;
	public formulario_puestos(puestos a) {
		this.a = a;
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
		absolutePanel.add(btnActualizar, 68, 60);
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
		absolutePanel.add(btnEliminar, 252, 60);
		btnEliminar.setSize("157px", "20px");
		
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
		
		DateBox dateFecha = new DateBox();
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 190, 29);
		dateFecha.setSize("137px", "11px");
		
		DoubleBox txtSalario = new DoubleBox();
		txtSalario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSalario, 374, 29);
		txtSalario.setSize("117px", "11px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this);
    }
}
