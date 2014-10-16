package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;

public class formularioDatos extends Composite {

	private Empleados empleado;
	private Long id_empleado = 0L;
	private boolean bandera = true;
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
    private Label label_16 ;
    private Label label_17;
    private Label label_26 ;
    private Label label_27 ;
    private Label lblD ;
    private Label lblEstadoDelEmpleado ;
    private Label lblCentroTrabajo;
	private Label lblOcupacion;
	private Label lblFechaIngreso;
	private Label lblCodigoOcupacion;
	private Label lblProfesion;
	private Label lblTipoPlanilla;
	private Label lblSalarioBase;
	private Label lblBonificacion;
	private Label lblTotal;
	private Button btnActualizar;
    private int tipo = 0;
    private ListBox listTienePasaporte ;
    private ListBox listEstadoCivil;
    private ListBox listSexo;
    private ListBox listEstado ;
    private TextBox txtPrimerApellido;
    private TextBox txtSegundoApellido ;
    private TextBox txtApellidoCasada ;
    private IntegerBox txtNo_iggs;
    private TextBox txtPrimerNombre;
    private TextBox txtSegundoNombre ;
    private ListBox listPais;
    private ListBox listNoDependientes ;
    private TextBox txtTipoPasaporte ;
    private TextBox txtDireccion ;
    private ListBox listDireccionMunicipio;
    private TextBox txtCorreoElectronico;
    private ListBox listTipoLicencia;
    private DateBox dateAnnioNacimiento;
    private TextBox txtOcupacion ;
    private TextBox txtCentroTrabajo;
    private TextBox txt_CodigoOcupacion;
    private TextBox txtProfesion;
    private TextBox txtTipoPlanilla ;
    private ListBox listLicencia ;
    private DateBox dateFechaIngreso;
    
    private IntegerBox noCuenta ;
    private ListBox tipoCuenta ;
    private ListBox nombreBanco ;
    
    private IntegerBox txtDPI;
    private IntegerBox txtTelefonoCasa;
    private IntegerBox txtTelefonoCelular ;
    private IntegerBox txtNoLicencia;
    private TextBox txtNit ;
    private IntegerBox txtNoPasaporte;
    private TextBox txtSalarioBase ;
    private TextBox txtBonificacion ;
    private TextBox txtTotal ;
    private ListBox listDireccionDepartamento ;
    private ListBox listIVS;

	private String URLFile ="";
	private String KeyFile ="";

	private FormPanel form;
	private VerticalPanel formElements;
	private FileUpload fileUpload;
	private Button button;
	private Grid grid;
	private Image image ;
	private final UploadUrlServiceAsync uploadUrlService = GWT
			.create(UploadUrlService.class);
    private AbsolutePanel absolutePanel;
    private Button btnImprimir;
    private Button btnExportarDatos;
    
	public formularioDatos(Empleados e,final int tipo) {
		
		this.empleado = e;
		this.setTipo(tipo);
		
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		absolutePanel.setSize("997px", "1337px");
		initWidget(absolutePanel);
		
		getFormUrl();
		absolutePanel.add(getFormPanel(), 591, 109);
		
		image = new Image("images/imagenempresa.png");
		image.setSize("167px", "158px");
		absolutePanel.add(image, 341, 10);
		
		listEstado = new ListBox();
		listEstado.addItem("empleado activo","0");
		listEstado.addItem("empleado inactivo","1");
		listEstado.addItem("posible empleado","2");
		listEstado.addItem("practicante","3");
		listEstado.addItem("interino","4");
		listEstado.setStyleName("gwt-PasswordTextBox");
		listEstado.setSize("230px", "36px");
		absolutePanel.add(listEstado, 36, 163);
		
		
		txtNo_iggs = new IntegerBox();
		txtNo_iggs.setText("0");
		txtNo_iggs.setStyleName("gwt-PasswordTextBox");
		txtNo_iggs.setSize("227px", "34px");
		absolutePanel.add(txtNo_iggs, 36, 239);
		
		listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("Soltero(a)","0");
		listEstadoCivil.addItem("Casado(a)/Unida(a)","1");
		listEstadoCivil.addItem("Viudo(a)","2");
		listEstadoCivil.addItem("Divorciado(a)","3");
		listEstadoCivil.setStyleName("gwt-PasswordTextBox");
		listEstadoCivil.setSize("230px", "36px");
		absolutePanel.add(listEstadoCivil, 319, 239);
		
		listSexo = new ListBox();
		listSexo.addItem("femenino","0");
		listSexo.addItem("masculino","1");
		listSexo.setStyleName("gwt-PasswordTextBox");
		listSexo.setSize("227px", "34px");
		absolutePanel.add(listSexo, 591, 239);
		
		txtPrimerApellido = new TextBox();
		txtPrimerApellido.setMaxLength(50);
		txtPrimerApellido.setStyleName("gwt-PasswordTextBox");
		txtPrimerApellido.setSize("227px", "34px");
		absolutePanel.add(txtPrimerApellido, 36, 312);
		
		txtSegundoApellido = new TextBox();
		txtSegundoApellido.setMaxLength(50);
		txtSegundoApellido.setStyleName("gwt-PasswordTextBox");
		txtSegundoApellido.setSize("227px", "34px");
		absolutePanel.add(txtSegundoApellido, 317, 312);
		
		txtApellidoCasada = new TextBox();
		txtApellidoCasada.setMaxLength(50);
		txtApellidoCasada.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtApellidoCasada, 589, 312);
		txtApellidoCasada.setSize("227px", "34px");
		
		txtPrimerNombre = new TextBox();
		txtPrimerNombre.setMaxLength(50);
		txtPrimerNombre.setStyleName("gwt-PasswordTextBox");
		txtPrimerNombre.setSize("227px", "34px");
		absolutePanel.add(txtPrimerNombre, 37, 383);
		
		txtSegundoNombre = new TextBox();
		txtSegundoNombre.setMaxLength(50);
		txtSegundoNombre.setStyleName("gwt-PasswordTextBox");
		txtSegundoNombre.setSize("227px", "34px");
		absolutePanel.add(txtSegundoNombre, 318, 383);
		
