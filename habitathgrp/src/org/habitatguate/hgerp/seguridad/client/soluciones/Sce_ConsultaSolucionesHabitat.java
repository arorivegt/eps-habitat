package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class Sce_ConsultaSolucionesHabitat extends Composite  {

    private  Grid grid;
    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
	
	// Llaves
	private Long idEmpleado = 0L;
	private Long idAfiliado = 0L;
	private Long idRol = 0L;
	
	private Button button;
	private FormPanel formPanel;
	private VerticalPanel verticalPanel;
	private Mensaje mensaje; 
    private ScrollPanel scrollPanel;
    private AbsolutePanel absolutePanel_1;
    private ListBox listSolucionConstruir ;
    private Loading load ;
    private List<Sce_ReporteDatosSolucionesConstruidas> DATOS;
  	
    // Valor Escritura-Lectura
    private boolean valor;
    // Opcion de busqueda
    private boolean opcion;
    
	public Sce_ConsultaSolucionesHabitat(boolean valor, final boolean opcion) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
	    this.opcion = opcion;				// Variable de opcion de busqueda Especifica|General
		
		// Obtener Id Empleado
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idEmpleado = result;
				System.out.println("Id Empleado: " + idEmpleado);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		// Obtener Id Afiliado
		recursosHumanosService.obtenerIdAfiliado(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idAfiliado = result;
				System.out.println("Afiliado: " + idAfiliado);	
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error no tiene Afiliado asignado Empleado");
			}
		});
		
		// Obtener Id Rol
		recursosHumanosService.obtenerIdRol(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idRol = result;
				System.out.println("Id Rol: " + idRol);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("100%");

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				
				busqueda();	

			}
		});
		listSolucionConstruir.addItem("Casa Nueva","1");
		listSolucionConstruir.addItem("Mejoramiento","2");
		listSolucionConstruir.addItem("Adiciones Menores","3");
		listSolucionConstruir.addItem("TODOS");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 170, 31);
		listSolucionConstruir.setSize("227px", "34px");
		
		// Imagen de Lupa de Busqueda
		
		Image image = new Image("images/ico-lupa.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				busqueda();	
				
			}
		});

		absolutePanel.add(image, 400, 10);
		image.setSize("103px", "55px");
		
		Label lblBusquedaPor = new Label("Segun Solucion a Construir:");
		lblBusquedaPor.setStyleName("label");
		absolutePanel.add(lblBusquedaPor, 170, 10);
		lblBusquedaPor.setSize("227px", "13px");
		
		scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		grid.setWidget(1, 0, scrollPanel);
		scrollPanel.setSize("1400px", "100%");
		
		absolutePanel_1 = new AbsolutePanel();
		scrollPanel.setWidget(absolutePanel_1);
		absolutePanel_1.setSize("4500px", "100%");
		
		Label lblEstadoEmpleado = new Label("Parametro Busqueda");
		lblEstadoEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoEmpleado, 10, 29);
		lblEstadoEmpleado.setSize("154px", "13px");
	
		// Boton para Exportar Data
		
		button = new Button("Send");
		
		if(this.valor) {
			button.setVisible(true);
		}else{
			button.setVisible(false);
		}
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(opcion){
					
					char tipo = '3';
					if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
						tipo = '2';
					else
						tipo = '3';
					
					System.out.println("/ExportConsultaSoluciones?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.setAction("/ExportConsultaSoluciones?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.submit();	
				
				}else{
					
					char tipo = '5';
					if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
						tipo = '4';
					else
						tipo = '5';
					
					System.out.println("/ExportConsultaSoluciones?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.setAction("/ExportConsultaSoluciones?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.submit();	
					
				}
				
			}
		});
		button.setText("Exportar");
		button.setStylePrimaryName("sendButton");
		button.setStyleName("sendButton");
		button.setSize("198px", "41px");
		
		formPanel = new FormPanel();
		formPanel.setAction("/ExportConsultaSoluciones?tipo="+"0"+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		
		verticalPanel = new VerticalPanel();
		formPanel.setWidget(verticalPanel);
		verticalPanel.setSize("208px", "43px");
        verticalPanel.add(button);
		absolutePanel.add(formPanel, 508, 21);
        formPanel.setSize("209px", "44px");
		
	}
	
	public void busqueda(){

		load.visible();

		char tipo = 0;

		if(this.opcion){
			tipo = '3';

			if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
				tipo = '2';
			else
				tipo = '3';			
		}else{
			tipo = '5';

			if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
				tipo = '4';
			else
				tipo = '5';	
		}

		solucionesService.buscarFormulario(tipo, idEmpleado, idAfiliado, "", listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()), new AsyncCallback<List<AuxSolicitudGeneral>>(){

			public void onFailure(Throwable caught) 
			{
				load.invisible();
				Window.alert("No hay resultados "+caught);
			}

			@Override
			public void onSuccess( List<AuxSolicitudGeneral> result)
			{
				DATOS = new ArrayList<Sce_ReporteDatosSolucionesConstruidas>();
				int i = 1;

				for (AuxSolicitudGeneral p : result) {

					Sce_ReporteDatosSolucionesConstruidas solucionData = new Sce_ReporteDatosSolucionesConstruidas();

					// DATA A MOSTRAR EN RESULTADO
					
					// 1. Numero Correlativo.
					solucionData.setNumero(""+i);
					
					// 2. Nombre Solicitante
					solucionData.setNombreSolicitante(p.getNombreSolicitante());
					
					// 3. Estado Civil
					String valEstadoCivil = "";
					valEstadoCivil = p.getEstadoCivil();
					String estadoCivil = "";
					if(valEstadoCivil.equals("1")){
						estadoCivil = "Soltero (a)";
					}else if(valEstadoCivil.equals("2")){
						estadoCivil = "Casado (a)";
					}else if(valEstadoCivil.equals("3")){
						estadoCivil = "Unido (a)";
					}else if(valEstadoCivil.equals("4")){
						estadoCivil = "Separado (a)";
					}else if(valEstadoCivil.equals("5")){
						estadoCivil = "Divorciado (a)";
					}else if(valEstadoCivil.equals("6")){
						estadoCivil = "Viudo (a)";
					}
					solucionData.setEstadoCivil(estadoCivil);
					
					// 4. Edad
					solucionData.setEdad(""+p.getEdad());

					// 5. Solucion a construir
					String valSolucion = "";
					valSolucion = p.getSolucionConstruir();
					String solucion = "";
					if(valSolucion.equals("1")){
						solucion = "CASA NUEVA";
					}else if(valSolucion.equals("2")){
						solucion = "MEJORAMIENTO";
					}else if(valSolucion.equals("3")){
						solucion = "ADICIONES MENORES";
					}
					solucionData.setSolucionConstruir(solucion);

					// 6. Usuario responsable
					solucionData.setUsrName(p.getUsrName());
					
					// 7. Telefono Casa
					solucionData.setTelefonoCasaSolicitante(""+p.getTelefonoCasaSolicitante());

					// 8. Telefono Trabajo
					solucionData.setTelefonoTrabajoSolicitante(""+p.getTelefonoTrabajoSolicitante());
					
					// 9. Inmueble accesible en camion
					String valCamion = "";
					Boolean camion = false;
					camion = p.getCheckCamion();
					if(camion){
						valCamion = "SI";
					}else{
						valCamion = "NO";
					}
					solucionData.setCamion(valCamion);
					
					// 10. Inmueble accesible en carro
					String valCarro = "";
					Boolean carro = false;
					carro = p.getCheckCarro();
					if(carro){
						valCarro = "SI";
					}else{
						valCarro = "NO";
					}
					solucionData.setCarro(valCarro);
					
					// 11. Inmueble accesible para peatones
					String valPeatonal = "";
					Boolean peatonal = false;
					peatonal = p.getCheckPeatonal();
					if(peatonal){
						valPeatonal = "SI";
					}else{
						valPeatonal = "NO";
					}
					solucionData.setPeatonal(valPeatonal);					
					
					// 12. Contiene Garantia
					String valGarantia = "";
					Boolean garantia = false;
					garantia = p.getGarantia();
					if(garantia){
						valGarantia = "SI";
					}else{
						valGarantia = "NO";
					}
					solucionData.setGarantia(valGarantia);
					
					// 13. Primera Supervision
					String valSupervision1 = "";
					Boolean supervision1 = false;
					supervision1 = p.getPrimeraSupervision();
					if(supervision1){
						valSupervision1 = "SI";
					}else{
						valSupervision1 = "NO";
					}
					solucionData.setSupervisionPrimera(valSupervision1);
					
					// 14. Segunda Supervision
					String valSupervision2 = "";
					Boolean supervision2 = false;
					supervision2 = p.getSegundaSupervision();
					if(supervision2){
						valSupervision2 = "SI";
					}else{
						valSupervision2 = "NO";
					}
					solucionData.setSupervisionSegunda(valSupervision2);
					
					// 15. Tercera Supervision
					String valSupervision3 = "";
					Boolean supervision3 = false;
					supervision3 = p.getTerceraSupervision();
					if(supervision3){
						valSupervision3 = "SI";
					}else{
						valSupervision3 = "NO";
					}
					solucionData.setSupervisionTercera(valSupervision3);
					
					// 16. Cuarta Supervision
					String valSupervision4 = "";
					Boolean supervision4 = false;
					supervision4 = p.getCuartaSupervision();
					if(supervision4){
						valSupervision4 = "SI";
					}else{
						valSupervision4 = "NO";
					}
					solucionData.setSupervisionCuarta(valSupervision4);
							
					DATOS.add(solucionData);
					i++;
				}

				Sce_ReporteSolucionesConstruidas nuevo = new Sce_ReporteSolucionesConstruidas(DATOS);
				nuevo.ConstruirConsultaSoluciones("1");
				nuevo.ConstruirConsultaSoluciones("2");
				nuevo.ConstruirConsultaSoluciones("3");
				nuevo.ConstruirConsultaSoluciones("4");
				nuevo.ConstruirConsultaSoluciones("5");
				nuevo.ConstruirConsultaSoluciones("6");
				nuevo.ConstruirConsultaSoluciones("7");
				nuevo.ConstruirConsultaSoluciones("8");
				nuevo.ConstruirConsultaSoluciones("9");
				nuevo.ConstruirConsultaSoluciones("10");
				nuevo.ConstruirConsultaSoluciones("11");
				nuevo.ConstruirConsultaSoluciones("12");
				nuevo.ConstruirConsultaSoluciones("13");
				nuevo.ConstruirConsultaSoluciones("14");
				nuevo.ConstruirConsultaSoluciones("15");
				nuevo.ConstruirConsultaSoluciones("16");

				absolutePanel_1.clear();
				absolutePanel_1.add(nuevo);
			}

		});

		load.invisible();

	}

}
