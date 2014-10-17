package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Grid;

public class TestForm extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
     private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     private List<AuxBDTest> valor = new ArrayList<AuxBDTest>();
     private final Button btnTest = new Button("Agregar");
     private final Grid grid = new Grid(1, 3);
	    
     public TestForm() {

 			mensaje = new Mensaje();
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        
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
	        Button btnAgregar = new Button("Agregar");
	        grid.setWidget(0, 2, btnAgregar);
	        
	        btnAgregar.setStyleName("sendButton");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario();
	        	}
	        });
	        
	        btnAgregar.setSize("227px", "34px");
	        IniciarLlenadoBaseDatosTest();
		}
	    
	    private void agregarFormulario(){
	    	flextable.clear();
	        flextable.setWidget(flextable.getRowCount(), 0, new CreacionBaseDatosTest(this));
	    }
	    
	    public void agregarFormulario_lleno(AuxBDTest n){
	    	flextable.clear();
	    	if (!n.equals(null)) {
	    		CreacionBaseDatosTest  fa = new CreacionBaseDatosTest(this);
					fa.LlenarDatos(n.getId_test(),n.getNombreTest(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
							""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
							""+n.getPregunta10(),n.getTipo_test(),n.getFecha_test());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    	}	    
	    }
	    
	    public void agregar_formularios(List<AuxBDTest> results){
	    	IniciarLlenadoBaseDatosTest();
	    	flextable.clear();
	    	if (!(results.size() == 0)) {
	    		valor = results;
			    for (AuxBDTest n : results) {
			    	FormularioTest de = new FormularioTest(this, n);
			    	flextable.setWidget(flextable.getRowCount(), 0,de);
			    }
			}			    
	    }
	    
	    
	    public void IniciarLlenadoBaseDatosTest(){
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
	    }

    	
}
