/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
/**
 * 
 * @author arodriguez
 *
 */
public class BDpuestos extends Composite  {

	private Mensaje mensaje; 
     private BDpuestos a;
	 private Button btnAgregar;
     private final Grid grid ;
	 private FlexTable flextable;
     private final Button btnTest;
     private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     
     /**
      * contructor
      */
    public BDpuestos() {

		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		scrollPanel.setSize("100%", "716px");
		initWidget(scrollPanel);
		
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setSize("761px", "85px");
		mensaje = new Mensaje();
        
        flextable = new FlexTable();
        panel.add(flextable);
        
        grid = new Grid(1, 3);
        panel.add(grid);
        
        btnTest = new Button("Agregar");
        btnTest.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario_lleno();
        	}
        });
        btnTest.setText("Ver Puestos");
        btnTest.setStyleName("sendButton");
        btnTest.setSize("227px", "34px");
        grid.setWidget(0, 0, btnTest);
        
        btnAgregar = new Button("Agregar");
        btnAgregar.setStyleName("sendButton");
        btnAgregar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario();
        	}
        });
        btnAgregar.setSize("227px", "34px");
        grid.setWidget(0, 2, btnAgregar);
        

		scrollPanel.setWidget(panel);
        
	}
    
    /**
     * agrega un formulario de Base de datos de puestos con datos
     * extraidos del datastore
     */
    public void agregarFormulario_lleno()
    {
    	flextable.clear();
    	final formularioBDPuestos fa = new  formularioBDPuestos(a);
    	
    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-error", "Error !! \nen la base de datos\nde puestos");
    		}

			@Override
			public void onSuccess(List<AuxBDPuesto> results)
			{
				if (results.size()!=0) 
				{
				    for ( AuxBDPuesto n2 : results) 
				    {
				    	Window.alert("aqui");
				    	fa.LlenarDatos(n2.getId_puesto(),n2.getFecha_puesto(), n2.getNombre_puesto(),n2.getFunciones());
				    	flextable.setWidget(flextable.getRowCount(), 0,fa );
				    }
		    	}	
			}
		});
    }
	    
    /**
     * agrega un formulario nuevo de Base de datos de puestos 
     */
    private void agregarFormulario(){
    	flextable.setWidget(flextable.getRowCount(), 0, new formularioBDPuestos(this));
    }
	    
    /**
     * elimina un formulario del panel, mas no del datastore
     * @param formularioBaseDatosPuestos
     */
    public void EliminarFormulario(formularioBDPuestos formularioBaseDatosPuestos){
    	flextable.remove(formularioBaseDatosPuestos);
	}
}
