package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.Maps;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.control.SmallMapControl;
import com.google.gwt.maps.client.control.SmallZoomControl;
import com.google.gwt.maps.client.event.MapDoubleClickHandler;
import com.google.gwt.maps.client.event.MarkerDragEndHandler;
import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geocode.LocationCallback;
import com.google.gwt.maps.client.geocode.Placemark;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.MarkerOptions;


public class Sce_DataSupervisionUbicacion extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntrySupervisionSolicitud formulario;
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
	
    private MapWidget map;
    private Geocoder fCoder;
    private Marker fMarker;
    
	public Sce_DataSupervisionUbicacion(Sce_DataEntrySupervisionUbicacion a, Sce_DataEntrySupervisionSolicitud e) {
		
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
		txtLatitud.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtLatitud.getText().equals("")) {txtLatitud.setText("0");}
				else if(txtLatitud.getText().equals(null)) {txtLatitud.setText("0");}
				else{
					try{
//						Integer.parseInt(txtLatitud.getText());
						Double.parseDouble(txtLatitud.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor ingresado no valido");
						txtLatitud.setText("0");
					}
				}
			}
		});		
		txtLatitud.setText("0");
		txtLatitud.setStylePrimaryName("gwt-TextBox2");
		txtLatitud.setStyleName("gwt-TextBox2");
		txtLatitud.setMaxLength(200);
		absolutePanel.add(txtLatitud, 300, 567);
		txtLatitud.setSize("95px", "19px");
		txtLatitud.setTabIndex(1);
		
		txtLongitud = new TextBox();
		txtLongitud.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtLongitud.getText().equals("")) {txtLongitud.setText("0");}
				else if(txtLongitud.getText().equals(null)) {txtLongitud.setText("0");}
				else{
					try{
//						Integer.parseInt(txtLongitud.getText());
						Double.parseDouble(txtLatitud.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nValor ingresado no valido");
						txtLongitud.setText("0");
					}
				}
			}
		});		
		txtLongitud.setText("0");
		txtLongitud.setStylePrimaryName("gwt-TextBox2");
		txtLongitud.setStyleName("gwt-TextBox2");
		txtLongitud.setMaxLength(200);
		absolutePanel.add(txtLongitud, 508, 567);
		txtLongitud.setSize("95px", "19px");
		txtLongitud.setTabIndex(2);
		
		// -- Boton Visualizar
		
		btnVisualizar = new Button("Visualizar");
		btnVisualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(initRequireData()){

					Maps.loadMapsApi("", "2", false, new Runnable() {
						public void run() {

							if(txtLatitud.getText().equals("0") && txtLatitud.getText().equals("0")){
								String latitudDefault = "14.6211";
								String longitudDefault = "-90.5269";		
								iniciarUbicacionDefault(latitudDefault, longitudDefault);
								System.out.println("Valores de Mapa Default - 0");

							}else if(txtLatitud.getText().equals(null) && txtLatitud.getText().equals(null)){
								String latitudDefault = "14.6211";
								String longitudDefault = "-90.5269";		
								iniciarUbicacionDefault(latitudDefault, longitudDefault);
								System.out.println("Valores de Mapa Default - nulo");

							} else{
								double latitud = 0;
								latitud = Double.parseDouble(txtLatitud.getText());

								double longitud = 0;
								longitud = Double.parseDouble(txtLongitud.getText());

								System.out.println("Valores: Latitud: " + latitud + " - Longitud: " + longitud);

								// Busqueda Ubicacion Especifica
								ubicacionEspecifica(latitud, longitud);

								System.out.println("Valores de Mapa Almacenados");
							}


						}
					});

				}
			}
		});
		btnVisualizar.setText("Visualizar/Refrescar");
		absolutePanel.add(btnVisualizar, 647, 561);
		btnVisualizar.setTabIndex(3);
		
		// -- Boton Guardar/Actualizar Informacion
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				String latitud = "";		
				if(txtLatitud.getText() == null){
					latitud = "";
				}else{
					latitud = txtLatitud.getText();
				}

				String longitud = "";		
				if(txtLongitud.getText() == null){
					longitud = "";
				}else{
					longitud = txtLongitud.getText();
				}
				
				Date time = new Date();
				@SuppressWarnings("deprecation")
				Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());
				
				if(bandera){

					solucionesService.ingresarSupervisionUbicacion(fecrec, formulario.idFormulario, 
							latitud, longitud,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje = new Mensaje();
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje = new Mensaje();
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idSupervisionUbicacion = result;
							System.out.println("Valor de NUEVA UBICACION Supervision: " + idSupervisionUbicacion);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarSupervisionUbicacion(formulario.idFormulario, idSupervisionUbicacion, 
							latitud, longitud,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de DATOS DE UBICACION SUPERVISION: " + idSupervisionUbicacion );
							bandera = false;

						}
					});
					
				}
				

			}
		});
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 471, 614);
		btnGuardar.setTabIndex(4);
		
		
	}
    
    //---- Metodo de Google Maps
	
	private void ubicacionEspecifica(double latitud, double longitud) {
		
		// Coordenadas
	    LatLng coordenadas = LatLng.newInstance(latitud, longitud);

	    map = new MapWidget(coordenadas, 6);
	    map.setSize("950px", "450px");
	    
	    // Add some controls for the zoom level
	    map.addControl(new SmallMapControl());
	    map.addControl(new SmallZoomControl());
	    map.setZoomLevel(10);
	    
	    ///
	    fCoder = new Geocoder();
	    
	    MarkerOptions options = MarkerOptions.newInstance();
        options.setDraggable(true);
        fMarker = new Marker(LatLng.newInstance(latitud, longitud), options);
	    
	    // Add a marker
	    map.addOverlay(fMarker);
//	    fMarker.setVisible(false);
        addHandlers();

        performReverseLookup(coordenadas);
        
	    // Add an info window to highlight a point of interest
//	    map.getInfoWindow().open(map.getCenter(), new InfoWindowContent("Ubicacion Solucion"));

		absolutePanel.add(map, 42, 50);
		
		
	}

	// Inicial
	
	private void ubicacionDefault(String latitud, String longitud) {
		
		double latitudValue = 0;
		latitudValue = Double.parseDouble(latitud);
		
		double longitudValue = 0;
		longitudValue = Double.parseDouble(longitud);
		
		// Coordenadas
	    LatLng coordenadas = LatLng.newInstance(latitudValue, longitudValue);

	    map = new MapWidget(coordenadas, 6);
	    map.setSize("950px", "450px");
	    
	    // Add some controls for the zoom level
	    map.addControl(new SmallMapControl());
	    map.addControl(new SmallZoomControl());
	    map.setZoomLevel(10);

	    ///
	    fCoder = new Geocoder();
	    
	    MarkerOptions options = MarkerOptions.newInstance();
        options.setDraggable(true);
        fMarker = new Marker(LatLng.newInstance(latitudValue, longitudValue), options);
	    
	    // Add a marker
	    map.addOverlay(fMarker);
//	    fMarker.setVisible(false);
        addHandlers();
        
        performReverseLookup(coordenadas);

	    // Add an info window to highlight a point of interest
//	    map.getInfoWindow().open(map.getCenter(), new InfoWindowContent("Ubicacion Default"));

		absolutePanel.add(map, 42, 50);

		
	}
	
	public void iniciarUbicacionDefault(final String latitud, final String longitud){
		
		Maps.loadMapsApi("", "2", false, new Runnable() {

			public void run() {
				// UbicacionDefault
				ubicacionDefault(latitud, longitud);
			}
		});
	}


	// ---------------- HANDLERS
	
    private void addHandlers() {
        map.addMapDoubleClickHandler(new MapDoubleClickHandler() {

            @Override
            public void onDoubleClick(MapDoubleClickEvent event) {
                if (event.getLatLng() != null) {
                    performReverseLookup(event.getLatLng());
                }
            }

        });

        fMarker.addMarkerDragEndHandler(new MarkerDragEndHandler() {

            @Override
            public void onDragEnd(MarkerDragEndEvent event) {
                LatLng point = event.getSender().getLatLng();
                if (point != null) {
                    performReverseLookup(point);
                }
            }

        });
    }
    
    private void performReverseLookup(final LatLng point) {
        fCoder.getLocations(point, new LocationCallback() {
        	
            @Override
            public void onFailure(int statusCode) {}

			@Override
			public void onSuccess(JsArray<Placemark> locations) {
                if (locations.length() > 0) {
                    LatLng point = locations.get(0).getPoint();
                    fMarker.setLatLng(point);
//                    fMarker.setVisible(true);
                    map.getInfoWindow().open(point, new InfoWindowContent(locations.get(0).getAddress()));
                    
                    // Se actualiza la informacion en los campos de texto
                    System.out.println("Coordenada Obtenidas: Latitud " + point.getLatitude() + " Longitud: " + point.getLongitude());
            		txtLatitud.setValue(""+point.getLatitude());
            		txtLongitud.setValue(""+point.getLongitude());
                    
                }
				
			}
        });
    }
	
	
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
			String latitud, String longitud)
	{
    	
		this.bandera = false;
		
		this.idSupervisionUbicacion = id; // ID Formulario Cargado
		
		this.txtLatitud.setValue(latitud);
		this.txtLongitud.setValue(longitud);
		
		
		if(latitud.equals("0") && longitud.equals("0")){
			String latitudDefault = "14.6211";
			String longitudDefault = "-90.5269";		
			iniciarUbicacionDefault(latitudDefault, longitudDefault);
			System.out.println("Valores de Mapa Default - 0");
			
		}else if(latitud.equals(null) && longitud.equals(null)){
			String latitudDefault = "14.6211";
			String longitudDefault = "-90.5269";		
			iniciarUbicacionDefault(latitudDefault, longitudDefault);
			System.out.println("Valores de Mapa Default - nulo");
			
		} else{
			iniciarUbicacionDefault(latitud, longitud);
			System.out.println("Valores de Mapa Almacenados");
		}
		
		
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
