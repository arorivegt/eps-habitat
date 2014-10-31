/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class BuscadorEmpleados extends Composite   {

	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private Label lbDato1;
    private Label lbDato2;
    private Label lbDato3;
    private Image Busqueda;
    private TextBox txtDato1;
    private TextBox txtDato2;
    private TextBox txtDato3;
    private  ListBox listEstado ;
    private AbsolutePanel absolutePanel;
    private BuscadorEmpleados evaluacionesBuscador;
	 public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
     private Loading load ;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
    /**
     * constructor
     */
	public BuscadorEmpleados() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		this.evaluacionesBuscador = this;
		grid = new Grid(2, 1);
		grid.setSize("876px", "100%");
					
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
		listEstado.addItem("empleado activo","0");
		listEstado.addItem("empleado inactivo","1");
		listEstado.addItem("posible empleado","2");
		listEstado.addItem("practicante","3");
		listEstado.addItem("interino","4");
		listEstado.setStyleName("gwt-TextBox2");
		listEstado.setVisible(false);
		absolutePanel.add(listEstado, 205, 16);
		listEstado.setSize("179px", "39px");
		
		
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
		listBox.addItem("Pasaporte");
		listBox.addItem("Estado");
		listBox.addItem("Puesto");
		listBox.addItem("Todos");
		listBox.addItem("DPI");
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

		        load.visible();
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

					grid.clearCell(1, 0);
					EmpleadoLista  nuevo = new EmpleadoLista();
					nuevo.agregarFormulario('2',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
							txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
							,"");
					grid.setWidget(1, 0,nuevo);
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
					listEstado.clear();
					listEstado.addItem("empleado activo","0");
					listEstado.addItem("empleado inactivo","1");
					listEstado.addItem("posible empleado","2");
					listEstado.addItem("practicante","3");
					listEstado.addItem("interino","4");
					
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
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un puesto","0");
				    for (AuxBDPuesto p : BDpuestos) 
				    {
				    	listEstado.addItem(p.getNombre_puesto(),""+p.getId_puesto());
				    }
					lbDato1.setText("Seleccione el puesto");
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
		        load.invisible();
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
						
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				grid.clearCell(1, 0);
				EmpleadoLista  nuevo = new EmpleadoLista();
				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					nuevo.agregarFormulario('2',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
							txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
							,"");
					grid.setWidget(1, 0,nuevo);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{

					if(!txtDato1.getText().equals("") || !txtDato2.getText().equals("") 
							|| !txtDato3.getText().equals("")){
						if(txtDato1.getText().equals("")){
							txtDato1.setText("    ");
						}if(txtDato2.getText().equals("")){
							txtDato2.setText("    ");
						}if(txtDato3.getText().equals("")){
							txtDato3.setText("    ");
						}
						nuevo.agregarFormulario('1',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
								txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
								,"");
						grid.setWidget(1, 0,nuevo);
						nuevo.setSize("100%", "648px");
					}
					else{

		    			mensaje.setMensaje("alert alert-info", "Escriba al menos un dato");
					}
				}else if(listBox.getValue(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					if(!txtDato1.getText().equals("") ){
						nuevo.agregarFormulario('3',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
								txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
								,"");
						grid.setWidget(1, 0,nuevo);
						nuevo.setSize("100%", "648px");
					}
					else{

		    			mensaje.setMensaje("alert alert-info", "Escriba el No pasaporte");
		    		}
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
				{

					if(!txtDato1.getText().equals("") ){
						nuevo.agregarFormulario('4',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
								txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
								,"");
						grid.setWidget(1, 0,nuevo);
						nuevo.setSize("100%", "648px");
					}
					else{

		    			mensaje.setMensaje("alert alert-info", "Escriba el DPI");
		    		}
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
				{
					nuevo.agregarFormulario('5',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
							txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
							,listEstado.getValue(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
				{
					nuevo.agregarFormulario('6',evaluacionesBuscador,txtDato1.getText(), "",txtDato2.getText(), 
							txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
							,listEstado.getValue(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}

		        load.invisible();
			}
		});
						
		absolutePanel.add(Busqueda, 760, 19);
		Busqueda.setSize("103px", "55px");
		
		lbDato1 = new Label("Primer Nombre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		lbDato2 = new Label("Primer Apellido");
		lbDato2.setStyleName("label");
		lbDato2.setSize("157px", "13px");
		absolutePanel.add(lbDato2, 390, 0);
		
		lbDato3 = new Label("Segundo Apellido");
		lbDato3.setStyleName("label");
		lbDato3.setSize("157px", "13px");
		absolutePanel.add(lbDato3, 575, 0);
		
		Label lblBusquedaPor = new Label("Busqueda por: ");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("118px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
	    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
	    		public void onFailure(Throwable caught) 
	    		{
	    			mensaje.setMensaje("alert alert-success", "Error en BD puestos\n"+caught);
	    		}

				@Override
				public void onSuccess(List<AuxBDPuesto> results)
				{
					if (!(results.size()==0)) {
						BDpuestos = results;
			    	}	
				}
			});
		initWidget(grid);
		
	}
	/**
	 * agrega un empleado con los datos extraidos del datastore
	 * como formulario de datos, familia, academico, idiomas
	 * referencia laboral, personal, etc.
	 * @param id_empleado
	 */
	public void Empleado_registrado(final Long id_empleado){

        load.visible();
		grid.clearCell(1, 0);
		final Empleados e = new Empleados(0);
		e.id_empleado = id_empleado;
		e.NuevasPestanas(); 
		grid.setWidget(1, 0,e);
        e.setSize("100%", "648px");
        
        loginService.Empleado_Registrado(id_empleado,new AsyncCallback<AuxEmpleado>(){
        	public void onFailure(Throwable caught) 
        	{
                load.invisible();
            	mensaje.setMensaje("alert alert-information alert-block", 
            			"\nNo hay resultados");
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

        		try{
        			e.setS(result.getSalario());
        		}catch(Exception e){
        			
        		}

                load.invisible();
        	}

        });
	}

	
}
