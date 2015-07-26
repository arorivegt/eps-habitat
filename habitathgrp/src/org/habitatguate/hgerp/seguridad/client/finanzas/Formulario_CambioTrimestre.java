package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.Date;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCuentaBancariaProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.service.jdo.SegProveedor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.sun.java.swing.plaf.windows.resources.windows;

public class Formulario_CambioTrimestre extends Composite{
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	
	private Label mensaje;
	final Button close= new Button("x");
	private Long idSolucion;
	
	 public Formulario_CambioTrimestre(Long idSolucion){
		 
		 //TIPO DE PAGO
		 // 1. TRANSACCION
		 // 2. CHEQUE
		 this.idSolucion = idSolucion;


		System.out.println("formulario cargado por un total de  "+ idSolucion);
		

		//this.idVale = idVale;
		mensaje = new Label("Formulario Trimestre");
		close.addStyleName("close");
		initWidget(mensaje);
		mensaje.setSize("250px", "20px");
		setMensaje();
		
	}
	
	
	public void setMensaje()
	{
		
        final DialogBox dialogo = new DialogBox();
        
        final Label label1 = new Label("Seleccione Trimestre");
        label1.setSize("200px", "25px");
        
        
        final ListBox txtUser =new ListBox();
        
        txtUser.setStyleName("gwt-PasswordTextBox");
        txtUser.setSize("200px", "25px");
        
        txtUser.addItem("Selec. Trimestre", "-1");
        
        txtUser.addItem("Enero a Marzo", "1");
        txtUser.addItem("Abril a Junio", "2");
        txtUser.addItem("Julio a Septiembre", "3");
        txtUser.addItem("Octubre a Diciembre", "4");
        
        
        
        
        
        
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
        
        txtUser.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				int select = Integer.valueOf(txtUser.getValue(txtUser.getSelectedIndex()));

			}
        });
        
        button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
				loginService.Actualizar_TrimestreSolucion(idSolucion, Integer.valueOf(txtUser.getValue(txtUser.getSelectedIndex())),new AsyncCallback<Long>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Long result) {
						// TODO Auto-generated method stub
						dialogo.hide();
						
					}
					
				}
				
				);
				
				

			

			}
		});
    }

}
