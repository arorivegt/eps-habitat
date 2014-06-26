package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formulario_vacaciones extends Composite {

	private vacaciones a;
	private int id_vacaciones =0;
	public formulario_vacaciones(vacaciones a) {
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("534px", "140px");
		
		Label lblNivelAcademico = new Label("Fecha Inicial");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 377, 42);
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
		absolutePanel.add(btnEliminar, 377, 78);
		btnEliminar.setSize("157px", "20px");
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 56);
		lblMotivo.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Fecha Final");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 183, 10);
		lblLoRecomienda.setSize("103px", "13px");
		
		TextArea txtMotivo_Retiro = new TextArea();
		txtMotivo_Retiro.getElement().setAttribute("maxlength", "1000");
		txtMotivo_Retiro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtMotivo_Retiro, 10, 71);
		txtMotivo_Retiro.setSize("317px", "61px");
		
		DateBox dateFecha1 = new DateBox();
		dateFecha1.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha1.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha1, 10, 29);
		dateFecha1.setSize("124px", "11px");
		
		DateBox dateFecha2 = new DateBox();
		dateFecha2.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha2.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha2, 183, 30);
		dateFecha2.setSize("137px", "11px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this);
    }
}
