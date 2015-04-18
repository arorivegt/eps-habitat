package org.habitatguate.hgerp.seguridad.client.administracion;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;


public class FormularioRol  extends Composite  {

	public Long id_permiso = 0L;
	public Long roll = 0L;
	public Long id_formularioPadre = 0L;
	
	public TextBox txtNombreFormulario ;
	private AbsolutePanel absolutePanel ;
    private Loading load ;
    public TextBox txtFormularioPadre;
    public ListBox listPermiso;
    private Label label;
	public FormularioRol() {

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
		txtNombreFormulario.setSize("348px", "34px");
		
//		txtFormularioPadre = new TextBox();
//		txtFormularioPadre.setEnabled(false);
//		txtFormularioPadre.setStyleName("gwt-TextBox2");
//		txtFormularioPadre.setMaxLength(100);
//		absolutePanel.add(txtFormularioPadre, 198, 29);
//		txtFormularioPadre.setSize("168px", "34px");
		
		listPermiso = new ListBox();
		listPermiso.addItem("RW");
		listPermiso.addItem("R");
		listPermiso.addItem("N");
		listPermiso.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPermiso, 396, 29);
		listPermiso.setSize("117px", "36px");
		
		Label lblN = new Label("Nombre Formulario");
		lblN.setStyleName("label");
		absolutePanel.add(lblN, 20, 10);
		lblN.setSize("157px", "13px");
		
//		Label lblFormularioPadre = new Label("Formulario Padre");
//		lblFormularioPadre.setStyleName("label");
//		absolutePanel.add(lblFormularioPadre, 198, 10);
//		lblFormularioPadre.setSize("192px", "13px");
		
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
		this.txtNombreFormulario.setText(txtNombreFormulario);

		boolean bandera = true;
		for(int i=0; i < this.listPermiso.getItemCount() && bandera; i++){
			bandera = !this.listPermiso.getItemText(i).equals(lisPermiso);
		    this.listPermiso.setSelectedIndex(i);
		}
	}
   

}
