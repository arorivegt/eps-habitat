package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class Sce_DataSituacionEconomica extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryFormularioSolicitud formulario;
	private Sce_DataEntrySituacionEconomica situacionEconomica;
    private boolean bandera = true;
	private Long idSituacionEconomica = 0L;
    
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	
	private TextBox txtIngresosSolicitante;
	private TextBox txtIngresosConyuge;
	private TextBox txtAlquilerVivienda;
	private TextBox txtAlimentacion;
	private TextBox txtRopa;
	private TextBox txtGastosMedicos;
	private TextBox txtTransporte;
	private TextBox txtEducacion;
	private TextBox txtPagoLuzAgua;
	private TextBox txtOtrosIngresos;
	private TextBox txtPagoPrestamos;
	private TextBox txtOtrosGastos1;
	private TextBox txtOtrosGastos2;
	private TextBox txtEgresosTotales;
	private TextBox txtIngresosTotales;
	private TextBox txtTotalIngresos;
	private TextBox txtTotalEgresos;
	private TextBox txtDiferencia;
	private TextBox txtPagosBuro;
	private TextBox txtCuota;
	private TextBox txtExcedente;
	private Button btnGuardar;
	
//	// Data Ingresos
//	private float valIngresosSolicitante = 0;
//	private float valIngresosConyuge = 0;
//	private float valOtrosIngresos = 0;
//	// Data Egresos
//	private float valAlquilerVivienda = 0;
//	private float valAlimentacion = 0;
//	private float valRopa = 0;
//	private float valGastosMedicos = 0;
//	private float valTransporte = 0;
//	private float valEducacion = 0;
//	private float valPagoLuzAgua = 0;
//	private float valPagoPrestamos = 0;
//	private float valOtrosGastos1 = 0;
//	private float valOtrosGastos2 = 0;
//	// Data Pagos Buro y Cuota HPHG
//	private float valPagosBuro = 0;
//	private float valCuota = 0;
	
	private String solucionConstruir = "";

	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_DataSituacionEconomica(Sce_DataEntrySituacionEconomica a, Sce_DataEntryFormularioSolicitud e, boolean valor) {

		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.situacionEconomica = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");

		
        solucionesService.obtenerDataFormularioRegistrado(this.formulario.idFormulario, new AsyncCallback<AuxSolicitudGeneral>(){
        	public void onFailure(Throwable caught) 
        	{
            	mensaje.setMensaje("alert alert-information alert-block", 
            			"\nNo hay resultados");
        	}

        	@Override
        	public void onSuccess(AuxSolicitudGeneral result)
        	{	
        		
        		solucionConstruir = result.getSolucionConstruir();
        		
        	}

        });
		
		
		Label lblEgresosMensuales = new Label("EGRESOS MENSUALES");
		absolutePanel.add(lblEgresosMensuales, 515, 52);
		lblEgresosMensuales.setSize("225px", "20px");
		
		Label lblCantidad_1 = new Label("CANTIDAD");
		absolutePanel.add(lblCantidad_1, 835, 52);
		lblCantidad_1.setSize("119px", "20px");
		
		Label lblIngresosFijosDel = new Label("Ingresos fijos del solicitante:");
		lblIngresosFijosDel.setStyleName("label");
		absolutePanel.add(lblIngresosFijosDel, 49, 118);
		lblIngresosFijosDel.setSize("249px", "19px");
		
		Label lblOtrosIngresosDel_1 = new Label("Otros ingresos:");
		lblOtrosIngresosDel_1.setStyleName("label");
		absolutePanel.add(lblOtrosIngresosDel_1, 49, 171);
		lblOtrosIngresosDel_1.setSize("249px", "19px");
		
		Label lblIngresosDelConyuge = new Label("Ingresos del conyuge:");
		lblIngresosDelConyuge.setStyleName("label");
		absolutePanel.add(lblIngresosDelConyuge, 49, 145);
		lblIngresosDelConyuge.setSize("249px", "19px");
		
		Label lblTotalIngresos = new Label("Ingresos totales:");
		lblTotalIngresos.setStyleName("label");
		absolutePanel.add(lblTotalIngresos, 49, 197);
		lblTotalIngresos.setSize("249px", "19px");
		
		Label lblAlquilerDeVivienda = new Label("Alquiler de vivienda:");
		lblAlquilerDeVivienda.setStyleName("label");
		absolutePanel.add(lblAlquilerDeVivienda, 515, 118);
		lblAlquilerDeVivienda.setSize("249px", "19px");
		
		Label lblAlimentacion = new Label("Alimentacion:");
		lblAlimentacion.setStyleName("label");
		absolutePanel.add(lblAlimentacion, 515, 145);
		lblAlimentacion.setSize("249px", "19px");
		
		Label lblRopa = new Label("Ropa:");
		lblRopa.setStyleName("label");
		absolutePanel.add(lblRopa, 515, 171);
		lblRopa.setSize("249px", "19px");
		
		Label lblGastosMedicos = new Label("Gastos Medicos:");
		lblGastosMedicos.setStyleName("label");
		absolutePanel.add(lblGastosMedicos, 515, 197);
		lblGastosMedicos.setSize("249px", "19px");
		
		Label lblTransporte = new Label("Transporte:");
		lblTransporte.setStyleName("label");
		absolutePanel.add(lblTransporte, 515, 223);
		lblTransporte.setSize("249px", "19px");
		
		Label lblEducacion = new Label("Educacion:");
		lblEducacion.setStyleName("label");
		absolutePanel.add(lblEducacion, 515, 249);
		lblEducacion.setSize("249px", "19px");
		
		Label lblPagoDeLuz = new Label("Pago de luz y agua:");
		lblPagoDeLuz.setStyleName("label");
		absolutePanel.add(lblPagoDeLuz, 515, 275);
		lblPagoDeLuz.setSize("249px", "19px");
		
		Label lblPagoDePrestamos = new Label("Pago de prestamos:");
		lblPagoDePrestamos.setStyleName("label");
		absolutePanel.add(lblPagoDePrestamos, 515, 301);
		lblPagoDePrestamos.setSize("249px", "19px");
		
		Label lblOtrosGastos = new Label("Otros gastos:");
		lblOtrosGastos.setStyleName("label");
		absolutePanel.add(lblOtrosGastos, 515, 327);
		lblOtrosGastos.setSize("249px", "19px");
		
		Label lblOtrosGastos_1 = new Label("Otros gastos:");
		lblOtrosGastos_1.setStyleName("label");
		absolutePanel.add(lblOtrosGastos_1, 515, 353);
		lblOtrosGastos_1.setSize("249px", "19px");
		
		Label lblEgresosTotales = new Label("Egresos totales:");
		lblEgresosTotales.setStyleName("label");
		absolutePanel.add(lblEgresosTotales, 515, 379);
		lblEgresosTotales.setSize("249px", "19px");
		
		Label lblIngresosMensuales = new Label("INGRESOS MENSUALES");
		absolutePanel.add(lblIngresosMensuales, 53, 52);
		lblIngresosMensuales.setSize("245px", "20px");
		
		Label label = new Label("CANTIDAD");
		absolutePanel.add(label, 332, 52);
		label.setSize("119px", "20px");
		
		Label lblTotalIngresos_1 = new Label("Total ingresos:");
		lblTotalIngresos_1.setStyleName("label");
		absolutePanel.add(lblTotalIngresos_1, 49, 249);
		lblTotalIngresos_1.setSize("249px", "19px");
		
		Label lblTotalEgresos = new Label("Total egresos:");
		lblTotalEgresos.setStyleName("label");
		absolutePanel.add(lblTotalEgresos, 49, 275);
		lblTotalEgresos.setSize("249px", "19px");
		
		Label lblDiferencia = new Label("Diferencia:");
		lblDiferencia.setStyleName("label");
		absolutePanel.add(lblDiferencia, 49, 301);
		lblDiferencia.setSize("249px", "19px");
		
		Label lblPagosBuro = new Label("Pagos buro:");
		lblPagosBuro.setStyleName("label");
		absolutePanel.add(lblPagosBuro, 49, 327);
		lblPagosBuro.setSize("249px", "19px");
		
		Label lblCuotaHphg = new Label("Cuota HPHG");
		lblCuotaHphg.setStyleName("label");
		absolutePanel.add(lblCuotaHphg, 49, 353);
		lblCuotaHphg.setSize("249px", "19px");
		
		Label lblExcedente = new Label("Excedente:");
		lblExcedente.setStyleName("label");
		absolutePanel.add(lblExcedente, 49, 379);
		lblExcedente.setSize("249px", "19px");
		
		txtIngresosSolicitante = new TextBox();
		txtIngresosSolicitante.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtIngresosSolicitante .getText().equals("")) {
					txtIngresosSolicitante .setText("0.0");
				}
				else if(txtIngresosSolicitante .getText().equals(null)) {
					txtIngresosSolicitante .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtIngresosSolicitante.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtIngresosSolicitante .setText("0.0");
					}
				}
				
