/**0
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
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;

public class CrearInformeBancos extends Composite   {

	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private Label lbDato1;
    private Image Busqueda;
    private SuggestBox txtDato1;
    private  ListBox listEstado ;
    private AbsolutePanel absolutePanel;
	public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
    private Loading load ;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private Label lblElijaElTipo;
    private ListBox listMes;
    private ListBox listAnnio;
	private FormPanel formPanel;
	private VerticalPanel verticalPanel;
    
    /**
     * constructor
     */
	public CrearInformeBancos() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
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
					absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(false);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 205, 16);

					grid.clearCell(1, 0);
//					agregarFormulario('2',txtDato1.getText(), "","", 
//							"",txtDato1.getText(),txtDato1.getText()
//							,"");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					lbDato1.setText("Ingrese No. Pasaporte");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 420, 19);
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

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					absolutePanel.add(Busqueda, 390, 19);
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
					buscar();
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
				buscar();
			}
		});
		
		listMes = new ListBox();
		//listMes.addItem("Decreto(78-89)", "1");
		listMes.addItem("Enero", "1");
		listMes.addItem("Febrero", "2");
		listMes.addItem("Marzo", "3");
		listMes.addItem("Abril", "4");
		listMes.addItem("Mayo", "5");
		listMes.addItem("Junio", "6");
		listMes.addItem("Julio", "7");
		listMes.addItem("Agosto", "8");
		listMes.addItem("Septiembre", "9");
		listMes.addItem("Octubre", "10");
		listMes.addItem("Noviembre", "1|");
		listMes.addItem("Diciembre", "11");
		listMes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listMes, 10, 94);
		listMes.setSize("179px", "39px");
						
		//absolutePanel.add(Busqueda, 984, 19);
		Busqueda.setSize("103px", "55px");
		
		lbDato1 = new Label("Escriba los nombres:");
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

		formPanel = new FormPanel();
		formPanel.setAction("/ExportBancos?tipo="+"0"
				+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
				+"&annio="+"2000"
				+"&primer_nombre="+"a"
				+"&segundo_nombre="+"a"
				+"&primer_apellido="+"a"
				+"&segundo_apellido="+"a"
				+"&DPI="+"a"
				+"&Pasaporte="+"a"
				+"&listMes="+"a");
		formPanel.setAction("/ExportBancos?tipo="+"0"+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex()));
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		
		verticalPanel = new VerticalPanel();
		formPanel.setWidget(verticalPanel);
		verticalPanel.setSize("208px", "43px");
        verticalPanel.add(Busqueda);
		absolutePanel.add(formPanel, 420, 21);
        formPanel.setSize("209px", "44px");
		
		
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
	public void buscar(){
		grid.clearCell(1, 0);
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			formPanel.setAction("/ExportBancos?tipo="+"2"
					+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
					+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex())
					+"&primer_nombre="+"a"
					+"&segundo_nombre="+"a"
					+"&primer_apellido="+"a"
					+"&segundo_apellido="+"a"
					+"&DPI="+"a"
					+"&Pasaporte="+"a"
					+"&listMes="+listMes.getValue(listMes.getSelectedIndex()));
			formPanel.submit();
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
		{

			String nombreArray[] = txtDato1.getText().split(" ");
			String primerNombre = "";
			String segundoNombre = "";
			String segundoApellido = "";
			String primerApellido =  "";

			try{
				 primerNombre = nombreArray[0];
				 segundoNombre =  nombreArray[1];
				 primerApellido =  nombreArray[2];
				 segundoApellido = nombreArray[3];
			}catch(Exception e){
				 primerNombre = "";
				 segundoNombre = "";
				 segundoApellido = "";
				 primerApellido =  "";
			}
			if(!txtDato1.getText().equals("")){

				formPanel.setAction("/ExportBancos?tipo="+"1"
						+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
						+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex())
						+"&primer_nombre="+primerNombre
						+"&segundo_nombre="+segundoNombre
						+"&primer_apellido="+primerApellido
						+"&segundo_apellido="+segundoApellido
						+"&DPI="+"a"
						+"&Pasaporte="+"a"
						+"&listMes="+listMes.getValue(listMes.getSelectedIndex()));
				formPanel.submit();
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba al menos un dato");
			}
		}else if(listBox.getValue(listBox.getSelectedIndex()).equals("Pasaporte"))
		{
			if(!txtDato1.getText().equals("") ){

				formPanel.setAction("/ExportBancos?tipo="+"3"
						+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
						+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex())
						+"&primer_nombre="+"a"
						+"&segundo_nombre="+"a"
						+"&primer_apellido="+"a"
						+"&segundo_apellido="+"a"
						+"&DPI="+"a"
						+"&Pasaporte="+txtDato1.getText()
						+"&listMes="+listMes.getValue(listMes.getSelectedIndex()));
				formPanel.submit();
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba el No pasaporte");
    		}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
		{

			if(!txtDato1.getText().equals("") ){
				formPanel.setAction("/ExportBancos?tipo="+"4"
						+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
						+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex())
						+"&primer_nombre="+"a"
						+"&segundo_nombre="+"a"
						+"&primer_apellido="+"a"
						+"&segundo_apellido="+"a"
						+"&DPI="+txtDato1.getText()
						+"&Pasaporte="+"a"
						+"&listMes="+listMes.getValue(listMes.getSelectedIndex()));
				formPanel.submit();
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba el DPI");
    		}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
		{

			formPanel.setAction("/ExportBancos?tipo="+"5"
					+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
					+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex())
					+"&primer_nombre="+"a"
					+"&segundo_nombre="+"a"
					+"&primer_apellido="+"a"
					+"&segundo_apellido="+"a"
					+"&DPI="+"a"
					+"&Pasaporte="+"a"
					+"&listMes="+listMes.getValue(listMes.getSelectedIndex()));
			formPanel.submit();
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
		{

			formPanel.setAction("/ExportBancos?tipo="+"6"
					+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
					+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex())
					+"&primer_nombre="+"a"
					+"&segundo_nombre="+"a"
					+"&primer_apellido="+"a"
					+"&segundo_apellido="+"a"
					+"&DPI="+"a"
					+"&Pasaporte="+"a"
					+"&listMes="+listMes.getValue(listMes.getSelectedIndex()));
			formPanel.submit();
		}
	}
