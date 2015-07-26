package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.FileUpload;


public class Formulario_Proveedor extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	
	private String nomProveedor;
	private String numeroNit;
	private String dirProveedor;
	private String telProveedor;
	private String paginaWeb;
	private String personaJuridica;
	private String razonSocial;
	private String actividadEcono;
	private String aceptaExencion;
	private String relacionConProv;
	private String tipoProveedor;
	private String tiempoDeTrabajarConHG;
	private String Departamentos;
	private String Municipios;
	private String ubicacionSucursales;
	private String productosfrece;
	private String disponibilidadProd;
	private Boolean servicioEntrega;
	private String tiempoEntrega;
	private String regimenTributario;
	private String observaciones;
	private String aceptaDonacion;
	private String formaDonacion;
	private double porcentDonacion;
	private String frecuenciaDonacion;
	private Boolean contribuyeEventos;
	private String cualesyComoEventos;
	private Boolean aceptaCredito;
	private double montoMaximo;
	private int tiempoMaximo;
	private Date fechaIngreso;
	private Boolean aprobadoComision;
	private Long idafiliado;
	

	Formulario_Proveedor(final Menu_Proveedores tabPanel){
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
	absolutePanel.setSize("1025px", "1949px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	Label lblNombreProveedor = new Label("Nombre Proveedor");
	lblNombreProveedor.setStyleName("label");
	absolutePanel.add(lblNombreProveedor, 10, 96);
	lblNombreProveedor.setSize("157px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 198, 73);
	textBox.setSize("455px", "34px");
	
	
	Label lblNumeroDeNit = new Label("Número de Nit");
	lblNumeroDeNit.setStyleName("label");
	absolutePanel.add(lblNumeroDeNit, 10, 146);
	lblNumeroDeNit.setSize("157px", "19px");
	
	final TextBox textBox_3 = new TextBox();
	textBox_3.setStyleName("gwt-TextBox2");
	textBox_3.setMaxLength(100);
	absolutePanel.add(textBox_3, 198, 129);
	textBox_3.setSize("227px", "34px");
	
	
	textBox.addKeyUpHandler(new KeyUpHandler() {
        @Override
        public void onKeyUp(KeyUpEvent event) {
        	textBox.setText(textBox.getText().toUpperCase());
        }
    });	
	
	Label lblDireccionProveedor = new Label("Dirección Proveedor");
	lblDireccionProveedor.setStyleName("label");
	absolutePanel.add(lblDireccionProveedor, 10, 181);
	lblDireccionProveedor.setSize("157px", "19px");
	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 198, 171);
	textBox_1.setSize("455px", "34px");
	
	Label lblTelefonoProveedor = new Label("Teléfono Proveedor");
	lblTelefonoProveedor.setStyleName("label");
	absolutePanel.add(lblTelefonoProveedor, 10, 219);
	lblTelefonoProveedor.setSize("157px", "19px");
	
	
	

	
	
	final IntegerBox integerBox = new IntegerBox();
	absolutePanel.add(integerBox, 198, 212);
	integerBox.setSize("223px", "25px");
	final SimpleCheckBox simpleCheckBox = new SimpleCheckBox();
	absolutePanel.add(simpleCheckBox, 229, 996);
	
	Label lblServicioDeDistribucion = new Label("Check: Si tiene servicio de distribución");
	lblServicioDeDistribucion.setStyleName("label");
	absolutePanel.add(lblServicioDeDistribucion, 10, 997);
	lblServicioDeDistribucion.setSize("157px", "19px");
	
	Label lblPaginaWeb = new Label("Pagina Web");
	lblPaginaWeb.setStyleName("label");
	absolutePanel.add(lblPaginaWeb, 10, 267);
	lblPaginaWeb.setSize("157px", "19px");
	
	final TextBox textBox_2 = new TextBox();
	textBox_2.setStyleName("gwt-TextBox2");
	textBox_2.setMaxLength(100);
	absolutePanel.add(textBox_2, 198, 260);
	textBox_2.setSize("358px", "34px");
	
	
	Label lblPersonaJuridica = new Label("Persona Jurídica");
	lblPersonaJuridica.setStyleName("label");
	absolutePanel.add(lblPersonaJuridica, 10, 328);
	lblPersonaJuridica.setSize("157px", "19px");
	
	final TextArea textArea = new TextArea();
	absolutePanel.add(textArea, 193, 1159);
	textArea.setSize("456px", "113px");
	
	Label lblObservaciones = new Label("Observaciones");
	lblObservaciones.setStyleName("label");
	absolutePanel.add(lblObservaciones, 10, 1162);
	lblObservaciones.setSize("157px", "19px");
	
	Label lblFormularioParaEl = new Label("FORMULARIO PARA EL INGRESO DE UN NUEVO PROVEEDOR");
	lblFormularioParaEl.setStyleName("label");
	absolutePanel.add(lblFormularioParaEl, 198, 10);
	lblFormularioParaEl.setSize("547px", "19px");
	
	Button button = new Button("Send");
	

	button.setText("Nuevo Proveedor");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 198, 1954);
	button.setSize("157px", "40px");
	
	Label lblrazonSocial = new Label("Razón Social");
	lblrazonSocial.setStyleName("label");
	absolutePanel.add(lblrazonSocial, 10, 384);
	lblrazonSocial.setSize("157px", "19px");
	
	Label lblActividadEconomica = new Label("Actividad Comercial o Categorización");
	lblActividadEconomica.setStyleName("label");
	absolutePanel.add(lblActividadEconomica, 10, 431);
	lblActividadEconomica.setSize("157px", "19px");
	
	final TextBox txtRazonSocial = new TextBox();
	txtRazonSocial.setStyleName("gwt-TextBox2");
	txtRazonSocial.setMaxLength(100);
	absolutePanel.add(txtRazonSocial, 198, 367);
	txtRazonSocial.setSize("227px", "34px");
	
	final TextBox txtActividadEco = new TextBox();
	txtActividadEco.setStyleName("gwt-TextBox2");
	txtActividadEco.setMaxLength(100);
	absolutePanel.add(txtActividadEco, 198, 426);
	txtActividadEco.setSize("358px", "34px");
	
	Label lblAceptaExencionIva = new Label("Acepta Exención IVA");
	lblAceptaExencionIva.setStyleName("label");
	absolutePanel.add(lblAceptaExencionIva, 10, 487);
	lblAceptaExencionIva.setSize("157px", "19px");
	
	final TextBox txtAceptaExencion = new TextBox();
	txtAceptaExencion.setStyleName("gwt-TextBox2");
	txtAceptaExencion.setMaxLength(100);
	absolutePanel.add(txtAceptaExencion, 198, 468);
	txtAceptaExencion.setSize("88px", "34px");
	
	Label lblRelacionConEl = new Label("Relación con el proveedor");
	lblRelacionConEl.setStyleName("label");
	absolutePanel.add(lblRelacionConEl, 10, 524);
	lblRelacionConEl.setSize("157px", "19px");
	
	Label lblTipoProveedor = new Label("En caso que se le compre actualmente? Que tipo de proveedor es:");
	lblTipoProveedor.setStyleName("label");
	absolutePanel.add(lblTipoProveedor, 10, 586);
	lblTipoProveedor.setSize("157px", "19px");
	
	final TextBox txtTipoProv = new TextBox();
	txtTipoProv.setStyleName("gwt-TextBox2");
	txtTipoProv.setMaxLength(100);
	absolutePanel.add(txtTipoProv, 426, 598);
	txtTipoProv.setSize("227px", "34px");
	txtTipoProv.setEnabled(false);
	
	Label lblProductosQOfrece = new Label("Tiempo de trabajar con la Fundación");
	lblProductosQOfrece.setStyleName("label");
	absolutePanel.add(lblProductosQOfrece, 10, 666);
	lblProductosQOfrece.setSize("157px", "19px");
	
	final TextBox txtProductOfrece = new TextBox();
	txtProductOfrece.setStyleName("gwt-TextBox2");
	txtProductOfrece.setMaxLength(100);
	absolutePanel.add(txtProductOfrece, 426, 666);
	txtProductOfrece.setSize("227px", "34px");
	txtProductOfrece.setEnabled(false);
	
	Label lblDisponibilidadProductos = new Label("Disponibilidad de Productos");
	lblDisponibilidadProductos.setStyleName("label");
	absolutePanel.add(lblDisponibilidadProductos, 10, 961);
	lblDisponibilidadProductos.setSize("157px", "19px");
	
	final TextBox txtDisponibilidadPro = new TextBox();
	txtDisponibilidadPro.setStyleName("gwt-TextBox2");
	txtDisponibilidadPro.setMaxLength(100);
	absolutePanel.add(txtDisponibilidadPro, 198, 961);
	txtDisponibilidadPro.setSize("227px", "34px");
	
	Label lblTiempoDeEntrega = new Label("Tiempo de entrega");
	lblTiempoDeEntrega.setStyleName("label");
	absolutePanel.add(lblTiempoDeEntrega, 10, 1054);
	lblTiempoDeEntrega.setSize("157px", "19px");
	
	final TextBox txtTiempoEntrega = new TextBox();
	txtTiempoEntrega.setStyleName("gwt-TextBox2");
	txtTiempoEntrega.setMaxLength(100);
	absolutePanel.add(txtTiempoEntrega, 198, 1043);
	txtTiempoEntrega.setSize("227px", "34px");
	
	Label lblRegimenTributario = new Label("Regimen tributario");
	lblRegimenTributario.setStyleName("label");
	absolutePanel.add(lblRegimenTributario, 10, 1109);
	lblRegimenTributario.setSize("157px", "19px");
	
	final TextBox txtRegimenTribu = new TextBox();
	txtRegimenTribu.setStyleName("gwt-TextBox2");
	txtRegimenTribu.setMaxLength(100);
	absolutePanel.add(txtRegimenTribu, 426, 1096);
	txtRegimenTribu.setSize("227px", "34px");
	txtRegimenTribu.setEnabled(false);
	
	Label lblPorcentajeDeDonacion = new Label("Porcentaje de Donación");
	lblPorcentajeDeDonacion.setStyleName("label");
	absolutePanel.add(lblPorcentajeDeDonacion, 10, 1421);
	lblPorcentajeDeDonacion.setSize("157px", "19px");
	
		
	final ListBox comboDonacion = new ListBox();
	comboDonacion.addItem("Seleccione Porcentaje","0");
	comboDonacion.addItem("0.5%","0.5");
	comboDonacion.addItem("1%","1.0");
	comboDonacion.addItem("1.5%","1.5");
	comboDonacion.addItem("2%","2.0");
	comboDonacion.addItem("2.5%","2.5");
	comboDonacion.addItem("3%","3.0");
	comboDonacion.addItem("3%","3.5");
	comboDonacion.addItem("4%","4");
	comboDonacion.addItem("5%","5");
	comboDonacion.setEnabled(false);
	absolutePanel.add(comboDonacion, 198, 1423);
	
	Label lblDepartamento = new Label("Departamento donde distrubuye: ");
	lblDepartamento.setStyleName("label");
	absolutePanel.add(lblDepartamento, 10, 758);
	lblDepartamento.setSize("157px", "19px");
	
	final TextBox textBox_5 = new TextBox();
	textBox_5.setStyleName("gwt-TextBox2");
	textBox_5.setMaxLength(100);
	absolutePanel.add(textBox_5, 193, 758);
	textBox_5.setSize("503px", "34px");
	
	Label lblMunicipiosDondeDistribuye = new Label("Municipios donde distribuye:");
	lblMunicipiosDondeDistribuye.setStyleName("label");
	absolutePanel.add(lblMunicipiosDondeDistribuye, 10, 808);
	lblMunicipiosDondeDistribuye.setSize("157px", "19px");
	
	final TextBox textBox_6 = new TextBox();
	textBox_6.setStyleName("gwt-TextBox2");
	textBox_6.setMaxLength(100);
	absolutePanel.add(textBox_6, 193, 808);
	textBox_6.setSize("503px", "34px");
	
	Label lblUbicacinDeSus = new Label("Ubicación de sus sucursales:");
	lblUbicacinDeSus.setStyleName("label");
	absolutePanel.add(lblUbicacinDeSus, 10, 850);
	lblUbicacinDeSus.setSize("157px", "19px");
	
	final TextBox textBox_7 = new TextBox();
	textBox_7.setStyleName("gwt-TextBox2");
	textBox_7.setMaxLength(100);
	absolutePanel.add(textBox_7, 193, 850);
	textBox_7.setSize("503px", "34px");
	
	Label lblProductosYServicios = new Label("Productos y servicios que ofrece");
	lblProductosYServicios.setStyleName("label");
	absolutePanel.add(lblProductosYServicios, 10, 903);
	lblProductosYServicios.setSize("157px", "19px");
	
	final TextBox textBox_8 = new TextBox();
	textBox_8.setStyleName("gwt-TextBox2");
	textBox_8.setMaxLength(100);
	absolutePanel.add(textBox_8, 193, 903);
	textBox_8.setSize("503px", "34px");
	
	Label lblInformacionGeneral = new Label("INFORMACION GENERAL");
	lblInformacionGeneral.setStyleName("label");
	absolutePanel.add(lblInformacionGeneral, 10, 35);
	lblInformacionGeneral.setSize("547px", "19px");
	
	Label lblInformacionExtra = new Label("DESARROLLO DE RECURSOS");
	lblInformacionExtra.setStyleName("label");
	absolutePanel.add(lblInformacionExtra, 11, 1301);
	lblInformacionExtra.setSize("547px", "19px");
	
	Label lblCheckContribuyeAl = new Label("Check: Contribuye al desarrollo de la fundación");
	lblCheckContribuyeAl.setStyleName("label");
	absolutePanel.add(lblCheckContribuyeAl, 10, 1327);
	lblCheckContribuyeAl.setSize("157px", "19px");
	
	final SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
	absolutePanel.add(simpleCheckBox_1, 237, 1326);
	simpleCheckBox_1.setSize("14px", "14px");
	
	
	
	Label lblF = new Label("Forma de donación");
	lblF.setStyleName("label");
	absolutePanel.add(lblF, 10, 1391);
	lblF.setSize("157px", "19px");
	
	final TextBox textBox_9 = new TextBox();
	textBox_9.setStyleName("gwt-TextBox2");
	textBox_9.setMaxLength(100);
	absolutePanel.add(textBox_9, 421, 1379);
	textBox_9.setSize("227px", "34px");
	textBox_9.setEnabled(false);
	
	Label lblFrecuenciaDeDonacin = new Label("Frecuencia de donación");
	lblFrecuenciaDeDonacin.setStyleName("label");
	absolutePanel.add(lblFrecuenciaDeDonacin, 10, 1488);
	lblFrecuenciaDeDonacin.setSize("157px", "19px");
	
	final TextBox textBox_10 = new TextBox();
	textBox_10.setStyleName("gwt-TextBox2");
	textBox_10.setMaxLength(100);
	absolutePanel.add(textBox_10, 426, 1477);
	textBox_10.setSize("227px", "34px");
	textBox_10.setEnabled(false);
	
	Label lblCheckSiEsta = new Label("Check: Si esta deacuerdo en contribuir con HPHG");
	lblCheckSiEsta.setStyleName("label");
	absolutePanel.add(lblCheckSiEsta, 10, 1540);
	lblCheckSiEsta.setSize("157px", "19px");
	
	final SimpleCheckBox simpleCheckBox_2 = new SimpleCheckBox();
	absolutePanel.add(simpleCheckBox_2, 237, 1539);
	simpleCheckBox_2.setSize("14px", "14px");
	
	Label lblCualesYEn = new Label("Cuales y en que forma");
	lblCualesYEn.setStyleName("label");
	absolutePanel.add(lblCualesYEn, 10, 1593);
	lblCualesYEn.setSize("157px", "19px");
	
	final TextArea textArea_1 = new TextArea();
	absolutePanel.add(textArea_1, 193, 1590);
	textArea_1.setSize("379px", "113px");
	
	Label lblCredito = new Label("CREDITO");
	lblCredito.setStyleName("label");
	absolutePanel.add(lblCredito, 11, 1727);
	lblCredito.setSize("547px", "19px");
	
	Label lblCheckSiTenemos = new Label("Check: Si tenemos crédito activo");
	lblCheckSiTenemos.setStyleName("label");
	absolutePanel.add(lblCheckSiTenemos, 10, 1753);
	lblCheckSiTenemos.setSize("157px", "19px");
	
	final SimpleCheckBox simpleCheckBox_3 = new SimpleCheckBox();
	absolutePanel.add(simpleCheckBox_3, 237, 1752);
	simpleCheckBox_3.setSize("14px", "14px");
	
	Label lblMontoMximoDe = new Label("Monto Máximo de crédito");
	lblMontoMximoDe.setStyleName("label");
	absolutePanel.add(lblMontoMximoDe, 10, 1809);
	lblMontoMximoDe.setSize("157px", "19px");
	
	final TextBox textBox_11 = new TextBox();
	textBox_11.setStyleName("gwt-TextBox2");
	textBox_11.setMaxLength(100);
	absolutePanel.add(textBox_11, 198, 1798);
	textBox_11.setSize("227px", "34px");
	
	Label lblTiempoMximoDe = new Label("Tiempo Máximo de crédito (días)");
	lblTiempoMximoDe.setStyleName("label");
	absolutePanel.add(lblTiempoMximoDe, 10, 1871);
	lblTiempoMximoDe.setSize("157px", "19px");
	
	final TextBox textBox_12 = new TextBox();
	textBox_12.setStyleName("gwt-TextBox2");
	textBox_12.setMaxLength(100);
	absolutePanel.add(textBox_12, 198, 1860);
	textBox_12.setSize("227px", "34px");
	
	Label lblCopiaRtu = new Label("Copia RTU");
	lblCopiaRtu.setStyleName("label");
	absolutePanel.add(lblCopiaRtu, 10, 1927);
	lblCopiaRtu.setSize("157px", "19px");
	
	FileUpload fileUpload = new FileUpload();
	absolutePanel.add(fileUpload, 197, 1917);
	
	Label lblAfiliadoEnEl = new Label("Afiliado en el que Trabaja");
	lblAfiliadoEnEl.setStyleName("label");
	absolutePanel.add(lblAfiliadoEnEl, 10, 718);
	lblAfiliadoEnEl.setSize("157px", "19px");
	
	final ListBox listAfiliados = new ListBox();
	listAfiliados.setStyleName("gwt-TextBox2");
	absolutePanel.add(listAfiliados, 198, 716);
	listAfiliados.setSize("227px", "34px");
	
	final ListBox comboBox = new ListBox();
	absolutePanel.add(comboBox, 198, 321);
	comboBox.setSize("211px", "26px");
	comboBox.addItem("Individual", "Individual");
	comboBox.addItem("Sociedad", "Sociedad");
	
	final ListBox listBox_1 = new ListBox();
	absolutePanel.add(listBox_1, 200, 534);
	listBox_1.setSize("211px", "26px");
	listBox_1.addItem("Se le compra actualmente", "Se le compra actualmente");
	listBox_1.addItem("Se le ha comprado", "Se le ha comprado");
	listBox_1.addItem("Es nuevo", "Es nuevo");
	

	final ListBox listBox_2 = new ListBox();
	absolutePanel.add(listBox_2, 198, 608);
	listBox_2.setSize("211px", "26px");
	listBox_2.addItem("Proveedor constante", "Proveedor constante");
	listBox_2.addItem("Proveedor eventual", "Proveedor eventual");
	listBox_2.addItem("Otro", "-1");
	
	listBox_2.addChangeHandler(new ChangeHandler() {

 		@Override
		public void onChange(ChangeEvent event) {
 			System.out.println(listBox_2.getValue(listBox_2.getSelectedIndex()));
 			String opcion = listBox_2.getValue(listBox_2.getSelectedIndex());
 			if (opcion.equals("-1")){
 				txtTipoProv.setEnabled(true);
 			}else{
 				txtTipoProv.setEnabled(false);
 			}
		}
    });
	
	final ListBox listBox_3 = new ListBox();
	absolutePanel.add(listBox_3, 198, 676);
	listBox_3.setSize("211px", "26px");
	listBox_3.addItem("1 año","1 año");
	listBox_3.addItem("2 año","2 año");
	listBox_3.addItem("3 año","3 año");
	listBox_3.addItem("4 año","4 año");
	listBox_3.addItem("5 año","5 año");
	listBox_3.addItem("mas de 6 año","mas de 6 año");
	listBox_3.addItem("Otro","-1");
	
	listBox_3.addChangeHandler(new ChangeHandler() {

 		@Override
		public void onChange(ChangeEvent event) {
 			System.out.println(listBox_3.getValue(listBox_3.getSelectedIndex()));
 			String opcion = listBox_3.getValue(listBox_3.getSelectedIndex());
 			if (opcion.equals("-1")){
 				txtProductOfrece.setEnabled(true);
 			}else{
 				txtProductOfrece.setEnabled(false);
 			}
		}
    });
	
	
	final ListBox listBox_4 = new ListBox();
	absolutePanel.add(listBox_4, 198, 1102);
	listBox_4.setSize("211px", "26px");
	listBox_4.addItem("Sujeto a pagos trimestrales","Sujeto a pagos trimestrales");
	listBox_4.addItem("Retencion del 5%","Retencion del 5%");
	listBox_4.addItem("Pequeño contribuyente","Pequeño contribuyente");
	listBox_4.addItem("Otro","-1");
	
	listBox_4.addChangeHandler(new ChangeHandler() {

 		@Override
		public void onChange(ChangeEvent event) {
 			System.out.println(listBox_4.getValue(listBox_4.getSelectedIndex()));
 			String opcion = listBox_4.getValue(listBox_4.getSelectedIndex());
 			if (opcion.equals("-1")){
 				txtRegimenTribu.setEnabled(true);
 			}else{
 				txtRegimenTribu.setEnabled(false);
 			}
		}
    });
	
	final ListBox listBox_5 = new ListBox();
	absolutePanel.add(listBox_5, 198, 1384);
	listBox_5.setSize("211px", "26px");
	listBox_5.addItem("Deposito Bancario", "Deposito Bancario");
	listBox_5.addItem("Se deduce del cheque", "Se deduce del cheque");
	listBox_5.addItem("En especie", "En especie");
	listBox_5.addItem("Efectivo", "Efectivo");
	listBox_5.addItem("Cheque", "Cheque");
	listBox_5.addItem("Otro", "-1");
	listBox_5.setEnabled(false);

	listBox_5.addChangeHandler(new ChangeHandler() {

 		@Override
		public void onChange(ChangeEvent event) {
 			System.out.println(listBox_5.getValue(listBox_5.getSelectedIndex()));
 			String opcion = listBox_5.getValue(listBox_5.getSelectedIndex());
 			if (opcion.equals("-1")){
 				textBox_9.setEnabled(true);
 			}else{
 				textBox_9.setEnabled(false);
 			}
		}
    });
	
	
	final ListBox listBox_6 = new ListBox();
	absolutePanel.add(listBox_6, 198, 1487);
	listBox_6.setSize("211px", "26px");
	listBox_6.addItem("Mensual", "Mensual");
	listBox_6.addItem("Bimensual", "Bimensual");
	listBox_6.addItem("Trimestral", "Trimestral");	
	listBox_6.addItem("Otro", "-1");
	listBox_6.setEnabled(false);
	
	listBox_6.addChangeHandler(new ChangeHandler() {

 		@Override
		public void onChange(ChangeEvent event) {
 			System.out.println(listBox_6.getValue(listBox_6.getSelectedIndex()));
 			String opcion = listBox_6.getValue(listBox_6.getSelectedIndex());
 			if (opcion.equals("-1")){
 				textBox_10.setEnabled(true);
 			}else{
 				textBox_10.setEnabled(false);
 			}
		}
    });
	
	loginService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>() {
		
		@Override
		public void onSuccess(List<AuxAfiliado> result) {
			System.out.println("ya estan todos los afiliados");
			for (AuxAfiliado aux : result){
				listAfiliados.addItem(aux.getNomAfiliado(),String.valueOf(aux.getIdAfiliado()));
			}
	
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
	
	simpleCheckBox_1.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
		   @Override
		   public void onValueChange(ValueChangeEvent<Boolean> event) {
			   System.out.println(event.getValue());
			   if (event.getValue()){
				   listBox_5.setEnabled(true);
				   comboDonacion.setEnabled(true);
				   listBox_6.setEnabled(true);
			   }else{
				   listBox_5.setEnabled(false);
				   comboDonacion.setEnabled(false);
				   listBox_6.setEnabled(false);   
			   }
		   }


	});
	
	button.addClickHandler(new ClickHandler() {
		
		
		public void onClick(ClickEvent event) {
			 nomProveedor = textBox.getText();
			 numeroNit= textBox_3.getText();
			 dirProveedor= textBox_1.getText();
			 telProveedor= integerBox.getText();
			 paginaWeb=  textBox_2.getText();
			 personaJuridica= comboBox.getValue(comboBox.getSelectedIndex());
			 razonSocial= txtRazonSocial.getText() ;
			 actividadEcono= txtActividadEco.getText();
			 aceptaExencion= txtAceptaExencion.getText();
			 relacionConProv= listBox_1.getValue(listBox_1.getSelectedIndex());
			 tipoProveedor= (listBox_2.getValue(listBox_2.getSelectedIndex()).equals("-1")) ? txtTipoProv.getText() : listBox_2.getValue(listBox_2.getSelectedIndex());
			 tiempoDeTrabajarConHG= (listBox_3.getValue(listBox_3.getSelectedIndex()).equals("-1")) ? txtProductOfrece.getText() : listBox_3.getValue(listBox_3.getSelectedIndex());
			 Departamentos= textBox_5.getText();
			 Municipios= textBox_6.getText();
			 ubicacionSucursales= textBox_7.getText();
			 productosfrece= textBox_8.getText();
			 disponibilidadProd= txtDisponibilidadPro.getText();
			servicioEntrega= simpleCheckBox.getValue();
			 tiempoEntrega= txtTiempoEntrega.getText();
			 regimenTributario= (listBox_4.getValue(listBox_4.getSelectedIndex()).equals("-1")) ? txtRegimenTribu.getText() : listBox_4.getValue(listBox_4.getSelectedIndex());
			 observaciones= textArea.getText();
			 aceptaDonacion= String.valueOf(simpleCheckBox_1.getValue());
			 formaDonacion= (listBox_5.getValue(listBox_5.getSelectedIndex()).equals("-1")) ? textBox_9.getText() : listBox_5.getValue(listBox_5.getSelectedIndex());
			porcentDonacion= Double.valueOf(comboDonacion.getValue(comboDonacion.getSelectedIndex()));
			 frecuenciaDonacion= (listBox_6.getValue(listBox_6.getSelectedIndex()).equals("-1")) ? textBox_10.getText() : listBox_6.getValue(listBox_6.getSelectedIndex());
			contribuyeEventos= simpleCheckBox_2.getValue();
			 cualesyComoEventos= textArea_1.getText();
			aceptaCredito= simpleCheckBox_3.getValue();
			montoMaximo= Double.valueOf(textBox_11.getText());
			tiempoMaximo= Integer.valueOf(textBox_12.getText());
			idafiliado = Long.valueOf(listAfiliados.getValue(listAfiliados.getSelectedIndex()));
			
			
			
			
			if (!textBox.getText().equals("")){
				Date time=new Date();
				Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
				
			
			loginService.Insertar_ProveedorCompleto(false, nomProveedor, numeroNit, dirProveedor, telProveedor, paginaWeb, personaJuridica, razonSocial, actividadEcono, aceptaExencion, relacionConProv, tipoProveedor, tiempoDeTrabajarConHG, Departamentos, Municipios, ubicacionSucursales, productosfrece, disponibilidadProd, servicioEntrega, tiempoEntrega, regimenTributario, observaciones, aceptaDonacion, formaDonacion, porcentDonacion, frecuenciaDonacion, contribuyeEventos, cualesyComoEventos, aceptaCredito, montoMaximo, tiempoMaximo, today,idafiliado,								
						new AsyncCallback<Long>() {
							
							@Override
							public void onSuccess(Long result) {
								// TODO Auto-generated method stub
								Mensaje mensaje = new Mensaje();
								mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente con id "+result);
								tabPanel.ItemCuatro(result,idafiliado);
								tabPanel.tabPanel.selectTab(1);
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
