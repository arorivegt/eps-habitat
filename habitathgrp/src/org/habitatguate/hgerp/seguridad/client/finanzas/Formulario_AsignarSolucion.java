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
    //public AuxSolicitudGeneral selectNuevoBene = null;
    public AuxBeneficiario selectNuevoBene = null;
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
		
	/*	solucionesService.buscarFormulario('7', 0L, 0l, "FINANZAS", "", 
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
				);*/

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
			absolutePanel_2.setSize("259px", "150px");
			
			Label lblNombreBeneficiario = new Label("Nombre Beneficiario");
			absolutePanel_2.add(lblNombreBeneficiario);
			lblNombreBeneficiario.setStyleName("label");
			lblNombreBeneficiario.setSize("157px", "13px");
			
			final SuggestBox suggestBox_1 = new SuggestBox(bene);
			absolutePanel_2.add(suggestBox_1, 10, 19);
			suggestBox_1.setSize("234px", "16px");
			

			
			Label lblDireccion = new Label("Departamento de Solución");
			lblDireccion.setStyleName("label");
			absolutePanel_2.add(lblDireccion, 0, 45);
			lblDireccion.setSize("157px", "13px");
			
			/*final TextBox textBox = new TextBox();
			textBox.setStyleName("gwt-TextBox2");
			textBox.setMaxLength(100);
			absolutePanel_2.add(textBox, 19, 64);
			textBox.setSize("227px", "19px");*/
			
			final ListBox listBox_2 = new ListBox();
			listBox_2.setStyleName("gwt-TextBox2");
			absolutePanel_2.add(listBox_2, 19, 75);
			listBox_2.setSize("227px", "23px");
			
			listBox_2.addItem("[Select Departamento]","0");
			listBox_2.addItem("Guatemala","01");
			listBox_2.addItem("Baja Verapaz","15");
			listBox_2.addItem("Alta Verapaz","16");
			listBox_2.addItem("El Progreso","02");
			listBox_2.addItem("Izabal","18");
			listBox_2.addItem("Zacapa","19");
			listBox_2.addItem("Chiquimula","20");
			listBox_2.addItem("Santa Rosa","06");
			listBox_2.addItem("Jalapa","21");
			listBox_2.addItem("Jutiapa","22");
			listBox_2.addItem("Sacatepequez","03");
			listBox_2.addItem("Chimaltenango","04");
			listBox_2.addItem("Escuintla","05");
			listBox_2.addItem("Solola","07");
			listBox_2.addItem("Totonicapan","08");
			listBox_2.addItem("Quezaltenango","09");
			listBox_2.addItem("Suchitepequez","10");
			listBox_2.addItem("Retalhuleu","11");
			listBox_2.addItem("San Marcos","12");
			listBox_2.addItem("Huehuetenango","13");
			listBox_2.addItem("Quiche","14");
			listBox_2.addItem("Peten","17");
			
			
			
			Label lblAfiliado = new Label("Municipio de Solución");
			lblAfiliado.setStyleName("label");
			absolutePanel_2.add(lblAfiliado, 0, 100);
			lblAfiliado.setSize("157px", "13px");
			
			/*final TextBox textBox_2 = new TextBox();
			textBox_2.setStyleName("gwt-TextBox2");
			textBox_2.setMaxLength(100);
			absolutePanel_2.add(textBox_2, 19, 109);
			textBox_2.setSize("227px", "19px");*/
			
			final ListBox listBox_3 = new ListBox();
			listBox_3.setStyleName("gwt-TextBox2");
			absolutePanel_2.add(listBox_3, 19, 118);
			listBox_3.setSize("227px", "23px");
			listBox_3.addItem("[Select Municipio]","0");
			
			
			listBox_2.addChangeHandler(new ChangeHandler() {
				public void onChange(ChangeEvent event) {
					listBox_3.clear();
					listBox_3.addItem("[Select Municipio]","0");
			        String[] numerosComoArray = Depto_Municipio(listBox_2.getItemText(listBox_2.getSelectedIndex())).split(",");
			        int correlativo = Integer.parseInt(listBox_2.getValue(listBox_2.getSelectedIndex())+"01");
			        for (int i = 1; i < numerosComoArray.length; i++) {
			        	listBox_3.addItem(numerosComoArray[i],String.valueOf(correlativo));
			        	correlativo++;
			        }

				}
			});
			
			
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
			//textBox_3.setEnabled(false);
			
			
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
					//textBox.setText(selectNuevoBene.getDireccionActual());
					//textBox_2.setText(selectNuevoBene.getDireccionSolucion());
					//textBox_3.setText(""+selectNuevoBene.getMontoAprobado());
					//double dif = Double.valueOf(textBox_3.getText()) - costoAcumulado; 
					//textBox_4.setText(" " +dif);
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
					/*loginService.Insertar_Bene(selectNuevoBene.getNombreSolicitante(),selectNuevoBene.getDireccionSolucion(), selectNuevoBene.getTelefonoCasaSolicitante(),selectNuevoBene.getIdFormulario(),
							selectNuevoBene.getNumDpi(),
							new AsyncCallback<Long>(){
						@Override		
		                public void onFailure(Throwable caught) 
		                {
		                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
		                }

						@Override
		                public void onSuccess(Long result)
		                {	*/		
							System.out.println("Solicitud que se va inclur" + selectNuevoBene.getIdBeneficiario());
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
							/*String ubicacion = selectNuevoBene.getDirBeneficiario();
							String[] ubicaciones = ubicacion.split(",");*/
							AuxBeneficiario auxBene = new AuxBeneficiario();
							/*auxS.setDepartamentoSolucion(ubicaciones[0]);
							auxS.setMunicipioSolucion(ubicaciones[1]);*/
							//auxBene.setIdBeneficiario(result);
							auxS.setDepartamentoSolucion(listBox_2.getValue(listBox_2.getSelectedIndex()));
							auxS.setMunicipioSolucion(listBox_3.getValue(listBox_3.getSelectedIndex()));
							auxBene.setIdBeneficiario(selectNuevoBene.getIdBeneficiario());
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
		      /*          }

		         });*/
					
					
					

					
				}
			});
	}
	
	
	 /**
		 * metodo para obtener los municipios del departamento entrante
		 * @param Departamento
		 * @return
		 */
		private String Depto_Municipio(String Departamento){
			
			String valor = "";
			if(Departamento.equals("Guatemala")){	
				
				valor = valor + "," + "Guatemala";
				valor = valor + "," + "Santa Catarina Pinula";
				valor = valor + "," + "San Jose Pinula";
				valor = valor + "," + "San Jose del Golfo";
				valor = valor + "," + "Palencia";
				valor = valor + "," + "Chinautla";
				valor = valor + "," + "San Pedro Ayampuc";
				valor = valor + "," + "Mixco";
				valor = valor + "," + "San Pedro Sacatepequez";
				valor = valor + "," + "San Juan Sacatepequez";
				valor = valor + "," + "San Raymundo";
				valor = valor + "," + "Chuarrancho";
				valor = valor + "," + "Fraijanes";
				valor = valor + "," + "Amatitlan";
				valor = valor + "," + "Villa Nueva";
				valor = valor + "," + "Villa Canales";
				valor = valor + "," + "Petapa";
				
			}else if(Departamento.equals("Baja Verapaz")){
				valor = valor + "," + "Salama";
				valor = valor + "," + "San Miguel Chicaj";
				valor = valor + "," + "Rabinal";
				valor = valor + "," + "Cubulco";
				valor = valor + "," + "Granados";
				valor = valor + "," + "Santa Cruz el Chol";
				valor = valor + "," + "San Jeronimo";
				valor = valor + "," + "Purulha";
				
			}else if(Departamento.equals("Alta Verapaz")){
				valor = valor + "," + "Coban";
				valor = valor + "," + "Santa Cruz Verapaz";
				valor = valor + "," + "San Cristobal Verapaz";
				valor = valor + "," + "Tactic";
				valor = valor + "," + "Tamahu";
				valor = valor + "," + "Tucuru";
				valor = valor + "," + "Panzos";
				valor = valor + "," + "Senahu";
				valor = valor + "," + "San Pedro Carcha";
				valor = valor + "," + "San Juan Chamelco";
				valor = valor + "," + "Lanquin";
				valor = valor + "," + "Santa Maria Cahabon";
				valor = valor + "," + "Chisec";
				valor = valor + "," + "Chahal";
				valor = valor + "," + "Fray Bartolome de las Casas";
				valor = valor + "," + "La Tinta";
				valor = valor + "," + "Raxruha";
				
			}else if(Departamento.equals("El Progreso")){
				valor = valor + "," + "Guastatoya";
				valor = valor + "," + "Morazan";
				valor = valor + "," + "San Agustin Acasaguastlan";
				valor = valor + "," + "San Cristobal Acasaguastlan";
				valor = valor + "," + "El Jicaro";
				valor = valor + "," + "Sansare";
				valor = valor + "," + "Sanarate";
				valor = valor + "," + "San Antonio La Paz";
				
			}else if(Departamento.equals("Izabal")){
				valor = valor + "," + "Puerto Barrios";
				valor = valor + "," + "Livingston";
				valor = valor + "," + "El Estor";
				valor = valor + "," + "Morales";
				valor = valor + "," + "Los Amates";
				
			}else if(Departamento.equals("Zacapa")){
				valor = valor + "," + "Zacapa";
				valor = valor + "," + "Estanzuela";
				valor = valor + "," + "Rio Hondo";
				valor = valor + "," + "Gualan";
				valor = valor + "," + "Teculutan";
				valor = valor + "," + "Usumatlan";
				valor = valor + "," + "Cabañas";
				valor = valor + "," + "Huite";
				valor = valor + "," + "San Diego";
				valor = valor + "," + "La Union";
				valor = valor + "," + "Huite";
				
			}else if(Departamento.equals("Chiquimula")){

				valor = valor + "," + "Chiquimula";
				valor = valor + "," + "San Jose la Arada";
				valor = valor + "," + "San Juan Ermita";
				valor = valor + "," + "Jocotan";
				valor = valor + "," + "Camotan";
				valor = valor + "," + "Olopa";
				valor = valor + "," + "Esquipulas";
				valor = valor + "," + "Concepcion Las Minas";
				valor = valor + "," + "Quezaltepeque";
				valor = valor + "," + "San Jacinto";
				valor = valor + "," + "Ipala";
				
			}else if(Departamento.equals("Santa Rosa")){
				valor = valor + "," + "Cuilapa";
				valor = valor + "," + "Barberena";
				valor = valor + "," + "Santa Rosa de Lima";
				valor = valor + "," + "Casillas";
				valor = valor + "," + "San Rafael las Flores";
				valor = valor + "," + "Oratorio";
				valor = valor + "," + "San Juan Tecuaco";
				valor = valor + "," + "Chiquimulilla";
				valor = valor + "," + "Taxisco";
				valor = valor + "," + "Santa Maria Ixhuatan";
				valor = valor + "," + "Guazacapan";
				valor = valor + "," + "Santa Cruz Naranjo";
				valor = valor + "," + "Pueblo Nuevo Viñas";
				valor = valor + "," + "Nueva Santa Rosa";
				
			}else if(Departamento.equals("Jalapa")){
				valor = valor + "," + "Jalapa";
				valor = valor + "," + "San Pedro Pinula";
				valor = valor + "," + "San Luis Jilotepeque";
				valor = valor + "," + "San Manuel Chaparron";
				valor = valor + "," + "San Carlos Alzatate";
				valor = valor + "," + "Monjas";
				valor = valor + "," + "Mataquescuintla";
				
			}else if(Departamento.equals("Jutiapa")){
				valor = valor + "," + "Jutiapa";
				valor = valor + "," + "El Progreso";
				valor = valor + "," + "Santa Catarina Mita";
				valor = valor + "," + "Agua Blanca";
				valor = valor + "," + "Asuncion Mita";
				valor = valor + "," + "Yupiltepeque";
				valor = valor + "," + "Atescatempa";
				valor = valor + "," + "Jerez";
				valor = valor + "," + "El Adelanto";
				valor = valor + "," + "Zapotitlan";
				valor = valor + "," + "Comapa";
				valor = valor + "," + "Jalpatagua";
				valor = valor + "," + "Conguaco";
				valor = valor + "," + "Moyuta";
				valor = valor + "," + "Pasaco";
				valor = valor + "," + "San Jose Acatempa";
				valor = valor + "," + "Quesada";
				
			}else if(Departamento.equals("Sacatepequez")){
				valor = valor + "," + "La Antigua Guatemala";
				valor = valor + "," + "Jocotenango";
				valor = valor + "," + "Pastores";
				valor = valor + "," + "Sumpango";
				valor = valor + "," + "Santo Domingo Xenacoj";
				valor = valor + "," + "Santiago Sacatepequez";
				valor = valor + "," + "San Bartolome Milpas Altas";
				valor = valor + "," + "San Lucas Sacatepequez";
				valor = valor + "," + "Santa Lucia Milpas Altas";
				valor = valor + "," + "Magdalena Milpas Altas";
				valor = valor + "," + "Santa Maria de Jesus";
				valor = valor + "," + "Ciudad Vieja";
				valor = valor + "," + "San Miguel Dueñas";
				valor = valor + "," + "Alotenango";
				valor = valor + "," + "San Antonio Aguas Calientes";
				valor = valor + "," + "Santa Catarina Barahona";
				
			}else if(Departamento.equals("Chimaltenango")){
				valor = valor + "," + "Chimaltenango";
				valor = valor + "," + "San Jose Poaquil";
				valor = valor + "," + "San Martin Jilotepeque";
				valor = valor + "," + "San Juan Comalapa";
				valor = valor + "," + "Santa Apolonia";
				valor = valor + "," + "Tecpan";
				valor = valor + "," + "Patzun";
				valor = valor + "," + "Pochuta";
				valor = valor + "," + "Patzicia";
				valor = valor + "," + "Santa Cruz Balanya";
				valor = valor + "," + "Acatenango";
				valor = valor + "," + "Yepocapa";
				valor = valor + "," + "San Andres Itzapa";
				valor = valor + "," + "Parramos";
				valor = valor + "," + "Zaragoza";
				valor = valor + "," + "El Tejar";
				
			}else if(Departamento.equals("Escuintla")){			
				valor = valor + "," + "Escuintla";
				valor = valor + "," + "Santa Lucia Cotzumalguapa";
				valor = valor + "," + "La Democracia";
				valor = valor + "," + "Siquinala";
				valor = valor + "," + "Masagua";
				valor = valor + "," + "Tiquisate";
				valor = valor + "," + "La Gomera";
				valor = valor + "," + "Guanagazapa";
				valor = valor + "," + "San Jose";
				valor = valor + "," + "Iztapa";
				valor = valor + "," + "Palin";
				valor = valor + "," + "San Vicente Pacaya";
				valor = valor + "," + "Nueva Concepcion";
				
			}else if(Departamento.equals("Solola")){
				valor = valor + "," + "Solola";
				valor = valor + "," + "San Jose Chacaya";
				valor = valor + "," + "Santa Maria Visitacion";
				valor = valor + "," + "Santa Lucia Utatlan";
				valor = valor + "," + "Nahuala";
				valor = valor + "," + "Santa Catarina Ixtahuacan";
				valor = valor + "," + "Santa Clara La Laguna";
				valor = valor + "," + "Concepcion";
				valor = valor + "," + "San Andres Semetabaj";
				valor = valor + "," + "Panajachel";
				valor = valor + "," + "Santa Catarina Palopo";
				valor = valor + "," + "San Antonio Palopo";
				valor = valor + "," + "San Lucas Toliman";
				valor = valor + "," + "Santa Cruz La Laguna";
				valor = valor + "," + "San Pablo La Laguna";
				valor = valor + "," + "San Juan La Laguna";
				valor = valor + "," + "San Marcos La Laguna";
				valor = valor + "," + "San Pedro La Laguna";
				valor = valor + "," + "Santiago Atitlan";
				
			}else if(Departamento.equals("Totonicapan")){
				valor = valor + "," + "Totonicapan";
				valor = valor + "," + "San Cristobal Totonicapan";
				valor = valor + "," + "San Francisco El Alto";
				valor = valor + "," + "San Andres Xecul";
				valor = valor + "," + "Momostenango";
				valor = valor + "," + "Santa Maria Chiquimula";
				valor = valor + "," + "Santa Lucia La Reforma";
				valor = valor + "," + "San Bartolo";
				
			}else if(Departamento.equals("Quezaltenango")){
				valor = valor + "," + "Quetzaltenango";
				valor = valor + "," + "Salcaja";
				valor = valor + "," + "Olintepeque";
				valor = valor + "," + "San Carlos Sija";
				valor = valor + "," + "Sibilia";
				valor = valor + "," + "Cabrican";
				valor = valor + "," + "Cajola";
				valor = valor + "," + "San Miguel Sigüila";
				valor = valor + "," + "San Juan Ostuncalco";
				valor = valor + "," + "San Mateo";
				valor = valor + "," + "Concepcion Chiquirichapa";
				valor = valor + "," + "San Martin Sacatepequez";
				valor = valor + "," + "Almolonga";
				valor = valor + "," + "Cantel";
				valor = valor + "," + "Huitan";
				valor = valor + "," + "Zunil";
				valor = valor + "," + "Colomba Costa Cuca";
				valor = valor + "," + "San Francisco La Union";
				valor = valor + "," + "El Palmar";
				valor = valor + "," + "Coatepeque";
				valor = valor + "," + "Genova";
				valor = valor + "," + "Flores Costa Cuca";
				valor = valor + "," + "La Esperanza";
				valor = valor + "," + "Palestina de Los Altos";
				
			}else if(Departamento.equals("Suchitepequez")){
				valor = valor + "," + "Mazatenango";
				valor = valor + "," + "Cuyotenango";
				valor = valor + "," + "San Francisco Zapotitlan";
				valor = valor + "," + "San Bernardino";
				valor = valor + "," + "San Jose El Idolo";
				valor = valor + "," + "Santo Domingo Suchitepequez";
				valor = valor + "," + "San Lorenzo";
				valor = valor + "," + "Samayac";
				valor = valor + "," + "San Pablo Jocopilas";
				valor = valor + "," + "San Antonio Suchitepequez";
				valor = valor + "," + "San Miguel Panan";
				valor = valor + "," + "San Gabriel";
				valor = valor + "," + "Chicacao";
				valor = valor + "," + "Patulul";
				valor = valor + "," + "Santa Barbara";
				valor = valor + "," + "San Juan Bautista";
				valor = valor + "," + "Santo Tomas La Union";
				valor = valor + "," + "Zunilito";
				valor = valor + "," + "Pueblo Nuevo";
				valor = valor + "," + "Rio Bravo";
				
			}else if(Departamento.equals("Retalhuleu")){
				valor = valor + "," + "Retalhuleu";
				valor = valor + "," + "San Sebastian";
				valor = valor + "," + "Santa Cruz Mulua";
				valor = valor + "," + "San Martin Zapotitlan";
				valor = valor + "," + "San Felipe";
				valor = valor + "," + "San Andres Villa Seca";
				valor = valor + "," + "Champerico";
				valor = valor + "," + "Nuevo San Carlos";
				valor = valor + "," + "El Asintal";
				
			}else if(Departamento.equals("San Marcos")){
				valor = valor + "," + "San Marcos";
				valor = valor + "," + "San Pedro Sacatepequez";
				valor = valor + "," + "San Antonio Sacatepequez";
				valor = valor + "," + "Comitancillo";
				valor = valor + "," + "San Miguel Ixtahuacan";
				valor = valor + "," + "Concepcion Tutuapa";
				valor = valor + "," + "Tacana";
				valor = valor + "," + "Sibinal";
				valor = valor + "," + "Tajumulco";
				valor = valor + "," + "Tejutla";
				valor = valor + "," + "San Rafael Pie de la Cuesta";
				valor = valor + "," + "Nuevo Progreso";
				valor = valor + "," + "El Tumbador";
				valor = valor + "," + "San Jose El Rodeo";
				valor = valor + "," + "Malacatan";
				valor = valor + "," + "Catarina";
				valor = valor + "," + "Ayutla";
				valor = valor + "," + "Ocos";
				valor = valor + "," + "San Pablo";
				valor = valor + "," + "El Quetzal";
				valor = valor + "," + "La Reforma";
				valor = valor + "," + "Pajapita";
				valor = valor + "," + "Ixchiguan";
				valor = valor + "," + "San Jose Ojetenam";
				valor = valor + "," + "San Cristobal Cucho";
				valor = valor + "," + "Sipacapa";
				valor = valor + "," + "Esquipulas Palo Gordo";
				valor = valor + "," + "Rio Blanco";
				valor = valor + "," + "San Lorenzo";
				
			}else if(Departamento.equals("Huehuetenango")){
				valor = valor + "," + "Huehuetenango";
				valor = valor + "," + "Chiantla";
				valor = valor + "," + "Malacatancito";
				valor = valor + "," + "Cuilco";
				valor = valor + "," + "Nenton";
				valor = valor + "," + "San Pedro Necta";
				valor = valor + "," + "Jacaltenango";
				valor = valor + "," + "San Pedro Soloma";
				valor = valor + "," + "San Ildefonso Ixtahuacan";
				valor = valor + "," + "Santa Barbara";
				valor = valor + "," + "La Libertad";
				valor = valor + "," + "La Democracia";
				valor = valor + "," + "San Miguel Acatan";
				valor = valor + "," + "San Rafael La Independencia";
				valor = valor + "," + "Santos Cuchumatan";
				valor = valor + "," + "San Juan Atitan";
				valor = valor + "," + "Santa Eulalia";
				valor = valor + "," + "San Mateo Ixtatan";
				valor = valor + "," + "Colotenango";
				valor = valor + "," + "San Sebastian Huehuetenango";
				valor = valor + "," + "Tectitan";
				valor = valor + "," + "Concepcion Huista";
				valor = valor + "," + "San Juan Ixcoy";
				valor = valor + "," + "San Antonio Huista";
				valor = valor + "," + "San Sebastian Coatan";
				valor = valor + "," + "Santa Cruz Barillas";
				valor = valor + "," + "Aguacatan";
				valor = valor + "," + "San Rafael Petzal";
				valor = valor + "," + "San Gaspar Ixchil";
				valor = valor + "," + "Santiago Chimaltenango";
				valor = valor + "," + "Santa Ana Huista";
				valor = valor + "," + "Union Cantinil";
				
			}else if(Departamento.equals("Quiche")){
				valor = valor + "," + "Santa Cruz del Quiche";
				valor = valor + "," + "Chiche";
				valor = valor + "," + "Chinique";
				valor = valor + "," + "Zacualpa";
				valor = valor + "," + "Chajul";
				valor = valor + "," + "Chichicastenango";
				valor = valor + "," + "Patzite";
				valor = valor + "," + "San Antonio Ilotenango";
				valor = valor + "," + "San Pedro Jocopilas";
				valor = valor + "," + "Cunen";
				valor = valor + "," + "San Juan Cotzal";
				valor = valor + "," + "Joyabaj";
				valor = valor + "," + "Nebaj";
				valor = valor + "," + "San Andres Sajcabaja";
				valor = valor + "," + "Uspantan";
				valor = valor + "," + "Sacapulas";
				valor = valor + "," + "San Bartolome Jocotenango";
				valor = valor + "," + "Canilla";
				valor = valor + "," + "Chicaman";
				valor = valor + "," + "Ixcan";
				valor = valor + "," + "Pachalum";
				
			}else if(Departamento.equals("Peten")){
				valor = valor + "," + "Flores";
				valor = valor + "," + "San Jose";
				valor = valor + "," + "San Benito";
				valor = valor + "," + "San Andres";
				valor = valor + "," + "La Libertad";
				valor = valor + "," + "San Francisco";
				valor = valor + "," + "Santa Ana";
				valor = valor + "," + "Dolores";
				valor = valor + "," + "San Luis";
				valor = valor + "," + "Sayaxche";
				valor = valor + "," + "Melchor de Mencos";
				valor = valor + "," + "Poptun";
				
			}else if(Departamento.equals("-")){
				valor = valor + "," + "-";
			}
		
			return valor;
		}
	
	
}
