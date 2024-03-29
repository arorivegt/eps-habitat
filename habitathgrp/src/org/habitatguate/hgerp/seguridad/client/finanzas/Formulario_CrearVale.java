package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.util.ConvertDate;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.text.shared.Renderer;

public class Formulario_CrearVale extends Composite {
	
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    private final RecursosHumanosServiceAsync getSession = GWT.create(RecursosHumanosService.class);
    private AuxBeneficiario selectNuevoBene;
    private AuxSolucion selectSolucion;
    private Double costoAcumulado = 0.0;
    private Date fechaActual;
    public int index = 0;
    public int checkSelect = 0;
    TablaGWT_Vale e = null;


	public Formulario_CrearVale(final Long idAfiliadoSession, Long idEmpleadoSession){
		final long idEmpleado = idEmpleadoSession;
		final BeneNameSuggestOracle bene = new BeneNameSuggestOracle();
		final java.util.Date date= new java.util.Date();
		final Grid grid = new Grid(2, 2);
		initWidget(grid);
		grid.setWidth("1278px");
		 System.out.println(new Timestamp(date.getTime()));

				loginService.ConsultaTodosBene_PorAfiliado(idAfiliadoSession, new AsyncCallback<List<AuxBeneficiario>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(List<AuxBeneficiario> result) {
						// TODO Auto-generated method stub

						if (!result.isEmpty()){
							for (AuxBeneficiario p : result){
								bene.add(new BeneMultiWordSuggestion(p));
								System.out.println("Datos beneficiario:"+p.getNomBeneficiario()+" datos afiliado:"+p.getAfiliado().getIdAfiliado());
							}
						}else
						{
							System.out.println("No hay registros");
						}
						
					}
					

				});
				
			

	

		


		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1025px", "110px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		Label lblNombreBeneficiario = new Label("Nombre Beneficiario");
		lblNombreBeneficiario.setStyleName("label");
		absolutePanel.add(lblNombreBeneficiario, 10, 33);
		lblNombreBeneficiario.setSize("157px", "13px");
		
		final TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(100);
		absolutePanel.add(textBox, 538, 31);
		textBox.setSize("227px", "28px");
		
		final SuggestBox suggestBox = new SuggestBox(bene);
		absolutePanel.add(suggestBox, 173, 33);
		

		
		Label lblDatosBeneficiario = new Label("Datos Beneficiario");
		lblDatosBeneficiario.setStyleName("label");
		absolutePanel.add(lblDatosBeneficiario, 168, 10);
		lblDatosBeneficiario.setSize("157px", "13px");
		
		Label lblDatosSolucin = new Label("Datos Solución");
		lblDatosSolucin.setStyleName("label");
		absolutePanel.add(lblDatosSolucin, 538, 10);
		lblDatosSolucin.setSize("157px", "13px");
		
		Label lblNombreProveedor = new Label("Nombre Proveedor");
		lblNombreProveedor.setStyleName("label");
		absolutePanel.add(lblNombreProveedor, 10, 95);
		lblNombreProveedor.setSize("157px", "13px");
		
		Label lblDatosProveedor = new Label("Datos Proveedor");
		lblDatosProveedor.setStyleName("label");
		absolutePanel.add(lblDatosProveedor, 168, 76);
		lblDatosProveedor.setSize("157px", "13px");
		
		Label lblTipoSolucion = new Label("Tipo Solucion");
		lblTipoSolucion.setStyleName("label");
		absolutePanel.add(lblTipoSolucion, 387, 43);
		lblTipoSolucion.setSize("157px", "13px");
		
		Label lblDireccion = new Label("Direccion");
		lblDireccion.setStyleName("label");
		absolutePanel.add(lblDireccion, 387, 76);
		lblDireccion.setSize("157px", "13px");
		
		final TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(100);
		absolutePanel.add(textBox_1, 538, 59);
		textBox_1.setSize("227px", "28px");
		
		Label lblDatosVale = new Label("Datos Vale");
		lblDatosVale.setStyleName("label");
		absolutePanel.add(lblDatosVale, 908, 10);
		lblDatosVale.setSize("157px", "13px");
		
		final TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox2");
		textBox_2.setMaxLength(100);
		absolutePanel.add(textBox_2, 856, 31);
		textBox_2.setSize("227px", "28px");
		
		Label lblNoVale = new Label("No. Vale");
		lblNoVale.setStyleName("label");
		absolutePanel.add(lblNoVale, 773, 33);
		lblNoVale.setSize("76px", "13px");
		
		Label lblFecha = new Label("Fecha");
		lblFecha.setStyleName("label");
		absolutePanel.add(lblFecha, 773, 76);
		lblFecha.setSize("76px", "13px");
		
		Button button = new Button("Send");
		button.setText("Generar Vale");
		button.setStyleName("finanButton");
		absolutePanel.add(button, 785, 100);
		button.setSize("157px", "30px");
		
