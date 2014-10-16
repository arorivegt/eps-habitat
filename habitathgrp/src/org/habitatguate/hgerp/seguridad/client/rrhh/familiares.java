package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class familiares extends Composite  {

	private Grid grid;
	private Empleados empleado;
    private FlexTable flextable;
	private Button btnAgregarHermanoa;
	private VerticalPanel panel = new VerticalPanel();
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	
    public familiares(Empleados e) {

		this.empleado = e;
        initWidget(panel);
        panel.setSize("761px", "381px");
        flextable = new FlexTable();
        panel.add(flextable);
        grid = new Grid(1, 3);
        panel.add(grid);
        Button btnAgregar_pariente = new Button("Agregar hijo(a)");
        grid.setWidget(0, 0, btnAgregar_pariente);
        
        btnAgregar_pariente.setStyleName("sendButton");
        btnAgregar_pariente.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario("hijo(a)");
        	}
        });
        btnAgregar_pariente.setSize("267px", "34px");
        
        btnAgregarHermanoa = new Button("Agregar hermano(a)");
        grid.setWidget(0, 2, btnAgregarHermanoa);
        btnAgregarHermanoa.setStyleName("sendButton");
        btnAgregarHermanoa.setSize("295px", "34px");
        btnAgregarHermanoa.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario("hermano(a)");
        	}
        });
	}
    
    private void agregarFormulario(String pariente){
        flextable.setWidget(flextable.getRowCount(), 0, new formularioFamilia(pariente,this,empleado));  	
    }
    
    public void agregarFormulario_lleno(List<AuxFamilia> results){
    	boolean padre = false;
    	boolean madre = false;
    	boolean conyugue = false;
    	if (!results.isEmpty()) {
    		
		    for ( AuxFamilia n2 : results) {
		    		if(n2.getParentesco().equals("padre")) padre = true;
		    		else if(n2.getParentesco().equals("madre")) madre = true;
		    		else if(n2.getParentesco().equals("conyugue")) conyugue = true;
		    	 formularioFamilia fa = new  formularioFamilia(n2.getParentesco(),this,empleado);
		    	  fa.LlenarDatos(n2.getId_familia(),n2.getPrimer_apellido(),n2.getSegundo_apellido(),n2.getPrimer_nombre(),
		    					 n2.getSegundo_nombre(),n2.getOcupacion(),n2.getParentesco(),""+n2.getEdad());
		        flextable.setWidget(flextable.getRowCount(), 0,fa );
		    }
		    if(!padre){
				agregarFormulario("padre");
		    }
		    if(!madre){
				agregarFormulario("madre");
		    }
		    if(!conyugue){
				agregarFormulario("conyugue");
		    }
		    	
    	}else{
    		agregar_parientes_unicos();
    	}
    		
    }
    
    public void EliminarFormulario(final formularioFamilia fa, final Long id_empledo, final Long id){

		loginService.Eliminar_Familiar(id_empledo, id, new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) 
            {
            	fa.setMensaje("alert alert-error", 
            			"Error !! \nal eliminar");
                Window.alert("Error al ELiminar"+caught);
            }

			@Override
            public void onSuccess(Long result)
            {
            	fa.setMensaje("alert alert-success", 
            			"Eliminado\n exitosamente!!!");
                flextable.remove(fa);
            }

     });
    }
    
    public void EliminarFormulario(formularioFamilia fa){
    	flextable.remove(fa);
     }
   
  
    public void agregar_parientes_unicos(){

        //se agrega padre, madre, conyugue, los formularios estan vacios, y no son guardados aun 
    	//en la base de datos
		agregarFormulario("padre");
		agregarFormulario("madre");
		agregarFormulario("conyugue");
        
    }
 
    
    
}
