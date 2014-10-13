package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BuscadorEmpleados extends Composite   {

    private  Grid grid;
    private BuscadorEmpleados evaluacionesBuscador;
    private ListBox listBox;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    private Label lbDato1;
    private Label lbDato2;
    private Label lbDato3;

    private TextBox txtDato1;
    private TextBox txtDato2;
    private TextBox txtDato3;
    private  ListBox listEstado ;
    private Image Busqueda;
    private AbsolutePanel absolutePanel;
	public BuscadorEmpleados() {
		this.evaluacionesBuscador = this;
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setSize("1350px", "100%");
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		txtDato1 = new TextBox();
		txtDato1.setStylePrimaryName("gwt-TextBox2");
		txtDato1.setStyleName("gwt-TextBox2");
		txtDato1.setMaxLength(100);
		absolutePanel.add(txtDato1, 205, 19);
		txtDato1.setSize("177px", "34px");
		
		txtDato2 = new TextBox();
		txtDato2.setStyleName("gwt-TextBox2");
		txtDato2.setMaxLength(100);
		absolutePanel.add(txtDato2, 390, 19);
		txtDato2.setSize("177px", "34px");
						
		txtDato3 = new TextBox();
		txtDato3.setStyleName("gwt-TextBox2");
		txtDato3.setMaxLength(100);
		absolutePanel.add(txtDato3, 575, 19);
		txtDato3.setSize("177px", "34px");
		
		listEstado = new ListBox();
		listEstado.addItem("empleado activo");
		listEstado.addItem("empleado inactivo");
		listEstado.addItem("posible empleado");
		listEstado.setStyleName("gwt-TextBox2");
		listEstado.setVisible(false);
		absolutePanel.add(listEstado, 205, 16);
		listEstado.setSize("179px", "39px");
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
		listBox.addItem("Pasaporte");
		listBox.addItem("Estado");
		listBox.addItem("Todos");
		listBox.addItem("DPI");
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
				{
					lbDato1.setText("Ingrese el DPI");
					lbDato2.setText("Ingrese el DPI");
					lbDato3.setText("Ingrese el DPI");

					lbDato1.setVisible(true);
					lbDato2.setVisible(false);
					lbDato3.setVisible(false);
					
					txtDato1.setVisible(true);
					txtDato2.setVisible(false);
					txtDato3.setVisible(false);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 390, 16);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Primer Nombre");
					lbDato2.setText("Primer Apellido");
					lbDato3.setText("Segundo Apellido");

					lbDato1.setVisible(true);
					lbDato2.setVisible(true);
					lbDato3.setVisible(true);
					
					txtDato1.setVisible(true);
					txtDato2.setVisible(true);
					txtDato3.setVisible(true);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 760, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Primer Nombre");
					lbDato2.setText("Primer Apellido");
					lbDato3.setText("Segundo Apellido");

					lbDato1.setVisible(false);
					lbDato2.setVisible(false);
					lbDato3.setVisible(false);
					
					txtDato1.setVisible(false);
					txtDato2.setVisible(false);
					txtDato3.setVisible(false);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 205, 16);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					lbDato1.setText("Ingrese No. Pasaporte");
					lbDato2.setText("Primer Apellido");
					lbDato3.setText("Segundo Apellido");

					lbDato1.setVisible(true);
					lbDato2.setVisible(false);
					lbDato3.setVisible(false);
					
					txtDato1.setVisible(true);
					txtDato2.setVisible(false);
					txtDato3.setVisible(false);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 390, 16);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
				{
					lbDato1.setText("Seleccione el Estado del empleado");
					lbDato2.setText("Primer Apellido");
					lbDato3.setText("Segundo Apellido");

					lbDato1.setVisible(true);
					lbDato2.setVisible(false);
					lbDato3.setVisible(false);
					
					txtDato1.setVisible(false);
					txtDato2.setVisible(false);
					txtDato3.setVisible(false);
					listEstado.setVisible(true);
					absolutePanel.add(Busqueda, 390, 19);
				}
			}
		});
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
						
						Busqueda = new Image("images/ico-lupa.png");
						Busqueda.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								grid.clearCell(1, 0);
								EmpleadoLista  nuevo = new EmpleadoLista();

								if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
								{
									nuevo.agregarFormulario('2',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
											txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
											,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
								{
									nuevo.agregarFormulario('1',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
											txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
											,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
								{
									nuevo.agregarFormulario('3',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
											txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
											,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
								{
									nuevo.agregarFormulario('4',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
											txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
											,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
								{
									nuevo.agregarFormulario('5',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
											txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
											,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}
							}
						});
						
								absolutePanel.add(Busqueda, 760, 19);
								Busqueda.setSize("103px", "55px");
						
						lbDato1 = new Label("Primer Nombre");
						lbDato1.setStyleName("label");
						absolutePanel.add(lbDato1, 205, 0);
						lbDato1.setSize("368px", "19px");
						
						lbDato2 = new Label("Segundo Apellido");
						lbDato2.setStyleName("label");
						absolutePanel.add(lbDato2, 390, 0);
						lbDato2.setSize("157px", "13px");
						
						lbDato3 = new Label("Primer Apellido");
						lbDato3.setStyleName("label");
						absolutePanel.add(lbDato3, 575, 0);
						lbDato3.setSize("157px", "13px");
						
						Label lblBusquedaPor = new Label("Busqueda por: ");
						lblBusquedaPor.setStyleName("label");
						absolutePanel.add(lblBusquedaPor, 10, 0);
						lblBusquedaPor.setSize("118px", "13px");
		
	}
	
	public void Empleado_registrado(final Long id_empleado){

		grid.clearCell(1, 0);
		final Empleados e = new Empleados(0);
		e.id_empleado = id_empleado;
		e.NuevasPestanas(); 
		grid.setWidget(1, 0,e);
        e.setSize("1187px", "648px");
        
        loginService.Empleado_Registrado(id_empleado,new AsyncCallback<AuxEmpleado>(){
        	public void onFailure(Throwable caught) 
        	{
            	setMensaje("alert alert-information alert-block", 
            			"\nNo hay resultados");
        		//Window.alert("No hay resultados "+caught);
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
        			e.setP(result.getPuestos());
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
	public void setMensaje(String estilo, String mensaje){
		final DialogBox Registro2 = new DialogBox();
        final HTML serverResponseLabel = new HTML();
        final Button close= new Button("x");
        Mensaje inicio = new Mensaje();
        
        Registro2.setStyleName(estilo);
        inicio.mensajeEntrada(mensaje);
        inicio.mensajeEstilo(estilo);
        close.addStyleName("close");
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(inicio);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(close);
        Registro2 .setWidget(dialogVPanel);
        Registro2 .setModal(true);
        Registro2 .setGlassEnabled(true);
        Registro2 .setAnimationEnabled(true);
        Registro2 .center();
        Registro2 .show();
        close.setFocus(true);
    
        close.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            Registro2.hide();
        }
    });
	}
	
}
