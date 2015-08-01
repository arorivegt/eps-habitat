package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.rrhh.FormularioDatos;

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
	private ScrollPanel panel2;
	private ScrollPanel panel3;
	private ScrollPanel panel4;
	private Formulario_AsignarSolucion bbs;
	private Formulario_AdminSolucionesEnCostruccion fase;
	private Formulario_TipoSolucion fts;
	private Formulario_AdminSolucionesFinalizadas fasf;

	
	public Buscador_Solucion() {
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");
		
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel3 = new ScrollPanel();
		panel3.setAlwaysShowScrollBars(true);
		panel4 = new ScrollPanel();
		panel4.setAlwaysShowScrollBars(true);
		tabPanel.add(panel1, "Asignar Solucion",true);
		tabPanel.add(panel2,"Mantenimiento Tipo Solución",true);
		tabPanel.add(panel3,"Soluciones en Costruccion",true);
		tabPanel.add(panel4,"Soluciones Finalizadas",true);
		panel1.setSize("100%", "580px");
		panel2.setSize("100%", "580px");
		panel3.setSize("100%", "580px");
		panel4.setSize("100%", "580px");

		

		
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
		fasf = new Formulario_AdminSolucionesFinalizadas();
		panel4.setWidget(fasf);
		
	}

	protected void ItemTres() {
		// TODO Auto-generated method stub
		fase = new Formulario_AdminSolucionesEnCostruccion();
		panel3.setWidget(fase);
		
	}

	protected void ItemDos() {
		// TODO Auto-generated method stub
		fts = new Formulario_TipoSolucion();
		panel2.setWidget(fts);
	}

	public void ItemUno(){
		bbs = new Formulario_AsignarSolucion();
		panel1.setWidget(bbs);
	}


}

