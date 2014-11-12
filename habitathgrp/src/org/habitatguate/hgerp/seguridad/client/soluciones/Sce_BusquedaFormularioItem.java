package org.habitatguate.hgerp.seguridad.client.soluciones;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Sce_BusquedaFormularioItem extends Composite {

	private Sce_BusquedaFormularioLista a;
	private Long id_Formulario = 0L;
	private Sce_BusquedaFormulario BE;
    private Loading load ;
    private AbsolutePanel absolutePanel;
    private	TextBox txtTelefonoCasaSolicitante;
    private TextBox txtTelefonoTrabajoSolicitante;
    private TextBox txtNombreSolicitante;
    private ListBox listSolucionConstruir;
    private Button button_2;
    
	public Sce_BusquedaFormularioItem(Sce_BusquedaFormulario b, Sce_BusquedaFormularioLista a, 
			Long idFormulario, String nombreSolicitante, int telefonoCasaSolicitante, 
			int telefonoTrabajoSolicitante, String solucionConstruir) {
		
		this.id_Formulario = idFormulario;
		this.BE = b;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.setA(a);
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1150px", "20px");
		
		Label lblPrimerNombre = new Label("Nombre Solicitante");
		lblPrimerNombre.setStyleName("label");
		absolutePanel.add(lblPrimerNombre, 10, 0);
		lblPrimerNombre.setSize("192px", "13px");
		
		Label lblSegundoNombre = new Label("Telefono Casa Solicitante");
		lblSegundoNombre.setStyleName("label");
		absolutePanel.add(lblSegundoNombre, 345, 0);
		lblSegundoNombre.setSize("227px", "13px");
		
		txtTelefonoCasaSolicitante = new TextBox();
		txtTelefonoCasaSolicitante.setEnabled(false);
		txtTelefonoCasaSolicitante.setStyleName("gwt-TextBox2");
		txtTelefonoCasaSolicitante.setMaxLength(100);
		absolutePanel.add(txtTelefonoCasaSolicitante, 345, 20);
		txtTelefonoCasaSolicitante.setSize("181px", "34px");
		String valueTelefonoCasaSolicitante = ""+telefonoCasaSolicitante;
		txtTelefonoCasaSolicitante.setText(valueTelefonoCasaSolicitante);
		
		txtTelefonoTrabajoSolicitante = new TextBox();
		txtTelefonoTrabajoSolicitante.setEnabled(false);
		txtTelefonoTrabajoSolicitante.setStyleName("gwt-TextBox2");
		txtTelefonoTrabajoSolicitante.setMaxLength(100);
		absolutePanel.add(txtTelefonoTrabajoSolicitante, 556, 20);
		txtTelefonoTrabajoSolicitante.setSize("203px", "34px");
		String valueTelefonoTrabajoSolicitante = ""+telefonoTrabajoSolicitante;
		txtTelefonoTrabajoSolicitante.setText(valueTelefonoTrabajoSolicitante);
		
		txtNombreSolicitante = new TextBox();
		txtNombreSolicitante.setEnabled(false);
		txtNombreSolicitante.setStyleName("gwt-TextBox2");
		txtNombreSolicitante.setMaxLength(100);
		absolutePanel.add(txtNombreSolicitante, 10, 20);
		txtNombreSolicitante.setSize("303px", "34px");
		txtNombreSolicitante.setText(nombreSolicitante);

		listSolucionConstruir = new ListBox();
		listSolucionConstruir.setEnabled(false);
		listSolucionConstruir.addItem("-","-1");
		listSolucionConstruir.addItem("Tipo I","1");
		listSolucionConstruir.addItem("Tipo II","2");
		listSolucionConstruir.addItem("Tipo III","3");
		listSolucionConstruir.addItem("Tipo IV","4");
		listSolucionConstruir.addItem("Tipo V","5");
		listSolucionConstruir.addItem("Tipo VI","6");
		listSolucionConstruir.addItem("Tipo VII","7");
		listSolucionConstruir.addItem("Tipo VIII","8");
		listSolucionConstruir.addItem("Tipo IX","9");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 791, 20);
		listSolucionConstruir.setSize("125px", "34px");;
		
        Boolean bandera = true;
	    for(int i=0; i < this.listSolucionConstruir.getItemCount() && bandera; i++){
	       bandera = !this.listSolucionConstruir.getValue(i).equals(solucionConstruir);
	       this.listSolucionConstruir.setSelectedIndex(i);
	    } 
	
		Label lblPrimerApellido = new Label("Telefono Trabajo Solicitante");
		lblPrimerApellido.setStyleName("label");
		absolutePanel.add(lblPrimerApellido, 556, 0);
		lblPrimerApellido.setSize("229px", "13px");
		
		Label lblSegundoApellido = new Label("Tipo de Vivienda");
		lblSegundoApellido.setStyleName("label");
		absolutePanel.add(lblSegundoApellido, 791, 0);
		lblSegundoApellido.setSize("192px", "13px");
		
		button_2 = new Button("Send");
		button_2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				BE.cargarFormulario(id_Formulario);
			}
		});
		button_2.setText("Ver Solicitud");
		button_2.setStylePrimaryName("sendButton");
		button_2.setStyleName("sendButton");
		absolutePanel.add(button_2, 991, 22);
		button_2.setSize("205px", "34px");
		
	}
	
	public Sce_BusquedaFormularioLista getA() {
		return a;
	}
	
	public void setA(Sce_BusquedaFormularioLista a) {
		this.a = a;
	}

}
