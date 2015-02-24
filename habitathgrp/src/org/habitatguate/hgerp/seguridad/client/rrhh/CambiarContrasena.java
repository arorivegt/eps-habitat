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

public class CambiarContrasena extends Composite{
	
	private Loading load ;
    private Mensaje mensaje; 
    private Button 	btnCambiar;
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
        txtContrasenaActual.setText("");
        txtContrasenaActual.setStyleName("gwt-PasswordTextBox");
        txtContrasenaActual.getElement().setPropertyString("placeHolder", "Ingrese Contraseña Actual");
        rootPanel.add(txtContrasenaActual, 30, 67);
        txtContrasenaActual.setSize("241px", "49px");
        
        txtContrasenaNueva =new TextBox();
        txtContrasenaNueva.setText("");
        txtContrasenaNueva.setStyleName("gwt-PasswordTextBox");
        txtContrasenaNueva.getElement().setPropertyString("placeHolder", "Ingrese Contraseña nueva");
        rootPanel.add(txtContrasenaNueva, 30, 67);
        txtContrasenaNueva.setSize("241px", "49px");
        
        txtContrasenaNuevaRepetida =new TextBox();
        txtContrasenaNuevaRepetida.setText("");
        txtContrasenaNuevaRepetida.setStyleName("gwt-PasswordTextBox");
        txtContrasenaNuevaRepetida.getElement().setPropertyString("placeHolder", "Repetir Contraseña nueva");
        rootPanel.add(txtContrasenaNuevaRepetida, 30, 67);
        txtContrasenaNuevaRepetida.setSize("241px", "49px");
        
        btnCambiar = new Button("Send");
        btnCambiar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
                load.visible();
                if(txtContrasenaNueva.getText().equals(txtContrasenaNuevaRepetida.getText())){
	            	mensaje.setMensaje("alert alert-error", "Las contraseñas no coinciden");
                }else{

                	recursosHumanosService.obtenerUsuario(new AsyncCallback<String>() 
					{ 
                		public void onFailure(Throwable caught) {
                			load.invisible();
                			mensaje.setMensaje("alert alert-error", "Error !! \nal obtener Usuario");
                		}

						public void onSuccess(String result) {
		            		recursosHumanosService.CambiarContrasena(result, txtContrasenaNueva.getText(), txtContrasenaActual.getText(),new AsyncCallback<String>()
		    			    {
		    		            public void onFailure(Throwable caught) {
		    		                load.invisible();
		    		            	mensaje.setMensaje("alert alert-error", "Error !! \nal actualizar contraseña");
		    		            }
		    
		    					public void onSuccess(String result) {
		    			            load.invisible();
		    			            mensaje.setMensaje("alert alert-success", result);
		    		            }
		    
		    			    });
			            }

					});
                	
                }
        	}
        });
        btnCambiar.setText("Cambiar");
        btnCambiar.setStyleName("sendButton");
        rootPanel.add(btnCambiar, 30, 124);
        btnCambiar.setSize("243px", "44px");
        
        initWidget(rootPanel);
        
        Label lblNewLabel = new Label("Cambiar contraseña:");
        rootPanel.add(lblNewLabel, 30, 10);
        lblNewLabel.setSize("243px", "19px");
        

    }
        
}