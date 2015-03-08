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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class FormularioBDPuestos extends Composite {

	private BDpuestos bdPuestos;
	private Mensaje mensaje; 
	private Long id_puesto = 0L;
	private boolean bandera = true;

    private Loading load ;
    private Button btnGuardar;
    private Button btnEliminar;
    private DateBox dateFecha;
	private TextBox txtPuesto;
    private TextBox txtIdPuesto ;
	private TextArea txtFunciones;
	private AbsolutePanel absolutePanel;
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
	
	public FormularioBDPuestos(BDpuestos bdPuestos) {

		mensaje = new Mensaje();
		this.bdPuestos = bdPuestos;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("850px", "100px");
		
		txtIdPuesto = new TextBox();
		txtIdPuesto.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtIdPuesto.getText().equals("")) {txtIdPuesto.setText("0");}
				else if(txtIdPuesto.getText().equals(null)) {txtIdPuesto.setText("0");}
				else{
					try{
						Long.parseLong(txtIdPuesto.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nid debe ser un numero correlativo y no existente");
						txtIdPuesto.setText("0");
					}
				}
			}
		});
		txtIdPuesto.setStyleName("gwt-TextBox2");
		txtIdPuesto.setMaxLength(100);
		absolutePanel.add(txtIdPuesto, 10, 63);
		txtIdPuesto.setSize("74px", "34px");
		
		txtPuesto = new TextBox();
		txtPuesto.setStyleName("gwt-TextBox2");
		txtPuesto.setMaxLength(100);
		absolutePanel.add(txtPuesto, 118, 29);
		txtPuesto.setSize("227px", "34px");

		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date(1407519035556L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 118, 89);
		dateFecha.setSize("227px", "34px");

		
		txtFunciones = new TextArea();
		txtFunciones.getElement().setAttribute("maxlength", "500");
		txtFunciones.setStyleName("gwt-TextBox");
		absolutePanel.add(txtFunciones, 372, 27);
		txtFunciones.setSize("304px", "58px");
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        load.visible();
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
			
				if(bandera) {					
					recursosHumanosService.Insertar_BDPuesto(Long.parseLong(txtIdPuesto.getText()),dateFecha.getValue(), txtPuesto.getText(), 
							txtFunciones.getText(), new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                        }

								@Override
                        public void onSuccess(Long result)
                        {
							        load.invisible();
									id_puesto = result;
									bandera = false;
									mensaje.setMensaje("alert alert-success", 
		                        			"Datos Guardados\n exitosamente!!!");
                        }
								});
				}else{
					recursosHumanosService.Actualizar_BDPuesto(id_puesto, dateFecha.getValue(), txtPuesto.getText(), 
						txtFunciones.getText(), new AsyncCallback<Long>(){
			            public void onFailure(Throwable caught) 
			            {
					        load.invisible();
			            	mensaje.setMensaje("alert alert-error", 
			            			"Error !! \nal Actualizar Datos");
			            }
			
								@Override
			            public void onSuccess(Long result)
			            {
							        load.invisible();
									bandera = false;
									mensaje.setMensaje("alert alert-success", 
				                			"Datos Actualizados\n exitosamente!!!");
			            }
					});
				}
		        load.invisible();
			}
			
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 763, 29);
		btnGuardar.setSize("146px", "34px");
		
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormularioSinDatos();
			}
		});
		btnEliminar.setText("Quitar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 763, 91);
		btnEliminar.setSize("146px", "34px");

		
		Label lblNivelAcademico = new Label("Nombre del puesto");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 118, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Fecha de Creacion del Puesto");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 118, 70);
		lblTitulodiploma.setSize("229px", "13px");
		
		Label lblFunciones = new Label("Descripcion de Funciones del Puesto");
		lblFunciones.setStyleName("label");
		absolutePanel.add(lblFunciones, 385, 10);
		lblFunciones.setSize("341px", "13px");
		
		Label lblIdPuesto = new Label("Id puesto");
		lblIdPuesto.setStyleName("label");
		absolutePanel.add(lblIdPuesto, 10, 29);
		lblIdPuesto.setSize("102px", "13px");
	}
	
	private void EliminarFormularioSinDatos(){
        	bdPuestos.EliminarFormulario(this);
    }
	
	public void LlenarDatos(Long id, Long dateFecha,
			 String txtPuesto,
			 String txtFunciones)
	{
		this.txtIdPuesto.setText(""+id);
		this.txtIdPuesto.setEnabled(false);
		this.id_puesto = id;
		this.bandera = false;
		this.dateFecha.setValue(new Date(dateFecha));
		this.txtPuesto.setText(txtPuesto);
		this.txtFunciones.setText(txtFunciones);
	}
	
}
