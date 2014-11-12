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
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextArea;

public class Sce_DataDatosVivienda extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryFormularioSolicitud formulario;
	private Sce_DataEntryDatosVivienda datosVivienda;
    private boolean bandera = true;
	private Long idDatosVivienda = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	
	private ListBox listViviendaActual;
	private TextBox txtOtroExplique;
	private CheckBox checkBoxAgua;
	private CheckBox checkBoxDrenaje;
	private	CheckBox checkBoxSanitario;
	private CheckBox checkBoxElectricidad;
	private TextArea txtAreaBienes;
	private TextBox txtValorInmueble;
	private ListBox listTecho; 
	private ListBox listPared;
	ListBox listCocina;
	private Button btnGuardar;
    
	public Sce_DataDatosVivienda(Sce_DataEntryDatosVivienda a, Sce_DataEntryFormularioSolicitud e) {
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.datosVivienda = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "455px");
		
		Label lblEstadoCivil = new Label("Datos de la vivienda:");
		lblEstadoCivil.setStyleName("label");
		absolutePanel.add(lblEstadoCivil, 42, 10);
		lblEstadoCivil.setSize("207px", "19px");
		
		listViviendaActual = new ListBox();
		listViviendaActual.addItem("-", "-1");
		listViviendaActual.addItem("Es propia", "1");
		listViviendaActual.addItem("Es alquilada", "2");
		listViviendaActual.addItem("Es de un familiar", "3");
		listViviendaActual.addItem("Es prestada", "4");
		listViviendaActual.addItem("Solamente la cuida", "5");
		listViviendaActual.setStyleName("gwt-TextBox2");
		absolutePanel.add(listViviendaActual, 41, 35);
		listViviendaActual.setSize("148px", "27px");
		
		txtOtroExplique = new TextBox();
		txtOtroExplique.setStyleName("gwt-TextBox2");
		txtOtroExplique.setMaxLength(200);
		absolutePanel.add(txtOtroExplique, 266, 41);
		txtOtroExplique.setSize("256px", "19px");
		
		Label lblExtendidaEn = new Label("Otro, explique:");
		lblExtendidaEn.setStyleName("label");
		absolutePanel.add(lblExtendidaEn, 266, 10);
		lblExtendidaEn.setSize("111px", "19px");
		
		checkBoxAgua = new CheckBox("Servicio de agua");
		absolutePanel.add(checkBoxAgua, 271, 167);
		checkBoxAgua.setSize("274px", "24px");
		
		checkBoxDrenaje = new CheckBox("Servicio de drenaje");
		absolutePanel.add(checkBoxDrenaje, 583, 170);
		checkBoxDrenaje.setSize("218px", "21px");
		
		checkBoxSanitario = new CheckBox("Servicio Sanitario");
		absolutePanel.add(checkBoxSanitario, 583, 211);
		checkBoxSanitario.setSize("218px", "21px");
		
		checkBoxElectricidad = new CheckBox("Servicio de eletricidad");
		absolutePanel.add(checkBoxElectricidad, 271, 211);
		checkBoxElectricidad.setSize("288px", "21px");
		
		Label lblServicios = new Label("Servicios basicos:");
		lblServicios.setStyleName("label");
		absolutePanel.add(lblServicios, 42, 167);
		lblServicios.setSize("187px", "19px");
		
		txtAreaBienes = new TextArea();
		absolutePanel.add(txtAreaBienes, 42, 293);
		txtAreaBienes.setSize("857px", "69px");
		
		Label lblIndiqueLosBienes = new Label("Indique los bienes inmuebles que posee:");
		lblIndiqueLosBienes.setStyleName("label");
		absolutePanel.add(lblIndiqueLosBienes, 42, 256);
		lblIndiqueLosBienes.setSize("379px", "19px");
		
		txtValorInmueble = new TextBox();
		txtValorInmueble.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtValorInmueble .getText().equals("")) {
					txtValorInmueble .setText("0.0");
				}
				else if(txtValorInmueble .getText().equals(null)) {
					txtValorInmueble .setText("0.0");
				}
				else{
					try{
						Float.parseFloat(txtValorInmueble.getText());						
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor No valido");
						txtValorInmueble .setText("0.0");
					}
				}
			}
		});			
		txtValorInmueble.setText("0.0");
		txtValorInmueble.setStyleName("gwt-TextBox2");
		txtValorInmueble.setMaxLength(200);
		absolutePanel.add(txtValorInmueble, 246, 404);
		txtValorInmueble.setSize("117px", "19px");
		
		Label lblValor = new Label("En cuanto los valora:");
		lblValor.setStyleName("label");
		absolutePanel.add(lblValor, 42, 406);
		lblValor.setSize("187px", "19px");
		
		listTecho = new ListBox();
		listTecho.addItem("-", "-1");
		listTecho.addItem("Lámina de zinc", "1");
		listTecho.addItem("Duralita", "2");
		listTecho.addItem("Terraza", "3");
		listTecho.addItem("Teja", "4");
		listTecho.addItem("Palma", "5");
		listTecho.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTecho, 42, 113);
		listTecho.setSize("148px", "27px");
		
		Label lblTecho = new Label("Techo de:");
		lblTecho.setStyleName("label");
		absolutePanel.add(lblTecho, 43, 88);
		lblTecho.setSize("207px", "19px");
		
		Label lblPared = new Label("Paredes de:");
		lblPared.setStyleName("label");
		absolutePanel.add(lblPared, 317, 88);
		lblPared.setSize("207px", "19px");
		
		listPared = new ListBox();
		listPared.addItem("-", "-1");
		listPared.addItem("Adobe", "1");
		listPared.addItem("Block", "2");
		listPared.addItem("Ladrillo", "3");
		listPared.addItem("Cartón", "4");
		listPared.addItem("Madera", "5");
		listPared.addItem("Varitas", "6");
		listPared.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPared, 316, 113);
		listPared.setSize("148px", "27px");
		
		listCocina = new ListBox();
		listCocina.addItem("-", "-1");
		listCocina.addItem("Estufa de gas", "1");
		listCocina.addItem("Polletón", "2");
		listCocina.addItem("Fogón", "3");
		listCocina.addItem("Estufa eléctrica", "4");
		listCocina.addItem("Fuego abierto", "5");
		listCocina.addItem("Estufa mejorada", "6");
		listCocina.setStyleName("gwt-TextBox2");
		absolutePanel.add(listCocina, 593, 113);
		listCocina.setSize("148px", "27px");
		
		Label lblCocina = new Label("Cocina de:");
		lblCocina.setStyleName("label");
		absolutePanel.add(lblCocina, 594, 88);
		lblCocina.setSize("207px", "19px");
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				String viviendaActual = "-1";		
				viviendaActual = listViviendaActual.getValue(listViviendaActual.getSelectedIndex());	
				
				String otroViviendaActual = "";		
				if(txtOtroExplique.getText() == null){
					otroViviendaActual = "";
				}else{
					otroViviendaActual = txtOtroExplique.getText();
				}

				String techo = "-1";		
				techo = listTecho.getValue(listTecho.getSelectedIndex());
				
				String pared = "-1";		
				pared = listPared.getValue(listPared.getSelectedIndex());	

				String cocina = "-1";		
				cocina = listCocina.getValue(listCocina.getSelectedIndex());	
				
				Boolean servicioAgua = false;
				servicioAgua = checkBoxAgua.getValue();

				Boolean servicioDrenaje = false;
				servicioDrenaje = checkBoxDrenaje.getValue();
				
				Boolean servicioElectricidad = false;
				servicioElectricidad = checkBoxElectricidad.getValue();
				
				Boolean servicioSanitario = false;
				servicioSanitario = checkBoxSanitario.getValue();
				
				String bienesInmuebles = "";		
				if(txtAreaBienes.getText() == null){
					bienesInmuebles = "";
				}else{
					bienesInmuebles = txtAreaBienes.getText();
				}
				
				float valorInmueble = 0;
				valorInmueble = Float.parseFloat(txtValorInmueble.getText());
				
				if(bandera){

					Date time = new Date();
					@SuppressWarnings("deprecation")
					Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());

					solucionesService.ingresarDatosVivienda(fecrec, formulario.idFormulario, 
							viviendaActual, otroViviendaActual, 
							techo, pared, cocina,
							servicioAgua, servicioDrenaje, servicioElectricidad, servicioSanitario,
							bienesInmuebles, valorInmueble,
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

							idDatosVivienda = result;
							System.out.println("Valor de NUEVO Carga Familiar: " + idDatosVivienda);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarDatosViviendaActual(formulario.idFormulario, idDatosVivienda, 
							viviendaActual, otroViviendaActual, 
							techo, pared, cocina,
							servicioAgua, servicioDrenaje, servicioElectricidad, servicioSanitario,
							bienesInmuebles, valorInmueble,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de DATOS DE VIVIENDA ACTUAL ACTUALIZADO: " + idDatosVivienda );
							bandera = false;

						}
					});
					
				}
				
			}
		});
		
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 475, 442);
		
	}
	
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles)
	{
    	
		this.bandera = false;
		
		this.idDatosVivienda = id; // ID Formulario Cargado
		
		this.txtOtroExplique.setText(otroDatosVivienda);
		this.checkBoxAgua.setValue(servicioAgua);
		this.checkBoxDrenaje.setValue(servicioDrenaje);
		this.checkBoxElectricidad.setValue(servicioElectricidad);
		this.checkBoxSanitario.setValue(servicioSanitario);
		this.txtAreaBienes.setValue(bienesInmuebles);
		String valorInmueblesValue = ""+valorInmuebles;
		this.txtValorInmueble.setValue(valorInmueblesValue);
		
		
        boolean bandera = true;
        for(int i=0; i < this.listViviendaActual.getItemCount() && bandera; i++){
            bandera = !this.listViviendaActual.getValue(i).equals(datosVivienda);
            this.listViviendaActual.setSelectedIndex(i);
       }   
        
        bandera = true;
	    for(int i=0; i < this.listTecho.getItemCount() && bandera; i++){
	       bandera = !this.listTecho.getValue(i).equals(techo);
	       this.listTecho.setSelectedIndex(i);
	    } 	  

        bandera = true;
	    for(int i=0; i < this.listPared.getItemCount() && bandera; i++){
	       bandera = !this.listPared.getValue(i).equals(pared);
	       this.listPared.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listCocina.getItemCount() && bandera; i++){
	       bandera = !this.listCocina.getValue(i).equals(cocina);
	       this.listCocina.setSelectedIndex(i);
	    } 
	    
	}


}
