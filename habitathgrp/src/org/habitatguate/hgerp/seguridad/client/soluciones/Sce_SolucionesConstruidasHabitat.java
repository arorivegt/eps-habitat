package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class Sce_SolucionesConstruidasHabitat extends Composite  {

    private  Grid grid;
    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
    private ScrollPanel scrollPanel;
    private AbsolutePanel absolutePanel_1;
    private  ListBox listEstado ;
    private Loading load ;
    private List<Sce_DatosSolucionesConstruidas> DATOS;
  	
	public Sce_SolucionesConstruidasHabitat() {
		
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
		
		listEstado = new ListBox();
		listEstado.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				busqueda();
			}
		});
		listEstado.addItem("Tipo I","1");
		listEstado.addItem("Tipo II","2");
		listEstado.addItem("Tipo III","3");
		listEstado.addItem("Tipo IV","4");
		listEstado.addItem("Tipo V","5");
		listEstado.addItem("Tipo VI","6");
		listEstado.addItem("Tipo VII","7");
		listEstado.addItem("Tipo VIII","8");
		listEstado.addItem("Tipo IX","9");
		listEstado.addItem("TODOS");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 170, 31);
		listEstado.setSize("227px", "34px");
		
			Image image = new Image("images/ico-lupa.png");
			image.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					busqueda();
				}
			});
			
					absolutePanel.add(image, 604, 10);
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
	
	}
	
	public void busqueda(){

		load.visible();
		char tipo = '3';

		if(listEstado.getItemText(listEstado.getSelectedIndex()).equals("TODOS"))
			tipo = '2';
		else
			tipo = '3';

		solucionesService.buscarFormulario(tipo,"",listEstado.getValue(listEstado.getSelectedIndex()), new AsyncCallback<List<AuxSolicitudGeneral>>(){

			public void onFailure(Throwable caught) 
			{
				load.invisible();
				Window.alert("No hay resultados "+caught);
			}

			@Override
			public void onSuccess( List<AuxSolicitudGeneral> result)
			{
				DATOS = new ArrayList<Sce_DatosSolucionesConstruidas>();
				int i = 0;

				for (AuxSolicitudGeneral p : result) {

					Sce_DatosSolucionesConstruidas empleado = new Sce_DatosSolucionesConstruidas();

					// DATA A MOSTRAR EN RESULTADO
					
					empleado.setIdFormulario(""+p.getIdFormulario());
					
					empleado.setNombreSolicitante(p.getNombreSolicitante());
					
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
					empleado.setEstadoCivil(estadoCivil);
					
					empleado.setEdad(""+p.getEdad());

					String valLeer = "";
					Boolean leer = false;
					if(!p.getCheckLeer().equals(null)){
						leer = p.getCheckLeer();
					}
					if(leer){
						valLeer = "SI";
					}else{
						valLeer = "NO";
					}
					empleado.setSabeLeer(valLeer);

//					String valEscribir = "";
//					Boolean escribir = false;
//					if(!p.getCheckEscribir().equals(null)){
//						escribir = p.getCheckEscribir();	
//					}
//					if(escribir){
//						valEscribir = "SI";
//					}else{
//						valEscribir = "NO";
//					}
					empleado.setSabeEscribir(valLeer);

					String valFirmar = "";
					Boolean firmar = false;
					if(!p.getCheckFirmar().equals(null)){
						firmar = p.getCheckFirmar();	
					}
					if(firmar){
						valFirmar = "SI";
					}else{
						valFirmar = "NO";
					}
					empleado.setSabeFirmar(valFirmar);

					empleado.setTelefonoCasaSolicitante(""+p.getTelefonoCasaSolicitante());
					empleado.setTelefonoTrabajoSolicitante(""+p.getTelefonoTrabajoSolicitante());
					empleado.setCuotaPagar(""+p.getCuotaPagar());
					
					String valCamion = "";
					Boolean camion = false;
					camion = p.getCheckCamion();
					if(camion){
						valCamion = "SI";
					}else{
						valCamion = "NO";
					}
					empleado.setCamion(valCamion);
					
					String valCarro = "";
					Boolean carro = false;
					carro = p.getCheckCarro();
					if(carro){
						valCarro = "SI";
					}else{
						valCarro = "NO";
					}
					empleado.setCarro(valCarro);
					
					String valPeatonal = "";
					Boolean peatonal = false;
					peatonal = p.getCheckPeatonal();
					if(peatonal){
						valPeatonal = "SI";
					}else{
						valPeatonal = "NO";
					}
					empleado.setPeatonal(valPeatonal);
					

					String valSolucion = "";
					valSolucion = p.getSolucionConstruir();
					String solucion = "";
					if(valSolucion.equals("1")){
						solucion = "TIPO I";
					}else if(valSolucion.equals("2")){
						solucion = "TIPO II";
					}else if(valSolucion.equals("3")){
						solucion = "TIPO III";
					}else if(valSolucion.equals("4")){
						solucion = "TIPO IV";
					}else if(valSolucion.equals("5")){
						solucion = "TIPO V";
					}else if(valSolucion.equals("6")){
						solucion = "TIPO VI";
					}
					else if(valSolucion.equals("7")){
						solucion = "TIPO VII";
					}
					else if(valSolucion.equals("8")){
						solucion = "TIPO VIII";
					}
					else if(valSolucion.equals("9")){
						solucion = "TIPO IX";
					}
					empleado.setSolucionConstruir(solucion);
					
					String valGarantia = "";
					Boolean garantia = false;
					garantia = p.getGarantia();
					if(garantia){
						valGarantia = "SI";
					}else{
						valGarantia = "NO";
					}
					empleado.setGarantia(valGarantia);
					
					String valSupervision1 = "";
					Boolean supervision1 = false;
					supervision1 = p.getPrimeraSupervision();
					if(supervision1){
						valSupervision1 = "SI";
					}else{
						valSupervision1 = "NO";
					}
					empleado.setSupervisionPrimera(valSupervision1);
					
					String valSupervision2 = "";
					Boolean supervision2 = false;
					supervision2 = p.getSegundaSupervision();
					if(supervision2){
						valSupervision2 = "SI";
					}else{
						valSupervision2 = "NO";
					}
					empleado.setSupervisionSegunda(valSupervision2);
					
					String valSupervision3 = "";
					Boolean supervision3 = false;
					supervision3 = p.getTerceraSupervision();
					if(supervision3){
						valSupervision3 = "SI";
					}else{
						valSupervision3 = "NO";
					}
					empleado.setSupervisionTercera(valSupervision3);
					
					String valSupervision4 = "";
					Boolean supervision4 = false;
					supervision4 = p.getCuartaSupervision();
					if(supervision4){
						valSupervision4 = "SI";
					}else{
						valSupervision4 = "NO";
					}
					empleado.setSupervisionCuarta(valSupervision4);
					
					
					
					
					DATOS.add(empleado);
					i++;
				}

				Sce_ReporteSolucionesConstruidas nuevo = new Sce_ReporteSolucionesConstruidas(DATOS);
				nuevo.AgregarColumna("1");
				nuevo.AgregarColumna("2");
				nuevo.AgregarColumna("3");
				nuevo.AgregarColumna("4");
				nuevo.AgregarColumna("5");
				nuevo.AgregarColumna("6");
				nuevo.AgregarColumna("7");
				nuevo.AgregarColumna("8");
				nuevo.AgregarColumna("9");
				nuevo.AgregarColumna("10");
				nuevo.AgregarColumna("11");
				nuevo.AgregarColumna("12");
				nuevo.AgregarColumna("13");
				nuevo.AgregarColumna("14");
				nuevo.AgregarColumna("15");
				nuevo.AgregarColumna("16");
				nuevo.AgregarColumna("17");

				absolutePanel_1.clear();
				absolutePanel_1.add(nuevo);
			}

		});

		load.invisible();

	}
	
}
