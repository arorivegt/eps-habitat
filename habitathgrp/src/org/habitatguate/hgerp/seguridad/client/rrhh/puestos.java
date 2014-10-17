package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

public class puestos extends Composite  {

	private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleados empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	 public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
	 
	    public puestos(Empleados e) {

			mensaje = new Mensaje();
			this.empleado = e;
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
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioPuestos(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxPuesto> results){
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxPuesto n2 : results) {
			    	formularioPuestos fa = new  formularioPuestos(this,empleado);
			    	String valor = "No";
			    	if(n2.isActivo()){ valor = "Si";}
			    	fa.LlenarDatos(n2.getId_puesto(),n2.getFecha_puesto(),valor, n2.getNombre_puesto(),
			    					n2.getFunciones(),n2.getMotivoPuesto(),n2.getJornada(),n2.getHorasTrabajo());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	    
	    }
	    
	    public void EliminarFormulario(final formularioPuestos fa, final Long id_empledo, final Long id){

			loginService.Eliminar_Puesto(id_empledo, id, new AsyncCallback<Long>(){
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
	    
	    public void EliminarFormulario(formularioPuestos fa){
        	        flextable.remove(fa);
	    }
	    
	    private void BDPuesto(){
	    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
	    		public void onFailure(Throwable caught) 
	    		{
	    			mensaje.setMensaje("alert alert-success", "Error en BD puestos\n"+caught);
	    		}

				@Override
				public void onSuccess(List<AuxBDPuesto> results)
				{
					if (!(results.size()==0)) {
						BDpuestos = results;
			    	}	
				}
			});
	    }
}
