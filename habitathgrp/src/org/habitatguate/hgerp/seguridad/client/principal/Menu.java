package org.habitatguate.hgerp.seguridad.client.principal;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Afiliado;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Parametro_Inv;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Solucion;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_MaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
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
	 private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	 
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
	
	@UiHandler("label_1_Finan")
 	void onLabel_1_FinanClick(ClickEvent event) {
 		Buscador_Parametro_Inv buscador = new Buscador_Parametro_Inv();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
 	}
 	@UiHandler("label_2_Finan")
 	void onLabel_2_FinanClick(ClickEvent event) {
 		Buscador_Solucion buscadorSoluciones = new Buscador_Solucion();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscadorSoluciones);
 	}
 	@UiHandler("label_3_Finan")
 	void onLabel_3_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_4_Finan")
 	void onLabel_4_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 		
 	}
 	@UiHandler("label_5_Finan")
 	void onLabel_5_FinanClick(ClickEvent event) {
 		Buscador_Afiliado buscadorAfiliado = new Buscador_Afiliado();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscadorAfiliado);
 	}
 	@UiHandler("label_6_Finan")
 	void onLabel_6_FinanClick(ClickEvent event) {
 		Formulario_MaterialCostruccion formCostruccion = new Formulario_MaterialCostruccion();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, formCostruccion);
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
