package org.habitatguate.hgerp.seguridad.client.principal;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Afiliado;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Soluciones_Inv;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_MaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Compartidas;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.EmpleadosMinisterioTrabajo;
import org.habitatguate.hgerp.seguridad.client.rrhh.ReporteEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.TestForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Menu extends Composite {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);
	 private Panel nuevo;
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	 
	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}

	public Menu(Panel nuevo) {
	     this.nuevo = nuevo;
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("rrhh1")
 	void rrhh1(ClickEvent event) {
 		BuscadorEmpleados buscador = new BuscadorEmpleados();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
 	}

	@UiHandler("rrhh2")
	void rrhh2(ClickEvent event) {
		BDpuestos puestos = new BDpuestos();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, puestos);
		
	}
 	
	@UiHandler("rrhh3")
	void rrhh3(ClickEvent event) {
		Window.alert("No disponible en este momento");
	}

	@UiHandler("rrhh4")
	void rrhh4(ClickEvent event) {
 		EmpleadosMinisterioTrabajo buscador = new EmpleadosMinisterioTrabajo();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	
	@UiHandler("rrhh5")
	void rrhh5(ClickEvent event) {
 		ReporteEmpleados buscador = new ReporteEmpleados();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	@UiHandler("rrhh6")
	void rrhh6(ClickEvent event) {

		TestForm buscador = new TestForm();
		this.nuevo.getGrid().setWidth("1000");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	@UiHandler("empleado1")
	void empleado1(ClickEvent event) {
		Empleado_registrado();
	}
	
	@UiHandler("empleado3")
	void empleado3(ClickEvent event) {
		final Compartidas comp = new Compartidas();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, comp);
        loginService.getEvaluacionesCompartidas(this.nuevo.getId_empleado(),new AsyncCallback<List<AuxTestCompartidos>>(){
        	
        	public void onFailure(Throwable caught) 
        	{
        		Window.alert("No hay resultados "+caught);
        	}

        	@Override
        	public void onSuccess(List<AuxTestCompartidos> result)
        	{ 
        		if(!result.isEmpty()){
        			comp.agregar_formularios(result);
        		}
        	}
        });
	}
	
	@UiHandler("finan2a")
	void fina2a(ClickEvent event){
		Buscador_Soluciones_Inv fmc = new Buscador_Soluciones_Inv();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
 	
 	}
	
	@UiHandler("finan3b")
	void finan3b(ClickEvent event){
		Formulario_MaterialCostruccion fmc = new Formulario_MaterialCostruccion();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
 	
 	}
	
	@UiHandler("finan4")
	void fina4a(ClickEvent event){
		Buscador_Afiliado fmc = new Buscador_Afiliado();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
 	
 	}
	
	public void Empleado_registrado(){

		final Empleados e = new Empleados(1);
		e.NuevasPestanasdos();
		e.inavilidarDatosYPestanas();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, e);
        e.setSize("1187px", "648px");

        loginService.Empleado_Registrado(this.nuevo.getId_empleado(),new AsyncCallback<AuxEmpleado>(){
        	
        	public void onFailure(Throwable caught) 
        	{
        		Window.alert("No hay resultados "+caught);
        	}

        	@Override
        	public void onSuccess(AuxEmpleado result)
        	{

        		try{
        			e.setFD(result);
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setA(result.getHistorial_academico());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setF(result.getFamilia());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setH(result.getHistorial());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setI(result.getIdiomas());
        		}catch(Exception e){

        		}
        		try{
        			e.setP(result.getPuestos());
        		}catch(Exception e){

        		}
        		try{
        			e.setRL(result.getReferencia_laboral());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setRP(result.getReferencia_personal());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setV(result.getVacaciones());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setFE(result.getEntrevista().get(0));
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setFPP(result.getTest());
        		}catch(Exception e){
        			
        		}
        		
        	}

        });
	}


}
