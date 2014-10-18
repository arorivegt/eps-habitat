package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class Formulario_AsignarSolucion extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_PlantillaSolucion e = null;
    
    public AuxMaterialCostruccion selectNuevo = null;
    public AuxBeneficiario selectNuevoBene = null;
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
	
	public Formulario_AsignarSolucion(){
		final Grid grid = new Grid(2, 2);
		final MaterialNameSuggestOracle oracle = new MaterialNameSuggestOracle();
		final PlantillaNameSuggestOracle plantilla = new PlantillaNameSuggestOracle();
		final BeneficiarioNameSuggestOracle bene = new BeneficiarioNameSuggestOracle();
		initWidget(grid);
		grid.setWidth("1278px");
		
		e = new TablaGWT_PlantillaSolucion(new ArrayList<AuxDetallePlantillaSolucion>());
		e.grid.setSize("1171px", "1500");
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
		
		loginService.ConsultaTodasPlantillas(new AsyncCallback<List<AuxPlantillaSolucion>>() {
			
			@Override
			public void onSuccess(List<AuxPlantillaSolucion> result) {
				if (!result.isEmpty()){
					for (AuxPlantillaSolucion p : result){
						plantilla.add(new PlantillaMultiWordSuggestion(p));	
					}
				}

			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});
		
		loginService.ConsultaTodosBene(new AsyncCallback<List<AuxBeneficiario>>() {
			
			@Override
			public void onSuccess(List<AuxBeneficiario> result) {
				if (!result.isEmpty()){
					for (AuxBeneficiario p : result){
						bene.add(new BeneficiarioMultiWordSuggestion(p));	
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
		absolutePanel.setSize("1241px", "90px");
		absolutePanel.setStyleName("gwt-Label-new");
		
	//------------------------- NUEVO MATERIAL DE COSTRUCCION----------------------------------
		Label label_2a = new Label("Nombre Material Costruccion");
		absolutePanel.add(label_2a, 5, 86);
		
		suggestbox.setStyleName("gwt-SuggestBox");
		absolutePanel.add(suggestbox, 5, 108);
		suggestbox.setSize("203px", "18px");
		
		suggestbox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
			
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				// TODO Auto-generated method stub
				MaterialMultiWordSuggestion select = (MaterialMultiWordSuggestion)event.getSelectedItem();
				selectNuevo = select.getMatConstruccion();
				
			}
		});
		label_2a.setStyleName("label");
		
		final TextBox textBox_2b = new TextBox();
		textBox_2b.setStyleName("gwt-TextBox2");
		textBox_2b.setMaxLength(100);
		absolutePanel.add(textBox_2b, 242, 108);
		textBox_2b.setSize("169px", "20px");

		Button button_2a = new Button("Agregar Material");
		button_2a.setText("Agregar Material");
		button_2a.setStylePrimaryName("gwt-TextBox2");
		button_2a.setStyleName("gwt-TextBox2");
		absolutePanel.add(button_2a, 451, 108);
		button_2a.setSize("134px", "22px");
		
		
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
		
		Label lblCantidad = new Label("Cantidad");
		lblCantidad.setStyleName("label");
		absolutePanel.add(lblCantidad, 242, 86);
		lblCantidad.setSize("207px", "16px");
		
		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel.add(absolutePanel_1, 0, 0);
		absolutePanel_1.setStyleName("panelMenu");
		absolutePanel_1.setSize("631px", "74px");
		
		Label label = new Label("Nombre Plantilla");
		absolutePanel_1.add(label, 10, 10);
		label.setStyleName("label");
		label.setSize("157px", "13px");
		label.setStyleName("label");
		label.setSize("157px", "13px");
		
			
			
			Label label_1 = new Label("Tipo");
			absolutePanel_1.add(label_1, 242, 10);
			label_1.setStyleName("label");
			label_1.setSize("192px", "13px");
			

			final TextBox textBox_1 = new TextBox();
			absolutePanel_1.add(textBox_1, 247, 29);
			textBox_1.setStyleName("gwt-TextBox2");
			textBox_1.setMaxLength(100);
			textBox_1.setSize("227px", "19px");
			
			SuggestBox selectPlantilla = new SuggestBox(plantilla);
			absolutePanel_1.add(selectPlantilla, 10, 29);
			selectPlantilla.setSize("196px", "16px");
			
			selectPlantilla.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
				
				@Override
				public void onSelection(SelectionEvent<Suggestion> event) {
					// TODO Auto-generated method stub
					PlantillaMultiWordSuggestion select = (PlantillaMultiWordSuggestion)event.getSelectedItem();
					textBox_1.setText(select.getPlantillaSolucion().getTipo());
					e.grid.ActualizarList();
					e.grid.setDataList(select.getPlantillaSolucion().getListaDetalle());
					costoAcumulado = select.getPlantillaSolucion().getCostoFinal();
				}
			});
			
	//--------------------------------------	
			
			Button button = new Button("Send");
			absolutePanel_1.add(button, 487, 27);
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					

					
					/*if (!textBox_1.getText().equals("")){

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
					
	        	//Window.alert("Datos Almacenados Correctamente ");  

					}
					else{
					Window.alert("Debe completar el formulario");
					} */
				}
			});		
			
					button.setText("Update Archivo");
					button.setStylePrimaryName("gwt-TextBox2");
					button.setStyleName("gwt-TextBox2");
					button.setSize("134px", "23px");
			
			AbsolutePanel absolutePanel_2 = new AbsolutePanel();
			absolutePanel_2.setStyleName("panelMenu");
			absolutePanel.add(absolutePanel_2, 643, 0);
			absolutePanel_2.setSize("259px", "129px");
			
			Label lblNombreBeneficiario = new Label("Nombre Beneficiario");
			absolutePanel_2.add(lblNombreBeneficiario);
			lblNombreBeneficiario.setStyleName("label");
			lblNombreBeneficiario.setSize("157px", "13px");
			
			final SuggestBox suggestBox_1 = new SuggestBox(bene);
			absolutePanel_2.add(suggestBox_1, 10, 19);
			suggestBox_1.setSize("234px", "16px");
			

			
			Label lblDireccion = new Label("Direccion");
			lblDireccion.setStyleName("label");
			absolutePanel_2.add(lblDireccion, 0, 45);
			lblDireccion.setSize("157px", "13px");
			
			final TextBox textBox = new TextBox();
			textBox.setStyleName("gwt-TextBox2");
			textBox.setMaxLength(100);
			absolutePanel_2.add(textBox, 19, 64);
			textBox.setSize("227px", "19px");
			
			Label lblAfiliado = new Label("Afiliado");
			lblAfiliado.setStyleName("label");
			absolutePanel_2.add(lblAfiliado, 0, 90);
			lblAfiliado.setSize("157px", "13px");
			
			final TextBox textBox_2 = new TextBox();
			textBox_2.setStyleName("gwt-TextBox2");
			textBox_2.setMaxLength(100);
			absolutePanel_2.add(textBox_2, 19, 109);
			textBox_2.setSize("227px", "19px");
			
			AbsolutePanel absolutePanel_3 = new AbsolutePanel();
			absolutePanel.add(absolutePanel_3, 914, 0);
			absolutePanel_3.setSize("387px", "130px");
			
			Label lblMontoAutorizado = new Label("Monto Autorizado");
			lblMontoAutorizado.setStyleName("label");
			absolutePanel_3.add(lblMontoAutorizado, 10, 10);
			lblMontoAutorizado.setSize("157px", "13px");
			
			TextBox textBox_3 = new TextBox();
			textBox_3.setStyleName("gwt-TextBox2");
			textBox_3.setMaxLength(100);
			absolutePanel_3.add(textBox_3, 173, 10);
			textBox_3.setSize("176px", "19px");
			
			TextBox textBox_4 = new TextBox();
			textBox_4.setStyleName("gwt-TextBox2");
			textBox_4.setMaxLength(100);
			absolutePanel_3.add(textBox_4, 173, 37);
			textBox_4.setSize("176px", "19px");
			
			Label lblDiferencia = new Label("Diferencia");
			lblDiferencia.setStyleName("label");
			absolutePanel_3.add(lblDiferencia, 10, 37);
			lblDiferencia.setSize("157px", "13px");
			
			Button btnAsignarSolucion = new Button("Asignar Solucion");
			btnAsignarSolucion.setText("Asignar Solucion");
			btnAsignarSolucion.setStylePrimaryName("gwt-TextBox2");
			btnAsignarSolucion.setStyleName("gwt-TextBox2");
			absolutePanel_3.add(btnAsignarSolucion, 217, 86);
			btnAsignarSolucion.setSize("134px", "22px");
			
			suggestBox_1.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
				
				@Override
				public void onSelection(SelectionEvent<Suggestion> event) {
					// TODO Auto-generated method stub
					BeneficiarioMultiWordSuggestion select = (BeneficiarioMultiWordSuggestion)event.getSelectedItem();
					selectNuevoBene = select.getAfiliado();
					textBox.setText(selectNuevoBene.getDirBeneficiario());
					textBox_2.setText(selectNuevoBene.getAfiliado().getNomAfiliado());
				}
			});
			
			AbsolutePanel absolutePanel_4 = new AbsolutePanel();
			absolutePanel_4.setStyleName("gwt-Label-new");
			absolutePanel_4.setSize("100px", "500px");
			grid.setWidget(1, 1, absolutePanel_4);
			
			Button eliminar = new Button("Agregar Material");
			eliminar.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					e.grid.EliminarFila();
					costoAcumulado = e.grid.ActualizarTabla();
				}
			});
			eliminar.setText("Eliminar Material");
			eliminar.setStylePrimaryName("gwt-TextBox2");
			eliminar.setStyleName("gwt-TextBox2");
			absolutePanel_4.add(eliminar,0,10);
			eliminar.setSize("145px", "38px");
			
	        Column<AuxDetallePlantillaSolucion, String> nomParamColumn = (Column<AuxDetallePlantillaSolucion, String>) e.grid.dataGrid.getColumn(4);
	        
	        nomParamColumn.setFieldUpdater(new FieldUpdater<AuxDetallePlantillaSolucion, String>() {
				@Override
				public void update(int index, AuxDetallePlantillaSolucion object, String value) {
					
					object.setPrecioUnit(Double.valueOf(value));
					object.setSubTotal(object.getCantidad() * Double.valueOf(value));
					costoAcumulado = e.grid.ActualizarTabla();
				}
	        	});
	}
}
