package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.Maps;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.control.SmallMapControl;
import com.google.gwt.maps.client.control.SmallZoomControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;


public class Sce_DataSupervisionUbicacion extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryBitacoraSolicitud formulario;
	private Sce_DataEntrySupervisionUbicacion supervisionUbicacion;
    private boolean bandera = true;
	private Long idSupervisionUbicacion = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	private Button btnGuardar;
    
	private Button btnVisualizar;
	
    private Loading load ;
    private TextBox txtLongitud;
    private TextBox txtLatitud;
    private Label lblLatitud;
    private Label lblLongitud;
	
	public Sce_DataSupervisionUbicacion(Sce_DataEntrySupervisionUbicacion a, Sce_DataEntryBitacoraSolicitud e) {
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.supervisionUbicacion = a;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "630px");
		
		// Actualmente no carga completa de mapa
		
//		Maps.loadMapsApi("", "2", false, new Runnable() {
//			public void run() {
//				busquedaEspecifica(14.6211, -90.5269);
//			}
//		});

		
		lblLatitud = new Label("Latitud:");
		lblLatitud.setStyleName("label");
		absolutePanel.add(lblLatitud, 225, 569);
		lblLatitud.setSize("69px", "19px");
		
		lblLongitud = new Label("Longitud:");
		lblLongitud.setStyleName("label");
		absolutePanel.add(lblLongitud, 423, 569);
		lblLongitud.setSize("79px", "19px");
		
		txtLatitud = new TextBox();
		txtLatitud.setStylePrimaryName("gwt-TextBox2");
		txtLatitud.setStyleName("gwt-TextBox2");
		txtLatitud.setMaxLength(200);
		absolutePanel.add(txtLatitud, 300, 567);
		txtLatitud.setSize("95px", "19px");
		
		txtLongitud = new TextBox();
		txtLongitud.setStylePrimaryName("gwt-TextBox2");
		txtLongitud.setStyleName("gwt-TextBox2");
		txtLongitud.setMaxLength(200);
		absolutePanel.add(txtLongitud, 508, 567);
		txtLongitud.setSize("95px", "19px");
		
		// -- Boton Visualizar
		
		btnVisualizar = new Button("Visualizar");
		btnVisualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(initRequireData()){

					Maps.loadMapsApi("", "2", false, new Runnable() {
						public void run() {
							
							float latitud = 0;
							latitud = Float.parseFloat(txtLatitud.getText());
							
							float longitud = 0;
							longitud = Float.parseFloat(txtLongitud.getText());
							
							System.out.println("Valores: Latitud: " + latitud + " - Longitud: " + longitud);

							// Busqueda Especifica
							busquedaEspecifica(latitud, longitud);
							
						}
					});

				}
			}
		});
		btnVisualizar.setText("Visualizar Ubicacion");
		absolutePanel.add(btnVisualizar, 647, 561);
		
		
		// -- Boton Guardar/Actualizar Informacion
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {


			}
		});
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 471, 614);
		
	}
	
	private void busquedaEspecifica(double latitud, double longitud) {
		
		   // Open a map centered on Cawker City, KS USA
	    LatLng cawkerCity = LatLng.newInstance(latitud, longitud);

	    final MapWidget map = new MapWidget(cawkerCity, 2);

	    // Add some controls for the zoom level
//	    map.addControl(new LargeMapControl());
	    map.addControl(new SmallMapControl());
	    map.addControl(new SmallZoomControl());
	    map.setZoomLevel(10);

	    // Add a marker
	    map.addOverlay(new Marker(cawkerCity));

	    // Add an info window to highlight a point of interest
	    map.getInfoWindow().open(map.getCenter(),
	        new InfoWindowContent("Ubicacion Solucion"));

		absolutePanel.add(map, 42, 50);
		map.setSize("950px", "450px");
		
	}
	
	
	private void buildUi() {
		// Open a map centered on Cawker City, KS USA
//		LatLng cawkerCity = LatLng.newInstance(39.509, -98.434);
		LatLng cawkerCity = LatLng.newInstance(14.6211, -90.5269);
		
		final MapWidget map = new MapWidget(cawkerCity, 2);
//		map.setSize("100%", "100%");
		// Add some controls for the zoom level
//		map.addControl(new LargeMapControl());
	    map.addControl(new SmallMapControl());
	    map.addControl(new SmallZoomControl());
	    map.setZoomLevel(12);

		// Add a marker
		map.addOverlay(new Marker(cawkerCity));

		// Add an info window to highlight a point of interest
		map.getInfoWindow().open(map.getCenter(),
				new InfoWindowContent("Ubicacion Default"));

		absolutePanel.add(map, 42, 50);
		map.setSize("950px", "450px");
		
	}

	
    // VALIDACION DATA A INGRESAR
    
    public boolean initRequireData()
    {

    	if(this.txtLatitud.getText().equals("")){
    		mensaje.setMensaje("alert alert-error", "Debe ingresar un valor válido");
    		return false;
    	}

    	if(this.txtLongitud.getText().equals("")){
    		mensaje.setMensaje("alert alert-error", "Debe ingresar un valor válido");
    		return false;
    	}
    	
    	return true;    		
    }
	
	
}
