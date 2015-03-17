
package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDocumentoPropiedad;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionCuarta;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionSegunda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionTercera;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;


public class Sce_DataEntryBitacoraSolicitud extends Composite {

	private TabPanel tabPanel;
	public Long idFormulario = 0L;

	private Sce_DataEntrySupervisionPrimera fd1;
	private Sce_DataEntrySupervisionSegunda fd2;
	private Sce_DataEntrySupervisionTercera fd3;
	private Sce_DataEntrySupervisionCuarta fd4;
	private Sce_DataEntrySupervisionUbicacion fd5;

	public Sce_DataEntryBitacoraSolicitud() {
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		// 1. Primer Supervision

		scrollPanel1 = new ScrollPanel();
		scrollPanel1.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel1, "Primera Supervision", true);
		scrollPanel1.setSize("100%", "100%");
		fd1 = new Sce_DataEntrySupervisionPrimera(this);
		scrollPanel1.setWidget(fd1);	
		
	}	
	
	public void nuevasPestanas(){
		
		// 2. Segunda Supervision
		
		scrollPanel2 = new ScrollPanel();
		scrollPanel2.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel2, "Segunda Supervision", true);
		scrollPanel2.setSize("100%", "100%");
		fd2 = new Sce_DataEntrySupervisionSegunda(this);
		scrollPanel2.setWidget(fd2);
		
		// 3. Tercera Supervision
		
		scrollPanel3 = new ScrollPanel();
		scrollPanel3.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel3, "Tercera Supervision", true);
		scrollPanel3.setSize("100%", "100%");
		fd3 = new Sce_DataEntrySupervisionTercera(this);
		scrollPanel3.setWidget(fd3);
		
		// 4. Cuarta Supervision
		
		scrollPanel4 = new ScrollPanel();
		scrollPanel4.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel4, "Cuarta Supervision", true);
		scrollPanel4.setSize("100%", "100%");
		fd4 = new Sce_DataEntrySupervisionCuarta(this);
		scrollPanel4.setWidget(fd4);
		
		// 5. Ubicacion Supervision
		
		scrollPanel5 = new ScrollPanel();
		scrollPanel5.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel5, "Ubicacion Supervision", true);
		scrollPanel5.setSize("100%", "100%");
		fd5 = new Sce_DataEntrySupervisionUbicacion(this);
		scrollPanel5.setWidget(fd5);
		
	}
	
//	
//	public void habilitarSegundaSupervision(){
//
//		// 2. Segunda Supervision
//		
//		scrollPanel2 = new ScrollPanel();
//		scrollPanel2.setAlwaysShowScrollBars(false);
//		tabPanel.add(scrollPanel2, "Segunda Supervision", true);
//		scrollPanel2.setSize("100%", "100%");
//		fd2 = new Sce_DataEntrySupervisionSegunda(this);
//		scrollPanel2.setWidget(fd2);
//		
//	}
//	
//	public void habilitarTerceraSupervision(){
//
//		// 3. Tercera Supervision
//		
//		scrollPanel3 = new ScrollPanel();
//		scrollPanel3.setAlwaysShowScrollBars(false);
//		tabPanel.add(scrollPanel3, "Tercera Supervision", true);
//		scrollPanel3.setSize("100%", "100%");
//		fd3 = new Sce_DataEntrySupervisionTercera(this);
//		scrollPanel3.setWidget(fd3);
//		
//	}
//	
//	public void habilitarCuartaSupervision(){
//
//		// 4. Cuarta Supervision
//		
//		scrollPanel4 = new ScrollPanel();
//		scrollPanel4.setAlwaysShowScrollBars(false);
//		tabPanel.add(scrollPanel4, "Cuarta Supervision", true);
//		scrollPanel4.setSize("100%", "100%");
//		fd4 = new Sce_DataEntrySupervisionCuarta(this);
//		scrollPanel4.setWidget(fd4);
//		
//	}	
	
	public void setDataSupervisionPrimera(List<AuxSolicitudSupervisionPrimera> results) {
		fd1.setDataSupervisionPrimera(results);
	}

	public void setDataSupervisionSegunda(List<AuxSolicitudSupervisionSegunda> results) {
		fd2.setDataSupervisionSegunda(results);
	}
	
	public void setDataSupervisionTercera(List<AuxSolicitudSupervisionTercera> results) {
		fd3.setDataSupervisionTercera(results);
	}

	public void setDataSupervisionCuarta(List<AuxSolicitudSupervisionCuarta> results) {
		fd4.setDataSupervisionCuarta(results);
	}
	
	
	private ScrollPanel scrollPanel1;

	public ScrollPanel getScrollPanel1() {
		return scrollPanel1;
	}


	public void setScrollPanel1(ScrollPanel scrollPanel1) {
		this.scrollPanel1 = scrollPanel1;
	}


	private ScrollPanel scrollPanel2;

	public ScrollPanel getScrollPanel2() {
		return scrollPanel2;
	}


	public void setScrollPanel2(ScrollPanel scrollPanel2) {
		this.scrollPanel2 = scrollPanel2;
	}


	private ScrollPanel scrollPanel3;

	public ScrollPanel getScrollPanel3() {
		return scrollPanel3;
	}

	public void setScrollPanel3(ScrollPanel scrollPanel3) {
		this.scrollPanel3 = scrollPanel3;
	}

	private ScrollPanel scrollPanel4;

	public ScrollPanel getScrollPanel4() {
		return scrollPanel4;
	}


	public void setScrollPanel4(ScrollPanel scrollPanel4) {
		this.scrollPanel4 = scrollPanel4;
	}

	private ScrollPanel scrollPanel5;

	public ScrollPanel getScrollPanel5() {
		return scrollPanel5;
	}

	public void setScrollPanel5(ScrollPanel scrollPanel5) {
		this.scrollPanel5 = scrollPanel5;
	}


}