		Label lblAfiliado = new Label("Afiliado");
		lblAfiliado.setStyleName("label");
		absolutePanel.add(lblAfiliado, 387, 112);
		lblAfiliado.setSize("157px", "13px");
		
		final TextBox textBox_3 = new TextBox();
		textBox_3.setStyleName("gwt-TextBox2");
		textBox_3.setMaxLength(100);
		absolutePanel.add(textBox_3, 538, 95);
		textBox_3.setSize("227px", "28px");
		
		final TextBox textBox_4 = new TextBox();
		textBox_4.setStyleName("gwt-TextBox2");
		textBox_4.setMaxLength(100);
		absolutePanel.add(textBox_4, 856, 76);
		textBox_4.setSize("227px", "28px");
		
		final ValueListBox<AuxProveedor> valueListBox = new ValueListBox<AuxProveedor>(new Renderer<AuxProveedor>() {
			  public String render(AuxProveedor user) {
				    String s = "";
				    if (user != null) {
				      // Specify the format for the Strings to display per list item here. In this example, it is 
				      // 'username (firstname lastname)'
				      // For example: MTielemans (Mark Tielemans)
				      s = " "+user.getNomProveedor();
				    } else {
				      s = "Seleccione Proveedor";
				    }
				    return s; 
				  }

				  public void render(AuxProveedor user, Appendable appendable) throws IOException {
				      String s = render(user);
				      appendable.append(s);
				  }
			
		});
		
		absolutePanel.add(valueListBox, 173, 95);
		valueListBox.setSize("200px", "22px");
		
