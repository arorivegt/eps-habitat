package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
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
    
	public formularioDatos(Empleados e) {
		this.empleado = e;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("890px", "1188px");

		absolutePanel.add(getFormPanel(), 591, 109);
		getFormUrl();
		image = new Image("images/imagenempresa.png");
		absolutePanel.add(image, 361, 10);
		image.setSize("167px", "158px");
		
		txtNo_iggs = new IntegerBox();
		txtNo_iggs.setText("0");
		txtNo_iggs.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNo_iggs, 38, 192);
		txtNo_iggs.setSize("227px", "19px");
		
		listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("Soltero/a");
		listEstadoCivil.addItem("Casado/a");
		listEstadoCivil.addItem("Divorciado/a");
		listEstadoCivil.addItem("Viudo/a");
		listEstadoCivil.addItem("Separado/a");
		listEstadoCivil.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstadoCivil, 319, 192);
		listEstadoCivil.setSize("247px", "27px");
		
		listSexo = new ListBox();
		listSexo.addItem("femenino");
		listSexo.addItem("masculino");
		listSexo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSexo, 591, 192);
		listSexo.setSize("247px", "27px");
		
		txtPrimerApellido = new TextBox();
		txtPrimerApellido.setMaxLength(50);
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerApellido, 38, 252);
		txtPrimerApellido.setSize("227px", "19px");
		
		txtSegundoApellido = new TextBox();
		txtSegundoApellido.setMaxLength(50);
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundoApellido, 319, 252);
		txtSegundoApellido.setSize("227px", "19px");
		
		txtApellidoCasada = new TextBox();
		txtApellidoCasada.setMaxLength(50);
		txtApellidoCasada.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtApellidoCasada, 591, 252);
		txtApellidoCasada.setSize("227px", "19px");
		
		txtPrimerNombre = new TextBox();
		txtPrimerNombre.setMaxLength(50);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerNombre, 38, 313);
		txtPrimerNombre.setSize("227px", "19px");
		
		txtSegundoNombre = new TextBox();
		txtSegundoNombre.setMaxLength(50);
		txtSegundoNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundoNombre, 319, 313);
		txtSegundoNombre.setSize("227px", "19px");
		
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
		listPais.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPais, 591, 313);
		listPais.setSize("247px", "27px");
		
		listIVS = new ListBox();
		listIVS.addItem("Con IVS");
		listIVS.addItem("Sin IVS");
		listIVS.setStyleName("gwt-TextBox2");
		absolutePanel.add(listIVS, 38, 381);
		listIVS.setSize("248px", "27px");
		
		txtNit = new TextBox();
		txtNit.setStyleName("gwt-TextBox2");
		txtNit.setMaxLength(50);
		absolutePanel.add(txtNit, 319, 381);
		txtNit.setSize("227px", "19px");
		
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
		listNoDependientes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNoDependientes, 592, 381);
		listNoDependientes.setSize("248px", "27px");
		
		txtNoOrden = new TextBox();
		txtNoOrden.setStyleName("gwt-TextBox2");
		txtNoOrden.setMaxLength(50);
		absolutePanel.add(txtNoOrden, 38, 444);
		txtNoOrden.setSize("227px", "19px");
		
		txtRegistro = new IntegerBox();
		txtRegistro.setText("0");
		txtRegistro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtRegistro, 318, 444);
		txtRegistro.setSize("227px", "19px");
		
		txtDPI = new IntegerBox();
		txtDPI.setText("0");
		txtDPI.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDPI, 590, 444);
		txtDPI.setSize("227px", "19px");
		
		listTienePasaporte = new ListBox();
		listTienePasaporte.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(listTienePasaporte.getItemText(listTienePasaporte.getSelectedIndex()).equals("No"))
				{
					txtTipoPasaporte.setVisible(false);
					txtNoPasaporte.setVisible(false);
				}else{
					txtTipoPasaporte.setVisible(true);
					txtNoPasaporte.setVisible(true);
				}
			}
		});
		listTienePasaporte.addItem("Si");
		listTienePasaporte.addItem("No");
		listTienePasaporte.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTienePasaporte, 37, 507);
		listTienePasaporte.setSize("248px", "27px");
		
		txtTipoPasaporte = new TextBox();
		txtTipoPasaporte.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTipoPasaporte, 316, 507);
		txtTipoPasaporte.setSize("227px", "19px");
		
		txtNoPasaporte = new IntegerBox();
		txtNoPasaporte.setText("0");
		txtNoPasaporte.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNoPasaporte, 591, 507);
		txtNoPasaporte.setSize("227px", "19px");
		
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
		listCedulaDepartamento.setStyleName("gwt-TextBox2");
		absolutePanel.add(listCedulaDepartamento, 37, 585);
		listCedulaDepartamento.setSize("248px", "27px");
		
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
		listCedulaMunicipio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listCedulaMunicipio, 318, 585);
		listCedulaMunicipio.setSize("248px", "27px");
		
		dateAnnioNacimiento = new DateBox();
		dateAnnioNacimiento.setValue(new Date(1407518707105L));
		dateAnnioNacimiento.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateAnnioNacimiento.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateAnnioNacimiento, 590, 578);
		dateAnnioNacimiento.setSize("228px", "18px");
		
		txtDireccion = new TextBox();
		txtDireccion.setMaxLength(200);
		txtDireccion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDireccion, 39, 650);
		txtDireccion.setSize("227px", "19px");
		
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
		listDireccionDepartamento.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDireccionDepartamento, 318, 652);
		listDireccionDepartamento.setSize("248px", "27px");
		
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
		listDireccionMunicipio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDireccionMunicipio, 590, 650);
		listDireccionMunicipio.setSize("248px", "27px");
		
		txtCorreoElectronico = new TextBox();
		txtCorreoElectronico.setMaxLength(200);
		txtCorreoElectronico.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtCorreoElectronico, 39, 722);
		txtCorreoElectronico.setSize("227px", "19px");
		
		
		txtTelefonoCasa = new IntegerBox();
		txtTelefonoCasa.setText("0");
		txtTelefonoCasa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCasa, 319, 722);
		txtTelefonoCasa.setSize("227px", "19px");
		
		txtTelefonoCelular = new IntegerBox();
		txtTelefonoCelular.setText("0");
		txtTelefonoCelular.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCelular, 591, 722);
		txtTelefonoCelular.setSize("227px", "19px");
		
		listLicencia = new ListBox();
		listLicencia.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(listLicencia.getItemText(listLicencia.getSelectedIndex()).equals("No"))
				{
					listTipoLicencia.setVisible(false);
					txtNoLicencia.setVisible(false);
				}else{
					listTipoLicencia.setVisible(true);
					txtNoLicencia.setVisible(true);
				}
				
			}
		});
		listLicencia.addItem("Si");
		listLicencia.addItem("No");
		listLicencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(listLicencia, 37, 799);
		listLicencia.setSize("248px", "27px");
		
		listTipoLicencia = new ListBox();
		listTipoLicencia.addItem("A");
		listTipoLicencia.addItem("B");
		listTipoLicencia.addItem("C");
		listTipoLicencia.addItem("M");
		listTipoLicencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoLicencia, 318, 799);
		listTipoLicencia.setSize("248px", "27px");
		
		txtNoLicencia = new IntegerBox();
		txtNoLicencia.setText("0");
		txtNoLicencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNoLicencia, 591, 799);
		txtNoLicencia.setSize("227px", "19px");
		
		txtCentroTrabajo = new TextBox();
		txtCentroTrabajo.setMaxLength(50);
		txtCentroTrabajo.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtCentroTrabajo, 39, 904);
		txtCentroTrabajo.setSize("227px", "19px");
		
		txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(50);
		txtOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOcupacion, 316, 904);
		txtOcupacion.setSize("227px", "19px");
		
		dateFechaIngreso = new DateBox();
		dateFechaIngreso.setValue(new Date(1407518751219L));
		dateFechaIngreso.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFechaIngreso.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFechaIngreso, 590, 903);
		dateFechaIngreso.setSize("228px", "18px");
		
		txt_CodigoOcupacion = new TextBox();
		txt_CodigoOcupacion.setMaxLength(50);
		txt_CodigoOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt_CodigoOcupacion, 39, 966);
		txt_CodigoOcupacion.setSize("227px", "19px");
		
		txtProfesion = new TextBox();
		txtProfesion.setMaxLength(50);
		txtProfesion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtProfesion, 316, 966);
		txtProfesion.setSize("227px", "19px");
		
		txtTipoPlanilla = new TextBox();
		txtTipoPlanilla.setMaxLength(50);
		txtTipoPlanilla.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTipoPlanilla, 591, 966);
		txtTipoPlanilla.setSize("227px", "19px");
		
		txtSalarioBase = new TextBox();
		txtSalarioBase.setText("0.0");
		txtSalarioBase.setStyleName("gwt-TextBox2");
		txtSalarioBase.setMaxLength(50);
		absolutePanel.add(txtSalarioBase, 37, 1042);
		txtSalarioBase.setSize("227px", "19px");
		
		txtBonificacion = new TextBox();
		txtBonificacion.setText("0.0");
		txtBonificacion.setStyleName("gwt-TextBox2");
		txtBonificacion.setMaxLength(50);
		absolutePanel.add(txtBonificacion, 318, 1043);
		txtBonificacion.setSize("227px", "19px");
		
		txtTotal = new TextBox();
		txtTotal.setText("0.0");
		txtTotal.setStyleName("gwt-TextBox2");
		txtTotal.setMaxLength(50);
		absolutePanel.add(txtTotal, 591, 1043);
		txtTotal.setSize("227px", "19px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox");
		btnActualizar.setStyleName("gwt-TextBox");
		absolutePanel.add(btnActualizar, 300, 1143);
		btnActualizar.setSize("280px", "44px");
		
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
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()),URLFile, KeyFile,listEstado.getItemText(listEstado.getSelectedIndex()), new AsyncCallback<Long>() 
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
	                            	empleado.NuevasPestanas();
	                            	empleado.familia_unica();
	                                Window.alert("Nuevo Empleado Guardados exitosamente!!! "+id_empleado);
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
							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), URLFile, KeyFile,listEstado.getItemText(listEstado.getSelectedIndex()),new AsyncCallback<Long>() 
	                        {
	                            public void onFailure(Throwable caught) 
	                            {
	                                Window.alert("Error al Actualizar Datos");
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {
	                            	bandera = false;
	                                Window.alert("Datos Actualizados exitosamente!!! "+id_empleado);
	                            }

	                     });
					
				}
				
			}
		});
		Label lblNoDeAfiliacin = new Label("No. De Afiliacion al IGSS");
		lblNoDeAfiliacin.setStyleName("label");
		absolutePanel.add(lblNoDeAfiliacin, 37, 174);
		
		Label label_1 = new Label("Estado Civil");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 318, 174);
		label_1.setSize("192px", "19px");
		
		Label label_2 = new Label("Sexo");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 590, 174);
		label_2.setSize("192px", "19px");
		
		Label label_3 = new Label("Primer Apellido");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 37, 234);
		label_3.setSize("192px", "19px");
		
		Label label_4 = new Label("Segundo Apellido");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 317, 234);
		label_4.setSize("192px", "19px");
		
		Label label_5 = new Label("Apellido Casada");
		label_5.setStyleName("label");
		absolutePanel.add(label_5, 592, 234);
		label_5.setSize("192px", "19px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 37, 295);
		label_6.setSize("192px", "19px");
		
		Label label_7 = new Label("2do y Demas Nombres");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 318, 295);
		label_7.setSize("192px", "19px");
		
		Label label_8 = new Label("Pais");
		label_8.setStyleName("label");
		absolutePanel.add(label_8, 590, 295);
		label_8.setSize("192px", "19px");
		
		Label label_9 = new Label("Tipo Empleado");
		label_9.setStyleName("label");
		absolutePanel.add(label_9, 37, 346);
		label_9.setSize("192px", "19px");
		
		Label label_10 = new Label("Nit");
		label_10.setStyleName("label");
		absolutePanel.add(label_10, 318, 363);
		label_10.setSize("192px", "19px");
		
		Label label_11 = new Label("No. Dependientes");
		label_11.setStyleName("label");
		absolutePanel.add(label_11, 591, 363);
		label_11.setSize("192px", "19px");
		
		Label label_12 = new Label("Cedula No. Orden");
		label_12.setStyleName("label");
		absolutePanel.add(label_12, 37, 426);
		label_12.setSize("192px", "19px");
		
		Label label_13 = new Label("Cedula No. Registro");
		label_13.setStyleName("label");
		absolutePanel.add(label_13, 318, 426);
		label_13.setSize("192px", "19px");
		
		Label label_14 = new Label("Doc. de Identificacion Personal- CUI");
		label_14.setStyleName("label");
		absolutePanel.add(label_14, 591, 426);
		label_14.setSize("247px", "19px");
		
		Label label_15 = new Label("Pasaporte");
		label_15.setStyleName("label");
		absolutePanel.add(label_15, 34, 489);
		label_15.setSize("178px", "19px");
		
		Label label_16 = new Label("Tipo Pasaporte");
		label_16.setStyleName("label");
		absolutePanel.add(label_16, 314, 489);
		label_16.setSize("192px", "19px");
		
		Label label_17 = new Label("No. Pasaporte");
		label_17.setStyleName("label");
		absolutePanel.add(label_17, 587, 489);
		label_17.setSize("192px", "19px");
		
		Label lblCedulaExtendidamunicipio = new Label("Cedula extendida-Municipio");
		lblCedulaExtendidamunicipio.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidamunicipio, 318, 560);
		lblCedulaExtendidamunicipio.setSize("192px", "19px");
		
		Label label_20 = new Label("DIreccion Actual");
		label_20.setStyleName("label");
		absolutePanel.add(label_20, 37, 627);
		label_20.setSize("192px", "19px");
		
		Label label_21 = new Label("Municipio residencia");
		label_21.setStyleName("label");
		absolutePanel.add(label_21, 590, 627);
		label_21.setSize("192px", "19px");
		
		Label label_22 = new Label("Correo Electronico");
		label_22.setStyleName("label");
		absolutePanel.add(label_22, 37, 702);
		label_22.setSize("192px", "19px");
		
		Label label_23 = new Label("Telefono de casa");
		label_23.setStyleName("label");
		absolutePanel.add(label_23, 318, 702);
		label_23.setSize("192px", "19px");
		
		Label label_24 = new Label("Telefono Celular");
		label_24.setStyleName("label");
		absolutePanel.add(label_24, 590, 702);
		label_24.setSize("192px", "19px");
		
		Label label_25 = new Label("Licencia");
		label_25.setStyleName("label");
		absolutePanel.add(label_25, 37, 774);
		label_25.setSize("178px", "19px");
		
		Label label_26 = new Label("No. Licencia");
		label_26.setStyleName("label");
		absolutePanel.add(label_26, 590, 774);
		label_26.setSize("192px", "19px");
		
		Label label_27 = new Label("Tipo Licencia");
		label_27.setStyleName("label");
		absolutePanel.add(label_27, 318, 774);
		label_27.setSize("192px", "19px");
		
		Label label_28 = new Label("Año de Nacimiento");
		label_28.setStyleName("label");
		absolutePanel.add(label_28, 590, 553);
		label_28.setSize("192px", "19px");
		
		Label lblFechaIngreso = new Label("Fecha Ingreso");
		lblFechaIngreso.setStyleName("label");
		absolutePanel.add(lblFechaIngreso, 590, 884);
		lblFechaIngreso.setSize("192px", "19px");
		
		Label lblOcupacion = new Label("Ocupacion");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 318, 884);
		lblOcupacion.setSize("192px", "19px");
		
		Label lblCentroTrabajo = new Label("Centro Trabajo");
		lblCentroTrabajo.setStyleName("label");
		absolutePanel.add(lblCentroTrabajo, 37, 884);
		lblCentroTrabajo.setSize("192px", "19px");
		
		Label lblD = new Label("Datos del Patrono: (Uso exclusivo de la Fundacion");
		lblD.setStyleName("label");
		absolutePanel.add(lblD, 37, 845);
		lblD.setSize("449px", "19px");
		
		Label lblCodigoOcupacion = new Label("Codigo Ocupacion");
		lblCodigoOcupacion.setStyleName("label");
		absolutePanel.add(lblCodigoOcupacion, 37, 946);
		lblCodigoOcupacion.setSize("192px", "19px");
		
		Label lblProfesion = new Label("profesion");
		lblProfesion.setStyleName("label");
		absolutePanel.add(lblProfesion, 318, 946);
		lblProfesion.setSize("192px", "19px");
		
		Label lblTipoPlanilla = new Label("Tipo Planilla");
		lblTipoPlanilla.setStyleName("label");
		absolutePanel.add(lblTipoPlanilla, 590, 946);
		lblTipoPlanilla.setSize("192px", "19px");
		
		Label lblBonificacion = new Label("Bonificacion");
		lblBonificacion.setStyleName("label");
		absolutePanel.add(lblBonificacion, 318, 1018);
		lblBonificacion.setSize("192px", "19px");
		
		Label lblTotal = new Label("Total");
		lblTotal.setStyleName("label");
		absolutePanel.add(lblTotal, 590, 1018);
		lblTotal.setSize("192px", "19px");
		
		Label lblSalarioBase = new Label("Salario Base");
		lblSalarioBase.setStyleName("label");
		absolutePanel.add(lblSalarioBase, 37, 1013);
		lblSalarioBase.setSize("192px", "19px");
		
		Label lblCedulaExtendidadepartamento = new Label("Cedula extendida-Departamento");
		lblCedulaExtendidadepartamento.setStyleName("label");
		absolutePanel.add(lblCedulaExtendidadepartamento, 37, 560);
		lblCedulaExtendidadepartamento.setSize("192px", "19px");
		
		Label label = new Label("Cedula extendida-Departamento");
		label.setStyleName("label");
		absolutePanel.add(label, 318, 627);
		label.setSize("192px", "19px");
		
		Label lblConIvs = new Label("IVS");
		lblConIvs.setStyleName("label");
		absolutePanel.add(lblConIvs, 37, 363);
		lblConIvs.setSize("97px", "19px");
		
		listEstado = new ListBox();
		listEstado.addItem("activo");
		listEstado.addItem("inactivo");
		listEstado.addItem("posible empleado");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 38, 119);
		listEstado.setSize("247px", "27px");
		
		Label lblEstadoDelEmpleado = new Label("Estado Del Empleado");
		lblEstadoDelEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoDelEmpleado, 37, 101);
		lblEstadoDelEmpleado.setSize("192px", "19px");
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
		    String KeyFile,String Estado)
	{
		this.KeyFile = KeyFile;
		image.setUrl( URLFile);
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
	          Window.alert("Did you select a file?");
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
						Window.alert(URLFile);
						Window.alert(KeyFile);
						//pResponse.add(new HTML(results));
						getFormUrl();
						form.setVisible(false);
						Archivo();
					}catch(Exception e){
						Archivo();
						Window.alert(results);
						
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
		}
		return fileUpload;
	}
	
	private Button getButton() {
		if (button == null) {
			button = new Button("Upload");
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
				Window.alert("Something went wrong with the rpc call.");
			}
		});
		
	}
	public void Archivo(){

		grid = new Grid(1, 2);
		absolutePanel.add(grid, 557, 109);
		grid.setSize("357px", "59px");
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				loginService.remove(getKeyFile() , new AsyncCallback<String>(){
					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Archivo No Eliminado");
					}
					@Override
					public void onSuccess(String result) {
						form.setVisible(true);
						grid.setVisible(false);
						Window.alert("Archivo Eliminado");
					}

                });
			}
		});

		image.setUrl(URLFile);
		grid.setWidget(0, 1, btnEliminar);
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
}
