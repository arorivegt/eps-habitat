package org.habitatguate.hgerp.seguridad.client;

import java.util.Date;
import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formulario_historial extends Composite {

	private historiales a;
	private Empleados empleado;
	private boolean bandera = true;
	private Long id_historial = 0L;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    
    private ListBox listTipo ;
    private DateBox dateFecha ;
    private TextArea txtDescripcion ;
    
	public formulario_historial(historiales a,Empleados e) {

		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("534px", "105px");
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					Window.alert("No se a guardado los datos");
				}else{
					EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 378, 83);
		btnEliminar.setSize("157px", "20px");
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 56);
		lblMotivo.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Tipo ");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 173, 10);
		lblLoRecomienda.setSize("103px", "13px");
		
		listTipo = new ListBox();
		listTipo.addItem("permisos");
		listTipo.addItem("ausencias");
		listTipo.addItem("aciertos ");
		listTipo.addItem("llamadas de atención");
		listTipo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipo, 173, 29);
		listTipo.setSize("157px", "22px");
		
		txtDescripcion = new TextArea();
		//txtDescripcion.getElement().setAttribute("maxlength", "1000");
		txtDescripcion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDescripcion, 10, 71);
		txtDescripcion.setSize("317px", "61px");
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407518904795L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 29);
		dateFecha.setSize("123px", "11px");
		
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
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_historial = result;
							bandera = false;
                        	Window.alert("Datos Guardados exitosamente!!! "+id_historial);
                        }
						});
				}else{
					loginService.Actualizar_Historial(empleado.id_empleado,id_historial, dateFecha.getValue(),txtDescripcion.getText(), 
							listTipo.getItemText(listTipo.getSelectedIndex()),new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Actualizar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							bandera = false;
                        	Window.alert("Datos Actualizados exitosamente!!! "+id_historial);
                        }
						});
				}
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 378, 41);
		btnActualizar.setSize("157px", "20px");
	}
	
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado,id_historial);
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
	
}
