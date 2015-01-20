/**0
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;

public class CrearPrestacionesLaborales extends Composite   {

    private Grid grid;
    private Loading load;
    private Image Busqueda;
	boolean bandera = false;
	private Mensaje mensaje; 
    private Prestaciones nuevo;
    private SuggestBox txtDato1;

    private ListBox listBox;
    private ListBox listEstado;
    private ListBox listAnnio;
    private ListBox listTipoPrestaciones;
    
    private DateBox dateFecha;

    private Label lbDato1;
    private Label lblFechaRegistro;
    private Label lblCantidad;
    private Label lblElijaElAo;
    private Label lblElijaElTipo;
    private AbsolutePanel absolutePanel;
    private Label lblDescripcionPequea;
    
    private TextBox Cantidad;
    private TextBox txtDescripcion;
    
	public List <AuxBDPuesto> auxbdPuestos = new ArrayList<AuxBDPuesto>();	
	public List <AuxAfiliado> auxAfiliados = new ArrayList<AuxAfiliado>();	
    private final SqlServiceAsync finanzasService = GWT.create(SqlService.class);
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private DateBox dateFecha1;
    private Label lblFecha;
    private DateBox dateFecha2;
    
    /**
     * constructor
     */
	public CrearPrestacionesLaborales() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		nuevo = new Prestaciones();
		grid.setSize("1117px", "100%");
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "98px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		
		
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

				if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
				{
					lbDato1.setText("Ingrese el DPI");
					
					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Primer Nombre");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Primer Nombre");

					lbDato1.setVisible(false);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 205, 16);

					grid.clearCell(1, 0);
					agregarFormulario('2',txtDato1.getText(), "","", 
							"",txtDato1.getText(),txtDato1.getText()
							,"");
					grid.setWidget(1, 0,nuevo);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					lbDato1.setText("Ingrese No. Pasaporte");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
				{
					listEstado.clear();
					listEstado.addItem("empleado activo","0");
					listEstado.addItem("empleado inactivo","1");
					listEstado.addItem("posible empleado","2");
					listEstado.addItem("practicante","3");
					listEstado.addItem("interino","4");
					
					lbDato1.setText("Seleccione el Estado del empleado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un puesto","0");
				    for (AuxBDPuesto p : auxbdPuestos) 
				    {
				    	listEstado.addItem(p.getNombre_puesto(),""+p.getId_puesto());
				    }
					lbDato1.setText("Seleccione el puesto");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un afiliado","0");
				    for (AuxAfiliado p : auxAfiliados) 
				    {
				    	listEstado.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
				    }
					lbDato1.setText("Seleccione el Afiliado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 19);
		listBox.setSize("179px", "39px");
		
		txtDato1 =  new SuggestBox(createCountriesOracle());
		txtDato1.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER){
					Buscar();
				}
			}
		});
		txtDato1.setStylePrimaryName("gwt-TextBox2");
		txtDato1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDato1, 205, 19);
		txtDato1.setSize("250px", "34px");
		
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
				Buscar();
			}
		});
		
		listTipoPrestaciones = new ListBox();
		listTipoPrestaciones.addItem("Decreto(78-89)", "1");
		listTipoPrestaciones.addItem("Comisiones", "2");
		listTipoPrestaciones.addItem("Bonificacion", "3");
		listTipoPrestaciones.addItem("Bono 14", "4");
		listTipoPrestaciones.addItem("Aguinaldo", "5");
		listTipoPrestaciones.addItem("Vacaciones", "6");
		listTipoPrestaciones.addItem("Indemnizacion", "7");
		listTipoPrestaciones.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoPrestaciones, 10, 94);
		listTipoPrestaciones.setSize("179px", "39px");
						
		absolutePanel.add(Busqueda, 848, 78);
		Busqueda.setSize("103px", "55px");
		
		listAnnio = new ListBox();
		listAnnio.addItem("2000");
		listAnnio.addItem("2001");
		listAnnio.addItem("2002");
		listAnnio.addItem("2003");
		listAnnio.addItem("2004");
		listAnnio.addItem("2005");
		listAnnio.addItem("2006");
		listAnnio.addItem("2007");
		listAnnio.addItem("2008");
		listAnnio.addItem("2009");
		listAnnio.addItem("2010");
		listAnnio.addItem("2011");
		listAnnio.addItem("2012");
		listAnnio.addItem("2013");
		listAnnio.addItem("2014");
		listAnnio.addItem("2015");
		listAnnio.addItem("2016");
		listAnnio.addItem("2017");
		listAnnio.addItem("2018");
		listAnnio.addItem("2019");
		listAnnio.addItem("2020");
		listAnnio.addItem("2021");
		listAnnio.addItem("2022");
		listAnnio.addItem("2023");
		listAnnio.addItem("2024");
		listAnnio.addItem("2025");
		listAnnio.addItem("2026");
		listAnnio.addItem("2027");
		listAnnio.addItem("2028");
		listAnnio.addItem("2029");
		listAnnio.addItem("2030");
		listAnnio.addItem("2031");
		listAnnio.addItem("2032");
		listAnnio.addItem("2033");
		listAnnio.addItem("2034");
		listAnnio.addItem("2035");
		listAnnio.addItem("2036");
		listAnnio.addItem("2037");
		listAnnio.addItem("2038");
		listAnnio.addItem("2039");
		listAnnio.addItem("2040");
		listAnnio.addItem("2050");
		listAnnio.addItem("2051");
		listAnnio.addItem("2052");
		listAnnio.addItem("2053");
		listAnnio.addItem("2054");
		listAnnio.addItem("2055");
		listAnnio.addItem("2056");
		listAnnio.addItem("2057");
		listAnnio.addItem("2058");
		listAnnio.addItem("2059");
		listAnnio.addItem("2060");
		listAnnio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listAnnio, 205, 94);
		listAnnio.setSize("179px", "39px");
		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date());
		dateFecha.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFecha, 463, 17);
		dateFecha.setSize("177px", "41px");
		
		txtDescripcion = new TextBox();
		txtDescripcion.setStyleName("gwt-TextBox2");
		txtDescripcion.setMaxLength(100);
		absolutePanel.add(txtDescripcion, 648, 19);
		txtDescripcion.setSize("177px", "39px");
		
		Cantidad = new TextBox();
		Cantidad.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(Cantidad.getText().equals("")) {Cantidad.setText("0.0");}
				else if(Cantidad.getText().equals(null)) {Cantidad.setText("0.0");}
				else{
					try{
						Float.parseFloat(Cantidad.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nCantidad no valida");
						Cantidad.setText("0.0");
					}
				}
			}
		});
		Cantidad.setText("0.0");
		Cantidad.setStyleName("gwt-TextBox2");
		Cantidad.setMaxLength(100);
		absolutePanel.add(Cantidad, 846, 19);
		Cantidad.setSize("145px", "39px");
		
		dateFecha1 = new DateBox();
		dateFecha1.getTextBox().setReadOnly(true);
		dateFecha1.setValue(new Date());
		dateFecha1.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha1.getDatePicker().setYearArrowsVisible(true);
		dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha1.getDatePicker().setVisibleYearCount(100);
		dateFecha1.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFecha1, 401, 90);
		dateFecha1.setSize("177px", "41px");
		
		dateFecha2 = new DateBox();
		dateFecha2.getTextBox().setReadOnly(true);
		dateFecha2.setValue(new Date());
		dateFecha2.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha2.getDatePicker().setYearArrowsVisible(true);
		dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha2.getDatePicker().setVisibleYearCount(100);
		dateFecha2.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFecha2, 593, 90);
		dateFecha2.setSize("177px", "41px");
		
		lbDato1 = new Label("Primer Nombre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		Label lblBusquedaPor = new Label("Busqueda por: ");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("118px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
		lblElijaElTipo = new Label("Elija el tipo de prestaciones a calcular");
		lblElijaElTipo.setStyleName("label");
		absolutePanel.add(lblElijaElTipo, 10, 61);
		lblElijaElTipo.setSize("179px", "13px");
		
		lblElijaElAo = new Label("Elija el año para calcular prestaciones");
		lblElijaElAo.setStyleName("label");
		absolutePanel.add(lblElijaElAo, 205, 61);
		lblElijaElAo.setSize("179px", "13px");
		
		lblFechaRegistro = new Label("Fecha Registro");
		lblFechaRegistro.setStyleName("label");
		absolutePanel.add(lblFechaRegistro, 463, 0);
		lblFechaRegistro.setSize("139px", "13px");
		
		lblDescripcionPequea = new Label("Descripcion(Opcional)");
		lblDescripcionPequea.setStyleName("label");
		absolutePanel.add(lblDescripcionPequea, 648, 0);
		lblDescripcionPequea.setSize("216px", "19px");
		
		lblCantidad = new Label("Cantidad");
		lblCantidad.setStyleName("label");
		absolutePanel.add(lblCantidad, 846, 0);
		lblCantidad.setSize("157px", "13px");
		
		lblFecha = new Label("Rango de Fecha para calculo de Bono 14 y Aguinaldo");
		lblFecha.setStyleName("label");
		absolutePanel.add(lblFecha, 401, 73);
		lblFecha.setSize("426px", "13px");
		
    	recursosHumanosService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-error", "Error en BD puestos\n"+caught);
    		}

			@Override
			public void onSuccess(List<AuxBDPuesto> results)
			{
				if (!(results.size()==0)) {
					auxbdPuestos = results;
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
					auxAfiliados = result;
		    	}
		    }
		});
		initWidget(grid);
		
	}
	
	public void Buscar()
	{
		grid.clearCell(1, 0);
		nuevo = new Prestaciones();
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			agregarFormulario('2',txtDato1.getText(), "","","",txtDato1.getText(),txtDato1.getText(),"");
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
					
					agregarFormulario('1',primerNombre, segundoNombre,primerApellido, segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}else if(nombreArray.length == 3){
					
					primerNombre = nombreArray[0];
					segundoNombre =  nombreArray[1];
					primerApellido =  nombreArray[2];
					segundoApellido = "";
					
					
					if(agregarFormulario('1',primerNombre, segundoNombre,primerApellido, 
							segundoApellido,txtDato1.getText(),txtDato1.getText(),""))
					{
						primerNombre = nombreArray[0];
						segundoNombre =  "";
						primerApellido =  nombreArray[1];
						segundoApellido = nombreArray[2];
						
						agregarFormulario('1',primerNombre, segundoNombre,primerApellido, 
								segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					}
					
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
					
				}else if(nombreArray.length == 4){
					primerNombre = nombreArray[0];
					segundoNombre = nombreArray[1];
					primerApellido =  nombreArray[2];
					segundoApellido = nombreArray[3];
					
					agregarFormulario('1',primerNombre, segundoNombre,primerApellido, segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
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
				agregarFormulario('3',txtDato1.getText(), "","", 
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
				agregarFormulario('4',txtDato1.getText(), "","", 
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
			agregarFormulario('5',txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
		{
			agregarFormulario('6',txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
		{
			agregarFormulario('7',txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}
	}
	
	 public boolean agregarFormulario(final char tipo, final String primer_nombre, String segundo_nombre, 
				String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,String Estado){

	        load.visible();
	    	recursosHumanosService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, 
							primer_apellido, segundo_apellido,DPI, Pasaporte,Estado,new AsyncCallback<List<AuxEmpleado>>(){
	            public void onFailure(Throwable caught) 
	            {
			        load.invisible();
	            	mensaje.setMensaje("alert alert-information alert-block", 
	            			"\nNo hay resultados");
	            }

				@Override
	            public void onSuccess( List<AuxEmpleado> result)
	            {
					bandera = !result.isEmpty();
					boolean error = true;
					String msj = "No hay resultados";
					
			        load.invisible();
			        
			        DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
			 		DateTimeFormat mes 	= DateTimeFormat.getFormat("MM");
			 		
			        String annio1 		= anio.format(dateFecha1.getValue());
			        String annio2 		= anio.format(dateFecha2.getValue());
			        
			        int meses			= (int) ((dateFecha2.getValue().getTime()-dateFecha1.getValue().getTime())/(1000*60*60*24*30));
			        int dias			= (int) ((dateFecha2.getValue().getTime()-dateFecha1.getValue().getTime())/(1000*60*60*24)); 
			        
			        if(annio1.equals(annio2)){
			        	error = false;
			        	msj = "rango de fechas debe ser del mismo año";
			        }else if(dateFecha2.getValue().getTime() > dateFecha1.getValue().getTime()){
			        	error = false;
			        	msj = "fecha 2 debe ser mayor a fecha 1";
			        }else if(dias <= 0){
			        	error = false;
			        	msj = "el calculo debe ser para mas de 1 dia";
			        }else if(meses >= 6){
			        	error = false;
			        	msj = "el calculo de prestaciones, no debe ser para mas de 6 meses";
			        }
			        
			        
			        
					if(!result.isEmpty() || error){
						Prestaciones(result,listTipoPrestaciones.getValue(listTipoPrestaciones.getSelectedIndex()),annio1);
						
					}else{
						mensaje.setMensaje("alert alert-information alert-block", "\n"+msj);
					}
	            }

	     });
	        load.invisible();

	        return bandera;

	    }
	 

	 	private void Prestaciones(List<AuxEmpleado> result, String tipo,String listAnio)
	 	{
	 		String nombre = "";
	 		float salarioBaseCalculo = 0;
	 		float enero = 0, eneroBono = 0;
	 		float febrero= 0 , febreroBono = 0;
	 		float marzo= 0, marzoBono = 0;
	 		float abril= 0, abrilBono = 0;
	 		float mayo= 0, mayoBono = 0;
	 		float junio= 0, junioBono = 0;
	 		float julio= 0, julioBono = 0;
	 		float agosto= 0, agostoBono = 0;
	 		float septiembre= 0, septiembreBono = 0;
	 		float octubre= 0, octubreBono = 0;
	 		float noviembre= 0, noviembreBono = 0;
	 		float diciembre= 0, diciembreBono = 0;
	 		
	 		boolean bEnero = true;
	 		boolean bFebrero = true;
	 		boolean bMarzo	= true;
	 		boolean bAbril = true;
	 		boolean bMayo = true;
	 		boolean bJunio = true;
	 		boolean bJulio = true;
	 		boolean bAgosto = true;
	 		boolean bSeptiembre = true;
	 		boolean bOctubre = true;
	 		boolean bNoviembre = true;
	 		boolean bDiciembre = true;
	 		
	 		DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
	 		DateTimeFormat mes 	= DateTimeFormat.getFormat("MM");
	 		//DateTimeFormat dia 	= DateTimeFormat.getFormat("dd");

	 		int ultimoAnnio = 0;
	 		int ultimoMes = 0;
	 		float ultimoSalario = 0;
	 		String formatAnio 	= "";
	 		String formatMes 	= "";
	 		//String formatDia 	= "";
	 		nuevo.limpiar();
	 		
	 		for(AuxEmpleado e:result)
	 		{
	 			nombre = e.getPrimer_nombre() +" "+ e.getSegundo_nombre() +" "+e.getPrimer_apellido() +" "+e.getSegundo_apellido(); 
	 			
	 			for(AuxSalario s:e.getSalario())
	 			{
	 				formatAnio = anio.format(new Date(s.getFecha()));
	 				formatMes  = mes.format(new Date(s.getFecha()));
	 				
	 				//verifico el ultimo salario que tiene el empleado, si en caso:
	 				//esto primero verificando que el año del ultimo salario, este no sea de una fecha despues de la que se quiere calcular
	 				//fecha del salario menor o igual que el año a calcular
	 				if(Integer.parseInt(formatAnio) <= Integer.parseInt(listAnio))
	 				{
	 					//luego de lo anterior verifico que el año del salario y el mes del salario a tomar en cuenta
	 					//es mayor o igual a la fecha del ultimo salario, si es asi, entonces ese salario sera el ultimo
	 					//y asi hasta encontrar el ultimo entre la fecha a calcular hasta antes de esa fecha
	 					if(Integer.parseInt(formatAnio) >= ultimoAnnio && Integer.parseInt(formatMes) >= ultimoMes)
	 					{
	 						ultimoAnnio 	= Integer.parseInt(formatAnio);
	 				 		ultimoMes 		= Integer.parseInt(formatMes);
	 				 		ultimoSalario 	=  s.getSalario();
	 					}
	 				}
	 				//*********************************************************************************
	 				/**
	 				 * por si cada mes no tuviera un salario en especifico, entonces se le asigna el ultimo salario calculado
	 				 * este salario para asignarle, el año debera ser menor o igual al año a calcular, y ademas el mes en 
	 				 * cuestion a asignarle el ultimo salario, el mes del ultimo salario debera ser menor o igual al mes al
	 				 * que se le va asignar el ultimo salario, en caso contrario ese mes, tendra salario = 0;
	 				 */
	 				//salario de enero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("01")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					enero = s.getSalario();
	 					bEnero = false;
	 				}else if(bEnero && s.getTipoSalario().equals("0") &&
	 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 01 && ultimoAnnio == Integer.parseInt(listAnio)) )
	 						)
	 				{
	 					enero = ultimoSalario;
	 				}
	 				
	 				//salario de febrero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("02")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					febrero = s.getSalario();
	 					bFebrero  = false;
	 				}else if(bFebrero && s.getTipoSalario().equals("0") &&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 02 && ultimoAnnio == Integer.parseInt(listAnio))) 
								)
	 				{
	 					febrero = ultimoSalario;
	 				}
	 				
	 				//salario de marzo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("03")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					marzo = s.getSalario();
	 					bMarzo  = false;
	 				}else if(bMarzo && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 03 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					marzo = ultimoSalario;
	 				}
	 				
	 				//salario de abril
	 				if(formatAnio.equals(listAnio) && formatMes.equals("04")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					abril = s.getSalario();
	 					bAbril  = false;
	 				}else if(bAbril && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 04 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					abril = ultimoSalario;
	 				}
	 				
	 				//salario de mayo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("05")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					mayo = s.getSalario();
	 					bMayo  = false;
	 				}else if(bMayo && s.getTipoSalario().equals("0") &&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 05 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					mayo = ultimoSalario;
	 				}
	 				
	 				//salario de junio
	 				if(formatAnio.equals(listAnio) && formatMes.equals("06")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
	 					bJunio  = false;
	 				}else if(bJunio && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 06 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					junio = ultimoSalario;
	 				}
	 				

	 				//salario de julio
	 				if(formatAnio.equals(listAnio) && formatMes.equals("07")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					julio = s.getSalario();
	 					bJulio  = false;
	 				}else if(bJulio && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 07 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					julio = ultimoSalario;
	 				}
	 				

	 				//salario de agosto
	 				if(formatAnio.equals(listAnio) && formatMes.equals("08")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					agosto = s.getSalario();
	 					bAgosto  = false;
	 				}else if(bAgosto && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 8 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					agosto = ultimoSalario;
	 				}
	 				

	 				//salario de septiembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("09")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					septiembre = s.getSalario();
	 					bSeptiembre  = false;
	 				}else if(bSeptiembre && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 9 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					septiembre = ultimoSalario;
	 				}
	 				

	 				//salario de Octubre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("10")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					octubre = s.getSalario();
	 					bOctubre  = false;
	 				}else if(bOctubre && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 10 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					octubre = ultimoSalario;
	 				}
	 				

	 				//salario de Noviembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("11")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					noviembre = s.getSalario();
	 					bNoviembre  = false;
	 				}else if(bNoviembre && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 11 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					noviembre = ultimoSalario;
	 				}
	 				

	 				//salario de Diciembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("12")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					diciembre = s.getSalario();
	 					bDiciembre  = false;
	 				}else if(bJunio && s.getTipoSalario().equals("0")&&
								(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 12 && ultimoAnnio == Integer.parseInt(listAnio)))
								)
	 				{
	 					diciembre = ultimoSalario;
	 				}
	 				
	 				

	 				//*********************************************************************************
	 				
	 				//*********************************************************************************
	 				//bonos de enero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("01")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					eneroBono += s.getSalario();
	 				}
	 				//bonos de febrero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("02")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					febreroBono += s.getSalario();
	 				}
	 				//bonos de marzo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("03")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					marzoBono += s.getSalario();
	 				}
	 				//bonos de abril
	 				if(formatAnio.equals(listAnio) && formatMes.equals("04")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					abrilBono += s.getSalario();
	 				}
	 				//bonos de mayo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("05")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					mayoBono += s.getSalario();
	 				}
	 				//bonos de junio
	 				if(formatAnio.equals(listAnio) && formatMes.equals("06")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					junioBono += s.getSalario();
	 				}
	 				//bonos de julio
	 				if(formatAnio.equals(listAnio) && formatMes.equals("07")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					julioBono += s.getSalario();
	 				}
	 				//bonos de agosto
	 				if(formatAnio.equals(listAnio) && formatMes.equals("08")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					agostoBono += s.getSalario();
	 				}
	 				//bonos de septiembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("09")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					septiembreBono += s.getSalario();
	 				}
	 				//bonos de octubre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("10")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					octubreBono += s.getSalario();
	 				}
	 				//bonos de noviembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("11")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					noviembreBono += s.getSalario();
	 				}
	 				//bonos de diciembre
	 				if(formatAnio.equals(listAnio) && formatMes.equals("12")
	 	 				   && s.getTipoSalario().equals("3"))
	 				{
	 					diciembreBono += s.getSalario();
	 				}
	 				//*********************************************************************************
	 				
	 				
	 			}//fin for salario
	 			enero 	= enero + eneroBono;
	 			febrero = febrero + febreroBono;
	 			marzo 	= marzo + marzoBono;
	 			abril 	= abril + abrilBono;
	 			mayo 	= mayo + mayoBono;
	 			junio 	= junio + junioBono;
	 			salarioBaseCalculo = (enero + febrero + marzo + abril + mayo + junio) / 6;

	 			if(tipo.equals("1") || tipo.equals("2") || tipo.equals("3")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, txtDescripcion.getText(),nombre
	 						,""+Cantidad.getText(), "1", "1",dateFecha.getValue());
	 			}if(tipo.equals("4")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Bono 14 del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365",dateFecha.getValue());
	 			}if(tipo.equals("5")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Aguinaldo del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365",dateFecha.getValue());
	 			}if(tipo.equals("6")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Vacaciones del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365",dateFecha.getValue());
	 			}if(tipo.equals("7")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Indemnizacion del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "14", "12",dateFecha.getValue());
	 			}
 			salarioBaseCalculo = 0;
 			enero = 0;
 			febrero = 0;
 			marzo = 0;
 			abril = 0;
 			mayo = 0;
 			junio = 0;
 			
 			eneroBono = 0;
 			febreroBono = 0;
 			marzoBono = 0;
 			abrilBono = 0;
 			mayoBono = 0;
 			junioBono = 0;
	 			

	 		 bEnero = true;
	 		 bFebrero = true;
	 		 bMarzo	= true;
	 		 bAbril = true;
	 		 bMayo = true;
	 		 bJunio = true;

	 		 ultimoAnnio = 0;
	 		 ultimoMes = 0;
	 		 ultimoSalario = 0;
	 		 formatAnio 	= "";
	 		 formatMes 	= "";
	 		}//fin for empleado

	        load.invisible();
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
						oracle.add(p.getPrimer_nombre()+" "+p.getSegundo_nombre()+" "+p.getPrimer_apellido()+" "+p.getSegundo_apellido());
					}
			    }
			
			});
		    return oracle;
	    }
}
