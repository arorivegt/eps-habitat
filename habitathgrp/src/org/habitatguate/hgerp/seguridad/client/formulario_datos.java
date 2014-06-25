package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.Button;

public class formulario_datos extends Composite {

	public formulario_datos() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("938px", "895px");
		
		Label lblNoDeAfiliacin = new Label("No. De Afiliación al IGSS");
		lblNoDeAfiliacin.setStyleName("label");
		absolutePanel.add(lblNoDeAfiliacin, 42, 10);
		
		Label label_1 = new Label("Estado Civil");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 323, 10);
		label_1.setSize("192px", "19px");
		
		Label label_2 = new Label("Sexo");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 595, 10);
		label_2.setSize("192px", "19px");
		
		ListBox listBox = new ListBox();
		listBox.addItem("Soltero/a");
		listBox.addItem("Casado/a");
		listBox.addItem("Divorciado/a");
		listBox.addItem("Viudo/a");
		listBox.addItem("Separado/a");
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 324, 28);
		listBox.setSize("247px", "27px");
		
		ListBox listBox_1 = new ListBox();
		listBox_1.addItem("femenino");
		listBox_1.addItem("masculino");
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 596, 28);
		listBox_1.setSize("247px", "27px");
		
		Label label_3 = new Label("Primer Apellido");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 42, 70);
		label_3.setSize("192px", "19px");
		
		Label label_4 = new Label("Segundo Apellido");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 322, 70);
		label_4.setSize("192px", "19px");
		
		Label label_5 = new Label("Apellido Casada");
		label_5.setStyleName("label");
		absolutePanel.add(label_5, 597, 70);
		label_5.setSize("192px", "19px");
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox, 43, 88);
		textBox.setSize("227px", "19px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_1, 324, 88);
		textBox_1.setSize("227px", "19px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_2, 596, 88);
		textBox_2.setSize("227px", "19px");
		
		IntegerBox integerBox = new IntegerBox();
		integerBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox, 43, 28);
		integerBox.setSize("227px", "19px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 42, 131);
		label_6.setSize("192px", "19px");
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_3, 43, 149);
		textBox_3.setSize("227px", "19px");
		
		TextBox textBox_4 = new TextBox();
		textBox_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_4, 324, 149);
		textBox_4.setSize("227px", "19px");
		
		Label label_7 = new Label("2do y Demás Nombres");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 323, 131);
		label_7.setSize("192px", "19px");
		
		Label label_8 = new Label("Pais");
		label_8.setStyleName("label");
		absolutePanel.add(label_8, 595, 131);
		label_8.setSize("192px", "19px");
		
		ListBox listBox_2 = new ListBox();
		listBox_2.addItem("Guatemala");
		listBox_2.addItem("Costa Rica");
		listBox_2.addItem("Portugal");
		listBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_2, 596, 149);
		listBox_2.setSize("247px", "27px");
		
		Label label_9 = new Label("Tipo Empleado");
		label_9.setStyleName("label");
		absolutePanel.add(label_9, 42, 199);
		label_9.setSize("192px", "19px");
		
		ListBox listBox_3 = new ListBox();
		listBox_3.addItem("sin ivs");
		listBox_3.addItem("con ivs");
		listBox_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_3, 43, 217);
		listBox_3.setSize("248px", "27px");
		
		TextBox textBox_5 = new TextBox();
		textBox_5.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_5, 325, 217);
		textBox_5.setSize("227px", "19px");
		
		Label label_10 = new Label("Nit");
		label_10.setStyleName("label");
		absolutePanel.add(label_10, 323, 199);
		label_10.setSize("192px", "19px");
		
		ListBox listBox_4 = new ListBox();
		listBox_4.addItem("0");
		listBox_4.addItem("1");
		listBox_4.addItem("2");
		listBox_4.addItem("3");
		listBox_4.addItem("4");
		listBox_4.addItem("5");
		listBox_4.addItem("6");
		listBox_4.addItem("7");
		listBox_4.addItem("8");
		listBox_4.addItem("9");
		listBox_4.addItem("10");
		listBox_4.addItem("11");
		listBox_4.addItem("12");
		listBox_4.addItem("13");
		listBox_4.addItem("14");
		listBox_4.addItem("15");
		listBox_4.addItem("16");
		listBox_4.addItem("17");
		listBox_4.addItem("18");
		listBox_4.addItem("19");
		listBox_4.addItem("20");
		listBox_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_4, 597, 217);
		listBox_4.setSize("248px", "27px");
		
		Label label_11 = new Label("No. Dependientes");
		label_11.setStyleName("label");
		absolutePanel.add(label_11, 596, 199);
		label_11.setSize("192px", "19px");
		
		Label label_12 = new Label("Cedula No. Orden");
		label_12.setStyleName("label");
		absolutePanel.add(label_12, 42, 262);
		label_12.setSize("192px", "19px");
		
		TextBox textBox_6 = new TextBox();
		textBox_6.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_6, 43, 280);
		textBox_6.setSize("227px", "19px");
		
		TextBox textBox_7 = new TextBox();
		textBox_7.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_7, 324, 280);
		textBox_7.setSize("227px", "19px");
		
		Label label_13 = new Label("Cedula No. Registro");
		label_13.setStyleName("label");
		absolutePanel.add(label_13, 323, 262);
		label_13.setSize("192px", "19px");
		
		Label label_14 = new Label("Doc. de Identificacion Personal- CUI");
		label_14.setStyleName("label");
		absolutePanel.add(label_14, 596, 262);
		label_14.setSize("247px", "19px");
		
		TextBox textBox_8 = new TextBox();
		textBox_8.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_8, 596, 280);
		textBox_8.setSize("227px", "19px");
		
		SimpleCheckBox simpleCheckBox = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox, 41, 442);
		
		Label label_15 = new Label("Pasaporte");
		label_15.setStyleName("label");
		absolutePanel.add(label_15, 39, 325);
		label_15.setSize("178px", "19px");
		
		TextBox textBox_9 = new TextBox();
		textBox_9.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_9, 321, 343);
		textBox_9.setSize("227px", "19px");
		
		Label label_16 = new Label("Tipo Pasaporte");
		label_16.setStyleName("label");
		absolutePanel.add(label_16, 319, 325);
		label_16.setSize("192px", "19px");
		
		Label label_17 = new Label("No. Pasaporte");
		label_17.setStyleName("label");
		absolutePanel.add(label_17, 592, 325);
		label_17.setSize("192px", "19px");
		
		TextBox textBox_10 = new TextBox();
		textBox_10.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_10, 594, 343);
		textBox_10.setSize("227px", "19px");
		
		Label lblCedulaExtendidamunicipio = new Label("Cedula extendida-Municipio");
		lblCedulaExtendidamunicipio.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidamunicipio, 42, 389);
		lblCedulaExtendidamunicipio.setSize("192px", "19px");
		
		ListBox listBox_5 = new ListBox();
		listBox_5.addItem("mixco");
		listBox_5.addItem("antigua guatemala");
		listBox_5.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_5, 42, 414);
		listBox_5.setSize("248px", "27px");
		
		TextBox textBox_11 = new TextBox();
		textBox_11.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_11, 44, 486);
		textBox_11.setSize("507px", "19px");
		
		Label label_20 = new Label("DIreccion Actual");
		label_20.setStyleName("label");
		absolutePanel.add(label_20, 42, 463);
		label_20.setSize("192px", "19px");
		
		ListBox listBox_6 = new ListBox();
		listBox_6.addItem("mixco");
		listBox_6.addItem("antigua guatemala");
		listBox_6.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_6, 595, 486);
		listBox_6.setSize("248px", "27px");
		
		Label label_21 = new Label("Municipio residencia");
		label_21.setStyleName("label");
		absolutePanel.add(label_21, 595, 463);
		label_21.setSize("192px", "19px");
		
		Label label_22 = new Label("Correo Electronico");
		label_22.setStyleName("label");
		absolutePanel.add(label_22, 42, 538);
		label_22.setSize("192px", "19px");
		
		TextBox textBox_12 = new TextBox();
		textBox_12.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_12, 44, 558);
		textBox_12.setSize("227px", "19px");
		
		Label label_23 = new Label("Telefono de casa");
		label_23.setStyleName("label");
		absolutePanel.add(label_23, 323, 538);
		label_23.setSize("192px", "19px");
		
		TextBox textBox_13 = new TextBox();
		textBox_13.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_13, 321, 558);
		textBox_13.setSize("227px", "19px");
		
		Label label_24 = new Label("Telefono Celular");
		label_24.setStyleName("label");
		absolutePanel.add(label_24, 595, 538);
		label_24.setSize("192px", "19px");
		
		TextBox textBox_14 = new TextBox();
		textBox_14.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_14, 596, 558);
		textBox_14.setSize("227px", "19px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label label_25 = new Label("Licencia");
		label_25.setStyleName("label");
		absolutePanel.add(label_25, 42, 610);
		label_25.setSize("178px", "19px");
		
		TextBox textBox_15 = new TextBox();
		textBox_15.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_15, 596, 635);
		textBox_15.setSize("227px", "19px");
		
		Label label_26 = new Label("No. Licencia");
		label_26.setStyleName("label");
		absolutePanel.add(label_26, 595, 610);
		label_26.setSize("192px", "19px");
		
		ListBox listBox_7 = new ListBox();
		listBox_7.addItem("A");
		listBox_7.addItem("B");
		listBox_7.addItem("C");
		listBox_7.addItem("M");
		listBox_7.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_7, 323, 635);
		listBox_7.setSize("248px", "27px");
		
		Label label_27 = new Label("Tipo Licencia");
		label_27.setStyleName("label");
		absolutePanel.add(label_27, 323, 610);
		label_27.setSize("192px", "19px");
		
		Label label_28 = new Label("Año de Nacimiento");
		label_28.setStyleName("label");
		absolutePanel.add(label_28, 323, 389);
		label_28.setSize("192px", "19px");
		
		DateBox dateBox = new DateBox();
		dateBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateBox, 323, 414);
		dateBox.setSize("228px", "18px");
		
		Button button = new Button("Send");
		button.setText("Actualizar");
		button.setStylePrimaryName("gwt-TextBox");
		button.setStyleName("gwt-TextBox");
		absolutePanel.add(button, 325, 830);
		button.setSize("280px", "44px");
	}
}
