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

public class Formulario_PagoVale extends Composite{
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    private Long idVale = 0L;
	private double total = 0.0;
	private double porcentajeDonacion = 0.0;
	private Label mensaje;
	final Button close= new Button("x");
	private Set<AuxVale> listaVales;
	private AuxProveedor proveedorSelect;
	
	 public Formulario_PagoVale(Set<AuxVale> vales, Long idProveedor){
		 
		 //TIPO DE PAGO
		 // 1. TRANSACCION
		 // 2. CHEQUE
		 

		 this.listaVales = vales;
		 for(AuxVale aux : vales){
				System.out.println("Vale por :"+ aux.getTotalVale());
				total = total + aux.getTotalVale();
		 }
		System.out.println("formulario cargado por un total de  "+ total);
		

		//this.idVale = idVale;
		mensaje = new Label("Formulario Solicitud Cheque");
		close.addStyleName("close");
		initWidget(mensaje);
		mensaje.setSize("250px", "20px");
		loginService.Consultar_infoProveedor(idProveedor, new AsyncCallback<AuxProveedor>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(AuxProveedor result) {
				// TODO Auto-generated method stub
				proveedorSelect = result;
				System.out.println("fue este"+result.getPorcentDonacion());
				setMensaje();
			}
	});
		
	}
	
	
	public void setMensaje()
	{
		
        final DialogBox dialogo = new DialogBox();
        
        final Label label1 = new Label("Forma de Pago");
        label1.setSize("200px", "25px");
        
        
        final ListBox txtUser =new ListBox();
        
        txtUser.setStyleName("gwt-PasswordTextBox");
        txtUser.setSize("200px", "25px");
        
        txtUser.addItem("Selec. Forma de Pago", "-1");
        
        int x = 0;
        for(AuxCuentaBancariaProv cuenta : proveedorSelect.getLista()){
        	if (cuenta.getTipoPago().equals("1"))
        		txtUser.addItem("Transferencia", ""+x);
        	else
        		txtUser.addItem("Cheque", ""+x);
        	x++;
        }
        
        
        
        final Label labelBanco = new Label("Banco");
        labelBanco.setSize("200px", "25px");
        
        final TextBox txtBanco =new TextBox();
        
        txtBanco.setStyleName("gwt-PasswordTextBox");
        
        txtBanco.setSize("200px", "25px");
        
        final Label labelNombre = new Label("Nombre Cuenta");
        labelNombre.setSize("200px", "25px");
        
        final TextBox txtNombre =new TextBox();
        
        txtNombre.setStyleName("gwt-PasswordTextBox");
        
        txtNombre.setSize("200px", "25px");
        
        final Label labelNumero = new Label("Numero Cuenta");
        labelNumero.setSize("200px", "25px");
        
        final TextBox txtNumero =new TextBox();
        
        txtNumero.setStyleName("gwt-PasswordTextBox");
        
        txtNumero.setSize("200px", "25px");
        
        final TextBox txtRef =new TextBox();
        
        txtRef.setStyleName("gwt-PasswordTextBox");
        txtRef.getElement().setAttribute("placeHolder", "No. de referencia");
        txtRef.setSize("200px", "25px");

        final Label label4 = new Label("Sub Total");
        label1.setSize("200px", "25px");
        
        final TextBox txtCantidad =new TextBox();
        
        txtCantidad.setStyleName("gwt-PasswordTextBox");
        txtCantidad.setText(""+total);
        txtCantidad.setSize("200px", "25px");
        
        final Label label2 = new Label("Porcentaje Donación");
        label1.setSize("200px", "25px");
        
        final TextBox txtporcentaje =new TextBox();
        
        txtporcentaje.setStyleName("gwt-PasswordTextBox");
        txtporcentaje.setText(""+proveedorSelect.getPorcentDonacion());
        txtporcentaje.setSize("200px", "25px");
        
        final Label label3 = new Label("Total a Cancelar");
        label1.setSize("200px", "25px");
        
        final TextBox txtCancelar =new TextBox();
        
        txtCancelar.setStyleName("gwt-PasswordTextBox");
        txtCancelar.setText(""+(total-(total*proveedorSelect.getPorcentDonacion())));
        txtCancelar.setSize("200px", "25px");
        
        final Label label5 = new Label("Fecha solicitud");
        label1.setSize("200px", "25px");
        
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
        dialogVPanel.getElement().setAttribute("width", "100%");
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(close);
        dialogVPanel.add(this);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(label1);
        dialogVPanel.add(txtUser);
        
        dialogVPanel.add(labelBanco);
        dialogVPanel.add(txtBanco);
        dialogVPanel.add(labelNombre);
        dialogVPanel.add(txtNombre);
        dialogVPanel.add(labelNumero);
        dialogVPanel.add(txtNumero);
        
        dialogVPanel.add(txtRef);
        dialogVPanel.add(label4);;
        dialogVPanel.add(txtCantidad);
        dialogVPanel.add(label5);
        dialogVPanel.add(dateBox);
        
        dialogVPanel.add(label2);
        dialogVPanel.add(txtporcentaje);
        dialogVPanel.add(label3);
        dialogVPanel.add(txtCancelar);
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
				if (select == -1){
					txtBanco.setText("");
					txtNombre.setText("");
					txtNumero.setText("");
				}else{
				txtBanco.setText(proveedorSelect.getLista().get(select).getBancoCuentaBancaria());
				txtNombre.setText(proveedorSelect.getLista().get(select).getNombrePropietario());
				txtNumero.setText(proveedorSelect.getLista().get(select).getNumeroCuentaBancaria());
				}
			}
        });
        
        button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
				/*loginService.Insertar_PagoVale(idVale, dateBox.getValue(), txtRef.getText(), txtUser.getText(), Double.valueOf(txtCantidad.getText()), new AsyncCallback<Long>() {
					
					@Override
					public void onSuccess(Long result) {
						// TODO Auto-generated method stub
						 for(AuxVale aux : listaVales){
								loginService.Insertar_ValePagado(result, aux.getIdVale(),aux.getTotalVale(), new AsyncCallback<Long>() {
								
										@Override
										public void onFailure(Throwable caught) {
											// TODO Auto-generated method stub
											
										}
		
										@Override
										public void onSuccess(Long result) {
											// TODO Auto-generated method stub
											
										}
								});
						 }
						dialogo.hide();
						Window.open("/FinanGenerarSolicitudCheque?idPago="+result,"_blank", "");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});*/

			}
		});
    }

}
