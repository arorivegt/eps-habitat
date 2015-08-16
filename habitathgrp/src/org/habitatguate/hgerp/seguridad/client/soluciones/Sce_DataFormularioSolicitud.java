package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.*;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.service.RecursosHumanosServiceImpl;
import org.habitatguate.hgerp.seguridad.service.SolucionesConstruidasServiceImpl;

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
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    
	private Sce_DataEntryFormularioSolicitud formulario;
	
	// Llaves
	private Long idFormulario = 0L;
	private Long idEmpleado = 0L;
	private String usrName = "";
	private Long idAfiliado = 0L;
	private Long idRol = 0L;

	private boolean bandera = true;
    private TextBox txtNombreSolicitante;
	private TextBox txtEdad;
	private TextBox txtNumDpi;
//	private TextBox txtNumDpiUnico;
//	private TextBox txtNumDpiReferencia;
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
	
	private Label lblAldeaDireccionActual;
	private Label lblDeptoDireccionActual;
	private Label lblMunicipioDireccionActual;
	private TextBox txtAldeaDireccionActual;
	private ListBox listDeptoDireccionActual;
	private ListBox listMunicipioDireccionActual;
	private Label lblAldeaDireccionSolucion;
	private TextBox txtAldeaDireccionSolucion;
	private ListBox listDeptoDireccionSolucion;
	private Label lblDeptoDireccionSolucion;
	private ListBox listMunicipioDireccionSolucion;
	private Label lblMunicipioDireccionSolucion;
	private Label lblDireccionLugarTrabajoSolicitante;
	private TextBox txtDireccionLugarTrabajoSolicitante;
	private Label lblDireccionLugarDeTrabajoConyuge;
	private TextBox txtDireccionLugarTrabajoConyuge;
	
	private String deptoMunicipioDireccionActual = "";
	private String deptoMunicipioDireccionSolucion = "";
	
	// Valor Escritura-Lectura
	private boolean valor;
    
	public Sce_DataFormularioSolicitud(Sce_DataEntryFormularioSolicitud e, boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		// Obtener Id Empleado y UserName (eMail)
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) 
			{
				idEmpleado = result;				

				solucionesService.consultaEmpleadoRegistrado(idEmpleado, new AsyncCallback<AuxEmpleado>(){
					public void onFailure(Throwable caught) 
					{
						mensaje.setMensaje("alert alert-information alert-block", 
								"\nNo hay resultados");
					}

					@Override
					public void onSuccess(AuxEmpleado result)
					{	
						usrName = result.getEmail();
						
						System.out.println("ID Empleado: " + idEmpleado + ", Nombre de Usuario: " + usrName);
					}
				});
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		// Obtener Id Afiliado
		recursosHumanosService.obtenerIdAfiliado(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idAfiliado = result;
				System.out.println("Afiliado: " + idAfiliado);	
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error no tiene Afiliado asignado Empleado");
			}
		});
		
		// Obtener Id Rol
		recursosHumanosService.obtenerIdRol(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idRol = result;
				System.out.println("Id Rol: " + idRol);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		this.formulario = e;
		mensaje =  new Mensaje();
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1100px", "745px");
		
		Label lblNombres = new Label("Nombre completo:");
		lblNombres.setStyleName("label");
		absolutePanel.add(lblNombres, 42, 10);
		lblNombres.setSize("192px", "19px");
		
		Label lblDireccionActual = new Label("Direccion Actual:");
		lblDireccionActual.setStyleName("label");
		absolutePanel.add(lblDireccionActual, 42, 254);
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
		absolutePanel.add(lblDireccionSolucion, 42, 326);
		lblDireccionSolucion.setSize("181px", "19px");
		
		Label lblProfesionUOficio = new Label("Profesion u Oficio:");
		lblProfesionUOficio.setStyleName("label");
		absolutePanel.add(lblProfesionUOficio, 42, 112);
		lblProfesionUOficio.setSize("136px", "19px");
		
		Label lblLugarDeTrabajoConyuge = new Label("Lugar de trabajo:");
		lblLugarDeTrabajoConyuge.setStyleName("label");
		absolutePanel.add(lblLugarDeTrabajoConyuge, 42, 645);
		lblLugarDeTrabajoConyuge.setSize("167px", "19px");
		
		Label lblLugarTrabajoSolicitante = new Label("Lugar de trabajo:");
		lblLugarTrabajoSolicitante.setStyleName("label");
		absolutePanel.add(lblLugarTrabajoSolicitante, 42, 424);
		lblLugarTrabajoSolicitante.setSize("181px", "19px");
		
		Label lblTelefonoTrabajo = new Label("Telefono:");
		lblTelefonoTrabajo.setStyleName("label");
		absolutePanel.add(lblTelefonoTrabajo, 574, 645);
		lblTelefonoTrabajo.setSize("88px", "19px");
		
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
		absolutePanel.add(lblTelefonoCasa, 42, 514);
		lblTelefonoCasa.setSize("167px", "19px");
		
		Label lblInmuebleAccesibleEn = new Label("Inmueble accesible en:");
		lblInmuebleAccesibleEn.setStyleName("label");
		absolutePanel.add(lblInmuebleAccesibleEn, 42, 375);
		lblInmuebleAccesibleEn.setSize("181px", "19px");
		
		Label lblTelefonoDeTrabajo = new Label("Telefono de trabajo:");
		lblTelefonoDeTrabajo.setStyleName("label");
		absolutePanel.add(lblTelefonoDeTrabajo, 491, 514);
		lblTelefonoDeTrabajo.setSize("167px", "19px");
		
		Label lblSolucion = new Label("Solucion a construir:");
		lblSolucion.setStyleName("label");
		absolutePanel.add(lblSolucion, 42, 555);
		lblSolucion.setSize("167px", "19px");
		
		Label lblCuota = new Label("Cuota que puede pagar:");
		lblCuota.setStyleName("label");
		absolutePanel.add(lblCuota, 491, 555);
		lblCuota.setSize("192px", "19px");
		
		Label lblNombreConyuge = new Label("Nombre del Conyuge:");
		lblNombreConyuge.setStyleName("label");
		absolutePanel.add(lblNombreConyuge, 42, 603);
		lblNombreConyuge.setSize("167px", "19px");
		
		Label lblTelefonoConyuge = new Label("Telefono:");
		lblTelefonoConyuge.setStyleName("label");
		absolutePanel.add(lblTelefonoConyuge, 574, 603);
		lblTelefonoConyuge.setSize("88px", "19px");
		
		lblAldeaDireccionActual = new Label("Aldea:");
		lblAldeaDireccionActual.setStyleName("label");
		absolutePanel.add(lblAldeaDireccionActual, 657, 221);
		lblAldeaDireccionActual.setSize("83px", "19px");
		
		lblAldeaDireccionSolucion = new Label("Aldea:");
		lblAldeaDireccionSolucion.setStyleName("label");
		absolutePanel.add(lblAldeaDireccionSolucion, 657, 295);
		lblAldeaDireccionSolucion.setSize("83px", "19px");
		
		lblDeptoDireccionActual = new Label("Departamento:");
		lblDeptoDireccionActual.setStyleName("label");
		absolutePanel.add(lblDeptoDireccionActual, 836, 221);
		lblDeptoDireccionActual.setSize("130px", "19px");
		
		lblDeptoDireccionSolucion = new Label("Departamento:");
		lblDeptoDireccionSolucion.setStyleName("label");
		absolutePanel.add(lblDeptoDireccionSolucion, 836, 295);
		lblDeptoDireccionSolucion.setSize("130px", "19px");
		
		lblMunicipioDireccionActual = new Label("Municipio:");
		lblMunicipioDireccionActual.setStyleName("label");
		absolutePanel.add(lblMunicipioDireccionActual, 982, 221);
		lblMunicipioDireccionActual.setSize("101px", "19px");
		
		lblMunicipioDireccionSolucion = new Label("Municipio:");
		lblMunicipioDireccionSolucion.setStyleName("label");
		absolutePanel.add(lblMunicipioDireccionSolucion, 982, 295);
		lblMunicipioDireccionSolucion.setSize("101px", "19px");
		
		lblDireccionLugarTrabajoSolicitante = new Label("Direccion Lugar de trabajo:");
		lblDireccionLugarTrabajoSolicitante.setStyleName("label");
		absolutePanel.add(lblDireccionLugarTrabajoSolicitante, 42, 468);
		lblDireccionLugarTrabajoSolicitante.setSize("214px", "19px");
		
		lblDireccionLugarDeTrabajoConyuge = new Label("Direccion Lugar de trabajo:");
		lblDireccionLugarDeTrabajoConyuge.setStyleName("label");
		absolutePanel.add(lblDireccionLugarDeTrabajoConyuge, 42, 686);
		lblDireccionLugarDeTrabajoConyuge.setSize("214px", "19px");
		
		txtNombreSolicitante = new TextBox();
		txtNombreSolicitante.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtNombreSolicitante);
				
			}
		});	
		txtNombreSolicitante.setMaxLength(50);
		txtNombreSolicitante.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreSolicitante, 43, 28);
		txtNombreSolicitante.setSize("851px", "19px");
		txtNombreSolicitante.setTabIndex(1);
		
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
		listEstadoCivil.setTabIndex(2);
		
		txtEdad = new TextBox();
		txtEdad.setMaxLength(3);
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
		txtEdad.setTabIndex(3);
		
