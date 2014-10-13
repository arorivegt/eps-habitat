package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Grid;

public class Compartidas extends Composite  {

     private FlexTable flextable;
     private VerticalPanel panel = new VerticalPanel();
     private final LoginServiceAsync loginService = GWT.create(LoginService.class);
     private List<AuxTestCompartidos> valor = new ArrayList<AuxTestCompartidos>();
     public List<AuxBDTest> BDresult = new ArrayList<AuxBDTest>();
     private final Button btnTest = new Button("Agregar");
     private final Grid grid = new Grid(1, 1);
     private Compartidas compartida;
     public boolean bandera = true;
     
            public Compartidas() {
            	compartida = this;
                initWidget(panel);
                panel.setSize("761px", "85px");
                flextable = new FlexTable();
                panel.add(flextable);
    	        BDTest();
                panel.add(grid);
                grid.setWidget(0, 0, btnTest);
                btnTest.addClickHandler(new ClickHandler() {
                        public void onClick(ClickEvent event) {
                                agregar_formularios(valor);
                        }
                });
                btnTest.setText("Ver Test");
                btnTest.setStyleName("sendButton");
                btnTest.setSize("227px", "34px");
                }

            public void agregarFormulario_lleno(AuxTest n,Long idEmpleado, String tipo){
                flextable.clear();
                if (tipo.equals("1")) {
                	Desempeno d = new Desempeno(0L);
                    Window.alert("Listo");
                    formularioPruebaPeriodo  fa = new formularioPruebaPeriodo(d,idEmpleado);
                    fa.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
                                    ""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
                                    ""+n.getPregunta10(), n.getEvaluador(),n.getBDtest(), n.getFecha_test());
                    flextable.setWidget(flextable.getRowCount(), 0,fa );
                    fa.botonesVisibles(false);
                }else if(tipo.equals("2")){
                	Evaluacion e = new Evaluacion(0L);
                	formularioPruebaPeriodoDos  fa = new formularioPruebaPeriodoDos(e,idEmpleado);
                    fa.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
                                    ""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
                                    ""+n.getPregunta10(), n.getEvaluador(),n.getBDtest(), n.getFecha_test());
	                flextable.setWidget(flextable.getRowCount(), 0,fa );
	                fa.botonesVisibles(false);
                }
            }
            
            public void agregar_formularios(List<AuxTestCompartidos> results){
                flextable.clear();
                if (!(results.size() == 0)) {
                	valor = results;
                        
                    for (final AuxTestCompartidos n : results) 
                    {
                    	loginService.getTest(n.getIdTest(),n.getId_empleado(), new AsyncCallback<AuxTest>(){
                        	
                        	public void onFailure(Throwable caught) 
                        	{
                        		Window.alert("No hay resultados "+caught);
                        	}

                        	@Override
                        	public void onSuccess(AuxTest result)
                        	{
                            	formularioTest de = new formularioTest(result,compartida);
                            	de.id_Empleado = n.getId_empleado();
                                flextable.setWidget(flextable.getRowCount(), 0,de);
                        	}
                        });
                    }
                }                           
            }
            
         
            
            private void BDTest(){
    	    	loginService.BDTest(new AsyncCallback<List<AuxBDTest>>(){

    				@Override
    				public void onFailure(Throwable caught) {
    					
    				}

    				@Override
    				public void onSuccess(List<AuxBDTest> result) {
    					//System.out.println("___"+result.isEmpty());
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