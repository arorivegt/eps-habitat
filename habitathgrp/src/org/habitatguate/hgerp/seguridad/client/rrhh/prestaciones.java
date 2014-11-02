package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class prestaciones extends Composite  {

	private Mensaje mensaje; 
	private Grid grid;
    private FlexTable flextable;
	private Button btnTodo;
	private Button btnSeleccionados;
	private VerticalPanel panel = new VerticalPanel();
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private Loading load ;
	
    public prestaciones() {

		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "381px");
        flextable = new FlexTable();
        panel.add(flextable);
        grid = new Grid(1, 3);
        panel.add(grid);
        grid.setWidth("650px");
        btnSeleccionados = new Button("Guardar Todo");
        grid.setWidget(0, 0, btnSeleccionados);
        
        btnSeleccionados.setStyleName("sendButton");
        btnSeleccionados.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) 
        	{
        	}
        });
        btnSeleccionados.setSize("267px", "34px");
        
        btnTodo = new Button("Guardar Seleccionados");
        grid.setWidget(0, 2, btnTodo);
        btnTodo.setStyleName("sendButton");
        btnTodo.setSize("295px", "34px");
        btnTodo.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) 
        	{
        	}
        });
	}
    
    public void agregarFormulario(
			 Long idEmpleado,
			 String codigoSalario,
			 String descripcion,
			 String nombre,
			 String promedioSalario,
			 String txtDiasTrabajados,
			 String txtDiasAnnio)
    {
    	formularioPrestaciones fp = new formularioPrestaciones();
    	fp.llenar_datos(idEmpleado, codigoSalario, descripcion, nombre, promedioSalario, txtDiasTrabajados, txtDiasAnnio);
        flextable.setWidget(flextable.getRowCount(), 0, fp); 
        	
    }
    
   
 
    
    
}
