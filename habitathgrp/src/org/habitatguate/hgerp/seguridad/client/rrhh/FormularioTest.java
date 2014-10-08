package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.TextBox;

public class FormularioTest extends Composite {

	private AuxBDTest prueba;
    private DateBox dateFecha ;
    private TestForm d;
    
	public FormularioTest(final TestForm d,final AuxBDTest prueba) {
		
		this.setD(d);
		this.setPrueba(prueba);
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("751px", "30px");
		
		dateFecha = new DateBox();
		dateFecha.setEnabled(false);
		dateFecha.setValue(new Date(1407518904795L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 29);
		dateFecha.setSize("227px", "34px");
		dateFecha.setValue(new Date(prueba.getFecha_test()));

		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				d.agregarFormulario_lleno(prueba);
			}
		});
		btnActualizar.setText("Ver");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 513, 29);
		btnActualizar.setSize("227px", "34px");
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("170px", "13px");
		
		TextBox txtNombre = new TextBox();
		txtNombre.setReadOnly(true);
		txtNombre.setStyleName("gwt-TextBox2");
		txtNombre.setMaxLength(100);
		absolutePanel.add(txtNombre, 267, 29);
		txtNombre.setSize("227px", "34px");
		txtNombre.setText(prueba.getNombreTest());
		
		Label lblNombreDelTest = new Label("Nombre del Test");
		lblNombreDelTest.setStyleName("label");
		absolutePanel.add(lblNombreDelTest, 267, 10);
		lblNombreDelTest.setSize("170px", "13px");
		
	}

	public AuxBDTest getPrueba() {
		return prueba;
	}

	public void setPrueba(AuxBDTest prueba) {
		this.prueba = prueba;
	}

	public TestForm getD() {
		return d;
	}

	public void setD(TestForm d) {
		this.d = d;
	}

	
	
}