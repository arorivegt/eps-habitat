package org.habitatguate.hgerp.seguridad.client.finanzas;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class Formulario_AsignarSolucion extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
    TablaGWT_PlantillaSolucion e = null;
    
    public AuxMaterialCostruccion selectNuevo = null;
    public AuxSolicitudGeneral selectNuevoBene = null;
    public AuxPlantillaSolucion selectPlant = null;
    public double costoAcumulado = 0;
    public Long idSolucionAlmacenado = 0L;
    public Long correlativo = (long) 1; 
    public boolean banderaTimer = false;
    public boolean banderaWhile = false;
    public int index = 0;
    

    
    /*Timer timer = new Timer() {
        public void run() {
        	Iterator<AuxDetallePlantillaSolucion> i = e.grid.getListMateriales().iterator();
			while (i.hasNext() && banderaTimer == false){
					AuxDetallePlantillaSolucion aux = i.next();
					loginService.Insertar_UnicoDetalleSolucion(idSolucionAlmacenado,aux,
        			new AsyncCallback<Long>() {

						@Override
						public void onFailure(Throwable caught) {
							System.err.println(caught);
							
						}

						@Override
						public void onSuccess(Long result) {

							
						}
        		
					});
			}
			
			Window.alert("Solucion asignada Correctamente");
			e.grid.ActualizarList();
		    costoAcumulado = 0;
		    idSolucionAlmacenado = 0L;
		    selectNuevo = null;
		    selectNuevoBene = null;
		    selectPlant = null;
		    correlativo = (long) 1; 
        }
      };*/
	
	public Formulario_AsignarSolucion(){
		/*Timer timer = new Timer() {
        public void run() {
        	Iterator<AuxDetallePlantillaSolucion> i = e.grid.getListMateriales().iterator();
			while (i.hasNext() && banderaTimer == false){
					AuxDetallePlantillaSolucion aux = i.next();
					loginService.Insertar_UnicoDetalleSolucion(idSolucionAlmacenado,aux,
        			new AsyncCallback<Long>() {

						@Override
						public void onFailure(Throwable caught) {
							System.err.println(caught);
							
						}

						@Override
						public void onSuccess(Long result) {

							
						}
        		
					});
			}
			
			Window.alert("Solucion asignada Correctamente");
			e.grid.ActualizarList();
		    costoAcumulado = 0;
		    idSolucionAlmacenado = 0L;
		    selectNuevo = null;
		    selectNuevoBene = null;
		    selectPlant = null;
		    correlativo = (long) 1; 
        }
      };*/
		final Timer timer = new Timer() {
	        public void run() {
       			if (index < e.grid.getListMateriales().size()){
						AuxDetallePlantillaSolucion aux = e.grid.getListMateriales().get(index);
						loginService.Insertar_UnicoDetalleSolucion(idSolucionAlmacenado,aux,
	        			new AsyncCallback<Long>() {

							@Override
							public void onFailure(Throwable caught) {
								System.err.println(caught);
								
							}

							@Override
							public void onSuccess(Long result) {
								index++;
								
							}
	        		
						});
       			}
       			else{
       				Window.alert("Solucion asignada Correctamente");
       				e.grid.ActualizarList();
       			    costoAcumulado = 0;
       			    idSolucionAlmacenado = 0L;
       			    selectNuevo = null;
       			    selectNuevoBene = null;
       			    selectPlant = null;
       			    correlativo = (long) 1; 
    				this.cancel();
       			}
				

	        }
	      };
		
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
		
	/*	loginService.ConsultaTodosBene(new AsyncCallback<List<AuxBeneficiario>>() {
			
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
		});*/
		
		solucionesService.buscarFormulario('7', 0L, 0l, "FINANZAS", "", 
		new AsyncCallback<List<AuxSolicitudGeneral>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<AuxSolicitudGeneral> result) {
				// TODO Auto-generated method stub
				if (!result.isEmpty()){
					for (AuxSolicitudGeneral p : result){
						bene.add(new BeneficiarioMultiWordSuggestion(p));	
					}
				}
			}
		}
				);

		//------------------------------primera fila
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		final SuggestBox suggestbox = new SuggestBox(oracle);
	    
		
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1241px", "110px");
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
		button_2a.setStyleName("finanButton");
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
				nuevoElemento.setMaterialCostruccion(selectNuevo);
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
					selectPlant = select.getPlantillaSolucion();
					e.grid.ActualizarList();
					e.grid.setDataList(select.getPlantillaSolucion().getListaDetalle());
					costoAcumulado = select.getPlantillaSolucion().getCostoFinal();
				}
			});
			
	//--------------------------------------	
			
	/*		Button button = new Button("Send");
			absolutePanel_1.add(button, 487, 27);
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {

				}
			});		
			
					button.setText("Update Archivo");
					button.setStyleName("finanButton");
					button.setSize("134px", "23px");*/
			
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
			
			Label lblAfiliado = new Label("Dirección Solución");
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
			absolutePanel_3.setSize("387px", "160px");
			
			
			Label lblTrimestre = new Label("Trimestre");
			lblTrimestre.setStyleName("label");
			absolutePanel_3.add(lblTrimestre, 10, 10);
			lblTrimestre.setSize("157px", "13px");
			
			final ListBox listTrimestre = new ListBox();
			absolutePanel_3.add(listTrimestre,173,10);
			listTrimestre.setSize("157px", "25px");
			listTrimestre.addItem("Enero a Marzo", "1");
			listTrimestre.addItem("Abril a Junio", "2");
			listTrimestre.addItem("Julio a Septiembre", "3");
			listTrimestre.addItem("Octubre a Diciembre", "4");
						
			Label lblMontoAutorizado = new Label("Monto Autorizado");
			lblMontoAutorizado.setStyleName("label");
			absolutePanel_3.add(lblMontoAutorizado, 10, 40);
			lblMontoAutorizado.setSize("157px", "13px");
			
			final TextBox textBox_3 = new TextBox();
			textBox_3.setStyleName("gwt-TextBox2");
			textBox_3.setMaxLength(100);
			absolutePanel_3.add(textBox_3, 173, 40);
			textBox_3.setSize("176px", "19px");
			textBox_3.setEnabled(false);
			
			
			final TextBox textBox_4 = new TextBox();
			textBox_4.setStyleName("gwt-TextBox2");
			textBox_4.setMaxLength(100);
			absolutePanel_3.add(textBox_4, 173, 95);
			textBox_4.setSize("176px", "19px");
			textBox_4.setEnabled(false);
			
			Label lblAdmin = new Label("Costo Administrativo");
			lblAdmin.setStyleName("label");
			absolutePanel_3.add(lblAdmin, 10, 65);
			lblAdmin.setSize("157px", "13px");
			
			final ListBox listaCostoAdmin = new ListBox();
			absolutePanel_3.add(listaCostoAdmin,173,65);
			listaCostoAdmin.setSize("50px", "25px");
			listaCostoAdmin.addItem("[%]","-1");
			listaCostoAdmin.addItem("7%","7");
			listaCostoAdmin.addItem("6.5%","6.5");
			listaCostoAdmin.addItem("6%","6");
			listaCostoAdmin.addItem("5.5%","5.5");
			listaCostoAdmin.addItem("5%","5");
			listaCostoAdmin.addItem("4.5%","4.5");
			listaCostoAdmin.addItem("4%","4");
			listaCostoAdmin.addItem("3.5%","3.5");
			listaCostoAdmin.addItem("3%","3");
			listaCostoAdmin.addItem("2.5%","2.5");
			listaCostoAdmin.addItem("2%","2");
			listaCostoAdmin.addItem("1.5%","1.5");
			listaCostoAdmin.addItem("1%","1");
			listaCostoAdmin.addItem("0.5%","0.5");
			listaCostoAdmin.addItem("0%","0");
			
						
			final TextBox textAdmin = new TextBox();
			textAdmin.setStyleName("gwt-TextBox2");
			textAdmin.setMaxLength(100);
			absolutePanel_3.add(textAdmin, 220, 65);
			textAdmin.setSize("135px", "19px");
			textAdmin.setEnabled(false);
			
			Label lblDiferencia = new Label("Diferencia");
			lblDiferencia.setStyleName("label");
			absolutePanel_3.add(lblDiferencia, 10, 95);
			lblDiferencia.setSize("157px", "13px");
			
			listaCostoAdmin.addChangeHandler(new ChangeHandler() {

		 		@Override
				public void onChange(ChangeEvent event) {
		 			String opcion = listaCostoAdmin.getValue(listaCostoAdmin.getSelectedIndex());
		 			if (opcion.equals("-1")){
		 				textAdmin.setText("0.0");
		 			}else{
		 				double opcion2 = Double.valueOf(opcion);
		 				double calculo = Double.valueOf(textBox_3.getText())*(opcion2/100);
		 				//DecimalFormat df = new DecimalFormat("#.##");
		 				String formatted = NumberFormat.getFormat("##.##").format(calculo);
		 				textAdmin.setText(String.valueOf(formatted));
		 			}
				}
		    });

			
			Button btnAsignarSolucion = new Button("Asignar Solucion");
			btnAsignarSolucion.setText("Asignar Solucion");
			btnAsignarSolucion.setStyleName("finanButton");
			absolutePanel_3.add(btnAsignarSolucion, 217, 120);
			btnAsignarSolucion.setSize("134px", "22px");
			
			textBox_3.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					double dif = Double.valueOf(textBox_3.getText()) - costoAcumulado; 
					textBox_4.setText(" " +dif);
					
				}
			});
			
			suggestBox_1.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
				
				@Override
				public void onSelection(SelectionEvent<Suggestion> event) {
					// TODO Auto-generated method stub
					BeneficiarioMultiWordSuggestion select = (BeneficiarioMultiWordSuggestion)event.getSelectedItem();
					selectNuevoBene = select.getAfiliado();
					textBox.setText(selectNuevoBene.getDireccionActual());
					textBox_2.setText(selectNuevoBene.getDireccionSolucion());
					textBox_3.setText(""+selectNuevoBene.getMontoAprobado());
					double dif = Double.valueOf(textBox_3.getText()) - costoAcumulado; 
					textBox_4.setText(" " +dif);
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
			eliminar.setStyleName("finanButton");
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
	        btnAsignarSolucion.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					loginService.Insertar_Bene(selectNuevoBene.getNombreSolicitante(),selectNuevoBene.getDireccionSolucion(), selectNuevoBene.getTelefonoCasaSolicitante(),selectNuevoBene.getIdFormulario(),
							selectNuevoBene.getNumDpi(),
							new AsyncCallback<Long>(){
						@Override		
		                public void onFailure(Throwable caught) 
		                {
		                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
		                }

						@Override
		                public void onSuccess(Long result)
		                {			
							System.out.println("Solicitud que se va inclur" + result);
							Date fecha = new Date();
							String formatted = DateTimeFormat.getFormat("yyyy").format(fecha);
							AuxSolucion auxS = new AuxSolucion();
							auxS.setNomSolucion(selectPlant.getNomPlantillaSolucion());
							auxS.setCostoAdministrativo(Double.valueOf(textAdmin.getText()));
							auxS.setCostoDirecto(0.0);
							auxS.setCostoMaterial(0.0);
							auxS.setCostoTotal(costoAcumulado);
							auxS.setDisenio(selectPlant.getTipo());
							auxS.setNotaDebito(0);
							auxS.setValorContrato(Double.valueOf(textBox_3.getText()));
							auxS.setTrimestre(Integer.valueOf(listTrimestre.getValue(listTrimestre.getSelectedIndex())));
							auxS.setAnio(Integer.valueOf(formatted));
							String ubicacion = selectNuevoBene.getDepartamentoMunicipioDireccionSolucion();
							String[] ubicaciones = ubicacion.split(",");
							AuxBeneficiario auxBene = new AuxBeneficiario();
							auxS.setDepartamentoSolucion(ubicaciones[0]);
							auxS.setMunicipioSolucion(ubicaciones[1]);
							auxBene.setIdBeneficiario(result);
							auxS.setBeneficiario(auxBene);
							loginService.Insertar_Solucion(auxS, costoAcumulado, new AsyncCallback<Long>() {
								
								@Override
								public void onSuccess(Long result) {
									idSolucionAlmacenado = result;
				        			index = 0;
				    				timer.scheduleRepeating(5000);
								}
								
								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}
							});
		                }

		         });
					
					
					

					
				}
			});
	}
}
