
package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionCuarta;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionSegunda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionTercera;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionUbicacion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;


public class Sce_DataEntrySupervisionSolicitud extends Composite {

	private TabPanel tabPanel;
	public Long idFormulario = 0L;
	public Long idRol = 0L;

	private Sce_DataEntrySupervisionPrimera fd1;
	private Sce_DataEntrySupervisionSegunda fd2;
	private Sce_DataEntrySupervisionTercera fd3;
	private Sce_DataEntrySupervisionCuarta fd4;
	private Sce_DataEntrySupervisionUbicacion fd5;
	private Sce_DataEntryEncuestaSatisfaccion fd6;

    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    
    private Sce_DataEntrySupervisionSolicitud formulario = null;
    private Mensaje mensaje;
    
	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_DataEntrySupervisionSolicitud(boolean valor) {
		
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		// Obtener Id Rol
		recursosHumanosService.obtenerIdRol(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idRol = result;
				System.out.println("Id Rol: " + idRol);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		// 1. Primer Supervision

		scrollPanel1 = new ScrollPanel();
		scrollPanel1.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel1, "Primera Supervision", true);
		scrollPanel1.setSize("100%", "100%");
		fd1 = new Sce_DataEntrySupervisionPrimera(this, this.valor);
		scrollPanel1.setWidget(fd1);	
		
		tabPanel.selectTab(0); // Carga Tab Inicial
		
	}	
	
	public void habilitarPestanasFormulario(Long rol){
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Segunda-Supervision-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{	
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					// 2. Segunda Supervision	
					scrollPanel2 = new ScrollPanel();
					scrollPanel2.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel2, "Segunda Supervision", true);
					scrollPanel2.setSize("100%", "100%");
					fd2 = new Sce_DataEntrySupervisionSegunda(formulario, true);
					scrollPanel2.setWidget(fd2);
					
				}else if(results.get(0).getPermiso().equals("R")){
					// 2. Segunda Supervision		
					scrollPanel2 = new ScrollPanel();
					scrollPanel2.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel2, "Segunda Supervision", true);
					scrollPanel2.setSize("100%", "100%");
					fd2 = new Sce_DataEntrySupervisionSegunda(formulario, false);
					scrollPanel2.setWidget(fd2);
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Tercera-Supervision-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{	
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					// 3. Tercera Supervision		
					scrollPanel3 = new ScrollPanel();
					scrollPanel3.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel3, "Tercera Supervision", true);
					scrollPanel3.setSize("100%", "100%");
					fd3 = new Sce_DataEntrySupervisionTercera(formulario, true);
					scrollPanel3.setWidget(fd3);
					
				}else if(results.get(0).getPermiso().equals("R")){
					// 3. Tercera Supervision				
					scrollPanel3 = new ScrollPanel();
					scrollPanel3.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel3, "Tercera Supervision", true);
					scrollPanel3.setSize("100%", "100%");
					fd3 = new Sce_DataEntrySupervisionTercera(formulario, false);
					scrollPanel3.setWidget(fd3);
				}
			}
		});		
					
		AdministracionService.ObtenerUsuarioPermisoNombre("Cuarta-Supervision-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{	
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					// 4. Cuarta Supervision			
					scrollPanel4 = new ScrollPanel();
					scrollPanel4.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel4, "Cuarta Supervision", true);
					scrollPanel4.setSize("100%", "100%");
					fd4 = new Sce_DataEntrySupervisionCuarta(formulario, true);
					scrollPanel4.setWidget(fd4);
					
				}else if(results.get(0).getPermiso().equals("R")){
					// 4. Cuarta Supervision					
					scrollPanel4 = new ScrollPanel();
					scrollPanel4.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel4, "Cuarta Supervision", true);
					scrollPanel4.setSize("100%", "100%");
					fd4 = new Sce_DataEntrySupervisionCuarta(formulario, false);
					scrollPanel4.setWidget(fd4);
				}
			}
		});			
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Ubicacion-Solucion-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{	
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					// 5. Ubicacion Supervision
					scrollPanel5 = new ScrollPanel();
					scrollPanel5.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel5, "Ubicacion Solucion", true);
					scrollPanel5.setSize("100%", "100%");
					fd5 = new Sce_DataEntrySupervisionUbicacion(formulario, true);
					scrollPanel5.setWidget(fd5);
					
				}else if(results.get(0).getPermiso().equals("R")){
					// 5. Ubicacion Supervision
					scrollPanel5 = new ScrollPanel();
					scrollPanel5.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel5, "Ubicacion Solucion", true);
					scrollPanel5.setSize("100%", "100%");
					fd5 = new Sce_DataEntrySupervisionUbicacion(formulario, false);
					scrollPanel5.setWidget(fd5);
				}
			}
		});		
				
		AdministracionService.ObtenerUsuarioPermisoNombre("Encuesta-Satisfaccion-Soluciones", rol, new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{	
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					// 6. Encuesta Satisfaccion	
					scrollPanel6 = new ScrollPanel();
					scrollPanel6.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel6, "Encuesta Satisfaccion", true);
					scrollPanel6.setSize("100%", "100%");
					fd6 = new Sce_DataEntryEncuestaSatisfaccion(formulario, true);
					scrollPanel6.setWidget(fd6);
					
				}else if(results.get(0).getPermiso().equals("R")){
					// 6. Encuesta Satisfaccion	
					scrollPanel6 = new ScrollPanel();
					scrollPanel6.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel6, "Encuesta Satisfaccion", true);
					scrollPanel6.setSize("100%", "100%");
					fd6 = new Sce_DataEntryEncuestaSatisfaccion(formulario, false);
					scrollPanel6.setWidget(fd6);
				}
			}
		});	
		
	}
	
	
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
	
	public void setDataSupervisionUbicacion(List<AuxSolicitudSupervisionUbicacion> results) {
		fd5.setDataSupervisionUbicacion(results);
	}

	public void setDataEncuestaSatisfaccion(List<AuxSolicitudEncuestaSatisfaccion> results) {
		fd6.setDataEncuestaSatisfaccion(results);
	}
	
	//-------------------
	
	
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

	private ScrollPanel scrollPanel6;

	public ScrollPanel getScrollPanel6() {
		return scrollPanel6;
	}

	public void setScrollPanel6(ScrollPanel scrollPanel6) {
		this.scrollPanel6 = scrollPanel6;
	}

}