//				valIngresosSolicitante = Float.parseFloat(txtIngresosSolicitante.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});		
		txtIngresosSolicitante.setText("0.0");
		txtIngresosSolicitante.setStyleName("gwt-TextBox2");
		txtIngresosSolicitante.setMaxLength(50);
		absolutePanel.add(txtIngresosSolicitante, 332, 116);
		txtIngresosSolicitante.setSize("103px", "19px");
		txtIngresosSolicitante.setTabIndex(1);
		
		txtIngresosConyuge = new TextBox();
		txtIngresosConyuge.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtIngresosConyuge .getText().equals("")) {
					txtIngresosConyuge .setText("0.0");
				}
				else if(txtIngresosConyuge .getText().equals(null)) {
					txtIngresosConyuge .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtIngresosConyuge.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtIngresosConyuge .setText("0.0");
					}
				}
				
//				valIngresosConyuge = Float.parseFloat(txtIngresosConyuge.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtIngresosConyuge.setText("0.0");
		txtIngresosConyuge.setStyleName("gwt-TextBox2");
		txtIngresosConyuge.setMaxLength(50);
		absolutePanel.add(txtIngresosConyuge, 332, 143);
		txtIngresosConyuge.setSize("103px", "19px");
		txtIngresosConyuge.setTabIndex(2);
		
		txtOtrosIngresos = new TextBox();
		txtOtrosIngresos.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtOtrosIngresos .getText().equals("")) {
					txtOtrosIngresos .setText("0.0");
				}
				else if(txtOtrosIngresos .getText().equals(null)) {
					txtOtrosIngresos .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtOtrosIngresos.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtOtrosIngresos .setText("0.0");
					}
				}
				
