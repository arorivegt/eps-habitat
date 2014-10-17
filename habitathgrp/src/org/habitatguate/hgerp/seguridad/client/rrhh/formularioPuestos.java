package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DateBox;

public class formularioPuestos extends Composite {

	private puestos aa;
	private Empleados empleado;
	private Long id_puesto = 0L;
	private boolean bandera = true;
	private AbsolutePanel absolutePanel;
    
    private DateBox dateFecha;
    private ListBox listActivo;
	private ListBox listPuesto ;
	private ListBox listJornada ;
	private ListBox listHorasTrabajadas;
	private Button btnGuardar;
	private Button btnEliminar;
	private TextArea txtFunciones;
	private TextArea txtMotivoPuesto;
	private Mensaje mensaje; 
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	
	public formularioPuestos(puestos a,Empleados e) {

		mensaje = new Mensaje();
		this.empleado = e;
		this.aa = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		absolutePanel.setSize("1024px", "170px");
		initWidget(absolutePanel);

		listPuesto = new ListBox();
		listPuesto.addItem("nada seleccionado");
		listPuesto.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) 
			{
				long lg;
				for (AuxBDPuesto p : aa.BDpuestos) 
				{
					lg  = Long.valueOf(listPuesto.getValue(listPuesto.getSelectedIndex()));
					if(lg == p.getId_puesto())
					{
						txtFunciones.setText(p.getFunciones());
						break;
					}
			    }
					
			}
		});
		listPuesto.setStyleName("gwt-TextBox2");
		listPuesto.setSize("227px", "34px");
		absolutePanel.add(listPuesto, 10, 29);
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407519035556L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		dateFecha.setSize("227px", "34px");
		absolutePanel.add(dateFecha, 259, 29);
		
		txtMotivoPuesto = new TextArea();
		txtMotivoPuesto.setText("");
		txtMotivoPuesto.setStyleName("gwt-TextBox2");
		txtMotivoPuesto.setSize("227px", "34px");
		absolutePanel.add(txtMotivoPuesto, 514, 29);

		listActivo = new ListBox();
		listActivo.addItem("Si");
		listActivo.addItem("No");
		listActivo.setStyleName("gwt-TextBox2");
		listActivo.setSize("227px", "34px");
		absolutePanel.add(listActivo, 761, 29);
		
		listActivo = new ListBox();
		listActivo.addItem("Si");
		listActivo.addItem("No");
		listActivo.setStyleName("gwt-TextBox2");
		listActivo.setSize("227px", "34px");
		absolutePanel.add(listActivo, 761, 29);
		
		listJornada = new ListBox();
		listJornada.addItem("Diurna","0");
		listJornada.addItem("Nocturna","1");
		listJornada.addItem("Mixta","2");
		listJornada.setStyleName("gwt-TextBox2");
		listJornada.setSize("227px", "34px");
		absolutePanel.add(listJornada, 780, 29);
		

		listHorasTrabajadas = new ListBox();
		listHorasTrabajadas.addItem("0");
		listHorasTrabajadas.addItem("1");
		listHorasTrabajadas.addItem("2");
		listHorasTrabajadas.addItem("3");
		listHorasTrabajadas.addItem("4");
		listHorasTrabajadas.addItem("5");
		listHorasTrabajadas.addItem("6");
		listHorasTrabajadas.addItem("7");
		listHorasTrabajadas.addItem("8");
		listHorasTrabajadas.addItem("9");
		listHorasTrabajadas.addItem("10");
		listHorasTrabajadas.addItem("11");
		listHorasTrabajadas.addItem("12");
		listHorasTrabajadas.addItem("13");
		listHorasTrabajadas.addItem("14");
		listHorasTrabajadas.addItem("15");
		listHorasTrabajadas.addItem("16");
		listHorasTrabajadas.addItem("17");
		listHorasTrabajadas.addItem("18");
		listHorasTrabajadas.addItem("19");
		listHorasTrabajadas.addItem("20");
		listHorasTrabajadas.addItem("21");
		listHorasTrabajadas.addItem("22");
		listHorasTrabajadas.addItem("23");
		listHorasTrabajadas.addItem("24");
		listHorasTrabajadas.setStyleName("gwt-TextBox2");
		listHorasTrabajadas.setSize("227px", "34px");
		absolutePanel.add(listHorasTrabajadas, 800, 29);
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
			
				if(bandera) {					
					loginService.Insertar_Puesto(empleado.id_empleado, dateFecha.getValue(), listPuesto.getValue(listPuesto.getSelectedIndex()), 
							txtFunciones.getText(), txtMotivoPuesto.getText(), listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si"),
							listJornada.getValue(listJornada.getSelectedIndex()),listHorasTrabajadas.getValue(listHorasTrabajadas.getSelectedIndex())
							, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                	mensaje.setMensaje("alert alert-error", 
                			"Error !! \nal Guardar Datos");
                }

						@Override
                public void onSuccess(Long result)
                {
							id_puesto = result;
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                }
						});
				}else{
					loginService.Actualizar_Puesto(empleado.id_empleado,id_puesto, dateFecha.getValue(), listPuesto.getValue(listPuesto.getSelectedIndex()), 
						txtFunciones.getText(), txtMotivoPuesto.getText(), listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si"),
						listJornada.getItemText(listJornada.getSelectedIndex()),listHorasTrabajadas.getItemText(listHorasTrabajadas.getSelectedIndex())
						, new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) 
            {
            	mensaje.setMensaje("alert alert-error", 
            			"Error !! \nal Actualizar Datos");
            }

					@Override
            public void onSuccess(Long result)
            {
						bandera = false;
						mensaje.setMensaje("alert alert-success", 
	                			"Datos Actualizados\n exitosamente!!!");
            }
					});
				}
			}
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		btnGuardar.setSize("227px", "34px");
		absolutePanel.add(btnGuardar, 514, 125);
		
		btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setSize("227px", "34px");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormularioSinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		absolutePanel.add(btnEliminar, 761, 125);
		
		txtFunciones = new TextArea();
		txtFunciones.setReadOnly(true);
		txtFunciones.getElement().setAttribute("maxlength", "500");
		txtFunciones.setStyleName("gwt-TextBox");
		txtFunciones.setSize("428px", "62px");
		absolutePanel.add(txtFunciones, 10, 97);
		
		
		Label lblNivelAcademico = new Label("Puesto");
		lblNivelAcademico.setStyleName("label");
		lblNivelAcademico.setSize("192px", "13px");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		
		Label lblTitulodiploma = new Label("Fecha");
		lblTitulodiploma.setStyleName("label");
		lblTitulodiploma.setSize("192px", "13px");
		absolutePanel.add(lblTitulodiploma, 259, 10);
		
		Label lblParentesco = new Label("Salario");
		lblParentesco.setStyleName("label");
		lblParentesco.setSize("192px", "13px");
		absolutePanel.add(lblParentesco, 514, 10);
		
		Label lblActivo = new Label("Activo");
		lblActivo.setStyleName("label");
		lblActivo.setSize("192px", "13px");
		absolutePanel.add(lblActivo, 761, 10);
		
		Label lblFunciones = new Label("Funciones");
		lblFunciones.setStyleName("label");
		lblFunciones.setSize("192px", "13px");
		absolutePanel.add(lblFunciones, 10, 78);

	    for (AuxBDPuesto p : this.aa.BDpuestos) 
	    {
	    	listPuesto.addItem(p.getNombre_puesto(),""+p.getId_puesto());
	    }
		
		
	}
	private void EliminarFormulario(){
        aa.EliminarFormulario(this,empleado.id_empleado,id_puesto);
    }
	private void EliminarFormularioSinDatos(){
        aa.EliminarFormulario(this);
    }
	public void LlenarDatos(Long id, Long dateFecha,
		     String listActivo,
			 String txtPuesto,
			 String txtFunciones,
			 String txtMotivoPuesto,
			 String listJornada,
			 String listhorasTrabajadas)
	{
		this.listActivo.setVisible(false);
		this.listActivo.setEnabled(false);
		this.id_puesto = id;
		this.bandera = false;
		this.dateFecha.setValue(new Date(dateFecha));
		boolean bandera = true;
		for(int i=0; i < this.listActivo.getItemCount() && bandera; i++){
			bandera = !this.listActivo.getItemText(i).equals(listActivo);
		    this.listActivo.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPuesto.getItemCount() && bandera; i++){
			bandera = !this.listPuesto.getValue(i).equals(txtPuesto);
		    this.listPuesto.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listJornada.getItemCount() && bandera; i++){
			bandera = !this.listJornada.getValue(i).equals(listJornada);
		    this.listJornada.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listHorasTrabajadas.getItemCount() && bandera; i++){
			bandera = !this.listHorasTrabajadas.getItemText(i).equals(listhorasTrabajadas);
		    this.listHorasTrabajadas.setSelectedIndex(i);
		}
		this.txtFunciones.setText(txtFunciones);
		this.txtMotivoPuesto.setText(txtMotivoPuesto);
	}
	
}
