package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class Sce_DataReferenciasFamiliares extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryFormularioSolicitud formulario;
	private Sce_DataEntryReferenciasFamiliares cargaFamiliar;
	private Long idReferenciaFamiliar = 0L;
	private boolean bandera = true;
	
	private TextBox txtNombreFamiliar;
	private TextBox txtTelefonoFamiliar;
	private TextBox txtParentescoFamiliar;	
	private TextBox txtDireccionFamiliar;
	private Mensaje mensaje; 
    
	public Sce_DataReferenciasFamiliares(Sce_DataEntryReferenciasFamiliares a, Sce_DataEntryFormularioSolicitud e) {

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
		
		txtTelefonoFamiliar = new TextBox();
		txtTelefonoFamiliar.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefonoFamiliar .getText().equals("")) {txtTelefonoFamiliar .setText("0");}
				else if(txtTelefonoFamiliar .getText().equals(null)) {txtTelefonoFamiliar .setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefonoFamiliar .getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nEdad No valida");
						txtTelefonoFamiliar .setText("0");
					}
				}
			}
		});
		txtTelefonoFamiliar.setText("0");
		txtTelefonoFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefonoFamiliar, 506, 51);
		txtTelefonoFamiliar.setSize("103px", "19px");
		
		txtParentescoFamiliar = new TextBox();
		txtParentescoFamiliar.setMaxLength(200);
		txtParentescoFamiliar.setStylePrimaryName("gwt-TextBox2");
		txtParentescoFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtParentescoFamiliar, 384, 51);
		txtParentescoFamiliar.setSize("103px", "19px");
		
		txtDireccionFamiliar = new TextBox();
		txtDireccionFamiliar.setMaxLength(100);
		txtDireccionFamiliar.setStylePrimaryName("gwt-TextBox2");
		txtDireccionFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDireccionFamiliar, 636, 51);
		txtDireccionFamiliar.setSize("397px", "19px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				String nombreFamiliar = "";		
				if(txtNombreFamiliar.getText() == null){
					nombreFamiliar = "";
				}else{
					nombreFamiliar = txtNombreFamiliar.getText();
				}
				
				String telefonoFamiliarValue = txtTelefonoFamiliar.getText();
				int telefonoFamiliar = 0;
				telefonoFamiliar = Integer.parseInt(telefonoFamiliarValue);
				
				String parentescoFamiliar = "";		
				if(txtParentescoFamiliar.getText() == null){
					parentescoFamiliar = "";
				}else{
					parentescoFamiliar = txtParentescoFamiliar.getText();
				}
				
				String direccionFamiliar = "";		
				if(txtDireccionFamiliar.getText() == null){
					direccionFamiliar = "";
				}else{
					direccionFamiliar = txtDireccionFamiliar.getText();
				}

				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.ingresarReferenciaFamiliar(fecrec, formulario.idFormulario, 
							nombreFamiliar, telefonoFamiliar, parentescoFamiliar, direccionFamiliar,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idReferenciaFamiliar = result;
							System.out.println("Valor de NUEVO Carga Familiar: " + idReferenciaFamiliar);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarReferenciaFamiliar(formulario.idFormulario, idReferenciaFamiliar, 
							nombreFamiliar, telefonoFamiliar, parentescoFamiliar, direccionFamiliar,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de Carga Familiar ACTUALIZADO: " + idReferenciaFamiliar );
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
		
		Label lblNombre = new Label("Nombre");
		lblNombre.setStyleName("label");
		absolutePanel.add(lblNombre, 20, 32);
		lblNombre.setSize("105px", "13px");
		
		Label lblTelefono = new Label("Telefono");
		lblTelefono.setStyleName("label");
		absolutePanel.add(lblTelefono, 506, 32);
		lblTelefono.setSize("58px", "13px");
		
		Label lblEscolaridad = new Label("Parentesco");
		lblEscolaridad.setStyleName("label");
		absolutePanel.add(lblEscolaridad, 384, 32);
		lblEscolaridad.setSize("105px", "13px");
		
		Label lblOcupacion = new Label("Direccion");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 636, 32);
		lblOcupacion.setSize("132px", "13px");
		
	
	}
	
	private void EliminarFormulario(){
		cargaFamiliar.EliminarFormulario(this, formulario.idFormulario, idReferenciaFamiliar);
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
		
		this.idReferenciaFamiliar = id; // ID

		this.txtNombreFamiliar.setText(nombreFamiliar);
		String edadFamiliarValue = ""+edadFamiliar;
		this.txtTelefonoFamiliar.setText(edadFamiliarValue);
		this.txtParentescoFamiliar.setText(escolaridadFamiliar);
		this.txtDireccionFamiliar.setText(ocupacionFamiliar);
	
	}
	
}