//				valOtrosIngresos = Float.parseFloat(txtOtrosIngresos.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtOtrosIngresos.setText("0.0");
		txtOtrosIngresos.setStyleName("gwt-TextBox2");
		txtOtrosIngresos.setMaxLength(50);
		absolutePanel.add(txtOtrosIngresos, 332, 169);
		txtOtrosIngresos.setSize("103px", "19px");		
		txtOtrosIngresos.setTabIndex(3);
		
		txtAlquilerVivienda = new TextBox();
		txtAlquilerVivienda.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtAlquilerVivienda .getText().equals("")) {
					txtAlquilerVivienda .setText("0.0");
				}
				else if(txtAlquilerVivienda .getText().equals(null)) {
					txtAlquilerVivienda .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtAlquilerVivienda.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtAlquilerVivienda .setText("0.0");
					}
				}
				
//				valAlquilerVivienda = Float.parseFloat(txtAlquilerVivienda.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtAlquilerVivienda.setText("0.0");
		txtAlquilerVivienda.setStyleName("gwt-TextBox2");
		txtAlquilerVivienda.setMaxLength(50);
		absolutePanel.add(txtAlquilerVivienda, 835, 116);
		txtAlquilerVivienda.setSize("103px", "19px");
		txtAlquilerVivienda.setTabIndex(4);
		
		txtAlimentacion = new TextBox();
		txtAlimentacion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtAlimentacion .getText().equals("")) {
					txtAlimentacion .setText("0.0");
				}
				else if(txtAlimentacion .getText().equals(null)) {
					txtAlimentacion .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtAlimentacion.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtAlimentacion .setText("0.0");
					}
				}
				
//				valAlimentacion = Float.parseFloat(txtAlimentacion.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});		
		txtAlimentacion.setText("0.0");
		txtAlimentacion.setStyleName("gwt-TextBox2");
		txtAlimentacion.setMaxLength(50);
		absolutePanel.add(txtAlimentacion, 835, 143);
		txtAlimentacion.setSize("103px", "19px");
		txtAlimentacion.setTabIndex(5);
		
		txtRopa = new TextBox();
		txtRopa.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtRopa .getText().equals("")) {
					txtRopa .setText("0.0");
				}
				else if(txtRopa .getText().equals(null)) {
					txtRopa .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtRopa.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtRopa .setText("0.0");
					}
				}
				
//				valRopa = Float.parseFloat(txtRopa.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtRopa.setText("0.0");
		txtRopa.setStyleName("gwt-TextBox2");
		txtRopa.setMaxLength(50);
		absolutePanel.add(txtRopa, 835, 169);
		txtRopa.setSize("103px", "19px");
		txtRopa.setTabIndex(6);
		
		txtGastosMedicos = new TextBox();
		txtGastosMedicos.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtGastosMedicos .getText().equals("")) {
					txtGastosMedicos .setText("0.0");
				}
				else if(txtGastosMedicos .getText().equals(null)) {
					txtGastosMedicos .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtGastosMedicos.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtGastosMedicos .setText("0.0");
					}
				}
				
//				valGastosMedicos = Float.parseFloat(txtGastosMedicos.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtGastosMedicos.setText("0.0");
		txtGastosMedicos.setStyleName("gwt-TextBox2");
		txtGastosMedicos.setMaxLength(50);
		absolutePanel.add(txtGastosMedicos, 835, 195);
		txtGastosMedicos.setSize("103px", "19px");
		txtGastosMedicos.setTabIndex(7);
		
		txtTransporte = new TextBox();
		txtTransporte.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTransporte .getText().equals("")) {
					txtTransporte .setText("0.0");
				}
				else if(txtTransporte .getText().equals(null)) {
					txtTransporte .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtTransporte.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtTransporte .setText("0.0");
					}
				}
				
