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
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DatePicker;

public class Sce_DataSupervisionSegunda extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryBitacoraSolicitud formulario;
	private Sce_DataEntrySupervisionSegunda supervisionSegunda;
    private boolean bandera = true;
	private Long idSupervisionSegunda = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	private TextArea txtObservaciones;
	private TextArea txtAcciones;
	private CheckBox checkSatisfactoria;
	private CheckBox checkNoSatisfactoria;
	private DateBox txtFechaVisita;
	private Button btnGuardar;
	private TextBox txtRepresentante;
	private Label label;
	private Label label_1;
	private Label label_2;
	private TextBox txtAlbanil;
	private TextBox txtPromotor;
    
	public Sce_DataSupervisionSegunda(Sce_DataEntrySupervisionSegunda a, Sce_DataEntryBitacoraSolicitud e) {
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.supervisionSegunda = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "600px");
		
		txtObservaciones = new TextArea();
		absolutePanel.add(txtObservaciones, 42, 134);
		txtObservaciones.setSize("857px", "69px");
		
		txtFechaVisita = new DateBox();
		txtFechaVisita.setValue(new Date());
		txtFechaVisita.getTextBox().setReadOnly(true);
		txtFechaVisita.setFireNullValues(true);
		txtFechaVisita.setStyleName("gwt-PasswordTextBox");
		txtFechaVisita.getDatePicker().setYearArrowsVisible(true);
		txtFechaVisita.getDatePicker().setYearAndMonthDropdownVisible(true);
		txtFechaVisita.getDatePicker().setVisibleYearCount(100);
		absolutePanel.add(txtFechaVisita, 232, 36);
		txtFechaVisita.setFormat(new DateBox.DefaultFormat (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		
		txtAcciones = new TextArea();
		absolutePanel.add(txtAcciones, 42, 257);
		txtAcciones.setSize("857px", "69px");
		
		checkSatisfactoria = new CheckBox("Satisfactoria");
		absolutePanel.add(checkSatisfactoria, 232, 361);
		checkSatisfactoria.setSize("141px", "24px");
		
		checkNoSatisfactoria = new CheckBox("No Satisfactoria");
		absolutePanel.add(checkNoSatisfactoria, 379, 361);
		checkNoSatisfactoria.setSize("161px", "24px");
		
		Label lblFechaDeVisita = new Label("Fecha de Visita II:");
		lblFechaDeVisita.setStyleName("label");
		absolutePanel.add(lblFechaDeVisita, 42, 36);
		lblFechaDeVisita.setSize("148px", "19px");
		
		Label lblAcciones = new Label("Acciones");
		lblAcciones.setStyleName("label");
		absolutePanel.add(lblAcciones, 42, 232);
		lblAcciones.setSize("171px", "19px");
		
		Label lblSupervision = new Label("Supervision");
		lblSupervision.setStyleName("label");
		absolutePanel.add(lblSupervision, 42, 366);
		lblSupervision.setSize("133px", "19px");
		
		Label lblIndiqueLosBienes = new Label("Observaciones:");
		lblIndiqueLosBienes.setStyleName("label");
		absolutePanel.add(lblIndiqueLosBienes, 42, 109);
		lblIndiqueLosBienes.setSize("171px", "19px");
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				Date fechaVisita = new Date();
				fechaVisita = txtFechaVisita.getValue();
				
				Boolean checkSatisfactoriaValue = false;
				checkSatisfactoriaValue = checkSatisfactoria.getValue();
				
				Boolean checkNoSatisfactoriaValue = false;
				checkNoSatisfactoriaValue = checkNoSatisfactoria.getValue();
				
				String observaciones = "";		
				if(txtObservaciones.getText() == null){
					observaciones = "";
				}else{
					observaciones = txtObservaciones.getText();
				}

				String acciones = "";		
				if(txtAcciones.getText() == null){
					acciones = "";
				}else{
					acciones = txtAcciones.getText();
				}
				
				
				Date time = new Date();
				@SuppressWarnings("deprecation")
				Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());
				
				if(bandera){

					solucionesService.ingresarSupervisionSegunda(fecrec, formulario.idFormulario, 
							fechaVisita,
							observaciones, acciones,
							checkSatisfactoriaValue, checkNoSatisfactoriaValue,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje = new Mensaje();
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje = new Mensaje();
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idSupervisionSegunda = result;
							System.out.println("Valor de NUEVA SEGUNDA Supervision: " + idSupervisionSegunda);
							bandera = false;
							
							// --- formulario.habilitarTerceraSupervision(); // Habilita para 3era Supervision
							
						}
					});

				}else{
					
					solucionesService.actualizarSupervisionSegunda(formulario.idFormulario, idSupervisionSegunda, 
							fechaVisita,
							observaciones, acciones,
							checkSatisfactoriaValue, checkNoSatisfactoriaValue,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de DATOS DE PRIMERA SUPERVISION: " + idSupervisionSegunda );
							bandera = false;

						}
					});
					
				}
				
			}
		});
		
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 453, 578);
		
		txtRepresentante = new TextBox();
		txtRepresentante.setStylePrimaryName("gwt-TextBox2");
		txtRepresentante.setStyleName("gwt-TextBox2");
		txtRepresentante.setMaxLength(200);
		absolutePanel.add(txtRepresentante, 275, 513);
		txtRepresentante.setSize("386px", "19px");
		
		label = new Label("Representante de Familia:");
		label.setStyleName("label");
		absolutePanel.add(label, 42, 515);
		label.setSize("208px", "19px");
		
		label_1 = new Label("Albañil:");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 42, 471);
		label_1.setSize("133px", "19px");
		
		label_2 = new Label("Promotor:");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 42, 426);
		label_2.setSize("133px", "19px");
		
		txtAlbanil = new TextBox();
		txtAlbanil.setStylePrimaryName("gwt-TextBox2");
		txtAlbanil.setStyleName("gwt-TextBox2");
		txtAlbanil.setMaxLength(200);
		absolutePanel.add(txtAlbanil, 275, 469);
		txtAlbanil.setSize("386px", "19px");
		
		txtPromotor = new TextBox();
		txtPromotor.setStylePrimaryName("gwt-TextBox2");
		txtPromotor.setStyleName("gwt-TextBox2");
		txtPromotor.setMaxLength(200);
		absolutePanel.add(txtPromotor, 275, 424);
		txtPromotor.setSize("386px", "19px");
		
	}
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
			Long fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria)
	{
    	
		this.bandera = false;
		
		this.idSupervisionSegunda = id; // ID Formulario Cargado
		
		this.txtFechaVisita.setValue(new Date(fechaVisita));
		this.txtObservaciones.setValue(observaciones);
		this.txtAcciones.setValue(acciones);
		this.checkSatisfactoria.setValue(satisfactoria);
		this.checkNoSatisfactoria.setValue(noSatisfactoria);
	    
	}
	
}
