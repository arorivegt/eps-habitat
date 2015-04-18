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
				busqueda(rol);
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
				GuardarPagina(rol, "RRRH-Menu", null, "N");
				GuardarPagina(rol, "Finanzas-Menu", null, "N");
				GuardarPagina(rol, "Soluciones-Menu", null, "N");
				GuardarPagina(rol, "Administracion-Menu", null, "N");
				
				//estos son los formularios que contiene el modulo de Empleado, para crearlos
				GuardarPagina(rol, "Datos-Empleado", 0L, "R");
				GuardarPagina(rol, "Familia-Empleado", 0L, "R");
				GuardarPagina(rol, "Academico-Empleado", 0L, "R");
				GuardarPagina(rol, "RefLaboral-Empleado", 0L, "R");
				GuardarPagina(rol, "RefPersonal-Empleado", 0L, "R");
				GuardarPagina(rol, "Idiomas-Empleado", 0L, "R");
				GuardarPagina(rol, "Entrevistas-Empleado", 0L, "R");
				GuardarPagina(rol, "Permisos-Empleado", 0L, "R");
				GuardarPagina(rol, "Permisos-Solicitudes-Empleado", 0L, "R");
				GuardarPagina(rol, "Permisos-Validar-Empleado", 0L, "R");
				GuardarPagina(rol, "Cambiar-Contrasena-Empleado", 0L, "R");
				GuardarPagina(rol, "Evaluaciones-Compartidas-Empleado", 0L, "R");
				
				//estos son los formularios que contiene el modulo de RRHH
				GuardarPagina(rol, "Buscar-RRHH", 0L, "N");
				GuardarPagina(rol, "BDEvaluacion-RRHH", 0L, "N");
				GuardarPagina(rol, "Aumentar-Vacaciones-RRHH", 0L, "N");
				GuardarPagina(rol, "Permisos-Validar-RRHH", 0L, "N");
				GuardarPagina(rol, "Calculo-Vacaciones-RRHH", 0L, "N");
				GuardarPagina(rol, "Calculo-Vacaciones-RRHH", 0L, "N");
				GuardarPagina(rol, "Informe-Prestaciones-RRHH", 0L, "N");
				GuardarPagina(rol, "Informe-Miniserio-Trabajo-RRHH", 0L, "N");
				GuardarPagina(rol, "Informe-Bancos-RRHH", 0L, "N");
				GuardarPagina(rol, "Datos-RRHH", 0L, "N");
				GuardarPagina(rol, "Familia-RRHH", 0L, "N");
				GuardarPagina(rol, "Academico-RRHH", 0L, "N");
				GuardarPagina(rol, "RefLaboral-RRHH", 0L, "N");
				GuardarPagina(rol, "RefPersonal-RRHH", 0L, "N");
				GuardarPagina(rol, "Idiomas-RRHH", 0L, "N");
				GuardarPagina(rol, "Desempeno-RRHH", 0L, "N");
				GuardarPagina(rol, "Evaluacion-RRHH", 0L, "N");
				GuardarPagina(rol, "Puestos-RRHH", 0L, "N");
				GuardarPagina(rol, "Salarios-RRHH", 0L, "N");
				GuardarPagina(rol, "Historial-RRHH", 0L, "N");
				GuardarPagina(rol, "Entrevistas-RRHH", 0L, "N");
				GuardarPagina(rol, "Permisos-RRHH", 0L, "N");
				GuardarPagina(rol, "Carga-Datos-RRHH", 0L, "N");
				listRol.addItem(""+rol);

				if(!bandera){
	    			mensaje.setMensaje("alert alert-error", "Error al Crear Rol");				
				}else{
	    			mensaje.setMensaje("alert alert-success", "Rol creado exitosamente");
				}

		        load.invisible();
			}
		});
		btnCrear.setText("Crear Rol");
		btnCrear.setStylePrimaryName("gwt-TextBox2");
		btnCrear.setStyleName("sendButton");
		absolutePanel.add(btnCrear, 97, 16);
		btnCrear.setSize("169px", "34px");
		
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				busqueda(rol);
			}
		});
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				if(formulario != null){
					for(int i = 0; i<formulario.formularioROL.size(); i++){
						ActualizarPagina(formulario.formularioROL.get(i).id_permiso,formulario.formularioROL.get(i).roll,
								formulario.formularioROL.get(i).txtNombreFormulario.getText(),null,
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
		absolutePanel.add(btnGuardar, 292, 16);
		btnGuardar.setSize("240px", "34px");
		
		absolutePanel.add(Busqueda, 552, 0);
		Busqueda.setSize("103px", "55px");
		
		
		Label lblroles = new Label("roles");
		lblroles.setStyleName("label");
		lblroles.setSize("118px", "13px");
		absolutePanel.add(lblroles, 10, 0);
    	
		
		initWidget(grid);
		
	}
	
	public void busqueda(Long rol){
		grid.clearCell(1, 0);
		
    	AdministracionService.ObtenerUsuarioPermiso(rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
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
