package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.i18n.client.DateTimeFormat;
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
		absolutePanel.setSize("938px", "1043px");
		
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
		
		ListBox listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("Soltero/a");
		listEstadoCivil.addItem("Casado/a");
		listEstadoCivil.addItem("Divorciado/a");
		listEstadoCivil.addItem("Viudo/a");
		listEstadoCivil.addItem("Separado/a");
		listEstadoCivil.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstadoCivil, 324, 28);
		listEstadoCivil.setSize("247px", "27px");
		
		ListBox listSexo = new ListBox();
		listSexo.addItem("femenino");
		listSexo.addItem("masculino");
		listSexo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSexo, 596, 28);
		listSexo.setSize("247px", "27px");
		
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
		
		TextBox txtPrimerApellido = new TextBox();
		txtPrimerApellido.setMaxLength(50);
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerApellido, 43, 88);
		txtPrimerApellido.setSize("227px", "19px");
		
		TextBox txtSegundoApellido = new TextBox();
		txtSegundoApellido.setMaxLength(50);
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundoApellido, 324, 88);
		txtSegundoApellido.setSize("227px", "19px");
		
		TextBox txtApellidoCasada = new TextBox();
		txtApellidoCasada.setMaxLength(50);
		txtApellidoCasada.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtApellidoCasada, 596, 88);
		txtApellidoCasada.setSize("227px", "19px");
		
		IntegerBox txtNo_iggs = new IntegerBox();
		txtNo_iggs.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNo_iggs, 43, 28);
		txtNo_iggs.setSize("227px", "19px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 42, 131);
		label_6.setSize("192px", "19px");
		
		TextBox txtPrimerNombre = new TextBox();
		txtPrimerNombre.setMaxLength(50);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerNombre, 43, 149);
		txtPrimerNombre.setSize("227px", "19px");
		
		TextBox txtSegundoNombre = new TextBox();
		txtSegundoNombre.setMaxLength(50);
		txtSegundoNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundoNombre, 324, 149);
		txtSegundoNombre.setSize("227px", "19px");
		
		Label label_7 = new Label("2do y Demás Nombres");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 323, 131);
		label_7.setSize("192px", "19px");
		
		Label label_8 = new Label("Pais");
		label_8.setStyleName("label");
		absolutePanel.add(label_8, 595, 131);
		label_8.setSize("192px", "19px");
		
		ListBox listPais = new ListBox();
		listPais.addItem("Guatemala");
		listPais.addItem("Costa Rica");
		listPais.addItem("Portugal");
		listPais.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPais, 596, 149);
		listPais.setSize("247px", "27px");
		
		Label label_9 = new Label("Tipo Empleado");
		label_9.setStyleName("label");
		absolutePanel.add(label_9, 42, 199);
		label_9.setSize("192px", "19px");
		
		ListBox listTipoEmpleado = new ListBox();
		listTipoEmpleado.addItem("sin ivs");
		listTipoEmpleado.addItem("con ivs");
		listTipoEmpleado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoEmpleado, 43, 217);
		listTipoEmpleado.setSize("248px", "27px");
		
		Label label_10 = new Label("Nit");
		label_10.setStyleName("label");
		absolutePanel.add(label_10, 323, 199);
		label_10.setSize("192px", "19px");
		
		ListBox listNoDependientes = new ListBox();
		listNoDependientes.addItem("0");
		listNoDependientes.addItem("1");
		listNoDependientes.addItem("2");
		listNoDependientes.addItem("3");
		listNoDependientes.addItem("4");
		listNoDependientes.addItem("5");
		listNoDependientes.addItem("6");
		listNoDependientes.addItem("7");
		listNoDependientes.addItem("8");
		listNoDependientes.addItem("9");
		listNoDependientes.addItem("10");
		listNoDependientes.addItem("11");
		listNoDependientes.addItem("12");
		listNoDependientes.addItem("13");
		listNoDependientes.addItem("14");
		listNoDependientes.addItem("15");
		listNoDependientes.addItem("16");
		listNoDependientes.addItem("17");
		listNoDependientes.addItem("18");
		listNoDependientes.addItem("19");
		listNoDependientes.addItem("20");
		listNoDependientes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNoDependientes, 597, 217);
		listNoDependientes.setSize("248px", "27px");
		
		Label label_11 = new Label("No. Dependientes");
		label_11.setStyleName("label");
		absolutePanel.add(label_11, 596, 199);
		label_11.setSize("192px", "19px");
		
		Label label_12 = new Label("Cedula No. Orden");
		label_12.setStyleName("label");
		absolutePanel.add(label_12, 42, 262);
		label_12.setSize("192px", "19px");
		
		Label label_13 = new Label("Cedula No. Registro");
		label_13.setStyleName("label");
		absolutePanel.add(label_13, 323, 262);
		label_13.setSize("192px", "19px");
		
		Label label_14 = new Label("Doc. de Identificacion Personal- CUI");
		label_14.setStyleName("label");
		absolutePanel.add(label_14, 596, 262);
		label_14.setSize("247px", "19px");
		
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
		textBox_10.setMaxLength(500);
		textBox_10.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_10, 594, 343);
		textBox_10.setSize("227px", "19px");
		
		Label lblCedulaExtendidamunicipio = new Label("Cedula extendida-Municipio");
		lblCedulaExtendidamunicipio.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidamunicipio, 42, 389);
		lblCedulaExtendidamunicipio.setSize("192px", "19px");
		
		ListBox listCedulaMunicipio = new ListBox();
		listCedulaMunicipio.addItem("mixco");
		listCedulaMunicipio.addItem("antigua guatemala");
		listCedulaMunicipio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listCedulaMunicipio, 42, 414);
		listCedulaMunicipio.setSize("248px", "27px");
		
		TextBox txtDireccion = new TextBox();
		txtDireccion.setMaxLength(200);
		txtDireccion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDireccion, 44, 486);
		txtDireccion.setSize("507px", "19px");
		
		Label label_20 = new Label("DIreccion Actual");
		label_20.setStyleName("label");
		absolutePanel.add(label_20, 42, 463);
		label_20.setSize("192px", "19px");
		
		ListBox listDireccionMunicipio = new ListBox();
		listDireccionMunicipio.addItem("mixco");
		listDireccionMunicipio.addItem("antigua guatemala");
		listDireccionMunicipio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDireccionMunicipio, 595, 486);
		listDireccionMunicipio.setSize("248px", "27px");
		
		Label label_21 = new Label("Municipio residencia");
		label_21.setStyleName("label");
		absolutePanel.add(label_21, 595, 463);
		label_21.setSize("192px", "19px");
		
		Label label_22 = new Label("Correo Electronico");
		label_22.setStyleName("label");
		absolutePanel.add(label_22, 42, 538);
		label_22.setSize("192px", "19px");
		
		TextBox txtCorreoElectronico = new TextBox();
		txtCorreoElectronico.setMaxLength(200);
		txtCorreoElectronico.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtCorreoElectronico, 44, 558);
		txtCorreoElectronico.setSize("227px", "19px");
		
		Label label_23 = new Label("Telefono de casa");
		label_23.setStyleName("label");
		absolutePanel.add(label_23, 323, 538);
		label_23.setSize("192px", "19px");
		
		Label label_24 = new Label("Telefono Celular");
		label_24.setStyleName("label");
		absolutePanel.add(label_24, 595, 538);
		label_24.setSize("192px", "19px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label label_25 = new Label("Licencia");
		label_25.setStyleName("label");
		absolutePanel.add(label_25, 42, 610);
		label_25.setSize("178px", "19px");
		
		Label label_26 = new Label("No. Licencia");
		label_26.setStyleName("label");
		absolutePanel.add(label_26, 595, 610);
		label_26.setSize("192px", "19px");
		
		ListBox listTipoLicencia = new ListBox();
		listTipoLicencia.addItem("A");
		listTipoLicencia.addItem("B");
		listTipoLicencia.addItem("C");
		listTipoLicencia.addItem("M");
		listTipoLicencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoLicencia, 323, 635);
		listTipoLicencia.setSize("248px", "27px");
		
		Label label_27 = new Label("Tipo Licencia");
		label_27.setStyleName("label");
		absolutePanel.add(label_27, 323, 610);
		label_27.setSize("192px", "19px");
		
		Label label_28 = new Label("Año de Nacimiento");
		label_28.setStyleName("label");
		absolutePanel.add(label_28, 323, 389);
		label_28.setSize("192px", "19px");
		
		DateBox dateAnnioNacimiento = new DateBox();
		dateAnnioNacimiento.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateAnnioNacimiento.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateAnnioNacimiento, 323, 414);
		dateAnnioNacimiento.setSize("228px", "18px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox");
		btnActualizar.setStyleName("gwt-TextBox");
		absolutePanel.add(btnActualizar, 325, 1029);
		btnActualizar.setSize("280px", "44px");
		
		Label lblFechaIngreso = new Label("Fecha Ingreso");
		lblFechaIngreso.setStyleName("label");
		absolutePanel.add(lblFechaIngreso, 595, 720);
		lblFechaIngreso.setSize("192px", "19px");
		
		TextBox txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(50);
		txtOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOcupacion, 321, 740);
		txtOcupacion.setSize("227px", "19px");
		
		Label lblOcupacion = new Label("Ocupacion");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 323, 720);
		lblOcupacion.setSize("192px", "19px");
		
		TextBox txtCentroTrabajo = new TextBox();
		txtCentroTrabajo.setMaxLength(50);
		txtCentroTrabajo.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtCentroTrabajo, 44, 740);
		txtCentroTrabajo.setSize("227px", "19px");
		
		Label lblCentroTrabajo = new Label("Centro Trabajo");
		lblCentroTrabajo.setStyleName("label");
		absolutePanel.add(lblCentroTrabajo, 42, 720);
		lblCentroTrabajo.setSize("192px", "19px");
		
		Label lblD = new Label("Datos del Patrono: (Uso exclusivo de la Fundacion");
		lblD.setStyleName("label");
		absolutePanel.add(lblD, 42, 681);
		lblD.setSize("449px", "19px");
		
		TextBox txt_CodigoOcupacion = new TextBox();
		txt_CodigoOcupacion.setMaxLength(50);
		txt_CodigoOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt_CodigoOcupacion, 44, 802);
		txt_CodigoOcupacion.setSize("227px", "19px");
		
		Label lblCodigoOcupacion = new Label("Codigo Ocupacion");
		lblCodigoOcupacion.setStyleName("label");
		absolutePanel.add(lblCodigoOcupacion, 42, 782);
		lblCodigoOcupacion.setSize("192px", "19px");
		
		TextBox txtProfesion = new TextBox();
		txtProfesion.setMaxLength(50);
		txtProfesion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtProfesion, 321, 802);
		txtProfesion.setSize("227px", "19px");
		
		Label lblProfesion = new Label("profesion");
		lblProfesion.setStyleName("label");
		absolutePanel.add(lblProfesion, 323, 782);
		lblProfesion.setSize("192px", "19px");
		
		TextBox txtTipoPlanilla = new TextBox();
		txtTipoPlanilla.setMaxLength(50);
		txtTipoPlanilla.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTipoPlanilla, 596, 802);
		txtTipoPlanilla.setSize("227px", "19px");
		
		Label lblTipoPlanilla = new Label("Tipo Planilla");
		lblTipoPlanilla.setStyleName("label");
		absolutePanel.add(lblTipoPlanilla, 595, 782);
		lblTipoPlanilla.setSize("192px", "19px");
		
		Label lblBonificacion = new Label("Bonificacion");
		lblBonificacion.setStyleName("label");
		absolutePanel.add(lblBonificacion, 323, 854);
		lblBonificacion.setSize("192px", "19px");
		
		Label lblTotal = new Label("Total");
		lblTotal.setStyleName("label");
		absolutePanel.add(lblTotal, 595, 854);
		lblTotal.setSize("192px", "19px");
		
		Label lblSalarioBase = new Label("Salario Base");
		lblSalarioBase.setStyleName("label");
		absolutePanel.add(lblSalarioBase, 42, 849);
		lblSalarioBase.setSize("192px", "19px");
		
		DateBox dateFecha_Ingreso = new DateBox();
		dateFecha_Ingreso.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha_Ingreso.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha_Ingreso, 595, 739);
		dateFecha_Ingreso.setSize("228px", "18px");
		
		ListBox listLicencia = new ListBox();
		listLicencia.addItem("Si");
		listLicencia.addItem("No");
		listLicencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(listLicencia, 42, 635);
		listLicencia.setSize("248px", "27px");
		
		ListBox listBox_9 = new ListBox();
		listBox_9.addItem("Si");
		listBox_9.addItem("No");
		listBox_9.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_9, 42, 343);
		listBox_9.setSize("248px", "27px");
		
		IntegerBox txtNit = new IntegerBox();
		txtNit.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNit, 323, 217);
		txtNit.setSize("227px", "19px");
		
		IntegerBox txtRegistro = new IntegerBox();
		txtRegistro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtRegistro, 323, 280);
		txtRegistro.setSize("227px", "19px");
		
		TextBox txtNoOrden = new TextBox();
		txtNoOrden.setStyleName("gwt-TextBox2");
		txtNoOrden.setMaxLength(50);
		absolutePanel.add(txtNoOrden, 42, 287);
		txtNoOrden.setSize("227px", "19px");
		
		IntegerBox txtDPI = new IntegerBox();
		txtDPI.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDPI, 595, 280);
		txtDPI.setSize("227px", "19px");
		
		IntegerBox txtTelefonoCasa = new IntegerBox();
		txtTelefonoCasa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCasa, 324, 558);
		txtTelefonoCasa.setSize("227px", "19px");
		
		IntegerBox txtTelefonoCelular = new IntegerBox();
		txtTelefonoCelular.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCelular, 596, 558);
		txtTelefonoCelular.setSize("227px", "19px");
		
		IntegerBox txtNoLicencia = new IntegerBox();
		txtNoLicencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNoLicencia, 596, 635);
		txtNoLicencia.setSize("227px", "19px");
		
		IntegerBox txtSalarioBase = new IntegerBox();
		txtSalarioBase.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSalarioBase, 43, 874);
		txtSalarioBase.setSize("227px", "19px");
		
		IntegerBox txtBonificacion = new IntegerBox();
		txtBonificacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtBonificacion, 323, 874);
		txtBonificacion.setSize("227px", "19px");
		
		IntegerBox txtTotal = new IntegerBox();
		txtTotal.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTotal, 595, 874);
		txtTotal.setSize("227px", "19px");
	}
}
