package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudPermiso;
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

public class SolicitudPermiso extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private SolicitudPermiso solicitudPermiso;
	 private Empleado empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 List<AuxSolicitudPermiso> permiso = new ArrayList<AuxSolicitudPermiso> ();
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	    private Loading load ;
		
	    public SolicitudPermiso(Empleado empleadoo) {

	    	solicitudPermiso = this;
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			mensaje = new Mensaje();
			this.empleado = empleadoo;
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");;
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
	        flextable.setWidget(flextable.getRowCount(), 0, new FormularioSolicitudPermiso(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxSolicitudPermiso> results){
	        load.visible();
	    	flextable.clear();
	    	if (!results.isEmpty()) {
	    		permiso = results;
			    for ( final AuxSolicitudPermiso n2 : results) {
			    	loginService.Empleado_Registrado(n2.getIdEmpleadoSolicitante(), new AsyncCallback<AuxEmpleado>(){
		                public void onFailure(Throwable caught) 
		                {
		    		        load.invisible();
		                	mensaje.setMensaje("alert alert-error", "Error !! \nal obtener datos Solicitante");
		                }

						@Override
		                public void onSuccess(AuxEmpleado result)
		                {
		    		        load.invisible();
							String nombre = result.getPrimer_nombre() +" "+result.getPrimer_apellido();
					    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(solicitudPermiso,empleado);
					    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
					    				   n2.getTipoPermisos(),nombre,""+result.getTotal());
					        flextable.setWidget(flextable.getRowCount(), 0,fa );
		                }

			    	});
			    }
	    	}	    
	        load.invisible();
	    }
	    
	    public void EliminarFormulario(final FormularioSolicitudPermiso fa, final Long id_empledo, final Long id){

	        load.visible();
			loginService.Eliminar_Vacaciones(id_empledo, id, new AsyncCallback<Long>(){
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
	    
	    public void EliminarFormulario(FormularioSolicitudPermiso fa){
	        load.visible();
	        flextable.remove(fa);
	        load.invisible();
	    }
	    

}
