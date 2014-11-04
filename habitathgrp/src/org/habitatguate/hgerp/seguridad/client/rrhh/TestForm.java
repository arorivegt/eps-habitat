package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;

public class TestForm extends Composite  {

	 private FlexTable flextable;
     private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     private List<AuxBDTest> valor = new ArrayList<AuxBDTest>();
     private final Button btnTest = new Button("Agregar");
     private final Grid grid = new Grid(1, 3);
     private Loading load ;
     private final Grid grid_1 = new Grid(1, 4);
     private final DateBox dateFecha1 = new DateBox();
     private final DateBox dateFecha2 = new DateBox();
     private final ListBox listTipo = new ListBox();
     private final Button btnBuscar = new Button("Agregar");
	 private Mensaje mensaje; 
	    
     public TestForm() {

     	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		scrollPanel.setSize("100%", "1000px");
		initWidget(scrollPanel);
        panel.setSize("100%", "177px");
        
        panel.add(grid_1);
        dateFecha1.setStyleName("gwt-TextBox2");
        
        grid_1.setWidget(0, 0, dateFecha1);
        dateFecha1.setSize("227px", "34px");
        dateFecha2.setStyleName("gwt-TextBox2");
		dateFecha1.getTextBox().setReadOnly(true);
        dateFecha1.setValue(new Date());
        dateFecha1.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
        dateFecha1.getDatePicker().setYearArrowsVisible(true);
        dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateFecha1.getDatePicker().setVisibleYearCount(100);
        
        grid_1.setWidget(0, 1, dateFecha2);
        dateFecha2.setSize("227px", "34px");
        dateFecha2.getTextBox().setReadOnly(true);
        dateFecha2.setValue(new Date());
        dateFecha2.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
        dateFecha2.getDatePicker().setYearArrowsVisible(true);
        dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateFecha2.getDatePicker().setVisibleYearCount(100);
        
        listTipo.addItem("Desempeño","1");
        listTipo.addItem("Evaluacion","2");
        listTipo.setStyleName("gwt-TextBox2");
        
        grid_1.setWidget(0, 2, listTipo);
        listTipo.setSize("229px", "36px");
        btnBuscar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		IniciarLlenadoBaseDatosTest();
        		try{

	        		List<AuxBDTest> vacacio = new ArrayList<AuxBDTest> ();
        		for(AuxBDTest h: valor)
        		{
        			Date aux = new Date(h.getFecha_test());
        			if(aux.after(dateFecha1.getValue())
        			&& aux.before(dateFecha2.getValue())
        			&& h.getTipo_test().equals(listTipo.getValue(listTipo.getSelectedIndex()))
        			||(aux.equals(dateFecha1.getValue())||aux.equals(dateFecha2.getValue())))
        			{
        				vacacio.add(h);
        			}
    	        			
        		}
        		//agregarFormularios
        		if(!vacacio.isEmpty()){
        			agregar_formularios(vacacio);
        		}else{
    		        load.invisible();
                	mensaje.setMensaje("alert alert-error", 
                			"No se encontro resultado");
        		}
        		}catch(Exception e){

    		        load.invisible();
                	mensaje.setMensaje("alert alert-error", 
                			"No se encontro resultado");
	        	}


                load.invisible();
        		
        	}
        });
        btnBuscar.setText("Buscar");
        btnBuscar.setStyleName("sendButton");
        
        grid_1.setWidget(0, 3, btnBuscar);
        btnBuscar.setSize("227px", "34px");
        flextable = new FlexTable();
        panel.add(flextable);
        flextable.setSize("100%", "82px");
        
        panel.add(grid);
        grid.setWidth("632px");
        grid.setWidget(0, 0, btnTest);
        btnTest.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregar_formularios(valor);
        	}
        });
        btnTest.setText("Ver Test");
        btnTest.setStyleName("sendButton");
        btnTest.setSize("227px", "34px");
        Button btnAgregar = new Button("Agregar");
        grid.setWidget(0, 2, btnAgregar);
        
        btnAgregar.setStyleName("sendButton");
        btnAgregar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario();
        	}
        });
        
        btnAgregar.setSize("227px", "34px");
		scrollPanel.setWidget(panel);
        IniciarLlenadoBaseDatosTest();
	}
	    
	    private void agregarFormulario(){
	        load.visible();
	    	flextable.clear();
	        flextable.setWidget(flextable.getRowCount(), 0, new CreacionBaseDatosTest(this));
	        load.invisible();
	    }
	    
	    public void agregarFormulario_lleno(AuxBDTest n){
	        load.visible();
	    	flextable.clear();
	    	if (!n.equals(null)) {
	    		CreacionBaseDatosTest  fa = new CreacionBaseDatosTest(this);
					fa.LlenarDatos(n.getId_test(),n.getNombreTest(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
							""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
							""+n.getPregunta10(),n.getTipo_test(),n.getFecha_test());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    	}	   
	        load.invisible(); 
	    }
	    
	    public void agregar_formularios(List<AuxBDTest> results){
	        load.visible();
	        IniciarLlenadoBaseDatosTest();
	    	flextable.clear();
	    	if (!(results.size() == 0)) {
			    for (AuxBDTest n : results) {
			    	FormularioTest de = new FormularioTest(this, n);
			    	flextable.setWidget(flextable.getRowCount(), 0,de);
			    }
			}		
	        load.invisible();	    
	    }
	    
	    
	    public void IniciarLlenadoBaseDatosTest(){
	        load.visible();
	    	loginService.BDTest(new AsyncCallback<List<AuxBDTest>>(){
                public void onFailure(Throwable caught) 
                {
                }

				@Override
                public void onSuccess(List<AuxBDTest> result)
                {
					valor.clear();
					valor = result;
                }

	    	});
	        load.invisible();
	    }

    	
}
