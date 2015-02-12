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
import com.google.gwt.user.client.ui.SimpleCheckBox;

public class Sce_BuzonBitacoraItem extends Composite {

	private Sce_BuzonBitacoraLista a;
	private Long id_Formulario = 0L;
	private Sce_BuzonBitacora BE;
    private Loading load ;
    private AbsolutePanel absolutePanel;
    private TextBox txtNombreSolicitante;
    private ListBox listSolucionConstruir;
    private Button btnVer;
    private Label lblPrimeraSupervision;
    private SimpleCheckBox checkPrimeraSupervision;
    private SimpleCheckBox checkSegundaSupervision;
    private SimpleCheckBox checkTerceraSupervision;
    private SimpleCheckBox checkCuartaSupervision;
    
	public Sce_BuzonBitacoraItem(Sce_BuzonBitacora b, Sce_BuzonBitacoraLista a, 
			Long idFormulario, String nombreSolicitante, String solucionConstruir,
			Boolean primeraSupervision, Boolean segundaSupervision, Boolean terceraSupervision, Boolean cuartaSupervision) {
		
		this.id_Formulario = idFormulario;
		this.BE = b;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.setA(a);
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1500px", "20px");
		
		Label lblNombreSolicitante = new Label("Nombre Solicitante");
		lblNombreSolicitante.setStyleName("label");
		absolutePanel.add(lblNombreSolicitante, 10, 0);
		lblNombreSolicitante.setSize("192px", "13px");
		
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
		absolutePanel.add(listSolucionConstruir, 350, 22);
		listSolucionConstruir.setSize("125px", "34px");;
		
        Boolean bandera = true;
	    for(int i=0; i < this.listSolucionConstruir.getItemCount() && bandera; i++){
	       bandera = !this.listSolucionConstruir.getValue(i).equals(solucionConstruir);
	       this.listSolucionConstruir.setSelectedIndex(i);
	    }
		
		Label lblTipoVivienda = new Label("Solucion a Construir");
		lblTipoVivienda.setStyleName("label");
		absolutePanel.add(lblTipoVivienda, 350, 0);
		lblTipoVivienda.setSize("153px", "13px");
		
		btnVer = new Button("Send");
		btnVer.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				BE.cargarFormulario(id_Formulario);
			}
		});
		btnVer.setText("Verificar Supervision");
		btnVer.setStylePrimaryName("sendButton");
		btnVer.setStyleName("sendButton");
		absolutePanel.add(btnVer, 1287, 20);
		btnVer.setSize("253px", "34px");
		
		lblPrimeraSupervision = new Label("Primera Supervision");
		lblPrimeraSupervision.setStyleName("label");
		absolutePanel.add(lblPrimeraSupervision, 509, 0);
		lblPrimeraSupervision.setSize("153px", "13px");
		
		checkPrimeraSupervision = new SimpleCheckBox();
		checkPrimeraSupervision.setEnabled(false);
		absolutePanel.add(checkPrimeraSupervision, 561, 20);
		checkPrimeraSupervision.setValue(primeraSupervision);
		
		Label lblSegundaSupervision = new Label("Segunda Supervision");
		lblSegundaSupervision.setStyleName("label");
		absolutePanel.add(lblSegundaSupervision, 687, 0);
		lblSegundaSupervision.setSize("153px", "13px");
		
		checkSegundaSupervision = new SimpleCheckBox();
		checkSegundaSupervision.setEnabled(false);
		absolutePanel.add(checkSegundaSupervision, 745, 20);
		checkSegundaSupervision.setValue(segundaSupervision);
		
		Label lblTerceraSupervision = new Label("Tercera Supervision");
		lblTerceraSupervision.setStyleName("label");
		absolutePanel.add(lblTerceraSupervision, 875, 0);
		lblTerceraSupervision.setSize("153px", "13px");
		
		checkTerceraSupervision = new SimpleCheckBox();
		checkTerceraSupervision.setEnabled(false);
		absolutePanel.add(checkTerceraSupervision, 936, 20);
		checkTerceraSupervision.setSize("24px", "24px");
		checkTerceraSupervision.setValue(terceraSupervision);
		
		Label lblCuartaSupervision = new Label("Cuarta Supervision");
		lblCuartaSupervision.setStyleName("label");
		absolutePanel.add(lblCuartaSupervision, 1060, 0);
		lblCuartaSupervision.setSize("153px", "13px");
		
		checkCuartaSupervision = new SimpleCheckBox();
		checkCuartaSupervision.setEnabled(false);
		absolutePanel.add(checkCuartaSupervision, 1125, 20);
		checkCuartaSupervision.setValue(cuartaSupervision);
		
	}
	
	public Sce_BuzonBitacoraLista getA() {
		return a;
	}
	
	public void setA(Sce_BuzonBitacoraLista a) {
		this.a = a;
	}
}
