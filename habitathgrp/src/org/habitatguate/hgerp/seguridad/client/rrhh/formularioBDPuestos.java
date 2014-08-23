package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class formularioBDPuestos extends Composite {

	private BDpuestos a;
	private Long id_puesto = 0L;
	private boolean bandera = true;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    
    private DateBox dateFecha;
	private TextBox txtPuesto;
	private TextArea txtFunciones;
	
	public formularioBDPuestos(BDpuestos a) {

		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("702px", "80px");
		
		txtPuesto = new TextBox();
		txtPuesto.setStyleName("gwt-TextBox2");
		txtPuesto.setMaxLength(100);
		absolutePanel.add(txtPuesto, 10, 29);
		txtPuesto.setSize("137px", "11px");
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407519035556L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 68);
		dateFecha.setSize("137px", "11px");
		
		txtFunciones = new TextArea();
		txtFunciones.getElement().setAttribute("maxlength", "500");
		txtFunciones.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtFunciones, 187, 29);
		txtFunciones.setSize("318px", "61px");
		
				Button btnGuardar = new Button("Send");
				btnGuardar.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
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
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

								@Override
                        public void onSuccess(Long result)
                        {
									id_puesto = result;
									bandera = false;
									Window.alert("Datos Guardados exitosamente!!! ");
                        }
								});
						}else{
							loginService.Actualizar_BDPuesto(id_puesto, dateFecha.getValue(), txtPuesto.getText(), 
								txtFunciones.getText(), new AsyncCallback<Long>(){
                    public void onFailure(Throwable caught) 
                    {
                        Window.alert("Error  al Actualizar Datos"+caught);
                    }

							@Override
                    public void onSuccess(Long result)
                    {
								bandera = false;
                    	Window.alert("Datos Actualizados exitosamente!!! ");
                    }
							});
						}
					}
					
				});
				btnGuardar.setText("Guardar");
				btnGuardar.setStylePrimaryName("gwt-TextBox2");
				btnGuardar.setStyleName("gwt-TextBox2");
				absolutePanel.add(btnGuardar, 547, 29);
				btnGuardar.setSize("157px", "20px");
		
		Label lblNivelAcademico = new Label("Puesto");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Fecha");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 10, 54);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblFunciones = new Label("Funciones");
		lblFunciones.setStyleName("label");
		absolutePanel.add(lblFunciones, 187, 10);
		lblFunciones.setSize("192px", "13px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormularioSinDatos();
			}
		});
		button.setText("Quitar formulario");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("gwt-TextBox2");
		absolutePanel.add(button, 547, 78);
		button.setSize("157px", "20px");
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
