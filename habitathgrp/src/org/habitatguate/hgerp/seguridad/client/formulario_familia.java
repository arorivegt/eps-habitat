package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;


public class formulario_familia  extends Composite  {

	public formulario_familia(String pariente) {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "100px");
		
		Label label_3 = new Label("Primer Apellido");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 10, 10);
		label_3.setSize("192px", "13px");
		
		Label label_4 = new Label("Segundo Apellido");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 190, 10);
		label_4.setSize("192px", "13px");
		
		TextBox primer_apellido = new TextBox();
		primer_apellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(primer_apellido, 10, 29);
		primer_apellido.setSize("137px", "11px");
		
		TextBox segundo_apellidp = new TextBox();
		segundo_apellidp.setStyleName("gwt-TextBox2");
		absolutePanel.add(segundo_apellidp, 190, 29);
		segundo_apellidp.setSize("137px", "11px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 10, 54);
		label_6.setSize("157px", "19px");
		
		TextBox primer_nombre = new TextBox();
		primer_nombre.setStylePrimaryName("gwt-TextBox2");
		primer_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(primer_nombre, 10, 68);
		primer_nombre.setSize("137px", "11px");
		
		TextBox segundo_nombre = new TextBox();
		segundo_nombre.setStylePrimaryName("gwt-TextBox2");
		segundo_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(segundo_nombre, 190, 68);
		segundo_nombre.setSize("137px", "11px");
		
		Label label_7 = new Label("2do y Demás Nombres");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 190, 54);
		label_7.setSize("157px", "13px");
		
		Label lblParentesco = new Label("Parentesco");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		TextBox ocupacion = new TextBox();
		ocupacion.setStylePrimaryName("gwt-TextBox2");
		ocupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(ocupacion, 374, 68);
		ocupacion.setSize("137px", "11px");
		
		Label lblOcupacion = new Label("Ocupacion ");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 374, 54);
		lblOcupacion.setSize("163px", "13px");
		
		Button actualizar = new Button("Send");
		actualizar.setText("Actualizar");
		actualizar.setStylePrimaryName("gwt-TextBox2");
		actualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(actualizar, 190, 103);
		actualizar.setSize("157px", "20px");
		
		Button eliminar = new Button("Send");
		eliminar.setText("Eliminar");
		eliminar.setStylePrimaryName("gwt-TextBox2");
		eliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(eliminar, 374, 103);
		eliminar.setSize("157px", "20px");
		
		TextBox edad = new TextBox();
		edad.setStylePrimaryName("gwt-TextBox2");
		edad.setStyleName("gwt-TextBox2");
		absolutePanel.add(edad, 567, 68);
		edad.setSize("137px", "11px");
		
		Label lblEdad = new Label("Edad");
		lblEdad.setStyleName("label");
		absolutePanel.add(lblEdad, 567, 49);
		lblEdad.setSize("76px", "13px");
		
		Button Guardar = new Button("Send");
		Guardar.setText("Guardar");
		Guardar.setStylePrimaryName("gwt-TextBox2");
		Guardar.setStyleName("gwt-TextBox2");
		absolutePanel.add(Guardar, 10, 103);
		Guardar.setSize("157px", "20px");
		
		TextBox parentesco = new TextBox();
		parentesco.setStylePrimaryName("gwt-TextBox2");
		parentesco.setStyleName("gwt-TextBox2");
		parentesco.setEnabled(false);
		absolutePanel.add(parentesco, 373, 29);
		parentesco.setSize("137px", "11px");
		parentesco.setText(pariente);
	}

}
