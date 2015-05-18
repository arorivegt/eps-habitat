
package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaSolidario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSituacionEconomica;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;


public class Sce_DataEntryBuroCreditoSolicitud extends Composite {

	private TabPanel tabPanel;
	public Long idFormulario = 0L;

	private Sce_DataEntrySituacionEconomicaBuroCredito fd7;
	
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    
    private Sce_DataEntryBuroCreditoSolicitud formulario = null;
    
	// Valor Escritura-Lectura
	private boolean valor;

	public Sce_DataEntryBuroCreditoSolicitud(boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		formulario = this;
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		// 1. Garantia Hipotecaria

		scrollPanel7 = new ScrollPanel();
		scrollPanel7.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel7, "Situacion Economica", true);
		scrollPanel7.setSize("100%", "100%");
		fd7 = new Sce_DataEntrySituacionEconomicaBuroCredito(this, this.valor);
		scrollPanel7.setWidget(fd7);	
		
		tabPanel.selectTab(0); // Carga Tab Inicial

		
	}	
	
	// SET DATA SITUACION ECONOMICA BURO CREDITO
	
	public void setDataSituacionEconomica(List<AuxSolicitudSituacionEconomica> results, Boolean valor) {
		fd7.setDataSituacionEconomica(results, valor);
	}
	
	
	
	private ScrollPanel scrollPanel7;

	public ScrollPanel getScrollPanel7() {
		return scrollPanel7;
	}


	public void setScrollPanel7(ScrollPanel scrollPanel7) {
		this.scrollPanel7 = scrollPanel7;
	}
	
	

}
