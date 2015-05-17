package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Grid;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleado; // Por cambiar

public class Sce_BuzonSupervision extends Composite  {

	private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
	
	// Llaves
	private Long idEmpleado = 0L;
	private Long idAfiliado = 0L;
	private Long idRol = 0L;
	
	private Sce_BuzonSupervision buzon;
	private Mensaje mensaje; 
	private Grid grid;
	private AbsolutePanel absolutePanel;
	private Loading load ;
    
	private ListBox listBox;
	private Label lbDato1;
	private Image Busqueda;
	private SuggestBox txtNombreSolicitante;	
	private ListBox listSolucionConstruir ;
	
	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_BuzonSupervision(final boolean valor) {

		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		// Obtener Id Empleado
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idEmpleado = result;
				System.out.println("Id Empleado: " + idEmpleado);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		// Obtener Id Afiliado
		recursosHumanosService.obtenerIdAfiliado(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idAfiliado = result;
				System.out.println("Afiliado: " + idAfiliado);	
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error no tiene Afiliado asignado Empleado");
			}
		});
		
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
		
		
		
		// ---- VERSION FUNCIONAL EN FIREFOX	
		
//    	load = new Loading();
//        load.Mostrar();
//        load.invisible();
//		mensaje = new Mensaje();
//		this.buzon = this;
//		grid = new Grid(2, 1);
//		grid.setSize("876px", "100%");
//		
//		absolutePanel = new AbsolutePanel();
//		grid.setWidget(0, 0, absolutePanel);
//		absolutePanel.setSize("100%", "30px");
//		absolutePanel.setStyleName("gwt-Label-new");
//		
//		grid.clearCell(0, 0);
//		Sce_BuzonBitacoraLista  nuevo = new Sce_BuzonBitacoraLista();
//		nuevo.agregarFormulario('2', buzon, "", "");
//		grid.setWidget(1, 0,nuevo);
//	    	
//		initWidget(grid);
		
		
// ---- NUEVA VERSION PARA VERIFICAR FUNCIONALIDAD EN CHROME
		
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		this.buzon = this;
		grid = new Grid(2, 1);
		grid.setSize("876px", "100%");
		
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		txtNombreSolicitante = new SuggestBox(resultadoFormulario());
		txtNombreSolicitante.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {

			     if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER) 
			     {
						busqueda(valor);
			     }
			}
		});
		txtNombreSolicitante.setStylePrimaryName("gwt-TextBox2");
		txtNombreSolicitante.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreSolicitante, 205, 19);
		txtNombreSolicitante.setSize("250px", "34px");
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
		listBox.addItem("Solucion");
		listBox.addItem("TODOS");		
		
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

		        load.visible();
		        if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Escriba el nombre del solicitante a buscar");
					lbDato1.setVisible(true);
					txtNombreSolicitante.setVisible(true);
					txtNombreSolicitante.showSuggestionList();
					listSolucionConstruir.setVisible(false);
					absolutePanel.add(Busqueda, 480, 15);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Solucion"))
				{
					listSolucionConstruir.clear();
					txtNombreSolicitante.setValue("");	
					listSolucionConstruir.addItem("Nueva","1");
					listSolucionConstruir.addItem("Mejoramiento","2");
					listSolucionConstruir.addItem("Adiciones Menores","3");
					
					lbDato1.setText("Seleccione segun Solucion a Construir");
					lbDato1.setVisible(true);
					txtNombreSolicitante.setVisible(false);
					listSolucionConstruir.setVisible(true);
					absolutePanel.add(Busqueda, 480, 15);
			        load.invisible();
			        
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("TODOS"))
				{
					lbDato1.setText("");
					lbDato1.setVisible(false);
					txtNombreSolicitante.setVisible(false);
					listSolucionConstruir.setVisible(false);
					absolutePanel.add(Busqueda, 205, 16);
			        load.invisible();

			        // Realiza la busqueda automatica
//					grid.clearCell(1, 0);
//					Sce_BuzonBitacoraLista  nuevo = new Sce_BuzonBitacoraLista();
//					nuevo.agregarFormulario('2', idEmpleado, idAfiliado, buzon, "", "");
//					grid.setWidget(1, 0,nuevo);
//			        load.invisible();
			        
				}
		        
		        load.invisible();
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addItem("Nueva","1");
		listSolucionConstruir.addItem("Mejoramiento","2");
		listSolucionConstruir.addItem("Adiciones Menores","3");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		listSolucionConstruir.setVisible(false);
		absolutePanel.add(listSolucionConstruir, 205, 16);
		listSolucionConstruir.setSize("250px", "39px");
						
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				busqueda(valor);
			}
		});
						
		absolutePanel.add(Busqueda, 480, 15);
		Busqueda.setSize("103px", "55px");
		
		lbDato1 = new Label("Nombre del Solicitante");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		
		Label lblBusquedaPor = new Label("Busqueda por: ");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("118px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
	    	
		initWidget(grid);
		
	}
	
	public void busqueda(boolean valVisilidad){

		grid.clearCell(1, 0);
		Sce_BuzonSupervisionLista  nuevo = new Sce_BuzonSupervisionLista();
		
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("TODOS"))
		{
			nuevo.agregarFormulario('2', idEmpleado, idAfiliado, buzon, "", "", valVisilidad);
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}
		
		else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
		{

			String nombreSolicitante = txtNombreSolicitante.getText();
			System.out.println("Formulario de Solicitante: " + nombreSolicitante);
			
			if(!txtNombreSolicitante.getText().equals("")){
				nuevo.agregarFormulario('1', idEmpleado, idAfiliado, buzon, nombreSolicitante, "", valVisilidad);
				grid.setWidget(1, 0,nuevo);
				nuevo.setSize("100%", "648px");
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Debe escribir el nombre del solicitante");
			}
		}
		
		else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Solucion"))
		{
			nuevo.agregarFormulario('3', idEmpleado, idAfiliado, buzon, "", listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()), valVisilidad);
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}
	}
	

	// CARGA DATA A FORMULARIOS
	
	// Soluciones
	
	public void cargarFormulario(final Long idFormulario, boolean valVisibilidad){
		
		load.visible();        
		grid.clearCell(1, 0);
		
		final Sce_DataEntrySupervisionSolicitud bitacoraSolicitud = new Sce_DataEntrySupervisionSolicitud(valVisibilidad);
		
		bitacoraSolicitud.habilitarPestanasFormulario(idRol); // Se habilitan las demas Pestanas
		
		grid.setWidget(1, 0, bitacoraSolicitud);
		bitacoraSolicitud.setSize("100%", "648px");
        
        
        solucionesService.obtenerDataFormularioRegistrado(idFormulario, new AsyncCallback<AuxSolicitudGeneral>(){
        	public void onFailure(Throwable caught) 
        	{
                load.invisible();
            	mensaje.setMensaje("alert alert-information alert-block", 
            			"\nNo hay resultados");
        	}

        	@Override
        	public void onSuccess(AuxSolicitudGeneral result)
        	{	

                load.invisible();            	
                bitacoraSolicitud.idFormulario = result.getIdFormulario();
            	System.out.println("BITACORA DE SUPERVISION DE FORMULARIO: " + bitacoraSolicitud.idFormulario + ", Del Solicitante: " + result.getNombreSolicitante());
        		        		
        		try{        		
        			bitacoraSolicitud.setDataSupervisionPrimera(result.getSupervisionPrimera());     			
        		}catch(Exception e){
        			
        		}  
        		
        		try{            		
        			bitacoraSolicitud.setDataSupervisionSegunda(result.getSupervisionSegunda());
        		}catch(Exception e){
        			
        		} 
        		
        		try{           		
        			bitacoraSolicitud.setDataSupervisionTercera(result.getSupervisionTercera());     			
        		}catch(Exception e){
        			
        		} 
            
        		try{           		
        			bitacoraSolicitud.setDataSupervisionCuarta(result.getSupervisionCuarta());
        		}catch(Exception e){
        			
        		} 
        		
        		try{           		
        			bitacoraSolicitud.setDataSupervisionUbicacion(result.getSupervisionUbicacion());
        		}catch(Exception e){
        			
        		} 
        		
        		try{           		
        			bitacoraSolicitud.setDataEncuestaSatisfaccion(result.getEncuestaSatisfaccion());
        		}catch(Exception e){
        			
        		} 
        		
                load.invisible();
        	}

        });
	}
	

	// RESULTADO BUSQUEDA
	
	// Soluciones
	
	MultiWordSuggestOracle resultadoFormulario()	
	{	
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
		// Obtener Id Empleado
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idEmpleado = result;
			
				// Obtener Id Afiliado
				recursosHumanosService.obtenerIdAfiliado(new AsyncCallback<Long>() {
					@Override
					public void onSuccess(Long result) {
						idAfiliado = result;
						
						System.out.println("Valores obtenidos para realizar busqueda: Id Empleado = " + idEmpleado + ", Id Afiliado = " + idAfiliado);
						
					    solucionesService.buscarFormulario('2', idEmpleado, idAfiliado, "", "", 
					    		new AsyncCallback<List<AuxSolicitudGeneral>>(){
						    
					    	public void onFailure(Throwable caught) 
						    {
						        load.invisible();
						    }
						
							@Override
						    public void onSuccess( List<AuxSolicitudGeneral> result)
						    {
								for(AuxSolicitudGeneral p : result) 
								{
									oracle.add(p.getNombreSolicitante());
								}
						    }
						
						});						
						
					}
					@Override
					public void onFailure(Throwable caught) {
						mensaje.setMensaje("alert alert-error", "Error no tiene Afiliado asignado Empleado");
					}
				});
				
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
	    
	    return oracle;
    }
	
}
