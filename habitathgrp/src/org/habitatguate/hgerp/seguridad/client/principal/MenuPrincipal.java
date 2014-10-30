package org.habitatguate.hgerp.seguridad.client.principal;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Afiliado;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Soluciones_Inv;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_MaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.finanzas.Menu_Proveedores;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Compartidas;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.EmpleadosMinisterioTrabajo;
import org.habitatguate.hgerp.seguridad.client.rrhh.ReporteEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.TestForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;

public class MenuPrincipal extends Composite {
	
    private AbsolutePanel absolutePanel; 
    private Panel nuevo;
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
	public MenuPrincipal(Panel nuevo) {
		this.nuevo = nuevo;
		absolutePanel = new AbsolutePanel();
		//absolutePanel.setStyleName("gwt-Label-new");
	
		Command cmd = new Command() {
	       public void execute() {
	    	   System.out.println();
	       }
	     };
	     Command cmdrrhh1 = new Command() {
	       public void execute() {
	    	   rrhh1();
	       }
	     };
	     Command cmdrrhh2 = new Command() {
	       public void execute() {
	    	   rrhh2();
	       }
	     };
//	     Command cmdrrhh3 = new Command() {
//	       public void execute() {
//	    	   //rrhh1();
//	       }
//	     };
	     Command cmdrrhh4 = new Command() {
	       public void execute() {
	    	   rrhh4();
	       }
	     };
	     Command cmdrrhh5 = new Command() {
	       public void execute() {
	    	   rrhh5();
	       }
	     };
	     Command cmdrrhh6 = new Command() {
	       public void execute() {
	    	   rrhh6();
	       }
	     };
	     

	     Command cmdempleado1 = new Command() {
	       public void execute() {
	    	   empleado1();
	       }
	     };
	     Command cmdempleado3 = new Command() {
	       public void execute() {
	    	   empleado3();
	       }
	     };
	     

	     Command cmdfina2a = new Command() {
	       public void execute() {
	    	   fina2a();
	       }
	     };
	     Command cmdfinan3b = new Command() {
	       public void execute() {
	    	   finan3b();
	       }
	     };

	     Command cmdfina4a = new Command() {
	       public void execute() {
	    	   fina4a();
	       }
	     };
	     Command cmdfina5 = new Command() {
	       public void execute() {
	    	   fina5();
	       }
	     };
	     //recursos humano menu
	    MenuBar MenuRecursosHumanos = new MenuBar(true);
	    MenuRecursosHumanos.setAnimationEnabled(true);
	    MenuRecursosHumanos.addItem("Buscar Empleados", cmdrrhh1);
	    MenuRecursosHumanos.addSeparator();
	    MenuRecursosHumanos.addItem("Base de Datos de Puestos", cmdrrhh2);
	    MenuRecursosHumanos.addSeparator();
	    MenuRecursosHumanos.addItem("Crear Formulario de Evaluacion", cmdrrhh6);
	    MenuRecursosHumanos.addSeparator();
	    MenuRecursosHumanos.addItem("Informe del Ministerio de Trabajo", cmdrrhh4);
	    MenuRecursosHumanos.addSeparator();
	    MenuRecursosHumanos.addItem("Informe de Empleados", cmdrrhh5);
	    MenuRecursosHumanos.addSeparator();
	    
	     //finanzas menu
	    MenuBar MenuEmpleados = new MenuBar(true);
	    MenuEmpleados.setAnimationEnabled(true);
	    MenuEmpleados.addItem("Mi Perfil", cmdempleado1);
	    MenuEmpleados.addSeparator();
	    MenuEmpleados.addItem("Evaluaciones Compartidas", cmdempleado3);

	     //Inventario Activos menu
	    MenuBar MenuInventarioActivos = new MenuBar(true);
	    MenuInventarioActivos.setAnimationEnabled(true);
	    MenuInventarioActivos.addItem("Cuentas y Parametros", cmd);
	    MenuInventarioActivos.addSeparator();
	    MenuInventarioActivos.addItem("Gestor de Inventario", cmd);
	    MenuInventarioActivos.addSeparator();
	    MenuInventarioActivos.addItem("Generar Conocimiento", cmd);
	    
	     //soluciones menu
	    MenuBar MenuSoluciones = new MenuBar(true);
	    MenuSoluciones.setAnimationEnabled(true);
	    MenuSoluciones.addItem("Ingreso Beneficiario", cmdfina2a);
	    MenuSoluciones.addSeparator();
	    MenuSoluciones.addItem("Ingreso de Solucion", cmdfina5);
	    

	     //soluciones menu
	    MenuBar MenuInventarioMateriales = new MenuBar(true);
	    MenuInventarioMateriales.setAnimationEnabled(true);
	    MenuInventarioMateriales.addItem("Cuenta Materiales", cmd);
	    MenuInventarioMateriales.addSeparator();
	    MenuInventarioMateriales.addItem("Administrar Materiales Costrucción", cmdfinan3b);
	    
	     //recursos humano menu
	    MenuBar MenuFinanzas = new MenuBar(true);
	    MenuFinanzas.setAnimationEnabled(true);
	    MenuFinanzas.addItem("Inventario Activos Fijos", MenuInventarioActivos);
	    MenuFinanzas.addSeparator();
	    MenuFinanzas.addItem("Soluciones", MenuSoluciones);
	    MenuFinanzas.addSeparator();
	    MenuFinanzas.addItem("Inventario Materiales", MenuInventarioMateriales);
	    MenuFinanzas.addSeparator();
	    MenuFinanzas.addItem("Administrador Afiliado", cmdfina4a);
	    MenuFinanzas.addSeparator();
	    MenuFinanzas.addItem("Administrador Proveedores", cmdempleado3);
	    
	    
	    //agregar item para el menu
	    MenuBar MenuVertical = new MenuBar();
	    MenuVertical.addItem("Recursos Humanos", MenuRecursosHumanos);
	    MenuVertical.addSeparator();
	    MenuVertical.addItem("Finanzas", MenuFinanzas);
	    MenuVertical.addSeparator();
	    MenuVertical.addItem("Empleado",MenuEmpleados); 
	    MenuVertical.addSeparator();
	    
	    MenuVertical.setAutoOpen(true);
	    MenuVertical.setWidth("500px");
	    MenuVertical.setAnimationEnabled(true);
		    
		    
	   absolutePanel.add(MenuVertical);
	   initWidget(absolutePanel);
	}
	
