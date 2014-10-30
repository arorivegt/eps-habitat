package org.habitatguate.hgerp.seguridad.client.principal;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.rrhh.valores_sesion;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
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
        Mensaje inicio;
        Loading load ;
        private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
        
        @Override
        public void onModuleLoad() 
        {
//        	load = new Loading();
//            load.Mostrar();
        	txtuser.setText("anibal@gmail.com");
        	txtpass.setText("Aqwe123");
        	inicio=  new Mensaje();
         	
        
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
                           
                           // load.visible();
                            loginService.login_inicio(usertxt,passtxt, new AsyncCallback<valores_sesion>() 
                            {
                                    public void onFailure(Throwable caught) 
                                    {
                                       // load.invisible();

                                		inicio.setMensaje("alert alert-error","Error!! \nEn el servicio "
                            				+ "\n no se pudo\n iniciar ");
                                    }
                                    
                                    public void onSuccess(valores_sesion result)
                                    {
                                        //load.invisible();
                                            //si la autentificacion es correcta limpia y contruye el menu
                                           if(result.isCorrecto())
                                            {
                                                    Panel inicio = new Panel();
                                                    inicio.setId_empleado(result.getId_empleado());
                                                    RootPanel.get().clear();
                                                    RootPanel.get().add(inicio);
                                            }else
                                            {
                                        		inicio.setMensaje("alert alert-error", "Error\n En el usuario y/o Contraseña");
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
            txtuser.getElement().setAttribute("placeHolder", "Usuario@habitat.com");
            rootPanel.add(txtuser, 545, 152);
            txtuser.setSize("325px", "49px");
            rootPanel.add(txtpass, 545, 218);
            
            txtpass.setSize("325px", "49px");
            txtpass.getElement().setAttribute("placeHolder", "password");
            final Button btnIniciar = new Button("Send");
            rootPanel.add(btnIniciar, 545, 286);
            btnIniciar.setText("Iniciar sesion");
            btnIniciar.setStyleName("sendButton");
            btnIniciar.addClickHandler(handler);
            btnIniciar.setSize("327px", "44px");
                    
           final  Button button = new Button("Send");
            button.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {
            		Registro nuevo = new Registro();
                    RootPanel.get().clear();
                    RootPanel.get().add(nuevo);
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
            

        }
}