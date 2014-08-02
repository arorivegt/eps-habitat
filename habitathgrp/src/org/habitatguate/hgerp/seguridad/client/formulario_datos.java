package org.habitatguate.hgerp.seguridad.client;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

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

public class formulario_datos extends Composite {

	private Long id_empleado = 0L;
	private boolean bandera = true;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
	private Empleados empleado;
	
	public formulario_datos(Empleados e) {
		this.empleado = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("890px", "1055px");
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
		
		final ListBox listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("Soltero/a");
		listEstadoCivil.addItem("Casado/a");
		listEstadoCivil.addItem("Divorciado/a");
		listEstadoCivil.addItem("Viudo/a");
		listEstadoCivil.addItem("Separado/a");
		listEstadoCivil.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstadoCivil, 324, 28);
		listEstadoCivil.setSize("247px", "27px");
		
		final ListBox listSexo = new ListBox();
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
		
		final TextBox txtPrimerApellido = new TextBox();
		txtPrimerApellido.setMaxLength(50);
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerApellido, 43, 88);
		txtPrimerApellido.setSize("227px", "19px");
		
		final TextBox txtSegundoApellido = new TextBox();
		txtSegundoApellido.setMaxLength(50);
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundoApellido, 324, 88);
		txtSegundoApellido.setSize("227px", "19px");
		
		final TextBox txtApellidoCasada = new TextBox();
		txtApellidoCasada.setMaxLength(50);
		txtApellidoCasada.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtApellidoCasada, 596, 88);
		txtApellidoCasada.setSize("227px", "19px");
		
		final IntegerBox txtNo_iggs = new IntegerBox();
		txtNo_iggs.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtNo_iggs.getText().equals("")) {txtNo_iggs.setText("0");}
				else if(txtNo_iggs.getText().equals(null)) {txtNo_iggs.setText("0");}
				else{
					try{
						Integer.parseInt(txtNo_iggs.getText());
					}catch(Exception e){
						Window.alert("No igss no valido");
						txtNo_iggs.setText("0");
					}
				}
			}
		});
		txtNo_iggs.setText("0");
		txtNo_iggs.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNo_iggs, 43, 28);
		txtNo_iggs.setSize("227px", "19px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 42, 131);
		label_6.setSize("192px", "19px");
		
		final TextBox txtPrimerNombre = new TextBox();
		txtPrimerNombre.setMaxLength(50);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerNombre, 43, 149);
		txtPrimerNombre.setSize("227px", "19px");
		
		final TextBox txtSegundoNombre = new TextBox();
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
		
		final ListBox listPais = new ListBox();
		listPais.addItem("Afganistán");
		listPais.addItem("Albania");
		listPais.addItem("Alemania");
		listPais.addItem("Andorra");
		listPais.addItem("Angola");
		listPais.addItem("Antigua y Barbuda");
		listPais.addItem("Arabia Saudita");
		listPais.addItem("Argelia");
		listPais.addItem("Argentina");
		listPais.addItem("Armenia");
		listPais.addItem("Australia");
		listPais.addItem("Austria");
		listPais.addItem("Azerbaiyán");
		listPais.addItem("Bahamas");
		listPais.addItem("Bangladés");
		listPais.addItem("Barbados");
		listPais.addItem("Baréin");
		listPais.addItem("Bélgica");
		listPais.addItem("Belice");
		listPais.addItem("Benín");
		listPais.addItem("Bielorrusia");
		listPais.addItem("Birmania");
		listPais.addItem("Bolivia");
		listPais.addItem("Bosnia y Herzegovina");
		listPais.addItem("Botsuana");
		listPais.addItem("Brasil");
		listPais.addItem("Brunéi");
		listPais.addItem("Bulgaria");
		listPais.addItem("Burkina Faso");
		listPais.addItem("Burundi");
		listPais.addItem("Bután");
		listPais.addItem("Cabo Verde");
		listPais.addItem("Camboya");
		listPais.addItem("Camerún");
		listPais.addItem("Canadá");
		listPais.addItem("Catar");
		listPais.addItem("Chad");
		listPais.addItem("Chile");
		listPais.addItem("China");
		listPais.addItem("Chipre");
		listPais.addItem("Ciudad del Vaticano");
		listPais.addItem("Colombia");
		listPais.addItem("Comoras");
		listPais.addItem("Corea del Norte");
		listPais.addItem("Corea del Sur");
		listPais.addItem("Costa de Marfil");
		listPais.addItem("Costa Rica");
		listPais.addItem("Croacia");
		listPais.addItem("Cuba");
		listPais.addItem("Dinamarca");
		listPais.addItem("Dominica");
		listPais.addItem("Ecuador");
		listPais.addItem("Egipto");
		listPais.addItem("El Salvador");
		listPais.addItem("Emiratos Árabes Unidos");
		listPais.addItem("Eritrea");
		listPais.addItem("Eslovaquia");
		listPais.addItem("Eslovenia");
		listPais.addItem("España");
		listPais.addItem("Estados Unidos");
		listPais.addItem("Estonia");
		listPais.addItem("Etiopía");
		listPais.addItem("Filipinas");
		listPais.addItem("Finlandia");
		listPais.addItem("Fiyi");
		listPais.addItem("Francia");
		listPais.addItem("Gabón");
		listPais.addItem("Gambia");
		listPais.addItem("Georgia");
		listPais.addItem("Ghana");
		listPais.addItem("Granada");
		listPais.addItem("Grecia");
		listPais.addItem("Guatemala");
		listPais.addItem("Guyana");
		listPais.addItem("Guinea");
		listPais.addItem("Guinea ecuatorial");
		listPais.addItem("Guinea-Bisáu");
		listPais.addItem("Haití");
		listPais.addItem("Honduras");
		listPais.addItem("Hungría");
		listPais.addItem("India");
		listPais.addItem("Indonesia");
		listPais.addItem("Irak");
		listPais.addItem("Irán");
		listPais.addItem("Irlanda");
		listPais.addItem("Islandia");
		listPais.addItem("Islas Marshall");
		listPais.addItem("Islas Salomón");
		listPais.addItem("Israel");
		listPais.addItem("Italia");
		listPais.addItem("Jamaica");
		listPais.addItem("Japón");
		listPais.addItem("Jordania");
		listPais.addItem("Kazajistán");
		listPais.addItem("Kenia");
		listPais.addItem("Kirguistán");
		listPais.addItem("Kiribati");
		listPais.addItem("Kuwait");
		listPais.addItem("Laos");
		listPais.addItem("Lesoto");
		listPais.addItem("Letonia");
		listPais.addItem("Líbano");
		listPais.addItem("Liberia");
		listPais.addItem("Libia");
		listPais.addItem("Liechtenstein");
		listPais.addItem("Lituania");
		listPais.addItem("Luxemburgo");
		listPais.addItem("Madagascar");
		listPais.addItem("Malasia");
		listPais.addItem("Malaui");
		listPais.addItem("Maldivas");
		listPais.addItem("Malí");
		listPais.addItem("Malta");
		listPais.addItem("Marruecos");
		listPais.addItem("Mauricio");
		listPais.addItem("Mauritania");
		listPais.addItem("México");
		listPais.addItem("Micronesia");
		listPais.addItem("Moldavia");
		listPais.addItem("Mónaco");
		listPais.addItem("Mongolia");
		listPais.addItem("Montenegro");
		listPais.addItem("Mozambique");
		listPais.addItem("Namibia");
		listPais.addItem("Nauru");
		listPais.addItem("Nepal");
		listPais.addItem("Nicaragua");
		listPais.addItem("Níger");
		listPais.addItem("Nigeria");
		listPais.addItem("Noruega");
		listPais.addItem("Nueva Zelanda");
		listPais.addItem("Omán");
		listPais.addItem("Países Bajos");
		listPais.addItem("Pakistán");
		listPais.addItem("Palaos");
		listPais.addItem("Panamá");
		listPais.addItem("Papúa Nueva Guinea");
		listPais.addItem("Paraguay");
		listPais.addItem("Perú");
		listPais.addItem("Polonia");
		listPais.addItem("Portugal");
		listPais.addItem("Reino Unido");
		listPais.addItem("República Centroafricana");
		listPais.addItem("República Checa");
		listPais.addItem("República de Macedonia");
		listPais.addItem("República del Congo");
		listPais.addItem("República Democrática del Congo");
		listPais.addItem("República Dominicana");
		listPais.addItem("República Sudafricana");
		listPais.addItem("Ruanda");
		listPais.addItem("Rumanía");
		listPais.addItem("Rusia");
		listPais.addItem("Samoa");
		listPais.addItem("San Cristóbal y Nieves");
		listPais.addItem("San Marino");
		listPais.addItem("San Vicente y las Granadinas");
		listPais.addItem("Santa Lucía");
		listPais.addItem("Santo Tomé y Príncipe");
		listPais.addItem("Senegal");
		listPais.addItem("Serbia");
		listPais.addItem("Seychelles");
		listPais.addItem("Sierra Leona");
		listPais.addItem("Singapur");
		listPais.addItem("Siria");
		listPais.addItem("Somalia");
		listPais.addItem("Sri Lanka");
		listPais.addItem("Suazilandia");
		listPais.addItem("Sudán");
		listPais.addItem("Sudán del Sur");
		listPais.addItem("Suecia");
		listPais.addItem("Suiza");
		listPais.addItem("Surinam");
		listPais.addItem("Tailandia");
		listPais.addItem("Tanzania");
		listPais.addItem("Tayikistán");
		listPais.addItem("Timor Oriental");
		listPais.addItem("Togo");
		listPais.addItem("Tonga");
		listPais.addItem("Trinidad y Tobago");
		listPais.addItem("Túnez");
		listPais.addItem("Turkmenistán");
		listPais.addItem("Turquía");
		listPais.addItem("Tuvalu");
		listPais.addItem("Ucrania");
		listPais.addItem("Uganda");
		listPais.addItem("Uruguay");
		listPais.addItem("Uzbekistán");
		listPais.addItem("Vanuatu");
		listPais.addItem("Venezuela");
		listPais.addItem("Vietnam");
		listPais.addItem("Yemen");
		listPais.addItem("Yibuti");
		listPais.addItem("Zambia");
		listPais.addItem("Zimbabue");
		listPais.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPais, 596, 149);
		listPais.setSize("247px", "27px");
		
		Label label_9 = new Label("Tipo Empleado");
		label_9.setStyleName("label");
		absolutePanel.add(label_9, 42, 182);
		label_9.setSize("192px", "19px");
		
		Label label_10 = new Label("Nit");
		label_10.setStyleName("label");
		absolutePanel.add(label_10, 323, 199);
		label_10.setSize("192px", "19px");
		
		final ListBox listNoDependientes = new ListBox();
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
		
		final TextBox txtTipoPasaporte = new TextBox();
		txtTipoPasaporte.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTipoPasaporte, 321, 343);
		txtTipoPasaporte.setSize("227px", "19px");
		
		Label label_16 = new Label("Tipo Pasaporte");
		label_16.setStyleName("label");
		absolutePanel.add(label_16, 319, 325);
		label_16.setSize("192px", "19px");
		
		Label label_17 = new Label("No. Pasaporte");
		label_17.setStyleName("label");
		absolutePanel.add(label_17, 592, 325);
		label_17.setSize("192px", "19px");
		
		Label lblCedulaExtendidamunicipio = new Label("Cedula extendida-Municipio");
		lblCedulaExtendidamunicipio.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidamunicipio, 323, 396);
		lblCedulaExtendidamunicipio.setSize("192px", "19px");
		
		final ListBox listCedulaMunicipio = new ListBox();
		listCedulaMunicipio.addItem("Chahal");
		listCedulaMunicipio.addItem("Chisec");
		listCedulaMunicipio.addItem("Cobán");
		listCedulaMunicipio.addItem("Fray Bartolomé de las Casas");
		listCedulaMunicipio.addItem("La Tinta");
		listCedulaMunicipio.addItem("Lanquín");
		listCedulaMunicipio.addItem("Panzós");
		listCedulaMunicipio.addItem("Raxruhá");
		listCedulaMunicipio.addItem("San Cristóbal Verapaz");
		listCedulaMunicipio.addItem("San Juan Chamelco");
		listCedulaMunicipio.addItem("San Pedro Carchá");
		listCedulaMunicipio.addItem("Santa Cruz Verapaz");
		listCedulaMunicipio.addItem("Santa María Cahabón");
		listCedulaMunicipio.addItem("Senahú");
		listCedulaMunicipio.addItem("Tamahú");
		listCedulaMunicipio.addItem("Tactic");
		listCedulaMunicipio.addItem("Tucurú");
		listCedulaMunicipio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listCedulaMunicipio, 323, 421);
		listCedulaMunicipio.setSize("248px", "27px");
		
		final TextBox txtDireccion = new TextBox();
		txtDireccion.setMaxLength(200);
		txtDireccion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDireccion, 44, 486);
		txtDireccion.setSize("227px", "19px");
		
		Label label_20 = new Label("DIreccion Actual");
		label_20.setStyleName("label");
		absolutePanel.add(label_20, 42, 463);
		label_20.setSize("192px", "19px");
		
		final ListBox listDireccionMunicipio = new ListBox();
		listDireccionMunicipio.addItem("Tucurú");
		listDireccionMunicipio.addItem("Tactic");
		listDireccionMunicipio.addItem("Tamahú");
		listDireccionMunicipio.addItem("Senahú");
		listDireccionMunicipio.addItem("Santa María Cahabón");
		listDireccionMunicipio.addItem("Santa Cruz Verapaz");
		listDireccionMunicipio.addItem("San Pedro Carchá");
		listDireccionMunicipio.addItem("San Juan Chamelco");
		listDireccionMunicipio.addItem("San Cristóbal Verapaz");
		listDireccionMunicipio.addItem("Raxruhá");
		listDireccionMunicipio.addItem("Panzós");
		listDireccionMunicipio.addItem("Lanquín");
		listDireccionMunicipio.addItem("La Tinta");
		listDireccionMunicipio.addItem("Fray Bartolomé de las Casas");
		listDireccionMunicipio.addItem("Cobán");
		listDireccionMunicipio.addItem("Chisec");
		listDireccionMunicipio.addItem("Chahal");
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
		
		final TextBox txtCorreoElectronico = new TextBox();
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
		
		final ListBox listTipoLicencia = new ListBox();
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
		absolutePanel.add(label_28, 595, 389);
		label_28.setSize("192px", "19px");
		
		final DateBox dateAnnioNacimiento = new DateBox();
		dateAnnioNacimiento.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateAnnioNacimiento.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateAnnioNacimiento, 595, 414);
		dateAnnioNacimiento.setSize("228px", "18px");
		
		Label lblFechaIngreso = new Label("Fecha Ingreso");
		lblFechaIngreso.setStyleName("label");
		absolutePanel.add(lblFechaIngreso, 595, 720);
		lblFechaIngreso.setSize("192px", "19px");
		
		final TextBox txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(50);
		txtOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOcupacion, 321, 740);
		txtOcupacion.setSize("227px", "19px");
		
		Label lblOcupacion = new Label("Ocupacion");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 323, 720);
		lblOcupacion.setSize("192px", "19px");
		
		final TextBox txtCentroTrabajo = new TextBox();
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
		
		final TextBox txt_CodigoOcupacion = new TextBox();
		txt_CodigoOcupacion.setMaxLength(50);
		txt_CodigoOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt_CodigoOcupacion, 44, 802);
		txt_CodigoOcupacion.setSize("227px", "19px");
		
		Label lblCodigoOcupacion = new Label("Codigo Ocupacion");
		lblCodigoOcupacion.setStyleName("label");
		absolutePanel.add(lblCodigoOcupacion, 42, 782);
		lblCodigoOcupacion.setSize("192px", "19px");
		
		final TextBox txtProfesion = new TextBox();
		txtProfesion.setMaxLength(50);
		txtProfesion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtProfesion, 321, 802);
		txtProfesion.setSize("227px", "19px");
		
		Label lblProfesion = new Label("profesion");
		lblProfesion.setStyleName("label");
		absolutePanel.add(lblProfesion, 323, 782);
		lblProfesion.setSize("192px", "19px");
		
		final TextBox txtTipoPlanilla = new TextBox();
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
		
		final DateBox dateFechaIngreso = new DateBox();
		dateFechaIngreso.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFechaIngreso.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFechaIngreso, 595, 739);
		dateFechaIngreso.setSize("228px", "18px");
		
		final ListBox listLicencia = new ListBox();
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
		
		final IntegerBox txtRegistro = new IntegerBox();
		txtRegistro.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtRegistro.getText().equals("")) {txtRegistro.setText("0");}
				else if(txtRegistro.getText().equals(null)) {txtRegistro.setText("0");}
				else{
					try{
						Integer.parseInt(txtRegistro.getText());
					}catch(Exception e){
						Window.alert("No Registro no valido");
						txtRegistro.setText("0");
					}
				}
			}
		});
		txtRegistro.setText("0");
		txtRegistro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtRegistro, 323, 280);
		txtRegistro.setSize("227px", "19px");
		
		final TextBox txtNoOrden = new TextBox();
		txtNoOrden.setStyleName("gwt-TextBox2");
		txtNoOrden.setMaxLength(50);
		absolutePanel.add(txtNoOrden, 42, 287);
		txtNoOrden.setSize("227px", "19px");
		
		final IntegerBox txtDPI = new IntegerBox();
		txtDPI.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtDPI.getText().equals("")) {txtDPI.setText("0");}
				else if(txtDPI.getText().equals(null)) {txtDPI.setText("0");}
				else{
					try{
						Integer.parseInt(txtDPI.getText());
					}catch(Exception e){
						Window.alert("DPI no valido");
						txtDPI.setText("0");
					}
				}
			}
		});
		txtDPI.setText("0");
		txtDPI.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDPI, 595, 280);
		txtDPI.setSize("227px", "19px");
		
		
		final IntegerBox txtTelefonoCasa = new IntegerBox();
		txtTelefonoCasa.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoCasa.getText().equals("")) {txtTelefonoCasa.setText("0");}
				else if(txtTelefonoCasa.getText().equals(null)) {txtTelefonoCasa.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoCasa.getText());
					}catch(Exception e){
						Window.alert("No Telefono no valido");
						txtTelefonoCasa.setText("0");
					}
				}
			}
		});
		txtTelefonoCasa.setText("0");
		txtTelefonoCasa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCasa, 324, 558);
		txtTelefonoCasa.setSize("227px", "19px");
		
		final IntegerBox txtTelefonoCelular = new IntegerBox();
		txtTelefonoCelular.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoCelular.getText().equals("")) {txtTelefonoCelular.setText("0");}
				else if(txtTelefonoCelular.getText().equals(null)) {txtTelefonoCelular.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoCelular.getText());
					}catch(Exception e){
						Window.alert("No Celular no valido");
						txtTelefonoCelular.setText("0");
					}
				}
			}
		});
		txtTelefonoCelular.setText("0");
		txtTelefonoCelular.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCelular, 596, 558);
		txtTelefonoCelular.setSize("227px", "19px");
		
		final IntegerBox txtNoLicencia = new IntegerBox();
		txtNoLicencia.setText("0");
		txtNoLicencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNoLicencia, 596, 635);
		txtNoLicencia.setSize("227px", "19px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox");
		btnActualizar.setStyleName("gwt-TextBox");
		absolutePanel.add(btnActualizar, 375, 992);
		btnActualizar.setSize("280px", "44px");
		
		final TextBox txtNit = new TextBox();
		txtNit.setStyleName("gwt-TextBox2");
		txtNit.setMaxLength(50);
		absolutePanel.add(txtNit, 324, 217);
		txtNit.setSize("227px", "19px");
		
		final IntegerBox txtNoPasaporte = new IntegerBox();
		txtNoPasaporte.setText("0");
		txtNoPasaporte.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNoPasaporte, 596, 343);
		txtNoPasaporte.setSize("227px", "19px");
		
		final TextBox txtSalarioBase = new TextBox();
		txtSalarioBase.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalarioBase.getText().equals("")) {txtSalarioBase.setText("0");}
				else if(txtSalarioBase.getText().equals(null)) {txtSalarioBase.setText("0");}
				else{
					try{
						Float.parseFloat(txtSalarioBase.getText());
					}catch(Exception e){
						Window.alert("Salario no valido");
						txtSalarioBase.setText("0.0");
					}
				}
			}
		});
		txtSalarioBase.setText("0.0");
		txtSalarioBase.setStyleName("gwt-TextBox2");
		txtSalarioBase.setMaxLength(50);
		absolutePanel.add(txtSalarioBase, 42, 878);
		txtSalarioBase.setSize("227px", "19px");
		
		final TextBox txtBonificacion = new TextBox();
		txtBonificacion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtBonificacion.getText().equals("")) {txtBonificacion.setText("0");}
				else if(txtBonificacion.getText().equals(null)) {txtBonificacion.setText("0");}
				else{
					try{
						Float.parseFloat(txtBonificacion.getText());
					}catch(Exception e){
						Window.alert("Bonificacion no valido");
						txtBonificacion.setText("0.0");
					}
				}
			}
		});
		txtBonificacion.setText("0.0");
		txtBonificacion.setStyleName("gwt-TextBox2");
		txtBonificacion.setMaxLength(50);
		absolutePanel.add(txtBonificacion, 323, 879);
		txtBonificacion.setSize("227px", "19px");
		
		final TextBox txtTotal = new TextBox();
		txtTotal.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTotal.getText().equals("")) {txtTotal.setText("0");}
				else if(txtTotal.getText().equals(null)) {txtTotal.setText("0");}
				else{
					try{
						Float.parseFloat(txtTotal.getText());
					}catch(Exception e){
						Window.alert("Total no valido");
						txtTotal.setText("0.0");
					}
				}
			}
		});
		txtTotal.setText("0.0");
		txtTotal.setStyleName("gwt-TextBox2");
		txtTotal.setMaxLength(50);
		absolutePanel.add(txtTotal, 596, 879);
		txtTotal.setSize("227px", "19px");
		
		final ListBox listCedulaDepartamento = new ListBox();
		listCedulaDepartamento.addItem("Alta Verapaz");
		listCedulaDepartamento.addItem("Baja Verapaz");
		listCedulaDepartamento.addItem("Chimaltenango");
		listCedulaDepartamento.addItem("Chiquimula");
		listCedulaDepartamento.addItem("El Progreso");
		listCedulaDepartamento.addItem("Escuintla");
		listCedulaDepartamento.addItem("Guatemala");
		listCedulaDepartamento.addItem("Huehuetenango");
		listCedulaDepartamento.addItem("Izabal");
		listCedulaDepartamento.addItem("Jalapa");
		listCedulaDepartamento.addItem("Jutiapa");
		listCedulaDepartamento.addItem("Petén");
		listCedulaDepartamento.addItem("Quezaltenango");
		listCedulaDepartamento.addItem("Quiché");
		listCedulaDepartamento.addItem("Retalhuleu");
		listCedulaDepartamento.addItem("Sacatepéquez");
		listCedulaDepartamento.addItem("San Marcos");
		listCedulaDepartamento.addItem("Santa Rosa");
		listCedulaDepartamento.addItem("Sololá");
		listCedulaDepartamento.addItem("Suchitepéquez");
		listCedulaDepartamento.addItem("Totonicapán");
		listCedulaDepartamento.addItem("Zacapa");
		listCedulaDepartamento.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listCedulaMunicipio.clear();
		        String[] numerosComoArray = Depto_Municipio(listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex())).split(",");
		        for (int i = 0; i < numerosComoArray.length; i++) {
		        	listCedulaMunicipio.addItem(numerosComoArray[i]);
		        }
			}		
		});
		listCedulaDepartamento.setStyleName("gwt-TextBox2");
		absolutePanel.add(listCedulaDepartamento, 42, 421);
		listCedulaDepartamento.setSize("248px", "27px");
		
		Label lblCedulaExtendidadepartamento = new Label("Cedula extendida-Departamento");
		lblCedulaExtendidadepartamento.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidadepartamento, 42, 396);
		lblCedulaExtendidadepartamento.setSize("192px", "19px");
		
		final ListBox listDireccionDepartamento = new ListBox();
		listDireccionDepartamento.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listDireccionMunicipio.clear();
		        String[] numerosComoArray = Depto_Municipio(listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex())).split(",");
		        for (int i = 0; i < numerosComoArray.length; i++) {
		        	listDireccionMunicipio.addItem(numerosComoArray[i]);
		        }
			}
		});
		listDireccionDepartamento.addItem("Alta Verapaz");
		listDireccionDepartamento.addItem("Baja Verapaz");
		listDireccionDepartamento.addItem("Chimaltenango");
		listDireccionDepartamento.addItem("Chiquimula");
		listDireccionDepartamento.addItem("El Progreso");
		listDireccionDepartamento.addItem("Escuintla");
		listDireccionDepartamento.addItem("Guatemala");
		listDireccionDepartamento.addItem("Huehuetenango");
		listDireccionDepartamento.addItem("Izabal");
		listDireccionDepartamento.addItem("Jalapa");
		listDireccionDepartamento.addItem("Jutiapa");
		listDireccionDepartamento.addItem("Petén");
		listDireccionDepartamento.addItem("Quezaltenango");
		listDireccionDepartamento.addItem("Quiché");
		listDireccionDepartamento.addItem("Retalhuleu");
		listDireccionDepartamento.addItem("Sacatepéquez");
		listDireccionDepartamento.addItem("San Marcos");
		listDireccionDepartamento.addItem("Santa Rosa");
		listDireccionDepartamento.addItem("Sololá");
		listDireccionDepartamento.addItem("Suchitepéquez");
		listDireccionDepartamento.addItem("Totonicapán");
		listDireccionDepartamento.addItem("Zacapa");
		listDireccionDepartamento.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDireccionDepartamento, 323, 488);
		listDireccionDepartamento.setSize("248px", "27px");
		
		Label label = new Label("Cedula extendida-Departamento");
		label.setStyleName("label");
		absolutePanel.add(label, 323, 463);
		label.setSize("192px", "19px");
		
		final TextBox txtConIVS = new TextBox();
		txtConIVS.setText("0");
		txtConIVS.setStyleName("gwt-TextBox2");
		txtConIVS.setMaxLength(50);
		absolutePanel.add(txtConIVS, 43, 217);
		txtConIVS.setSize("101px", "19px");
		
		final TextBox txtSinIVS = new TextBox();
		txtSinIVS.setText("0");
		txtSinIVS.setStyleName("gwt-TextBox2");
		txtSinIVS.setMaxLength(50);
		absolutePanel.add(txtSinIVS, 169, 217);
		txtSinIVS.setSize("101px", "19px");
		
		Label lblConIvs = new Label("con IVS");
		lblConIvs.setStyleName("label");
		absolutePanel.add(lblConIvs, 42, 199);
		lblConIvs.setSize("97px", "19px");
		
		Label lblSinIvs = new Label("Sin IVS");
		lblSinIvs.setStyleName("label");
		absolutePanel.add(lblSinIvs, 176, 199);
		lblSinIvs.setSize("97px", "19px");
		
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if(bandera){
					depto_municipio_uno = listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex()) + "," +listCedulaMunicipio.getItemText(listCedulaMunicipio.getSelectedIndex());
					depto_municipio_uno = listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getItemText(listDireccionMunicipio.getSelectedIndex());
					
					loginService.Insertar_Emppleado(txtNo_iggs.getValue(), listEstadoCivil.getItemText(listEstadoCivil.getSelectedIndex()), 
							listSexo.getItemText(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtConIVS.getText(), txtSinIVS.getText(), 
							listPais.getItemText(listPais.getSelectedIndex()),txtNit.getText(),Integer.parseInt(listNoDependientes.getItemText(listPais.getSelectedIndex())),
							txtNoOrden.getText(), txtRegistro.getValue(), txtDPI.getValue(), txtTipoPasaporte.getText(), txtNoPasaporte.getValue(), 
							depto_municipio_uno, txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getValue(), 
							txtTelefonoCelular.getValue(), dateAnnioNacimiento.getValue(), listTipoLicencia.getItemText(listTipoLicencia.getSelectedIndex()), 
							txtNoLicencia.getValue(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), new AsyncCallback<Long>() 
	                        {
	                            public void onFailure(Throwable caught) 
	                            {
	                                Window.alert("Error  al Guardar Datos");
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {

	                            	id_empleado = result;
	                            	empleado.id_empleado = result;
	                            	bandera = false;
	                            	empleado.Nuevas_Pestañas();
	                                Window.alert("Nuevo Empleado Guardados exitosamente!!! "+id_empleado);
	                            }

	                     });
				}else{
					if(txtNo_iggs.getValue().equals(null)) {txtNo_iggs.setValue(0);}
					if(txtRegistro.getValue().equals(null)) {txtRegistro.setValue(0);}
					if(txtDPI.getValue().equals(null)) {txtDPI.setValue(0);}
					if(txtNoPasaporte.getValue().equals(null)) {txtNoPasaporte.setValue(0);}
					if(txtTelefonoCasa.getValue().equals(null)) {txtTelefonoCasa.setValue(0);}
					if(txtTelefonoCelular.getValue().equals(null)) {txtTelefonoCelular.setValue(0);}
					if(txtNoLicencia.getValue().equals(null)) {txtNoLicencia.setValue(0);}
					if(txtSalarioBase.getValue().equals(null)) {txtSalarioBase.setValue("0");}
					if(txtBonificacion.getValue().equals(null)) {txtBonificacion.setValue("0");}
					if(txtTotal.getValue().equals(null)) {txtTotal.setValue("0");}
					depto_municipio_uno = listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex()) + "," +listCedulaMunicipio.getItemText(listCedulaMunicipio.getSelectedIndex());
					depto_municipio_uno = listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getItemText(listDireccionMunicipio.getSelectedIndex());
					
					loginService.Actualizar_Emppleado(id_empleado,txtNo_iggs.getValue(), listEstadoCivil.getItemText(listEstadoCivil.getSelectedIndex()), 
							listSexo.getItemText(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtConIVS.getText(), txtSinIVS.getText(), 
							listPais.getItemText(listPais.getSelectedIndex()),txtNit.getText(),Integer.parseInt(listNoDependientes.getItemText(listPais.getSelectedIndex())),
							txtNoOrden.getText(), txtRegistro.getValue(), txtDPI.getValue(), txtTipoPasaporte.getText(), txtNoPasaporte.getValue(), 
							depto_municipio_uno, txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getValue(), 
							txtTelefonoCelular.getValue(), dateAnnioNacimiento.getValue(), listTipoLicencia.getItemText(listTipoLicencia.getSelectedIndex()), 
							txtNoLicencia.getValue(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), new AsyncCallback<Long>() 
	                        {
	                            public void onFailure(Throwable caught) 
	                            {
	                                Window.alert("Error al Actualizar Datos");
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {
	                            	bandera = false;
	                            	empleado.Nuevas_Pestañas();
	                                Window.alert("Datos Actualizados exitosamente!!! "+id_empleado);
	                            }

	                     });
					
				}
				
			}
		});
	}
	
	private String Depto_Municipio(String Departamento){
		String valor = "";
		if(Departamento.equals("Alta Verapaz")){
			valor = valor + "," + "Chahal";
			valor = valor + "," + "Chisec";
			valor = valor + "," + "Cobán";
			valor = valor + "," + "Fray Bartolomé de las Casas";
			valor = valor + "," + "La Tinta";
			valor = valor + "," + "Lanquín";
			valor = valor + "," + "Panzós";
			valor = valor + "," + "Raxruhá";
			valor = valor + "," + "San Cristóbal Verapaz";
			valor = valor + "," + "San Juan Chamelco";
			valor = valor + "," + "San Pedro Carchá";
			valor = valor + "," + "Santa Cruz Verapaz";
			valor = valor + "," + "Santa María Cahabón";
			valor = valor + "," + "Senahú";
			valor = valor + "," + "Tamahú";
			valor = valor + "," + "Tactic";
			valor = valor + "," + "Tucurú";
			
		}else if(Departamento.equals("Baja Verapaz")){
			valor = valor + "," + "Cubulco";
			valor = valor + "," + "Granados";
			valor = valor + "," + "Purulhá";
			valor = valor + "," + "Rabinal";
			valor = valor + "," + "Salamá";
			valor = valor + "," + "San Jerónimo";
			valor = valor + "," + "San Miguel Chicaj";
			valor = valor + "," + "Santa Cruz el Chol";
			
		}else if(Departamento.equals("Chimaltenango")){
			valor = valor + "," + "Acatenango";
			valor = valor + "," + "Chimaltenango";
			valor = valor + "," + "El Tejar";
			valor = valor + "," + "Parramos";
			valor = valor + "," + "Patzicía";
			valor = valor + "," + "Patzún";
			valor = valor + "," + "Pochuta";
			valor = valor + "," + "San Andrés Itzapa";
			valor = valor + "," + "San José Poaquíl";
			valor = valor + "," + "San Juan Comalapa";
			valor = valor + "," + "San Martín Jilotepeque";
			valor = valor + "," + "Santa Apolonia";
			valor = valor + "," + "Santa Cruz Balanyá";
			valor = valor + "," + "Tecpán";
			valor = valor + "," + "Yepocapa";
			valor = valor + "," + "Zaragoza";
			
		}else if(Departamento.equals("Chiquimula")){
			
			valor = valor + "," + "Camotán";
			valor = valor + "," + "Chiquimula";
			valor = valor + "," + "Concepción Las Minas";
			valor = valor + "," + "Esquipulas";
			valor = valor + "," + "Ipala";
			valor = valor + "," + "Jocotán";
			valor = valor + "," + "Olopa";
			valor = valor + "," + "Quezaltepeque";
			valor = valor + "," + "San Jacinto";
			valor = valor + "," + "San José la Arada";
			valor = valor + "," + "San Juan Ermita";
			
		}else if(Departamento.equals("El Progreso")){
			valor = valor + "," + "El Jícaro";
			valor = valor + "," + "Guastatoya";
			valor = valor + "," + "Morazán";
			valor = valor + "," + "San Agustín Acasaguastlán";
			valor = valor + "," + "San Antonio La Paz";
			valor = valor + "," + "San Cristóbal Acasaguastlán";
			valor = valor + "," + "Sanarate";
			valor = valor + "," + "Sansare";
			
		}else if(Departamento.equals("Escuintla")){			
			valor = valor + "," + "Escuintla";
			valor = valor + "," + "Guanagazapa";
			valor = valor + "," + "Iztapa";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "La Gomera";
			valor = valor + "," + "Masagua";
			valor = valor + "," + "Nueva Concepción";
			valor = valor + "," + "Palín";
			valor = valor + "," + "San José";
			valor = valor + "," + "San Vicente Pacaya";
			valor = valor + "," + "Santa Lucía Cotzumalguapa";
			valor = valor + "," + "Siquinalá";
			valor = valor + "," + "Tiquisate";
			
		}else if(Departamento.equals("Guatemala")){	
			valor = valor + "," + "Amatitlán";
			valor = valor + "," + "Chinautla";
			valor = valor + "," + "Chuarrancho";
			valor = valor + "," + "Ciudad de Guatemala";
			valor = valor + "," + "Fraijanes";
			valor = valor + "," + "Mixco";
			valor = valor + "," + "Palencia";
			valor = valor + "," + "San José del Golfo";
			valor = valor + "," + "San José Pinula";
			valor = valor + "," + "San Juan Sacatepéquez";
			valor = valor + "," + "San Miguel Petapa";
			valor = valor + "," + "San Pedro Ayampuc";
			valor = valor + "," + "San Pedro Sacatepéquez";
			valor = valor + "," + "San Raymundo";
			valor = valor + "," + "Santa Catarina Pinula";
			valor = valor + "," + "Villa Canales";
			valor = valor + "," + "Villa Nueva";
			
		}else if(Departamento.equals("Huehuetenango")){
			valor = valor + "," + "Aguacatán";
			valor = valor + "," + "Chiantla";
			valor = valor + "," + "Colotenango";
			valor = valor + "," + "Concepción Huista";
			valor = valor + "," + "Cuilco";
			valor = valor + "," + "Huehuetenango";
			valor = valor + "," + "Jacaltenango";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "Malacatancito";
			valor = valor + "," + "Nentón";
			valor = valor + "," + "San Antonio Huista";
			valor = valor + "," + "San Gaspar Ixchil";
			valor = valor + "," + "San Ildefonso Ixtahuacán";
			valor = valor + "," + "San Juan Atitán";
			valor = valor + "," + "San Juan Ixcoy";
			valor = valor + "," + "San Mateo Ixtatán";
			valor = valor + "," + "San Miguel Acatán";
			valor = valor + "," + "San Pedro Nécta";
			valor = valor + "," + "San Pedro Soloma";
			valor = valor + "," + "San Rafael La Independencia";
			valor = valor + "," + "San Rafael Pétzal";
			valor = valor + "," + "San Sebastián Coatán";
			valor = valor + "," + "San Sebastián Huehuetenango";
			valor = valor + "," + "Santa Ana Huista";
			valor = valor + "," + "Santa Bárbara";
			valor = valor + "," + "Santa Cruz Barillas";
			valor = valor + "," + "Santa Eulalia";
			valor = valor + "," + "Santiago Chimaltenango";
			valor = valor + "," + "Tectitán";
			valor = valor + "," + " Santos Cuchumatán";
			valor = valor + "," + "Unión Cantinil";
			
		}else if(Departamento.equals("Izabal")){
			valor = valor + "," + "El Estor";
			valor = valor + "," + "Livingston";
			valor = valor + "," + "Los Amates";
			valor = valor + "," + "Morales";
			valor = valor + "," + "Puerto Barrios";
			
		}else if(Departamento.equals("Jalapa")){
			valor = valor + "," + "Jalapa";
			valor = valor + "," + "Mataquescuintla";
			valor = valor + "," + "Monjas";
			valor = valor + "," + "San Carlos Alzatate";
			valor = valor + "," + "San Luis Jilotepeque";
			valor = valor + "," + "San Manuel Chaparrón";
			valor = valor + "," + "San Pedro Pinula";
			
		}else if(Departamento.equals("Jutiapa")){
			valor = valor + "," + "Agua Blanca";
			valor = valor + "," + "Asunción Mita";
			valor = valor + "," + "Atescatempa";
			valor = valor + "," + "Comapa";
			valor = valor + "," + "Conguaco";
			valor = valor + "," + "El Adelanto";
			valor = valor + "," + "El Progreso";
			valor = valor + "," + "Jalpatagua";
			valor = valor + "," + "Jerez";
			valor = valor + "," + "Jutiapa";
			valor = valor + "," + "Moyuta";
			valor = valor + "," + "Pasaco";
			valor = valor + "," + "Quesada";
			valor = valor + "," + "San José Acatempa";
			valor = valor + "," + "Santa Catarina Mita";
			valor = valor + "," + "Yupiltepeque";
			valor = valor + "," + "Zapotitlán";
			
		}else if(Departamento.equals("Petén")){
			valor = valor + "," + "Dolores";
			valor = valor + "," + "El Chal";
			valor = valor + "," + "Flores";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "Las Cruces";
			valor = valor + "," + "Melchor de Mencos";
			valor = valor + "," + "Poptún";
			valor = valor + "," + "San Andrés";
			valor = valor + "," + "San Benito";
			valor = valor + "," + "San Francisco";
			valor = valor + "," + "San José";
			valor = valor + "," + "San Luis";
			valor = valor + "," + "Santa Ana";
			valor = valor + "," + "Sayaxché";
			
		}else if(Departamento.equals("Quezaltenango")){
			valor = valor + "," + "Almolonga";
			valor = valor + "," + "Cabricán";
			valor = valor + "," + "Cajolá";
			valor = valor + "," + "Cantel";
			valor = valor + "," + "Coatepeque";
			valor = valor + "," + "Colomba Costa Cuca";
			valor = valor + "," + "Concepción Chiquirichapa";
			valor = valor + "," + "El Palmar";
			valor = valor + "," + "Flores Costa Cuca";
			valor = valor + "," + "Génova";
			valor = valor + "," + "Huitán";
			valor = valor + "," + "La Esperanza";
			valor = valor + "," + "Olintepeque";
			valor = valor + "," + "Palestina de Los Altos";
			valor = valor + "," + "Quetzaltenango";
			valor = valor + "," + "Salcajá";
			valor = valor + "," + "San Carlos Sija";
			valor = valor + "," + "San Francisco La Unión";
			valor = valor + "," + "San Juan Ostuncalco";
			valor = valor + "," + "San Martín Sacatepéquez";
			valor = valor + "," + "San Mateo";
			valor = valor + "," + "San Miguel Sigüilá";
			valor = valor + "," + "Sibilia";
			valor = valor + "," + "Zunil";
			
		}else if(Departamento.equals("Quiché")){
			valor = valor + "," + "Canillá";
			valor = valor + "," + "Chajul";
			valor = valor + "," + "Chicamán";
			valor = valor + "," + "Chiché";
			valor = valor + "," + "Chichicastenango";
			valor = valor + "," + "Chinique";
			valor = valor + "," + "Cunén";
			valor = valor + "," + "Ixcán";
			valor = valor + "," + "Joyabaj";
			valor = valor + "," + "Nebaj";
			valor = valor + "," + "Pachalum";
			valor = valor + "," + "Patzité";
			valor = valor + "," + "Sacapulas";
			valor = valor + "," + "San Andrés Sajcabajá";
			valor = valor + "," + "San Antonio Ilotenango";
			valor = valor + "," + "San Bartolomé Jocotenango";
			valor = valor + "," + "San Juan Cotzal";
			valor = valor + "," + "San Pedro Jocopilas";
			valor = valor + "," + "Santa Cruz del Quiché";
			valor = valor + "," + "Uspantán";
			valor = valor + "," + "Zacualpa";
			
		}else if(Departamento.equals("Retalhuleu")){
			valor = valor + "," + "Champerico";
			valor = valor + "," + "El Asintal";
			valor = valor + "," + "Nuevo San Carlos";
			valor = valor + "," + "Retalhuleu";
			valor = valor + "," + "San Andrés Villa Seca";
			valor = valor + "," + "San Felipe";
			valor = valor + "," + "San Martín Zapotitlán";
			valor = valor + "," + "San Sebastián";
			valor = valor + "," + "Santa Cruz Muluá";
			
		}else if(Departamento.equals("Sacatepéquez")){
			valor = valor + "," + "Alotenango";
			valor = valor + "," + "Ciudad Vieja";
			valor = valor + "," + "Jocotenango";
			valor = valor + "," + "La Antigua Guatemala";
			valor = valor + "," + "Magdalena Milpas Altas";
			valor = valor + "," + "Pastores";
			valor = valor + "," + "San Antonio Aguas Calientes";
			valor = valor + "," + "San Bartolomé Milpas Altas";
			valor = valor + "," + "San Lucas Sacatepéquez";
			valor = valor + "," + "San Miguel Dueñas";
			valor = valor + "," + "Santa Catarina Barahona";
			valor = valor + "," + "Santa Lucía Milpas Altas";
			valor = valor + "," + "Santa María de Jesús";
			valor = valor + "," + "Santiago Sacatepéquez";
			valor = valor + "," + "Santo Domingo Xenacoj";
			valor = valor + "," + "Sumpango";;
			
		}else if(Departamento.equals("San Marcos")){
			valor = valor + "," + "Ayutla";
			valor = valor + "," + "Catarina";
			valor = valor + "," + "Comitancillo";
			valor = valor + "," + "Concepción Tutuapa";
			valor = valor + "," + "El Quetzal";
			valor = valor + "," + "El Tumbador";
			valor = valor + "," + "Esquipulas Palo Gordo";
			valor = valor + "," + "Ixchiguán";
			valor = valor + "," + "La Blanca";
			valor = valor + "," + "La Reforma";
			valor = valor + "," + "Malacatán";
			valor = valor + "," + "Nuevo Progreso";
			valor = valor + "," + "Ocós";
			valor = valor + "," + "Pajapita";
			valor = valor + "," + "Río Blanco";
			valor = valor + "," + "San Antonio Sacatepéquez";
			valor = valor + "," + "San Cristóbal Cucho";
			valor = valor + "," + "San José El Rodeo";
			valor = valor + "," + "San José Ojetenam";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "San Marcos";
			valor = valor + "," + "San Miguel Ixtahuacán";
			valor = valor + "," + "San Pablo";
			valor = valor + "," + "San Pedro Sacatepéquez";
			valor = valor + "," + "San Rafael Pie de la Cuesta";
			valor = valor + "," + "Sibinal";
			valor = valor + "," + "Sipacapa";
			valor = valor + "," + "Tacaná";
			valor = valor + "," + "Tajumulco";
			valor = valor + "," + "Tejutla";
			
		}else if(Departamento.equals("Santa Rosa")){
			valor = valor + "," + "Barberena";
			valor = valor + "," + "Casillas";
			valor = valor + "," + "Chiquimulilla";
			valor = valor + "," + "Cuilapa";
			valor = valor + "," + "Guazacapán";
			valor = valor + "," + "Nueva Santa Rosa";
			valor = valor + "," + "Oratorio";
			valor = valor + "," + "Pueblo Nuevo Viñas";
			valor = valor + "," + "San Juan Tecuaco";
			valor = valor + "," + "San Rafael las Flores";
			valor = valor + "," + "Santa Cruz Naranjo";
			valor = valor + "," + "Santa María Ixhuatán";
			valor = valor + "," + "Santa Rosa de Lima";
			valor = valor + "," + "Taxisco";
			
		}else if(Departamento.equals("Sololá")){
			valor = valor + "," + "Concepción";
			valor = valor + "," + "Nahualá";
			valor = valor + "," + "Panajachel";
			valor = valor + "," + "San Andrés Semetabaj";
			valor = valor + "," + "San Antonio Palopó";
			valor = valor + "," + "San José Chacayá";
			valor = valor + "," + "San Juan La Laguna";
			valor = valor + "," + "San Lucas Tolimán";
			valor = valor + "," + "San Marcos La Laguna";
			valor = valor + "," + "San Pablo La Laguna";
			valor = valor + "," + "San Pedro La Laguna";
			valor = valor + "," + "Santa Catarina Ixtahuacán";
			valor = valor + "," + "Santa Catarina Palopó";
			valor = valor + "," + "Santa Clara La Laguna";
			valor = valor + "," + "Santa Cruz La Laguna";
			valor = valor + "," + "Santa Lucía Utatlán";
			valor = valor + "," + "Santa María Visitación";
			valor = valor + "," + "Santiago Atitlán";
			valor = valor + "," + "Sololá";
			
		}else if(Departamento.equals("Suchitepéquez")){
			valor = valor + "," + "Chicacao";
			valor = valor + "," + "Cuyotenango";
			valor = valor + "," + "Mazatenango";
			valor = valor + "," + "Patulul";
			valor = valor + "," + "Pueblo Nuevo";
			valor = valor + "," + "Río Bravo";
			valor = valor + "," + "Samayac";
			valor = valor + "," + "San Antonio Suchitepéquez";
			valor = valor + "," + "San Bernardino";
			valor = valor + "," + "San Francisco Zapotitlán";
			valor = valor + "," + "San Gabriel";
			valor = valor + "," + "San José El Idolo";
			valor = valor + "," + "San José La Maquina";
			valor = valor + "," + "San Juan Bautista";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "San Miguel Panán";
			valor = valor + "," + "San Pablo Jocopilas";
			valor = valor + "," + "Santa Bárbara";
			valor = valor + "," + "Santo Domingo Suchitepéquez";
			valor = valor + "," + "Santo Tomás La Unión";
			valor = valor + "," + "Zunilito";
			
		}else if(Departamento.equals("Totonicapán")){
			valor = valor + "," + "Momostenango";
			valor = valor + "," + "San Andrés Xecul";
			valor = valor + "," + "San Bartolo";
			valor = valor + "," + "San Cristóbal Totonicapán";
			valor = valor + "," + "San Francisco El Alto";
			valor = valor + "," + "Santa Lucía La Reforma";
			valor = valor + "," + "Santa María Chiquimula";
			valor = valor + "," + "Totonicapán";
			
		}else if(Departamento.equals("Zacapa")){
			valor = valor + "," + "Cabañas";
			valor = valor + "," + "Estanzuela";
			valor = valor + "," + "Gualán";
			valor = valor + "," + "Huité";
			valor = valor + "," + "La Unión";
			valor = valor + "," + "Río Hondo";
			valor = valor + "," + "San Diego";
			valor = valor + "," + "San Jorge";
			valor = valor + "," + "Teculután";
			valor = valor + "," + "Usumatlán";
			valor = valor + "," + "Zacapa";
			
		}
		return valor;
	}

}
