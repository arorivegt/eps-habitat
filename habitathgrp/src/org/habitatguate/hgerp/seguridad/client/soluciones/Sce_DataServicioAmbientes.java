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

public class Sce_DataServicioAmbientes extends Composite {

	private Sce_DataEntryFormularioSolicitud entryFormulario;
	private Long id_empleado = 0L;
	private boolean bandera = true;
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync RecursosHumanosService = GWT.create(RecursosHumanosService.class);
    
	public Sce_DataServicioAmbientes(Sce_DataEntryFormularioSolicitud e) {
		this.entryFormulario = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
		SimpleCheckBox simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox_1, 41, 739);
		simpleCheckBox_1.setSize("22px", "22px");
		
		Label lblEstadoCivil = new Label("El techo es de:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 42, 10);
		lblEstadoCivil.setSize("130px", "19px");
		
		ListBox listBox_estadoCivil_sce = new ListBox();
		listBox_estadoCivil_sce.addItem("-");
		listBox_estadoCivil_sce.addItem("L\u00E1mina de zinc");
		listBox_estadoCivil_sce.addItem("Duralita");
		listBox_estadoCivil_sce.addItem("Terraza");
		listBox_estadoCivil_sce.addItem("Teja");
		listBox_estadoCivil_sce.addItem("Palma");
		listBox_estadoCivil_sce.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_estadoCivil_sce, 42, 35);
		listBox_estadoCivil_sce.setSize("148px", "27px");
		
		TextBox textBox_extendida_sce = new TextBox();
		textBox_extendida_sce.setStyleName("gwt-TextBox2");
		textBox_extendida_sce.setMaxLength(200);
		absolutePanel.add(textBox_extendida_sce, 445, 110);
		textBox_extendida_sce.setSize("336px", "19px");
		
		Label lblExtendidaEn = new Label("Otro, explique:");
		lblExtendidaEn.setStyleName("label");
		absolutePanel.add(lblExtendidaEn, 445, 85);
		lblExtendidaEn.setSize("111px", "19px");
		
		ListBox listBox = new ListBox();
		listBox.addItem("-");
		listBox.addItem("Adobe");
		listBox.addItem("Block");
		listBox.addItem("Ladrillo");
		listBox.addItem("Cartón");
		listBox.addItem("Madera");
		listBox.addItem("Varitas");
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 41, 110);
		listBox.setSize("148px", "27px");
		
		Label lblLasParedesSon = new Label("Las paredes son de:");
		lblLasParedesSon.setStyleName("label");
		absolutePanel.add(lblLasParedesSon, 41, 85);
		lblLasParedesSon.setSize("130px", "19px");
		
		ListBox listBox_1 = new ListBox();
		listBox_1.addItem("-");
		listBox_1.addItem("Estufa de gas");
		listBox_1.addItem("Polletón");
		listBox_1.addItem("Fogón");
		listBox_1.addItem("Estufa eléctrica");
		listBox_1.addItem("Fuego abierto");
		listBox_1.addItem("Estufa mejorada");
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 42, 191);
		listBox_1.setSize("148px", "27px");
		
		Label lblLaCocinaEs = new Label("La cocina es de:");
		lblLaCocinaEs.setStyleName("label");
		absolutePanel.add(lblLaCocinaEs, 42, 166);
		lblLaCocinaEs.setSize("130px", "19px");
		
		ListBox listBox_2 = new ListBox();
		listBox_2.addItem("-");
		listBox_2.addItem("Tierra");
		listBox_2.addItem("Torta de cemento");
		listBox_2.addItem("Ladrillo de cemento");
		listBox_2.addItem("Piso cer\u00E1mico");
		listBox_2.addItem("Madera");
		listBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_2, 445, 191);
		listBox_2.setSize("148px", "27px");
		
		Label lblElPisoEs = new Label("El piso es de:");
		lblElPisoEs.setStyleName("label");
		absolutePanel.add(lblElPisoEs, 445, 166);
		lblElPisoEs.setSize("130px", "19px");
		
		ListBox listBox_3 = new ListBox();
		listBox_3.addItem("-");
		listBox_3.addItem("Porcelana");
		listBox_3.addItem("Letrina");
		listBox_3.addItem("Pozo ciego");
		listBox_3.addItem("Bio digestor");
		listBox_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_3, 42, 279);
		listBox_3.setSize("148px", "27px");
		
		Label label = new Label("La cocina es de:");
		label.setStyleName("label");
		absolutePanel.add(label, 42, 254);
		label.setSize("130px", "19px");
		
		ListBox listBox_4 = new ListBox();
		listBox_4.addItem("-");
		listBox_4.addItem("Pozo");
		listBox_4.addItem("Entuada");
		listBox_4.addItem("R\u00EDo");
		listBox_4.addItem("Colector de lluvia");
		listBox_4.addItem("Compra cisterna");
		listBox_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_4, 445, 279);
		listBox_4.setSize("148px", "27px");
		
		Label lblAgua = new Label("Agua:");
		lblAgua.setStyleName("label");
		absolutePanel.add(lblAgua, 445, 254);
		lblAgua.setSize("130px", "19px");
	
		
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