//		listPais = new ListBox();
//		listPais.addItem("-","-1");
//		listPais.addItem("Guatemala","1");
//		listPais.addItem("El Salvador","2");
//		listPais.addItem("Bélice","3");
//		listPais.addItem("Honduras","4");
//		listPais.addItem("Nicaragua","5");
//		listPais.addItem("Costa Rica","5");
//		listPais.addItem("Panamá","6");
//		listPais.setStyleName("gwt-TextBox2");
//		absolutePanel.add(listPais, 687, 64);
//		listPais.setSize("173px", "27px");
//		listPais.setTabIndex(4);
		
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
		listPais.setTabIndex(4);
		
		txtProfesionOficio = new TextBox();
		txtProfesionOficio.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtProfesionOficio);
				
			}
		});
		txtProfesionOficio.setStyleName("gwt-TextBox2");
		txtProfesionOficio.setMaxLength(50);
		absolutePanel.add(txtProfesionOficio, 227, 113);
		txtProfesionOficio.setSize("296px", "19px");
		txtProfesionOficio.setTabIndex(5);
		
		txtNumDpi = new TextBox();
		txtNumDpi.setMaxLength(13);
//		txtNumDpi.addKeyPressHandler(new KeyPressHandler() {
//		    @Override
//		    public void onKeyPress(KeyPressEvent event) {
//		        String input = txtNumDpi.getText();
//		        if (!input.matches("[0-9]*")) {
//		            // show some error
//					mensaje.setMensaje("alert alert-error", 
//                			"Error !! \nNumero no valido");
//					txtNumDpi.setText("0");
//		        	
//		            return;
//		        }
//		        // do your thang
//		        System.out.println("Exito");
//		        
//		    }
//		});	
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
		absolutePanel.add(txtNumDpi, 693, 115);
		txtNumDpi.setSize("116px", "19px");
		txtNumDpi.setTabIndex(6);
		
		// Comentado para validez de no. DPI en un solo campo
		
