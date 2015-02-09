package org.habitatguate.hgerp.seguridad.client.principal;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Afiliado;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Solucion;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Soluciones_Inv;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_GestorVales;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_MaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.finanzas.Menu_Proveedores;
import org.habitatguate.hgerp.seguridad.client.rrhh.AsignarDiasVacaciones;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Compartidas;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearInformeBancos;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearPrestacionesLaborales;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearReporteEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleado;
import org.habitatguate.hgerp.seguridad.client.rrhh.EmpleadosMinisterioTrabajo;
import org.habitatguate.hgerp.seguridad.client.rrhh.SolicitudPermiso;
import org.habitatguate.hgerp.seguridad.client.rrhh.TestForm;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_BusquedaFormulario;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_BuzonBitacora;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_BuzonSeguimientoSolicitud;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_BuzonSolicitud;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_DataEntryFormularioSolicitud;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_SolucionesConstruidasHabitat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuPrincipal extends Composite {

	private Panel nuevo;
	private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);

	public MenuPrincipal(Panel nuevo) {
		this.nuevo = nuevo;

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
		final Command cmdrrhh8 = new Command() {
			public void execute() {
				rrhh8();
			}
		};
		final Command cmdrrhh9 = new Command() {
			public void execute() {
				rrhh9();
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

		final Command cmdsolicitudes1 = new Command() {
			public void execute() {
				solicitudes1();
			}
		};
		
		final Command cmdsolicitudes2 = new Command() {
			public void execute() {
				solicitudes2();
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

		final Command cmdfina3b = new Command() {
			public void execute() {
				fina3b();
			}
		};
		final Command cmdfina6b = new Command() {
			public void execute() {
				fina6b();
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

		// -- Soluciones Construidas
		Command cmdsce1 = new Command() {
			public void execute() {
				sce1();
			}
		};
		Command cmdsce2 = new Command() {
			public void execute() {
				sce2();
			}
		};
		Command cmdsce3 = new Command() {
			public void execute() {
				sce3();
			}
		};	 
		Command cmdsce4 = new Command() {
			public void execute() {
				sce4();
			}
		};		     
//		Command cmdsce5 = new Command() {
//			public void execute() {
//				sce5();
//			}
//		};	 
		Command cmdsce6 = new Command() {
			public void execute() {
				sce6();
			}
		};		     
		// --- Fin

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
		MenuRecursosHumanos.addItem("Validar Solicitud de Permisos", cmdrrhh8);
		MenuRecursosHumanos.addSeparator();
		MenuRecursosHumanos.addItem("Aumentar Dias Vacaciones", cmdrrhh9);
		MenuRecursosHumanos.addSeparator();
		MenuRecursosHumanos.addItem("Informes", MenuInforme);

		//finanzas menu
		final MenuBar MenuSolicitudes = new MenuBar(true);
		MenuSolicitudes.setAutoOpen(true);
		MenuSolicitudes.setAnimationEnabled(true);
		MenuSolicitudes.addItem("Solicitudes realizadas", cmdsolicitudes1);
		MenuSolicitudes.addSeparator();
		MenuSolicitudes.addItem("Validar Solicitud de Permisos", cmdsolicitudes2);
		
		//finanzas menu
		final MenuBar MenuEmpleados = new MenuBar(true);
		MenuEmpleados.setAutoOpen(true);
		MenuEmpleados.setAnimationEnabled(true);
		MenuEmpleados.addItem("Mi Perfil", cmdempleado1);
		MenuEmpleados.addSeparator();
		MenuEmpleados.addItem("Solicitudes", MenuSolicitudes);
		MenuEmpleados.addSeparator();
		MenuEmpleados.addItem("Evaluaciones Compartidas", cmdempleado3);

		//Inventario Activos menu
		/*      final MenuBar MenuInventarioActivos = new MenuBar(true);
            MenuInventarioActivos.setAutoOpen(true);
            MenuInventarioActivos.setAnimationEnabled(true);
            MenuInventarioActivos.addItem("Cuentas y Parametros", cmd);
            MenuInventarioActivos.addSeparator();
            MenuInventarioActivos.addItem("Gestor de Inventario", cmd);
            MenuInventarioActivos.addSeparator();
            MenuInventarioActivos.addItem("Generar Conocimiento", cmd); */

		//soluciones menu
		final MenuBar MenuSoluciones = new MenuBar(true);
		MenuSoluciones.setAnimationEnabled(true);
		/* MenuSoluciones.addItem("Ingreso Beneficiario", cmdfina2a);
         	 	    MenuSoluciones.addSeparator();*/
		MenuSoluciones.addItem("Asignar Solucion", cmdfina3b);
		MenuSoluciones.addItem("Gestor de Vales", cmdfina3a);

		//soluciones menu
		final MenuBar MenuInventarioMateriales = new MenuBar(true);
		MenuInventarioMateriales.setAnimationEnabled(true);
		/*  MenuInventarioMateriales.addItem("Cuenta Materiales", cmd);
         	 	    MenuInventarioMateriales.addSeparator();*/
		MenuInventarioMateriales.addItem("Inventario Materiales de Costrucción", cmdfina6b);

		//recursos humano menu
		final MenuBar MenuFinanzas = new MenuBar(true);
		/*	    MenuFinanzas.setAnimationEnabled(true);
         	 	    MenuFinanzas.addItem("Inventario Activos Fijos", MenuInventarioActivos);*/
		MenuFinanzas.addSeparator();
		MenuFinanzas.addItem("Administrador Afiliado", cmdfina4a);
		MenuFinanzas.addSeparator();
		MenuFinanzas.addItem("Administrador Proveedores", cmdfina5);
		MenuFinanzas.addSeparator();
		MenuFinanzas.addItem("Administrador Materiales", MenuInventarioMateriales);
		MenuFinanzas.addSeparator();
		MenuFinanzas.addItem("Administrador Beneficiario", cmdfina2a);
		MenuFinanzas.addSeparator();
		MenuFinanzas.addItem("Soluciones", MenuSoluciones);


		// --- Soluciones Construidas    
		final MenuBar MenuSolucionesConstruidas = new MenuBar(true);
		MenuSolucionesConstruidas.setAnimationEnabled(true);
		MenuSolucionesConstruidas.addItem("Recepcion Formulario de Solicitud", cmdsce1);
		MenuSolucionesConstruidas.addSeparator();
		MenuSolucionesConstruidas.addItem("Verificacion de Solicitud", cmdsce2);
		MenuSolucionesConstruidas.addSeparator();
		MenuSolucionesConstruidas.addItem("Seguimiento de Garantia de Solicitud", cmdsce3);
		MenuSolucionesConstruidas.addSeparator();
		MenuSolucionesConstruidas.addItem("Bitacora de Soluciones Construidas", cmdsce4);
		MenuSolucionesConstruidas.addSeparator();
//		MenuSolucionesConstruidas.addItem("Busqueda Exacta por Parametro", cmdsce5);	
//		MenuSolucionesConstruidas.addSeparator();
		MenuSolucionesConstruidas.addItem("Detalle Soluciones Construidas", cmdsce6);		
		// --- Fin

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
								MenuVertical.setAutoOpen(false);
								MenuVertical.setAnimationEnabled(true);

							}else if(results == 2L){//si el rol es 2, entonces es RRHH
								MenuVertical.addItem("Recursos Humanos", MenuRecursosHumanos);
								MenuVertical.addSeparator();
								MenuVertical.addItem("Empleado",MenuEmpleados); 
								MenuVertical.addSeparator();
								MenuVertical.addItem("Cerrar Sesion",cmdCerrarSesion); 
								MenuVertical.setAutoOpen(false);
								MenuVertical.setAnimationEnabled(true);

							}else if(results == 3L){//si el rol es 3, entonces es finanzas
								//agregar item para el menu
								MenuVertical.setHeight("100%");
								MenuVertical.addItem("Finanzas", MenuFinanzas);
								MenuVertical.addSeparator();
								MenuVertical.addItem("Empleado",MenuEmpleados); 
								MenuVertical.addSeparator();
								MenuVertical.addItem("Cerrar Sesion",cmdCerrarSesion); 
								MenuVertical.setAutoOpen(false);
								MenuVertical.setAnimationEnabled(true);
							}else if(results == 4L){//si el rol es 4, entonces es soluciones construidas
								//agregar item para el menu
								MenuVertical.setHeight("100%");
								MenuVertical.addItem("Soluciones Construidas",MenuSolucionesConstruidas); 
								MenuVertical.addSeparator();
								MenuVertical.addItem("Empleado",MenuEmpleados); 
								MenuVertical.addSeparator();
								MenuVertical.addItem("Cerrar Sesion",cmdCerrarSesion); 
								MenuVertical.setAutoOpen(false);
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
		CrearReporteEmpleados buscador = new CrearReporteEmpleados();
		this.nuevo.getGrid().setSize("100%", "100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}
	//      @UiHandler("rrhh6")
	void rrhh6() {

		TestForm buscador = new TestForm();
		this.nuevo.getGrid().setSize("100%", "100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}


	//      @UiHandler("rrhh7")
	void rrhh7() {
		CrearInformeBancos nuevo = new CrearInformeBancos();
		this.nuevo.getGrid().setSize("100%", "100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, nuevo);

	}
	
	void rrhh8() {
		SolicitudPermiso fmc = new SolicitudPermiso(nuevo.getId_empleado());
		fmc.agregarFormularios();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
	}
	void rrhh9() {
		final DialogBox Registro2 = new DialogBox();
	    final HTML serverResponseLabel = new HTML();
	    final Button close= new Button("x");
	    AsignarDiasVacaciones inicio = new AsignarDiasVacaciones();
	    VerticalPanel dialogVPanel = new VerticalPanel();
	    dialogVPanel.add(serverResponseLabel );
	    dialogVPanel.add(inicio);
	    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
	    dialogVPanel.add(close);
	    Registro2 .setWidget(dialogVPanel);
	    Registro2 .setModal(true);
	    Registro2 .setGlassEnabled(true);
	    Registro2 .setAnimationEnabled(true);
	    Registro2 .center();
	    Registro2 .show();
	    close.setFocus(true);
	
	    close.addClickHandler(new ClickHandler() {
	    public void onClick(ClickEvent event) {
	        Registro2.hide();
	    }
	    });
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


	//      @UiHandler("empleado3")
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

	
	void solicitudes1(){
		
		SolicitudPermiso fmc = new SolicitudPermiso(nuevo.getId_empleado());
		fmc.agregarFormulario_Empleado();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);

	}
	void solicitudes2(){
		SolicitudPermiso fmc = new SolicitudPermiso(nuevo.getId_empleado());
		fmc.agregarFormulario_Jefe();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);
	}
	
	//@UiHandler("finan2a")
	void fina2a(){
		Buscador_Soluciones_Inv fmc = new Buscador_Soluciones_Inv();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);

	}

	void fina3b(){
		Buscador_Solucion fmc = new Buscador_Solucion();
		this.nuevo.getGrid().setWidth("1000");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, fmc);

	}
	//@UiHandler("finan3b")
	void fina6b(){
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

	// --- Soluciones Construidas

	//@UiHandler("sce1")
	void sce1() {
		Sce_DataEntryFormularioSolicitud recepcionFormulario = new Sce_DataEntryFormularioSolicitud();
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, recepcionFormulario);
	}
	//@UiHandler("sce2")
	void sce2() {
		Sce_BuzonSolicitud buzon = new Sce_BuzonSolicitud();
		buzon.setSize("100%", "100%");
		this.nuevo.getGrid().setSize("100%", "100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, buzon);
	}	
	//@UiHandler("sce3")
	void sce3() {
		Sce_BuzonSeguimientoSolicitud seguimientoFormulario = new Sce_BuzonSeguimientoSolicitud();
		seguimientoFormulario.setSize("100%", "100%");
		this.nuevo.getGrid().setSize("100%", "100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, seguimientoFormulario);
	}	
	//@UiHandler("sce4")
	void sce4() {
		Sce_BuzonBitacora bitacora = new Sce_BuzonBitacora();
		bitacora.setSize("100%", "100%");
		this.nuevo.getGrid().setSize("100%", "100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, bitacora);
	}		
	//@UiHandler("sce4")
	void sce5() {
		Sce_BusquedaFormulario busqueda = new Sce_BusquedaFormulario();
		busqueda.setSize("100%", "100%");
		this.nuevo.getGrid().setSize("100%", "100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, busqueda);
	}	

	//@UiHandler("rrhh4")
	void sce6() {
		Sce_SolucionesConstruidasHabitat buscador = new Sce_SolucionesConstruidasHabitat();
		this.nuevo.getGrid().setHeight("100%");
		this.nuevo.getGrid().clearCell(1, 0);
		this.nuevo.getGrid().setWidget(1, 0, buscador);
	}

	// --- Fin        

	public void Empleado_registrado(){

		final Empleado e = new Empleado(1);
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
					e.setFormularioDatos(result);
				}catch(Exception e){

				}
				try{
					e.setAcademico(result.getHistorial_academico());
				}catch(Exception e){

				}
				try{
					e.setFamilia(result.getFamilia());
				}catch(Exception e){

				}
				try{
					e.setHistorial(result.getHistorial());
				}catch(Exception e){

				}
				try{
					e.setIdioma(result.getIdiomas());
				}catch(Exception e){

				}
				try{
					e.setPuesto(result.getPuestos());
				}catch(Exception e){

				}
				try{
					e.setReferenciaLaboral(result.getReferencia_laboral());
				}catch(Exception e){

				}
				try{
					e.setReferenciaPersonal(result.getReferencia_personal());
				}catch(Exception e){

				}
				try{
					e.setPermiso(result.getVacaciones());
				}catch(Exception e){

				}
				try{
					e.setFormularioEntrevista(result.getEntrevista().get(0));
				}catch(Exception e){

				}
				try{
					e.setFormularioTest(result.getTest());
				}catch(Exception e){

				}


			}

		});
	}
}
