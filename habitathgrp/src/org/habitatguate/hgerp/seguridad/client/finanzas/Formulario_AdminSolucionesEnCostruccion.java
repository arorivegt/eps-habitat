package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class Formulario_AdminSolucionesEnCostruccion extends Composite{
	
	 private final SqlServiceAsync loginService = GWT.create(SqlService.class);
		public long idProveedorActual = 0L;
		Formulario_CambioTrimestre formularioPago;
	    TablaGWT_AdminSoluciones e = null;
	    
	    public Formulario_AdminSolucionesEnCostruccion() {
			// TODO Auto-generated constructor stub
			

			
			final Grid grid = new Grid(2, 1);
			initWidget(grid);
			grid.setWidth("1178px");
			

			
			AbsolutePanel absolutePanel = new AbsolutePanel();
			grid.setWidget(0, 0, absolutePanel);
			absolutePanel.setSize("1130px", "20px");
			absolutePanel.setStyleName("gwt-Label-new");
			
			//----------------------------primera fila---------------------------------
			
			Label label = new Label("Seleccione Afiliado");
			label.setStyleName("label");
			absolutePanel.add(label, 20, 10);
			label.setSize("275px", "18px");
			
					
			
		/*	Image image = new Image("images/ico-lupa.png");
			absolutePanel.add(image, 958, 0);
			image.setSize("103px", "55px");*/
			
			
			Button button = new Button("Send");
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					AuxSolucion total= e.grid.selectionModel.getSelectedObject();
					if (total != null){
						loginService.Actualizar_EstadoFinalizadoSolucion(total.getIdSolucion(), new AsyncCallback<Long>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Long result) {
								// TODO Auto-generated method stub
								Window.alert("La solución ha sido finalizado exitosamente");
							}
						});
					
					}else{
						Window.alert("Debes de seleccionar una solucion");
					}
					
				}
			});		

			button.setText("Finalizar Solución");
			button.setStyleName("finanButton");
			absolutePanel.add(button, 650, 29);
			button.setSize("157px", "30px");
			
			Button button2 = new Button("Send");
			button2.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {				
					AuxSolucion aux = e.grid.selectionModel.getSelectedObject();
					if (aux != null){
						formularioPago = new Formulario_CambioTrimestre(aux.getIdSolucion());
					}else{
						Window.alert("Debes de Seleccionar una Solucion");
					}
					
						}

					
					
				
			});		

			button2.setText("Cambiar Trimestre");
			button2.setStyleName("finanButton");
			absolutePanel.add(button2, 850, 29);
			button2.setSize("157px", "30px");
				
			final ListBox comboBox = new ListBox();
			absolutePanel.add(comboBox, 20, 29);
			comboBox.addItem("Seleccione Afiliado", "-1");
			
			comboBox.addChangeHandler(new ChangeHandler() {

		 		@Override
				public void onChange(ChangeEvent event) {	 			
		 			if (!comboBox.getValue(comboBox.getSelectedIndex()).equals("-1")){
		 				loginService.Consultar_SolucionesEnCostruccion_PorAfiliado(Long.valueOf(comboBox.getValue(comboBox.getSelectedIndex())),
		 						new AsyncCallback<List<AuxSolucion>>() {	 	        		
		 	        		@Override
		 	        		public void onFailure(Throwable caught) {
		 	        			System.out.println(caught);
		 	        			
		 	        		}

							@Override
							public void onSuccess(List<AuxSolucion> result) {
								System.out.println(result.size());
								e = new TablaGWT_AdminSoluciones(result);
								grid.setWidget(1, 0,e);
								e.setSize("1000px", "300px");
								// TODO Auto-generated method stub
								
							}
		 	        	});
		 			}
		 			
				}
		    });
			
			
			loginService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>() {
				
				@Override
				public void onSuccess(List<AuxAfiliado> result) {
					System.out.println("ya estan todos los afiliados");
					for (AuxAfiliado aux : result){
						comboBox.addItem(aux.getNomAfiliado(),String.valueOf(aux.getIdAfiliado()));
					}
			
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					System.out.println(caught);
					
				}
			});
			
			e = new TablaGWT_AdminSoluciones(new ArrayList<AuxSolucion>());
			grid.setWidget(1, 0,e);
			e.setSize("1000px", "300px");
		}
}
