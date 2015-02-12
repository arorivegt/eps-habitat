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

public class Sce_BuzonSolicitudItem extends Composite {

	private Sce_BuzonSolicitudLista a;
	private Long id_Formulario = 0L;
	private Sce_BuzonSolicitud BE;
    private Loading load ;
    private AbsolutePanel absolutePanel;
    private	TextBox txtTelefonoCasaSolicitante;
    private TextBox txtTelefonoTrabajoSolicitante;
    private TextBox txtNombreSolicitante;
    private ListBox listSolucionConstruir;
    private Button btnVer;
    
	public Sce_BuzonSolicitudItem(Sce_BuzonSolicitud b, Sce_BuzonSolicitudLista a, 
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
		
		Label lblNombreSolicitante = new Label("Nombre Solicitante");
		lblNombreSolicitante.setStyleName("label");
		absolutePanel.add(lblNombreSolicitante, 10, 0);
		lblNombreSolicitante.setSize("192px", "13px");
		
		Label lblTelefonoCasa = new Label("Telefono Casa Solicitante");
		lblTelefonoCasa.setStyleName("label");
		absolutePanel.add(lblTelefonoCasa, 345, 0);
		lblTelefonoCasa.setSize("227px", "13px");
		
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
		listSolucionConstruir.addItem("Nueva","1");
		listSolucionConstruir.addItem("Mejoramiento","2");
		listSolucionConstruir.addItem("Adiciones Menores","3");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 791, 20);
		listSolucionConstruir.setSize("125px", "34px");;
		
        Boolean bandera = true;
	    for(int i=0; i < this.listSolucionConstruir.getItemCount() && bandera; i++){
	       bandera = !this.listSolucionConstruir.getValue(i).equals(solucionConstruir);
	       this.listSolucionConstruir.setSelectedIndex(i);
	    } 
	
		Label lblTelefonoTrabajo = new Label("Telefono Trabajo Solicitante");
		lblTelefonoTrabajo.setStyleName("label");
		absolutePanel.add(lblTelefonoTrabajo, 556, 0);
		lblTelefonoTrabajo.setSize("229px", "13px");
		
		Label lblTipoVivienda = new Label("Solucion a Construir");
		lblTipoVivienda.setStyleName("label");
		absolutePanel.add(lblTipoVivienda, 791, 0);
		lblTipoVivienda.setSize("192px", "13px");
		
		btnVer = new Button("Send");
		btnVer.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				BE.cargarFormulario(id_Formulario);
			}
		});
		btnVer.setText("Ver Solicitud");
		btnVer.setStylePrimaryName("sendButton");
		btnVer.setStyleName("sendButton");
		absolutePanel.add(btnVer, 990, 20);
		btnVer.setSize("205px", "34px");
		
	}
	
	public Sce_BuzonSolicitudLista getA() {
		return a;
	}
	
	public void setA(Sce_BuzonSolicitudLista a) {
		this.a = a;
	}

}
