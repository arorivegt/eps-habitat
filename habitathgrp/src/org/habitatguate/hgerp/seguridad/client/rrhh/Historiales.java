package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorial;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;

public class Historiales extends Composite  {

	 private FlexTable flextable;
	 private Empleado empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 private Mensaje mensaje; 
	 private List<AuxHistorial> historial = new ArrayList<AuxHistorial> ();
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	 private Grid grid;
	 private DateBox dateFecha2;
	 private DateBox dateFecha1;
	 private ListBox listTipo;
	 private Button btnBuscar;
	    private Loading load ;
		
	    public Historiales(Empleado e) {

			mensaje = new Mensaje();
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			this.empleado = e;
    		mensaje = new Mensaje();
	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        
	        grid = new Grid(1, 4);
	        panel.add(grid);
	        
	        
	        dateFecha1 = new DateBox();
	        dateFecha1.setValue(new Date());
	        dateFecha1.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
	        dateFecha1.getDatePicker().setYearArrowsVisible(true);
	        dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
	        dateFecha1.getDatePicker().setVisibleYearCount(100);
	        dateFecha1.setStyleName("gwt-TextBox2");
	        grid.setWidget(0, 0, dateFecha1);
	        dateFecha1.setSize("227px", "34px");
	        
	        dateFecha2 = new DateBox();
	        dateFecha2.setValue(new Date());
	        dateFecha2.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
	        dateFecha2.getDatePicker().setYearArrowsVisible(true);
	        dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
	        dateFecha2.getDatePicker().setVisibleYearCount(100);
	        dateFecha2.setStyleName("gwt-TextBox2");
	        grid.setWidget(0, 1, dateFecha2);
	        dateFecha2.setSize("227px", "34px");
	        
	        listTipo = new ListBox();
	        listTipo.addItem("acierto ","0");
	        listTipo.addItem("llamada de atención","1");
	        listTipo.setStyleName("gwt-TextBox2");
	        grid.setWidget(0, 2, listTipo);
	        listTipo.setSize("229px", "36px");
	        
	        btnBuscar = new Button("Agregar");
	        btnBuscar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	                load.visible();
	        		loginService.getHistorial(empleado.id_empleado, new AsyncCallback<List<AuxHistorial>>(){
	                    public void onFailure(Throwable caught) 
	                    {
	                    }

	    				@Override
	                    public void onSuccess(List<AuxHistorial> result)
	                    {
	    					historial  = result;
	                    }

	    	         });
	        		try{
		        		List<AuxHistorial> hist = new ArrayList<AuxHistorial> ();
		        		for(AuxHistorial h: historial)
		        		{
		        			Date aux = new Date(h.getFecha());
		        			if( (aux.after(dateFecha1.getValue())
		        				&& aux.before(dateFecha2.getValue())
		        				&& h.getTipo_historial().equals(listTipo.getValue(listTipo.getSelectedIndex()))
		        				)
		        				||
		        				(aux.equals(dateFecha1.getValue())
		        				&& aux.equals(dateFecha2.getValue())
		        				&& h.getTipo_historial().equals(listTipo.getValue(listTipo.getSelectedIndex()))
		        				)
		        			  )
		        			{
		        				hist.add(h);
		        			}
		        		}
		        		//agregarFormularios
		        		if(!hist.isEmpty()){
		        			agregarFormularios(hist);
		        		}else{
		    		        load.invisible();
		                	mensaje.setMensaje("alert alert-error", 
		                			"No se encontro resultado");
		        		}
		        	}catch(Exception e){

				        load.invisible();
	                	mensaje.setMensaje("alert alert-error", 
	                			"No se encontro resultado");
		        	}

	                load.invisible();
	        	}
	        });
	        btnBuscar.setText("Buscar");
	        btnBuscar.setStyleName("sendButton");
	        grid.setWidget(0, 3, btnBuscar);
	        
	        btnBuscar.setSize("227px", "34px");
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
		}
	    
	    private void agregarFormulario(){
	        flextable.setWidget(flextable.getRowCount(), 0, new FormularioHistorial(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxHistorial> results){

	        load.visible();
	    	flextable.clear();
	    	if (!results.isEmpty()) {

			    historial = results;
			    for ( AuxHistorial n2 : results) {
			    	FormularioHistorial fa = new  FormularioHistorial(this,empleado);
			    	fa.LlenarDatos(n2.getId_historial(),n2.getTipo_historial() ,n2.getFecha(),n2.getDescripcion());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	    
	        load.invisible();
	    }
	    
	    public void agregarFormularios(List<AuxHistorial> results){

	        load.visible();
	    	flextable.clear();
	    	if (!results.isEmpty()) {

			    historial = results;
			    for ( AuxHistorial n2 : results) {
			    	FormularioHistorial fa = new  FormularioHistorial(this,empleado);
			    	fa.LlenarDatos(n2.getId_historial(),n2.getTipo_historial() ,n2.getFecha(),n2.getDescripcion());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	
	        load.invisible();    
	    }
	    
	    public void EliminarFormulario(final FormularioHistorial fa, final Long id_empledo, final Long id){

	        load.visible();
			loginService.Eliminar_Historial(id_empledo, id, new AsyncCallback<Long>(){
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
	    
	    public void EliminarFormulario(FormularioHistorial fa){
	        load.visible();
	    	flextable.remove(fa);
	        load.invisible();
		}
}
