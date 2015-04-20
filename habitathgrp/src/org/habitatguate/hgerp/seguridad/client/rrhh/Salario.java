/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;

public class Salario extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleado empleado;
	 private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
     private Button btnAgregar;
     private Loading load ;
     private Grid grid;
     private DateBox dateFecha1;
     private DateBox dateFecha2;
     private ListBox txtTipoSalario;
	 private List<AuxSalario> salario = new ArrayList<AuxSalario> ();
     private Button button;
     boolean valor = true;
		
	    public Salario(Empleado empleadoo) {

			mensaje = new Mensaje();
			
        	load = new Loading();
            load.Mostrar();
            load.invisible();
            
			this.empleado = empleadoo;
	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        
	        grid = new Grid(1, 4);
	        panel.add(grid);
	        
	        dateFecha1 = new DateBox(); dateFecha1.setValue(new Date());
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
	        
	        txtTipoSalario = new ListBox();
	        txtTipoSalario.addItem("Salario Base", "0");
			txtTipoSalario.addItem("Decreto(78-89)", "1");
			txtTipoSalario.addItem("Comisiones", "2");
			txtTipoSalario.addItem("Bonificacion", "3");
			txtTipoSalario.addItem("Bono 14", "4");
			txtTipoSalario.addItem("Aguinaldo", "5");
			txtTipoSalario.addItem("Vacaciones", "6");
			txtTipoSalario.addItem("Indemnizacion", "7");
			txtTipoSalario.addItem("Otros pagos", "8");
	        txtTipoSalario.setStyleName("gwt-TextBox2");
	        grid.setWidget(0, 2, txtTipoSalario);
	        txtTipoSalario.setSize("229px", "36px");
	        
	        button = new Button("Agregar");
	        button.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		
	        		load.visible();
	        		recursosHumanosService.getSalarios(empleado.id_empleado, new AsyncCallback<List<AuxSalario>>(){
	                    public void onFailure(Throwable caught) 
	                    {
	                    }

	    				@Override
	                    public void onSuccess(List<AuxSalario> result)
	                    {
	    					salario  = result;
	                    }

	    	         });
	        		try{
		        		List<AuxSalario> sal = new ArrayList<AuxSalario> ();
		        		for(AuxSalario h: salario)
		        		{
		        			Date aux = new Date(h.getFecha());
		        			if( (aux.after(dateFecha1.getValue())
		        				&& aux.before(dateFecha2.getValue())
		        				&& h.getTipoSalario().equals(txtTipoSalario.getValue(txtTipoSalario.getSelectedIndex()))
		        				)
		        				||
		        				(aux.equals(dateFecha1.getValue())
		        				&& aux.equals(dateFecha2.getValue())
		        				&& h.getTipoSalario().equals(txtTipoSalario.getValue(txtTipoSalario.getSelectedIndex()))
		        				)
		        			  )
		        			{
		        				sal.add(h);
		        			}
		        		}
		        		//agregarFormularios
		        		if(!sal.isEmpty()){
		        			agregarFormulario_lleno(sal);
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
	        button.setText("Buscar");
	        button.setStyleName("sendButton");
	        grid.setWidget(0, 3, button);
	        button.setSize("227px", "34px");
	        flextable = new FlexTable();
	        panel.add(flextable);
	        
	        btnAgregar = new Button("Agregar");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario("Comision");
	        	}
	        });
	        btnAgregar.setText("Agregar");
	        btnAgregar.setStyleName("sendButton");
	        panel.add(btnAgregar);
	        btnAgregar.setSize("227px", "34px");
		}
	    
	    private void agregarFormulario(String tipo){
	    	if(valor){
		        load.visible();
		        flextable.setWidget(flextable.getRowCount(), 0, new FormularioSalario(this,empleado));
		        load.invisible();
	    	}
	    }
	    
	    public void agregarFormulario_lleno(List<AuxSalario> results){
	        load.visible();
	        flextable.clear();
	    	if (!results.isEmpty()) {
	    		
			    for ( AuxSalario n2 : results) 
			    {
			    	FormularioSalario fa = new  FormularioSalario(this,empleado);
			    	fa.LlenarDatos(n2.getId_Salario(), ""+n2.getSalario(),n2.getFecha(), n2.getTipoSalario(),n2.getDescripcion());
			    	fa.btnhinabilitar(valor);
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	
	        load.invisible();
	    	
	    }
	    
	    public void EliminarFormulario(final FormularioSalario fa, final Long id_empledo, final Long id){

	        load.visible();
			recursosHumanosService.Eliminar_Salario(id_empledo, id, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
    		        load.invisible();
                	mensaje.setMensaje("alert alert-error", "Error !! \nal Eliminar");
                }

				@Override
                public void onSuccess(Long result)
                {
			        load.invisible();
					mensaje.setMensaje("alert alert-success", "Eliminado\n exitosamente!!!");
        	        flextable.remove(fa);
                }

         });
	        load.invisible();
	    }
	    
	    public void EliminarFormulario(FormularioSalario fa){
	        load.visible();
        	flextable.remove(fa);
            load.invisible();
	    }
}
