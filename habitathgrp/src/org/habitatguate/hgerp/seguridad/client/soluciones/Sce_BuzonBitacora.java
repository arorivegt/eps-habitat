package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

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
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleados; // Por cambiar

public class Sce_BuzonBitacora extends Composite  {

	private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_BuzonBitacora buzon;
	private Mensaje mensaje; 
	private Grid grid;
	private AbsolutePanel absolutePanel;
	private Loading load ;
    
	private ListBox listBox;
	private Label lbDato1;
	private Image Busqueda;
	private SuggestBox txtNombreSolicitante;
	private SuggestBox txtCodigoReferencia;		
	private ListBox listSolucionConstruir ;
	
	private String nombre;
	private String codigo;
	
	public Sce_BuzonBitacora() {

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
						busqueda();
			     }
			}
		});
		txtNombreSolicitante.setStylePrimaryName("gwt-TextBox2");
		txtNombreSolicitante.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreSolicitante, 205, 19);
		txtNombreSolicitante.setSize("250px", "34px");
		txtNombreSolicitante = new SuggestBox(resultadoFormulario());
		txtNombreSolicitante.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {

			     if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER) 
			     {
						busqueda();
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
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Primer Nombre");
					lbDato1.setVisible(false);
					txtNombreSolicitante.setVisible(false);
					listSolucionConstruir.setVisible(false);
					absolutePanel.add(Busqueda, 205, 16);

					grid.clearCell(1, 0);
					Sce_BuzonBitacoraLista  nuevo = new Sce_BuzonBitacoraLista();
					nuevo.agregarFormulario('2', buzon, "", "");
					grid.setWidget(1, 0,nuevo);
			        load.invisible();
			        
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Solucion"))
				{
					listSolucionConstruir.clear();
					txtNombreSolicitante.setValue("");	
					listSolucionConstruir.addItem("Tipo I","1");
					listSolucionConstruir.addItem("Tipo II","2");
					listSolucionConstruir.addItem("Tipo III","3");
					listSolucionConstruir.addItem("Tipo IV","4");
					listSolucionConstruir.addItem("Tipo V","5");
					listSolucionConstruir.addItem("Tipo VI","6");
					listSolucionConstruir.addItem("Tipo VII","7");
					listSolucionConstruir.addItem("Tipo VIII","8");
					listSolucionConstruir.addItem("Tipo IX","9");
					
					lbDato1.setText("Seleccione segun Solucion a Construir");
					lbDato1.setVisible(true);
					txtNombreSolicitante.setVisible(false);
					listSolucionConstruir.setVisible(true);
					absolutePanel.add(Busqueda, 480, 15);
			        load.invisible();
			        
				}
		        
		        load.invisible();
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addItem("Tipo I","1");
		listSolucionConstruir.addItem("Tipo II","2");
		listSolucionConstruir.addItem("Tipo III","3");
		listSolucionConstruir.addItem("Tipo IV","4");
		listSolucionConstruir.addItem("Tipo V","5");
		listSolucionConstruir.addItem("Tipo VI","6");
		listSolucionConstruir.addItem("Tipo VII","7");
		listSolucionConstruir.addItem("Tipo VIII","8");
		listSolucionConstruir.addItem("Tipo IX","9");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		listSolucionConstruir.setVisible(false);
		absolutePanel.add(listSolucionConstruir, 205, 16);
		listSolucionConstruir.setSize("250px", "39px");
						
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				busqueda();
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
	
	public void busqueda(){

		grid.clearCell(1, 0);
		Sce_BuzonBitacoraLista  nuevo = new Sce_BuzonBitacoraLista();
		
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			nuevo.agregarFormulario('2',buzon,txtNombreSolicitante.getText(), "");
			grid.setWidget(1, 0,nuevo);
		}
		
		else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
		{

			String nombreSolicitante = txtNombreSolicitante.getText();
			System.out.println("Formulario de Solicitante: " + nombreSolicitante);
			
			if(!txtNombreSolicitante.getText().equals("")){
				nuevo.agregarFormulario('1',buzon, nombreSolicitante, "");
				grid.setWidget(1, 0,nuevo);
				nuevo.setSize("100%", "648px");
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Debe escribir el nombre del solicitante");
			}
		}
		
		else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Solucion"))
		{
			nuevo.agregarFormulario('3', buzon, "", listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}
	}
	

	// CARGA DATA A FORMULARIOS
	
	// Soluciones
	
	public void cargarFormulario(final Long idFormulario){
		
		load.visible();        
		grid.clearCell(1, 0);
		
		final Sce_DataEntryBitacoraSolicitud bitacoraSolicitud = new Sce_DataEntryBitacoraSolicitud();
		
		bitacoraSolicitud.nuevasPestanas(); // Se habilitan las demas Pestanas
											// Solucion 2 Aun no propuesta
		
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
            	System.out.println("BITACORA DE FORMULARIO: " + bitacoraSolicitud.idFormulario + ", Del Solicitante: " + result.getNombreSolicitante());
        		        		
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
        		
        		
                load.invisible();
        	}

        });
	}
	

	// RESULTADO BUSQUEDA
	
	// Soluciones
	
	MultiWordSuggestOracle resultadoFormulario()
	{
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
	    solucionesService.buscarFormulario('2', "", "", 
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
	    return oracle;
    }
	
}
