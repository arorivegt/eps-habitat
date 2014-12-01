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

public class Sce_DataCargasFamiliares extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryFormularioSolicitud formulario;
	private Sce_DataEntryCargasFamiliares cargaFamiliar;
	private Long idCargaFamiliar = 0L;
	private boolean bandera = true;
	
	private TextBox txtNombreFamiliar;
	private TextBox txtOcupacionFamiliar;
	private TextBox txtEdadFamiliar;
	private TextBox txtEscolaridadFamiliar;
	private Mensaje mensaje; 
	
	public Sce_DataCargasFamiliares(Sce_DataEntryCargasFamiliares a, Sce_DataEntryFormularioSolicitud e) {

		mensaje = new Mensaje();
		this.formulario = e;
		this.cargaFamiliar = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "140px");
		
		txtNombreFamiliar = new TextBox();
		txtNombreFamiliar.setMaxLength(200);
		txtNombreFamiliar.setStylePrimaryName("gwt-TextBox2");
		txtNombreFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreFamiliar, 20, 51);
		txtNombreFamiliar.setSize("345px", "19px");
		
		txtEdadFamiliar = new TextBox();
		txtEdadFamiliar.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtEdadFamiliar .getText().equals("")) {txtEdadFamiliar .setText("0");}
				else if(txtEdadFamiliar .getText().equals(null)) {txtEdadFamiliar .setText("0");}
				else{
					try{
						Integer.parseInt(txtEdadFamiliar .getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nEdad No valida");
						txtEdadFamiliar .setText("0");
					}
				}
			}
		});
		txtEdadFamiliar.setText("0");
		txtEdadFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEdadFamiliar, 386, 51);
		txtEdadFamiliar.setSize("56px", "19px");
		
		txtEscolaridadFamiliar = new TextBox();
		txtEscolaridadFamiliar.setMaxLength(200);
		txtEscolaridadFamiliar.setStylePrimaryName("gwt-TextBox2");
		txtEscolaridadFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEscolaridadFamiliar, 475, 51);
		txtEscolaridadFamiliar.setSize("250px", "19px");
		
		txtOcupacionFamiliar = new TextBox();
		txtOcupacionFamiliar.setMaxLength(100);
		txtOcupacionFamiliar.setStylePrimaryName("gwt-TextBox2");
		txtOcupacionFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOcupacionFamiliar, 758, 51);
		txtOcupacionFamiliar.setSize("271px", "19px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				String nombreFamiliar = "";		
				if(txtNombreFamiliar.getText() == null){
					nombreFamiliar = "";
				}else{
					nombreFamiliar = txtNombreFamiliar.getText();
				}
				
				String edadFamiliarValue = txtEdadFamiliar.getText();
				int edadFamiliar = 0;
				edadFamiliar = Integer.parseInt(edadFamiliarValue);
				
				String escolaridadFamiliar = "";		
				if(txtEscolaridadFamiliar.getText() == null){
					escolaridadFamiliar = "";
				}else{
					escolaridadFamiliar = txtEscolaridadFamiliar.getText();
				}
				
				String ocupacionFamiliar = "";		
				if(txtOcupacionFamiliar.getText() == null){
					ocupacionFamiliar = "";
				}else{
					ocupacionFamiliar = txtOcupacionFamiliar.getText();
				}

				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.ingresarCargaFamiliar(fecrec, formulario.idFormulario, 
							nombreFamiliar, edadFamiliar, escolaridadFamiliar, ocupacionFamiliar,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idCargaFamiliar = result;
							System.out.println("Valor de NUEVO Carga Familiar: " + idCargaFamiliar);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarCargaFamiliar(formulario.idFormulario, idCargaFamiliar, 
							nombreFamiliar, edadFamiliar, escolaridadFamiliar, ocupacionFamiliar,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de Carga Familiar ACTUALIZADO: " + idCargaFamiliar );
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
		
		
		Button btnEliminar = new Button("Send");
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
	}
	
	private void EliminarFormulario(){
		cargaFamiliar.EliminarFormulario(this, formulario.idFormulario, idCargaFamiliar);
    }
	private void EliminarFormularioSinDatos(){
		cargaFamiliar.EliminarFormulario(this);
    }
	
	// DATA A CARGAR EN REFERENCIAS FAMILIARES
	
	public void LlenarDatos(Long id,
			String nombreFamiliar,
			int edadFamiliar,
			String escolaridadFamiliar,
			String ocupacionFamiliar)
	{

		this.bandera = false;
		
		this.idCargaFamiliar = id; // ID

		this.txtNombreFamiliar.setText(nombreFamiliar);
		String edadFamiliarValue = ""+edadFamiliar;
		this.txtEdadFamiliar.setText(edadFamiliarValue);
		this.txtEscolaridadFamiliar.setText(escolaridadFamiliar);
		this.txtOcupacionFamiliar.setText(ocupacionFamiliar);
	
	}
	
	
}
