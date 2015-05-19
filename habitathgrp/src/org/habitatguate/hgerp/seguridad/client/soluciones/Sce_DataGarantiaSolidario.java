package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.rrhh.FormularioFamilia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class Sce_DataGarantiaSolidario extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryGarantiaSolicitud formulario;
	private Sce_DataEntryGarantiaSolidario garantiaSolidario;
	private Long idGarantiaSolidario = 0L;
	private boolean bandera = true;
	
	private TextBox txtNombre;
	private TextBox txtOcupacion;
	private TextBox txtEdad;
	private TextBox txtEscolaridad;
	private Mensaje mensaje; 
	
	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_DataGarantiaSolidario(Sce_DataEntryGarantiaSolidario a, Sce_DataEntryGarantiaSolicitud e, boolean valor) {

		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.garantiaSolidario = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "140px");
		
		Label lblNombre = new Label("Nombres y Apellidos");
		lblNombre.setStyleName("label");
		absolutePanel.add(lblNombre, 20, 32);
		lblNombre.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Edad");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 386, 32);
		lblTitulodiploma.setSize("58px", "13px");
		
		Label lblEscolaridad = new Label("Escolaridad");
		lblEscolaridad.setStyleName("label");
		absolutePanel.add(lblEscolaridad, 475, 32);
		lblEscolaridad.setSize("192px", "13px");
		
		Label lblOcupacion = new Label("Ocupacion");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 758, 32);
		lblOcupacion.setSize("132px", "13px");
		
		txtNombre = new TextBox();
		txtNombre.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtNombre);
				
			}
		});	
		txtNombre.setMaxLength(200);
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombre, 20, 51);
		txtNombre.setSize("345px", "19px");
		txtNombre.setTabIndex(1);
		
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
		absolutePanel.add(txtEdad, 386, 51);
		txtEdad.setSize("56px", "19px");
		txtEdad.setTabIndex(2);
		
		txtEscolaridad = new TextBox();
		txtEscolaridad.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtEscolaridad);
				
			}
		});	
		txtEscolaridad.setMaxLength(200);
		txtEscolaridad.setStylePrimaryName("gwt-TextBox2");
		txtEscolaridad.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEscolaridad, 475, 51);
		txtEscolaridad.setSize("250px", "19px");
		txtEscolaridad.setTabIndex(3);
		
		txtOcupacion = new TextBox();
		txtOcupacion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
			
				firstLetterToUppercase(txtOcupacion);
				
			}
		});	
		txtOcupacion.setMaxLength(100);
		txtOcupacion.setStylePrimaryName("gwt-TextBox2");
		txtOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOcupacion, 758, 51);
		txtOcupacion.setSize("271px", "19px");
		txtOcupacion.setTabIndex(4);
		
		// Boton Guardar
		
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
				
				String escolaridad = "";		
				if(txtEscolaridad.getText() == null){
					escolaridad = "";
				}else{
					escolaridad = txtEscolaridad.getText();
				}
				
				String ocupacion = "";		
				if(txtOcupacion.getText() == null){
					ocupacion = "";
				}else{
					ocupacion = txtOcupacion.getText();
				}

				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.ingresarGarantiaSolidario(fecrec, formulario.idFormulario, 
							nombre, edad, escolaridad, ocupacion,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idGarantiaSolidario = result;
							System.out.println("Valor de NUEVO Garantia Grupo Solidario: " + idGarantiaSolidario);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarGarantiaSolidario(formulario.idFormulario, idGarantiaSolidario, 
							nombre, edad, escolaridad, ocupacion,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de Garantia Grupo Solidario ACTUALIZADO: " + idGarantiaSolidario );
							bandera = false;

						}
					});
					
				}
				
			}
		});
			
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 232, 119);
		btnGuardar.setSize("227px", "34px");
		btnGuardar.setTabIndex(5);
		
		// Boton Eliminar
		
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
		absolutePanel.add(btnEliminar, 531, 119);
		btnEliminar.setSize("227px", "34px");
		btnEliminar.setTabIndex(6);
		
	}
	
	private void EliminarFormulario(){
		garantiaSolidario.EliminarFormulario(this, formulario.idFormulario, idGarantiaSolidario);
    }
	private void EliminarFormularioSinDatos(){
		garantiaSolidario.EliminarFormulario(this);
    }
	
	// DATA A CARGAR EN REFERENCIAS FAMILIARES
	
	public void LlenarDatos(Long id,
			String nombre,
			int edad,
			String escolaridad,
			String ocupacion)
	{

		this.bandera = false;
		
		this.idGarantiaSolidario = id; // ID

		this.txtNombre.setText(nombre);
		String edadFamiliarValue = ""+edad;
		this.txtEdad.setText(edadFamiliarValue);
		this.txtEscolaridad.setText(escolaridad);
		this.txtOcupacion.setText(ocupacion);
	
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