		listPais = new ListBox();
		listPais.addItem("Afganistan","1");
		listPais.addItem("Albania","2");
		listPais.addItem("Alemania","3");
		listPais.addItem("Andorra","4");
		listPais.addItem("Angola","5");
		listPais.addItem("Antigua y Barbuda","6");
		listPais.addItem("Arabia Saudita","7");
		listPais.addItem("Argelia","8");
		listPais.addItem("Argentina","9");
		listPais.addItem("Armenia","10");
		listPais.addItem("Australia","11");
		listPais.addItem("Austria","12");
		listPais.addItem("Azerbaiyan","13");
		listPais.addItem("Bahamas","14");
		listPais.addItem("Banglades","15");
		listPais.addItem("Barbados","16");
		listPais.addItem("Barein","17");
		listPais.addItem("Belgica","18");
		listPais.addItem("Belice","19");
		listPais.addItem("Benin","20");
		listPais.addItem("Bielorrusia","21");
		listPais.addItem("Birmania","22");
		listPais.addItem("Bolivia","23");
		listPais.addItem("Bosnia y Herzegovina","24");
		listPais.addItem("Botsuana","25");
		listPais.addItem("Brasil","26");
		listPais.addItem("Brunei","27");
		listPais.addItem("Bulgaria","28");
		listPais.addItem("Burkina Faso","29");
		listPais.addItem("Burundi","30");
		listPais.addItem("Butan","31");
		listPais.addItem("Cabo Verde","32");
		listPais.addItem("Camboya","33");
		listPais.addItem("Camerun","34");
		listPais.addItem("Canada","35");
		listPais.addItem("Catar","36");
		listPais.addItem("Chad","37");
		listPais.addItem("Chile","38");
		listPais.addItem("China","39");
		listPais.addItem("Chipre","40");
		listPais.addItem("Ciudad del Vaticano","41");
		listPais.addItem("Colombia","42");
		listPais.addItem("Comoras","43");
		listPais.addItem("Corea del Norte","44");
		listPais.addItem("Corea del Sur","45");
		listPais.addItem("Costa de Marfil","46");
		listPais.addItem("Costa Rica","47");
		listPais.addItem("Croacia","48");
		listPais.addItem("Cuba","49");
		listPais.addItem("Dinamarca","50");
		listPais.addItem("Dominica","51");
		listPais.addItem("Ecuador","52");
		listPais.addItem("Egipto","53");
		listPais.addItem("El Salvador","54");
		listPais.addItem("Emiratos arabes Unidos","55");
		listPais.addItem("Eritrea","56");
		listPais.addItem("Eslovaquia","57");
		listPais.addItem("Eslovenia","58");
		listPais.addItem("España","59");
		listPais.addItem("Estados Unidos","60");
		listPais.addItem("Estonia","61");
		listPais.addItem("Etiopia","62");
		listPais.addItem("Filipinas","63");
		listPais.addItem("Finlandia","64");
		listPais.addItem("Fiyi","65");
		listPais.addItem("Francia","66");
		listPais.addItem("Gabon","67");
		listPais.addItem("Gambia","68");
		listPais.addItem("Georgia","69");
		listPais.addItem("Ghana","70");
		listPais.addItem("Granada","71");
		listPais.addItem("Grecia","72");
		listPais.addItem("Guatemala","73");
		listPais.addItem("Guyana","74");
		listPais.addItem("Guinea","75");
		listPais.addItem("Guinea ecuatorial","76");
		listPais.addItem("Guinea-Bisau","77");
		listPais.addItem("Haiti","78");
		listPais.addItem("Honduras","79");
		listPais.addItem("Hungria","80");
		listPais.addItem("India","81");
		listPais.addItem("Indonesia","82");
		listPais.addItem("Irak","83");
		listPais.addItem("Iran","84");
		listPais.addItem("Irlanda","85");
		listPais.addItem("Islandia","86");
		listPais.addItem("Islas Marshall","87");
		listPais.addItem("Islas Salomon","88");
		listPais.addItem("Israel","90");
		listPais.addItem("Italia","91");
		listPais.addItem("Jamaica","92");
		listPais.addItem("Japon","93");
		listPais.addItem("Jordania","94");
		listPais.addItem("Kazajistan","95");
		listPais.addItem("Kenia","96");
		listPais.addItem("Kirguistan","97");
		listPais.addItem("Kiribati","98");
		listPais.addItem("Kuwait","100");
		listPais.addItem("Laos","101");
		listPais.addItem("Lesoto","102");
		listPais.addItem("Letonia","103");
		listPais.addItem("Libano","104");
		listPais.addItem("Liberia","105");
		listPais.addItem("Libia","106");
		listPais.addItem("Liechtenstein","107");
		listPais.addItem("Lituania","108");
		listPais.addItem("Luxemburgo","109");
		listPais.addItem("Madagascar","110");
		listPais.addItem("Malasia","111");
		listPais.addItem("Malaui","112");
		listPais.addItem("Maldivas","113");
		listPais.addItem("Mali","114");
		listPais.addItem("Malta","115");
		listPais.addItem("Marruecos","116");
		listPais.addItem("Mauricio","117");
		listPais.addItem("Mauritania","118");
		listPais.addItem("Mexico","119");
		listPais.addItem("Micronesia","120");
		listPais.addItem("Moldavia","121");
		listPais.addItem("Monaco","122");
		listPais.addItem("Mongolia","123");
		listPais.addItem("Montenegro","124");
		listPais.addItem("Mozambique","125");
		listPais.addItem("Namibia","126");
		listPais.addItem("Nauru","127");
		listPais.addItem("Nepal","128");
		listPais.addItem("Nicaragua","129");
		listPais.addItem("Niger","130");
		listPais.addItem("Nigeria","131");
		listPais.addItem("Noruega","132");
		listPais.addItem("Nueva Zelanda","133");
		listPais.addItem("Oman","134");
		listPais.addItem("Paises Bajos","135");
		listPais.addItem("Pakistan","136");
		listPais.addItem("Palaos","137");
		listPais.addItem("Panama","138");
		listPais.addItem("Papua Nueva Guinea","139");
		listPais.addItem("Paraguay","140");
		listPais.addItem("Peru","141");
		listPais.addItem("Polonia","142");
		listPais.addItem("Portugal","143");
		listPais.addItem("Reino Unido","144");
		listPais.addItem("Republica Centroafricana","145");
		listPais.addItem("Republica Checa","146");
		listPais.addItem("Republica de Macedonia","147");
		listPais.addItem("Republica del Congo","148");
		listPais.addItem("Republica Democratica del Congo","150");
		listPais.addItem("Republica Dominicana","151");
		listPais.addItem("Republica Sudafricana","152");
		listPais.addItem("Ruanda","153");
		listPais.addItem("Rumania","154");
		listPais.addItem("Rusia","155");
		listPais.addItem("Samoa","156");
		listPais.addItem("San Cristobal y Nieves","157");
		listPais.addItem("San Marino","158");
		listPais.addItem("San Vicente y las Granadinas","159");
		listPais.addItem("Santa Lucia","160");
		listPais.addItem("Santo Tome y Principe","161");
		listPais.addItem("Senegal","162");
		listPais.addItem("Serbia","163");
		listPais.addItem("Seychelles","164");
		listPais.addItem("Sierra Leona","165");
		listPais.addItem("Singapur","166");
		listPais.addItem("Siria","167");
		listPais.addItem("Somalia","168");
		listPais.addItem("Sri Lanka","169");
		listPais.addItem("Suazilandia","170");
		listPais.addItem("Sudan","171");
		listPais.addItem("Sudan del Sur","172");
		listPais.addItem("Suecia","173");
		listPais.addItem("Suiza","174");
		listPais.addItem("Surinam","175");
		listPais.addItem("Tailandia","176");
		listPais.addItem("Tanzania","177");
		listPais.addItem("Tayikistan","178");
		listPais.addItem("Timor Oriental","179");
		listPais.addItem("Togo","180");
		listPais.addItem("Tonga","181");
		listPais.addItem("Trinidad y Tobago","182");
		listPais.addItem("Tunez","183");
		listPais.addItem("Turkmenistan","184");
		listPais.addItem("Turquia","185");
		listPais.addItem("Tuvalu","186");
		listPais.addItem("Ucrania","187");
		listPais.addItem("Uganda","188");
		listPais.addItem("Uruguay","189");
		listPais.addItem("Uzbekistan","190");
		listPais.addItem("Vanuatu","191");
		listPais.addItem("Venezuela","192");
		listPais.addItem("Vietnam","193");
		listPais.addItem("Yemen","194");
		listPais.addItem("Yibuti","195");
		listPais.addItem("Zambia","196");
		listPais.addItem("Zimbabue","197");
		listPais.setStyleName("gwt-PasswordTextBox");
		listPais.setSize("230px", "36px");
		absolutePanel.add(listPais, 590, 383);
		
		listIVS = new ListBox();
		listIVS.addItem("Con IVS","0");
		listIVS.addItem("Sin IVS","1");
		listIVS.setStyleName("gwt-PasswordTextBox");
		listIVS.setSize("230px", "36px");
		absolutePanel.add(listIVS, 34, 467);
		
		txtNit = new TextBox();
		txtNit.setStyleName("gwt-PasswordTextBox");
		txtNit.setMaxLength(30);
		txtNit.setSize("227px", "34px");
		absolutePanel.add(txtNit, 315, 467);
		
		listNoDependientes = new ListBox();
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
		listNoDependientes.setStyleName("gwt-PasswordTextBox");
		listNoDependientes.setSize("230px", "36px");
		absolutePanel.add(listNoDependientes, 588, 467);

		noCuenta = new IntegerBox();
		noCuenta.setText("0");
		noCuenta.setMaxLength(30);
		noCuenta.setSize("227px", "34px");
		noCuenta.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(noCuenta, 320, 536);
		
		tipoCuenta = new ListBox();
		tipoCuenta.addItem("Ahorro","0");
		tipoCuenta.addItem("Monetaria","1");
		tipoCuenta.setSize("227px", "34px");
		tipoCuenta.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(tipoCuenta, 40, 536);
		

