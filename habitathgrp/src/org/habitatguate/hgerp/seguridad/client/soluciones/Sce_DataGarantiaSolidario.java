package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.rrhh.FormularioFamilia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class Sce_DataGarantiaSolidario extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryGarantiaSolicitud formulario;
	private Sce_DataEntryGarantiaSolidario garantiaSolidario;
	private Long idGarantiaSolidario = 0L;
	private boolean bandera = true;
	private Mensaje mensaje; 
	
	private TextBox txtTelefonoTrabajo;
	private TextBox txtTelefonoCasa;
	private TextBox txtLugarTrabajo;
	private TextBox txtDireccionActual;
	private CheckBox checkLeer;
	private CheckBox checkEscribir;
	private CheckBox checkFirmar;
	private TextBox txtActividadEconomica;
	private ListBox listEstadoCivil;
	private TextBox txtEdad;
	private ListBox listPais;
	private TextBox txtNumDpi;
	private TextBox txtNombre;
	private TextBox txtCorreoElectronico;
	private TextBox txtNumeroCelular;
	private TextBox txtTelefonoInternacional;
	private TextBox txtProfesionOficio;
	private TextBox txtDireccionLugarTrabajo;
	
	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_DataGarantiaSolidario(Sce_DataEntryGarantiaSolidario a, Sce_DataEntryGarantiaSolicitud e, boolean valor) {

		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.garantiaSolidario = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("800px", "600px");

		Label label = new Label("Número de Celular:");
		label.setStyleName("label");
		absolutePanel.add(label, 37, 513);
		label.setSize("167px", "19px");
		
		txtNumeroCelular = new TextBox();
		txtNumeroCelular.setText("0");
		txtNumeroCelular.setTabIndex(11);
		txtNumeroCelular.setStyleName("gwt-TextBox2");
		txtNumeroCelular.setMaxLength(8);
		absolutePanel.add(txtNumeroCelular, 224, 511);
		txtNumeroCelular.setSize("128px", "19px");
		
		Label label_1 = new Label("Telefono Internacional:");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 459, 513);
		label_1.setSize("192px", "19px");
		
		txtTelefonoInternacional = new TextBox();
		txtTelefonoInternacional.setText("0");
		txtTelefonoInternacional.setTabIndex(11);
		txtTelefonoInternacional.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoInternacional, 688, 511);
		txtTelefonoInternacional.setSize("131px", "19px");
		
		txtProfesionOficio = new TextBox();
		txtProfesionOficio.setTabIndex(5);
		txtProfesionOficio.setStyleName("gwt-TextBox2");
		txtProfesionOficio.setMaxLength(50);
		absolutePanel.add(txtProfesionOficio, 222, 220);
		txtProfesionOficio.setSize("296px", "19px");
		
		Label label_2 = new Label("Profesion u Oficio:");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 39, 220);
		label_2.setSize("154px", "19px");
		
		Label label_3 = new Label("Correo Electrónico:");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 37, 433);
		label_3.setSize("181px", "19px");
		
		txtCorreoElectronico = new TextBox();
		txtCorreoElectronico.setTabIndex(10);
		txtCorreoElectronico.setStyleName("gwt-TextBox2");
		txtCorreoElectronico.setMaxLength(200);
		absolutePanel.add(txtCorreoElectronico, 224, 433);
		txtCorreoElectronico.setSize("223px", "19px");
		
		txtDireccionLugarTrabajo = new TextBox();
		txtDireccionLugarTrabajo.setTabIndex(10);
		txtDireccionLugarTrabajo.setStyleName("gwt-TextBox2");
		txtDireccionLugarTrabajo.setMaxLength(200);
		absolutePanel.add(txtDireccionLugarTrabajo, 252, 389);
		txtDireccionLugarTrabajo.setSize("573px", "19px");
		
		Label lblDireccionLugarTrabajo = new Label("Direccion Lugar de Trabajo:");
		lblDireccionLugarTrabajo.setStyleName("label");
		absolutePanel.add(lblDireccionLugarTrabajo, 37, 389);
		lblDireccionLugarTrabajo.setSize("218px", "19px");
		
		Label lblTelefonoTrabajo = new Label("Telefono de trabajo:");
		lblTelefonoTrabajo.setStyleName("label");
		absolutePanel.add(lblTelefonoTrabajo, 459, 474);
		lblTelefonoTrabajo.setSize("181px", "19px");

		Label lblTelefonoCasa = new Label("Telefono de casa:");
		lblTelefonoCasa.setStyleName("label");
		absolutePanel.add(lblTelefonoCasa, 37, 474);
		lblTelefonoCasa.setSize("167px", "19px");
		
		Label lblLugarTrabajo = new Label("Lugar de trabajo:");
		lblLugarTrabajo.setStyleName("label");
		absolutePanel.add(lblLugarTrabajo, 37, 345);
		lblLugarTrabajo.setSize("181px", "19px");
		
		Label lblDireccionActual = new Label("Direccion Actual:");
		lblDireccionActual.setStyleName("label");
		absolutePanel.add(lblDireccionActual, 37, 307);
		lblDireccionActual.setSize("181px", "19px");
		
		Label lblActividadEconomica = new Label("Actividad Economica:");
		lblActividadEconomica.setStyleName("label");
		absolutePanel.add(lblActividadEconomica, 37, 181);
		lblActividadEconomica.setSize("179px", "19px");
		
		Label lblEstadoCivil = new Label("Estado Civil:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 38, 108);
		lblEstadoCivil.setSize("124px", "13px");
		
		Label lblEdad = new Label("Edad:");
		lblEdad.setStyleName("label");
		absolutePanel.add(lblEdad, 335, 108);
		lblEdad.setSize("58px", "13px");
		
		Label lblNacionalidad = new Label("Nacionalidad:");
		lblNacionalidad.setStyleName("label");
		lblNacionalidad.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		absolutePanel.add(lblNacionalidad, 500, 108);
		lblNacionalidad.setSize("110px", "19px");
		
		Label lblNumDpi = new Label("Num. DPI:");
		lblNumDpi.setStyleName("label");
		absolutePanel.add(lblNumDpi, 694, 25);
		lblNumDpi.setSize("101px", "19px");
		
		Label lblNombre = new Label("Nombre Completo:");
		lblNombre.setStyleName("label");
		absolutePanel.add(lblNombre, 37, 50);
		lblNombre.setSize("192px", "13px");
		
		txtNombre = new TextBox();
		txtNombre.setTabIndex(1);
		txtNombre.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtNombre);
				
			}
		});	
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		txtNombre.setMaxLength(200);
		absolutePanel.add(txtNombre, 222, 50);
		txtNombre.setSize("450px", "19px");
		
		txtNumDpi = new TextBox();
		txtNumDpi.setMaxLength(13);
		txtNumDpi.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {			
				String input = txtNumDpi.getText();			
				if(txtNumDpi.getText().equals("")) {txtNumDpi.setText("0");}
				else if(txtNumDpi.getText().equals(null)) {txtNumDpi.setText("0");}
				
				else if (!input.matches("[0-9]*")) {
	            // show some error
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nNumero no valido");
				txtNumDpi.setText("0");	      
				}			
				else{
					 System.out.println("Exito");
				}
			}
		});
		txtNumDpi.setText("0");
		txtNumDpi.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNumDpi, 694, 50);
		txtNumDpi.setSize("116px", "19px");
		
		txtEdad = new TextBox();
		txtEdad.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {			
				String input = txtEdad.getText();			
				if(txtEdad.getText().equals("")) {txtEdad.setText("0");}
				else if(txtEdad.getText().equals(null)) {txtEdad.setText("0");}
				
				else if (!input.matches("[0-9]*")) {
	            // show some error
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nNumero no valido");
				txtEdad.setText("0");	      
				}			
				else{
					 System.out.println("Exito");
				}
			}
		});
		txtEdad.setText("0");
		txtEdad.setTabIndex(3);
		txtEdad.setStyleName("gwt-TextBox2");
		txtEdad.setMaxLength(3);
		absolutePanel.add(txtEdad, 391, 108);
		txtEdad.setSize("56px", "19px");
		
		txtTelefonoTrabajo = new TextBox();
		txtTelefonoTrabajo.setMaxLength(8);
		txtTelefonoTrabajo.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {			
				String input = txtTelefonoTrabajo.getText();			
				if(txtTelefonoTrabajo.getText().equals("")) {txtTelefonoTrabajo.setText("0");}
				else if(txtTelefonoTrabajo.getText().equals(null)) {txtTelefonoTrabajo.setText("0");}
				
				else if (!input.matches("[0-9]*")) {
	            // show some error
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nNumero no valido");
				txtTelefonoTrabajo.setText("0");	      
				}			
				else{
					 System.out.println("Exito");
				}
			}
		});
		txtTelefonoTrabajo.setText("0");
		txtTelefonoTrabajo.setTabIndex(12);
		txtTelefonoTrabajo.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoTrabajo, 688, 474);
		txtTelefonoTrabajo.setSize("128px", "17px");
		
		txtTelefonoCasa = new TextBox();
		txtTelefonoCasa.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {			
				String input = txtTelefonoCasa.getText();			
				if(txtTelefonoCasa.getText().equals("")) {txtTelefonoCasa.setText("0");}
				else if(txtTelefonoCasa.getText().equals(null)) {txtTelefonoCasa.setText("0");}
				
				else if (!input.matches("[0-9]*")) {
	            // show some error
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nNumero no valido");
				txtTelefonoCasa.setText("0");	      
				}			
				else{
					 System.out.println("Exito");
				}
			}
		});
		txtTelefonoCasa.setText("0");
		txtTelefonoCasa.setTabIndex(11);
		txtTelefonoCasa.setStyleName("gwt-TextBox2");
		txtTelefonoCasa.setMaxLength(8);
		absolutePanel.add(txtTelefonoCasa, 224, 472);
		txtTelefonoCasa.setSize("128px", "19px");
		
		txtLugarTrabajo = new TextBox();
		txtLugarTrabajo.setTabIndex(10);
		txtLugarTrabajo.setStyleName("gwt-TextBox2");
		txtLugarTrabajo.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajo, 224, 345);
		txtLugarTrabajo.setSize("601px", "19px");
		
		txtDireccionActual = new TextBox();
		txtDireccionActual.setTabIndex(9);
		txtDireccionActual.setStyleName("gwt-TextBox2");
		txtDireccionActual.setMaxLength(200);
		absolutePanel.add(txtDireccionActual, 224, 305);
		txtDireccionActual.setSize("601px", "19px");
		
		checkLeer = new CheckBox("Sabe Leer");
		checkLeer.setTabIndex(6);
		absolutePanel.add(checkLeer, 263, 263);
		checkLeer.setSize("143px", "24px");
		
		checkEscribir = new CheckBox("Sabe Escribir");
		checkEscribir.setTabIndex(7);
		absolutePanel.add(checkEscribir, 426, 263);
		checkEscribir.setSize("154px", "24px");
		
		checkFirmar = new CheckBox("Sabe Firmar");
		checkFirmar.setTabIndex(8);
		absolutePanel.add(checkFirmar, 608, 263);
		checkFirmar.setSize("159px", "24px");
		
		txtActividadEconomica = new TextBox();
		txtActividadEconomica.setTabIndex(5);
		txtActividadEconomica.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtActividadEconomica);
				
			}
		});	
		txtActividadEconomica.setStyleName("gwt-TextBox2");
		txtActividadEconomica.setMaxLength(50);
		absolutePanel.add(txtActividadEconomica, 222, 179);
		txtActividadEconomica.setSize("296px", "19px");
		
		listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("-", "-1");
		listEstadoCivil.addItem("Soltero (a)", "1");
		listEstadoCivil.addItem("Casado (a)", "2");
		listEstadoCivil.addItem("Unido (a)", "3");
		listEstadoCivil.addItem("Separado (a)", "4");
		listEstadoCivil.addItem("Divorciado (a)", "5");
		listEstadoCivil.addItem("Viudo (a)", "6");
		listEstadoCivil.setTabIndex(2);
		listEstadoCivil.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstadoCivil, 153, 108);
		listEstadoCivil.setSize("148px", "27px");
		
		listPais = new ListBox();
		listPais.addItem("-","-1");
		listPais.addItem("ABUDABI","1");
		listPais.addItem("AFGANISTÁN","2");
		listPais.addItem("ALASKA","143");
		listPais.addItem("ALBANIA","3");
		listPais.addItem("ALEMANIA","4");
		listPais.addItem("ALGERIA","5");
		listPais.addItem("ALMIRANTES","198");
		listPais.addItem("ALTO VOLTA","199");
		listPais.addItem("ANDORRA","6");
		listPais.addItem("ANGLONORMANDAS","196");
		listPais.addItem("ANGOLA","7");
		listPais.addItem("ANGUILLA","8");
		listPais.addItem("ANTARCTICA","9");
		listPais.addItem("ANTIGUA Y BARBUDA","10");
		listPais.addItem("ANTILLAS HOLANDESAS","195");
		listPais.addItem("ARABIA SAUDITA","11");
		listPais.addItem("ARGELIA","200");
		listPais.addItem("ARGENTINA","12");
		listPais.addItem("ARMENIA","13");
		listPais.addItem("ARUBA","14");
		listPais.addItem("AUSTRALIA","15");
		listPais.addItem("AUSTRIA","16");
		listPais.addItem("AZERBAIJAN","17");
		listPais.addItem("AZORES","197");
		listPais.addItem("BAHAMAS","18");
		listPais.addItem("BAHREIN","19");
		listPais.addItem("BANGLADESH","20");
		listPais.addItem("BARBADOS","21");
		listPais.addItem("BARBUDA","204");
		listPais.addItem("BELARUS","22");
		listPais.addItem("BELAU","203");
		listPais.addItem("BÉLGICA","23");
		listPais.addItem("BELIZE","24");
		listPais.addItem("BENIN","25");
		listPais.addItem("BERMUDA","26");
		listPais.addItem("BHUTÁN","27");
		listPais.addItem("BIRMANIA","202");
		listPais.addItem("BOLIVIA","28");
		listPais.addItem("BORNEO","201");
		listPais.addItem("BOSNIA Y HERZEGOVINA","29");
		listPais.addItem("BOTSWANA","30");
		listPais.addItem("BRASIL","31");
		listPais.addItem("BRUNEI","32");
		listPais.addItem("BULGARIA","33");
		listPais.addItem("BURKINA FASO","34");
		listPais.addItem("BURUNDI","35");
		listPais.addItem("CAIMAN","206");
		listPais.addItem("CALPE","207");
		listPais.addItem("CAMBOYA","36");
		listPais.addItem("CAMERÚN","37");
		listPais.addItem("CANADÁ","38");
		listPais.addItem("CANARIAS","213");
		listPais.addItem("CAPO VERDE","39");
		listPais.addItem("CEBELES","215");
		listPais.addItem("CEILAN","209");
		listPais.addItem("CEUTA","214");
		listPais.addItem("CHAD","41");
		listPais.addItem("CHECOSLOVAQUIA","208");
		listPais.addItem("CHILE","42");
		listPais.addItem("CHINA","43");
		listPais.addItem("CHIPRE","52");
		listPais.addItem("CLIPPERTON","211");
		listPais.addItem("COCOS","210");
		listPais.addItem("COLOMBIA","44");
		listPais.addItem("COMORO","45");
		listPais.addItem("CONGO","46");
		listPais.addItem("COOK","212");
		listPais.addItem("COREA","48");
		listPais.addItem("COREA DEL SUR","47");
		listPais.addItem("COSTA DE MARFIL","50");
		listPais.addItem("COSTA RICA","49");
		listPais.addItem("CROATIA","53");
		listPais.addItem("DINAMARCA","54");
		listPais.addItem("DJIBOUTI","55");
		listPais.addItem("DOMINICA","56");
		listPais.addItem("DUBAI","58");
		listPais.addItem("ECUADOR","59");
		listPais.addItem("EGIPTO","60");
		listPais.addItem("EL SALVADOR","61");
		listPais.addItem("EMIRATOS ÁRABES UNIDOS","62");
		listPais.addItem("ERITREA","63");
		listPais.addItem("ESCOCIA","216");
		listPais.addItem("ESLOVAQUIA","64");
		listPais.addItem("ESLOVENIA","65");
		listPais.addItem("ESOTHO","109");
		listPais.addItem("ESPAÑA","66");
		listPais.addItem("ESTADOS UNIDOS DE AMERICA","67");
		listPais.addItem("ESTONIA","68");
		listPais.addItem("ETIOPÍA","69");
		listPais.addItem("FEDERACION DE MALAYSIA","217");
		listPais.addItem("FEROE","219");
		listPais.addItem("FIJI","70");
		listPais.addItem("FILIPINAS","71");
		listPais.addItem("FINLANDIA","72");
		listPais.addItem("FORMOSA","218");
		listPais.addItem("FRANCIA","73");
		listPais.addItem("GABÓN","74");
		listPais.addItem("GAMBIA","75");
		listPais.addItem("GEORGIA","76");
		listPais.addItem("GHANA","77");
		listPais.addItem("GIBRALTAR","78");
		listPais.addItem("GILBERT","223");
		listPais.addItem("GRAN BRETAÑA","220");
		listPais.addItem("GRECIA","79");
		listPais.addItem("GRENADA","81");
		listPais.addItem("GROENLANDIA","80");
		listPais.addItem("GUADELUPE","82");
		listPais.addItem("GUAM","222");
		listPais.addItem("GUATEMALA","83");
		listPais.addItem("GUAYANA INGLESA","221");
		listPais.addItem("GUINEA","84");
		listPais.addItem("GUINEA ECUATORIAL","85");
		listPais.addItem("GUINEA PORTUGUESA","224");
		listPais.addItem("GUYANA","86");
		listPais.addItem("HAITI","87");
		listPais.addItem("HAWAI","225");
		listPais.addItem("HOLANDA","88");
		listPais.addItem("HONDURAS","89");
		listPais.addItem("HONG KONG","90");
		listPais.addItem("HUNGRÍA","91");
		listPais.addItem("INDIA","93");
		listPais.addItem("INDONESIA","94");
		listPais.addItem("INGLATERRA","226");
		listPais.addItem("IRAN","95");
		listPais.addItem("IRAQ","96");
		listPais.addItem("IRIAN JAYA","227");
		listPais.addItem("IRLANDA","97");
		listPais.addItem("ISLA HONG KONG","228");
		listPais.addItem("ISLANDIA","92");
		listPais.addItem("ISRAEL","98");
		listPais.addItem("ITALIA","99");
		listPais.addItem("JAMAICA","100");
		listPais.addItem("JAPÓN","101");
		listPais.addItem("JORDANIA","102");
		listPais.addItem("KATAR","230");
		listPais.addItem("KAZAKHSTAN","103");
		listPais.addItem("KENIA","104");
		listPais.addItem("KOWEIT","229");
		listPais.addItem("KUWAIT","105");
		listPais.addItem("KYRGYZSTAN","106");
		listPais.addItem("LATVIA","107");
		listPais.addItem("LESHOTO","231");
		listPais.addItem("LETONIA","110");
		listPais.addItem("LÍBANO","108");
		listPais.addItem("LIBERIA","111");
		listPais.addItem("LIBIA","112");
		listPais.addItem("LIECHTENSTEIN","113");
		listPais.addItem("LITUANIA","114");
		listPais.addItem("LUXEMBURGO","115");
		listPais.addItem("MACEDONIA","116");
		listPais.addItem("MACQUARIE","235");
		listPais.addItem("MADAGASCAR","117");
		listPais.addItem("MADEITA","236");
		listPais.addItem("MALASIA","119");
		listPais.addItem("MALAWI","118");
		listPais.addItem("MALAYSIA","232");
		listPais.addItem("MALDIVES","120");
		listPais.addItem("MALI","121");
		listPais.addItem("MALTA","122");
		listPais.addItem("MAN","238");
		listPais.addItem("MARRUECOS","133");
		listPais.addItem("MARTINICA","123");
		listPais.addItem("MAURITANIA","124");
		listPais.addItem("MAURITIUS","125");
		listPais.addItem("MAYOTTE","126");
		listPais.addItem("MELILLA","233");
		listPais.addItem("MÉXICO","127");
		listPais.addItem("MICRONESIA","128");
		listPais.addItem("MIDWAY","237");
		listPais.addItem("MOLDOVA","129");
		listPais.addItem("MOLUCA","234");
		listPais.addItem("MÓNACO","130");
		listPais.addItem("MONGOLIA","131");
		listPais.addItem("MONTSERRAT","132");
		listPais.addItem("MOZAMBIQUE","134");
		listPais.addItem("NAMIBIA","135");
		listPais.addItem("NEPAL","136");
		listPais.addItem("NICARAGUA","138");
		listPais.addItem("NIGER","139");
		listPais.addItem("NIGERIA","140");
		listPais.addItem("NORFOLK","239");
		listPais.addItem("NORUEGA","141");
		listPais.addItem("NUEVA CALEDONIA","240");
		listPais.addItem("NUEVA ZELANDIA","137");
		listPais.addItem("OMÁN","142");
		listPais.addItem("PALAU","243");
		listPais.addItem("PALESTINA","145");
		listPais.addItem("PANAMÁ","146");
		listPais.addItem("PAPUA NUEVA GUINEA","147");
		listPais.addItem("PAQUISTÁN","144");
		listPais.addItem("PARAGUAY","148");
		listPais.addItem("PASCUA","244");
		listPais.addItem("PERÚ","149");
		listPais.addItem("PITCAIRN","245");
		listPais.addItem("POLONESIA FRANCESA","246");
		listPais.addItem("POLONIA","150");
		listPais.addItem("POPULAR DE CHINA","241");
		listPais.addItem("POPULAR DE COREA","242");
		listPais.addItem("PORTUGAL","151");
		listPais.addItem("PUERTO RICO","152");
		listPais.addItem("QATAR","153");
		listPais.addItem("REINO UNIDO","154");
		listPais.addItem("REPUBLICA ARABE DE EJIPTO","247");
		listPais.addItem("REPÚBLICA CENTROAFRICANA","40");
		listPais.addItem("REPÚBLICA CHECA","51");
		listPais.addItem("REPUBLICA DE AFRICA ECUATORIAL","248");
		listPais.addItem("REPÚBLICA DOMINICANA","57");
		listPais.addItem("REUNION","155");
		listPais.addItem("ROMANIA","156");
		listPais.addItem("RUSSIA","157");
		listPais.addItem("RWANDA","158");
		listPais.addItem("SALOMON DEL SUR","250");
		listPais.addItem("SAMOA","159");
		listPais.addItem("SAN MARINO","160");
		listPais.addItem("SANTA LUCIA","251");
		listPais.addItem("SAO TOME Y PRÍNCIPE","161");
		listPais.addItem("SENEGAL","162");
		listPais.addItem("SEYCHELLES","163");
		listPais.addItem("SIERRA LEONA","164");
		listPais.addItem("SINGAPUR","165");
		listPais.addItem("SIRIA","166");
		listPais.addItem("SOCOTORRA","249");
		listPais.addItem("SOMALIA","167");
		listPais.addItem("SRI LANKA","169");
		listPais.addItem("SUDÁN","170");
		listPais.addItem("SUECIA","173");
		listPais.addItem("SUIZA","174");
		listPais.addItem("SURÁFRICA","168");
		listPais.addItem("SURINAME","171");
		listPais.addItem("SWAZILANDIA","172");
		listPais.addItem("TAILANDIA","178");
		listPais.addItem("TAIWÁN","175");
		listPais.addItem("TAJIKISTAN","176");
		listPais.addItem("TANZANIA","177");
		listPais.addItem("TIMOR","252");
		listPais.addItem("TOGO","179");
		listPais.addItem("TOKELAU","253");
		listPais.addItem("TONGA","181");
		listPais.addItem("TRINIDAD Y TOBAGO","181");
		listPais.addItem("TÚNEZ","182");
		listPais.addItem("TURKMENISTAN","184");
		listPais.addItem("TURQUÍA","183");
		listPais.addItem("TUVALU","254");
		listPais.addItem("UCRANIA","185");
		listPais.addItem("UGANDA","186");
		listPais.addItem("URUGUAY","187");
		listPais.addItem("UZBEKISTAN","188");
		listPais.addItem("VATICANO","257");
		listPais.addItem("VENEZUELA","189");
		listPais.addItem("VIETNAM","190");
		listPais.addItem("VIRGENES AMERICAS","256");
		listPais.addItem("VIRGENES BRITANICAS","255");
		listPais.addItem("WAKE","258");
		listPais.addItem("WALLIS","259");
		listPais.addItem("YEMEN","191");
		listPais.addItem("YUGOSLAVIA","192");
		listPais.addItem("ZAMBIA","183");
		listPais.addItem("ZIMBABWE","194");
		listPais.setTabIndex(4);
		listPais.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPais, 638, 108);
		listPais.setSize("173px", "27px");
		

		
		// Boton Guardar
		
		Button btnGuardar = new Button("Send");
		
		if(this.valor) {
			btnGuardar.setVisible(true);
		}else{
			btnGuardar.setVisible(false);
		}
		
		btnGuardar.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				
				String nombre = "";		
				if(txtNombre.getText() == null){
					nombre = "";
				}else{
					nombre = txtNombre.getText();
				}
				
				String dpiValue = txtNumDpi.getText();
				
				String edadValue = txtEdad.getText();
				int edad = 0;
				edad = Integer.parseInt(edadValue);
				
				String estadoCivil = "-1";		
				estadoCivil = listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex());
				
				String nacionalidad = "-1";		
				nacionalidad = listPais.getValue(listPais.getSelectedIndex());	
				
				String actividadEconomica = "";		
				if(txtActividadEconomica.getText() == null){
					actividadEconomica = "";
				}else{
					actividadEconomica = txtActividadEconomica.getText();
				}
				
				Boolean sabeLeer = false;
				sabeLeer = checkLeer.getValue();
				
				Boolean sabeEscribir = false;
				sabeEscribir = checkEscribir.getValue();
				
				Boolean sabeFirmar = false;
				sabeFirmar = checkFirmar.getValue();
				
				String direccionActual = "";		
				if(txtDireccionActual.getText() == null){
					direccionActual = "";
				}else{
					direccionActual = txtDireccionActual.getText();
				}
				
				String lugarTrabajo = "";		
				if(txtLugarTrabajo.getText() == null){
					lugarTrabajo = "";
				}else{
					lugarTrabajo = txtLugarTrabajo.getText();
				}
				
				String telefonoCasaValue = txtTelefonoCasa.getText();
				int telefonoCasa = 0;
				telefonoCasa = Integer.parseInt(telefonoCasaValue);
				
				String telefonoTrabajoValue = txtTelefonoTrabajo.getText();
				int telefonoTrabajo = 0;
				telefonoTrabajo = Integer.parseInt(telefonoTrabajoValue);
				
				String profesionOficio = "";		
				if(txtProfesionOficio.getText() == null){
					profesionOficio = "";
				}else{
					profesionOficio = txtProfesionOficio.getText();
				}
				
				String direccionLugarTrabajo = "";		
				if(txtDireccionLugarTrabajo.getText() == null){
					direccionLugarTrabajo = "";
				}else{
					direccionLugarTrabajo = txtDireccionLugarTrabajo.getText();
				}
				
				String correoElectronico = "";		
				if(txtCorreoElectronico.getText() == null){
					correoElectronico = "";
				}else{
					correoElectronico = txtCorreoElectronico.getText();
				}
				
				String numeroCelularValue = txtNumeroCelular.getText();
				int numeroCelular = 0;
				numeroCelular = Integer.parseInt(numeroCelularValue);
				
				String telefonoInternacionalValue = txtTelefonoInternacional.getText();
				int telefonoInternacional = 0;
				telefonoInternacional = Integer.parseInt(telefonoInternacionalValue);

				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.ingresarGarantiaSolidario(fecrec, formulario.idFormulario, 
							nombre, dpiValue, 
							estadoCivil, edad, nacionalidad,
							actividadEconomica,
							sabeLeer, sabeEscribir, sabeFirmar,
							direccionActual, lugarTrabajo,
							telefonoCasa, telefonoTrabajo,
							profesionOficio, direccionLugarTrabajo, correoElectronico,
							numeroCelular, telefonoInternacional,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idGarantiaSolidario = result;
							System.out.println("Valor de NUEVO Garantia Grupo Solidario: " + idGarantiaSolidario);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarGarantiaSolidario(formulario.idFormulario, idGarantiaSolidario, 
							nombre, dpiValue, 
							estadoCivil, edad, nacionalidad,
							actividadEconomica,
							sabeLeer, sabeEscribir, sabeFirmar,
							direccionActual, lugarTrabajo,
							telefonoCasa, telefonoTrabajo,
							profesionOficio, direccionLugarTrabajo, correoElectronico,
							numeroCelular, telefonoInternacional,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de Garantia Grupo Solidario ACTUALIZADO: " + idGarantiaSolidario );
							bandera = false;

						}
					});
					
				}
				
			}
		});
			
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 222, 580);
		btnGuardar.setSize("227px", "34px");
		btnGuardar.setTabIndex(5);
		
		// Boton Eliminar
		
		Button btnEliminar = new Button("Send");
		
		if(this.valor) {
			btnEliminar.setVisible(true);
		}else{
			btnEliminar.setVisible(false);
		}
		
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormularioSinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 521, 580);
		btnEliminar.setSize("227px", "34px");
		btnEliminar.setTabIndex(6);
		
	}
	
	private void EliminarFormulario(){
		garantiaSolidario.EliminarFormulario(this, formulario.idFormulario, idGarantiaSolidario);
    }
	private void EliminarFormularioSinDatos(){
		garantiaSolidario.EliminarFormulario(this);
    }
	
	// DATA A CARGAR EN REFERENCIAS FAMILIARES
	
	public void LlenarDatos(Long id,
			String nombre, String numDpi,
			String estadoCivil, int edad, String nacionalidad,
			String actividad,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
			String direccionActual, String lugarTrabajo,
			int telefonoCasa, int telefonoTrabajo,
			String profesionOficio, String direccionLugarTrabajo, String correoElectronico,
			int numeroCelular, int telefonoInternacional)
	{

		this.bandera = false;
		
		this.idGarantiaSolidario = id; // ID

		this.txtNombre.setText(nombre);
		this.txtNumDpi.setText(numDpi);
		String edadValue = ""+edad;
		this.txtEdad.setText(edadValue);
		this.txtActividadEconomica.setText(actividad);
		this.checkLeer.setValue(sabeLeer);
		this.checkEscribir.setValue(sabeEscribir);
		this.checkFirmar.setValue(sabeFirmar);
		this.txtDireccionActual.setText(direccionActual);
		this.txtLugarTrabajo.setText(lugarTrabajo);
		String telefonoCasaValue = ""+telefonoCasa;
		this.txtTelefonoCasa.setText(telefonoCasaValue);
		String telefonoTrabajoValue = ""+telefonoTrabajo;
		this.txtTelefonoTrabajo.setText(telefonoTrabajoValue);
		
		this.txtProfesionOficio.setText(profesionOficio);
		this.txtDireccionLugarTrabajo.setText(direccionLugarTrabajo);
		this.txtCorreoElectronico.setText(correoElectronico);
		String numeroCelularValue = ""+numeroCelular;
		this.txtNumeroCelular.setText(numeroCelularValue);
		String telefonoInternacionalValue = ""+telefonoInternacional;
		this.txtTelefonoInternacional.setText(telefonoInternacionalValue);
		
        boolean bandera = true;
        for(int i=0; i < this.listEstadoCivil.getItemCount() && bandera; i++){
            bandera = !this.listEstadoCivil.getValue(i).equals(estadoCivil);
            this.listEstadoCivil.setSelectedIndex(i);
       }   
        
        bandera = true;
	    for(int i=0; i < this.listPais.getItemCount() && bandera; i++){
	       bandera = !this.listPais.getValue(i).equals(nacionalidad);
	       this.listPais.setSelectedIndex(i);
	    } 
	
	}
	
    public static void firstLetterToUppercase(TextBox input) {
    	String text = input.getText();
    	StringBuffer result = new StringBuffer();
    	char ch;
    	for (int i = 0; i < text.length(); i++) {
    		ch = text.charAt(i);
    		if (Character.isLetter(ch)
    				&& ((i == 0) || !Character.isLetter(text.charAt(i - 1)))){
    			result.append(Character.toUpperCase(ch));
    		} else {
    			result.append(Character.toLowerCase(ch));
    		}
    	}
    	input.setText(result.toString());
    }
	
}
