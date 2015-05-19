
package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaSolidario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;


public class Sce_DataEntryGarantiaSolicitud extends Composite {

	private TabPanel tabPanel;
	public Long idFormulario = 0L;

	private Sce_DataEntryGarantiaHipotecaria fd7;
	private Sce_DataEntryGarantiaFiduciaria fd8;
	private Sce_DataEntryGarantiaSolidario fd9;
	
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
    
    private Sce_DataEntryGarantiaSolicitud formulario = null;
    
	// Valor Escritura-Lectura
	private boolean valor;

	public Sce_DataEntryGarantiaSolicitud(boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		formulario = this;
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		// 1. Garantia Hipotecaria

		scrollPanel7 = new ScrollPanel();
		scrollPanel7.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel7, "Garantia Hipotecaria", true);
		scrollPanel7.setSize("100%", "100%");
		fd7 = new Sce_DataEntryGarantiaHipotecaria(this, this.valor);
		scrollPanel7.setWidget(fd7);	
		
		tabPanel.selectTab(0); // Carga Tab Inicial

		
	}	
	
	
	public void habilitarPestanasFormulario(Long rol){

		
		AdministracionService.ObtenerUsuarioPermisoNombre("Garantia-Fiduciaria-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{	
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					// 2. Garantia Fiduciaria
					scrollPanel8 = new ScrollPanel();
					scrollPanel8.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel8, "Garantia Fiduciaria", true);
					scrollPanel8.setSize("100%", "100%");
					fd8 = new Sce_DataEntryGarantiaFiduciaria(formulario, true);
					scrollPanel8.setWidget(fd8);	
					
				}else if(results.get(0).getPermiso().equals("R")){
					// 2. Garantia Fiduciaria
					scrollPanel8 = new ScrollPanel();
					scrollPanel8.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel8, "Garantia Fiduciaria", true);
					scrollPanel8.setSize("100%", "100%");
					fd8 = new Sce_DataEntryGarantiaFiduciaria(formulario, false);
					scrollPanel8.setWidget(fd8);	
				}
			}
		});
		
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Grupo-Solidario-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{	
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					// 3. Garantia Grupo Solidario

					scrollPanel9 = new ScrollPanel();
					scrollPanel9.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel9, "Grupo Solidario", true);
					scrollPanel9.setSize("100%", "100%");
					fd9 = new Sce_DataEntryGarantiaSolidario(formulario, true);
					scrollPanel9.setWidget(fd9);	
					
				}else if(results.get(0).getPermiso().equals("R")){
					// 3. Garantia Grupo Solidario

					scrollPanel9 = new ScrollPanel();
					scrollPanel9.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel9, "Grupo Solidario", true);
					scrollPanel9.setSize("100%", "100%");
					fd9 = new Sce_DataEntryGarantiaSolidario(formulario, false);
					scrollPanel9.setWidget(fd9);	
				}
			}
		});

		
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
