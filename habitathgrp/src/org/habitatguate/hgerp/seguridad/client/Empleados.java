 /**
 * 
 */
package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * @author anibaljose
 *
 */
public class Empleados extends Composite {

	public Empleados() {
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel, "Datos",true);
		scrollPanel.setSize("1200px", "480px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		scrollPanel.setWidget(absolutePanel);
		absolutePanel.setSize("100%", "895px");
		
		Label lblNewLabel = new Label("No. De Afiliación al IGSS");
		lblNewLabel.setStyleName("");
		absolutePanel.add(lblNewLabel, 41, 22);
		
		Label lblEstadoCivil = new Label("Estado Civil");
		lblEstadoCivil.setStyleName("");
		absolutePanel.add(lblEstadoCivil, 322, 22);
		lblEstadoCivil.setSize("192px", "19px");
		
		Label lblSexo = new Label("Sexo");
		lblSexo.setStyleName("");
		absolutePanel.add(lblSexo, 594, 22);
		lblSexo.setSize("192px", "19px");
		
		ListBox comboBox = new ListBox();
		comboBox.addItem("Soltero/a");
		comboBox.addItem("Casado/a");
		comboBox.addItem("Divorciado/a");
		comboBox.addItem("Viudo/a");
		comboBox.addItem("Separado/a");
		absolutePanel.add(comboBox, 322, 47);
		comboBox.setSize("247px", "27px");
		
		ListBox listBox = new ListBox();
		listBox.addItem("Mujer");
		listBox.addItem("Hombre");
		absolutePanel.add(listBox, 594, 47);
		listBox.setSize("247px", "27px");
		
		Label lblPrimerApellido = new Label("Primer Apellido");
		lblPrimerApellido.setStyleName("");
		absolutePanel.add(lblPrimerApellido, 41, 101);
		lblPrimerApellido.setSize("192px", "19px");
		
		Label lblSegundoApellido = new Label("Segundo Apellido");
		lblSegundoApellido.setStyleName("");
		absolutePanel.add(lblSegundoApellido, 321, 101);
		lblSegundoApellido.setSize("192px", "19px");
		
		Label lblApellidoCasada = new Label("Apellido Casada");
		lblApellidoCasada.setStyleName("");
		absolutePanel.add(lblApellidoCasada, 596, 101);
		lblApellidoCasada.setSize("192px", "19px");
		
		TextBox textBox_1 = new TextBox();
		absolutePanel.add(textBox_1, 41, 126);
		textBox_1.setSize("227px", "19px");
		
		TextBox textBox_2 = new TextBox();
		absolutePanel.add(textBox_2, 322, 126);
		textBox_2.setSize("227px", "19px");
		
		TextBox textBox_3 = new TextBox();
		absolutePanel.add(textBox_3, 594, 126);
		textBox_3.setSize("227px", "19px");
		
		IntegerBox integerBox = new IntegerBox();
		integerBox.setStyleName("gwt-TextBox");
		absolutePanel.add(integerBox, 41, 47);
		integerBox.setSize("227px", "19px");
		
		Label lblPrimerNombre = new Label("Primer Nombre");
		lblPrimerNombre.setStyleName("");
		absolutePanel.add(lblPrimerNombre, 41, 177);
		lblPrimerNombre.setSize("192px", "19px");
		
		TextBox textBox = new TextBox();
		absolutePanel.add(textBox, 41, 202);
		textBox.setSize("227px", "19px");
		
		TextBox textBox_4 = new TextBox();
		absolutePanel.add(textBox_4, 322, 202);
		textBox_4.setSize("227px", "19px");
		
		Label lblSegundoNombre = new Label("2do y Demás Nombres");
		lblSegundoNombre.setStyleName("");
		absolutePanel.add(lblSegundoNombre, 322, 159);
		lblSegundoNombre.setSize("192px", "19px");
		
		Label lblPais = new Label("Pais");
		lblPais.setStyleName("");
		absolutePanel.add(lblPais, 594, 177);
		lblPais.setSize("192px", "19px");
		
		ListBox listBox_1 = new ListBox();
		listBox_1.addItem("Guatemala");
		listBox_1.addItem("Honduras");
		absolutePanel.add(listBox_1, 594, 202);
		listBox_1.setSize("247px", "27px");
		
		Label lblTipoEmpleado = new Label("Tipo Empleado");
		lblTipoEmpleado.setStyleName("");
		absolutePanel.add(lblTipoEmpleado, 40, 247);
		lblTipoEmpleado.setSize("192px", "19px");
		
		ListBox listBox_2 = new ListBox();
		listBox_2.setStyleName("");
		listBox_2.addItem("Con IVS");
		listBox_2.addItem("Sin IVS");
		absolutePanel.add(listBox_2, 40, 272);
		listBox_2.setSize("248px", "27px");
		
		TextBox textBox_5 = new TextBox();
		absolutePanel.add(textBox_5, 322, 272);
		textBox_5.setSize("227px", "19px");
		
		Label lblNit = new Label("Nit");
		lblNit.setStyleName("");
		absolutePanel.add(lblNit, 321, 247);
		lblNit.setSize("192px", "19px");
		
		ListBox listBox_3 = new ListBox();
		listBox_3.addItem("0");
		listBox_3.addItem("1");
		listBox_3.addItem("2");
		listBox_3.addItem("3");
		listBox_3.addItem("4");
		listBox_3.addItem("5");
		listBox_3.addItem("6");
		listBox_3.addItem("7");
		listBox_3.addItem("8");
		listBox_3.addItem("9");
		listBox_3.addItem("10");
		listBox_3.addItem("11");
		listBox_3.addItem("12");
		listBox_3.addItem("13");
		listBox_3.addItem("14");
		listBox_3.addItem("15");
		listBox_3.addItem("16");
		listBox_3.addItem("17");
		listBox_3.addItem("18");
		listBox_3.addItem("19");
		listBox_3.addItem("20");
		absolutePanel.add(listBox_3, 594, 272);
		listBox_3.setSize("248px", "27px");
		
		Label lblNoDependientes = new Label("No. Dependientes");
		lblNoDependientes.setStyleName("");
		absolutePanel.add(lblNoDependientes, 594, 247);
		lblNoDependientes.setSize("192px", "19px");
		
		Label lblNoOrden = new Label("Cedula No. Orden");
		lblNoOrden.setStyleName("");
		absolutePanel.add(lblNoOrden, 41, 339);
		lblNoOrden.setSize("192px", "19px");
		
		TextBox textBox_6 = new TextBox();
		absolutePanel.add(textBox_6, 41, 364);
		textBox_6.setSize("227px", "19px");
		
		TextBox textBox_7 = new TextBox();
		absolutePanel.add(textBox_7, 322, 364);
		textBox_7.setSize("227px", "19px");
		
		Label lblNoRegistro = new Label("Cedula No. Registro");
		lblNoRegistro.setStyleName("");
		absolutePanel.add(lblNoRegistro, 322, 339);
		lblNoRegistro.setSize("192px", "19px");
		
		Label lblCui = new Label("Doc. de Identificacion Personal- CUI");
		lblCui.setStyleName("");
		absolutePanel.add(lblCui, 594, 316);
		lblCui.setSize("247px", "19px");
		
		TextBox textBox_8 = new TextBox();
		absolutePanel.add(textBox_8, 594, 364);
		textBox_8.setSize("227px", "19px");
		
		SimpleCheckBox simpleCheckBox = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox, 41, 442);
		
