package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class formularioDesempeno extends Composite {

	private AuxTest prueba;
    private DateBox dateFecha ;
    private TextBox txtEvaluador ;
    private DoubleBox txtPunteo;
    private Desempeno d;
    
	public formularioDesempeno(final Desempeno d,final AuxTest prueba) {
		
		this.setD(d);
		this.setPrueba(prueba);
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("708px", "20px");
		
		dateFecha = new DateBox();
		dateFecha.setEnabled(false);
		dateFecha.setValue(new Date(1407518904795L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 29);
		dateFecha.setSize("123px", "11px");
		dateFecha.setValue(new Date(prueba.getFecha_test()));
		
		txtEvaluador = new TextBox();
		txtEvaluador.setReadOnly(true);
		txtEvaluador.setStyleName("gwt-TextBox2");
		txtEvaluador.setMaxLength(500);
		absolutePanel.add(txtEvaluador, 181, 29);
		txtEvaluador.setSize("117px", "11px");
		
		txtEvaluador.setText(prueba.getEvaluador());
		
		txtPunteo = new DoubleBox();
		txtPunteo.setReadOnly(true);
		txtPunteo.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPunteo, 342, 29);
		txtPunteo.setSize("117px", "11px");

		txtEvaluador.setText(prueba.getEvaluador());
		int valor = prueba.getPregunta1() + prueba.getPregunt2() + prueba.getPregunta3()
				+prueba.getPregunta4()+prueba.getPregunta5() +prueba.getPregunta6()
				+prueba.getPregunta7()+prueba.getPregunta8()+prueba.getPregunta9()
				+prueba.getPregunta10();
		txtPunteo.setText(""+valor);
		dateFecha.setValue(new Date(prueba.getFecha_test()));
		txtPunteo.setText(""+valor);
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				d.agregarFormulario_lleno(prueba);
			}
		});
		btnActualizar.setText("Ver Formulario Completo");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 499, 29);
		btnActualizar.setSize("157px", "20px");
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label label = new Label("Evaluador");
		label.setStyleName("label");
		absolutePanel.add(label, 185, 10);
		label.setSize("75px", "13px");
		
		Label label_1 = new Label("Punteo Total");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 342, 10);
		label_1.setSize("75px", "13px");
		
	}

	public AuxTest getPrueba() {
		return prueba;
	}

	public void setPrueba(AuxTest prueba) {
		this.prueba = prueba;
	}

	public Desempeno getD() {
		return d;
	}

	public void setD(Desempeno d) {
		this.d = d;
	}

	
	
}
