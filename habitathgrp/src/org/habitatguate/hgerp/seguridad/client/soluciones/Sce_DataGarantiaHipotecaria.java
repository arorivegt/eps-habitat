package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

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
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.CheckBox;

public class Sce_DataGarantiaHipotecaria extends Composite {
	
    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryGarantiaSolicitud formulario;
	private Sce_DataEntryGarantiaHipotecaria garantiaHipotecaria;
    private boolean bandera = true;
	private Long idGarantiaHipotecaria = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	
	private Label lblIndiquePersona;
	private Label lblNoTelefonoPersona;
	private TextBox txtFolio;
    private TextBox txtEscrituraRegistrada;
    private TextBox txtNombrePersona;
    private TextBox txtLibro;
    private TextBox txtEscrituraNoRegistrada;
    private TextBox txtAreaTerreno;
    private TextBox txtFinca;
    private TextBox txtValorTerreno;
    private TextBox txtTelefonoPersona;
    private TextBox txtNombreNotario;
    private CheckBox checkBoxSi;
    private Button btnGuardar;
    
	private TextBox txtAldeaPersona;
	private Label lblAldeaPersona;
	private ListBox listDepartamentoPersona;
	private Label lblDepartamentoPersona;
	private ListBox listMunicipioPersona;
	private Label lblMunicipioPersona;
	private TextBox txtDireccionTerrenoPersona;
	private Label lblDireccionTerrenoPersona;
	private TextBox txtNumDpiPersona;
	private Label lblNumDpiPersona;
    
	private String deptoMunicipioDireccionPersona = "";
	private String deptoMunicipioDireccionGarantia = "";
    
	// Valor Escritura-Lectura
	private boolean valor;    
	private Label lblDireccionTerrenoGarantia;
	private TextBox txtDireccionTerrenoGarantia;
	private TextBox txtAldeaGarantia;
	private Label lblAldeaGarantia;
	private ListBox listDepartamentoGarantia;
	private Label lblDepartamentoGarantia;
	private ListBox listMunicipioGarantia;
	private Label lblMunicipioGarantia;
    
