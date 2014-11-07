package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Grid;

public class Desempeno extends Composite  {

     private FlexTable flextable;
     private Long empleado;
     private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     private List<AuxTest> valor = new ArrayList<AuxTest>();
     public List<AuxBDTest> BDresult = new ArrayList<AuxBDTest>();
     private final Button btnTest = new Button("Agregar");
     private final Grid grid = new Grid(1, 3);
     public Button btnAgregar;
     private Loading load ;
     public boolean bandera = true;
     
    public Desempeno(Long e) {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        this.empleado = e;
        initWidget(panel);
        panel.setSize("761px", "85px");
        flextable = new FlexTable();
        panel.add(flextable);
        BDTest();
        panel.add(grid);
        grid.setWidget(0, 0, btnTest);
        btnTest.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            	BDTest();
                agregar_formularios(valor);
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
            flextable.setWidget(flextable.getRowCount(), 0, new formularioPruebaPeriodo(this,empleado));
	        load.invisible();
        }
        
        public void agregarFormulario_lleno(AuxTest n){
	        load.visible();
            flextable.clear();
            if (!n.equals(null)) {
                formularioPruebaPeriodo  fa = new formularioPruebaPeriodo(this,empleado);
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
            valor = results;
                for (AuxTest n : results) {
                    formularioDesempeno de = new formularioDesempeno(this, n);
                    flextable.setWidget(flextable.getRowCount(), 0,de);
                }
            }

            load.invisible();
        }
        
        public void EliminarFormulario(final formularioPruebaPeriodo fa, final Long id_empledo, final Long id){

            load.visible();
                    loginService.Eliminar_Test(id_empledo, id, new AsyncCallback<Long>(){
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
                    //Window.alert("Eliminado exitosamente!!! ");
                    flextable.remove(fa);
            }

     });
                    load.invisible();
        }
        public void EliminarFormulario(formularioPruebaPeriodo fa){
	        load.visible();
            flextable.remove(fa);
	        load.invisible();
        }
        
        private void BDTest(){

        	BDresult.clear();
	    	loginService.BDTest(new AsyncCallback<List<AuxBDTest>>(){

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
								BDresult.add(a);
							}
						}
			    	}
					
				} 
			});
	    }
            
}