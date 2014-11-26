/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class formularioDatos extends Composite {

	private Mensaje mensaje; 
	private Empleados empleado;
	private Long id_empleado = 0L;
	private Long id_afiliado = 0L;
	private Long idJefe = 0L;
	private boolean bandera = true;
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final SqlServiceAsync finanzasService = GWT.create(SqlService.class);
    
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
    private FormPanel formPanel;

	private String URLFile ="";
	private String KeyFile ="";

	private FormPanel form;
	private VerticalPanel formElements;
	private FileUpload fileUpload;
	private Button button;
	private Grid grid;
	private Image image ;
	private final UploadUrlServiceAsync uploadUrlService = GWT.create(UploadUrlService.class);
    private AbsolutePanel absolutePanel;
    private Button btnImprimir;
    private Button btnExportarDatos;
    private Label lblEtnia;
    private ListBox listEtnia;
    private TextBox txtNombreEmergencia;
    private Label lblNombreYApellido;
    private TextBox txtTelefonoEmergencia;
    private Label lblNoTelefono;
    private TextBox txtNombreEmergencia2;
    private Label label_14;
    private TextBox txtTelefonoEmergencia2;
    private Label lblTelefono;
    private Label lblTelefonoSeEmergencia;
    private ListBox listNacimientoDepartamento;
    private Label lblDepartamentoNacimiento;
    private ListBox listNacimientoMunicipio;
    private Label lblMunicipioNacimiento;
    private IntegerBox txtJefeInmediato;
    private Label lblJefeInmediato;
    private Button btnOK;
    private Loading load ;
    private VerticalPanel verticalPanel;
    private ListBox listAfiliado;
    private Label lblAfiliado;
    private int tip = 0;
    /**
     * 
     * @param empleadoo
     * @param tipo
     */
	public formularioDatos(Empleados empleadoo,final int tipo) {

		tip = tipo;
		mensaje = new Mensaje();
		this.empleado = empleadoo;
		this.setTipo(tipo);
    	load = new Loading();
        load.Mostrar();
        load.invisible();
  		
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		absolutePanel.setSize("997px", "1557px");
		initWidget(absolutePanel);
		
		getFormUrl();
		
		
		image = new Image("images/imagenempresa.png");
		image.setSize("167px", "158px");
		absolutePanel.add(image, 341, 10);
		absolutePanel.add(getFormPanel(), 596, 43);
		
		listEstado = new ListBox();
		listEstado.addItem("empleado activo","0");
		listEstado.addItem("empleado inactivo","1");
		listEstado.addItem("posible empleado","2");
		listEstado.addItem("practicante","3");
		listEstado.addItem("interino","4");
		listEstado.setStyleName("gwt-PasswordTextBox");
		listEstado.setSize("230px", "36px");
		absolutePanel.add(listEstado, 36, 94);
		
		
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
		listPais.addItem("3TURKMENISTAN","184");
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
		absolutePanel.add(noCuenta, 36, 545);

		nombreBanco = new ListBox();
		nombreBanco.addItem("G&T Continental","0");
		nombreBanco.addItem("Banrural","1");
		nombreBanco.setSize("230px", "36px");
		nombreBanco.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(nombreBanco, 319, 545);
		
		tipoCuenta = new ListBox();
		tipoCuenta.addItem("Ahorro","0");
		tipoCuenta.addItem("Monetaria","1");
		tipoCuenta.setSize("227px", "36px");
		tipoCuenta.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(tipoCuenta, 591, 545);
		
		
		txtDPI = new IntegerBox();
		txtDPI.setText("0");
		txtDPI.setSize("227px", "34px");
		txtDPI.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtDPI, 317, 687);
		
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
						mensaje.setMensaje("alert alert-error", 
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
		dateAnnioNacimiento.getTextBox().setReadOnly(true);
		dateAnnioNacimiento.setValue(new Date(1407518707105L));
		dateAnnioNacimiento.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateAnnioNacimiento.getDatePicker().setYearArrowsVisible(true);
		dateAnnioNacimiento.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateAnnioNacimiento.getDatePicker().setVisibleYearCount(100);
		dateAnnioNacimiento.setStyleName("gwt-PasswordTextBox");
		dateAnnioNacimiento.setSize("228px", "41px");
		
				dateAnnioNacimiento.addValueChangeHandler(new ValueChangeHandler<Date>() {
					@Override
					public void onValueChange(ValueChangeEvent<Date> event) {
						try{
							new Date(dateAnnioNacimiento.getValue().getTime());
						}catch(Exception e){
							mensaje.setMensaje("alert alert-error", 
		                			"Error !! \nFecha Nacimiento no valida");
		                	dateAnnioNacimiento.setValue(new Date(1407518124684L));
						}
					}
				});
		absolutePanel.add(dateAnnioNacimiento, 36, 680);
		
		listEtnia = new ListBox();
		listEtnia.addItem("Xinca","1");
		listEtnia.addItem("Maya","2");
		listEtnia.addItem("Garifuna","3");
		listEtnia.addItem("Mestiza","4");
		listEtnia.addItem("Extranjeros","5");
		listEtnia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listEtnia, 591, 687);
		listEtnia.setSize("227px", "36px");
		
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
		        int correlativo = Integer.parseInt(listDireccionDepartamento.getValue(listDireccionDepartamento.getSelectedIndex())+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	listDireccionMunicipio.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }

		        listDireccionMunicipio.setSelectedIndex(2);
			}
		});

		listDireccionDepartamento.addItem("Guatemala","01");
		listDireccionDepartamento.addItem("Baja Verapaz","15");
		listDireccionDepartamento.addItem("Alta Verapaz","16");
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
					mensaje.setMensaje("alert alert-error", 
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
                	mensaje.setMensaje("alert alert-error", 
                			"Error !! \nEmail no valido");
                	txtCorreoElectronico.setText("ejemplo@habitat.com");
                }

			}
		});
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
						mensaje.setMensaje("alert alert-error", 
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
						mensaje.setMensaje("alert alert-error", 
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
						mensaje.setMensaje("alert alert-error", 
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
		
		listNacimientoDepartamento = new ListBox();
		listNacimientoDepartamento.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listNacimientoMunicipio.clear();
		        String[] numerosComoArray = Depto_Municipio(listNacimientoDepartamento.getItemText(listNacimientoDepartamento.getSelectedIndex())).split(",");
		        int correlativo = Integer.parseInt(listNacimientoDepartamento.getValue(listNacimientoDepartamento.getSelectedIndex())+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	listNacimientoMunicipio.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }

		        listNacimientoMunicipio.setSelectedIndex(2);
				
			}
		});
		listNacimientoDepartamento.setStyleName("gwt-PasswordTextBox");
		listNacimientoDepartamento.addItem("Guatemala","01");
		listNacimientoDepartamento.addItem("Baja Verapaz","15");
		listNacimientoDepartamento.addItem("Alta Verapaz","16");
		listNacimientoDepartamento.addItem("El Progreso","02");
		listNacimientoDepartamento.addItem("Izabal","18");
		listNacimientoDepartamento.addItem("Zacapa","19");
		listNacimientoDepartamento.addItem("Chiquimula","20");
		listNacimientoDepartamento.addItem("Santa Rosa","06");
		listNacimientoDepartamento.addItem("Jalapa","21");
		listNacimientoDepartamento.addItem("Jutiapa","22");
		listNacimientoDepartamento.addItem("Sacatepequez","03");
		listNacimientoDepartamento.addItem("Chimaltenango","04");
		listNacimientoDepartamento.addItem("Escuintla","05");
		listNacimientoDepartamento.addItem("Solola","07");
		listNacimientoDepartamento.addItem("Totonicapan","08");
		listNacimientoDepartamento.addItem("Quezaltenango","09");
		listNacimientoDepartamento.addItem("Suchitepequez","10");
		listNacimientoDepartamento.addItem("Retalhuleu","11");
		listNacimientoDepartamento.addItem("San Marcos","12");
		listNacimientoDepartamento.addItem("Huehuetenango","13");
		listNacimientoDepartamento.addItem("Quiche","14");
		listNacimientoDepartamento.addItem("Peten","17");
		absolutePanel.add(listNacimientoDepartamento, 36, 1014);
		listNacimientoDepartamento.setSize("230px", "36px");
		
		listNacimientoMunicipio = new ListBox();
		listNacimientoMunicipio.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listNacimientoMunicipio, 308, 1012);
		listNacimientoMunicipio.setSize("230px", "36px");
		
		txtNombreEmergencia = new TextBox();
		txtNombreEmergencia.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtNombreEmergencia, 38, 1117);
		txtNombreEmergencia.setSize("187px", "34px");
		
		txtTelefonoEmergencia = new TextBox();
		txtTelefonoEmergencia.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoEmergencia.getText().equals("")) {txtTelefonoEmergencia.setText("0");}
				else if(txtTelefonoEmergencia.getText().equals(null)) {txtTelefonoEmergencia.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoEmergencia.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nTelefono Emergencia no valido");
						txtTelefonoEmergencia.setText("0");
					}
				}
			}
		});
		txtTelefonoEmergencia.setStyleName("gwt-PasswordTextBox");
		txtTelefonoEmergencia.setMaxLength(20);
		absolutePanel.add(txtTelefonoEmergencia, 267, 1117);
		txtTelefonoEmergencia.setSize("146px", "34px");
		
		txtNombreEmergencia2 = new TextBox();
		txtNombreEmergencia2.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtNombreEmergencia2, 463, 1117);
		txtNombreEmergencia2.setSize("169px", "34px");
		
		txtTelefonoEmergencia2 = new TextBox();
		txtTelefonoEmergencia2.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoEmergencia2.getText().equals("")) {txtTelefonoEmergencia2.setText("0");}
				else if(txtTelefonoEmergencia2.getText().equals(null)) {txtTelefonoEmergencia2.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoEmergencia2.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nTelefono Emergencia no valido");
						txtTelefonoEmergencia2.setText("0");
					}
				}
			}
		});
		txtTelefonoEmergencia2.setStyleName("gwt-PasswordTextBox");
		txtTelefonoEmergencia2.setMaxLength(20);
		absolutePanel.add(txtTelefonoEmergencia2, 672, 1117);
		txtTelefonoEmergencia2.setSize("144px", "34px");
		
		txtCentroTrabajo = new TextBox();
		txtCentroTrabajo.setMaxLength(50);
		txtCentroTrabajo.setSize("227px", "34px");
		txtCentroTrabajo.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtCentroTrabajo, 34, 1223);
		
		txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(50);
		txtOcupacion.setSize("227px", "34px");
		txtOcupacion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtOcupacion, 311, 1223);
		
		dateFechaIngreso = new DateBox();
		dateFechaIngreso.getTextBox().setReadOnly(true);
		dateFechaIngreso.setValue(new Date(1407518751219L));
		dateFechaIngreso.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFechaIngreso.getDatePicker().setYearArrowsVisible(true);
		dateFechaIngreso.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFechaIngreso.getDatePicker().setVisibleYearCount(100);
		dateFechaIngreso.setSize("228px", "35px");
		dateFechaIngreso.setStyleName("gwt-PasswordTextBox");
		dateFechaIngreso.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				//Window.alert("fecha");
				try{
					new Date(dateFechaIngreso.getValue().getTime());
				}catch(Exception e){
					mensaje.setMensaje("alert alert-error", 
                			"Error !! \nFecha de Ingreso no valida");
					dateFechaIngreso.setValue(new Date(1407518124684L));
				}
			}
		});
		absolutePanel.add(dateFechaIngreso, 585, 1222);
		
		txt_CodigoOcupacion = new TextBox();
		txt_CodigoOcupacion.setMaxLength(50);
		txt_CodigoOcupacion.setSize("227px", "34px");
		txt_CodigoOcupacion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txt_CodigoOcupacion, 34, 1286);
		
		txtProfesion = new TextBox();
		txtProfesion.setMaxLength(50);
		txtProfesion.setSize("227px", "34px");
		txtProfesion.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtProfesion, 311, 1286);
		
		txtTipoPlanilla = new TextBox();
		txtTipoPlanilla.setMaxLength(50);
		txtTipoPlanilla.setSize("227px", "34px");
		txtTipoPlanilla.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtTipoPlanilla, 586, 1286);
		//boorar este dato
		txtSalarioBase = new TextBox();
		txtSalarioBase.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalarioBase.getText().equals("")) {txtSalarioBase.setText("0");}
				else if(txtSalarioBase.getText().equals(null)) {txtSalarioBase.setText("0");}
				else{
					try{
						Float.parseFloat(txtSalarioBase.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
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
		absolutePanel.add(txtSalarioBase, 35, 1353);
		//borrar esta parte
		txtBonificacion = new TextBox();
		txtBonificacion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtBonificacion.getText().equals("")) {txtBonificacion.setText("0");}
				else if(txtBonificacion.getText().equals(null)) {txtBonificacion.setText("0");}
				else{
					try{
						Float.parseFloat(txtBonificacion.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
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
		absolutePanel.add(txtBonificacion, 311, 1353);
		//borrar esta parte
		txtTotal = new TextBox();
		txtTotal.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTotal.getText().equals("")) {txtTotal.setText("0");}
				else if(txtTotal.getText().equals(null)) {txtTotal.setText("0");}
				else{
					try{
						Float.parseFloat(txtTotal.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
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
		absolutePanel.add(txtTotal, 585, 1353);
		
		txtJefeInmediato = new IntegerBox();
		txtJefeInmediato.setEnabled(false);
		txtJefeInmediato.setReadOnly(true);
		txtJefeInmediato.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(txtJefeInmediato, 37, 1420);
		txtJefeInmediato.setSize("187px", "34px");
		
		btnOK = new Button("Send");
		btnOK.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				MensajeBusquedaEmpleado();
			}
		});
		btnOK.setText("OK");
		btnOK.setStylePrimaryName("sendButton");
		btnOK.setStyleName("sendButton");
		absolutePanel.add(btnOK, 219, 1420);
		btnOK.setSize("50px", "36px");
		
		btnActualizar = new Button("Send");
		btnActualizar.setText("Guardar");
		btnActualizar.setStyleName("sendButton");
		btnActualizar.setSize("229px", "44px");
		btnActualizar.setStylePrimaryName("sendButton");
		absolutePanel.add(btnActualizar, 36, 1500);
		
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
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
				if(!txtPrimerApellido.getText().equals("") && !txtPrimerNombre.getText().equals("")   ){

                
					depto_municipio_dos = listDireccionDepartamento.getValue(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getValue(listDireccionMunicipio.getSelectedIndex());
					depto_municipio_uno = listNacimientoDepartamento.getValue(listNacimientoDepartamento.getSelectedIndex()) + "," +listNacimientoMunicipio.getValue(listNacimientoMunicipio.getSelectedIndex());
					if(bandera){
						recursosHumanosService.Insertar_Emppleado(txtNo_iggs.getText(), listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex()), 
								listSexo.getValue(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
								txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), listIVS.getValue(listIVS.getSelectedIndex()), 
								listPais.getValue(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
								noCuenta.getText(),tipoCuenta.getValue(tipoCuenta.getSelectedIndex()) , nombreBanco.getValue(nombreBanco.getSelectedIndex()) , txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
								txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
								txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getValue(listTipoLicencia.getSelectedIndex()), 
								txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
								txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
								Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()),URLFile, KeyFile,listEstado.getValue(listEstado.getSelectedIndex()),
								listTienePasaporte.getValue(listTienePasaporte.getSelectedIndex()),listLicencia.getValue(listLicencia.getSelectedIndex()),
								listEtnia.getValue(listEtnia.getSelectedIndex()), txtNombreEmergencia.getText(), txtTelefonoEmergencia.getText(),
								txtNombreEmergencia2.getText(), txtTelefonoEmergencia2.getText(),depto_municipio_uno, idJefe,
								Long.parseLong(listAfiliado.getValue(listAfiliado.getSelectedIndex())),new AsyncCallback<Long>() 
		                        {
		                            public void onFailure(Throwable caught) 
		                            {
		                		        load.invisible();
		                            	mensaje.setMensaje("alert alert-error", 
		                            			"Error !! \nal Guardar Datos");
		                            }
	
									@Override
		                            public void onSuccess(Long result)
		                            {
	
								        load.invisible();
		                            	id_empleado = result;
		                            	empleado.id_empleado = result;
		                            	bandera = false;
		                            	if(tipo == 0)
		                            		empleado.NuevasPestanas();
		                            	else
		                            		empleado.NuevasPestanasdos();
		                            	empleado.familia_unica();
		                            	mensaje.setMensaje("alert alert-success", 
			                        			"Datos Guardados\n exitosamente!!!");
		                            }
	
		                     });
					}else{
						
						if(id_afiliado==0L)
						{
							id_afiliado = Long.parseLong(listAfiliado.getValue(listAfiliado.getSelectedIndex()));							
						}
						if(!listAfiliado.getValue(listAfiliado.getSelectedIndex()).equals("0")){
							finanzasService.Actualizar_AfiliadoEmpleado(Long.parseLong(listAfiliado.getValue(listAfiliado.getSelectedIndex())),
									id_empleado,new AsyncCallback<Long>(){
							    public void onFailure(Throwable caught) 
							    {
							    	
							    }
							
								@Override
							    public void onSuccess(Long result)
							    {
									
							    }
							});
						}
						recursosHumanosService.Actualizar_Emppleado(id_empleado,txtNo_iggs.getText(), listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex()), 
								listSexo.getValue(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
								txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(),listIVS.getValue(listIVS.getSelectedIndex()), 
								listPais.getValue(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
								noCuenta.getText(),tipoCuenta.getValue(tipoCuenta.getSelectedIndex()) , nombreBanco.getValue(nombreBanco.getSelectedIndex()),txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
								txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
								txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getValue(listTipoLicencia.getSelectedIndex()), 
								txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
								txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
								Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), URLFile, KeyFile,listEstado.getValue(listEstado.getSelectedIndex()),
								listTienePasaporte.getValue(listTienePasaporte.getSelectedIndex()),listLicencia.getValue(listLicencia.getSelectedIndex()),
								listEtnia.getValue(listEtnia.getSelectedIndex()), txtNombreEmergencia.getText(), txtTelefonoEmergencia.getText(),
								txtNombreEmergencia2.getText(), txtTelefonoEmergencia2.getText(),depto_municipio_uno, idJefe,
								id_afiliado,new AsyncCallback<Long>() 
		                        {
		                            public void onFailure(Throwable caught) 
		                            {
		                		        load.invisible();
		                            	mensaje.setMensaje("alert alert-error", 
		                            			"Error !! \nal Actualizar Datos");
		                            }
	
									@Override
		                            public void onSuccess(Long result)
		                            {
								        load.invisible();
		                            	bandera = false;
		                            	mensaje.setMensaje("alert alert-success", 
					                			"Datos Actualizados\n exitosamente!!!");
		                            }
	
		                     });
					}
					
				}else{
    		        load.invisible();
                	mensaje.setMensaje("alert alert-error", 
                			"Error !! \nPrimer Nombre y/o Apellido no pueden ir vacios");
				}

		        load.invisible();
			}
		});
		
		btnImprimir = new Button("Send");
		btnImprimir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//formPanel.setAction("/ImprimirPerfil?abracadabra="+id_empleado);
				//formPanel.submit();
				Window.open("/ImprimirPerfil?abracadabra="+id_empleado, "_blank", "");
				//Window.open("/ExportAs?id="+id_empleado,"_blank", "");
				
			}
		});
		btnImprimir.setText("Imprimir");
		btnImprimir.setStylePrimaryName("sendButton");
		btnImprimir.setStyleName("sendButton");
		
		btnExportarDatos = new Button("Send");
		btnExportarDatos.setVisible(false);
		btnExportarDatos.setText("Exportar Datos");
		btnExportarDatos.setStylePrimaryName("sendButton");
		btnExportarDatos.setStyleName("sendButton");
		absolutePanel.add(btnExportarDatos, 591, 1500);
		btnExportarDatos.setSize("229px", "44px");
		
		formPanel = new FormPanel();
		formPanel.setAction("/ImprimirPerfil?abracadabra="+id_empleado);
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_GET);
		verticalPanel = new VerticalPanel();
		formPanel.setWidget(verticalPanel);
		verticalPanel.setSize("208px", "43px");
        verticalPanel.add(btnImprimir);
        btnImprimir.setSize("198px", "41px");
        
        absolutePanel.add(formPanel, 329, 1500);
        formPanel.setSize("209px", "44px");
		
		listAfiliado = new ListBox();
		listAfiliado.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(listAfiliado, 308, 1420);
		listAfiliado.setSize("230px", "36px");
        
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
		
		Label lblTipoDeCuenta = new Label("Tipo de Cuenta");
		lblTipoDeCuenta.setStyleName("label");
		absolutePanel.add(lblTipoDeCuenta, 590, 527);
		lblTipoDeCuenta.setSize("192px", "19px");
		
		Label label_13 = new Label("No. Cuenta");
		label_13.setStyleName("label");
		absolutePanel.add(label_13, 36, 527);
		label_13.setSize("192px", "19px");
		
		Label lblDpi = new Label("DPI");
		lblDpi.setStyleName("label");
		absolutePanel.add(lblDpi, 318, 669);
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
		absolutePanel.add(lblCentroTrabajo, 32, 1198);
		lblCentroTrabajo.setSize("192px", "19px");
		
		lblOcupacion = new Label("Ocupacion");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 312, 1202);
		lblOcupacion.setSize("192px", "19px");
		
		lblFechaIngreso = new Label("Fecha Ingreso");
		lblFechaIngreso.setStyleName("label");
		absolutePanel.add(lblFechaIngreso, 584, 1202);
		lblFechaIngreso.setSize("192px", "19px");
		
		lblCodigoOcupacion = new Label("Codigo Ocupacion");
		lblCodigoOcupacion.setStyleName("label");
		absolutePanel.add(lblCodigoOcupacion, 31, 1265);
		lblCodigoOcupacion.setSize("192px", "19px");
		
		lblProfesion = new Label("profesion");
		lblProfesion.setStyleName("label");
		absolutePanel.add(lblProfesion, 312, 1265);
		lblProfesion.setSize("192px", "19px");
		
		lblTipoPlanilla = new Label("Tipo Planilla");
		lblTipoPlanilla.setStyleName("label");
		absolutePanel.add(lblTipoPlanilla, 590, 1261);
		lblTipoPlanilla.setSize("192px", "19px");
		
		lblSalarioBase = new Label("Salario Base");
		lblSalarioBase.setStyleName("label");
		absolutePanel.add(lblSalarioBase, 35, 1328);
		lblSalarioBase.setSize("192px", "19px");
		
		lblBonificacion = new Label("Bonificacion");
		lblBonificacion.setStyleName("label");
		absolutePanel.add(lblBonificacion, 315, 1328);
		lblBonificacion.setSize("192px", "19px");
		
		lblTotal = new Label("Total");
		lblTotal.setStyleName("label");
		absolutePanel.add(lblTotal, 587, 1328);
		lblTotal.setSize("192px", "19px");
		
		Label label_28 = new Label("Año de Nacimiento");
		label_28.setStyleName("label");
		absolutePanel.add(label_28, 36, 655);
		label_28.setSize("192px", "19px");
		
		lblD = new Label("Datos del Patrono: (Uso exclusivo de la Fundacion");
		lblD.setStyleName("label");
		absolutePanel.add(lblD, 20, 1173);
		lblD.setSize("449px", "19px");
		
		Label lbNombreBanco = new Label("Nombre del Banco");
		lbNombreBanco.setStyleName("label");
		absolutePanel.add(lbNombreBanco, 320, 527);
		lbNombreBanco.setSize("230px", "19px");
		
		Label lblDepartamentoResidencia = new Label("Departamento residencia");
		lblDepartamentoResidencia.setStyleName("label");
		absolutePanel.add(lblDepartamentoResidencia, 316, 751);
		lblDepartamentoResidencia.setSize("231px", "19px");
		
		lblEstadoDelEmpleado = new Label("Estado Del Empleado");
		lblEstadoDelEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoDelEmpleado, 38, 69);
		lblEstadoDelEmpleado.setSize("192px", "19px");
		
		lblEtnia = new Label("Etnia");
		lblEtnia.setStyleName("label");
		absolutePanel.add(lblEtnia, 592, 669);
		lblEtnia.setSize("247px", "19px");
		
		lblNombreYApellido = new Label("Nombre y Apellido");
		lblNombreYApellido.setStyleName("label");
		absolutePanel.add(lblNombreYApellido, 36, 1099);
		lblNombreYApellido.setSize("192px", "19px");
		
		lblNoTelefono = new Label("Telefono");
		lblNoTelefono.setStyleName("label");
		absolutePanel.add(lblNoTelefono, 265, 1099);
		lblNoTelefono.setSize("192px", "19px");
		
		label_14 = new Label("Nombre y Apellido");
		label_14.setStyleName("label");
		absolutePanel.add(label_14, 461, 1099);
		label_14.setSize("192px", "19px");
		
		lblTelefono = new Label("Telefono");
		lblTelefono.setStyleName("label");
		absolutePanel.add(lblTelefono, 672, 1099);
		lblTelefono.setSize("192px", "19px");
		
		lblTelefonoSeEmergencia = new Label("Escribe nombres y Telefonos de emergencia");
		lblTelefonoSeEmergencia.setStyleName("label");
		absolutePanel.add(lblTelefonoSeEmergencia, 36, 1064);
		lblTelefonoSeEmergencia.setSize("449px", "19px");
		
		lblDepartamentoNacimiento = new Label("Departamento Nacimiento");
		lblDepartamentoNacimiento.setStyleName("label");
		absolutePanel.add(lblDepartamentoNacimiento, 36, 989);
		lblDepartamentoNacimiento.setSize("231px", "19px");
		
		lblMunicipioNacimiento = new Label("Municipio Nacimiento");
		lblMunicipioNacimiento.setStyleName("label");
		absolutePanel.add(lblMunicipioNacimiento, 308, 989);
		lblMunicipioNacimiento.setSize("192px", "19px");
		
		lblJefeInmediato = new Label("Jefe Inmediato");
		lblJefeInmediato.setStyleName("label");
		absolutePanel.add(lblJefeInmediato, 36, 1395);
		lblJefeInmediato.setSize("192px", "19px");
		
		lblAfiliado = new Label("Afiliado");
		lblAfiliado.setStyleName("label");
		absolutePanel.add(lblAfiliado, 308, 1397);
		lblAfiliado.setSize("192px", "19px");
		
		finanzasService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>(){
		    public void onFailure(Throwable caught) 
		    {
		    }
		
			@Override
		    public void onSuccess(List<AuxAfiliado> result)
		    {
				listAfiliado.addItem("nada seleccionado", ""+0);
				if(!result.isEmpty()){
					for(AuxAfiliado af: result)
					{
						listAfiliado.addItem(af.getNomAfiliado(), ""+af.getIdAfiliado());
						
					}
				}
		    }
		});
	}
	/**
	 * metodo para obtener los municipios del departemento entrante
	 * @param Departamento
	 * @return
	 */
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
	/**
	 * llena los datos que vienen del datastore, a este formulario
	 * @param id
	 * @param listEstadoCivil
	 * @param listSexo
	 * @param txtPrimerApellido
	 * @param txtSegundoApellido
	 * @param txtApellidoCasada
	 * @param txtNo_iggs
	 * @param txtPrimerNombre
	 * @param txtSegundoNombre
	 * @param listPais
	 * @param listNoDependientes
	 * @param txtTipoPasaporte
	 * @param listDireccionMunicipio
	 * @param txtDireccion
	 * @param txtCorreoElectronico
	 * @param listTipoLicencia
	 * @param dateAnnioNacimiento
	 * @param txtOcupacion
	 * @param txtCentroTrabajo
	 * @param txt_CodigoOcupacion
	 * @param txtProfesion
	 * @param txtTipoPlanilla
	 * @param dateFechaIngreso
	 * @param noCuenta
	 * @param tipoCuenta
	 * @param nombreBanco
	 * @param txtDPI
	 * @param txtTelefonoCasa
	 * @param txtTelefonoCelular
	 * @param txtNoLicencia
	 * @param txtNit
	 * @param txtNoPasaporte
	 * @param txtSalarioBase
	 * @param txtBonificacion
	 * @param txtTotal
	 * @param listDireccionDepartamento
	 * @param txtIVS
	 * @param URLFile
	 * @param KeyFile
	 * @param Estado
	 * @param pasaporte
	 * @param licencia
	 * @param Etnia
	 * @param NombreEmergencia
	 * @param TelefonoEmergencia
	 * @param NombreEmergencia2
	 * @param TelefonoEmergencia2
	 * @param depto_nacimiento
	 * @param municipio_nacimiento
	 * @param Jefe_Inmediato
	 */
	public void LlenarDatos(Long id,String listEstadoCivil,String listSexo,String txtPrimerApellido,
		    String txtSegundoApellido , String txtApellidoCasada ,String txtNo_iggs, String txtPrimerNombre,
		    String txtSegundoNombre ,String listPais,String listNoDependientes , String txtTipoPasaporte ,
		    String listDireccionMunicipio,String txtDireccion , String txtCorreoElectronico,
		    String listTipoLicencia, Long dateAnnioNacimiento,String txtOcupacion , String txtCentroTrabajo,
		    String txt_CodigoOcupacion, String txtProfesion,String txtTipoPlanilla, Long dateFechaIngreso,
		    String noCuenta, String tipoCuenta, String nombreBanco , String txtDPI,String txtTelefonoCasa, String txtTelefonoCelular ,
		    String txtNoLicencia, String txtNit, String txtNoPasaporte,String txtSalarioBase ,String txtBonificacion ,
		    String txtTotal, String listDireccionDepartamento ,String txtIVS, String  URLFile, 
		    String KeyFile,String Estado,String pasaporte, String licencia, String Etnia,
            String NombreEmergencia, String TelefonoEmergencia,
            String NombreEmergencia2, String TelefonoEmergencia2,String depto_nacimiento,
            String municipio_nacimiento, Long Jefe_Inmediato, Long afiliado)
	{
		if(afiliado==0L){
			id_afiliado = 0L;
			listAfiliado.setVisible(true);
		}else{
			id_afiliado = afiliado;
			listAfiliado.setVisible(false);
			listAfiliado.setEnabled(false);
			lblAfiliado.setVisible(false);
			
		}
		if(tip != 0){
			id_afiliado = afiliado;
			listAfiliado.setVisible(false);
			listAfiliado.setEnabled(false);
			lblAfiliado.setVisible(false);
		}
		System.out.println(id);
		this.idJefe = Jefe_Inmediato;
		this.txtJefeInmediato.setText(""+Jefe_Inmediato);
		this.KeyFile = KeyFile;
		this.URLFile = URLFile;
		this.id_empleado = id;
		this.bandera = false;
		this.txtNo_iggs.setText(txtNo_iggs);
		this.txtNombreEmergencia.setText(NombreEmergencia);
		this.txtTelefonoEmergencia.setText(TelefonoEmergencia);
		this.txtNombreEmergencia2.setText(NombreEmergencia2);
		this.txtTelefonoEmergencia2.setText(TelefonoEmergencia2);
		this.noCuenta.setText(noCuenta);
		this.txtDPI.setText(txtDPI);
		this.txtTipoPasaporte.setText(txtTipoPasaporte);
		this.txtNoPasaporte.setText(txtNoPasaporte);
		this.txtDireccion.setText(txtDireccion);
		this.txtCorreoElectronico.setText(txtCorreoElectronico);
		this.txtTelefonoCasa.setText(txtTelefonoCasa);
		this.txtTelefonoCelular.setText(txtTelefonoCelular);

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
		
		try{
			image.setUrl(URLFile);
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
	    for(int i=0; i < this.listEtnia.getItemCount() && bandera; i++){
	       bandera = !this.listEtnia.getValue(i).equals(Etnia);
	       this.listEtnia.setSelectedIndex(i);
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
		this.dateAnnioNacimiento.setValue(new Date(dateAnnioNacimiento));
        bandera = true;
        for(int i=0; i < this.listTipoLicencia.getItemCount() && bandera; i++){
            bandera = this.listTipoLicencia.getValue(i).equals(listTipoLicencia);
            this.listTipoLicencia.setSelectedIndex(i);
        }   

        bandera = true;
        for(int i=0; i < this.listDireccionDepartamento.getItemCount() && bandera; i++){
            bandera = !this.listDireccionDepartamento.getValue(i).equals(listDireccionDepartamento);
            this.listDireccionDepartamento.setSelectedIndex(i);
        }  
        
        bandera = true;
        for(int i=0; i < this.listNacimientoDepartamento.getItemCount() && bandera; i++){
            bandera = !this.listNacimientoDepartamento.getValue(i).equals(depto_nacimiento);
            this.listNacimientoDepartamento.setSelectedIndex(i);
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
        int correlativo = Integer.parseInt(this.listDireccionDepartamento.getValue(this.listDireccionDepartamento.getSelectedIndex())+"01");
        for (int i = 1; i < numerosComoArray2.length; i++) {
        	this.listDireccionMunicipio.addItem(numerosComoArray2[i],String.valueOf(correlativo));
        	correlativo++;
        }

        bandera = true;
        for(int i=0; i < this.listDireccionMunicipio.getItemCount() && bandera; i++){
            bandera = !this.listDireccionMunicipio.getValue(i).equals(listDireccionMunicipio);
            this.listDireccionMunicipio.setSelectedIndex(i);
        }   
        
        this.listNacimientoMunicipio.clear();
        String[] numerosComoArray = Depto_Municipio(this.listNacimientoDepartamento.getItemText(this.listNacimientoDepartamento.getSelectedIndex())).split(",");
        correlativo = Integer.parseInt(this.listNacimientoDepartamento.getValue(this.listNacimientoDepartamento.getSelectedIndex())+"01");
        for (int i = 1; i < numerosComoArray.length; i++) {
        	
        	this.listNacimientoMunicipio.addItem(numerosComoArray[i],String.valueOf(correlativo));
        	correlativo++;
        }

        bandera = true;
        for(int i=0; i < this.listNacimientoMunicipio.getItemCount() && bandera; i++){
            bandera = !this.listNacimientoMunicipio.getValue(i).equals(municipio_nacimiento);
            this.listNacimientoMunicipio.setSelectedIndex(i);
        } 
				  
		
	}
	/**
	 * invalida casiillas que solo se le presenta a un usuario en especifico
	 */
	public void Inavilitar_Casillas(){

		
		lblAfiliado.setVisible(false);		
		listAfiliado.setVisible(false);
		listAfiliado.setEnabled(false);
		
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
		lblJefeInmediato.setVisible(false);
		txtJefeInmediato.setVisible(false);
		btnOK.setVisible(false);
		absolutePanel.add(btnActualizar, 316, 1200);
	}
	/**
	 * se obtiene un form, que contiene para subir archivos al blobStore
	 * @return
	 */
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
					if (fileUpload.getFilename().length() == 0 ) {
						mensaje.setMensaje("alert alert-info", 
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
						mensaje.setMensaje("alert alert-error", 
	                			"verifique que la imagen Pese menos de 1MB");
						
					}
				}
			});
	    
		}
		return form;
	}
	/**
	 * se agrega los elementos como fileupload, y boton a un panel
	 * @return
	 */
	private VerticalPanel getFormElements() {
		if (formElements == null) {
			formElements = new VerticalPanel();
			formElements.setSize("356px", "100%");
			formElements.add(getFileUpload());
			formElements.add(getButton());
		}
		return formElements;
	}
	/**
	 * se crea un file ulpoad
	 * @return
	 */
	private FileUpload getFileUpload() {
		if (fileUpload == null) {
			fileUpload = new FileUpload();
			fileUpload.setWidth("357px");
			fileUpload.setName("myFile");
			fileUpload.getElement().setAttribute("accept", "image/*");
		}
		return fileUpload;
	}
	/**
	 * se crea un boton para el form para subir archivos
	 * @return
	 */
	private Button getButton() {
		if (button == null) {
			button = new Button("Subir");
			button.setHeight("31px");
			button.setStyleName("sendButton");
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					load.visible();
					form.submit();
					load.invisible();
				}
			});
			button.setEnabled(false);
		}
		return button;
	}
	/**
	 * se realiza el procedimiento para subir el archivo y crear una URL
	 */
	private void getFormUrl() {
		
		uploadUrlService.getUploadUrl(new AsyncCallback<String>() {
			public void onSuccess(String url) {
				form.setAction(url);
				button.setEnabled(true);
				//System.out.println("retrieved url for blob store: " + url);
			}

			public void onFailure(Throwable caught) {
		        load.invisible();
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nen el servicio");
			}
		});
		
	}
	/**
	 * se obtiene el archivo, tanto el key, como la URL
	 */
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
				recursosHumanosService.remove(getKeyFile() , new AsyncCallback<String>(){
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
		grid.setWidget(0, 0, new HTML("<a  target=\"_blank\" href=" + URLFile +">Ver</a>"));
	}
	public void MensajeBusquedaEmpleado(){
        final DialogBox Registro2 = new DialogBox();
        final HTML serverResponseLabel = new HTML();
        final Button close= new Button("x");
        AsignarJefe inicio = new AsignarJefe(this);
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
	public void setJefe(String correo){
		txtJefeInmediato.setText(correo);
	}
/**
 * 
 * @return
 */
	public String getURLFile() {
		return URLFile;
	}
/**
 * 
 * @param uRLFile
 */
	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}
/**
 * 
 * @return
 */
	public String getKeyFile() {
		return KeyFile;
	}
/**
 * 
 * @param keyFile
 */
	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}
/**
 * 
 * @return
 */
	public int getTipo() {
		return tipo;
	}
/**
 * 
 * @param tipo
 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	/**
	 * 
	 * @return
	 */
	public Long getIdJefe() {
		return idJefe;
	}
	/**
	 * 
	 * @param idJefe
	 */
	public void setIdJefe(Long idJefe) {
		this.idJefe = idJefe;
	}
	}
