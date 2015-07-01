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
import com.google.gwt.user.client.ui.ListBox;


public class Formulario_Proveedor extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);

	

	public Formulario_Proveedor(){
	final Grid grid = new Grid(3, 1);
	initWidget(grid);
	grid.setWidth("1278px");
	
			
		
		//-----------------------------	---------------------------------
	
	/*Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "55px");*/
	
	//------------------------------primera fila

	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(2, 0, absolutePanel);
	absolutePanel.setSize("1025px", "1381px");
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
	absolutePanel.add(textArea, 193, 1061);
	textArea.setSize("224px", "113px");
	
	Label lblObservaciones = new Label("observaciones");
	lblObservaciones.setStyleName("label");
	absolutePanel.add(lblObservaciones, 10, 1064);
	lblObservaciones.setSize("157px", "19px");
	
	Label lblFormularioParaEl = new Label("FORMULARIO PARA EL INGRESO DE UN NUEVO PROVEEDOR");
	lblFormularioParaEl.setStyleName("label");
	absolutePanel.add(lblFormularioParaEl, 198, 10);
	lblFormularioParaEl.setSize("310px", "41px");
	
	Button button = new Button("Send");
	

	button.setText("Nuevo Proveedor");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 219, 1236);
	button.setSize("157px", "40px");
	
	Label razonSocial = new Label("Razon Social");
	razonSocial.setStyleName("label");
	absolutePanel.add(razonSocial, 10, 475);
	razonSocial.setSize("157px", "19px");
	
	Label lblActividadEconomica = new Label("Actividad Economica");
	lblActividadEconomica.setStyleName("label");
	absolutePanel.add(lblActividadEconomica, 10, 527);
	lblActividadEconomica.setSize("157px", "19px");
	
	final TextBox txtRazonSocial = new TextBox();
	txtRazonSocial.setStyleName("gwt-TextBox2");
	txtRazonSocial.setMaxLength(100);
	absolutePanel.add(txtRazonSocial, 198, 464);
	txtRazonSocial.setSize("227px", "34px");
	
	final TextBox txtActividadEco = new TextBox();
	txtActividadEco.setStyleName("gwt-TextBox2");
	txtActividadEco.setMaxLength(100);
	absolutePanel.add(txtActividadEco, 198, 515);
	txtActividadEco.setSize("227px", "34px");
	
	Label lblAceptaExencionIva = new Label("Acepta Exencion IVA");
	lblAceptaExencionIva.setStyleName("label");
	absolutePanel.add(lblAceptaExencionIva, 10, 576);
	lblAceptaExencionIva.setSize("157px", "19px");
	
	final TextBox txtAceptaExencion = new TextBox();
	txtAceptaExencion.setStyleName("gwt-TextBox2");
	txtAceptaExencion.setMaxLength(100);
	absolutePanel.add(txtAceptaExencion, 198, 565);
	txtAceptaExencion.setSize("227px", "34px");
	
	Label lblRelacionConEl = new Label("Relacion con el proveedor");
	lblRelacionConEl.setStyleName("label");
	absolutePanel.add(lblRelacionConEl, 10, 618);
	lblRelacionConEl.setSize("157px", "19px");
	
	final TextBox txtRelacionProv = new TextBox();
	txtRelacionProv.setStyleName("gwt-TextBox2");
	txtRelacionProv.setMaxLength(100);
	absolutePanel.add(txtRelacionProv, 198, 615);
	txtRelacionProv.setSize("227px", "34px");
	
	Label lblTipoProveedor = new Label("Tipo Proveedor");
	lblTipoProveedor.setStyleName("label");
	absolutePanel.add(lblTipoProveedor, 10, 681);
	lblTipoProveedor.setSize("157px", "19px");
	
	final TextBox txtTipoProv = new TextBox();
	txtTipoProv.setStyleName("gwt-TextBox2");
	txtTipoProv.setMaxLength(100);
	absolutePanel.add(txtTipoProv, 198, 670);
	txtTipoProv.setSize("227px", "34px");
	
	Label lblProductosQOfrece = new Label("Productos q ofrece");
	lblProductosQOfrece.setStyleName("label");
	absolutePanel.add(lblProductosQOfrece, 10, 736);
	lblProductosQOfrece.setSize("157px", "19px");
	
	final TextBox txtProductOfrece = new TextBox();
	txtProductOfrece.setStyleName("gwt-TextBox2");
	txtProductOfrece.setMaxLength(100);
	absolutePanel.add(txtProductOfrece, 198, 725);
	txtProductOfrece.setSize("227px", "34px");
	
	Label lblDisponibilidadProductos = new Label("Disponibilidad Productos");
	lblDisponibilidadProductos.setStyleName("label");
	absolutePanel.add(lblDisponibilidadProductos, 10, 792);
	lblDisponibilidadProductos.setSize("157px", "19px");
	
	final TextBox txtDisponibilidadPro = new TextBox();
	txtDisponibilidadPro.setStyleName("gwt-TextBox2");
	txtDisponibilidadPro.setMaxLength(100);
	absolutePanel.add(txtDisponibilidadPro, 198, 781);
	txtDisponibilidadPro.setSize("227px", "34px");
	
	Label lblTiempoDeEntrega = new Label("Tiempo de entrega");
	lblTiempoDeEntrega.setStyleName("label");
	absolutePanel.add(lblTiempoDeEntrega, 10, 844);
	lblTiempoDeEntrega.setSize("157px", "19px");
	
	final TextBox txtTiempoEntrega = new TextBox();
	txtTiempoEntrega.setStyleName("gwt-TextBox2");
	txtTiempoEntrega.setMaxLength(100);
	absolutePanel.add(txtTiempoEntrega, 198, 833);
	txtTiempoEntrega.setSize("227px", "34px");
	
	Label lblRegimenTributario = new Label("Regimen tributario");
	lblRegimenTributario.setStyleName("label");
	absolutePanel.add(lblRegimenTributario, 10, 899);
	lblRegimenTributario.setSize("157px", "19px");
	
	final TextBox txtRegimenTribu = new TextBox();
	txtRegimenTribu.setStyleName("gwt-TextBox2");
	txtRegimenTribu.setMaxLength(100);
	absolutePanel.add(txtRegimenTribu, 198, 888);
	txtRegimenTribu.setSize("227px", "34px");
	
	Label label_5 = new Label("Acepta Exencion IVA");
	label_5.setStyleName("label");
	absolutePanel.add(label_5, 10, 943);
	label_5.setSize("157px", "19px");
	
	final TextBox txtAceptaExencion_1 = new TextBox();
	txtAceptaExencion_1.setStyleName("gwt-TextBox2");
	txtAceptaExencion_1.setMaxLength(100);
	absolutePanel.add(txtAceptaExencion_1, 198, 932);
	txtAceptaExencion_1.setSize("227px", "34px");
	
	Label lblOtorgaDonacion = new Label("Otorga Donacion");
	lblOtorgaDonacion.setStyleName("label");
	absolutePanel.add(lblOtorgaDonacion, 10, 990);
	lblOtorgaDonacion.setSize("157px", "19px");
	
	final SimpleCheckBox checkOtorgaDonacion = new SimpleCheckBox();
	absolutePanel.add(checkOtorgaDonacion, 198, 990);
	
	Label lblPorcentajeDeDonacion = new Label("Porcentaje de Donacion");
	lblPorcentajeDeDonacion.setStyleName("label");
	absolutePanel.add(lblPorcentajeDeDonacion, 10, 1023);
	lblPorcentajeDeDonacion.setSize("157px", "19px");
	
		
	final ListBox comboDonacion = new ListBox();
	comboDonacion.addItem("Seleccione Porcentaje","0");
	comboDonacion.addItem("1%","1");
	comboDonacion.addItem("1.5%","1.5");
	comboDonacion.addItem("2%","2");
	comboDonacion.addItem("4%","4");
	comboDonacion.addItem("5%","5");
	;
	absolutePanel.add(comboDonacion, 198, 1025);
	
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("")){
				Date time=new Date();
				Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
				
			
			/*	loginService.Insertar_Proveedor(false, textBox_1.getText(), today, textBox.getText(), textBox_3.getText(), textBox_2.getText(), textBox_4.getText(), simpleCheckBox.getValue(), integerBox.getText(),textArea.getText(),
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
						});*/

				loginService.Insertar_ProveedorCompleto(false, textBox_1.getText(), today, textBox.getText(), textBox_3.getText(), textBox_2.getText(), textBox_4.getText(), simpleCheckBox.getValue(), integerBox.getText(),textArea.getText(),
						txtRazonSocial.getText(),
						txtActividadEco.getText(),
						txtAceptaExencion.getText(),
						txtRelacionProv.getText(),
						txtTipoProv.getText(),
						txtProductOfrece.getText(),
						txtDisponibilidadPro.getText(),
						txtTiempoEntrega.getText(),
						txtRegimenTribu.getText(),
						checkOtorgaDonacion.getValue().toString(),
						Double.valueOf(comboDonacion.getValue(comboDonacion.getSelectedIndex())),								
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
