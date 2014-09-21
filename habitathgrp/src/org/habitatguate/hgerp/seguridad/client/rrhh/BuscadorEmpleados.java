package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
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
    private BuscadorEmpleados a;
    private ListBox listBox;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	public BuscadorEmpleados() {
		this.a = this;
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1100");
					
					AbsolutePanel absolutePanel = new AbsolutePanel();
					grid.setWidget(0, 0, absolutePanel);
					absolutePanel.setSize("1100px", "90px");
					absolutePanel.setStyleName("gwt-Label-new");
						
						final TextBox txtPrimerApellido = new TextBox();
						txtPrimerApellido.setStyleName("gwt-TextBox2");
						txtPrimerApellido.setMaxLength(100);
						absolutePanel.add(txtPrimerApellido, 10, 29);
						txtPrimerApellido.setSize("227px", "34px");
						
						final TextBox txtSegundoApellido = new TextBox();
						txtSegundoApellido.setStyleName("gwt-TextBox2");
						txtSegundoApellido.setMaxLength(100);
						absolutePanel.add(txtSegundoApellido, 245, 29);
						txtSegundoApellido.setSize("227px", "34px");
						
						final TextBox txtPrimerNombre = new TextBox();
						txtPrimerNombre.setStylePrimaryName("gwt-TextBox2");
						txtPrimerNombre.setStyleName("gwt-TextBox2");
						txtPrimerNombre.setMaxLength(100);
						absolutePanel.add(txtPrimerNombre, 480, 29);
						txtPrimerNombre.setSize("227px", "34px");
						
						final TextBox txtSegundoNombre = new TextBox();
						txtSegundoNombre.setStylePrimaryName("gwt-TextBox2");
						txtSegundoNombre.setStyleName("gwt-TextBox2");
						txtSegundoNombre.setMaxLength(100);
						absolutePanel.add(txtSegundoNombre, 715, 29);
						txtSegundoNombre.setSize("227px", "34px");
						
							final TextBox txtDPI = new TextBox();
							txtDPI.setStyleName("gwt-TextBox2");
							txtDPI.setMaxLength(100);
							absolutePanel.add(txtDPI, 10, 87);
							txtDPI.setSize("227px", "34px");
						
						final TextBox txtPasaporte = new TextBox();
						txtPasaporte.setStyleName("gwt-TextBox2");
						txtPasaporte.setMaxLength(100);
						absolutePanel.add(txtPasaporte, 245, 87);
						txtPasaporte.setSize("227px", "34px");
						
						final ListBox listEstado = new ListBox();
						listEstado.addItem("empleado activo");
						listEstado.addItem("empleado inactivo");
						listEstado.addItem("posible empleado");
						listEstado.setStyleName("gwt-TextBox2");
						absolutePanel.add(listEstado, 480, 89);
						listEstado.setSize("229px", "34px");
						
						listBox = new ListBox();
						listBox.addItem("DPI");
						listBox.addItem("Pasaporte");
						listBox.addItem("Nombres");
						listBox.addItem("Todos");
						listBox.addItem("Estado");
						listBox.setStyleName("gwt-TextBox2");
						absolutePanel.add(listBox, 715, 87);
						listBox.setSize("229px", "36px");
						
						Image image = new Image("images/ico-lupa.png");
						image.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								grid.clearCell(1, 0);
								EmpleadoLista  nuevo = new EmpleadoLista();

								if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
								{
									nuevo.agregarFormulario('2',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
											txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
											,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
								{
									nuevo.agregarFormulario('1',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
										txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText(),
										listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
								{
									nuevo.agregarFormulario('3',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
										txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
										,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
								{
									nuevo.agregarFormulario('4',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
										txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
										,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
								{
									nuevo.agregarFormulario('5',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
										txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
										,listEstado.getItemText(listEstado.getSelectedIndex()));
									grid.setWidget(1, 0,nuevo);
									nuevo.setSize("1187px", "648px");
								}
							}
						});
						
								absolutePanel.add(image, 973, 42);
								image.setSize("103px", "55px");
						
						Label label = new Label("Primer Apellido");
						label.setStyleName("label");
						absolutePanel.add(label, 10, 10);
						label.setSize("157px", "13px");
						
						Label label_1 = new Label("Segundo Apellido");
						label_1.setStyleName("label");
						absolutePanel.add(label_1, 245, 10);
						label_1.setSize("192px", "13px");
						
						Label label_2 = new Label("Primer Nombre");
						label_2.setStyleName("label");
						absolutePanel.add(label_2, 480, 10);
						label_2.setSize("157px", "19px");
						
						Label label_3 = new Label("2do y Demás Nombres");
						label_3.setStyleName("label");
						absolutePanel.add(label_3, 715, 10);
						label_3.setSize("261px", "13px");
						
						Label dpi = new Label("DPI");
						dpi.setStyleName("label");
						absolutePanel.add(dpi, 10, 71);
						dpi.setSize("157px", "13px");
						
						Label NoPasaporte = new Label("No Pasaporte");
						NoPasaporte.setStyleName("label");
						absolutePanel.add(NoPasaporte, 245, 71);
						NoPasaporte.setSize("157px", "13px");
						
						Label lblBusquedaPor = new Label("Busqueda por: ");
						lblBusquedaPor.setStyleName("label");
						absolutePanel.add(lblBusquedaPor, 715, 71);
						lblBusquedaPor.setSize("118px", "13px");
								
								Label lblEstadoEmpleado = new Label("Estado Empleado");
								lblEstadoEmpleado.setStyleName("label");
								absolutePanel.add(lblEstadoEmpleado, 480, 70);
								lblEstadoEmpleado.setSize("229px", "13px");
		
	}
	
	public void Empleado_registrado(final Long id_empleado){

		grid.clearCell(1, 0);
		final Empleados e = new Empleados(0);
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