		Label lblPasaporte = new Label("Pasaporte");
		lblPasaporte.setStyleName("");
		absolutePanel.add(lblPasaporte, 41, 415);
		lblPasaporte.setSize("178px", "19px");
		
		TextBox textBox_9 = new TextBox();
		absolutePanel.add(textBox_9, 322, 440);
		textBox_9.setSize("227px", "19px");
		
		Label lblTipoPasaporte = new Label("Tipo Pasaporte");
		lblTipoPasaporte.setStyleName("");
		absolutePanel.add(lblTipoPasaporte, 321, 415);
		lblTipoPasaporte.setSize("192px", "19px");
		
		Label lblNoPasaporte = new Label("No. Pasaporte");
		lblNoPasaporte.setStyleName("");
		absolutePanel.add(lblNoPasaporte, 594, 415);
		lblNoPasaporte.setSize("192px", "19px");
		
		TextBox textBox_10 = new TextBox();
		absolutePanel.add(textBox_10, 595, 440);
		textBox_10.setSize("227px", "19px");
		
		Label lblExtendida = new Label("Extendida");
		lblExtendida.setStyleName("");
		absolutePanel.add(lblExtendida, 41, 492);
		lblExtendida.setSize("192px", "19px");
		
		Label lblMunicipio = new Label("Municipio");
		lblMunicipio.setStyleName("");
		absolutePanel.add(lblMunicipio, 129, 492);
		lblMunicipio.setSize("192px", "19px");
		
