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
		absolutePanel.setSize("988px", "617px");
		
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
		
		listPais = new ListBox();
		listPais.addItem("-","-1");
		listPais.addItem("Guatemala","1");
		listPais.addItem("El Salvador","2");
		listPais.addItem("Bélice","3");
		listPais.addItem("Honduras","4");
		listPais.addItem("Nicaragua","5");
		listPais.addItem("Costa Rica","5");
		listPais.addItem("Panamá","6");
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
//		txtNumDpi.setMaxLength(8);
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
		absolutePanel.add(txtDireccionActual, 229, 235);
		txtDireccionActual.setSize("601px", "19px");
		txtDireccionActual.setTabIndex(11);
		
		txtDireccionSolucion = new TextBox();
		txtDireccionSolucion.setStyleName("gwt-TextBox2");
		txtDireccionSolucion.setMaxLength(200);
		absolutePanel.add(txtDireccionSolucion, 229, 273);
		txtDireccionSolucion.setSize("601px", "19px");
		txtDireccionSolucion.setTabIndex(12);
		
		checkBoxCamion = new CheckBox("Camion");
		absolutePanel.add(checkBoxCamion, 232, 319);
		checkBoxCamion.setSize("105px", "24px");
		checkBoxCamion.setTabIndex(13);
		
		checkBoxCarro = new CheckBox("Carro");
		absolutePanel.add(checkBoxCarro, 364, 319);
		checkBoxCarro.setSize("105px", "24px");
		checkBoxCarro.setTabIndex(14);
		
		checkBoxPeatonal = new CheckBox("Peatonal");
		absolutePanel.add(checkBoxPeatonal, 524, 319);
		checkBoxPeatonal.setSize("105px", "24px");
		checkBoxPeatonal.setTabIndex(15);
		
		txtLugarTrabajoSolicitante = new TextBox();
		txtLugarTrabajoSolicitante.setStyleName("gwt-TextBox2");
		txtLugarTrabajoSolicitante.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajoSolicitante, 229, 371);
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
		absolutePanel.add(txtTelefonoCasaSolicitante, 229, 419);
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
		absolutePanel.add(txtTelefonoTrabajoSolicitante, 693, 421);
		txtTelefonoTrabajoSolicitante.setSize("128px", "17px");
		txtTelefonoTrabajoSolicitante.setTabIndex(18);
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addItem("-","-1");
		listSolucionConstruir.addItem("Nueva","1");
		listSolucionConstruir.addItem("Mejoramiento","2");
		listSolucionConstruir.addItem("Adiciones Menores","3");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 232, 456);
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
		absolutePanel.add(txtCuotaPagar, 689, 462);
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
		absolutePanel.add(txtNombreConyuge, 229, 502);
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
		absolutePanel.add(txtTelefonoConyuge, 689, 500);
		txtTelefonoConyuge.setSize("128px", "19px");
		txtTelefonoConyuge.setTabIndex(22);
		
		txtLugarTrabajoConyuge = new TextBox();
		txtLugarTrabajoConyuge.setStyleName("gwt-TextBox2");
		txtLugarTrabajoConyuge.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajoConyuge, 229, 544);
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
		absolutePanel.add(txtTelefonoTrabajoConyuge, 689, 542);
		txtTelefonoTrabajoConyuge.setSize("128px", "19px");	
		txtTelefonoTrabajoConyuge.setTabIndex(24);

		
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
					
					Boolean garantia = false;
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
										garantia, creditoAprobado, creditoNoAprobado, montoAprobado, observacionNoAprobado,
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
		absolutePanel.add(btnGuardar, 464, 603);
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
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge)
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
