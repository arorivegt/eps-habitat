package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaPersonal;
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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class ReferenciaPersonal extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleado empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 private Loading load ;
	 boolean valor = true;;
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
		
	    public ReferenciaPersonal(Empleado empleado) {

			mensaje = new Mensaje();
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			this.empleado = empleado;
	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

	        initWidget(panel);
	        panel.setSize("761px", "79px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        Button btnAgregar = new Button("Agregar");
	        panel.add(btnAgregar);
	        
	        btnAgregar.setStyleName("sendButton");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario();
	        	}
	        });
	        
	        btnAgregar.setSize("227px", "34px");
		}
	    
	    private void agregarFormulario(){
	    	if(valor){
		        load.visible();
		        flextable.setWidget(flextable.getRowCount(), 0, new FormularioReferenciaPersonal(this,empleado));
		        load.invisible();
	    	}
	    }
	    
	    public void agregarFormulario_lleno(List<AuxReferenciaPersonal> results){
	        load.visible();
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxReferenciaPersonal n2 : results) {
			    	FormularioReferenciaPersonal fa = new  FormularioReferenciaPersonal(this,empleado);
			    	fa.LlenarDatos( n2.getId_referencia_personal(), n2.getNombre_referencia(), n2.getPuesto_candidato(), n2.getRelacion(),
			    					n2.getActitudes_cualidades(), ""+n2.getTelefono(),n2.getFecha1());
			    	fa.btnhinabilitar(valor);
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	   
	        load.invisible(); 
	    }
	    
	    public void EliminarFormulario(final FormularioReferenciaPersonal fa, final Long id_empledo, final Long id){

	        load.visible();
			loginService.Eliminar_Referencia_Personal(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
    		        load.invisible();
                	mensaje.setMensaje("alert alert-error", 
                			"Error !! \nal Eliminar");
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
	        load.invisible();
	    }
	    
	    public void EliminarFormulario(FormularioReferenciaPersonal fa){
	        load.visible();
    		flextable.remove(fa);
            load.invisible();
	 	}
}
