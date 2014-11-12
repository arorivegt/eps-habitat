package org.habitatguate.hgerp.seguridad.client.finanzas;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;



public class Formulario_GestorVales extends Composite{
	private TabPanel tabPanel;
	public Long id_empleado = 0L;
	private ScrollPanel panel1;
	private ScrollPanel panel2;
	private Formulario_CrearVale bp;
	
	
	public Formulario_GestorVales(){
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");

		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		
		tabPanel.add(panel1, "Generar Vales de Solución",true);
		//tabPanel.add(panel2, "Aprobar Vales",true);
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

			   }

			 }
			});
	
   
	}

	public void ItemUno(){
		bp = new Formulario_CrearVale();
		panel1.setWidget(bp);
	}
	
	public void ItemDos(){

	}
}
