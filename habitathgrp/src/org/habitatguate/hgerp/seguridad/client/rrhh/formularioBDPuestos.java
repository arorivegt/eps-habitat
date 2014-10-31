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

public class formularioBDPuestos extends Composite {

	private Mensaje mensaje; 
	private BDpuestos a;
	private Long id_puesto = 0L;
	private boolean bandera = true;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
    private DateBox dateFecha;
	private TextBox txtPuesto;
	private TextArea txtFunciones;
    private Loading load ;
	
	public formularioBDPuestos(BDpuestos a) {

		mensaje = new Mensaje();
		this.a = a;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("850px", "100px");
		
		txtPuesto = new TextBox();
		txtPuesto.setStyleName("gwt-TextBox2");
		txtPuesto.setMaxLength(100);
		absolutePanel.add(txtPuesto, 10, 29);
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
		absolutePanel.add(dateFecha, 10, 89);
		dateFecha.setSize("227px", "34px");

		
		txtFunciones = new TextArea();
		txtFunciones.getElement().setAttribute("maxlength", "500");
		txtFunciones.setStyleName("gwt-TextBox");
		absolutePanel.add(txtFunciones, 259, 27);
		txtFunciones.setSize("348px", "58px");
		
				Button btnGuardar = new Button("Send");
				btnGuardar.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
				        load.visible();
						try{
							new Date(dateFecha.getValue().getTime());
						}catch(Exception e){
							dateFecha.setValue(new Date(1407518124684L));
						}
					
						if(bandera) {					
							loginService.Insertar_BDPuesto(dateFecha.getValue(), txtPuesto.getText(), 
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
							loginService.Actualizar_BDPuesto(id_puesto, dateFecha.getValue(), txtPuesto.getText(), 
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
				absolutePanel.add(btnGuardar, 682, 29);
				btnGuardar.setSize("227px", "34px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormularioSinDatos();
			}
		});
		button.setText("Quitar formulario");
		button.setStylePrimaryName("sendButton");
		button.setStyleName("sendButton");
		absolutePanel.add(button, 682, 91);
		button.setSize("227px", "34px");

		
		Label lblNivelAcademico = new Label("Puesto");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Fecha");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 10, 70);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblFunciones = new Label("Funciones");
		lblFunciones.setStyleName("label");
		absolutePanel.add(lblFunciones, 272, 10);
		lblFunciones.setSize("192px", "13px");
	}
	
	private void EliminarFormularioSinDatos(){
        	a.EliminarFormulario(this);
    }
	
	public void LlenarDatos(Long id, Long dateFecha,
			 String txtPuesto,
			 String txtFunciones)
	{
		this.id_puesto = id;
		this.bandera = false;
		this.dateFecha.setValue(new Date(dateFecha));
		this.txtPuesto.setText(txtPuesto);
		this.txtFunciones.setText(txtFunciones);
	}
	
}