//				valTransporte = Float.parseFloat(txtTransporte.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtTransporte.setText("0.0");
		txtTransporte.setStyleName("gwt-TextBox2");
		txtTransporte.setMaxLength(50);
		absolutePanel.add(txtTransporte, 835, 221);
		txtTransporte.setSize("103px", "19px");
		txtTransporte.setTabIndex(8);
		
		txtEducacion = new TextBox();
		txtEducacion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtEducacion .getText().equals("")) {
					txtEducacion .setText("0.0");
				}
				else if(txtEducacion .getText().equals(null)) {
					txtEducacion .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtEducacion.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtEducacion .setText("0.0");
					}
				}
				
//				valEducacion = Float.parseFloat(txtEducacion.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});		
		txtEducacion.setText("0.0");
		txtEducacion.setStyleName("gwt-TextBox2");
		txtEducacion.setMaxLength(50);
		absolutePanel.add(txtEducacion, 835, 247);
		txtEducacion.setSize("103px", "19px");
		txtEducacion.setTabIndex(9);
		
		txtPagoLuzAgua = new TextBox();
		txtPagoLuzAgua.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPagoLuzAgua .getText().equals("")) {
					txtPagoLuzAgua .setText("0.0");
				}
				else if(txtPagoLuzAgua .getText().equals(null)) {
					txtPagoLuzAgua .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtPagoLuzAgua.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtPagoLuzAgua .setText("0.0");
					}
				}
				
//				valPagoLuzAgua = Float.parseFloat(txtPagoLuzAgua.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});		
		txtPagoLuzAgua.setText("0.0");
		txtPagoLuzAgua.setStyleName("gwt-TextBox2");
		txtPagoLuzAgua.setMaxLength(50);
		absolutePanel.add(txtPagoLuzAgua, 835, 273);
		txtPagoLuzAgua.setSize("103px", "19px");
		txtPagoLuzAgua.setTabIndex(10);
		
		txtPagoPrestamos = new TextBox();
		txtPagoPrestamos.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPagoPrestamos .getText().equals("")) {
					txtPagoPrestamos .setText("0.0");
				}
				else if(txtPagoPrestamos .getText().equals(null)) {
					txtPagoPrestamos .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtPagoPrestamos.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtPagoPrestamos .setText("0.0");
					}
				}
				
//				valPagoPrestamos = Float.parseFloat(txtPagoPrestamos.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtPagoPrestamos.setText("0.0");
		txtPagoPrestamos.setStyleName("gwt-TextBox2");
		txtPagoPrestamos.setMaxLength(50);
		absolutePanel.add(txtPagoPrestamos, 835, 299);
		txtPagoPrestamos.setSize("103px", "19px");
		txtPagoPrestamos.setTabIndex(11);
		
		txtOtrosGastos1 = new TextBox();
		txtOtrosGastos1.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtOtrosGastos1 .getText().equals("")) {
					txtOtrosGastos1 .setText("0.0");
				}
				else if(txtOtrosGastos1 .getText().equals(null)) {
					txtOtrosGastos1 .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtOtrosGastos1.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtOtrosGastos1 .setText("0.0");
					}
				}
				
//				valOtrosGastos1 = Float.parseFloat(txtOtrosGastos1.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtOtrosGastos1.setText("0.0");
		txtOtrosGastos1.setStyleName("gwt-TextBox2");
		txtOtrosGastos1.setMaxLength(50);
		absolutePanel.add(txtOtrosGastos1, 835, 325);
		txtOtrosGastos1.setSize("103px", "19px");
		txtOtrosGastos1.setTabIndex(12);
		
		txtOtrosGastos2 = new TextBox();
		txtOtrosGastos2.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtOtrosGastos2 .getText().equals("")) {
					txtOtrosGastos2 .setText("0.0");
				}
				else if(txtOtrosGastos2 .getText().equals(null)) {
					txtOtrosGastos2 .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtOtrosGastos2.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtOtrosGastos2 .setText("0.0");
					}
				}
				
//				valOtrosGastos2 = Float.parseFloat(txtOtrosGastos2.getText()); // Para Ingreso Total
				actualizarIngresosTotales();
				
			}
		});			
		txtOtrosGastos2.setText("0.0");
		txtOtrosGastos2.setStyleName("gwt-TextBox2");
		txtOtrosGastos2.setMaxLength(50);
		absolutePanel.add(txtOtrosGastos2, 835, 351);
		txtOtrosGastos2.setSize("103px", "19px");
		txtOtrosGastos2.setTabIndex(13);
		
		txtPagosBuro = new TextBox();
		txtPagosBuro.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPagosBuro .getText().equals("")) {
					txtPagosBuro .setText("0.0");
				}
				else if(txtPagosBuro .getText().equals(null)) {
					txtPagosBuro .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtPagosBuro.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtPagosBuro .setText("0.0");
					}
				}
				
