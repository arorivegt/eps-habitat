package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.datepicker.client.DateBox;

public class Desempeno extends Composite  {

     private Grid grid;
     private Grid grid_1;
     private Loading load ;
     private Button button;
     private Long idEmpleado;
     private Button btnTest;
	 private Mensaje mensaje; 
     public  Button btnAgregar;
     private DateBox dateFecha1;
     private DateBox dateFecha2;
     private VerticalPanel panel;
     private FlexTable flextable;
     public  boolean bandera = true;
     private List<AuxTest> auxTest = new ArrayList<AuxTest>();
     public  List<AuxBDTest> auxBDTest = new ArrayList<AuxBDTest>();
     private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
     
    public Desempeno(Long idEmpleadoo) {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		mensaje = new Mensaje();
        this.idEmpleado = idEmpleadoo;
        
        panel = new VerticalPanel();
        initWidget(panel);
        
        panel.setSize("761px", "85px");
        
        grid_1 = new Grid(1, 3);
        panel.add(grid_1);
        
        dateFecha1 = new DateBox();
        dateFecha1.setValue(new Date());
        dateFecha1.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
        dateFecha1.getDatePicker().setYearArrowsVisible(true);
        dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateFecha1.getDatePicker().setVisibleYearCount(100);
        dateFecha1.setStyleName("gwt-TextBox2");
        grid_1.setWidget(0, 0, dateFecha1);
        
        dateFecha2 = new DateBox();
        dateFecha2.setValue(new Date());
        dateFecha2.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
        dateFecha2.getDatePicker().setYearArrowsVisible(true);
        dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateFecha2.getDatePicker().setVisibleYearCount(100);
        dateFecha1.setSize("227px", "34px");
        dateFecha2.setStyleName("gwt-TextBox2");
        
        grid_1.setWidget(0, 1, dateFecha2);
        dateFecha2.setSize("227px", "34px");
        
        button = new Button("Agregar");
        button.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		load.visible();
        		
        		recursosHumanosService.getTest(idEmpleado, new AsyncCallback<List<AuxTest>>(){
                    public void onFailure(Throwable caught) 
                    {
                    }

    				@Override
                    public void onSuccess(List<AuxTest> result)
                    {
    					auxTest  = result;
                    }

    	         });
        		try{
	        		List<AuxTest> hist = new ArrayList<AuxTest> ();
	        		for(AuxTest h: auxTest)
	        		{
	        			Date aux = new Date(h.getFecha_test());
	        			if( (aux.after(dateFecha1.getValue())
	        				&& aux.before(dateFecha2.getValue())
	        				&& h.getTipo_test().equals("1")
	        				)
	        				||
	        				(aux.equals(dateFecha1.getValue())
	        				&& aux.equals(dateFecha2.getValue())
	        				&& h.getTipo_test().equals("1"))
		        		 )
		        			  
	        			{
	        				hist.add(h);
	        			}
	        		}
	        		//agregarFormularios
	        		if(!hist.isEmpty()){
	        			agregar_formularios(hist);
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
        button.setText("Buscar");
        button.setStyleName("sendButton");
        
        grid_1.setWidget(0, 2, button);
        button.setSize("227px", "34px");
        flextable = new FlexTable();
        panel.add(flextable);
        BDTest();

        grid = new Grid(1, 3);
        panel.add(grid);
        
        btnTest = new Button("Agregar");
        grid.setWidget(0, 0, btnTest);
        btnTest.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            	BDTest();
                agregar_formularios(auxTest);
        }
        });
        btnTest.setText("Ver Test");
        btnTest.setStyleName("sendButton");
        btnTest.setSize("227px", "34px");
        btnAgregar = new Button("Agregar");
        grid.setWidget(0, 2, btnAgregar);
        
        btnAgregar.setStyleName("sendButton");
        btnAgregar.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                        agregarFormulario();
                }
        });
        
        btnAgregar.setSize("227px", "34px");
        }
            
        private void agregarFormulario(){
	        load.visible();
            flextable.clear();
            flextable.setWidget(flextable.getRowCount(), 0, new FormularioPruebaPeriodo(this,idEmpleado));
	        load.invisible();
        }
        
        public void agregarFormulario_lleno(AuxTest n){
	        load.visible();
            flextable.clear();
            if (!n.equals(null)) {
                FormularioPruebaPeriodo  fa = new FormularioPruebaPeriodo(this,idEmpleado);
                        fa.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
                                        ""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
                                        ""+n.getPregunta10(), n.getEvaluador(),n.getBDtest(), n.getFecha_test());
                flextable.setWidget(flextable.getRowCount(), 0,fa );
                if(bandera){
                	fa.botonesVisibles(true);
                }else{
                	fa.botonesVisibles(false);
                }
            }   
	        load.invisible();        
        }
        
        public void agregar_formularios(List<AuxTest> results){

            load.visible();
            flextable.clear();
            if (!(results.size() == 0)) {
            auxTest = results;
                for (AuxTest n : results) {
                    FormularioDesempeno de = new FormularioDesempeno(this, n);
                    flextable.setWidget(flextable.getRowCount(), 0,de);
                }
            }

            load.invisible();
        }
        
        public void EliminarFormulario(final FormularioPruebaPeriodo fa, final Long id_empledo, final Long id){

            load.visible();
                    recursosHumanosService.Eliminar_Test(id_empledo, id, new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) 
            {
		        load.invisible();
                    fa.setMensaje("alert alert-error", 
                                    "Error !! \nal Eliminar");
               // Window.alert("Error al ELiminar"+caught);
            }

                            @Override
            public void onSuccess(Long result)
            {
                		        load.invisible();
                    fa.setMensaje("alert alert-success", 
                                    "Eliminado exitosamente!!!");
                    flextable.remove(fa);
            }

     });
                    load.invisible();
        }
        public void EliminarFormulario(FormularioPruebaPeriodo fa){
	        load.visible();
            flextable.remove(fa);
	        load.invisible();
        }
        
        private void BDTest(){

        	auxBDTest.clear();
	    	recursosHumanosService.BDTest(new AsyncCallback<List<AuxBDTest>>(){

				@Override
				public void onFailure(Throwable caught) {
					
				}

				@Override
				public void onSuccess(List<AuxBDTest> result) {
					if (!result.isEmpty()) {
						for(AuxBDTest a: result )
						{
							if(a.getTipo_test().equals("1"))
							{
								auxBDTest.add(a);
							}
						}
			    	}
					
				} 
			});
	    }
            
}