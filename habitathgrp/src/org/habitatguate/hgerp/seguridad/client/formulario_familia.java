package org.habitatguate.hgerp.seguridad.client;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;


public class formulario_familia  extends Composite  {

	private familiares a;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	private Long id_familia = 0L;
	private Empleados empleado;
	
	public formulario_familia(String pariente, familiares a,Empleados e) {

		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "100px");
		
		Label label_3 = new Label("Primer Apellido");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 10, 10);
		label_3.setSize("157px", "13px");
		
		Label label_4 = new Label("Segundo Apellido");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 190, 10);
		label_4.setSize("192px", "13px");
		
		final TextBox txtPrimer_apellido = new TextBox();
		txtPrimer_apellido.setMaxLength(100);
		txtPrimer_apellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimer_apellido, 10, 29);
		txtPrimer_apellido.setSize("137px", "11px");
		
		final TextBox txtSegundo_apellidp = new TextBox();
		txtSegundo_apellidp.setMaxLength(100);
		txtSegundo_apellidp.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundo_apellidp, 190, 29);
		txtSegundo_apellidp.setSize("137px", "11px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 10, 54);
		label_6.setSize("157px", "19px");
		
		final TextBox txtPrimer_nombre = new TextBox();
		txtPrimer_nombre.setMaxLength(100);
		txtPrimer_nombre.setStylePrimaryName("gwt-TextBox2");
		txtPrimer_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimer_nombre, 10, 68);
		txtPrimer_nombre.setSize("137px", "11px");
		
		final TextBox txtSegundo_nombre = new TextBox();
		txtSegundo_nombre.setMaxLength(100);
		txtSegundo_nombre.setStylePrimaryName("gwt-TextBox2");
		txtSegundo_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundo_nombre, 190, 68);
		txtSegundo_nombre.setSize("137px", "11px");
		
		Label label_7 = new Label("2do y Demás Nombres");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 190, 54);
		label_7.setSize("157px", "13px");
		
		Label lblParentesco = new Label("Parentesco");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		final TextBox txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(100);
		txtOcupacion.setStylePrimaryName("gwt-TextBox2");
		txtOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOcupacion, 374, 68);
		txtOcupacion.setSize("137px", "11px");
		
		Label lblOcupacion = new Label("Ocupacion ");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 374, 54);
		lblOcupacion.setSize("163px", "13px");
		
		
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormulario();
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 286, 110);
		btnEliminar.setSize("157px", "20px");
		
		Label lblEdad = new Label("Edad");
		lblEdad.setStyleName("label");
		absolutePanel.add(lblEdad, 567, 49);
		lblEdad.setSize("76px", "13px");
		
		final TextBox txtParentesco = new TextBox();
		txtParentesco.setStylePrimaryName("gwt-TextBox2");
		txtParentesco.setStyleName("gwt-TextBox2");
		txtParentesco.setEnabled(false);
		absolutePanel.add(txtParentesco, 373, 29);
		txtParentesco.setSize("137px", "11px");
		txtParentesco.setText(pariente);

		final TextBox txtEdad = new TextBox();
		txtEdad.setText("0");
		txtEdad.setStylePrimaryName("gwt-TextBox2");
		txtEdad.setStyleName("gwt-TextBox2");
		txtEdad.setMaxLength(100);
		absolutePanel.add(txtEdad, 564, 68);
		txtEdad.setSize("137px", "11px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(id_familia == 0) {
					loginService.Insertar_Familiar(empleado.id_empleado, txtPrimer_nombre.getText(), 
							txtSegundo_nombre.getText(), txtPrimer_apellido.getText(),txtSegundo_apellidp.getText(), 
							Integer.parseInt(txtEdad.getValue()), txtOcupacion.getText(), txtParentesco.getText(), 
							new AsyncCallback<Long>(){
	                            public void onFailure(Throwable caught) 
	                            {
	                                Window.alert("Error  al Guardar Datos"+caught);
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {
									id_familia = result;
	                            	Window.alert("Datos Guardados exitosamente!!! "+id_familia);
	                            }

	                     });
				}else{
					//actualizacion
				}
					
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 102, 110);
		btnActualizar.setSize("157px", "20px");
		
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this);
    }

}
