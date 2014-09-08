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
import com.google.gwt.user.client.ui.HTMLPanel;

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
            
            Label lblNewLabel_1 = new Label("");
            lblNewLabel_1.setStyleName("gwt-Label-new");
            rootPanel.add(lblNewLabel_1, 489, 98);
            lblNewLabel_1.setSize("346px", "254px");
            txtuser.setStyleName("gwt-PasswordTextBox");
            rootPanel.add(txtuser, 545, 152);
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
            txtuser.setSize("325px", "49px");
            rootPanel.add(txtpass, 545, 218);
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
                    txtpass.setSize("325px", "49px");
                    
            final Button btnIniciar = new Button("Send");
            rootPanel.add(btnIniciar, 545, 286);
            btnIniciar.setText("Iniciar sesion");
            btnIniciar.setStyleName("sendButton");
            btnIniciar.addClickHandler(handler);
            btnIniciar.setSize("327px", "44px");
                    
                   final  Button button = new Button("Send");
                    button.addClickHandler(new ClickHandler() {
                    	public void onClick(ClickEvent event) {

                            final Button close= new Button("cerrar");
                            VerticalPanel dialogVPanel = new VerticalPanel();
                            dialogVPanel.addStyleName("gwt-TextBox2");
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
                    rootPanel.add(button, 545, 346);
                    button.setSize("327px", "44px");
                    
                    Image image = new Image("images/mailicon.png");
                    rootPanel.add(image, 522, 175);
                    image.setSize("16px", "10px");
                    
                    Image image_1 = new Image("images/passicon.png");
                    rootPanel.add(image_1, 522, 236);
                    image_1.setSize("9px", "17px");
                    
                    Label lblIniciarSesion = new Label("Iniciar Sesion");
                    rootPanel.add(lblIniciarSesion, 639, 108);
                    
                    Image image_2 = new Image("images/imagenempresa.png");
                    rootPanel.add(image_2, 27, 10);
                    image_2.setSize("386px", "136px");
                    
                    //RootPanel.get().add(dialogBox);
            

        }
}