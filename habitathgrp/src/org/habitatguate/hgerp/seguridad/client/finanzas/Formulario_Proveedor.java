package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextArea;


public class Formulario_Proveedor extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);

	

	public Formulario_Proveedor(){
	final Grid grid = new Grid(2, 2);
	initWidget(grid);
	grid.setWidth("1278px");
	
	//------------------------------primera fila

	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1025px", "900px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	Label lblNombreProveedor = new Label("Nombre Proveedor");
	lblNombreProveedor.setStyleName("label");
	absolutePanel.add(lblNombreProveedor, 10, 96);
	lblNombreProveedor.setSize("157px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 198, 73);
	textBox.setSize("308px", "34px");
	
	textBox.addKeyUpHandler(new KeyUpHandler() {
        @Override
        public void onKeyUp(KeyUpEvent event) {
        	textBox.setText(textBox.getText().toUpperCase());
        }
    });	
	
	Label lblDireccionProveedor = new Label("Direccion Proveedor");
	lblDireccionProveedor.setStyleName("label");
	absolutePanel.add(lblDireccionProveedor, 10, 143);
	lblDireccionProveedor.setSize("157px", "19px");
	

	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 198, 137);
	textBox_1.setSize("227px", "34px");
	
	Label lblTelefonoProveedor = new Label("Telefono Proveedor");
		lblTelefonoProveedor.setStyleName("label");
		absolutePanel.add(lblTelefonoProveedor, 10, 201);
	lblTelefonoProveedor.setSize("157px", "19px");
	
			
		
		//-----------------------------	---------------------------------
	
	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "55px");
	
	
	

	
	final IntegerBox integerBox = new IntegerBox();
	absolutePanel.add(integerBox, 198, 201);
	
	final SimpleCheckBox simpleCheckBox = new SimpleCheckBox();
	absolutePanel.add(simpleCheckBox, 198, 253);
	
	Label lblServicioDeDistribucion = new Label("Servicio de distribucion");
	lblServicioDeDistribucion.setStyleName("label");
	absolutePanel.add(lblServicioDeDistribucion, 10, 254);
	lblServicioDeDistribucion.setSize("157px", "19px");
	
	Label lblPaginaWeb = new Label("Pagina Web");
	lblPaginaWeb.setStyleName("label");
	absolutePanel.add(lblPaginaWeb, 10, 307);
	lblPaginaWeb.setSize("157px", "19px");
	
	final TextBox textBox_2 = new TextBox();
	textBox_2.setStyleName("gwt-TextBox2");
	textBox_2.setMaxLength(100);
	absolutePanel.add(textBox_2, 198, 301);
	textBox_2.setSize("227px", "34px");
	
	Label lblNumeroDeNit = new Label("Numero de Nit");
	lblNumeroDeNit.setStyleName("label");
	absolutePanel.add(lblNumeroDeNit, 10, 358);
	lblNumeroDeNit.setSize("157px", "19px");
	
	final TextBox textBox_3 = new TextBox();
	textBox_3.setStyleName("gwt-TextBox2");
	textBox_3.setMaxLength(100);
	absolutePanel.add(textBox_3, 198, 353);
	textBox_3.setSize("227px", "34px");
	
	Label lblPersonaJuridica = new Label("Persona Juridica");
	lblPersonaJuridica.setStyleName("label");
	absolutePanel.add(lblPersonaJuridica, 10, 412);
	lblPersonaJuridica.setSize("157px", "19px");
	
	final TextBox textBox_4 = new TextBox();
	textBox_4.setStyleName("gwt-TextBox2");
	textBox_4.setMaxLength(100);
	absolutePanel.add(textBox_4, 198, 407);
	textBox_4.setSize("227px", "34px");
	
	final TextArea textArea = new TextArea();
	absolutePanel.add(textArea, 193, 481);
	textArea.setSize("224px", "113px");
	
	Label lblObservaciones = new Label("observaciones");
	lblObservaciones.setStyleName("label");
	absolutePanel.add(lblObservaciones, 10, 484);
	lblObservaciones.setSize("157px", "19px");
	
	Label lblFormularioParaEl = new Label("FORMULARIO PARA EL INGRESO DE UN NUEVO PROVEEDOR");
	lblFormularioParaEl.setStyleName("label");
	absolutePanel.add(lblFormularioParaEl, 198, 10);
	lblFormularioParaEl.setSize("310px", "41px");
	
	Button button = new Button("Send");
	

	button.setText("Nuevo Proveedor");
	button.setStylePrimaryName("gwt-TextBox2");
	button.setStyleName("gwt-TextBox2");
	absolutePanel.add(button, 47, 653);
	button.setSize("157px", "40px");
	
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("")){
				Date time=new Date();
				Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
				loginService.Insertar_Proveedor(false, textBox_1.getText(), today, textBox.getText(), textBox_3.getText(), textBox_2.getText(), textBox_4.getText(), simpleCheckBox.getValue(), integerBox.getText(),textArea.getText(),
						new AsyncCallback<Long>() {
							
							@Override
							public void onSuccess(Long result) {
								// TODO Auto-generated method stub
								Mensaje mensaje = new Mensaje();
								mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");
								textArea.setText("");
								textBox.setText("");
								textBox_1.setText("");
								textBox_2.setText("");
								textBox_3.setText("");
								textBox_4.setText("");
								integerBox.setText("");
								simpleCheckBox.setValue(false);
								
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Mensaje mensaje = new Mensaje();
								mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
								
							}
						});



		}
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});	
	

	
   
}
}