	void rrhh1() {
 		BuscadorEmpleados buscador = new BuscadorEmpleados();
 		buscador.setSize("100%", "100%");
 		this.nuevo.getGrid().setSize("100%", "100%");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
 	}

	void rrhh2() {
		BDpuestos puestos = new BDpuestos();
		this.nuevo.getGrid().setWidth("1000");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, puestos);
		
	}
	
	//	@UiHandler("rrhh3")
//	void rrhh3() {
//		Window.alert("No disponible en este momento");
//	}

	//@UiHandler("rrhh4")
	void rrhh4() {
 		EmpleadosMinisterioTrabajo buscador = new EmpleadosMinisterioTrabajo();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	
	//@UiHandler("rrhh5")
	void rrhh5() {
 		ReporteEmpleados buscador = new ReporteEmpleados();
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
//	@UiHandler("rrhh6")
	void rrhh6() {

		TestForm buscador = new TestForm();
		this.nuevo.getGrid().setWidth("1000");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	//@UiHandler("empleado1")
	void empleado1() {
		Empleado_registrado();
	}
	
//	@UiHandler("empleado3")
	void empleado3() {
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
	//@UiHandler("finan2a")
	void fina2a(){
		Buscador_Soluciones_Inv fmc = new Buscador_Soluciones_Inv();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
 	
 	}
	
	//@UiHandler("finan3b")
	void finan3b(){
		Formulario_MaterialCostruccion fmc = new Formulario_MaterialCostruccion();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
 	
 	}
	
	//@UiHandler("finan4")
	void fina4a(){
		Buscador_Afiliado fmc = new Buscador_Afiliado();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
 	
 	}	
	//@UiHandler("finan5")
	void fina5(){
		Menu_Proveedores fmc = new Menu_Proveedores();
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
        e.setSize("100%", "1000px");

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
