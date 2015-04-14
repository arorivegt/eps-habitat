package org.habitatguate.hgerp.seguridad.client.administracion;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;


public class FormularioRol  extends Composite  {

	private Mensaje mensaje; 
	private Long id_permiso = 0L;
	private Long roll = 0L;
	private Long id_formularioPadre = 0L;
	private boolean bandera = true;
    private final AdministracionServiceAsync loginService = GWT.create(AdministracionService.class);
	
	private TextBox txtNombreFormulario ;
	private AbsolutePanel absolutePanel ;
    private Loading load ;
    private TextBox txtFormularioPadre;
    private ListBox listPermiso;
    private Label label;
	public FormularioRol() {

		
		
		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("511px", "40px");
		
		txtNombreFormulario = new TextBox();
		txtNombreFormulario.setEnabled(false);
		txtNombreFormulario.setMaxLength(100);
		txtNombreFormulario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreFormulario, 20, 31);
		txtNombreFormulario.setSize("168px", "34px");
		
		txtFormularioPadre = new TextBox();
		txtFormularioPadre.setEnabled(false);
		txtFormularioPadre.setStyleName("gwt-TextBox2");
		txtFormularioPadre.setMaxLength(100);
		absolutePanel.add(txtFormularioPadre, 198, 29);
		txtFormularioPadre.setSize("168px", "34px");
		
		listPermiso = new ListBox();
		listPermiso.addItem("RW");
		listPermiso.addItem("R");
		listPermiso.addItem("W");
		listPermiso.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPermiso, 396, 29);
		listPermiso.setSize("117px", "36px");
		
		Label lblN = new Label("Nombre Formulario");
		lblN.setStyleName("label");
		absolutePanel.add(lblN, 20, 10);
		lblN.setSize("157px", "13px");
		
		Label lblFormularioPadre = new Label("Formulario Padre");
		lblFormularioPadre.setStyleName("label");
		absolutePanel.add(lblFormularioPadre, 198, 10);
		lblFormularioPadre.setSize("192px", "13px");
		
		label = new Label("Permiso");
		label.setStyleName("label");
		absolutePanel.add(label, 396, 10);
		label.setSize("192px", "13px");
		
	}
	
	public void LlenarDatos(Long id,
			Long rol,
			String txtNombreFormulario ,
			Long id_formularioPadre,
			String lisPermiso)
	{
		this.id_permiso = id;
		this.roll = rol;
		this.id_formularioPadre = id_formularioPadre;
		this.bandera = false;
		this.txtNombreFormulario.setText(txtNombreFormulario);

		boolean bandera = true;
		for(int i=0; i < this.listPermiso.getItemCount() && bandera; i++){
			bandera = !this.listPermiso.getValue(i).equals(lisPermiso);
		    this.listPermiso.setSelectedIndex(i);
		}
	}
   

}
