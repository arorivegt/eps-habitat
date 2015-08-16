package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxContactoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCuentaBancariaProv;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class Formulario_InfoProveedor extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_ContactoProv e = null;
    TablaGWT_FormasPago e2 = null;
    Long idProveedor = 0L;
    Long idAfiliado = 0L;
    Timer timer2 = new Timer(){
  	  public void run() {
			loginService.Consultar_ContactosProv(idProveedor,new AsyncCallback<List<AuxContactoProv>>() {
        		
        		@Override
        		public void onSuccess(List<AuxContactoProv> result) {
   			
        			e.ActulizarList(result);
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});

  	  }
    };
    Timer timer1 = new Timer(){
    	  public void run() {
  			loginService.Consultar_FormasPago(idProveedor,new AsyncCallback<List<AuxCuentaBancariaProv>>() {
          		
          		@Override
          		public void onSuccess(List<AuxCuentaBancariaProv> result) {
     			
          			e2.ActulizarList(result);
          		}
          		
          		@Override
          		public void onFailure(Throwable caught) {
          			System.out.println(caught);
          			
          		}
          	});

    	  }
      };
	Formulario_InfoProveedor(final Long idProveedor, final Long idAfiliado){
	this.idProveedor = idProveedor;
	this.idAfiliado = idAfiliado;
	System.out.println(idProveedor);
		
	final Grid grid = new Grid(4, 1);
	initWidget(grid);
	grid.setWidth("1178px");
	


	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1300px", "20px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	//----------------------------primera fila---------------------------------
	
	Label label = new Label("Nombre Contacto");
	label.setStyleName("label");
	absolutePanel.add(label, 20, 10);
	label.setSize("157px", "13px");
	
	Label label_1 = new Label("Puesto Empresa");
	label_1.setStyleName("label");
	absolutePanel.add(label_1, 257, 10);
	label_1.setSize("192px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 20, 29);
	textBox.setSize("227px", "34px");
	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 257, 29);
	textBox_1.setSize("227px", "34px");
	
	Label lblTelfonoYExt = new Label("Teléfono y Ext.");
	lblTelfonoYExt.setStyleName("label");
	absolutePanel.add(lblTelfonoYExt, 494, 10);
	lblTelfonoYExt.setSize("157px", "19px");
	
	final TextBox textBox_2 = new TextBox();
	textBox_2.setStylePrimaryName("gwt-TextBox2");
	textBox_2.setStyleName("gwt-TextBox2");
	textBox_2.setMaxLength(100);
	absolutePanel.add(textBox_2, 494, 29);
	textBox_2.setSize("227px", "34px");
	
	final TextBox textBox_3 = new TextBox();
	textBox_3.setStylePrimaryName("gwt-TextBox2");
	textBox_3.setStyleName("gwt-TextBox2");
	textBox_3.setMaxLength(100);
	absolutePanel.add(textBox_3, 731, 29);
	textBox_3.setSize("227px", "34px");
	
	Label label_3 = new Label("Correo Electrónico");
	label_3.setStyleName("label");
	absolutePanel.add(label_3, 731, 10);
	label_3.setSize("157px", "13px");
	
	final TextBox textBox_4 = new TextBox();
	textBox_4.setStylePrimaryName("gwt-TextBox2");
	textBox_4.setStyleName("gwt-TextBox2");
	textBox_4.setMaxLength(100);
	absolutePanel.add(textBox_4, 960, 29);
	textBox_4.setSize("227px", "34px");
	
	Label label_4 = new Label("Celular");
	label_4.setStyleName("label");
	absolutePanel.add(label_4, 960, 10);
	label_4.setSize("157px", "13px");
	
	
	
/*	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "55px");*/
	
	
	
	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("") && !textBox_1.getText().equals("") && !textBox_2.getText().equals("")){

			loginService.Insertar_ContactoProveedor(idProveedor,textBox.getText(), textBox_1.getText(), textBox_2.getText(), textBox_3.getText(),textBox_4.getText(),idAfiliado,
					new AsyncCallback<Long>(){
				@Override		
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {	
                	timer2.schedule(2000);	
                	Window.alert("Nuevo Contaacto con el codigo: "+ result);
                	textBox.setText("");
                	textBox_1.setText("");
                	textBox_2.setText("");
                	textBox_3.setText("");
                	textBox_4.setText("");

                	
                }

         });
			

		}
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});		

	button.setText("Agregar Contacto");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 1200, 29);
	button.setSize("157px", "30px");
	
	


	
	e = new TablaGWT_ContactoProv(new ArrayList<AuxContactoProv>());
	grid.setWidget(1, 0,e);
	e.setSize("1000px", "200px");
	
	AbsolutePanel absolutePanel2 = new AbsolutePanel();
	grid.setWidget(2, 0, absolutePanel2);
	absolutePanel2.setSize("1300px", "20px");
	absolutePanel2.setStyleName("gwt-Label-new");
	
	
	Label labelTipoTransaccion = new Label("Tipo Transaccion");
	labelTipoTransaccion.setStyleName("label");
	absolutePanel2.add(labelTipoTransaccion, 20, 10);
	labelTipoTransaccion.setSize("157px", "13px");
	
	Label labeltipoCuenta = new Label("Tipo Cuenta Bancaria");
	labeltipoCuenta.setStyleName("label");
	absolutePanel2.add(labeltipoCuenta, 257, 10);
	labeltipoCuenta.setSize("192px", "13px");
	
	final ListBox listTipoTransaccion = new ListBox();
	listTipoTransaccion.addItem("Transferencia", "1");
	listTipoTransaccion.addItem("Cheque", "2");
	listTipoTransaccion.setStyleName("gwt-TextBox2");
	absolutePanel2.add(listTipoTransaccion, 20, 29);
	listTipoTransaccion.setSize("227px", "34px");
	
	final ListBox listTipoCuenta = new ListBox();
	listTipoCuenta.addItem("Monetaria", "Monetaria");
	listTipoCuenta.addItem("Ahorro", "Ahorro");
	listTipoCuenta.setStyleName("gwt-TextBox2");
	absolutePanel2.add(listTipoCuenta, 257, 29);
	listTipoCuenta.setSize("227px", "34px");
	
	Label labelBancoCuenta = new Label("Banco Emisor de Cuenta");
	labelBancoCuenta.setStyleName("label");
	absolutePanel2.add(labelBancoCuenta, 721, 10);
	labelBancoCuenta.setSize("220px", "19px");
	
	final TextBox listBancos = new TextBox();
	listBancos.setStylePrimaryName("gwt-TextBox2");
	listBancos.setStyleName("gwt-TextBox2");
	absolutePanel2.add(listBancos, 721, 27);
	listBancos.setSize("227px", "34px");
	
	final TextBox numeroCuenta = new TextBox();
	numeroCuenta.setStylePrimaryName("gwt-TextBox2");
	numeroCuenta.setStyleName("gwt-TextBox2");
	numeroCuenta.setMaxLength(100);
	absolutePanel2.add(numeroCuenta, 965, 29);
	numeroCuenta.setSize("227px", "34px");
	
	Label labelNumeroCuenta = new Label("Numero de Cuenta");
	labelNumeroCuenta.setStyleName("label");
	absolutePanel2.add(labelNumeroCuenta, 965, 10);
	labelNumeroCuenta.setSize("157px", "13px");
	
	final TextBox titular = new TextBox();
	titular.setStylePrimaryName("gwt-TextBox2");
	titular.setStyleName("gwt-TextBox2");
	titular.setMaxLength(100);
	absolutePanel2.add(titular, 490, 27);
	titular.setSize("227px", "34px");
	
	Label labelTitular = new Label("Nombre Titular Cuenta");
	labelTitular.setStyleName("label");
	absolutePanel2.add(labelTitular, 490, 8);
	labelTitular.setSize("200px", "13px");
	
	listTipoTransaccion.addChangeHandler(new ChangeHandler() {
		public void onChange(ChangeEvent event) {
			int select = Integer.valueOf(listTipoTransaccion.getValue(listTipoTransaccion.getSelectedIndex()));
			if (select == 1){
				numeroCuenta.setVisible(true);
				listBancos.setVisible(true);
			}else{
				numeroCuenta.setVisible(false);
				listBancos.setVisible(false);
			}
		}
    });
	
	Button button2 = new Button("Send");
	button2.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!titular.getText().equals("")){

			loginService.Insertar_FormaPagoProv(idProveedor, listTipoTransaccion.getValue(listTipoTransaccion.getSelectedIndex()), listTipoCuenta.getValue(listTipoCuenta.getSelectedIndex()), listBancos.getText(), numeroCuenta.getText(), titular.getText(),idAfiliado,
					new AsyncCallback<Long>(){
				@Override		
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {	
                	timer1.schedule(2000);	
                	Window.alert("Nuevo forma de pago"+ result);
                	titular.setText("");
                	listBancos.setText("");
                	numeroCuenta.setText("");
                	

                	
                }

         });
			

		}
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});		

	button2.setText("Nueva Forma de Pago");
	button2.setStyleName("finanButton");
	absolutePanel2.add(button2, 1200, 29);
	button2.setSize("157px", "30px");	
	
	e2 = new TablaGWT_FormasPago(new ArrayList<AuxCuentaBancariaProv>());
	grid.setWidget(3, 0,e2);
	e2.setSize("1000px", "200px");
	
	
   
}
	
	
}