		nombreBanco = new ListBox();
		nombreBanco.addItem("G&T Continental","0");
		nombreBanco.addItem("Banrural","1");
		nombreBanco.setSize("230px", "36px");
		nombreBanco.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(nombreBanco, 35, 687);
		
		
		txtDPI = new IntegerBox();
		txtDPI.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtDPI.getText().equals("")) {txtDPI.setText("0");}
				else if(txtDPI.getText().equals(null)) {txtDPI.setText("0");}
				else{
					try{
						Integer.parseInt(txtDPI.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nDPI no valido");
						txtDPI.setText("0");
					}
				}
			}
		});
		txtDPI.setText("0");
		txtDPI.setSize("227px", "34px");
		txtDPI.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtDPI, 592, 536);
		
		listTienePasaporte = new ListBox();
		listTienePasaporte.addChangeHandler(new ChangeHandler() 
		{
			public void onChange(ChangeEvent event) {
				if(listTienePasaporte.getItemText(listTienePasaporte.getSelectedIndex()).equals("No"))
				{
					txtTipoPasaporte.setVisible(false);
					txtNoPasaporte.setVisible(false);
					label_17.setVisible(false);
					label_16.setVisible(false);
				}else{
					txtTipoPasaporte.setVisible(true);
					txtNoPasaporte.setVisible(true);
					label_17.setVisible(true);
					label_16.setVisible(true);
				}
			}
		});
		listTienePasaporte.addItem("Si","0");
		listTienePasaporte.addItem("No","1");
		listTienePasaporte.setStyleName("gwt-PasswordTextBox");
		listTienePasaporte.setSize("232px", "36px");
		absolutePanel.add(listTienePasaporte, 38, 611);
		
		txtTipoPasaporte = new TextBox();
		txtTipoPasaporte.setStyleName("gwt-PasswordTextBox");
		txtTipoPasaporte.setSize("227px", "34px");
		absolutePanel.add(txtTipoPasaporte, 320, 611);
		
		txtNoPasaporte = new IntegerBox();
		txtNoPasaporte.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtNoPasaporte.getText().equals("")) {txtNoPasaporte.setText("0");}
				else if(txtNoPasaporte.getText().equals(null)) {txtNoPasaporte.setText("0");}
				else{
					try{
						Integer.parseInt(txtNoPasaporte.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nPasaporte no valido");
						txtNoPasaporte.setText("0");
					}
				}
			}
		});
		txtNoPasaporte.setText("0");
		txtNoPasaporte.setStyleName("gwt-PasswordTextBox");
		txtNoPasaporte.setSize("230px", "36px");
		absolutePanel.add(txtNoPasaporte, 589, 611);
		
		dateAnnioNacimiento = new DateBox();
		dateAnnioNacimiento.setValue(new Date(1407518707105L));
		dateAnnioNacimiento.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateAnnioNacimiento.getDatePicker().setYearArrowsVisible(true);
		dateAnnioNacimiento.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateAnnioNacimiento.getDatePicker().setVisibleYearCount(100);
		dateAnnioNacimiento.setStyleName("gwt-PasswordTextBox");
		dateAnnioNacimiento.setSize("228px", "41px");
		absolutePanel.add(dateAnnioNacimiento, 588, 680);
		
		txtDireccion = new TextBox();
		txtDireccion.setMaxLength(200);
		txtDireccion.setStyleName("gwt-PasswordTextBox");
		txtDireccion.setSize("227px", "34px");
		absolutePanel.add(txtDireccion, 37, 774);

		listDireccionDepartamento = new ListBox();
		listDireccionDepartamento.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listDireccionMunicipio.clear();
		        String[] numerosComoArray = Depto_Municipio(listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex())).split(",");
		        int correlativo = 0 + Integer.parseInt(listDireccionDepartamento.getValue(listDireccionDepartamento.getSelectedIndex())+"00");
		        for (int i = 0; i < numerosComoArray.length; i++) {
		        	listDireccionMunicipio.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }

		        listDireccionMunicipio.setSelectedIndex(2);
			}
		});

		listDireccionDepartamento.addItem("Guatemala","01");
		listDireccionDepartamento.addItem("Baja Verapaz","15");
		listDireccionDepartamento.addItem("Alta Verapaz","14");
		listDireccionDepartamento.addItem("El Progreso","02");
		listDireccionDepartamento.addItem("Izabal","18");
		listDireccionDepartamento.addItem("Zacapa","19");
		listDireccionDepartamento.addItem("Chiquimula","20");
		listDireccionDepartamento.addItem("Santa Rosa","06");
		listDireccionDepartamento.addItem("Jalapa","21");
		listDireccionDepartamento.addItem("Jutiapa","22");
		listDireccionDepartamento.addItem("Sacatepequez","03");
		listDireccionDepartamento.addItem("Chimaltenango","04");
		listDireccionDepartamento.addItem("Escuintla","05");
		listDireccionDepartamento.addItem("Solola","07");
		listDireccionDepartamento.addItem("Totonicapan","08");
		listDireccionDepartamento.addItem("Quezaltenango","09");
		listDireccionDepartamento.addItem("Suchitepequez","10");
		listDireccionDepartamento.addItem("Retalhuleu","11");
		listDireccionDepartamento.addItem("San Marcos","12");
		listDireccionDepartamento.addItem("Huehuetenango","13");
		listDireccionDepartamento.addItem("Quiche","14");
		listDireccionDepartamento.addItem("Peten","17");
		listDireccionDepartamento.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listDireccionDepartamento, 316, 776);
		listDireccionDepartamento.setSize("230px", "36px");
		
		listDireccionMunicipio = new ListBox();
		listDireccionMunicipio.setStyleName("gwt-PasswordTextBox");
		listDireccionMunicipio.setSize("230px", "36px");
		absolutePanel.add(listDireccionMunicipio, 588, 774);
		
		txtCorreoElectronico = new TextBox();
		txtCorreoElectronico.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtCorreoElectronico.getText().equals("ejemplo@habitat.com")){
                	setMensaje("alert alert-error", 
                			"Error !! \nEmail no valido");
                	txtCorreoElectronico.setText("ejemplo@habitat.com");
				}
                
                String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$";
                
                boolean valid = false;
                if(txtCorreoElectronico.getClass().toString().equals(String.class.toString())) {
                        valid = ((String)txtCorreoElectronico.getText()).matches(emailPattern);
                } else {
                        valid = ((Object)txtCorreoElectronico.getText()).toString().matches(emailPattern);
                }
                if(!valid){
                	setMensaje("alert alert-error", 
                			"Error !! \nEmail no valido");
                	txtCorreoElectronico.setText("ejemplo@habitat.com");
                }

			}
		});
		txtCorreoElectronico.setMaxLength(200);
		txtCorreoElectronico.setStyleName("gwt-PasswordTextBox");
		txtCorreoElectronico.setSize("227px", "34px");
		absolutePanel.add(txtCorreoElectronico, 37, 853);
		
		
		txtTelefonoCasa = new IntegerBox();
		txtTelefonoCasa.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(txtTelefonoCasa.getText().equals("")) {txtTelefonoCasa.setText("0");}
				else if(txtTelefonoCasa.getText().equals(null)) {txtTelefonoCasa.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoCasa.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nTelefono de Casa no valido");
						txtTelefonoCasa.setText("0");
					}
				}

			}
		});
		txtTelefonoCasa.setText("0");
		txtTelefonoCasa.setSize("227px", "34px");
		txtTelefonoCasa.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTelefonoCasa, 317, 853);
		
		txtTelefonoCelular = new IntegerBox();
		txtTelefonoCelular.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoCelular.getText().equals("")) {txtTelefonoCelular.setText("0");}
				else if(txtTelefonoCelular.getText().equals(null)) {txtTelefonoCelular.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoCelular.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nTelefono celular no valido");
						txtTelefonoCelular.setText("0");
					}
				}
			}
		});
		txtTelefonoCelular.setText("0");
		txtTelefonoCelular.setSize("227px", "34px");
		txtTelefonoCelular.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTelefonoCelular, 589, 853);
		
		listLicencia = new ListBox();
		listLicencia.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(listLicencia.getItemText(listLicencia.getSelectedIndex()).equals("No"))
				{
					listTipoLicencia.setVisible(false);
					txtNoLicencia.setVisible(false);
					label_26.setVisible(false);
					label_27.setVisible(false);
				}else{
					listTipoLicencia.setVisible(true);
					txtNoLicencia.setVisible(true);
					label_26.setVisible(true);
					label_27.setVisible(true);
				}
				
			}
		});
		listLicencia.addItem("Si","0");
		listLicencia.addItem("No","1");
		listLicencia.setSize("230px", "36px");
		listLicencia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listLicencia, 36, 935);
		
		listTipoLicencia = new ListBox();
		listTipoLicencia.addItem("A","0");
		listTipoLicencia.addItem("B","1");
		listTipoLicencia.addItem("C","2");
		listTipoLicencia.addItem("M","3");
		listTipoLicencia.setSize("230px", "36px");
		listTipoLicencia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listTipoLicencia, 316, 935);
		
		txtNoLicencia = new IntegerBox();
		txtNoLicencia.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtNoLicencia.getText().equals("")) {txtNoLicencia.setText("0");}
				else if(txtNoLicencia.getText().equals(null)) {txtNoLicencia.setText("0");}
				else{
					try{
						Integer.parseInt(txtNoLicencia.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nLicencia no valido");
						txtNoLicencia.setText("0");
					}
				}
			}
		});
		txtNoLicencia.setText("0");
		txtNoLicencia.setSize("227px", "34px");
		txtNoLicencia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtNoLicencia, 589, 935);
		
		txtCentroTrabajo = new TextBox();
		txtCentroTrabajo.setMaxLength(50);
		txtCentroTrabajo.setSize("227px", "34px");
		txtCentroTrabajo.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtCentroTrabajo, 37, 1103);
		
		txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(50);
		txtOcupacion.setSize("227px", "34px");
		txtOcupacion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtOcupacion, 314, 1103);
		
		dateFechaIngreso = new DateBox();
		dateFechaIngreso.setValue(new Date(1407518751219L));
		dateFechaIngreso.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFechaIngreso.getDatePicker().setYearArrowsVisible(true);
		dateFechaIngreso.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFechaIngreso.getDatePicker().setVisibleYearCount(100);
		dateFechaIngreso.setSize("228px", "35px");
		dateFechaIngreso.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFechaIngreso, 588, 1102);
		
		txt_CodigoOcupacion = new TextBox();
		txt_CodigoOcupacion.setMaxLength(50);
		txt_CodigoOcupacion.setSize("227px", "34px");
		txt_CodigoOcupacion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txt_CodigoOcupacion, 37, 1166);
		
		txtProfesion = new TextBox();
		txtProfesion.setMaxLength(50);
		txtProfesion.setSize("227px", "34px");
		txtProfesion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtProfesion, 314, 1166);
		
		txtTipoPlanilla = new TextBox();
		txtTipoPlanilla.setMaxLength(50);
		txtTipoPlanilla.setSize("227px", "34px");
		txtTipoPlanilla.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTipoPlanilla, 589, 1166);
		
		txtSalarioBase = new TextBox();
		txtSalarioBase.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalarioBase.getText().equals("")) {txtSalarioBase.setText("0");}
				else if(txtSalarioBase.getText().equals(null)) {txtSalarioBase.setText("0");}
				else{
					try{
						Float.parseFloat(txtSalarioBase.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nSalario no valido");
						txtSalarioBase.setText("0");
					}
				}
			}
		});
		txtSalarioBase.setText("0.0");
		txtSalarioBase.setMaxLength(50);
		txtSalarioBase.setSize("227px", "34px");
		txtSalarioBase.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtSalarioBase, 38, 1233);
		
		txtBonificacion = new TextBox();
		txtBonificacion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtBonificacion.getText().equals("")) {txtBonificacion.setText("0");}
				else if(txtBonificacion.getText().equals(null)) {txtBonificacion.setText("0");}
				else{
					try{
						Float.parseFloat(txtBonificacion.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nBonificacion no valido");
						txtBonificacion.setText("0");
					}
				}
			}
		});
		txtBonificacion.setText("0.0");
		txtBonificacion.setMaxLength(50);
		txtBonificacion.setSize("227px", "34px");
		txtBonificacion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtBonificacion, 319, 1234);
		
		txtTotal = new TextBox();
		txtTotal.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTotal.getText().equals("")) {txtTotal.setText("0");}
				else if(txtTotal.getText().equals(null)) {txtTotal.setText("0");}
				else{
					try{
						Float.parseFloat(txtTotal.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nTotal no valido");
						txtTotal.setText("0");
					}
				}
			}
		});
		txtTotal.setText("0.0");
		txtTotal.setMaxLength(50);
		txtTotal.setSize("227px", "34px");
		txtTotal.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTotal, 592, 1234);
		
		btnActualizar = new Button("Send");
		btnActualizar.setText("Guardar");
		btnActualizar.setStyleName("sendButton");
		btnActualizar.setSize("229px", "44px");
		btnActualizar.setStylePrimaryName("sendButton");
		absolutePanel.add(btnActualizar, 36, 1313);
		
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				try{
					new Date(dateAnnioNacimiento.getValue().getTime());
				}catch(Exception e){
					dateAnnioNacimiento.setValue(new Date(1407518124684L));
				}
				try{
					new Date(dateFechaIngreso.getValue().getTime());
				}catch(Exception e){
					dateFechaIngreso.setValue(new Date(1407518124684L));
				}
			
				if(bandera){
					depto_municipio_dos = listDireccionDepartamento.getValue(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getValue(listDireccionMunicipio.getSelectedIndex());
					
					loginService.Insertar_Emppleado(txtNo_iggs.getText(), listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex()), 
							listSexo.getValue(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), listIVS.getValue(listIVS.getSelectedIndex()), 
							listPais.getValue(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
							noCuenta.getText(),tipoCuenta.getValue(tipoCuenta.getSelectedIndex()) , nombreBanco.getValue(nombreBanco.getSelectedIndex()) , txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
							txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
							txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getValue(listTipoLicencia.getSelectedIndex()), 
							txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()),URLFile, KeyFile,listEstado.getValue(listEstado.getSelectedIndex()),
							listTienePasaporte.getValue(listTienePasaporte.getSelectedIndex()),listLicencia.getValue(listLicencia.getSelectedIndex()),new AsyncCallback<Long>() 
	                        {
	                            public void onFailure(Throwable caught) 
	                            {
	                            	setMensaje("alert alert-error", 
	                            			"Error !! \nal Guardar Datos");
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {

	                            	id_empleado = result;
	                            	empleado.id_empleado = result;
	                            	bandera = false;
	                            	if(tipo == 0)
	                            		empleado.NuevasPestanas();
	                            	else
	                            		empleado.NuevasPestanasdos();
	                            	empleado.familia_unica();
		                        	setMensaje("alert alert-success", 
		                        			"Datos Guardados\n exitosamente!!!");
	                            }

	                     });
				}else{
					depto_municipio_dos = listDireccionDepartamento.getValue(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getValue(listDireccionMunicipio.getSelectedIndex());
					
					loginService.Actualizar_Emppleado(id_empleado,txtNo_iggs.getText(), listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex()), 
							listSexo.getValue(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(),listIVS.getValue(listIVS.getSelectedIndex()), 
							listPais.getValue(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
							noCuenta.getText(),tipoCuenta.getValue(tipoCuenta.getSelectedIndex()) , nombreBanco.getValue(nombreBanco.getSelectedIndex()),txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
							txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
							txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getValue(listTipoLicencia.getSelectedIndex()), 
							txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), URLFile, KeyFile,listEstado.getValue(listEstado.getSelectedIndex()),
							listTienePasaporte.getValue(listTienePasaporte.getSelectedIndex()),listLicencia.getValue(listLicencia.getSelectedIndex()),new AsyncCallback<Long>() 
	                        {
	                            public void onFailure(Throwable caught) 
	                            {
	                            	setMensaje("alert alert-error", 
	                            			"Error !! \nal Actualizar Datos");
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {
	                            	bandera = false;
				                	setMensaje("alert alert-success", 
				                			"Datos Actualizados\n exitosamente!!!");
	                            }

	                     });
					
				}
				
			}
		});
		
		btnImprimir = new Button("Send");
		btnImprimir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.open("/ImprimirPerfil?abracadabra="+id_empleado, "_blank", "");
			}
		});
		btnImprimir.setText("Imprimir");
		btnImprimir.setStylePrimaryName("sendButton");
		btnImprimir.setStyleName("sendButton");
		absolutePanel.add(btnImprimir, 319, 1314);
		btnImprimir.setSize("229px", "44px");
		
		btnExportarDatos = new Button("Send");
		btnExportarDatos.setText("Exportar Datos");
		btnExportarDatos.setStylePrimaryName("sendButton");
		btnExportarDatos.setStyleName("sendButton");
		absolutePanel.add(btnExportarDatos, 591, 1313);
		btnExportarDatos.setSize("229px", "44px");
		Label lblNoDeAfiliacin = new Label("No. De Afiliacion al IGSS");
		lblNoDeAfiliacin.setStyleName("label");
		absolutePanel.add(lblNoDeAfiliacin, 37, 221);
		
		Label label_1 = new Label("Estado Civil");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 318, 221);
		label_1.setSize("192px", "19px");
		
		Label label_2 = new Label("Sexo");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 590, 221);
		label_2.setSize("192px", "19px");
		
		Label label_3 = new Label("Primer Apellido");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 35, 294);
		label_3.setSize("192px", "19px");
		
		Label label_4 = new Label("Segundo Apellido");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 315, 294);
		label_4.setSize("192px", "19px");
		
		Label label_5 = new Label("Apellido Casada");
		label_5.setStyleName("label");
		absolutePanel.add(label_5, 590, 294);
		label_5.setSize("192px", "19px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 36, 365);
		label_6.setSize("192px", "19px");
		
		Label label_7 = new Label("2do y Demas Nombres");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 317, 365);
		label_7.setSize("192px", "19px");
		
		Label label_8 = new Label("Pais");
		label_8.setStyleName("label");
		absolutePanel.add(label_8, 589, 365);
		label_8.setSize("192px", "19px");
		
		Label label_9 = new Label("Tipo Empleado");
		label_9.setStyleName("label");
		absolutePanel.add(label_9, 34, 442);
		label_9.setSize("192px", "19px");
		
		Label label_10 = new Label("Nit");
		label_10.setStyleName("label");
		absolutePanel.add(label_10, 314, 449);
		label_10.setSize("192px", "19px");
		
		Label label_11 = new Label("No. Dependientes");
		label_11.setStyleName("label");
		absolutePanel.add(label_11, 587, 449);
		label_11.setSize("192px", "19px");
		
		Label label_12 = new Label("Cedula No. Orden");
		label_12.setStyleName("label");
		absolutePanel.add(label_12, 39, 518);
		label_12.setSize("192px", "19px");
		
		Label label_13 = new Label("Cedula No. Registro");
		label_13.setStyleName("label");
		absolutePanel.add(label_13, 320, 518);
		label_13.setSize("192px", "19px");
		
		Label lblDpi = new Label("DPI");
		lblDpi.setStyleName("label");
		absolutePanel.add(lblDpi, 593, 518);
		lblDpi.setSize("247px", "19px");
		
		Label label_15 = new Label("Pasaporte");
		label_15.setStyleName("label");
		absolutePanel.add(label_15, 38, 593);
		label_15.setSize("178px", "19px");
		
		label_16 = new Label("Tipo Pasaporte");
		label_16.setStyleName("label");
		absolutePanel.add(label_16, 318, 593);
		label_16.setSize("192px", "19px");
		
		label_17 = new Label("No. Pasaporte");
		label_17.setStyleName("label");
		absolutePanel.add(label_17, 591, 593);
		label_17.setSize("192px", "19px");
		
		Label lblCedulaExtendidamunicipio = new Label("Cedula (Municipio)");
		lblCedulaExtendidamunicipio.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidamunicipio, 316, 662);
		lblCedulaExtendidamunicipio.setSize("231px", "19px");
		
		Label label_20 = new Label("DIreccion Actual");
		label_20.setStyleName("label");
		absolutePanel.add(label_20, 35, 751);
		label_20.setSize("192px", "19px");
		
		Label label_21 = new Label("Municipio residencia");
		label_21.setStyleName("label");
		absolutePanel.add(label_21, 588, 751);
		label_21.setSize("192px", "19px");
		
		Label label_22 = new Label("Correo Electronico");
		label_22.setStyleName("label");
		absolutePanel.add(label_22, 35, 833);
		label_22.setSize("192px", "19px");
		
		Label label_23 = new Label("Telefono de casa");
		label_23.setStyleName("label");
		absolutePanel.add(label_23, 316, 833);
		label_23.setSize("192px", "19px");
		
		Label label_24 = new Label("Telefono Celular");
		label_24.setStyleName("label");
		absolutePanel.add(label_24, 588, 833);
		label_24.setSize("192px", "19px");
		
		Label label_25 = new Label("Licencia");
		label_25.setStyleName("label");
		absolutePanel.add(label_25, 35, 910);
		label_25.setSize("178px", "19px");
		
		label_26 = new Label("No. Licencia");
		label_26.setStyleName("label");
		absolutePanel.add(label_26, 588, 910);
		label_26.setSize("192px", "19px");
		
		label_27 = new Label("Tipo Licencia");
		label_27.setStyleName("label");
		absolutePanel.add(label_27, 316, 910);
		label_27.setSize("192px", "19px");
		
		lblCentroTrabajo = new Label("Centro Trabajo");
		lblCentroTrabajo.setStyleName("label");
		absolutePanel.add(lblCentroTrabajo, 35, 1078);
		lblCentroTrabajo.setSize("192px", "19px");
		
		lblOcupacion = new Label("Ocupacion");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 315, 1082);
		lblOcupacion.setSize("192px", "19px");
		
		lblFechaIngreso = new Label("Fecha Ingreso");
		lblFechaIngreso.setStyleName("label");
		absolutePanel.add(lblFechaIngreso, 587, 1082);
		lblFechaIngreso.setSize("192px", "19px");
		
		lblCodigoOcupacion = new Label("Codigo Ocupacion");
		lblCodigoOcupacion.setStyleName("label");
		absolutePanel.add(lblCodigoOcupacion, 34, 1145);
		lblCodigoOcupacion.setSize("192px", "19px");
		
		lblProfesion = new Label("profesion");
		lblProfesion.setStyleName("label");
		absolutePanel.add(lblProfesion, 315, 1145);
		lblProfesion.setSize("192px", "19px");
		
		lblTipoPlanilla = new Label("Tipo Planilla");
		lblTipoPlanilla.setStyleName("label");
		absolutePanel.add(lblTipoPlanilla, 587, 1145);
		lblTipoPlanilla.setSize("192px", "19px");
		
		lblSalarioBase = new Label("Salario Base");
		lblSalarioBase.setStyleName("label");
		absolutePanel.add(lblSalarioBase, 38, 1208);
		lblSalarioBase.setSize("192px", "19px");
		
		lblBonificacion = new Label("Bonificacion");
		lblBonificacion.setStyleName("label");
		absolutePanel.add(lblBonificacion, 318, 1208);
		lblBonificacion.setSize("192px", "19px");
		
		lblTotal = new Label("Total");
		lblTotal.setStyleName("label");
		absolutePanel.add(lblTotal, 590, 1208);
		lblTotal.setSize("192px", "19px");
		
		Label label_28 = new Label("Año de Nacimiento");
		label_28.setStyleName("label");
		absolutePanel.add(label_28, 588, 655);
		label_28.setSize("192px", "19px");
		
		lblD = new Label("Datos del Patrono: (Uso exclusivo de la Fundacion");
		lblD.setStyleName("label");
		absolutePanel.add(lblD, 38, 1004);
		lblD.setSize("449px", "19px");
		
		Label lblCedulaExtendidadepartamento = new Label("Cedula (Departamento)");
		lblCedulaExtendidadepartamento.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidadepartamento, 36, 662);
		lblCedulaExtendidadepartamento.setSize("230px", "19px");
		
		Label lblDepartamentoResidencia = new Label("Departamento residencia");
		lblDepartamentoResidencia.setStyleName("label");
		absolutePanel.add(lblDepartamentoResidencia, 316, 751);
		lblDepartamentoResidencia.setSize("231px", "19px");
		
		lblEstadoDelEmpleado = new Label("Estado Del Empleado");
		lblEstadoDelEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoDelEmpleado, 38, 138);
		lblEstadoDelEmpleado.setSize("192px", "19px");
	}
	
	private String Depto_Municipio(String Departamento){
		String valor = "";
		if(Departamento.equals("Guatemala")){	
			
			valor = valor + "," + "Guatemala";
			valor = valor + "," + "Santa Catarina Pinula";
			valor = valor + "," + "San Jose Pinula";
			valor = valor + "," + "San Jose del Golfo";
			valor = valor + "," + "Palencia";
			valor = valor + "," + "Chinautla";
			valor = valor + "," + "San Pedro Ayampuc";
			valor = valor + "," + "Mixco";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Juan Sacatepequez";
			valor = valor + "," + "San Raymundo";
			valor = valor + "," + "Chuarrancho";
			valor = valor + "," + "Fraijanes";
			valor = valor + "," + "Amatitlan";
			valor = valor + "," + "Villa Nueva";
			valor = valor + "," + "Villa Canales";
			valor = valor + "," + "Petapa";
			
		}else if(Departamento.equals("Baja Verapaz")){
			valor = valor + "," + "Salama";
			valor = valor + "," + "San Miguel Chicaj";
			valor = valor + "," + "Rabinal";
			valor = valor + "," + "Cubulco";
			valor = valor + "," + "Granados";
			valor = valor + "," + "Santa Cruz el Chol";
			valor = valor + "," + "San Jeronimo";
			valor = valor + "," + "Purulha";
			
		}else if(Departamento.equals("Alta Verapaz")){
			valor = valor + "," + "Coban";
			valor = valor + "," + "Santa Cruz Verapaz";
			valor = valor + "," + "San Cristobal Verapaz";
			valor = valor + "," + "Tactic";
			valor = valor + "," + "Tamahu";
			valor = valor + "," + "Tucuru";
			valor = valor + "," + "Panzos";
			valor = valor + "," + "Senahu";
			valor = valor + "," + "San Pedro Carcha";
			valor = valor + "," + "San Juan Chamelco";
			valor = valor + "," + "Lanquin";
			valor = valor + "," + "Santa Maria Cahabon";
			valor = valor + "," + "Chisec";
			valor = valor + "," + "Chahal";
			valor = valor + "," + "Fray Bartolome de las Casas";
			valor = valor + "," + "La Tinta";
			valor = valor + "," + "Raxruha";
			
		}else if(Departamento.equals("El Progreso")){
			valor = valor + "," + "Guastatoya";
			valor = valor + "," + "Morazan";
			valor = valor + "," + "San Agustin Acasaguastlan";
			valor = valor + "," + "San Cristobal Acasaguastlan";
			valor = valor + "," + "El Jicaro";
			valor = valor + "," + "Sansare";
			valor = valor + "," + "Sanarate";
			valor = valor + "," + "San Antonio La Paz";
			
		}else if(Departamento.equals("Izabal")){
			valor = valor + "," + "Puerto Barrios";
			valor = valor + "," + "Livingston";
			valor = valor + "," + "El Estor";
			valor = valor + "," + "Morales";
			valor = valor + "," + "Los Amates";
			
		}else if(Departamento.equals("Zacapa")){
			valor = valor + "," + "Zacapa";
			valor = valor + "," + "Estanzuela";
			valor = valor + "," + "Rio Hondo";
			valor = valor + "," + "Gualan";
			valor = valor + "," + "Teculutan";
			valor = valor + "," + "Usumatlan";
			valor = valor + "," + "Cabañas";
			valor = valor + "," + "Huite";
			valor = valor + "," + "San Diego";
			valor = valor + "," + "La Union";
			valor = valor + "," + "Huite";
			
		}else if(Departamento.equals("Chiquimula")){

			valor = valor + "," + "Chiquimula";
			valor = valor + "," + "San Jose la Arada";
			valor = valor + "," + "San Juan Ermita";
			valor = valor + "," + "Jocotan";
			valor = valor + "," + "Camotan";
			valor = valor + "," + "Olopa";
			valor = valor + "," + "Esquipulas";
			valor = valor + "," + "Concepcion Las Minas";
			valor = valor + "," + "Quezaltepeque";
			valor = valor + "," + "San Jacinto";
			valor = valor + "," + "Ipala";
			
		}else if(Departamento.equals("Santa Rosa")){
			valor = valor + "," + "Cuilapa";
			valor = valor + "," + "Barberena";
			valor = valor + "," + "Santa Rosa de Lima";
			valor = valor + "," + "Casillas";
			valor = valor + "," + "San Rafael las Flores";
			valor = valor + "," + "Oratorio";
			valor = valor + "," + "San Juan Tecuaco";
			valor = valor + "," + "Chiquimulilla";
			valor = valor + "," + "Taxisco";
			valor = valor + "," + "Santa Maria Ixhuatan";
			valor = valor + "," + "Guazacapan";
			valor = valor + "," + "Santa Cruz Naranjo";
			valor = valor + "," + "Pueblo Nuevo Viñas";
			valor = valor + "," + "Nueva Santa Rosa";
			
		}else if(Departamento.equals("Jalapa")){
			valor = valor + "," + "Jalapa";
			valor = valor + "," + "San Pedro Pinula";
			valor = valor + "," + "San Luis Jilotepeque";
			valor = valor + "," + "San Manuel Chaparron";
			valor = valor + "," + "San Carlos Alzatate";
			valor = valor + "," + "Monjas";
			valor = valor + "," + "Mataquescuintla";
			
		}else if(Departamento.equals("Jutiapa")){
			valor = valor + "," + "Jutiapa";
			valor = valor + "," + "El Progreso";
			valor = valor + "," + "Santa Catarina Mita";
			valor = valor + "," + "Agua Blanca";
			valor = valor + "," + "Asuncion Mita";
			valor = valor + "," + "Yupiltepeque";
			valor = valor + "," + "Atescatempa";
			valor = valor + "," + "Jerez";
			valor = valor + "," + "El Adelanto";
			valor = valor + "," + "Zapotitlan";
			valor = valor + "," + "Comapa";
			valor = valor + "," + "Jalpatagua";
			valor = valor + "," + "Conguaco";
			valor = valor + "," + "Moyuta";
			valor = valor + "," + "Pasaco";
			valor = valor + "," + "San Jose Acatempa";
			valor = valor + "," + "Quesada";
			
		}else if(Departamento.equals("Sacatepequez")){
			valor = valor + "," + "La Antigua Guatemala";
			valor = valor + "," + "Jocotenango";
			valor = valor + "," + "Pastores";
			valor = valor + "," + "Sumpango";
			valor = valor + "," + "Santo Domingo Xenacoj";
			valor = valor + "," + "Santiago Sacatepequez";
			valor = valor + "," + "San Bartolome Milpas Altas";
			valor = valor + "," + "San Lucas Sacatepequez";
			valor = valor + "," + "Santa Lucia Milpas Altas";
			valor = valor + "," + "Magdalena Milpas Altas";
			valor = valor + "," + "Santa Maria de Jesus";
			valor = valor + "," + "Ciudad Vieja";
			valor = valor + "," + "San Miguel Dueñas";
			valor = valor + "," + "Alotenango";
			valor = valor + "," + "San Antonio Aguas Calientes";
			valor = valor + "," + "Santa Catarina Barahona";
			
		}else if(Departamento.equals("Chimaltenango")){
			valor = valor + "," + "Chimaltenango";
			valor = valor + "," + "San Jose Poaquil";
			valor = valor + "," + "San Martin Jilotepeque";
			valor = valor + "," + "San Juan Comalapa";
			valor = valor + "," + "Santa Apolonia";
			valor = valor + "," + "Tecpan";
			valor = valor + "," + "Patzun";
			valor = valor + "," + "Pochuta";
			valor = valor + "," + "Patzicia";
			valor = valor + "," + "Santa Cruz Balanya";
			valor = valor + "," + "Acatenango";
			valor = valor + "," + "Yepocapa";
			valor = valor + "," + "San Andres Itzapa";
			valor = valor + "," + "Parramos";
			valor = valor + "," + "Zaragoza";
			valor = valor + "," + "El Tejar";
			
		}else if(Departamento.equals("Escuintla")){			
			valor = valor + "," + "Escuintla";
			valor = valor + "," + "Santa Lucia Cotzumalguapa";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "Siquinala";
			valor = valor + "," + "Masagua";
			valor = valor + "," + "Tiquisate";
			valor = valor + "," + "La Gomera";
			valor = valor + "," + "Guanagazapa";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "Iztapa";
			valor = valor + "," + "Palin";
			valor = valor + "," + "San Vicente Pacaya";
			valor = valor + "," + "Nueva Concepcion";
			
		}else if(Departamento.equals("Solola")){
			valor = valor + "," + "Solola";
			valor = valor + "," + "San Jose Chacaya";
			valor = valor + "," + "Santa Maria Visitacion";
			valor = valor + "," + "Santa Lucia Utatlan";
			valor = valor + "," + "Nahuala";
			valor = valor + "," + "Santa Catarina Ixtahuacan";
			valor = valor + "," + "Santa Clara La Laguna";
			valor = valor + "," + "Concepcion";
			valor = valor + "," + "San Andres Semetabaj";
			valor = valor + "," + "Panajachel";
			valor = valor + "," + "Santa Catarina Palopo";
			valor = valor + "," + "San Antonio Palopo";
			valor = valor + "," + "San Lucas Toliman";
			valor = valor + "," + "Santa Cruz La Laguna";
			valor = valor + "," + "San Pablo La Laguna";
			valor = valor + "," + "San Juan La Laguna";
			valor = valor + "," + "San Marcos La Laguna";
			valor = valor + "," + "San Pedro La Laguna";
			valor = valor + "," + "Santiago Atitlan";
			
		}else if(Departamento.equals("Totonicapan")){
			valor = valor + "," + "Totonicapan";
			valor = valor + "," + "San Cristobal Totonicapan";
			valor = valor + "," + "San Francisco El Alto";
			valor = valor + "," + "San Andres Xecul";
			valor = valor + "," + "Momostenango";
			valor = valor + "," + "Santa Maria Chiquimula";
			valor = valor + "," + "Santa Lucia La Reforma";
			valor = valor + "," + "San Bartolo";
			
		}else if(Departamento.equals("Quezaltenango")){
			valor = valor + "," + "Quetzaltenango";
			valor = valor + "," + "Salcaja";
			valor = valor + "," + "Olintepeque";
			valor = valor + "," + "San Carlos Sija";
			valor = valor + "," + "Sibilia";
			valor = valor + "," + "Cabrican";
			valor = valor + "," + "Cajola";
			valor = valor + "," + "San Miguel Sigüila";
			valor = valor + "," + "San Juan Ostuncalco";
			valor = valor + "," + "San Mateo";
			valor = valor + "," + "Concepcion Chiquirichapa";
			valor = valor + "," + "San Martin Sacatepequez";
			valor = valor + "," + "Almolonga";
			valor = valor + "," + "Cantel";
			valor = valor + "," + "Huitan";
			valor = valor + "," + "Zunil";
			valor = valor + "," + "Colomba Costa Cuca";
			valor = valor + "," + "San Francisco La Union";
			valor = valor + "," + "El Palmar";
			valor = valor + "," + "Coatepeque";
			valor = valor + "," + "Genova";
			valor = valor + "," + "Flores Costa Cuca";
			valor = valor + "," + "La Esperanza";
			valor = valor + "," + "Palestina de Los Altos";
			
		}else if(Departamento.equals("Suchitepequez")){
			valor = valor + "," + "Mazatenango";
			valor = valor + "," + "Cuyotenango";
			valor = valor + "," + "San Francisco Zapotitlan";
			valor = valor + "," + "San Bernardino";
			valor = valor + "," + "San Jose El Idolo";
			valor = valor + "," + "Santo Domingo Suchitepequez";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "Samayac";
			valor = valor + "," + "San Pablo Jocopilas";
			valor = valor + "," + "San Antonio Suchitepequez";
			valor = valor + "," + "San Miguel Panan";
			valor = valor + "," + "San Gabriel";
			valor = valor + "," + "Chicacao";
			valor = valor + "," + "Patulul";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "San Juan Bautista";
			valor = valor + "," + "Santo Tomas La Union";
			valor = valor + "," + "Zunilito";
			valor = valor + "," + "Pueblo Nuevo";
			valor = valor + "," + "Rio Bravo";
			
		}else if(Departamento.equals("Retalhuleu")){
			valor = valor + "," + "Retalhuleu";
			valor = valor + "," + "San Sebastian";
			valor = valor + "," + "Santa Cruz Mulua";
			valor = valor + "," + "San Martin Zapotitlan";
			valor = valor + "," + "San Felipe";
			valor = valor + "," + "San Andres Villa Seca";
			valor = valor + "," + "Champerico";
			valor = valor + "," + "Nuevo San Carlos";
			valor = valor + "," + "El Asintal";
			
		}else if(Departamento.equals("San Marcos")){
			valor = valor + "," + "San Marcos";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Antonio Sacatepequez";
			valor = valor + "," + "Comitancillo";
			valor = valor + "," + "San Miguel Ixtahuacan";
			valor = valor + "," + "Concepcion Tutuapa";
			valor = valor + "," + "Tacana";
			valor = valor + "," + "Sibinal";
			valor = valor + "," + "Tajumulco";
			valor = valor + "," + "Tejutla";
			valor = valor + "," + "San Rafael Pie de la Cuesta";
			valor = valor + "," + "Nuevo Progreso";
			valor = valor + "," + "El Tumbador";
			valor = valor + "," + "San Jose El Rodeo";
			valor = valor + "," + "Malacatan";
			valor = valor + "," + "Catarina";
			valor = valor + "," + "Ayutla";
			valor = valor + "," + "Ocos";
			valor = valor + "," + "San Pablo";
			valor = valor + "," + "El Quetzal";
			valor = valor + "," + "La Reforma";
			valor = valor + "," + "Pajapita";
			valor = valor + "," + "Ixchiguan";
			valor = valor + "," + "San Jose Ojetenam";
			valor = valor + "," + "San Cristobal Cucho";
			valor = valor + "," + "Sipacapa";
			valor = valor + "," + "Esquipulas Palo Gordo";
			valor = valor + "," + "Rio Blanco";
			valor = valor + "," + "San Lorenzo";
			
		}else if(Departamento.equals("Huehuetenango")){
			valor = valor + "," + "Huehuetenango";
			valor = valor + "," + "Chiantla";
			valor = valor + "," + "Malacatancito";
			valor = valor + "," + "Cuilco";
			valor = valor + "," + "Nenton";
			valor = valor + "," + "San Pedro Necta";
			valor = valor + "," + "Jacaltenango";
			valor = valor + "," + "San Pedro Soloma";
			valor = valor + "," + "San Ildefonso Ixtahuacan";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "San Miguel Acatan";
			valor = valor + "," + "San Rafael La Independencia";
			valor = valor + "," + "Santos Cuchumatan";
			valor = valor + "," + "San Juan Atitan";
			valor = valor + "," + "Santa Eulalia";
			valor = valor + "," + "San Mateo Ixtatan";
			valor = valor + "," + "Colotenango";
			valor = valor + "," + "San Sebastian Huehuetenango";
			valor = valor + "," + "Tectitan";
			valor = valor + "," + "Concepcion Huista";
			valor = valor + "," + "San Juan Ixcoy";
			valor = valor + "," + "San Antonio Huista";
			valor = valor + "," + "San Sebastian Coatan";
			valor = valor + "," + "Santa Cruz Barillas";
			valor = valor + "," + "Aguacatan";
			valor = valor + "," + "San Rafael Petzal";
			valor = valor + "," + "San Gaspar Ixchil";
			valor = valor + "," + "Santiago Chimaltenango";
			valor = valor + "," + "Santa Ana Huista";
			valor = valor + "," + "Union Cantinil";
			
		}else if(Departamento.equals("Quiche")){
			valor = valor + "," + "Santa Cruz del Quiche";
			valor = valor + "," + "Chiche";
			valor = valor + "," + "Chinique";
			valor = valor + "," + "Zacualpa";
			valor = valor + "," + "Chajul";
			valor = valor + "," + "Chichicastenango";
			valor = valor + "," + "Patzite";
			valor = valor + "," + "San Antonio Ilotenango";
			valor = valor + "," + "San Pedro Jocopilas";
			valor = valor + "," + "Cunen";
			valor = valor + "," + "San Juan Cotzal";
			valor = valor + "," + "Joyabaj";
			valor = valor + "," + "Nebaj";
			valor = valor + "," + "San Andres Sajcabaja";
			valor = valor + "," + "Uspantan";
			valor = valor + "," + "Sacapulas";
			valor = valor + "," + "San Bartolome Jocotenango";
			valor = valor + "," + "Canilla";
			valor = valor + "," + "Chicaman";
			valor = valor + "," + "Ixcan";
			valor = valor + "," + "Pachalum";
			
		}else if(Departamento.equals("Peten")){
			valor = valor + "," + "Flores";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "San Benito";
			valor = valor + "," + "San Andres";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "San Francisco";
			valor = valor + "," + "Santa Ana";
			valor = valor + "," + "Dolores";
			valor = valor + "," + "San Luis";
			valor = valor + "," + "Sayaxche";
			valor = valor + "," + "Melchor de Mencos";
			valor = valor + "," + "Poptun";
			
		}
		return valor;
	}
	
	public void LlenarDatos(Long id,String listEstadoCivil,String listSexo,String txtPrimerApellido,
		    String txtSegundoApellido , String txtApellidoCasada ,String txtNo_iggs, String txtPrimerNombre,
		    String txtSegundoNombre ,String listPais,String listNoDependientes , String txtTipoPasaporte ,
		    String listDireccionMunicipio,String txtDireccion , String txtCorreoElectronico,
		    String listTipoLicencia, Long dateAnnioNacimiento,String txtOcupacion , String txtCentroTrabajo,
		    String txt_CodigoOcupacion, String txtProfesion,String txtTipoPlanilla, Long dateFechaIngreso,
		    String noCuenta, String tipoCuenta, String nombreBanco , String txtDPI,String txtTelefonoCasa, String txtTelefonoCelular ,
		    String txtNoLicencia, String txtNit, String txtNoPasaporte,String txtSalarioBase ,String txtBonificacion ,
		    String txtTotal, String listDireccionDepartamento ,String txtIVS, String  URLFile, 
		    String KeyFile,String Estado,String pasaporte, String licencia)
	{
		this.KeyFile = KeyFile;
		this.URLFile = URLFile;
		this.id_empleado = id;
		this.bandera = false;
		this.txtNo_iggs.setText(txtNo_iggs);
		
		try{
			image.setUrl( URLFile);
			Archivo();
		}catch(Exception e){
			image.setUrl("images/imagenempresa.png");
		}
		
        boolean bandera = true;
        for(int i=0; i < this.listEstadoCivil.getItemCount() && bandera; i++){
            bandera = !this.listEstadoCivil.getValue(i).equals(listEstadoCivil);
            this.listEstadoCivil.setSelectedIndex(i);
        }   

		bandera = true;
	    for(int i=0; i < this.nombreBanco.getItemCount() && bandera; i++){
	       bandera = !this.nombreBanco.getValue(i).equals(nombreBanco);
	       this.nombreBanco.setSelectedIndex(i);
	    } 
	    
		bandera = true;
	    for(int i=0; i < this.tipoCuenta.getItemCount() && bandera; i++){
	       bandera = !this.tipoCuenta.getValue(i).equals(tipoCuenta);
	       this.tipoCuenta.setSelectedIndex(i);
	    } 
	        
        bandera = true;
        for(int i=0; i < this.listEstado.getItemCount() && bandera; i++){
            bandera = !this.listEstado.getValue(i).equals(Estado);
            this.listEstado.setSelectedIndex(i);
        } 
       
        bandera = true;
        for(int i=0; i < this.listSexo.getItemCount() && bandera; i++){
            bandera = !this.listSexo.getValue(i).equals(listSexo);
            this.listSexo.setSelectedIndex(i);
        }   
        bandera = true;
        for(int i=0; i < this.listLicencia.getItemCount() && bandera; i++){
            bandera = !this.listLicencia.getValue(i).equals(licencia);
            this.listLicencia.setSelectedIndex(i);
        } 
        if(licencia.equals("No"))
		{
			this.listTipoLicencia.setVisible(false);
			this.txtNoLicencia.setVisible(false);
			label_26.setVisible(false);
			label_27.setVisible(false);
		}else{
			this.listTipoLicencia.setVisible(true);
			this.txtNoLicencia.setVisible(true);
			label_26.setVisible(true);
			label_27.setVisible(true);
		}
		this.txtPrimerApellido.setText(txtPrimerApellido);
		this.txtSegundoApellido.setText(txtSegundoApellido);
		this.txtApellidoCasada.setText(txtApellidoCasada);
		this.txtPrimerNombre.setText(txtPrimerNombre);
		this.txtSegundoNombre.setText(txtSegundoNombre);
		
		 bandera = true;
	        for(int i=0; i < this.listIVS.getItemCount() && bandera; i++){
	           bandera = !this.listIVS.getValue(i).equals(txtIVS);
	           this.listIVS.setSelectedIndex(i);
	        }  
	        
        bandera = true;
        for(int i=0; i < this.listPais.getItemCount() && bandera; i++){
           bandera = !this.listPais.getValue(i).equals(listPais);
           this.listPais.setSelectedIndex(i);
        }   
		this.txtNit.setText(txtNit);
        bandera = true;
        for(int i=0; i < this.listNoDependientes.getItemCount() && bandera; i++){
            bandera = !this.listNoDependientes.getItemText(i).equals(listNoDependientes);
            this.listNoDependientes.setSelectedIndex(i);
        }   
		this.noCuenta.setText(noCuenta);
		this.txtDPI.setText(txtDPI);
		this.txtTipoPasaporte.setText(txtTipoPasaporte);
		this.txtNoPasaporte.setText(txtNoPasaporte);
		this.txtDireccion.setText(txtDireccion);
		this.txtCorreoElectronico.setText(txtCorreoElectronico);
		this.txtTelefonoCasa.setText(txtTelefonoCasa);
		this.txtTelefonoCelular.setText(txtTelefonoCelular);
		
		this.dateAnnioNacimiento.setValue(new Date(dateAnnioNacimiento));
        bandera = true;
        for(int i=0; i < this.listTipoLicencia.getItemCount() && bandera; i++){
            bandera = this.listTipoLicencia.getValue(i).equals(listTipoLicencia);
            this.listTipoLicencia.setSelectedIndex(i);
        }   
		this.txtNoLicencia.setText(txtNoLicencia);
		this.txtCentroTrabajo.setText(txtCentroTrabajo);
		this.txtOcupacion.setText(txtOcupacion);
		this.dateFechaIngreso.setValue(new Date(dateFechaIngreso));
		this.txt_CodigoOcupacion.setText(txt_CodigoOcupacion);
		this.txtProfesion.setText(txtProfesion);
		this.txtTipoPlanilla.setText(txtTipoPlanilla);
		this.txtSalarioBase.setText(txtSalarioBase);
		this.txtTotal.setText(txtTotal);
		this.txtBonificacion.setText(txtBonificacion);

        bandera = true;
        for(int i=0; i < this.listDireccionDepartamento.getItemCount() && bandera; i++){
            bandera = !this.listDireccionDepartamento.getValue(i).equals(listDireccionDepartamento);
            this.listDireccionDepartamento.setSelectedIndex(i);
        }   
        

        bandera = true;
        for(int i=0; i < this.nombreBanco.getItemCount() && bandera; i++){
            bandera = !this.nombreBanco.getValue(i).equals(nombreBanco);
            this.nombreBanco.setSelectedIndex(i);
        }   

        bandera = true;
        for(int i=0; i < this.listTienePasaporte.getItemCount() && bandera; i++){
            bandera = !this.listTienePasaporte.getValue(i).equals(pasaporte);
            this.listTienePasaporte.setSelectedIndex(i);
        } 
        if(pasaporte.equals("No"))
		{
			this.txtTipoPasaporte.setVisible(false);
			this.txtNoPasaporte.setVisible(false);
			label_17.setVisible(false);
			label_16.setVisible(false);
		}else{
			this.txtTipoPasaporte.setVisible(true);
			this.txtNoPasaporte.setVisible(true);
			label_17.setVisible(true);
			label_16.setVisible(true);
		}

        this.listDireccionMunicipio.clear();
        String[] numerosComoArray2 = Depto_Municipio(this.listDireccionDepartamento.getItemText(this.listDireccionDepartamento.getSelectedIndex())).split(",");
        int correlativo = 0 + Integer.parseInt(this.listDireccionDepartamento.getValue(this.listDireccionDepartamento.getSelectedIndex())+"00");
        for (int i = 0; i < numerosComoArray2.length; i++) {
        	this.listDireccionMunicipio.addItem(numerosComoArray2[i],String.valueOf(correlativo));
        	correlativo++;
        }

        bandera = true;
        for(int i=0; i < this.listDireccionMunicipio.getItemCount() && bandera; i++){
            bandera = !this.listDireccionMunicipio.getValue(i).equals(listDireccionMunicipio);
            this.listDireccionMunicipio.setSelectedIndex(i);
        }   
				  
		
	}
	
	public void Inavilitar_Casillas(){
		txtCentroTrabajo.setVisible(false);
		txtOcupacion.setVisible(false);
		dateFechaIngreso.setVisible(false);
		txt_CodigoOcupacion.setVisible(false);
		txtProfesion.setVisible(false);
		txtTipoPlanilla.setVisible(false);
		txtSalarioBase.setVisible(false);
		txtBonificacion.setVisible(false);
		txtTotal.setVisible(false);
		listEstado.setVisible(false);
		btnExportarDatos.setVisible(false);
		btnImprimir.setVisible(false);
		 	lblEstadoDelEmpleado.setVisible(false);			
		 	lblCentroTrabajo.setVisible(false);
			lblOcupacion.setVisible(false);
			lblFechaIngreso.setVisible(false);
			lblCodigoOcupacion.setVisible(false);
			lblProfesion.setVisible(false);
			lblTipoPlanilla.setVisible(false);
			lblSalarioBase.setVisible(false);
			lblBonificacion.setVisible(false);
			lblTotal.setVisible(false);
			lblD.setVisible(false);
			absolutePanel.add(btnActualizar, 316, 1200);
	}
	private FormPanel getFormPanel() {
		if (form == null) {
			form = new FormPanel();
			form.setSize("357px", "59px");
			form.setAction("/upload");
			form.setEncoding(FormPanel.ENCODING_MULTIPART);
	    form.setMethod(FormPanel.METHOD_POST);
			form.setWidget(getFormElements());
			//form.add(getHidden());
			
			// add submit handler
	    form.addSubmitHandler(new SubmitHandler() {
				public void onSubmit(SubmitEvent event) {
					if (fileUpload.getFilename().length() == 0) {
	                	setMensaje("alert alert-info", 
	                			"Selecciono un archivo?");
						event.cancel();
					}
				}
			});
	    
	    // add submit complete handler
	    form.addSubmitCompleteHandler(new SubmitCompleteHandler() {
				public void onSubmitComplete(SubmitCompleteEvent event) {
					button.setEnabled(false);
					String results = event.getResults();
					try{
						int i = results.indexOf("key=");
						KeyFile = results.substring(i+4, results.length()-2);
						i = results.indexOf("http");
						URLFile = results.substring(i, results.length()-2);
						//Window.alert(URLFile);
						//Window.alert(KeyFile);
						//pResponse.add(new HTML(results));
						getFormUrl();
						form.setVisible(false);
						Archivo();
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nal subir foto");
						
					}
				}
			});
	    
		}
		return form;
	}
	
	private VerticalPanel getFormElements() {
		if (formElements == null) {
			formElements = new VerticalPanel();
			formElements.setSize("356px", "100%");
			formElements.add(getFileUpload());
			formElements.add(getButton());
		}
		return formElements;
	}
	
	private FileUpload getFileUpload() {
		if (fileUpload == null) {
			fileUpload = new FileUpload();
			fileUpload.setWidth("357px");
			fileUpload.setName("myFile");
			fileUpload.getElement().setAttribute("accept", "image/png, image/gif,image/jpeg");
		}
		return fileUpload;
	}
	
	private Button getButton() {
		if (button == null) {
			button = new Button("Subir");
			button.setHeight("31px");
			button.setStyleName("sendButton");
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					form.submit();
				}
			});
			button.setEnabled(false);
		}
		return button;
	}
	
	private void getFormUrl() {
		
		uploadUrlService.getUploadUrl(new AsyncCallback<String>() {
			public void onSuccess(String url) {
				form.setAction(url);
				button.setEnabled(true);
				System.out.println("retrieved url for blob store: " + url);
			}

			public void onFailure(Throwable caught) {
            	setMensaje("alert alert-error", 
            			"Error !! \nen el servicio");
			}
		});
		
	}
	public void Archivo(){

		form.setVisible(false);
		grid = new Grid(1, 2);
		absolutePanel.add(grid, 580, 109);
		grid.setSize("357px", "59px");
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setHeight("27px");
		grid.setVisible(true);
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				loginService.remove(getKeyFile() , new AsyncCallback<String>(){
					@Override
					public void onFailure(Throwable caught) {
					}
					@Override
					public void onSuccess(String result) {
						form.setVisible(true);
						grid.setVisible(false);
						KeyFile = "";
						URLFile = "";
					}

                });
			}
		});

		image.setUrl(URLFile);
		grid.setWidget(0, 1, btnEliminar);
		//Window.alert(URLFile);
		grid.setWidget(0, 0, new HTML("<a  target=\"_blank\" href=" + URLFile +">Ver</a>"));
	}

	public String getURLFile() {
		return URLFile;
	}

	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}

	public String getKeyFile() {
		return KeyFile;
	}

	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
    public void setMensaje(String estilo, String mensaje){
        final DialogBox Registro2 = new DialogBox();
        final HTML serverResponseLabel = new HTML();
        final Button close= new Button("x");
        Mensaje inicio = new Mensaje();
        
        Registro2.setStyleName(estilo);
        inicio.mensajeEntrada(mensaje);
        inicio.mensajeEstilo(estilo);
        close.addStyleName("close");
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(inicio);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(close);
        Registro2 .setWidget(dialogVPanel);
        Registro2 .setModal(true);
        Registro2 .setGlassEnabled(true);
        Registro2 .setAnimationEnabled(true);
        Registro2 .center();
        Registro2 .show();
        close.setFocus(true);
    
        close.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            Registro2.hide();
        }
    });
    }
}