	public Sce_DataGarantiaHipotecaria(Sce_DataEntryGarantiaHipotecaria a, Sce_DataEntryGarantiaSolicitud e, boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.garantiaHipotecaria = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1135px", "621px");
		
		Label lblNombres = new Label("Escritura p\u00FAblica NO registrada n\u00FAmero:");
		lblNombres.setStyleName("label");
		absolutePanel.add(lblNombres, 42, 30);
		lblNombres.setSize("297px", "19px");
		
		Label lblDireccionActual = new Label("\u00C1rea del terreno en mt2:");
		lblDireccionActual.setStyleName("label");
		absolutePanel.add(lblDireccionActual, 42, 221);
		lblDireccionActual.setSize("240px", "19px");
		
		Label lblNumeroDeTelefonoCelular = new Label("No. de Libro:");
		lblNumeroDeTelefonoCelular.setStyleName("label");
		absolutePanel.add(lblNumeroDeTelefonoCelular, 637, 66);
		lblNumeroDeTelefonoCelular.setSize("118px", "19px");
		
		Label lblNumeroDeTelefono = new Label("No. Folio:");
		lblNumeroDeTelefono.setStyleName("label");
		absolutePanel.add(lblNumeroDeTelefono, 521, 66);
		lblNumeroDeTelefono.setSize("117px", "19px");
		
		Label lblEstadoCivil = new Label("Escritura p\u00FAblica Registrada n\u00FAmero:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 42, 101);
		lblEstadoCivil.setSize("291px", "19px");
		
		Label lblProfesionUOficio = new Label("Valor estima del terreno Q.:");
		lblProfesionUOficio.setStyleName("label");
		absolutePanel.add(lblProfesionUOficio, 42, 268);
		lblProfesionUOficio.setSize("240px", "19px");
		
		Label lblLugarDeTrabajo = new Label("El terreno est\u00E1 a nombre de otra persona:");
		lblLugarDeTrabajo.setStyleName("label");
		absolutePanel.add(lblLugarDeTrabajo, 42, 375);
		lblLugarDeTrabajo.setSize("323px", "19px");
		
		lblIndiquePersona = new Label("Si su respuesta es afirmativa, por favor indique el nombre de la persona:");
		lblIndiquePersona.setStyleName("label");
		absolutePanel.add(lblIndiquePersona, 42, 424);
		lblIndiquePersona.setSize("550px", "19px");
		
		Label lblNoDeFinca = new Label("No. de Finca:");
		lblNoDeFinca.setStyleName("label");
		absolutePanel.add(lblNoDeFinca, 761, 66);
		lblNoDeFinca.setSize("118px", "19px");
		
		lblNoTelefonoPersona = new Label("No. tel\u00E9fono persona:");
		lblNoTelefonoPersona.setStyleName("label");
		absolutePanel.add(lblNoTelefonoPersona, 42, 477);
		lblNoTelefonoPersona.setSize("240px", "19px");
		
		Label lblNotario = new Label("Nombre Notario:");
		lblNotario.setStyleName("label");
		absolutePanel.add(lblNotario, 42, 161);
		lblNotario.setSize("240px", "19px");
		
		lblAldeaPersona = new Label("Aldea:");
		lblAldeaPersona.setStyleName("label");
		absolutePanel.add(lblAldeaPersona, 632, 491);
		lblAldeaPersona.setSize("83px", "19px");
		
		lblDepartamentoPersona = new Label("Departamento:");
		lblDepartamentoPersona.setStyleName("label");
		absolutePanel.add(lblDepartamentoPersona, 811, 491);
		lblDepartamentoPersona.setSize("130px", "19px");
		
		lblMunicipioPersona = new Label("Municipio:");
		lblMunicipioPersona.setStyleName("label");
		absolutePanel.add(lblMunicipioPersona, 996, 489);
		lblMunicipioPersona.setSize("101px", "19px");
		
		lblDireccionTerrenoPersona = new Label("Direccion Terreno:");
		lblDireccionTerrenoPersona.setStyleName("label");
		absolutePanel.add(lblDireccionTerrenoPersona, 42, 522);
		lblDireccionTerrenoPersona.setSize("181px", "19px");
		
		lblNumDpiPersona = new Label("Num. DPI:");
		lblNumDpiPersona.setStyleName("label");
		absolutePanel.add(lblNumDpiPersona, 1047, 397);
		lblNumDpiPersona.setSize("101px", "19px");
		
		lblDireccionTerrenoGarantia = new Label("Direccion Terreno:");
		lblDireccionTerrenoGarantia.setStyleName("label");
		absolutePanel.add(lblDireccionTerrenoGarantia, 42, 328);
		lblDireccionTerrenoGarantia.setSize("181px", "19px");
		
		lblAldeaGarantia = new Label("Aldea:");
		lblAldeaGarantia.setStyleName("label");
		absolutePanel.add(lblAldeaGarantia, 632, 297);
		lblAldeaGarantia.setSize("83px", "19px");

		lblDepartamentoGarantia = new Label("Departamento:");
		lblDepartamentoGarantia.setStyleName("label");
		absolutePanel.add(lblDepartamentoGarantia, 811, 297);
		lblDepartamentoGarantia.setSize("130px", "19px");

		lblMunicipioGarantia = new Label("Municipio:");
		lblMunicipioGarantia.setStyleName("label");
		absolutePanel.add(lblMunicipioGarantia, 996, 295);
		lblMunicipioGarantia.setSize("101px", "19px");
		
		txtEscrituraNoRegistrada = new TextBox();
		txtEscrituraNoRegistrada.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEscrituraNoRegistrada, 353, 30);
		txtEscrituraNoRegistrada.setSize("143px", "19px");
		txtEscrituraNoRegistrada.setTabIndex(1);
		
		txtEscrituraRegistrada = new TextBox();
		txtEscrituraRegistrada.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEscrituraRegistrada, 353, 99);
		txtEscrituraRegistrada.setSize("143px", "19px");
		txtEscrituraRegistrada.setTabIndex(2);
		
