/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Administracion
 */
package org.habitatguate.hgerp.seguridad.client.administracion;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class BuscadorRoles extends Composite   {

    private Grid grid;
    private Loading load ;
    private Image Busqueda;
	private Mensaje mensaje; 
    private ListBox listRol;
    private AbsolutePanel absolutePanel;
    private boolean bandera = true;
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
   // private Button btnEliminar;
    public Formulario formulario;
    private Button btnCrear;
    private Button btnGuardar;
    private ListBox listFormulario;
    private Label lblElijaTipoDe;
    
    /**
     * constructor
     */
	public BuscadorRoles() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		grid.setSize("876px", "100%");
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		
		listRol = new ListBox();

		
    	AdministracionService.ObtenerUltimoROl(new AsyncCallback<Long>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-success", "Error al obtener rol\n"+caught);
    		}

			@Override
			public void onSuccess(Long result)
			{
				for(int i = 1; i <= result; i++){
					listRol.addItem(""+i);
				}
			}
		});
		listRol.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
		        load.visible();
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				Long formu  = Long.parseLong(listFormulario.getValue(listFormulario.getSelectedIndex()));
				busqueda(rol,formu);
		        load.invisible();
			}
		});
		
		listRol.setStyleName("gwt-TextBox2");
		absolutePanel.add(listRol, 10, 16);
		listRol.setSize("67px", "39px");
		
		//quitar esto de eliminar, un rol no se va eliminar, sino modificar