        valueListBox.addValueChangeHandler(new ValueChangeHandler<AuxProveedor>()
        {
            @Override
            public void onValueChange(ValueChangeEvent<AuxProveedor> event)
            {
                AuxProveedor selected = event.getValue();
                List<AuxDetalleSolucion> listaSolucion = selectNuevoBene.getSolucion().getLista();
                Iterator<AuxDetalleSolucion> i = listaSolucion.iterator();
                List<AuxDetallePlantillaSolucion> listaDetalleVale = new ArrayList<AuxDetallePlantillaSolucion>();
                while(i.hasNext()){
                	AuxDetalleSolucion aux = i.next();
                	if ((aux.getCantidad() - aux.getCantidadEjecutada()) > 0.0){
                		if (aux.getMaterialCostruccion().getProveedor().getIdProveedor().compareTo(selected.getIdProveedor()) == 0){
                			AuxDetallePlantillaSolucion auxDetalle = new AuxDetallePlantillaSolucion();
                			auxDetalle.setIdDetallePlantillaSolucion(aux.getIdDetalleSolucion());
                			auxDetalle.setNomMaterialCostruccion(aux.getMaterialCostruccion().getNomMaterialCostruccion());
                			auxDetalle.setPrecioUnit(aux.getMaterialCostruccion().getPrecioUnit());
                			auxDetalle.setCantidad(aux.getCantidad()-aux.getCantidadEjecutada());
                			auxDetalle.setUnidadMetrica(aux.getMaterialCostruccion().getUnidadMetrica());
                			auxDetalle.setSubTotal(aux.getSubTotal());
                			auxDetalle.setCostoAcumulado(0.0);
                			AuxMaterialCostruccion subAux = new AuxMaterialCostruccion();
                			subAux.setIdMaterialConstruccion(aux.getMaterialCostruccion().getIdMaterialConstruccion());
                			AuxProveedor subProv = new AuxProveedor();
                			subProv.setIdProveedor(aux.getMaterialCostruccion().getProveedor().getIdProveedor());
                			subProv.getAuxAfiliado().setIdAfiliado(aux.getMaterialCostruccion().getProveedor().getAuxAfiliado().getIdAfiliado());
                			subAux.setProveedor(subProv);
                			auxDetalle.setMaterialCostruccion(subAux);
                			listaDetalleVale.add(auxDetalle);
                			System.out.println("Material "+ aux.getIdDetalleSolucion());

                		}
                		
                	}
                }
                
                
        		e = new TablaGWT_Vale(listaDetalleVale);
        		grid.setWidget(1, 0,e);
        		e.setSize("700px", "300px"); 
				costoAcumulado = e.grid.ActualizarTabla();
		      	Column<AuxDetallePlantillaSolucion, String> cantidadColumn = (Column<AuxDetallePlantillaSolucion, String>) e.grid.dataGrid.getColumn(3);
		        
		        cantidadColumn.setFieldUpdater(new FieldUpdater<AuxDetallePlantillaSolucion, String>() {
					@Override
					public void update(int index, AuxDetallePlantillaSolucion object, String value) {
						System.out.println("Ejecuto");
						object.setCantidad(Double.valueOf(value));
						object.setSubTotal(object.getPrecioUnit() * Double.valueOf(value));
						costoAcumulado = e.grid.ActualizarTabla();
						
					}
		        });
		        Column<AuxDetallePlantillaSolucion, String> precioColumn = (Column<AuxDetallePlantillaSolucion, String>) e.grid.dataGrid.getColumn(4);
		        
		        precioColumn.setFieldUpdater(new FieldUpdater<AuxDetallePlantillaSolucion, String>() {
					@Override
					public void update(int index, AuxDetallePlantillaSolucion object, String value) {
						System.out.println("Ejecuto");
						object.setPrecioUnit(Double.valueOf(value));
						object.setSubTotal(object.getCantidad() * Double.valueOf(value));
						costoAcumulado = e.grid.ActualizarTabla();
						
					}
		        });
            }

        });

		
		suggestBox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {	
			
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				BeneMultiWordSuggestion select = (BeneMultiWordSuggestion)event.getSelectedItem();
				//beneficiario
				selectNuevoBene = select.getAfiliado();
				textBox_3.setText(selectNuevoBene.getAfiliado().getNomAfiliado());
				textBox.setText(selectNuevoBene.getSolucion().getDisenio());
				textBox_1.setText(selectNuevoBene.getDirBeneficiario());
				fechaActual = new Date(date.getTime());
				textBox_4.setText(String.valueOf(fechaActual));
				
				List<AuxProveedor> listaProveedor = new ArrayList<AuxProveedor>();
				Iterator<AuxDetalleSolucion> i = selectNuevoBene.getSolucion().getLista().iterator();
				int bandera = 0;
				while(i.hasNext()){
					AuxDetalleSolucion aux = i.next();
					if (bandera == 0){
						listaProveedor.add(aux.getMaterialCostruccion().getProveedor());
						bandera = 1;
					}
					else
					{
						Long idActual = aux.getMaterialCostruccion().getProveedor().getIdProveedor();
						int bandera2 = 0;
						Iterator<AuxProveedor> i2 = listaProveedor.iterator();
						while(i2.hasNext()){
							AuxProveedor aux2 = i2.next();
							System.out.println(idActual +" " + aux2.getIdProveedor());
							if (idActual.compareTo(aux2.getIdProveedor()) == 0){
								bandera2 = 1;
							}
						}
						if (bandera2 == 0)
							listaProveedor.add(aux.getMaterialCostruccion().getProveedor());
						
					}
					
				}
				valueListBox.setAcceptableValues(listaProveedor);
				
				System.out.println("Afiliado del beneficiario Selecccionado:"+ selectNuevoBene.getAfiliado().getIdAfiliado());
				
				loginService.GenerarIdVale2(selectNuevoBene.getAfiliado().getIdAfiliado(),new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						textBox_2.setText(result);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
			}

		});
		e = new TablaGWT_Vale(new ArrayList<AuxDetallePlantillaSolucion>());
		grid.setWidget(1, 0,e);
		e.setSize("700px", "300px"); 
		

		


		
		final Timer timer = new Timer() {
	        public void run() {
       			if (index < e.grid.getListMateriales().size()){
						final AuxDetallePlantillaSolucion aux = e.grid.getListMateriales().get(index);
						if (e.grid.selectionModel.isSelected(aux)){
						loginService.Actualizar_DetalleSolucion(aux.getIdDetallePlantillaSolucion(), textBox_2.getText(),selectNuevoBene.getSolucion().getIdSolucion(), new AsyncCallback<Long>() {
							
							@Override
							public void onSuccess(Long result) {
								// TODO Auto-generated method stub
								index++;
								costoAcumulado = costoAcumulado + aux.getSubTotal();
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}
							}								
						);
						loginService.Insertar_UnicoHistorialSolucion(selectNuevoBene.getSolucion().getIdSolucion(),textBox_2.getText(), aux, new AsyncCallback<Long>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Long result) {
								// TODO Auto-generated method stub
								System.out.println("ejecucion agregado al vale"+result);
								loginService.Agregar_DetalleEjecucionVale(textBox_2.getText(), result, new AsyncCallback<String>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										
									}

									@Override
									public void onSuccess(String result) {
										// TODO Auto-generated method stub
										
									}
								});
								
							}
						});
						}
       			}
       			else{
    				this.cancel();
    				
    				loginService.Actualizar_EstadoVale(textBox_2.getText(),fechaActual,costoAcumulado, new AsyncCallback<String>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
		       				
						}

						@Override
						public void onSuccess(String result) {
							// TODO Auto-generated method stub
							Window.alert("Solucion asignada Correctamente");
						}
    					
					});
    				Window.open("/FinanGenerarPdfVale?idVale="+textBox_2.getText()+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliadoSession+"&idBeneficiario="+selectNuevoBene.getIdBeneficiario(), "_blank", "");
       			}
				

	        }
	      };
	      	button.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
									System.out.println("Aqui se actualiza los detalles");
									index = 0;
									costoAcumulado = 0.0;
									loginService.GenerarIdVale(textBox_2.getText(),new AsyncCallback<String>() {
									
										@Override
										public void onSuccess(String result) {
											// TODO Auto-generated method stub
											System.out.println("Se guardo el vale: "+result);
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
}
