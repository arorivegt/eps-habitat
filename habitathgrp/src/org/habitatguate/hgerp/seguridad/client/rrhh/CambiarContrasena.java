package org.habitatguate.hgerp.seguridad.client.rrhh;


import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class CambiarContrasena extends Composite{
	
	private Loading load ;
    private Mensaje mensaje; 
    private Button 	btnAsignar;
    private AbsolutePanel rootPanel;
    private TextBox txtContrasenaActual;
    private TextBox txtContrasenaNueva;
    private TextBox txtContrasenaNuevaRepetida;
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
	
    public CambiarContrasena() 
    {
    	
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		mensaje = new Mensaje();
		
    	rootPanel = new AbsolutePanel();
    	rootPanel.setSize("299px", "199px");
        rootPanel.setStyleName("body");
        
        Label lblNewLabel_1 = new Label("");
        lblNewLabel_1.setStyleName("gwt-Label-new");
        rootPanel.add(lblNewLabel_1, 10, 5);
        lblNewLabel_1.setSize("205px", "142px");
        
        txtContrasenaActual =new TextBox();
        txtContrasenaActual.addChangeHandler(new ChangeHandler() {
        	public void onChange(ChangeEvent event) {
        		if(txtContrasenaActual.getText().equals("")) {txtContrasenaActual.setText("0");}
				else if(txtContrasenaActual.getText().equals(null)) {txtContrasenaActual.setText("0");}
				else{
					try{
						Integer.parseInt(txtContrasenaActual.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nEdad no valida");
						txtContrasenaActual.setText("0");
					}
				}
        	}
        });
        txtContrasenaActual.setText("26");
        txtContrasenaActual.setStyleName("gwt-PasswordTextBox");
        txtContrasenaActual.getElement().setAttribute("placeHolder", "Ingrese correo");
        rootPanel.add(txtContrasenaActual, 30, 67);
        txtContrasenaActual.setSize("241px", "49px");
        
        btnAsignar = new Button("Send");
        btnAsignar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
                load.visible();
        		recursosHumanosService.Insertar_Dias_Vacaciones(Integer.parseInt(txtContrasenaActual.getText()),new AsyncCallback<String>()
			    {
		            public void onFailure(Throwable caught) {
		                load.invisible();
		            	mensaje.setMensaje("alert alert-error", "Error !! \nal asignar dias");
		            }

					public void onSuccess(String result) {
			            load.invisible();
			            mensaje.setMensaje("alert alert-success", result);
		            }

			    });
        	}
        });
        btnAsignar.setText("Aumentar");
        btnAsignar.setStyleName("sendButton");
        rootPanel.add(btnAsignar, 30, 124);
        btnAsignar.setSize("243px", "44px");
        
        initWidget(rootPanel);
        
        Label lblNewLabel = new Label("Dias de vacaciones a dar a todo el personal:");
        rootPanel.add(lblNewLabel, 30, 10);
        lblNewLabel.setSize("243px", "19px");
        

    }
        
}