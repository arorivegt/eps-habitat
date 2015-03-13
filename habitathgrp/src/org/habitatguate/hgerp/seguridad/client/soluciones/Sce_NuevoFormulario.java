package org.habitatguate.hgerp.seguridad.client.soluciones;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TabPanel;

public class Sce_NuevoFormulario extends Composite  {
	
	// Llaves
	private Long idEmpleado = 0L;
	private Long idAfiliado = 0L;
	
	private Grid grid;
	private Label texto;
	private AbsolutePanel absolutePanel;
	private Loading load ;
	
	private Sce_DataEntryFormularioSolicitud nuevaSolicitud;
	
	public Sce_NuevoFormulario() {
		
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		grid = new Grid(2, 1);
		grid.setSize("876px", "100%");
		
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
	    	
		nuevaSolicitud = new Sce_DataEntryFormularioSolicitud();
		grid.setWidget(1, 0, nuevaSolicitud);
		nuevaSolicitud.setSize("100%", "100%");
		
		texto = new Label("NUEVO FORMULARIO DE SOLICITUD");
		texto.setStyleName("label");
		texto.setSize("368px", "19px");
		absolutePanel.add(texto, 55, 25);
		
		initWidget(grid);
	
	}
	
	// --- ELEMENTOS
	
	private TabPanel tabPanel;
	
	public TabPanel getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(TabPanel tabPanel) {
		this.tabPanel = tabPanel;
	}
	
	private ScrollPanel scrollPanel1;
	
	public ScrollPanel getScrollPanel1() {
		return scrollPanel1;
	}

	public void setScrollPanel1(ScrollPanel scrollPanel1) {
		this.scrollPanel1 = scrollPanel1;
	}
	
}
