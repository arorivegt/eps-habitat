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

    private Grid grid;
    private Loading load;
    private Label lbDato1;
	private Mensaje mensaje; 
    private Image Busqueda;
    private ListBox listBox;
    private ListBox listMes;
    private ListBox listAnnio;
    private ListBox listEstado;
	private FormPanel formPanel;
    private SuggestBox txtDato1;
    private Label lblElijaElTipo;
    private AbsolutePanel absolutePanel;
	private VerticalPanel verticalPanel;
    private final SqlServiceAsync finanzasService = GWT.create(SqlService.class);
	public List <AuxBDPuesto> auxbdPuesto = new ArrayList<AuxBDPuesto>();	
	public List <AuxAfiliado> auxAfiliado = new ArrayList<AuxAfiliado>();	
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    
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
				    for (AuxBDPuesto p : auxbdPuesto) 
				    {
				    	listEstado.addItem(p.getNombre_puesto(),""+p.getId_puesto());
				    }
					lbDato1.setText("Seleccione el puesto");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					absolutePanel.add(Busqueda, 390, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un afiliado","0");
				    for (AuxAfiliado p : auxAfiliado) 
				    {
				    	listEstado.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
				    }
					lbDato1.setText("Seleccione el Afiliado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					absolutePanel.add(Busqueda, 390, 19);
			        load.invisible();
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
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		
		verticalPanel = new VerticalPanel();
		formPanel.setWidget(verticalPanel);
		verticalPanel.setSize("208px", "43px");
        verticalPanel.add(Busqueda);
		absolutePanel.add(formPanel, 420, 21);
        formPanel.setSize("209px", "44px");
		
		
    	recursosHumanosService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-success", "Error en BD puestos\n"+caught);
    		}

			@Override
			public void onSuccess(List<AuxBDPuesto> results)
			{
				if (!(results.size()==0)) {
					auxbdPuesto = results;
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
					auxAfiliado = result;
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

			String nombre = txtDato1.getText().replace(" ", ":");
			System.out.println(nombre);
			if(!txtDato1.getText().equals("")){

				formPanel.setAction("/ExportBancos?tipo="+"1"
						+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
						+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex())
						+"&primer_nombre="+nombre
						+"&segundo_nombre="+"a"
						+"&primer_apellido="+"a"
						+"&segundo_apellido="+"a"
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
		else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
		{ 
			formPanel.setAction("/ExportBancos?tipo="+"7"
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
	
 	MultiWordSuggestOracle createCountriesOracle()
	{
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
	    recursosHumanosService.Buscar_Empleado('2', "", "", "", "","", "","",new AsyncCallback<List<AuxEmpleado>>(){
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
