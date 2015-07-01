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
	private Label lblNoTelfonoPersona;
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
    
	// Valor Escritura-Lectura
	private boolean valor;    
    
	public Sce_DataGarantiaHipotecaria(Sce_DataEntryGarantiaHipotecaria a, Sce_DataEntryGarantiaSolicitud e, boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.garantiaHipotecaria = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
		Label lblNombres = new Label("Escritura p\u00FAblica NO registrada n\u00FAmero:");
		lblNombres.setStyleName("label");
		absolutePanel.add(lblNombres, 42, 30);
		lblNombres.setSize("291px", "19px");
		
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
		absolutePanel.add(lblLugarDeTrabajo, 42, 317);
		lblLugarDeTrabajo.setSize("323px", "19px");
		
		lblIndiquePersona = new Label("Si su respuesta es afirmativa, por favor indique el nombre de la persona:");
		lblIndiquePersona.setStyleName("label");
		absolutePanel.add(lblIndiquePersona, 42, 366);
		lblIndiquePersona.setSize("532px", "19px");
		
		Label lblNoDeFinca = new Label("No. de Finca:");
		lblNoDeFinca.setStyleName("label");
		absolutePanel.add(lblNoDeFinca, 761, 66);
		lblNoDeFinca.setSize("118px", "19px");
		
		lblNoTelfonoPersona = new Label("No. tel\u00E9fono persona:");
		lblNoTelfonoPersona.setStyleName("label");
		absolutePanel.add(lblNoTelfonoPersona, 42, 419);
		lblNoTelfonoPersona.setSize("240px", "19px");
		
		Label lblNotario = new Label("Nombre Notario:");
		lblNotario.setStyleName("label");
		absolutePanel.add(lblNotario, 42, 161);
		lblNotario.setSize("240px", "19px");
		
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
		txtAreaTerreno.setText("0");
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
		absolutePanel.add(txtNombrePersona, 580, 366);
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
		absolutePanel.add(txtTelefonoPersona, 207, 417);
		txtTelefonoPersona.setSize("90px", "19px");
		txtTelefonoPersona.setTabIndex(11);
		
		checkBoxSi = new CheckBox("");
		checkBoxSi.addClickHandler(new ClickHandler() 
		{
		    public void onClick(ClickEvent event) 
		    {
		        if(checkBoxSi.isChecked()){
		        	lblIndiquePersona.setVisible(true);
		        	lblNoTelfonoPersona.setVisible(true);
					txtNombrePersona.setVisible(true);
					txtTelefonoPersona.setVisible(true);
		        }else{
		        	lblIndiquePersona.setVisible(false);
					lblNoTelfonoPersona.setVisible(false);
					txtNombrePersona.setVisible(false);
					txtNombrePersona.setValue("");
					txtTelefonoPersona.setVisible(false);
					txtTelefonoPersona.setValue("0");
		        }
		    }
		});
		absolutePanel.add(checkBoxSi, 418, 312);
		checkBoxSi.setTabIndex(9);
		
        if(checkBoxSi.isChecked()){
        	lblIndiquePersona.setVisible(true);
        	lblNoTelfonoPersona.setVisible(true);
			txtNombrePersona.setVisible(true);
			txtTelefonoPersona.setVisible(true);
        }else{
        	lblIndiquePersona.setVisible(false);
			lblNoTelfonoPersona.setVisible(false);
			txtNombrePersona.setVisible(false);
			txtNombrePersona.setValue("");
			txtTelefonoPersona.setVisible(false);
			txtTelefonoPersona.setValue("0");
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
		absolutePanel.add(btnGuardar, 475, 460);
		btnGuardar.setTabIndex(12);
		
	}
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
    		String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, float areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona)
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
	
        if(checkSi){
        	lblIndiquePersona.setVisible(true);
        	lblNoTelfonoPersona.setVisible(true);
			txtNombrePersona.setVisible(true);
			txtTelefonoPersona.setVisible(true);
        }else{
        	lblIndiquePersona.setVisible(false);
			lblNoTelfonoPersona.setVisible(false);
			txtNombrePersona.setVisible(false);
			txtNombrePersona.setValue("");
			txtTelefonoPersona.setVisible(false);
			txtTelefonoPersona.setValue("0");
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
	
}
