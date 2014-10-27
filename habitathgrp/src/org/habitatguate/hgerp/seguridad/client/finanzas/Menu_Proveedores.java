package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Menu_Proveedores extends Composite{
	private TabPanel tabPanel;
	public Long id_empleado = 0L;
	private ScrollPanel panel1;
	private ScrollPanel panel2;
	private ScrollPanel panel3;
	private Formulario_Proveedor bp;
	private Buscador_Proveedor fp;
    private Buscador_ProveedorAprobar bpa;
	public Menu_Proveedores(){
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");

		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		panel3 = new ScrollPanel();
		panel3.setAlwaysShowScrollBars(true);
		
		tabPanel.add(panel1, "Formulario nuevo proveedor",true);
		tabPanel.add(panel2, "Gestor de proveedores",true);
		tabPanel.add(panel3,"Aprobar Proveedor",true);
		panel1.setSize("100%", "480px");

		

		
		tabPanel.addSelectionHandler(new SelectionHandler<Integer>(){
			  public void onSelection(SelectionEvent<Integer> event){
			   int tabId = event.getSelectedItem();
			   switch(tabId) {
			   case 0:
				   ItemUno();
			       break;
			   case 1: 
				   ItemDos();
			       break;
			   case 2:
				   ItemTres();
				   break;
			   }

			 }
			});
	
   
	}

	public void ItemUno(){
		bp = new Formulario_Proveedor();
		panel1.setWidget(bp);
	}
	
	public void ItemDos(){
		fp = new Buscador_Proveedor();
		panel2.setWidget(fp);
	}
	public void ItemTres(){
		bpa = new Buscador_ProveedorAprobar();
		panel3.setWidget(bpa);
	}
	
	
}
