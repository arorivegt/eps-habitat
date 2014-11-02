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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class CrearPrestacionesLaborales extends Composite   {

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
    private prestaciones  nuevo;
	 public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
     private Loading load ;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private Label lblElijaElTipo;
    private ListBox listTipoPrestaciones;
    private Label lblElijaLasConfiguraciones;
    private Label lblElijaElAo;
    private ListBox listAnnio;
    
    /**
     * constructor
     */
	public CrearPrestacionesLaborales() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		grid.setSize("100%", "100%");
					
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
					nuevo = new prestaciones();
					agregarFormulario('2',txtDato1.getText(), "",txtDato2.getText(), 
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
						
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				grid.clearCell(1, 0);
				nuevo = new prestaciones();
				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					agregarFormulario('2',txtDato1.getText(), "",txtDato2.getText(), 
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
						agregarFormulario('1',txtDato1.getText(), "",txtDato2.getText(), 
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
						agregarFormulario('3',txtDato1.getText(), "",txtDato2.getText(), 
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
						agregarFormulario('4',txtDato1.getText(), "",txtDato2.getText(), 
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
					agregarFormulario('5',txtDato1.getText(), "",txtDato2.getText(), 
							txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
							,listEstado.getValue(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
				{
					agregarFormulario('6',txtDato1.getText(), "",txtDato2.getText(), 
							txtDato3.getText(),txtDato1.getText(),txtDato1.getText()
							,listEstado.getValue(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}
			}
		});
		
		listTipoPrestaciones = new ListBox();
		listTipoPrestaciones.addItem("Bono 14", "4");
		listTipoPrestaciones.addItem("Aguinaldo", "5");
		listTipoPrestaciones.addItem("Vacaciones", "6");
		listTipoPrestaciones.addItem("Indemnizacion", "7");
		listTipoPrestaciones.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoPrestaciones, 10, 94);
		listTipoPrestaciones.setSize("179px", "39px");
						
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
		
		lblElijaElTipo = new Label("Elija el tipo de prestaciones a calcular");
		lblElijaElTipo.setStyleName("label");
		absolutePanel.add(lblElijaElTipo, 10, 61);
		lblElijaElTipo.setSize("179px", "13px");
		
		lblElijaLasConfiguraciones = new Label("Elija las configuraciones que se le presentan, para realizar calculo de prestaciones, segun empleados elegidos, y el tipo de prestaciones a calcular");
		lblElijaLasConfiguraciones.setStyleName("label");
		absolutePanel.add(lblElijaLasConfiguraciones, 390, 79);
		lblElijaLasConfiguraciones.setSize("368px", "13px");
		
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
		listAnnio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listAnnio, 205, 94);
		listAnnio.setSize("179px", "39px");
		
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
	
	 public void agregarFormulario(final char tipo, final String primer_nombre, String segundo_nombre, 
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
					if(!result.isEmpty()){
						Prestaciones(result,listTipoPrestaciones.getValue(listTipoPrestaciones.getSelectedIndex()),
								listAnnio.getItemText(listAnnio.getSelectedIndex()));
					}
	            }

	     });

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
	 		DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
	 		DateTimeFormat mes 	= DateTimeFormat.getFormat("MM");
	 		//DateTimeFormat dia 	= DateTimeFormat.getFormat("dd");
	 		String formatAnio 	= "";
	 		String formatMes 	= "";
	 		//String formatDia 	= "";
	 		
	 		for(AuxEmpleado e:result)
	 		{
	 			nombre = e.getPrimer_nombre() +" "+ e.getPrimer_apellido() +" "+e.getSegundo_apellido(); 
	 			for(AuxSalario s:e.getSalario())
	 			{
	 				formatAnio = anio.format(new Date(s.getFecha()));
	 				formatMes  = mes.format(new Date(s.getFecha()));

	 				System.out.println(formatAnio);
	 				System.out.println(listAnio);
	 				
	 				System.out.println(formatMes);
	 				//*********************************************************************************
	 				//salario de enero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("01")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					enero = s.getSalario();
	 				}else if(enero != 0 && s.getTipoSalario().equals("0"))
	 				{
	 					enero = s.getSalario();
	 				}
	 				
	 				//salario de febrero
	 				if(formatAnio.equals(listAnio) && formatMes.equals("02")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					febrero = s.getSalario();
	 				}else if(enero != 0 &&  febrero == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					febrero = s.getSalario();
	 				}
	 				
	 				//salario de marzo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("03")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					marzo = s.getSalario();
	 				}else if(febrero != 0 &&  marzo == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					marzo = s.getSalario();
	 				}else if(enero != 0 &&  marzo == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					marzo = s.getSalario();
	 				}
	 				
	 				//salario de abril
	 				if(formatAnio.equals(listAnio) && formatMes.equals("04")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					abril = s.getSalario();
	 				}else if(marzo != 0 &&  abril == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					abril = s.getSalario();
	 				}else if(febrero != 0 &&  abril == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					abril = s.getSalario();
	 				}else if(enero != 0 &&  abril == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					abril = s.getSalario();
	 				}
	 				
	 				//salario de mayo
	 				if(formatAnio.equals(listAnio) && formatMes.equals("05")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					mayo = s.getSalario();
	 				}else if(abril != 0 &&  mayo == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					mayo = s.getSalario();
	 				}else if(marzo != 0 &&  mayo == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					mayo = s.getSalario();
	 				}else if(febrero != 0 &&  mayo == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					mayo = s.getSalario();
	 				}else if(enero != 0 &&  mayo == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					mayo = s.getSalario();
	 				}
	 				

	 				
	 				//salario de junio
	 				if(formatAnio.equals(listAnio) && formatMes.equals("06")
	 				   && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
	 				}else if(mayo != 0 &&  junio == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
	 				}else if(abril != 0 &&  junio == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
	 				}else if(marzo != 0 &&  junio == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
	 				}else if(febrero != 0 &&  junio != 0 && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
	 				}else if(enero != 0 &&  junio == 0 && s.getTipoSalario().equals("0"))
	 				{
	 					junio = s.getSalario();
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
	 			if(tipo.equals("4"))
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Bono 14 del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365");
	 			if(tipo.equals("5"))
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Aguinaldo del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365");
	 			if(tipo.equals("6"))
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Vacaciones del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365");
	 			if(tipo.equals("7"))
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Indemnizacion del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "181", "365");
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
	 		}//fin for empleado

	        load.invisible();
	 	}
	
}