		ListBox listBox_4 = new ListBox();
		listBox_4.addItem("Mixco");
		listBox_4.addItem("Antigua Guatemala");
		absolutePanel.add(listBox_4, 41, 517);
		listBox_4.setSize("248px", "27px");
		
		TextBox textBox_11 = new TextBox();
		absolutePanel.add(textBox_11, 42, 596);
		textBox_11.setSize("494px", "19px");
		
		Label lblDireccion = new Label("DIreccion Actual");
		lblDireccion.setStyleName("");
		absolutePanel.add(lblDireccion, 41, 571);
		lblDireccion.setSize("192px", "19px");
		
		ListBox listBox_5 = new ListBox();
		listBox_5.addItem("Mixco");
		listBox_5.addItem("Antigua Guatemala");
		absolutePanel.add(listBox_5, 593, 596);
		listBox_5.setSize("248px", "27px");
		
		Label lblMunicipioRe = new Label("Municipio residencia");
		lblMunicipioRe.setStyleName("");
		absolutePanel.add(lblMunicipioRe, 593, 571);
		lblMunicipioRe.setSize("192px", "19px");
		
		Label lblCorreoElectronico = new Label("Correo Electronico");
		lblCorreoElectronico.setStyleName("");
		absolutePanel.add(lblCorreoElectronico, 41, 641);
		lblCorreoElectronico.setSize("192px", "19px");
		
		TextBox textBox_12 = new TextBox();
		absolutePanel.add(textBox_12, 42, 666);
		textBox_12.setSize("227px", "19px");
		
		Label lblTelefonoDeCasa = new Label("Telefono de casa");
		lblTelefonoDeCasa.setStyleName("");
		absolutePanel.add(lblTelefonoDeCasa, 295, 641);
		lblTelefonoDeCasa.setSize("192px", "19px");
		
		TextBox textBox_13 = new TextBox();
		absolutePanel.add(textBox_13, 296, 666);
		textBox_13.setSize("227px", "19px");
		
		Label lblTelefonoCelular = new Label("Telefono Celular");
		lblTelefonoCelular.setStyleName("");
		absolutePanel.add(lblTelefonoCelular, 568, 641);
		lblTelefonoCelular.setSize("192px", "19px");
		
