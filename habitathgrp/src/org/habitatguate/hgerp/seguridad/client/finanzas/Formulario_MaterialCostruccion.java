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

public class Formulario_MaterialCostruccion extends Composite{
	private TabPanel tabPanel;
	public Long id_empleado = 0L;
	private ScrollPanel panel1;
	private ScrollPanel panel2;
	private ScrollPanel panel3;
	private ScrollPanel panel4;
	private Buscador_MaterialCostruccion bbs;
	private Plantilla_Solucion ps;
	private Formulario_CatalogoMaterial fcat;
	private Formulario_CatalogoProductos fcp;
    
	public Formulario_MaterialCostruccion(){
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");
		
		panel3 = new ScrollPanel();
		panel3.setAlwaysShowScrollBars(true);
		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		panel4 = new ScrollPanel();
		
		tabPanel.add(panel1, "Materiales de Construccion",true);
		tabPanel.add(panel2, "Plantilla Solucion",true);
		tabPanel.add(panel3, "Items de Construccion",true);
		tabPanel.add(panel4, "Catalogo de Productos",true);
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
			   case 3:
				   ItemCuatro();
				   break;
			   }

			 }
			});
	
   
	}
	protected void ItemCuatro() {
		// TODO Auto-generated method stub
		fcp = new Formulario_CatalogoProductos();
		panel4.setWidget(fcp);
	}
	public void ItemTres(){
		fcat = new Formulario_CatalogoMaterial();
		panel3.setWidget(fcat);
	}
	public void ItemUno(){
		bbs = new Buscador_MaterialCostruccion();
		panel1.setWidget(bbs);
	}
	
	public void ItemDos(){
		ps = new Plantilla_Solucion();
		panel2.setWidget(ps);
	}
	
	
}
