package org.habitatguate.hgerp.seguridad.client.principal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;

public class SubirDatos extends Composite{
        

	   private Loading load ;
       private Mensaje inicio;
       private int registro = 0;
       private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
        
        public SubirDatos() 
        {

        	load = new Loading();
        	inicio=  new Mensaje();
            load.Mostrar();
            load.invisible();
        	AbsolutePanel rootPanel = new AbsolutePanel();
        	rootPanel.setSize("1038px", "815px");
            rootPanel.setStyleName("body");
            
            initWidget(rootPanel);
            
            final TextArea txtDatos = new TextArea();
            rootPanel.add(txtDatos, 35, 51);
            txtDatos.setSize("976px", "360px");
            
            Button btnEmpleados = new Button("Send");
            btnEmpleados.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {
            		String Datos[] = txtDatos.getText().split("<ENTER>");
            		String Datos2[] = null;
            		for(int i = 0; i<Datos.length; i++){
            			Datos2 = Datos[i].split(",");
            			//NOrdoñez@habitat.org,Rodolfo,Andrés,Ordoñez,,2228891600101,83,21968152,181569419,0,M,6/1/1981
            			String uss = sanearTexto(Datos2[0]);
            			String pass = md5(Datos2[1].charAt(0)+"qwe123");
            			String pNombre = Datos2[1].trim().replace(" ", "");
            			String sNombre = Datos2[2].trim().replace(" ", "");
            			String pApellido = Datos2[3].trim().replace(" ", "");
            			String sApellido = Datos2[4].trim().replace(" ", "");
            			String DPI = Datos2[5].trim().replace(" ", "");
            			String Pais = Datos2[6].trim().replace(" ", "");
            			String NIT = Datos2[7].trim().replace(" ", "");
            			String IGGS = Datos2[8].trim().replace(" ", "");
            			String EstadoCivil = Datos2[9].trim().replace(" ", "");
            			String Sexo = "";
            			Date fecha = null;
            			if(Datos2[10].trim().equals("M")){
            				Sexo = "1";
            			}else{
            				Sexo = "0";
            			}
            			
            			try{
            				DateTimeFormat pfecha = DateTimeFormat.getFormat("dd/MM/yyyy");
            				fecha = pfecha.parseStrict(Datos2[11].trim());
            			}catch(Exception e){
            				fecha = new Date();
            			}
            			loginService.RegistroMasivo(uss, pass, pNombre, pApellido, fecha, 
            					sNombre, sApellido, DPI, Pais, NIT, IGGS, Sexo,EstadoCivil,new AsyncCallback<Boolean>() 
                                {
               					 public void onFailure(Throwable caught) 
                                 {
               						 registro ++;
               					 }
               					 public void onSuccess(Boolean result)
                                 {

               						if(!result)
               							registro ++;
               						 
               							 
                                 }
               			});
            		}
            		

						inicio.setMensaje("alert alert-success", "registros No exitosos "+registro);
            		
            	}
            });
            btnEmpleados.setText("Subir Empleados");
            btnEmpleados.setStyleName("sendButton");
            rootPanel.add(btnEmpleados, 35, 438);
            btnEmpleados.setSize("327px", "44px");
            
            Button btnPuestos = new Button("Send");
            btnPuestos.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {

            		String Datos[] = txtDatos.getText().split("<ENTER>");
            		String Datos2[] = null;
            		for(int i = 0; i<Datos.length; i++){
            			Datos2 = Datos[i].split(",");
            			Long id = Long.parseLong(sanearTexto(Datos2[0]));
            			String nombre_puesto = Datos2[1];
            			loginService.Insertar_BDPuesto(id, new Date(), nombre_puesto, "",new AsyncCallback<Long>() 
                            {
           					 public void onFailure(Throwable caught) 
                             {
           					 }
           					 public void onSuccess(Long result)
                             {
           						 
           							 
                             }
               			});
            		}
            	}
            });
            btnPuestos.setText("Subir Puestos");
            btnPuestos.setStyleName("sendButton");
            rootPanel.add(btnPuestos, 690, 438);
            btnPuestos.setSize("327px", "44px");
            
            Label lblSubeInformacionDe = new Label("Sube informacion de un Empleado y Puesto, de forma masiva");
            rootPanel.add(lblSubeInformacionDe, 41, 0);
            lblSubeInformacionDe.setSize("962px", "19px");
            

        }
        

   	 public static String sanearTexto(String texto){
   			texto = texto.replaceAll("%|&|=|:|;|¡|¿|!|-|,|'|<|>|[|]|\"|/", "");
   			texto = texto.replace('[', ' ');
   			texto = texto.replace(']', ' ');
   			texto = texto.replace('{', ' ');
   			texto = texto.replace('}', ' ');
   			texto = texto.replace(" ","");
   			texto = texto.replace('(', ' ');
   			texto = texto.replace(')', ' ');
   			texto = texto.replace('+', ' ');
   			texto = texto.replace('*', ' ');
   			texto = texto.replace('?', ' ');
   			texto = texto.replace('^', ' ');
   			texto = texto.replace('.', ' ');
   			texto = texto.replace('á', 'a');
   			texto = texto.replace('é', 'e');
   			texto = texto.replace('í', 'i');
   			texto = texto.replace('ó', 'o');
   			texto = texto.replace('ú', 'u');
   			texto = texto.replace('ñ', 'n');
   			texto = texto.replace('Á', 'A');
   			texto = texto.replace('É', 'E');
   			texto = texto.replace('Í', 'I');
   			texto = texto.replace('Ó', 'O');
   			texto = texto.replace('Ú', 'U');
   			texto = texto.replace('Ñ', 'N');
   			texto = texto.trim();
   			texto = texto.toLowerCase();
   			return texto;
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