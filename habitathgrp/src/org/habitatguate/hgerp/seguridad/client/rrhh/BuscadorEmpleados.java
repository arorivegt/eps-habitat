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
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class BuscadorEmpleados extends Composite   {

    private Grid grid;
    private Loading load ;
    private Label lbDato1;
    private Image Busqueda;
	private Mensaje mensaje; 
    private ListBox listBox;
    private SuggestBox txtDato1;
    private ListBox listEstado;
    private AbsolutePanel absolutePanel;
    private BuscadorEmpleados buscadorEmpleados;
	public  List <AuxBDPuesto> bdPuestos = new ArrayList<AuxBDPuesto>();	
	public  List <AuxAfiliado> bdAfiliados = new ArrayList<AuxAfiliado>();	
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final SqlServiceAsync finanzasService = GWT.create(SqlService.class);
    
    /**
     * constructor
     */
	public BuscadorEmpleados() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		mensaje = new Mensaje();
		
		this.buscadorEmpleados = this;
		grid = new Grid(2, 1);
		grid.setSize("876px", "100%");
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		txtDato1 = new SuggestBox(createCountriesOracle());
		txtDato1.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
			     if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER) 
			     {
						busqueda();
			     }
			}
		});
		txtDato1.setStylePrimaryName("gwt-TextBox2");
		txtDato1.setStyleName("gwt-TextBox2");
		//txtDato1.setMaxLength(100);
		absolutePanel.add(txtDato1, 205, 19);
		txtDato1.setSize("250px", "34px");
		
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
		listBox.addItem("Afiliado");
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
					lbDato1.setVisible(true);
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Escriba el nombre de la persona a buscar");
					lbDato1.setVisible(true);
					txtDato1.setVisible(true);
					txtDato1.showSuggestionList();
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Primer Nombre");
					lbDato1.setVisible(false);
					txtDato1.setVisible(false);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 205, 16);

					grid.clearCell(1, 0);
					EmpleadoLista  nuevo = new EmpleadoLista();
					nuevo.agregarFormulario('2',buscadorEmpleados,txtDato1.getText(), "","", 
							"",txtDato1.getText(),txtDato1.getText()
							,"");
					grid.setWidget(1, 0,nuevo);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					lbDato1.setText("Ingrese No. Pasaporte");
					txtDato1.setValue("");
					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
				{
					listEstado.clear();
					txtDato1.setValue("");
					listEstado.addItem("empleado activo","0");
					listEstado.addItem("empleado inactivo","1");
					listEstado.addItem("posible empleado","2");
					listEstado.addItem("practicante","3");
					listEstado.addItem("interino","4");
					
					lbDato1.setText("Seleccione el Estado del empleado");
					lbDato1.setVisible(true);
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un puesto","0");
				    for (AuxBDPuesto p : bdPuestos) 
				    {
				    	listEstado.addItem(p.getNombre_puesto(),""+p.getId_puesto());
				    }
					lbDato1.setText("Seleccione el puesto");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un afiliado","0");
				    for (AuxAfiliado p : bdAfiliados) 
				    {
				    	listEstado.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
				    }
					lbDato1.setText("Seleccione el Afiliado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}
		        load.invisible();
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
		
		
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
						
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				busqueda();
			}
		});
						
		absolutePanel.add(Busqueda, 420, 19);
		Busqueda.setSize("103px", "55px");
		
		lbDato1 = new Label("Primer Nombre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		
		Label lblBusquedaPor = new Label("Busqueda por: ");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("118px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
    	recursosHumanosService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-success", "Error en BD puestos\n"+caught);
    		}

			@Override
			public void onSuccess(List<AuxBDPuesto> results)
			{
				if (!(results.size()==0)) {
					bdPuestos = results;
		    	}	
			}
		});
    	
		finanzasService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>(){
		    public void onFailure(Throwable caught) 
		    {
		    }
		
			@Override
		    public void onSuccess(List<AuxAfiliado> result)
		    {
				if (!(result.size()==0)) {
					bdAfiliados = result;
		    	}
		    }
		});
		initWidget(grid);
		
	}
	
	public void busqueda(){

		grid.clearCell(1, 0);
		EmpleadoLista  nuevo = new EmpleadoLista();
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			nuevo.agregarFormulario('2',buscadorEmpleados,txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,"");
			grid.setWidget(1, 0,nuevo);
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
		{
			String nombreArray[] = txtDato1.getText().split(" ");
			String primerNombre = "";
			String segundoNombre = "";
			String segundoApellido = "";
			String primerApellido =  "";
			System.out.println(nombreArray.length);
			try{

				if(nombreArray.length == 2){
					primerNombre = nombreArray[0];
					segundoNombre = "";
					primerApellido =  nombreArray[1];
					segundoApellido = "";
					
					nuevo.agregarFormulario('1',buscadorEmpleados,primerNombre, segundoNombre,primerApellido, segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}else if(nombreArray.length == 3){
					
					primerNombre = nombreArray[0];
					segundoNombre =  nombreArray[1];
					primerApellido =  nombreArray[2];
					segundoApellido = "";
					
					if(nuevo.agregarFormulario('1',buscadorEmpleados,primerNombre, segundoNombre,primerApellido, 
							segundoApellido,txtDato1.getText(),txtDato1.getText(),""))
					{
						primerNombre = nombreArray[0];
						segundoNombre =  "";
						primerApellido =  nombreArray[1];
						segundoApellido = nombreArray[2];
						
						nuevo.agregarFormulario('1',buscadorEmpleados,primerNombre, segundoNombre,primerApellido, 
								segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					}
					
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
					
				}else if(nombreArray.length == 4){
					primerNombre = nombreArray[0];
					segundoNombre = nombreArray[1];
					primerApellido =  nombreArray[2];
					segundoApellido = nombreArray[3];
					
					nuevo.agregarFormulario('1',buscadorEmpleados,primerNombre, segundoNombre,primerApellido, segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}
				
			}catch(Exception e){
				 primerNombre = "";
				 segundoApellido = "";
				 primerApellido =  "";
			}
			
		}else if(listBox.getValue(listBox.getSelectedIndex()).equals("Pasaporte"))
		{
			if(!txtDato1.getText().equals("") ){
				nuevo.agregarFormulario('3',buscadorEmpleados,txtDato1.getText(), "","", 
						"",txtDato1.getText(),txtDato1.getText()
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
				nuevo.agregarFormulario('4',buscadorEmpleados,txtDato1.getText(), "","", 
						"",txtDato1.getText(),txtDato1.getText()
						,"");
				grid.setWidget(1, 0,nuevo);
				nuevo.setSize("100%", "648px");
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba el DPI");
    		}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
		{
			nuevo.agregarFormulario('5',buscadorEmpleados,txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
		{
			nuevo.agregarFormulario('6',buscadorEmpleados,txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
		{
			nuevo.agregarFormulario('7',buscadorEmpleados,txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}
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
		recursosHumanosService.obtenerIdRol(new AsyncCallback<Long>() 
		{
			public void onFailure(Throwable caught) 
			{
			}

			public void onSuccess(Long results)
			{

				final Empleado empleado = new Empleado(0,"R",results);
				empleado.id_empleado = id_empleado;
				empleado.NuevasPestanas(results); 
				grid.setWidget(1, 0,empleado);
		        empleado.setSize("100%", "648px");
		        
		        recursosHumanosService.Empleado_Registrado(id_empleado,new AsyncCallback<AuxEmpleado>(){
		        	public void onFailure(Throwable caught) 
		        	{
		                load.invisible();
		            	mensaje.setMensaje("alert alert-information alert-block", "\nNo hay resultados");
		        	}

		        	@Override
		        	public void onSuccess(AuxEmpleado result)
		        	{
		        		//System.out.println(result.getAfiliado());
		        		try{
		        			
		        			empleado.setFormularioDatos(result);
		        			
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setAcademico(result.getHistorial_academico());
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setFamilia(result.getFamilia());
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setHistorial(result.getHistorial());
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setIdioma(result.getIdiomas());
		        		}catch(Exception e){

		        		}
		        		try{
		        			empleado.setPuesto(result.getPuestos());
		        		}catch(Exception e){

		        		}
		        		try{
		        			empleado.setReferenciaLaboral(result.getReferencia_laboral());
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setReferenciaPersonal(result.getReferencia_personal());
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setPermiso(result.getVacaciones());
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setFormularioEntrevista(result.getEntrevista().get(0));
		        		}catch(Exception e){
		        			
		        		}
		        		try{
		        			empleado.setFormularioTest(result.getTest());
		        		}catch(Exception e){
		        			
		        		}

		        		try{
		        			empleado.setSalario(result.getSalario());
		        		}catch(Exception e){
		        			
		        		}

		                load.invisible();
		        	}

		        });
				
			}
		});
        
        
	}
	MultiWordSuggestOracle createCountriesOracle()
	{
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
	    recursosHumanosService.Buscar_Empleado('2', "", "", 
	    		"", "","", "","",new AsyncCallback<List<AuxEmpleado>>(){
		    public void onFailure(Throwable caught) 
		    {
		        load.invisible();
		    }
		
			@Override
		    public void onSuccess( List<AuxEmpleado> result)
		    {
				for(AuxEmpleado p : result) 
				{
					oracle.add(p.getPrimer_nombre().trim()+" "+p.getSegundo_nombre().trim()+" "+p.getPrimer_apellido().trim()+" "+p.getSegundo_apellido().trim());
				}
		    }
		
		});
	    return oracle;
    }
	
}
