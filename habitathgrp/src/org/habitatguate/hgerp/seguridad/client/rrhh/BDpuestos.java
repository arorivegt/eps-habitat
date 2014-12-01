/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
/**
 * 
 * @author arodriguez
 *
 */
public class BDpuestos extends Composite  {

     private Grid grid_1;
     private BDpuestos a;
     private Loading load;
     private Button button;
	 private Mensaje mensaje; 
     private final Grid grid;
     private TextBox idPuesto;
	 private Button btnAgregar;
	 private FlexTable flextable;
     private final Button btnTest;
 	 private formularioBDPuestos fa ;
     private VerticalPanel panel = new VerticalPanel();
 	 private List<AuxBDPuesto> bdpuesto = new ArrayList<AuxBDPuesto>();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     
     /**
      * contructor
      */
    public BDpuestos() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		scrollPanel.setSize("100%", "1000px");
		initWidget(scrollPanel);
		
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setSize("100%", "177px");
		mensaje = new Mensaje();
        
        grid_1 = new Grid(1, 2);
        panel.add(grid_1);
        grid_1.setWidth("678px");
        
        idPuesto = new TextBox();
        idPuesto.setText("0");
		idPuesto.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(idPuesto.getText().equals("")) {idPuesto.setText("0");}
				else if(idPuesto.getText().equals(null)) {idPuesto.setText("0");}
				else{
					try{
						Long.parseLong(idPuesto.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nid no valido");
						idPuesto.setText("0");
					}
				}
			}
		});
        idPuesto.getElement().setAttribute("placeHolder", "ID puesto");
        idPuesto.setStyleName("gwt-TextBox2");
        grid_1.setWidget(0, 0, idPuesto);
        idPuesto.setSize("227px", "34px");
        
        button = new Button("Agregar");
        button.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		for ( AuxBDPuesto n2 : bdpuesto) 
			    {
        			if(n2.getId_puesto() == Long.parseLong(idPuesto.getText()))
        			{
        				flextable.clear();
        		    	fa = new  formularioBDPuestos(a);
        		    	fa.LlenarDatos(n2.getId_puesto(),n2.getFecha_puesto(), n2.getNombre_puesto(),n2.getFunciones());
        		    	flextable.setWidget(flextable.getRowCount(), 0,fa );
        			}
			    }
        	}
        });
        button.setText("Buscar");
        button.setStyleName("sendButton");
        grid_1.setWidget(0, 1, button);
        button.setSize("227px", "34px");
        
        flextable = new FlexTable();
        panel.add(flextable);
        flextable.setSize("100%", "82px");
        
        grid = new Grid(1, 3);
        panel.add(grid);
        grid.setWidth("733px");
        
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
        agregarFormulario_lleno();
        
	}
    
    /**
     * agrega un formulario de Base de datos de puestos con datos
     * extraidos del datastore
     */
    public void agregarFormulario_lleno()
    {
        load.visible();
    	flextable.clear();
    	bdpuesto.clear();
    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
    		public void onFailure(Throwable caught) 
    		{
    	        load.invisible();
    			mensaje.setMensaje("alert alert-error", "Error !! \nen la base de datos\nde puestos");
    		}

			@Override
			public void onSuccess(List<AuxBDPuesto> results)
			{
				if (results.size()!=0) 
				{
				    for ( AuxBDPuesto n2 : results) 
				    {
				    	bdpuesto.add(n2);
				    	fa = new  formularioBDPuestos(a);
				    	fa.LlenarDatos(n2.getId_puesto(),n2.getFecha_puesto(), n2.getNombre_puesto(),n2.getFunciones());
				    	flextable.setWidget(flextable.getRowCount(), 0,fa );
				    }
		    	}	
		        load.invisible();
			}
		});
    }
	    
    /**
     * agrega un formulario nuevo de Base de datos de puestos 
     */
    private void agregarFormulario(){
        load.visible();
    	flextable.setWidget(flextable.getRowCount(), 0, new formularioBDPuestos(this));
        load.invisible();
    }
	    
    /**
     * elimina un formulario del panel, mas no del datastore
     * @param formularioBaseDatosPuestos
     */
    public void EliminarFormulario(formularioBDPuestos formularioBaseDatosPuestos){
    	flextable.remove(formularioBaseDatosPuestos);
	}
}
