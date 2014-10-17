package org.habitatguate.hgerp.seguridad.client.principal;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Mensaje extends Composite {
	
	private Label mensaje;
	final Button close= new Button("x");
	public Mensaje() {
        
		mensaje = new Label("");
		close.addStyleName("close");
		mensaje.setStyleName("alert alert-error");
		initWidget(mensaje);
		mensaje.setSize("150px", "79px");
		// TODO Auto-generated constructor stub
	}
	
	public void mensajeEntrada(String cadena)
	{
		mensaje.setText(cadena);
	}

	public void mensajeEstilo(String cadena)
	{
		mensaje.setStyleName(cadena);
	}
	
	public void setMensaje(String estilo, String mensaje)
	{
        final DialogBox dialogo = new DialogBox();
        final HTML serverResponseLabel = new HTML();
        final Button close= new Button("x");
        
        dialogo.setStyleName(estilo);
        mensajeEntrada(mensaje);
        mensajeEstilo(estilo);
        close.addStyleName("close");
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(this);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(close);
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
    }
}
