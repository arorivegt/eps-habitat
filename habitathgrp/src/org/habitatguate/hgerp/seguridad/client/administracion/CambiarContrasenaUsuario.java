package org.habitatguate.hgerp.seguridad.client.administracion;


import java.util.List;

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
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SuggestBox;

public class CambiarContrasenaUsuario extends Composite{
	
	private Loading load ;
    private Mensaje mensaje; 
    private Button 	btnCambiar;
    private AbsolutePanel rootPanel;
    private PasswordTextBox txtContrasenaActual;
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private SuggestBox txtUsuario;
	
    public CambiarContrasenaUsuario() 
    {
    	
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		mensaje = new Mensaje();
		
    	rootPanel = new AbsolutePanel();
    	rootPanel.setSize("297px", "323px");
        rootPanel.setStyleName("body");
        
        Label lblNewLabel_1 = new Label("");
        lblNewLabel_1.setStyleName("gwt-Label-new");
        rootPanel.add(lblNewLabel_1, 10, 5);
        lblNewLabel_1.setSize("207px", "215px");
        
        txtUsuario =  new SuggestBox(createCountriesOracle());
        txtUsuario.setStyleName("gwt-PasswordTextBox");
        txtUsuario.getElement().setAttribute("placeHolder", "Escriba el Usuario");
        rootPanel.add(txtUsuario, 30, 57);
        txtUsuario.setSize("241px", "49px");
        
        txtContrasenaActual =new PasswordTextBox();
        txtContrasenaActual.setText("");
        txtContrasenaActual.setStyleName("gwt-PasswordTextBox");
        txtContrasenaActual.getElement().setAttribute("placeHolder", "Ingrese Contraseña");
        rootPanel.add(txtContrasenaActual, 30, 127);
        txtContrasenaActual.setSize("241px", "49px");
        
        btnCambiar = new Button("Send");
        btnCambiar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
                load.visible();
            	
        		recursosHumanosService.CambiarContrasenaAdmin(txtUsuario.getText(), txtContrasenaActual.getText(),new AsyncCallback<String>()
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
        btnCambiar.setText("Cambiar");
        btnCambiar.setStyleName("sendButton");
        rootPanel.add(btnCambiar, 30, 213);
        btnCambiar.setSize("243px", "44px");
        
        initWidget(rootPanel);
        
        Label lblNewLabel = new Label("Cambiar contraseña:");
        rootPanel.add(lblNewLabel, 59, 5);
        lblNewLabel.setSize("174px", "19px");
        

    }
    
    MultiWordSuggestOracle createCountriesOracle()
	{
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
	    recursosHumanosService.getCorreos(new AsyncCallback<List<String>>()
	    {
            public void onFailure(Throwable caught) 
            {
            }

			public void onSuccess(List<String> listCorreos)
            {
				if(!listCorreos.isEmpty())
				{	
					for(String correo: listCorreos){
						oracle.add(correo);
					}
				}
            }

	    });
	    return oracle;
    }
        
}