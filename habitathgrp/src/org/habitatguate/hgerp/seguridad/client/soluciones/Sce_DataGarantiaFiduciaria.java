package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.CheckBox;

public class Sce_DataGarantiaFiduciaria extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryGarantiaSolicitud formulario;
	private Sce_DataEntryGarantiaFiduciaria garantiaFiduciaria;
	private Long idGarantiaFiduciaria = 0L;
	private boolean bandera = true;
	private Mensaje mensaje; 
	
	private TextBox txtNombre;
	private TextBox txtEdad;
	private TextBox txtActividad;
	private TextBox txtDireccionActual;
	private TextBox txtLugarTrabajo;
	private TextBox txtTelefonoCasa;
	private TextBox txtTelefonoTrabajo;
	
	private CheckBox checkLeer;
	private CheckBox checkEscribir;
	private CheckBox checkFirmar;
	
	private ListBox listEstadoCivil;
    private ListBox listPais;
    
	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_DataGarantiaFiduciaria(Sce_DataEntryGarantiaFiduciaria a, Sce_DataEntryGarantiaSolicitud e, boolean valor) {

		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.garantiaFiduciaria = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("800px", "425px");
		
		Label lblNombre = new Label("Nombre Completo:");
		lblNombre.setStyleName("label");
		absolutePanel.add(lblNombre, 20, 32);
		lblNombre.setSize("192px", "13px");
		
		Label lblEscolaridad = new Label("Estado Civil:");
		lblEscolaridad.setStyleName("label");
		absolutePanel.add(lblEscolaridad, 20, 105);
		lblEscolaridad.setSize("124px", "13px");
		
		Label lblTitulodiploma = new Label("Edad:");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 318, 105);
		lblTitulodiploma.setSize("58px", "13px");
		
		Label label = new Label("Nacionalidad:");
		label.setStyleName("label");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		absolutePanel.add(label, 488, 105);
		label.setSize("110px", "19px");
		
		Label label_1 = new Label("Actividad Economica:");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 20, 170);
		label_1.setSize("179px", "19px");
		
		Label label_2 = new Label("Direccion Actual:");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 20, 251);
		label_2.setSize("181px", "19px");
		
		Label label_3 = new Label("Lugar de trabajo:");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 20, 289);
		label_3.setSize("181px", "19px");
		
		Label label_4 = new Label("Telefono de casa:");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 20, 333);
		label_4.setSize("167px", "19px");
		
		Label label_5 = new Label("Telefono de trabajo:");
		label_5.setStyleName("label");
		absolutePanel.add(label_5, 442, 333);
		label_5.setSize("167px", "19px");
		
		txtNombre = new TextBox();
		txtNombre.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtNombre);
				
			}
		});	
		txtNombre.setMaxLength(200);
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombre, 194, 32);
		txtNombre.setSize("461px", "19px");
		txtNombre.setTabIndex(1);
		
		listEstadoCivil = new ListBox();
		listEstadoCivil.addItem("-", "-1");
		listEstadoCivil.addItem("Soltero (a)", "1");
		listEstadoCivil.addItem("Casado (a)", "2");
		listEstadoCivil.addItem("Unido (a)", "3");
		listEstadoCivil.addItem("Separado (a)", "4");
		listEstadoCivil.addItem("Divorciado (a)", "5");
		listEstadoCivil.addItem("Viudo (a)", "6");
		listEstadoCivil.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstadoCivil, 127, 97);
		listEstadoCivil.setSize("148px", "27px");
		listEstadoCivil.setTabIndex(2);
		
		txtEdad = new TextBox();
		txtEdad.setMaxLength(3);
		txtEdad.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtEdad .getText().equals("")) {txtEdad .setText("0");}
				else if(txtEdad .getText().equals(null)) {txtEdad .setText("0");}
				else{
					try{
						Integer.parseInt(txtEdad .getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nEdad No valida");
						txtEdad .setText("0");
					}
				}
			}
		});
		txtEdad.setText("0");
		txtEdad.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEdad, 382, 97);
		txtEdad.setSize("56px", "19px");
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
		absolutePanel.add(listPais, 622, 97);
		listPais.setSize("173px", "27px");
		listPais.setTabIndex(4);
		
		txtActividad = new TextBox();
		txtActividad.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtActividad);
				
			}
		});	
		txtActividad.setStyleName("gwt-TextBox2");
		txtActividad.setMaxLength(50);
		absolutePanel.add(txtActividad, 205, 168);
		txtActividad.setSize("296px", "19px");
		txtActividad.setTabIndex(5);
		
		checkLeer = new CheckBox("Sabe Leer");
		absolutePanel.add(checkLeer, 194, 206);
		checkLeer.setSize("143px", "24px");
		checkLeer.setTabIndex(6);
		
		checkEscribir = new CheckBox("Sabe Escribir");
		absolutePanel.add(checkEscribir, 357, 206);
		checkEscribir.setSize("154px", "24px");
		checkEscribir.setTabIndex(7);
		
		checkFirmar = new CheckBox("Sabe Firmar");
		absolutePanel.add(checkFirmar, 539, 206);
		checkFirmar.setSize("159px", "24px");
		checkFirmar.setTabIndex(8);
		
		txtDireccionActual = new TextBox();
		txtDireccionActual.setStyleName("gwt-TextBox2");
		txtDireccionActual.setMaxLength(200);
		absolutePanel.add(txtDireccionActual, 207, 249);
		txtDireccionActual.setSize("601px", "19px");
		txtDireccionActual.setTabIndex(9);
		
		txtLugarTrabajo = new TextBox();
		txtLugarTrabajo.setStyleName("gwt-TextBox2");
		txtLugarTrabajo.setMaxLength(200);
		absolutePanel.add(txtLugarTrabajo, 207, 289);
		txtLugarTrabajo.setSize("601px", "19px");
		txtLugarTrabajo.setTabIndex(10);
		
		txtTelefonoCasa = new TextBox();
		txtTelefonoCasa.setMaxLength(8);
		txtTelefonoCasa.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoCasa .getText().equals("")) {txtTelefonoCasa .setText("0");}
				else if(txtTelefonoCasa .getText().equals(null)) {txtTelefonoCasa .setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoCasa .getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor no valido");
						txtTelefonoCasa .setText("0");
					}
				}
			}
		});
		txtTelefonoCasa.setText("0");
		txtTelefonoCasa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoCasa, 207, 331);
		txtTelefonoCasa.setSize("128px", "19px");
		txtTelefonoCasa.setTabIndex(11);
		
		txtTelefonoTrabajo = new TextBox();
		txtTelefonoTrabajo.setMaxLength(8);
		txtTelefonoTrabajo.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoTrabajo .getText().equals("")) {txtTelefonoTrabajo .setText("0");}
				else if(txtTelefonoTrabajo .getText().equals(null)) {txtTelefonoTrabajo .setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoTrabajo .getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor no valido");
						txtTelefonoTrabajo .setText("0");
					}
				}
			}
		});
		txtTelefonoTrabajo.setText("0");
		txtTelefonoTrabajo.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoTrabajo, 671, 333);
		txtTelefonoTrabajo.setSize("128px", "17px");
		txtTelefonoTrabajo.setTabIndex(12);
		
		// Boton Guardar/Actualizar Informacion
		
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
				
				String edadValue = txtEdad.getText();
				int edad = 0;
				edad = Integer.parseInt(edadValue);
				
				String estadoCivil = "-1";		
				estadoCivil = listEstadoCivil.getValue(listEstadoCivil.getSelectedIndex());
				
				String nacionalidad = "-1";		
				nacionalidad = listPais.getValue(listPais.getSelectedIndex());	
				
				String actividadEconomica = "";		
				if(txtActividad.getText() == null){
					actividadEconomica = "";
				}else{
					actividadEconomica = txtActividad.getText();
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
				

				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.ingresarGarantiaFiduciaria(fecrec, formulario.idFormulario, 
							nombre, estadoCivil, edad, nacionalidad,
							actividadEconomica,
							sabeLeer, sabeEscribir, sabeFirmar,
							direccionActual, lugarTrabajo,
							telefonoCasa, telefonoTrabajo,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idGarantiaFiduciaria = result;
							System.out.println("Valor de NUEVA Garantia Fiduciaria: " + idGarantiaFiduciaria);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarGarantiaFiduciaria(formulario.idFormulario, idGarantiaFiduciaria, 
							nombre, estadoCivil, edad, nacionalidad,
							actividadEconomica,
							sabeLeer, sabeEscribir, sabeFirmar,
							direccionActual, lugarTrabajo,
							telefonoCasa, telefonoTrabajo,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de Garantia Fiduciaria ACTUALIZADO: " + idGarantiaFiduciaria );
							bandera = false;

						}
					});
					
				}
				
			}
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 194, 386);
		btnGuardar.setSize("227px", "34px");
		btnGuardar.setTabIndex(13);
		
		// Boton Eliminar Formulario
		
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
		absolutePanel.add(btnEliminar, 471, 386);
		btnEliminar.setSize("227px", "34px");
		btnEliminar.setTabIndex(14);
		
	}
	
	private void EliminarFormulario(){
		garantiaFiduciaria.EliminarFormulario(this, formulario.idFormulario, idGarantiaFiduciaria);
    }
	private void EliminarFormularioSinDatos(){
		garantiaFiduciaria.EliminarFormulario(this);
    }
	
	// DATA A CARGAR EN REFERENCIAS FAMILIARES
	
	public void LlenarDatos(Long id,
			String nombre, 
			String estadoCivil, int edad, String nacionalidad,
			String actividad,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
			String direccionActual, String lugarTrabajo,
			int telefonoCasa, int telefonoTrabajo)
	{

		this.bandera = false;
		
		this.idGarantiaFiduciaria = id; // ID

		this.txtNombre.setText(nombre);
		String edadValue = ""+edad;
		this.txtEdad.setText(edadValue);
		this.txtActividad.setText(actividad);
		this.checkLeer.setValue(sabeLeer);
		this.checkEscribir.setValue(sabeEscribir);
		this.checkFirmar.setValue(sabeFirmar);
		this.txtDireccionActual.setText(direccionActual);
		this.txtLugarTrabajo.setText(lugarTrabajo);
		String telefonoCasaValue = ""+telefonoCasa;
		this.txtTelefonoCasa.setText(telefonoCasaValue);
		String telefonoTrabajoValue = ""+telefonoTrabajo;
		this.txtTelefonoTrabajo.setText(telefonoTrabajoValue);
		
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
//    	System.out.println(result.toString());
    	input.setText(result.toString());
    }
	
}
