package org.habitatguate.hgerp.seguridad.client;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

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

public class Buscador_Empleados extends Composite  {

    private  Grid grid;
    private Buscador_Empleados a;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	public Buscador_Empleados() {
		this.a = this;
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "20px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		Label label = new Label("Primer Apellido");
		label.setStyleName("label");
		absolutePanel.add(label, 10, 10);
		label.setSize("157px", "13px");
		
		Label label_1 = new Label("Segundo Apellido");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 173, 10);
		label_1.setSize("192px", "13px");
		
		final TextBox txtPrimerApellido = new TextBox();
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		txtPrimerApellido.setMaxLength(100);
		absolutePanel.add(txtPrimerApellido, 10, 29);
		txtPrimerApellido.setSize("137px", "11px");
		
		final TextBox txtSegundoApellido = new TextBox();
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		txtSegundoApellido.setMaxLength(100);
		absolutePanel.add(txtSegundoApellido, 173, 29);
		txtSegundoApellido.setSize("137px", "11px");
		
		Label label_2 = new Label("Primer Nombre");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 337, 10);
		label_2.setSize("157px", "19px");
		
		final TextBox txtPrimerNombre = new TextBox();
		txtPrimerNombre.setStylePrimaryName("gwt-TextBox2");
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		txtPrimerNombre.setMaxLength(100);
		absolutePanel.add(txtPrimerNombre, 337, 29);
		txtPrimerNombre.setSize("137px", "11px");
		
		final TextBox txtSegundoNombre = new TextBox();
		txtSegundoNombre.setStylePrimaryName("gwt-TextBox2");
		txtSegundoNombre.setStyleName("gwt-TextBox2");
		txtSegundoNombre.setMaxLength(100);
		absolutePanel.add(txtSegundoNombre, 500, 29);
		txtSegundoNombre.setSize("137px", "11px");
		
		Label label_3 = new Label("2do y Demás Nombres");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 500, 10);
		label_3.setSize("157px", "13px");
		
		Image image = new Image("images/ico-lupa.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				grid.clearCell(1, 0);
				Empleado_Lista  nuevo = new Empleado_Lista();
				nuevo.agregarFormulario('1',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
						txtPrimerApellido.getText(), txtSegundoApellido.getText());
				grid.setWidget(1, 0,nuevo);
		        nuevo.setSize("1187px", "648px");
			}
		});
		absolutePanel.add(image, 630, 10);
		image.setSize("103px", "55px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				grid.clearCell(1, 0);
				Empleados e = new Empleados();
				grid.setWidget(1, 0,e);
		        e.setSize("1187px", "648px");
			}
		});
		button.setText("Nuevo Empleado");
		button.setStylePrimaryName("gwt-TextBox2");
		button.setStyleName("gwt-TextBox2");
		absolutePanel.add(button, 730, 29);
		button.setSize("157px", "20px");
		
		Button btnBuscarTodos = new Button("Send");
		btnBuscarTodos.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				grid.clearCell(1, 0);
				Empleado_Lista  nuevo = new Empleado_Lista();
				nuevo.agregarFormulario('2',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
						txtPrimerApellido.getText(), txtSegundoApellido.getText());
				grid.setWidget(1, 0,nuevo);
		        nuevo.setSize("1187px", "648px");
			}
		});
		btnBuscarTodos.setText("Todos los Empleados");
		btnBuscarTodos.setStylePrimaryName("gwt-TextBox2");
		btnBuscarTodos.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnBuscarTodos, 730, 0);
		btnBuscarTodos.setSize("157px", "20px");
		
		SimplePanel simplePanel = new SimplePanel();
		grid.setWidget(1, 0, simplePanel);
		simplePanel.setSize("1184px", "716px");
	}
	
	public void Empleado_registrado(final Long id_empleado){

		grid.clearCell(1, 0);
		final Empleados e = new Empleados();
		e.Nuevas_Pestañas();
		grid.setWidget(1, 0,e);
        e.setSize("1187px", "648px");
        
        loginService.Empleado_Registrado(id_empleado,new AsyncCallback<AuxEmpleado>(){
        	
        	public void onFailure(Throwable caught) 
        	{
        		Window.alert("No hay resultados "+caught);
        	}

        	@Override
        	public void onSuccess(AuxEmpleado result)
        	{

        		try{
        			
        			e.setFD(result);
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setA(result.getHistorial_academico());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setF(result.getFamilia());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setH(result.getHistorial());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setI(result.getIdiomas());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setRL(result.getReferencia_laboral());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setRP(result.getReferencia_personal());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setV(result.getVacaciones());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setFE(result.getEntrevista().get(0));
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setFPP(result.getTest());
        		}catch(Exception e){
        			
        		}
        		
        	}

        });
	}
	
}
