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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class SolicitudPermiso extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Long empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 List<AuxSolicitudPermiso> permiso = new ArrayList<AuxSolicitudPermiso> ();
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	 private Loading load ;
	 
    public SolicitudPermiso(Long emplead) {

    	this.empleado = emplead;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "85px");;
        flextable = new FlexTable();
        panel.add(flextable);
	}
	    
    public void agregarFormulario_Jefe(){
        load.visible();
    	flextable.clear();
		    	loginService.BDSolicitudesJefe(empleado,new AsyncCallback<List<AuxSolicitudPermiso>>(){
	                public void onFailure(Throwable caught) 
	                {
	    		        load.invisible();
	                	mensaje.setMensaje("alert alert-error", "Error !! \nal obtener datos Solicitante");
	                }

					@Override
	                public void onSuccess(List<AuxSolicitudPermiso> result)
	                {
	    		        load.invisible();
	    		        for(final AuxSolicitudPermiso n2:result){
	    		        	loginService.Empleado_Registrado(n2.getIdEmpleadoSolicitante(),new AsyncCallback<AuxEmpleado>(){
	    		                public void onFailure(Throwable caught) 
	    		                {
	    		                	mensaje.setMensaje("alert alert-error", "Error !! \nnombre ");
	    		    		        String dias  = "";
			    		        	dias = ""+((n2.getFecha2()-n2.getFecha1())/(1000*60*60*24));
							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(empleado);
							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
							    				   n2.getTipoPermisos(),"Empleado", dias,"0",
							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    		                }

	    						@Override
	    		                public void onSuccess(AuxEmpleado result)
	    		                {
	    							String nombre = result.getPrimer_nombre() + " "+result.getSegundo_nombre() + " "+result.getPrimer_apellido() + " "+result.getSegundo_apellido();

	    		    		        String dias  = "";
			    		        	dias = ""+((n2.getFecha2()-n2.getFecha1())/(1000*60*60*24));
							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(empleado);
							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
							    				   n2.getTipoPermisos(),nombre, dias,""+result.getTotal(),
							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    		                }

	    			    	}); 
	    		        }
	                }
					

		    	});			    
    		   
        load.invisible();
    }
    public void agregarFormulario_Empleado (){
        load.visible();
    	flextable.clear();
		    	loginService.BDSolicitudesEmpleado(empleado, new AsyncCallback<List<AuxSolicitudPermiso>>(){
	                public void onFailure(Throwable caught) 
	                {
	    		        load.invisible();
	                	mensaje.setMensaje("alert alert-error", "Error !! \nal obtener datos Solicitante");
	                }

					@Override
	                public void onSuccess(List<AuxSolicitudPermiso> result)
	                {
	    		        load.invisible();
	    		        for(final AuxSolicitudPermiso n2:result){
	    		        	loginService.Empleado_Registrado(n2.getIdEmpleadoSolicitante(),new AsyncCallback<AuxEmpleado>(){
	    		                public void onFailure(Throwable caught) 
	    		                {
	    		                	mensaje.setMensaje("alert alert-error", "Error !! \nnombre ");
	    		    		        String dias  = "";
			    		        	dias = ""+((n2.getFecha2()-n2.getFecha1())/(1000*60*60*24));
							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(empleado);
							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
							    				   n2.getTipoPermisos(),"Empleado", dias,"0",
							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
							    	fa.btnAceptar.setVisible(false);
							    	fa.btnAceptar.setEnabled(false);
							    	fa.btnNoAceptar.setVisible(false);
							    	fa.btnNoAceptar.setEnabled(false);
							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    		                }

	    						@Override
	    		                public void onSuccess(AuxEmpleado result)
	    		                {
	    							String nombre = result.getPrimer_nombre() + " "+result.getSegundo_nombre() + " "+result.getPrimer_apellido() + " "+result.getSegundo_apellido();

	    		    		        String dias  = "";
			    		        	dias = ""+((n2.getFecha2()-n2.getFecha1())/(1000*60*60*24));
							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(empleado);
							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
							    				   n2.getTipoPermisos(),nombre, dias,""+result.getTotal(),
							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
							    	fa.btnAceptar.setVisible(false);
							    	fa.btnAceptar.setEnabled(false);
							    	fa.btnNoAceptar.setVisible(false);
							    	fa.btnNoAceptar.setEnabled(false);
							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    		                }

	    			    	}); 
	    		        }
	                }

		    	});			    
    		   
        load.invisible();
    }
    //agrega todos los formularios de solicitudes
    public void agregarFormularios(){
        load.visible();
    	flextable.clear();
		    	loginService.BDSolicitudPermiso(new AsyncCallback<List<AuxSolicitudPermiso>>(){
	                public void onFailure(Throwable caught) 
	                {
	    		        load.invisible();
	                	mensaje.setMensaje("alert alert-error", "Error !! \nal obtener datos Solicitante");
	                }

					@Override
	                public void onSuccess(List<AuxSolicitudPermiso> result)
	                {
	    		        load.invisible();
	    		        for(final AuxSolicitudPermiso n2:result){
	    		        	loginService.Empleado_Registrado(n2.getIdEmpleadoSolicitante(),new AsyncCallback<AuxEmpleado>(){
	    		                public void onFailure(Throwable caught) 
	    		                {
	    		                	mensaje.setMensaje("alert alert-error", "Error !! \nnombre ");
	    		    		        String dias  = "";
			    		        	dias = ""+((n2.getFecha2()-n2.getFecha1())/(1000*60*60*24));
							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(empleado);
							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
							    				   n2.getTipoPermisos(),"Empleado", dias,"0",
							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'0');
							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    		                }

	    						@Override
	    		                public void onSuccess(AuxEmpleado result)
	    		                {
	    							String nombre = result.getPrimer_nombre() + " "+result.getSegundo_nombre() + " "+result.getPrimer_apellido() + " "+result.getSegundo_apellido();

	    		    		        String dias  = "";
			    		        	dias = ""+((n2.getFecha2()-n2.getFecha1())/(1000*60*60*24));
							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(empleado);
							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
							    				   n2.getTipoPermisos(),nombre, dias,""+result.getTotal(),
							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'0');
							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    		                }

	    			    	}); 
	    		        }
	                }

		    	});			    
    		   
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
