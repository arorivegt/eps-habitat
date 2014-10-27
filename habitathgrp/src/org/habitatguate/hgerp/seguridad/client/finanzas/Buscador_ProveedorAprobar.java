package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;


public class Buscador_ProveedorAprobar extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_Proveedor e = null;
	
    Timer timer2 = new Timer(){
  	  public void run() {
		/*	loginService.ConsultaTodosMaterialCostruccion(new AsyncCallback<List<AuxMaterialCostruccion>>() {
        		
        		@Override
        		public void onSuccess(List<AuxMaterialCostruccion> result) {
        			e.ActulizarList(result);      			
        			
        			
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});*/

  	  }
    };
	public Buscador_ProveedorAprobar(){
	final Grid grid = new Grid(2, 2);
	initWidget(grid);
	grid.setWidth("1278px");
	
	//------------------------------primera fila

	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1025px", "20px");
	absolutePanel.setStyleName("gwt-Label-new");
	
			
		//-----------------------------	---------------------------------
	
	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "21px");
	
	
	
	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			e.grid.AprobarProveedor();
		}
	});		

	button.setText("Aprobar Proveedor");
	button.setStylePrimaryName("gwt-TextBox2");
	button.setStyleName("gwt-TextBox2");
	absolutePanel.add(button, 914, 28);
	button.setSize("160px", "27px");
	
	loginService.ConsultaTodosProveedor_SinAprobar(0L,new AsyncCallback<List<AuxProveedor>>() {
		
		@Override
		public void onSuccess(List<AuxProveedor> result) {
			System.out.println("ya estan todos los afiliados");
			e = new TablaGWT_Proveedor(result);
			grid.setWidget(1, 0,e);
			e.setSize("700px", "300px"); 			
			
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
	

	
   
}
	
	
	
}
