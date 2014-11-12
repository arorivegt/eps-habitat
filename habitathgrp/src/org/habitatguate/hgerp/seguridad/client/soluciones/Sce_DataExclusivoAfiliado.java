package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
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
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.CheckBox;

public class Sce_DataExclusivoAfiliado extends Composite {

	private Sce_DataEntrySeguimientoFormularioSolicitud entryFormulario;
	private Long id_empleado = 0L;
	private boolean bandera = true;
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync RecursosHumanosService = GWT.create(RecursosHumanosService.class);
    private TextBox textBox_direccionActual_sce;
    
	public Sce_DataExclusivoAfiliado(Sce_DataEntrySeguimientoFormularioSolicitud e) {
		this.entryFormulario = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
		Label lblDireccionActual = new Label("Monto total de egresos:");
		lblDireccionActual.setStyleName("label");
		absolutePanel.add(lblDireccionActual, 41, 105);
		lblDireccionActual.setSize("174px", "19px");
		
		textBox_direccionActual_sce = new TextBox();
		textBox_direccionActual_sce.setMaxLength(200);
		textBox_direccionActual_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_direccionActual_sce, 226, 103);
		textBox_direccionActual_sce.setSize("123px", "19px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label lblEstadoCivil = new Label("Salarios m\u00EDnimos:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 421, 50);
		lblEstadoCivil.setSize("130px", "19px");
		
		TextBox textBox_extendida_sce = new TextBox();
		textBox_extendida_sce.setStyleName("gwt-TextBox2");
		textBox_extendida_sce.setMaxLength(200);
		absolutePanel.add(textBox_extendida_sce, 226, 50);
		textBox_extendida_sce.setSize("123px", "19px");
		
		Label lblExtendidaEn = new Label("Monto total de ingreso familiar:");
		lblExtendidaEn.setStyleName("label");
		absolutePanel.add(lblExtendidaEn, 38, 52);
		lblExtendidaEn.setSize("185px", "19px");
		
		CheckBox chckbxMenos = new CheckBox("Menos");
		absolutePanel.add(chckbxMenos, 557, 50);
		chckbxMenos.setSize("69px", "21px");
		
		CheckBox chckbxI = new CheckBox("I");
		absolutePanel.add(chckbxI, 652, 50);
		chckbxI.setSize("62px", "21px");
		
		CheckBox chckbxIi = new CheckBox("II");
		absolutePanel.add(chckbxIi, 735, 50);
		chckbxIi.setSize("62px", "21px");
		
		CheckBox chckbxIii = new CheckBox("III");
		absolutePanel.add(chckbxIii, 820, 50);
		chckbxIii.setSize("62px", "21px");
		
		CheckBox chckbxMs = new CheckBox("M\u00E1s");
		absolutePanel.add(chckbxMs, 968, 50);
		chckbxMs.setSize("62px", "21px");
		
		CheckBox chckbxIv = new CheckBox("IV");
		absolutePanel.add(chckbxIv, 889, 50);
		chckbxIv.setSize("62px", "21px");
		
		Label lblDiferenciaDeIngresos = new Label("Diferencia de Ingresos menos Egresos:");
		lblDiferenciaDeIngresos.setStyleName("label");
		absolutePanel.add(lblDiferenciaDeIngresos, 421, 105);
		lblDiferenciaDeIngresos.setSize("229px", "19px");
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(200);
		absolutePanel.add(textBox, 674, 103);
		textBox.setSize("123px", "19px");
		
		Label lblTotalDiferenciaDividido = new Label("Total diferencia dividido entre los ingresos multiplicado por cien (%):");
		lblTotalDiferenciaDividido.setStyleName("label");
		absolutePanel.add(lblTotalDiferenciaDividido, 38, 174);
		lblTotalDiferenciaDividido.setSize("417px", "19px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(200);
		absolutePanel.add(textBox_1, 461, 172);
		textBox_1.setSize("123px", "19px");
		
		Label lblEsteEsEl = new Label("Este es el porcentaje del salario que la familia puede comprometer");
		lblEsteEsEl.setStyleName("label");
		absolutePanel.add(lblEsteEsEl, 634, 174);
		lblEsteEsEl.setSize("372px", "19px");
		
		Label lblComoMximoEne = new Label("como m\u00E1ximo ene le pago de una cuota mensual.");
		lblComoMximoEne.setStyleName("label");
		absolutePanel.add(lblComoMximoEne, 634, 199);
		lblComoMximoEne.setSize("372px", "19px");
		
		Label lblConRelacinAl = new Label("Con relaci\u00F3n al dato anterior por favor calcular la cuota mensual que");
		lblConRelacinAl.setStyleName("label");
		absolutePanel.add(lblConRelacinAl, 41, 249);
		lblConRelacinAl.setSize("414px", "19px");
		
		Label lblDeberCancelarLa = new Label("deber\u00E1 cancelar la familia para amortizar el financiamiento:");
		lblDeberCancelarLa.setStyleName("label");
		absolutePanel.add(lblDeberCancelarLa, 41, 274);
		lblDeberCancelarLa.setSize("414px", "19px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox2");
		textBox_2.setMaxLength(200);
		absolutePanel.add(textBox_2, 461, 247);
		textBox_2.setSize("123px", "19px");
		
		Label lblEstaCuotaDebe = new Label("Esta cuota debe ser menor a la capacidad de endeudamiento.");
		lblEstaCuotaDebe.setStyleName("label");
		absolutePanel.add(lblEstaCuotaDebe, 634, 249);
		lblEstaCuotaDebe.setSize("372px", "19px");
		
		Button btnGuardar = new Button("GUARDAR");
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 475, 460);
	
	}

	public void LlenarDatos(Long id,String listEstadoCivil,String listSexo,String txtPrimerApellido,
		    String txtSegundoApellido , String txtApellidoCasada ,String txtNo_iggs, String txtPrimerNombre,
		    String txtSegundoNombre ,String listPais,String listNoDependientes , String txtTipoPasaporte ,
		    String listCedulaMunicipio,String txtDireccion , String listDireccionMunicipio, String txtCorreoElectronico,
		    String listTipoLicencia, Long dateAnnioNacimiento,String txtOcupacion , String txtCentroTrabajo,
		    String txt_CodigoOcupacion, String txtProfesion,String txtTipoPlanilla, Long dateFechaIngreso,
		    String txtRegistro , String txtNoOrden , String txtDPI,String txtTelefonoCasa, String txtTelefonoCelular ,
		    String txtNoLicencia, String txtNit, String txtNoPasaporte,String txtSalarioBase ,String txtBonificacion ,
		    String txtTotal, String listCedulaDepartamento , String listDireccionDepartamento ,String txtConIVS ,
		    String txtSinIVS )
	{
		this.id_empleado = id;
		this.bandera = false;

        boolean bandera = true;
				  
		
	}
}
