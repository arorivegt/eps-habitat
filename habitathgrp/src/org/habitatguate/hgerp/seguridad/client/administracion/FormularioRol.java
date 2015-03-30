package org.habitatguate.hgerp.seguridad.client.administracion;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;


public class FormularioRol  extends Composite  {

	private Mensaje mensaje; 
	private Formulario rol;
	private Long id_formulario_rol = 0L;
	private boolean bandera = true;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	
	private TextBox txtNombreFormulario ;
	private Button btnActualizar;
	private AbsolutePanel absolutePanel ;
    private Loading load ;
    private TextBox txtFormularioPadre;
    private ListBox listPermiso;
    private Label label;
	public FormularioRol(String pariente, Formulario rol) {

		
		
		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		this.rol = rol;
		
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("787px", "40px");
		
		txtNombreFormulario = new TextBox();
		txtNombreFormulario.setMaxLength(100);
		txtNombreFormulario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreFormulario, 10, 29);
		txtNombreFormulario.setSize("168px", "34px");
		
		btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				if(bandera) {
//					loginService.Insertar_Familiar(empleado.id_empleado, txtPrimer_nombre.getText(), 
//							txtSegundo_nombre.getText(), txtPrimer_apellido.getText(),txtSegundo_apellidp.getText(), 
//							Integer.parseInt(txtEdad.getValue()), txtOcupacion.getText(), txtParentesco.getText(), 
//							new AsyncCallback<Long>(){
//	                            public void onFailure(Throwable caught) 
//	                            {
//	                		        load.invisible();
//	                            	mensaje.setMensaje("alert alert-error", 
//	                            			"Error !! \nal Guardar Datos");
//	                            }
//
//								@Override
//	                            public void onSuccess(Long result)
//	                            {
//							        load.invisible();
//									id_familia = result;
//									bandera = false;
//									mensaje.setMensaje("alert alert-success", 
//		                        			"Datos Guardados\n exitosamente!!!");
//	                            }
//
//	                     });
				}else{
//					loginService.Actualizar_Familiar(empleado.id_empleado,id_familia, txtPrimer_nombre.getText(), 
//							txtSegundo_nombre.getText(), txtPrimer_apellido.getText(),txtSegundo_apellidp.getText(), 
//							Integer.parseInt(txtEdad.getValue()), txtOcupacion.getText(), txtParentesco.getText(), 
//							new AsyncCallback<Long>(){
//	                            public void onFailure(Throwable caught) 
//	                            {
//	                		        load.invisible();
//	                            	mensaje.setMensaje("alert alert-error", 
//	                            			"Error !! \nal Actualizar Datos");
//	                                //Window.alert("Error  al Actualizar Datos"+caught);
//	                            }
//
//								@Override
//	                            public void onSuccess(Long result)
//	                            {
//							        load.invisible();
//									bandera = false;
//									mensaje.setMensaje("alert alert-success", 
//				                			"Datos Actualizados\n exitosamente!!!");
//	                    	//Window.alert("Datos Actualizados exitosamente!!! ");
//	                            }
//
//	                     });
				}

		        load.invisible();
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 534, 31);
		btnActualizar.setSize("117px", "34px");
		
		Label lblN = new Label("Nombre Formulario");
		lblN.setStyleName("label");
		absolutePanel.add(lblN, 10, 10);
		lblN.setSize("157px", "13px");
		
		Label lblFormularioPadre = new Label("Formulario Padre");
		lblFormularioPadre.setStyleName("label");
		absolutePanel.add(lblFormularioPadre, 198, 10);
		lblFormularioPadre.setSize("192px", "13px");
		
		txtFormularioPadre = new TextBox();
		txtFormularioPadre.setStyleName("gwt-TextBox2");
		txtFormularioPadre.setMaxLength(100);
		absolutePanel.add(txtFormularioPadre, 198, 29);
		txtFormularioPadre.setSize("168px", "34px");
		
		listPermiso = new ListBox();
		listPermiso.addItem("RWV");
		listPermiso.addItem("RW");
		listPermiso.addItem("WV");
		listPermiso.addItem("RV");
		listPermiso.addItem("R");
		listPermiso.addItem("V");
		listPermiso.addItem("W");
		listPermiso.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPermiso, 396, 29);
		listPermiso.setSize("117px", "36px");
		
		label = new Label("Permiso");
		label.setStyleName("label");
		absolutePanel.add(label, 396, 10);
		label.setSize("192px", "13px");
		
	}
	
	public void LlenarDatos(Long id,String txtNombreFormulario ,
			String txtFormularioPadre,
			String txtPrimer_nombre,
			String lisPermiso)
	{
		this.id_formulario_rol = id;
		this.bandera = false;
		this.txtNombreFormulario.setText(txtNombreFormulario);
		this.txtFormularioPadre.setText(txtFormularioPadre);

		boolean bandera = true;
		for(int i=0; i < this.listPermiso.getItemCount() && bandera; i++){
			bandera = !this.listPermiso.getValue(i).equals(lisPermiso);
		    this.listPermiso.setSelectedIndex(i);
		}
	}
   

}
