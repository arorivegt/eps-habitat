package org.habitatguate.hgerp.seguridad.client.principal;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Parametro_Inv;
import org.habitatguate.hgerp.seguridad.client.rrhh.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.EmpleadosMinisterioTrabajo;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
 
public class UIStacksEjemplo extends ResizeComposite {
	 private Panel nuevo;
	 private static UiStackEjemploUiBinder uiBinder = GWT.create(UiStackEjemploUiBinder.class);
	 private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	 @UiField Label label_1;

   public UIStacksEjemplo(Panel nuevo) {
     initWidget(uiBinder.createAndBindUi(this));
     this.nuevo = nuevo;
   }

   
   interface UiStackEjemploUiBinder extends UiBinder<Widget, UIStacksEjemplo> {
   }
 	@UiHandler("label_1")
 	void onLabel_1Click(ClickEvent event) {
 		BuscadorEmpleados buscador = new BuscadorEmpleados();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(buscador, 0, 0);
 	}
 	@UiHandler("label_2")
 	void onLabel_2Click(ClickEvent event) {
 		EmpleadosMinisterioTrabajo buscador = new EmpleadosMinisterioTrabajo();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(buscador, 0, 0);
 	
 	}
 	@UiHandler("label_3")
 	void onLabel_3Click(ClickEvent event) {

 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_4")
 	void onLabel_4Click(ClickEvent event) {

 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_1_Finan")
 	void onLabel_1_FinanClick(ClickEvent event) {
 		Buscador_Parametro_Inv buscador = new Buscador_Parametro_Inv();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(buscador, 0, 0);
 	}
 	@UiHandler("label_2_Finan")
 	void onLabel_2_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_3_Finan")
 	void onLabel_3_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_4_Finan")
 	void onLabel_4_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
	@UiHandler("label_5")
	void onLabel_5Click(ClickEvent event) {
		Empleado_registrado();
	}
	@UiHandler("label_6")
	void onLabel_6Click(ClickEvent event) {
		BDpuestos e = new BDpuestos();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(e, 0, 0);
		
	}
	public void Empleado_registrado(){

		final Empleados e = new Empleados(1);
		e.NuevasPestanasdos();
		e.inavilidarDatosYPestanas();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(e, 0, 0);
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

