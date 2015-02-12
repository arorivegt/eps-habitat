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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.CheckBox;

public class Sce_DataGarantiaFiduciaria extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntrySeguimientoFormularioSolicitud formulario;
	private Sce_DataEntryGarantiaFiduciaria cargaFamiliar;
	private Long idCargaFamiliar = 0L;
	private boolean bandera = true;
	
	private TextBox txtNombreFamiliar;
	private TextBox txtEdadFamiliar;
	private Mensaje mensaje; 
	
	private ListBox listEstadoCivil;
    private ListBox listPais;
	
	public Sce_DataGarantiaFiduciaria(Sce_DataEntryGarantiaFiduciaria a, Sce_DataEntrySeguimientoFormularioSolicitud e) {

		mensaje = new Mensaje();
		this.formulario = e;
		this.cargaFamiliar = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("800px", "425px");
		
		txtNombreFamiliar = new TextBox();
		txtNombreFamiliar.setMaxLength(200);
		txtNombreFamiliar.setStylePrimaryName("gwt-TextBox2");
		txtNombreFamiliar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreFamiliar, 194, 32);
		txtNombreFamiliar.setSize("461px", "19px");
		
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
		absolutePanel.add(txtEdadFamiliar, 382, 97);
		txtEdadFamiliar.setSize("56px", "19px");
		
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
				

				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

//					solucionesService.ingresarCargaFamiliar(fecrec, formulario.idFormulario, 
//							nombreFamiliar, edadFamiliar, "", "",
//							new AsyncCallback<Long>() {
//
//						public void onFailure(Throwable caught) 
//						{
//							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
//						}
//
//						public void onSuccess(Long result)
//						{
//							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");
//
//							idCargaFamiliar = result;
//							System.out.println("Valor de NUEVO Carga Familiar: " + idCargaFamiliar);
//							bandera = false;
//							
//						}
//					});

				}else{
					
//					solucionesService.actualizarCargaFamiliar(formulario.idFormulario, idCargaFamiliar, 
//							nombreFamiliar, edadFamiliar, "", "",
//							new AsyncCallback<Long>() {
//
//						public void onFailure(Throwable caught) 
//						{
//							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
//						}
//
//						public void onSuccess(Long result)
//						{	
//							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
//							
//							System.out.println("Valor de Carga Familiar ACTUALIZADO: " + idCargaFamiliar );
//							bandera = false;
//
//						}
//					});
					
				}
				
			}
		});
		
		
		
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 194, 386);
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
		absolutePanel.add(btnEliminar, 471, 386);
		btnEliminar.setSize("227px", "34px");
		
		Label lblNombre = new Label("Nombre Completo:");
		lblNombre.setStyleName("label");
		absolutePanel.add(lblNombre, 20, 32);
		lblNombre.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Edad:");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 318, 105);
		lblTitulodiploma.setSize("58px", "13px");
		
		Label lblEscolaridad = new Label("Estado Civil:");
		lblEscolaridad.setStyleName("label");
		absolutePanel.add(lblEscolaridad, 20, 105);
		lblEscolaridad.setSize("124px", "13px");
		
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
		
		Label label = new Label("Nacionalidad:");
		label.setStyleName("label");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		absolutePanel.add(label, 488, 105);
		label.setSize("110px", "19px");
		
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
		
		Label label_1 = new Label("Actividad Economica:");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 20, 170);
		label_1.setSize("179px", "19px");
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(50);
		absolutePanel.add(textBox, 205, 168);
		textBox.setSize("296px", "19px");
		
		CheckBox checkBox = new CheckBox("Sabe Leer");
		absolutePanel.add(checkBox, 194, 206);
		checkBox.setSize("143px", "24px");
		
		CheckBox checkBox_1 = new CheckBox("Sabe Escribir");
		absolutePanel.add(checkBox_1, 357, 206);
		checkBox_1.setSize("154px", "24px");
		
		CheckBox checkBox_2 = new CheckBox("Sabe Firmar");
		absolutePanel.add(checkBox_2, 539, 206);
		checkBox_2.setSize("159px", "24px");
		
		Label label_2 = new Label("Direccion Actual:");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 20, 251);
		label_2.setSize("181px", "19px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(200);
		absolutePanel.add(textBox_1, 207, 249);
		textBox_1.setSize("601px", "19px");
		
		Label label_3 = new Label("Lugar de trabajo:");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 20, 289);
		label_3.setSize("181px", "19px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox2");
		textBox_2.setMaxLength(200);
		absolutePanel.add(textBox_2, 207, 289);
		textBox_2.setSize("601px", "19px");
		
		Label label_4 = new Label("Telefono de casa:");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 20, 333);
		label_4.setSize("167px", "19px");
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setText("0");
		textBox_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_3, 207, 331);
		textBox_3.setSize("128px", "19px");
		
		Label label_5 = new Label("Telefono de trabajo:");
		label_5.setStyleName("label");
		absolutePanel.add(label_5, 442, 333);
		label_5.setSize("167px", "19px");
		
		TextBox textBox_4 = new TextBox();
		textBox_4.setText("0");
		textBox_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_4, 671, 333);
		textBox_4.setSize("128px", "17px");
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

	
	}
}
