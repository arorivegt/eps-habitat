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
    private Button button;
    
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
		listRol.setSize("179px", "39px");
						
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				busqueda(rol);
			}
		});
						
		absolutePanel.add(Busqueda, 341, 0);
		Busqueda.setSize("103px", "55px");
		
		
		Label lblroles = new Label("roles");
		lblroles.setStyleName("label");
		lblroles.setSize("118px", "13px");
		absolutePanel.add(lblroles, 10, 0);
		
		button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
				eliminarRol(rol);
			}
		});
		button.setText("Eliminar");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("sendButton");
		absolutePanel.add(button, 207, 16);
		button.setSize("117px", "34px");
    	
		
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
}
