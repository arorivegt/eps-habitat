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
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;

public class Sce_DataColindanciasMejoramiento extends Composite {

	private Sce_DataEntrySeguimientoFormularioSolicitud entryFormulario;
	private Long id_empleado = 0L;
	private boolean bandera = true;
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync RecursosHumanosService = GWT.create(RecursosHumanosService.class);
    
	public Sce_DataColindanciasMejoramiento(Sce_DataEntrySeguimientoFormularioSolicitud e) {
		this.entryFormulario = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
		Label lblNombres = new Label("COLINDANCIAS DEL TERRENO");
		lblNombres.setStyleName("label");
		absolutePanel.add(lblNombres, 42, 30);
		lblNombres.setSize("240px", "19px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label lblEstadoCivil = new Label("Norte:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 42, 101);
		lblEstadoCivil.setSize("90px", "19px");
		
		IntegerBox integerBox_DPI_sce = new IntegerBox();
		integerBox_DPI_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_DPI_sce, 138, 101);
		integerBox_DPI_sce.setSize("117px", "19px");
		
		Label lblLugarDeTrabajo = new Label("Describa el tipo de mejoramiento que desea realizar:");
		lblLugarDeTrabajo.setStyleName("label");
		absolutePanel.add(lblLugarDeTrabajo, 42, 294);
		lblLugarDeTrabajo.setSize("329px", "19px");
		
		Label lblSur = new Label("Sur:");
		lblSur.setStyleName("label");
		absolutePanel.add(lblSur, 342, 101);
		lblSur.setSize("90px", "19px");
		
		IntegerBox integerBox = new IntegerBox();
		integerBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox, 438, 101);
		integerBox.setSize("117px", "19px");
		
		Label lblEste = new Label("Este:");
		lblEste.setStyleName("label");
		absolutePanel.add(lblEste, 42, 155);
		lblEste.setSize("90px", "19px");
		
		IntegerBox integerBox_1 = new IntegerBox();
		integerBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_1, 138, 155);
		integerBox_1.setSize("117px", "19px");
		
		IntegerBox integerBox_2 = new IntegerBox();
		integerBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_2, 438, 153);
		integerBox_2.setSize("117px", "19px");
		
		Label lblOeste = new Label("Oeste:");
		lblOeste.setStyleName("label");
		absolutePanel.add(lblOeste, 342, 153);
		lblOeste.setSize("90px", "19px");
		
		Label lblTipoDeMejoramiento = new Label("TIPO DE MEJORAMIENTO QUE DESEA REALIZAR");
		lblTipoDeMejoramiento.setStyleName("label");
		absolutePanel.add(lblTipoDeMejoramiento, 42, 247);
		lblTipoDeMejoramiento.setSize("390px", "19px");
		
		TextArea textArea = new TextArea();
		absolutePanel.add(textArea, 42, 342);
		textArea.setSize("867px", "66px");
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("Guardar");
		absolutePanel.add(btnNewButton, 475, 460);

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
