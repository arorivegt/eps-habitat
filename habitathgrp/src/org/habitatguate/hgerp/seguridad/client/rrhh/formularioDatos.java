package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.i18n.client.DateTimeFormat;
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
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    
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
    private ListBox listCedulaMunicipio;
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
    private IntegerBox txtRegistro ;
    private TextBox txtNoOrden ;
    private IntegerBox txtDPI;
    private IntegerBox txtTelefonoCasa;
    private IntegerBox txtTelefonoCelular ;
    private IntegerBox txtNoLicencia;
    private TextBox txtNit ;
    private IntegerBox txtNoPasaporte;
    private TextBox txtSalarioBase ;
    private TextBox txtBonificacion ;
    private TextBox txtTotal ;
    private ListBox listCedulaDepartamento ;
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
    
	public formularioDatos(Empleados e,final int tipo) {
		this.empleado = e;
		this.setTipo(tipo);
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("997px", "1337px");
		getFormUrl();
		
		listEstado = new ListBox();
		listEstado.addItem("empleado activo");
		listEstado.addItem("empleado inactivo");
		listEstado.addItem("posible empleado");
		listEstado.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listEstado, 36, 163);
		listEstado.setSize("230px", "36px");
		image = new Image("images/imagenempresa.png");
		absolutePanel.add(image, 341, 10);
		image.setSize("167px", "158px");
		
				absolutePanel.add(getFormPanel(), 591, 109);
		
		txtNo_iggs = new IntegerBox();
		txtNo_iggs.setText("0");
		txtNo_iggs.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtNo_iggs, 36, 239);
		txtNo_iggs.setSize("227px", "34px");
		
		listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("Soltero/a");
		listEstadoCivil.addItem("Casado/a");
		listEstadoCivil.addItem("Divorciado/a");
		listEstadoCivil.addItem("Viudo/a");
		listEstadoCivil.addItem("Separado/a");
		listEstadoCivil.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listEstadoCivil, 319, 239);
		listEstadoCivil.setSize("230px", "36px");
		
		listSexo = new ListBox();
		listSexo.addItem("femenino");
		listSexo.addItem("masculino");
		listSexo.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listSexo, 591, 239);
		listSexo.setSize("227px", "34px");
		
		txtPrimerApellido = new TextBox();
		txtPrimerApellido.setMaxLength(50);
		txtPrimerApellido.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtPrimerApellido, 36, 312);
		txtPrimerApellido.setSize("227px", "34px");
		
		txtSegundoApellido = new TextBox();
		txtSegundoApellido.setMaxLength(50);
		txtSegundoApellido.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtSegundoApellido, 317, 312);
		txtSegundoApellido.setSize("227px", "34px");
		
		txtApellidoCasada = new TextBox();
		txtApellidoCasada.setMaxLength(50);
		txtApellidoCasada.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtApellidoCasada, 589, 312);
		txtApellidoCasada.setSize("227px", "34px");
		
		txtPrimerNombre = new TextBox();
		txtPrimerNombre.setMaxLength(50);
		txtPrimerNombre.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtPrimerNombre, 37, 383);
		txtPrimerNombre.setSize("227px", "34px");
		
		txtSegundoNombre = new TextBox();
		txtSegundoNombre.setMaxLength(50);
		txtSegundoNombre.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtSegundoNombre, 318, 383);
		txtSegundoNombre.setSize("227px", "34px");
		
		listPais = new ListBox();
		listPais.addItem("Afganistan");
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
		listPais.addItem("Azerbaiyan");
		listPais.addItem("Bahamas");
		listPais.addItem("Banglades");
		listPais.addItem("Barbados");
		listPais.addItem("Barein");
		listPais.addItem("Belgica");
		listPais.addItem("Belice");
		listPais.addItem("Benin");
		listPais.addItem("Bielorrusia");
		listPais.addItem("Birmania");
		listPais.addItem("Bolivia");
		listPais.addItem("Bosnia y Herzegovina");
		listPais.addItem("Botsuana");
		listPais.addItem("Brasil");
		listPais.addItem("Brunei");
		listPais.addItem("Bulgaria");
		listPais.addItem("Burkina Faso");
		listPais.addItem("Burundi");
		listPais.addItem("Butan");
		listPais.addItem("Cabo Verde");
		listPais.addItem("Camboya");
		listPais.addItem("Camerun");
		listPais.addItem("Canada");
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
		listPais.addItem("Emiratos arabes Unidos");
		listPais.addItem("Eritrea");
		listPais.addItem("Eslovaquia");
		listPais.addItem("Eslovenia");
		listPais.addItem("España");
		listPais.addItem("Estados Unidos");
		listPais.addItem("Estonia");
		listPais.addItem("Etiopia");
		listPais.addItem("Filipinas");
		listPais.addItem("Finlandia");
		listPais.addItem("Fiyi");
		listPais.addItem("Francia");
		listPais.addItem("Gabon");
		listPais.addItem("Gambia");
		listPais.addItem("Georgia");
		listPais.addItem("Ghana");
		listPais.addItem("Granada");
		listPais.addItem("Grecia");
		listPais.addItem("Guatemala");
		listPais.addItem("Guyana");
		listPais.addItem("Guinea");
		listPais.addItem("Guinea ecuatorial");
		listPais.addItem("Guinea-Bisau");
		listPais.addItem("Haiti");
		listPais.addItem("Honduras");
		listPais.addItem("Hungria");
		listPais.addItem("India");
		listPais.addItem("Indonesia");
		listPais.addItem("Irak");
		listPais.addItem("Iran");
		listPais.addItem("Irlanda");
		listPais.addItem("Islandia");
		listPais.addItem("Islas Marshall");
		listPais.addItem("Islas Salomon");
		listPais.addItem("Israel");
		listPais.addItem("Italia");
		listPais.addItem("Jamaica");
		listPais.addItem("Japon");
		listPais.addItem("Jordania");
		listPais.addItem("Kazajistan");
		listPais.addItem("Kenia");
		listPais.addItem("Kirguistan");
		listPais.addItem("Kiribati");
		listPais.addItem("Kuwait");
		listPais.addItem("Laos");
		listPais.addItem("Lesoto");
		listPais.addItem("Letonia");
		listPais.addItem("Libano");
		listPais.addItem("Liberia");
		listPais.addItem("Libia");
		listPais.addItem("Liechtenstein");
		listPais.addItem("Lituania");
		listPais.addItem("Luxemburgo");
		listPais.addItem("Madagascar");
		listPais.addItem("Malasia");
		listPais.addItem("Malaui");
		listPais.addItem("Maldivas");
		listPais.addItem("Mali");
		listPais.addItem("Malta");
		listPais.addItem("Marruecos");
		listPais.addItem("Mauricio");
		listPais.addItem("Mauritania");
		listPais.addItem("Mexico");
		listPais.addItem("Micronesia");
		listPais.addItem("Moldavia");
		listPais.addItem("Monaco");
		listPais.addItem("Mongolia");
		listPais.addItem("Montenegro");
		listPais.addItem("Mozambique");
		listPais.addItem("Namibia");
		listPais.addItem("Nauru");
		listPais.addItem("Nepal");
		listPais.addItem("Nicaragua");
		listPais.addItem("Niger");
		listPais.addItem("Nigeria");
		listPais.addItem("Noruega");
		listPais.addItem("Nueva Zelanda");
		listPais.addItem("Oman");
		listPais.addItem("Paises Bajos");
		listPais.addItem("Pakistan");
		listPais.addItem("Palaos");
		listPais.addItem("Panama");
		listPais.addItem("Papua Nueva Guinea");
		listPais.addItem("Paraguay");
		listPais.addItem("Peru");
		listPais.addItem("Polonia");
		listPais.addItem("Portugal");
		listPais.addItem("Reino Unido");
		listPais.addItem("Republica Centroafricana");
		listPais.addItem("Republica Checa");
		listPais.addItem("Republica de Macedonia");
		listPais.addItem("Republica del Congo");
		listPais.addItem("Republica Democratica del Congo");
		listPais.addItem("Republica Dominicana");
		listPais.addItem("Republica Sudafricana");
		listPais.addItem("Ruanda");
		listPais.addItem("Rumania");
		listPais.addItem("Rusia");
		listPais.addItem("Samoa");
		listPais.addItem("San Cristobal y Nieves");
		listPais.addItem("San Marino");
		listPais.addItem("San Vicente y las Granadinas");
		listPais.addItem("Santa Lucia");
		listPais.addItem("Santo Tome y Principe");
		listPais.addItem("Senegal");
		listPais.addItem("Serbia");
		listPais.addItem("Seychelles");
		listPais.addItem("Sierra Leona");
		listPais.addItem("Singapur");
		listPais.addItem("Siria");
		listPais.addItem("Somalia");
		listPais.addItem("Sri Lanka");
		listPais.addItem("Suazilandia");
		listPais.addItem("Sudan");
		listPais.addItem("Sudan del Sur");
		listPais.addItem("Suecia");
		listPais.addItem("Suiza");
		listPais.addItem("Surinam");
		listPais.addItem("Tailandia");
		listPais.addItem("Tanzania");
		listPais.addItem("Tayikistan");
		listPais.addItem("Timor Oriental");
		listPais.addItem("Togo");
		listPais.addItem("Tonga");
		listPais.addItem("Trinidad y Tobago");
		listPais.addItem("Tunez");
		listPais.addItem("Turkmenistan");
		listPais.addItem("Turquia");
		listPais.addItem("Tuvalu");
		listPais.addItem("Ucrania");
		listPais.addItem("Uganda");
		listPais.addItem("Uruguay");
		listPais.addItem("Uzbekistan");
		listPais.addItem("Vanuatu");
		listPais.addItem("Venezuela");
		listPais.addItem("Vietnam");
		listPais.addItem("Yemen");
		listPais.addItem("Yibuti");
		listPais.addItem("Zambia");
		listPais.addItem("Zimbabue");
		listPais.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listPais, 590, 383);
		listPais.setSize("230px", "36px");
		
		listIVS = new ListBox();
		listIVS.addItem("Con IVS");
		listIVS.addItem("Sin IVS");
		listIVS.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listIVS, 34, 467);
		listIVS.setSize("230px", "36px");
		
		txtNit = new TextBox();
		txtNit.setStyleName("gwt-PasswordTextBox");
		txtNit.setMaxLength(50);
		absolutePanel.add(txtNit, 315, 467);
		txtNit.setSize("227px", "34px");
		
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
		absolutePanel.add(listNoDependientes, 588, 467);
		listNoDependientes.setSize("230px", "36px");
		
		txtNoOrden = new TextBox();
		txtNoOrden.setStyleName("gwt-PasswordTextBox");
		txtNoOrden.setMaxLength(50);
		absolutePanel.add(txtNoOrden, 40, 536);
		txtNoOrden.setSize("227px", "34px");
		
		txtRegistro = new IntegerBox();
		txtRegistro.setText("0");
		txtRegistro.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtRegistro, 320, 536);
		txtRegistro.setSize("227px", "34px");
		
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
		txtDPI.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtDPI, 592, 536);
		txtDPI.setSize("227px", "34px");
		
		listTienePasaporte = new ListBox();
		listTienePasaporte.addChangeHandler(new ChangeHandler() {
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
		listTienePasaporte.addItem("Si");
		listTienePasaporte.addItem("No");
		listTienePasaporte.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listTienePasaporte, 38, 611);
		listTienePasaporte.setSize("232px", "36px");
		
		txtTipoPasaporte = new TextBox();
		txtTipoPasaporte.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTipoPasaporte, 320, 611);
		txtTipoPasaporte.setSize("227px", "34px");
		
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
		absolutePanel.add(txtNoPasaporte, 589, 611);
		txtNoPasaporte.setSize("230px", "36px");
		
		listCedulaDepartamento = new ListBox();
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
		listCedulaDepartamento.addItem("Peten");
		listCedulaDepartamento.addItem("Quezaltenango");
		listCedulaDepartamento.addItem("Quiche");
		listCedulaDepartamento.addItem("Retalhuleu");
		listCedulaDepartamento.addItem("Sacatepequez");
		listCedulaDepartamento.addItem("San Marcos");
		listCedulaDepartamento.addItem("Santa Rosa");
		listCedulaDepartamento.addItem("Solola");
		listCedulaDepartamento.addItem("Suchitepequez");
		listCedulaDepartamento.addItem("Totonicapan");
		listCedulaDepartamento.addItem("Zacapa");
		listCedulaDepartamento.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listCedulaMunicipio.clear();
		        String[] numerosComoArray = Depto_Municipio(listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex())).split(",");
		        for (int i = 0; i < numerosComoArray.length; i++) {
		        	listCedulaMunicipio.addItem(numerosComoArray[i]);
		        }
		        listCedulaMunicipio.setSelectedIndex(2);
			}		
		});
		listCedulaDepartamento.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listCedulaDepartamento, 35, 687);
		listCedulaDepartamento.setSize("230px", "36px");
		
		listCedulaMunicipio = new ListBox();
		listCedulaMunicipio.addItem("Chahal");
		listCedulaMunicipio.addItem("Chisec");
		listCedulaMunicipio.addItem("Coban");
		listCedulaMunicipio.addItem("Fray Bartolome de las Casas");
		listCedulaMunicipio.addItem("La Tinta");
		listCedulaMunicipio.addItem("Lanquin");
		listCedulaMunicipio.addItem("Panzos");
		listCedulaMunicipio.addItem("Raxruha");
		listCedulaMunicipio.addItem("San Cristobal Verapaz");
		listCedulaMunicipio.addItem("San Juan Chamelco");
		listCedulaMunicipio.addItem("San Pedro Carcha");
		listCedulaMunicipio.addItem("Santa Cruz Verapaz");
		listCedulaMunicipio.addItem("Santa Maria Cahabon");
		listCedulaMunicipio.addItem("Senahu");
		listCedulaMunicipio.addItem("Tamahu");
		listCedulaMunicipio.addItem("Tactic");
		listCedulaMunicipio.addItem("Tucuru");
		listCedulaMunicipio.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listCedulaMunicipio, 316, 687);
		listCedulaMunicipio.setSize("230px", "36px");
		
		dateAnnioNacimiento = new DateBox();
		dateAnnioNacimiento.setValue(new Date(1407518707105L));
		dateAnnioNacimiento.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateAnnioNacimiento.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateAnnioNacimiento, 588, 680);
		dateAnnioNacimiento.setSize("228px", "41px");
		
		txtDireccion = new TextBox();
		txtDireccion.setMaxLength(200);
		txtDireccion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtDireccion, 37, 774);
		txtDireccion.setSize("227px", "34px");
		
		listDireccionDepartamento = new ListBox();
		listDireccionDepartamento.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listDireccionMunicipio.clear();
		        String[] numerosComoArray = Depto_Municipio(listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex())).split(",");
		        for (int i = 0; i < numerosComoArray.length; i++) {
		        	listDireccionMunicipio.addItem(numerosComoArray[i]);
		        }

		        listDireccionMunicipio.setSelectedIndex(2);
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
		listDireccionDepartamento.addItem("Peten");
		listDireccionDepartamento.addItem("Quezaltenango");
		listDireccionDepartamento.addItem("Quiche");
		listDireccionDepartamento.addItem("Retalhuleu");
		listDireccionDepartamento.addItem("Sacatepequez");
		listDireccionDepartamento.addItem("San Marcos");
		listDireccionDepartamento.addItem("Santa Rosa");
		listDireccionDepartamento.addItem("Solola");
		listDireccionDepartamento.addItem("Suchitepequez");
		listDireccionDepartamento.addItem("Totonicapan");
		listDireccionDepartamento.addItem("Zacapa");
		listDireccionDepartamento.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listDireccionDepartamento, 316, 776);
		listDireccionDepartamento.setSize("230px", "36px");
		
		listDireccionMunicipio = new ListBox();
		listDireccionMunicipio.addItem("Tucuru");
		listDireccionMunicipio.addItem("Tactic");
		listDireccionMunicipio.addItem("Tamahu");
		listDireccionMunicipio.addItem("Senahu");
		listDireccionMunicipio.addItem("Santa Maria Cahabon");
		listDireccionMunicipio.addItem("Santa Cruz Verapaz");
		listDireccionMunicipio.addItem("San Pedro Carcha");
		listDireccionMunicipio.addItem("San Juan Chamelco");
		listDireccionMunicipio.addItem("San Cristobal Verapaz");
		listDireccionMunicipio.addItem("Raxruha");
		listDireccionMunicipio.addItem("Panzos");
		listDireccionMunicipio.addItem("Lanquin");
		listDireccionMunicipio.addItem("La Tinta");
		listDireccionMunicipio.addItem("Fray Bartolome de las Casas");
		listDireccionMunicipio.addItem("Coban");
		listDireccionMunicipio.addItem("Chisec");
		listDireccionMunicipio.addItem("Chahal");
		listDireccionMunicipio.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listDireccionMunicipio, 588, 774);
		listDireccionMunicipio.setSize("230px", "36px");
		
		txtCorreoElectronico = new TextBox();
		txtCorreoElectronico.setMaxLength(200);
		txtCorreoElectronico.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtCorreoElectronico, 37, 853);
		txtCorreoElectronico.setSize("227px", "34px");
		
		
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
		txtTelefonoCasa.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTelefonoCasa, 317, 853);
		txtTelefonoCasa.setSize("227px", "34px");
		
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
		txtTelefonoCelular.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTelefonoCelular, 589, 853);
		txtTelefonoCelular.setSize("227px", "34px");
		
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
		listLicencia.addItem("Si");
		listLicencia.addItem("No");
		listLicencia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listLicencia, 36, 935);
		listLicencia.setSize("230px", "36px");
		
		listTipoLicencia = new ListBox();
		listTipoLicencia.addItem("A");
		listTipoLicencia.addItem("B");
		listTipoLicencia.addItem("C");
		listTipoLicencia.addItem("M");
		listTipoLicencia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listTipoLicencia, 316, 935);
		listTipoLicencia.setSize("230px", "36px");
		
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
		txtNoLicencia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtNoLicencia, 589, 935);
		txtNoLicencia.setSize("227px", "34px");
		
		txtCentroTrabajo = new TextBox();
		txtCentroTrabajo.setMaxLength(50);
		txtCentroTrabajo.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtCentroTrabajo, 37, 1103);
		txtCentroTrabajo.setSize("227px", "34px");
		
		txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(50);
		txtOcupacion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtOcupacion, 314, 1103);
		txtOcupacion.setSize("227px", "34px");
		
		dateFechaIngreso = new DateBox();
		dateFechaIngreso.setValue(new Date(1407518751219L));
		dateFechaIngreso.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFechaIngreso.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFechaIngreso, 588, 1102);
		dateFechaIngreso.setSize("228px", "35px");
		
		txt_CodigoOcupacion = new TextBox();
		txt_CodigoOcupacion.setMaxLength(50);
		txt_CodigoOcupacion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txt_CodigoOcupacion, 37, 1166);
		txt_CodigoOcupacion.setSize("227px", "34px");
		
		txtProfesion = new TextBox();
		txtProfesion.setMaxLength(50);
		txtProfesion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtProfesion, 314, 1166);
		txtProfesion.setSize("227px", "34px");
		
		txtTipoPlanilla = new TextBox();
		txtTipoPlanilla.setMaxLength(50);
		txtTipoPlanilla.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTipoPlanilla, 589, 1166);
		txtTipoPlanilla.setSize("227px", "34px");
		
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
		txtSalarioBase.setStyleName("gwt-PasswordTextBox");
		txtSalarioBase.setMaxLength(50);
		absolutePanel.add(txtSalarioBase, 38, 1233);
		txtSalarioBase.setSize("227px", "34px");
		
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
		txtBonificacion.setStyleName("gwt-PasswordTextBox");
		txtBonificacion.setMaxLength(50);
		absolutePanel.add(txtBonificacion, 319, 1234);
		txtBonificacion.setSize("227px", "34px");
		
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
		txtTotal.setStyleName("gwt-PasswordTextBox");
		txtTotal.setMaxLength(50);
		absolutePanel.add(txtTotal, 592, 1234);
		txtTotal.setSize("227px", "34px");
		
		btnActualizar = new Button("Send");
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 320, 1313);
		btnActualizar.setSize("229px", "44px");
		
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
					depto_municipio_uno = listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex()) + "," +listCedulaMunicipio.getItemText(listCedulaMunicipio.getSelectedIndex());
					depto_municipio_dos = listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getItemText(listDireccionMunicipio.getSelectedIndex());
					System.out.println("pais en: "+listPais.getSelectedIndex());
					loginService.Insertar_Emppleado(txtNo_iggs.getText(), listEstadoCivil.getItemText(listEstadoCivil.getSelectedIndex()), 
							listSexo.getItemText(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), listIVS.getItemText(listIVS.getSelectedIndex()), 
							listPais.getItemText(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
							txtNoOrden.getText(), txtRegistro.getText(), txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
							depto_municipio_uno, txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
							txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getItemText(listTipoLicencia.getSelectedIndex()), 
							txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()),URLFile, KeyFile,listEstado.getItemText(listEstado.getSelectedIndex()),
							listTienePasaporte.getItemText(listTienePasaporte.getSelectedIndex()),listLicencia.getItemText(listLicencia.getSelectedIndex()),new AsyncCallback<Long>() 
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
					depto_municipio_uno = listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex()) + "," +listCedulaMunicipio.getItemText(listCedulaMunicipio.getSelectedIndex());
					depto_municipio_dos = listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getItemText(listDireccionMunicipio.getSelectedIndex());

					
					loginService.Actualizar_Emppleado(id_empleado,txtNo_iggs.getText(), listEstadoCivil.getItemText(listEstadoCivil.getSelectedIndex()), 
							listSexo.getItemText(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(),listIVS.getItemText(listIVS.getSelectedIndex()), 
							listPais.getItemText(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
							txtNoOrden.getText(), txtRegistro.getText(), txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
							depto_municipio_uno, txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
							txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getItemText(listTipoLicencia.getSelectedIndex()), 
							txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), URLFile, KeyFile,listEstado.getItemText(listEstado.getSelectedIndex()),
							listTienePasaporte.getItemText(listTienePasaporte.getSelectedIndex()),listLicencia.getItemText(listLicencia.getSelectedIndex()),new AsyncCallback<Long>() 
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
		
		btnImprimir = new Button("Send");
		btnImprimir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				loginService.ReporteEmpleados(new AsyncCallback<String>() 
                        {
                            public void onFailure(Throwable caught) 
                            {
                            	setMensaje("alert alert-error", 
                            			"Error !! \nal imprimir");
                            }

							@Override
                            public void onSuccess(String resutl)
                            {
			                	setMensaje("alert alert-success", 
			                			"Impresion\n exitosamente!!!");
                            }

                     });
			}
		});
		btnImprimir.setText("Imprimir");
		btnImprimir.setStylePrimaryName("sendButton");
		btnImprimir.setStyleName("sendButton");
		absolutePanel.add(btnImprimir, 591, 1313);
		btnImprimir.setSize("229px", "44px");
	}
	
	private String Depto_Municipio(String Departamento){
		String valor = "";
		if(Departamento.equals("Alta Verapaz")){
			valor = valor + "," + "Chahal";
			valor = valor + "," + "Chisec";
			valor = valor + "," + "Coban";
			valor = valor + "," + "Fray Bartolome de las Casas";
			valor = valor + "," + "La Tinta";
			valor = valor + "," + "Lanquin";
			valor = valor + "," + "Panzos";
			valor = valor + "," + "Raxruha";
			valor = valor + "," + "San Cristobal Verapaz";
			valor = valor + "," + "San Juan Chamelco";
			valor = valor + "," + "San Pedro Carcha";
			valor = valor + "," + "Santa Cruz Verapaz";
			valor = valor + "," + "Santa Maria Cahabon";
			valor = valor + "," + "Senahu";
			valor = valor + "," + "Tamahu";
			valor = valor + "," + "Tactic";
			valor = valor + "," + "Tucuru";
			
		}else if(Departamento.equals("Baja Verapaz")){
			valor = valor + "," + "Cubulco";
			valor = valor + "," + "Granados";
			valor = valor + "," + "Purulha";
			valor = valor + "," + "Rabinal";
			valor = valor + "," + "Salama";
			valor = valor + "," + "San Jeronimo";
			valor = valor + "," + "San Miguel Chicaj";
			valor = valor + "," + "Santa Cruz el Chol";
			
		}else if(Departamento.equals("Chimaltenango")){
			valor = valor + "," + "Acatenango";
			valor = valor + "," + "Chimaltenango";
			valor = valor + "," + "El Tejar";
			valor = valor + "," + "Parramos";
			valor = valor + "," + "Patzicia";
			valor = valor + "," + "Patzun";
			valor = valor + "," + "Pochuta";
			valor = valor + "," + "San Andres Itzapa";
			valor = valor + "," + "San Jose Poaquil";
			valor = valor + "," + "San Juan Comalapa";
			valor = valor + "," + "San Martin Jilotepeque";
			valor = valor + "," + "Santa Apolonia";
			valor = valor + "," + "Santa Cruz Balanya";
			valor = valor + "," + "Tecpan";
			valor = valor + "," + "Yepocapa";
			valor = valor + "," + "Zaragoza";
			
		}else if(Departamento.equals("Chiquimula")){
			
			valor = valor + "," + "Camotan";
			valor = valor + "," + "Chiquimula";
			valor = valor + "," + "Concepcion Las Minas";
			valor = valor + "," + "Esquipulas";
			valor = valor + "," + "Ipala";
			valor = valor + "," + "Jocotan";
			valor = valor + "," + "Olopa";
			valor = valor + "," + "Quezaltepeque";
			valor = valor + "," + "San Jacinto";
			valor = valor + "," + "San Jose la Arada";
			valor = valor + "," + "San Juan Ermita";
			
		}else if(Departamento.equals("El Progreso")){
			valor = valor + "," + "El Jicaro";
			valor = valor + "," + "Guastatoya";
			valor = valor + "," + "Morazan";
			valor = valor + "," + "San Agustin Acasaguastlan";
			valor = valor + "," + "San Antonio La Paz";
			valor = valor + "," + "San Cristobal Acasaguastlan";
			valor = valor + "," + "Sanarate";
			valor = valor + "," + "Sansare";
			
		}else if(Departamento.equals("Escuintla")){			
			valor = valor + "," + "Escuintla";
			valor = valor + "," + "Guanagazapa";
			valor = valor + "," + "Iztapa";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "La Gomera";
			valor = valor + "," + "Masagua";
			valor = valor + "," + "Nueva Concepcion";
			valor = valor + "," + "Palin";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "San Vicente Pacaya";
			valor = valor + "," + "Santa Lucia Cotzumalguapa";
			valor = valor + "," + "Siquinala";
			valor = valor + "," + "Tiquisate";
			
		}else if(Departamento.equals("Guatemala")){	
			valor = valor + "," + "Amatitlan";
			valor = valor + "," + "Chinautla";
			valor = valor + "," + "Chuarrancho";
			valor = valor + "," + "Ciudad de Guatemala";
			valor = valor + "," + "Fraijanes";
			valor = valor + "," + "Mixco";
			valor = valor + "," + "Palencia";
			valor = valor + "," + "San Jose del Golfo";
			valor = valor + "," + "San Jose Pinula";
			valor = valor + "," + "San Juan Sacatepequez";
			valor = valor + "," + "San Miguel Petapa";
			valor = valor + "," + "San Pedro Ayampuc";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Raymundo";
			valor = valor + "," + "Santa Catarina Pinula";
			valor = valor + "," + "Villa Canales";
			valor = valor + "," + "Villa Nueva";
			
		}else if(Departamento.equals("Huehuetenango")){
			valor = valor + "," + "Aguacatan";
			valor = valor + "," + "Chiantla";
			valor = valor + "," + "Colotenango";
			valor = valor + "," + "Concepcion Huista";
			valor = valor + "," + "Cuilco";
			valor = valor + "," + "Huehuetenango";
			valor = valor + "," + "Jacaltenango";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "Malacatancito";
			valor = valor + "," + "Nenton";
			valor = valor + "," + "San Antonio Huista";
			valor = valor + "," + "San Gaspar Ixchil";
			valor = valor + "," + "San Ildefonso Ixtahuacan";
			valor = valor + "," + "San Juan Atitan";
			valor = valor + "," + "San Juan Ixcoy";
			valor = valor + "," + "San Mateo Ixtatan";
			valor = valor + "," + "San Miguel Acatan";
			valor = valor + "," + "San Pedro Necta";
			valor = valor + "," + "San Pedro Soloma";
			valor = valor + "," + "San Rafael La Independencia";
			valor = valor + "," + "San Rafael Petzal";
			valor = valor + "," + "San Sebastian Coatan";
			valor = valor + "," + "San Sebastian Huehuetenango";
			valor = valor + "," + "Santa Ana Huista";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "Santa Cruz Barillas";
			valor = valor + "," + "Santa Eulalia";
			valor = valor + "," + "Santiago Chimaltenango";
			valor = valor + "," + "Tectitan";
			valor = valor + "," + " Santos Cuchumatan";
			valor = valor + "," + "Union Cantinil";
			
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
			valor = valor + "," + "San Manuel Chaparron";
			valor = valor + "," + "San Pedro Pinula";
			
		}else if(Departamento.equals("Jutiapa")){
			valor = valor + "," + "Agua Blanca";
			valor = valor + "," + "Asuncion Mita";
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
			valor = valor + "," + "San Jose Acatempa";
			valor = valor + "," + "Santa Catarina Mita";
			valor = valor + "," + "Yupiltepeque";
			valor = valor + "," + "Zapotitlan";
			
		}else if(Departamento.equals("Peten")){
			valor = valor + "," + "Dolores";
			valor = valor + "," + "El Chal";
			valor = valor + "," + "Flores";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "Las Cruces";
			valor = valor + "," + "Melchor de Mencos";
			valor = valor + "," + "Poptun";
			valor = valor + "," + "San Andres";
			valor = valor + "," + "San Benito";
			valor = valor + "," + "San Francisco";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "San Luis";
			valor = valor + "," + "Santa Ana";
			valor = valor + "," + "Sayaxche";
			
		}else if(Departamento.equals("Quezaltenango")){
			valor = valor + "," + "Almolonga";
			valor = valor + "," + "Cabrican";
			valor = valor + "," + "Cajola";
			valor = valor + "," + "Cantel";
			valor = valor + "," + "Coatepeque";
			valor = valor + "," + "Colomba Costa Cuca";
			valor = valor + "," + "Concepcion Chiquirichapa";
			valor = valor + "," + "El Palmar";
			valor = valor + "," + "Flores Costa Cuca";
			valor = valor + "," + "Genova";
			valor = valor + "," + "Huitan";
			valor = valor + "," + "La Esperanza";
			valor = valor + "," + "Olintepeque";
			valor = valor + "," + "Palestina de Los Altos";
			valor = valor + "," + "Quetzaltenango";
			valor = valor + "," + "Salcaja";
			valor = valor + "," + "San Carlos Sija";
			valor = valor + "," + "San Francisco La Union";
			valor = valor + "," + "San Juan Ostuncalco";
			valor = valor + "," + "San Martin Sacatepequez";
			valor = valor + "," + "San Mateo";
			valor = valor + "," + "San Miguel Sigüila";
			valor = valor + "," + "Sibilia";
			valor = valor + "," + "Zunil";
			
		}else if(Departamento.equals("Quiche")){
			valor = valor + "," + "Canilla";
			valor = valor + "," + "Chajul";
			valor = valor + "," + "Chicaman";
			valor = valor + "," + "Chiche";
			valor = valor + "," + "Chichicastenango";
			valor = valor + "," + "Chinique";
			valor = valor + "," + "Cunen";
			valor = valor + "," + "Ixcan";
			valor = valor + "," + "Joyabaj";
			valor = valor + "," + "Nebaj";
			valor = valor + "," + "Pachalum";
			valor = valor + "," + "Patzite";
			valor = valor + "," + "Sacapulas";
			valor = valor + "," + "San Andres Sajcabaja";
			valor = valor + "," + "San Antonio Ilotenango";
			valor = valor + "," + "San Bartolome Jocotenango";
			valor = valor + "," + "San Juan Cotzal";
			valor = valor + "," + "San Pedro Jocopilas";
			valor = valor + "," + "Santa Cruz del Quiche";
			valor = valor + "," + "Uspantan";
			valor = valor + "," + "Zacualpa";
			
		}else if(Departamento.equals("Retalhuleu")){
			valor = valor + "," + "Champerico";
			valor = valor + "," + "El Asintal";
			valor = valor + "," + "Nuevo San Carlos";
			valor = valor + "," + "Retalhuleu";
			valor = valor + "," + "San Andres Villa Seca";
			valor = valor + "," + "San Felipe";
			valor = valor + "," + "San Martin Zapotitlan";
			valor = valor + "," + "San Sebastian";
			valor = valor + "," + "Santa Cruz Mulua";
			
		}else if(Departamento.equals("Sacatepequez")){
			valor = valor + "," + "Alotenango";
			valor = valor + "," + "Ciudad Vieja";
			valor = valor + "," + "Jocotenango";
			valor = valor + "," + "La Antigua Guatemala";
			valor = valor + "," + "Magdalena Milpas Altas";
			valor = valor + "," + "Pastores";
			valor = valor + "," + "San Antonio Aguas Calientes";
			valor = valor + "," + "San Bartolome Milpas Altas";
			valor = valor + "," + "San Lucas Sacatepequez";
			valor = valor + "," + "San Miguel Dueñas";
			valor = valor + "," + "Santa Catarina Barahona";
			valor = valor + "," + "Santa Lucia Milpas Altas";
			valor = valor + "," + "Santa Maria de Jesus";
			valor = valor + "," + "Santiago Sacatepequez";
			valor = valor + "," + "Santo Domingo Xenacoj";
			valor = valor + "," + "Sumpango";;
			
		}else if(Departamento.equals("San Marcos")){
			valor = valor + "," + "Ayutla";
			valor = valor + "," + "Catarina";
			valor = valor + "," + "Comitancillo";
			valor = valor + "," + "Concepcion Tutuapa";
			valor = valor + "," + "El Quetzal";
			valor = valor + "," + "El Tumbador";
			valor = valor + "," + "Esquipulas Palo Gordo";
			valor = valor + "," + "Ixchiguan";
			valor = valor + "," + "La Blanca";
			valor = valor + "," + "La Reforma";
			valor = valor + "," + "Malacatan";
			valor = valor + "," + "Nuevo Progreso";
			valor = valor + "," + "Ocos";
			valor = valor + "," + "Pajapita";
			valor = valor + "," + "Rio Blanco";
			valor = valor + "," + "San Antonio Sacatepequez";
			valor = valor + "," + "San Cristobal Cucho";
			valor = valor + "," + "San Jose El Rodeo";
			valor = valor + "," + "San Jose Ojetenam";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "San Marcos";
			valor = valor + "," + "San Miguel Ixtahuacan";
			valor = valor + "," + "San Pablo";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Rafael Pie de la Cuesta";
			valor = valor + "," + "Sibinal";
			valor = valor + "," + "Sipacapa";
			valor = valor + "," + "Tacana";
			valor = valor + "," + "Tajumulco";
			valor = valor + "," + "Tejutla";
			
		}else if(Departamento.equals("Santa Rosa")){
			valor = valor + "," + "Barberena";
			valor = valor + "," + "Casillas";
			valor = valor + "," + "Chiquimulilla";
			valor = valor + "," + "Cuilapa";
			valor = valor + "," + "Guazacapan";
			valor = valor + "," + "Nueva Santa Rosa";
			valor = valor + "," + "Oratorio";
			valor = valor + "," + "Pueblo Nuevo Viñas";
			valor = valor + "," + "San Juan Tecuaco";
			valor = valor + "," + "San Rafael las Flores";
			valor = valor + "," + "Santa Cruz Naranjo";
			valor = valor + "," + "Santa Maria Ixhuatan";
			valor = valor + "," + "Santa Rosa de Lima";
			valor = valor + "," + "Taxisco";
			
		}else if(Departamento.equals("Solola")){
			valor = valor + "," + "Concepcion";
			valor = valor + "," + "Nahuala";
			valor = valor + "," + "Panajachel";
			valor = valor + "," + "San Andres Semetabaj";
			valor = valor + "," + "San Antonio Palopo";
			valor = valor + "," + "San Jose Chacaya";
			valor = valor + "," + "San Juan La Laguna";
			valor = valor + "," + "San Lucas Toliman";
			valor = valor + "," + "San Marcos La Laguna";
			valor = valor + "," + "San Pablo La Laguna";
			valor = valor + "," + "San Pedro La Laguna";
			valor = valor + "," + "Santa Catarina Ixtahuacan";
			valor = valor + "," + "Santa Catarina Palopo";
			valor = valor + "," + "Santa Clara La Laguna";
			valor = valor + "," + "Santa Cruz La Laguna";
			valor = valor + "," + "Santa Lucia Utatlan";
			valor = valor + "," + "Santa Maria Visitacion";
			valor = valor + "," + "Santiago Atitlan";
			valor = valor + "," + "Solola";
			
		}else if(Departamento.equals("Suchitepequez")){
			valor = valor + "," + "Chicacao";
			valor = valor + "," + "Cuyotenango";
			valor = valor + "," + "Mazatenango";
			valor = valor + "," + "Patulul";
			valor = valor + "," + "Pueblo Nuevo";
			valor = valor + "," + "Rio Bravo";
			valor = valor + "," + "Samayac";
			valor = valor + "," + "San Antonio Suchitepequez";
			valor = valor + "," + "San Bernardino";
			valor = valor + "," + "San Francisco Zapotitlan";
			valor = valor + "," + "San Gabriel";
			valor = valor + "," + "San Jose El Idolo";
			valor = valor + "," + "San Jose La Maquina";
			valor = valor + "," + "San Juan Bautista";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "San Miguel Panan";
			valor = valor + "," + "San Pablo Jocopilas";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "Santo Domingo Suchitepequez";
			valor = valor + "," + "Santo Tomas La Union";
			valor = valor + "," + "Zunilito";
			
		}else if(Departamento.equals("Totonicapan")){
			valor = valor + "," + "Momostenango";
			valor = valor + "," + "San Andres Xecul";
			valor = valor + "," + "San Bartolo";
			valor = valor + "," + "San Cristobal Totonicapan";
			valor = valor + "," + "San Francisco El Alto";
			valor = valor + "," + "Santa Lucia La Reforma";
			valor = valor + "," + "Santa Maria Chiquimula";
			valor = valor + "," + "Totonicapan";
			
		}else if(Departamento.equals("Zacapa")){
			valor = valor + "," + "Cabañas";
			valor = valor + "," + "Estanzuela";
			valor = valor + "," + "Gualan";
			valor = valor + "," + "Huite";
			valor = valor + "," + "La Union";
			valor = valor + "," + "Rio Hondo";
			valor = valor + "," + "San Diego";
			valor = valor + "," + "San Jorge";
			valor = valor + "," + "Teculutan";
			valor = valor + "," + "Usumatlan";
			valor = valor + "," + "Zacapa";
			
		}
		return valor;
	}
	
	public void LlenarDatos(Long id,String listEstadoCivil,String listSexo,String txtPrimerApellido,
		    String txtSegundoApellido , String txtApellidoCasada ,String txtNo_iggs, String txtPrimerNombre,
		    String txtSegundoNombre ,String listPais,String listNoDependientes , String txtTipoPasaporte ,
		    String listCedulaMunicipio,String txtDireccion , String listDireccionMunicipio, String txtCorreoElectronico,
		    String listTipoLicencia, Long dateAnnioNacimiento,String txtOcupacion , String txtCentroTrabajo,
		    String txt_CodigoOcupacion, String txtProfesion,String txtTipoPlanilla, Long dateFechaIngreso,
		    String txtRegistro , String txtNoOrden , String txtDPI,String txtTelefonoCasa, String txtTelefonoCelular ,
		    String txtNoLicencia, String txtNit, String txtNoPasaporte,String txtSalarioBase ,String txtBonificacion ,
		    String txtTotal, String listCedulaDepartamento , String listDireccionDepartamento ,String txtIVS, String  URLFile, 
		    String KeyFile,String Estado,String pasaporte, String licencia)
	{
		this.KeyFile = KeyFile;
		this.URLFile = URLFile;
		//Window.alert("llenar datos"+URLFile);
		//Window.alert("llenar datos"+this.URLFile);
		try{
			image.setUrl( URLFile);
			Archivo();
		}catch(Exception e){
			image.setUrl("images/imagenempresa.png");
		}
		this.id_empleado = id;
		this.bandera = false;
		this.txtNo_iggs.setText(txtNo_iggs);
        boolean bandera = true;
        for(int i=0; i < this.listEstadoCivil.getItemCount() && bandera; i++){
            bandera = !this.listEstadoCivil.getItemText(i).equals(listEstadoCivil);
            this.listEstadoCivil.setSelectedIndex(i);
        }   
        bandera = true;
        for(int i=0; i < this.listEstado.getItemCount() && bandera; i++){
            bandera = !this.listEstado.getItemText(i).equals(Estado);
            this.listEstado.setSelectedIndex(i);
        } 
       
        bandera = true;
        for(int i=0; i < this.listSexo.getItemCount() && bandera; i++){
            bandera = !this.listSexo.getItemText(i).equals(listSexo);
            this.listSexo.setSelectedIndex(i);
        }   
        bandera = true;
        for(int i=0; i < this.listLicencia.getItemCount() && bandera; i++){
            bandera = !this.listLicencia.getItemText(i).equals(licencia);
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
	           bandera = !this.listIVS.getItemText(i).equals(txtIVS);
	           this.listIVS.setSelectedIndex(i);
	        }  
	        
        bandera = true;
        for(int i=0; i < this.listPais.getItemCount() && bandera; i++){
           bandera = !this.listPais.getItemText(i).equals(listPais);
           this.listPais.setSelectedIndex(i);
        }   
		this.txtNit.setText(txtNit);
        bandera = true;
        for(int i=0; i < this.listNoDependientes.getItemCount() && bandera; i++){
            bandera = !this.listNoDependientes.getItemText(i).equals(listNoDependientes);
            this.listNoDependientes.setSelectedIndex(i);
        }   
		this.txtNoOrden.setText(txtNoOrden);
		this.txtRegistro.setText(txtRegistro);
		this.txtDPI.setText(txtDPI);
		this.txtTipoPasaporte.setText(txtTipoPasaporte);
		this.txtNoPasaporte.setText(txtNoPasaporte);
		this.txtDireccion.setText(txtDireccion);
		this.txtCorreoElectronico.setText(txtCorreoElectronico);
		this.txtTelefonoCasa.setText(txtTelefonoCasa);
		this.txtTelefonoCelular.setText(txtTelefonoCelular);
		//SimpleDateFormat formatter = new SimpleDateFormat("dow mon dd HH:mm:ss zzz yyyy");
		//Date date = formatter.parse(dateAnnioNacimiento);
		
		this.dateAnnioNacimiento.setValue(new Date(dateAnnioNacimiento));
        bandera = true;
        for(int i=0; i < this.listTipoLicencia.getItemCount() && bandera; i++){
            bandera = this.listTipoLicencia.getItemText(i).equals(listTipoLicencia);
            this.listTipoLicencia.setSelectedIndex(i);
        }   
		this.txtNoLicencia.setText(txtNoLicencia);
		this.txtCentroTrabajo.setText(txtCentroTrabajo);
		this.txtOcupacion.setText(txtOcupacion);
		//Date date2 = formatter.parse(dateFechaIngreso);
		this.dateFechaIngreso.setValue(new Date(dateFechaIngreso));
		this.txt_CodigoOcupacion.setText(txt_CodigoOcupacion);
		this.txtProfesion.setText(txtProfesion);
		this.txtTipoPlanilla.setText(txtTipoPlanilla);
		this.txtSalarioBase.setText(txtSalarioBase);
		this.txtTotal.setText(txtTotal);
		this.txtBonificacion.setText(txtBonificacion);

		System.out.println(listDireccionDepartamento);
        bandera = true;
        for(int i=0; i < this.listDireccionDepartamento.getItemCount() && bandera; i++){
            bandera = !this.listDireccionDepartamento.getItemText(i).equals(listDireccionDepartamento);
            this.listDireccionDepartamento.setSelectedIndex(i);
        }   
        

		System.out.println(listCedulaDepartamento);
        bandera = true;
        for(int i=0; i < this.listCedulaDepartamento.getItemCount() && bandera; i++){
            bandera = !this.listCedulaDepartamento.getItemText(i).equals(listCedulaDepartamento);
            this.listCedulaDepartamento.setSelectedIndex(i);
        }   

        this.listCedulaMunicipio.clear();
        String[] numerosComoArray = Depto_Municipio(this.listCedulaDepartamento.getItemText(this.listCedulaDepartamento.getSelectedIndex())).split(",");
        for (int i = 0; i < numerosComoArray.length; i++) {
        	this.listCedulaMunicipio.addItem(numerosComoArray[i]);
        }
        bandera = true;
        for(int i=0; i < this.listTienePasaporte.getItemCount() && bandera; i++){
            bandera = !this.listTienePasaporte.getItemText(i).equals(pasaporte);
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
        for (int i = 0; i < numerosComoArray2.length; i++) {
        	this.listDireccionMunicipio.addItem(numerosComoArray2[i]);
        }
		System.out.println(listCedulaMunicipio);
        bandera = true;
        for(int i=0; i < this.listCedulaMunicipio.getItemCount() && bandera; i++){
            bandera = !this.listCedulaMunicipio.getItemText(i).equals(listCedulaMunicipio);
            this.listCedulaMunicipio.setSelectedIndex(i);
        }   

		System.out.println(listDireccionMunicipio);
        bandera = true;
        for(int i=0; i < this.listDireccionMunicipio.getItemCount() && bandera; i++){
            bandera = !this.listDireccionMunicipio.getItemText(i).equals(listDireccionMunicipio);
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