//		btnEliminar = new Button("Send");
//		btnEliminar.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
//				eliminarRol(rol);
//			}
//		});
//		btnEliminar.setText("Eliminar");
//		btnEliminar.setStylePrimaryName("gwt-TextBox2");
//		btnEliminar.setStyleName("sendButton");
//		absolutePanel.add(btnEliminar, 93, 16);
//		btnEliminar.setSize("117px", "34px");
		
		btnCrear = new Button("Send");
		btnCrear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//se obtiene el ultimo rol, y se suma 1, para crear otro Rol

		        load.visible();
				int UltimoRol = 1;
				Long rol = 1L;
				if(listRol.getItemCount() > 0){
					UltimoRol = listRol.getItemCount();
					rol = UltimoRol + 1L;
				}
				//son los modulos que se quieren mostrar
				GuardarPagina(rol, "RRRH-Menu", 0L, "N");
				GuardarPagina(rol, "Finanzas-Menu", 0L, "N");
				GuardarPagina(rol, "Soluciones-Menu", 0L, "N");
				GuardarPagina(rol, "Administracion-Menu", 0L, "N");
				
				//estos son los formularios que contiene el modulo de Empleado, para crearlos
				GuardarPagina(rol, "Datos-Empleado", 1L, "R");
				GuardarPagina(rol, "Familia-Empleado", 1L, "R");
				GuardarPagina(rol, "Academico-Empleado", 1L, "R");
				GuardarPagina(rol, "RefLaboral-Empleado", 1L, "R");
				GuardarPagina(rol, "RefPersonal-Empleado", 1L, "R");
				GuardarPagina(rol, "Idiomas-Empleado", 1L, "R");
				GuardarPagina(rol, "Entrevistas-Empleado", 1L, "R");
				GuardarPagina(rol, "Permisos-Empleado", 1L, "R");
				GuardarPagina(rol, "Permisos-Solicitudes-Empleado", 1L, "R");
				GuardarPagina(rol, "Permisos-Validar-Empleado", 1L, "R");
				GuardarPagina(rol, "Cambiar-Contrasena-Empleado", 1L, "R");
				GuardarPagina(rol, "Evaluaciones-Compartidas-Empleado", 1L, "R");
				
				//estos son los formularios que contiene el modulo de RRHH
				GuardarPagina(rol, "Buscar-RRHH", 2L, "N");
				GuardarPagina(rol, "BDEvaluacion-RRHH", 2L, "N");
				GuardarPagina(rol, "BDPuesto-RRHH", 2L, "N");
				GuardarPagina(rol, "Aumentar-Vacaciones-RRHH", 2L, "N");
				GuardarPagina(rol, "Permisos-Validar-RRHH", 2L, "N");
				GuardarPagina(rol, "Evaluaciones-Compartidas-RRHH", 2L, "N");
				GuardarPagina(rol, "Calculo-Vacaciones-RRHH", 2L, "N");
				GuardarPagina(rol, "Informe-Prestaciones-RRHH", 2L, "N");
				GuardarPagina(rol, "Informe-Miniserio-Trabajo-RRHH", 2L, "N");
				GuardarPagina(rol, "Informe-Empleado-RRHH", 2L, "N");
				GuardarPagina(rol, "Informe-Bancos-RRHH", 2L, "N");
				GuardarPagina(rol, "Datos-RRHH", 2L, "N");
				GuardarPagina(rol, "Familia-RRHH", 2L, "N");
				GuardarPagina(rol, "Academico-RRHH", 2L, "N");
				GuardarPagina(rol, "RefLaboral-RRHH", 2L, "N");
				GuardarPagina(rol, "RefPersonal-RRHH", 2L, "N");
				GuardarPagina(rol, "Idiomas-RRHH", 2L, "N");
				GuardarPagina(rol, "Desempeno-RRHH", 2L, "N");
				GuardarPagina(rol, "Evaluacion-RRHH", 2L, "N");
				GuardarPagina(rol, "Puestos-RRHH", 2L, "N");
				GuardarPagina(rol, "Salarios-RRHH", 2L, "N");
				GuardarPagina(rol, "Historial-RRHH", 2L, "N");
				GuardarPagina(rol, "Entrevistas-RRHH", 2L, "N");
				GuardarPagina(rol, "Permisos-RRHH", 2L, "N");
				GuardarPagina(rol, "Carga-Datos-RRHH", 2L, "N");
				// Soluciones Construidas
				GuardarPagina(rol, "Recepcion-Formulario-Soluciones", 3L, "R");				// Menu Opcion 1
				GuardarPagina(rol, "Verificacion-Solicitud-Soluciones", 3L, "N");			// Menu Opcion 2
				GuardarPagina(rol, "Seguimiento-Garantia-Soluciones", 3L, "N");				// Menu Opcion 3
				GuardarPagina(rol, "Bitacora-Soluciones", 3L, "N");							// Menu Opcion 4
				GuardarPagina(rol, "Buro-Credito-Soluciones", 3L, "N");						// Menu Opcion 5
				GuardarPagina(rol, "Buzon-Encuesta-Satisfaccion-Soluciones", 3L, "N");		// Menu Opcion 6
				GuardarPagina(rol, "Consulta-Ingreso-Soluciones", 3L, "N");					// Menu Opcion 7
				GuardarPagina(rol, "Consulta-General-Soluciones", 3L, "N");					// Menu Opcion 8
				GuardarPagina(rol, "Consulta-Ingreso-Encuesta-Soluciones", 3L, "N");		// Menu Opcion 9
				GuardarPagina(rol, "Consulta-General-Encuesta-Soluciones", 3L, "N");		// Menu Opcion 10				
				GuardarPagina(rol, "Datos-Solicitante-Soluciones", 3L, "R");				// Formulario 1 Menu Opcion 2
				GuardarPagina(rol, "Cargas-Familiares-Soluciones", 3L, "N");				// Formulario 2 Menu Opcion 2
				GuardarPagina(rol, "Situacion-Vivienda-Soluciones", 3L, "N");				// Formulario 3 Menu Opcion 2
				GuardarPagina(rol, "Situacion-Economica-Soluciones", 3L, "N");				// Formulario 4 Menu Opcion 2
				GuardarPagina(rol, "Referencias-Familiares-Soluciones", 3L, "N");			// Formulario 5 Menu Opcion 2
				GuardarPagina(rol, "Garantia-Hipotecaria-Soluciones", 3L, "R");				// Formulario 1 Menu Opcion 3
				GuardarPagina(rol, "Garantia-Fiduciaria-Soluciones", 3L, "N");				// Formulario 2 Menu Opcion 3
				GuardarPagina(rol, "Grupo-Solidario-Soluciones", 3L, "N");					// Formulario 3 Menu Opcion 3
				GuardarPagina(rol, "Primera-Supervision-Soluciones", 3L, "R");				// Formulario 1 Menu Opcion 4
				GuardarPagina(rol, "Segunda-Supervision-Soluciones", 3L, "N");				// Formulario 2 Menu Opcion 4
				GuardarPagina(rol, "Tercera-Supervision-Soluciones", 3L, "N");				// Formulario 3 Menu Opcion 4
				GuardarPagina(rol, "Cuarta-Supervision-Soluciones", 3L, "N");				// Formulario 4 Menu Opcion 4
				GuardarPagina(rol, "Ubicacion-Solucion-Soluciones", 3L, "N");				// Formulario 5 Menu Opcion 4
				GuardarPagina(rol, "Encuesta-Satisfaccion-Soluciones", 3L, "R");			// Formulario 6 Menu Opcion 4
				GuardarPagina(rol, "Situacion-Economica-Credito-Soluciones", 3L, "R");		// Formulario 1 Menu Opcion 5
				//
				
				listRol.addItem(""+rol);

				if(!bandera){
	    			mensaje.setMensaje("alert alert-error", "Error al Crear Rol");				
				}else{
	    			mensaje.setMensaje("alert alert-success", "Rol creado exitosamente");
				}

		        load.invisible();
			}
		});
		
		listFormulario = new ListBox();
		listFormulario.addItem("Menu","0");
		listFormulario.addItem("RRHH","2");
		listFormulario.addItem("Empleado","1");
		// Soluciones Construidas
		listFormulario.addItem("Soluciones Construidas","3");
		//
		
		listFormulario.setStyleName("gwt-TextBox2");
		absolutePanel.add(listFormulario, 93, 16);
		
		listFormulario.setSize("169px", "39px");
		btnCrear.setText("Crear Rol");
		btnCrear.setStylePrimaryName("gwt-TextBox2");
		btnCrear.setStyleName("sendButton");
		absolutePanel.add(btnCrear, 292, 16);
		btnCrear.setSize("169px", "34px");
		
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				Long formu  = Long.parseLong(listFormulario.getValue(listFormulario.getSelectedIndex()));
				busqueda(rol,formu);
			}
		});
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				if(formulario != null){
					for(int i = 0; i<formulario.formularioROL.size(); i++){
						ActualizarPagina(formulario.formularioROL.get(i).id_permiso,formulario.formularioROL.get(i).roll,
								formulario.formularioROL.get(i).txtNombreFormulario.getText(),formulario.formularioROL.get(i).id_formularioPadre,
								formulario.formularioROL.get(i).listPermiso.getItemText(formulario.formularioROL.get(i).listPermiso.getSelectedIndex()));
					}
					if(!bandera){
		    			mensaje.setMensaje("alert alert-error", "Error al Actualizar Rol");				
					}else{
		    			mensaje.setMensaje("alert alert-success", "Rol Actualizado exitosamente");
					}
				}

		        load.invisible();
			}
		});
		btnGuardar.setText("Guardar Cambios");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 487, 16);
		btnGuardar.setSize("240px", "34px");
		
		absolutePanel.add(Busqueda, 747, 0);
		Busqueda.setSize("103px", "55px");
		
		
		Label lblroles = new Label("Roles");
		lblroles.setStyleName("label");
		lblroles.setSize("67px", "13px");
		absolutePanel.add(lblroles, 10, 0);
		
		lblElijaTipoDe = new Label("Elija tipo de formulario");
		lblElijaTipoDe.setStyleName("label");
		absolutePanel.add(lblElijaTipoDe, 93, -3);
		lblElijaTipoDe.setSize("183px", "13px");
    	
		
		initWidget(grid);
		
	}
	
	public void busqueda(Long rol,Long formularioPadre){
		grid.clearCell(1, 0);
		
    	AdministracionService.ObtenerUsuarioPermisoFormularios(rol,formularioPadre,new AsyncCallback<List<AuxUsuarioPermiso>>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			bandera = false;
    		}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				System.out.println(results.size());
				if (!(results.size()==0)) {
					formulario  = new Formulario();
					formulario.agregarFormulario_lleno(results);
					grid.setWidget(1, 0, formulario);
					bandera = true;
		    	}	
			}
		});
	}	
	
	public void eliminarRol(Long rol){
		
    	AdministracionService.EliminarUsuarioPermiso(rol,new AsyncCallback<Long>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-error", "Error en BD puestos\n"+caught);
    		}

			@Override
			public void onSuccess(Long results)
			{	
    			mensaje.setMensaje("alert alert-success", "Rol Eliminado");
			}
		});
	}
	
	public void GuardarPagina(Long rol, String nombreFormulario, Long formularioPadre, String permiso){
			
	    	AdministracionService.InsertarUsuarioPermiso(rol, nombreFormulario, formularioPadre, permiso,new AsyncCallback<Long>()
	    	{
	    		public void onFailure(Throwable caught) 
	    		{
	    			bandera = false;
	    		}
	
				@Override
				public void onSuccess(Long results)
				{	
					bandera = true;
				}
			});
	}
	

	public void ActualizarPagina(Long id, Long rol, String nombreFormulario, Long formularioPadre, String permiso){
	    	AdministracionService.ActualizarUsuarioPermiso(id,rol, nombreFormulario, formularioPadre, permiso,new AsyncCallback<Long>()
	    	{
	    		public void onFailure(Throwable caught) 
	    		{
	    			bandera = false;
	    		}
	
				@Override
				public void onSuccess(Long results)
				{	
					bandera = true;
				}
			});
	}
}
