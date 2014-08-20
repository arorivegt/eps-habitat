package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;

public class formulario_idiomas extends Composite {

	private Idioma a;
	private Empleados empleado;
	private Long id_idioma = 0L;
	private boolean bandera = true;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    
    private ListBox listNivel;
    private TextBox txtIdioma;
    
	public formulario_idiomas(Idioma a,Empleados e) {

		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "20px");
		
		txtIdioma = new TextBox();
		txtIdioma.setStyleName("gwt-TextBox2");
		txtIdioma.setMaxLength(100);
		absolutePanel.add(txtIdioma, 10, 29);
		txtIdioma.setSize("137px", "11px");
		
		listNivel = new ListBox();
		listNivel.addItem("Avanzado");
		listNivel.addItem("Intermedio");
		listNivel.addItem("Principiante");
		listNivel.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNivel, 188, 29);
		listNivel.setSize("140px", "22px");
		

		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera) {
					loginService.Insertar_Idioma(empleado.id_empleado, listNivel.getItemText(listNivel.getSelectedIndex()), 
							txtIdioma.getText(), new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_idioma = result;
							bandera = false;
                        	Window.alert("Datos Guardados exitosamente!!! "+id_idioma);
                        }
						});
				}else{
					loginService.Actualizar_Idioma(empleado.id_empleado,id_idioma, listNivel.getItemText(listNivel.getSelectedIndex()), 
							txtIdioma.getText(), new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Actualizar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							bandera = false;
                        	Window.alert("Datos Actualizar exitosamente!!! "+id_idioma);
                        }
						});
				}
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 358, 29);
		btnActualizar.setSize("157px", "20px");
		
		
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
		absolutePanel.add(btnEliminar, 527, 29);
		btnEliminar.setSize("157px", "20px");
		
		Label lblNivelAcademico = new Label("Idioma");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Nivel");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 160, 10);
		lblTitulodiploma.setSize("192px", "13px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado,id_idioma);
    }
	
	public void LlenarDatos(Long id, String listNivel, String txtIdioma)
	{
		this.id_idioma = id;
		this.bandera = false;
		this.txtIdioma.setText(txtIdioma);
		boolean bandera = true;
		for(int i=0; i < this.listNivel.getItemCount() && bandera; i++){
			bandera = !this.listNivel.getItemText(i).equals(listNivel);
		    this.listNivel.setSelectedIndex(i);
		}
		
	}

}
