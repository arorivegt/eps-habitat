package org.habitatguate.hgerp.seguridad.client.principal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class Registro extends Composite{
        
        
       private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
        
        public Registro() 
        {
        	
        	AbsolutePanel rootPanel = new AbsolutePanel();
        	rootPanel.setSize("1038px", "671px");
            rootPanel.setStyleName("body");
            
            Label lblNewLabel_1 = new Label("");
            lblNewLabel_1.setStyleName("gwt-Label-new");
            rootPanel.add(lblNewLabel_1, 489, 98);
            lblNewLabel_1.setSize("346px", "503px");
                    
           
            Label lblIniciarSesion = new Label("Formulario de Registro:");
            rootPanel.add(lblIniciarSesion, 615, 98);
            
            Image image_2 = new Image("images/imagenempresa.png");
            rootPanel.add(image_2, 27, 10);
            image_2.setSize("386px", "136px");
            
            final TextBox txtUser =new TextBox();
            txtUser.setStyleName("gwt-PasswordTextBox");
            txtUser.getElement().setAttribute("placeHolder", "Correo Electronico");
            rootPanel.add(txtUser, 543, 188);
            txtUser.setSize("325px", "49px");

            final PasswordTextBox txtPass =new PasswordTextBox();
            txtPass.setSize("325px", "49px");
            txtPass.getElement().setAttribute("placeHolder", "Password");
            rootPanel.add(txtPass, 543, 254);
            
            final PasswordTextBox txtRepitaPassword = new PasswordTextBox();
            txtRepitaPassword.getElement().setAttribute("placeHolder", "Repita la contraseña");
            rootPanel.add(txtRepitaPassword, 543, 317);
            txtRepitaPassword.setSize("325px", "49px");
            
            final TextBox txtNombre = new TextBox();
            txtNombre.setStyleName("gwt-PasswordTextBox");
            txtNombre.getElement().setAttribute("placeHolder", "Nombre");
            rootPanel.add(txtNombre, 543, 381);
            txtNombre.setSize("325px", "49px");
                                    
            final TextBox txtApellido = new TextBox();
            txtApellido.setStyleName("gwt-PasswordTextBox");
            txtApellido.getElement().setAttribute("placeHolder", "Apellido");
            rootPanel.add(txtApellido, 543, 447);
            txtApellido.setSize("325px", "49px");

            final DateBox dateBox = new DateBox();
            dateBox.setFireNullValues(true);
            dateBox.setStyleName("gwt-PasswordTextBox");
            dateBox.getElement().setAttribute("placeHolder", "Fecha Nacimiento");
            
    //        dateBox.getDatePicker().setYearArrowsVisible(true);
     //       dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
     //       dateBox.getDatePicker().setVisibleYearCount(100);
            
            rootPanel.add(dateBox, 543, 512);
            dateBox.setSize("325px", "49px");

            dateBox.setFormat(new DateBox.DefaultFormat 
            	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
            
            Label lblLleneLoQue = new Label("Llene lo que a contiuacion se le pide, todos los campos son obligatorios:");
            rootPanel.add(lblLleneLoQue, 543, 124);
            lblLleneLoQue.setSize("343px", "4px");
            
            Button button = new Button("Send");
            button.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {
//            		//validar correo         	
//            		
//                    String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$";
//                    String pass = "[A-Z][A-Za-z0-9]+{10}";
//                    String  MensajeError = "";
//                    boolean err = false;
//                    boolean valid = false;
//                    boolean valid2 = false;
//                    if(txtUser.getClass().toString().equals(String.class.toString())) {
//                            valid = ((String)txtUser.getText()).matches(emailPattern);
//                    } else {
//                            valid = ((Object)txtUser.getText()).toString().matches(emailPattern);
//                    }
//                    
//                    if(txtPass.getClass().toString().equals(String.class.toString())) {
//                        valid2 = ((String)txtPass.getText()).matches(pass);
//	                } else {
//	                     valid2 = ((Object)txtPass.getText()).toString().matches(pass);
//	                }
//                    
//                    if(!valid){
//                    	MensajeError = "\nEmail no valido";
//                    	err = true;
//                    }
//                    if(!valid2){
//                    	MensajeError = "\nContraseña debe  Iniciar con:"
//                    			+ "\n Mayuscula, seguido de letras o numero"
//                    			+ "\n y debe tener un tamaño de 10";
//                    	err = true;
//                    }
//                    if(txtNombre.getText().equals("")){
//                    	MensajeError = "\nNombre no debe estar vacio";
//                    	err = true;
//                    }if(txtApellido.getText().equals("")){
//                    	MensajeError = "\nApellido no debe estar vacio";
//                    	err = true;
//                    	
//                    }if(!txtPass.getText().equals(txtRepitaPassword.getText())){
//                    	MensajeError = "\nContraseña  no son iguales";
//                    	err = true;
//                    }
//                    
//                    try{
//    					new Date(dateBox.getValue().getTime());
//    				}catch(Exception e){
//                    	MensajeError = "\nFecha Nacimiento no valida";
//    					err = true;
//    				}
                    
                    if(false){
                    	//setMensaje("alert alert-error", MensajeError);
                    }else{
                    	loginService.Registro(txtUser.getText(),md5(txtPass.getText()),txtNombre.getText(), txtApellido.getText(),dateBox.getValue(),
                    			new AsyncCallback<String>() 
                                {
               					 public void onFailure(Throwable caught) 
                                 {
                                 	setMensaje("alert alert-error", "Hubo un error en el Registro, Intentelo mas tarde");
               					 }
               					 public void onSuccess(String result)
                                    {
               						 if(result.equals("no existe"))
                                      	setMensaje("alert alert-success", "registro exitoso");
               						 else if(result.equals("error"))
                                       	setMensaje("alert alert-error", "error al registrar");
               						 else
               							 setMensaje("alert alert-error", result);

               							 
                                    }
               				});
               				
               			}
                    }
            	
            });
            
            button.setText("Aceptar");
            button.setStyleName("sendButton");
            rootPanel.add(button, 543, 585);
            button.setSize("327px", "44px");
            
            initWidget(rootPanel);
            

        }
        
		private String md5(String cadena){
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(cadena.getBytes());
                BigInteger number = new BigInteger(1, messageDigest);
                String hashtext = number.toString(16);
                // Now we need to zero pad it if you actually want the full 32 chars.
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            }
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            
    	}
        public void setMensaje(String estilo, String mensaje){
            final DialogBox Registro2 = new DialogBox();
            final HTML serverResponseLabel = new HTML();
            final Button close= new Button("x");
            Mensaje inicio = new Mensaje();
            
            Registro2.setStyleName(estilo);
            inicio.mensajeEntrada(mensaje);
            inicio.mensajeEstilo(estilo);
            close.addStyleName("close");
            VerticalPanel dialogVPanel = new VerticalPanel();
            dialogVPanel.add(serverResponseLabel );
            dialogVPanel.add(inicio);
            dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
            dialogVPanel.add(close);
            Registro2 .setWidget(dialogVPanel);
            Registro2 .setModal(true);
            Registro2 .setGlassEnabled(true);
            Registro2 .setAnimationEnabled(true);
            Registro2 .center();
            Registro2 .show();
            close.setFocus(true);
        
            close.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Registro2.hide();
            }
        });
        }
    
        
}