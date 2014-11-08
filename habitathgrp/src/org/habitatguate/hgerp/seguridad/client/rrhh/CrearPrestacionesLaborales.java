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

	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private Label lbDato1;
    private Image Busqueda;
    private SuggestBox txtDato1;
    private  ListBox listEstado ;
	boolean bandera = false;
    private AbsolutePanel absolutePanel;
    private prestaciones  nuevo;
	public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
    private Loading load ;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private Label lblElijaElTipo;
    private ListBox listTipoPrestaciones;
    private Label lblElijaElAo;
    private ListBox listAnnio;
    private DateBox fecha;
    private Label label;
    private TextBox txtDescripcion;
    private Label lblDescripcionPequea;
    private TextBox Cantidad;
    private Label lblCantidad;
    
    /**
     * constructor
     */
	public CrearPrestacionesLaborales() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		nuevo = new prestaciones();
		grid.setSize("1117px", "100%");
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "98px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
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
				    for (AuxBDPuesto p : BDpuestos) 
				    {
				    	listEstado.addItem(p.getNombre_puesto(),""+p.getId_puesto());
				    }
					lbDato1.setText("Seleccione el puesto");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
				}
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
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
		//listTipoPrestaciones.addItem("Decreto(78-89)", "1");
		listTipoPrestaciones.addItem("Comisiones", "2");
		listTipoPrestaciones.addItem("Bonificacion", "3");
		listTipoPrestaciones.addItem("Bono 14", "4");
		listTipoPrestaciones.addItem("Aguinaldo", "5");
		//listTipoPrestaciones.addItem("Vacaciones", "6");
		//listTipoPrestaciones.addItem("Indemnizacion", "7");
		listTipoPrestaciones.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoPrestaciones, 10, 94);
		listTipoPrestaciones.setSize("179px", "39px");
						
		absolutePanel.add(Busqueda, 470, 78);
		Busqueda.setSize("103px", "55px");
		
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
		
		fecha = new DateBox();
		fecha.getTextBox().setReadOnly(true);
		fecha.setValue(new Date());
		fecha.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		fecha.getDatePicker().setYearArrowsVisible(true);
		fecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		fecha.getDatePicker().setVisibleYearCount(100);
		fecha.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(fecha, 463, 17);
		fecha.setSize("177px", "41px");
		
		label = new Label("Fecha");
		label.setStyleName("label");
		absolutePanel.add(label, 463, 0);
		label.setSize("139px", "13px");
		
		txtDescripcion = new TextBox();
		txtDescripcion.setStyleName("gwt-TextBox2");
		txtDescripcion.setMaxLength(100);
		absolutePanel.add(txtDescripcion, 648, 19);
		txtDescripcion.setSize("177px", "39px");
		
		lblDescripcionPequea = new Label("Descripcion Pequeña");
		lblDescripcionPequea.setStyleName("label");
		absolutePanel.add(lblDescripcionPequea, 648, 0);
		lblDescripcionPequea.setSize("157px", "13px");
		
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
		
		lblCantidad = new Label("Cantidad");
		lblCantidad.setStyleName("label");
		absolutePanel.add(lblCantidad, 846, 0);
		lblCantidad.setSize("157px", "13px");
		
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
	
	public void Buscar()
	{
		grid.clearCell(1, 0);
		nuevo = new prestaciones();
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			agregarFormulario('2',txtDato1.getText(), "","", 
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
		}
	}
	
	 public boolean agregarFormulario(final char tipo, final String primer_nombre, String segundo_nombre, 
				String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,String Estado){

	        load.visible();
	    	loginService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, 
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
			        load.invisible();
					if(!result.isEmpty()){
						Prestaciones(result,listTipoPrestaciones.getValue(listTipoPrestaciones.getSelectedIndex()),
								listAnnio.getItemText(listAnnio.getSelectedIndex()));
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
	 		
	 		boolean bEnero = true;
	 		boolean bFebrero = true;
	 		boolean bMarzo	= true;
	 		boolean bAbril = true;
	 		boolean bMayo = true;
	 		boolean bJunio = true;
	 		
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
	 				//*********************************************************************************
	 				
	 				
	 			}//fin for salario
	 			enero 	= enero + eneroBono;
	 			febrero = febrero + febreroBono;
	 			marzo 	= marzo + marzoBono;
	 			abril 	= abril + abrilBono;
	 			mayo 	= mayo + mayoBono;
	 			junio 	= junio + junioBono;
	 			salarioBaseCalculo = (enero + febrero + marzo + abril + mayo + junio) / 6;

	 			if(tipo.equals("2") || tipo.equals("3")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, txtDescripcion.getText(),nombre
	 						,""+Cantidad.getText(), "1", "1",fecha.getValue());
	 			}if(tipo.equals("4")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Bono 14 del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365",fecha.getValue());
	 			}if(tipo.equals("5")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Aguinaldo del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365",fecha.getValue());
	 			}if(tipo.equals("6")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Vacaciones del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365",fecha.getValue());
	 			}if(tipo.equals("7")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Indemnizacion del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365",fecha.getValue());
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
		    
		    loginService.Buscar_Empleado('2', "", "", 
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
