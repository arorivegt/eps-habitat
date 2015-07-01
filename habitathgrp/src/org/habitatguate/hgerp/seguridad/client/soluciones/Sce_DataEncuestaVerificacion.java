package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class Sce_DataEncuestaVerificacion extends Composite {

	private Sce_DataEntryEncuestaVerificacion entryFormulario;
    private TextBox txtPrimerApellido;
    private TextBox txtSegundoApellido ;
    private TextBox txtPrimerNombre;
    private TextBox textBox_direccionActual_sce;
    private IntegerBox integerBox_telefonoCasa_sce ;
    
	public Sce_DataEncuestaVerificacion(Sce_DataEntryEncuestaVerificacion e) {
		this.entryFormulario = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "637px");
		
		Label lblPrimerApellido = new Label("Primer Apellido:");
		lblPrimerApellido.setStyleName("label");
		absolutePanel.add(lblPrimerApellido, 416, 10);
		lblPrimerApellido.setSize("192px", "19px");
		
		Label lblSegundoApellido = new Label("Segundo Apellido:");
		lblSegundoApellido.setStyleName("label");
		absolutePanel.add(lblSegundoApellido, 706, 10);
		lblSegundoApellido.setSize("137px", "19px");
		
		txtPrimerApellido = new TextBox();
		txtPrimerApellido.setMaxLength(50);
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerApellido, 416, 28);
		txtPrimerApellido.setSize("227px", "19px");
		
		txtSegundoApellido = new TextBox();
		txtSegundoApellido.setMaxLength(50);
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundoApellido, 706, 28);
		txtSegundoApellido.setSize("188px", "19px");
		
		Label lblNombres = new Label("Nombres:");
		lblNombres.setStyleName("label");
		absolutePanel.add(lblNombres, 42, 10);
		lblNombres.setSize("192px", "19px");
		
		txtPrimerNombre = new TextBox();
		txtPrimerNombre.setMaxLength(50);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerNombre, 43, 28);
		txtPrimerNombre.setSize("331px", "19px");
		
		Label lblDireccionActual = new Label("Direccion Actual:");
		lblDireccionActual.setStyleName("label");
		absolutePanel.add(lblDireccionActual, 42, 142);
		lblDireccionActual.setSize("192px", "19px");
		
		textBox_direccionActual_sce = new TextBox();
		textBox_direccionActual_sce.setMaxLength(200);
		textBox_direccionActual_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_direccionActual_sce, 42, 166);
		textBox_direccionActual_sce.setSize("514px", "19px");
		
		Label lblNumeroDeTelefonoCelular = new Label("Numero de telefono celular:");
		lblNumeroDeTelefonoCelular.setStyleName("label");
		absolutePanel.add(lblNumeroDeTelefonoCelular, 790, 142);
		lblNumeroDeTelefonoCelular.setSize("160px", "19px");
		
		Label lblNumeroDeTelefono = new Label("Numero de telefono casa:");
		lblNumeroDeTelefono.setStyleName("label");
		absolutePanel.add(lblNumeroDeTelefono, 602, 142);
		lblNumeroDeTelefono.setSize("148px", "19px");
		
		integerBox_telefonoCasa_sce = new IntegerBox();
		integerBox_telefonoCasa_sce.setText("0");
		integerBox_telefonoCasa_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_telefonoCasa_sce, 602, 166);
		integerBox_telefonoCasa_sce.setSize("117px", "19px");
		
		Label lblEstadoCivil = new Label("Estado Civil:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 168, 72);
		lblEstadoCivil.setSize("130px", "19px");
		
		ListBox listBox_estadoCivil_sce = new ListBox();
		listBox_estadoCivil_sce.addItem("-");
		listBox_estadoCivil_sce.addItem("Soltero (a)");
		listBox_estadoCivil_sce.addItem("Casado (a)");
		listBox_estadoCivil_sce.addItem("Unido (a)");
		listBox_estadoCivil_sce.addItem("Separado (a)");
		listBox_estadoCivil_sce.addItem("Divorciado (a)");
		listBox_estadoCivil_sce.addItem("Viudo (a)");
		listBox_estadoCivil_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_estadoCivil_sce, 168, 97);
		listBox_estadoCivil_sce.setSize("148px", "27px");
		
		Label lblEdad = new Label("Edad:");
		lblEdad.setStyleName("label");
		absolutePanel.add(lblEdad, 42, 72);
		lblEdad.setSize("101px", "19px");
		
		TextBox textBox_edad_sce = new TextBox();
		textBox_edad_sce.setStyleName("gwt-TextBox2");
		textBox_edad_sce.setMaxLength(200);
		absolutePanel.add(textBox_edad_sce, 42, 97);
		textBox_edad_sce.setSize("81px", "19px");
		
		Label lblDocumentoPersonalDe = new Label("Documento Personal de Identificacion (DPI):");
		lblDocumentoPersonalDe.setStyleName("label");
		absolutePanel.add(lblDocumentoPersonalDe, 343, 72);
		lblDocumentoPersonalDe.setSize("265px", "19px");
		
		IntegerBox integerBox_DPI_sce = new IntegerBox();
		integerBox_DPI_sce.setText("0");
		integerBox_DPI_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_DPI_sce, 343, 97);
		integerBox_DPI_sce.setSize("196px", "19px");
		
		DateBox dateBox_fechaVencimiento_sce = new DateBox();
		dateBox_fechaVencimiento_sce.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateBox_fechaVencimiento_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateBox_fechaVencimiento_sce, 790, 96);
		dateBox_fechaVencimiento_sce.setSize("126px", "18px");
		
		Label lblFechaDeVencimiento = new Label("Fecha de Vencimiento:");
		lblFechaDeVencimiento.setStyleName("label");
		absolutePanel.add(lblFechaDeVencimiento, 790, 72);
		lblFechaDeVencimiento.setSize("137px", "19px");
		
		Label lblReferenciasQueNos = new Label("Referencias que nos permitan ubicar facilmente el lugar donde vive actualmente:");
		lblReferenciasQueNos.setStyleName("label");
		absolutePanel.add(lblReferenciasQueNos, 42, 222);
		lblReferenciasQueNos.setSize("534px", "19px");
		
		TextBox textBox_referencias_sce = new TextBox();
		textBox_referencias_sce.setStyleName("gwt-TextBox2");
		textBox_referencias_sce.setMaxLength(200);
		absolutePanel.add(textBox_referencias_sce, 42, 247);
		textBox_referencias_sce.setSize("601px", "19px");
		
		Label lblProfesionUOficio = new Label("Profesion u oficio:");
		lblProfesionUOficio.setStyleName("label");
		absolutePanel.add(lblProfesionUOficio, 42, 300);
		lblProfesionUOficio.setSize("136px", "19px");
		
		TextBox textBox_profesionOficio_sce = new TextBox();
		textBox_profesionOficio_sce.setStyleName("gwt-TextBox2");
		textBox_profesionOficio_sce.setMaxLength(200);
		absolutePanel.add(textBox_profesionOficio_sce, 42, 325);
		textBox_profesionOficio_sce.setSize("136px", "19px");
		
		Label lblLugarDeTrabajo = new Label("Lugar de trabajo:");
		lblLugarDeTrabajo.setStyleName("label");
		absolutePanel.add(lblLugarDeTrabajo, 285, 300);
		lblLugarDeTrabajo.setSize("101px", "19px");
		
		TextBox textBox_lugarTrabajo_sce = new TextBox();
		textBox_lugarTrabajo_sce.setStyleName("gwt-TextBox2");
		textBox_lugarTrabajo_sce.setMaxLength(200);
		absolutePanel.add(textBox_lugarTrabajo_sce, 285, 325);
		textBox_lugarTrabajo_sce.setSize("358px", "19px");
		
		IntegerBox integerBox_telefonoCelular_sce = new IntegerBox();
		integerBox_telefonoCelular_sce.setText("0");
		integerBox_telefonoCelular_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_telefonoCelular_sce, 798, 166);
		integerBox_telefonoCelular_sce.setSize("118px", "19px");
		
		ListBox listBox_escolaridad_sce = new ListBox();
		listBox_escolaridad_sce.addItem("-");
		listBox_escolaridad_sce.addItem("Ninguna");
		listBox_escolaridad_sce.addItem("Primaria");
		listBox_escolaridad_sce.addItem("Basico");
		listBox_escolaridad_sce.addItem("Diversificado");
		listBox_escolaridad_sce.addItem("Universitario");
		listBox_escolaridad_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_escolaridad_sce, 42, 391);
		listBox_escolaridad_sce.setSize("148px", "27px");
		
		Label lblEscolaridad = new Label("Escolaridad:");
		lblEscolaridad.setStyleName("label");
		absolutePanel.add(lblEscolaridad, 42, 366);
		lblEscolaridad.setSize("130px", "19px");
		
		ListBox listBox_modoIngresos_sce = new ListBox();
		listBox_modoIngresos_sce.addItem("-");
		listBox_modoIngresos_sce.addItem("Asalariado (a)");
		listBox_modoIngresos_sce.addItem("Por cuenta propia");
		listBox_modoIngresos_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_modoIngresos_sce, 285, 391);
		listBox_modoIngresos_sce.setSize("148px", "27px");
		
		Label lblModoDeIngresos = new Label("Modo de ingresos:");
		lblModoDeIngresos.setStyleName("label");
		absolutePanel.add(lblModoDeIngresos, 285, 366);
		lblModoDeIngresos.setSize("130px", "19px");
		
		TextBox textBox_extendida_sce = new TextBox();
		textBox_extendida_sce.setStyleName("gwt-TextBox2");
		textBox_extendida_sce.setMaxLength(200);
		absolutePanel.add(textBox_extendida_sce, 612, 95);
		textBox_extendida_sce.setSize("117px", "19px");
		
		Label lblExtendidaEn = new Label("Extendida en:");
		lblExtendidaEn.setStyleName("label");
		absolutePanel.add(lblExtendidaEn, 639, 72);
		lblExtendidaEn.setSize("111px", "19px");
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("Guardar");
		absolutePanel.add(btnNewButton, 507, 607);
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(200);
		absolutePanel.add(textBox, 42, 470);
		textBox.setSize("136px", "19px");
		
		Label lblTiempoDeVivir = new Label("Tiempo de vivir en el departamento:");
		lblTiempoDeVivir.setStyleName("label");
		absolutePanel.add(lblTiempoDeVivir, 42, 445);
		lblTiempoDeVivir.setSize("227px", "19px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(200);
		absolutePanel.add(textBox_1, 285, 470);
		textBox_1.setSize("358px", "19px");
		
		Label lblLugarDeOrigen = new Label("Lugar de origen:");
		lblLugarDeOrigen.setStyleName("label");
		absolutePanel.add(lblLugarDeOrigen, 285, 445);
		lblLugarDeOrigen.setSize("101px", "19px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox2");
		textBox_2.setMaxLength(200);
		absolutePanel.add(textBox_2, 42, 543);
		textBox_2.setSize("601px", "19px");
		
		Label lblDireccionExactaDonde = new Label("Direccion exacta donde se piensa construir:");
		lblDireccionExactaDonde.setStyleName("label");
		absolutePanel.add(lblDireccionExactaDonde, 42, 519);
		lblDireccionExactaDonde.setSize("332px", "19px");
		
	}
	

				
}
