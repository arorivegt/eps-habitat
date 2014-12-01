package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Prestaciones extends Composite  {

	private Grid grid;
    private FlexTable flextable;
	private Button btnTodo;
	private Button btnSeleccionados;
	private VerticalPanel panel = new VerticalPanel();
    private FormularioPrestaciones fp;
    private Loading load ;
	private Mensaje mensaje; 
    private List<FormularioPrestaciones> listfp = new ArrayList<FormularioPrestaciones>();
    public Prestaciones() {

    	load = new Loading();
		mensaje = new Mensaje();
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
        grid.setWidth("609px");
        btnSeleccionados = new Button("Guardar Todo");
        grid.setWidget(0, 0, btnSeleccionados);
        
        btnSeleccionados.setStyleName("sendButton");
        btnSeleccionados.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) 
        	{
                load.visible();
        		for(int i = 0; i < listfp.size(); i++){
        			listfp.get(i).insertar_actualizar();
        		}
                load.invisible();
        	}
        });
        btnSeleccionados.setSize("267px", "34px");
        
        btnTodo = new Button("Guardar Seleccionados");
        grid.setWidget(0, 2, btnTodo);
        btnTodo.setStyleName("sendButton");
        btnTodo.setSize("295px", "34px");
        btnTodo.addClickHandler(new ClickHandler() {
        	@SuppressWarnings("deprecation")
			public void onClick(ClickEvent event) 
        	{
        		boolean valor = false;
                load.visible();
        		for(int i = 0; i < listfp.size(); i++){
        			if(listfp.get(i).checkOk.isChecked())
        			{
        				valor = listfp.get(i).insertar_actualizar();
        			}
        		}
                load.invisible();
                if(valor){
        			mensaje.setMensaje("alert alert-success", "Salario guardados con exito");
                	
                }else{
					mensaje.setMensaje("alert alert-error", "Error !! \nHubo un error al guardar salarios");
                }
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
			 String txtDiasAnnio,
			 Date fecha)
    {
    	fp = new FormularioPrestaciones();
    	fp.llenar_datos(idEmpleado, codigoSalario, descripcion, nombre, promedioSalario, txtDiasTrabajados, txtDiasAnnio,fecha);
        flextable.setWidget(flextable.getRowCount(), 0, fp); 
    	listfp.add(fp);
        	
    }
    
    public void limpiar()
    {
    	listfp.clear();
    	flextable.clear();
    }
    
   
 
    
    
}
