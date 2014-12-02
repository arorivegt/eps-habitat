package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Compartidas extends Composite  {

     private Loading load;
     private Mensaje inicio;
     private final Grid grid;
     private String nombre = "";
     private FlexTable flextable;
     private final Button btnTest;
     public boolean bandera = true;
     private Compartidas compartida;
     public Long id_EmpleadoPrincipal = 0L;
 	 private Desempeno desempeno = new Desempeno(0L);
     private VerticalPanel panel = new VerticalPanel();
	 private Evaluacion evaluacion = new Evaluacion(0L);
     public List<AuxBDTest> auxbdTest = new ArrayList<AuxBDTest>();
     private List<AuxTestCompartidos> auxTestCompartido = new ArrayList<AuxTestCompartidos>();
     private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);

     
     public Compartidas() {
    	grid = new Grid(1, 1);
    	
    	inicio=  new Mensaje();
    	
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
    	compartida = this;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        
        panel.setSize("761px", "85px");
        flextable = new FlexTable();
        panel.add(flextable);
        BDTest();
        
        panel.add(grid);
        grid.setWidth("233px");
        
   	    btnTest = new Button("Agregar");
        grid.setWidget(0, 0, btnTest);
        btnTest.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                        agregar_formularios(auxTestCompartido);
                }
        });
        btnTest.setText("Ver Test");
        btnTest.setStyleName("sendButton");
        btnTest.setSize("227px", "34px");
    }

    public void agregarFormularioLleno(AuxTest n,Long idEmpleado, String tipo){
        flextable.clear();
        if (tipo.equals("1")) 
        {
            FormularioPruebaPeriodo  fa = new FormularioPruebaPeriodo(desempeno,idEmpleado);
            
            fa.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
                            ""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
                            ""+n.getPregunta10(), n.getEvaluador(),n.getBDtest(), n.getFecha_test());
            flextable.setWidget(flextable.getRowCount(), 0,fa );
            fa.botonesVisibles(false);
        }else if(tipo.equals("2"))
        {
        	FormularioPruebaPeriodoDos  fa = new FormularioPruebaPeriodoDos(evaluacion,idEmpleado);
        	
            fa.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
                            ""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
                            ""+n.getPregunta10(), n.getEvaluador(),n.getBDtest(), n.getFecha_test());
            flextable.setWidget(flextable.getRowCount(), 0,fa );
            fa.botonesVisibles(false);
        }
    }
            
    public void agregar_formularios(List<AuxTestCompartidos> listAuxCompartido){

        load.visible();
        flextable.clear();
        
        if (!(listAuxCompartido.size() == 0)) {
        	auxTestCompartido = listAuxCompartido;
                
            for (final AuxTestCompartidos aux : listAuxCompartido) 
            {
            	recursosHumanosService.getTest(aux.getIdTest(),aux.getId_empleado(), new AsyncCallback<AuxTest>(){
                	
                	public void onFailure(Throwable caught) 
                	{
        		        load.invisible();
                		inicio.setMensaje("alert alert-error","No hay resultados ");
                	}

                	@Override
                	public void onSuccess(final AuxTest result)
                	{
                		recursosHumanosService.getEmpleado(aux.getId_empleado(), new AsyncCallback<AuxEmpleado>(){
                        	
                        	public void onFailure(Throwable caught) 
                        	{
                		        load.invisible();
                        		System.out.println("fracaso");
                        	}

                        	@Override
                        	public void onSuccess(AuxEmpleado resul)
                        	{
                        		nombre = resul.getPrimer_nombre() +" "+ resul.getPrimer_apellido() + " "+resul.getSegundo_apellido();
                            	FormularioTestCompartido de = new FormularioTestCompartido(result,compartida,aux.getId(),nombre);
                            	de.id_Empleado = aux.getId_empleado();
                                flextable.setWidget(flextable.getRowCount(), 0,de);
                        		System.out.println("exito"+nombre);
                        	}
                        });
                		
        		        load.invisible();
                	}
                });
            }
        }     

        load.invisible();
    }
         
    public void DejarCompartir(Long idEmpleadoPrincipal, Long idTestCompartido, final FormularioTestCompartido formularioTestCompartido){

        load.visible();
                
    	recursosHumanosService.QuitarCompartido(idEmpleadoPrincipal, idTestCompartido,  new AsyncCallback<String>(){
        	
        	public void onFailure(Throwable caught) 
        	{
		        load.invisible();
        		inicio.setMensaje("alert alert-error","Error en el servicio");
        	}

        	@Override
        	public void onSuccess(String result)
        	{
		        load.invisible();
        		inicio.setMensaje("alert alert-success",result);
    	        BDTest();
        		remover(formularioTestCompartido);
        	}
        });
        load.invisible();
    }
    
    public void remover(FormularioTestCompartido formularioTestCompartido){
    	flextable.remove(formularioTestCompartido);
    }
            
    private void BDTest(){

        load.visible();
    	recursosHumanosService.BDTest(new AsyncCallback<List<AuxBDTest>>(){

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(List<AuxBDTest> result) {
				if (!result.isEmpty()) {
					for(AuxBDTest aux: result )
					{
						if(aux.getTipo_test().equals("1"))
						{
							auxbdTest.add(aux);
						}
					}
		    	}
				
			} 
		});

        load.invisible();
    }
            
}