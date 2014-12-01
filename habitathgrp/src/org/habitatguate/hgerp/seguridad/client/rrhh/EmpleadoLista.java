package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EmpleadoLista extends Composite {

    private Loading load;
	private Mensaje mensaje; 
	boolean bandera = false;
    private FlexTable flexTable;
    private EmpleadoLista listaEmpleado;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	
	public EmpleadoLista() {
		
		this.listaEmpleado =this;
		mensaje = new Mensaje();

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		initWidget(scrollPanel);
		
		scrollPanel.setSize("100%", "716px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		scrollPanel.setWidget(verticalPanel);
		verticalPanel.setSize("100%", "739px");
		
		flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setSize("100%", "80px");
	}

    public boolean agregarFormulario(final char tipo, final BuscadorEmpleados buscador, final String primer_nombre, String segundo_nombre, 
			String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,String Estado){

        load.visible();
    	loginService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido,DPI, Pasaporte,Estado,new AsyncCallback<List<AuxEmpleado>>(){
            public void onFailure(Throwable caught) 
            {
		        load.invisible();
            	mensaje.setMensaje("alert alert-information alert-block", "\nNo hay resultados");
            }

			@Override
            public void onSuccess( List<AuxEmpleado> result)
            {
				bandera = !result.isEmpty();
				for(AuxEmpleado p : result) {
			        flexTable.setWidget(flexTable.getRowCount(), 0, new EmpleadoItem(buscador,listaEmpleado,p.getId_empleado(),p.getPrimer_nombre(),
			        		p.getSegundo_nombre(),p.getPrimer_apellido(),p.getSegundo_apellido()));
				}
		        load.invisible();
            }

    	});

        load.invisible();
        return bandera;
    }
    
    public void EliminarFormulario(final EmpleadoItem a){
        load.visible();
    	flexTable.remove(a);
        load.invisible();
    }
    

}
