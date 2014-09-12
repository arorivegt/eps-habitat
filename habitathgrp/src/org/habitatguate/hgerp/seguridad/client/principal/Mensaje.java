package org.habitatguate.hgerp.seguridad.client.principal;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

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
}
