package org.habitatguate.hgerp.seguridad.client;

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
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class formulario_puestos extends Composite {

	private puestos a;
	private Long id_puesto = 0L;
	private Empleados empleado;
	private boolean bandera = true;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	public formulario_puestos(puestos a,Empleados e) {

		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "130px");
		
		Label lblNivelAcademico = new Label("Puesto");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Fecha");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 190, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Salario");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormulario();
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 563, 114);
		btnEliminar.setSize("157px", "20px");
		
		final ListBox listActivo = new ListBox();
		listActivo.addItem("Si");
		listActivo.addItem("No");
		listActivo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listActivo, 551, 29);
		listActivo.setSize("157px", "19px");
		
		Label lblActivo = new Label("Activo");
		lblActivo.setStyleName("label");
		absolutePanel.add(lblActivo, 550, 10);
		lblActivo.setSize("192px", "13px");
		
		final DateBox dateFecha = new DateBox();
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 190, 29);
		dateFecha.setSize("137px", "11px");
		
		final TextBox txtPuesto = new TextBox();
		txtPuesto.setStyleName("gwt-TextBox2");
		txtPuesto.setMaxLength(100);
		absolutePanel.add(txtPuesto, 10, 29);
		txtPuesto.setSize("137px", "11px");
		
		final TextArea txtFunciones = new TextArea();
		txtFunciones.getElement().setAttribute("maxlength", "500");
		txtFunciones.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtFunciones, 10, 77);
		txtFunciones.setSize("318px", "61px");
		
		Label lblFunciones = new Label("Funciones");
		lblFunciones.setStyleName("label");
		absolutePanel.add(lblFunciones, 10, 58);
		lblFunciones.setSize("192px", "13px");
		
		final TextBox txtSalario = new TextBox();
		txtSalario.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalario.getText().equals("")) {txtSalario.setText("0");}
				else if(txtSalario.getText().equals(null)) {txtSalario.setText("0");}
				else{
					try{
						Float.parseFloat(txtSalario.getText());
					}catch(Exception e){
						Window.alert("Salario no valido");
						txtSalario.setText("0.0");
					}
				}
			}
		});
		txtSalario.setText("0.0");
		txtSalario.setStyleName("gwt-TextBox2");
		txtSalario.setMaxLength(100);
		absolutePanel.add(txtSalario, 374, 29);
		txtSalario.setSize("137px", "11px");

		Button btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if(bandera) {					
					loginService.Insertar_Puesto(empleado.id_empleado, dateFecha.getValue(), txtPuesto.getText(), 
							txtFunciones.getText(), Float.parseFloat(txtSalario.getText()), listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si")
							, new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_puesto = result;
							bandera = false;
                        	Window.alert("Datos Guardados exitosamente!!! "+id_puesto);
                        }
						});
				}else{
					loginService.Actualizar_Puesto(empleado.id_empleado,id_puesto, dateFecha.getValue(), txtPuesto.getText(), 
						txtFunciones.getText(), Float.parseFloat(txtSalario.getText()), listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si")
						, new AsyncCallback<Long>(){
                    public void onFailure(Throwable caught) 
                    {
                        Window.alert("Error  al Actualizar Datos"+caught);
                    }

					@Override
                    public void onSuccess(Long result)
                    {
						bandera = false;
                    	Window.alert("Datos Actualizados exitosamente!!! "+id_puesto);
                    }
					});
				}
			}
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("gwt-TextBox2");
		btnGuardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnGuardar, 379, 114);
		btnGuardar.setSize("157px", "20px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado,id_puesto);
    }
}
