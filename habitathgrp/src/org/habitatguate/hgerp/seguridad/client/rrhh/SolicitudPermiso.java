package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
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
	 private float totalDias = 0.0f;
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

	    		        			loginService.getPuestoActivo(n2.getIdEmpleadoSolicitante(), new AsyncCallback<AuxPuesto>(){
	    		        	            public void onFailure(Throwable caught) 
	    		        	            {
	    		        			        load.invisible();
	    		        	            	mensaje.setMensaje("alert alert-error", "Error !! \nal calcular dias de descanso");
	    		        	            }

	    		        				@SuppressWarnings("deprecation")
	    		        				@Override
	    		        	            public void onSuccess(AuxPuesto result)
	    		        	            {
	    		        			        load.invisible();
	    		        			        Long fech1 = n2.getFecha1();
	    		        			        Long fech2 = n2.getFecha2();
	    		        			        Date f1 = new Date(fech1);
	    		        					Date f2 = new Date(fech2);
	    			    			        float dias			= 0.0f;

	    		        					while(f1.before(f2) || f1.getTime() == f2.getTime()){
	    		        						
	    		        						int diaNumero = f1.getDay();
	    		        						dias =dias+1f;

	    		        						if(result.getDomingo().equals("0") && diaNumero == 0){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getDomingo().equals("1") && diaNumero == 0){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getLunes().equals("0") && diaNumero == 1){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getLunes().equals("1") && diaNumero == 1){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMartes().equals("0") && diaNumero == 2){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMartes().equals("1") && diaNumero == 2){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMiercoles().equals("0") && diaNumero == 3){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMiercoles().equals("1") && diaNumero == 3){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getJueves().equals("0") && diaNumero == 4){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getJueves().equals("1") && diaNumero == 4){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getViernes().equals("0") && diaNumero == 5){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getViernes().equals("1") && diaNumero == 5){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getSabado().equals("0") && diaNumero == 6){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getSabado().equals("1") && diaNumero == 6){
	    		        							totalDias =totalDias +0.50f;
	    		        						}
	    		        						
	    		        						fech1 = fech1 + 1*24*60*60*1000;
	    		        						f1 = new Date(fech1);
	    		        					}

	    			    			        float diasDescanso 	= totalDias;
	    			    			        dias = dias - diasDescanso;
	    			    			       
	    							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(n2.getId_Empleado());
	    							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
	    							    				   n2.getTipoPermisos(),"Empleado", ""+dias,"0",
	    							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
	    							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    							    	fa.btnEnterado.setVisible(false);
	    							    	fa.btnEnterado.setEnabled(false);
	    							    	totalDias = 0.0f;
	    		        	            }
	    		        				});
	    		                }

	    						@Override
	    		                public void onSuccess(final AuxEmpleado result2)
	    		                {

	    		        			loginService.getPuestoActivo(n2.getIdEmpleadoSolicitante(), new AsyncCallback<AuxPuesto>(){
	    		        	            public void onFailure(Throwable caught) 
	    		        	            {
	    		        			        load.invisible();
	    		        	            	mensaje.setMensaje("alert alert-error", "Error !! \nal calcular dias de descanso");
	    		        	            }

	    		        				@SuppressWarnings("deprecation")
	    		        				@Override
	    		        	            public void onSuccess(AuxPuesto result)
	    		        	            {
	    		        			        load.invisible();
	    		        			        Long fech1 = n2.getFecha1();
	    		        			        Long fech2 = n2.getFecha2();
	    		        			        Date f1 = new Date(fech1);
	    		        					Date f2 = new Date(fech2);
	    			    			        float dias			= 0.0f;
	    			    			        
	    		        					while(f1.before(f2) || f1.getTime() == f2.getTime()){
	    		        						dias = dias +1f;
	    		        						int diaNumero = f1.getDay();

	    		        						if(result.getDomingo().equals("0") && diaNumero == 0){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getDomingo().equals("1") && diaNumero == 0){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getLunes().equals("0") && diaNumero == 1){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getLunes().equals("1") && diaNumero == 1){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMartes().equals("0") && diaNumero == 2){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMartes().equals("1") && diaNumero == 2){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMiercoles().equals("0") && diaNumero == 3){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMiercoles().equals("1") && diaNumero == 3){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getJueves().equals("0") && diaNumero == 4){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getJueves().equals("1") && diaNumero == 4){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getViernes().equals("0") && diaNumero == 5){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getViernes().equals("1") && diaNumero == 5){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getSabado().equals("0") && diaNumero == 6){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getSabado().equals("1") && diaNumero == 6){
	    		        							totalDias =totalDias +0.50f;
	    		        						}
	    		        						
	    		        						fech1 = fech1 + 1*24*60*60*1000;
	    		        						f1 = new Date(fech1);
	    		        					}

	    	    							String nombre = result2.getPrimer_nombre() + " "+result2.getSegundo_nombre() + " "+result2.getPrimer_apellido() + " "+result2.getSegundo_apellido();

	    			    			        float diasDescanso 	= totalDias;
	    			    			        dias = dias - diasDescanso;
	    							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(n2.getId_Empleado());
	    							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
	    							    				   n2.getTipoPermisos(),nombre, ""+dias,""+result2.getDiasDeVacaciones(),
	    							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
	    							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    							    	fa.btnEnterado.setVisible(false);
	    							    	fa.btnEnterado.setEnabled(false);
	    							    	totalDias = 0.0f;

	    		        	            }
	    		        				
	    		        				});
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

	    		        			loginService.getPuestoActivo(n2.getIdEmpleadoSolicitante(), new AsyncCallback<AuxPuesto>(){
	    		        	            public void onFailure(Throwable caught) 
	    		        	            {
	    		        			        load.invisible();
	    		        	            	mensaje.setMensaje("alert alert-error", "Error !! \nal calcular dias de descanso");
	    		        	            }

	    		        				@SuppressWarnings("deprecation")
	    		        				@Override
	    		        	            public void onSuccess(AuxPuesto result)
	    		        	            {
	    		        			        load.invisible();
	    		        			        Long fech1 = n2.getFecha1();
	    		        			        Long fech2 = n2.getFecha2();
	    		        			        Date f1 = new Date(fech1);
	    		        					Date f2 = new Date(fech2);
	    			    			        float dias			= 0.0f;

	    		        					while(f1.before(f2) || f1.getTime() == f2.getTime()){
	    		        						
	    		        						int diaNumero = f1.getDay();
	    		        						dias = dias +1f;

	    		        						if(result.getDomingo().equals("0") && diaNumero == 0){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getDomingo().equals("1") && diaNumero == 0){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getLunes().equals("0") && diaNumero == 1){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getLunes().equals("1") && diaNumero == 1){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMartes().equals("0") && diaNumero == 2){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMartes().equals("1") && diaNumero == 2){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMiercoles().equals("0") && diaNumero == 3){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMiercoles().equals("1") && diaNumero == 3){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getJueves().equals("0") && diaNumero == 4){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getJueves().equals("1") && diaNumero == 4){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getViernes().equals("0") && diaNumero == 5){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getViernes().equals("1") && diaNumero == 5){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getSabado().equals("0") && diaNumero == 6){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getSabado().equals("1") && diaNumero == 6){
	    		        							totalDias =totalDias +0.50f;
	    		        						}
	    		        						
	    		        						fech1 = fech1 + 1*24*60*60*1000;
	    		        						f1 = new Date(fech1);
	    		        					}

	    	    		                	mensaje.setMensaje("alert alert-error", "Error !! \nnombre ");

	    			    			        float diasDescanso 	= totalDias;
	    			    			        dias = dias - diasDescanso;
	    							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(n2.getId_Empleado());
	    							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
	    							    				   n2.getTipoPermisos(),"Empleado", ""+dias,"0",
	    							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
	    							    	fa.btnAceptar.setVisible(false);
	    							    	fa.btnAceptar.setEnabled(false);
	    							    	fa.btnNoAceptar.setVisible(false);
	    							    	fa.btnNoAceptar.setEnabled(false);
	    							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    							    	totalDias = 0.0f;
	    		        	            }
	    		        				});
	    		                }

	    						@Override
	    		                public void onSuccess(final AuxEmpleado result2)
	    		                {

	    		        			loginService.getPuestoActivo(n2.getIdEmpleadoSolicitante(), new AsyncCallback<AuxPuesto>(){
	    		        	            public void onFailure(Throwable caught) 
	    		        	            {
	    		        			        load.invisible();
	    		        	            	mensaje.setMensaje("alert alert-error", "Error !! \nal calcular dias de descanso");
	    		        	            }

	    		        				@SuppressWarnings("deprecation")
	    		        				@Override
	    		        	            public void onSuccess(AuxPuesto result)
	    		        	            {
	    		        			        load.invisible();
	    		        			        Long fech1 = n2.getFecha1();
	    		        			        Long fech2 = n2.getFecha2();
	    		        			        Date f1 = new Date(fech1);
	    		        					Date f2 = new Date(fech2);
	    			    			        float dias			= 0.0f;

	    		        					while(f1.before(f2) || f1.getTime() == f2.getTime()){
	    		        						
	    		        						int diaNumero = f1.getDay();
	    		        						dias = dias +1f;

	    		        						if(result.getDomingo().equals("0") && diaNumero == 0){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getDomingo().equals("1") && diaNumero == 0){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getLunes().equals("0") && diaNumero == 1){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getLunes().equals("1") && diaNumero == 1){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMartes().equals("0") && diaNumero == 2){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMartes().equals("1") && diaNumero == 2){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMiercoles().equals("0") && diaNumero == 3){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMiercoles().equals("1") && diaNumero == 3){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getJueves().equals("0") && diaNumero == 4){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getJueves().equals("1") && diaNumero == 4){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getViernes().equals("0") && diaNumero == 5){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getViernes().equals("1") && diaNumero == 5){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getSabado().equals("0") && diaNumero == 6){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getSabado().equals("1") && diaNumero == 6){
	    		        							totalDias =totalDias +0.50f;
	    		        						}
	    		        						
	    		        						fech1 = fech1 + 1*24*60*60*1000;
	    		        						f1 = new Date(fech1);
	    		        					}

	    	    							String nombre = result2.getPrimer_nombre() + " "+result2.getSegundo_nombre() + " "+result2.getPrimer_apellido() + " "+result2.getSegundo_apellido();

	    			    			        float diasDescanso 	= totalDias;
	    			    			        dias = dias - diasDescanso;
	    							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(n2.getId_Empleado());
	    							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
	    							    				   n2.getTipoPermisos(),nombre, ""+dias,""+result2.getDiasDeVacaciones(),
	    							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'1');
	    							    	fa.btnAceptar.setVisible(false);
	    							    	fa.btnAceptar.setEnabled(false);
	    							    	fa.btnNoAceptar.setVisible(false);
	    							    	fa.btnNoAceptar.setEnabled(false);
	    							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    							    	totalDias = 0.0f;
	    		        	            }
	    		        				});
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

	    		        			loginService.getPuestoActivo(n2.getIdEmpleadoSolicitante(), new AsyncCallback<AuxPuesto>(){
	    		        	            public void onFailure(Throwable caught) 
	    		        	            {
	    		        			        load.invisible();
	    		        	            	mensaje.setMensaje("alert alert-error", "Error !! \nal calcular dias de descanso");
	    		        	            }

	    		        				@SuppressWarnings("deprecation")
	    		        				@Override
	    		        	            public void onSuccess(AuxPuesto result)
	    		        	            {
	    		        			        load.invisible();
	    		        			        Long fech1 = n2.getFecha1();
	    		        			        Long fech2 = n2.getFecha2();
	    		        			        Date f1 = new Date(fech1);
	    		        					Date f2 = new Date(fech2);
	    			    			        float dias			= 0.0f;

	    		        					while(f1.before(f2) || f1.getTime() == f2.getTime()){
	    		        						
	    		        						int diaNumero = f1.getDay();
	    		        						dias = dias +1f;

	    		        						if(result.getDomingo().equals("0") && diaNumero == 0){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getDomingo().equals("1") && diaNumero == 0){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getLunes().equals("0") && diaNumero == 1){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getLunes().equals("1") && diaNumero == 1){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMartes().equals("0") && diaNumero == 2){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMartes().equals("1") && diaNumero == 2){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMiercoles().equals("0") && diaNumero == 3){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMiercoles().equals("1") && diaNumero == 3){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getJueves().equals("0") && diaNumero == 4){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getJueves().equals("1") && diaNumero == 4){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getViernes().equals("0") && diaNumero == 5){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getViernes().equals("1") && diaNumero == 5){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getSabado().equals("0") && diaNumero == 6){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getSabado().equals("1") && diaNumero == 6){
	    		        							totalDias =totalDias +0.50f;
	    		        						}
	    		        						
	    		        						fech1 = fech1 + 1*24*60*60*1000;
	    		        						f1 = new Date(fech1);
	    		        					}

	    	    		                	mensaje.setMensaje("alert alert-error", "Error !! \nnombre ");
	    			    			        float diasDescanso 	= totalDias;
	    			    			        dias = dias - diasDescanso;
	    							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(n2.getId_Empleado());
	    							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
	    							    				   n2.getTipoPermisos(),"Empleado", ""+dias,"0",
	    							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'0');
	    							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    							    	totalDias = 0.0f;
	    		        	            }
	    		        				});
	    		                }

	    						@Override
	    		                public void onSuccess(final AuxEmpleado result2)
	    		                {

	    		        			loginService.getPuestoActivo(n2.getIdEmpleadoSolicitante(), new AsyncCallback<AuxPuesto>(){
	    		        	            public void onFailure(Throwable caught) 
	    		        	            {
	    		        			        load.invisible();
	    		        	            	mensaje.setMensaje("alert alert-error", "Error !! \nal calcular dias de descanso");
	    		        	            }

	    		        				@SuppressWarnings("deprecation")
	    		        				@Override
	    		        	            public void onSuccess(AuxPuesto result)
	    		        	            {
	    		        			        load.invisible();
	    		        			        Long fech1 = n2.getFecha1();
	    		        			        Long fech2 = n2.getFecha2();
	    		        			        Date f1 = new Date(fech1);
	    		        					Date f2 = new Date(fech2);
	    			    			        float dias			= 0.0f;

	    		        					while(f1.before(f2) || f1.getTime() == f2.getTime()){
	    		        						
	    		        						int diaNumero = f1.getDay();
	    		        						dias = dias +1f;

	    		        						if(result.getDomingo().equals("0") && diaNumero == 0){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getDomingo().equals("1") && diaNumero == 0){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getLunes().equals("0") && diaNumero == 1){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getLunes().equals("1") && diaNumero == 1){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMartes().equals("0") && diaNumero == 2){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMartes().equals("1") && diaNumero == 2){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getMiercoles().equals("0") && diaNumero == 3){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getMiercoles().equals("1") && diaNumero == 3){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getJueves().equals("0") && diaNumero == 4){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getJueves().equals("1") && diaNumero == 4){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getViernes().equals("0") && diaNumero == 5){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getViernes().equals("1") && diaNumero == 5){
	    		        							totalDias =totalDias +0.50f;
	    		        						}else if(result.getSabado().equals("0") && diaNumero == 6){
	    		        							totalDias =totalDias+1f;
	    		        						}else if(result.getSabado().equals("1") && diaNumero == 6){
	    		        							totalDias =totalDias +0.50f;
	    		        						}
	    		        						
	    		        						fech1 = fech1 + 1*24*60*60*1000;
	    		        						f1 = new Date(fech1);
	    		        					}
	    	    							String nombre = result2.getPrimer_nombre() + " "+result2.getSegundo_nombre() + " "+result2.getPrimer_apellido() + " "+result2.getSegundo_apellido();

	    			    			        float diasDescanso 	= totalDias;
	    			    			        dias = dias - diasDescanso;
	    							    	FormularioSolicitudPermiso fa = new  FormularioSolicitudPermiso(n2.getId_Empleado());
	    							    	fa.LlenarDatos(n2.getId_permiso(),n2.getIdEmpleadoSolicitante(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
	    							    				   n2.getTipoPermisos(),nombre, ""+dias,""+result2.getDiasDeVacaciones(),
	    							    				   n2.getJefeInmediatoAceptaSolicitud(),n2.getRrhhAceptaSolicitud(),'0');
	    							        flextable.setWidget(flextable.getRowCount(), 0,fa );
	    							    	fa.btnEnterado.setVisible(false);
	    							    	fa.btnEnterado.setEnabled(false);
	    							    	totalDias = 0.0f;

	    		        	            }
	    		        				});
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
	    
//	    public float DiasDescando(final Long fecha1, final Long fecha2, final Long idEmpleado){
//			System.out.println(totalDias);
//			return totalDias;
//		}
	    

}