//		txtNumDpiUnico = new TextBox();
//		txtNumDpiUnico.setMaxLength(1);
//		txtNumDpiUnico.addChangeHandler(new ChangeHandler() {
//			public void onChange(ChangeEvent event) {
//				if(txtNumDpiUnico.getText().equals("")) {txtNumDpiUnico.setText("0");}
//				else if(txtNumDpiUnico.getText().equals(null)) {txtNumDpiUnico.setText("0");}
//				else{
//					try{
//						Integer.parseInt(txtNumDpiUnico.getText());
//					}catch(Exception e){
//						mensaje.setMensaje("alert alert-error", 
//                    			"Error !! \nNumero no valido");
//						txtNumDpiUnico.setText("0");
//					}
//				}
//			}
//		});	
//		txtNumDpiUnico.setText("0");
//		txtNumDpiUnico.setStyleName("gwt-TextBox2");
//		absolutePanel.add(txtNumDpiUnico, 687, 151);
//		txtNumDpiUnico.setSize("20px", "19px");
//		
//		txtNumDpiReferencia = new TextBox();
//		txtNumDpiReferencia.setMaxLength(4);
//		txtNumDpiReferencia.addChangeHandler(new ChangeHandler() {
//			public void onChange(ChangeEvent event) {
//				if(txtNumDpiReferencia.getText().equals("")) {txtNumDpiReferencia.setText("0");}
//				else if(txtNumDpiReferencia.getText().equals(null)) {txtNumDpiReferencia.setText("0");}
//				else{
//					try{
//						Integer.parseInt(txtNumDpiReferencia.getText());
//					}catch(Exception e){
//						mensaje.setMensaje("alert alert-error", 
//                    			"Error !! \nNumero no valido");
//						txtNumDpiReferencia.setText("0");
//					}
//				}
//			}
//		});	
//		txtNumDpiReferencia.setText("0");
//		txtNumDpiReferencia.setStyleName("gwt-TextBox2");
//		absolutePanel.add(txtNumDpiReferencia, 715, 151);
//		txtNumDpiReferencia.setSize("45px", "19px");
		
		txtActividadEconomica = new TextBox();
		txtActividadEconomica.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtActividadEconomica);
				
			}
		});
		txtActividadEconomica.setStyleName("gwt-TextBox2");
		txtActividadEconomica.setMaxLength(50);
		absolutePanel.add(txtActividadEconomica, 227, 151);
		txtActividadEconomica.setSize("296px", "19px");
		txtActividadEconomica.setTabIndex(7);
		
		checkBoxLeer = new CheckBox("Sabe Leer");
		absolutePanel.add(checkBoxLeer, 232, 189);
		checkBoxLeer.setSize("126px", "24px");
		checkBoxLeer.setTabIndex(8);
		
		checkBoxEscribir = new CheckBox("Sabe Escribir");
		absolutePanel.add(checkBoxEscribir, 364, 189);
		checkBoxEscribir.setSize("154px", "24px");
		checkBoxEscribir.setTabIndex(9);
		
		checkBoxFirmar = new CheckBox("Sabe Firmar");
		absolutePanel.add(checkBoxFirmar, 524, 189);
		checkBoxFirmar.setSize("159px", "24px");
		checkBoxFirmar.setTabIndex(10);
		
		txtDireccionActual = new TextBox();
		txtDireccionActual.setMaxLength(200);
		txtDireccionActual.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDireccionActual, 229, 252);
		txtDireccionActual.setSize("398px", "19px");
		txtDireccionActual.setTabIndex(11);
		
		txtDireccionSolucion = new TextBox();
		txtDireccionSolucion.setStyleName("gwt-TextBox2");
		txtDireccionSolucion.setMaxLength(200);
		absolutePanel.add(txtDireccionSolucion, 229, 324);
		txtDireccionSolucion.setSize("398px", "19px");
		txtDireccionSolucion.setTabIndex(12);
		
		checkBoxCamion = new CheckBox("Camion");
		absolutePanel.add(checkBoxCamion, 232, 370);
		checkBoxCamion.setSize("105px", "24px");
		checkBoxCamion.setTabIndex(13);
		
		checkBoxCarro = new CheckBox("Carro");
		absolutePanel.add(checkBoxCarro, 364, 370);
		checkBoxCarro.setSize("105px", "24px");
		checkBoxCarro.setTabIndex(14);
		
		checkBoxPeatonal = new CheckBox("Peatonal");
		absolutePanel.add(checkBoxPeatonal, 524, 370);
		checkBoxPeatonal.setSize("105px", "24px");
		checkBoxPeatonal.setTabIndex(15);
		
		txtLugarTrabajoSolicitante = new TextBox();
		txtLugarTrabajoSolicitante.setStyleName("gwt-TextBox2");
		txtLugarTrabajoSolicitante.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajoSolicitante, 229, 422);
		txtLugarTrabajoSolicitante.setSize("601px", "19px");
		txtLugarTrabajoSolicitante.setTabIndex(16);
		
		txtTelefonoCasaSolicitante = new TextBox();
		txtTelefonoCasaSolicitante.setMaxLength(8);
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
		absolutePanel.add(txtTelefonoCasaSolicitante, 229, 512);
		txtTelefonoCasaSolicitante.setSize("128px", "19px");
		txtTelefonoCasaSolicitante.setTabIndex(17);
		
		txtTelefonoTrabajoSolicitante = new TextBox();
		txtTelefonoTrabajoSolicitante.setMaxLength(8);
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
		absolutePanel.add(txtTelefonoTrabajoSolicitante, 702, 514);
		txtTelefonoTrabajoSolicitante.setSize("128px", "17px");
		txtTelefonoTrabajoSolicitante.setTabIndex(18);
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addItem("-","-1");
		listSolucionConstruir.addItem("Casa Nueva","1");
		listSolucionConstruir.addItem("Mejoramiento","2");
		listSolucionConstruir.addItem("Adiciones Menores","3");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 232, 549);
		listSolucionConstruir.setSize("148px", "27px");
		listSolucionConstruir.setTabIndex(19);
		
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
		absolutePanel.add(txtCuotaPagar, 702, 553);
		txtCuotaPagar.setSize("128px", "19px");
		txtCuotaPagar.setTabIndex(20);;
		
		txtNombreConyuge = new TextBox();
		txtNombreConyuge.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtNombreConyuge);
				
			}
		});
		txtNombreConyuge.setStyleName("gwt-TextBox2");
		txtNombreConyuge.setMaxLength(200);
		absolutePanel.add(txtNombreConyuge, 229, 603);
		txtNombreConyuge.setSize("294px", "19px");
		txtNombreConyuge.setTabIndex(21);
		
		txtTelefonoConyuge = new TextBox();
		txtTelefonoConyuge.setMaxLength(8);
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
		absolutePanel.add(txtTelefonoConyuge, 702, 601);
		txtTelefonoConyuge.setSize("128px", "19px");
		txtTelefonoConyuge.setTabIndex(22);
		
		txtLugarTrabajoConyuge = new TextBox();
		txtLugarTrabajoConyuge.setStyleName("gwt-TextBox2");
		txtLugarTrabajoConyuge.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajoConyuge, 229, 645);
		txtLugarTrabajoConyuge.setSize("294px", "19px");
		txtLugarTrabajoConyuge.setTabIndex(23);
		
		txtTelefonoTrabajoConyuge = new TextBox();
		txtTelefonoTrabajoConyuge.setMaxLength(8);
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
		absolutePanel.add(txtTelefonoTrabajoConyuge, 702, 643);
		txtTelefonoTrabajoConyuge.setSize("128px", "19px");	
		txtTelefonoTrabajoConyuge.setTabIndex(24);


		txtAldeaDireccionActual = new TextBox();
		txtAldeaDireccionActual.setStyleName("gwt-TextBox2");
		txtAldeaDireccionActual.setMaxLength(200);
		absolutePanel.add(txtAldeaDireccionActual, 657, 254);
		txtAldeaDireccionActual.setSize("152px", "19px");
		
		txtAldeaDireccionSolucion = new TextBox();
		txtAldeaDireccionSolucion.setStyleName("gwt-TextBox2");
		txtAldeaDireccionSolucion.setMaxLength(200);
		absolutePanel.add(txtAldeaDireccionSolucion, 657, 324);
		txtAldeaDireccionSolucion.setSize("152px", "19px");
		
		// Depto-Mun Direccion Actual
		
		listDeptoDireccionActual = new ListBox();
		listDeptoDireccionActual.addItem("-","-1");
		listDeptoDireccionActual.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listMunicipioDireccionActual.clear();
		        String[] numerosComoArray = Depto_Municipio(listDeptoDireccionActual.getItemText(listDeptoDireccionActual.getSelectedIndex())).split(",");
		        int correlativo = Integer.parseInt(listDeptoDireccionActual.getValue(listDeptoDireccionActual.getSelectedIndex())+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	listMunicipioDireccionActual.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }

		        listMunicipioDireccionActual.setSelectedIndex(2);
			}
		});
		listDeptoDireccionActual.addItem("Guatemala","01");
		listDeptoDireccionActual.addItem("Baja Verapaz","15");
		listDeptoDireccionActual.addItem("Alta Verapaz","16");
		listDeptoDireccionActual.addItem("El Progreso","02");
		listDeptoDireccionActual.addItem("Izabal","18");
		listDeptoDireccionActual.addItem("Zacapa","19");
		listDeptoDireccionActual.addItem("Chiquimula","20");
		listDeptoDireccionActual.addItem("Santa Rosa","06");
		listDeptoDireccionActual.addItem("Jalapa","21");
		listDeptoDireccionActual.addItem("Jutiapa","22");
		listDeptoDireccionActual.addItem("Sacatepequez","03");
		listDeptoDireccionActual.addItem("Chimaltenango","04");
		listDeptoDireccionActual.addItem("Escuintla","05");
		listDeptoDireccionActual.addItem("Solola","07");
		listDeptoDireccionActual.addItem("Totonicapan","08");
		listDeptoDireccionActual.addItem("Quezaltenango","09");
		listDeptoDireccionActual.addItem("Suchitepequez","10");
		listDeptoDireccionActual.addItem("Retalhuleu","11");
		listDeptoDireccionActual.addItem("San Marcos","12");
		listDeptoDireccionActual.addItem("Huehuetenango","13");
		listDeptoDireccionActual.addItem("Quiche","14");
		listDeptoDireccionActual.addItem("Peten","17");
		listDeptoDireccionActual.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDeptoDireccionActual, 836, 246);
		listDeptoDireccionActual.setSize("130px", "27px");
		
		listMunicipioDireccionActual = new ListBox();
		listMunicipioDireccionActual.addItem("[-]","0");
		listMunicipioDireccionActual.setStyleName("gwt-TextBox2");
		absolutePanel.add(listMunicipioDireccionActual, 982, 246);
		listMunicipioDireccionActual.setSize("130px", "27px");
		
		// Depto-Mun Direccion Solucion
		
		listDeptoDireccionSolucion = new ListBox();
		listDeptoDireccionSolucion.addItem("-","-1");
		listDeptoDireccionSolucion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listMunicipioDireccionSolucion.clear();
		        String[] numerosComoArray = Depto_Municipio(listDeptoDireccionSolucion.getItemText(listDeptoDireccionSolucion.getSelectedIndex())).split(",");
		        int correlativo = Integer.parseInt(listDeptoDireccionSolucion.getValue(listDeptoDireccionSolucion.getSelectedIndex())+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	listMunicipioDireccionSolucion.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }
			}
		});
		listDeptoDireccionSolucion.addItem("Guatemala","01");
		listDeptoDireccionSolucion.addItem("Baja Verapaz","15");
		listDeptoDireccionSolucion.addItem("Alta Verapaz","16");
		listDeptoDireccionSolucion.addItem("El Progreso","02");
		listDeptoDireccionSolucion.addItem("Izabal","18");
		listDeptoDireccionSolucion.addItem("Zacapa","19");
		listDeptoDireccionSolucion.addItem("Chiquimula","20");
		listDeptoDireccionSolucion.addItem("Santa Rosa","06");
		listDeptoDireccionSolucion.addItem("Jalapa","21");
		listDeptoDireccionSolucion.addItem("Jutiapa","22");
		listDeptoDireccionSolucion.addItem("Sacatepequez","03");
		listDeptoDireccionSolucion.addItem("Chimaltenango","04");
		listDeptoDireccionSolucion.addItem("Escuintla","05");
		listDeptoDireccionSolucion.addItem("Solola","07");
		listDeptoDireccionSolucion.addItem("Totonicapan","08");
		listDeptoDireccionSolucion.addItem("Quezaltenango","09");
		listDeptoDireccionSolucion.addItem("Suchitepequez","10");
		listDeptoDireccionSolucion.addItem("Retalhuleu","11");
		listDeptoDireccionSolucion.addItem("San Marcos","12");
		listDeptoDireccionSolucion.addItem("Huehuetenango","13");
		listDeptoDireccionSolucion.addItem("Quiche","14");
		listDeptoDireccionSolucion.addItem("Peten","17");
		listDeptoDireccionSolucion.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDeptoDireccionSolucion, 836, 320);
		listDeptoDireccionSolucion.setSize("130px", "27px");
		
		listMunicipioDireccionSolucion = new ListBox();
		listMunicipioDireccionSolucion.addItem("-","-1");
		listMunicipioDireccionSolucion.setStyleName("gwt-TextBox2");
		absolutePanel.add(listMunicipioDireccionSolucion, 982, 320);
		listMunicipioDireccionSolucion.setSize("130px", "27px");
		
		txtDireccionLugarTrabajoSolicitante = new TextBox();
		txtDireccionLugarTrabajoSolicitante.setStyleName("gwt-TextBox2");
		txtDireccionLugarTrabajoSolicitante.setMaxLength(200);
		absolutePanel.add(txtDireccionLugarTrabajoSolicitante, 272, 468);
		txtDireccionLugarTrabajoSolicitante.setSize("558px", "19px");
		
		txtDireccionLugarTrabajoConyuge = new TextBox();
		txtDireccionLugarTrabajoConyuge.setStyleName("gwt-TextBox2");
		txtDireccionLugarTrabajoConyuge.setMaxLength(200);
		absolutePanel.add(txtDireccionLugarTrabajoConyuge, 272, 686);
		txtDireccionLugarTrabajoConyuge.setSize("558px", "19px");
		
		
		// --- Boton Guardar - Data Formulario Solicitud
		
		btnGuardar = new Button("New button");
		
		if(this.valor) {
			btnGuardar.setVisible(true);
		}else{
			btnGuardar.setVisible(false);
		}
		
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
//					int dpi = 0;
//					dpi = Integer.parseInt(dpiValue);
					
					// Comentado para validez de no. DPI en un solo campo
					
