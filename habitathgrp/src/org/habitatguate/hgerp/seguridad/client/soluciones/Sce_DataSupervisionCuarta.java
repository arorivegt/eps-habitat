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

public class Sce_DataSupervisionCuarta extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryBitacoraSolicitud formulario;
	private Sce_DataEntrySupervisionCuarta supervisionCuarta;
    private boolean bandera = true;
	private Long idSupervisionCuarta = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	private TextArea txtObservaciones;
	private TextArea txtAcciones;
	private CheckBox checkSatisfactoria;
	private CheckBox checkNoSatisfactoria;
	private DateBox txtFechaVisita;
	private Button btnGuardar;
    
	public Sce_DataSupervisionCuarta(Sce_DataEntrySupervisionCuarta a, Sce_DataEntryBitacoraSolicitud e) {
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.supervisionCuarta = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
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
		
		Label lblFechaDeVisita = new Label("Fecha de Visita IV:");
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

					solucionesService.ingresarSupervisionCuarta(fecrec, formulario.idFormulario, 
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

							idSupervisionCuarta = result;
							System.out.println("Valor de NUEVA CUARTA Supervision: " + idSupervisionCuarta);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarSupervisionCuarta(formulario.idFormulario, idSupervisionCuarta, 
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
							
							System.out.println("Valor de DATOS DE CUARTA SUPERVISION: " + idSupervisionCuarta );
							bandera = false;

						}
					});
					
				}
				
			}
		});
		
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 471, 429);
		
	}
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
			Long fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria)
	{
    	
		this.bandera = false;
		
		this.idSupervisionCuarta = id; // ID Formulario Cargado
		
		this.txtFechaVisita.setValue(new Date(fechaVisita));
		this.txtObservaciones.setValue(observaciones);
		this.txtAcciones.setValue(acciones);
		this.checkSatisfactoria.setValue(satisfactoria);
		this.checkNoSatisfactoria.setValue(noSatisfactoria);
	    
	}
	
}
