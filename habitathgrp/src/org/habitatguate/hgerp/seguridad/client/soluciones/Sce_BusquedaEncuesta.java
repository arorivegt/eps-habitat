package org.habitatguate.hgerp.seguridad.client.soluciones;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Grid;

public class Sce_BusquedaEncuesta extends Composite  {

    private  Grid grid;
    private Sce_BusquedaEncuesta a;
    private final RecursosHumanosServiceAsync RecursosHumanosService = GWT.create(RecursosHumanosService.class);
	public Sce_BusquedaEncuesta() {
		this.a = this;
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("990px", "20px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		// Nombre del Solicitante
		
		Label label = new Label("Nombre del solicitante");
		label.setStyleName("label");
		absolutePanel.add(label, 10, 10);
		label.setSize("145px", "13px");

		final TextBox txtBoxNombre = new TextBox();
		txtBoxNombre.setStyleName("gwt-TextBox2");
		txtBoxNombre.setMaxLength(100);
		absolutePanel.add(txtBoxNombre, 10, 29);
		txtBoxNombre.setSize("137px", "24px");
		
		// Primer Apellido
		
		Label label_1 = new Label("Primer Apellido");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 173, 10);
		label_1.setSize("137px", "13px");
		
		final TextBox txtBoxPrimerApellido = new TextBox();
		txtBoxPrimerApellido.setStyleName("gwt-TextBox2");
		txtBoxPrimerApellido.setMaxLength(100);
		absolutePanel.add(txtBoxPrimerApellido, 173, 29);
		txtBoxPrimerApellido.setSize("137px", "24px");
		
		// Segundo Apellido
		
		Label label_2 = new Label("Segundo Apellido");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 337, 10);
		label_2.setSize("157px", "19px");
		
		final TextBox txtBoxSegundoApellido = new TextBox();
		txtBoxSegundoApellido.setStylePrimaryName("gwt-TextBox2");
		txtBoxSegundoApellido.setStyleName("gwt-TextBox2");
		txtBoxSegundoApellido.setMaxLength(100);
		absolutePanel.add(txtBoxSegundoApellido, 337, 29);
		txtBoxSegundoApellido.setSize("186px", "24px");
		
		
		Image image = new Image("images/ico-lupa.png");
//		image.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				grid.clearCell(1, 0);
//				Empleado_Lista  nuevo = new Empleado_Lista();
//				nuevo.agregarFormulario('1',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
//						txtPrimerApellido.getText(), txtSegundoApellido.getText());
//				grid.setWidget(1, 0,nuevo);
//		        nuevo.setSize("1187px", "648px");
//			}
//		});
		absolutePanel.add(image, 544, 0);
		image.setSize("103px", "55px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				grid.clearCell(1, 0);
				Sce_DataEntryEncuestaVerificacion e = new Sce_DataEntryEncuestaVerificacion();
				grid.setWidget(1, 0, e);
		        e.setSize("1187px", "648px");
			}
		});
		
		button.setText("Nueva Encuesta de Verificaci\u00F3n");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("gwt-TextBox2");
		absolutePanel.add(button, 672, 10);
		button.setSize("283px", "39px");
		
//		Button btnBuscarTodos = new Button("Send");
//		btnBuscarTodos.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//
//				grid.clearCell(1, 0);
//				Empleado_Lista  nuevo = new Empleado_Lista();
//				nuevo.agregarFormulario('2',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
//						txtPrimerApellido.getText(), txtSegundoApellido.getText());
//				grid.setWidget(1, 0,nuevo);
//		        nuevo.setSize("1187px", "648px");
//			}
//		});
//		btnBuscarTodos.setText("Todos los Empleados");
//		btnBuscarTodos.setStylePrimaryName("gwt-TextBox2");
//		btnBuscarTodos.setStyleName("gwt-TextBox2");
//		absolutePanel.add(btnBuscarTodos, 730, 0);
//		btnBuscarTodos.setSize("157px", "20px");
		
//		this.simplePanel = new SimplePanel();
//		grid.setWidget(1, 0, simplePanel);
//		simplePanel.setSize("1184px", "716px");
	}

	
	private SimplePanel simplePanel = null;
	
	public SimplePanel getSimplePanel() {
		return simplePanel;
	}


	public void setSimplePanel(SimplePanel simplePanel) {
		this.simplePanel = simplePanel;
	}
	
//	public void Empleado_registrado(final Long id_empleado){
//
//		grid.clearCell(1, 0);
//		final Empleados e = new Empleados();
//		e.Nuevas_Pestanas();
//		grid.setWidget(1, 0,e);
//        e.setSize("1187px", "648px");
//        
//        RecursosHumanosService.Empleado_Registrado(id_empleado,new AsyncCallback<AuxEmpleado>(){
//        	
//        	public void onFailure(Throwable caught) 
//        	{
//        		Window.alert("No hay resultados "+caught);
//        	}
//
//        	@Override
//        	public void onSuccess(AuxEmpleado result)
//        	{
//
//        		try{
//        			
//        			e.setFD(result);
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setA(result.getHistorial_academico());
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setF(result.getFamilia());
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setH(result.getHistorial());
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setI(result.getIdiomas());
//        		}catch(Exception e){
//
//        		}
//        		try{
//        			e.setP(result.getPuestos());
//        		}catch(Exception e){
//
//        		}
//        		try{
//        			e.setRL(result.getReferencia_laboral());
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setRP(result.getReferencia_personal());
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setV(result.getVacaciones());
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setFE(result.getEntrevista().get(0));
//        		}catch(Exception e){
//        			
//        		}
//        		try{
//        			e.setFPP(result.getTest());
//        		}catch(Exception e){
//        			
//        		}
//        		
//        	}
//
//        });
//	}
	
}
