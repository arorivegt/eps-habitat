package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class EmpleadoItem extends Composite {

    private Loading load ;
	private Button btnEditar ;
    private AbsolutePanel panel;
	private Long id_empleado = 0L;
	private TextBox txtPrimerNombre;
	private TextBox txtSegundoNombre;
	private TextBox txtPrimerApellido;
	private TextBox txtSegundoApellido;
	private EmpleadoLista empleadoLista;
	private BuscadorEmpleados buscadorEmleados;
	
	public EmpleadoItem(BuscadorEmpleados buscadorEmpleado, EmpleadoLista empleadoLista,Long id_emplead, String primer_nombre, String segundo_nombre, 
			String primer_apellido, String segundo_apellido) {
		
		this.id_empleado = id_emplead;
		this.buscadorEmleados = buscadorEmpleado;
		
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		this.setA(empleadoLista);
		panel = new AbsolutePanel();
		panel.setStyleName("gwt-Label-new");
		initWidget(panel);
		panel.setSize("1097px", "20px");
		
		Label lblPrimerNombre = new Label("Primer Nombre");
		lblPrimerNombre.setStyleName("label");
		panel.add(lblPrimerNombre, 10, 0);
		lblPrimerNombre.setSize("192px", "13px");
		
		Label lblSegundoNombre = new Label("Segundo Nombre");
		lblSegundoNombre.setStyleName("label");
		panel.add(lblSegundoNombre, 245, 0);
		lblSegundoNombre.setSize("227px", "34px");
		
		txtSegundoNombre = new TextBox();
		txtSegundoNombre.setEnabled(false);
		txtSegundoNombre.setStyleName("gwt-TextBox2");
		txtSegundoNombre.setMaxLength(100);
		panel.add(txtSegundoNombre, 245, 20);
		txtSegundoNombre.setSize("227px", "34px");
		txtSegundoNombre.setText(segundo_nombre);
		
		txtPrimerApellido = new TextBox();
		txtPrimerApellido.setEnabled(false);
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		txtPrimerApellido.setMaxLength(100);
		panel.add(txtPrimerApellido, 478, 20);
		txtPrimerApellido.setSize("227px", "34px");
		txtPrimerApellido.setText(primer_apellido);
		
		txtPrimerNombre = new TextBox();
		txtPrimerNombre.setEnabled(false);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		txtPrimerNombre.setMaxLength(100);
		panel.add(txtPrimerNombre, 10, 20);
		txtPrimerNombre.setSize("227px", "34px");
		txtPrimerNombre.setText(primer_nombre);

		txtSegundoApellido = new TextBox();
		txtSegundoApellido.setEnabled(false);
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		txtSegundoApellido.setMaxLength(100);
		panel.add(txtSegundoApellido, 713, 20);
		txtSegundoApellido.setSize("227px", "34px");
		txtSegundoApellido.setText(segundo_apellido);
	
		Label lblPrimerApellido = new Label("Primer Apellido");
		lblPrimerApellido.setStyleName("label");
		panel.add(lblPrimerApellido, 478, -1);
		lblPrimerApellido.setSize("192px", "13px");
		
		Label lblSegundoApellido = new Label("Segundo Apellido");
		lblSegundoApellido.setStyleName("label");
		panel.add(lblSegundoApellido, 713, 0);
		lblSegundoApellido.setSize("192px", "13px");
		
		btnEditar = new Button("Send");
		btnEditar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				buscadorEmleados.Empleado_registrado(id_empleado);
			}
		});
		btnEditar.setText("Editar");
		btnEditar.setStylePrimaryName("sendButton");
		btnEditar.setStyleName("sendButton");
		panel.add(btnEditar, 948, 22);
		btnEditar.setSize("205px", "34px");
		
	}
	public EmpleadoLista getA() {
		return empleadoLista;
	}
	public void setA(EmpleadoLista a) {
		this.empleadoLista = a;
	}

}
