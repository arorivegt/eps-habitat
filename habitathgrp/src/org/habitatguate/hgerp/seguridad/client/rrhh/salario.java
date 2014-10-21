package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxIdioma;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class salario extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleados empleado;
	 private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     private Button btnComision;
		
	    public salario(Empleados e) {

			mensaje = new Mensaje();
			this.empleado = e;
	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        
	        btnComision = new Button("Agregar");
	        btnComision.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario("Comision");
	        	}
	        });
	        btnComision.setText("Comision");
	        btnComision.setStyleName("sendButton");
	        panel.add(btnComision);
	        btnComision.setSize("227px", "34px");
	        Button btnGastos = new Button("Agregar");
	        btnGastos.setText("otros Gastos");
	        panel.add(btnGastos);
	        
	        btnGastos.setStyleName("sendButton");
	        btnGastos.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario("Gasto");
	        	}
	        });
	        
	        btnGastos.setSize("227px", "34px");
		}
	    
	    private void agregarFormulario(String tipo){
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioSalario(this,empleado,tipo));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxSalario> results){
	    	boolean salarioBase = false;
	    	boolean decreto = false;
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxSalario n2 : results) {
			    	if(n2.getTipoSalario().equals("Salario Base")){
			    		salarioBase = true;
			    	}else if(n2.getTipoSalario().equals("Decreto(78-89)")){
			    		decreto = true;
			    	}
			    	formularioSalario fa = new  formularioSalario(this,empleado,"");
			    	fa.LlenarDatos(n2.getId_Salario(), ""+n2.getSalario(),n2.getAnio(), n2.getTipoSalario(),n2.getDescripcion());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	
	    	if(!salarioBase){
		    	formularioSalario fa = new  formularioSalario(this,empleado,"Salario Base");
		        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    	}if(!decreto){
		    	formularioSalario fa = new  formularioSalario(this,empleado,"Decreto(78-89)");
		        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    	}
	    	
	    }
	    
	    public void EliminarFormulario(final formularioIdiomas fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Idioma(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                	mensaje.setMensaje("alert alert-error", 
                			"Error !! \nal Eliminar");
                }

				@Override
                public void onSuccess(Long result)
                {
					mensaje.setMensaje("alert alert-success", 
                			"Eliminado\n exitosamente!!!");
        	        flextable.remove(fa);
                }

         });
	    }
	    
	    public void EliminarFormulario(formularioIdiomas fa){
        	        flextable.remove(fa);
	    }
}
