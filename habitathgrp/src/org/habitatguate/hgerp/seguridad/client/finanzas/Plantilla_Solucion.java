package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegPlantillaSolucion;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestionEvent;
import com.google.gwt.user.client.ui.SuggestionHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Plantilla_Solucion extends Composite{

	
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_PlantillaSolucion e = null;
    
    public AuxMaterialCostruccion selectNuevo = null;
    public double costoAcumulado = 0;
    public Long idPlantillaSolucionAlmacenado = 0L;
    public Long correlativo = (long) 1; 
    public boolean banderaTimer = false;
    public boolean banderaWhile = false;
    
    Timer timer2 = new Timer(){
  	  public void run() {
  		  System.out.println("tiempo expirado");
  		  banderaWhile = false;
  	  }
    };
    
    Timer timer = new Timer() {
        public void run() {
        	Iterator<AuxDetallePlantillaSolucion> i = e.grid.getListMateriales().iterator();
			//timer2.schedule(1000);
			while (i.hasNext() && banderaTimer == false){
			//	System.out.println("corriendo");
			//	if (banderaWhile ==false){
			//		banderaWhile = true;
					AuxDetallePlantillaSolucion aux = i.next();
			//		timer2.schedule(1000);
					loginService.Insertar_UnicoDetallePlantillaSolucion(idPlantillaSolucionAlmacenado,aux,
        			new AsyncCallback<Long>() {

						@Override
						public void onFailure(Throwable caught) {
							System.err.println(caught);
							
						}

						@Override
						public void onSuccess(Long result) {

							
						}
        		
					});
			//		if(!i.hasNext()){
		//				banderaTimer= true;
		//			}
		//			}
					Long c = 0L;
					for (int x = 0; x < 10000; x++){
						for (int y = 0 ; y <10000; y++){
							//for (int z = 0; z < 2;z++)
								c = c + 1;
						}
					}
			}
			
			Window.alert("Plantilla Almacenada Correctamente");
			e.grid.ActualizarList();
		    costoAcumulado = 0;
		    idPlantillaSolucionAlmacenado = 0L;
		    correlativo = (long) 1; 
        }
      };
 
    
    public Plantilla_Solucion() {
    	final Grid grid = new Grid(2, 1);
		final MaterialNameSuggestOracle oracle = new MaterialNameSuggestOracle();
		initWidget(grid);
		grid.setWidth("1278px");
		
		e = new TablaGWT_PlantillaSolucion(new ArrayList<AuxDetallePlantillaSolucion>());
		grid.setWidget(1, 0,e);
		e.setSize("1000px", "300px");
		
		
		
		loginService.ConsultaTodosMaterialCostruccion(new AsyncCallback<List<AuxMaterialCostruccion>>() {
			
			@Override
			public void onSuccess(List<AuxMaterialCostruccion> result) {
				if (!result.isEmpty()){
					for (AuxMaterialCostruccion p : result){
						oracle.add(new MaterialMultiWordSuggestion(p));	
					}
				}

			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});

		//------------------------------primera fila
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		

		
	    final SuggestBox suggestbox = new SuggestBox(oracle);
	    
		
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1000px", "90px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		Label label = new Label("Nombre Plantilla");
		label.setStyleName("label");
		absolutePanel.add(label, 5, 10);
		label.setSize("157px", "13px");
		
		final TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(100);
		absolutePanel.add(textBox, 5, 29);
		textBox.setSize("227px", "34px");

		
		
		Label label_1 = new Label("Tipo");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 242, 10);
		label_1.setSize("192px", "13px");
		

		final TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(100);
		absolutePanel.add(textBox_1, 242, 29);
		textBox_1.setSize("227px", "34px");
		
			
			//-----------------------------	---------------------------------
		
		Image image = new Image("images/ico-lupa.png");
		absolutePanel.add(image, 958, 0);
		image.setSize("103px", "55px");
		
	//------------------------- NUEVO MATERIAL DE COSTRUCCION----------------------------------
		Label label_2a = new Label("Nombre Material Costruccion");
		label.setStyleName("label");
		absolutePanel.add(label_2a, 5, 90);
		label.setSize("157px", "13px");
		
		suggestbox.setStyleName("gwt-SuggestBox");
		absolutePanel.add(suggestbox, 5, 90);
		suggestbox.setSize("227px", "30px");
		
		suggestbox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
			
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				// TODO Auto-generated method stub
				MaterialMultiWordSuggestion select = (MaterialMultiWordSuggestion)event.getSelectedItem();
				selectNuevo = select.getMatConstruccion();
			}
		});
		 
		Label label_2b = new Label("Cantidad");
		label_2a.setStyleName("label");
		absolutePanel.add(label_2b, 242, 55);
		label_2b.setSize("157px", "13px");
		
		final TextBox textBox_2b = new TextBox();
		textBox_2b.setStyleName("gwt-TextBox2");
		textBox_2b.setMaxLength(100);
		absolutePanel.add(textBox_2b, 242, 90);
		textBox_2b.setSize("227px", "34px");

		Button button_2a = new Button("Agregar Material");
		button_2a.setText("Agregar Material");
		button_2a.setStylePrimaryName("gwt-TextBox2");
		button_2a.setStyleName("gwt-TextBox2");
		absolutePanel.add(button_2a, 720, 90);
		button_2a.setSize("157px", "40px");
		
		
		button_2a.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (selectNuevo != null){
				AuxDetallePlantillaSolucion nuevoElemento = new AuxDetallePlantillaSolucion();
				nuevoElemento.setIdDetallePlantillaSolucion(correlativo);
				nuevoElemento.setNomMaterialCostruccion(selectNuevo.getNomMaterialCostruccion());
				nuevoElemento.setUnidadMetrica(selectNuevo.getUnidadMetrica());
				nuevoElemento.setCantidad(Double.parseDouble(textBox_2b.getText()));
				nuevoElemento.setPrecioUnit(selectNuevo.getPrecioUnit());
				double subTotal = Double.parseDouble(textBox_2b.getText())*selectNuevo.getPrecioUnit();
				nuevoElemento.setSubTotal(subTotal);
				costoAcumulado = costoAcumulado + subTotal;
				nuevoElemento.setCostoAcumulado(costoAcumulado);
				correlativo = correlativo + (long)1;
				e.grid.NuevoMaterial(nuevoElemento);
				suggestbox.setText("");
				textBox_2b.setText("");
				selectNuevo = null;
				}
				else
				{
					Window.alert("Es necesario ingresar antes un material de costrucción");
				}
				
			}
		});
		
		
	//--------------------------------------	
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if (!textBox_1.getText().equals("")){

				loginService.Insertar_PlantillaSolucion(textBox.getText(), textBox_1.getText(), costoAcumulado,
						new AsyncCallback<Long>(){
					@Override		
	                public void onFailure(Throwable caught) 
	                {
	                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
	                }

					@Override
	                public void onSuccess(Long result)
	                {			
	                	//Window.alert("Datos Almacenados Correctamente " + result);             	
	                	textBox.setText("");
	                	textBox_1.setText("");
	        			idPlantillaSolucionAlmacenado = result;
	    				timer.schedule(1500);	
	                	
	                }

	         		});	
				/**/
	        	//Window.alert("Datos Almacenados Correctamente ");  

				}
				else{
				Window.alert("Debe completar el formulario");
				}
			}
		});		

		button.setText("Nueva Plantilla");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("gwt-TextBox2");
		absolutePanel.add(button, 720, 29);
		button.setSize("157px", "40px");
	

	

	
   
}
}