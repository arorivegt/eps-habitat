package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formularioHistorial extends Composite {

	private historiales a;
	private Empleados empleado;
	private boolean bandera = true;
	private Long id_historial = 0L;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    
    private ListBox listTipo ;
    private DateBox dateFecha ;
    private TextArea txtDescripcion ;
    
	public formularioHistorial(historiales a,Empleados e) {

		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("763px", "170px");
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407518904795L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 29);
		dateFecha.setSize("227px", "34px");
		
		listTipo = new ListBox();
		listTipo.addItem("permisos");
		listTipo.addItem("ausencias");
		listTipo.addItem("aciertos ");
		listTipo.addItem("llamadas de atención");
		listTipo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipo, 259, 29);
		listTipo.setSize("229px", "36px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
			
				if(bandera) {
					loginService.Insertar_Historial(empleado.id_empleado, dateFecha.getValue(),txtDescripcion.getText(), 
							listTipo.getItemText(listTipo.getSelectedIndex()),new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_historial = result;
							bandera = false;
                        	setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        }
						});
				}else{
					loginService.Actualizar_Historial(empleado.id_empleado,id_historial, dateFecha.getValue(),txtDescripcion.getText(), 
							listTipo.getItemText(listTipo.getSelectedIndex()),new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	setMensaje("alert alert-error", 
                        			"Error !! \nal Actualizar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							bandera = false;
		                	setMensaje("alert alert-success", 
		                			"Datos Actualizados\n exitosamente!!!");
                        }
						});
				}
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
		
		Button btnEliminar = new Button("Send");
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
		absolutePanel.add(btnEliminar, 541, 160);
		btnEliminar.setSize("227px", "34px");
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 74);
		lblMotivo.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Tipo ");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 259, 10);
		lblLoRecomienda.setSize("103px", "13px");
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
		boolean bandera = true;
		for(int i=0; i < this.listTipo.getItemCount() && bandera; i++){
			bandera = !this.listTipo.getItemText(i).equals(listTipo);
		    this.listTipo.setSelectedIndex(i);
		}
		this.dateFecha.setValue(new Date(dateFecha));
		this.txtDescripcion.setText(txtDescripcion);
	}
    public void setMensaje(String estilo, String mensaje){
        final DialogBox Registro2 = new DialogBox();
        final HTML serverResponseLabel = new HTML();
        final Button close= new Button("x");
        Mensaje inicio = new Mensaje();
        
        Registro2.setStyleName(estilo);
        inicio.mensajeEntrada(mensaje);
        inicio.mensajeEstilo(estilo);
        close.addStyleName("close");
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(inicio);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(close);
        Registro2 .setWidget(dialogVPanel);
        Registro2 .setModal(true);
        Registro2 .setGlassEnabled(true);
        Registro2 .setAnimationEnabled(true);
        Registro2 .center();
        Registro2 .show();
        close.setFocus(true);
    
        close.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            Registro2.hide();
        }
    });
    }
	
}