		txtFolio = new TextBox();
		txtFolio.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtFolio .getText().equals("")) {
					txtFolio .setText("0");
				}
				else if(txtFolio .getText().equals(null)) {
					txtFolio .setText("0");
				}
				else{
					try{
						Integer.parseInt(txtFolio.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtFolio .setText("0");
					}
				}
			}
		});			
		txtFolio.setText("0");
		txtFolio.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtFolio, 521, 99);
		txtFolio.setSize("80px", "19px");
		txtFolio.setTabIndex(3);
		
		txtLibro = new TextBox();
		txtLibro.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtLibro .getText().equals("")) {
					txtLibro .setText("0");
				}
				else if(txtLibro .getText().equals(null)) {
					txtLibro .setText("0");
				}
				else{
					try{
						Integer.parseInt(txtLibro.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtLibro .setText("0");
					}
				}
			}
		});			
		txtLibro.setText("0");
		txtLibro.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtLibro, 637, 99);
		txtLibro.setSize("80px", "19px");
		txtLibro.setTabIndex(4);
		
		txtFinca = new TextBox();
		txtFinca.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtFinca .getText().equals("")) {
					txtFinca .setText("0");
				}
				else if(txtFinca .getText().equals(null)) {
					txtFinca .setText("0");
				}
				else{
					try{
						Integer.parseInt(txtFinca.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtFinca .setText("0");
					}
				}
			}
		});				
		txtFinca.setText("0");
		txtFinca.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtFinca, 756, 99);
		txtFinca.setSize("80px", "19px");
		txtFinca.setTabIndex(5);
		
		txtNombreNotario = new TextBox();
		txtNombreNotario.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtNombreNotario);
				
			}
		});
		txtNombreNotario.setStyleName("gwt-TextBox2");
		txtNombreNotario.setMaxLength(200);
		absolutePanel.add(txtNombreNotario, 207, 159);
		txtNombreNotario.setSize("414px", "19px");
		txtNombreNotario.setTabIndex(6);
				
		txtAreaTerreno = new TextBox();
		txtAreaTerreno.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtAreaTerreno .getText().equals("")) {
					txtAreaTerreno .setText("0.0");
				}
				else if(txtAreaTerreno .getText().equals(null)) {
					txtAreaTerreno .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtAreaTerreno.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtAreaTerreno .setText("0.0");
					}
				}
			}
		});					
		txtAreaTerreno.setText("0.0");
		txtAreaTerreno.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtAreaTerreno, 256, 221);
		txtAreaTerreno.setSize("90px", "19px");
		txtAreaTerreno.setTabIndex(7);
		
		txtValorTerreno = new TextBox();
		txtValorTerreno.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtValorTerreno .getText().equals("")) {
					txtValorTerreno .setText("0.0");
				}
				else if(txtValorTerreno .getText().equals(null)) {
					txtValorTerreno .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtValorTerreno.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtValorTerreno .setText("0.0");
					}
				}
			}
		});			
		txtValorTerreno.setText("0.0");
		txtValorTerreno.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtValorTerreno, 256, 268);
		txtValorTerreno.setSize("90px", "19px");
		txtValorTerreno.setTabIndex(8);
		
		txtNombrePersona = new TextBox();
		txtNombrePersona.addChangeHandler(new ChangeHandler(){
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtNombrePersona);
				
			}
		});
		txtNombrePersona.setStyleName("gwt-TextBox2");
		txtNombrePersona.setMaxLength(200);
		absolutePanel.add(txtNombrePersona, 580, 424);
		txtNombrePersona.setSize("425px", "19px");
		txtNombrePersona.setTabIndex(10);
		
		txtTelefonoPersona = new TextBox();
		txtTelefonoPersona.setMaxLength(8);
		txtTelefonoPersona.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoPersona .getText().equals("")) {
					txtTelefonoPersona .setText("0");
				}
				else if(txtTelefonoPersona .getText().equals(null)) {
					txtTelefonoPersona .setText("0");
				}
				else{
					try{
						Integer.parseInt(txtTelefonoPersona.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtTelefonoPersona .setText("0");
					}
				}
			}
		});			
		txtTelefonoPersona.setText("0");
		txtTelefonoPersona.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoPersona, 207, 475);
		txtTelefonoPersona.setSize("90px", "19px");
		txtTelefonoPersona.setTabIndex(11);
		
		txtAldeaPersona = new TextBox();
		txtAldeaPersona.setStyleName("gwt-TextBox2");
		txtAldeaPersona.setMaxLength(200);
		absolutePanel.add(txtAldeaPersona, 632, 522);
		txtAldeaPersona.setSize("152px", "19px");
		
		listDepartamentoPersona = new ListBox();
		listDepartamentoPersona.addItem("-","-1");
		listDepartamentoPersona.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listMunicipioPersona.clear();
		        String[] numerosComoArray = Depto_Municipio(listDepartamentoPersona.getItemText(listDepartamentoPersona.getSelectedIndex())).split(",");
		        int correlativo = Integer.parseInt(listDepartamentoPersona.getValue(listDepartamentoPersona.getSelectedIndex())+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	listMunicipioPersona.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }

		        listMunicipioPersona.setSelectedIndex(2);
			}
		});
		listDepartamentoPersona.addItem("Guatemala","01");
		listDepartamentoPersona.addItem("Baja Verapaz","15");
		listDepartamentoPersona.addItem("Alta Verapaz","16");
		listDepartamentoPersona.addItem("El Progreso","02");
		listDepartamentoPersona.addItem("Izabal","18");
		listDepartamentoPersona.addItem("Zacapa","19");
		listDepartamentoPersona.addItem("Chiquimula","20");
		listDepartamentoPersona.addItem("Santa Rosa","06");
		listDepartamentoPersona.addItem("Jalapa","21");
		listDepartamentoPersona.addItem("Jutiapa","22");
		listDepartamentoPersona.addItem("Sacatepequez","03");
		listDepartamentoPersona.addItem("Chimaltenango","04");
		listDepartamentoPersona.addItem("Escuintla","05");
		listDepartamentoPersona.addItem("Solola","07");
		listDepartamentoPersona.addItem("Totonicapan","08");
		listDepartamentoPersona.addItem("Quezaltenango","09");
		listDepartamentoPersona.addItem("Suchitepequez","10");
		listDepartamentoPersona.addItem("Retalhuleu","11");
		listDepartamentoPersona.addItem("San Marcos","12");
		listDepartamentoPersona.addItem("Huehuetenango","13");
		listDepartamentoPersona.addItem("Quiche","14");
		listDepartamentoPersona.addItem("Peten","17");
		listDepartamentoPersona.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDepartamentoPersona, 811, 516);
		listDepartamentoPersona.setSize("145px", "27px");
		
		listMunicipioPersona = new ListBox();
		listMunicipioPersona.addItem("-","-1");
		listMunicipioPersona.setStyleName("gwt-TextBox2");
		absolutePanel.add(listMunicipioPersona, 996, 514);
		listMunicipioPersona.setSize("145px", "27px");
		
		txtDireccionTerrenoPersona = new TextBox();
		txtDireccionTerrenoPersona.setTabIndex(11);
		txtDireccionTerrenoPersona.setStyleName("gwt-TextBox2");
		txtDireccionTerrenoPersona.setMaxLength(200);
		absolutePanel.add(txtDireccionTerrenoPersona, 204, 522);
		txtDireccionTerrenoPersona.setSize("398px", "19px");
		
		txtNumDpiPersona = new TextBox();
		txtNumDpiPersona.setMaxLength(13);
		txtNumDpiPersona.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {			
				String input = txtNumDpiPersona.getText();			
				if(txtNumDpiPersona.getText().equals("")) {txtNumDpiPersona.setText("0");}
				else if(txtNumDpiPersona.getText().equals(null)) {txtNumDpiPersona.setText("0");}
				
				else if (!input.matches("[0-9]*")) {
	            // show some error
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nNumero no valido");
				txtNumDpiPersona.setText("0");	      
				}			
				else{
					 System.out.println("Exito");
				}
			}
		});	
		txtNumDpiPersona.setText("0");
		txtNumDpiPersona.setTabIndex(6);
		txtNumDpiPersona.setStyleName("gwt-TextBox2");
		txtNumDpiPersona.setMaxLength(13);
		absolutePanel.add(txtNumDpiPersona, 1047, 422);
		txtNumDpiPersona.setSize("116px", "19px");
		
		txtDireccionTerrenoGarantia = new TextBox();
		txtDireccionTerrenoGarantia.setTabIndex(11);
		txtDireccionTerrenoGarantia.setStyleName("gwt-TextBox2");
		txtDireccionTerrenoGarantia.setMaxLength(200);
		absolutePanel.add(txtDireccionTerrenoGarantia, 204, 328);
		txtDireccionTerrenoGarantia.setSize("398px", "19px");
		
		txtAldeaGarantia = new TextBox();
		txtAldeaGarantia.setStyleName("gwt-TextBox2");
		txtAldeaGarantia.setMaxLength(200);
		absolutePanel.add(txtAldeaGarantia, 632, 328);
		txtAldeaGarantia.setSize("152px", "19px");
		
		listDepartamentoGarantia = new ListBox();
		listDepartamentoGarantia.addItem("-","-1");
		listDepartamentoGarantia.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listMunicipioGarantia.clear();
		        String[] numerosComoArray = Depto_Municipio(listDepartamentoGarantia.getItemText(listDepartamentoGarantia.getSelectedIndex())).split(",");
		        int correlativo = Integer.parseInt(listDepartamentoGarantia.getValue(listDepartamentoGarantia.getSelectedIndex())+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	listMunicipioGarantia.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }

		        listMunicipioGarantia.setSelectedIndex(2);
			}
		});
		listDepartamentoGarantia.addItem("Guatemala","01");
		listDepartamentoGarantia.addItem("Baja Verapaz","15");
		listDepartamentoGarantia.addItem("Alta Verapaz","16");
		listDepartamentoGarantia.addItem("El Progreso","02");
		listDepartamentoGarantia.addItem("Izabal","18");
		listDepartamentoGarantia.addItem("Zacapa","19");
		listDepartamentoGarantia.addItem("Chiquimula","20");
		listDepartamentoGarantia.addItem("Santa Rosa","06");
		listDepartamentoGarantia.addItem("Jalapa","21");
		listDepartamentoGarantia.addItem("Jutiapa","22");
		listDepartamentoGarantia.addItem("Sacatepequez","03");
		listDepartamentoGarantia.addItem("Chimaltenango","04");
		listDepartamentoGarantia.addItem("Escuintla","05");
		listDepartamentoGarantia.addItem("Solola","07");
		listDepartamentoGarantia.addItem("Totonicapan","08");
		listDepartamentoGarantia.addItem("Quezaltenango","09");
		listDepartamentoGarantia.addItem("Suchitepequez","10");
		listDepartamentoGarantia.addItem("Retalhuleu","11");
		listDepartamentoGarantia.addItem("San Marcos","12");
		listDepartamentoGarantia.addItem("Huehuetenango","13");
		listDepartamentoGarantia.addItem("Quiche","14");
		listDepartamentoGarantia.addItem("Peten","17");
		listDepartamentoGarantia.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDepartamentoGarantia, 811, 322);
		listDepartamentoGarantia.setSize("145px", "27px");
		
		listMunicipioGarantia = new ListBox();
		listMunicipioGarantia.addItem("-","-1");
		listMunicipioGarantia.setStyleName("gwt-TextBox2");
		absolutePanel.add(listMunicipioGarantia, 996, 320);
		listMunicipioGarantia.setSize("145px", "27px");
		
		
		checkBoxSi = new CheckBox("");
		checkBoxSi.addClickHandler(new ClickHandler() 
		{
		    public void onClick(ClickEvent event) 
		    {
		        if(checkBoxSi.isChecked()){
		        	lblIndiquePersona.setVisible(true);
		        	lblNoTelefonoPersona.setVisible(true);
		        	lblNumDpiPersona.setVisible(true);
		        	lblDireccionTerrenoPersona.setVisible(true);
		        	lblAldeaPersona.setVisible(true);
		        	lblDepartamentoPersona.setVisible(true);
		        	lblMunicipioPersona.setVisible(true);
					txtNombrePersona.setVisible(true);
					txtTelefonoPersona.setVisible(true);
					txtNumDpiPersona.setVisible(true);
					txtDireccionTerrenoPersona.setVisible(true);
					txtAldeaPersona.setVisible(true);
					listDepartamentoPersona.setVisible(true);
					listMunicipioPersona.setVisible(true);
		        }else{
		        	lblIndiquePersona.setVisible(false);
					lblNoTelefonoPersona.setVisible(false);
					lblNumDpiPersona.setVisible(false);
		        	lblDireccionTerrenoPersona.setVisible(false);
		        	lblAldeaPersona.setVisible(false);
		        	lblDepartamentoPersona.setVisible(false);
		        	lblMunicipioPersona.setVisible(false);
					txtNombrePersona.setVisible(false);
					txtNombrePersona.setValue("");
					txtTelefonoPersona.setVisible(false);
					txtTelefonoPersona.setValue("0");
					txtNumDpiPersona.setVisible(false);
					txtNumDpiPersona.setValue("0");
					txtDireccionTerrenoPersona.setVisible(false);
					txtDireccionTerrenoPersona.setValue("");
					txtAldeaPersona.setVisible(false);
					txtAldeaPersona.setValue("");
					listDepartamentoPersona.setVisible(false);
//					listDepartamentoPersona.setValue(-1,"-");
					listMunicipioPersona.setVisible(false);
//					listMunicipioPersona.setValue(-1,"-");
		        }
		    }
		});
		absolutePanel.add(checkBoxSi, 418, 370);
		checkBoxSi.setTabIndex(9);
		
        if(checkBoxSi.isChecked()){
        	lblIndiquePersona.setVisible(true);
        	lblNoTelefonoPersona.setVisible(true);
        	lblNumDpiPersona.setVisible(true);
        	lblDireccionTerrenoPersona.setVisible(true);
        	lblAldeaPersona.setVisible(true);
        	lblDepartamentoPersona.setVisible(true);
        	lblMunicipioPersona.setVisible(true);
			txtNombrePersona.setVisible(true);
			txtTelefonoPersona.setVisible(true);
			txtNumDpiPersona.setVisible(true);
			txtDireccionTerrenoPersona.setVisible(true);
			txtAldeaPersona.setVisible(true);
			listDepartamentoPersona.setVisible(true);
			listMunicipioPersona.setVisible(true);
			
        }else{
        	lblIndiquePersona.setVisible(false);
			lblNoTelefonoPersona.setVisible(false);
			lblNumDpiPersona.setVisible(false);
        	lblDireccionTerrenoPersona.setVisible(false);
        	lblAldeaPersona.setVisible(false);
        	lblDepartamentoPersona.setVisible(false);
        	lblMunicipioPersona.setVisible(false);
			txtNombrePersona.setVisible(false);
			txtNombrePersona.setValue("");
			txtTelefonoPersona.setVisible(false);
			txtTelefonoPersona.setValue("0");
			txtNumDpiPersona.setVisible(false);
			txtNumDpiPersona.setValue("0");
			txtDireccionTerrenoPersona.setVisible(false);
			txtDireccionTerrenoPersona.setValue("");
			txtAldeaPersona.setVisible(false);
			txtAldeaPersona.setValue("");
			listDepartamentoPersona.setVisible(false);
//			listDepartamentoPersona.setValue(-1,"-");
			listMunicipioPersona.setVisible(false);
//			listMunicipioPersona.setValue(-1,"-");
        }
        
		
		// --- Boton Guardar
		
		btnGuardar = new Button("Send");
		
		if(this.valor) {
			btnGuardar.setVisible(true);
		}else{
			btnGuardar.setVisible(false);
		}
		
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				String escrituraNoRegistrada = "";		
				if(txtEscrituraNoRegistrada.getText() == null){
					escrituraNoRegistrada = "";
				}else{
					escrituraNoRegistrada = txtEscrituraNoRegistrada.getText();
				}

				String escrituraRegistrada = "";		
				if(txtEscrituraRegistrada.getText() == null){
					escrituraRegistrada = "";
				}else{
					escrituraRegistrada = txtEscrituraRegistrada.getText();
				}

				String folio = "0";		
				if(txtFolio.getText() == null){
					folio = "";
				}else{
					folio = txtFolio.getText();
				}

				String libro = "0";		
				if(txtLibro.getText() == null){
					libro = "";
				}else{
					libro = txtLibro.getText();
				}

				String finca = "0";		
				if(txtFinca.getText() == null){
					finca = "";
				}else{
					finca = txtFinca.getText();
				}

				String nombreNotario = "";		
				if(txtNombreNotario.getText() == null){
					nombreNotario = "";
				}else{
					nombreNotario = txtNombreNotario.getText();
				}

				float areaTerreno = 0;
				areaTerreno = Float.parseFloat(txtAreaTerreno.getText());
				
				float valorTerreno = 0;
				valorTerreno = Float.parseFloat(txtValorTerreno.getText());

				Boolean checkSi = false;
				checkSi = checkBoxSi.getValue();

				Boolean checkNo = false;
