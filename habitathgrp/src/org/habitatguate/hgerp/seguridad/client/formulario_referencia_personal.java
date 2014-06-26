package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formulario_referencia_personal extends Composite {

	private referencia_personal a;
	private int id_referencia_personal =0;
	public formulario_referencia_personal(referencia_personal a) {
		this.a = a;
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
		absolutePanel.add(btnActualizar, 71, 160);
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
		absolutePanel.add(btnEliminar, 255, 160);
		btnEliminar.setSize("157px", "20px");
		
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
		
		Label lblEmpresa = new Label("Relacion");
		lblEmpresa.setStyleName("label");
		absolutePanel.add(lblEmpresa, 10, 54);
		lblEmpresa.setSize("192px", "13px");
		
		TextBox txtRelacion = new TextBox();
		txtRelacion.setMaxLength(100);
		txtRelacion.setStylePrimaryName("gwt-TextBox2");
		txtRelacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtRelacion, 10, 73);
		txtRelacion.setSize("137px", "11px");
		
		TextArea txtActitudes = new TextArea();
		txtActitudes.getElement().setAttribute("maxlength", "500");
		txtActitudes.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtActitudes, 190, 73);
		txtActitudes.setSize("318px", "61px");
		
		Label lblActitudescualidadesaptitudesObserv = new Label("Actitudes/cualidades/aptitudes observadas");
		lblActitudescualidadesaptitudesObserv.setStyleName("label");
		absolutePanel.add(lblActitudescualidadesaptitudesObserv, 190, 54);
		lblActitudescualidadesaptitudesObserv.setSize("338px", "13px");
		
		IntegerBox integerBox = new IntegerBox();
		integerBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox, 190, 29);
		integerBox.setSize("137px", "11px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this);
    }
}
