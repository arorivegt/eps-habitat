package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.rrhh.formularioDatos;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * @author anibaljose
 *
 */
public class Buscador_Solucion extends Composite {

	private TabPanel tabPanel;
	public Long id_empleado = 0L;
	private ScrollPanel panel1;
	private Formulario_AsignarSolucion bbs;

	
	public Buscador_Solucion() {
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");
		
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		tabPanel.add(panel1, "Asignar Solucion",true);
		panel1.setSize("100%", "480px");

		

		
		tabPanel.addSelectionHandler(new SelectionHandler<Integer>(){
			  public void onSelection(SelectionEvent<Integer> event){
			   int tabId = event.getSelectedItem();
			   ItemUno();
			 }
			});
	}	
	
	public void ItemUno(){
		bbs = new Formulario_AsignarSolucion();
		panel1.setWidget(bbs);
	}


}

