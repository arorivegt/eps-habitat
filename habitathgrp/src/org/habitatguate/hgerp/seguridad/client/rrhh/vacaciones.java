package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVacaciones;
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
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;

public class vacaciones extends Composite  {

	 private Mensaje mensaje; 
	 private FlexTable flextable;
	 private Empleados empleado;
	 private VerticalPanel panel = new VerticalPanel();
	 List<AuxVacaciones> permiso = new ArrayList<AuxVacaciones> ();
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	 private final Grid grid = new Grid(1, 4);
	 private DateBox dateFecha1;
	 private DateBox dateFecha2;
	 private final ListBox listTipoPermiso = new ListBox();
	 private final Button btnBuscar = new Button("Agregar");
	    private Loading load ;
		
	    public vacaciones(Empleados e) {

        	load = new Loading();
            load.Mostrar();
            load.invisible();
			mensaje = new Mensaje();
			this.empleado = e;
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        initWidget(panel);
	        panel.setSize("761px", "85px");
	        
	        panel.add(grid);
	        
	        dateFecha1 = new DateBox();
	        grid.setWidget(0, 0, dateFecha1);
			dateFecha1.getTextBox().setReadOnly(true);
	        dateFecha1.setSize("227px", "34px");
	        dateFecha1.setValue(new Date());
	        dateFecha1.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
	        dateFecha1.getDatePicker().setYearArrowsVisible(true);
	        dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
	        dateFecha1.getDatePicker().setVisibleYearCount(100);
	        dateFecha1.setStyleName("gwt-TextBox2");
	        
	        dateFecha2 =  new DateBox();;
	        grid.setWidget(0, 1, dateFecha2);
			dateFecha2.getTextBox().setReadOnly(true);
	        dateFecha2.setValue(new Date());
	        dateFecha2.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
	        dateFecha2.getDatePicker().setYearArrowsVisible(true);
	        dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
	        dateFecha2.getDatePicker().setVisibleYearCount(100);
	        dateFecha2.setSize("227px", "34px");
	        dateFecha2.setStyleName("gwt-TextBox2");
	        
	        grid.setWidget(0, 2, listTipoPermiso);
	        listTipoPermiso.setSize("229px", "36px");
			listTipoPermiso.addItem("Vacaciones con goce salaria","0");
			listTipoPermiso.addItem("Vacaciones sin goce salaria","1");
			listTipoPermiso.addItem("Permiso con goce salarial","2");
			listTipoPermiso.addItem("Permiso sin goce salarial","3");
			listTipoPermiso.addItem("Suspension con goce salarial","4");
			listTipoPermiso.addItem("Suspension sin goce salarial","5");
			listTipoPermiso.addItem("Ausencia con goce salarial","6");
			listTipoPermiso.addItem("Ausencia sin goce salarial","7");
	        listTipoPermiso.setStyleName("gwt-TextBox2");
	        btnBuscar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {

	                load.visible();
	        		loginService.getPermisos(empleado.id_empleado, new AsyncCallback<List<AuxVacaciones>>(){
	        			
	                    public void onFailure(Throwable caught) 
	                    {
	                    }

	    				@Override
	                    public void onSuccess(List<AuxVacaciones> result)
	                    {
	    					System.out.print(result.isEmpty());
	    					permiso  = result;
	                    }

	    	         });
	        		try{

		        		List<AuxVacaciones> vacacio = new ArrayList<AuxVacaciones> ();
	        		for(AuxVacaciones h: permiso)
	        		{
	        			Date aux = new Date(h.getFecha1());
	        			Date aux2 = new Date(h.getFecha2());
	        			
	        			if(aux.after(dateFecha1.getValue())
	        			&& aux.before(dateFecha2.getValue())
	        			&& h.getTipoPermisos().equals(listTipoPermiso.getValue(listTipoPermiso.getSelectedIndex()))
	        			)
	        			{
	        				vacacio.add(h);
	        			}
	        			else if(aux2.after(dateFecha1.getValue())
	        			&& aux2.before(dateFecha2.getValue())
	        			&& h.getTipoPermisos().equals(listTipoPermiso.getValue(listTipoPermiso.getSelectedIndex()))
	        			)
	        			{
	        				vacacio.add(h);
	        				
	        			}
	    	        			
	        		}
	        		//agregarFormularios
	        		if(!vacacio.isEmpty()){
	        			agregarFormulario_lleno(vacacio);
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
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioVacaciones(this,empleado));
	    }
	    
	    public void agregarFormulario_lleno(List<AuxVacaciones> results){
	        load.visible();
	    	flextable.clear();
	    	if (!results.isEmpty()) {
	    		permiso = results;
			    for ( AuxVacaciones n2 : results) {
			    	formularioVacaciones fa = new  formularioVacaciones(this,empleado);
			    	fa.LlenarDatos(n2.getId_vacaciones(),n2.getDescripcion(),n2.getFecha1(),n2.getFecha2(),
			    				   n2.getTipoPermisos());
			        flextable.setWidget(flextable.getRowCount(), 0,fa );
			    }
	    	}	    
	        load.invisible();
	    }
	    
	    public void EliminarFormulario(final formularioVacaciones fa, final Long id_empledo, final Long id){

	        load.visible();
			loginService.Eliminar_Vacaciones(id_empledo, id, new AsyncCallback<Long>(){
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
	    
	    public void EliminarFormulario(formularioVacaciones fa){
	        load.visible();
	        flextable.remove(fa);
	        load.invisible();
	    }
	    

}
