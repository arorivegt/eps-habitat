package org.habitatguate.hgerp.seguridad.client.principal;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.rrhh.valores_sesion;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Index implements EntryPoint {
        
        final TextBox txtuser =new TextBox();
        final PasswordTextBox txtpass =new PasswordTextBox();
    	private DialogBox Registro = new DialogBox();
        private final LoginServiceAsync loginService = GWT.create(LoginService.class);
        
        @Override
        public void onModuleLoad() 
        {
            
             final DialogBox dialogBox = new DialogBox();
             
                dialogBox.setText("Autenticacion");
                dialogBox.setAnimationEnabled(true);
                final Button closeButton = new Button("cerrar");
                
                // We can set the id of a widget by accessing its Element
                closeButton.getElement().setId("closeButton");
                final Label textToServerLabel = new Label();
                final HTML serverResponseLabel = new HTML();
                VerticalPanel dialogVPanel = new VerticalPanel();
                dialogVPanel.addStyleName("dialogVPanel");
                dialogVPanel.add(serverResponseLabel);
                dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
                dialogVPanel.add(closeButton);
                dialogBox.setWidget(dialogVPanel);
        
                // Add a handler to close the DialogBox

                
                // Create a handler for the sendButton and nameField
                class MyHandler implements ClickHandler
                {
                        
                        public void onClick(ClickEvent event) 
                        {
                                login();
                        }
                        private void login() 
                        {
                                // First, we validate the input.
                                final Button sendButton = new Button("Send");   
                                String usertxt = txtuser.getText();
                                String passtxt= txtpass.getText();
                                // Then, we send the input to the server.
                                sendButton.setEnabled(false);
                                                
                                closeButton.addClickHandler(new ClickHandler() 
                                {
                                        public void onClick(ClickEvent event) 
                                        {
                                                dialogBox.hide();
                                                sendButton.setEnabled(true);
                                                sendButton.setFocus(true);
                                        }
                                });
                                
                                textToServerLabel.setText(usertxt+" / "+passtxt);
                                serverResponseLabel.setText("");
                                                
                                loginService.login_inicio(usertxt,passtxt, new AsyncCallback<valores_sesion>() 
                                {
                                        public void onFailure(Throwable caught) 
                                        {
                                                // Show the RPC error message to the user
                                                dialogBox.setText("Error en login :(");
                                                dialogBox.center();
                                                closeButton.setFocus(true);
                                        }
                                        
                                        public void onSuccess(valores_sesion result)
                                        {
                                                //si la autentificacion es correcta limpia y contruye el menu
                                                if(result.isCorrecto())
                                                {
                                                        Panel inicio = new Panel();
                                                        inicio.setId_empleado(result.getId_empleado());
                                                        RootPanel.get().clear();
                                                        RootPanel.get().add(inicio);
                                                        //RootPanel.get().add(buildMenu(result));
                                                }else
                                                {
                                                        dialogBox.setText("Usuario o password incorrecto");
                                                        dialogBox.center();
                                                        closeButton.setFocus(true);
                                                }
                                                                                
                                        }
                                 });
                        }
                }// Add a handler to send the name to the server
                
                MyHandler handler = new MyHandler();
            RootPanel rootPanel = RootPanel.get();
            rootPanel.setStyleName("body");
                
            // Add some standard form options
                            
            Label lblNewLabel = new Label("Inicio");
            rootPanel.add(lblNewLabel, 508, 72);
            lblNewLabel.setSize("346px", "30px");
            
            Label lblNewLabel_1 = new Label("");
            lblNewLabel_1.setStyleName("gwt-Label-new");
            rootPanel.add(lblNewLabel_1, 508, 135);
            lblNewLabel_1.setSize("346px", "216px");
            rootPanel.add(txtuser, 545, 161);
            txtuser.addBlurHandler(new BlurHandler() {
                public void onBlur(BlurEvent event) {

                        if (txtuser.getText().equals(""))
                        {
                                txtuser.setText("Usuario");
                        }
                }
            });
            txtuser.addFocusHandler(new FocusHandler() {
                public void onFocus(FocusEvent event) {
                        if (txtuser.getText().equals("Usuario"))
                        {
                                txtuser.setText("");
                        }
                                        
                }
            });
            txtuser.setText("Usuario");
            txtuser.setSize("321px", "36px");
            rootPanel.add(txtpass, 545, 226);
            txtpass.addFocusHandler(new FocusHandler() {
                public void onFocus(FocusEvent event) {
                        if (txtpass.getText().equals("password"))
                        {
                                txtpass.setText("");
                        }
                }
            });
            txtpass.addBlurHandler(new BlurHandler() {
                public void onBlur(BlurEvent event) {
                        if (txtpass.getText().equals(""))
                        {
                                txtpass.setText("password");
                        }
                }
            });
            
                    txtpass.setText("password");
                    txtpass.setSize("321px", "36px");
                    
            final Button btnIniciar = new Button("Send");
            rootPanel.add(btnIniciar, 545, 286);
            btnIniciar.setText("Iniciar sesion");
            btnIniciar.setStyleName("sendButton");
            btnIniciar.addClickHandler(handler);
            btnIniciar.setSize("341px", "44px");
                    
                   final  Button button = new Button("Send");
                    button.addClickHandler(new ClickHandler() {
                    	public void onClick(ClickEvent event) {

                            final Button close= new Button("cerrar");
                            VerticalPanel dialogVPanel = new VerticalPanel();
                            HTML serverResponseLabel = new HTML();
                            dialogVPanel.addStyleName("dialogVPanel");
                    		formularioRegistro inicio = new formularioRegistro();
                    		Registro .setText("Registro");
                    		dialogVPanel.add(serverResponseLabel );
                    		dialogVPanel.add(inicio);
                            dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
                            dialogVPanel.add(close);
                            Registro .setWidget(dialogVPanel);
                    		Registro .setModal(true);
                    		Registro .setGlassEnabled(true);
                    		Registro .setAnimationEnabled(true);
                    		Registro .center();
                    		Registro .show();
                            close.setFocus(true);
                            close.addClickHandler(new ClickHandler() {
                    			public void onClick(ClickEvent event) {
                    				Registro.hide();
                                    button.setEnabled(true);
                                    button.setFocus(true);
                    			}
                            });
                            //RootPanel.get().clear();
                            //RootPanel.get().add(inicio);
                    	}
                    });
                    button.setText("Registrarse");
                    button.setStyleName("sendButton");
                    rootPanel.add(button, 545, 334);
                    button.setSize("341px", "44px");
                    
                    Image image = new Image("images/mailicon.png");
                    rootPanel.add(image, 522, 175);
                    image.setSize("16px", "10px");
                    
                    Image image_1 = new Image("images/passicon.png");
                    rootPanel.add(image_1, 522, 236);
                    image_1.setSize("9px", "17px");
            //RootPanel.get().add(dialogBox);
            

        }
}