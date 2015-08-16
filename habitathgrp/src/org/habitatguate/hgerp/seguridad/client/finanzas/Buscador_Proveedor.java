package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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


public class Buscador_Proveedor extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_Proveedor e = null;
    Formulario_PopUpProveedorInactivo formInactivo;
    Formulario_PopUpProveedorConvenio formConvenio;
	
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
	public Buscador_Proveedor(){
	final Grid grid = new Grid(2, 2);
	initWidget(grid);
	grid.setWidth("1278px");
	
	//------------------------------primera fila

	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1025px", "40px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	
	Button button = new Button("Send");
	

	button.setText("Imprimir Información Proveedor");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 649, -1);
	button.setSize("214px", "40px");
	
	Button button_1 = new Button("Send");
	button_1.setText("Cambiar Inactivo");
	button_1.setStyleName("finanButton");
	absolutePanel.add(button_1, 649, 45);
	button_1.setSize("214px", "40px");
	
	Button button_2 = new Button("Send");
	button_2.setText("Subir Convenio Aprobado");
	button_2.setStyleName("finanButton");
	absolutePanel.add(button_2, 869, -1);
	button_2.setSize("214px", "40px");
	
	
	
	button.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			Long idProveedor = total.get(0).getIdProveedor();
			Window.open("/FinanInformacionProveedorPDF?idProveedor="+idProveedor, "_blank", "");
			
			
		}
	});
	
	button_1.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			final List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			Long idProveedor = total.get(0).getIdProveedor();
			Long idAfiliado = total.get(0).getAuxAfiliado().getIdAfiliado();
			
			if (!total.isEmpty()){
				formInactivo = new Formulario_PopUpProveedorInactivo(idProveedor,idAfiliado);
			}else{
				Window.alert("Debes de Seleccionar una Solucion");
			}
			
			
		}
	});
	
	button_2.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			final List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			Long idProveedor = total.get(0).getIdProveedor();
			Long idAfiliado = total.get(0).getAuxAfiliado().getIdAfiliado();
			
			if (!total.isEmpty()){
				formConvenio = new Formulario_PopUpProveedorConvenio(idProveedor,idAfiliado);
			}else{
				Window.alert("Debes de Seleccionar una Solucion");
			}
			
			
		}
	});
	
	
			
		//-----------------------------	---------------------------------
	
/*	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "21px");*/
	
	
	
/*	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			e.grid.EliminarFila();
			e.grid.ActualizarTabla();
		}
	});		

	button.setText("Eliminar Proveedor");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 914, 28);
	button.setSize("160px", "27px");*/
	
	loginService.ConsultaTodosProveedor_PorAfiliadoAprobados(0L,new AsyncCallback<List<AuxProveedor>>() {
		
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