//	 public void agregarFormulario(final char tipo, final String primer_nombre, String segundo_nombre, 
//				String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,String Estado){
//
//	        load.visible();
//	    	loginService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, 
//							primer_apellido, segundo_apellido,DPI, Pasaporte,Estado,new AsyncCallback<List<AuxEmpleado>>(){
//	            public void onFailure(Throwable caught) 
//	            {
//			        load.invisible();
//	            	mensaje.setMensaje("alert alert-information alert-block", "\nNo hay resultados");
//	            }
//
//				@Override
//	            public void onSuccess( List<AuxEmpleado> result)
//	            {
//					if(!result.isEmpty()){
//						//Bancos(result,listMes.getValue(listMes.getSelectedIndex()),listAnnio.getItemText(listAnnio.getSelectedIndex()));
//					}
//	            }
//
//	     });
//
//	    }
	 
//
//	 	private void Bancos(List<AuxEmpleado> result, String listMes,String listAnio)
//	 	{
//	 		String nombre = "";
//	 		int i = 0;
//	 		float salarioCalculo = 0;
//	 		float enero = 0, Bono = 0;
//	 		float febrero= 0 , marzo = 0;
//	 		float abril= 0, mayo = 0;
//	 		float junio= 0, julio = 0;
//	 		float agosto= 0, septiembre = 0;
//	 		float octubre= 0, noviembre = 0;
//	 		float diciembre= 0;
//	 		
//	 		boolean bEnero = true;
//	 		boolean bFebrero = true;
//	 		boolean bMarzo	= true;
//	 		boolean bAbril = true;
//	 		boolean bMayo = true;
//	 		boolean bJunio = true;
//	 		boolean bJulio = true;
//	 		boolean bAgosto = true;
//	 		boolean bSeptiembre = true;
//	 		boolean bOctubre = true;
//	 		boolean bNoviembre = true;
//	 		boolean bDiciembre = true;
//	 		
//	 		DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
//	 		DateTimeFormat mes 	= DateTimeFormat.getFormat("MM");
//	 		int ultimoAnnio = 0;
//	 		int ultimoMes = 0;
//	 		float ultimoSalario = 0;
//	 		String formatAnio 	= "";
//	 		String formatMes 	= "";
//	 		
//	 		for(AuxEmpleado e:result)
//	 		{
//	 			nombre = e.getPrimer_nombre() +" "+ e.getSegundo_nombre() +" "+e.getPrimer_apellido() +" "+e.getSegundo_apellido(); 
//	 			for(AuxSalario s:e.getSalario())
//	 			{
//	 				formatAnio = anio.format(new Date(s.getFecha()));
//	 				formatMes  = mes.format(new Date(s.getFecha()));
//	 				
//	 				//verifico el ultimo salario que tiene el empleado, si en caso:
//	 				//esto primero verificando que el año del ultimo salario, este no sea de una fecha despues de la que se quiere calcular
//	 				//fecha del salario menor o igual que el año a calcular
//	 				if(Integer.parseInt(formatAnio) <= Integer.parseInt(listAnio))
//	 				{
//	 					//luego de lo anterior verifico que el año del salario y el mes del salario a tomar en cuenta
//	 					//es mayor o igual a la fecha del ultimo salario, si es asi, entonces ese salario sera el ultimo
//	 					//y asi hasta encontrar el ultimo entre la fecha a calcular hasta antes de esa fecha
//	 					if(Integer.parseInt(formatAnio) >= ultimoAnnio && Integer.parseInt(formatMes) >= ultimoMes)
//	 					{
//	 						ultimoAnnio 	= Integer.parseInt(formatAnio);
//	 				 		ultimoMes 		= Integer.parseInt(formatMes);
//	 				 		ultimoSalario 	=  s.getSalario();
//	 					}
//	 				}
//	 				//*********************************************************************************
//	 				/**
//	 				 * por si cada mes no tuviera un salario en especifico, entonces se le asigna el ultimo salario calculado
//	 				 * este salario para asignarle, el año debera ser menor o igual al año a calcular, y ademas el mes en 
//	 				 * cuestion a asignarle el ultimo salario, el mes del ultimo salario debera ser menor o igual al mes al
//	 				 * que se le va asignar el ultimo salario, en caso contrario ese mes, tendra salario = 0;
//	 				 */
//	 				//salario de enero
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("01")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					enero = s.getSalario();
//	 					bEnero = false;
//	 				}else if(bEnero && s.getTipoSalario().equals("0") &&
//	 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 01 && ultimoAnnio == Integer.parseInt(listAnio)) )
//	 						)
//	 				{
//	 					enero = ultimoSalario;
//	 				}
//	 				
//	 				//salario de febrero
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("02")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					febrero = s.getSalario();
//	 					bFebrero  = false;
//	 				}else if(bFebrero && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 02 && ultimoAnnio == Integer.parseInt(listAnio))) 
// 							)
//	 				{
//	 					febrero = ultimoSalario;
//	 				}
//	 				
//	 				//salario de marzo
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("03")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					marzo = s.getSalario();
//	 					bMarzo  = false;
//	 				}else if(bMarzo && s.getTipoSalario().equals("0")&&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 03 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					marzo = ultimoSalario;
//	 				}
//	 				
//	 				//salario de abril
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("04")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					abril = s.getSalario();
//	 					bAbril  = false;
//	 				}else if(bAbril && s.getTipoSalario().equals("0")&&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 04 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					abril = ultimoSalario;
//	 				}
//	 				
//	 				//salario de mayo
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("05")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					mayo = s.getSalario();
//	 					bMayo  = false;
//	 				}else if(bMayo && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 05 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					mayo = ultimoSalario;
//	 				}
//	 				
//	 				//salario de junio
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("06")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					junio = s.getSalario();
//	 					bJunio  = false;
//	 				}else if(bJunio && s.getTipoSalario().equals("0")&&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 06 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					junio = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de julio
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("07")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					julio = s.getSalario();
//	 					bJulio  = false;
//	 				}else if(bJulio && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 07 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					julio = ultimoSalario;
//	 				}
//	 				
//	 				//salario de agosto
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("08")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					agosto = s.getSalario();
//	 					bAgosto  = false;
//	 				}else if(bAgosto && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 8 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					agosto = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de septiembre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("09")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					septiembre = s.getSalario();
//	 					bSeptiembre  = false;
//	 				}else if(bSeptiembre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 9 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					septiembre = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de octubre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("10")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					octubre = s.getSalario();
//	 					bOctubre  = false;
//	 				}else if(bOctubre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 10 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					octubre = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de noviembre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("11")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					noviembre = s.getSalario();
//	 					bNoviembre  = false;
//	 				}else if(bNoviembre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 11 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					noviembre = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de diciembre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("12")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					diciembre = s.getSalario();
//	 					bDiciembre  = false;
//	 				}else if(bDiciembre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 12 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					diciembre = ultimoSalario;
//	 				}
//	 				
//	 				//*********************************************************************************
//	 				
//	 				//*********************************************************************************
//	 				//bonos
//	 				if(formatAnio.equals(listAnio) && formatMes.equals(listMes)
//	 	 				   && s.getTipoSalario().equals("3"))
//	 				{
//	 					Bono += s.getSalario();
//	 				}
//	 				//*********************************************************************************
//	 				
//	 				
//	 			}//fin for salario
//	 			
//
// 				//****************************************calculo de planilla del mes a calcular*****************************************
//	 			
//	 			if(Integer.parseInt(listMes) == 01){
//	 				salarioCalculo = (float) (enero - (enero*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 02){
//	 				salarioCalculo = (float) (febrero- (febrero*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 03){
//	 				salarioCalculo = (float) (marzo - (marzo*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 04){
//	 				salarioCalculo = (float) (abril - (abril*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 05){
//	 				salarioCalculo = (float) (mayo - (mayo*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 06){
//	 				salarioCalculo = (float) (junio - (junio*4.83/100) + Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 07){
//	 				salarioCalculo = (float) (julio - (julio*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 8){
//	 				salarioCalculo = (float) (agosto - (agosto*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 9){
//	 				salarioCalculo = (float) (septiembre - (septiembre*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 10){
//	 				salarioCalculo = octubre + Bono;
//	 				
//	 			}else if(Integer.parseInt(listMes) == 11){
//	 				salarioCalculo = (float) (noviembre - (noviembre*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 12){
//	 				salarioCalculo = (float) (diciembre - (diciembre*4.83/100)+ Bono);
//	 				
//	 			}
//	 			String tipoCuenta = "";
//	 			if(e.getTipoCuenta().equals("0")){
//	 				tipoCuenta = "Ahorro";
//	 			}else{
//	 				tipoCuenta = "Monetaria";
//	 			}
//	 			//aqui se crea cada fila con sus respectivas columnas para el excel
//	 			enero = 0;
//	 			febrero = 0;
//	 			marzo = 0;
//	 			abril = 0;
//	 			mayo = 0;
//	 			junio = 0;
//	 			julio = 0;
//	 			agosto = 0;
//	 			septiembre = 0;
//	 			octubre = 0;
//	 			noviembre = 0;
//	 			diciembre = 0;
//	 			
//	 			Bono = 0;
//	 		}//fin for empleado
//	        load.invisible();
//	 	}
//	 	
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