//				valPagosBuro = Float.parseFloat(txtPagosBuro.getText()); // Para Excedente
				actualizarIngresosTotales();	
			}
		});				
		txtPagosBuro.setText("0.0");
		txtPagosBuro.setStyleName("gwt-TextBox2");
		txtPagosBuro.setMaxLength(50);
		absolutePanel.add(txtPagosBuro, 332, 325);
		txtPagosBuro.setSize("103px", "19px");
		txtPagosBuro.setTabIndex(14);
		
		txtCuota = new TextBox();
		txtCuota.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtCuota .getText().equals("")) {
					txtCuota .setText("0.0");
				}
				else if(txtCuota .getText().equals(null)) {
					txtCuota .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtCuota.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtCuota .setText("0.0");
					}
				}
				
//				valCuota = Float.parseFloat(txtCuota.getText()); // Para Excedente
				actualizarIngresosTotales();
			}
		});			
		txtCuota.setText("0.0");
		txtCuota.setStyleName("gwt-TextBox2");
		txtCuota.setMaxLength(50);
		absolutePanel.add(txtCuota, 332, 351);
		txtCuota.setSize("103px", "19px");
		txtCuota.setTabIndex(15);
		
		txtIngresosTotales = new TextBox();
		txtIngresosTotales.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtIngresosTotales .getText().equals("")) {
					txtIngresosTotales .setText("0.0");
				}
				else if(txtIngresosTotales .getText().equals(null)) {
					txtIngresosTotales .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtIngresosTotales.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtIngresosTotales .setText("0.0");
					}
				}
			}
		});			
		txtIngresosTotales.setText("0.0");
		txtIngresosTotales.setStyleName("gwt-TextBox2");
		txtIngresosTotales.setMaxLength(50);
		txtIngresosTotales.setEnabled(false); // No modificable
		absolutePanel.add(txtIngresosTotales, 332, 195);
		txtIngresosTotales.setSize("103px", "19px");
		
		txtEgresosTotales = new TextBox();
		txtEgresosTotales.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtEgresosTotales .getText().equals("")) {
					txtEgresosTotales .setText("0.0");
				}
				else if(txtEgresosTotales .getText().equals(null)) {
					txtEgresosTotales .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtEgresosTotales.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtEgresosTotales .setText("0.0");
					}
				}
			}
		});			
		txtEgresosTotales.setText("0.0");
		txtEgresosTotales.setStyleName("gwt-TextBox2");
		txtEgresosTotales.setMaxLength(50);
		txtEgresosTotales.setEnabled(false); // No modificable
		absolutePanel.add(txtEgresosTotales, 835, 377);
		txtEgresosTotales.setSize("103px", "19px");		
		
		txtTotalIngresos = new TextBox();
		txtTotalIngresos.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTotalIngresos .getText().equals("")) {
					txtTotalIngresos .setText("0.0");
				}
				else if(txtTotalIngresos .getText().equals(null)) {
					txtTotalIngresos .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtTotalIngresos.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtTotalIngresos .setText("0.0");
					}
				}
			}
		});			
		txtTotalIngresos.setText("0.0");
		txtTotalIngresos.setStyleName("gwt-TextBox2");
		txtTotalIngresos.setMaxLength(50);
		txtTotalIngresos.setEnabled(false); // No modificable
		absolutePanel.add(txtTotalIngresos, 332, 247);
		txtTotalIngresos.setSize("103px", "19px");		
		
		txtTotalEgresos = new TextBox();
		txtTotalEgresos.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTotalEgresos .getText().equals("")) {
					txtTotalEgresos .setText("0.0");
				}
				else if(txtTotalEgresos .getText().equals(null)) {
					txtTotalEgresos .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtTotalEgresos.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtTotalEgresos .setText("0.0");
					}
				}
			}
		});				
		txtTotalEgresos.setText("0.0");
		txtTotalEgresos.setStyleName("gwt-TextBox2");
		txtTotalEgresos.setMaxLength(50);
		txtTotalEgresos.setEnabled(false); // No modificable
		absolutePanel.add(txtTotalEgresos, 332, 273);
		txtTotalEgresos.setSize("103px", "19px");		
		
		txtDiferencia = new TextBox();
		txtDiferencia.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtDiferencia .getText().equals("")) {
					txtDiferencia .setText("0.0");
				}
				else if(txtDiferencia .getText().equals(null)) {
					txtDiferencia .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtDiferencia.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtDiferencia .setText("0.0");
					}
				}
			}
		});				
		txtDiferencia.setText("0.0");
		txtDiferencia.setStyleName("gwt-TextBox2");
		txtDiferencia.setMaxLength(50);
		txtDiferencia.setEnabled(false); // No modificable
		absolutePanel.add(txtDiferencia, 332, 299);
		txtDiferencia.setSize("103px", "19px");
		
		txtExcedente = new TextBox();
		txtExcedente.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtExcedente .getText().equals("")) {
					txtExcedente .setText("0.0");
				}
				else if(txtExcedente .getText().equals(null)) {
					txtExcedente .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtExcedente.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtExcedente .setText("0.0");
					}
				}
			}
		});				
		txtExcedente.setText("0.0");
		txtExcedente.setStyleName("gwt-TextBox2");
		txtExcedente.setMaxLength(50);
		txtExcedente.setEnabled(false); // No modificable
		absolutePanel.add(txtExcedente, 332, 377);
		txtExcedente.setSize("103px", "19px");		
		
		// Boton Guardar
		
		btnGuardar = new Button("Send");

		if(this.valor) {
			btnGuardar.setVisible(true);
		}else{
			btnGuardar.setVisible(false);
		}

		btnGuardar.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				if(validarExcedente()){

					float ingresosSolicitante = 0;
					ingresosSolicitante = Float.parseFloat(txtIngresosSolicitante.getText());

					float ingresosConyuge = 0;
					ingresosConyuge = Float.parseFloat(txtIngresosConyuge.getText());

					float otrosIngresos = 0;
					otrosIngresos = Float.parseFloat(txtOtrosIngresos.getText());

					float ingresosTotales = 0;
					ingresosTotales = Float.parseFloat(txtIngresosTotales.getText());

					float totalIngresos = 0;
					totalIngresos = Float.parseFloat(txtTotalIngresos.getText());

					float totalEgresos = 0;
					totalEgresos = Float.parseFloat(txtTotalEgresos.getText());

					float diferencia = 0;
					diferencia = Float.parseFloat(txtDiferencia.getText());

					float pagosBuro = 0;
					pagosBuro = Float.parseFloat(txtPagosBuro.getText());

					float cuota = 0;
					cuota = Float.parseFloat(txtCuota.getText());

					float excedente = 0;
					excedente = Float.parseFloat(txtExcedente.getText());

					float alquilerVivienda = 0;
					alquilerVivienda = Float.parseFloat(txtAlquilerVivienda.getText());

					float alimentacion = 0;
					alimentacion = Float.parseFloat(txtAlimentacion.getText());

					float ropa = 0;
					ropa = Float.parseFloat(txtRopa.getText());

					float gastosMedicos = 0;
					gastosMedicos = Float.parseFloat(txtGastosMedicos.getText());

					float transporte = 0;
					transporte = Float.parseFloat(txtTransporte.getText());

					float educacion = 0;
					educacion = Float.parseFloat(txtEducacion.getText());

					float pagoLuzAgua = 0;
					pagoLuzAgua = Float.parseFloat(txtPagoLuzAgua.getText());

					float pagoPrestamos = 0;
					pagoPrestamos = Float.parseFloat(txtPagoPrestamos.getText());

					float otrosGastos1 = 0;
					otrosGastos1 = Float.parseFloat(txtOtrosGastos1.getText());

					float otrosGastos2 = 0;
					otrosGastos2 = Float.parseFloat(txtOtrosGastos2.getText());

					float egresosTotales = 0;
					egresosTotales = Float.parseFloat(txtEgresosTotales.getText());


					if(bandera){

						Date time = new Date();
						@SuppressWarnings("deprecation")
						Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

						solucionesService.ingresarSituacionEconomica(fecrec, formulario.idFormulario, 
								ingresosSolicitante, ingresosConyuge, otrosIngresos, ingresosTotales, 
								totalIngresos, totalEgresos, diferencia, pagosBuro, cuota, excedente,
								alquilerVivienda, alimentacion, ropa, gastosMedicos, transporte, educacion,
								pagoLuzAgua, pagoPrestamos, otrosGastos1, otrosGastos2, egresosTotales,
								new AsyncCallback<Long>() {

							public void onFailure(Throwable caught) 
							{
								mensaje = new Mensaje();
								mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
							}

							public void onSuccess(Long result)
							{
								mensaje = new Mensaje();
								mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

								idSituacionEconomica = result;
								System.out.println("Valor de NUEVA Situacion Economica: " + idSituacionEconomica);
								bandera = false;

							}
						});

					}else{

						solucionesService.actualizarSituacionEconomica(formulario.idFormulario, idSituacionEconomica, 
								ingresosSolicitante, ingresosConyuge, otrosIngresos, ingresosTotales, 
								totalIngresos, totalEgresos, diferencia, pagosBuro, cuota, excedente,
								alquilerVivienda, alimentacion, ropa, gastosMedicos, transporte, educacion,
								pagoLuzAgua, pagoPrestamos, otrosGastos1, otrosGastos2, egresosTotales,
								new AsyncCallback<Long>() {

							public void onFailure(Throwable caught) 
							{
								mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
							}

							public void onSuccess(Long result)
							{	
								mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");

								System.out.println("Valor de Datos SITUACION ECONOMICA ACTUALIZADO: " + idSituacionEconomica );
								bandera = false;

							}
						});

					}

				}	
			}
		});		
		
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 475, 460);
		btnGuardar.setTabIndex(16);

    	// ACTUALIZACION DATA
		actualizarIngresosTotales();
		
	}
	

	private void actualizarIngresosTotales(){
	
		float valIngresosSolicitante = Float.parseFloat(this.txtIngresosSolicitante.getText()); 	// Para Ingreso Total
		float valIngresosConyuge = Float.parseFloat(this.txtIngresosConyuge.getText()); 			// Para Ingreso Total
		float valOtrosIngresos = Float.parseFloat(this.txtOtrosIngresos.getText()); 				// Para Ingreso Total
		float valAlquilerVivienda = Float.parseFloat(this.txtAlquilerVivienda.getText()); 		// Para Ingreso Total
		float valAlimentacion = Float.parseFloat(this.txtAlimentacion.getText()); 				// Para Ingreso Total
		float valRopa = Float.parseFloat(this.txtRopa.getText()); 								// Para Ingreso Total
		float valGastosMedicos = Float.parseFloat(this.txtGastosMedicos.getText()); 				// Para Ingreso Total
		float valTransporte = Float.parseFloat(this.txtTransporte.getText()); 					// Para Ingreso Total
		float valEducacion = Float.parseFloat(this.txtEducacion.getText()); 						// Para Ingreso Total
		float valPagoLuzAgua = Float.parseFloat(this.txtPagoLuzAgua.getText()); 					// Para Ingreso Total
		float valPagoPrestamos = Float.parseFloat(this.txtPagoPrestamos.getText()); 				// Para Ingreso Total
		float valOtrosGastos1 = Float.parseFloat(this.txtOtrosGastos1.getText()); 				// Para Ingreso Total
		float valOtrosGastos2 = Float.parseFloat(this.txtOtrosGastos2.getText()); 				// Para Ingreso Total
		float valPagosBuro = Float.parseFloat(this.txtPagosBuro.getText()); 						// Para Excedente
		float valCuota = Float.parseFloat(this.txtCuota.getText()); 								// Para Excedente
		
		
		// Ingresos Totales
//		float valIngresosTotales = this.valIngresosSolicitante + this.valIngresosConyuge + this.valOtrosIngresos;
		float valIngresosTotales = valIngresosSolicitante + valIngresosConyuge + valOtrosIngresos;
		String valueIngresosTotales = ""+valIngresosTotales;
		
		// Egresos Totales
//		float valEgresosTotales = this.valAlquilerVivienda + this.valAlimentacion + this.valRopa + this.valGastosMedicos + this.valTransporte +
//									this.valEducacion + this.valPagoLuzAgua + this.valPagoPrestamos + this.valOtrosGastos1 + this.valOtrosGastos2;
		float valEgresosTotales = valAlquilerVivienda + valAlimentacion + valRopa + valGastosMedicos + valTransporte +
				valEducacion + valPagoLuzAgua + valPagoPrestamos + valOtrosGastos1 + valOtrosGastos2;
		String valueEgresosTotales = ""+valEgresosTotales;
		
		// Diferencia
		float valDiferencia = valIngresosTotales - valEgresosTotales;
		String valueDiferencia = ""+valDiferencia;
		
		// Pagos Buro + Cuota HPHG
//		float valPagoCuota = this.valPagosBuro + this.valCuota;
		float valPagoCuota = valPagosBuro + valCuota;
		
		// Excedente
		float valExcedente = valDiferencia - valPagoCuota;
		String valueExcedente = ""+valExcedente; 
		
		this.txtIngresosTotales.setText(valueIngresosTotales);
		this.txtEgresosTotales.setText(valueEgresosTotales);
		this.txtTotalIngresos.setText(valueIngresosTotales);
		this.txtTotalEgresos.setText(valueEgresosTotales);
		this.txtDiferencia.setText(valueDiferencia);
		this.txtExcedente.setText(valueExcedente);
		
		if(solucionConstruir.equals("1")){

			if(valExcedente < 0){
				mensaje.setMensaje("alert alert-error", "CASA NUEVA. Excedente se encuentra en Negativo. Favor revisar información.");
			}

		}

		if(solucionConstruir.equals("2")){

			if(valExcedente < 0){
				mensaje.setMensaje("alert alert-error", "MEJORAMIENTO. Excedente se encuentra en Negativo. Favor revisar información.");
			}

		}
		
//		System.out.println("Valores data Situacion Economica - Ingresos Totales: " + valIngresosTotales + ", Excedente: " + valExcedente);
		
	}
	
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
    		float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales,
			String solucionConstruir)
	{
    	
    	this.bandera = false;

    	this.idSituacionEconomica = id; // ID Formulario Cargado

    	String valorIngresosSolicitante = ""+ingresosSolicitante;
    	this.txtIngresosSolicitante.setValue(valorIngresosSolicitante);

    	String valorIngresosConyuge = ""+ingresosConyuge;
    	this.txtIngresosConyuge.setValue(valorIngresosConyuge);

    	String valorOtrosIngresos = ""+otrosIngresos;
    	this.txtOtrosIngresos.setValue(valorOtrosIngresos);

    	String valorIngresosTotales = ""+ingresosTotales;
    	this.txtIngresosTotales.setValue(valorIngresosTotales);

    	String valorTotalIngresos = ""+totalIngresos;
    	this.txtTotalIngresos.setValue(valorTotalIngresos);

    	String valorTotalEgresos = ""+totalEgresos;
    	this.txtTotalEgresos.setValue(valorTotalEgresos);

    	String valorDiferencia = ""+diferencia;
    	this.txtDiferencia.setValue(valorDiferencia);

    	String valorPagosBuro = ""+pagosBuro;
    	this.txtPagosBuro.setValue(valorPagosBuro);

    	String valorCuota = ""+cuota;
    	this.txtCuota.setValue(valorCuota);

    	String valorExcedente = ""+excedente;
    	this.txtExcedente.setValue(valorExcedente);

    	String valorAlquilerVivienda = ""+alquilerVivienda;
    	this.txtAlquilerVivienda.setValue(valorAlquilerVivienda);

    	String valorAlimentacion = ""+alimentacion;
    	this.txtAlimentacion.setValue(valorAlimentacion);

    	String valorRopa = ""+ropa;
    	this.txtRopa.setValue(valorRopa);

    	String valorGastosMedicos = ""+gastosMedicos;
    	this.txtGastosMedicos.setValue(valorGastosMedicos);

    	String valorTransporte = ""+transporte;
    	this.txtTransporte.setValue(valorTransporte);

    	String valorEducacion = ""+educacion;
    	this.txtEducacion.setValue(valorEducacion);

    	String valorPagoLuzAgua = ""+pagoLuzAgua;
    	this.txtPagoLuzAgua.setValue(valorPagoLuzAgua);
    	
    	String valorPagoPrestamos = ""+pagoPrestamos;
    	this.txtPagoPrestamos.setValue(valorPagoPrestamos);
    	
    	String valorOtrosGastos1 = ""+otrosGastos1;
    	this.txtOtrosGastos1.setValue(valorOtrosGastos1);
    	
    	String valorOtrosGastos2 = ""+otrosGastos2;
    	this.txtOtrosGastos2.setValue(valorOtrosGastos2);
    	
    	String valorEgresosTotales = ""+egresosTotales;
    	this.txtEgresosTotales.setValue(valorEgresosTotales);
	
    	// ACTUALIZACION DATA
    	actualizarIngresosTotales();
    	
    	float valExcedente = Float.parseFloat(valorExcedente);
    	
//    	System.out.println("Verificar data - valor Excendente: " + valExcedente + ", Solucion: " + solucionConstruir);
    	
		if(solucionConstruir.equals("1")){

			if(valExcedente < 0){
				mensaje.setMensaje("alert alert-error", "CASA NUEVA. Excedente se encuentra en Negativo. Favor revisar información.");
			}

		}
		
		if(solucionConstruir.equals("2")){

			if(valExcedente < 0){
				mensaje.setMensaje("alert alert-error", "MEJORAMIENTO. Excedente se encuentra en Negativo. Favor revisar información.");
			}

		}
    	
	}
    
    
    public boolean validarExcedente()
    {

		float valExcedente = Float.parseFloat(this.txtExcedente.getText());
    	
		if(solucionConstruir.equals("1")){
		
			if(valExcedente < 0){
				mensaje.setMensaje("alert alert-error", "CASA NUEVA. Excedente se encuentra en Negativo. Favor revisar información.");
				return false;
			}

		}
		
		if(solucionConstruir.equals("2")){
			
			if(valExcedente < 0){
				mensaje.setMensaje("alert alert-error", "MEJORAMIENTO. Excedente se encuentra en Negativo. Favor revisar información.");
				return false;
			}

		}
		
    	return true;    		
    }

}
