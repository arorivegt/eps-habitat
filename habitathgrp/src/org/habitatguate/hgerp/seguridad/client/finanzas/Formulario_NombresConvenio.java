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

public class Formulario_NombresConvenio extends Composite{
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    private Long idProveedor = 0L;
    private Long idAfiliado = 0L;
	
	
	private Label mensaje;
	final Button close= new Button("x");
	
	 public Formulario_NombresConvenio(Long idProveedor, Long idAfiliado){
		 
		 //TIPO DE PAGO
		 // 1. TRANSACCION
		 // 2. CHEQUE
		 this.idProveedor = idProveedor;
		 this.idAfiliado = idAfiliado;
		
		

		//this.idVale = idVale;
		mensaje = new Label("Formulario Datos Convenio");
		close.addStyleName("close");
		initWidget(mensaje);
		mensaje.setSize("250px", "20px");
		setMensaje();
		
	}
	
	
	public void setMensaje()
	{
		
        final DialogBox dialogo = new DialogBox();          
        final Label labelBanco = new Label("Persona que firma convenio");
        labelBanco.setSize("200px", "40px");
        
        final TextBox txtBanco =new TextBox();
        
        txtBanco.setStyleName("gwt-PasswordTextBox");
        
        txtBanco.setSize("200px", "25px");
        
        final Label labelNombre = new Label("Puesto en la empresa");
        labelNombre.setSize("200px", "40px");
        
        final TextBox txtNombre =new TextBox();
        
        txtNombre.setStyleName("gwt-PasswordTextBox");
        
        txtNombre.setSize("200px", "25px");
        
        final Label labelNumero = new Label("Coordinador Nacional de Compras");
        labelNumero.setSize("200px", "40px");
        
        final TextBox txtNumero =new TextBox();
        
        txtNumero.setStyleName("gwt-PasswordTextBox");
        
        txtNumero.setSize("200px", "25px");
        
        final Label labeldesarrollo = new Label("Coordinador de Desarrollo de recursos");
        labeldesarrollo.setSize("200px", "40px");
        
        final TextBox txtRef =new TextBox();
        
        txtRef.setStyleName("gwt-PasswordTextBox");
        txtRef.setSize("200px", "25px");

        final Label label4 = new Label("Departamento de Operaciones");
        label4.setSize("200px", "40px");
        
        final TextBox txtCantidad =new TextBox();
        
        txtCantidad.setStyleName("gwt-PasswordTextBox");
        txtCantidad.setSize("200px", "25px");
        txtCantidad.setEnabled(true);
              
        
        Button button = new Button("");
        button.setText("Generar Convenio");
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
        
        dialogVPanel.add(labelBanco);
        dialogVPanel.add(txtBanco);
        dialogVPanel.add(labelNombre);
        dialogVPanel.add(txtNombre);
        dialogVPanel.add(labelNumero);
        dialogVPanel.add(txtNumero);
        dialogVPanel.add(labeldesarrollo);
        dialogVPanel.add(txtRef);
        dialogVPanel.add(label4);;
        dialogVPanel.add(txtCantidad);
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
				
				Window.open("/FinanInformacionProveedorPDF?idProveedor="+idProveedor+"&idAfiliado="+idAfiliado+"&nomGerente="+txtBanco.getText()+"&puestoGerente="+txtNombre.getText()+"&nomCompras="+txtNumero.getText()+"&nomDesarrollo="+txtRef.getText()+"&nomOpe="+txtCantidad.getText(), "_blank", "");
				dialogo.hide();
			}
		});
    }

}
