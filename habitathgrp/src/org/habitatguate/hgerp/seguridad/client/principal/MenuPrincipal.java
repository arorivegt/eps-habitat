package org.habitatguate.hgerp.seguridad.client.principal;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.administracion.AsignarRol;
import org.habitatguate.hgerp.seguridad.client.administracion.BuscadorRoles;
import org.habitatguate.hgerp.seguridad.client.administracion.CambiarContrasenaUsuario;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Afiliado;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Solucion;
import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Soluciones_Inv;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_GestorVales;
import org.habitatguate.hgerp.seguridad.client.finanzas.Formulario_MaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.finanzas.Menu_Proveedores;
import org.habitatguate.hgerp.seguridad.client.rrhh.AsignarDiasVacaciones;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.CalculoVacaciones;
import org.habitatguate.hgerp.seguridad.client.rrhh.CambiarContrasena;
import org.habitatguate.hgerp.seguridad.client.rrhh.Compartidas;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearInformeBancos;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearPrestacionesLaborales;
import org.habitatguate.hgerp.seguridad.client.rrhh.CrearReporteEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleado;
import org.habitatguate.hgerp.seguridad.client.rrhh.EmpleadosMinisterioTrabajo;
import org.habitatguate.hgerp.seguridad.client.rrhh.SolicitudPermiso;
import org.habitatguate.hgerp.seguridad.client.rrhh.TestForm;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_BuzonBuroCredito;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_DataFormularioSolicitud;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_NuevoFormulario;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_BuzonSupervision;
import org.habitatguate.hgerp.seguridad.client.soluciones.Sce_BuzonGarantia;
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

	private Panel panel;
	private boolean bandera = true;
	private Mensaje mensaje; 
	private Long rol = 0L;
	private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);

	public MenuPrincipal(Panel panel) {
		this.panel = panel;
		mensaje = new Mensaje();

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
		final Command Carga = new Command() {
			public void execute() {
				Carga1();
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
		final Command cmdrrhh10 = new Command() {
			public void execute() {
				rrhh10();
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

		final Command cmdempleado4 = new Command() {
			public void execute() {
				empleado4();
			}
		};
		

		final Command MenuContrasena = new Command() {
			public void execute() {
				Contrasena();
			}
		};

		final Command cmdAsignar = new Command() {
			public void execute() {
				Asignar();
			}
		};
		
		
		final Command cmdrol1 = new Command() {
			public void execute() {
				rol1();
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

		// -- Soluciones Construidas6
//		Command cmdsce1_v1 = new Command() {
//			public void execute() {
//				sce1_v1();
//			}
//		};
		final Command cmdsce1 = new Command() {
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
		Command cmdsce6 = new Command() {
			public void execute() {
				sce6();
			}
		};	
		Command cmdsceBuroCredito = new Command() {
			public void execute() {
				sceBuroCredito();
			}
		};		
		Command cmdsceConsultaGeneral = new Command() {
			public void execute() {
				sceConsultaGeneral();
			}
		};
		// --- Fin

		//informes Menu
		final MenuBar MenuInforme = new MenuBar(true);
		MenuInforme.setAutoOpen(true);
		MenuInforme.setAnimationEnabled(true);
		MenuInforme.addItem("Informe de Prestaciones y Salarios", cmdrrhh3);
		MenuInforme.addSeparator();
		MenuInforme.addItem("Informe del Ministerio de Trabajo", cmdrrhh4);
		MenuInforme.addSeparator();
		MenuInforme.addItem("Informe de Empleados", cmdrrhh5);
		MenuInforme.addSeparator();
		MenuInforme.addItem("Informe Bancos", cmdrrhh7);

		final MenuBar MenuVacaciones = new MenuBar(true);
		MenuVacaciones.setAutoOpen(true);
		MenuVacaciones.setAnimationEnabled(true);
		MenuVacaciones.addSeparator();
		MenuVacaciones.addItem("Validar Solicitud de Permisos", cmdrrhh8);
		MenuVacaciones.addSeparator();
		MenuVacaciones.addItem("Calculo Vacaciones", cmdrrhh10);
		MenuVacaciones.addSeparator();
		MenuVacaciones.addItem("Aumentar Dias", cmdrrhh9);
		
		//recursos humano menu
		final MenuBar MenuRecursosHumanos = new MenuBar(true);
		MenuRecursosHumanos.setAutoOpen(true);
		MenuRecursosHumanos.setAnimationEnabled(true);
		MenuRecursosHumanos.addItem("Base de Datos de Evaluacion", cmdrrhh6);
		MenuRecursosHumanos.addSeparator();
		MenuRecursosHumanos.addItem("Base de Datos de Puestos", cmdrrhh2);
		MenuRecursosHumanos.addSeparator();
		MenuRecursosHumanos.addItem("Buscar Empleados", cmdrrhh1);
		MenuRecursosHumanos.addSeparator();
		MenuRecursosHumanos.addItem("Permisos", MenuVacaciones);
		MenuRecursosHumanos.addSeparator();
		MenuRecursosHumanos.addItem("Informes", MenuInforme);
		MenuRecursosHumanos.addSeparator();
		MenuRecursosHumanos.addItem("Carga Datos", Carga);

		
		//solicitudes menu
		final MenuBar MenuSolicitudes = new MenuBar(true);
		MenuSolicitudes.setAutoOpen(true);
		MenuSolicitudes.setAnimationEnabled(true);
		MenuSolicitudes.addItem("Solicitudes realizadas", cmdsolicitudes1);
		MenuSolicitudes.addSeparator();
		MenuSolicitudes.addItem("Validar Solicitudes", cmdsolicitudes2);
		
		//empleado menu
		final MenuBar MenuEmpleados = new MenuBar(true);
		MenuEmpleados.setAutoOpen(true);
		MenuEmpleados.setAnimationEnabled(true);
		MenuEmpleados.addItem("Mi Perfil", cmdempleado1);
		MenuEmpleados.addSeparator();
		MenuEmpleados.addItem("Permisos", MenuSolicitudes);
		MenuEmpleados.addSeparator();
		MenuEmpleados.addItem("Cambiar Contraseña", cmdempleado4);
		MenuEmpleados.addSeparator();
		MenuEmpleados.addItem("Evaluaciones Compartidas", cmdempleado3);
		MenuEmpleados.addSeparator();
		MenuEmpleados.addItem("CERRAR SESION",cmdCerrarSesion); 
		

		//administracion menu
		final MenuBar MenuAdmistracion = new MenuBar(true);
		MenuAdmistracion.setAutoOpen(true);
		MenuAdmistracion.setAnimationEnabled(true);
		MenuAdmistracion.addItem("Asignar Rol a Usuario", cmdAsignar);
		MenuAdmistracion.addSeparator();
		MenuAdmistracion.addItem("Cambiar Contraseña Usuario", MenuContrasena);
		MenuAdmistracion.addSeparator();
		MenuAdmistracion.addItem("Administrar Roles", cmdrol1);
		MenuAdmistracion.addSeparator();

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
		
//		AdministracionService.ObtenerUsuarioPermisoNombre("Recepcion-Formulario-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
//		{
//			public void onFailure(Throwable caught) 
//			{
//			}
//
//			@Override
//			public void onSuccess(List<AuxUsuarioPermiso> results)
//			{
//				if(!results.isEmpty())
//				{	
//					if(!results.get(0).getPermiso().equals("N")){
						MenuSolucionesConstruidas.addItem("Recepcion Formulario de Solicitud", cmdsce1);
						MenuSolucionesConstruidas.addSeparator();
//					}
//				}
//			}
//		});
		
		MenuSolucionesConstruidas.addItem("Verificacion Informacion Solicitudes Ingresadas", cmdsce2);
		MenuSolucionesConstruidas.addSeparator();
		MenuSolucionesConstruidas.addItem("Aprobacion Buro de Credito", cmdsceBuroCredito);
		MenuSolucionesConstruidas.addSeparator();
		MenuSolucionesConstruidas.addItem("Garantia de Solicitudes Ingresadas", cmdsce3);
		MenuSolucionesConstruidas.addSeparator();
		MenuSolucionesConstruidas.addItem("Bitacora de Supervision Solicitudes Ingresadas", cmdsce4);
		MenuSolucionesConstruidas.addSeparator();										
		MenuSolucionesConstruidas.addItem("Detalle Solicitudes Ingresadas", cmdsce6);	
		MenuSolucionesConstruidas.addSeparator();										
		MenuSolucionesConstruidas.addItem("Consulta General Solicitudes", cmdsceConsultaGeneral);		
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
							//ESTE MENU VIENE POR DEFECTO
							MenuVertical.setHeight("100%");
							rol = results;
							//VERIFICO SI TIENE PERMISO PARA MOSTRAR EL MENU DE RRHH
							AdministracionService.ObtenerUsuarioPermisoNombre("RRRH-Menu",results,new AsyncCallback<List<AuxUsuarioPermiso>>()
					    	{
					    		public void onFailure(Throwable caught) 
					    		{
					    			bandera = false;
					    		}

								@Override
								public void onSuccess(List<AuxUsuarioPermiso> results)
								{
									if(!results.isEmpty())
									{	
										if(!results.get(0).getPermiso().equals("N")){
											MenuVertical.addItem("Recursos Humanos", MenuRecursosHumanos);
											MenuVertical.addSeparator();
										}
									}
								}
							});

							//VERIFICO SI TIENE PERMISO PARA MOSTRAR EL MENU DE Finanzas
							AdministracionService.ObtenerUsuarioPermisoNombre("Finanzas-Menu",results,new AsyncCallback<List<AuxUsuarioPermiso>>()
					    	{
					    		public void onFailure(Throwable caught) 
					    		{
					    			bandera = false;
					    		}

								@Override
								public void onSuccess(List<AuxUsuarioPermiso> results)
								{
									if(!results.isEmpty())
									{	
										if(!results.get(0).getPermiso().equals("N")){
											MenuVertical.addItem("Finanzas", MenuFinanzas);
											MenuVertical.addSeparator();
										}
									}
								}
							});
							

							//VERIFICO SI TIENE PERMISO PARA MOSTRAR EL MENU DE Soluciones
							AdministracionService.ObtenerUsuarioPermisoNombre("Soluciones-Menu",results,new AsyncCallback<List<AuxUsuarioPermiso>>()
					    	{
					    		public void onFailure(Throwable caught) 
					    		{
					    			bandera = false;
					    		}

								@Override
								public void onSuccess(List<AuxUsuarioPermiso> results)
								{
									if(!results.isEmpty())
									{	
										if(!results.get(0).getPermiso().equals("N")){
											MenuVertical.addItem("Soluciones Construidas",MenuSolucionesConstruidas); 
											MenuVertical.addSeparator();
										}
									}
								}
							});
							

							//VERIFICO SI TIENE PERMISO PARA MOSTRAR EL MENU DE Administracion
							AdministracionService.ObtenerUsuarioPermisoNombre("Administracion-Menu",results,new AsyncCallback<List<AuxUsuarioPermiso>>()
					    	{
					    		public void onFailure(Throwable caught) 
					    		{
					    			bandera = false;
					    		}

								@Override
								public void onSuccess(List<AuxUsuarioPermiso> results)
								{
									if(!results.isEmpty())
									{	
										if(!results.get(0).getPermiso().equals("N")){
											MenuVertical.addItem("Administracion",MenuAdmistracion); 
											MenuVertical.addSeparator();
										}
									}
								}
							});
							
							
							if(!bandera){
				    			mensaje.setMensaje("alert alert-error", "Error al construir Menu Rol");				
							}else{
								//PARTE DEL MENU POR DEFECTP
								//agregar item para el menu
								MenuVertical.addItem("Empleado",MenuEmpleados); 
//								MenuVertical.addSeparator();
//								MenuVertical.addItem("Administracion",MenuAdmistracion); 
//								MenuVertical.addSeparator();
//								MenuVertical.addItem("Cerrar Sesion",cmdCerrarSesion); 
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
		AdministracionService.ObtenerUsuarioPermisoNombre("Buscar-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}
	
			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					BuscadorEmpleados buscadorEmpleados = new BuscadorEmpleados();
					buscadorEmpleados.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, buscadorEmpleados);
				}
			}
		});
	}

	void rrhh2() {
		AdministracionService.ObtenerUsuarioPermisoNombre("BDPuesto-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					BDpuestos bdPuestos = new BDpuestos();
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, bdPuestos);
					
				}
			}
		});
		

	}

	//@UiHandler("rrhh3")
	void rrhh3() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Informe-Prestaciones-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					CrearPrestacionesLaborales crearPrestacionesLaborales = new CrearPrestacionesLaborales();
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, crearPrestacionesLaborales);
				}
			}
		});
	}

	//@UiHandler("rrhh4")
	void rrhh4() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Informe-Miniserio-Trabajo-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					EmpleadosMinisterioTrabajo empleadosMinisterioTrabajo = new EmpleadosMinisterioTrabajo();
					panel.getGrid().setHeight("100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, empleadosMinisterioTrabajo);
				}
			}
		});
	}

	//@UiHandler("rrhh5")
	void rrhh5() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Informe-Empleado-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					CrearReporteEmpleados crearReporteEmpleados = new CrearReporteEmpleados();
					panel.getGrid().setHeight("100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, crearReporteEmpleados);
				}
			}
		});
		
	}
	//      @UiHandler("rrhh6")
	void rrhh6() {
		AdministracionService.ObtenerUsuarioPermisoNombre("BDEvaluacion-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					TestForm testForm = new TestForm();
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, testForm);
				}
			}
		});
		
	}

	void Carga1(){
		AdministracionService.ObtenerUsuarioPermisoNombre("Carga-Datos-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					SubirDatos subirDatos = new SubirDatos();
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, subirDatos);
				}
			}
		});
		
	}
	//      @UiHandler("rrhh7")
	void rrhh7() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Informe-Bancos-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					CrearInformeBancos crearInformes = new CrearInformeBancos();
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, crearInformes);
				}
			}
		});
		

	}
	
	void rrhh8() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Permisos-Validar-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					SolicitudPermiso solicitudPermiso = new SolicitudPermiso(panel.getId_empleado());
					solicitudPermiso.agregarFormularios();
					panel.getGrid().setWidth("1000");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, solicitudPermiso);
				}
			}
		});
	}
	
	void rrhh9() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Aumentar-Vacaciones-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
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
			}
		});

	}
	
	void rrhh10() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Calculo-Vacaciones-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					CalculoVacaciones calculoVacaciones = new CalculoVacaciones();
					panel.getGrid().setWidth("1000");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, calculoVacaciones);
				}
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
		AdministracionService.ObtenerUsuarioPermisoNombre("Evaluaciones-Compartidas-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(!results.get(0).getPermiso().equals("N")){
					final Compartidas comp = new Compartidas();
					comp.id_EmpleadoPrincipal = panel.getId_empleado();
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, comp);
					loginService.getEvaluacionesCompartidas(panel.getId_empleado(),new AsyncCallback<List<AuxTestCompartidos>>(){

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
			}
		});
		
	}


	void empleado4() {
		final DialogBox Registro2 = new DialogBox();
	    final HTML serverResponseLabel = new HTML();
	    final Button close= new Button("x");
	    CambiarContrasena inicio = new CambiarContrasena();
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
	
	void Contrasena(){

		final DialogBox Registro2 = new DialogBox();
	    final HTML serverResponseLabel = new HTML();
	    final Button close= new Button("x");
	    CambiarContrasenaUsuario inicio = new CambiarContrasenaUsuario();
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
	
	void Asignar(){
		final DialogBox Registro2 = new DialogBox();
	    final HTML serverResponseLabel = new HTML();
	    final Button close= new Button("x");
	    AsignarRol inicio = new AsignarRol();
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
	
	void rol1(){
		BuscadorRoles fmc = new BuscadorRoles();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);
		
	}
	
	
	void solicitudes1(){	
		SolicitudPermiso fmc = new SolicitudPermiso(panel.getId_empleado());
		fmc.agregarFormulario_Empleado();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);
	}
	
	void solicitudes2(){
		SolicitudPermiso fmc = new SolicitudPermiso(panel.getId_empleado());
		fmc.agregarFormulario_Jefe();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);
	}
	
	//@UiHandler("finan2a")
	void fina2a(){
		Buscador_Soluciones_Inv fmc = new Buscador_Soluciones_Inv();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);
	}

	void fina3b(){
		Buscador_Solucion fmc = new Buscador_Solucion();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);
	}
	
	//@UiHandler("finan3b")
	void fina6b(){
		Formulario_MaterialCostruccion fmc = new Formulario_MaterialCostruccion();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);
	}

	//@UiHandler("finan4")
	void fina4a(){
		Buscador_Afiliado fmc = new Buscador_Afiliado();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);

	}       
	//@UiHandler("finan5")
	void fina5(){
		Menu_Proveedores fmc = new Menu_Proveedores();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fmc);

	}

	void fina3a(){
		Formulario_GestorVales fgv = new Formulario_GestorVales();
		this.panel.getGrid().setWidth("1000");
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, fgv);
	}
	
	public void Empleado_registrado(){

		final Empleado e = new Empleado(1,"E",rol);
		e.NuevasPestanasdos(rol);
		this.panel.getGrid().clearCell(1, 0);
		this.panel.getGrid().setWidget(1, 0, e);
		e.setSize("100%", "1000px");

		loginService.Empleado_Registrado(this.panel.getId_empleado(),new AsyncCallback<AuxEmpleado>(){

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
	
	// --- Soluciones Construidas

	//@UiHandler("sce1")
	void sce1() {
		AdministracionService.ObtenerUsuarioPermisoNombre("Recepcion-Formulario-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{

			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
								
					if(results.get(0).getPermiso().equals("RW")){
						
						Sce_NuevoFormulario nuevo = new Sce_NuevoFormulario(true);
						System.out.println("Datos Generales Solicitante - Lectura/Escritura");
						
						nuevo.setSize("100%", "100%");
						panel.getGrid().setSize("100%", "100%");
						panel.getGrid().clearCell(1, 0);
						panel.getGrid().setWidget(1, 0, nuevo);
						

					}else if(results.get(0).getPermiso().equals("R")){
						
						Sce_NuevoFormulario nuevo = new Sce_NuevoFormulario(false);
						System.out.println("Datos Generales Solicitante - Solo Lectura");
						
						nuevo.setSize("100%", "100%");
						panel.getGrid().setSize("100%", "100%");
						panel.getGrid().clearCell(1, 0);
						panel.getGrid().setWidget(1, 0, nuevo);
						
					}else if(results.get(0).getPermiso().equals("N")){
						
						mensaje.setMensaje("alert alert-error", "No tiene privilegios para acceder a esta opción del Menú.");	
						
					}

			}
		});
	}
	
	//@UiHandler("sce2")
	void sce2() {	
		AdministracionService.ObtenerUsuarioPermisoNombre("Verificacion-Solicitud-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{

			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{

				if(results.get(0).getPermiso().equals("RW")){

					Sce_BuzonSolicitud buzon = new Sce_BuzonSolicitud(true);
					System.out.println("Verificacion Solicitud - Lectura/Escritura");

					buzon.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, buzon);

				}else if(results.get(0).getPermiso().equals("R")){

					Sce_BuzonSolicitud buzon = new Sce_BuzonSolicitud(false);
					System.out.println("Verificacion Solicitud - Solo Lectura");

					buzon.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, buzon);

				}else if(results.get(0).getPermiso().equals("N")){
					
					mensaje.setMensaje("alert alert-error", "No tiene privilegios para acceder a esta opción del Menú.");	
					
				}


			}
		});
	}
	
	//@UiHandler("sce3")
	void sce3() {

		AdministracionService.ObtenerUsuarioPermisoNombre("Seguimiento-Garantia-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{

			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				
				if(results.get(0).getPermiso().equals("RW")){

					Sce_BuzonGarantia seguimientoFormulario = new Sce_BuzonGarantia(true);
					System.out.println("Seguimiento Garantia - Lectura/Escritura");
					
					seguimientoFormulario.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, seguimientoFormulario);

				}else if(results.get(0).getPermiso().equals("R")){

					Sce_BuzonGarantia seguimientoFormulario = new Sce_BuzonGarantia(false);
					System.out.println("Seguimiento Garantia - Solo Lectura");
					
					seguimientoFormulario.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, seguimientoFormulario);

				}else if(results.get(0).getPermiso().equals("N")){
					
					mensaje.setMensaje("alert alert-error", "No tiene privilegios para acceder a esta opción del Menú.");	
					
				}
				

			}
		});

	}	
	
	//@UiHandler("sce4")
	void sce4() {
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Bitacora-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{

			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{

				if(results.get(0).getPermiso().equals("RW")){

					Sce_BuzonSupervision bitacora = new Sce_BuzonSupervision(true);
					System.out.println("Bitacora Soluciones - Lectura/Escritura");
					
					bitacora.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, bitacora);

				}else if(results.get(0).getPermiso().equals("R")){
					
					Sce_BuzonSupervision bitacora = new Sce_BuzonSupervision(false);
					System.out.println("Bitacora Soluciones - Solo Lectura");
					
					bitacora.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, bitacora);
					
				}else if(results.get(0).getPermiso().equals("N")){
					
					mensaje.setMensaje("alert alert-error", "No tiene privilegios para acceder a esta opción del Menú.");	
					
				}

			}
		});
		
	}		

	//@UiHandler("sc6")
	void sce6() {
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Detalle-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{

			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{

				if(results.get(0).getPermiso().equals("RW")){

					Sce_SolucionesConstruidasHabitat buscador = new Sce_SolucionesConstruidasHabitat(true, true);
					System.out.println("Detalle Soluciones - Lectura/Escritura");
					
					panel.getGrid().setHeight("100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, buscador);

				}else if(results.get(0).getPermiso().equals("R")){
				
					Sce_SolucionesConstruidasHabitat buscador = new Sce_SolucionesConstruidasHabitat(false, true);
					System.out.println("Detalle Soluciones - Solo Lectura");
					
					panel.getGrid().setHeight("100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, buscador);
					
				}else if(results.get(0).getPermiso().equals("N")){
					
					mensaje.setMensaje("alert alert-error", "No tiene privilegios para acceder a esta opción del Menú.");	
					
				}

			}
		});
			
	}

	//@UiHandler("sceBuroCredito")
	void sceBuroCredito() {
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Buro-Credito-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{

			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{

				if(results.get(0).getPermiso().equals("RW")){

					Sce_BuzonBuroCredito seguimientoFormulario = new Sce_BuzonBuroCredito(true);
					System.out.println("Buro Credito - Lectura/Escritura");
					
					seguimientoFormulario.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, seguimientoFormulario);

				}else if(results.get(0).getPermiso().equals("R")){
				
					Sce_BuzonBuroCredito seguimientoFormulario = new Sce_BuzonBuroCredito(false);
					System.out.println("Buro Credito - Lectura/Escritura");
					
					seguimientoFormulario.setSize("100%", "100%");
					panel.getGrid().setSize("100%", "100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, seguimientoFormulario);
					
				}else if(results.get(0).getPermiso().equals("N")){
					
					mensaje.setMensaje("alert alert-error", "No tiene privilegios para acceder a esta opción del Menú.");	
					
				}

			}
		});
			
	}
	
	//@UiHandler("sceConsultaGeneral")
	void sceConsultaGeneral() {
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Consulta-General-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{

			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{

				if(results.get(0).getPermiso().equals("RW")){

					Sce_SolucionesConstruidasHabitat buscador = new Sce_SolucionesConstruidasHabitat(true, false);
					System.out.println("Detalle Soluciones - Lectura/Escritura");
					
					panel.getGrid().setHeight("100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, buscador);

				}else if(results.get(0).getPermiso().equals("R")){
				
					Sce_SolucionesConstruidasHabitat buscador = new Sce_SolucionesConstruidasHabitat(false, false);
					System.out.println("Detalle Soluciones - Solo Lectura");
					
					panel.getGrid().setHeight("100%");
					panel.getGrid().clearCell(1, 0);
					panel.getGrid().setWidget(1, 0, buscador);
					
				}else if(results.get(0).getPermiso().equals("N")){
					
					mensaje.setMensaje("alert alert-error", "No tiene privilegios para acceder a esta opción del Menú.");	
					
				}

			}
		});
			
	}
	
	// --- Fin   
	
}
