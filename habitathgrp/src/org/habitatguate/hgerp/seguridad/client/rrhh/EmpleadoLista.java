package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ScrollPanel;

public class EmpleadoLista extends Composite {
	
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    private EmpleadoLista a;
    private FlexTable flexTable;
	public EmpleadoLista() {
		this.a =this;
		
		ScrollPanel scrollPanel = new ScrollPanel();
		initWidget(scrollPanel);
		scrollPanel.setSize("1184px", "716px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		scrollPanel.setWidget(verticalPanel);
		verticalPanel.setSize("1184px", "739px");
		
		flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setSize("100%", "80px");
	}
	
    public void agregarFormulario(final char tipo, final BuscadorEmpleados b, final String primer_nombre, String segundo_nombre, 
			String primer_apellido, String segundo_apellido){
    	System.out.println("tipo "+tipo);
    	loginService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, 
						primer_apellido, segundo_apellido,new AsyncCallback<List<AuxEmpleado>>(){
            public void onFailure(Throwable caught) 
            {
                Window.alert("No hay resultados "+caught);
            }

			@Override
            public void onSuccess( List<AuxEmpleado> result)
            {
				for(AuxEmpleado p : result) {
			        flexTable.setWidget(flexTable.getRowCount(), 0, new EmpleadoItem(b,a,p.getId_empleado(),p.getPrimer_nombre(),
			        		p.getSegundo_nombre(),p.getPrimer_apellido(),p.getSegundo_apellido()));
				}
            }

     });
    }
    
    public void EliminarFormulario(final EmpleadoItem a){
    	flexTable.remove(a);
    }
    

}
