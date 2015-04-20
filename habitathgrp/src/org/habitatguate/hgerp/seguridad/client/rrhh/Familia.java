package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
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

public class Familia extends Composite  {

	private Mensaje mensaje; 
	private Grid grid;
	boolean valor = true;
	private Empleado empleado;
    private FlexTable flextable;
	private Button btnAgregarHermanoa;
	private Button btnAgregar_pariente;
	private VerticalPanel panel = new VerticalPanel();
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private Loading load ;
	
    public Familia(Empleado e) {

		mensaje = new Mensaje();
		this.empleado = e;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "381px");
        flextable = new FlexTable();
        panel.add(flextable);
        grid = new Grid(1, 3);
        panel.add(grid);
        btnAgregar_pariente = new Button("Agregar hijo(a)");
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
    	if(valor){
            load.visible();
            flextable.setWidget(flextable.getRowCount(), 0, new FormularioFamilia(pariente,this,empleado)); 
            load.invisible(); 
    	}
    }
    
    public void agregarFormulario_lleno(List<AuxFamilia> results){
    	boolean padre = false;
    	boolean madre = false;
    	boolean conyugue = false;
        load.visible();
    	if (!results.isEmpty()) {
    		
		    for ( AuxFamilia n2 : results) {
		    		if(n2.getParentesco().equals("padre")) padre = true;
		    		else if(n2.getParentesco().equals("madre")) madre = true;
		    		else if(n2.getParentesco().equals("conyugue")) conyugue = true;
		    	 FormularioFamilia fa = new  FormularioFamilia(n2.getParentesco(),this,empleado);
		    	 fa.btnhabilitar(valor);
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

        load.invisible();
    		
    }
    
    public void EliminarFormulario(final FormularioFamilia fa, final Long id_empledo, final Long id){

        load.visible();
		recursosHumanosService.Eliminar_Familiar(id_empledo, id, new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) 
            {
		        load.invisible();
            	mensaje.setMensaje("alert alert-error", 
            			"Error !! \nal eliminar");
            }

			@Override
            public void onSuccess(Long result)
            {
		        load.invisible();
				mensaje.setMensaje("alert alert-success", 
            			"Eliminado\n exitosamente!!!");
                flextable.remove(fa);
            }

     });
        load.visible();
    }
    
    public void EliminarFormulario(FormularioFamilia fa){
        load.visible();
    	flextable.remove(fa);
        load.invisible();
     }
   
  
    public void agregar_parientes_unicos(){

        //se agrega padre, madre, conyugue, los formularios estan vacios, y no son guardados aun 
    	//en la base de datos
		agregarFormulario("padre");
		agregarFormulario("madre");
		agregarFormulario("conyugue");
        
    }
 
    
    
}
