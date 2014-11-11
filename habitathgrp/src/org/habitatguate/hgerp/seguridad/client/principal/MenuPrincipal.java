package org.habitatguate.hgerp.seguridad.client.principal;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Afiliado;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Soluciones_Inv;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_GestorVales;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_MaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.finanzas.Menu_Proveedores;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Compartidas;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearInformeBancos;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearPrestacionesLaborales;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.EmpleadosMinisterioTrabajo;
import org.habitatguate.hgerp.seguridad.client.rrhh.ReporteEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.TestForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;

public class MenuPrincipal extends Composite {
	
    private Panel nuevo;
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
	public MenuPrincipal(Panel nuevo) {
		this.nuevo = nuevo;
	
		 final Command cmd = new Command() {
	       public void execute() {
	    	   System.out.println();
	       }
	     };
	     final  Command cmdrrhh1 = new Command() {
	       public void execute() {
	    	   rrhh1();
	       }
	     };
	     final Command cmdrrhh2 = new Command() {
	       public void execute() {
	    	   rrhh2();
	       }
	     };
	     final Command cmdrrhh3 = new Command() {
	       public void execute() {
	    	   rrhh3();
	       }
	     };
	     final Command cmdrrhh4 = new Command() {
	       public void execute() {
	    	   rrhh4();
	       }
	     };
	     final  Command cmdrrhh5 = new Command() {
	       public void execute() {
	    	   rrhh5();
	       }
	     };
	     final Command cmdrrhh6 = new Command() {
	       public void execute() {
	    	   rrhh6();
	       }
	     };
	     final Command cmdrrhh7 = new Command() {
	       public void execute() {
	    	   rrhh7();
	       }
	     };
	     

	     final Command cmdempleado1 = new Command() {
	       public void execute() {
	    	   empleado1();
	       }
	     };
	     final Command cmdCerrarSesion = new Command() {
		       public void execute() {
		    	   cerrarSesion();
		       }
		     };
		     
		     final Command cmdempleado3 = new Command() {
	       public void execute() {
	    	   empleado3();
	       }
	     };
	     

	     final  Command cmdfina2a = new Command() {
	       public void execute() {
	    	   fina2a();
	       }
	     };
	     final  Command cmdfina3a = new Command() {
		       public void execute() {
		    	   fina3a();
		       }
		     };
	     
	     final Command cmdfinan3b = new Command() {
	       public void execute() {
	    	   finan3b();
	       }
	     };

	     final Command cmdfina4a = new Command() {
	       public void execute() {
	    	   fina4a();
	       }
	     };
	     final Command cmdfina5 = new Command() {
	       public void execute() {
	    	   fina5();
	       }
	     };
	     	//informes Menu
	 	    final MenuBar MenuInforme = new MenuBar(true);
	 	    MenuInforme.setAutoOpen(true);
	 	    MenuInforme.setAnimationEnabled(true);
	 	    MenuInforme.addItem("Informe del Ministerio de Trabajo", cmdrrhh4);
	 	    MenuInforme.addSeparator();
	 	    MenuInforme.addItem("Informe Bancos", cmdrrhh7);
	 	    MenuInforme.addSeparator();
	 	    MenuInforme.addItem("Informe de Empleados", cmdrrhh5);
	 	    MenuInforme.addSeparator();
	 	    MenuInforme.addItem("Informe de Salarios", cmdrrhh3);
	 	    
	 	     //recursos humano menu
	 	   final MenuBar MenuRecursosHumanos = new MenuBar(true);
	 	    MenuRecursosHumanos.setAutoOpen(true);
	 	    MenuRecursosHumanos.setAnimationEnabled(true);
	 	    MenuRecursosHumanos.addItem("Buscar Empleados", cmdrrhh1);
	 	    MenuRecursosHumanos.addSeparator();
	 	    MenuRecursosHumanos.addItem("Base de Datos de Puestos", cmdrrhh2);
	 	    MenuRecursosHumanos.addSeparator();
	 	    MenuRecursosHumanos.addItem("Base de Datos de Evaluacion", cmdrrhh6);
	 	    MenuRecursosHumanos.addSeparator();
	 	    MenuRecursosHumanos.addItem("Informes", MenuInforme);
	 	    
	 	    
	 	    
	 	     //finanzas menu
	 	   final MenuBar MenuEmpleados = new MenuBar(true);
	 	    MenuEmpleados.setAutoOpen(true);
	 	    MenuEmpleados.setAnimationEnabled(true);
	 	    MenuEmpleados.addItem("Mi Perfil", cmdempleado1);
	 	    MenuEmpleados.addSeparator();
	 	    MenuEmpleados.addItem("Evaluaciones Compartidas", cmdempleado3);

	 	     //Inventario Activos menu
	 	   final MenuBar MenuInventarioActivos = new MenuBar(true);
	 	    MenuInventarioActivos.setAutoOpen(true);
	 	    MenuInventarioActivos.setAnimationEnabled(true);
	 	    MenuInventarioActivos.addItem("Cuentas y Parametros", cmd);
	 	    MenuInventarioActivos.addSeparator();
	 	    MenuInventarioActivos.addItem("Gestor de Inventario", cmd);
	 	    MenuInventarioActivos.addSeparator();
	 	    MenuInventarioActivos.addItem("Generar Conocimiento", cmd);
	 	    
	 	     //soluciones menu
	 	   final MenuBar MenuSoluciones = new MenuBar(true);
	 	    MenuSoluciones.setAutoOpen(true);
	 	    MenuSoluciones.setAnimationEnabled(true);
	 	    MenuSoluciones.addItem("Ingreso Beneficiario", cmdfina2a);
	 	    MenuSoluciones.addSeparator();
	 	    MenuSoluciones.addItem("Gestor de Vales", cmdfina3a);
	 	    

	 	     //soluciones menu
	 	   final MenuBar MenuInventarioMateriales = new MenuBar(true);
	 	    MenuInventarioMateriales.setAutoOpen(true);
	 	    MenuInventarioMateriales.setAnimationEnabled(true);
	 	    MenuInventarioMateriales.addItem("Cuenta Materiales", cmd);
	 	    MenuInventarioMateriales.addSeparator();
	 	    MenuInventarioMateriales.addItem("Administrar Materiales Costrucción", cmdfinan3b);
	 	    
	 	     //recursos humano menu
	 	   final MenuBar MenuFinanzas = new MenuBar(true);
	 	   	MenuFinanzas.setAutoOpen(true);
	 	    MenuFinanzas.setAnimationEnabled(true);
	 	    MenuFinanzas.addItem("Inventario Activos Fijos", MenuInventarioActivos);
	 	    MenuFinanzas.addSeparator();
	 	    MenuFinanzas.addItem("Soluciones", MenuSoluciones);
	 	    MenuFinanzas.addSeparator();
	 	    MenuFinanzas.addItem("Inventario Materiales", MenuInventarioMateriales);
	 	    MenuFinanzas.addSeparator();
	 	    MenuFinanzas.addItem("Administrador Afiliado", cmdfina4a);
	 	    MenuFinanzas.addSeparator();
	 	    MenuFinanzas.addItem("Administrador Proveedores", cmdfina5);
	 	    

          final  MenuBar MenuVertical = new MenuBar();
	     loginService.CheqLog(new AsyncCallback<Boolean>() 
	             {
	         		
	                     public void onFailure(Throwable caught) 
	                     {
	                     }
	                     
	                     public void onSuccess(Boolean result)
	                     {
	                     	if(result){
	                     		loginService.obtenerIdRol(new AsyncCallback<Long>() 
	             	            {
	             	                    public void onFailure(Throwable caught) 
	             	                    {
	             	                    }
	             	                    
	             	                    public void onSuccess(Long results)
	             	                    {
	            	                     	System.out.println("menu resultado : "+results);
	             	                    	//si el rol es 1, entonces es empledo
	             	                    	if(results == 1L){

		             	                   	    MenuVertical.setHeight("100%");
	             	                    		//agregar item para el menu
		             	                   	    MenuVertical.addItem("Empleado",MenuEmpleados); 
		             	                   	    MenuVertical.addSeparator();
		             	                   	    MenuVertical.addItem("Cerrar Sesion",cmdCerrarSesion); 
		             	                   	    MenuVertical.setAutoOpen(true);
		             	                   	    MenuVertical.setAnimationEnabled(true);
	             	                   		    
	             	                    	}else if(results == 2L){//si el rol es 2, entonces es RRHH
		             	                   	    MenuVertical.addItem("Recursos Humanos", MenuRecursosHumanos);
		             	                   	    MenuVertical.addSeparator();
		             	                   	    MenuVertical.addItem("Empleado",MenuEmpleados); 
		             	                   	    MenuVertical.addSeparator();
		             	                   	    MenuVertical.addItem("Cerrar Sesion",cmdCerrarSesion); 
		             	                   	    MenuVertical.setAutoOpen(true);
		             	                   	    MenuVertical.setAnimationEnabled(true);
		             	                   	    
	             	                    	}else if(results == 3L){//si el rol es 3, entonces es finanzas
		             	                   	    //agregar item para el menu
		             	                   	    MenuVertical.setHeight("100%");
		             	                   	    MenuVertical.addItem("Finanzas", MenuFinanzas);
		             	                   	    MenuVertical.addSeparator();
		             	                   	    MenuVertical.addItem("Empleado",MenuEmpleados); 
		             	                   	    MenuVertical.addSeparator();
		             	                   	    MenuVertical.addItem("Cerrar Sesion",cmdCerrarSesion); 
		             	                   	    MenuVertical.setAutoOpen(true);
		             	                   	    MenuVertical.setAnimationEnabled(true);
	             	                    	}
	             	                                                            
	             	                    }
	             	             });
	                     		
	                     	}
	                                                             
	                     }
	              });

  	   
 	    
	 
		    
	   initWidget(MenuVertical);
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
 		this.nuevo.getGrid().setSize("100%", "100%");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, puestos);
		
	}
	
	//@UiHandler("rrhh3")
	void rrhh3() {
		CrearPrestacionesLaborales nuevo = new CrearPrestacionesLaborales();
 		this.nuevo.getGrid().setSize("100%", "100%");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, nuevo);
	}

	//@UiHandler("rrhh4")
	void rrhh4() {
 		EmpleadosMinisterioTrabajo buscador = new EmpleadosMinisterioTrabajo();
 		this.nuevo.getGrid().setHeight("100%");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	
	//@UiHandler("rrhh5")
	void rrhh5() {
 		ReporteEmpleados buscador = new ReporteEmpleados();
 		this.nuevo.getGrid().setSize("100%", "100%");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
//	@UiHandler("rrhh6")
	void rrhh6() {

		TestForm buscador = new TestForm();
 		this.nuevo.getGrid().setSize("100%", "100%");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	

//	@UiHandler("rrhh7")
	void rrhh7() {
		CrearInformeBancos nuevo = new CrearInformeBancos();
 		this.nuevo.getGrid().setSize("100%", "100%");
 		this.nuevo.getGrid().clearCell(1, 0);
 		this.nuevo.getGrid().setWidget(1, 0, nuevo);

	}
	//@UiHandler("empleado1")
	void empleado1() {
		Empleado_registrado();
	}
	
	void cerrarSesion() {
		 loginService.logout(new AsyncCallback<Boolean>(){
	        	
	        	public void onFailure(Throwable caught) 
	        	{
	        		Window.alert("No se pudo cerrar sesion "+caught);
	        	}

	        	@Override
	        	public void onSuccess(Boolean result)
	        	{ 
	        		if(result){
	        			Window.Location.reload();
	        		}
	        	}
	        });
	}
	
	
//	@UiHandler("empleado3")
	void empleado3() {
		final Compartidas comp = new Compartidas();
		comp.id_EmpleadoPrincipal = this.nuevo.getId_empleado();
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
	
	void fina3a(){
		Formulario_GestorVales fgv = new Formulario_GestorVales();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fgv);
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