		TextBox textBox_14 = new TextBox();
		absolutePanel.add(textBox_14, 569, 666);
		textBox_14.setSize("227px", "19px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label lblLicencia = new Label("Licencia");
		lblLicencia.setStyleName("");
		absolutePanel.add(lblLicencia, 41, 712);
		lblLicencia.setSize("178px", "19px");
		
		TextBox textBox_23 = new TextBox();
		absolutePanel.add(textBox_23, 595, 737);
		textBox_23.setSize("227px", "19px");
		
		Label lblNoLicencia = new Label("No. Licencia");
		lblNoLicencia.setStyleName("");
		absolutePanel.add(lblNoLicencia, 594, 712);
		lblNoLicencia.setSize("192px", "19px");
		
		ListBox listBox_6 = new ListBox();
		listBox_6.addItem("A");
		listBox_6.addItem("B");
		listBox_6.addItem("C");
		listBox_6.addItem("M");
		absolutePanel.add(listBox_6, 295, 737);
		listBox_6.setSize("248px", "27px");
		
		Label lblTipoLicencia = new Label("Tipo Licencia");
		lblTipoLicencia.setStyleName("");
		absolutePanel.add(lblTipoLicencia, 295, 712);
		lblTipoLicencia.setSize("192px", "19px");
		
		Label lblAoDeNacimiento = new Label("Año de Nacimiento");
		lblAoDeNacimiento.setStyleName("");
		absolutePanel.add(lblAoDeNacimiento, 332, 492);
		lblAoDeNacimiento.setSize("192px", "19px");
		
		DateBox dateBox = new DateBox();
		dateBox.setStyleName("gwt-TextBox");
		absolutePanel.add(dateBox, 322, 520);
		dateBox.setSize("237px", "18px");
		
		Button button = new Button("Send");
		button.setStylePrimaryName("gwt-TextBox");
		button.setText("Guardar");
		button.setStyleName("gwt-TextBox");
		absolutePanel.add(button, 55, 805);
		button.setSize("280px", "44px");
		comboBox.setValue(0, "Soltero/a");
		
		ScrollPanel scrollPanel_1 = new ScrollPanel();
		scrollPanel_1.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_1, "Familia",true);
		scrollPanel_1.setSize("1200px", "489px");
		familiares f = new familiares();
		scrollPanel_1.setWidget(f);

		
		ScrollPanel scrollPanel_2 = new ScrollPanel();
		scrollPanel_2.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_2, "Academico", true);
		scrollPanel_2.setSize("1200px", "480px");
		academico a = new academico();
		scrollPanel_2.setWidget(a);
		
		ScrollPanel scrollPanel_3 = new ScrollPanel();
		scrollPanel_3.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_3, "Referencia Laboral", true);
		scrollPanel_3.setSize("1200px", "480px");
		referencia_laboral rl = new referencia_laboral();
		scrollPanel_3.setWidget(rl);
		rl.setHeight("236px");
		
		ScrollPanel scrollPanel_5 = new ScrollPanel();
		scrollPanel_5.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_5, "Referencia Personal", true);
		scrollPanel_5.setSize("1200px", "480px");
		referencia_personal rp = new referencia_personal();
		scrollPanel_5.setWidget(rp);
		
		ScrollPanel scrollPanel_4 = new ScrollPanel();
		scrollPanel_4.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_4, "Idiomas", true);
		scrollPanel_4.setSize("1200px", "480px");
		// TODO Auto-generated constructor stub
		setStyleName("");
		Idioma i = new Idioma();
		scrollPanel_4.setWidget(i);
		
		ScrollPanel scrollPanel_6 = new ScrollPanel();
		scrollPanel_6.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_6, "Evaluacion", true);
		scrollPanel_6.setSize("1200px", "480px");
		formulario_prueba_periodo fpp = new formulario_prueba_periodo();
		scrollPanel_6.setWidget(fpp);
		
		ScrollPanel scrollPanel_7 = new ScrollPanel();
		scrollPanel_7.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_7, "Desempeño", true);
		scrollPanel_7.setSize("1200px", "480px");
		formulario_prueba_periodo_dos fppd = new formulario_prueba_periodo_dos();
		scrollPanel_7.setWidget(fppd);
		
		ScrollPanel scrollPanel_8 = new ScrollPanel();
		scrollPanel_8.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_8, "Puestos ", true);
		scrollPanel_8.setSize("1200px", "480px");
		puestos p = new puestos();
		scrollPanel_8.setWidget(p);
		
		ScrollPanel scrollPanel_9 = new ScrollPanel();
		scrollPanel_9.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_9, "Entrevista", true);
		scrollPanel_9.setSize("1200px", "480px");
		formulario_entrevista fe = new formulario_entrevista();
		scrollPanel_9.setWidget(fe);
		
		ScrollPanel scrollPanel_10 = new ScrollPanel();
		scrollPanel_10.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_10, "Historial", true);
		scrollPanel_10.setSize("1200px", "480px");
		
		historiales h = new historiales();
		scrollPanel_10.setWidget(h);
	}
}