//					String dpiUnicoValue = txtNumDpiUnico.getText();
					int dpiUnico = 0;
//					dpiUnico = Integer.parseInt(dpiUnicoValue);
//
//					String dpiReferenciaValue = txtNumDpiReferencia.getText();
					int dpiReferencia = 0;
//					dpiReferencia = Integer.parseInt(dpiReferenciaValue);

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
					
					String aldeaDireccionActual = "";		
					if(txtAldeaDireccionActual.getText() == null){
						aldeaDireccionActual = "";
					}else{
						aldeaDireccionActual = txtAldeaDireccionActual.getText();
					}
					
					String aldeaDireccionSolucion = "";		
					if(txtAldeaDireccionSolucion.getText() == null){
						aldeaDireccionSolucion = "";
					}else{
						aldeaDireccionSolucion = txtAldeaDireccionSolucion.getText();
					}
					
					deptoMunicipioDireccionActual = listDeptoDireccionActual.getValue(listDeptoDireccionActual.getSelectedIndex()) + "," +listMunicipioDireccionActual.getValue(listMunicipioDireccionActual.getSelectedIndex());
					deptoMunicipioDireccionSolucion = listDeptoDireccionSolucion.getValue(listDeptoDireccionSolucion.getSelectedIndex()) + "," +listMunicipioDireccionSolucion.getValue(listMunicipioDireccionSolucion.getSelectedIndex());
					
					String direccionLugarTrabajoSolicitante = "";		
					if(txtDireccionLugarTrabajoSolicitante.getText() == null){
						direccionLugarTrabajoSolicitante = "";
					}else{
						direccionLugarTrabajoSolicitante = txtDireccionLugarTrabajoSolicitante.getText();
					}
					
					String direccionLugarTrabajoConyuge = "";		
					if(txtDireccionLugarTrabajoConyuge.getText() == null){
						direccionLugarTrabajoConyuge = "";
					}else{
						direccionLugarTrabajoConyuge = txtDireccionLugarTrabajoConyuge.getText();
					}
					
					Boolean creditoAprobado = false;
					Boolean creditoNoAprobado = false;
					float montoAprobado = 0;
					String observacionNoAprobado = "";
					Boolean primeraSupervision = false;
					Boolean segundaSupervision = false;
					Boolean terceraSupervision = false;
					Boolean cuartaSupervision = false;
					
					if(idEmpleado != 0){
						
						System.out.println("Valor Retornado Id Empleado: " + idEmpleado + ", Nombre de Usuario: " + usrName);

						// Modulo Soluciones //-- CAMBIAR Y QUITAR COMENTARIO AL REALIZAR VALIDACIÓN
						
//						if(idAfiliado != 0){
//							System.out.println("Valor Retornado Id Afiliado: " + idAfiliado);
							

							if(bandera){

								Date time = new Date();
								@SuppressWarnings("deprecation")
								Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());
								
								solucionesService.ingresarDatosSolicitante(idEmpleado, idAfiliado, usrName,
										fecrec, 
										nombreSolicitante, estadoCivil, edad, nacionalidad, 
										profesionOficio, dpiValue, dpiUnico, dpiReferencia, actividadEconomica,   // Comentado para validez de no. DPI en un solo campo
										sabeLeer, sabeEscribir, sabeFirmar, 
										direccionActual, direccionSolucion,
										camion, carro, peatonal,
										lugarTrabajoSolicitante, telefonoCasaSolicitante, telefonoTrabajoSolicitante,
										solucionConstruir, cuotaPagar,
										nombreConyuge, telefonoConyuge, lugarTrabajoConyuge, telefonoTrabajoConyuge,
										creditoAprobado, creditoNoAprobado, montoAprobado, observacionNoAprobado,
										primeraSupervision, segundaSupervision, terceraSupervision, cuartaSupervision,
										aldeaDireccionActual, aldeaDireccionSolucion,
										deptoMunicipioDireccionActual, deptoMunicipioDireccionSolucion,
										direccionLugarTrabajoSolicitante, direccionLugarTrabajoConyuge,
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
										formulario.habilitarPestanasNuevo();
									}
								});

							}else{

								Date time = new Date();
								@SuppressWarnings("deprecation")
								Date fecupdate = new Date(time.getYear(),time.getMonth(),time.getDate());
								
								solucionesService.actualizarDatosSolicitante(idFormulario, idEmpleado, idAfiliado, usrName,
										fecupdate,
										nombreSolicitante, estadoCivil, edad, nacionalidad, 
										profesionOficio, dpiValue, dpiUnico, dpiReferencia, actividadEconomica,			// Comentado para validez de no. DPI en un solo campo
										sabeLeer, sabeEscribir, sabeFirmar, 
										direccionActual, direccionSolucion,
										camion, carro, peatonal,
										lugarTrabajoSolicitante, telefonoCasaSolicitante, telefonoTrabajoSolicitante,
										solucionConstruir, cuotaPagar,
										nombreConyuge, telefonoConyuge, lugarTrabajoConyuge, telefonoTrabajoConyuge,
										aldeaDireccionActual, aldeaDireccionSolucion,
										deptoMunicipioDireccionActual, deptoMunicipioDireccionSolucion,
										direccionLugarTrabajoSolicitante, direccionLugarTrabajoConyuge,
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

							// Modulo Soluciones //-- CAMBIAR Y QUITAR COMENTARIO AL REALIZAR VALIDACIÓN
							
//						}else{
//							mensaje.setMensaje("alert alert-error", "El empleado actual no tiene Afiliado");							
//						}
					
					
					}else{
						mensaje.setMensaje("alert alert-error", "Error en retornar ID de Empleado");
					}
					
				}
			}
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		btnGuardar.setSize("198px", "41px");
		absolutePanel.add(btnGuardar, 485, 728);
		btnGuardar.setTabIndex(25);
		
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
			String profesionOficio, String dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
			String aldeaDireccionActual, String aldeaDireccionSolucion,
			String deptoDireccionActual, String municipioDireccionActual, String deptoDireccionSolucion, String municipioDireccionSolucion,
			String direccionLugarTrabajoSolicitante, String direccionLugarTrabajoConyuge)
	{
    	
		this.bandera = false;
		
		this.idFormulario = idFormulario; // ID Formulario Cargado
		
		this.txtNombreSolicitante.setText(nombreSolicitante);
		String edadValue = ""+edad;
		this.txtEdad.setText(edadValue);
		this.txtProfesionOficio.setText(profesionOficio);
		this.txtActividadEconomica.setText(actividadEconomica);
		String dpiValue = ""+dpi;
		this.txtNumDpi.setText(dpiValue);
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
		
	    this.txtAldeaDireccionActual.setText(aldeaDireccionActual);

	    this.txtAldeaDireccionSolucion.setText(aldeaDireccionSolucion);
	    
        bandera = true;
        for(int i=0; i < this.listDeptoDireccionActual.getItemCount() && bandera; i++){
            bandera = !this.listDeptoDireccionActual.getValue(i).equals(deptoDireccionActual);
            this.listDeptoDireccionActual.setSelectedIndex(i);
        }  
        
        bandera = true;
        for(int i=0; i < this.listDeptoDireccionSolucion.getItemCount() && bandera; i++){
            bandera = !this.listDeptoDireccionSolucion.getValue(i).equals(deptoDireccionSolucion);
            this.listDeptoDireccionSolucion.setSelectedIndex(i);
        }
	    
	    
        this.listMunicipioDireccionActual.clear();
        String[] numerosComoArray = Depto_Municipio(this.listDeptoDireccionActual.getItemText(this.listDeptoDireccionActual.getSelectedIndex())).split(",");
        int correlativo = Integer.parseInt(this.listDeptoDireccionActual.getValue(this.listDeptoDireccionActual.getSelectedIndex())+"01");
        for (int i = 1; i < numerosComoArray.length; i++) {
        	
        	this.listMunicipioDireccionActual.addItem(numerosComoArray[i],String.valueOf(correlativo));
        	correlativo++;
        }

        bandera = true;
        for(int i=0; i < this.listMunicipioDireccionActual.getItemCount() && bandera; i++){
            bandera = !this.listMunicipioDireccionActual.getValue(i).equals(municipioDireccionActual);
            this.listMunicipioDireccionActual.setSelectedIndex(i);
        } 
        
        
        this.listMunicipioDireccionSolucion.clear();
        String[] numerosComoArray2 = Depto_Municipio(this.listDeptoDireccionSolucion.getItemText(this.listDeptoDireccionSolucion.getSelectedIndex())).split(",");
        correlativo = Integer.parseInt(this.listDeptoDireccionSolucion.getValue(this.listDeptoDireccionSolucion.getSelectedIndex())+"01");
        for (int i = 1; i < numerosComoArray2.length; i++) {
        	
        	this.listMunicipioDireccionSolucion.addItem(numerosComoArray2[i],String.valueOf(correlativo));
        	correlativo++;
        }

        bandera = true;
        for(int i=0; i < this.listMunicipioDireccionSolucion.getItemCount() && bandera; i++){
            bandera = !this.listMunicipioDireccionSolucion.getValue(i).equals(municipioDireccionSolucion);
            this.listMunicipioDireccionSolucion.setSelectedIndex(i);
        }
        
        
        this.txtDireccionLugarTrabajoSolicitante.setText(direccionLugarTrabajoSolicitante);
	    
        this.txtDireccionLugarTrabajoConyuge.setText(direccionLugarTrabajoConyuge);
        
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
    	
    	String solucionConstruir = "-1";		
    	solucionConstruir = this.listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex());
    	
    	if(solucionConstruir.equals("-1")){
    		mensaje.setMensaje("alert alert-error", "Debe indicar Solucion a Construir");
    		return false;
    	}
    	
//    	if(this.txtTelefonoCasaSolicitante.getText().equals("0")){
//    		mensaje.setMensaje("alert alert-error", "Debe ingresar Telefono de Casa de Solicitante");
//    		return false;
//    	}
//
//    	if(this.txtTelefonoTrabajoSolicitante.getText().equals("0")){
//    		mensaje.setMensaje("alert alert-error", "Debe ingresar Telefono de Trabajo de Solicitante");
//    		return false;
//    	}
    	
    	return true;    		
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
    
    /**
	 * metodo para obtener los municipios del departamento entrante
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
			
		}else if(Departamento.equals("-")){
			valor = valor + "," + "-";
		}
	
		return valor;
	}
    
}
