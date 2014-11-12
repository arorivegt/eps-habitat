package org.habitatguate.hgerp.seguridad.client.soluciones;



import java.util.*;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.CheckBox;

public class Sce_DataFormularioSolicitud extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryFormularioSolicitud formulario;
	private Long idFormulario = 0L;
	private boolean bandera = true;
    private TextBox txtNombreSolicitante;
	private TextBox txtEdad;
	private TextBox txtNumDpi;
	private TextBox txtNumDpiUnico;
	private TextBox txtNumDpiReferencia;
	private TextBox txtProfesionOficio;
    private TextBox txtDireccionActual;
	private TextBox txtActividadEconomica;
	private CheckBox checkBoxLeer;
	private CheckBox checkBoxEscribir;
	private CheckBox checkBoxFirmar;
	private TextBox txtDireccionSolucion;
	private TextBox txtCuotaPagar;
	private CheckBox checkBoxCamion;
	private CheckBox checkBoxCarro;
	private CheckBox checkBoxPeatonal;
	private TextBox txtLugarTrabajoSolicitante;
	private TextBox txtTelefonoCasaSolicitante;
	private TextBox txtTelefonoTrabajoSolicitante;
    private TextBox txtNombreConyuge;
	private TextBox txtTelefonoConyuge;
	private TextBox txtLugarTrabajoConyuge;
	private TextBox txtTelefonoTrabajoConyuge;
	private ListBox listEstadoCivil;
    private ListBox listPais;
    private AbsolutePanel absolutePanel;
	private Mensaje mensaje;
	private Button btnGuardar;
	private ListBox listSolucionConstruir;
    
	public Sce_DataFormularioSolicitud(Sce_DataEntryFormularioSolicitud e) {
		
		this.formulario = e;
		mensaje =  new Mensaje();
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "617px");
		
		listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("-", "-1");
		listEstadoCivil.addItem("Soltero (a)", "1");
		listEstadoCivil.addItem("Casado (a)", "2");
		listEstadoCivil.addItem("Unido (a)", "3");
		listEstadoCivil.addItem("Separado (a)", "4");
		listEstadoCivil.addItem("Divorciado (a)", "5");
		listEstadoCivil.addItem("Viudo (a)", "6");
		listEstadoCivil.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstadoCivil, 148, 64);
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
		listPais.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPais, 687, 64);
		listPais.setSize("173px", "27px");
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addItem("-","-1");
		listSolucionConstruir.addItem("Tipo I","1");
		listSolucionConstruir.addItem("Tipo II","2");
		listSolucionConstruir.addItem("Tipo III","3");
		listSolucionConstruir.addItem("Tipo IV","4");
		listSolucionConstruir.addItem("Tipo V","5");
		listSolucionConstruir.addItem("Tipo VI","6");
		listSolucionConstruir.addItem("Tipo VII","7");
		listSolucionConstruir.addItem("Tipo VIII","8");
		listSolucionConstruir.addItem("Tipo IX","9");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 232, 456);
		listSolucionConstruir.setSize("148px", "27px");
		
		txtNombreSolicitante = new TextBox();
		txtNombreSolicitante.setMaxLength(50);
		txtNombreSolicitante.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreSolicitante, 43, 28);
		txtNombreSolicitante.setSize("851px", "19px");
		
		txtDireccionActual = new TextBox();
		txtDireccionActual.setMaxLength(200);
		txtDireccionActual.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDireccionActual, 229, 235);
		txtDireccionActual.setSize("601px", "19px");
		
		txtEdad = new TextBox();
		txtEdad.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtEdad.getText().equals("")) {txtEdad.setText("0");}
				else if(txtEdad.getText().equals(null)) {txtEdad.setText("0");}
				else{
					try{
						Integer.parseInt(txtEdad.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtEdad.setText("0");
					}
				}
			}
		});		
		txtEdad.setText("0");
		txtEdad.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEdad, 398, 70);
		txtEdad.setSize("81px", "19px");
		
		txtNumDpi = new TextBox();
		txtNumDpi.setMaxLength(8);
		txtNumDpi.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtNumDpi.getText().equals("")) {txtNumDpi.setText("0");}
				else if(txtNumDpi.getText().equals(null)) {txtNumDpi.setText("0");}
				else{
					try{
						Integer.parseInt(txtNumDpi.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtNumDpi.setText("0");
					}
				}
			}
		});
		txtNumDpi.setText("0");
		txtNumDpi.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNumDpi, 693, 115);
		txtNumDpi.setSize("80px", "19px");
		
		txtNumDpiUnico = new TextBox();
		txtNumDpiUnico.setMaxLength(1);
		txtNumDpiUnico.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtNumDpiUnico.getText().equals("")) {txtNumDpiUnico.setText("0");}
				else if(txtNumDpiUnico.getText().equals(null)) {txtNumDpiUnico.setText("0");}
				else{
					try{
						Integer.parseInt(txtNumDpiUnico.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtNumDpiUnico.setText("0");
					}
				}
			}
		});	
		txtNumDpiUnico.setText("0");
		txtNumDpiUnico.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNumDpiUnico, 781, 115);
		txtNumDpiUnico.setSize("20px", "19px");
		
		txtNumDpiReferencia = new TextBox();
		txtNumDpiReferencia.setMaxLength(4);
		txtNumDpiReferencia.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtNumDpiReferencia.getText().equals("")) {txtNumDpiReferencia.setText("0");}
				else if(txtNumDpiReferencia.getText().equals(null)) {txtNumDpiReferencia.setText("0");}
				else{
					try{
						Integer.parseInt(txtNumDpiReferencia.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtNumDpiReferencia.setText("0");
					}
				}
			}
		});	
		txtNumDpiReferencia.setText("0");
		txtNumDpiReferencia.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNumDpiReferencia, 810, 115);
		txtNumDpiReferencia.setSize("45px", "19px");
		
		txtDireccionSolucion = new TextBox();
		txtDireccionSolucion.setStyleName("gwt-TextBox2");
		txtDireccionSolucion.setMaxLength(200);
		absolutePanel.add(txtDireccionSolucion, 229, 273);
		txtDireccionSolucion.setSize("601px", "19px");
		
		txtLugarTrabajoConyuge = new TextBox();
		txtLugarTrabajoConyuge.setStyleName("gwt-TextBox2");
		txtLugarTrabajoConyuge.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajoConyuge, 229, 544);
		txtLugarTrabajoConyuge.setSize("294px", "19px");
		
		txtLugarTrabajoSolicitante = new TextBox();
		txtLugarTrabajoSolicitante.setStyleName("gwt-TextBox2");
		txtLugarTrabajoSolicitante.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajoSolicitante, 229, 371);
		txtLugarTrabajoSolicitante.setSize("601px", "19px");
		
		txtTelefonoTrabajoConyuge = new TextBox();
		txtTelefonoTrabajoConyuge.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoTrabajoConyuge.getText().equals("")) {txtTelefonoTrabajoConyuge.setText("0");}
				else if(txtTelefonoTrabajoConyuge.getText().equals(null)) {txtTelefonoTrabajoConyuge.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoTrabajoConyuge.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtTelefonoTrabajoConyuge.setText("0");
					}
				}
			}
		});		
		txtTelefonoTrabajoConyuge.setText("0");
		txtTelefonoTrabajoConyuge.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoTrabajoConyuge, 689, 542);
		txtTelefonoTrabajoConyuge.setSize("128px", "19px");	
		
		txtProfesionOficio = new TextBox();
		txtProfesionOficio.setStyleName("gwt-TextBox2");
		txtProfesionOficio.setMaxLength(50);
		absolutePanel.add(txtProfesionOficio, 227, 113);
		txtProfesionOficio.setSize("296px", "19px");
		
		txtActividadEconomica = new TextBox();
		txtActividadEconomica.setStyleName("gwt-TextBox2");
		txtActividadEconomica.setMaxLength(50);
		absolutePanel.add(txtActividadEconomica, 227, 151);
		txtActividadEconomica.setSize("296px", "19px");
		
		checkBoxLeer = new CheckBox("Sabe Leer");
		absolutePanel.add(checkBoxLeer, 232, 189);
		
		checkBoxEscribir = new CheckBox("Sabe Escribir");
		absolutePanel.add(checkBoxEscribir, 364, 189);
		checkBoxEscribir.setSize("154px", "24px");
		
		checkBoxFirmar = new CheckBox("Sabe Firmar");
		absolutePanel.add(checkBoxFirmar, 524, 189);
		checkBoxFirmar.setSize("159px", "24px");
		
		txtTelefonoCasaSolicitante = new TextBox();
		txtTelefonoCasaSolicitante.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoCasaSolicitante.getText().equals("")) {txtTelefonoCasaSolicitante.setText("0");}
				else if(txtTelefonoCasaSolicitante.getText().equals(null)) {txtTelefonoCasaSolicitante.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoCasaSolicitante.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtTelefonoCasaSolicitante.setText("0");
					}
				}
			}
		});			
		txtTelefonoCasaSolicitante.setText("0");
		txtTelefonoCasaSolicitante.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCasaSolicitante, 229, 419);
		txtTelefonoCasaSolicitante.setSize("128px", "19px");
		
		checkBoxCamion = new CheckBox("Camion");
		absolutePanel.add(checkBoxCamion, 232, 319);
		checkBoxCamion.setSize("105px", "24px");
		
		checkBoxCarro = new CheckBox("Carro");
		absolutePanel.add(checkBoxCarro, 364, 319);
		checkBoxCarro.setSize("105px", "24px");
		
		checkBoxPeatonal = new CheckBox("Peatonal");
		absolutePanel.add(checkBoxPeatonal, 524, 319);
		checkBoxPeatonal.setSize("105px", "24px");
		
		txtTelefonoTrabajoSolicitante = new TextBox();
		txtTelefonoTrabajoSolicitante.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoTrabajoSolicitante.getText().equals("")) {txtTelefonoTrabajoSolicitante.setText("0");}
				else if(txtTelefonoTrabajoSolicitante.getText().equals(null)) {txtTelefonoTrabajoSolicitante.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoTrabajoSolicitante.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtTelefonoTrabajoSolicitante.setText("0");
					}
				}
			}
		});			
		txtTelefonoTrabajoSolicitante.setText("0");
		txtTelefonoTrabajoSolicitante.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoTrabajoSolicitante, 693, 421);
		txtTelefonoTrabajoSolicitante.setSize("128px", "17px");
		
		txtNombreConyuge = new TextBox();
		txtNombreConyuge.setStyleName("gwt-TextBox2");
		txtNombreConyuge.setMaxLength(200);
		absolutePanel.add(txtNombreConyuge, 229, 502);
		txtNombreConyuge.setSize("294px", "19px");
		
		txtTelefonoConyuge = new TextBox();
		txtTelefonoConyuge.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoConyuge.getText().equals("")) {txtTelefonoConyuge.setText("0");}
				else if(txtTelefonoConyuge.getText().equals(null)) {txtTelefonoConyuge.setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoConyuge.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtTelefonoConyuge.setText("0");
					}
				}
			}
		});			
		txtTelefonoConyuge.setText("0");
		txtTelefonoConyuge.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoConyuge, 689, 500);
		txtTelefonoConyuge.setSize("128px", "19px");
		
		txtCuotaPagar = new TextBox();
		txtCuotaPagar.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtCuotaPagar.getText().equals("")) {txtCuotaPagar.setText("0.0");}
				else if(txtCuotaPagar.getText().equals(null)) {txtCuotaPagar.setText("0.0");}
				else{
					try{
						Float.parseFloat(txtCuotaPagar.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nNumero no valido");
						txtCuotaPagar.setText("0.0");
					}
				}
			}
		});			
		txtCuotaPagar.setText("0.0");
		txtCuotaPagar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtCuotaPagar, 689, 462);
		txtCuotaPagar.setSize("128px", "19px");
		
		Label lblNombres = new Label("Nombre completo:");
		lblNombres.setStyleName("label");
		absolutePanel.add(lblNombres, 42, 10);
		lblNombres.setSize("192px", "19px");
		
		Label lblDireccionActual = new Label("Direccion Actual:");
		lblDireccionActual.setStyleName("label");
		absolutePanel.add(lblDireccionActual, 42, 237);
		lblDireccionActual.setSize("181px", "19px");
		
		Label lblEstadoCivil = new Label("Estado Civil:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 42, 72);
		lblEstadoCivil.setSize("130px", "19px");		
		
		Label lblEdad = new Label("Edad:");
		lblEdad.setStyleName("label");
		absolutePanel.add(lblEdad, 323, 72);
		lblEdad.setSize("69px", "19px");
		
		Label lblDocumentoPersonalDe = new Label("Num. DPI:");
		lblDocumentoPersonalDe.setStyleName("label");
		absolutePanel.add(lblDocumentoPersonalDe, 562, 115);
		lblDocumentoPersonalDe.setSize("101px", "19px");
		
		Label lblDireccionSolucion = new Label("Direccion de solucion:");
		lblDireccionSolucion.setStyleName("label");
		absolutePanel.add(lblDireccionSolucion, 42, 275);
		lblDireccionSolucion.setSize("181px", "19px");
		
		Label lblProfesionUOficio = new Label("Profesion u oficio:");
		lblProfesionUOficio.setStyleName("label");
		absolutePanel.add(lblProfesionUOficio, 42, 112);
		lblProfesionUOficio.setSize("136px", "19px");
		
		Label lblLugarDeTrabajo = new Label("Lugar de trabajo:");
		lblLugarDeTrabajo.setStyleName("label");
		absolutePanel.add(lblLugarDeTrabajo, 42, 544);
		lblLugarDeTrabajo.setSize("167px", "19px");
		
		Label lblLugarTrabajoSolicitante = new Label("Lugar de trabajo:");
		lblLugarTrabajoSolicitante.setStyleName("label");
		absolutePanel.add(lblLugarTrabajoSolicitante, 42, 373);
		lblLugarTrabajoSolicitante.setSize("181px", "19px");
		
		Label lblTelefonoTrabajo = new Label("Telefono:");
		lblTelefonoTrabajo.setStyleName("label");
		absolutePanel.add(lblTelefonoTrabajo, 562, 544);
		lblTelefonoTrabajo.setSize("110px", "19px");
		
		Label labelPais = new Label("Nacionalidad:");
		labelPais.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		labelPais.setStyleName("label");
		absolutePanel.add(labelPais, 553, 72);
		labelPais.setSize("110px", "19px");	
		
		Label lblActividadEconomica = new Label("Actividad Economica:");
		lblActividadEconomica.setStyleName("label");
		absolutePanel.add(lblActividadEconomica, 42, 153);
		lblActividadEconomica.setSize("179px", "19px");
		
		Label lblTelefonoCasa = new Label("Telefono de casa:");
		lblTelefonoCasa.setStyleName("label");
		absolutePanel.add(lblTelefonoCasa, 42, 421);
		lblTelefonoCasa.setSize("167px", "19px");
		
		Label lblInmuebleAccesibleEn = new Label("Inmueble accesible en:");
		lblInmuebleAccesibleEn.setStyleName("label");
		absolutePanel.add(lblInmuebleAccesibleEn, 42, 324);
		lblInmuebleAccesibleEn.setSize("181px", "19px");
		
		Label lblTelefonoDeTrabajo = new Label("Telefono de trabajo:");
		lblTelefonoDeTrabajo.setStyleName("label");
		absolutePanel.add(lblTelefonoDeTrabajo, 464, 421);
		lblTelefonoDeTrabajo.setSize("167px", "19px");
		
		Label lblSolucion = new Label("Solucion a construir:");
		lblSolucion.setStyleName("label");
		absolutePanel.add(lblSolucion, 42, 462);
		lblSolucion.setSize("167px", "19px");
		
		Label lblCuota = new Label("Cuota que puede pagar:");
		lblCuota.setStyleName("label");
		absolutePanel.add(lblCuota, 464, 462);
		lblCuota.setSize("199px", "19px");
		
		Label lblNombreConyuge = new Label("Nombre del Conyuge:");
		lblNombreConyuge.setStyleName("label");
		absolutePanel.add(lblNombreConyuge, 42, 502);
		lblNombreConyuge.setSize("167px", "19px");
		
		Label lblTelefonoConyuge = new Label("Telefono:");
		lblTelefonoConyuge.setStyleName("label");
		absolutePanel.add(lblTelefonoConyuge, 562, 502);
		lblTelefonoConyuge.setSize("110px", "19px");
		
		// --- Boton Guardar - Data Formulario Solicitud

		btnGuardar = new Button("New button");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(initRequireData()){

					String nombreSolicitante = "";		
					if(txtNombreSolicitante.getText() == null){
						nombreSolicitante = "";
					}else{
						nombreSolicitante = txtNombreSolicitante.getText();
					}

					String estadoCivil = "-1";		
					estadoCivil = listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex());		

					String nacionalidad = "-1";		
					nacionalidad = listPais.getValue(listPais.getSelectedIndex());		

					String edadValue = txtEdad.getText();
					int edad = 0;
					edad = Integer.parseInt(edadValue);

					String profesionOficio = "";		
					if(txtProfesionOficio.getText() == null){
						profesionOficio = "";
					}else{
						profesionOficio = txtProfesionOficio.getText();
					}

					String dpiValue = txtNumDpi.getText();
					int dpi = 0;
					dpi = Integer.parseInt(dpiValue);

					String dpiUnicoValue = txtNumDpiUnico.getText();
					int dpiUnico = 0;
					dpiUnico = Integer.parseInt(dpiUnicoValue);

					String dpiReferenciaValue = txtNumDpiReferencia.getText();
					int dpiReferencia = 0;
					dpiReferencia = Integer.parseInt(dpiReferenciaValue);

					String actividadEconomica = "";		
					if(txtActividadEconomica.getText() == null){
						actividadEconomica = "";
					}else{
						actividadEconomica = txtActividadEconomica.getText();
					}

					Boolean sabeLeer = false;
					sabeLeer = checkBoxLeer.getValue();

					Boolean sabeEscribir = false;
					sabeEscribir = checkBoxEscribir.getValue();

					Boolean sabeFirmar = false;
					sabeFirmar = checkBoxFirmar.getValue();

					String direccionActual = "";		
					if(txtDireccionActual.getText() == null){
						direccionActual = "";
					}else{
						direccionActual = txtDireccionActual.getText();
					}				

					String direccionSolucion = "";		
					if(txtDireccionSolucion.getText() == null){
						direccionSolucion = "";
					}else{
						direccionSolucion = txtDireccionSolucion.getText();
					}

					Boolean camion = false;
					camion = checkBoxCamion.getValue();

					Boolean carro = false;
					carro = checkBoxCarro.getValue();

					Boolean peatonal = false;
					peatonal = checkBoxPeatonal.getValue();

					String lugarTrabajoSolicitante = "";		
					if(txtLugarTrabajoSolicitante.getText() == null){
						lugarTrabajoSolicitante = "";
					}else{
						lugarTrabajoSolicitante = txtLugarTrabajoSolicitante.getText();
					}

					String telefonoCasaSolicitanteValue = txtTelefonoCasaSolicitante.getText();
					int telefonoCasaSolicitante = 0;
					telefonoCasaSolicitante = Integer.parseInt(telefonoCasaSolicitanteValue);

					String telefonoTrabajoSolicitanteValue = txtTelefonoTrabajoSolicitante.getText();
					int telefonoTrabajoSolicitante = 0;
					telefonoTrabajoSolicitante = Integer.parseInt(telefonoTrabajoSolicitanteValue);

					String solucionConstruir = "-1";		
					solucionConstruir = listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex());		

					float cuotaPagar = 0;
					cuotaPagar = Float.parseFloat(txtCuotaPagar.getText());

					String nombreConyuge = "";		
					if(txtNombreConyuge.getText() == null){
						nombreConyuge = "";
					}else{
						nombreConyuge = txtNombreConyuge.getText();
					}

					String telefonoConyugeValue = txtTelefonoConyuge.getText();
					int telefonoConyuge = 0;
					telefonoConyuge = Integer.parseInt(telefonoConyugeValue);

					String lugarTrabajoConyuge = "";		
					if(txtLugarTrabajoConyuge.getText() == null){
						lugarTrabajoConyuge = "";
					}else{
						lugarTrabajoConyuge = txtLugarTrabajoConyuge.getText();
					}

					String telefonoTrabajoConyugeValue = txtTelefonoTrabajoConyuge.getText();
					int telefonoTrabajoConyuge = 0;
					telefonoTrabajoConyuge = Integer.parseInt(telefonoTrabajoConyugeValue);
					
					Boolean garantia = false;
					Boolean aprobacion = false;
					Boolean primeraSupervision = false;
					Boolean segundaSupervision = false;
					Boolean terceraSupervision = false;
					Boolean cuartaSupervision = false;

					if(bandera){

						Date time=new Date();
						@SuppressWarnings("deprecation")
						Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

						solucionesService.ingresarDatosSolicitante(fecrec, nombreSolicitante, estadoCivil, edad, nacionalidad, 
								profesionOficio, dpi, dpiUnico, dpiReferencia, actividadEconomica,
								sabeLeer, sabeEscribir, sabeFirmar, 
								direccionActual, direccionSolucion,
								camion, carro, peatonal,
								lugarTrabajoSolicitante, telefonoCasaSolicitante, telefonoTrabajoSolicitante,
								solucionConstruir, cuotaPagar,
								nombreConyuge, telefonoConyuge, lugarTrabajoConyuge, telefonoTrabajoConyuge,
								garantia, aprobacion,
								primeraSupervision, segundaSupervision, terceraSupervision, cuartaSupervision,
								new AsyncCallback<Long>() {

							public void onFailure(Throwable caught) 
							{
								mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Almacenarse");
							}

							public void onSuccess(Long result)
							{	
								mensaje.setMensaje("alert alert-info", "Registro Almacenado Exitosamente");

								idFormulario = result;
								formulario.idFormulario = result;
								System.out.println("Valor de NUEVO Formulario: " + idFormulario + ", ID: " + formulario.idFormulario);
								bandera = false;
								formulario.NuevasPestanas();

							}
						});

					}else{

						solucionesService.actualizarDatosSolicitante(idFormulario, nombreSolicitante, estadoCivil, edad, nacionalidad, 
								profesionOficio, dpi, dpiUnico, dpiReferencia, actividadEconomica,
								sabeLeer, sabeEscribir, sabeFirmar, 
								direccionActual, direccionSolucion,
								camion, carro, peatonal,
								lugarTrabajoSolicitante, telefonoCasaSolicitante, telefonoTrabajoSolicitante,
								solucionConstruir, cuotaPagar,
								nombreConyuge, telefonoConyuge, lugarTrabajoConyuge, telefonoTrabajoConyuge,
								new AsyncCallback<Long>() {

							public void onFailure(Throwable caught) 
							{
								mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
							}

							public void onSuccess(Long result)
							{	
								mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");

								System.out.println("Valor de Formulario ACTUALIZADO: " + formulario.idFormulario );
								bandera = false;

							}
						});

					}
				}

			}
		});
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 464, 603);
		
	}
	
	// ---- Mensaje - Exito / Error
	
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
    
	// DATA A CARGAR EN DATOS SOLICITANTE
 
    public void LlenarDatos(Long idFormulario, 
    		String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
			String profesionOficio, int dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge)
	{
    	
		this.bandera = false;
		
		this.idFormulario = idFormulario; // ID Formulario Cargado
		
		this.txtNombreSolicitante.setText(nombreSolicitante);
		String edadValue = ""+edad;
		this.txtEdad.setText(edadValue);
		this.txtProfesionOficio.setText(profesionOficio);
		String dpiValue = ""+dpi;
		this.txtNumDpi.setText(dpiValue);
		String dpiUnicoValue = ""+dpiUnico;
		this.txtNumDpiUnico.setText(dpiUnicoValue);
		String dpiReferenciaValue = ""+dpiReferencia;
		this.txtNumDpiReferencia.setText(dpiReferenciaValue);
		this.txtActividadEconomica.setText(actividadEconomica);
		this.checkBoxLeer.setValue(sabeLeer);
		this.checkBoxEscribir.setValue(sabeEscribir);
		this.checkBoxFirmar.setValue(sabeFirmar);
		this.txtDireccionActual.setText(direccionActual);
		this.txtDireccionSolucion.setText(direccionSolucion);
		this.checkBoxCamion.setValue(camion);
		this.checkBoxCarro.setValue(carro);
		this.checkBoxPeatonal.setValue(peatonal);
		this.txtLugarTrabajoSolicitante.setText(lugarTrabajoSolicitante);
		String telefonoCasaSolicitanteValue = ""+telefonoCasaSolicitante;
		this.txtTelefonoCasaSolicitante.setText(telefonoCasaSolicitanteValue);
		String telefonoTrabajoSolicitanteValue = ""+telefonoTrabajoSolicitante;
		this.txtTelefonoTrabajoSolicitante.setText(telefonoTrabajoSolicitanteValue);
		String cuotaPagarValue = ""+cuotaPagar;
		this.txtCuotaPagar.setText(cuotaPagarValue);
		this.txtNombreConyuge.setText(nombreConyuge);
		String telefonoConyugeValue = ""+telefonoConyuge;
		this.txtTelefonoConyuge.setText(telefonoConyugeValue);
		this.txtLugarTrabajoConyuge.setText(lugarTrabajoConyuge);
		String telefonoTrabajoConyugeValue = ""+telefonoTrabajoConyuge;
		this.txtTelefonoTrabajoConyuge.setText(telefonoTrabajoConyugeValue);
		
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
		
        bandera = true;
	    for(int i=0; i < this.listSolucionConstruir.getItemCount() && bandera; i++){
	       bandera = !this.listSolucionConstruir.getValue(i).equals(solucionConstruir);
	       this.listSolucionConstruir.setSelectedIndex(i);
	    } 
	    
//		this.KeyFile = KeyFile;
//		this.URLFile = URLFile;
//		try{
//			image.setUrl(URLFile);
//			Archivo();
//		}catch(Exception e){
//			image.setUrl("images/imagenempresa.png");
//		}
				  
		
	}
    
    // VALIDACION DATA A INGRESAR
    
    public boolean initRequireData()
    {

    	if(this.txtNombreSolicitante.getText().equals("")){
    		mensaje.setMensaje("alert alert-error", "Debe ingresar Nombre de Solicitante");
    		return false;
    	}

    	String estadoCivil = "-1";		
    	estadoCivil = this.listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex());
    	
    	if(estadoCivil.equals("-1")){
    		mensaje.setMensaje("alert alert-error", "Debe indicar Estado Civil de Solicitante");
    		return false;
    	}

    	if(this.txtEdad.getText().equals("0")){
    		mensaje.setMensaje("alert alert-error", "Debe ingresar Edad de Solicitante");
    		return false;
    	}

    	String nacionalidad = "-1";		
    	nacionalidad = this.listPais.getValue(listPais.getSelectedIndex());
    	
    	if(nacionalidad.equals("-1")){
    		mensaje.setMensaje("alert alert-error", "Debe indicar Nacionalidad de Solicitante");
    		return false;
    	}
    	
//    	if(this.txtDireccionActual.getText().equals("")){
//    		mensaje.setMensaje("alert alert-error", "Debe ingresar Direccion Actual");
//    		return false;
//    	}
//
//    	if(this.txtDireccionSolucion.getText().equals("")){
//    		mensaje.setMensaje("alert alert-error", "Debe ingresar Direccion de Solucion");
//    		return false;
//    	}
    	
    	String solucionConstruir = "-1";		
    	solucionConstruir = this.listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex());
    	
    	if(solucionConstruir.equals("-1")){
    		mensaje.setMensaje("alert alert-error", "Debe indicar Solucion a Construir");
    		return false;
    	}
    	
    	if(this.txtTelefonoCasaSolicitante.getText().equals("0")){
    		mensaje.setMensaje("alert alert-error", "Debe ingresar Telefono de Casa de Solicitante");
    		return false;
    	}

    	if(this.txtTelefonoTrabajoSolicitante.getText().equals("0")){
    		mensaje.setMensaje("alert alert-error", "Debe ingresar Telefono de Trabajo de Solicitante");
    		return false;
    	}
    	
    	
    	return true;    		
    }
    
    
}
