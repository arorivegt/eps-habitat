package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class FormularioSolicitudPermiso extends Composite {

	private Long id_empleado;
	private Long id_Solicitud = 0L;
	public 	Button btnAceptar ;
	public 	Button btnNoAceptar ;
	public 	Button btnEnterado ;
	private Long id_Empleado_Solicitante = 0L;
	private String RespuestaJ= "JSR";
	private String RespuestaR= "JSR";
	private char DeQuien = '0';
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
    private TextArea txtDescripcion;
    private DateBox dateFecha1;
    private DateBox dateFecha2;
	private Mensaje mensaje; 
	private ListBox listTipoPermiso ;
    private Loading load ;
    private TextBox txtNombre;
    private TextBox txtDias;
    private TextBox txtDisponibles;
    private Label lblDiasDisponibles_1;
    
	public FormularioSolicitudPermiso(Long e) {

		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.id_empleado = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("773px", "170px");
		
		dateFecha1 = new DateBox();
		dateFecha1.getTextBox().setReadOnly(true);
		dateFecha1.setValue(new Date());
		dateFecha1.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha1.getDatePicker().setYearArrowsVisible(true);
		dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha1.getDatePicker().setVisibleYearCount(100);
		dateFecha1.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha1, 10, 29);
		dateFecha1.setSize("89px", "34px");
		
		dateFecha2 = new DateBox();
		dateFecha2.getTextBox().setReadOnly(true);
		dateFecha2.setValue(new Date());
		dateFecha2.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha2.getDatePicker().setYearArrowsVisible(true);
		dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha2.getDatePicker().setVisibleYearCount(100);
		dateFecha2.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha2, 117, 29);
		dateFecha2.setSize("89px", "34px");
		
		txtDescripcion = new TextArea();
		txtDescripcion.getElement().setAttribute("maxlength", "1000");
		
		listTipoPermiso = new ListBox();
		listTipoPermiso.addItem("Vacaciones con goce salaria","0");
		listTipoPermiso.addItem("Vacaciones sin goce salaria","1");
		listTipoPermiso.addItem("Permiso con goce salarial","2");
		listTipoPermiso.addItem("Permiso sin goce salarial","3");
		listTipoPermiso.addItem("Suspension con goce salarial","4");
		listTipoPermiso.addItem("Suspension sin goce salarial","5");
		listTipoPermiso.addItem("Ausencia con goce salarial","6");
		listTipoPermiso.addItem("Ausencia sin goce salarial","7");
		listTipoPermiso.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoPermiso, 226, 29);
		listTipoPermiso.setSize("221px", "36px");
		txtDescripcion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDescripcion, 10, 106);
		txtDescripcion.setSize("433px", "95px");
		
		btnAceptar = new Button("Send");
		btnAceptar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
		        if(DeQuien == '0'){
		        	RespuestaR = "RS";
		        }else{
		        	RespuestaJ = "JS";
		        }
				loginService.Respuesta_Solicitud(id_Solicitud,id_empleado,id_Empleado_Solicitante,
						dateFecha1.getValue(),dateFecha2.getValue(),txtDescripcion.getText(),listTipoPermiso.getValue(listTipoPermiso.getSelectedIndex()),
						RespuestaJ,RespuestaR,"ENE",new AsyncCallback<String>(){
                    public void onFailure(Throwable caught) 
                    {
        		        load.invisible();
                    	mensaje.setMensaje("alert alert-error", "Error !! \nal Guardar Datos");
                    }

					@Override
                    public void onSuccess(String result)
                    {
				        load.invisible();
						mensaje.setMensaje("alert alert-success", result);
                    }
					});
					
		        load.invisible();
			}
		});

		btnAceptar.setText("Aceptar");
		btnAceptar.setStylePrimaryName("sendButton");
		btnAceptar.setStyleName("sendButton");
		absolutePanel.add(btnAceptar, 700, 85);
		btnAceptar.setSize("143px", "34px");
		
		txtNombre = new TextBox();
		txtNombre.setReadOnly(true);
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		txtNombre.setMaxLength(100);
		absolutePanel.add(txtNombre, 480, 29);
		txtNombre.setSize("361px", "34px");
		
		txtDias = new TextBox();
		txtDias.setEnabled(false);
		txtDias.setText("0");
		txtDias.setStylePrimaryName("gwt-TextBox2");
		txtDias.setStyleName("gwt-TextBox2");
		txtDias.setMaxLength(100);
		absolutePanel.add(txtDias, 480, 138);
		txtDias.setSize("89px", "34px");
		
		
		btnNoAceptar = new Button("Send");
		btnNoAceptar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
		        if(DeQuien == '0'){
		        	RespuestaR = "RN";
		        }else{
		        	RespuestaJ = "JN";
		        }
				loginService.Respuesta_Solicitud(id_Solicitud,id_empleado,id_Empleado_Solicitante,
						dateFecha1.getValue(),dateFecha2.getValue(),txtDescripcion.getText(),listTipoPermiso.getValue(listTipoPermiso.getSelectedIndex()),
						RespuestaJ,RespuestaR,"ENE",new AsyncCallback<String>(){
                    public void onFailure(Throwable caught) 
                    {
        		        load.invisible();
                    	mensaje.setMensaje("alert alert-error", "Error !! \nal Guardar Datos");
                    }

					@Override
                    public void onSuccess(String result)
                    {
				        load.invisible();
						mensaje.setMensaje("alert alert-success", result);
                    }
					});
					
		        load.invisible();
			}
		});
		btnNoAceptar.setText("No Aceptar");
		btnNoAceptar.setStylePrimaryName("sendButton");
		btnNoAceptar.setStyleName("sendButton");
		absolutePanel.add(btnNoAceptar, 700, 140);
		btnNoAceptar.setSize("143px", "34px");
		
		//BOTON ENTERADO
		btnEnterado = new Button("Send");
		btnEnterado.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				loginService.Respuesta_Solicitud(id_Solicitud,id_empleado,id_Empleado_Solicitante,
						dateFecha1.getValue(),dateFecha2.getValue(),txtDescripcion.getText(),listTipoPermiso.getValue(listTipoPermiso.getSelectedIndex()),
						RespuestaJ,RespuestaR,"EE",new AsyncCallback<String>(){
                    public void onFailure(Throwable caught) 
                    {
        		        load.invisible();
                    	mensaje.setMensaje("alert alert-error", "Error !! \nal Guardar Datos");
                    }

					@Override
                    public void onSuccess(String result)
                    {
				        load.invisible();
						mensaje.setMensaje("alert alert-success", result);
                    }
					});
					
		        load.invisible();
			}
		});
		btnEnterado.setText("No Aceptar");
		btnEnterado.setStylePrimaryName("sendButton");
		btnEnterado.setStyleName("sendButton");
		absolutePanel.add(btnEnterado, 700, 200);
		btnEnterado.setSize("143px", "34px");
		
		Label lblNivelAcademico = new Label("Fecha Inicial");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 87);
		lblMotivo.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Fecha Final");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 119, 10);
		lblLoRecomienda.setSize("103px", "13px");
		
		Label lblTipoDePermiso = new Label("Tipo de Permiso");
		lblTipoDePermiso.setStyleName("label");
		absolutePanel.add(lblTipoDePermiso, 228, 10);
		lblTipoDePermiso.setSize("139px", "13px");
		
		Label lblNombreSolicitante = new Label("Nombre solicitante");
		lblNombreSolicitante.setStyleName("label");
		absolutePanel.add(lblNombreSolicitante, 480, 10);
		lblNombreSolicitante.setSize("139px", "13px");
		
		Label lblDiasDisponibles = new Label("Dias solicitados");
		lblDiasDisponibles.setStyleName("label");
		absolutePanel.add(lblDiasDisponibles, 480, 106);
		lblDiasDisponibles.setSize("77px", "13px");
		
		txtDisponibles = new TextBox();
		txtDisponibles.setEnabled(false);
		txtDisponibles.setText("0");
		txtDisponibles.setStylePrimaryName("gwt-TextBox2");
		txtDisponibles.setStyleName("gwt-TextBox2");
		txtDisponibles.setMaxLength(100);
		absolutePanel.add(txtDisponibles, 590, 138);
		txtDisponibles.setSize("89px", "34px");
		
		lblDiasDisponibles_1 = new Label("Dias disponibles");
		lblDiasDisponibles_1.setStyleName("label");
		absolutePanel.add(lblDiasDisponibles_1, 590, 106);
		lblDiasDisponibles_1.setSize("104px", "13px");
	}
	
	public void LlenarDatos(Long id, 
			Long id_Empleado_Solicitante,
			String txtDescripcion,
		    Long dateFecha1,
		    Long dateFecha2,
		    String tipoPermiso,
		    String nombre,
		    String dias,
		    String disponibles,
		    String RespuestaJ,
		    String RespuestaR,
		    char DeQuien)
	{
		boolean bandera = true;
		for(int i=0; i < this.listTipoPermiso.getItemCount() && bandera; i++){
			bandera = !this.listTipoPermiso.getValue(i).equals(tipoPermiso);
		    this.listTipoPermiso.setSelectedIndex(i);
		}
		this.id_Solicitud = id;
		this.id_Empleado_Solicitante = id_Empleado_Solicitante;
		this.txtDescripcion.setText(txtDescripcion);
		this.dateFecha1.setValue(new Date(dateFecha1));
		this.dateFecha2.setValue(new Date(dateFecha2));
		this.txtNombre.setText(nombre);
		this.txtDias.setText(dias);
		this.txtDisponibles.setText(disponibles);
		this.RespuestaJ 	= RespuestaJ;
		this.RespuestaR 	= RespuestaR;
		this.DeQuien 	= DeQuien;
	}
	
}
