package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class Puestos extends Composite  {

	private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleado empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	 public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
	    private Loading load ;
	 
	    public Puestos(Empleado empleados) {

			mensaje = new Mensaje();
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			this.empleado = empleados;
	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");
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
	        BDPuesto();
		}
	    
	    private void agregarFormulario(){
	        load.visible();
	        flextable.setWidget(flextable.getRowCount(), 0, new FormularioPuestos(this,empleado));
	        load.invisible();
	    }
	    
	    public void agregarFormulario_lleno(List<AuxPuesto> results){
	        load.visible();
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxPuesto n2 : results) {
			    	FormularioPuestos fa = new  FormularioPuestos(this,empleado);
			    	String valor = "0";
			    	if(n2.isActivo()){ valor = "1";}
			    	fa.LlenarDatos(n2.getId_puesto(),n2.getFecha_puesto(),valor, n2.getNombre_puesto(),
			    					n2.getFunciones(),n2.getMotivoPuesto(),n2.getJornada(),n2.getHorasTrabajo(),
			    					n2.getLunes(),n2.getMartes(),n2.getMiercoles(),n2.getJueves(),n2.getViernes(),
			    					n2.getSabado(),n2.getDomingo());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	  
	        load.invisible();  
	    }
	    
	    public void EliminarFormulario(final FormularioPuestos fa, final Long id_empledo, final Long id){

	        load.visible();
			loginService.Eliminar_Puesto(id_empledo, id, new AsyncCallback<Long>(){
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
	    
	    public void EliminarFormulario(FormularioPuestos fa){
	        load.visible();
	        flextable.remove(fa);
	        load.invisible();
	    }
	    
	    private void BDPuesto(){
	        load.visible();
	    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
	    		public void onFailure(Throwable caught) 
	    		{
			        load.invisible();
	    			mensaje.setMensaje("alert alert-success", "Error en BD puestos\n"+caught);
	    		}

				@Override
				public void onSuccess(List<AuxBDPuesto> results)
				{
			        load.invisible();
					if (!(results.size()==0)) {
						BDpuestos = results;
			    	}	
				}
			});
	        load.invisible();
	    }
}
