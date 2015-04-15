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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;

public class BuscadorRoles extends Composite   {

    private Grid grid;
    private Loading load ;
    private Image Busqueda;
	private Mensaje mensaje; 
    private ListBox listRol;
    private AbsolutePanel absolutePanel;
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
    private Button btnEliminar;
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
		listRol.addItem("1");
		listRol.addItem("2");
		listRol.addItem("3");
		listRol.addItem("4");
		listRol.addItem("5");
		listRol.addItem("6");
		listRol.addItem("7");
		listRol.addItem("8");
		listRol.addItem("9");
		listRol.addItem("10");
		listRol.addItem("11");
		listRol.addItem("12");
		listRol.addItem("13");
		listRol.addItem("14");
		listRol.addItem("15");
		listRol.addItem("16");
		listRol.addItem("17");
		listRol.addItem("18");
		listRol.addItem("19");
		listRol.addItem("20");
		listRol.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				busqueda(rol);
			}
		});
		
		listRol.setStyleName("gwt-TextBox2");
		absolutePanel.add(listRol, 10, 16);
		listRol.setSize("67px", "39px");
		//quitar esto de eliminar, un rol no se va eliminar, sino modificar
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				eliminarRol(rol);
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 93, 16);
		btnEliminar.setSize("117px", "34px");
		
		btnCrear = new Button("Send");
		btnCrear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//se obtiene el ultimo rol, y se suma 1, para crear otro Rol
				int UltimoRol = listRol.getItemCount();
				Long rol = UltimoRol + 1L;
				
				//estos son los formularios que contiene el modulo de Empleado, para crearlos
				GuardarPagina(rol, "Datos-Empleado", 0L, "RW");
				GuardarPagina(rol, "Familia-Empleado", 0L, "RW");
				GuardarPagina(rol, "Academico-Empleado", 0L, "RW");
				GuardarPagina(rol, "RefLaboral-Empleado", 0L, "RW");
				GuardarPagina(rol, "RefPersonal-Empleado", 0L, "RW");
				GuardarPagina(rol, "Idiomas-Empleado", 0L, "RW");
				GuardarPagina(rol, "Entrevistas-Empleado", 0L, "RW");
				GuardarPagina(rol, "Permisos-Empleado", 0L, "RW");
				GuardarPagina(rol, "Permisos-Solicitudes-Empleado", 0L, "RW");
				GuardarPagina(rol, "Permisos-Validar-Empleado", 0L, "RW");
				GuardarPagina(rol, "Cambiar-Contrasena-Empleado", 0L, "RW");
				GuardarPagina(rol, "Evaluaciones-Compartidas-Empleado", 0L, "RW");
				
				//estos son los formularios que contiene el modulo de RRHH
				GuardarPagina(rol, "Buscar-RRHH", 0L, "RW");
				GuardarPagina(rol, "BDEvaluacion-RRHH", 0L, "RW");
				GuardarPagina(rol, "Aumentar-Vacaciones-RRHH", 0L, "RW");
				GuardarPagina(rol, "Permisos-Validar-RRHH", 0L, "RW");
				GuardarPagina(rol, "CalculoV-acaciones-RRHH", 0L, "RW");
				GuardarPagina(rol, "Calculo-Vacaciones-RRHH", 0L, "RW");
				GuardarPagina(rol, "Informe-Prestaciones-RRHH", 0L, "RW");
				GuardarPagina(rol, "Informe-Miniserio-Trabajo-RRHH", 0L, "RW");
				GuardarPagina(rol, "Informe-Bancos-RRHH", 0L, "RW");
				GuardarPagina(rol, "Datos-RRHH", 0L, "RW");
				GuardarPagina(rol, "Familia-RRHH", 0L, "RW");
				GuardarPagina(rol, "Academico-RRHH", 0L, "RW");
				GuardarPagina(rol, "RefLaboral-RRHH", 0L, "RW");
				GuardarPagina(rol, "RefPersonal-RRHH", 0L, "RW");
				GuardarPagina(rol, "Idiomas-RRHH", 0L, "RW");
				GuardarPagina(rol, "Desempeno-RRHH", 0L, "RW");
				GuardarPagina(rol, "Evaluacion-RRHH", 0L, "RW");
				GuardarPagina(rol, "Puestos-RRHH", 0L, "RW");
				GuardarPagina(rol, "Salarios-RRHH", 0L, "RW");
				GuardarPagina(rol, "Historial-RRHH", 0L, "RW");
				GuardarPagina(rol, "Entrevistas-RRHH", 0L, "RW");
				GuardarPagina(rol, "Permisos-RRHH", 0L, "RW");
				GuardarPagina(rol, "Carga-Datos-RRHH", 0L, "RW");
			}
		});
		btnCrear.setText("Crear");
		btnCrear.setStylePrimaryName("gwt-TextBox2");
		btnCrear.setStyleName("sendButton");
		absolutePanel.add(btnCrear, 229, 16);
		btnCrear.setSize("117px", "34px");
		
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				busqueda(rol);
			}
		});
		
		btnGuardar = new Button("Send");
		btnGuardar.setText("Guardar Cambios");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 365, 16);
		btnGuardar.setSize("240px", "34px");
		
		absolutePanel.add(Busqueda, 611, 0);
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
    			mensaje.setMensaje("alert alert-success", "Error en BD puestos\n"+caught);
    		}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if (!(results.size()==0)) {
					Formulario nuevo  =new Formulario();
					nuevo.agregarFormulario_lleno(results);
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
	    			mensaje.setMensaje("alert alert-error", "Error al crear rol\n"+caught);
	    		}
	
				@Override
				public void onSuccess(Long results)
				{	
	    			//mensaje.setMensaje("alert alert-success", "Rol Eliminado");
				}
			});
		}
}
