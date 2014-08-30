package org.habitatguate.hgerp.seguridad.client.principal;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.event.dom.client.BlurHandler;

public class formularioRegistro extends Composite {

    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	private Button btnGuardar;
    private TextBox txtUsuario;
    private AbsolutePanel absolutePanel;
    private PasswordTextBox txtContrasena;
    
	public formularioRegistro() {
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("220px", "170px");
		
		txtUsuario = new TextBox();
		txtUsuario.setText("Usuario");

        txtUsuario.addBlurHandler(new BlurHandler() {
            public void onBlur(BlurEvent event) {

                    if (txtUsuario.getText().equals(""))
                    {
                            txtUsuario.setText("Usuario");
                    }
            }
        });
        txtUsuario.addFocusHandler(new FocusHandler() {
            public void onFocus(FocusEvent event) {
                    if (txtUsuario.getText().equals("Usuario"))
                    {
                            txtUsuario.setText("");
                    }
                                    
            }
        });
		txtUsuario.setMaxLength(50);
		txtUsuario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtUsuario, 20, 35);
		txtUsuario.setSize("227px", "34px");
		txtContrasena = new PasswordTextBox();
		txtContrasena.setText("password");
        txtContrasena.addFocusHandler(new FocusHandler() {
            public void onFocus(FocusEvent event) {
                    if (txtContrasena.getText().equals("password"))
                    {
                            txtContrasena.setText("");
                    }
            }
        });
        txtContrasena.addBlurHandler(new BlurHandler() {
            public void onBlur(BlurEvent event) {
                    if (txtContrasena.getText().equals(""))
                    {
                            txtContrasena.setText("password");
                    }
            }
        });
		absolutePanel.add(txtContrasena, 20, 106);
		txtContrasena.setSize("227px", "34px");
		
		btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 20, 166);
		btnGuardar.setSize("227px", "34px");
		
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				 loginService.Registro(txtUsuario.getText(),txtContrasena.getText(), new AsyncCallback<String>() 
                 {
					 public void onFailure(Throwable caught) 
                     {
						 Window.alert("Error al registrarse "+caught);
					 }
					 public void onSuccess(String result)
                     {
						 if(result.equals("no existe"))
							 Window.alert("registro exitoso");
						 else if(result.equals("error"))
							 Window.alert("error al registrar");
						 else
							 Window.alert(result);

							 
                     }
				});
				
			}
		});
		Label lblUsuario = new Label("Usuario");
		lblUsuario.setStyleName("label");
		absolutePanel.add(lblUsuario, 95, 10);
		lblUsuario.setSize("192px", "19px");
		
		Label lblContrasea = new Label("Contraseña");
		lblContrasea.setStyleName("label");
		absolutePanel.add(lblContrasea, 95, 81);
		lblContrasea.setSize("192px", "19px");
	}


}
