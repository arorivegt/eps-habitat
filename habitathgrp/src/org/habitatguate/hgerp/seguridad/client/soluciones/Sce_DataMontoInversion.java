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

public class Sce_DataMontoInversion extends Composite {

	private Sce_DataEntryGarantiaSolicitud entryFormulario;
	private Long id_empleado = 0L;
	private boolean bandera = true;
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync RecursosHumanosService = GWT.create(RecursosHumanosService.class);
    
	public Sce_DataMontoInversion(Sce_DataEntryGarantiaSolicitud e) {
		this.entryFormulario = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label lblEstadoCivil = new Label("Materiales de construcci\u00F3n Q. :");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 41, 53);
		lblEstadoCivil.setSize("189px", "19px");
		
		IntegerBox integerBox_DPI_sce = new IntegerBox();
		integerBox_DPI_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_DPI_sce, 274, 53);
		integerBox_DPI_sce.setSize("117px", "19px");
		
		Label lblSur = new Label("Mano de obra Q. :");
		lblSur.setStyleName("label");
		absolutePanel.add(lblSur, 41, 119);
		lblSur.setSize("189px", "19px");
		
		IntegerBox integerBox = new IntegerBox();
		integerBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox, 274, 119);
		integerBox.setSize("117px", "19px");
		
		Label lblEste = new Label("Imprevistos Q. :");
		lblEste.setStyleName("label");
		absolutePanel.add(lblEste, 41, 186);
		lblEste.setSize("189px", "19px");
		
		IntegerBox integerBox_1 = new IntegerBox();
		integerBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_1, 274, 186);
		integerBox_1.setSize("117px", "19px");
		
		IntegerBox integerBox_2 = new IntegerBox();
		integerBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(integerBox_2, 274, 246);
		integerBox_2.setSize("117px", "19px");
		
		Label lblOeste = new Label("Total de la inversi\u00F3n Q. :");
		lblOeste.setStyleName("label");
		absolutePanel.add(lblOeste, 41, 248);
		lblOeste.setSize("189px", "19px");
		
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

	}
}
