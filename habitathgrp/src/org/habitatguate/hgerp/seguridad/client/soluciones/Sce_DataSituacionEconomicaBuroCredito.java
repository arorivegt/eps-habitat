package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
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
import com.google.gwt.user.client.ui.CheckBox;

public class Sce_DataSituacionEconomicaBuroCredito extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryBuroCreditoSolicitud formulario;
	private Sce_DataEntrySituacionEconomicaBuroCredito situacionEconomica;
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
	
	private CheckBox checkAprobado;

	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_DataSituacionEconomicaBuroCredito(Sce_DataEntrySituacionEconomicaBuroCredito a, Sce_DataEntryBuroCreditoSolicitud e, boolean valor) {

		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.situacionEconomica = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "536px");
		
		Label lblEgresosMensuales = new Label("EGRESOS MENSUALES");
		absolutePanel.add(lblEgresosMensuales, 515, 52);
		lblEgresosMensuales.setSize("228px", "20px");
		
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
		txtIngresosSolicitante.setText("0.0");
		txtIngresosSolicitante.setStyleName("gwt-TextBox2");
		txtIngresosSolicitante.setMaxLength(50);
		txtIngresosSolicitante.setEnabled(false); // No modificable
		absolutePanel.add(txtIngresosSolicitante, 332, 116);
		txtIngresosSolicitante.setSize("103px", "19px");
		txtIngresosSolicitante.setTabIndex(1);
		
		txtIngresosConyuge = new TextBox();	
		txtIngresosConyuge.setText("0.0");
		txtIngresosConyuge.setStyleName("gwt-TextBox2");
		txtIngresosConyuge.setMaxLength(50);
		txtIngresosConyuge.setEnabled(false); // No modificable
		absolutePanel.add(txtIngresosConyuge, 332, 143);
		txtIngresosConyuge.setSize("103px", "19px");
		txtIngresosConyuge.setTabIndex(2);
		
		txtOtrosIngresos = new TextBox();		
		txtOtrosIngresos.setText("0.0");
		txtOtrosIngresos.setStyleName("gwt-TextBox2");
		txtOtrosIngresos.setMaxLength(50);
		txtOtrosIngresos.setEnabled(false); // No modificable
		absolutePanel.add(txtOtrosIngresos, 332, 169);
		txtOtrosIngresos.setSize("103px", "19px");		
		txtOtrosIngresos.setTabIndex(3);
		
		txtAlquilerVivienda = new TextBox();		
		txtAlquilerVivienda.setText("0.0");
		txtAlquilerVivienda.setStyleName("gwt-TextBox2");
		txtAlquilerVivienda.setMaxLength(50);
		txtAlquilerVivienda.setEnabled(false); // No modificable
		absolutePanel.add(txtAlquilerVivienda, 835, 116);
		txtAlquilerVivienda.setSize("103px", "19px");
		txtAlquilerVivienda.setTabIndex(4);
		
		txtAlimentacion = new TextBox();	
		txtAlimentacion.setText("0.0");
		txtAlimentacion.setStyleName("gwt-TextBox2");
		txtAlimentacion.setMaxLength(50);
		txtAlimentacion.setEnabled(false); // No modificable
		absolutePanel.add(txtAlimentacion, 835, 143);
		txtAlimentacion.setSize("103px", "19px");
		txtAlimentacion.setTabIndex(5);
		
		txtRopa = new TextBox();		
		txtRopa.setText("0.0");
		txtRopa.setStyleName("gwt-TextBox2");
		txtRopa.setMaxLength(50);
		txtRopa.setEnabled(false); // No modificable
		absolutePanel.add(txtRopa, 835, 169);
		txtRopa.setSize("103px", "19px");
		txtRopa.setTabIndex(6);
		
		txtGastosMedicos = new TextBox();	
		txtGastosMedicos.setText("0.0");
		txtGastosMedicos.setStyleName("gwt-TextBox2");
		txtGastosMedicos.setMaxLength(50);
		txtGastosMedicos.setEnabled(false); // No modificable
		absolutePanel.add(txtGastosMedicos, 835, 195);
		txtGastosMedicos.setSize("103px", "19px");
		txtGastosMedicos.setTabIndex(7);
		
		txtTransporte = new TextBox();		
		txtTransporte.setText("0.0");
		txtTransporte.setStyleName("gwt-TextBox2");
		txtTransporte.setMaxLength(50);
		txtTransporte.setEnabled(false); // No modificable
		absolutePanel.add(txtTransporte, 835, 221);
		txtTransporte.setSize("103px", "19px");
		txtTransporte.setTabIndex(8);
		
		txtEducacion = new TextBox();	
		txtEducacion.setText("0.0");
		txtEducacion.setStyleName("gwt-TextBox2");
		txtEducacion.setMaxLength(50);
		txtEducacion.setEnabled(false); // No modificable
		absolutePanel.add(txtEducacion, 835, 247);
		txtEducacion.setSize("103px", "19px");
		txtEducacion.setTabIndex(9);
		
		txtPagoLuzAgua = new TextBox();	
		txtPagoLuzAgua.setText("0.0");
		txtPagoLuzAgua.setStyleName("gwt-TextBox2");
		txtPagoLuzAgua.setMaxLength(50);
		txtPagoLuzAgua.setEnabled(false); // No modificable
		absolutePanel.add(txtPagoLuzAgua, 835, 273);
		txtPagoLuzAgua.setSize("103px", "19px");
		txtPagoLuzAgua.setTabIndex(10);
		
		txtPagoPrestamos = new TextBox();		
		txtPagoPrestamos.setText("0.0");
		txtPagoPrestamos.setStyleName("gwt-TextBox2");
		txtPagoPrestamos.setMaxLength(50);
		txtPagoPrestamos.setEnabled(false); // No modificable
		absolutePanel.add(txtPagoPrestamos, 835, 299);
		txtPagoPrestamos.setSize("103px", "19px");
		txtPagoPrestamos.setTabIndex(11);
		
		txtOtrosGastos1 = new TextBox();		
		txtOtrosGastos1.setText("0.0");
		txtOtrosGastos1.setStyleName("gwt-TextBox2");
		txtOtrosGastos1.setMaxLength(50);
		txtOtrosGastos1.setEnabled(false); // No modificable
		absolutePanel.add(txtOtrosGastos1, 835, 325);
		txtOtrosGastos1.setSize("103px", "19px");
		txtOtrosGastos1.setTabIndex(12);
		
		txtOtrosGastos2 = new TextBox();			
		txtOtrosGastos2.setText("0.0");
		txtOtrosGastos2.setStyleName("gwt-TextBox2");
		txtOtrosGastos2.setMaxLength(50);
		txtOtrosGastos2.setEnabled(false); // No modificable
		absolutePanel.add(txtOtrosGastos2, 835, 351);
		txtOtrosGastos2.setSize("103px", "19px");
		txtOtrosGastos2.setTabIndex(13);
		
		txtPagosBuro = new TextBox();			
		txtPagosBuro.setText("0.0");
		txtPagosBuro.setStyleName("gwt-TextBox2");
		txtPagosBuro.setMaxLength(50);
		txtPagosBuro.setEnabled(false); // No modificable
		absolutePanel.add(txtPagosBuro, 332, 325);
		txtPagosBuro.setSize("103px", "19px");
		txtPagosBuro.setTabIndex(14);
		
		txtCuota = new TextBox();		
		txtCuota.setText("0.0");
		txtCuota.setStyleName("gwt-TextBox2");
		txtCuota.setMaxLength(50);
		txtCuota.setEnabled(false); // No modificable
		absolutePanel.add(txtCuota, 332, 351);
		txtCuota.setSize("103px", "19px");
		txtCuota.setTabIndex(15);
		
		txtIngresosTotales = new TextBox();		
		txtIngresosTotales.setText("0.0");
		txtIngresosTotales.setStyleName("gwt-TextBox2");
		txtIngresosTotales.setMaxLength(50);
		txtIngresosTotales.setEnabled(false); // No modificable
		absolutePanel.add(txtIngresosTotales, 332, 195);
		txtIngresosTotales.setSize("103px", "19px");
		
		txtEgresosTotales = new TextBox();		
		txtEgresosTotales.setText("0.0");
		txtEgresosTotales.setStyleName("gwt-TextBox2");
		txtEgresosTotales.setMaxLength(50);
		txtEgresosTotales.setEnabled(false); // No modificable
		absolutePanel.add(txtEgresosTotales, 835, 377);
		txtEgresosTotales.setSize("103px", "19px");		
		
		txtTotalIngresos = new TextBox();		
		txtTotalIngresos.setText("0.0");
		txtTotalIngresos.setStyleName("gwt-TextBox2");
		txtTotalIngresos.setMaxLength(50);
		txtTotalIngresos.setEnabled(false); // No modificable
		absolutePanel.add(txtTotalIngresos, 332, 247);
		txtTotalIngresos.setSize("103px", "19px");		
		
		txtTotalEgresos = new TextBox();			
		txtTotalEgresos.setText("0.0");
		txtTotalEgresos.setStyleName("gwt-TextBox2");
		txtTotalEgresos.setMaxLength(50);
		txtTotalEgresos.setEnabled(false); // No modificable
		absolutePanel.add(txtTotalEgresos, 332, 273);
		txtTotalEgresos.setSize("103px", "19px");		
		
		txtDiferencia = new TextBox();			
		txtDiferencia.setText("0.0");
		txtDiferencia.setStyleName("gwt-TextBox2");
		txtDiferencia.setMaxLength(50);
		txtDiferencia.setEnabled(false); // No modificable
		absolutePanel.add(txtDiferencia, 332, 299);
		txtDiferencia.setSize("103px", "19px");
		
		txtExcedente = new TextBox();			
		txtExcedente.setText("0.0");
		txtExcedente.setStyleName("gwt-TextBox2");
		txtExcedente.setMaxLength(50);
		txtExcedente.setEnabled(false); // No modificable
		absolutePanel.add(txtExcedente, 332, 377);
		txtExcedente.setSize("103px", "19px");		
		
		Label lblAprobacion = new Label("CREDITO APROBADO:");
		lblAprobacion.setStyleName("label");
		absolutePanel.add(lblAprobacion, 49, 448);
		lblAprobacion.setSize("202px", "19px");
		
		checkAprobado = new CheckBox("Si");
		checkAprobado.setHTML("");
		absolutePanel.add(checkAprobado, 113, 474);
		checkAprobado.setSize("69px", "24px");
		
		// Boton Guardar
		
		btnGuardar = new Button("Send");
		
		if(this.valor) {
			btnGuardar.setVisible(true);
		}else{
			btnGuardar.setVisible(false);
		}
		
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		
				Boolean aprobadoBuroCredito = false;
				aprobadoBuroCredito = checkAprobado.getValue();
				
				
				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.actualizarDatosAprobacionBuroCredito(formulario.idFormulario, 
							aprobadoBuroCredito,
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
							System.out.println("Valor de Aprobacion Buro Credito: " + idSituacionEconomica);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarDatosAprobacionBuroCredito(formulario.idFormulario, 
							aprobadoBuroCredito,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de Aprobacion Buro Credito ACTUALIZADO: " + idSituacionEconomica );
							bandera = false;

						}
					});
					
				}
				
			}
		});		
		
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 475, 509);
		btnGuardar.setTabIndex(16);

	
	}
	
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
    		float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales,
			Boolean valor)
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
    	
    	this.checkAprobado.setValue(valor);
    	
	}

}
