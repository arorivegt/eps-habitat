package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
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

public class FormularioHistorial extends Composite {

	private Historiales a;
	private Empleado empleado;
	private boolean bandera = true;
	private Long id_historial = 0L;
	private Button btnActualizar ;
    private ListBox listTipo ;
    private DateBox dateFecha ;
    private TextArea txtDescripcion ;
	private AbsolutePanel absolutePanel ;
	private Button btnEliminar ;
	private Mensaje mensaje; 
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private Loading load ;
    
    
	public FormularioHistorial(Historiales a,Empleado e) {

		this.empleado = e;
		this.a = a;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		absolutePanel.setSize("763px", "170px");
		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date());
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 29);
		dateFecha.setSize("227px", "34px");
		
		listTipo = new ListBox();
		listTipo.addItem("aciertos ","0");
		listTipo.addItem("llamadas de atención","1");
		listTipo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipo, 259, 29);
		listTipo.setSize("229px", "36px");
		
		btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        load.visible();
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
			
				if(bandera) {
					loginService.Insertar_Historial(empleado.id_empleado, dateFecha.getValue(),txtDescripcion.getText(), 
							listTipo.getValue(listTipo.getSelectedIndex()),new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", "Error !! \nal Guardar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
					        load.invisible();
							id_historial = result;
							bandera = false;
							mensaje.setMensaje("alert alert-success", "Datos Guardados\n exitosamente!!!");
                        }
						});
				}else{
					loginService.Actualizar_Historial(empleado.id_empleado,id_historial, dateFecha.getValue(),txtDescripcion.getText(), 
							listTipo.getValue(listTipo.getSelectedIndex()),new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", "Error !! \nal Actualizar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
					        load.invisible();
							bandera = false;
							mensaje.setMensaje("alert alert-success", "Datos Actualizados\n exitosamente!!!");
                        }
						});
				}
		        load.invisible();
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 541, 93);
		btnActualizar.setSize("227px", "34px");
		
		txtDescripcion = new TextArea();
		//txtDescripcion.getElement().setAttribute("maxlength", "1000");
		txtDescripcion.setStyleName("gwt-TextBox");
		absolutePanel.add(txtDescripcion, 10, 93);
		txtDescripcion.setSize("428px", "61px");
		
		btnEliminar = new Button("Send");
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
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setSize("227px", "34px");
		absolutePanel.add(btnEliminar, 541, 160);
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		lblNivelAcademico.setSize("192px", "13px");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		lblMotivo.setSize("192px", "13px");
		absolutePanel.add(lblMotivo, 10, 74);
		
		Label lblLoRecomienda = new Label("Tipo ");
		lblLoRecomienda.setStyleName("label");
		lblLoRecomienda.setSize("103px", "13px");
		absolutePanel.add(lblLoRecomienda, 259, 10);
		initWidget(absolutePanel);
	}
	
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado,id_historial);
    }
	
	private void EliminarFormularioSinDatos(){
        a.EliminarFormulario(this);
    }
	
	public void LlenarDatos(Long id,String listTipo , Long dateFecha ,
		     				 String txtDescripcion)
	{
		this.id_historial = id;
		this.bandera = false;
		this.dateFecha.setValue(new Date(dateFecha));
		this.txtDescripcion.setText(txtDescripcion);
		
		boolean bandera = true;
		for(int i=0; i < this.listTipo.getItemCount() && bandera; i++){
			bandera = !this.listTipo.getValue(i).equals(listTipo);
		    this.listTipo.setSelectedIndex(i);
		}
	}
	
}
