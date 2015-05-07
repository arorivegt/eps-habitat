
package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaSolidario;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;


public class Sce_DataEntryGarantiaSolicitud extends Composite {

	private TabPanel tabPanel;
	public Long idFormulario = 0L;

	private Sce_DataEntryGarantiaHipotecaria fd7;
	private Sce_DataEntryGarantiaFiduciaria fd8;
	private Sce_DataEntryGarantiaSolidario fd9;
	
    private  Grid grid;

	public Sce_DataEntryGarantiaSolicitud() {
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		// 1. Garantia Hipotecaria

		scrollPanel7 = new ScrollPanel();
		scrollPanel7.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel7, "Garantia Hipotecaria", true);
		scrollPanel7.setSize("100%", "100%");
		fd7 = new Sce_DataEntryGarantiaHipotecaria(this);
		scrollPanel7.setWidget(fd7);	
		
		tabPanel.selectTab(0); // Carga Tab Inicial

		
		// 2. Garantia Fiduciaria

		scrollPanel8 = new ScrollPanel();
		scrollPanel8.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel8, "Garantia Fiduciaria", true);
		scrollPanel8.setSize("100%", "100%");
		fd8 = new Sce_DataEntryGarantiaFiduciaria(this);
		scrollPanel8.setWidget(fd8);	

		// 3. Garantia Grupo Solidario

		scrollPanel9 = new ScrollPanel();
		scrollPanel9.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel9, "Grupo Solidario", true);
		scrollPanel9.setSize("100%", "100%");
		fd9 = new Sce_DataEntryGarantiaSolidario(this);
		scrollPanel9.setWidget(fd9);	
		
	}	
	
	
	public void NuevasPestanas(){

		// 8. Colindancias & Mejoramiento

//		scrollPanel8 = new ScrollPanel();
//		scrollPanel8.setAlwaysShowScrollBars(false);
//		tabPanel.add(scrollPanel8, "Colindancias & Mejoramiento",true);
//		scrollPanel8.setSize("100%", "100%");
//		fd8 = new Sce_DataColindanciasMejoramiento(this);
//		scrollPanel8.setWidget(fd8);				
		
		// 9. Monto inversion

//		scrollPanel8 = new ScrollPanel();
//		scrollPanel8.setAlwaysShowScrollBars(false);
//		tabPanel.add(scrollPanel8, "Monto Inversion",true);
//		scrollPanel8.setSize("100%", "100%");
//		fd9 = new Sce_DataMontoInversion(this);
//		scrollPanel8.setWidget(fd9);		
		
		// 11. Solo para exclusivo del Afiliado

//		scrollPanel9 = new ScrollPanel();
//		scrollPanel9.setAlwaysShowScrollBars(false);
//		tabPanel.add(scrollPanel9, "Exclusivo Afiliado",true);
//		scrollPanel9.setSize("100%", "100%");
//		fd11 = new Sce_DataExclusivoAfiliado(this);
//		scrollPanel9.setWidget(fd11);		
		
	}
	
	// SET DATA GARANTIAS
	
	public void setDataGarantiaHipotecaria(List<AuxSolicitudGarantiaHipotecaria> results) {
		fd7.setDataGarantiaHipotecaria(results);
	}
	
	public void setDataGarantiaFiduciaria(List<AuxSolicitudGarantiaFiduciaria> results) {
		fd8.setDataGarantiaFiduciaria(results);
	}
	
	public void setDataGarantiaSolidario(List<AuxSolicitudGarantiaSolidario> results) {
		fd9.setDataGarantiaSolidario(results);
	}
	
	
	private ScrollPanel scrollPanel7;

	public ScrollPanel getScrollPanel7() {
		return scrollPanel7;
	}


	public void setScrollPanel7(ScrollPanel scrollPanel7) {
		this.scrollPanel7 = scrollPanel7;
	}
	
	private ScrollPanel scrollPanel8;
	
	public ScrollPanel getScrollPanel8() {
		return scrollPanel8;
	}


	public void setScrollPanel8(ScrollPanel scrollPanel8) {
		this.scrollPanel8 = scrollPanel8;
	}


	private ScrollPanel scrollPanel9;

	public ScrollPanel getScrollPanel9() {
		return scrollPanel9;
	}


	public void setScrollPanel9(ScrollPanel scrollPanel9) {
		this.scrollPanel9 = scrollPanel9;
	}


	private ScrollPanel scrollPanel10;

	public ScrollPanel getScrollPanel10() {
		return scrollPanel10;
	}


	public void setScrollPanel10(ScrollPanel scrollPanel10) {
		this.scrollPanel10 = scrollPanel10;
	}
	

}