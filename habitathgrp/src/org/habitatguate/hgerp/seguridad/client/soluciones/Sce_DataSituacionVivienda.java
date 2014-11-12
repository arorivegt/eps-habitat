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
import com.google.gwt.user.client.ui.RadioButton;

public class Sce_DataSituacionVivienda extends Composite {

	private Sce_DataEntryFormularioSolicitud entryFormulario;
	private Long id_empleado = 0L;
	private boolean bandera = true;
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync RecursosHumanosService = GWT.create(RecursosHumanosService.class);
    
	public Sce_DataSituacionVivienda(Sce_DataEntryFormularioSolicitud e) {
		this.entryFormulario = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label lblEstadoCivil = new Label("Servicios con que cuenta la vivienda:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 41, 41);
		lblEstadoCivil.setSize("258px", "19px");
		
		TextBox textBox_extendida_sce = new TextBox();
		textBox_extendida_sce.setStyleName("gwt-TextBox2");
		textBox_extendida_sce.setMaxLength(200);
		absolutePanel.add(textBox_extendida_sce, 220, 364);
		textBox_extendida_sce.setSize("336px", "19px");
		
		Label lblExtendidaEn = new Label("Otro, explique:");
		lblExtendidaEn.setStyleName("label");
		absolutePanel.add(lblExtendidaEn, 41, 364);
		lblExtendidaEn.setSize("111px", "19px");
		
		Label lblLasParedesSon = new Label("N\u00FAmero de dormitorios:");
		lblLasParedesSon.setStyleName("label");
		absolutePanel.add(lblLasParedesSon, 42, 149);
		lblLasParedesSon.setSize("218px", "19px");
		
		CheckBox chckbxNewCheckBox = new CheckBox("Servicio de agua");
		absolutePanel.add(chckbxNewCheckBox, 317, 39);
		
		CheckBox chckbxServicioDeDrenaje = new CheckBox("Servicio de drenaje");
		absolutePanel.add(chckbxServicioDeDrenaje, 507, 41);
		chckbxServicioDeDrenaje.setSize("182px", "21px");
		
		CheckBox chckbxServicioDeEletricidad = new CheckBox("Servicio de eletricidad");
		absolutePanel.add(chckbxServicioDeEletricidad, 317, 85);
		chckbxServicioDeEletricidad.setSize("174px", "21px");
		
		CheckBox chckbxServicioDeCable = new CheckBox("Servicio de cable");
		absolutePanel.add(chckbxServicioDeCable, 507, 85);
		chckbxServicioDeCable.setSize("182px", "21px");
		
		IntegerBox integerBox = new IntegerBox();
		integerBox.setText("0");
		absolutePanel.add(integerBox, 220, 142);
		
		Label lblTieneCocina = new Label("Tiene cocina:");
		lblTieneCocina.setStyleName("label");
		absolutePanel.add(lblTieneCocina, 41, 214);
		lblTieneCocina.setSize("151px", "19px");
		
		Label lblTieneBao = new Label("Tiene ba\u00F1o:");
		lblTieneBao.setStyleName("label");
		absolutePanel.add(lblTieneBao, 41, 264);
		lblTieneBao.setSize("151px", "19px");
		
		Label lblParqueoParaVehculo = new Label("Parqueo para veh\u00EDculo:");
		lblParqueoParaVehculo.setStyleName("label");
		absolutePanel.add(lblParqueoParaVehculo, 41, 312);
		lblParqueoParaVehculo.setSize("151px", "19px");
		
		RadioButton radioButton = new RadioButton("new name", "Si");
		absolutePanel.add(radioButton, 220, 264);
		radioButton.setSize("53px", "21px");
		
		RadioButton radioButton_1 = new RadioButton("new name", "No");
		absolutePanel.add(radioButton_1, 267, 264);
		radioButton_1.setSize("53px", "21px");
		
		RadioButton radioButton_2 = new RadioButton("new name", "Si");
		absolutePanel.add(radioButton_2, 220, 310);
		radioButton_2.setSize("53px", "21px");
		
		RadioButton radioButton_3 = new RadioButton("new name", "No");
		absolutePanel.add(radioButton_3, 267, 310);
		radioButton_3.setSize("53px", "21px");
		
		RadioButton radioButton_4 = new RadioButton("new name", "No");
		absolutePanel.add(radioButton_4, 267, 214);
		radioButton_4.setSize("53px", "21px");
		
		RadioButton radioButton_5 = new RadioButton("new name", "Si");
		absolutePanel.add(radioButton_5, 220, 214);
		radioButton_5.setSize("53px", "21px");
	
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
