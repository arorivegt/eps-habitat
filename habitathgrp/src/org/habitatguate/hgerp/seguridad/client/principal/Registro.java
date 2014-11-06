package org.habitatguate.hgerp.seguridad.client.principal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class Registro extends Composite{
        

	   private Loading load ;
       private Mensaje inicio;
       private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
        
        public Registro() 
        {

        	load = new Loading();
        	inicio=  new Mensaje();
            load.Mostrar();
            load.invisible();
        	AbsolutePanel rootPanel = new AbsolutePanel();
        	rootPanel.setSize("1038px", "815px");
            rootPanel.setStyleName("body");
            
            Label lblNewLabel_1 = new Label("");
            lblNewLabel_1.setStyleName("gwt-Label-new");
            rootPanel.add(lblNewLabel_1, 489, 98);
            lblNewLabel_1.setSize("346px", "652px");
                    
           
            Label lblIniciarSesion = new Label("Formulario de Registro:");
            rootPanel.add(lblIniciarSesion, 615, 98);
            
            Image image_2 = new Image("images/imagenempresa.png");

            image_2.addClickHandler(new ClickHandler() {
    			public void onClick(ClickEvent event) {
	        			Window.Location.reload();
    			}
    		});
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
            txtNombre.getElement().setAttribute("placeHolder", "Primer Nombre");
            rootPanel.add(txtNombre, 543, 381);
            txtNombre.setSize("325px", "49px");
            
            final TextBox txtNombre2 = new TextBox();
            txtNombre2.setStyleName("gwt-PasswordTextBox");
            txtNombre2.getElement().setAttribute("placeHolder", "Segundo Nombre");
            rootPanel.add(txtNombre2, 543, 444);
            txtNombre2.setSize("325px", "49px");

            final DateBox dateBox = new DateBox();
            dateBox.setValue(new Date());
            dateBox.getTextBox().setReadOnly(true);
            dateBox.setFireNullValues(true);
            dateBox.setStyleName("gwt-PasswordTextBox");
            dateBox.getElement().setAttribute("placeHolder", "Fecha Nacimiento");
            
            dateBox.getDatePicker().setYearArrowsVisible(true);
            dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
            dateBox.getDatePicker().setVisibleYearCount(100);
            
            final TextBox txtApellido2 = new TextBox();
            txtApellido2.setStyleName("gwt-PasswordTextBox");
            txtApellido2.getElement().setAttribute("placeHolder", "Segundo Apellido");
            
            final TextBox txtApellido = new TextBox();
            txtApellido.setStyleName("gwt-PasswordTextBox");
            txtApellido.getElement().setAttribute("placeHolder", "Primer Apellido");
            rootPanel.add(txtApellido, 543, 510);
            txtApellido.setSize("325px", "49px");
            rootPanel.add(txtApellido2, 543, 572);
            txtApellido2.setSize("325px", "49px");
            
            rootPanel.add(dateBox, 543, 646);
            dateBox.setSize("325px", "49px");

            dateBox.setFormat(new DateBox.DefaultFormat 
            	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
            
            Button button = new Button("Send");
            button.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {
            		//validar correo         	

                    load.visible();
                    String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$";
                    //String pass = "^[A-Z][A-Za-z0-9]+{10}$";
                    String  MensajeError = "";
                    boolean err = false;
                    boolean valid = false;
                    boolean valid2 = true;
                    if(txtUser.getClass().toString().equals(String.class.toString())) {
                            valid = ((String)txtUser.getText()).matches(emailPattern);
                    } else {
                            valid = ((Object)txtUser.getText()).toString().matches(emailPattern);
                    }
                    
//                    if(txtPass.getClass().toString().equals(String.class.toString())) {
//                        valid2 = ((String)txtPass.getText()).matches(pass);
//	                } else {
//	                     valid2 = ((Object)txtPass.getText()).toString().matches(pass);
//	                }
                    
                    if(!valid){
                    	MensajeError = "\nEmail no valido";
                    	err = true;
                    }
                    else if(!valid2){
                    	MensajeError = "\nContraseña debe  Iniciar con:"
                    			+ "\n Mayuscula, seguido de letras o numero"
                    			+ "\n y debe tener un tamaño de 10";
                    	err = true;
                    }
                    else if(txtNombre.getText().equals("")){
                    	MensajeError = "\nNombre no debe estar vacio";
                    	err = true;
                    }else if(txtApellido.getText().equals("")){
                    	MensajeError = "\nApellido no debe estar vacio";
                    	err = true;
                    	
                    }else if(txtNombre2.getText().equals("")){
                    	MensajeError = "\nSegundo Nombre no debe estar vacio";
                    	err = true;
                    }else if(txtApellido2.getText().equals("")){
                    	MensajeError = "\nSegundo Apellido no debe estar vacio";
                    	err = true;
                    	
                    }else if(!txtPass.getText().equals(txtRepitaPassword.getText())){
                    	MensajeError = "\nContraseña  no son iguales";
                    	err = true;
                    }
                    
                    
                    if(err){
                        load.invisible();
                    	inicio.setMensaje("alert alert-error", MensajeError);
                    }else{
                    	loginService.Registro(txtUser.getText(),md5(txtPass.getText()),txtNombre.getText(), 
                    			txtApellido.getText(),dateBox.getValue(),txtNombre2.getText(), txtApellido2.getText(),
                    			new AsyncCallback<String>() 
                                {
               					 public void onFailure(Throwable caught) 
                                 {
               			            load.invisible();
               			         inicio.setMensaje("alert alert-error", "Hubo un error en el Registro, Intentelo mas tarde");
               					 }
               					 public void onSuccess(String result)
                                  {
               			            load.invisible();
               						 if(result.equals("no existe")){
               							inicio.setMensaje("alert alert-success", "registro exitoso");
               		        			Window.Location.reload();
               							}
               						 else if(result.equals("error"))
               							inicio.setMensaje("alert alert-error", "error al registrar");
               						 else
               							inicio. setMensaje("alert alert-error", result);

               							 
                                   }
               				});
               				
               			}
                    }
            	
            });
            
            button.setText("Aceptar");
            button.setStyleName("sendButton");
            rootPanel.add(button, 543, 719);
            button.setSize("327px", "44px");
            
            initWidget(rootPanel);
            
            Label lblLleneLoQue = new Label("Llene lo que a contiuacion se le pide, todos los campos son obligatorios:");
            rootPanel.add(lblLleneLoQue, 543, 124);
            lblLleneLoQue.setSize("343px", "4px");
            

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
       
    
        
}