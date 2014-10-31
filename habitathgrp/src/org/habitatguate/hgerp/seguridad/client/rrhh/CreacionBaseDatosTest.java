package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class CreacionBaseDatosTest extends Composite{
        
        
       private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
       private TestForm test = null;
       private Long id_prueba = 0L;
       private boolean bandera = true;
       private TextBox txtPregunta1;
       private TextBox txtPregunta2;
       private TextBox txtPregunta3;
       private TextBox txtPregunta4;
       private TextBox txtPregunta5;
       private TextBox txtPregunta6;
       private TextBox txtPregunta7;
       private TextBox txtPregunta8;
       private TextBox txtPregunta9;
       private TextBox txtPregunta10;
       private DateBox dateBox ;
       private ListBox lsitTipoTest;
       private TextBox txtNombreTest;
       private Loading load ;
        public CreacionBaseDatosTest(TestForm test ) 
        {
        	load = new Loading();
            load.Mostrar();
            load.invisible();
        	this.setTest(test);
        	
        	AbsolutePanel rootPanel = new AbsolutePanel();
        	rootPanel.setSize("1038px", "1078px");
            rootPanel.setStyleName("body");
            
            Label lblNewLabel_1 = new Label("");
            lblNewLabel_1.setStyleName("gwt-Label-new");
            rootPanel.add(lblNewLabel_1, 25, 10);
            lblNewLabel_1.setSize("744px", "920px");
            
            Label lblLleneLoQue = new Label("Ingrese las 10 preguntas, y luego aceptar para poder crear un test de preguntas, que luego podra utilizar en los formularios de test");
            rootPanel.add(lblLleneLoQue, 79, 48);
            lblLleneLoQue.setSize("729px", "4px");
                    
           
            Label lblIniciarSesion = new Label("Creacion de Base de datos de test");
            rootPanel.add(lblIniciarSesion, 239, 10);
            lblIniciarSesion.setSize("310px", "19px");
            
            txtPregunta1 =new TextBox();
            txtPregunta1.setStyleName("gwt-PasswordTextBox");
            txtPregunta1.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            rootPanel.add(txtPregunta1, 79, 114);
            txtPregunta1.setSize("727px", "49px");
            
            txtPregunta4 = new TextBox();
            txtPregunta4.setStyleName("gwt-PasswordTextBox");
            txtPregunta4.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            
            txtPregunta2 = new TextBox();
            txtPregunta2.setStyleName("gwt-PasswordTextBox");
            rootPanel.add(txtPregunta2, 79, 181);
            txtPregunta2.setSize("727px", "49px");
            txtPregunta2.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            
            txtPregunta3 = new TextBox();
            txtPregunta3.setStyleName("gwt-PasswordTextBox");
            rootPanel.add(txtPregunta3, 79, 250);
            txtPregunta3.setSize("727px", "49px");
            rootPanel.add(txtPregunta4, 79, 316);
            txtPregunta4.setSize("727px", "49px");
            txtPregunta3.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
                                    
            txtPregunta5 = new TextBox();
            txtPregunta5.setStyleName("gwt-PasswordTextBox");
            txtPregunta5.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            rootPanel.add(txtPregunta5, 79, 382);
            txtPregunta5.setSize("727px", "49px");

            dateBox = new DateBox();
            dateBox.getTextBox().setReadOnly(true);
            dateBox.getDatePicker().setYearArrowsVisible(true);
            dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
            dateBox.getDatePicker().setVisibleYearCount(100);
            dateBox.setFireNullValues(true);
            dateBox.setStyleName("gwt-PasswordTextBox");
            dateBox.getElement().setAttribute("placeHolder", "Fecha Nacimiento");
            
            txtPregunta6 = new TextBox();
            txtPregunta6.setStyleName("gwt-PasswordTextBox");
            txtPregunta6.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            rootPanel.add(txtPregunta6, 79, 446);
            txtPregunta6.setSize("727px", "49px");
            
            txtPregunta7 = new TextBox();
            txtPregunta7.setStyleName("gwt-PasswordTextBox");
            txtPregunta7.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            rootPanel.add(txtPregunta7, 79, 514);
            txtPregunta7.setSize("727px", "49px");
            
            txtPregunta8 = new TextBox();
            txtPregunta8.setStyleName("gwt-PasswordTextBox");
            txtPregunta8.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            rootPanel.add(txtPregunta8, 79, 583);
            txtPregunta8.setSize("727px", "49px");
            
            txtPregunta9 = new TextBox();
            txtPregunta9.setStyleName("gwt-PasswordTextBox");
            txtPregunta9.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            rootPanel.add(txtPregunta9, 79, 649);
            txtPregunta9.setSize("727px", "49px");
            
            txtPregunta10 = new TextBox();
            txtPregunta10.setStyleName("gwt-PasswordTextBox");
            txtPregunta10.getElement().setAttribute("placeHolder", "Ingrese una de las preguntas");
            rootPanel.add(txtPregunta10, 79, 715);
            txtPregunta10.setSize("727px", "49px");
            rootPanel.add(dateBox, 79, 782);
            dateBox.setSize("231px", "49px");

            dateBox.setFormat(new DateBox.DefaultFormat 
            	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
            

            lsitTipoTest = new ListBox();
            lsitTipoTest.addItem("Desempeño");
            lsitTipoTest.addItem("Evaluacion");
            lsitTipoTest.setStyleName("gwt-PasswordTextBox");
            rootPanel.add(lsitTipoTest, 338, 782);
            lsitTipoTest.setSize("190px", "51px");
            
            txtNombreTest = new TextBox();
            txtNombreTest.getElement().setAttribute("placeHolder", "Nombre para identifcar test");
            txtNombreTest.setStyleName("gwt-PasswordTextBox");
            rootPanel.add(txtNombreTest, 567, 782);
            txtNombreTest.setSize("239px", "49px");
            
            Button button = new Button("Send");
            button.addClickHandler(new ClickHandler() {

            	public void onClick(ClickEvent event) 
            	{      
                    load.visible();
            		try{
    					new Date(dateBox.getValue().getTime());
    				}catch(Exception e){
    					dateBox.setValue(new Date(1407518124684L));
    				}
            		String tipo = "";
            		if( lsitTipoTest.getItemText(lsitTipoTest.getSelectedIndex()).equals("Evaluacion")){
            			tipo = "2";
            		}else{
            			tipo = "1";
            		}
            		if(!txtPregunta1.getText().equals("") && !txtPregunta2.getText().equals("") &&
            				!txtPregunta3.getText().equals("") && !txtPregunta4.getText().equals("") &&
            				!txtPregunta5.getText().equals("") && !txtPregunta6.getText().equals("") &&
            				!txtPregunta7.getText().equals("") && !txtPregunta8.getText().equals("") &&
            				!txtPregunta9.getText().equals("") && !txtPregunta10.getText().equals("") ){
            		if(bandera) {
    					loginService.Insertar_BDTest(txtNombreTest.getText(),txtPregunta1.getText(), 
    	    					txtPregunta2.getText(), txtPregunta3.getText(), 
    	    					txtPregunta4.getText(), txtPregunta5.getText(), 
    	    					txtPregunta6.getText(), txtPregunta7.getText(), 
    	    					txtPregunta8.getText(), txtPregunta9.getText(), 
    	    					txtPregunta10.getText(), dateBox.getValue(), 
    	    					tipo, new AsyncCallback<Long>(){
                            public void onFailure(Throwable caught) 
                            {
                		        load.invisible();
                            	setMensaje("alert alert-error", 
                            			"Error !! \nal Guardar Datos");
                            }

    						@Override
                            public void onSuccess(Long result)
                            {
    					        load.invisible();
    							id_prueba= result;
    							bandera = false;
                            	setMensaje("alert alert-success", 
                            			"Datos Guardados\n exitosamente!!!");
                            }

                     });
    		}else{
    			loginService.Actualizar_BDTest(id_prueba, txtNombreTest.getText(),txtPregunta1.getText(), 
    					txtPregunta2.getText(), txtPregunta3.getText(), 
    					txtPregunta4.getText(), txtPregunta5.getText(), 
    					txtPregunta6.getText(), txtPregunta7.getText(), 
    					txtPregunta8.getText(), txtPregunta9.getText(), 
    					txtPregunta10.getText(), dateBox.getValue(), 
    					tipo, new AsyncCallback<Long>(){
                    public void onFailure(Throwable caught) 
                    {
        		        load.invisible();
                    	setMensaje("alert alert-error", 
                    			"Error !! \nal Actualizar Datos");
                    }

    				@Override
                    public void onSuccess(Long result)
                    {
    			        load.invisible();
    					bandera = false;
                    	setMensaje("alert alert-success", 
                    			"Datos Actualizados\n exitosamente!!!");
                    }

             });
    		}
                }else{

    		        load.invisible();
                	setMensaje("alert alert-error", 
                			"Error !! \nlas preguntas no pueden ir vacias");
            	}

                    load.invisible();
            	}
            });
            
            button.setText("Aceptar");
            button.setStyleName("sendButton");
            rootPanel.add(button, 285, 892);
            button.setSize("404px", "44px");
            
            initWidget(rootPanel);
            
            

        }

      
        public  void LlenarDatos(Long id, String nombreTest,String txtPregunta1,
    			String txtPregunta2, String txtPregunta3,
    			String txtPregunta4, String txtPregunta5,
    			String txtPregunta6, String txtPregunta7, 
    			String txtPregunta8, String txtPregunta9,
    			String txtPregunta10, String tipo, Long dateFecha)
        {
        	if(tipo.equals("1"))
        	{
        		this.lsitTipoTest.setSelectedIndex(0);
        	}else{
        		this.lsitTipoTest.setSelectedIndex(1);
        	}
    		this.id_prueba = id;
    		this.bandera = false;
    		this.txtNombreTest.setText(nombreTest);
    		this.txtPregunta1.setText(txtPregunta1);
    		this.txtPregunta2.setText(txtPregunta2);
    		this.txtPregunta3.setText(txtPregunta3);
    		this.txtPregunta4.setText(txtPregunta4);
    		this.txtPregunta5.setText(txtPregunta5);
    		this.txtPregunta6.setText(txtPregunta6);
    		this.txtPregunta7.setText(txtPregunta7);
    		this.txtPregunta8.setText(txtPregunta8);
    		this.txtPregunta9.setText(txtPregunta9);
    		this.txtPregunta10.setText(txtPregunta10);
    		this.dateBox.setValue(new Date(dateFecha));
    		
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


		public TestForm getTest() {
			return test;
		}


		public void setTest(TestForm test) {
			this.test = test;
		}

        
}