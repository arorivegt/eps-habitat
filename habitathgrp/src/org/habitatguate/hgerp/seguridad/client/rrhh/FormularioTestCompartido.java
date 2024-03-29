package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;

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

public class FormularioTestCompartido extends Composite {

	private AuxTest prueba;
    private DateBox dateFecha ;
    private TextBox txtEvaluador ;
    private DoubleBox txtPunteo;
    public Long id_Empleado = 0L;
    public Long id_TestCompartido = 0L;
    private Compartidas compartido;
    private Loading load ;
    private FormularioTestCompartido test;
    
	public FormularioTestCompartido(final AuxTest prueba, Compartidas comp, Long idCompartido, String nombre) {
		
		test = this;
		
		id_TestCompartido = idCompartido;
		compartido = comp;
		
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		this.setPrueba(prueba);
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("914px", "30px");
		
		dateFecha = new DateBox();
		dateFecha.setEnabled(false);
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date());
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 29);
		dateFecha.setSize("183px", "34px");
		dateFecha.setValue(new Date(prueba.getFecha_test()));
		
		txtEvaluador = new TextBox();
		txtEvaluador.setReadOnly(true);
		txtEvaluador.setStyleName("gwt-TextBox2");
		txtEvaluador.setMaxLength(500);
		absolutePanel.add(txtEvaluador, 218, 29);
		txtEvaluador.setSize("227px", "34px");

		txtEvaluador.setText(nombre);
		
		txtPunteo = new DoubleBox();
		txtPunteo.setReadOnly(true);
		txtPunteo.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPunteo, 483, 29);
		txtPunteo.setSize("97px", "34px");

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
				compartido.agregarFormularioLleno(getPrueba(), id_Empleado, getPrueba().getTipo_test());
			}
		});
		btnActualizar.setText("Ver");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 627, 31);
		btnActualizar.setSize("118px", "34px");
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("170px", "13px");
		
		Label lblEvaluacionDe = new Label("Persona a Evaluar");
		lblEvaluacionDe.setStyleName("label");
		absolutePanel.add(lblEvaluacionDe, 218, 10);
		lblEvaluacionDe.setSize("201px", "13px");
		
		Label label_1 = new Label("Punteo Total");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 483, 10);
		label_1.setSize("147px", "13px");
		
		Button btnQuitar = new Button("Send");
		btnQuitar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				compartido.DejarCompartir(compartido.id_EmpleadoPrincipal,id_TestCompartido,test);
			}
		});
		btnQuitar.setText("Dejar de seguir");
		btnQuitar.setStylePrimaryName("gwt-TextBox2");
		btnQuitar.setStyleName("sendButton");
		absolutePanel.add(btnQuitar, 751, 31);
		btnQuitar.setSize("206px", "34px");
		
	}

	public AuxTest getPrueba() {
		return prueba;
	}

	public void setPrueba(AuxTest prueba) {
		this.prueba = prueba;
	}	
	
}
