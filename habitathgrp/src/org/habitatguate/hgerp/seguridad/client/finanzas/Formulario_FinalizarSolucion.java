package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class Formulario_FinalizarSolucion extends Composite{
	 private final SqlServiceAsync loginService = GWT.create(SqlService.class);
		
		private Label mensaje;
		final Button close= new Button("x");
		private Long idSolucion;
	
	public Formulario_FinalizarSolucion(Long idSolucion){
		 //TIPO DE PAGO
		 // 1. TRANSACCION
		 // 2. CHEQUE
		 this.idSolucion = idSolucion;


		System.out.println("formulario cargado por un total de  "+ idSolucion);
		

		//this.idVale = idVale;
		mensaje = new Label("Formulario Finalización");
		close.addStyleName("close");
		initWidget(mensaje);
		mensaje.setSize("250px", "20px");
		setMensaje();
	}
	
	public void setMensaje()
	{
		
        final DialogBox dialogo = new DialogBox();
        
        
        final Label label1 = new Label("Ingrese No. Solucion Finalizada");
        label1.setSize("200px", "40px");
        
        
        
        
        final TextBox txtUser =new TextBox();
        
        txtUser.setStyleName("gwt-PasswordTextBox");
        txtUser.setSize("200px", "25px");
        
  
        
        
        
        
        Button button = new Button("");
        button.setText("Realizar Cambio");
        button.setStyleName("sendButton");
        button.setSize("200px", "25px");
        
        
        final HTML serverResponseLabel = new HTML();
      
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.setStyleName("gwt-Label-new");
        dialogVPanel.getElement().setAttribute("width", "100%");
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(close);
        dialogVPanel.add(this);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(label1);
        dialogVPanel.add(txtUser);
        
        dialogVPanel.add(button);
        dialogo .setWidget(dialogVPanel);
        dialogo .setModal(true);
        dialogo .setGlassEnabled(true);
        dialogo .setAnimationEnabled(true);
        dialogo .center();
        dialogo .show();
        close.setFocus(true);
    
        close.addClickHandler(new ClickHandler() 
        {
        	public void onClick(ClickEvent event) {
        		dialogo.hide();
        	}
        });
        
    
        button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
				loginService.Actualizar_EstadoFinalizadoSolucion(idSolucion,Integer.valueOf(txtUser.getText()), new AsyncCallback<Long>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Long result) {
								// TODO Auto-generated method stub
								Window.alert("La solución ha sido finalizado exitosamente");
							}
						});
				
				

			

			}
		});
    }

}