//				checkNo = checkBoxNo.getValue();
				checkNo = false;

				String nombrePersona = "";		
				if(txtNombrePersona.getText() == null){
					nombrePersona = "";
				}else{
					nombrePersona = txtNombrePersona.getText();
				}

				String telefonoPersonaValue = txtTelefonoPersona.getText();
				int telefonoPersona = 0;
				telefonoPersona = Integer.parseInt(telefonoPersonaValue);
				
				String dpiValue = txtNumDpiPersona.getText();

				String direccionTerrenoPersona = "";		
				if(txtDireccionTerrenoPersona.getText() == null){
					direccionTerrenoPersona = "";
				}else{
					direccionTerrenoPersona = txtDireccionTerrenoPersona.getText();
				}
				
				String aldeaPersona = "";		
				if(txtAldeaPersona.getText() == null){
					aldeaPersona = "";
				}else{
					aldeaPersona = txtAldeaPersona.getText();
				}
				
				String direccionTerrenoGarantia = "";		
				if(txtDireccionTerrenoGarantia.getText() == null){
					direccionTerrenoGarantia = "";
				}else{
					direccionTerrenoGarantia = txtDireccionTerrenoGarantia.getText();
				}
				
				String aldeaGarantia = "";		
				if(txtAldeaGarantia.getText() == null){
					aldeaGarantia = "";
				}else{
					aldeaGarantia = txtAldeaGarantia.getText();
				}
				
				deptoMunicipioDireccionPersona = listDepartamentoPersona.getValue(listDepartamentoPersona.getSelectedIndex()) + "," +listMunicipioPersona.getValue(listMunicipioPersona.getSelectedIndex());

				deptoMunicipioDireccionGarantia = listDepartamentoGarantia.getValue(listDepartamentoGarantia.getSelectedIndex()) + "," +listMunicipioGarantia.getValue(listMunicipioGarantia.getSelectedIndex());
				
				if(bandera){

					Boolean actualizacionGarantia = true;

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.ingresarGarantiaHipotecaria(fecrec, formulario.idFormulario, 
							escrituraNoRegistrada, escrituraRegistrada, folio, libro, finca, 
							nombreNotario, areaTerreno, valorTerreno, 
							checkSi, checkNo, 
							nombrePersona, telefonoPersona, 
							actualizacionGarantia,
							dpiValue, direccionTerrenoPersona, aldeaPersona, deptoMunicipioDireccionPersona,
							direccionTerrenoGarantia, aldeaGarantia, deptoMunicipioDireccionGarantia,
							new AsyncCallback<Long>() {


						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idGarantiaHipotecaria = result;
							System.out.println("Valor de NUEVA Garantia Hipotecaria: " + idGarantiaHipotecaria);
							bandera = false;
							
						}
					});

				}else {

					solucionesService.actualizarGarantiaHipotecaria(formulario.idFormulario, idGarantiaHipotecaria, 
							escrituraNoRegistrada, escrituraRegistrada, folio, libro, finca, 
							nombreNotario, areaTerreno, valorTerreno, 
							checkSi, checkNo, 
							nombrePersona, telefonoPersona,
							dpiValue, direccionTerrenoPersona, aldeaPersona, deptoMunicipioDireccionPersona,
							direccionTerrenoGarantia, aldeaGarantia, deptoMunicipioDireccionGarantia,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de Garantia Hipotecaria Actualizado: " + idGarantiaHipotecaria );
							bandera = false;

						}
					});
					
				}
				
			}
		});
		btnGuardar.setText("Guardar");	
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		btnGuardar.setSize("198px", "41px");
		absolutePanel.add(btnGuardar, 493, 587);
		btnGuardar.setTabIndex(12);
		

		
	}
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
    		String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, float areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			String numDpiPersona, 
			String direccionTerrenoPersona, String aldeaPersona, 
			String deptoDireccionPersona, String municipioDireccionPersona,
			String direccionTerrenoGarantia, String aldeaGarantia, 
			String deptoDireccionGarantia, String municipioDireccionGarantia)
	{
    	
		this.bandera = false;
		
		this.idGarantiaHipotecaria = id; // ID Formulario Cargado
		
		this.txtEscrituraNoRegistrada.setValue(escrituraNoRegistrada);
		this.txtEscrituraRegistrada.setValue(escrituraRegistrada);
		this.txtFolio.setValue(folio);
		this.txtLibro.setValue(libro);
		this.txtFinca.setValue(finca);
		this.txtNombreNotario.setValue(nombreNotario);
		String valAreaTerreno = ""+areaTerreno;
		this.txtAreaTerreno.setValue(valAreaTerreno);
		String valValorTerreno = ""+valorTerreno;
		this.txtValorTerreno.setValue(valValorTerreno);
		this.checkBoxSi.setValue(checkSi);
		this.txtNombrePersona.setValue(nombrePersona);
		String valueTelefonoPersona = ""+telefonoPersona;
		this.txtTelefonoPersona.setValue(valueTelefonoPersona);	    
	
		this.txtNumDpiPersona.setText(numDpiPersona);
		this.txtDireccionTerrenoPersona.setText(direccionTerrenoPersona);
		this.txtAldeaPersona.setText(aldeaPersona);
		
		boolean bandera = true;
        for(int i=0; i < this.listDepartamentoPersona.getItemCount() && bandera; i++){
            bandera = !this.listDepartamentoPersona.getValue(i).equals(deptoDireccionPersona);
            this.listDepartamentoPersona.setSelectedIndex(i);
        } 

        this.listMunicipioPersona.clear();
        String[] numerosComoArray = Depto_Municipio(this.listDepartamentoPersona.getItemText(this.listDepartamentoPersona.getSelectedIndex())).split(",");
        int correlativo = Integer.parseInt(this.listDepartamentoPersona.getValue(this.listDepartamentoPersona.getSelectedIndex())+"01");
        for (int i = 1; i < numerosComoArray.length; i++) {
        	
        	this.listMunicipioPersona.addItem(numerosComoArray[i],String.valueOf(correlativo));
        	correlativo++;
        }

        bandera = true;
        for(int i=0; i < this.listMunicipioPersona.getItemCount() && bandera; i++){
            bandera = !this.listMunicipioPersona.getValue(i).equals(municipioDireccionPersona);
            this.listMunicipioPersona.setSelectedIndex(i);
        } 
		
		
		this.txtDireccionTerrenoGarantia.setText(direccionTerrenoGarantia);
		this.txtAldeaGarantia.setText(aldeaGarantia);
		
		bandera = true;
        for(int i=0; i < this.listDepartamentoGarantia.getItemCount() && bandera; i++){
            bandera = !this.listDepartamentoGarantia.getValue(i).equals(deptoDireccionGarantia);
            this.listDepartamentoGarantia.setSelectedIndex(i);
        } 
		
        this.listMunicipioGarantia.clear();
        String[] numerosComoArray2 = Depto_Municipio(this.listDepartamentoGarantia.getItemText(this.listDepartamentoGarantia.getSelectedIndex())).split(",");
        correlativo = Integer.parseInt(this.listDepartamentoGarantia.getValue(this.listDepartamentoGarantia.getSelectedIndex())+"01");
        for (int i = 1; i < numerosComoArray2.length; i++) {
        	
        	this.listMunicipioGarantia.addItem(numerosComoArray2[i],String.valueOf(correlativo));
        	correlativo++;
        }

        bandera = true;
        for(int i=0; i < this.listMunicipioGarantia.getItemCount() && bandera; i++){
            bandera = !this.listMunicipioGarantia.getValue(i).equals(municipioDireccionGarantia);
            this.listMunicipioGarantia.setSelectedIndex(i);
        } 
        
		
        
        if(checkSi){
        	lblIndiquePersona.setVisible(true);
        	lblNoTelefonoPersona.setVisible(true);
        	lblNumDpiPersona.setVisible(true);
        	lblDireccionTerrenoPersona.setVisible(true);
        	lblAldeaPersona.setVisible(true);
        	lblDepartamentoPersona.setVisible(true);
        	lblMunicipioPersona.setVisible(true);
			txtNombrePersona.setVisible(true);
			txtTelefonoPersona.setVisible(true);
			txtNumDpiPersona.setVisible(true);
			txtDireccionTerrenoPersona.setVisible(true);
			txtAldeaPersona.setVisible(true);
			listDepartamentoPersona.setVisible(true);
			listMunicipioPersona.setVisible(true);
			
        }else{
        	lblIndiquePersona.setVisible(false);
			lblNoTelefonoPersona.setVisible(false);
			lblNumDpiPersona.setVisible(false);
        	lblDireccionTerrenoPersona.setVisible(false);
        	lblAldeaPersona.setVisible(false);
        	lblDepartamentoPersona.setVisible(false);
        	lblMunicipioPersona.setVisible(false);
			txtNombrePersona.setVisible(false);
			txtNombrePersona.setValue("");
			txtTelefonoPersona.setVisible(false);
			txtTelefonoPersona.setValue("0");
			txtNumDpiPersona.setVisible(false);
			txtNumDpiPersona.setValue("0");
			txtDireccionTerrenoPersona.setVisible(false);
			txtDireccionTerrenoPersona.setValue("");
			txtAldeaPersona.setVisible(false);
			txtAldeaPersona.setValue("");
			listDepartamentoPersona.setVisible(false);
//			listDepartamentoPersona.setValue(-1,"-");
			listMunicipioPersona.setVisible(false);
//			listMunicipioPersona.setValue(-1,"-");
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
//    	System.out.println(result.toString());
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
