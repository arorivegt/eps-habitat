package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.i18n.client.HasDirection.Direction;

public class Formulario_PagoVale extends Composite{
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    private Long idVale = 0L;
	
	private Label mensaje;
	final Button close= new Button("x");
	
	 public Formulario_PagoVale(Long idVale){
			System.out.println("Vale cargado "+ idVale);
			this.idVale = idVale;
		mensaje = new Label("Formulario de Pago");
		close.addStyleName("close");
		initWidget(mensaje);
		mensaje.setSize("250px", "20px");
	}
	
	
	public void setMensaje()
	{
        final DialogBox dialogo = new DialogBox();
        final TextBox txtUser =new TextBox();
        
        txtUser.setStyleName("gwt-PasswordTextBox");
        txtUser.getElement().setAttribute("placeHolder", "Forma de Pago");
        txtUser.setSize("200px", "25px");
        
        final TextBox txtRef =new TextBox();
        
        txtRef.setStyleName("gwt-PasswordTextBox");
        txtRef.getElement().setAttribute("placeHolder", "No. de referencia");
        txtRef.setSize("200px", "25px");
        
        final TextBox txtCantidad =new TextBox();
        
        txtCantidad.setStyleName("gwt-PasswordTextBox");
        txtCantidad.getElement().setAttribute("placeHolder", "Total de Pago");
        txtCantidad.setSize("200px", "25px");
        
        
        
        final DateBox dateBox = new DateBox();
        dateBox.setValue(new Date());
        dateBox.getTextBox().setReadOnly(true);
        dateBox.setFireNullValues(true);
        dateBox.setStyleName("gwt-PasswordTextBox");
        dateBox.getElement().setAttribute("placeHolder", "Fecha de Pago");
        
        dateBox.getDatePicker().setYearArrowsVisible(true);
        dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateBox.getDatePicker().setVisibleYearCount(100);
        
        dateBox.setSize("200px", "25px");

        dateBox.setFormat(new DateBox.DefaultFormat 
        	    (DateTimeFormat.getFormat("dd/MM/yyyy")));
        
        Button button = new Button("");
        button.setText("Realizar");
        button.setStyleName("sendButton");
        button.setSize("200px", "25px");
        
        
        final HTML serverResponseLabel = new HTML();
      
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.setStyleName("gwt-Label-new");
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(close);
        dialogVPanel.add(this);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(txtUser);
        dialogVPanel.add(txtRef);
        dialogVPanel.add(txtCantidad);
        dialogVPanel.add(dateBox);
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
				loginService.Insertar_PagoVale(idVale, dateBox.getValue(), txtRef.getText(), txtUser.getText(), Double.valueOf(txtCantidad.getText()), new AsyncCallback<Long>() {
					
					@Override
					public void onSuccess(Long result) {
						// TODO Auto-generated method stub
						dialogo.hide();
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});

			}
		});
    }

}
